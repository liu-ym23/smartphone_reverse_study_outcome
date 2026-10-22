package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
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

/* JADX INFO: loaded from: classes3.dex */
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

        public Builder() {
            this.scene = SCENE.BROWSER;
            this.referrer = "";
            this.targetUrl = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder referrer(String r5) {
            this.referrer = r5;
            return this;
        }

        public Builder scene(SCENE r5) {
            this.scene = r5;
            return this;
        }

        public Builder targetUrl(String r5) {
            this.targetUrl = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public StartPicoLinksRequest build() {
            return new StartPicoLinksRequest(this.scene, this.referrer, this.targetUrl, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_StartPicoLinksRequest extends ProtoAdapter<StartPicoLinksRequest> {
        public ProtoAdapter_StartPicoLinksRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksRequest decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, StartPicoLinksRequest r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StartPicoLinksRequest r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksRequest redact(StartPicoLinksRequest r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StartPicoLinksRequest decode(ProtoReader r10) throws IOException {
            Builder r11 = new Builder();
            long r5 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L18;
            if (r12 != 1) goto L8;
            r11.scene(SCENE.ADAPTER.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r11.addUnknownField(r12, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r11.referrer(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            if (r12 != 3) goto L11;
            r11.targetUrl(ProtoAdapter.STRING.decode(r10));
            goto L3
        L11:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r11.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r5);
            return r11.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, StartPicoLinksRequest r10) throws IOException {
            SCENE.ADAPTER.encodeWithTag(r5, 1, r10.scene);
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            r11.encodeWithTag(r5, 2, r10.referrer);
            r11.encodeWithTag(r5, 3, r10.targetUrl);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(StartPicoLinksRequest r5) {
            int r10 = SCENE.ADAPTER.encodedSizeWithTag(1, r5.scene);
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            int r12 = r11.encodedSizeWithTag(2, r5.referrer) + r10;
            int r13 = r11.encodedSizeWithTag(3, r5.targetUrl) + r12;
            return r5.unknownFields().size() + r13;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public StartPicoLinksRequest redact2(StartPicoLinksRequest r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
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

            @Override // com.squareup.wire.EnumAdapter
            public /* bridge */ /* synthetic */ WireEnum fromValue(int r5) {
                return fromValue(r5);
            }

            @Override // com.squareup.wire.EnumAdapter
            public SCENE fromValue(int r5) {
                return SCENE.fromValue(r5);
            }
        }

        static {
            SCENE r5 = new SCENE("BROWSER", 0, 0);
            BROWSER = r5;
            SCENE r10 = new SCENE("WEB_VIEW", 1, 1);
            WEB_VIEW = r10;
            SCENE r11 = new SCENE("NATIVE_APP", 2, 2);
            NATIVE_APP = r11;
            SCENE r12 = new SCENE("SYSTEM", 3, 3);
            SYSTEM = r12;
            $VALUES = new SCENE[]{r5, r10, r11, r12};
            ADAPTER = new ProtoAdapter_SCENE();
        }

        private SCENE(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static SCENE fromValue(int r5) {
            if (r5 == 0) goto L18;
            if (r5 == 1) goto L16;
            if (r5 == 2) goto L14;
            if (r5 == 3) goto L12;
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

        public static SCENE valueOf(String r5) {
            return (SCENE) Enum.valueOf(SCENE.class, r5);
        }

        public static SCENE[] values() {
            return (SCENE[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StartPicoLinksRequest();
        DEFAULT_SCENE = SCENE.BROWSER;
    }

    public StartPicoLinksRequest(SCENE r5, String r10, String r11) {
        this(r5, r10, r11, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof StartPicoLinksRequest) == true) goto L8;
        return false;
    L8:
        StartPicoLinksRequest r10 = (StartPicoLinksRequest) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L18;
        if (Internal.equals(this.scene, r10.scene) == false) goto L18;
        if (Internal.equals(this.referrer, r10.referrer) == false) goto L18;
        if (Internal.equals(this.targetUrl, r10.targetUrl) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L17;
        int r10 = unknownFields().hashCode() * 37;
        SCENE r11 = this.scene;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this.referrer;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.targetUrl;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        int r19 = r17 + r12;
        this.hashCode = r19;
        return r19;
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L17:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.scene == null) goto L6;
        r5.append(", scene=");
        r5.append(this.scene);
    L6:
        if (this.referrer == null) goto L9;
        r5.append(", referrer=");
        r5.append(this.referrer);
    L9:
        if (this.targetUrl == null) goto L12;
        r5.append(", targetUrl=");
        r5.append(this.targetUrl);
    L12:
        return a.s(r5, 0, 2, "StartPicoLinksRequest{", '}');
    }

    public StartPicoLinksRequest(SCENE r5, String r10, String r11, ByteString r12) {
        super(ADAPTER, r12);
        this.scene = r5;
        this.referrer = r10;
        this.targetUrl = r11;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.scene = this.scene;
        r5.referrer = this.referrer;
        r5.targetUrl = this.targetUrl;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
