package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RenderItem extends Message<RenderItem, Builder> {
    public static final ProtoAdapter<RenderItem> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    public final String mKey;
    public final RenderTypeValue mRenderTypeValue;
    public final String mValue;

    public static final class Builder extends Message.Builder<RenderItem, Builder> {
        public String mKey;
        public RenderTypeValue mRenderTypeValue;
        public String mValue;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public RenderItem m2198build() {
            return new RenderItem(this.mKey, this.mValue, this.mRenderTypeValue, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2198build();
        }

        public Builder Key(String r1) {
            this.mKey = r1;
            return this;
        }

        public Builder RenderTypeValue(RenderTypeValue r1) {
            this.mRenderTypeValue = r1;
            return this;
        }

        public Builder Value(String r1) {
            this.mValue = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RenderItem extends ProtoAdapter<RenderItem> {
        public ProtoAdapter_RenderItem() {
            super(FieldEncoding.LENGTH_DELIMITED, RenderItem.class);
        }

        public RenderItem decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mKey = "";
            r0.mValue = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mKey = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mValue = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mRenderTypeValue = (RenderTypeValue) RenderTypeValue.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2198build();
        }

        public int encodedSize(RenderItem r6) {
            String r0 = r6.mKey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mValue;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            RenderTypeValue r7 = r6.mRenderTypeValue;
            if (r7 == null) goto L14;
            r1 = RenderTypeValue.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2199decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RenderItem) r1);
        }

        public void encode(ProtoWriter r4, RenderItem r5) throws IOException {
            String r0 = r5.mKey;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mValue;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            RenderTypeValue r2 = r5.mRenderTypeValue;
            if (r2 == null) goto L11;
            RenderTypeValue.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RenderItem) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RenderItem();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2197newBuilder() {
        Builder r0 = new Builder();
        r0.mKey = this.mKey;
        r0.mValue = this.mValue;
        r0.mRenderTypeValue = this.mRenderTypeValue;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return RenderItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2197newBuilder();
    }

    public RenderItem(String r2, String r3, RenderTypeValue r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public RenderItem(String r2, String r3, RenderTypeValue r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mKey = r2;
        this.mValue = r3;
        this.mRenderTypeValue = r4;
    }
}
