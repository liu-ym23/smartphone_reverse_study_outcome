package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NumberFieldFilterValue extends Message<NumberFieldFilterValue, Builder> {
    public static final ProtoAdapter<NumberFieldFilterValue> ADAPTER = null;
    public static final String DEFAULT_NUM_STR = "";
    private static final long serialVersionUID = 0;
    public final String mnum_str;

    public static final class Builder extends Message.Builder<NumberFieldFilterValue, Builder> {
        public String mnum_str;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public NumberFieldFilterValue m2312build() {
            return new NumberFieldFilterValue(this.mnum_str, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2312build();
        }

        public Builder num_str(String r1) {
            this.mnum_str = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_NumberFieldFilterValue extends ProtoAdapter<NumberFieldFilterValue> {
        public ProtoAdapter_NumberFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, NumberFieldFilterValue.class);
        }

        public NumberFieldFilterValue decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mnum_str = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mnum_str = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2312build();
        }

        public int encodedSize(NumberFieldFilterValue r4) {
            String r0 = r4.mnum_str;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2313decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((NumberFieldFilterValue) r1);
        }

        public void encode(ProtoWriter r4, NumberFieldFilterValue r5) throws IOException {
            String r0 = r5.mnum_str;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (NumberFieldFilterValue) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NumberFieldFilterValue();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2311newBuilder() {
        Builder r0 = new Builder();
        r0.mnum_str = this.mnum_str;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return NumberFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2311newBuilder();
    }

    public NumberFieldFilterValue(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public NumberFieldFilterValue(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mnum_str = r2;
    }
}
