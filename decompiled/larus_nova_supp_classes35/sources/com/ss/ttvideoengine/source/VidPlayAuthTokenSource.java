package com.ss.ttvideoengine.source;

import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class VidPlayAuthTokenSource implements StrategySource {
    public static final List<String> DEFAULT_SUPPORTED_ENCODE_TYPES = null;
    public static final String TAG = "VidPlayAuthTokenSource";
    private final int codecStrategy;
    private final String encodeType;
    private final String playAuthToken;
    private final Resolution resolution;
    private final List<String> supportedEncodeTypes;
    private final Object tag;
    private final String vid;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.VidPlayAuthTokenSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int codecStrategy;
        private String encodeType;
        private String playAuthToken;
        private Resolution resolution;
        private List<String> supportedEncodeTypes;
        private Object tag;
        private String vid;

        public Builder() {
        }

        public VidPlayAuthTokenSource build() {
            if (this.vid == null) goto L28;
            if (this.playAuthToken == null) goto L26;
            if (this.resolution != null) goto L9;
            this.resolution = Resolution.Standard;
        L9:
            List<String> r0 = this.supportedEncodeTypes;
            if (r0 == null) goto L18;
            String r1 = this.encodeType;
            if (r1 == null) goto L18;
            if (r0.contains(r1) == true) goto L18;
            throw new IllegalArgumentException("supportedEncodeTypes:" + this.supportedEncodeTypes + " must contains encodeType:" + this.encodeType);
        L18:
            List<String> r2 = this.supportedEncodeTypes;
            if (r2 != null) goto L21;
        L22:
            this.supportedEncodeTypes = VidPlayAuthTokenSource.DEFAULT_SUPPORTED_ENCODE_TYPES;
        L24:
            return new VidPlayAuthTokenSource(this, null);
        L21:
            if (r2.isEmpty() == false) goto L24;
        L26:
            throw new NullPointerException("playAuthToken is null");
        L28:
            throw new NullPointerException("vid is null");
        }

        public Builder(VidPlayAuthTokenSource r2) {
            this.vid = VidPlayAuthTokenSource.access$700(r2);
            this.playAuthToken = VidPlayAuthTokenSource.access$800(r2);
            this.encodeType = VidPlayAuthTokenSource.access$900(r2);
            this.resolution = VidPlayAuthTokenSource.access$1000(r2);
            this.codecStrategy = VidPlayAuthTokenSource.access$1100(r2);
        }

        public static /* synthetic */ String access$000(Builder r0) {
            return r0.vid;
        }

        public static /* synthetic */ String access$100(Builder r0) {
            return r0.playAuthToken;
        }

        public static /* synthetic */ String access$200(Builder r0) {
            return r0.encodeType;
        }

        public static /* synthetic */ List access$300(Builder r0) {
            return r0.supportedEncodeTypes;
        }

        public static /* synthetic */ Resolution access$400(Builder r0) {
            return r0.resolution;
        }

        public static /* synthetic */ int access$500(Builder r0) {
            return r0.codecStrategy;
        }

        public static /* synthetic */ Object access$600(Builder r0) {
            return r0.tag;
        }

        public Builder setCodecStrategy(int r1) {
            this.codecStrategy = r1;
            return this;
        }

        public Builder setEncodeType(String r1) {
            this.encodeType = r1;
            return this;
        }

        public Builder setPlayAuthToken(String r2) {
            if (r2 == null) goto L6;
            this.playAuthToken = r2;
            return this;
        L6:
            throw new NullPointerException("playAuthToken is null");
        }

        public Builder setResolution(Resolution r1) {
            this.resolution = r1;
            return this;
        }

        public Builder setSupportedEncodeTypes(List<String> r2) {
            if (r2 == null) goto L8;
            if (r2.isEmpty() == true) goto L8;
            this.supportedEncodeTypes = new ArrayList(r2);
            return this;
        L8:
            throw new IllegalArgumentException("supportedEncodeTypes can't be null or empty!");
        }

        public Builder setTag(Object r1) {
            this.tag = r1;
            return this;
        }

        public Builder setVid(String r2) {
            if (r2 == null) goto L6;
            this.vid = r2;
            return this;
        L6:
            throw new NullPointerException("vid is null");
        }
    }

    @Override // com.ss.ttvideoengine.source.Source
    public final /* synthetic */ boolean isCodecStrategyValid() {
        return Source.CC.$default$isCodecStrategyValid(this);
    }

    static {
        DEFAULT_SUPPORTED_ENCODE_TYPES = Collections.unmodifiableList(Arrays.asList(new String[]{Source.EncodeType.H264, Source.EncodeType.BYTEVC1, Source.EncodeType.BYTEVC2}));
    }

    public List<String> supportedEncodeTypes() {
        return Collections.unmodifiableList(this.supportedEncodeTypes);
    }

    public String toString() {
        return "VidPlayAuthTokenSource{vid='" + this.vid + "', playAuthToken='" + this.playAuthToken + "', encodeType='" + this.encodeType + "', supportedEncodeTypes=" + this.supportedEncodeTypes + ", resolution=" + this.resolution + ", codecStrategy=" + this.codecStrategy + '}';
    }

    @Override // com.ss.ttvideoengine.source.Source
    public int codecStrategy() {
        return this.codecStrategy;
    }

    public String encodeType() {
        return this.encodeType;
    }

    public String playAuthToken() {
        return this.playAuthToken;
    }

    public Resolution resolution() {
        return this.resolution;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Object tag() {
        return this.tag;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Source.Type type() {
        return Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public String vid() {
        return this.vid;
    }

    private VidPlayAuthTokenSource(Builder r2) {
        this.vid = Builder.access$000(r2);
        this.playAuthToken = Builder.access$100(r2);
        this.encodeType = Builder.access$200(r2);
        this.supportedEncodeTypes = Builder.access$300(r2);
        this.resolution = Builder.access$400(r2);
        this.codecStrategy = Builder.access$500(r2);
        this.tag = Builder.access$600(r2);
    }

    public static /* synthetic */ Resolution access$1000(VidPlayAuthTokenSource r0) {
        return r0.resolution;
    }

    public static /* synthetic */ int access$1100(VidPlayAuthTokenSource r0) {
        return r0.codecStrategy;
    }

    public static /* synthetic */ String access$700(VidPlayAuthTokenSource r0) {
        return r0.vid;
    }

    public static /* synthetic */ String access$800(VidPlayAuthTokenSource r0) {
        return r0.playAuthToken;
    }

    public static /* synthetic */ String access$900(VidPlayAuthTokenSource r0) {
        return r0.encodeType;
    }

    public /* synthetic */ VidPlayAuthTokenSource(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }
}
