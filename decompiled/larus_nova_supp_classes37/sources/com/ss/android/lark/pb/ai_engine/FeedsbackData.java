package com.ss.android.lark.pb.ai_engine;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FeedsbackData extends Message<FeedsbackData, Builder> {
    public static final ProtoAdapter<FeedsbackData> ADAPTER = null;
    public static final String DEFAULT_EXTRA = "";
    public static final Boolean DEFAULT_LIKE = null;
    private static final long serialVersionUID = 0;
    public final String mextra;
    public final Boolean mlike;
    public final List<String> mreason_id;

    public static final class Builder extends Message.Builder<FeedsbackData, Builder> {
        public String mextra;
        public Boolean mlike;
        public List<String> mreason_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FeedsbackData m782build() {
            return new FeedsbackData(this.mlike, this.mreason_id, this.mextra, super.buildUnknownFields());
        }

        public Builder() {
            this.mreason_id = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m782build();
        }

        public Builder extra(String r1) {
            this.mextra = r1;
            return this;
        }

        public Builder like(Boolean r1) {
            this.mlike = r1;
            return this;
        }

        public Builder reason_id(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mreason_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedsbackData extends ProtoAdapter<FeedsbackData> {
        public ProtoAdapter_FeedsbackData() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedsbackData.class);
        }

        public FeedsbackData decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mlike = Boolean.FALSE;
            r0.mextra = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mlike = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mreason_id.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mextra = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m782build();
        }

        public int encodedSize(FeedsbackData r7) {
            Boolean r0 = r7.mlike;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            ProtoAdapter r3 = ProtoAdapter.STRING;
            int r4 = r2 + r3.asRepeated().encodedSizeWithTag(2, r7.mreason_id);
            String r5 = r7.mextra;
            if (r5 == null) goto L10;
            r1 = r3.encodedSizeWithTag(3, r5);
        L10:
            return (r4 + r1) + r7.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m783decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FeedsbackData) r1);
        }

        public void encode(ProtoWriter r5, FeedsbackData r6) throws IOException {
            Boolean r0 = r6.mlike;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r0);
        L5:
            ProtoAdapter r1 = ProtoAdapter.STRING;
            r1.asRepeated().encodeWithTag(r5, 2, r6.mreason_id);
            String r2 = r6.mextra;
            if (r2 == null) goto L8;
            r1.encodeWithTag(r5, 3, r2);
        L8:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FeedsbackData) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedsbackData();
        DEFAULT_LIKE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m781newBuilder() {
        Builder r0 = new Builder();
        r0.mlike = this.mlike;
        r0.mreason_id = Internal.copyOf("mreason_id", this.mreason_id);
        r0.mextra = this.mextra;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FeedsbackData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m781newBuilder();
    }

    public FeedsbackData(Boolean r2, List<String> r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public FeedsbackData(Boolean r2, List<String> r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mlike = r2;
        this.mreason_id = Internal.immutableCopyOf("mreason_id", r3);
        this.mextra = r4;
    }
}
