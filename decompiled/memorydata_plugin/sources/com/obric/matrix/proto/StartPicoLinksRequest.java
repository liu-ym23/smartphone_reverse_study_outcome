package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class StartPicoLinksRequest extends Message<StartPicoLinksRequest, a> {
    public static final ProtoAdapter<StartPicoLinksRequest> ADAPTER = null;
    public static final String DEFAULT_REFERRER = "";
    public static final SCENE DEFAULT_SCENE = null;
    public static final String DEFAULT_TARGETURL = "";
    private static final long serialVersionUID = 0;

    @SerializedName("referrer")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String referrer;

    @SerializedName(MemoryInfoSectionEditActivity.KIND_SCENE)
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest$SCENE#ADAPTER", tag = 1)
    public final SCENE scene;

    @SerializedName("targetUrl")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String targetUrl;

    public static final enum SCENE extends Enum<SCENE> implements WireEnum {
        private static final /* synthetic */ SCENE[] $VALUES = null;
        public static final ProtoAdapter<SCENE> ADAPTER = null;
        public static final SCENE BROWSER = null;
        public static final SCENE NATIVE_APP = null;
        public static final SCENE SYSTEM = null;
        public static final SCENE WEB_VIEW = null;
        private final int value;

        private static final class a extends EnumAdapter<SCENE> {
            a() {
                super(SCENE.class);
            }

            public SCENE a(int r1) {
                return SCENE.fromValue(r1);
            }

            @Override // com.squareup.wire.EnumAdapter
            public /* synthetic */ WireEnum fromValue(int r1) {
                return a(r1);
            }
        }

        static {
            SCENE r0 = new SCENE("BROWSER", 0, 0);
            BROWSER = r0;
            SCENE r1 = new SCENE("WEB_VIEW", 1, 1);
            WEB_VIEW = r1;
            SCENE r3 = new SCENE("NATIVE_APP", 2, 2);
            NATIVE_APP = r3;
            SCENE r5 = new SCENE("SYSTEM", 3, 3);
            SYSTEM = r5;
            $VALUES = new SCENE[]{r0, r1, r3, r5};
            ADAPTER = new a();
        }

        private SCENE(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static SCENE fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return SYSTEM;
        L14:
            return NATIVE_APP;
        L16:
            return WEB_VIEW;
        L18:
            return BROWSER;
        }

        public static SCENE valueOf(String r2) {
            return (SCENE) ZeusTransformUtils.preCheckCast(Enum.valueOf(SCENE.class, r2), SCENE.class, "com.obric.memorydata.plugin");
        }

        public static SCENE[] values() {
            return (SCENE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SCENE[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    public static final class a extends Message.Builder<StartPicoLinksRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SCENE f8228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8229b;
        public String c;

        public a() {
            this.f8228a = SCENE.BROWSER;
            this.f8229b = "";
            this.c = "";
        }

        public a a(SCENE r1) {
            this.f8228a = r1;
            return this;
        }

        public a a(String r1) {
            this.f8229b = r1;
            return this;
        }

        public StartPicoLinksRequest a() {
            return new StartPicoLinksRequest(this.f8228a, this.f8229b, this.c, super.buildUnknownFields());
        }

        public a b(String r1) {
            this.c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<StartPicoLinksRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksRequest.class);
        }

        public int a(StartPicoLinksRequest r4) {
            return ((SCENE.ADAPTER.encodedSizeWithTag(1, r4.scene) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.referrer)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.targetUrl)) + r4.unknownFields().size();
        }

        public StartPicoLinksRequest a(ProtoReader r8) {
            a r7 = new a();
            long r0 = r8.beginMessage();
        L3:
            int r2 = r8.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r7.a((SCENE) ZeusTransformUtils.preCheckCast(SCENE.ADAPTER.decode(r8), SCENE.class, "com.obric.memorydata.plugin"));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r7.addUnknownField(r2, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r7.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r7.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            FieldEncoding r3 = r8.peekFieldEncoding();
            r7.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r8));
            goto L3
        L18:
            r8.endMessage(r0);
            return r7.a();
        }

        public void a(ProtoWriter r3, StartPicoLinksRequest r4) {
            SCENE.ADAPTER.encodeWithTag(r3, 1, r4.scene);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.referrer);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.targetUrl);
            r3.writeBytes(r4.unknownFields());
        }

        public StartPicoLinksRequest b(StartPicoLinksRequest r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ StartPicoLinksRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, StartPicoLinksRequest r4) {
            a(r3, (StartPicoLinksRequest) ZeusTransformUtils.preCheckCast(r4, StartPicoLinksRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(StartPicoLinksRequest r3) {
            return a((StartPicoLinksRequest) ZeusTransformUtils.preCheckCast(r3, StartPicoLinksRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ StartPicoLinksRequest redact(StartPicoLinksRequest r3) {
            return b((StartPicoLinksRequest) ZeusTransformUtils.preCheckCast(r3, StartPicoLinksRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SCENE = SCENE.BROWSER;
    }

    public StartPicoLinksRequest(SCENE r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public StartPicoLinksRequest(SCENE r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.scene = r2;
        this.referrer = r3;
        this.targetUrl = r4;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, StartPicoLinksRequest.class) == true) goto L8;
        return false;
    L8:
        StartPicoLinksRequest r6 = (StartPicoLinksRequest) ZeusTransformUtils.preCheckCast(r5, StartPicoLinksRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (Internal.equals(this.scene, r6.scene) == false) goto L18;
        if (Internal.equals(this.referrer, r6.referrer) == false) goto L18;
        if (Internal.equals(this.targetUrl, r6.targetUrl) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        SCENE r2 = this.scene;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.referrer;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.targetUrl;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8228a = this.scene;
        r0.f8229b = this.referrer;
        r0.c = this.targetUrl;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.scene == null) goto L6;
        r0.append(", scene=").append(this.scene);
    L6:
        if (this.referrer == null) goto L9;
        r0.append(", referrer=").append(this.referrer);
    L9:
        if (this.targetUrl == null) goto L12;
        r0.append(", targetUrl=").append(this.targetUrl);
    L12:
        return r0.replace(0, 2, "StartPicoLinksRequest{").append('}').toString();
    }
}
