package com.ss.android.lark.pb.ai_engine;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FeedsbackRequest extends Message<FeedsbackRequest, Builder> {
    public static final ProtoAdapter<FeedsbackRequest> ADAPTER = null;
    public static final String DEFAULT_AI_MESSAGE_ID = "";
    public static final String DEFAULT_ANS_MESSAGE_ID = "";
    public static final String DEFAULT_ANS_MESSAGE_RAWDATA = "";
    public static final String DEFAULT_QUERY_MESSAGE_ID = "";
    public static final String DEFAULT_QUERY_MESSAGE_RAWDATA = "";
    public static final String DEFAULT_SCENARIO = "";
    private static final long serialVersionUID = 0;
    public final String mai_message_id;
    public final String mans_message_id;
    public final String mans_message_rawdata;
    public final FeedsbackData mdata;
    public final WorkMode mmode;
    public final String mquery_message_id;
    public final String mquery_message_rawdata;
    public final String mscenario;

    public static final class Builder extends Message.Builder<FeedsbackRequest, Builder> {
        public String mai_message_id;
        public String mans_message_id;
        public String mans_message_rawdata;
        public FeedsbackData mdata;
        public WorkMode mmode;
        public String mquery_message_id;
        public String mquery_message_rawdata;
        public String mscenario;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FeedsbackRequest m785build() {
            return new FeedsbackRequest(this.mai_message_id, this.mquery_message_id, this.mans_message_id, this.mquery_message_rawdata, this.mans_message_rawdata, this.mdata, this.mmode, this.mscenario, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m785build();
        }

        public Builder ai_message_id(String r1) {
            this.mai_message_id = r1;
            return this;
        }

        public Builder ans_message_id(String r1) {
            this.mans_message_id = r1;
            return this;
        }

        public Builder ans_message_rawdata(String r1) {
            this.mans_message_rawdata = r1;
            return this;
        }

        public Builder data(FeedsbackData r1) {
            this.mdata = r1;
            return this;
        }

        public Builder mode(WorkMode r1) {
            this.mmode = r1;
            return this;
        }

        public Builder query_message_id(String r1) {
            this.mquery_message_id = r1;
            return this;
        }

        public Builder query_message_rawdata(String r1) {
            this.mquery_message_rawdata = r1;
            return this;
        }

        public Builder scenario(String r1) {
            this.mscenario = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedsbackRequest extends ProtoAdapter<FeedsbackRequest> {
        public ProtoAdapter_FeedsbackRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedsbackRequest.class);
        }

        public FeedsbackRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mai_message_id = "";
            r0.mquery_message_id = "";
            r0.mans_message_id = "";
            r0.mquery_message_rawdata = "";
            r0.mans_message_rawdata = "";
            r0.mscenario = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            switch(r3) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L20;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r0.mmode = (WorkMode) WorkMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mscenario = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.mdata = (FeedsbackData) FeedsbackData.ADAPTER.decode(r9);
            goto L3
        L13:
            r0.mans_message_rawdata = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mquery_message_rawdata = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mans_message_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mquery_message_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L17:
            r0.mai_message_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m785build();
        }

        public int encodedSize(FeedsbackRequest r6) {
            String r0 = r6.mai_message_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mquery_message_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mans_message_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mquery_message_rawdata;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mans_message_rawdata;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            FeedsbackData r16 = r6.mdata;
            if (r16 == null) goto L25;
            int r17 = FeedsbackData.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            WorkMode r19 = r6.mmode;
            if (r19 == null) goto L29;
            int r20 = WorkMode.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mscenario;
            if (r22 == null) goto L34;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            return (r21 + r1) + r6.unknownFields().size();
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ Object m786decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FeedsbackRequest) r1);
        }

        public void encode(ProtoWriter r4, FeedsbackRequest r5) throws IOException {
            String r0 = r5.mai_message_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mquery_message_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mans_message_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mquery_message_rawdata;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mans_message_rawdata;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            FeedsbackData r7 = r5.mdata;
            if (r7 == null) goto L20;
            FeedsbackData.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            WorkMode r8 = r5.mmode;
            if (r8 == null) goto L23;
            WorkMode.ADAPTER.encodeWithTag(r4, 7, r8);
        L23:
            String r9 = r5.mscenario;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
        L26:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FeedsbackRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedsbackRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m784newBuilder() {
        Builder r0 = new Builder();
        r0.mai_message_id = this.mai_message_id;
        r0.mquery_message_id = this.mquery_message_id;
        r0.mans_message_id = this.mans_message_id;
        r0.mquery_message_rawdata = this.mquery_message_rawdata;
        r0.mans_message_rawdata = this.mans_message_rawdata;
        r0.mdata = this.mdata;
        r0.mmode = this.mmode;
        r0.mscenario = this.mscenario;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FeedsbackRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m784newBuilder();
    }

    public FeedsbackRequest(String r11, String r12, String r13, String r14, String r15, FeedsbackData r16, WorkMode r17, String r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
    }

    public FeedsbackRequest(String r2, String r3, String r4, String r5, String r6, FeedsbackData r7, WorkMode r8, String r9, ByteString r10) {
        super(ADAPTER, r10);
        this.mai_message_id = r2;
        this.mquery_message_id = r3;
        this.mans_message_id = r4;
        this.mquery_message_rawdata = r5;
        this.mans_message_rawdata = r6;
        this.mdata = r7;
        this.mmode = r8;
        this.mscenario = r9;
    }
}
