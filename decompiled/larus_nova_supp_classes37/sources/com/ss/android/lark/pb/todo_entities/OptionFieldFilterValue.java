package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OptionFieldFilterValue extends Message<OptionFieldFilterValue, Builder> {
    public static final ProtoAdapter<OptionFieldFilterValue> ADAPTER = null;
    public static final String DEFAULT_OPTION_GUID = "";
    private static final long serialVersionUID = 0;
    public final String moption_guid;

    public static final class Builder extends Message.Builder<OptionFieldFilterValue, Builder> {
        public String moption_guid;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public OptionFieldFilterValue m2318build() {
            return new OptionFieldFilterValue(this.moption_guid, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2318build();
        }

        public Builder option_guid(String r1) {
            this.moption_guid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_OptionFieldFilterValue extends ProtoAdapter<OptionFieldFilterValue> {
        public ProtoAdapter_OptionFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, OptionFieldFilterValue.class);
        }

        public OptionFieldFilterValue decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.moption_guid = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.moption_guid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2318build();
        }

        public int encodedSize(OptionFieldFilterValue r4) {
            String r0 = r4.moption_guid;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2319decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((OptionFieldFilterValue) r1);
        }

        public void encode(ProtoWriter r4, OptionFieldFilterValue r5) throws IOException {
            String r0 = r5.moption_guid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (OptionFieldFilterValue) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OptionFieldFilterValue();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2317newBuilder() {
        Builder r0 = new Builder();
        r0.moption_guid = this.moption_guid;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return OptionFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2317newBuilder();
    }

    public OptionFieldFilterValue(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public OptionFieldFilterValue(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.moption_guid = r2;
    }
}
