package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class StartPicoLinksRequest extends Message<StartPicoLinksRequest, Builder> {
    public static final ProtoAdapter<StartPicoLinksRequest> ADAPTER = null;
    public static final String DEFAULT_REFERRER = "";
    public static final SCENE DEFAULT_SCENE = null;
    public static final String DEFAULT_TARGETURL = "";
    private static final long serialVersionUID = 0;

    @SerializedName("referrer")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String referrer;

    @SerializedName("scene")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest$SCENE#ADAPTER", tag = 1)
    public final SCENE scene;

    @SerializedName("targetUrl")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String targetUrl;

    public static final class Builder extends Message.Builder<StartPicoLinksRequest, Builder> {
        public String referrer;
        public SCENE scene;
        public String targetUrl;

        public StartPicoLinksRequest build() {
            return new StartPicoLinksRequest(this.scene, this.referrer, this.targetUrl, super.buildUnknownFields());
        }

        public Builder() {
            this.scene = SCENE.BROWSER;
            this.referrer = "";
            this.targetUrl = "";
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m185build() {
            return build();
        }

        public Builder referrer(String r1) {
            this.referrer = r1;
            return this;
        }

        public Builder scene(SCENE r1) {
            this.scene = r1;
            return this;
        }

        public Builder targetUrl(String r1) {
            this.targetUrl = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_StartPicoLinksRequest extends ProtoAdapter<StartPicoLinksRequest> {
        public ProtoAdapter_StartPicoLinksRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksRequest.class);
        }

        public StartPicoLinksRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.scene((SCENE) SCENE.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.referrer((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.targetUrl((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(StartPicoLinksRequest r5) {
            int r0 = SCENE.ADAPTER.encodedSizeWithTag(1, r5.scene);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            return ((r0 + r1.encodedSizeWithTag(2, r5.referrer)) + r1.encodedSizeWithTag(3, r5.targetUrl)) + r5.unknownFields().size();
        }

        public StartPicoLinksRequest redact(StartPicoLinksRequest r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m186decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((StartPicoLinksRequest) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((StartPicoLinksRequest) r1);
        }

        public void encode(ProtoWriter r4, StartPicoLinksRequest r5) throws IOException {
            SCENE.ADAPTER.encodeWithTag(r4, 1, r5.scene);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 2, r5.referrer);
            r0.encodeWithTag(r4, 3, r5.targetUrl);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (StartPicoLinksRequest) r2);
        }
    }

    public static final enum SCENE extends Enum<SCENE> implements WireEnum {
        private static final /* synthetic */ SCENE[] $VALUES = null;
        public static final ProtoAdapter<SCENE> ADAPTER = null;
        public static final SCENE BROWSER = null;
        public static final SCENE NATIVE_APP = null;
        public static final SCENE SYSTEM = null;
        public static final SCENE WEB_VIEW = null;
        private final int value;

        public static final class ProtoAdapter_SCENE extends EnumAdapter<SCENE> {
            public ProtoAdapter_SCENE() {
                super(SCENE.class);
            }

            public SCENE fromValue(int r1) {
                return SCENE.fromValue(r1);
            }

            /* JADX INFO: renamed from: fromValue, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ WireEnum m187fromValue(int r1) {
                return fromValue(r1);
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
            ADAPTER = new ProtoAdapter_SCENE();
        }

        public static SCENE[] values() {
            return (SCENE[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
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

        public static SCENE valueOf(String r1) {
            return (SCENE) a.a(SCENE.class, r1);
        }

        private SCENE(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StartPicoLinksRequest();
        DEFAULT_SCENE = SCENE.BROWSER;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
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
        ((Message) this).hashCode = r10;
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

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.scene = this.scene;
        r0.referrer = this.referrer;
        r0.targetUrl = this.targetUrl;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.scene == null) goto L6;
        r0.append(", scene=");
        r0.append(this.scene);
    L6:
        if (this.referrer == null) goto L9;
        r0.append(", referrer=");
        r0.append(this.referrer);
    L9:
        if (this.targetUrl == null) goto L11;
        r0.append(", targetUrl=");
        r0.append(this.targetUrl);
    L11:
        StringBuilder r1 = r0.replace(0, 2, "StartPicoLinksRequest{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m184newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof StartPicoLinksRequest) == true) goto L8;
        return false;
    L8:
        StartPicoLinksRequest r6 = (StartPicoLinksRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (Internal.equals(this.scene, r6.scene) == false) goto L17;
        if (Internal.equals(this.referrer, r6.referrer) == false) goto L17;
        if (Internal.equals(this.targetUrl, r6.targetUrl) == false) goto L17;
        return true;
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
}
