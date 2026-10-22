package com.ss.android.lark.pb.office_ai_inline;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class QuickAction extends Message<QuickAction, Builder> {
    public static final ProtoAdapter<QuickAction> ADAPTER = null;
    public static final Long DEFAULT_ACTION_TYPE = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PROMPT_TASK = "";
    public static final String DEFAULT_PROMPT_TASK_VERSION = "";
    private static final long serialVersionUID = 0;
    public final Long maction_type;
    public final String mdescription;
    public final Map<String, String> mextra_map;
    public final String micon;
    public final String mid;
    public final String mname;
    public final List<QuickActionParam> mparam_details;
    public final List<String> mparams;
    public final String mprompt_task;
    public final String mprompt_task_version;

    public static final class Builder extends Message.Builder<QuickAction, Builder> {
        public Long maction_type;
        public String mdescription;
        public Map<String, String> mextra_map;
        public String micon;
        public String mid;
        public String mname;
        public List<QuickActionParam> mparam_details;
        public List<String> mparams;
        public String mprompt_task;
        public String mprompt_task_version;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public QuickAction m2045build() {
            return new QuickAction(this.mid, this.mname, this.mdescription, this.micon, this.maction_type, this.mprompt_task, this.mprompt_task_version, this.mparams, this.mextra_map, this.mparam_details, super.buildUnknownFields());
        }

        public Builder() {
            this.mparams = Internal.newMutableList();
            this.mextra_map = Internal.newMutableMap();
            this.mparam_details = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2045build();
        }

        public Builder action_type(Long r1) {
            this.maction_type = r1;
            return this;
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder extra_map(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mextra_map = r1;
            return this;
        }

        public Builder icon(String r1) {
            this.micon = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder param_details(List<QuickActionParam> r1) {
            Internal.checkElementsNotNull(r1);
            this.mparam_details = r1;
            return this;
        }

        public Builder params(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mparams = r1;
            return this;
        }

        public Builder prompt_task(String r1) {
            this.mprompt_task = r1;
            return this;
        }

        public Builder prompt_task_version(String r1) {
            this.mprompt_task_version = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_QuickAction extends ProtoAdapter<QuickAction> {
        private final ProtoAdapter<Map<String, String>> mextra_map;

        public ProtoAdapter_QuickAction() {
            super(FieldEncoding.LENGTH_DELIMITED, QuickAction.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mextra_map = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public QuickAction decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            r0.mdescription = "";
            r0.micon = "";
            r0.maction_type = 0L;
            r0.mprompt_task = "";
            r0.mprompt_task_version = "";
            long r1 = r7.beginMessage();
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
            r0.mparam_details.add((QuickActionParam) QuickActionParam.ADAPTER.decode(r7));
            goto L3
        L8:
            r0.mextra_map.putAll((Map) this.mextra_map.decode(r7));
            goto L3
        L9:
            r0.mparams.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            r0.mprompt_task_version = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mprompt_task = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.maction_type = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L13:
            r0.micon = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L15:
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L16:
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L17:
            r7.endMessage(r1);
            return r0.m2045build();
        }

        public int encodedSize(QuickAction r6) {
            String r0 = r6.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mname;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mdescription;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.micon;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Long r13 = r6.maction_type;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.INT64.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.mprompt_task;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mprompt_task_version;
            if (r19 == null) goto L30;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            return ((((r18 + r1) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(8, r6.mparams)) + this.mextra_map.encodedSizeWithTag(9, r6.mextra_map)) + QuickActionParam.ADAPTER.asRepeated().encodedSizeWithTag(10, r6.mparam_details)) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2046decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((QuickAction) r1);
        }

        public void encode(ProtoWriter r4, QuickAction r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mdescription;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.micon;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            Long r6 = r5.maction_type;
            if (r6 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.mprompt_task;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            String r8 = r5.mprompt_task_version;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
        L23:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 8, r5.mparams);
            this.mextra_map.encodeWithTag(r4, 9, r5.mextra_map);
            QuickActionParam.ADAPTER.asRepeated().encodeWithTag(r4, 10, r5.mparam_details);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (QuickAction) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuickAction();
        DEFAULT_ACTION_TYPE = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2044newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mdescription = this.mdescription;
        r0.micon = this.micon;
        r0.maction_type = this.maction_type;
        r0.mprompt_task = this.mprompt_task;
        r0.mprompt_task_version = this.mprompt_task_version;
        r0.mparams = Internal.copyOf("mparams", this.mparams);
        r0.mextra_map = Internal.copyOf("mextra_map", this.mextra_map);
        r0.mparam_details = Internal.copyOf("mparam_details", this.mparam_details);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return QuickAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2044newBuilder();
    }

    public QuickAction(String r13, String r14, String r15, String r16, Long r17, String r18, String r19, List<String> r20, Map<String, String> r21, List<QuickActionParam> r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public QuickAction(String r2, String r3, String r4, String r5, Long r6, String r7, String r8, List<String> r9, Map<String, String> r10, List<QuickActionParam> r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mid = r2;
        this.mname = r3;
        this.mdescription = r4;
        this.micon = r5;
        this.maction_type = r6;
        this.mprompt_task = r7;
        this.mprompt_task_version = r8;
        this.mparams = Internal.immutableCopyOf("mparams", r9);
        this.mextra_map = Internal.immutableCopyOf("mextra_map", r10);
        this.mparam_details = Internal.immutableCopyOf("mparam_details", r11);
    }
}
