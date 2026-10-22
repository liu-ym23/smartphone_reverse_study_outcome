package com.obric.matrix.proto;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class StartPicoLinksRequest extends Message<StartPicoLinksRequest, a> {
    public static final ProtoAdapter<StartPicoLinksRequest> ADAPTER = null;
    public static final String DEFAULT_REFERRER = "";
    public static final SCENE DEFAULT_SCENE = null;
    public static final String DEFAULT_TARGETURL = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @c("referrer")
    public final String referrer;

    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest$SCENE#ADAPTER", tag = 1)
    @c("scene")
    public final SCENE scene;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @c("targetUrl")
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

            protected SCENE a(int r10) {
                return SCENE.fromValue(r10);
            }

            @Override // com.squareup.wire.EnumAdapter
            protected /* bridge */ /* synthetic */ WireEnum fromValue(int r10) {
                return a(r10);
            }
        }

        static {
            SCENE r10 = new SCENE("BROWSER", 0, 0);
            BROWSER = r10;
            SCENE r11 = new SCENE("WEB_VIEW", 1, 1);
            WEB_VIEW = r11;
            SCENE r12 = new SCENE("NATIVE_APP", 2, 2);
            NATIVE_APP = r12;
            SCENE r13 = new SCENE("SYSTEM", 3, 3);
            SYSTEM = r13;
            $VALUES = new SCENE[]{r10, r11, r12, r13};
            ADAPTER = new a();
        }

        private SCENE(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static SCENE fromValue(int r10) {
            if (r10 == 0) goto L18;
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L12;
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

        public static SCENE valueOf(String r10) {
            return (SCENE) Enum.valueOf(SCENE.class, r10);
        }

        public static SCENE[] values() {
            return (SCENE[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    public static final class a extends Message.Builder<StartPicoLinksRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SCENE f6097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6099c;

        public a() {
            this.f6097a = SCENE.BROWSER;
            this.f6098b = "";
            this.f6099c = "";
        }

        public StartPicoLinksRequest a() {
            return new StartPicoLinksRequest(this.f6097a, this.f6098b, this.f6099c, super.buildUnknownFields());
        }

        public a b(String r10) {
            this.f6098b = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(SCENE r10) {
            this.f6097a = r10;
            return this;
        }

        public a d(String r10) {
            this.f6099c = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<StartPicoLinksRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksRequest.class);
        }

        public StartPicoLinksRequest a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L18;
            if (r13 != 1) goto L8;
            r11.c(SCENE.ADAPTER.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r11.addUnknownField(r13, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r13 != 2) goto L10;
            r11.b(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            if (r13 != 3) goto L11;
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L11:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, StartPicoLinksRequest r11) {
            SCENE.ADAPTER.encodeWithTag(r10, 1, r11.scene);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r10, 2, r11.referrer);
            r12.encodeWithTag(r10, 3, r11.targetUrl);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(StartPicoLinksRequest r10) {
            int r11 = SCENE.ADAPTER.encodedSizeWithTag(1, r10.scene);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            return ((r11 + r12.encodedSizeWithTag(2, r10.referrer)) + r12.encodedSizeWithTag(3, r10.targetUrl)) + r10.unknownFields().size();
        }

        public StartPicoLinksRequest d(StartPicoLinksRequest r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksRequest decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, StartPicoLinksRequest r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StartPicoLinksRequest r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksRequest redact(StartPicoLinksRequest r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SCENE = SCENE.BROWSER;
    }

    public StartPicoLinksRequest(SCENE r10, String r11, String r12) {
        this(r10, r11, r12, ByteString.EMPTY);
    }

    public StartPicoLinksRequest(SCENE r10, String r11, String r12, ByteString r13) {
        super(ADAPTER, r13);
        this.scene = r10;
        this.referrer = r11;
        this.targetUrl = r12;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof StartPicoLinksRequest) == true) goto L8;
        return false;
    L8:
        StartPicoLinksRequest r11 = (StartPicoLinksRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L18;
        if (Internal.equals(this.scene, r11.scene) == false) goto L18;
        if (Internal.equals(this.referrer, r11.referrer) == false) goto L18;
        if (Internal.equals(this.targetUrl, r11.targetUrl) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L17;
        int r11 = unknownFields().hashCode() * 37;
        SCENE r12 = this.scene;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        String r16 = this.referrer;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        String r19 = this.targetUrl;
        if (r19 == null) goto L15;
        r13 = r19.hashCode();
    L15:
        int r20 = r18 + r13;
        this.hashCode = r20;
        return r20;
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L17:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6097a = this.scene;
        r10.f6098b = this.referrer;
        r10.f6099c = this.targetUrl;
        r10.addUnknownFields(unknownFields());
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.scene == null) goto L6;
        r10.append(", scene=");
        r10.append(this.scene);
    L6:
        if (this.referrer == null) goto L9;
        r10.append(", referrer=");
        r10.append(this.referrer);
    L9:
        if (this.targetUrl == null) goto L11;
        r10.append(", targetUrl=");
        r10.append(this.targetUrl);
    L11:
        StringBuilder r11 = r10.replace(0, 2, "StartPicoLinksRequest{");
        r11.append('}');
        return r11.toString();
    }
}
