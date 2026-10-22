package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ReportUGEventRequest extends Message<ReportUGEventRequest, Builder> {
    public static final ProtoAdapter<ReportUGEventRequest> ADAPTER = null;
    public static final String DEFAULT_EVENT_NAME = "";
    public static final Long DEFAULT_LOCAL_RULE_ID = null;
    public static final String DEFAULT_MATERIAL_KEY = "";
    public static final String DEFAULT_REACH_POINT_ID = "";
    public static final String DEFAULT_SCENARIO_ID = "";
    private static final long serialVersionUID = 0;
    public final ConsumeType mconsume_type;
    public final String mevent_name;
    public final Long mlocal_rule_id;
    public final String mmaterial_key;
    public final String mreach_point_id;
    public final String mscenario_id;
    public final Map<String, String> mupload_context;

    public static final class Builder extends Message.Builder<ReportUGEventRequest, Builder> {
        public ConsumeType mconsume_type;
        public String mevent_name;
        public Long mlocal_rule_id;
        public String mmaterial_key;
        public String mreach_point_id;
        public String mscenario_id;
        public Map<String, String> mupload_context;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ReportUGEventRequest m2456build() {
            return new ReportUGEventRequest(this.mscenario_id, this.mreach_point_id, this.mmaterial_key, this.mlocal_rule_id, this.mevent_name, this.mupload_context, this.mconsume_type, super.buildUnknownFields());
        }

        public Builder() {
            this.mupload_context = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2456build();
        }

        public Builder consume_type(ConsumeType r1) {
            this.mconsume_type = r1;
            return this;
        }

        public Builder event_name(String r1) {
            this.mevent_name = r1;
            return this;
        }

        public Builder local_rule_id(Long r1) {
            this.mlocal_rule_id = r1;
            return this;
        }

        public Builder material_key(String r1) {
            this.mmaterial_key = r1;
            return this;
        }

        public Builder reach_point_id(String r1) {
            this.mreach_point_id = r1;
            return this;
        }

        public Builder scenario_id(String r1) {
            this.mscenario_id = r1;
            return this;
        }

        public Builder upload_context(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mupload_context = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ReportUGEventRequest extends ProtoAdapter<ReportUGEventRequest> {
        private final ProtoAdapter<Map<String, String>> mupload_context;

        public ProtoAdapter_ReportUGEventRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ReportUGEventRequest.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mupload_context = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public ReportUGEventRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mscenario_id = "";
            r0.mreach_point_id = "";
            r0.mmaterial_key = "";
            r0.mlocal_rule_id = 0L;
            r0.mevent_name = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L19;
                default: goto L6;
            };
        L19:
            r0.mconsume_type = (ConsumeType) ConsumeType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r0.mupload_context.putAll((Map) this.mupload_context.decode(r9));
            goto L3
        L12:
            r0.mevent_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mlocal_rule_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L14:
            r0.mmaterial_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mreach_point_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mscenario_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L17:
            r9.endMessage(r1);
            return r0.m2456build();
        }

        public int encodedSize(ReportUGEventRequest r6) {
            String r0 = r6.mscenario_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mreach_point_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mmaterial_key;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Long r10 = r6.mlocal_rule_id;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mevent_name;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = (r12 + r14) + this.mupload_context.encodedSizeWithTag(6, r6.mupload_context);
            ConsumeType r16 = r6.mconsume_type;
            if (r16 == null) goto L26;
            r1 = ConsumeType.ADAPTER.encodedSizeWithTag(7, r16);
        L26:
            return (r15 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2457decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ReportUGEventRequest) r1);
        }

        public void encode(ProtoWriter r4, ReportUGEventRequest r5) throws IOException {
            String r0 = r5.mscenario_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mreach_point_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mmaterial_key;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            Long r3 = r5.mlocal_rule_id;
            if (r3 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mevent_name;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            this.mupload_context.encodeWithTag(r4, 6, r5.mupload_context);
            ConsumeType r7 = r5.mconsume_type;
            if (r7 == null) goto L20;
            ConsumeType.ADAPTER.encodeWithTag(r4, 7, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ReportUGEventRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ReportUGEventRequest();
        DEFAULT_LOCAL_RULE_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2455newBuilder() {
        Builder r0 = new Builder();
        r0.mscenario_id = this.mscenario_id;
        r0.mreach_point_id = this.mreach_point_id;
        r0.mmaterial_key = this.mmaterial_key;
        r0.mlocal_rule_id = this.mlocal_rule_id;
        r0.mevent_name = this.mevent_name;
        r0.mupload_context = Internal.copyOf("mupload_context", this.mupload_context);
        r0.mconsume_type = this.mconsume_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ReportUGEventRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2455newBuilder();
    }

    public ReportUGEventRequest(String r10, String r11, String r12, Long r13, String r14, Map<String, String> r15, ConsumeType r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public ReportUGEventRequest(String r2, String r3, String r4, Long r5, String r6, Map<String, String> r7, ConsumeType r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mscenario_id = r2;
        this.mreach_point_id = r3;
        this.mmaterial_key = r4;
        this.mlocal_rule_id = r5;
        this.mevent_name = r6;
        this.mupload_context = Internal.immutableCopyOf("mupload_context", r7);
        this.mconsume_type = r8;
    }
}
