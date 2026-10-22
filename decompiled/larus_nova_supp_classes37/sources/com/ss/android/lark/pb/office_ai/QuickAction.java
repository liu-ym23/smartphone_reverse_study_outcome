package com.ss.android.lark.pb.office_ai;

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
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_QUERY_TEMPLATE = "";
    private static final long serialVersionUID = 0;
    public final FollowUpFrom mFollowUpFrom;
    public final QuickActionType maction_type;
    public final ContentAlign mcontent_align;
    public final String mdescription;
    public final DisplayConfig mdisplay_config;
    public final String mdisplay_name;
    public final Map<String, String> mextra_map;
    public final String micon;
    public final IconConfig micon_config;
    public final String mid;
    public final LinkConfig mlink_config;
    public final String mname;
    public final List<Param> mparam_details;
    public final String mquery_template;

    public static final class Builder extends Message.Builder<QuickAction, Builder> {
        public FollowUpFrom mFollowUpFrom;
        public QuickActionType maction_type;
        public ContentAlign mcontent_align;
        public String mdescription;
        public DisplayConfig mdisplay_config;
        public String mdisplay_name;
        public Map<String, String> mextra_map;
        public String micon;
        public IconConfig micon_config;
        public String mid;
        public LinkConfig mlink_config;
        public String mname;
        public List<Param> mparam_details;
        public String mquery_template;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public QuickAction m2009build() {
            return new QuickAction(this.mid, this.mname, this.mdescription, this.mextra_map, this.mparam_details, this.mdisplay_name, this.maction_type, this.mFollowUpFrom, this.micon, this.mdisplay_config, this.mquery_template, this.micon_config, this.mlink_config, this.mcontent_align, super.buildUnknownFields());
        }

        public Builder() {
            this.mextra_map = Internal.newMutableMap();
            this.mparam_details = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2009build();
        }

        public Builder FollowUpFrom(FollowUpFrom r1) {
            this.mFollowUpFrom = r1;
            return this;
        }

        public Builder action_type(QuickActionType r1) {
            this.maction_type = r1;
            return this;
        }

        public Builder content_align(ContentAlign r1) {
            this.mcontent_align = r1;
            return this;
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder display_config(DisplayConfig r1) {
            this.mdisplay_config = r1;
            return this;
        }

        public Builder display_name(String r1) {
            this.mdisplay_name = r1;
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

        public Builder icon_config(IconConfig r1) {
            this.micon_config = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder link_config(LinkConfig r1) {
            this.mlink_config = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder param_details(List<Param> r1) {
            Internal.checkElementsNotNull(r1);
            this.mparam_details = r1;
            return this;
        }

        public Builder query_template(String r1) {
            this.mquery_template = r1;
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

        public QuickAction decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            r0.mdescription = "";
            r0.mdisplay_name = "";
            r0.micon = "";
            r0.mquery_template = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L27;
            switch(r3) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L31;
                case 8: goto L29;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L29:
            r0.mFollowUpFrom = (FollowUpFrom) FollowUpFrom.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L31:
            r0.maction_type = (QuickActionType) QuickActionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mcontent_align = (ContentAlign) ContentAlign.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.mlink_config = (LinkConfig) LinkConfig.ADAPTER.decode(r9);
            goto L3
        L9:
            r0.micon_config = (IconConfig) IconConfig.ADAPTER.decode(r9);
            goto L3
        L10:
            r0.mquery_template = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            r0.mdisplay_config = (DisplayConfig) DisplayConfig.ADAPTER.decode(r9);
            goto L3
        L12:
            r0.micon = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L21:
            r0.mdisplay_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L22:
            r0.mparam_details.add((Param) Param.ADAPTER.decode(r9));
            goto L3
        L23:
            r0.mextra_map.putAll((Map) this.mextra_map.decode(r9));
            goto L3
        L24:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L25:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L26:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L27:
            r9.endMessage(r1);
            return r0.m2009build();
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
            int r9 = ((r5 + r8) + this.mextra_map.encodedSizeWithTag(4, r6.mextra_map)) + Param.ADAPTER.asRepeated().encodedSizeWithTag(5, r6.mparam_details);
            String r10 = r6.mdisplay_name;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(6, r10);
        L18:
            int r12 = r9 + r11;
            QuickActionType r13 = r6.maction_type;
            if (r13 == null) goto L21;
            int r14 = QuickActionType.ADAPTER.encodedSizeWithTag(7, r13);
        L22:
            int r15 = r12 + r14;
            FollowUpFrom r16 = r6.mFollowUpFrom;
            if (r16 == null) goto L25;
            int r17 = FollowUpFrom.ADAPTER.encodedSizeWithTag(8, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.micon;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(9, r19);
        L30:
            int r21 = r18 + r20;
            DisplayConfig r22 = r6.mdisplay_config;
            if (r22 == null) goto L33;
            int r23 = DisplayConfig.ADAPTER.encodedSizeWithTag(10, r22);
        L34:
            int r24 = r21 + r23;
            String r25 = r6.mquery_template;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.STRING.encodedSizeWithTag(11, r25);
        L38:
            int r27 = r24 + r26;
            IconConfig r28 = r6.micon_config;
            if (r28 == null) goto L41;
            int r29 = IconConfig.ADAPTER.encodedSizeWithTag(12, r28);
        L42:
            int r30 = r27 + r29;
            LinkConfig r31 = r6.mlink_config;
            if (r31 == null) goto L45;
            int r32 = LinkConfig.ADAPTER.encodedSizeWithTag(13, r31);
        L46:
            int r33 = r30 + r32;
            ContentAlign r34 = r6.mcontent_align;
            if (r34 == null) goto L50;
            r1 = ContentAlign.ADAPTER.encodedSizeWithTag(14, r34);
        L50:
            return (r33 + r1) + r6.unknownFields().size();
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
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
        public /* bridge */ /* synthetic */ Object m2010decode(ProtoReader r1) throws IOException {
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
            this.mextra_map.encodeWithTag(r4, 4, r5.mextra_map);
            Param.ADAPTER.asRepeated().encodeWithTag(r4, 5, r5.mparam_details);
            String r3 = r5.mdisplay_name;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r3);
        L14:
            QuickActionType r6 = r5.maction_type;
            if (r6 == null) goto L17;
            QuickActionType.ADAPTER.encodeWithTag(r4, 7, r6);
        L17:
            FollowUpFrom r7 = r5.mFollowUpFrom;
            if (r7 == null) goto L20;
            FollowUpFrom.ADAPTER.encodeWithTag(r4, 8, r7);
        L20:
            String r8 = r5.micon;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 9, r8);
        L23:
            DisplayConfig r9 = r5.mdisplay_config;
            if (r9 == null) goto L26;
            DisplayConfig.ADAPTER.encodeWithTag(r4, 10, r9);
        L26:
            String r10 = r5.mquery_template;
            if (r10 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r4, 11, r10);
        L29:
            IconConfig r11 = r5.micon_config;
            if (r11 == null) goto L32;
            IconConfig.ADAPTER.encodeWithTag(r4, 12, r11);
        L32:
            LinkConfig r12 = r5.mlink_config;
            if (r12 == null) goto L35;
            LinkConfig.ADAPTER.encodeWithTag(r4, 13, r12);
        L35:
            ContentAlign r13 = r5.mcontent_align;
            if (r13 == null) goto L38;
            ContentAlign.ADAPTER.encodeWithTag(r4, 14, r13);
        L38:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (QuickAction) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuickAction();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2008newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mdescription = this.mdescription;
        r0.mextra_map = Internal.copyOf("mextra_map", this.mextra_map);
        r0.mparam_details = Internal.copyOf("mparam_details", this.mparam_details);
        r0.mdisplay_name = this.mdisplay_name;
        r0.maction_type = this.maction_type;
        r0.mFollowUpFrom = this.mFollowUpFrom;
        r0.micon = this.micon;
        r0.mdisplay_config = this.mdisplay_config;
        r0.mquery_template = this.mquery_template;
        r0.micon_config = this.micon_config;
        r0.mlink_config = this.mlink_config;
        r0.mcontent_align = this.mcontent_align;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return QuickAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2008newBuilder();
    }

    public QuickAction(String r17, String r18, String r19, Map<String, String> r20, List<Param> r21, String r22, QuickActionType r23, FollowUpFrom r24, String r25, DisplayConfig r26, String r27, IconConfig r28, LinkConfig r29, ContentAlign r30) {
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, ByteString.EMPTY);
    }

    public QuickAction(String r4, String r5, String r6, Map<String, String> r7, List<Param> r8, String r9, QuickActionType r10, FollowUpFrom r11, String r12, DisplayConfig r13, String r14, IconConfig r15, LinkConfig r16, ContentAlign r17, ByteString r18) {
        super(ADAPTER, r18);
        this.mid = r4;
        this.mname = r5;
        this.mdescription = r6;
        this.mextra_map = Internal.immutableCopyOf("mextra_map", r7);
        this.mparam_details = Internal.immutableCopyOf("mparam_details", r8);
        this.mdisplay_name = r9;
        this.maction_type = r10;
        this.mFollowUpFrom = r11;
        this.micon = r12;
        this.mdisplay_config = r13;
        this.mquery_template = r14;
        this.micon_config = r15;
        this.mlink_config = r16;
        this.mcontent_align = r17;
    }
}
