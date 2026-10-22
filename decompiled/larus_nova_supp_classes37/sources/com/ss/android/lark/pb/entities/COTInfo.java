package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class COTInfo extends com.squareup.wire.Message<COTInfo, Builder> {
    public static final ProtoAdapter<COTInfo> ADAPTER = null;
    public static final Boolean DEFAULT_COT_HIDDEN_AFTER_DONE = null;
    public static final Long DEFAULT_COT_ID = null;
    public static final Boolean DEFAULT_VIOLATED = null;
    private static final long serialVersionUID = 0;
    public final Boolean mcot_hidden_after_done;
    public final Long mcot_id;
    public final COTStatus mcot_status;
    public final Boolean mviolated;

    public static final class Builder extends com.squareup.wire.Message.Builder<COTInfo, Builder> {
        public Boolean mcot_hidden_after_done;
        public Long mcot_id;
        public COTStatus mcot_status;
        public Boolean mviolated;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public COTInfo m1037build() {
            return new COTInfo(this.mcot_id, this.mcot_status, this.mviolated, this.mcot_hidden_after_done, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1037build();
        }

        public Builder cot_hidden_after_done(Boolean r1) {
            this.mcot_hidden_after_done = r1;
            return this;
        }

        public Builder cot_id(Long r1) {
            this.mcot_id = r1;
            return this;
        }

        public Builder cot_status(COTStatus r1) {
            this.mcot_status = r1;
            return this;
        }

        public Builder violated(Boolean r1) {
            this.mviolated = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_COTInfo extends ProtoAdapter<COTInfo> {
        public ProtoAdapter_COTInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, COTInfo.class);
        }

        public COTInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mcot_id = 0L;
            Boolean r1 = Boolean.FALSE;
            r0.mviolated = r1;
            r0.mcot_hidden_after_done = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mcot_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcot_status = (COTStatus) COTStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mviolated = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mcot_hidden_after_done = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r2);
            return r0.m1037build();
        }

        public int encodedSize(COTInfo r6) {
            Long r0 = r6.mcot_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            COTStatus r3 = r6.mcot_status;
            if (r3 == null) goto L9;
            int r4 = COTStatus.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mviolated;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mcot_hidden_after_done;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1038decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((COTInfo) r1);
        }

        public void encode(ProtoWriter r4, COTInfo r5) throws IOException {
            Long r0 = r5.mcot_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            COTStatus r1 = r5.mcot_status;
            if (r1 == null) goto L8;
            COTStatus.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mviolated;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.mcot_hidden_after_done;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (COTInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_COTInfo();
        DEFAULT_COT_ID = 0L;
        Boolean r0 = Boolean.FALSE;
        DEFAULT_VIOLATED = r0;
        DEFAULT_COT_HIDDEN_AFTER_DONE = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1036newBuilder() {
        Builder r0 = new Builder();
        r0.mcot_id = this.mcot_id;
        r0.mcot_status = this.mcot_status;
        r0.mviolated = this.mviolated;
        r0.mcot_hidden_after_done = this.mcot_hidden_after_done;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return COTInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1036newBuilder();
    }

    public COTInfo(Long r7, COTStatus r8, Boolean r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public COTInfo(Long r2, COTStatus r3, Boolean r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mcot_id = r2;
        this.mcot_status = r3;
        this.mviolated = r4;
        this.mcot_hidden_after_done = r5;
    }
}
