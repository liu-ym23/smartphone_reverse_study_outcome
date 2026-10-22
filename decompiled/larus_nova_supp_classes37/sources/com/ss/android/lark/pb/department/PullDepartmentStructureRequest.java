package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullDepartmentStructureRequest extends Message<PullDepartmentStructureRequest, Builder> {
    public static final ProtoAdapter<PullDepartmentStructureRequest> ADAPTER = null;
    public static final Integer DEFAULT_CHATTER_COUNT = null;
    public static final Integer DEFAULT_CHATTER_OFFSET = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final String DEFAULT_DEPARTMENT_ID = "";
    public static final String DEFAULT_IN_CHAT_ID = "";
    public static final Boolean DEFAULT_NEED_PATH = null;
    public static final Integer DEFAULT_OFFSET = null;
    public static final Boolean DEFAULT_SUB_DEPARTMENT_PAGING = null;
    public static final Boolean DEFAULT_USE_DISPLAY_ORDER = null;
    private static final long serialVersionUID = 0;
    public final Integer mchatter_count;
    public final Integer mchatter_offset;
    public final Integer mcount;
    public final String mdepartment_id;
    public final ExtendParam mextend_param;
    public final String min_chat_id;
    public final Boolean mneed_path;
    public final Integer moffset;
    public final Boolean msub_department_paging;
    public final Boolean muse_display_order;

    public static final class Builder extends Message.Builder<PullDepartmentStructureRequest, Builder> {
        public Integer mchatter_count;
        public Integer mchatter_offset;
        public Integer mcount;
        public String mdepartment_id;
        public ExtendParam mextend_param;
        public String min_chat_id;
        public Boolean mneed_path;
        public Integer moffset;
        public Boolean msub_department_paging;
        public Boolean muse_display_order;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullDepartmentStructureRequest m977build() {
            return new PullDepartmentStructureRequest(this.mdepartment_id, this.mchatter_count, this.mchatter_offset, this.min_chat_id, this.mextend_param, this.moffset, this.mcount, this.msub_department_paging, this.mneed_path, this.muse_display_order, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m977build();
        }

        public Builder chatter_count(Integer r1) {
            this.mchatter_count = r1;
            return this;
        }

        public Builder chatter_offset(Integer r1) {
            this.mchatter_offset = r1;
            return this;
        }

        public Builder count(Integer r1) {
            this.mcount = r1;
            return this;
        }

        public Builder department_id(String r1) {
            this.mdepartment_id = r1;
            return this;
        }

        public Builder extend_param(ExtendParam r1) {
            this.mextend_param = r1;
            return this;
        }

        public Builder in_chat_id(String r1) {
            this.min_chat_id = r1;
            return this;
        }

        public Builder need_path(Boolean r1) {
            this.mneed_path = r1;
            return this;
        }

        public Builder offset(Integer r1) {
            this.moffset = r1;
            return this;
        }

        public Builder sub_department_paging(Boolean r1) {
            this.msub_department_paging = r1;
            return this;
        }

        public Builder use_display_order(Boolean r1) {
            this.muse_display_order = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDepartmentStructureRequest extends ProtoAdapter<PullDepartmentStructureRequest> {
        public ProtoAdapter_PullDepartmentStructureRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDepartmentStructureRequest.class);
        }

        public PullDepartmentStructureRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mdepartment_id = "";
            r0.mchatter_count = 20;
            r0.mchatter_offset = 0;
            r0.min_chat_id = "";
            r0.moffset = 0;
            r0.mcount = 0;
            Boolean r1 = Boolean.FALSE;
            r0.msub_department_paging = r1;
            r0.mneed_path = r1;
            r0.muse_display_order = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r0.muse_display_order = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            r0.mneed_path = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            r0.msub_department_paging = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            r0.mcount = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L11:
            r0.moffset = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L12:
            r0.mextend_param = (ExtendParam) ExtendParam.ADAPTER.decode(r7);
            goto L3
        L13:
            r0.min_chat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mchatter_offset = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L15:
            r0.mchatter_count = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L16:
            r0.mdepartment_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L17:
            r7.endMessage(r2);
            return r0.m977build();
        }

        public int encodedSize(PullDepartmentStructureRequest r6) {
            String r0 = r6.mdepartment_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r6.mchatter_count;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Integer r7 = r6.mchatter_offset;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.min_chat_id;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            ExtendParam r13 = r6.mextend_param;
            if (r13 == null) goto L21;
            int r14 = ExtendParam.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Integer r16 = r6.moffset;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.INT32.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Integer r19 = r6.mcount;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.INT32.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            Boolean r22 = r6.msub_department_paging;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            Boolean r25 = r6.mneed_path;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            Boolean r28 = r6.muse_display_order;
            if (r28 == null) goto L42;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r28);
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
        public /* bridge */ /* synthetic */ Object m978decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullDepartmentStructureRequest) r1);
        }

        public void encode(ProtoWriter r4, PullDepartmentStructureRequest r5) throws IOException {
            String r0 = r5.mdepartment_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.mchatter_count;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            Integer r2 = r5.mchatter_offset;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.min_chat_id;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            ExtendParam r6 = r5.mextend_param;
            if (r6 == null) goto L17;
            ExtendParam.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            Integer r7 = r5.moffset;
            if (r7 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r4, 6, r7);
        L20:
            Integer r8 = r5.mcount;
            if (r8 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r4, 7, r8);
        L23:
            Boolean r9 = r5.msub_department_paging;
            if (r9 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r4, 8, r9);
        L26:
            Boolean r10 = r5.mneed_path;
            if (r10 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r4, 9, r10);
        L29:
            Boolean r11 = r5.muse_display_order;
            if (r11 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r4, 10, r11);
        L32:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullDepartmentStructureRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullDepartmentStructureRequest();
        DEFAULT_CHATTER_COUNT = 20;
        DEFAULT_CHATTER_OFFSET = 0;
        DEFAULT_OFFSET = 0;
        DEFAULT_COUNT = 0;
        Boolean r0 = Boolean.FALSE;
        DEFAULT_SUB_DEPARTMENT_PAGING = r0;
        DEFAULT_NEED_PATH = r0;
        DEFAULT_USE_DISPLAY_ORDER = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m976newBuilder() {
        Builder r0 = new Builder();
        r0.mdepartment_id = this.mdepartment_id;
        r0.mchatter_count = this.mchatter_count;
        r0.mchatter_offset = this.mchatter_offset;
        r0.min_chat_id = this.min_chat_id;
        r0.mextend_param = this.mextend_param;
        r0.moffset = this.moffset;
        r0.mcount = this.mcount;
        r0.msub_department_paging = this.msub_department_paging;
        r0.mneed_path = this.mneed_path;
        r0.muse_display_order = this.muse_display_order;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullDepartmentStructureRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m976newBuilder();
    }

    public PullDepartmentStructureRequest(String r13, Integer r14, Integer r15, String r16, ExtendParam r17, Integer r18, Integer r19, Boolean r20, Boolean r21, Boolean r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public PullDepartmentStructureRequest(String r2, Integer r3, Integer r4, String r5, ExtendParam r6, Integer r7, Integer r8, Boolean r9, Boolean r10, Boolean r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mdepartment_id = r2;
        this.mchatter_count = r3;
        this.mchatter_offset = r4;
        this.min_chat_id = r5;
        this.mextend_param = r6;
        this.moffset = r7;
        this.mcount = r8;
        this.msub_department_paging = r9;
        this.mneed_path = r10;
        this.muse_display_order = r11;
    }
}
