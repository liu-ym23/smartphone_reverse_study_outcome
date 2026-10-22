package com.ss.ttvideoengine.source.strategy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.WeakHandler;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SmartUrlFetcher implements WeakHandler.IHandler {
    public static final int CACHE_TYPE_HINT_CACHE = 1;
    public static final int CACHE_TYPE_NONE = 0;
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_ERROR = 2;
    private static final String TAG = "CodecStrategy_SmartUrlFetcher";
    private final Callback mCallback;
    private volatile boolean mCanceled;
    private final Handler mH;
    private final TTVNetClient mHttpClient;
    private RequestParams mRequestParams;

    public interface Callback {
        void onComplete(RequestParams r1, int r2, Result r3);

        void onError(RequestParams r1, Error r2);
    }

    public static class RequestParams {
        public String cacheKey;
        public String codec;
        public String definition;
        public String playUrl;
        public String videoId;

        public RequestParams() {
        }

        public String toString() {
            return "RequestParams{videoId='" + this.videoId + "', playUrl='" + this.playUrl + "', cacheKey='" + this.cacheKey + "', codec='" + this.codec + "', definition='" + this.definition + "'}";
        }
    }

    public static class Result {
        public static final int DataStoreStatusHasEncodeStream = 3;
        public static final int DataStoreStatusHasOriginalStream = 2;
        public static final int DataStoreStatusNotExist = 1;
        public static final int DataStoreStatusUndefined = 0;
        public static final int StreamTypeFallbackEncodeStream = 3;
        public static final int StreamTypeOriginalStream = 1;
        public static final int StreamTypeStrategyEncodeStream = 2;
        public static final int StreamTypeUndefined = 0;
        public final int dataStoreStatus;
        public final Error error;
        public final JSONObject jsonResult;
        public final String originalPlayUrl;
        public final int streamType;
        public final IVideoModel videoModel;

        private static boolean isStreamTypeValid(int r1) {
            if (r1 != 2) goto L5;
        L8:
            return true;
        L5:
            if (r1 == 3) goto L8;
            return false;
        }

        public boolean isEncodeStream() {
            IVideoModel r0 = this.videoModel;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.getVideoRefStr(2) == null) goto L15;
            Resolution r1 = CodecStrategy.SmartUrlVod.findTargetResolution(this.videoModel);
            VideoInfo r2 = this.videoModel.getVideoInfo(r1, false);
            if (r2 == null) goto L16;
            String r3 = r2.getValueStr(0);
            String r4 = r2.getValueStr(17);
            if (TextUtils.isEmpty(r3) == true) goto L11;
        L12:
            return true;
        L11:
            if (TextUtils.isEmpty(r4) == false) goto L12;
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        public String toString() {
            return "Result{dataStoreStatus=" + this.dataStoreStatus + ", streamType=" + this.streamType + ", originalPlayUrl='" + this.originalPlayUrl + "', videoModel=" + this.videoModel + ", jsonResult=" + this.jsonResult + ", error=" + this.error + '}';
        }

        public static /* synthetic */ Result access$200(JSONObject r0) {
            return parseResult(r0);
        }

        private static Result parseResult(JSONObject r13) {
            JSONObject r0 = r13.optJSONObject("Result");
            if (r0 == null) goto L5;
            int r2 = r0.optInt("DataStoreStatus");
            int r10 = r0.optInt("StreamType");
            String r11 = r0.optString("OriginalPlayUrl");
            JSONObject r1 = r0.optJSONObject("PlayInfoModel");
            if (r1 == null) goto L17;
            if (isStreamTypeValid(r10) == false) goto L17;
            VideoModel r7 = new VideoModel();     // Catch: Throwable -> L13
            r7.extractFields(r1);     // Catch: Throwable -> L13
            return new Result(r2, r10, r11, r7, r13, null);
        L13:
            th = move-exception;
            return new Result(r2, r10, r11, null, r13, new Error(Error.FetchingSmartUrlInfo, Error.VideoModelExtractError, "video model extract failed: " + th));
        L17:
            return new Result(r2, r10, r11, null, r13, null);
        L5:
            return new Result(r13, new Error(Error.FetchingSmartUrlInfo, Error.ParseJsonError, "Result is null"));
        }

        public Result(JSONObject r2, Error r3) {
            this.dataStoreStatus = -1;
            this.streamType = -1;
            this.originalPlayUrl = null;
            this.videoModel = null;
            this.jsonResult = r2;
            this.error = r3;
        }

        public Result(int r1, int r2, String r3, IVideoModel r4, JSONObject r5, Error r6) {
            this.dataStoreStatus = r1;
            this.streamType = r2;
            this.originalPlayUrl = r3;
            this.videoModel = r4;
            this.jsonResult = r5;
            this.error = r6;
        }
    }

    public static class SmartUrlCache {
        public static final String TAG = "CodecStrategy_SmartUrlCache";
        private static final Map<String, CacheHolder> sCacheMap = null;

        public static class CacheHolder {
            private final long expiredMS;
            private final Result result;

            public static /* synthetic */ long access$400(CacheHolder r2) {
                return r2.expiredMS;
            }

            public static /* synthetic */ Result access$500(CacheHolder r0) {
                return r0.result;
            }

            public CacheHolder(Result r1, long r2) {
                this.result = r1;
                this.expiredMS = r2;
            }
        }

        public SmartUrlCache() {
        }

        static {
            sCacheMap = new HashMap();
        }

        public static void clear() {
            if (TTVideoEngineLog.d() == false) goto L5;
            TTVideoEngineLog.d(TAG, "clear");
        L5:
            sCacheMap.clear();
        }

        private static Result find(String r6) {
            CacheHolder r7 = sCacheMap.get(r6);
            if (r7 != null) goto L6;
            return null;
        L6:
            if (CacheHolder.access$400(r7) != (-1)) goto L10;
            return CacheHolder.access$500(r7);
        L10:
            if (CacheHolder.access$400(r7) < SystemClock.uptimeMillis()) goto L12;
            return null;
        L12:
            return CacheHolder.access$500(r7);
        }

        public static Result get(String r3) {
            Result r0 = find(r3);
            TTVideoEngineLog.d(TAG, "get " + r3 + " " + r0);
            return r0;
        }

        public static String key(RequestParams r1) {
            if (TextUtils.isEmpty(r1.cacheKey) == true) goto L7;
            return r1.cacheKey;
        L7:
            return r1.playUrl;
        }

        public static void remove(String r2) {
            if (TTVideoEngineLog.d() == false) goto L5;
            TTVideoEngineLog.d(TAG, "remove " + r2);
        L5:
            sCacheMap.remove(r2);
        }

        public static void put(String r4, Result r5) {
            if (TTVideoEngineLog.d() == false) goto L5;
            TTVideoEngineLog.d(TAG, "put " + r4 + " " + r5);
        L5:
            sCacheMap.put(r4, new CacheHolder(r5, -1));
        }
    }

    public void cancel() {
        if (this.mCanceled == false) goto L5;
        return;
    L5:
        this.mCanceled = true;
        this.mHttpClient.cancel();
        this.mH.removeCallbacksAndMessages(null);
        if (TTVideoEngineLog.d() == false) goto L9;
        TTVideoEngineLog.d(TAG, "cancel " + this.mRequestParams);
        return;
    }

    public void start() {
        if (TTVideoEngineLog.d() == false) goto L5;
        TTVideoEngineLog.d(TAG, "start " + this.mRequestParams);
    L5:
        RequestParams r0 = this.mRequestParams;
        String r1 = SmartUrlCache.key(r0);
        Result r2 = SmartUrlCache.get(r1);
        if (r2 == null) goto L8;
        notifyComplete(r0, 1, r2);
        return;
    L8:
        fetch(r1, r0);
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public SmartUrlFetcher(Callback r2) {
        this.mCallback = r2;
        TTVNetClient r3 = TTVideoEngineConfig.gNetClient;
        if (r3 == null) goto L5;
        this.mHttpClient = r3;
    L7:
        if (Looper.myLooper() != null) goto L9;
        Looper r4 = Looper.getMainLooper();
    L10:
        this.mH = new WeakHandler(r4, this);
        return;
    L9:
        r4 = Looper.myLooper();
        goto L10
    L5:
        this.mHttpClient = new TTHTTPNetwork();
        goto L7
    }

    public static /* synthetic */ boolean access$000(SmartUrlFetcher r0) {
        return r0.mCanceled;
    }

    private static String buildRequestUrl(RequestParams r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("PlayUrl", r3.playUrl);
        r0.put("Codec", r3.codec);
        r0.put("Definition", r3.definition);
        StringBuilder r4 = new StringBuilder();
        String r1 = CodecStrategy.SmartUrlVod.getApiHost();
        if (r1 != null) goto L5;
    L7:
        r4.append(r1);
        r4.append("/api/general/getSmartStrategyLitePlayInfo20220101?");
        r4.append(TTHelper.buildUrlEncodedQuery(r0));
        return r4.toString();
    L5:
        if (r1.startsWith("http") == true) goto L7;
        r4.append("https://");
        goto L7
    }

    @Override // com.ss.ttvideoengine.utils.WeakHandler.IHandler
    public void handleMessage(Message r5) {
        int r0 = r5.what;
        if (r0 == 1) goto L7;
        if (r0 != 2) goto L10;
        Object[] r6 = (Object[]) r5.obj;
        notifyError((RequestParams) r6[0], (Error) r6[1]);
        return;
    L10:
        return;
    L7:
        Object[] r7 = (Object[]) r5.obj;
        notifyComplete((RequestParams) r7[0], ((Integer) r7[1]).intValue(), (Result) r7[2]);
    }

    public void setRequestParams(RequestParams r1) {
        this.mRequestParams = r1;
    }

    private void fetch(final String r4, final RequestParams r5) {
        String r0 = buildRequestUrl(r5);
        this.mHttpClient.startTask(r0, new AnonymousClass1(this, r5, r4));
        if (TTVideoEngineLog.d() == false) goto L6;
        TTVideoEngineLog.d(TAG, "fetch " + r5 + ", requestUrl = " + r0);
        return;
    }

    private void notifyError(RequestParams r5, Error r6) {
        r6.domain = Error.FetchingSmartUrlInfo;
        if (this.mH.getLooper() == Looper.myLooper()) goto L5;
        this.mH.obtainMessage(2, new Object[]{r5, r6}).sendToTarget();
        return;
    L5:
        if (this.mCanceled == false) goto L11;
        if (TTVideoEngineLog.d() == false) goto L19;
        TTVideoEngineLog.d(TAG, "notifyError canceled");
        return;
    L19:
        return;
    L11:
        if (this.mCallback != null) goto L14;
        return;
    L14:
        if (TTVideoEngineLog.d() == false) goto L16;
        TTVideoEngineLog.d(TAG, "notifyError " + r5 + " " + r6);
    L16:
        this.mCallback.onError(r5, r6);
    }

    public static /* synthetic */ void access$100(SmartUrlFetcher r0, RequestParams r1, Error r2) {
        r0.notifyError(r1, r2);
    }

    private void notifyComplete(RequestParams r4, int r5, Result r6) {
        if (this.mH.getLooper() == Looper.myLooper()) goto L5;
        this.mH.obtainMessage(1, new Object[]{r4, Integer.valueOf(r5), r6}).sendToTarget();
        return;
    L5:
        if (this.mCanceled == false) goto L11;
        if (TTVideoEngineLog.d() == false) goto L19;
        TTVideoEngineLog.d(TAG, "notifyComplete canceled");
        return;
    L19:
        return;
    L11:
        if (this.mCallback != null) goto L14;
        return;
    L14:
        if (TTVideoEngineLog.d() == false) goto L16;
        TTVideoEngineLog.d(TAG, "notifyComplete " + r4 + " " + r5 + " " + r6);
    L16:
        this.mCallback.onComplete(r4, r5, r6);
    }

    public static /* synthetic */ void access$300(SmartUrlFetcher r0, RequestParams r1, int r2, Result r3) {
        r0.notifyComplete(r1, r2, r3);
    }
}
