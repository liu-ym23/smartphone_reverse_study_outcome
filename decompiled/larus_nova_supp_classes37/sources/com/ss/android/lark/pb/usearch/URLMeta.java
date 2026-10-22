package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ImageSetV2;
import com.ss.android.lark.pb.entities.UDIcon;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class URLMeta extends Message<URLMeta, Builder> {
    public static final ProtoAdapter<URLMeta> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Integer DEFAULT_MESSAGE_POSITION = null;
    public static final String DEFAULT_MESSAGE_SENDER_NAME = "";
    public static final String DEFAULT_PREVIEW_TOKEN = "";
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final Long mcreate_time;
    public final Map<Integer, MessageBehavior> mdisabled_action;
    public final String mfrom_id;
    public final String micon_url;
    public final String mid;
    public final ImageSetV2 mimage_icon;
    public final Boolean mis_restricted;
    public final String mmessage_id;
    public final Integer mmessage_position;
    public final String mmessage_sender_name;
    public final String mpreview_token;
    public final Integer mthread_chat_position;
    public final String mthread_id;
    public final Integer mthread_position;
    public final UDIcon mud_icon;
    public final String murl;

    public static final class Builder extends Message.Builder<URLMeta, Builder> {
        public String mchat_id;
        public Long mcreate_time;
        public Map<Integer, MessageBehavior> mdisabled_action;
        public String mfrom_id;
        public String micon_url;
        public String mid;
        public ImageSetV2 mimage_icon;
        public Boolean mis_restricted;
        public String mmessage_id;
        public Integer mmessage_position;
        public String mmessage_sender_name;
        public String mpreview_token;
        public Integer mthread_chat_position;
        public String mthread_id;
        public Integer mthread_position;
        public UDIcon mud_icon;
        public String murl;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public URLMeta m2876build() {
            String r1 = this.mid;
            if (r1 == null) goto L7;
            return new URLMeta(this.mid, this.mcreate_time, this.mmessage_id, this.mmessage_position, this.mchat_id, this.mfrom_id, this.murl, this.micon_url, this.mthread_id, this.mthread_position, this.mthread_chat_position, this.mis_restricted, this.mdisabled_action, this.mud_icon, this.mimage_icon, this.mmessage_sender_name, this.mpreview_token, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mid"});
        }

        public Builder() {
            this.mdisabled_action = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2876build();
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder create_time(Long r1) {
            this.mcreate_time = r1;
            return this;
        }

        public Builder disabled_action(Map<Integer, MessageBehavior> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdisabled_action = r1;
            return this;
        }

        public Builder from_id(String r1) {
            this.mfrom_id = r1;
            return this;
        }

        public Builder icon_url(String r1) {
            this.micon_url = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder image_icon(ImageSetV2 r1) {
            this.mimage_icon = r1;
            return this;
        }

        public Builder is_restricted(Boolean r1) {
            this.mis_restricted = r1;
            return this;
        }

        public Builder message_id(String r1) {
            this.mmessage_id = r1;
            return this;
        }

        public Builder message_position(Integer r1) {
            this.mmessage_position = r1;
            return this;
        }

        public Builder message_sender_name(String r1) {
            this.mmessage_sender_name = r1;
            return this;
        }

        public Builder preview_token(String r1) {
            this.mpreview_token = r1;
            return this;
        }

        public Builder thread_chat_position(Integer r1) {
            this.mthread_chat_position = r1;
            return this;
        }

        public Builder thread_id(String r1) {
            this.mthread_id = r1;
            return this;
        }

        public Builder thread_position(Integer r1) {
            this.mthread_position = r1;
            return this;
        }

        public Builder ud_icon(UDIcon r1) {
            this.mud_icon = r1;
            return this;
        }

        public Builder url(String r1) {
            this.murl = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_URLMeta extends ProtoAdapter<URLMeta> {
        private final ProtoAdapter<Map<Integer, MessageBehavior>> mdisabled_action;

        public ProtoAdapter_URLMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, URLMeta.class);
            this.mdisabled_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageBehavior.ADAPTER);
        }

        public URLMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mcreate_time = 0L;
            r0.mmessage_id = "";
            r0.mmessage_position = 0;
            r0.mchat_id = "";
            r0.mfrom_id = "";
            r0.murl = "";
            r0.micon_url = "";
            r0.mthread_id = "";
            r0.mthread_position = 0;
            r0.mthread_chat_position = 0;
            r0.mis_restricted = Boolean.FALSE;
            r0.mmessage_sender_name = "";
            r0.mpreview_token = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L24;
            switch(r3) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L12;
                case 13: goto L11;
                case 14: goto L10;
                case 15: goto L9;
                case 16: goto L8;
                case 17: goto L7;
                default: goto L6;
            };
        L7:
            r0.mpreview_token = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.mmessage_sender_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.mimage_icon = (ImageSetV2) ImageSetV2.ADAPTER.decode(r7);
            goto L3
        L10:
            r0.mud_icon = (UDIcon) UDIcon.ADAPTER.decode(r7);
            goto L3
        L11:
            r0.mdisabled_action.putAll((Map) this.mdisabled_action.decode(r7));
            goto L3
        L12:
            r0.mis_restricted = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            r0.mthread_chat_position = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L14:
            r0.mthread_position = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L15:
            r0.mthread_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L16:
            r0.micon_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L17:
            r0.murl = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L18:
            r0.mfrom_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L19:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L20:
            r0.mmessage_position = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L21:
            r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L22:
            r0.mcreate_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L23:
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L24:
            r7.endMessage(r1);
            return r0.m2876build();
        }

        public int encodedSize(URLMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            Long r2 = r7.mcreate_time;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mmessage_id;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            Integer r10 = r7.mmessage_position;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.INT32.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            String r13 = r7.mchat_id;
            if (r13 == null) goto L17;
            int r14 = r0.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            String r16 = r7.mfrom_id;
            if (r16 == null) goto L21;
            int r17 = r0.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.murl;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(7, r19);
        L26:
            int r21 = r18 + r20;
            String r22 = r7.micon_url;
            if (r22 == null) goto L29;
            int r23 = r0.encodedSizeWithTag(8, r22);
        L30:
            int r24 = r21 + r23;
            String r25 = r7.mthread_id;
            if (r25 == null) goto L33;
            int r26 = r0.encodedSizeWithTag(9, r25);
        L34:
            int r27 = r24 + r26;
            Integer r28 = r7.mthread_position;
            if (r28 == null) goto L37;
            int r29 = ProtoAdapter.INT32.encodedSizeWithTag(10, r28);
        L38:
            int r30 = r27 + r29;
            Integer r31 = r7.mthread_chat_position;
            if (r31 == null) goto L41;
            int r32 = ProtoAdapter.INT32.encodedSizeWithTag(11, r31);
        L42:
            int r33 = r30 + r32;
            Boolean r34 = r7.mis_restricted;
            if (r34 == null) goto L45;
            int r35 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r34);
        L46:
            int r36 = (r33 + r35) + this.mdisabled_action.encodedSizeWithTag(13, r7.mdisabled_action);
            UDIcon r37 = r7.mud_icon;
            if (r37 == null) goto L49;
            int r38 = UDIcon.ADAPTER.encodedSizeWithTag(14, r37);
        L50:
            int r39 = r36 + r38;
            ImageSetV2 r40 = r7.mimage_icon;
            if (r40 == null) goto L53;
            int r41 = ImageSetV2.ADAPTER.encodedSizeWithTag(15, r40);
        L54:
            int r42 = r39 + r41;
            String r43 = r7.mmessage_sender_name;
            if (r43 == null) goto L57;
            int r44 = r0.encodedSizeWithTag(16, r43);
        L58:
            int r45 = r42 + r44;
            String r46 = r7.mpreview_token;
            if (r46 == null) goto L62;
            r3 = r0.encodedSizeWithTag(17, r46);
        L62:
            return (r45 + r3) + r7.unknownFields().size();
        L57:
            r44 = 0;
            goto L58
        L53:
            r41 = 0;
            goto L54
        L49:
            r38 = 0;
            goto L50
        L45:
            r35 = 0;
            goto L46
        L41:
            r32 = 0;
            goto L42
        L37:
            r29 = 0;
            goto L38
        L33:
            r26 = 0;
            goto L34
        L29:
            r23 = 0;
            goto L30
        L25:
            r20 = 0;
            goto L26
        L21:
            r17 = 0;
            goto L22
        L17:
            r14 = 0;
            goto L18
        L13:
            r11 = 0;
            goto L14
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2877decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((URLMeta) r1);
        }

        public void encode(ProtoWriter r5, URLMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            Long r1 = r6.mcreate_time;
            if (r1 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.mmessage_id;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            Integer r3 = r6.mmessage_position;
            if (r3 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r5, 4, r3);
        L11:
            String r4 = r6.mchat_id;
            if (r4 == null) goto L14;
            r0.encodeWithTag(r5, 5, r4);
        L14:
            String r7 = r6.mfrom_id;
            if (r7 == null) goto L17;
            r0.encodeWithTag(r5, 6, r7);
        L17:
            String r8 = r6.murl;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 7, r8);
        L20:
            String r9 = r6.micon_url;
            if (r9 == null) goto L23;
            r0.encodeWithTag(r5, 8, r9);
        L23:
            String r10 = r6.mthread_id;
            if (r10 == null) goto L26;
            r0.encodeWithTag(r5, 9, r10);
        L26:
            Integer r11 = r6.mthread_position;
            if (r11 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r5, 10, r11);
        L29:
            Integer r12 = r6.mthread_chat_position;
            if (r12 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r5, 11, r12);
        L32:
            Boolean r13 = r6.mis_restricted;
            if (r13 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r5, 12, r13);
        L35:
            this.mdisabled_action.encodeWithTag(r5, 13, r6.mdisabled_action);
            UDIcon r14 = r6.mud_icon;
            if (r14 == null) goto L38;
            UDIcon.ADAPTER.encodeWithTag(r5, 14, r14);
        L38:
            ImageSetV2 r15 = r6.mimage_icon;
            if (r15 == null) goto L41;
            ImageSetV2.ADAPTER.encodeWithTag(r5, 15, r15);
        L41:
            String r16 = r6.mmessage_sender_name;
            if (r16 == null) goto L44;
            r0.encodeWithTag(r5, 16, r16);
        L44:
            String r17 = r6.mpreview_token;
            if (r17 == null) goto L47;
            r0.encodeWithTag(r5, 17, r17);
        L47:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (URLMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_URLMeta();
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_MESSAGE_POSITION = 0;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_IS_RESTRICTED = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2875newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mcreate_time = this.mcreate_time;
        r0.mmessage_id = this.mmessage_id;
        r0.mmessage_position = this.mmessage_position;
        r0.mchat_id = this.mchat_id;
        r0.mfrom_id = this.mfrom_id;
        r0.murl = this.murl;
        r0.micon_url = this.micon_url;
        r0.mthread_id = this.mthread_id;
        r0.mthread_position = this.mthread_position;
        r0.mthread_chat_position = this.mthread_chat_position;
        r0.mis_restricted = this.mis_restricted;
        r0.mdisabled_action = Internal.copyOf("mdisabled_action", this.mdisabled_action);
        r0.mud_icon = this.mud_icon;
        r0.mimage_icon = this.mimage_icon;
        r0.mmessage_sender_name = this.mmessage_sender_name;
        r0.mpreview_token = this.mpreview_token;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return URLMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2875newBuilder();
    }

    public URLMeta(String r20, Long r21, String r22, Integer r23, String r24, String r25, String r26, String r27, String r28, Integer r29, Integer r30, Boolean r31, Map<Integer, MessageBehavior> r32, UDIcon r33, ImageSetV2 r34, String r35, String r36) {
        this(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, ByteString.EMPTY);
    }

    public URLMeta(String r4, Long r5, String r6, Integer r7, String r8, String r9, String r10, String r11, String r12, Integer r13, Integer r14, Boolean r15, Map<Integer, MessageBehavior> r16, UDIcon r17, ImageSetV2 r18, String r19, String r20, ByteString r21) {
        super(ADAPTER, r21);
        this.mid = r4;
        this.mcreate_time = r5;
        this.mmessage_id = r6;
        this.mmessage_position = r7;
        this.mchat_id = r8;
        this.mfrom_id = r9;
        this.murl = r10;
        this.micon_url = r11;
        this.mthread_id = r12;
        this.mthread_position = r13;
        this.mthread_chat_position = r14;
        this.mis_restricted = r15;
        this.mdisabled_action = Internal.immutableCopyOf("mdisabled_action", r16);
        this.mud_icon = r17;
        this.mimage_icon = r18;
        this.mmessage_sender_name = r19;
        this.mpreview_token = r20;
    }
}
