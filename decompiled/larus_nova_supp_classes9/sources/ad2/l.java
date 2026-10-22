package ad2;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.bduploader.BDImageInfo;
import com.ss.bduploader.BDImageUploader;
import com.ss.bduploader.BDImageUploaderListener;
import io.reactivex.ObservableEmitter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements BDImageUploaderListener {
    public final Map<Integer, Long> a;
    public final /* synthetic */ ObservableEmitter b;
    public final /* synthetic */ BDImageUploader c;
    public final /* synthetic */ int d;
    public final /* synthetic */ CallContext e;

    public final void onLog(int r1, int r2, String r3) {
    }

    public final int imageUploadCheckNetState(int r1, int r2) {
        return DownloadUtils.isNetworkConnected(s1.getContext()) ? 1 : 0;
    }

    public final void onNotify(int r4, long r5, BDImageInfo r7) {
        if (r4 != 0) goto L4;
        this.c.close();
        this.b.onComplete();
        return;
    L4:
        if (r4 == 1) goto L28;
        String r6 = null;
        if (r4 != 2) goto L8;
        this.c.close();
        ObservableEmitter r8 = this.b;
        StringBuilder r0 = new StringBuilder("BDUpload failed,");
        if (r7 == null) goto L23;
        Long r1 = Long.valueOf(r7.mErrorCode);
    L24:
        r0.append(r1);
        r0.append(", ");
        if (r7 == null) goto L27;
        r6 = r7.mErrorMsg;
    L27:
        r0.append(r6);
        r8.onError(new Throwable(r0.toString()));
        return;
    L23:
        r1 = null;
        goto L24
    L8:
        if (r4 != 6) goto L10;
        if (r7 != null) goto L19;
        this.b.onError(new Throwable("Complete with empty result"));
        return;
    L19:
        this.b.onNext(TuplesKt.to(Integer.valueOf(r7.mFileIndex), new com.bytedance.android.livesdk.jsbridge.methods.upload.models.a(r7.mImageTosKey, r7.mEncryptionMeta)));
        return;
    L10:
        if (r4 != 7) goto L37;
        this.c.close();
        ObservableEmitter r9 = this.b;
        StringBuilder r2 = new StringBuilder("single upload fail ");
        if (r7 == null) goto L15;
        r6 = r7.mErrorMsg;
    L15:
        r2.append(r6);
        r9.onError(new Throwable(r2.toString()));
        return;
    L37:
        return;
    L28:
        if (r7 == null) goto L35;
        this.a.put(Integer.valueOf(r7.mFileIndex), Long.valueOf(r7.mProgress));
        int r10 = (int) ((CollectionsKt.sumOfLong(((LinkedHashMap) this.a).values()) / ((double) (this.d * 100))) * ((double) 100));
        CallContext r11 = this.e;
        JSONObject r13 = new JSONObject();
        r13.put("progress", r10);
        Unit r14 = Unit.INSTANCE;
        r11.b("subscribe.upload.progress", r13);
        return;
    }

    public l(ObservableEmitter r1, BDImageUploader r2, int r3, CallContext r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new LinkedHashMap();
    }
}
