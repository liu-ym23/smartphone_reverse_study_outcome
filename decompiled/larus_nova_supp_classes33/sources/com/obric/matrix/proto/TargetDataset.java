package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TargetDataset extends Message<TargetDataset, Builder> {
    public static final ProtoAdapter<TargetDataset> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    public static final String DEFAULT_APPKEY = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String appid;

    @SerializedName("appkey")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String appkey;

    @SerializedName("name")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @SerializedName("properties")
    @WireField(adapter = "com.obric.matrix.proto.NullableMap#ADAPTER", tag = 4)
    public final NullableMap properties;

    public static final class Builder extends Message.Builder<TargetDataset, Builder> {
        public String appid;
        public String appkey;
        public String name;
        public NullableMap properties;

        public TargetDataset build() {
            return new TargetDataset(this.name, this.appid, this.appkey, this.properties, super.buildUnknownFields());
        }

        public Builder() {
            this.name = "";
            this.appid = "";
            this.appkey = "";
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m227build() {
            return build();
        }

        public Builder appid(String r1) {
            this.appid = r1;
            return this;
        }

        public Builder appkey(String r1) {
            this.appkey = r1;
            return this;
        }

        public Builder name(String r1) {
            this.name = r1;
            return this;
        }

        public Builder properties(NullableMap r1) {
            this.properties = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TargetDataset extends ProtoAdapter<TargetDataset> {
        public ProtoAdapter_TargetDataset() {
            super(FieldEncoding.LENGTH_DELIMITED, TargetDataset.class);
        }

        public TargetDataset decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.name((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.appid((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.appkey((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.properties((NullableMap) NullableMap.ADAPTER.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(TargetDataset r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (((r0.encodedSizeWithTag(1, r5.name) + r0.encodedSizeWithTag(2, r5.appid)) + r0.encodedSizeWithTag(3, r5.appkey)) + NullableMap.ADAPTER.encodedSizeWithTag(4, r5.properties)) + r5.unknownFields().size();
        }

        public TargetDataset redact(TargetDataset r3) {
            Builder r4 = r3.newBuilder();
            NullableMap r0 = r4.properties;
            if (r0 == null) goto L5;
            r4.properties = (NullableMap) NullableMap.ADAPTER.redact(r0);
        L5:
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m228decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TargetDataset) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((TargetDataset) r1);
        }

        public void encode(ProtoWriter r4, TargetDataset r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.name);
            r0.encodeWithTag(r4, 2, r5.appid);
            r0.encodeWithTag(r4, 3, r5.appkey);
            NullableMap.ADAPTER.encodeWithTag(r4, 4, r5.properties);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TargetDataset) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TargetDataset();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.name;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.appid;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.appkey;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        NullableMap r12 = this.properties;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        ((Message) this).hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.name = this.name;
        r0.appid = this.appid;
        r0.appkey = this.appkey;
        r0.properties = this.properties;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.name == null) goto L6;
        r0.append(", name=");
        r0.append(this.name);
    L6:
        if (this.appid == null) goto L9;
        r0.append(", appid=");
        r0.append(this.appid);
    L9:
        if (this.appkey == null) goto L12;
        r0.append(", appkey=");
        r0.append(this.appkey);
    L12:
        if (this.properties == null) goto L14;
        r0.append(", properties=");
        r0.append(this.properties);
    L14:
        StringBuilder r1 = r0.replace(0, 2, "TargetDataset{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m226newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof TargetDataset) == true) goto L8;
        return false;
    L8:
        TargetDataset r6 = (TargetDataset) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.name, r6.name) == false) goto L19;
        if (Internal.equals(this.appid, r6.appid) == false) goto L19;
        if (Internal.equals(this.appkey, r6.appkey) == false) goto L19;
        if (Internal.equals(this.properties, r6.properties) == false) goto L19;
        return true;
    }

    public TargetDataset(String r7, String r8, String r9, NullableMap r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public TargetDataset(String r2, String r3, String r4, NullableMap r5, ByteString r6) {
        super(ADAPTER, r6);
        this.name = r2;
        this.appid = r3;
        this.appkey = r4;
        this.properties = r5;
    }
}
