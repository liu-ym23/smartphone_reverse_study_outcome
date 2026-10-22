package com.ss.ttvideoengine.source.strategy;

import android.text.TextUtils;
import com.ss.ttvideoengine.DirectUrlItem;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineImpl;
import com.ss.ttvideoengine.TTVideoEngineInternal;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.source.DirectUrlSource;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.source.VidPlayAuthTokenSource;
import com.ss.ttvideoengine.source.VideoModelSource;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import com.ss.ttvideoengine.utils.EngineException;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CodecStrategyAdapter {
    public final String TAG;
    private final List<CodecStrategy.Dimension> mErrorDimensions;
    private CodecStrategy.ResolveResult mResolveResult;
    private SmartUrlFetcher mSmartUrlFetcher;
    private StrategySource mSource;
    private final SourceSetter mSourceSetter;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$source$Source$Type = null;

        static {
            int[] r0 = new int[Source.Type.values().length];
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type = r0;
            r0[Source.Type.DIRECT_URL_SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type[Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type[Source.Type.VIDEO_MODEL_SOURCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class PlayerSourceSetter implements SourceSetter {
        TTVideoEngineImpl mEngine;

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public int type() {
            return 0;
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public String createTag() {
            return TTVideoEngineInternal.logcatTag(this.mEngine) + "_CodecStrategy";
        }

        public void play() {
            this.mEngine.play();
        }

        public void stop() {
            this.mEngine.stop();
        }

        public PlayerSourceSetter(TTVideoEngineImpl r1) {
            this.mEngine = r1;
        }

        private void configPlayerWithDimension(CodecStrategy.Dimension r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            this.mEngine.setStringOption(1000, r5.encodeType);
            if (r5.decoder != 1) goto L12;
            this.mEngine.setIntOption(7, 1);
            if (TextUtils.equals(r5.encodeType, Source.EncodeType.BYTEVC1) == false) goto L10;
            this.mEngine.setAsyncInit(true, 1);
            return;
        L10:
            if (TextUtils.equals(r5.encodeType, Source.EncodeType.H264) == false) goto L15;
            this.mEngine.setAsyncInit(true, 0);
            return;
        L15:
            return;
        L12:
            this.mEngine.setIntOption(7, 0);
        }

        public void setEncodedKey(String r2) {
            this.mEngine.setEncodedKey(r2);
        }

        public static /* synthetic */ void access$000(PlayerSourceSetter r0, CodecStrategy.Dimension r1) {
            r0.configPlayerWithDimension(r1);
        }

        public void setStringOption(int r2, String r3) {
            this.mEngine.setStringOption(r2, r3);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public void setVideoModel(String r4, IVideoModel r5, Resolution r6) {
            TTVideoEngineLog.d(createTag(), "setVideoModel vid = " + r4 + ", videoModel = " + r5 + ", resolution = " + r6);
            this.mEngine.setVideoModel(r5);
            this.mEngine.configResolution(r6);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public void setDirectUrl(String r11, DirectUrlSource.UrlItem r12, CodecStrategy.Dimension r13, boolean r14) {
            TTVideoEngineLog.d(createTag(), "setDirectUrl vid = " + r11 + ", urlItem = " + r12 + ", dimension = " + r13 + ", isFetchSmartUrl = " + r14);
            if (r14 == true) goto L16;
            if (r12.getUrlExpiredTime() <= 0) goto L8;
        L11:
            this.mEngine.setDirectUrlUseDataLoader(new DirectUrlItem(r12.getUrls(), r12.getCacheKey(), r11, r12.getUrlExpiredTime(), r12.getUrlExpires(), r12.getFormat(), r12.getBitrate()));
        L13:
            if (r12.getPlayAuth() == null) goto L16;
            this.mEngine.setEncodedKey(r12.getPlayAuth());
            goto L16
        L8:
            if (r12.getUrlExpires() != null) goto L11;
            this.mEngine.setDirectUrlUseDataLoader(r12.getUrls(), r12.getCacheKey(), r11, r12.getFormat(), r12.getBitrate());
        L16:
            if (r13 == null) goto L18;
            configPlayerWithDimension(r13);
            this.mEngine.setIntOption(670, 0);
            return;
        L18:
            this.mEngine.setIntOption(670, 1);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public void setVideoID(String r4, String r5, Resolution r6, String r7, CodecStrategy.Dimension r8) {
            TTVideoEngineLog.d(createTag(), "setVideoID vid = " + r4 + ", playAuthToken = " + r5 + ", dimension = " + r8);
            this.mEngine.setVideoID(r4);
            this.mEngine.setPlayAuthToken(r5);
            if (r8 == null) goto L5;
            configPlayerWithDimension(r8);
            this.mEngine.setIntOption(670, 0);
        L7:
            if (r6 == null) goto L10;
            this.mEngine.configResolution(r6);
            return;
        L10:
            return;
        L5:
            if (r7 == null) goto L7;
            this.mEngine.setStringOption(1000, r7);
            this.mEngine.setIntOption(670, 1);
            goto L7
        }
    }

    public interface PreloadSourceSetter extends SourceSetter {

        /* JADX INFO: renamed from: com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter$PreloadSourceSetter$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static String $default$createTag(PreloadSourceSetter r0) {
                return "DataLoaderHelper_CodecStrategy";
            }

            public static int $default$type(PreloadSourceSetter r0) {
                return 1;
            }

            public static void $default$setVideoModel(PreloadSourceSetter r2, String r3, IVideoModel r4, Resolution r5) {
                TTVideoEngineLog.d(r2.createTag(), "setVideoModel vid = " + r3 + ", videoModel = " + r4 + ", resolution = " + r5);
            }

            public static void $default$setDirectUrl(PreloadSourceSetter r2, String r3, DirectUrlSource.UrlItem r4, CodecStrategy.Dimension r5, boolean r6) {
                TTVideoEngineLog.d(r2.createTag(), "setDirectUrl vid = " + r3 + ", urlItem = " + r4 + ", dimension = " + r5 + ", isFetchSmartUrl = " + r6);
            }

            public static void $default$setVideoID(PreloadSourceSetter r1, String r2, String r3, Resolution r4, String r5, CodecStrategy.Dimension r6) {
                TTVideoEngineLog.d(r1.createTag(), "setVideoID vid = " + r2 + ", playAuthToken = " + r3 + ", encodeType = " + r5 + ", dimension = " + r6);
            }
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        String createTag();

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        void setDirectUrl(String r1, DirectUrlSource.UrlItem r2, CodecStrategy.Dimension r3, boolean r4);

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        void setVideoID(String r1, String r2, Resolution r3, String r4, CodecStrategy.Dimension r5);

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        void setVideoModel(String r1, IVideoModel r2, Resolution r3);

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        int type();
    }

    public interface SourceSetter {
        public static final int TYPE_PLAYER = 0;
        public static final int TYPE_PRELOAD = 1;

        /* JADX INFO: renamed from: com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter$SourceSetter$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static String $default$createTag(SourceSetter r0) {
                return CodecStrategy.TAG;
            }

            public static void $default$setDirectUrl(SourceSetter r0, String r1, DirectUrlSource.UrlItem r2, CodecStrategy.Dimension r3, boolean r4) {
            }

            public static void $default$setVideoID(SourceSetter r0, String r1, String r2, Resolution r3, String r4, CodecStrategy.Dimension r5) {
            }

            public static void $default$setVideoModel(SourceSetter r0, String r1, IVideoModel r2, Resolution r3) {
            }

            public static int $default$type(SourceSetter r0) {
                return -1;
            }
        }

        String createTag();

        void setDirectUrl(String r1, DirectUrlSource.UrlItem r2, CodecStrategy.Dimension r3, boolean r4);

        void setVideoID(String r1, String r2, Resolution r3, String r4, CodecStrategy.Dimension r5);

        void setVideoModel(String r1, IVideoModel r2, Resolution r3);

        int type();
    }

    public void cancelFetchSmartUrlInfo() {
        if (this.mSmartUrlFetcher != null) goto L6;
        return;
    L6:
        if (this.mResolveResult != null) goto L8;
    L12:
        this.mSmartUrlFetcher.cancel();
        this.mSmartUrlFetcher = null;
        return;
    L8:
        if (this.mSource == null) goto L12;
        if (TTVideoEngineLog.d() == false) goto L12;
        TTVideoEngineLog.d(this.TAG, "cancelFetchSmartUrlInfo " + this.mSource.vid() + " " + this.mResolveResult.requestItem);
        goto L12
    }

    public boolean fallbackToDirectUrl() {
        SourceSetter r0 = this.mSourceSetter;
        if (r0 != null) goto L5;
        return false;
    L5:
        StrategySource r2 = this.mSource;
        if (r2 != null) goto L8;
    L10:
        DirectUrlSource r3 = null;
    L11:
        if (r3 != null) goto L13;
        return false;
    L13:
        CodecStrategy.ResolveResult r1 = CodecStrategy.resolveStartPlayback(r3, false);
        if (TTVideoEngineLog.d() == false) goto L16;
        TTVideoEngineLog.d(this.TAG, "fallbackToDirectUrl " + r3 + " " + r1);
    L16:
        if (r1 != null) goto L18;
        setupSource(r0, r3);
    L20:
        if (r0.type() != 0) goto L24;
        ((PlayerSourceSetter) r0).play();
        return true;
    L24:
        return true;
    L18:
        setupSource(r0, r1);
        goto L20
    L8:
        if (r2.type() != Source.Type.DIRECT_URL_SOURCE) goto L10;
        r3 = (DirectUrlSource) this.mSource;
        goto L11
    }

    public boolean isCodecStrategyValid() {
        StrategySource r0 = this.mSource;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isCodecStrategyValid();
    }

    public boolean isFetchSmartUrl() {
        StrategySource r0 = this.mSource;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.type() == Source.Type.DIRECT_URL_SOURCE) goto L8;
        return false;
    L8:
        if (CodecStrategy.SmartUrlVod.isEnable((DirectUrlSource) this.mSource) == false) goto L16;
        CodecStrategy.ResolveResult r1 = this.mResolveResult;
        if (r1 != null) goto L12;
        return false;
    L12:
        if (r1.requestItem == null) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    public void release() {
        reset();
        this.mErrorDimensions.clear();
    }

    public void reset() {
        if (TTVideoEngineLog.d() == false) goto L5;
        TTVideoEngineLog.d(this.TAG, "reset");
    L5:
        cancelFetchSmartUrlInfo();
        this.mSource = null;
        this.mResolveResult = null;
    }

    public StrategySource getStrategySource() {
        return this.mSource;
    }

    public CodecStrategyAdapter(SourceSetter r2) {
        this.mErrorDimensions = new ArrayList();
        this.mSourceSetter = r2;
        this.TAG = createTag(r2);
    }

    public static String createTag(SourceSetter r0) {
        return r0.createTag();
    }

    private static String resolveVideoModelEncoderType(IVideoModel r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String[] r3 = r2.getCodecs();
        if (r3 != null) goto L8;
        return null;
    L8:
        List r4 = Arrays.asList(r3);
        if (r4.contains(Source.EncodeType.BYTEVC2) == false) goto L12;
        return Source.EncodeType.BYTEVC2;
    L12:
        if (r4.contains(Source.EncodeType.BYTEVC1) == true) goto L17;
        return Source.EncodeType.H264;
    L17:
        return Source.EncodeType.BYTEVC1;
    }

    public void correctStrategy(IVideoModel r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        SourceSetter r0 = this.mSourceSetter;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.type() != 0) goto L48;
        PlayerSourceSetter r1 = (PlayerSourceSetter) this.mSourceSetter;
        CodecStrategy.ResolveResult r2 = this.mResolveResult;
        if (r2 != null) goto L12;
        return;
    L12:
        StrategySource r3 = this.mSource;
        if (r3 != null) goto L16;
        return;
    L16:
        if (r3.isCodecStrategyValid() == true) goto L18;
        return;
    L18:
        String r10 = resolveVideoModelEncoderType(r9);
        if (r10 != null) goto L21;
        return;
    L21:
        CodecStrategy.Dimension r4 = r2.dimension;
        if (TextUtils.equals(r4.encodeType, r10) == false) goto L28;
        if (TTVideoEngineLog.d() == false) goto L46;
        TTVideoEngineLog.d(this.TAG, "correctStrategy result is [right] " + r4);
        return;
    L46:
        return;
    L28:
        if (TTVideoEngineLog.d() == false) goto L30;
        TTVideoEngineLog.d(this.TAG, "correctStrategy result is [wrong] " + r10 + " " + r4);
    L30:
        CodecStrategy.Dimension[] r5 = CodecStrategy.Dimension.values();
        int r6 = r5.length;
        int r7 = 0;
    L31:
        if (r7 >= r6) goto L36;
        if (TextUtils.equals(r5[r7].encodeType, r4.encodeType) == false) goto L35;
        this.mErrorDimensions.add(r4);
    L35:
        r7 = r7 + 1;
        goto L31
    L36:
        CodecStrategy.Dimension r11 = CodecStrategy.resolveWithEncoderType(r10, r3, this.mErrorDimensions);
        if (TTVideoEngineLog.d() == false) goto L39;
        TTVideoEngineLog.d(this.TAG, "correctStrategy corrected dimension = " + r11 + "; old = " + r4);
    L39:
        if (r11 != null) goto L41;
        return;
    L41:
        correctDimension(r1, r11);
        return;
    }

    public void fetchSmartUrlInfo(SmartUrlFetcher.Callback r5) {
        SmartUrlFetcher r0 = this.mSmartUrlFetcher;
        if (r0 == null) goto L6;
        r0.cancel();
        this.mSmartUrlFetcher = null;
    L6:
        if (this.mSource != null) goto L8;
        return;
    L8:
        CodecStrategy.ResolveResult r1 = this.mResolveResult;
        if (r1 != null) goto L11;
        return;
    L11:
        DirectUrlSource.UrlItem r2 = r1.requestItem;
        if (r2 != null) goto L15;
        return;
    L15:
        if (TTVideoEngineLog.d() == false) goto L17;
        TTVideoEngineLog.d(this.TAG, "fetchSmartUrlInfo " + this.mSource.vid() + " " + this.mResolveResult.requestItem);
    L17:
        this.mSmartUrlFetcher = new SmartUrlFetcher(r5);
        SmartUrlFetcher.RequestParams r6 = new SmartUrlFetcher.RequestParams();
        r6.videoId = this.mSource.vid();
        r6.playUrl = r2.getUrl();
        r6.cacheKey = r2.getCacheKey();
        r6.codec = CodecStrategy.SmartUrlVod.encodeType();
        r6.definition = CodecStrategy.SmartUrlVod.videoResolution().toString(VideoRef.TYPE_VIDEO);
        this.mSmartUrlFetcher.setRequestParams(r6);
        this.mSmartUrlFetcher.start();
    }

    public boolean interceptFallbackRetry(Error r6) {
        SourceSetter r7 = this.mSourceSetter;
        if (r7 != null) goto L6;
        return false;
    L6:
        if (r7.type() == 0) goto L8;
        return false;
    L8:
        PlayerSourceSetter r8 = (PlayerSourceSetter) this.mSourceSetter;
        StrategySource r1 = this.mSource;
        if (r1 != null) goto L12;
        return false;
    L12:
        if (r1.isCodecStrategyValid() == true) goto L14;
        return false;
    L14:
        CodecStrategy.ResolveResult r2 = this.mResolveResult;
        if (r2 != null) goto L18;
        return false;
    L18:
        if (this.mErrorDimensions.contains(r2.dimension) == true) goto L20;
        this.mErrorDimensions.add(r2.dimension);
    L20:
        CodecStrategy.ResolveResult r3 = CodecStrategy.resolveFallback(r1, this.mErrorDimensions);
        if (r3 != null) goto L27;
        if (TTVideoEngineLog.e() == false) goto L25;
        TTVideoEngineLog.e(this.TAG, "resolveFallback return null! " + r1 + " " + this.mErrorDimensions + " " + CodecStrategy.dump());
    L25:
        return false;
    L27:
        if (TTVideoEngineLog.d() == false) goto L29;
        TTVideoEngineLog.d(this.TAG, "resolveFallback " + r3 + " " + CodecStrategy.dump());
    L29:
        setupSource(r8, r3);
        r8.play();
        return true;
    }

    public void setStrategySource(StrategySource r4) throws EngineException {
        reset();
        if (r4 == null) goto L16;
        if (TTVideoEngineLog.d() == false) goto L7;
        TTVideoEngineLog.d(this.TAG, "setStrategySource " + r4);
        TTVideoEngineLog.d(this.TAG, "setStrategySource " + CodecStrategy.dump());
    L7:
        this.mSource = r4;
        if (r4.isCodecStrategyValid() == false) goto L13;
        CodecStrategy.ResolveResult r0 = CodecStrategy.resolveStartPlayback(r4, true);
        if (r0 == null) goto L12;
        setupSource(this.mSourceSetter, r0);
        return;
    L12:
        setupSource(this.mSourceSetter, r4);
        return;
    L13:
        setupSource(this.mSourceSetter, r4);
        return;
    L16:
        throw new EngineException(new Error(Error.SetStrategySource, Error.InvalidSource));
    }

    public CodecStrategyAdapter(TTVideoEngineImpl r2) {
        this(new PlayerSourceSetter(r2));
    }

    private void correctDimension(PlayerSourceSetter r2, CodecStrategy.Dimension r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        CodecStrategy.ResolveResult r0 = this.mResolveResult;
        if (r0 == null) goto L7;
        r0.correctedDimension = r3;
    L7:
        PlayerSourceSetter.access$000(r2, r3);
    }

    private void setupSource(SourceSetter r9, CodecStrategy.ResolveResult r10) {
        this.mResolveResult = r10;
        StrategySource r0 = r10.source;
        CodecStrategy.Dimension r1 = r10.correctedDimension;
        if (r1 != null) goto L6;
        r1 = r10.dimension;
    L6:
        CodecStrategy.Dimension r7 = r1;
        Source.Type r2 = r0.type();
        int r3 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$Source$Type[r2.ordinal()];
        if (r3 != 1) goto L9;
        DirectUrlSource.UrlItem r4 = r10.urlItem;
        DirectUrlSource.UrlItem r5 = r10.requestItem;
        if (r4 == null) goto L16;
        r9.setDirectUrl(r0.vid(), r4, r7, false);
        return;
    L16:
        if (r5 == null) goto L20;
        r9.setDirectUrl(r0.vid(), r5, r7, true);
        return;
    L20:
        if (TTVideoEngineLog.d() == false) goto L25;
        TTVideoEngineLog.d(this.TAG, "setupSource CodecStrategy error:" + r10);
        return;
    L25:
        return;
    L9:
        if (r3 != 2) goto L12;
        VidPlayAuthTokenSource r6 = (VidPlayAuthTokenSource) r0;
        r9.setVideoID(r6.vid(), r6.playAuthToken(), r6.resolution(), null, r7);
        return;
    L12:
        throw new IllegalArgumentException("unsupported source type! " + r2);
    }

    private void setupSource(SourceSetter r8, StrategySource r9) {
        this.mResolveResult = null;
        Source.Type r1 = r9.type();
        int r2 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$Source$Type[r1.ordinal()];
        if (r2 != 1) goto L5;
        DirectUrlSource.UrlItem r3 = ((DirectUrlSource) r9).firstItem();
        r8.setDirectUrl(r9.vid(), r3, null, false);
        return;
    L5:
        if (r2 != 2) goto L7;
        VidPlayAuthTokenSource r0 = (VidPlayAuthTokenSource) r9;
        r8.setVideoID(r9.vid(), r0.playAuthToken(), r0.resolution(), r0.encodeType(), null);
        return;
    L7:
        if (r2 != 3) goto L15;
        VideoModelSource r10 = (VideoModelSource) r9;
        r8.setVideoModel(r10.vid(), r10.videoModel(), r10.resolution());
        return;
    }
}
