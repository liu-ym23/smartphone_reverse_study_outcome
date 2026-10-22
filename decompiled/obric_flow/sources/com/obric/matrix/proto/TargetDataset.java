package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
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

/* JADX INFO: loaded from: classes3.dex */
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

        public Builder() {
            this.name = "";
            this.appid = "";
            this.appkey = "";
        }

        public Builder appid(String r5) {
            this.appid = r5;
            return this;
        }

        public Builder appkey(String r5) {
            this.appkey = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder name(String r5) {
            this.name = r5;
            return this;
        }

        public Builder properties(NullableMap r5) {
            this.properties = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public TargetDataset build() {
            return new TargetDataset(this.name, this.appid, this.appkey, this.properties, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_TargetDataset extends ProtoAdapter<TargetDataset> {
        public ProtoAdapter_TargetDataset() {
            super(FieldEncoding.LENGTH_DELIMITED, TargetDataset.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TargetDataset decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, TargetDataset r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TargetDataset r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TargetDataset redact(TargetDataset r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TargetDataset decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L18;
            if (r12 != 1) goto L8;
            r5.name(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r5.appid(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            if (r12 != 3) goto L12;
            r5.appkey(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            if (r12 != 4) goto L13;
            r5.properties(NullableMap.ADAPTER.decode(r10));
            goto L3
        L13:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, TargetDataset r10) throws IOException {
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            r11.encodeWithTag(r5, 1, r10.name);
            r11.encodeWithTag(r5, 2, r10.appid);
            r11.encodeWithTag(r5, 3, r10.appkey);
            NullableMap.ADAPTER.encodeWithTag(r5, 4, r10.properties);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TargetDataset r5) {
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            int r11 = r10.encodedSizeWithTag(1, r5.name);
            int r12 = r10.encodedSizeWithTag(2, r5.appid) + r11;
            int r13 = r10.encodedSizeWithTag(3, r5.appkey) + r12;
            int r14 = NullableMap.ADAPTER.encodedSizeWithTag(4, r5.properties) + r13;
            return r5.unknownFields().size() + r14;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public TargetDataset redact2(TargetDataset r5) {
            Builder r10 = r5.newBuilder();
            NullableMap r11 = r10.properties;
            if (r11 == null) goto L5;
            r10.properties = NullableMap.ADAPTER.redact(r11);
        L5:
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TargetDataset();
    }

    public TargetDataset(String r10, String r11, String r12, NullableMap r13) {
        this(r10, r11, r12, r13, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof TargetDataset) == true) goto L8;
        return false;
    L8:
        TargetDataset r10 = (TargetDataset) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L20;
        if (Internal.equals(this.name, r10.name) == false) goto L20;
        if (Internal.equals(this.appid, r10.appid) == false) goto L20;
        if (Internal.equals(this.appkey, r10.appkey) == false) goto L20;
        if (Internal.equals(this.properties, r10.properties) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L21;
        int r10 = unknownFields().hashCode() * 37;
        String r11 = this.name;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this.appid;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.appkey;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        NullableMap r21 = this.properties;
        if (r21 == null) goto L19;
        r12 = r21.hashCode();
    L19:
        int r22 = r20 + r12;
        this.hashCode = r22;
        return r22;
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L21:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.name == null) goto L6;
        r5.append(", name=");
        r5.append(this.name);
    L6:
        if (this.appid == null) goto L9;
        r5.append(", appid=");
        r5.append(this.appid);
    L9:
        if (this.appkey == null) goto L12;
        r5.append(", appkey=");
        r5.append(this.appkey);
    L12:
        if (this.properties == null) goto L15;
        r5.append(", properties=");
        r5.append(this.properties);
    L15:
        return a.s(r5, 0, 2, "TargetDataset{", '}');
    }

    public TargetDataset(String r5, String r10, String r11, NullableMap r12, ByteString r13) {
        super(ADAPTER, r13);
        this.name = r5;
        this.appid = r10;
        this.appkey = r11;
        this.properties = r12;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.name = this.name;
        r5.appid = this.appid;
        r5.appkey = this.appkey;
        r5.properties = this.properties;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
