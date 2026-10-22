package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AIViewBlockData extends Message<AIViewBlockData, Builder> {
    public static final ProtoAdapter<AIViewBlockData> ADAPTER = null;
    public static final String DEFAULT_AI_VIEW_ID = "";
    public static final String DEFAULT_BLOCK_DATA = "";
    public static final Long DEFAULT_END_TIME = null;
    public static final String DEFAULT_LOCALE = "";
    public static final String DEFAULT_LOCATION = "";
    public static final String DEFAULT_MINUTES_TOKEN = "";
    public static final Long DEFAULT_START_TIME = null;
    public static final String DEFAULT_TOPIC = "";
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final String mai_view_id;
    public final AIViewSource mai_view_source;
    public final String mblock_data;
    public final Long mend_time;
    public final String mlocale;
    public final String mlocation;
    public final String mminutes_token;
    public final Long mstart_time;
    public final String mtopic;
    public final Long muser_id;

    public static final enum AIViewSource extends Enum<AIViewSource> implements WireEnum {
        private static final /* synthetic */ AIViewSource[] $VALUES = null;
        public static final ProtoAdapter<AIViewSource> ADAPTER = null;
        public static final AIViewSource MEETING = null;
        public static final AIViewSource MINUTES = null;
        public static final AIViewSource UNKNOWN = null;
        private final int value;

        static {
            AIViewSource r0 = new AIViewSource("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            AIViewSource r1 = new AIViewSource("MEETING", 1, 1);
            MEETING = r1;
            AIViewSource r3 = new AIViewSource("MINUTES", 2, 2);
            MINUTES = r3;
            $VALUES = new AIViewSource[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(AIViewSource.class);
        }

        public static AIViewSource[] values() {
            return (AIViewSource[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AIViewSource fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return MINUTES;
        L12:
            return MEETING;
        L14:
            return UNKNOWN;
        }

        public static AIViewSource valueOf(String r1) {
            return (AIViewSource) a.a(AIViewSource.class, r1);
        }

        private AIViewSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<AIViewBlockData, Builder> {
        public String mai_view_id;
        public AIViewSource mai_view_source;
        public String mblock_data;
        public Long mend_time;
        public String mlocale;
        public String mlocation;
        public String mminutes_token;
        public Long mstart_time;
        public String mtopic;
        public Long muser_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AIViewBlockData m3233build() {
            return new AIViewBlockData(this.mlocale, this.mtopic, this.muser_id, this.mstart_time, this.mend_time, this.mminutes_token, this.mai_view_id, this.mlocation, this.mai_view_source, this.mblock_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3233build();
        }

        public Builder ai_view_id(String r1) {
            this.mai_view_id = r1;
            return this;
        }

        public Builder ai_view_source(AIViewSource r1) {
            this.mai_view_source = r1;
            return this;
        }

        public Builder block_data(String r1) {
            this.mblock_data = r1;
            return this;
        }

        public Builder end_time(Long r1) {
            this.mend_time = r1;
            return this;
        }

        public Builder locale(String r1) {
            this.mlocale = r1;
            return this;
        }

        public Builder location(String r1) {
            this.mlocation = r1;
            return this;
        }

        public Builder minutes_token(String r1) {
            this.mminutes_token = r1;
            return this;
        }

        public Builder start_time(Long r1) {
            this.mstart_time = r1;
            return this;
        }

        public Builder topic(String r1) {
            this.mtopic = r1;
            return this;
        }

        public Builder user_id(Long r1) {
            this.muser_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AIViewBlockData extends ProtoAdapter<AIViewBlockData> {
        public ProtoAdapter_AIViewBlockData() {
            super(FieldEncoding.LENGTH_DELIMITED, AIViewBlockData.class);
        }

        public AIViewBlockData decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mlocale = "";
            r0.mtopic = "";
            r0.muser_id = 0L;
            r0.mstart_time = 0L;
            r0.mend_time = 0L;
            r0.mminutes_token = "";
            r0.mai_view_id = "";
            r0.mlocation = "";
            r0.mblock_data = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L22;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r0.mai_view_source = (AIViewSource) AIViewSource.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mblock_data = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.mlocation = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mai_view_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mminutes_token = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mend_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L16:
            r0.mstart_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L17:
            r0.muser_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L18:
            r0.mtopic = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L19:
            r0.mlocale = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L20:
            r9.endMessage(r1);
            return r0.m3233build();
        }

        public int encodedSize(AIViewBlockData r6) {
            String r0 = r6.mlocale;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mtopic;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Long r7 = r6.muser_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Long r10 = r6.mstart_time;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Long r13 = r6.mend_time;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.INT64.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.mminutes_token;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mai_view_id;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mlocation;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            AIViewSource r25 = r6.mai_view_source;
            if (r25 == null) goto L37;
            int r26 = AIViewSource.ADAPTER.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r6.mblock_data;
            if (r28 == null) goto L42;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(10, r28);
        L42:
            return (r27 + r1) + r6.unknownFields().size();
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
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
        public /* bridge */ /* synthetic */ Object m3234decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AIViewBlockData) r1);
        }

        public void encode(ProtoWriter r4, AIViewBlockData r5) throws IOException {
            String r0 = r5.mlocale;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtopic;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Long r2 = r5.muser_id;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
        L11:
            Long r3 = r5.mstart_time;
            if (r3 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r3);
        L14:
            Long r6 = r5.mend_time;
            if (r6 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.mminutes_token;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            String r8 = r5.mai_view_id;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
        L23:
            String r9 = r5.mlocation;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
        L26:
            AIViewSource r10 = r5.mai_view_source;
            if (r10 == null) goto L29;
            AIViewSource.ADAPTER.encodeWithTag(r4, 9, r10);
        L29:
            String r11 = r5.mblock_data;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r4, 10, r11);
        L32:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AIViewBlockData) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIViewBlockData();
        DEFAULT_USER_ID = 0L;
        DEFAULT_START_TIME = 0L;
        DEFAULT_END_TIME = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3232newBuilder() {
        Builder r0 = new Builder();
        r0.mlocale = this.mlocale;
        r0.mtopic = this.mtopic;
        r0.muser_id = this.muser_id;
        r0.mstart_time = this.mstart_time;
        r0.mend_time = this.mend_time;
        r0.mminutes_token = this.mminutes_token;
        r0.mai_view_id = this.mai_view_id;
        r0.mlocation = this.mlocation;
        r0.mai_view_source = this.mai_view_source;
        r0.mblock_data = this.mblock_data;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AIViewBlockData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3232newBuilder();
    }

    public AIViewBlockData(String r13, String r14, Long r15, Long r16, Long r17, String r18, String r19, String r20, AIViewSource r21, String r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public AIViewBlockData(String r2, String r3, Long r4, Long r5, Long r6, String r7, String r8, String r9, AIViewSource r10, String r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mlocale = r2;
        this.mtopic = r3;
        this.muser_id = r4;
        this.mstart_time = r5;
        this.mend_time = r6;
        this.mminutes_token = r7;
        this.mai_view_id = r8;
        this.mlocation = r9;
        this.mai_view_source = r10;
        this.mblock_data = r11;
    }
}
