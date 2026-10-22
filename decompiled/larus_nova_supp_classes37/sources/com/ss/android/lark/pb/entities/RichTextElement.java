package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RichTextElement extends com.squareup.wire.Message<RichTextElement, Builder> {
    public static final ProtoAdapter<RichTextElement> ADAPTER = null;
    public static final ByteString DEFAULT_PROPERTY = null;
    public static final ByteString DEFAULT_UPGRADE_ELEMENT = null;
    private static final long serialVersionUID = 0;
    public final List<String> mchild_ids;
    public final ByteString mproperty;
    public final Map<String, String> mstyle;
    public final List<String> mstyle_keys;
    public final Tag mtag;
    public final ByteString mupgrade_element;

    public static final class AnchorProperty extends com.squareup.wire.Message<AnchorProperty, Builder> {
        public static final ProtoAdapter<AnchorProperty> ADAPTER = null;
        public static final String DEFAULT_ANDROID_HREF = "";
        public static final Boolean DEFAULT_CLOSE_CARD_PREVIEW = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_HREF = "";
        public static final String DEFAULT_I18N_KEY = "";
        public static final String DEFAULT_IOS_HREF = "";
        public static final Boolean DEFAULT_IS_CUSTOM = null;
        public static final String DEFAULT_PC_HREF = "";
        public static final String DEFAULT_TEXT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final String mandroid_href;
        public final Boolean mclose_card_preview;
        public final String mcontent;
        public final String mhref;
        public final String mi18n_key;
        public final String mios_href;
        public final Boolean mis_custom;
        public final String mpc_href;
        public final Scene mscene;
        public final SpecialURL mspecial_url;
        public final String mtext_content;

        public static final class Builder extends com.squareup.wire.Message.Builder<AnchorProperty, Builder> {
            public String mandroid_href;
            public Boolean mclose_card_preview;
            public String mcontent;
            public String mhref;
            public String mi18n_key;
            public String mios_href;
            public Boolean mis_custom;
            public String mpc_href;
            public Scene mscene;
            public SpecialURL mspecial_url;
            public String mtext_content;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AnchorProperty m1353build() {
                String r0 = this.mhref;
                if (r0 == null) goto L9;
                if (this.mcontent == null) goto L9;
                return new AnchorProperty(this.mhref, this.mcontent, this.mtext_content, this.mspecial_url, this.mi18n_key, this.mios_href, this.mandroid_href, this.mpc_href, this.mis_custom, this.mscene, this.mclose_card_preview, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mhref", this.mcontent, "mcontent"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1353build();
            }

            public Builder android_href(String r1) {
                this.mandroid_href = r1;
                return this;
            }

            public Builder close_card_preview(Boolean r1) {
                this.mclose_card_preview = r1;
                return this;
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder href(String r1) {
                this.mhref = r1;
                return this;
            }

            public Builder i18n_key(String r1) {
                this.mi18n_key = r1;
                return this;
            }

            public Builder ios_href(String r1) {
                this.mios_href = r1;
                return this;
            }

            public Builder is_custom(Boolean r1) {
                this.mis_custom = r1;
                return this;
            }

            public Builder pc_href(String r1) {
                this.mpc_href = r1;
                return this;
            }

            public Builder scene(Scene r1) {
                this.mscene = r1;
                return this;
            }

            public Builder special_url(SpecialURL r1) {
                this.mspecial_url = r1;
                return this;
            }

            public Builder text_content(String r1) {
                this.mtext_content = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AnchorProperty extends ProtoAdapter<AnchorProperty> {
            public ProtoAdapter_AnchorProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, AnchorProperty.class);
            }

            public AnchorProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mhref = "";
                r0.mcontent = "";
                r0.mtext_content = "";
                r0.mi18n_key = "";
                r0.mios_href = "";
                r0.mandroid_href = "";
                r0.mpc_href = "";
                Boolean r1 = Boolean.FALSE;
                r0.mis_custom = r1;
                r0.mclose_card_preview = r1;
                long r2 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L24;
                switch(r3) {
                    case 1: goto L23;
                    case 2: goto L22;
                    case 3: goto L21;
                    case 4: goto L26;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    case 8: goto L13;
                    case 9: goto L12;
                    case 10: goto L28;
                    case 11: goto L7;
                    default: goto L6;
                };
            L26:
                r0.mspecial_url = (SpecialURL) SpecialURL.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L28:
                r0.mscene = (Scene) Scene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mclose_card_preview = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L12:
                r0.mis_custom = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L13:
                r0.mpc_href = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L14:
                r0.mandroid_href = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L15:
                r0.mios_href = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L16:
                r0.mi18n_key = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L21:
                r0.mtext_content = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L22:
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L23:
                r0.mhref = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L24:
                r9.endMessage(r2);
                return r0.m1353build();
            }

            public int encodedSize(AnchorProperty r7) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r7.mhref) + r0.encodedSizeWithTag(2, r7.mcontent);
                String r2 = r7.mtext_content;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = r0.encodedSizeWithTag(3, r2);
            L6:
                int r5 = r1 + r4;
                SpecialURL r6 = r7.mspecial_url;
                if (r6 == null) goto L9;
                int r8 = SpecialURL.ADAPTER.encodedSizeWithTag(4, r6);
            L10:
                int r9 = r5 + r8;
                String r10 = r7.mi18n_key;
                if (r10 == null) goto L13;
                int r11 = r0.encodedSizeWithTag(5, r10);
            L14:
                int r12 = r9 + r11;
                String r13 = r7.mios_href;
                if (r13 == null) goto L17;
                int r14 = r0.encodedSizeWithTag(6, r13);
            L18:
                int r15 = r12 + r14;
                String r16 = r7.mandroid_href;
                if (r16 == null) goto L21;
                int r17 = r0.encodedSizeWithTag(7, r16);
            L22:
                int r18 = r15 + r17;
                String r19 = r7.mpc_href;
                if (r19 == null) goto L25;
                int r20 = r0.encodedSizeWithTag(8, r19);
            L26:
                int r21 = r18 + r20;
                Boolean r22 = r7.mis_custom;
                if (r22 == null) goto L29;
                int r23 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r22);
            L30:
                int r24 = r21 + r23;
                Scene r25 = r7.mscene;
                if (r25 == null) goto L33;
                int r26 = Scene.ADAPTER.encodedSizeWithTag(10, r25);
            L34:
                int r27 = r24 + r26;
                Boolean r28 = r7.mclose_card_preview;
                if (r28 == null) goto L38;
                r3 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r28);
            L38:
                return (r27 + r3) + r7.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1354decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AnchorProperty) r1);
            }

            public void encode(ProtoWriter r5, AnchorProperty r6) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r5, 1, r6.mhref);
                r0.encodeWithTag(r5, 2, r6.mcontent);
                String r1 = r6.mtext_content;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r5, 3, r1);
            L5:
                SpecialURL r2 = r6.mspecial_url;
                if (r2 == null) goto L8;
                SpecialURL.ADAPTER.encodeWithTag(r5, 4, r2);
            L8:
                String r3 = r6.mi18n_key;
                if (r3 == null) goto L11;
                r0.encodeWithTag(r5, 5, r3);
            L11:
                String r4 = r6.mios_href;
                if (r4 == null) goto L14;
                r0.encodeWithTag(r5, 6, r4);
            L14:
                String r7 = r6.mandroid_href;
                if (r7 == null) goto L17;
                r0.encodeWithTag(r5, 7, r7);
            L17:
                String r8 = r6.mpc_href;
                if (r8 == null) goto L20;
                r0.encodeWithTag(r5, 8, r8);
            L20:
                Boolean r9 = r6.mis_custom;
                if (r9 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r5, 9, r9);
            L23:
                Scene r10 = r6.mscene;
                if (r10 == null) goto L26;
                Scene.ADAPTER.encodeWithTag(r5, 10, r10);
            L26:
                Boolean r11 = r6.mclose_card_preview;
                if (r11 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r5, 11, r11);
            L29:
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AnchorProperty) r2);
            }
        }

        public static final enum Scene extends Enum<Scene> implements WireEnum {
            private static final /* synthetic */ Scene[] $VALUES = null;
            public static final ProtoAdapter<Scene> ADAPTER = null;
            public static final Scene COPY_PASTE_ANCHOR = null;
            public static final Scene COPY_PASTE_TEXT = null;
            public static final Scene CUSTOM_EDIT = null;
            public static final Scene SEVER_PARSE = null;
            public static final Scene UNKNOWN = null;
            private final int value;

            static {
                Scene r0 = new Scene("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Scene r1 = new Scene("COPY_PASTE_ANCHOR", 1, 1);
                COPY_PASTE_ANCHOR = r1;
                Scene r3 = new Scene("COPY_PASTE_TEXT", 2, 2);
                COPY_PASTE_TEXT = r3;
                Scene r5 = new Scene("CUSTOM_EDIT", 3, 3);
                CUSTOM_EDIT = r5;
                Scene r7 = new Scene("SEVER_PARSE", 4, 4);
                SEVER_PARSE = r7;
                $VALUES = new Scene[]{r0, r1, r3, r5, r7};
                ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
            }

            public static Scene[] values() {
                return (Scene[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Scene fromValue(int r1) {
                if (r1 == 0) goto L22;
                if (r1 == 1) goto L20;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L16;
                if (r1 == 4) goto L14;
                return null;
            L14:
                return SEVER_PARSE;
            L16:
                return CUSTOM_EDIT;
            L18:
                return COPY_PASTE_TEXT;
            L20:
                return COPY_PASTE_ANCHOR;
            L22:
                return UNKNOWN;
            }

            public static Scene valueOf(String r1) {
                return (Scene) a.a(Scene.class, r1);
            }

            private Scene(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AnchorProperty();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_IS_CUSTOM = r0;
            DEFAULT_CLOSE_CARD_PREVIEW = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1352newBuilder() {
            Builder r0 = new Builder();
            r0.mhref = this.mhref;
            r0.mcontent = this.mcontent;
            r0.mtext_content = this.mtext_content;
            r0.mspecial_url = this.mspecial_url;
            r0.mi18n_key = this.mi18n_key;
            r0.mios_href = this.mios_href;
            r0.mandroid_href = this.mandroid_href;
            r0.mpc_href = this.mpc_href;
            r0.mis_custom = this.mis_custom;
            r0.mscene = this.mscene;
            r0.mclose_card_preview = this.mclose_card_preview;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AnchorProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1352newBuilder();
        }

        public AnchorProperty(String r14, String r15, String r16, SpecialURL r17, String r18, String r19, String r20, String r21, Boolean r22, Scene r23, Boolean r24) {
            this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, ByteString.EMPTY);
        }

        public AnchorProperty(String r2, String r3, String r4, SpecialURL r5, String r6, String r7, String r8, String r9, Boolean r10, Scene r11, Boolean r12, ByteString r13) {
            super(ADAPTER, r13);
            this.mhref = r2;
            this.mcontent = r3;
            this.mtext_content = r4;
            this.mspecial_url = r5;
            this.mi18n_key = r6;
            this.mios_href = r7;
            this.mandroid_href = r8;
            this.mpc_href = r9;
            this.mis_custom = r10;
            this.mscene = r11;
            this.mclose_card_preview = r12;
        }
    }

    public static final class AtProperty extends com.squareup.wire.Message<AtProperty, Builder> {
        public static final ProtoAdapter<AtProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String muser_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<AtProperty, Builder> {
            public String mcontent;
            public String muser_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AtProperty m1356build() {
                String r0 = this.muser_id;
                if (r0 == null) goto L9;
                if (this.mcontent == null) goto L9;
                return new AtProperty(this.muser_id, this.mcontent, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "muser_id", this.mcontent, "mcontent"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1356build();
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder user_id(String r1) {
                this.muser_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AtProperty extends ProtoAdapter<AtProperty> {
            public ProtoAdapter_AtProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, AtProperty.class);
            }

            public AtProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.muser_id = "";
                r0.mcontent = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.muser_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1356build();
            }

            public int encodedSize(AtProperty r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                return (r0.encodedSizeWithTag(1, r5.muser_id) + r0.encodedSizeWithTag(2, r5.mcontent)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1357decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AtProperty) r1);
            }

            public void encode(ProtoWriter r4, AtProperty r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.muser_id);
                r0.encodeWithTag(r4, 2, r5.mcontent);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AtProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AtProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1355newBuilder() {
            Builder r0 = new Builder();
            r0.muser_id = this.muser_id;
            r0.mcontent = this.mcontent;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AtProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1355newBuilder();
        }

        public AtProperty(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public AtProperty(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.muser_id = r2;
            this.mcontent = r3;
        }
    }

    public static final class AtUserGroupProperty extends com.squareup.wire.Message<AtUserGroupProperty, Builder> {
        public static final ProtoAdapter<AtUserGroupProperty> ADAPTER = null;
        public static final String DEFAULT_DEFAULT_GROUP_NAME = "";
        public static final Long DEFAULT_USER_GROUP_ID = null;
        private static final long serialVersionUID = 0;
        public final String mdefault_group_name;
        public final Map<String, String> mi18n_group_name;
        public final Long muser_group_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<AtUserGroupProperty, Builder> {
            public String mdefault_group_name;
            public Map<String, String> mi18n_group_name;
            public Long muser_group_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AtUserGroupProperty m1359build() {
                return new AtUserGroupProperty(this.muser_group_id, this.mdefault_group_name, this.mi18n_group_name, super.buildUnknownFields());
            }

            public Builder() {
                this.mi18n_group_name = Internal.newMutableMap();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1359build();
            }

            public Builder default_group_name(String r1) {
                this.mdefault_group_name = r1;
                return this;
            }

            public Builder i18n_group_name(Map<String, String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mi18n_group_name = r1;
                return this;
            }

            public Builder user_group_id(Long r1) {
                this.muser_group_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AtUserGroupProperty extends ProtoAdapter<AtUserGroupProperty> {
            private final ProtoAdapter<Map<String, String>> mi18n_group_name;

            public ProtoAdapter_AtUserGroupProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, AtUserGroupProperty.class);
                ProtoAdapter r0 = ProtoAdapter.STRING;
                this.mi18n_group_name = ProtoAdapter.newMapAdapter(r0, r0);
            }

            public AtUserGroupProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.muser_group_id = 0L;
                r0.mdefault_group_name = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.muser_group_id = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mdefault_group_name = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mi18n_group_name.putAll((Map) this.mi18n_group_name.decode(r7));
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1359build();
            }

            public int encodedSize(AtUserGroupProperty r5) {
                Long r0 = r5.muser_group_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r5.mdefault_group_name;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                return ((r2 + r1) + this.mi18n_group_name.encodedSizeWithTag(3, r5.mi18n_group_name)) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1360decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AtUserGroupProperty) r1);
            }

            public void encode(ProtoWriter r4, AtUserGroupProperty r5) throws IOException {
                Long r0 = r5.muser_group_id;
                if (r0 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mdefault_group_name;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                this.mi18n_group_name.encodeWithTag(r4, 3, r5.mi18n_group_name);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AtUserGroupProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AtUserGroupProperty();
            DEFAULT_USER_GROUP_ID = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1358newBuilder() {
            Builder r0 = new Builder();
            r0.muser_group_id = this.muser_group_id;
            r0.mdefault_group_name = this.mdefault_group_name;
            r0.mi18n_group_name = Internal.copyOf("mi18n_group_name", this.mi18n_group_name);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AtUserGroupProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1358newBuilder();
        }

        public AtUserGroupProperty(Long r2, String r3, Map<String, String> r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public AtUserGroupProperty(Long r2, String r3, Map<String, String> r4, ByteString r5) {
            super(ADAPTER, r5);
            this.muser_group_id = r2;
            this.mdefault_group_name = r3;
            this.mi18n_group_name = Internal.immutableCopyOf("mi18n_group_name", r4);
        }
    }

    public static final class BoldProperty extends com.squareup.wire.Message<BoldProperty, Builder> {
        public static final ProtoAdapter<BoldProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mi18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<BoldProperty, Builder> {
            public String mcontent;
            public String mi18n_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public BoldProperty m1362build() {
                String r0 = this.mcontent;
                if (r0 == null) goto L7;
                return new BoldProperty(this.mcontent, this.mi18n_key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mcontent"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1362build();
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder i18n_key(String r1) {
                this.mi18n_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_BoldProperty extends ProtoAdapter<BoldProperty> {
            public ProtoAdapter_BoldProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, BoldProperty.class);
            }

            public BoldProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcontent = "";
                r0.mi18n_key = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mi18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1362build();
            }

            public int encodedSize(BoldProperty r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r5.mcontent);
                String r2 = r5.mi18n_key;
                if (r2 == null) goto L5;
                int r3 = r0.encodedSizeWithTag(2, r2);
            L7:
                return (r1 + r3) + r5.unknownFields().size();
            L5:
                r3 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1363decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((BoldProperty) r1);
            }

            public void encode(ProtoWriter r4, BoldProperty r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mcontent);
                String r1 = r5.mi18n_key;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 2, r1);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (BoldProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BoldProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1361newBuilder() {
            Builder r0 = new Builder();
            r0.mcontent = this.mcontent;
            r0.mi18n_key = this.mi18n_key;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return BoldProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1361newBuilder();
        }

        public BoldProperty(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public BoldProperty(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mcontent = r2;
            this.mi18n_key = r3;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<RichTextElement, Builder> {
        public List<String> mchild_ids;
        public ByteString mproperty;
        public Map<String, String> mstyle;
        public List<String> mstyle_keys;
        public Tag mtag;
        public ByteString mupgrade_element;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public RichTextElement m1364build() {
            Tag r0 = this.mtag;
            if (r0 == null) goto L9;
            if (this.mproperty == null) goto L9;
            return new RichTextElement(this.mtag, this.mstyle, this.mproperty, this.mchild_ids, this.mstyle_keys, this.mupgrade_element, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mtag", this.mproperty, "mproperty"});
        }

        public Builder() {
            this.mstyle = Internal.newMutableMap();
            this.mchild_ids = Internal.newMutableList();
            this.mstyle_keys = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1364build();
        }

        public Builder child_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchild_ids = r1;
            return this;
        }

        public Builder property(ByteString r1) {
            this.mproperty = r1;
            return this;
        }

        public Builder style(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mstyle = r1;
            return this;
        }

        public Builder style_keys(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mstyle_keys = r1;
            return this;
        }

        public Builder tag(Tag r1) {
            this.mtag = r1;
            return this;
        }

        public Builder upgrade_element(ByteString r1) {
            this.mupgrade_element = r1;
            return this;
        }
    }

    public static final class ButtonConfirmProperty extends com.squareup.wire.Message<ButtonConfirmProperty, Builder> {
        public static final ProtoAdapter<ButtonConfirmProperty> ADAPTER = null;
        public static final String DEFAULT_CONFIRM = "";
        public static final String DEFAULT_CONFIRM_I18N_KEY = "";
        public static final String DEFAULT_DISMISS = "";
        public static final String DEFAULT_DISMISS_I18N_KEY = "";
        public static final String DEFAULT_TEXT = "";
        public static final String DEFAULT_TEXT_I18N_KEY = "";
        public static final String DEFAULT_TITLE = "";
        public static final String DEFAULT_TITLE_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mconfirm;
        public final String mconfirm_i18n_key;
        public final String mdismiss;
        public final String mdismiss_i18n_key;
        public final String mtext;
        public final String mtext_i18n_key;
        public final String mtitle;
        public final String mtitle_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonConfirmProperty, Builder> {
            public String mconfirm;
            public String mconfirm_i18n_key;
            public String mdismiss;
            public String mdismiss_i18n_key;
            public String mtext;
            public String mtext_i18n_key;
            public String mtitle;
            public String mtitle_i18n_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ButtonConfirmProperty m1366build() {
                String r0 = this.mtitle;
                if (r0 == null) goto L13;
                if (this.mtext == null) goto L13;
                if (this.mconfirm == null) goto L13;
                if (this.mdismiss == null) goto L13;
                return new ButtonConfirmProperty(this.mtitle, this.mtext, this.mconfirm, this.mdismiss, this.mtitle_i18n_key, this.mtext_i18n_key, this.mconfirm_i18n_key, this.mdismiss_i18n_key, super.buildUnknownFields());
            L13:
                throw Internal.missingRequiredFields(new Object[]{r0, "mtitle", this.mtext, "mtext", this.mconfirm, "mconfirm", this.mdismiss, "mdismiss"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1366build();
            }

            public Builder confirm(String r1) {
                this.mconfirm = r1;
                return this;
            }

            public Builder confirm_i18n_key(String r1) {
                this.mconfirm_i18n_key = r1;
                return this;
            }

            public Builder dismiss(String r1) {
                this.mdismiss = r1;
                return this;
            }

            public Builder dismiss_i18n_key(String r1) {
                this.mdismiss_i18n_key = r1;
                return this;
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }

            public Builder text_i18n_key(String r1) {
                this.mtext_i18n_key = r1;
                return this;
            }

            public Builder title(String r1) {
                this.mtitle = r1;
                return this;
            }

            public Builder title_i18n_key(String r1) {
                this.mtitle_i18n_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ButtonConfirmProperty extends ProtoAdapter<ButtonConfirmProperty> {
            public ProtoAdapter_ButtonConfirmProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ButtonConfirmProperty.class);
            }

            public ButtonConfirmProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mtitle = "";
                r0.mtext = "";
                r0.mconfirm = "";
                r0.mdismiss = "";
                r0.mtitle_i18n_key = "";
                r0.mtext_i18n_key = "";
                r0.mconfirm_i18n_key = "";
                r0.mdismiss_i18n_key = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                switch(r3) {
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L7:
                r0.mdismiss_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                r0.mconfirm_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                r0.mtext_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                r0.mtitle_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                r0.mdismiss = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                r0.mconfirm = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L13:
                r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L14:
                r0.mtitle = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L6:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1366build();
            }

            public int encodedSize(ButtonConfirmProperty r6) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = ((r0.encodedSizeWithTag(1, r6.mtitle) + r0.encodedSizeWithTag(2, r6.mtext)) + r0.encodedSizeWithTag(3, r6.mconfirm)) + r0.encodedSizeWithTag(4, r6.mdismiss);
                String r2 = r6.mtitle_i18n_key;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = r0.encodedSizeWithTag(5, r2);
            L6:
                int r5 = r1 + r4;
                String r7 = r6.mtext_i18n_key;
                if (r7 == null) goto L9;
                int r8 = r0.encodedSizeWithTag(6, r7);
            L10:
                int r9 = r5 + r8;
                String r10 = r6.mconfirm_i18n_key;
                if (r10 == null) goto L13;
                int r11 = r0.encodedSizeWithTag(7, r10);
            L14:
                int r12 = r9 + r11;
                String r13 = r6.mdismiss_i18n_key;
                if (r13 == null) goto L18;
                r3 = r0.encodedSizeWithTag(8, r13);
            L18:
                return (r12 + r3) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1367decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ButtonConfirmProperty) r1);
            }

            public void encode(ProtoWriter r4, ButtonConfirmProperty r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mtitle);
                r0.encodeWithTag(r4, 2, r5.mtext);
                r0.encodeWithTag(r4, 3, r5.mconfirm);
                r0.encodeWithTag(r4, 4, r5.mdismiss);
                String r1 = r5.mtitle_i18n_key;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 5, r1);
            L5:
                String r2 = r5.mtext_i18n_key;
                if (r2 == null) goto L8;
                r0.encodeWithTag(r4, 6, r2);
            L8:
                String r3 = r5.mconfirm_i18n_key;
                if (r3 == null) goto L11;
                r0.encodeWithTag(r4, 7, r3);
            L11:
                String r6 = r5.mdismiss_i18n_key;
                if (r6 == null) goto L14;
                r0.encodeWithTag(r4, 8, r6);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ButtonConfirmProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ButtonConfirmProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1365newBuilder() {
            Builder r0 = new Builder();
            r0.mtitle = this.mtitle;
            r0.mtext = this.mtext;
            r0.mconfirm = this.mconfirm;
            r0.mdismiss = this.mdismiss;
            r0.mtitle_i18n_key = this.mtitle_i18n_key;
            r0.mtext_i18n_key = this.mtext_i18n_key;
            r0.mconfirm_i18n_key = this.mconfirm_i18n_key;
            r0.mdismiss_i18n_key = this.mdismiss_i18n_key;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ButtonConfirmProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1365newBuilder();
        }

        public ButtonConfirmProperty(String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18) {
            this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
        }

        public ButtonConfirmProperty(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, ByteString r10) {
            super(ADAPTER, r10);
            this.mtitle = r2;
            this.mtext = r3;
            this.mconfirm = r4;
            this.mdismiss = r5;
            this.mtitle_i18n_key = r6;
            this.mtext_i18n_key = r7;
            this.mconfirm_i18n_key = r8;
            this.mdismiss_i18n_key = r9;
        }
    }

    public static final class ButtonLoadingProperty extends com.squareup.wire.Message<ButtonLoadingProperty, Builder> {
        public static final ProtoAdapter<ButtonLoadingProperty> ADAPTER = null;
        public static final String DEFAULT_BEGIN = "";
        public static final String DEFAULT_BEGIN_I18N_KEY = "";
        public static final String DEFAULT_FAIL = "";
        public static final String DEFAULT_FAIL_I18N_KEY = "";
        public static final String DEFAULT_SUCCESS = "";
        public static final String DEFAULT_SUCCESS_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mbegin;
        public final String mbegin_i18n_key;
        public final String mfail;
        public final String mfail_i18n_key;
        public final String msuccess;
        public final String msuccess_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonLoadingProperty, Builder> {
            public String mbegin;
            public String mbegin_i18n_key;
            public String mfail;
            public String mfail_i18n_key;
            public String msuccess;
            public String msuccess_i18n_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ButtonLoadingProperty m1369build() {
                String r0 = this.mbegin;
                if (r0 == null) goto L11;
                if (this.msuccess == null) goto L11;
                if (this.mfail == null) goto L11;
                return new ButtonLoadingProperty(this.mbegin, this.msuccess, this.mfail, this.mbegin_i18n_key, this.msuccess_i18n_key, this.mfail_i18n_key, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r0, "mbegin", this.msuccess, "msuccess", this.mfail, "mfail"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1369build();
            }

            public Builder begin(String r1) {
                this.mbegin = r1;
                return this;
            }

            public Builder begin_i18n_key(String r1) {
                this.mbegin_i18n_key = r1;
                return this;
            }

            public Builder fail(String r1) {
                this.mfail = r1;
                return this;
            }

            public Builder fail_i18n_key(String r1) {
                this.mfail_i18n_key = r1;
                return this;
            }

            public Builder success(String r1) {
                this.msuccess = r1;
                return this;
            }

            public Builder success_i18n_key(String r1) {
                this.msuccess_i18n_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ButtonLoadingProperty extends ProtoAdapter<ButtonLoadingProperty> {
            public ProtoAdapter_ButtonLoadingProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ButtonLoadingProperty.class);
            }

            public ButtonLoadingProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mbegin = "";
                r0.msuccess = "";
                r0.mfail = "";
                r0.mbegin_i18n_key = "";
                r0.msuccess_i18n_key = "";
                r0.mfail_i18n_key = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L13;
                switch(r3) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r0.mfail_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                r0.msuccess_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                r0.mbegin_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                r0.mfail = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                r0.msuccess = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                r0.mbegin = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L6:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L13:
                r7.endMessage(r1);
                return r0.m1369build();
            }

            public int encodedSize(ButtonLoadingProperty r6) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = (r0.encodedSizeWithTag(1, r6.mbegin) + r0.encodedSizeWithTag(2, r6.msuccess)) + r0.encodedSizeWithTag(3, r6.mfail);
                String r2 = r6.mbegin_i18n_key;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = r0.encodedSizeWithTag(4, r2);
            L6:
                int r5 = r1 + r4;
                String r7 = r6.msuccess_i18n_key;
                if (r7 == null) goto L9;
                int r8 = r0.encodedSizeWithTag(5, r7);
            L10:
                int r9 = r5 + r8;
                String r10 = r6.mfail_i18n_key;
                if (r10 == null) goto L14;
                r3 = r0.encodedSizeWithTag(6, r10);
            L14:
                return (r9 + r3) + r6.unknownFields().size();
            L9:
                r8 = 0;
                goto L10
            L5:
                r4 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1370decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ButtonLoadingProperty) r1);
            }

            public void encode(ProtoWriter r4, ButtonLoadingProperty r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mbegin);
                r0.encodeWithTag(r4, 2, r5.msuccess);
                r0.encodeWithTag(r4, 3, r5.mfail);
                String r1 = r5.mbegin_i18n_key;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 4, r1);
            L5:
                String r2 = r5.msuccess_i18n_key;
                if (r2 == null) goto L8;
                r0.encodeWithTag(r4, 5, r2);
            L8:
                String r3 = r5.mfail_i18n_key;
                if (r3 == null) goto L11;
                r0.encodeWithTag(r4, 6, r3);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ButtonLoadingProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ButtonLoadingProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1368newBuilder() {
            Builder r0 = new Builder();
            r0.mbegin = this.mbegin;
            r0.msuccess = this.msuccess;
            r0.mfail = this.mfail;
            r0.mbegin_i18n_key = this.mbegin_i18n_key;
            r0.msuccess_i18n_key = this.msuccess_i18n_key;
            r0.mfail_i18n_key = this.mfail_i18n_key;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ButtonLoadingProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1368newBuilder();
        }

        public ButtonLoadingProperty(String r9, String r10, String r11, String r12, String r13, String r14) {
            this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
        }

        public ButtonLoadingProperty(String r2, String r3, String r4, String r5, String r6, String r7, ByteString r8) {
            super(ADAPTER, r8);
            this.mbegin = r2;
            this.msuccess = r3;
            this.mfail = r4;
            this.mbegin_i18n_key = r5;
            this.msuccess_i18n_key = r6;
            this.mfail_i18n_key = r7;
        }
    }

    public static final class ButtonProperty extends com.squareup.wire.Message<ButtonProperty, Builder> {
        public static final ProtoAdapter<ButtonProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_ACTIVE = null;
        public static final Boolean DEFAULT_DISABLE = null;
        public static final String DEFAULT_MODE = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final Boolean mactive;
        public final ButtonConfirmProperty mconfirm;
        public final Boolean mdisable;
        public final ButtonLoadingProperty mloading;
        public final String mmode;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonProperty, Builder> {
            public String maction_id;
            public Boolean mactive;
            public ButtonConfirmProperty mconfirm;
            public Boolean mdisable;
            public ButtonLoadingProperty mloading;
            public String mmode;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ButtonProperty m1372build() {
                return new ButtonProperty(this.maction_id, this.mdisable, this.mactive, this.mconfirm, this.mloading, this.mmode, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1372build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder active(Boolean r1) {
                this.mactive = r1;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r1) {
                this.mconfirm = r1;
                return this;
            }

            public Builder disable(Boolean r1) {
                this.mdisable = r1;
                return this;
            }

            public Builder loading(ButtonLoadingProperty r1) {
                this.mloading = r1;
                return this;
            }

            public Builder mode(String r1) {
                this.mmode = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ButtonProperty extends ProtoAdapter<ButtonProperty> {
            public ProtoAdapter_ButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ButtonProperty.class);
            }

            public ButtonProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                Boolean r2 = Boolean.FALSE;
                r0.mdisable = r2;
                r0.mactive = r2;
                r0.mmode = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L13;
                switch(r3) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r0.mmode = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                r0.mloading = (ButtonLoadingProperty) ButtonLoadingProperty.ADAPTER.decode(r7);
                goto L3
            L9:
                r0.mconfirm = (ButtonConfirmProperty) ButtonConfirmProperty.ADAPTER.decode(r7);
                goto L3
            L10:
                r0.mactive = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L11:
                r0.mdisable = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L12:
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L6:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L13:
                r7.endMessage(r1);
                return r0.m1372build();
            }

            public int encodedSize(ButtonProperty r6) {
                String r0 = r6.maction_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r6.mdisable;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Boolean r7 = r6.mactive;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                ButtonConfirmProperty r10 = r6.mconfirm;
                if (r10 == null) goto L17;
                int r11 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                ButtonLoadingProperty r13 = r6.mloading;
                if (r13 == null) goto L21;
                int r14 = ButtonLoadingProperty.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                String r16 = r6.mmode;
                if (r16 == null) goto L26;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
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
            public /* bridge */ /* synthetic */ Object m1373decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ButtonProperty) r1);
            }

            public void encode(ProtoWriter r4, ButtonProperty r5) throws IOException {
                String r0 = r5.maction_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mdisable;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                Boolean r2 = r5.mactive;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
            L11:
                ButtonConfirmProperty r3 = r5.mconfirm;
                if (r3 == null) goto L14;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                ButtonLoadingProperty r6 = r5.mloading;
                if (r6 == null) goto L17;
                ButtonLoadingProperty.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                String r7 = r5.mmode;
                if (r7 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
            L20:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ButtonProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ButtonProperty();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_DISABLE = r0;
            DEFAULT_ACTIVE = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1371newBuilder() {
            Builder r0 = new Builder();
            r0.maction_id = this.maction_id;
            r0.mdisable = this.mdisable;
            r0.mactive = this.mactive;
            r0.mconfirm = this.mconfirm;
            r0.mloading = this.mloading;
            r0.mmode = this.mmode;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1371newBuilder();
        }

        public ButtonProperty(String r9, Boolean r10, Boolean r11, ButtonConfirmProperty r12, ButtonLoadingProperty r13, String r14) {
            this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
        }

        public ButtonProperty(String r2, Boolean r3, Boolean r4, ButtonConfirmProperty r5, ButtonLoadingProperty r6, String r7, ByteString r8) {
            super(ADAPTER, r8);
            this.maction_id = r2;
            this.mdisable = r3;
            this.mactive = r4;
            this.mconfirm = r5;
            this.mloading = r6;
            this.mmode = r7;
        }
    }

    public static final class CodeBlockProperty extends com.squareup.wire.Message<CodeBlockProperty, Builder> {
        public static final ProtoAdapter<CodeBlockProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final Language mlanguage;
        public final List<StyleRef> mstyle_refs;
        public final List<Style> mstyles;

        public static final class Builder extends com.squareup.wire.Message.Builder<CodeBlockProperty, Builder> {
            public String mcontent;
            public Language mlanguage;
            public List<StyleRef> mstyle_refs;
            public List<Style> mstyles;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CodeBlockProperty m1375build() {
                return new CodeBlockProperty(this.mlanguage, this.mcontent, this.mstyle_refs, this.mstyles, super.buildUnknownFields());
            }

            public Builder() {
                this.mstyle_refs = Internal.newMutableList();
                this.mstyles = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1375build();
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder language(Language r1) {
                this.mlanguage = r1;
                return this;
            }

            public Builder style_refs(List<StyleRef> r1) {
                Internal.checkElementsNotNull(r1);
                this.mstyle_refs = r1;
                return this;
            }

            public Builder styles(List<Style> r1) {
                Internal.checkElementsNotNull(r1);
                this.mstyles = r1;
                return this;
            }
        }

        public static final enum Language extends Enum<Language> implements WireEnum {
            private static final /* synthetic */ Language[] $VALUES = null;
            public static final ProtoAdapter<Language> ADAPTER = null;
            public static final Language APACHE = null;
            public static final Language BASH = null;
            public static final Language COFFE_SCRIPT = null;
            public static final Language CPLUSPLUS = null;
            public static final Language CS = null;
            public static final Language DJANGO = null;
            public static final Language GO = null;
            public static final Language HTML = null;
            public static final Language HTTP = null;
            public static final Language JAVA = null;
            public static final Language JS = null;
            public static final Language JSON = null;
            public static final Language KOTLIN = null;
            public static final Language LUA = null;
            public static final Language MAKEFILE = null;
            public static final Language MARKDOWN = null;
            public static final Language NGINX = null;
            public static final Language OBJC = null;
            public static final Language PERL = null;
            public static final Language PHP = null;
            public static final Language PYTHON = null;
            public static final Language RUBY = null;
            public static final Language SCSS = null;
            public static final Language SHELL = null;
            public static final Language SQL = null;
            public static final Language XML = null;
            private final int value;

            static {
                Language r0 = new Language("JS", 0, 0);
                JS = r0;
                Language r1 = new Language("APACHE", 1, 1);
                APACHE = r1;
                Language r3 = new Language("BASH", 2, 2);
                BASH = r3;
                Language r5 = new Language("CS", 3, 3);
                CS = r5;
                Language r7 = new Language("CPLUSPLUS", 4, 4);
                CPLUSPLUS = r7;
                Language r9 = new Language("COFFE_SCRIPT", 5, 5);
                COFFE_SCRIPT = r9;
                Language r11 = new Language("HTML", 6, 6);
                HTML = r11;
                Language r13 = new Language("XML", 7, 7);
                XML = r13;
                Language r15 = new Language("HTTP", 8, 8);
                HTTP = r15;
                Language r14 = new Language("JSON", 9, 9);
                JSON = r14;
                Language r12 = new Language("JAVA", 10, 10);
                JAVA = r12;
                Language r10 = new Language("MAKEFILE", 11, 11);
                MAKEFILE = r10;
                Language r8 = new Language("MARKDOWN", 12, 12);
                MARKDOWN = r8;
                Language r6 = new Language("NGINX", 13, 13);
                NGINX = r6;
                Language r4 = new Language("OBJC", 14, 14);
                OBJC = r4;
                Language r2 = new Language("PHP", 15, 15);
                PHP = r2;
                Language r16 = new Language("PERL", 16, 16);
                PERL = r16;
                Language r17 = new Language("PYTHON", 17, 17);
                PYTHON = r17;
                Language r18 = new Language("RUBY", 18, 18);
                RUBY = r18;
                Language r19 = new Language("SQL", 19, 19);
                SQL = r19;
                Language r20 = new Language("SHELL", 20, 20);
                SHELL = r20;
                Language r21 = new Language("GO", 21, 21);
                GO = r21;
                Language r22 = new Language("SCSS", 22, 22);
                SCSS = r22;
                Language r23 = new Language("LUA", 23, 23);
                LUA = r23;
                Language r24 = new Language("DJANGO", 24, 24);
                DJANGO = r24;
                Language r25 = new Language("KOTLIN", 25, 25);
                KOTLIN = r25;
                $VALUES = new Language[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25};
                ADAPTER = ProtoAdapter.newEnumAdapter(Language.class);
            }

            public static Language[] values() {
                return (Language[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Language fromValue(int r0) {
                switch(r0) {
                    case 0: goto L56;
                    case 1: goto L54;
                    case 2: goto L52;
                    case 3: goto L50;
                    case 4: goto L48;
                    case 5: goto L46;
                    case 6: goto L44;
                    case 7: goto L42;
                    case 8: goto L40;
                    case 9: goto L38;
                    case 10: goto L36;
                    case 11: goto L34;
                    case 12: goto L32;
                    case 13: goto L30;
                    case 14: goto L28;
                    case 15: goto L26;
                    case 16: goto L24;
                    case 17: goto L22;
                    case 18: goto L20;
                    case 19: goto L18;
                    case 20: goto L16;
                    case 21: goto L14;
                    case 22: goto L12;
                    case 23: goto L10;
                    case 24: goto L8;
                    case 25: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return KOTLIN;
            L8:
                return DJANGO;
            L10:
                return LUA;
            L12:
                return SCSS;
            L14:
                return GO;
            L16:
                return SHELL;
            L18:
                return SQL;
            L20:
                return RUBY;
            L22:
                return PYTHON;
            L24:
                return PERL;
            L26:
                return PHP;
            L28:
                return OBJC;
            L30:
                return NGINX;
            L32:
                return MARKDOWN;
            L34:
                return MAKEFILE;
            L36:
                return JAVA;
            L38:
                return JSON;
            L40:
                return HTTP;
            L42:
                return XML;
            L44:
                return HTML;
            L46:
                return COFFE_SCRIPT;
            L48:
                return CPLUSPLUS;
            L50:
                return CS;
            L52:
                return BASH;
            L54:
                return APACHE;
            L56:
                return JS;
            }

            public static Language valueOf(String r1) {
                return (Language) a.a(Language.class, r1);
            }

            private Language(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_CodeBlockProperty extends ProtoAdapter<CodeBlockProperty> {
            public ProtoAdapter_CodeBlockProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, CodeBlockProperty.class);
            }

            public CodeBlockProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mcontent = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mlanguage = (Language) Language.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mstyle_refs.add((StyleRef) StyleRef.ADAPTER.decode(r9));
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mstyles.add((Style) Style.ADAPTER.decode(r9));
                goto L3
            L13:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m1375build();
            }

            public int encodedSize(CodeBlockProperty r5) {
                Language r0 = r5.mlanguage;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Language.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r5.mcontent;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                return (((r2 + r1) + StyleRef.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mstyle_refs)) + Style.ADAPTER.asRepeated().encodedSizeWithTag(4, r5.mstyles)) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1376decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CodeBlockProperty) r1);
            }

            public void encode(ProtoWriter r4, CodeBlockProperty r5) throws IOException {
                Language r0 = r5.mlanguage;
                if (r0 == null) goto L5;
                Language.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mcontent;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                StyleRef.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mstyle_refs);
                Style.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mstyles);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CodeBlockProperty) r2);
            }
        }

        public static final class Style extends com.squareup.wire.Message<Style, Builder> {
            public static final ProtoAdapter<Style> ADAPTER = null;
            public static final String DEFAULT_NAME = "";
            public static final String DEFAULT_VALUE = "";
            private static final long serialVersionUID = 0;
            public final String mname;
            public final StyleType mtype;
            public final String mvalue;

            public static final class Builder extends com.squareup.wire.Message.Builder<Style, Builder> {
                public String mname;
                public StyleType mtype;
                public String mvalue;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public Style m1378build() {
                    return new Style(this.mtype, this.mname, this.mvalue, super.buildUnknownFields());
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1378build();
                }

                public Builder name(String r1) {
                    this.mname = r1;
                    return this;
                }

                public Builder type(StyleType r1) {
                    this.mtype = r1;
                    return this;
                }

                public Builder value(String r1) {
                    this.mvalue = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_Style extends ProtoAdapter<Style> {
                public ProtoAdapter_Style() {
                    super(FieldEncoding.LENGTH_DELIMITED, Style.class);
                }

                public Style decode(ProtoReader r9) throws IOException {
                    Builder r0 = new Builder();
                    r0.mname = "";
                    r0.mvalue = "";
                    long r1 = r9.beginMessage();
                L3:
                    int r3 = r9.nextTag();
                    if (r3 == (-1)) goto L18;
                    if (r3 != 1) goto L8;
                    r0.mtype = (StyleType) StyleType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.mname = (String) ProtoAdapter.STRING.decode(r9);
                    goto L3
                L10:
                    if (r3 != 3) goto L11;
                    r0.mvalue = (String) ProtoAdapter.STRING.decode(r9);
                    goto L3
                L11:
                    FieldEncoding r4 = r9.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                    goto L3
                L18:
                    r9.endMessage(r1);
                    return r0.m1378build();
                }

                public int encodedSize(Style r6) {
                    StyleType r0 = r6.mtype;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = StyleType.ADAPTER.encodedSizeWithTag(1, r0);
                L6:
                    String r3 = r6.mname;
                    if (r3 == null) goto L9;
                    int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
                L10:
                    int r5 = r2 + r4;
                    String r7 = r6.mvalue;
                    if (r7 == null) goto L14;
                    r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
                L14:
                    return (r5 + r1) + r6.unknownFields().size();
                L9:
                    r4 = 0;
                    goto L10
                L5:
                    r2 = 0;
                    goto L6
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1379decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((Style) r1);
                }

                public void encode(ProtoWriter r4, Style r5) throws IOException {
                    StyleType r0 = r5.mtype;
                    if (r0 == null) goto L5;
                    StyleType.ADAPTER.encodeWithTag(r4, 1, r0);
                L5:
                    String r1 = r5.mname;
                    if (r1 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
                L8:
                    String r2 = r5.mvalue;
                    if (r2 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
                L11:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (Style) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Style();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1377newBuilder() {
                Builder r0 = new Builder();
                r0.mtype = this.mtype;
                r0.mname = this.mname;
                r0.mvalue = this.mvalue;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return Style.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1377newBuilder();
            }

            public Style(StyleType r2, String r3, String r4) {
                this(r2, r3, r4, ByteString.EMPTY);
            }

            public Style(StyleType r2, String r3, String r4, ByteString r5) {
                super(ADAPTER, r5);
                this.mtype = r2;
                this.mname = r3;
                this.mvalue = r4;
            }
        }

        public static final class StyleRef extends com.squareup.wire.Message<StyleRef, Builder> {
            public static final ProtoAdapter<StyleRef> ADAPTER = null;
            public static final Integer DEFAULT_LENGTH = null;
            public static final Integer DEFAULT_LOCATION = null;
            private static final long serialVersionUID = 0;
            public final Integer mlength;
            public final Integer mlocation;
            public final List<Integer> mstyle_ids;

            public static final class Builder extends com.squareup.wire.Message.Builder<StyleRef, Builder> {
                public Integer mlength;
                public Integer mlocation;
                public List<Integer> mstyle_ids;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public StyleRef m1381build() {
                    return new StyleRef(this.mlocation, this.mlength, this.mstyle_ids, super.buildUnknownFields());
                }

                public Builder() {
                    this.mstyle_ids = Internal.newMutableList();
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1381build();
                }

                public Builder length(Integer r1) {
                    this.mlength = r1;
                    return this;
                }

                public Builder location(Integer r1) {
                    this.mlocation = r1;
                    return this;
                }

                public Builder style_ids(List<Integer> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mstyle_ids = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_StyleRef extends ProtoAdapter<StyleRef> {
                public ProtoAdapter_StyleRef() {
                    super(FieldEncoding.LENGTH_DELIMITED, StyleRef.class);
                }

                public StyleRef decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.mlocation = 0;
                    r0.mlength = 0;
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L15;
                    if (r3 != 1) goto L8;
                    r0.mlocation = (Integer) ProtoAdapter.INT32.decode(r7);
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.mlength = (Integer) ProtoAdapter.INT32.decode(r7);
                    goto L3
                L10:
                    if (r3 != 3) goto L11;
                    r0.mstyle_ids.add((Integer) ProtoAdapter.INT32.decode(r7));
                    goto L3
                L11:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L15:
                    r7.endMessage(r1);
                    return r0.m1381build();
                }

                public int encodedSize(StyleRef r5) {
                    Integer r0 = r5.mlocation;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
                L6:
                    Integer r3 = r5.mlength;
                    if (r3 == null) goto L10;
                    r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
                L10:
                    return ((r2 + r1) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(3, r5.mstyle_ids)) + r5.unknownFields().size();
                L5:
                    r2 = 0;
                    goto L6
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1382decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((StyleRef) r1);
                }

                public void encode(ProtoWriter r4, StyleRef r5) throws IOException {
                    Integer r0 = r5.mlocation;
                    if (r0 == null) goto L5;
                    ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
                L5:
                    Integer r1 = r5.mlength;
                    if (r1 == null) goto L8;
                    ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
                L8:
                    ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 3, r5.mstyle_ids);
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (StyleRef) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_StyleRef();
                DEFAULT_LOCATION = 0;
                DEFAULT_LENGTH = 0;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1380newBuilder() {
                Builder r0 = new Builder();
                r0.mlocation = this.mlocation;
                r0.mlength = this.mlength;
                r0.mstyle_ids = Internal.copyOf("mstyle_ids", this.mstyle_ids);
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return StyleRef.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1380newBuilder();
            }

            public StyleRef(Integer r2, Integer r3, List<Integer> r4) {
                this(r2, r3, r4, ByteString.EMPTY);
            }

            public StyleRef(Integer r2, Integer r3, List<Integer> r4, ByteString r5) {
                super(ADAPTER, r5);
                this.mlocation = r2;
                this.mlength = r3;
                this.mstyle_ids = Internal.immutableCopyOf("mstyle_ids", r4);
            }
        }

        public static final enum StyleType extends Enum<StyleType> implements WireEnum {
            private static final /* synthetic */ StyleType[] $VALUES = null;
            public static final ProtoAdapter<StyleType> ADAPTER = null;
            public static final StyleType CUSTOMIZE = null;
            public static final StyleType GRAMMAR = null;
            private final int value;

            static {
                StyleType r0 = new StyleType("CUSTOMIZE", 0, 0);
                CUSTOMIZE = r0;
                StyleType r1 = new StyleType("GRAMMAR", 1, 1);
                GRAMMAR = r1;
                $VALUES = new StyleType[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(StyleType.class);
            }

            public static StyleType[] values() {
                return (StyleType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static StyleType fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return GRAMMAR;
            L10:
                return CUSTOMIZE;
            }

            public static StyleType valueOf(String r1) {
                return (StyleType) a.a(StyleType.class, r1);
            }

            private StyleType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CodeBlockProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1374newBuilder() {
            Builder r0 = new Builder();
            r0.mlanguage = this.mlanguage;
            r0.mcontent = this.mcontent;
            r0.mstyle_refs = Internal.copyOf("mstyle_refs", this.mstyle_refs);
            r0.mstyles = Internal.copyOf("mstyles", this.mstyles);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CodeBlockProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1374newBuilder();
        }

        public CodeBlockProperty(Language r7, String r8, List<StyleRef> r9, List<Style> r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public CodeBlockProperty(Language r2, String r3, List<StyleRef> r4, List<Style> r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mlanguage = r2;
            this.mcontent = r3;
            this.mstyle_refs = Internal.immutableCopyOf("mstyle_refs", r4);
            this.mstyles = Internal.immutableCopyOf("mstyles", r5);
        }
    }

    public static final class CodeBlockV2Property extends com.squareup.wire.Message<CodeBlockV2Property, Builder> {
        public static final ProtoAdapter<CodeBlockV2Property> ADAPTER = null;
        public static final Integer DEFAULT_VERSION = null;
        public static final Boolean DEFAULT_WORD_WRAP = null;
        private static final long serialVersionUID = 0;
        public final List<LineContent> mcontents;
        public final Language mlanguage;
        public final Integer mversion;
        public final Boolean mword_wrap;

        public static final class Builder extends com.squareup.wire.Message.Builder<CodeBlockV2Property, Builder> {
            public List<LineContent> mcontents;
            public Language mlanguage;
            public Integer mversion;
            public Boolean mword_wrap;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CodeBlockV2Property m1384build() {
                return new CodeBlockV2Property(this.mlanguage, this.mcontents, this.mword_wrap, this.mversion, super.buildUnknownFields());
            }

            public Builder() {
                this.mcontents = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1384build();
            }

            public Builder contents(List<LineContent> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcontents = r1;
                return this;
            }

            public Builder language(Language r1) {
                this.mlanguage = r1;
                return this;
            }

            public Builder version(Integer r1) {
                this.mversion = r1;
                return this;
            }

            public Builder word_wrap(Boolean r1) {
                this.mword_wrap = r1;
                return this;
            }
        }

        public static final class Content extends com.squareup.wire.Message<Content, Builder> {
            public static final ProtoAdapter<Content> ADAPTER = null;
            public static final String DEFAULT_CONTENT = "";
            private static final long serialVersionUID = 0;
            public final String mcontent;
            public final Map<String, String> mstyle;
            public final ContentType mtype;

            public static final class Builder extends com.squareup.wire.Message.Builder<Content, Builder> {
                public String mcontent;
                public Map<String, String> mstyle;
                public ContentType mtype;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public Content m1386build() {
                    return new Content(this.mcontent, this.mtype, this.mstyle, super.buildUnknownFields());
                }

                public Builder() {
                    this.mstyle = Internal.newMutableMap();
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1386build();
                }

                public Builder content(String r1) {
                    this.mcontent = r1;
                    return this;
                }

                public Builder style(Map<String, String> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mstyle = r1;
                    return this;
                }

                public Builder type(ContentType r1) {
                    this.mtype = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_Content extends ProtoAdapter<Content> {
                private final ProtoAdapter<Map<String, String>> mstyle;

                public ProtoAdapter_Content() {
                    super(FieldEncoding.LENGTH_DELIMITED, Content.class);
                    ProtoAdapter r0 = ProtoAdapter.STRING;
                    this.mstyle = ProtoAdapter.newMapAdapter(r0, r0);
                }

                public Content decode(ProtoReader r9) throws IOException {
                    Builder r0 = new Builder();
                    r0.mcontent = "";
                    long r1 = r9.beginMessage();
                L3:
                    int r3 = r9.nextTag();
                    if (r3 == (-1)) goto L18;
                    if (r3 != 1) goto L8;
                    r0.mcontent = (String) ProtoAdapter.STRING.decode(r9);
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.mtype = (ContentType) ContentType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
                L15:
                    e = move-exception;
                    r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r3 != 3) goto L11;
                    r0.mstyle.putAll((Map) this.mstyle.decode(r9));
                    goto L3
                L11:
                    FieldEncoding r4 = r9.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                    goto L3
                L18:
                    r9.endMessage(r1);
                    return r0.m1386build();
                }

                public int encodedSize(Content r5) {
                    String r0 = r5.mcontent;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
                L6:
                    ContentType r3 = r5.mtype;
                    if (r3 == null) goto L10;
                    r1 = ContentType.ADAPTER.encodedSizeWithTag(2, r3);
                L10:
                    return ((r2 + r1) + this.mstyle.encodedSizeWithTag(3, r5.mstyle)) + r5.unknownFields().size();
                L5:
                    r2 = 0;
                    goto L6
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1387decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((Content) r1);
                }

                public void encode(ProtoWriter r4, Content r5) throws IOException {
                    String r0 = r5.mcontent;
                    if (r0 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
                L5:
                    ContentType r1 = r5.mtype;
                    if (r1 == null) goto L8;
                    ContentType.ADAPTER.encodeWithTag(r4, 2, r1);
                L8:
                    this.mstyle.encodeWithTag(r4, 3, r5.mstyle);
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (Content) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Content();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1385newBuilder() {
                Builder r0 = new Builder();
                r0.mcontent = this.mcontent;
                r0.mtype = this.mtype;
                r0.mstyle = Internal.copyOf("mstyle", this.mstyle);
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return Content.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1385newBuilder();
            }

            public Content(String r2, ContentType r3, Map<String, String> r4) {
                this(r2, r3, r4, ByteString.EMPTY);
            }

            public Content(String r2, ContentType r3, Map<String, String> r4, ByteString r5) {
                super(ADAPTER, r5);
                this.mcontent = r2;
                this.mtype = r3;
                this.mstyle = Internal.immutableCopyOf("mstyle", r4);
            }
        }

        public static final enum ContentType extends Enum<ContentType> implements WireEnum {
            private static final /* synthetic */ ContentType[] $VALUES = null;
            public static final ProtoAdapter<ContentType> ADAPTER = null;
            public static final ContentType ADDITION = null;
            public static final ContentType ATTR = null;
            public static final ContentType ATTRIBUTE = null;
            public static final ContentType BUILT_IN = null;
            public static final ContentType BULLET = null;
            public static final ContentType CHAR_ESCAPE = null;
            public static final ContentType CLASS = null;
            public static final ContentType CODE = null;
            public static final ContentType COMMENT = null;
            public static final ContentType DELETION = null;
            public static final ContentType DOCTAG = null;
            public static final ContentType EMPHASIS = null;
            public static final ContentType FORMULA = null;
            public static final ContentType FUNCTION = null;
            public static final ContentType KEYWORD = null;
            public static final ContentType LINK = null;
            public static final ContentType LITERAL = null;
            public static final ContentType META = null;
            public static final ContentType META_KEYWORD = null;
            public static final ContentType META_PROMPT = null;
            public static final ContentType META_STRING = null;
            public static final ContentType NAME = null;
            public static final ContentType NUMBER = null;
            public static final ContentType OPERATOR = null;
            public static final ContentType PARAMS = null;
            public static final ContentType PROPERTY = null;
            public static final ContentType PUNCTUATION = null;
            public static final ContentType QUOTE = null;
            public static final ContentType REGEXP = null;
            public static final ContentType SECTION = null;
            public static final ContentType SELECTOR_ATTR = null;
            public static final ContentType SELECTOR_CLASS = null;
            public static final ContentType SELECTOR_ID = null;
            public static final ContentType SELECTOR_PSEUDO = null;
            public static final ContentType SELECTOR_TAG = null;
            public static final ContentType STRING = null;
            public static final ContentType SUBST = null;
            public static final ContentType SYMBOL = null;
            public static final ContentType TAG = null;
            public static final ContentType TEMPLATE_TAG = null;
            public static final ContentType TEMPLATE_VARIABLE = null;
            public static final ContentType TEXT = null;
            public static final ContentType TITLE = null;
            public static final ContentType TITLE_CLASS = null;
            public static final ContentType TITLE_CLASS_INHERITED = null;
            public static final ContentType TITLE_FUNCTION = null;
            public static final ContentType TITLE_FUNCTION_INVOKE = null;
            public static final ContentType TYPE = null;
            public static final ContentType VARIABLE = null;
            public static final ContentType VARIABLE_CONSTANT = null;
            public static final ContentType VARIABLE_LANGUAGE = null;
            private final int value;

            static {
                ContentType r0 = new ContentType("TEXT", 0, 0);
                TEXT = r0;
                ContentType r1 = new ContentType("KEYWORD", 1, 1);
                KEYWORD = r1;
                ContentType r3 = new ContentType("BUILT_IN", 2, 2);
                BUILT_IN = r3;
                ContentType r5 = new ContentType("TYPE", 3, 3);
                TYPE = r5;
                ContentType r7 = new ContentType("LITERAL", 4, 4);
                LITERAL = r7;
                ContentType r9 = new ContentType("NUMBER", 5, 5);
                NUMBER = r9;
                ContentType r11 = new ContentType("OPERATOR", 6, 6);
                OPERATOR = r11;
                ContentType r13 = new ContentType("PUNCTUATION", 7, 7);
                PUNCTUATION = r13;
                ContentType r15 = new ContentType("PROPERTY", 8, 8);
                PROPERTY = r15;
                ContentType r14 = new ContentType("REGEXP", 9, 9);
                REGEXP = r14;
                ContentType r12 = new ContentType("STRING", 10, 10);
                STRING = r12;
                ContentType r10 = new ContentType("CHAR_ESCAPE", 11, 11);
                CHAR_ESCAPE = r10;
                ContentType r8 = new ContentType("SUBST", 12, 12);
                SUBST = r8;
                ContentType r6 = new ContentType("SYMBOL", 13, 13);
                SYMBOL = r6;
                ContentType r4 = new ContentType("CLASS", 14, 14);
                CLASS = r4;
                ContentType r2 = new ContentType("FUNCTION", 15, 15);
                FUNCTION = r2;
                ContentType r16 = new ContentType("VARIABLE", 16, 16);
                VARIABLE = r16;
                ContentType r17 = new ContentType("VARIABLE_LANGUAGE", 17, 17);
                VARIABLE_LANGUAGE = r17;
                ContentType r18 = new ContentType("VARIABLE_CONSTANT", 18, 18);
                VARIABLE_CONSTANT = r18;
                ContentType r19 = new ContentType("TITLE", 19, 19);
                TITLE = r19;
                ContentType r20 = new ContentType("TITLE_CLASS", 20, 20);
                TITLE_CLASS = r20;
                ContentType r21 = new ContentType("TITLE_CLASS_INHERITED", 21, 21);
                TITLE_CLASS_INHERITED = r21;
                ContentType r22 = new ContentType("TITLE_FUNCTION", 22, 22);
                TITLE_FUNCTION = r22;
                ContentType r23 = new ContentType("TITLE_FUNCTION_INVOKE", 23, 23);
                TITLE_FUNCTION_INVOKE = r23;
                ContentType r24 = new ContentType("PARAMS", 24, 24);
                PARAMS = r24;
                ContentType r25 = new ContentType("COMMENT", 25, 25);
                COMMENT = r25;
                ContentType r26 = new ContentType("DOCTAG", 26, 26);
                DOCTAG = r26;
                ContentType r27 = new ContentType("META", 27, 27);
                META = r27;
                ContentType r28 = new ContentType("META_PROMPT", 28, 28);
                META_PROMPT = r28;
                ContentType r29 = new ContentType("META_KEYWORD", 29, 29);
                META_KEYWORD = r29;
                ContentType r30 = new ContentType("META_STRING", 30, 30);
                META_STRING = r30;
                ContentType r31 = new ContentType("SECTION", 31, 31);
                SECTION = r31;
                ContentType r32 = new ContentType("TAG", 32, 32);
                TAG = r32;
                ContentType r33 = new ContentType("NAME", 33, 33);
                NAME = r33;
                ContentType r34 = new ContentType("ATTR", 34, 34);
                ATTR = r34;
                ContentType r35 = new ContentType("ATTRIBUTE", 35, 35);
                ATTRIBUTE = r35;
                ContentType r36 = new ContentType("BULLET", 36, 36);
                BULLET = r36;
                ContentType r37 = new ContentType("CODE", 37, 37);
                CODE = r37;
                ContentType r38 = new ContentType("EMPHASIS", 38, 38);
                EMPHASIS = r38;
                ContentType r39 = new ContentType("FORMULA", 39, 39);
                FORMULA = r39;
                ContentType r40 = new ContentType("LINK", 40, 40);
                LINK = r40;
                ContentType r41 = new ContentType("QUOTE", 41, 41);
                QUOTE = r41;
                ContentType r42 = new ContentType("SELECTOR_TAG", 42, 42);
                SELECTOR_TAG = r42;
                ContentType r43 = new ContentType("SELECTOR_ID", 43, 43);
                SELECTOR_ID = r43;
                ContentType r44 = new ContentType("SELECTOR_CLASS", 44, 44);
                SELECTOR_CLASS = r44;
                ContentType r45 = new ContentType("SELECTOR_ATTR", 45, 45);
                SELECTOR_ATTR = r45;
                ContentType r46 = new ContentType("SELECTOR_PSEUDO", 46, 46);
                SELECTOR_PSEUDO = r46;
                ContentType r47 = new ContentType("TEMPLATE_TAG", 47, 47);
                TEMPLATE_TAG = r47;
                ContentType r48 = new ContentType("TEMPLATE_VARIABLE", 48, 48);
                TEMPLATE_VARIABLE = r48;
                ContentType r49 = new ContentType("ADDITION", 49, 49);
                ADDITION = r49;
                ContentType r50 = new ContentType("DELETION", 50, 50);
                DELETION = r50;
                $VALUES = new ContentType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50};
                ADAPTER = ProtoAdapter.newEnumAdapter(ContentType.class);
            }

            public static ContentType[] values() {
                return (ContentType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ContentType fromValue(int r0) {
                switch(r0) {
                    case 0: goto L106;
                    case 1: goto L104;
                    case 2: goto L102;
                    case 3: goto L100;
                    case 4: goto L98;
                    case 5: goto L96;
                    case 6: goto L94;
                    case 7: goto L92;
                    case 8: goto L90;
                    case 9: goto L88;
                    case 10: goto L86;
                    case 11: goto L84;
                    case 12: goto L82;
                    case 13: goto L80;
                    case 14: goto L78;
                    case 15: goto L76;
                    case 16: goto L74;
                    case 17: goto L72;
                    case 18: goto L70;
                    case 19: goto L68;
                    case 20: goto L66;
                    case 21: goto L64;
                    case 22: goto L62;
                    case 23: goto L60;
                    case 24: goto L58;
                    case 25: goto L56;
                    case 26: goto L54;
                    case 27: goto L52;
                    case 28: goto L50;
                    case 29: goto L48;
                    case 30: goto L46;
                    case 31: goto L44;
                    case 32: goto L42;
                    case 33: goto L40;
                    case 34: goto L38;
                    case 35: goto L36;
                    case 36: goto L34;
                    case 37: goto L32;
                    case 38: goto L30;
                    case 39: goto L28;
                    case 40: goto L26;
                    case 41: goto L24;
                    case 42: goto L22;
                    case 43: goto L20;
                    case 44: goto L18;
                    case 45: goto L16;
                    case 46: goto L14;
                    case 47: goto L12;
                    case 48: goto L10;
                    case 49: goto L8;
                    case 50: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return DELETION;
            L8:
                return ADDITION;
            L10:
                return TEMPLATE_VARIABLE;
            L12:
                return TEMPLATE_TAG;
            L14:
                return SELECTOR_PSEUDO;
            L16:
                return SELECTOR_ATTR;
            L18:
                return SELECTOR_CLASS;
            L20:
                return SELECTOR_ID;
            L22:
                return SELECTOR_TAG;
            L24:
                return QUOTE;
            L26:
                return LINK;
            L28:
                return FORMULA;
            L30:
                return EMPHASIS;
            L32:
                return CODE;
            L34:
                return BULLET;
            L36:
                return ATTRIBUTE;
            L38:
                return ATTR;
            L40:
                return NAME;
            L42:
                return TAG;
            L44:
                return SECTION;
            L46:
                return META_STRING;
            L48:
                return META_KEYWORD;
            L50:
                return META_PROMPT;
            L52:
                return META;
            L54:
                return DOCTAG;
            L56:
                return COMMENT;
            L58:
                return PARAMS;
            L60:
                return TITLE_FUNCTION_INVOKE;
            L62:
                return TITLE_FUNCTION;
            L64:
                return TITLE_CLASS_INHERITED;
            L66:
                return TITLE_CLASS;
            L68:
                return TITLE;
            L70:
                return VARIABLE_CONSTANT;
            L72:
                return VARIABLE_LANGUAGE;
            L74:
                return VARIABLE;
            L76:
                return FUNCTION;
            L78:
                return CLASS;
            L80:
                return SYMBOL;
            L82:
                return SUBST;
            L84:
                return CHAR_ESCAPE;
            L86:
                return STRING;
            L88:
                return REGEXP;
            L90:
                return PROPERTY;
            L92:
                return PUNCTUATION;
            L94:
                return OPERATOR;
            L96:
                return NUMBER;
            L98:
                return LITERAL;
            L100:
                return TYPE;
            L102:
                return BUILT_IN;
            L104:
                return KEYWORD;
            L106:
                return TEXT;
            }

            public static ContentType valueOf(String r1) {
                return (ContentType) a.a(ContentType.class, r1);
            }

            private ContentType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final enum Language extends Enum<Language> implements WireEnum {
            private static final /* synthetic */ Language[] $VALUES = null;
            public static final Language ABAP = null;
            public static final Language ADA = null;
            public static final ProtoAdapter<Language> ADAPTER = null;
            public static final Language APACHE = null;
            public static final Language APEX = null;
            public static final Language ASSEMBLY = null;
            public static final Language BASH = null;
            public static final Language C = null;
            public static final Language CMAKE = null;
            public static final Language COBOL = null;
            public static final Language COFFEE_SCRIPT = null;
            public static final Language CPP = null;
            public static final Language CSS = null;
            public static final Language C_SHARP = null;
            public static final Language D = null;
            public static final Language DART = null;
            public static final Language DELPHI = null;
            public static final Language DIFF = null;
            public static final Language DJANGO = null;
            public static final Language DOCKER_FILE = null;
            public static final Language ERLANG = null;
            public static final Language FORTRAN = null;
            public static final Language GHERKIN = null;
            public static final Language GO = null;
            public static final Language GRAPHQL = null;
            public static final Language GROOVY = null;
            public static final Language HASKELL = null;
            public static final Language HTML = null;
            public static final Language HTMLBARS = null;
            public static final Language HTTP = null;
            public static final Language JAVA = null;
            public static final Language JAVASCRIPT = null;
            public static final Language JSON = null;
            public static final Language JULIA = null;
            public static final Language KOTLIN = null;
            public static final Language LATEX = null;
            public static final Language LISP = null;
            public static final Language LUA = null;
            public static final Language MAKEFILE = null;
            public static final Language MARKDOWN = null;
            public static final Language MATLAB = null;
            public static final Language NGINX = null;
            public static final Language OBJECTIVE_C = null;
            public static final Language OPENGL_SHADING_LANGUAGE = null;
            public static final Language PERL = null;
            public static final Language PHP = null;
            public static final Language PLAIN_TEXT = null;
            public static final Language POWERSHELL = null;
            public static final Language PROLOG = null;
            public static final Language PROPERTIES = null;
            public static final Language PROTOBUF = null;
            public static final Language PYTHON = null;
            public static final Language R = null;
            public static final Language RUBY = null;
            public static final Language RUST = null;
            public static final Language SAS = null;
            public static final Language SCALA = null;
            public static final Language SCHEME = null;
            public static final Language SCSS = null;
            public static final Language SHELL = null;
            public static final Language SOLIDITY = null;
            public static final Language SQL = null;
            public static final Language SWIFT = null;
            public static final Language THRIFT = null;
            public static final Language TOML = null;
            public static final Language TYPESCRIPT = null;
            public static final Language VBSCRIPT = null;
            public static final Language VISUAL_BASIC = null;
            public static final Language XML = null;
            public static final Language YAML = null;
            private final int value;

            static {
                Language r0 = new Language("PLAIN_TEXT", 0, 0);
                PLAIN_TEXT = r0;
                Language r1 = new Language("ABAP", 1, 1);
                ABAP = r1;
                Language r3 = new Language("ADA", 2, 2);
                ADA = r3;
                Language r5 = new Language("APACHE", 3, 3);
                APACHE = r5;
                Language r7 = new Language("APEX", 4, 4);
                APEX = r7;
                Language r9 = new Language("ASSEMBLY", 5, 5);
                ASSEMBLY = r9;
                Language r11 = new Language("BASH", 6, 6);
                BASH = r11;
                Language r13 = new Language("C_SHARP", 7, 7);
                C_SHARP = r13;
                Language r15 = new Language("CPP", 8, 8);
                CPP = r15;
                Language r14 = new Language("C", 9, 9);
                C = r14;
                Language r12 = new Language("CMAKE", 10, 10);
                CMAKE = r12;
                Language r10 = new Language("COBOL", 11, 11);
                COBOL = r10;
                Language r8 = new Language("CSS", 12, 12);
                CSS = r8;
                Language r6 = new Language("COFFEE_SCRIPT", 13, 13);
                COFFEE_SCRIPT = r6;
                Language r4 = new Language("D", 14, 14);
                D = r4;
                Language r2 = new Language("DART", 15, 15);
                DART = r2;
                Language r16 = new Language("DELPHI", 16, 16);
                DELPHI = r16;
                Language r17 = new Language("DIFF", 17, 17);
                DIFF = r17;
                Language r18 = new Language("DJANGO", 18, 18);
                DJANGO = r18;
                Language r19 = new Language("DOCKER_FILE", 19, 19);
                DOCKER_FILE = r19;
                Language r20 = new Language("ERLANG", 20, 20);
                ERLANG = r20;
                Language r21 = new Language("FORTRAN", 21, 21);
                FORTRAN = r21;
                Language r22 = new Language("GHERKIN", 22, 22);
                GHERKIN = r22;
                Language r23 = new Language("GO", 23, 23);
                GO = r23;
                Language r24 = new Language("GRAPHQL", 24, 24);
                GRAPHQL = r24;
                Language r25 = new Language("GROOVY", 25, 25);
                GROOVY = r25;
                Language r26 = new Language("HTML", 26, 26);
                HTML = r26;
                Language r27 = new Language("HTMLBARS", 27, 27);
                HTMLBARS = r27;
                Language r28 = new Language("HTTP", 28, 28);
                HTTP = r28;
                Language r29 = new Language("HASKELL", 29, 29);
                HASKELL = r29;
                Language r30 = new Language("JSON", 30, 30);
                JSON = r30;
                Language r31 = new Language("JAVA", 31, 31);
                JAVA = r31;
                Language r32 = new Language("JAVASCRIPT", 32, 32);
                JAVASCRIPT = r32;
                Language r33 = new Language("JULIA", 33, 33);
                JULIA = r33;
                Language r34 = new Language("KOTLIN", 34, 34);
                KOTLIN = r34;
                Language r35 = new Language("LATEX", 35, 35);
                LATEX = r35;
                Language r36 = new Language("LISP", 36, 36);
                LISP = r36;
                Language r37 = new Language("LUA", 37, 37);
                LUA = r37;
                Language r38 = new Language("MATLAB", 38, 38);
                MATLAB = r38;
                Language r39 = new Language("MAKEFILE", 39, 39);
                MAKEFILE = r39;
                Language r40 = new Language("MARKDOWN", 40, 40);
                MARKDOWN = r40;
                Language r41 = new Language("NGINX", 41, 41);
                NGINX = r41;
                Language r42 = new Language("OBJECTIVE_C", 42, 42);
                OBJECTIVE_C = r42;
                Language r43 = new Language("OPENGL_SHADING_LANGUAGE", 43, 43);
                OPENGL_SHADING_LANGUAGE = r43;
                Language r44 = new Language("PHP", 44, 44);
                PHP = r44;
                Language r45 = new Language("PERL", 45, 45);
                PERL = r45;
                Language r46 = new Language("POWERSHELL", 46, 46);
                POWERSHELL = r46;
                Language r47 = new Language("PROLOG", 47, 47);
                PROLOG = r47;
                Language r48 = new Language("PROPERTIES", 48, 48);
                PROPERTIES = r48;
                Language r49 = new Language("PROTOBUF", 49, 49);
                PROTOBUF = r49;
                Language r50 = new Language("PYTHON", 50, 50);
                PYTHON = r50;
                Language r51 = new Language("R", 51, 51);
                R = r51;
                Language r52 = new Language("RUBY", 52, 52);
                RUBY = r52;
                Language r53 = new Language("RUST", 53, 53);
                RUST = r53;
                Language r54 = new Language("SAS", 54, 54);
                SAS = r54;
                Language r55 = new Language("SCSS", 55, 55);
                SCSS = r55;
                Language r56 = new Language("SQL", 56, 56);
                SQL = r56;
                Language r57 = new Language("SCALA", 57, 57);
                SCALA = r57;
                Language r58 = new Language("SCHEME", 58, 58);
                SCHEME = r58;
                Language r59 = new Language("SHELL", 59, 59);
                SHELL = r59;
                Language r60 = new Language("SOLIDITY", 60, 60);
                SOLIDITY = r60;
                Language r61 = new Language("SWIFT", 61, 61);
                SWIFT = r61;
                Language r62 = new Language("TOML", 62, 62);
                TOML = r62;
                Language r63 = new Language("THRIFT", 63, 63);
                THRIFT = r63;
                Language r64 = new Language("TYPESCRIPT", 64, 64);
                TYPESCRIPT = r64;
                Language r65 = new Language("VBSCRIPT", 65, 65);
                VBSCRIPT = r65;
                Language r66 = new Language("VISUAL_BASIC", 66, 66);
                VISUAL_BASIC = r66;
                Language r67 = new Language("XML", 67, 67);
                XML = r67;
                Language r68 = new Language("YAML", 68, 68);
                YAML = r68;
                $VALUES = new Language[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68};
                ADAPTER = ProtoAdapter.newEnumAdapter(Language.class);
            }

            public static Language[] values() {
                return (Language[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Language fromValue(int r0) {
                switch(r0) {
                    case 0: goto L142;
                    case 1: goto L140;
                    case 2: goto L138;
                    case 3: goto L136;
                    case 4: goto L134;
                    case 5: goto L132;
                    case 6: goto L130;
                    case 7: goto L128;
                    case 8: goto L126;
                    case 9: goto L124;
                    case 10: goto L122;
                    case 11: goto L120;
                    case 12: goto L118;
                    case 13: goto L116;
                    case 14: goto L114;
                    case 15: goto L112;
                    case 16: goto L110;
                    case 17: goto L108;
                    case 18: goto L106;
                    case 19: goto L104;
                    case 20: goto L102;
                    case 21: goto L100;
                    case 22: goto L98;
                    case 23: goto L96;
                    case 24: goto L94;
                    case 25: goto L92;
                    case 26: goto L90;
                    case 27: goto L88;
                    case 28: goto L86;
                    case 29: goto L84;
                    case 30: goto L82;
                    case 31: goto L80;
                    case 32: goto L78;
                    case 33: goto L76;
                    case 34: goto L74;
                    case 35: goto L72;
                    case 36: goto L70;
                    case 37: goto L68;
                    case 38: goto L66;
                    case 39: goto L64;
                    case 40: goto L62;
                    case 41: goto L60;
                    case 42: goto L58;
                    case 43: goto L56;
                    case 44: goto L54;
                    case 45: goto L52;
                    case 46: goto L50;
                    case 47: goto L48;
                    case 48: goto L46;
                    case 49: goto L44;
                    case 50: goto L42;
                    case 51: goto L40;
                    case 52: goto L38;
                    case 53: goto L36;
                    case 54: goto L34;
                    case 55: goto L32;
                    case 56: goto L30;
                    case 57: goto L28;
                    case 58: goto L26;
                    case 59: goto L24;
                    case 60: goto L22;
                    case 61: goto L20;
                    case 62: goto L18;
                    case 63: goto L16;
                    case 64: goto L14;
                    case 65: goto L12;
                    case 66: goto L10;
                    case 67: goto L8;
                    case 68: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return YAML;
            L8:
                return XML;
            L10:
                return VISUAL_BASIC;
            L12:
                return VBSCRIPT;
            L14:
                return TYPESCRIPT;
            L16:
                return THRIFT;
            L18:
                return TOML;
            L20:
                return SWIFT;
            L22:
                return SOLIDITY;
            L24:
                return SHELL;
            L26:
                return SCHEME;
            L28:
                return SCALA;
            L30:
                return SQL;
            L32:
                return SCSS;
            L34:
                return SAS;
            L36:
                return RUST;
            L38:
                return RUBY;
            L40:
                return R;
            L42:
                return PYTHON;
            L44:
                return PROTOBUF;
            L46:
                return PROPERTIES;
            L48:
                return PROLOG;
            L50:
                return POWERSHELL;
            L52:
                return PERL;
            L54:
                return PHP;
            L56:
                return OPENGL_SHADING_LANGUAGE;
            L58:
                return OBJECTIVE_C;
            L60:
                return NGINX;
            L62:
                return MARKDOWN;
            L64:
                return MAKEFILE;
            L66:
                return MATLAB;
            L68:
                return LUA;
            L70:
                return LISP;
            L72:
                return LATEX;
            L74:
                return KOTLIN;
            L76:
                return JULIA;
            L78:
                return JAVASCRIPT;
            L80:
                return JAVA;
            L82:
                return JSON;
            L84:
                return HASKELL;
            L86:
                return HTTP;
            L88:
                return HTMLBARS;
            L90:
                return HTML;
            L92:
                return GROOVY;
            L94:
                return GRAPHQL;
            L96:
                return GO;
            L98:
                return GHERKIN;
            L100:
                return FORTRAN;
            L102:
                return ERLANG;
            L104:
                return DOCKER_FILE;
            L106:
                return DJANGO;
            L108:
                return DIFF;
            L110:
                return DELPHI;
            L112:
                return DART;
            L114:
                return D;
            L116:
                return COFFEE_SCRIPT;
            L118:
                return CSS;
            L120:
                return COBOL;
            L122:
                return CMAKE;
            L124:
                return C;
            L126:
                return CPP;
            L128:
                return C_SHARP;
            L130:
                return BASH;
            L132:
                return ASSEMBLY;
            L134:
                return APEX;
            L136:
                return APACHE;
            L138:
                return ADA;
            L140:
                return ABAP;
            L142:
                return PLAIN_TEXT;
            }

            public static Language valueOf(String r1) {
                return (Language) a.a(Language.class, r1);
            }

            private Language(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class LineContent extends com.squareup.wire.Message<LineContent, Builder> {
            public static final ProtoAdapter<LineContent> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<Content> mcontents;

            public static final class Builder extends com.squareup.wire.Message.Builder<LineContent, Builder> {
                public List<Content> mcontents;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public LineContent m1389build() {
                    return new LineContent(this.mcontents, super.buildUnknownFields());
                }

                public Builder() {
                    this.mcontents = Internal.newMutableList();
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1389build();
                }

                public Builder contents(List<Content> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mcontents = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_LineContent extends ProtoAdapter<LineContent> {
                public ProtoAdapter_LineContent() {
                    super(FieldEncoding.LENGTH_DELIMITED, LineContent.class);
                }

                public LineContent decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L9;
                    if (r3 != 1) goto L7;
                    r0.mcontents.add((Content) Content.ADAPTER.decode(r7));
                    goto L3
                L7:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L9:
                    r7.endMessage(r1);
                    return r0.m1389build();
                }

                public int encodedSize(LineContent r4) {
                    return Content.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mcontents) + r4.unknownFields().size();
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1390decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((LineContent) r1);
                }

                public void encode(ProtoWriter r4, LineContent r5) throws IOException {
                    Content.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mcontents);
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (LineContent) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_LineContent();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1388newBuilder() {
                Builder r0 = new Builder();
                r0.mcontents = Internal.copyOf("mcontents", this.mcontents);
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return LineContent.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1388newBuilder();
            }

            public LineContent(List<Content> r2) {
                this(r2, ByteString.EMPTY);
            }

            public LineContent(List<Content> r2, ByteString r3) {
                super(ADAPTER, r3);
                this.mcontents = Internal.immutableCopyOf("mcontents", r2);
            }
        }

        public static final class ProtoAdapter_CodeBlockV2Property extends ProtoAdapter<CodeBlockV2Property> {
            public ProtoAdapter_CodeBlockV2Property() {
                super(FieldEncoding.LENGTH_DELIMITED, CodeBlockV2Property.class);
            }

            public CodeBlockV2Property decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mword_wrap = Boolean.FALSE;
                r0.mversion = 0;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mlanguage = (Language) Language.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mcontents.add((LineContent) LineContent.ADAPTER.decode(r9));
                goto L3
            L10:
                if (r3 != 4) goto L12;
                r0.mword_wrap = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L12:
                if (r3 != 5) goto L13;
                r0.mversion = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L13:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m1384build();
            }

            public int encodedSize(CodeBlockV2Property r6) {
                Language r0 = r6.mlanguage;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Language.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                int r3 = r2 + LineContent.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.mcontents);
                Boolean r4 = r6.mword_wrap;
                if (r4 == null) goto L9;
                int r5 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r4);
            L10:
                int r7 = r3 + r5;
                Integer r8 = r6.mversion;
                if (r8 == null) goto L14;
                r1 = ProtoAdapter.INT32.encodedSizeWithTag(5, r8);
            L14:
                return (r7 + r1) + r6.unknownFields().size();
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1391decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CodeBlockV2Property) r1);
            }

            public void encode(ProtoWriter r4, CodeBlockV2Property r5) throws IOException {
                Language r0 = r5.mlanguage;
                if (r0 == null) goto L5;
                Language.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                LineContent.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mcontents);
                Boolean r1 = r5.mword_wrap;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r1);
            L8:
                Integer r2 = r5.mversion;
                if (r2 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r4, 5, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CodeBlockV2Property) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CodeBlockV2Property();
            DEFAULT_WORD_WRAP = Boolean.FALSE;
            DEFAULT_VERSION = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1383newBuilder() {
            Builder r0 = new Builder();
            r0.mlanguage = this.mlanguage;
            r0.mcontents = Internal.copyOf("mcontents", this.mcontents);
            r0.mword_wrap = this.mword_wrap;
            r0.mversion = this.mversion;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CodeBlockV2Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1383newBuilder();
        }

        public CodeBlockV2Property(Language r7, List<LineContent> r8, Boolean r9, Integer r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public CodeBlockV2Property(Language r2, List<LineContent> r3, Boolean r4, Integer r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mlanguage = r2;
            this.mcontents = Internal.immutableCopyOf("mcontents", r3);
            this.mword_wrap = r4;
            this.mversion = r5;
        }
    }

    public static final class CodeProperty extends com.squareup.wire.Message<CodeProperty, Builder> {
        public static final ProtoAdapter<CodeProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CodeProperty, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CodeProperty m1393build() {
                return new CodeProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1393build();
            }
        }

        public static final class ProtoAdapter_CodeProperty extends ProtoAdapter<CodeProperty> {
            public ProtoAdapter_CodeProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, CodeProperty.class);
            }

            public CodeProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1393build();
            }

            public int encodedSize(CodeProperty r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1394decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CodeProperty) r1);
            }

            public void encode(ProtoWriter r1, CodeProperty r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CodeProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CodeProperty();
        }

        public CodeProperty() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1392newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CodeProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1392newBuilder();
        }

        public CodeProperty(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class ColumnProperty extends com.squareup.wire.Message<ColumnProperty, Builder> {
        public static final ProtoAdapter<ColumnProperty> ADAPTER = null;
        public static final Integer DEFAULT_WIDTH = null;
        private static final long serialVersionUID = 0;
        public final Integer mwidth;

        public static final class Builder extends com.squareup.wire.Message.Builder<ColumnProperty, Builder> {
            public Integer mwidth;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ColumnProperty m1396build() {
                return new ColumnProperty(this.mwidth, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1396build();
            }

            public Builder width(Integer r1) {
                this.mwidth = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ColumnProperty extends ProtoAdapter<ColumnProperty> {
            public ProtoAdapter_ColumnProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ColumnProperty.class);
            }

            public ColumnProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mwidth = 0;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mwidth = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1396build();
            }

            public int encodedSize(ColumnProperty r4) {
                Integer r0 = r4.mwidth;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1397decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ColumnProperty) r1);
            }

            public void encode(ProtoWriter r4, ColumnProperty r5) throws IOException {
                Integer r0 = r5.mwidth;
                if (r0 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ColumnProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ColumnProperty();
            DEFAULT_WIDTH = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1395newBuilder() {
            Builder r0 = new Builder();
            r0.mwidth = this.mwidth;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ColumnProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1395newBuilder();
        }

        public ColumnProperty(Integer r2) {
            this(r2, ByteString.EMPTY);
        }

        public ColumnProperty(Integer r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mwidth = r2;
        }
    }

    public static final class ColumnsProperty extends com.squareup.wire.Message<ColumnsProperty, Builder> {
        public static final ProtoAdapter<ColumnsProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ColumnsProperty, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ColumnsProperty m1399build() {
                return new ColumnsProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1399build();
            }
        }

        public static final class ProtoAdapter_ColumnsProperty extends ProtoAdapter<ColumnsProperty> {
            public ProtoAdapter_ColumnsProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ColumnsProperty.class);
            }

            public ColumnsProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1399build();
            }

            public int encodedSize(ColumnsProperty r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1400decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ColumnsProperty) r1);
            }

            public void encode(ProtoWriter r1, ColumnsProperty r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ColumnsProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ColumnsProperty();
        }

        public ColumnsProperty() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1398newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ColumnsProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1398newBuilder();
        }

        public ColumnsProperty(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class DatePickerProperty extends com.squareup.wire.Message<DatePickerProperty, Builder> {
        public static final ProtoAdapter<DatePickerProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_INITIAL_DATE = "";
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ButtonConfirmProperty mconfirm;
        public final String minitial_date;
        public final String mplace_holder;
        public final String mplace_holder_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<DatePickerProperty, Builder> {
            public String maction_id;
            public ButtonConfirmProperty mconfirm;
            public String minitial_date;
            public String mplace_holder;
            public String mplace_holder_i18n_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DatePickerProperty m1402build() {
                return new DatePickerProperty(this.maction_id, this.mplace_holder, this.mplace_holder_i18n_key, this.minitial_date, this.mconfirm, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1402build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r1) {
                this.mconfirm = r1;
                return this;
            }

            public Builder initial_date(String r1) {
                this.minitial_date = r1;
                return this;
            }

            public Builder place_holder(String r1) {
                this.mplace_holder = r1;
                return this;
            }

            public Builder place_holder_i18n_key(String r1) {
                this.mplace_holder_i18n_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DatePickerProperty extends ProtoAdapter<DatePickerProperty> {
            public ProtoAdapter_DatePickerProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DatePickerProperty.class);
            }

            public DatePickerProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                r0.mplace_holder = "";
                r0.mplace_holder_i18n_key = "";
                r0.minitial_date = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mplace_holder = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mplace_holder_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.minitial_date = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mconfirm = (ButtonConfirmProperty) ButtonConfirmProperty.ADAPTER.decode(r7);
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m1402build();
            }

            public int encodedSize(DatePickerProperty r6) {
                String r0 = r6.maction_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mplace_holder;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mplace_holder_i18n_key;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.minitial_date;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                ButtonConfirmProperty r13 = r6.mconfirm;
                if (r13 == null) goto L22;
                r1 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                return (r12 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1403decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DatePickerProperty) r1);
            }

            public void encode(ProtoWriter r4, DatePickerProperty r5) throws IOException {
                String r0 = r5.maction_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mplace_holder;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mplace_holder_i18n_key;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.minitial_date;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                ButtonConfirmProperty r6 = r5.mconfirm;
                if (r6 == null) goto L17;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DatePickerProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DatePickerProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1401newBuilder() {
            Builder r0 = new Builder();
            r0.maction_id = this.maction_id;
            r0.mplace_holder = this.mplace_holder;
            r0.mplace_holder_i18n_key = this.mplace_holder_i18n_key;
            r0.minitial_date = this.minitial_date;
            r0.mconfirm = this.mconfirm;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DatePickerProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1401newBuilder();
        }

        public DatePickerProperty(String r8, String r9, String r10, String r11, ButtonConfirmProperty r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public DatePickerProperty(String r2, String r3, String r4, String r5, ButtonConfirmProperty r6, ByteString r7) {
            super(ADAPTER, r7);
            this.maction_id = r2;
            this.mplace_holder = r3;
            this.mplace_holder_i18n_key = r4;
            this.minitial_date = r5;
            this.mconfirm = r6;
        }
    }

    public static final class DatetimePickerProperty extends com.squareup.wire.Message<DatetimePickerProperty, Builder> {
        public static final ProtoAdapter<DatetimePickerProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_INITIAL_DATETIME = "";
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ButtonConfirmProperty mconfirm;
        public final String minitial_datetime;
        public final String mplace_holder;
        public final String mplace_holder_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<DatetimePickerProperty, Builder> {
            public String maction_id;
            public ButtonConfirmProperty mconfirm;
            public String minitial_datetime;
            public String mplace_holder;
            public String mplace_holder_i18n_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DatetimePickerProperty m1405build() {
                return new DatetimePickerProperty(this.maction_id, this.mplace_holder, this.mplace_holder_i18n_key, this.minitial_datetime, this.mconfirm, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1405build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r1) {
                this.mconfirm = r1;
                return this;
            }

            public Builder initial_datetime(String r1) {
                this.minitial_datetime = r1;
                return this;
            }

            public Builder place_holder(String r1) {
                this.mplace_holder = r1;
                return this;
            }

            public Builder place_holder_i18n_key(String r1) {
                this.mplace_holder_i18n_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DatetimePickerProperty extends ProtoAdapter<DatetimePickerProperty> {
            public ProtoAdapter_DatetimePickerProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DatetimePickerProperty.class);
            }

            public DatetimePickerProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                r0.mplace_holder = "";
                r0.mplace_holder_i18n_key = "";
                r0.minitial_datetime = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mplace_holder = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mplace_holder_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.minitial_datetime = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mconfirm = (ButtonConfirmProperty) ButtonConfirmProperty.ADAPTER.decode(r7);
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m1405build();
            }

            public int encodedSize(DatetimePickerProperty r6) {
                String r0 = r6.maction_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mplace_holder;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mplace_holder_i18n_key;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.minitial_datetime;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                ButtonConfirmProperty r13 = r6.mconfirm;
                if (r13 == null) goto L22;
                r1 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                return (r12 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1406decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DatetimePickerProperty) r1);
            }

            public void encode(ProtoWriter r4, DatetimePickerProperty r5) throws IOException {
                String r0 = r5.maction_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mplace_holder;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mplace_holder_i18n_key;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.minitial_datetime;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                ButtonConfirmProperty r6 = r5.mconfirm;
                if (r6 == null) goto L17;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DatetimePickerProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DatetimePickerProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1404newBuilder() {
            Builder r0 = new Builder();
            r0.maction_id = this.maction_id;
            r0.mplace_holder = this.mplace_holder;
            r0.mplace_holder_i18n_key = this.mplace_holder_i18n_key;
            r0.minitial_datetime = this.minitial_datetime;
            r0.mconfirm = this.mconfirm;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DatetimePickerProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1404newBuilder();
        }

        public DatetimePickerProperty(String r8, String r9, String r10, String r11, ButtonConfirmProperty r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public DatetimePickerProperty(String r2, String r3, String r4, String r5, ButtonConfirmProperty r6, ByteString r7) {
            super(ADAPTER, r7);
            this.maction_id = r2;
            this.mplace_holder = r3;
            this.mplace_holder_i18n_key = r4;
            this.minitial_datetime = r5;
            this.mconfirm = r6;
        }
    }

    public static final class DivProperty extends com.squareup.wire.Message<DivProperty, Builder> {
        public static final ProtoAdapter<DivProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<DivProperty, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DivProperty m1408build() {
                return new DivProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1408build();
            }
        }

        public static final class ProtoAdapter_DivProperty extends ProtoAdapter<DivProperty> {
            public ProtoAdapter_DivProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DivProperty.class);
            }

            public DivProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1408build();
            }

            public int encodedSize(DivProperty r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1409decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DivProperty) r1);
            }

            public void encode(ProtoWriter r1, DivProperty r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DivProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DivProperty();
        }

        public DivProperty() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1407newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DivProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1407newBuilder();
        }

        public DivProperty(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class DocsProperty extends com.squareup.wire.Message<DocsProperty, Builder> {
        public static final ProtoAdapter<DocsProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<DocsProperty, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DocsProperty m1411build() {
                return new DocsProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1411build();
            }
        }

        public static final class ProtoAdapter_DocsProperty extends ProtoAdapter<DocsProperty> {
            public ProtoAdapter_DocsProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DocsProperty.class);
            }

            public DocsProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1411build();
            }

            public int encodedSize(DocsProperty r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1412decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DocsProperty) r1);
            }

            public void encode(ProtoWriter r1, DocsProperty r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DocsProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocsProperty();
        }

        public DocsProperty() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1410newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DocsProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1410newBuilder();
        }

        public DocsProperty(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class EmotionProperty extends com.squareup.wire.Message<EmotionProperty, Builder> {
        public static final ProtoAdapter<EmotionProperty> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mkey;

        public static final class Builder extends com.squareup.wire.Message.Builder<EmotionProperty, Builder> {
            public String mkey;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public EmotionProperty m1414build() {
                String r0 = this.mkey;
                if (r0 == null) goto L7;
                return new EmotionProperty(this.mkey, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mkey"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1414build();
            }

            public Builder key(String r1) {
                this.mkey = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_EmotionProperty extends ProtoAdapter<EmotionProperty> {
            public ProtoAdapter_EmotionProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, EmotionProperty.class);
            }

            public EmotionProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mkey = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1414build();
            }

            public int encodedSize(EmotionProperty r4) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r4.mkey) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1415decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((EmotionProperty) r1);
            }

            public void encode(ProtoWriter r4, EmotionProperty r5) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mkey);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (EmotionProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EmotionProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1413newBuilder() {
            Builder r0 = new Builder();
            r0.mkey = this.mkey;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return EmotionProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1413newBuilder();
        }

        public EmotionProperty(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public EmotionProperty(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mkey = r2;
        }
    }

    public static final class FigureProperty extends com.squareup.wire.Message<FigureProperty, Builder> {
        public static final ProtoAdapter<FigureProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<FigureProperty, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public FigureProperty m1417build() {
                return new FigureProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1417build();
            }
        }

        public static final class ProtoAdapter_FigureProperty extends ProtoAdapter<FigureProperty> {
            public ProtoAdapter_FigureProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, FigureProperty.class);
            }

            public FigureProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1417build();
            }

            public int encodedSize(FigureProperty r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1418decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((FigureProperty) r1);
            }

            public void encode(ProtoWriter r1, FigureProperty r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (FigureProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FigureProperty();
        }

        public FigureProperty() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1416newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return FigureProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1416newBuilder();
        }

        public FigureProperty(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class H1Property extends com.squareup.wire.Message<H1Property, Builder> {
        public static final ProtoAdapter<H1Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H1Property, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public H1Property m1420build() {
                return new H1Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1420build();
            }
        }

        public static final class ProtoAdapter_H1Property extends ProtoAdapter<H1Property> {
            public ProtoAdapter_H1Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H1Property.class);
            }

            public H1Property decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1420build();
            }

            public int encodedSize(H1Property r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1421decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((H1Property) r1);
            }

            public void encode(ProtoWriter r1, H1Property r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (H1Property) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H1Property();
        }

        public H1Property() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1419newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return H1Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1419newBuilder();
        }

        public H1Property(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class H2Property extends com.squareup.wire.Message<H2Property, Builder> {
        public static final ProtoAdapter<H2Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H2Property, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public H2Property m1423build() {
                return new H2Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1423build();
            }
        }

        public static final class ProtoAdapter_H2Property extends ProtoAdapter<H2Property> {
            public ProtoAdapter_H2Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H2Property.class);
            }

            public H2Property decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1423build();
            }

            public int encodedSize(H2Property r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1424decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((H2Property) r1);
            }

            public void encode(ProtoWriter r1, H2Property r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (H2Property) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H2Property();
        }

        public H2Property() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1422newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return H2Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1422newBuilder();
        }

        public H2Property(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class H3Property extends com.squareup.wire.Message<H3Property, Builder> {
        public static final ProtoAdapter<H3Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H3Property, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public H3Property m1426build() {
                return new H3Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1426build();
            }
        }

        public static final class ProtoAdapter_H3Property extends ProtoAdapter<H3Property> {
            public ProtoAdapter_H3Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H3Property.class);
            }

            public H3Property decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1426build();
            }

            public int encodedSize(H3Property r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1427decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((H3Property) r1);
            }

            public void encode(ProtoWriter r1, H3Property r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (H3Property) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H3Property();
        }

        public H3Property() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1425newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return H3Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1425newBuilder();
        }

        public H3Property(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class H4Property extends com.squareup.wire.Message<H4Property, Builder> {
        public static final ProtoAdapter<H4Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H4Property, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public H4Property m1429build() {
                return new H4Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1429build();
            }
        }

        public static final class ProtoAdapter_H4Property extends ProtoAdapter<H4Property> {
            public ProtoAdapter_H4Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H4Property.class);
            }

            public H4Property decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1429build();
            }

            public int encodedSize(H4Property r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1430decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((H4Property) r1);
            }

            public void encode(ProtoWriter r1, H4Property r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (H4Property) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H4Property();
        }

        public H4Property() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1428newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return H4Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1428newBuilder();
        }

        public H4Property(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class H5Property extends com.squareup.wire.Message<H5Property, Builder> {
        public static final ProtoAdapter<H5Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H5Property, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public H5Property m1432build() {
                return new H5Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1432build();
            }
        }

        public static final class ProtoAdapter_H5Property extends ProtoAdapter<H5Property> {
            public ProtoAdapter_H5Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H5Property.class);
            }

            public H5Property decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1432build();
            }

            public int encodedSize(H5Property r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1433decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((H5Property) r1);
            }

            public void encode(ProtoWriter r1, H5Property r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (H5Property) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H5Property();
        }

        public H5Property() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1431newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return H5Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1431newBuilder();
        }

        public H5Property(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class H6Property extends com.squareup.wire.Message<H6Property, Builder> {
        public static final ProtoAdapter<H6Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H6Property, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public H6Property m1435build() {
                return new H6Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1435build();
            }
        }

        public static final class ProtoAdapter_H6Property extends ProtoAdapter<H6Property> {
            public ProtoAdapter_H6Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H6Property.class);
            }

            public H6Property decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1435build();
            }

            public int encodedSize(H6Property r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1436decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((H6Property) r1);
            }

            public void encode(ProtoWriter r1, H6Property r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (H6Property) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H6Property();
        }

        public H6Property() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1434newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return H6Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1434newBuilder();
        }

        public H6Property(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class HRProperty extends com.squareup.wire.Message<HRProperty, Builder> {
        public static final ProtoAdapter<HRProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<HRProperty, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public HRProperty m1438build() {
                return new HRProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1438build();
            }
        }

        public static final class ProtoAdapter_HRProperty extends ProtoAdapter<HRProperty> {
            public ProtoAdapter_HRProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, HRProperty.class);
            }

            public HRProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1438build();
            }

            public int encodedSize(HRProperty r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1439decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((HRProperty) r1);
            }

            public void encode(ProtoWriter r1, HRProperty r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (HRProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HRProperty();
        }

        public HRProperty() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1437newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return HRProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1437newBuilder();
        }

        public HRProperty(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final enum HorizontalAlign extends Enum<HorizontalAlign> implements WireEnum {
        private static final /* synthetic */ HorizontalAlign[] $VALUES = null;
        public static final ProtoAdapter<HorizontalAlign> ADAPTER = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_CENTER = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_LEFT = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_RIGHT = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_UNKNOWN = null;
        private final int value;

        static {
            HorizontalAlign r0 = new HorizontalAlign("HORIZONTAL_ALIGN_UNKNOWN", 0, 0);
            HORIZONTAL_ALIGN_UNKNOWN = r0;
            HorizontalAlign r1 = new HorizontalAlign("HORIZONTAL_ALIGN_LEFT", 1, 1);
            HORIZONTAL_ALIGN_LEFT = r1;
            HorizontalAlign r3 = new HorizontalAlign("HORIZONTAL_ALIGN_CENTER", 2, 2);
            HORIZONTAL_ALIGN_CENTER = r3;
            HorizontalAlign r5 = new HorizontalAlign("HORIZONTAL_ALIGN_RIGHT", 3, 3);
            HORIZONTAL_ALIGN_RIGHT = r5;
            $VALUES = new HorizontalAlign[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(HorizontalAlign.class);
        }

        public static HorizontalAlign[] values() {
            return (HorizontalAlign[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static HorizontalAlign fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return HORIZONTAL_ALIGN_RIGHT;
        L14:
            return HORIZONTAL_ALIGN_CENTER;
        L16:
            return HORIZONTAL_ALIGN_LEFT;
        L18:
            return HORIZONTAL_ALIGN_UNKNOWN;
        }

        public static HorizontalAlign valueOf(String r1) {
            return (HorizontalAlign) a.a(HorizontalAlign.class, r1);
        }

        private HorizontalAlign(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ImageProperty extends com.squareup.wire.Message<ImageProperty, Builder> {
        public static final ProtoAdapter<ImageProperty> ADAPTER = null;
        public static final String DEFAULT_ALT = "";
        public static final String DEFAULT_ALT_I18N_KEY = "";
        public static final Integer DEFAULT_CUSTOM_WIDTH = null;
        public static final String DEFAULT_FS_UNIT = "";
        public static final Integer DEFAULT_HEIGHT = null;
        public static final Boolean DEFAULT_IMG_CAN_PREVIEW = null;
        public static final Boolean DEFAULT_IS_ORIGIN_SOURCE = null;
        public static final String DEFAULT_MIDDLE_KEY = "";
        public static final Integer DEFAULT_ORIGIN_HEIGHT = null;
        public static final String DEFAULT_ORIGIN_KEY = "";
        public static final Long DEFAULT_ORIGIN_SIZE = null;
        public static final Integer DEFAULT_ORIGIN_WIDTH = null;
        public static final Integer DEFAULT_SHOW_MODE = null;
        public static final String DEFAULT_THUMB_KEY = "";
        public static final String DEFAULT_TOKEN = "";
        public static final Integer DEFAULT_WIDTH = null;
        private static final long serialVersionUID = 0;
        public final String malt;
        public final String malt_i18n_key;
        public final Cipher mcipher;
        public final Crypto.Type mcipher_type;
        public final Image mcover;
        public final Integer mcustom_width;
        public final String mfs_unit;
        public final Integer mheight;
        public final ImageSetV2 mimage;
        public final Boolean mimg_can_preview;
        public final Boolean mis_origin_source;
        public final String mmiddle_key;
        public final Image mmiddle_mp4;
        public final Image mmiddle_webp;
        public final Integer morigin_height;
        public final String morigin_key;
        public final Long morigin_size;
        public final Integer morigin_width;
        public final Integer mshow_mode;
        public final String mthumb_key;
        public final Image mthumbnail_webp;
        public final String mtoken;
        public final List<String> murls;
        public final Integer mwidth;

        public static final class Builder extends com.squareup.wire.Message.Builder<ImageProperty, Builder> {
            public String malt;
            public String malt_i18n_key;
            public Cipher mcipher;
            public Crypto.Type mcipher_type;
            public Image mcover;
            public Integer mcustom_width;
            public String mfs_unit;
            public Integer mheight;
            public ImageSetV2 mimage;
            public Boolean mimg_can_preview;
            public Boolean mis_origin_source;
            public String mmiddle_key;
            public Image mmiddle_mp4;
            public Image mmiddle_webp;
            public Integer morigin_height;
            public String morigin_key;
            public Long morigin_size;
            public Integer morigin_width;
            public Integer mshow_mode;
            public String mthumb_key;
            public Image mthumbnail_webp;
            public String mtoken;
            public List<String> murls;
            public Integer mwidth;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ImageProperty m1441build() {
                return new ImageProperty(this.mtoken, this.malt, this.malt_i18n_key, this.mimg_can_preview, this.mcipher, this.mcipher_type, this.morigin_key, this.mfs_unit, this.murls, this.mmiddle_key, this.mthumb_key, this.morigin_width, this.morigin_height, this.mthumbnail_webp, this.mmiddle_webp, this.mmiddle_mp4, this.mcover, this.mimage, this.mcustom_width, this.mis_origin_source, this.morigin_size, this.mshow_mode, this.mwidth, this.mheight, super.buildUnknownFields());
            }

            public Builder() {
                this.murls = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1441build();
            }

            public Builder alt(String r1) {
                this.malt = r1;
                return this;
            }

            public Builder alt_i18n_key(String r1) {
                this.malt_i18n_key = r1;
                return this;
            }

            public Builder cipher(Cipher r1) {
                this.mcipher = r1;
                return this;
            }

            public Builder cipher_type(Crypto.Type r1) {
                this.mcipher_type = r1;
                return this;
            }

            public Builder cover(Image r1) {
                this.mcover = r1;
                return this;
            }

            public Builder custom_width(Integer r1) {
                this.mcustom_width = r1;
                return this;
            }

            public Builder fs_unit(String r1) {
                this.mfs_unit = r1;
                return this;
            }

            public Builder height(Integer r1) {
                this.mheight = r1;
                return this;
            }

            public Builder image(ImageSetV2 r1) {
                this.mimage = r1;
                return this;
            }

            public Builder img_can_preview(Boolean r1) {
                this.mimg_can_preview = r1;
                return this;
            }

            public Builder is_origin_source(Boolean r1) {
                this.mis_origin_source = r1;
                return this;
            }

            public Builder middle_key(String r1) {
                this.mmiddle_key = r1;
                return this;
            }

            public Builder middle_mp4(Image r1) {
                this.mmiddle_mp4 = r1;
                return this;
            }

            public Builder middle_webp(Image r1) {
                this.mmiddle_webp = r1;
                return this;
            }

            public Builder origin_height(Integer r1) {
                this.morigin_height = r1;
                return this;
            }

            public Builder origin_key(String r1) {
                this.morigin_key = r1;
                return this;
            }

            public Builder origin_size(Long r1) {
                this.morigin_size = r1;
                return this;
            }

            public Builder origin_width(Integer r1) {
                this.morigin_width = r1;
                return this;
            }

            public Builder show_mode(Integer r1) {
                this.mshow_mode = r1;
                return this;
            }

            public Builder thumb_key(String r1) {
                this.mthumb_key = r1;
                return this;
            }

            public Builder thumbnail_webp(Image r1) {
                this.mthumbnail_webp = r1;
                return this;
            }

            public Builder token(String r1) {
                this.mtoken = r1;
                return this;
            }

            public Builder urls(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.murls = r1;
                return this;
            }

            public Builder width(Integer r1) {
                this.mwidth = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ImageProperty extends ProtoAdapter<ImageProperty> {
            public ProtoAdapter_ImageProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageProperty.class);
            }

            public ImageProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mtoken = "";
                r0.malt = "";
                r0.malt_i18n_key = "";
                Boolean r2 = Boolean.FALSE;
                r0.mimg_can_preview = r2;
                r0.morigin_key = "";
                r0.mfs_unit = "";
                r0.mmiddle_key = "";
                r0.mthumb_key = "";
                r0.morigin_width = 0;
                r0.morigin_height = 0;
                r0.mcustom_width = 0;
                r0.mis_origin_source = r2;
                r0.morigin_size = 0L;
                r0.mshow_mode = 0;
                r0.mwidth = 0;
                r0.mheight = 0;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L34;
                switch(r3) {
                    case 1: goto L33;
                    case 2: goto L32;
                    case 3: goto L31;
                    case 4: goto L30;
                    case 5: goto L29;
                    case 6: goto L28;
                    case 7: goto L27;
                    case 8: goto L26;
                    case 9: goto L25;
                    case 10: goto L24;
                    case 11: goto L23;
                    case 12: goto L22;
                    case 13: goto L21;
                    case 14: goto L20;
                    case 15: goto L19;
                    case 16: goto L18;
                    case 17: goto L17;
                    case 18: goto L16;
                    case 19: goto L36;
                    case 20: goto L11;
                    case 21: goto L10;
                    case 22: goto L9;
                    case 23: goto L8;
                    case 24: goto L7;
                    default: goto L6;
                };
            L36:
                r0.mcipher_type = (Crypto.Type) Crypto.Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mheight = (Integer) ProtoAdapter.UINT32.decode(r9);
                goto L3
            L8:
                r0.mwidth = (Integer) ProtoAdapter.UINT32.decode(r9);
                goto L3
            L9:
                r0.mshow_mode = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L10:
                r0.morigin_size = (Long) ProtoAdapter.UINT64.decode(r9);
                goto L3
            L11:
                r0.mis_origin_source = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L16:
                r0.mcustom_width = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L17:
                r0.mimage = (ImageSetV2) ImageSetV2.ADAPTER.decode(r9);
                goto L3
            L18:
                r0.mcover = (Image) Image.ADAPTER.decode(r9);
                goto L3
            L19:
                r0.mmiddle_mp4 = (Image) Image.ADAPTER.decode(r9);
                goto L3
            L20:
                r0.mmiddle_webp = (Image) Image.ADAPTER.decode(r9);
                goto L3
            L21:
                r0.mthumbnail_webp = (Image) Image.ADAPTER.decode(r9);
                goto L3
            L22:
                r0.mimg_can_preview = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L23:
                r0.malt_i18n_key = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L24:
                r0.malt = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L25:
                r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L26:
                r0.morigin_height = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L27:
                r0.morigin_width = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L28:
                r0.mthumb_key = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L29:
                r0.mmiddle_key = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L30:
                r0.morigin_key = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L31:
                r0.mcipher = (Cipher) Cipher.ADAPTER.decode(r9);
                goto L3
            L32:
                r0.mtoken = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L33:
                r0.murls.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L34:
                r9.endMessage(r1);
                return r0.m1441build();
            }

            public int encodedSize(ImageProperty r7) {
                String r0 = r7.mtoken;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(2, r0);
            L6:
                String r3 = r7.malt;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(10, r3);
            L10:
                int r5 = r2 + r4;
                String r6 = r7.malt_i18n_key;
                if (r6 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(11, r6);
            L14:
                int r9 = r5 + r8;
                Boolean r10 = r7.mimg_can_preview;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r10);
            L18:
                int r12 = r9 + r11;
                Cipher r13 = r7.mcipher;
                if (r13 == null) goto L21;
                int r14 = Cipher.ADAPTER.encodedSizeWithTag(3, r13);
            L22:
                int r15 = r12 + r14;
                Crypto.Type r16 = r7.mcipher_type;
                if (r16 == null) goto L25;
                int r17 = Crypto.Type.ADAPTER.encodedSizeWithTag(19, r16);
            L26:
                int r18 = r15 + r17;
                String r19 = r7.morigin_key;
                if (r19 == null) goto L29;
                int r20 = ProtoAdapter.STRING.encodedSizeWithTag(4, r19);
            L30:
                int r21 = r18 + r20;
                String r22 = r7.mfs_unit;
                if (r22 == null) goto L33;
                int r23 = ProtoAdapter.STRING.encodedSizeWithTag(9, r22);
            L34:
                int r24 = r21 + r23;
                ProtoAdapter r25 = ProtoAdapter.STRING;
                int r26 = r24 + r25.asRepeated().encodedSizeWithTag(1, r7.murls);
                String r27 = r7.mmiddle_key;
                if (r27 == null) goto L37;
                int r28 = r25.encodedSizeWithTag(5, r27);
            L38:
                int r29 = r26 + r28;
                String r30 = r7.mthumb_key;
                if (r30 == null) goto L41;
                int r31 = r25.encodedSizeWithTag(6, r30);
            L42:
                int r32 = r29 + r31;
                Integer r33 = r7.morigin_width;
                if (r33 == null) goto L45;
                int r34 = ProtoAdapter.INT32.encodedSizeWithTag(7, r33);
            L46:
                int r35 = r32 + r34;
                Integer r36 = r7.morigin_height;
                if (r36 == null) goto L49;
                int r37 = ProtoAdapter.INT32.encodedSizeWithTag(8, r36);
            L50:
                int r38 = r35 + r37;
                Image r39 = r7.mthumbnail_webp;
                if (r39 == null) goto L53;
                int r40 = Image.ADAPTER.encodedSizeWithTag(13, r39);
            L54:
                int r41 = r38 + r40;
                Image r42 = r7.mmiddle_webp;
                if (r42 == null) goto L57;
                int r43 = Image.ADAPTER.encodedSizeWithTag(14, r42);
            L58:
                int r44 = r41 + r43;
                Image r45 = r7.mmiddle_mp4;
                if (r45 == null) goto L61;
                int r46 = Image.ADAPTER.encodedSizeWithTag(15, r45);
            L62:
                int r47 = r44 + r46;
                Image r48 = r7.mcover;
                if (r48 == null) goto L65;
                int r49 = Image.ADAPTER.encodedSizeWithTag(16, r48);
            L66:
                int r50 = r47 + r49;
                ImageSetV2 r51 = r7.mimage;
                if (r51 == null) goto L69;
                int r52 = ImageSetV2.ADAPTER.encodedSizeWithTag(17, r51);
            L70:
                int r53 = r50 + r52;
                Integer r54 = r7.mcustom_width;
                if (r54 == null) goto L73;
                int r55 = ProtoAdapter.INT32.encodedSizeWithTag(18, r54);
            L74:
                int r56 = r53 + r55;
                Boolean r57 = r7.mis_origin_source;
                if (r57 == null) goto L77;
                int r58 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r57);
            L78:
                int r59 = r56 + r58;
                Long r60 = r7.morigin_size;
                if (r60 == null) goto L81;
                int r61 = ProtoAdapter.UINT64.encodedSizeWithTag(21, r60);
            L82:
                int r62 = r59 + r61;
                Integer r63 = r7.mshow_mode;
                if (r63 == null) goto L85;
                int r64 = ProtoAdapter.INT32.encodedSizeWithTag(22, r63);
            L86:
                int r65 = r62 + r64;
                Integer r66 = r7.mwidth;
                if (r66 == null) goto L89;
                int r67 = ProtoAdapter.UINT32.encodedSizeWithTag(23, r66);
            L90:
                int r68 = r65 + r67;
                Integer r69 = r7.mheight;
                if (r69 == null) goto L94;
                r1 = ProtoAdapter.UINT32.encodedSizeWithTag(24, r69);
            L94:
                return (r68 + r1) + r7.unknownFields().size();
            L89:
                r67 = 0;
                goto L90
            L85:
                r64 = 0;
                goto L86
            L81:
                r61 = 0;
                goto L82
            L77:
                r58 = 0;
                goto L78
            L73:
                r55 = 0;
                goto L74
            L69:
                r52 = 0;
                goto L70
            L65:
                r49 = 0;
                goto L66
            L61:
                r46 = 0;
                goto L62
            L57:
                r43 = 0;
                goto L58
            L53:
                r40 = 0;
                goto L54
            L49:
                r37 = 0;
                goto L50
            L45:
                r34 = 0;
                goto L46
            L41:
                r31 = 0;
                goto L42
            L37:
                r28 = 0;
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
            public /* bridge */ /* synthetic */ Object m1442decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ImageProperty) r1);
            }

            public void encode(ProtoWriter r5, ImageProperty r6) throws IOException {
                String r0 = r6.mtoken;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r5, 2, r0);
            L5:
                String r1 = r6.malt;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r5, 10, r1);
            L8:
                String r2 = r6.malt_i18n_key;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r5, 11, r2);
            L11:
                Boolean r3 = r6.mimg_can_preview;
                if (r3 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r5, 12, r3);
            L14:
                Cipher r4 = r6.mcipher;
                if (r4 == null) goto L17;
                Cipher.ADAPTER.encodeWithTag(r5, 3, r4);
            L17:
                Crypto.Type r7 = r6.mcipher_type;
                if (r7 == null) goto L20;
                Crypto.Type.ADAPTER.encodeWithTag(r5, 19, r7);
            L20:
                String r8 = r6.morigin_key;
                if (r8 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r5, 4, r8);
            L23:
                String r9 = r6.mfs_unit;
                if (r9 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r5, 9, r9);
            L26:
                ProtoAdapter r10 = ProtoAdapter.STRING;
                r10.asRepeated().encodeWithTag(r5, 1, r6.murls);
                String r11 = r6.mmiddle_key;
                if (r11 == null) goto L29;
                r10.encodeWithTag(r5, 5, r11);
            L29:
                String r12 = r6.mthumb_key;
                if (r12 == null) goto L32;
                r10.encodeWithTag(r5, 6, r12);
            L32:
                Integer r13 = r6.morigin_width;
                if (r13 == null) goto L35;
                ProtoAdapter.INT32.encodeWithTag(r5, 7, r13);
            L35:
                Integer r14 = r6.morigin_height;
                if (r14 == null) goto L38;
                ProtoAdapter.INT32.encodeWithTag(r5, 8, r14);
            L38:
                Image r15 = r6.mthumbnail_webp;
                if (r15 == null) goto L41;
                Image.ADAPTER.encodeWithTag(r5, 13, r15);
            L41:
                Image r16 = r6.mmiddle_webp;
                if (r16 == null) goto L44;
                Image.ADAPTER.encodeWithTag(r5, 14, r16);
            L44:
                Image r17 = r6.mmiddle_mp4;
                if (r17 == null) goto L47;
                Image.ADAPTER.encodeWithTag(r5, 15, r17);
            L47:
                Image r18 = r6.mcover;
                if (r18 == null) goto L50;
                Image.ADAPTER.encodeWithTag(r5, 16, r18);
            L50:
                ImageSetV2 r19 = r6.mimage;
                if (r19 == null) goto L53;
                ImageSetV2.ADAPTER.encodeWithTag(r5, 17, r19);
            L53:
                Integer r20 = r6.mcustom_width;
                if (r20 == null) goto L56;
                ProtoAdapter.INT32.encodeWithTag(r5, 18, r20);
            L56:
                Boolean r21 = r6.mis_origin_source;
                if (r21 == null) goto L59;
                ProtoAdapter.BOOL.encodeWithTag(r5, 20, r21);
            L59:
                Long r22 = r6.morigin_size;
                if (r22 == null) goto L62;
                ProtoAdapter.UINT64.encodeWithTag(r5, 21, r22);
            L62:
                Integer r23 = r6.mshow_mode;
                if (r23 == null) goto L65;
                ProtoAdapter.INT32.encodeWithTag(r5, 22, r23);
            L65:
                Integer r24 = r6.mwidth;
                if (r24 == null) goto L68;
                ProtoAdapter.UINT32.encodeWithTag(r5, 23, r24);
            L68:
                Integer r25 = r6.mheight;
                if (r25 == null) goto L71;
                ProtoAdapter.UINT32.encodeWithTag(r5, 24, r25);
            L71:
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ImageProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageProperty();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_IMG_CAN_PREVIEW = r0;
            DEFAULT_ORIGIN_WIDTH = 0;
            DEFAULT_ORIGIN_HEIGHT = 0;
            DEFAULT_CUSTOM_WIDTH = 0;
            DEFAULT_IS_ORIGIN_SOURCE = r0;
            DEFAULT_ORIGIN_SIZE = 0L;
            DEFAULT_SHOW_MODE = 0;
            DEFAULT_WIDTH = 0;
            DEFAULT_HEIGHT = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1440newBuilder() {
            Builder r0 = new Builder();
            r0.mtoken = this.mtoken;
            r0.malt = this.malt;
            r0.malt_i18n_key = this.malt_i18n_key;
            r0.mimg_can_preview = this.mimg_can_preview;
            r0.mcipher = this.mcipher;
            r0.mcipher_type = this.mcipher_type;
            r0.morigin_key = this.morigin_key;
            r0.mfs_unit = this.mfs_unit;
            r0.murls = Internal.copyOf("murls", this.murls);
            r0.mmiddle_key = this.mmiddle_key;
            r0.mthumb_key = this.mthumb_key;
            r0.morigin_width = this.morigin_width;
            r0.morigin_height = this.morigin_height;
            r0.mthumbnail_webp = this.mthumbnail_webp;
            r0.mmiddle_webp = this.mmiddle_webp;
            r0.mmiddle_mp4 = this.mmiddle_mp4;
            r0.mcover = this.mcover;
            r0.mimage = this.mimage;
            r0.mcustom_width = this.mcustom_width;
            r0.mis_origin_source = this.mis_origin_source;
            r0.morigin_size = this.morigin_size;
            r0.mshow_mode = this.mshow_mode;
            r0.mwidth = this.mwidth;
            r0.mheight = this.mheight;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ImageProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1440newBuilder();
        }

        public ImageProperty(String r27, String r28, String r29, Boolean r30, Cipher r31, Crypto.Type r32, String r33, String r34, List<String> r35, String r36, String r37, Integer r38, Integer r39, Image r40, Image r41, Image r42, Image r43, ImageSetV2 r44, Integer r45, Boolean r46, Long r47, Integer r48, Integer r49, Integer r50) {
            this(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, ByteString.EMPTY);
        }

        public ImageProperty(String r4, String r5, String r6, Boolean r7, Cipher r8, Crypto.Type r9, String r10, String r11, List<String> r12, String r13, String r14, Integer r15, Integer r16, Image r17, Image r18, Image r19, Image r20, ImageSetV2 r21, Integer r22, Boolean r23, Long r24, Integer r25, Integer r26, Integer r27, ByteString r28) {
            super(ADAPTER, r28);
            this.mtoken = r4;
            this.malt = r5;
            this.malt_i18n_key = r6;
            this.mimg_can_preview = r7;
            this.mcipher = r8;
            this.mcipher_type = r9;
            this.morigin_key = r10;
            this.mfs_unit = r11;
            this.murls = Internal.immutableCopyOf("murls", r12);
            this.mmiddle_key = r13;
            this.mthumb_key = r14;
            this.morigin_width = r15;
            this.morigin_height = r16;
            this.mthumbnail_webp = r17;
            this.mmiddle_webp = r18;
            this.mmiddle_mp4 = r19;
            this.mcover = r20;
            this.mimage = r21;
            this.mcustom_width = r22;
            this.mis_origin_source = r23;
            this.morigin_size = r24;
            this.mshow_mode = r25;
            this.mwidth = r26;
            this.mheight = r27;
        }
    }

    public static final class ItalicProperty extends com.squareup.wire.Message<ItalicProperty, Builder> {
        public static final ProtoAdapter<ItalicProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mi18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<ItalicProperty, Builder> {
            public String mcontent;
            public String mi18n_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ItalicProperty m1444build() {
                String r0 = this.mcontent;
                if (r0 == null) goto L7;
                return new ItalicProperty(this.mcontent, this.mi18n_key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mcontent"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1444build();
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder i18n_key(String r1) {
                this.mi18n_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ItalicProperty extends ProtoAdapter<ItalicProperty> {
            public ProtoAdapter_ItalicProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ItalicProperty.class);
            }

            public ItalicProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcontent = "";
                r0.mi18n_key = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mi18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1444build();
            }

            public int encodedSize(ItalicProperty r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r5.mcontent);
                String r2 = r5.mi18n_key;
                if (r2 == null) goto L5;
                int r3 = r0.encodedSizeWithTag(2, r2);
            L7:
                return (r1 + r3) + r5.unknownFields().size();
            L5:
                r3 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1445decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ItalicProperty) r1);
            }

            public void encode(ProtoWriter r4, ItalicProperty r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mcontent);
                String r1 = r5.mi18n_key;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 2, r1);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ItalicProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ItalicProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1443newBuilder() {
            Builder r0 = new Builder();
            r0.mcontent = this.mcontent;
            r0.mi18n_key = this.mi18n_key;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ItalicProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1443newBuilder();
        }

        public ItalicProperty(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public ItalicProperty(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mcontent = r2;
            this.mi18n_key = r3;
        }
    }

    public static final class LIProperty extends com.squareup.wire.Message<LIProperty, Builder> {
        public static final ProtoAdapter<LIProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<LIProperty, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public LIProperty m1447build() {
                return new LIProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1447build();
            }
        }

        public static final class ProtoAdapter_LIProperty extends ProtoAdapter<LIProperty> {
            public ProtoAdapter_LIProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, LIProperty.class);
            }

            public LIProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1447build();
            }

            public int encodedSize(LIProperty r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1448decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((LIProperty) r1);
            }

            public void encode(ProtoWriter r1, LIProperty r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (LIProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LIProperty();
        }

        public LIProperty() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1446newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return LIProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1446newBuilder();
        }

        public LIProperty(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class LinkProperty extends com.squareup.wire.Message<LinkProperty, Builder> {
        public static final ProtoAdapter<LinkProperty> ADAPTER = null;
        public static final String DEFAULT_ANDROID_URL = "";
        public static final String DEFAULT_IOS_URL = "";
        public static final String DEFAULT_PC_URL = "";
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String mandroid_url;
        public final String mios_url;
        public final String mpc_url;
        public final LinkScene mscene;
        public final SpecialURL mspecial_url;
        public final String murl;

        public static final class Builder extends com.squareup.wire.Message.Builder<LinkProperty, Builder> {
            public String mandroid_url;
            public String mios_url;
            public String mpc_url;
            public LinkScene mscene;
            public SpecialURL mspecial_url;
            public String murl;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public LinkProperty m1450build() {
                return new LinkProperty(this.murl, this.mios_url, this.mandroid_url, this.mpc_url, this.mspecial_url, this.mscene, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1450build();
            }

            public Builder android_url(String r1) {
                this.mandroid_url = r1;
                return this;
            }

            public Builder ios_url(String r1) {
                this.mios_url = r1;
                return this;
            }

            public Builder pc_url(String r1) {
                this.mpc_url = r1;
                return this;
            }

            public Builder scene(LinkScene r1) {
                this.mscene = r1;
                return this;
            }

            public Builder special_url(SpecialURL r1) {
                this.mspecial_url = r1;
                return this;
            }

            public Builder url(String r1) {
                this.murl = r1;
                return this;
            }
        }

        public static final enum LinkScene extends Enum<LinkScene> implements WireEnum {
            private static final /* synthetic */ LinkScene[] $VALUES = null;
            public static final ProtoAdapter<LinkScene> ADAPTER = null;
            public static final LinkScene CardLink = null;
            public static final LinkScene ContentLink = null;
            public static final LinkScene FooterLink = null;
            public static final LinkScene UNKNOWN = null;
            private final int value;

            static {
                LinkScene r0 = new LinkScene("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                LinkScene r1 = new LinkScene("CardLink", 1, 1);
                CardLink = r1;
                LinkScene r3 = new LinkScene("ContentLink", 2, 2);
                ContentLink = r3;
                LinkScene r5 = new LinkScene("FooterLink", 3, 3);
                FooterLink = r5;
                $VALUES = new LinkScene[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(LinkScene.class);
            }

            public static LinkScene[] values() {
                return (LinkScene[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static LinkScene fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return FooterLink;
            L14:
                return ContentLink;
            L16:
                return CardLink;
            L18:
                return UNKNOWN;
            }

            public static LinkScene valueOf(String r1) {
                return (LinkScene) a.a(LinkScene.class, r1);
            }

            private LinkScene(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_LinkProperty extends ProtoAdapter<LinkProperty> {
            public ProtoAdapter_LinkProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, LinkProperty.class);
            }

            public LinkProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.murl = "";
                r0.mios_url = "";
                r0.mandroid_url = "";
                r0.mpc_url = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L19;
                switch(r3) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L21;
                    case 6: goto L23;
                    default: goto L6;
                };
            L21:
                r0.mspecial_url = (SpecialURL) SpecialURL.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L23:
                r0.mscene = (LinkScene) LinkScene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L15:
                r0.mpc_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L16:
                r0.mandroid_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L17:
                r0.mios_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L18:
                r0.murl = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L19:
                r9.endMessage(r1);
                return r0.m1450build();
            }

            public int encodedSize(LinkProperty r6) {
                String r0 = r6.murl;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mios_url;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mandroid_url;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mpc_url;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                SpecialURL r13 = r6.mspecial_url;
                if (r13 == null) goto L21;
                int r14 = SpecialURL.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                LinkScene r16 = r6.mscene;
                if (r16 == null) goto L26;
                r1 = LinkScene.ADAPTER.encodedSizeWithTag(6, r16);
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
            public /* bridge */ /* synthetic */ Object m1451decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((LinkProperty) r1);
            }

            public void encode(ProtoWriter r4, LinkProperty r5) throws IOException {
                String r0 = r5.murl;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mios_url;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mandroid_url;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mpc_url;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                SpecialURL r6 = r5.mspecial_url;
                if (r6 == null) goto L17;
                SpecialURL.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                LinkScene r7 = r5.mscene;
                if (r7 == null) goto L20;
                LinkScene.ADAPTER.encodeWithTag(r4, 6, r7);
            L20:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (LinkProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LinkProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1449newBuilder() {
            Builder r0 = new Builder();
            r0.murl = this.murl;
            r0.mios_url = this.mios_url;
            r0.mandroid_url = this.mandroid_url;
            r0.mpc_url = this.mpc_url;
            r0.mspecial_url = this.mspecial_url;
            r0.mscene = this.mscene;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return LinkProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1449newBuilder();
        }

        public LinkProperty(String r9, String r10, String r11, String r12, SpecialURL r13, LinkScene r14) {
            this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
        }

        public LinkProperty(String r2, String r3, String r4, String r5, SpecialURL r6, LinkScene r7, ByteString r8) {
            super(ADAPTER, r8);
            this.murl = r2;
            this.mios_url = r3;
            this.mandroid_url = r4;
            this.mpc_url = r5;
            this.mspecial_url = r6;
            this.mscene = r7;
        }
    }

    public static final class MarkdownProperty extends com.squareup.wire.Message<MarkdownProperty, Builder> {
        public static final ProtoAdapter<MarkdownProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final Boolean DEFAULT_IS_AT_ALL = null;
        private static final long serialVersionUID = 0;
        public final List<Long> mat_user_ids;
        public final String mcontent;
        public final Map<String, ImageSetV2> mimages;
        public final Boolean mis_at_all;

        public static final class Builder extends com.squareup.wire.Message.Builder<MarkdownProperty, Builder> {
            public List<Long> mat_user_ids;
            public String mcontent;
            public Map<String, ImageSetV2> mimages;
            public Boolean mis_at_all;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MarkdownProperty m1453build() {
                return new MarkdownProperty(this.mcontent, this.mimages, this.mat_user_ids, this.mis_at_all, super.buildUnknownFields());
            }

            public Builder() {
                this.mimages = Internal.newMutableMap();
                this.mat_user_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1453build();
            }

            public Builder at_user_ids(List<Long> r1) {
                Internal.checkElementsNotNull(r1);
                this.mat_user_ids = r1;
                return this;
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder images(Map<String, ImageSetV2> r1) {
                Internal.checkElementsNotNull(r1);
                this.mimages = r1;
                return this;
            }

            public Builder is_at_all(Boolean r1) {
                this.mis_at_all = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MarkdownProperty extends ProtoAdapter<MarkdownProperty> {
            private final ProtoAdapter<Map<String, ImageSetV2>> mimages;

            public ProtoAdapter_MarkdownProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, MarkdownProperty.class);
                this.mimages = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ImageSetV2.ADAPTER);
            }

            public MarkdownProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcontent = "";
                r0.mis_at_all = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mimages.putAll((Map) this.mimages.decode(r7));
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mat_user_ids.add((Long) ProtoAdapter.INT64.decode(r7));
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mis_at_all = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m1453build();
            }

            public int encodedSize(MarkdownProperty r6) {
                String r0 = r6.mcontent;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                int r3 = (r2 + this.mimages.encodedSizeWithTag(2, r6.mimages)) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(3, r6.mat_user_ids);
                Boolean r4 = r6.mis_at_all;
                if (r4 == null) goto L10;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r4);
            L10:
                return (r3 + r1) + r6.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1454decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MarkdownProperty) r1);
            }

            public void encode(ProtoWriter r4, MarkdownProperty r5) throws IOException {
                String r0 = r5.mcontent;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                this.mimages.encodeWithTag(r4, 2, r5.mimages);
                ProtoAdapter.INT64.asRepeated().encodeWithTag(r4, 3, r5.mat_user_ids);
                Boolean r1 = r5.mis_at_all;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MarkdownProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MarkdownProperty();
            DEFAULT_IS_AT_ALL = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1452newBuilder() {
            Builder r0 = new Builder();
            r0.mcontent = this.mcontent;
            r0.mimages = Internal.copyOf("mimages", this.mimages);
            r0.mat_user_ids = Internal.copyOf("mat_user_ids", this.mat_user_ids);
            r0.mis_at_all = this.mis_at_all;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MarkdownProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1452newBuilder();
        }

        public MarkdownProperty(String r7, Map<String, ImageSetV2> r8, List<Long> r9, Boolean r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public MarkdownProperty(String r2, Map<String, ImageSetV2> r3, List<Long> r4, Boolean r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mcontent = r2;
            this.mimages = Internal.immutableCopyOf("mimages", r3);
            this.mat_user_ids = Internal.immutableCopyOf("mat_user_ids", r4);
            this.mis_at_all = r5;
        }
    }

    public static final class MediaProperty extends com.squareup.wire.Message<MediaProperty, Builder> {
        public static final ProtoAdapter<MediaProperty> ADAPTER = null;
        public static final ByteString DEFAULT_CRYPTO = null;
        public static final String DEFAULT_CRYPTO_TOKEN = "";
        public static final Integer DEFAULT_DURATION = null;
        public static final String DEFAULT_FS_UNIT = "";
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_MIME = "";
        public static final String DEFAULT_NAME = "";
        public static final Long DEFAULT_SIZE = null;
        private static final long serialVersionUID = 0;
        public final ByteString mcrypto;
        public final String mcrypto_token;
        public final Integer mduration;
        public final String mfs_unit;
        public final ImageSet mimage;
        public final String mkey;
        public final String mmime;
        public final String mname;
        public final Long msize;
        public final Source msource;

        public static final class Builder extends com.squareup.wire.Message.Builder<MediaProperty, Builder> {
            public ByteString mcrypto;
            public String mcrypto_token;
            public Integer mduration;
            public String mfs_unit;
            public ImageSet mimage;
            public String mkey;
            public String mmime;
            public String mname;
            public Long msize;
            public Source msource;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MediaProperty m1456build() {
                return new MediaProperty(this.mkey, this.mname, this.msize, this.mmime, this.msource, this.mimage, this.mduration, this.mfs_unit, this.mcrypto_token, this.mcrypto, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1456build();
            }

            public Builder crypto(ByteString r1) {
                this.mcrypto = r1;
                return this;
            }

            public Builder crypto_token(String r1) {
                this.mcrypto_token = r1;
                return this;
            }

            public Builder duration(Integer r1) {
                this.mduration = r1;
                return this;
            }

            public Builder fs_unit(String r1) {
                this.mfs_unit = r1;
                return this;
            }

            public Builder image(ImageSet r1) {
                this.mimage = r1;
                return this;
            }

            public Builder key(String r1) {
                this.mkey = r1;
                return this;
            }

            public Builder mime(String r1) {
                this.mmime = r1;
                return this;
            }

            public Builder name(String r1) {
                this.mname = r1;
                return this;
            }

            public Builder size(Long r1) {
                this.msize = r1;
                return this;
            }

            public Builder source(Source r1) {
                this.msource = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MediaProperty extends ProtoAdapter<MediaProperty> {
            public ProtoAdapter_MediaProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, MediaProperty.class);
            }

            public MediaProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mkey = "";
                r0.mname = "";
                r0.msize = 0L;
                r0.mmime = "";
                r0.mduration = 0;
                r0.mfs_unit = "";
                r0.mcrypto_token = "";
                r0.mcrypto = ByteString.EMPTY;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L20;
                switch(r3) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L22;
                    case 6: goto L11;
                    case 7: goto L10;
                    case 8: goto L9;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L22:
                r0.msource = (Source) Source.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mcrypto = (ByteString) ProtoAdapter.BYTES.decode(r9);
                goto L3
            L8:
                r0.mcrypto_token = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L9:
                r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                r0.mduration = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L11:
                r0.mimage = (ImageSet) ImageSet.ADAPTER.decode(r9);
                goto L3
            L16:
                r0.mmime = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L17:
                r0.msize = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L18:
                r0.mname = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L19:
                r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L20:
                r9.endMessage(r1);
                return r0.m1456build();
            }

            public int encodedSize(MediaProperty r6) {
                String r0 = r6.mkey;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mname;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Long r7 = r6.msize;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mmime;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Source r13 = r6.msource;
                if (r13 == null) goto L21;
                int r14 = Source.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                ImageSet r16 = r6.mimage;
                if (r16 == null) goto L25;
                int r17 = ImageSet.ADAPTER.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                Integer r19 = r6.mduration;
                if (r19 == null) goto L29;
                int r20 = ProtoAdapter.INT32.encodedSizeWithTag(7, r19);
            L30:
                int r21 = r18 + r20;
                String r22 = r6.mfs_unit;
                if (r22 == null) goto L33;
                int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
            L34:
                int r24 = r21 + r23;
                String r25 = r6.mcrypto_token;
                if (r25 == null) goto L37;
                int r26 = ProtoAdapter.STRING.encodedSizeWithTag(9, r25);
            L38:
                int r27 = r24 + r26;
                ByteString r28 = r6.mcrypto;
                if (r28 == null) goto L42;
                r1 = ProtoAdapter.BYTES.encodedSizeWithTag(10, r28);
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
            public /* bridge */ /* synthetic */ Object m1457decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MediaProperty) r1);
            }

            public void encode(ProtoWriter r4, MediaProperty r5) throws IOException {
                String r0 = r5.mkey;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mname;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Long r2 = r5.msize;
                if (r2 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mmime;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                Source r6 = r5.msource;
                if (r6 == null) goto L17;
                Source.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                ImageSet r7 = r5.mimage;
                if (r7 == null) goto L20;
                ImageSet.ADAPTER.encodeWithTag(r4, 6, r7);
            L20:
                Integer r8 = r5.mduration;
                if (r8 == null) goto L23;
                ProtoAdapter.INT32.encodeWithTag(r4, 7, r8);
            L23:
                String r9 = r5.mfs_unit;
                if (r9 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
            L26:
                String r10 = r5.mcrypto_token;
                if (r10 == null) goto L29;
                ProtoAdapter.STRING.encodeWithTag(r4, 9, r10);
            L29:
                ByteString r11 = r5.mcrypto;
                if (r11 == null) goto L32;
                ProtoAdapter.BYTES.encodeWithTag(r4, 10, r11);
            L32:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MediaProperty) r2);
            }
        }

        public static final enum Source extends Enum<Source> implements WireEnum {
            private static final /* synthetic */ Source[] $VALUES = null;
            public static final ProtoAdapter<Source> ADAPTER = null;
            public static final Source LARK = null;
            public static final Source UNKNOWN = null;
            private final int value;

            static {
                Source r0 = new Source("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Source r1 = new Source("LARK", 1, 1);
                LARK = r1;
                $VALUES = new Source[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(Source.class);
            }

            public static Source[] values() {
                return (Source[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Source fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return LARK;
            L10:
                return UNKNOWN;
            }

            public static Source valueOf(String r1) {
                return (Source) a.a(Source.class, r1);
            }

            private Source(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MediaProperty();
            DEFAULT_SIZE = 0L;
            DEFAULT_DURATION = 0;
            DEFAULT_CRYPTO = ByteString.EMPTY;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1455newBuilder() {
            Builder r0 = new Builder();
            r0.mkey = this.mkey;
            r0.mname = this.mname;
            r0.msize = this.msize;
            r0.mmime = this.mmime;
            r0.msource = this.msource;
            r0.mimage = this.mimage;
            r0.mduration = this.mduration;
            r0.mfs_unit = this.mfs_unit;
            r0.mcrypto_token = this.mcrypto_token;
            r0.mcrypto = this.mcrypto;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MediaProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1455newBuilder();
        }

        public MediaProperty(String r13, String r14, Long r15, String r16, Source r17, ImageSet r18, Integer r19, String r20, String r21, ByteString r22) {
            this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
        }

        public MediaProperty(String r2, String r3, Long r4, String r5, Source r6, ImageSet r7, Integer r8, String r9, String r10, ByteString r11, ByteString r12) {
            super(ADAPTER, r12);
            this.mkey = r2;
            this.mname = r3;
            this.msize = r4;
            this.mmime = r5;
            this.msource = r6;
            this.mimage = r7;
            this.mduration = r8;
            this.mfs_unit = r9;
            this.mcrypto_token = r10;
            this.mcrypto = r11;
        }
    }

    public static final class MentionItem extends com.squareup.wire.Message<MentionItem, Builder> {
        public static final ProtoAdapter<MentionItem> ADAPTER = null;
        public static final String DEFAULT_ID = "";
        private static final long serialVersionUID = 0;
        public final String mid;
        public final MentionType mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<MentionItem, Builder> {
            public String mid;
            public MentionType mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MentionItem m1459build() {
                String r0 = this.mid;
                if (r0 == null) goto L9;
                if (this.mtype == null) goto L9;
                return new MentionItem(this.mid, this.mtype, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mid", this.mtype, "mtype"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1459build();
            }

            public Builder id(String r1) {
                this.mid = r1;
                return this;
            }

            public Builder type(MentionType r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final enum MentionType extends Enum<MentionType> implements WireEnum {
            private static final /* synthetic */ MentionType[] $VALUES = null;
            public static final ProtoAdapter<MentionType> ADAPTER = null;
            public static final MentionType HASH_TAG = null;
            public static final MentionType MOMENTS_HASHTAG = null;
            public static final MentionType UNKNOWN_MENTION_TYPE = null;
            private final int value;

            static {
                MentionType r0 = new MentionType("UNKNOWN_MENTION_TYPE", 0, 0);
                UNKNOWN_MENTION_TYPE = r0;
                MentionType r1 = new MentionType("HASH_TAG", 1, 1);
                HASH_TAG = r1;
                MentionType r3 = new MentionType("MOMENTS_HASHTAG", 2, 2);
                MOMENTS_HASHTAG = r3;
                $VALUES = new MentionType[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(MentionType.class);
            }

            public static MentionType[] values() {
                return (MentionType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static MentionType fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return MOMENTS_HASHTAG;
            L12:
                return HASH_TAG;
            L14:
                return UNKNOWN_MENTION_TYPE;
            }

            public static MentionType valueOf(String r1) {
                return (MentionType) a.a(MentionType.class, r1);
            }

            private MentionType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_MentionItem extends ProtoAdapter<MentionItem> {
            public ProtoAdapter_MentionItem() {
                super(FieldEncoding.LENGTH_DELIMITED, MentionItem.class);
            }

            public MentionItem decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mid = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mid = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mtype = (MentionType) MentionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m1459build();
            }

            public int encodedSize(MentionItem r5) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mid) + MentionType.ADAPTER.encodedSizeWithTag(2, r5.mtype)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1460decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MentionItem) r1);
            }

            public void encode(ProtoWriter r4, MentionItem r5) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mid);
                MentionType.ADAPTER.encodeWithTag(r4, 2, r5.mtype);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MentionItem) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MentionItem();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1458newBuilder() {
            Builder r0 = new Builder();
            r0.mid = this.mid;
            r0.mtype = this.mtype;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MentionItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1458newBuilder();
        }

        public MentionItem(String r2, MentionType r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public MentionItem(String r2, MentionType r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mid = r2;
            this.mtype = r3;
        }
    }

    public static final class MentionProperty extends com.squareup.wire.Message<MentionProperty, Builder> {
        public static final ProtoAdapter<MentionProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final MentionItem mitem;

        public static final class Builder extends com.squareup.wire.Message.Builder<MentionProperty, Builder> {
            public String mcontent;
            public MentionItem mitem;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MentionProperty m1462build() {
                MentionItem r0 = this.mitem;
                if (r0 == null) goto L9;
                if (this.mcontent == null) goto L9;
                return new MentionProperty(this.mitem, this.mcontent, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mitem", this.mcontent, "mcontent"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1462build();
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder item(MentionItem r1) {
                this.mitem = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MentionProperty extends ProtoAdapter<MentionProperty> {
            public ProtoAdapter_MentionProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, MentionProperty.class);
            }

            public MentionProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcontent = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mitem = (MentionItem) MentionItem.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1462build();
            }

            public int encodedSize(MentionProperty r5) {
                return (MentionItem.ADAPTER.encodedSizeWithTag(1, r5.mitem) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.mcontent)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1463decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MentionProperty) r1);
            }

            public void encode(ProtoWriter r4, MentionProperty r5) throws IOException {
                MentionItem.ADAPTER.encodeWithTag(r4, 1, r5.mitem);
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.mcontent);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MentionProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MentionProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1461newBuilder() {
            Builder r0 = new Builder();
            r0.mitem = this.mitem;
            r0.mcontent = this.mcontent;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MentionProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1461newBuilder();
        }

        public MentionProperty(MentionItem r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public MentionProperty(MentionItem r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mitem = r2;
            this.mcontent = r3;
        }
    }

    public static final class MenuOption extends com.squareup.wire.Message<MenuOption, Builder> {
        public static final ProtoAdapter<MenuOption> ADAPTER = null;
        public static final String DEFAULT_OPTION_ACTION_ID = "";
        public static final String DEFAULT_TEXT = "";
        public static final String DEFAULT_TEXT_I18N_KEY = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;
        public final String moption_action_id;
        public final String mtext;
        public final String mtext_i18n_key;
        public final CardAction.Url murl;
        public final String mvalue;

        public static final class Builder extends com.squareup.wire.Message.Builder<MenuOption, Builder> {
            public String moption_action_id;
            public String mtext;
            public String mtext_i18n_key;
            public CardAction.Url murl;
            public String mvalue;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MenuOption m1465build() {
                return new MenuOption(this.mtext, this.mtext_i18n_key, this.mvalue, this.murl, this.moption_action_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1465build();
            }

            public Builder option_action_id(String r1) {
                this.moption_action_id = r1;
                return this;
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }

            public Builder text_i18n_key(String r1) {
                this.mtext_i18n_key = r1;
                return this;
            }

            public Builder url(CardAction.Url r1) {
                this.murl = r1;
                return this;
            }

            public Builder value(String r1) {
                this.mvalue = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MenuOption extends ProtoAdapter<MenuOption> {
            public ProtoAdapter_MenuOption() {
                super(FieldEncoding.LENGTH_DELIMITED, MenuOption.class);
            }

            public MenuOption decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mtext = "";
                r0.mtext_i18n_key = "";
                r0.mvalue = "";
                r0.moption_action_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mtext_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mvalue = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.murl = (CardAction.Url) CardAction.Url.ADAPTER.decode(r7);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.moption_action_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m1465build();
            }

            public int encodedSize(MenuOption r6) {
                String r0 = r6.mtext;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mtext_i18n_key;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mvalue;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                CardAction.Url r10 = r6.murl;
                if (r10 == null) goto L17;
                int r11 = CardAction.Url.ADAPTER.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                String r13 = r6.moption_action_id;
                if (r13 == null) goto L22;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
            L22:
                return (r12 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1466decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MenuOption) r1);
            }

            public void encode(ProtoWriter r4, MenuOption r5) throws IOException {
                String r0 = r5.mtext;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mtext_i18n_key;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mvalue;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                CardAction.Url r3 = r5.murl;
                if (r3 == null) goto L14;
                CardAction.Url.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                String r6 = r5.moption_action_id;
                if (r6 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
            L17:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MenuOption) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MenuOption();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1464newBuilder() {
            Builder r0 = new Builder();
            r0.mtext = this.mtext;
            r0.mtext_i18n_key = this.mtext_i18n_key;
            r0.mvalue = this.mvalue;
            r0.murl = this.murl;
            r0.moption_action_id = this.moption_action_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MenuOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1464newBuilder();
        }

        public MenuOption(String r8, String r9, String r10, CardAction.Url r11, String r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public MenuOption(String r2, String r3, String r4, CardAction.Url r5, String r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mtext = r2;
            this.mtext_i18n_key = r3;
            this.mvalue = r4;
            this.murl = r5;
            this.moption_action_id = r6;
        }
    }

    public static final class MyAIToolProperty extends com.squareup.wire.Message<MyAIToolProperty, Builder> {
        public static final ProtoAdapter<MyAIToolProperty> ADAPTER = null;
        public static final String DEFAULT_NAME = "";
        public static final String DEFAULT_TEXT = "";
        public static final String DEFAULT_TOOL_ID = "";
        public static final String DEFAULT_TOOL_RUNTIME_ID = "";
        private static final long serialVersionUID = 0;
        public final Map<String, String> mi18n_name;
        public final Icon micon;
        public final String mname;
        public final Status mstatus;
        public final String mtext;
        public final String mtool_id;
        public final String mtool_runtime_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<MyAIToolProperty, Builder> {
            public Map<String, String> mi18n_name;
            public Icon micon;
            public String mname;
            public Status mstatus;
            public String mtext;
            public String mtool_id;
            public String mtool_runtime_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MyAIToolProperty m1468build() {
                return new MyAIToolProperty(this.mtool_id, this.mtool_runtime_id, this.mstatus, this.mi18n_name, this.mname, this.mtext, this.micon, super.buildUnknownFields());
            }

            public Builder() {
                this.mi18n_name = Internal.newMutableMap();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1468build();
            }

            public Builder i18n_name(Map<String, String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mi18n_name = r1;
                return this;
            }

            public Builder icon(Icon r1) {
                this.micon = r1;
                return this;
            }

            public Builder name(String r1) {
                this.mname = r1;
                return this;
            }

            public Builder status(Status r1) {
                this.mstatus = r1;
                return this;
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }

            public Builder tool_id(String r1) {
                this.mtool_id = r1;
                return this;
            }

            public Builder tool_runtime_id(String r1) {
                this.mtool_runtime_id = r1;
                return this;
            }
        }

        public static final enum Icon extends Enum<Icon> implements WireEnum {
            private static final /* synthetic */ Icon[] $VALUES = null;
            public static final ProtoAdapter<Icon> ADAPTER = null;
            public static final Icon ANALYZING = null;
            public static final Icon GENERATING = null;
            public static final Icon LOADING = null;
            public static final Icon NONE = null;
            public static final Icon RETRIEVING = null;
            private final int value;

            static {
                Icon r0 = new Icon("LOADING", 0, 0);
                LOADING = r0;
                Icon r1 = new Icon("ANALYZING", 1, 1);
                ANALYZING = r1;
                Icon r3 = new Icon("RETRIEVING", 2, 2);
                RETRIEVING = r3;
                Icon r5 = new Icon("GENERATING", 3, 3);
                GENERATING = r5;
                Icon r7 = new Icon("NONE", 4, 4);
                NONE = r7;
                $VALUES = new Icon[]{r0, r1, r3, r5, r7};
                ADAPTER = ProtoAdapter.newEnumAdapter(Icon.class);
            }

            public static Icon[] values() {
                return (Icon[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Icon fromValue(int r1) {
                if (r1 == 0) goto L22;
                if (r1 == 1) goto L20;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L16;
                if (r1 == 4) goto L14;
                return null;
            L14:
                return NONE;
            L16:
                return GENERATING;
            L18:
                return RETRIEVING;
            L20:
                return ANALYZING;
            L22:
                return LOADING;
            }

            public static Icon valueOf(String r1) {
                return (Icon) a.a(Icon.class, r1);
            }

            private Icon(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_MyAIToolProperty extends ProtoAdapter<MyAIToolProperty> {
            private final ProtoAdapter<Map<String, String>> mi18n_name;

            public ProtoAdapter_MyAIToolProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, MyAIToolProperty.class);
                ProtoAdapter r0 = ProtoAdapter.STRING;
                this.mi18n_name = ProtoAdapter.newMapAdapter(r0, r0);
            }

            public MyAIToolProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mtool_id = "";
                r0.mtool_runtime_id = "";
                r0.mname = "";
                r0.mtext = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L20;
                switch(r3) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L22;
                    case 4: goto L13;
                    case 5: goto L12;
                    case 6: goto L11;
                    case 7: goto L24;
                    default: goto L6;
                };
            L22:
                r0.mstatus = (Status) Status.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L24:
                r0.micon = (Icon) Icon.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r0.mtext = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L12:
                r0.mname = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L13:
                r0.mi18n_name.putAll((Map) this.mi18n_name.decode(r9));
                goto L3
            L18:
                r0.mtool_runtime_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L19:
                r0.mtool_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L20:
                r9.endMessage(r1);
                return r0.m1468build();
            }

            public int encodedSize(MyAIToolProperty r6) {
                String r0 = r6.mtool_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mtool_runtime_id;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Status r7 = r6.mstatus;
                if (r7 == null) goto L13;
                int r8 = Status.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = (r5 + r8) + this.mi18n_name.encodedSizeWithTag(4, r6.mi18n_name);
                String r10 = r6.mname;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(5, r10);
            L18:
                int r12 = r9 + r11;
                String r13 = r6.mtext;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.STRING.encodedSizeWithTag(6, r13);
            L22:
                int r15 = r12 + r14;
                Icon r16 = r6.micon;
                if (r16 == null) goto L26;
                r1 = Icon.ADAPTER.encodedSizeWithTag(7, r16);
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
            public /* bridge */ /* synthetic */ Object m1469decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MyAIToolProperty) r1);
            }

            public void encode(ProtoWriter r4, MyAIToolProperty r5) throws IOException {
                String r0 = r5.mtool_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mtool_runtime_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Status r2 = r5.mstatus;
                if (r2 == null) goto L11;
                Status.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                this.mi18n_name.encodeWithTag(r4, 4, r5.mi18n_name);
                String r3 = r5.mname;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r3);
            L14:
                String r6 = r5.mtext;
                if (r6 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r4, 6, r6);
            L17:
                Icon r7 = r5.micon;
                if (r7 == null) goto L20;
                Icon.ADAPTER.encodeWithTag(r4, 7, r7);
            L20:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MyAIToolProperty) r2);
            }
        }

        public static final enum Status extends Enum<Status> implements WireEnum {
            private static final /* synthetic */ Status[] $VALUES = null;
            public static final ProtoAdapter<Status> ADAPTER = null;
            public static final Status FAILED = null;
            public static final Status RUNING = null;
            public static final Status SUCCESS = null;
            private final int value;

            static {
                Status r0 = new Status("RUNING", 0, 0);
                RUNING = r0;
                Status r1 = new Status("SUCCESS", 1, 1);
                SUCCESS = r1;
                Status r3 = new Status("FAILED", 2, 2);
                FAILED = r3;
                $VALUES = new Status[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
            }

            public static Status[] values() {
                return (Status[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Status fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return FAILED;
            L12:
                return SUCCESS;
            L14:
                return RUNING;
            }

            public static Status valueOf(String r1) {
                return (Status) a.a(Status.class, r1);
            }

            private Status(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MyAIToolProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1467newBuilder() {
            Builder r0 = new Builder();
            r0.mtool_id = this.mtool_id;
            r0.mtool_runtime_id = this.mtool_runtime_id;
            r0.mstatus = this.mstatus;
            r0.mi18n_name = Internal.copyOf("mi18n_name", this.mi18n_name);
            r0.mname = this.mname;
            r0.mtext = this.mtext;
            r0.micon = this.micon;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MyAIToolProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1467newBuilder();
        }

        public MyAIToolProperty(String r10, String r11, Status r12, Map<String, String> r13, String r14, String r15, Icon r16) {
            this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
        }

        public MyAIToolProperty(String r2, String r3, Status r4, Map<String, String> r5, String r6, String r7, Icon r8, ByteString r9) {
            super(ADAPTER, r9);
            this.mtool_id = r2;
            this.mtool_runtime_id = r3;
            this.mstatus = r4;
            this.mi18n_name = Internal.immutableCopyOf("mi18n_name", r5);
            this.mname = r6;
            this.mtext = r7;
            this.micon = r8;
        }
    }

    public static final class OLProperty extends com.squareup.wire.Message<OLProperty, Builder> {
        public static final ProtoAdapter<OLProperty> ADAPTER = null;
        public static final Integer DEFAULT_START = null;
        private static final long serialVersionUID = 0;
        public final Integer mstart;
        public final Type mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<OLProperty, Builder> {
            public Integer mstart;
            public Type mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public OLProperty m1471build() {
                return new OLProperty(this.mtype, this.mstart, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1471build();
            }

            public Builder start(Integer r1) {
                this.mstart = r1;
                return this;
            }

            public Builder type(Type r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_OLProperty extends ProtoAdapter<OLProperty> {
            public ProtoAdapter_OLProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, OLProperty.class);
            }

            public OLProperty decode(ProtoReader r10) throws IOException {
                Builder r0 = new Builder();
                r0.mstart = 1;
                long r2 = r10.beginMessage();
            L3:
                int r4 = r10.nextTag();
                if (r4 == (-1)) goto L14;
                if (r4 != 1) goto L7;
                r0.mtype = (Type) Type.ADAPTER.decode(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r0.addUnknownField(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                if (r4 != 2) goto L8;
                r0.mstart = (Integer) ProtoAdapter.INT32.decode(r10);
                goto L3
            L8:
                FieldEncoding r5 = r10.peekFieldEncoding();
                r0.addUnknownField(r4, r5, r5.rawProtoAdapter().decode(r10));
                goto L3
            L14:
                r10.endMessage(r2);
                return r0.m1471build();
            }

            public int encodedSize(OLProperty r5) {
                Type r0 = r5.mtype;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Type.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r5.mstart;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1472decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((OLProperty) r1);
            }

            public void encode(ProtoWriter r4, OLProperty r5) throws IOException {
                Type r0 = r5.mtype;
                if (r0 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mstart;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (OLProperty) r2);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type LOWERCASE_A = null;
            public static final Type LOWERCASE_ROMAN = null;
            public static final Type NONE = null;
            public static final Type NUMBER = null;
            public static final Type UPPERCASE_A = null;
            public static final Type UPPERCASE_ROMAN = null;
            private final int value;

            static {
                Type r0 = new Type("NUMBER", 0, 0);
                NUMBER = r0;
                Type r1 = new Type("LOWERCASE_A", 1, 1);
                LOWERCASE_A = r1;
                Type r3 = new Type("UPPERCASE_A", 2, 2);
                UPPERCASE_A = r3;
                Type r5 = new Type("LOWERCASE_ROMAN", 3, 3);
                LOWERCASE_ROMAN = r5;
                Type r7 = new Type("UPPERCASE_ROMAN", 4, 4);
                UPPERCASE_ROMAN = r7;
                Type r9 = new Type("NONE", 5, 5);
                NONE = r9;
                $VALUES = new Type[]{r0, r1, r3, r5, r7, r9};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r1) {
                if (r1 == 0) goto L26;
                if (r1 == 1) goto L24;
                if (r1 == 2) goto L22;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L18;
                if (r1 == 5) goto L16;
                return null;
            L16:
                return NONE;
            L18:
                return UPPERCASE_ROMAN;
            L20:
                return LOWERCASE_ROMAN;
            L22:
                return UPPERCASE_A;
            L24:
                return LOWERCASE_A;
            L26:
                return NUMBER;
            }

            public static Type valueOf(String r1) {
                return (Type) a.a(Type.class, r1);
            }

            private Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OLProperty();
            DEFAULT_START = 1;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1470newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.mstart = this.mstart;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return OLProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1470newBuilder();
        }

        public OLProperty(Type r2, Integer r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public OLProperty(Type r2, Integer r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mtype = r2;
            this.mstart = r3;
        }
    }

    public static final class OverflowMenuProperty extends com.squareup.wire.Message<OverflowMenuProperty, Builder> {
        public static final ProtoAdapter<OverflowMenuProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ButtonConfirmProperty mconfirm;
        public final List<MenuOption> moptions;

        public static final class Builder extends com.squareup.wire.Message.Builder<OverflowMenuProperty, Builder> {
            public String maction_id;
            public ButtonConfirmProperty mconfirm;
            public List<MenuOption> moptions;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public OverflowMenuProperty m1474build() {
                return new OverflowMenuProperty(this.maction_id, this.moptions, this.mconfirm, super.buildUnknownFields());
            }

            public Builder() {
                this.moptions = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1474build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r1) {
                this.mconfirm = r1;
                return this;
            }

            public Builder options(List<MenuOption> r1) {
                Internal.checkElementsNotNull(r1);
                this.moptions = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_OverflowMenuProperty extends ProtoAdapter<OverflowMenuProperty> {
            public ProtoAdapter_OverflowMenuProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, OverflowMenuProperty.class);
            }

            public OverflowMenuProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.moptions.add((MenuOption) MenuOption.ADAPTER.decode(r7));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mconfirm = (ButtonConfirmProperty) ButtonConfirmProperty.ADAPTER.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1474build();
            }

            public int encodedSize(OverflowMenuProperty r6) {
                String r0 = r6.maction_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                int r3 = r2 + MenuOption.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.moptions);
                ButtonConfirmProperty r4 = r6.mconfirm;
                if (r4 == null) goto L10;
                r1 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(3, r4);
            L10:
                return (r3 + r1) + r6.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1475decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((OverflowMenuProperty) r1);
            }

            public void encode(ProtoWriter r4, OverflowMenuProperty r5) throws IOException {
                String r0 = r5.maction_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                MenuOption.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.moptions);
                ButtonConfirmProperty r1 = r5.mconfirm;
                if (r1 == null) goto L8;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r4, 3, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (OverflowMenuProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OverflowMenuProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1473newBuilder() {
            Builder r0 = new Builder();
            r0.maction_id = this.maction_id;
            r0.moptions = Internal.copyOf("moptions", this.moptions);
            r0.mconfirm = this.mconfirm;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return OverflowMenuProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1473newBuilder();
        }

        public OverflowMenuProperty(String r2, List<MenuOption> r3, ButtonConfirmProperty r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public OverflowMenuProperty(String r2, List<MenuOption> r3, ButtonConfirmProperty r4, ByteString r5) {
            super(ADAPTER, r5);
            this.maction_id = r2;
            this.moptions = Internal.immutableCopyOf("moptions", r3);
            this.mconfirm = r4;
        }
    }

    public static final class ParagraphProperty extends com.squareup.wire.Message<ParagraphProperty, Builder> {
        public static final ProtoAdapter<ParagraphProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ParagraphProperty, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ParagraphProperty m1477build() {
                return new ParagraphProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1477build();
            }
        }

        public static final class ProtoAdapter_ParagraphProperty extends ProtoAdapter<ParagraphProperty> {
            public ProtoAdapter_ParagraphProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ParagraphProperty.class);
            }

            public ParagraphProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1477build();
            }

            public int encodedSize(ParagraphProperty r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1478decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ParagraphProperty) r1);
            }

            public void encode(ProtoWriter r1, ParagraphProperty r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ParagraphProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ParagraphProperty();
        }

        public ParagraphProperty() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1476newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ParagraphProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1476newBuilder();
        }

        public ParagraphProperty(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class ProgressSelectOptionProperty extends com.squareup.wire.Message<ProgressSelectOptionProperty, Builder> {
        public static final ProtoAdapter<ProgressSelectOptionProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_ACTION_PARAM_NAME = "";
        public static final String DEFAULT_ACTION_PARAM_VALUE = "";
        public static final String DEFAULT_CONTENT = "";
        public static final Boolean DEFAULT_DISABLE = null;
        public static final Integer DEFAULT_NUMBER_OF_SELECTED = null;
        public static final Integer DEFAULT_NUMBER_OF_TOTAL = null;
        public static final String DEFAULT_OPTION_CASE = "";
        public static final Boolean DEFAULT_SELECTED = null;
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final String maction_param_name;
        public final String maction_param_value;
        public final String mcontent;
        public final Boolean mdisable;
        public final Integer mnumber_of_selected;
        public final Integer mnumber_of_total;
        public final String moption_case;
        public final Boolean mselected;

        public static final class Builder extends com.squareup.wire.Message.Builder<ProgressSelectOptionProperty, Builder> {
            public String maction_id;
            public String maction_param_name;
            public String maction_param_value;
            public String mcontent;
            public Boolean mdisable;
            public Integer mnumber_of_selected;
            public Integer mnumber_of_total;
            public String moption_case;
            public Boolean mselected;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ProgressSelectOptionProperty m1480build() {
                return new ProgressSelectOptionProperty(this.maction_id, this.maction_param_name, this.maction_param_value, this.mdisable, this.mselected, this.moption_case, this.mcontent, this.mnumber_of_selected, this.mnumber_of_total, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1480build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder action_param_name(String r1) {
                this.maction_param_name = r1;
                return this;
            }

            public Builder action_param_value(String r1) {
                this.maction_param_value = r1;
                return this;
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder disable(Boolean r1) {
                this.mdisable = r1;
                return this;
            }

            public Builder number_of_selected(Integer r1) {
                this.mnumber_of_selected = r1;
                return this;
            }

            public Builder number_of_total(Integer r1) {
                this.mnumber_of_total = r1;
                return this;
            }

            public Builder option_case(String r1) {
                this.moption_case = r1;
                return this;
            }

            public Builder selected(Boolean r1) {
                this.mselected = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ProgressSelectOptionProperty extends ProtoAdapter<ProgressSelectOptionProperty> {
            public ProtoAdapter_ProgressSelectOptionProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ProgressSelectOptionProperty.class);
            }

            public ProgressSelectOptionProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                r0.maction_param_name = "";
                r0.maction_param_value = "";
                Boolean r2 = Boolean.FALSE;
                r0.mdisable = r2;
                r0.mselected = r2;
                r0.moption_case = "";
                r0.mcontent = "";
                r0.mnumber_of_selected = 0;
                r0.mnumber_of_total = 0;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L16;
                switch(r3) {
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L11;
                    case 6: goto L10;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L7:
                r0.mnumber_of_total = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L8:
                r0.mnumber_of_selected = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L9:
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                r0.moption_case = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                r0.mselected = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L12:
                r0.mdisable = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L13:
                r0.maction_param_value = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L14:
                r0.maction_param_name = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L15:
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L6:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L16:
                r7.endMessage(r1);
                return r0.m1480build();
            }

            public int encodedSize(ProgressSelectOptionProperty r6) {
                String r0 = r6.maction_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.maction_param_name;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.maction_param_value;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Boolean r10 = r6.mdisable;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Boolean r13 = r6.mselected;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                String r16 = r6.moption_case;
                if (r16 == null) goto L25;
                int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                String r19 = r6.mcontent;
                if (r19 == null) goto L29;
                int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
            L30:
                int r21 = r18 + r20;
                Integer r22 = r6.mnumber_of_selected;
                if (r22 == null) goto L33;
                int r23 = ProtoAdapter.INT32.encodedSizeWithTag(8, r22);
            L34:
                int r24 = r21 + r23;
                Integer r25 = r6.mnumber_of_total;
                if (r25 == null) goto L38;
                r1 = ProtoAdapter.INT32.encodedSizeWithTag(9, r25);
            L38:
                return (r24 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1481decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ProgressSelectOptionProperty) r1);
            }

            public void encode(ProtoWriter r4, ProgressSelectOptionProperty r5) throws IOException {
                String r0 = r5.maction_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.maction_param_name;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.maction_param_value;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                Boolean r3 = r5.mdisable;
                if (r3 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
            L14:
                Boolean r6 = r5.mselected;
                if (r6 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
            L17:
                String r7 = r5.moption_case;
                if (r7 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
            L20:
                String r8 = r5.mcontent;
                if (r8 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
            L23:
                Integer r9 = r5.mnumber_of_selected;
                if (r9 == null) goto L26;
                ProtoAdapter.INT32.encodeWithTag(r4, 8, r9);
            L26:
                Integer r10 = r5.mnumber_of_total;
                if (r10 == null) goto L29;
                ProtoAdapter.INT32.encodeWithTag(r4, 9, r10);
            L29:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ProgressSelectOptionProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ProgressSelectOptionProperty();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_DISABLE = r0;
            DEFAULT_SELECTED = r0;
            DEFAULT_NUMBER_OF_SELECTED = 0;
            DEFAULT_NUMBER_OF_TOTAL = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1479newBuilder() {
            Builder r0 = new Builder();
            r0.maction_id = this.maction_id;
            r0.maction_param_name = this.maction_param_name;
            r0.maction_param_value = this.maction_param_value;
            r0.mdisable = this.mdisable;
            r0.mselected = this.mselected;
            r0.moption_case = this.moption_case;
            r0.mcontent = this.mcontent;
            r0.mnumber_of_selected = this.mnumber_of_selected;
            r0.mnumber_of_total = this.mnumber_of_total;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ProgressSelectOptionProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1479newBuilder();
        }

        public ProgressSelectOptionProperty(String r12, String r13, String r14, Boolean r15, Boolean r16, String r17, String r18, Integer r19, Integer r20) {
            this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
        }

        public ProgressSelectOptionProperty(String r2, String r3, String r4, Boolean r5, Boolean r6, String r7, String r8, Integer r9, Integer r10, ByteString r11) {
            super(ADAPTER, r11);
            this.maction_id = r2;
            this.maction_param_name = r3;
            this.maction_param_value = r4;
            this.mdisable = r5;
            this.mselected = r6;
            this.moption_case = r7;
            this.mcontent = r8;
            this.mnumber_of_selected = r9;
            this.mnumber_of_total = r10;
        }
    }

    public static final class ProtoAdapter_RichTextElement extends ProtoAdapter<RichTextElement> {
        private final ProtoAdapter<Map<String, String>> mstyle;

        public ProtoAdapter_RichTextElement() {
            super(FieldEncoding.LENGTH_DELIMITED, RichTextElement.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mstyle = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public RichTextElement decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            ByteString r1 = ByteString.EMPTY;
            r0.mproperty = r1;
            r0.mupgrade_element = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L18;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r0.mtag = (Tag) Tag.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mupgrade_element = (ByteString) ProtoAdapter.BYTES.decode(r9);
            goto L3
        L8:
            r0.mstyle_keys.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L9:
            r0.mchild_ids.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L10:
            r0.mproperty = (ByteString) ProtoAdapter.BYTES.decode(r9);
            goto L3
        L11:
            r0.mstyle.putAll((Map) this.mstyle.decode(r9));
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L16:
            r9.endMessage(r2);
            return r0.m1364build();
        }

        public int encodedSize(RichTextElement r7) {
            int r0 = Tag.ADAPTER.encodedSizeWithTag(1, r7.mtag) + this.mstyle.encodedSizeWithTag(2, r7.mstyle);
            ProtoAdapter r1 = ProtoAdapter.BYTES;
            int r2 = r0 + r1.encodedSizeWithTag(3, r7.mproperty);
            ProtoAdapter r3 = ProtoAdapter.STRING;
            int r4 = (r2 + r3.asRepeated().encodedSizeWithTag(4, r7.mchild_ids)) + r3.asRepeated().encodedSizeWithTag(5, r7.mstyle_keys);
            ByteString r5 = r7.mupgrade_element;
            if (r5 == null) goto L5;
            int r6 = r1.encodedSizeWithTag(6, r5);
        L7:
            return (r4 + r6) + r7.unknownFields().size();
        L5:
            r6 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1482decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RichTextElement) r1);
        }

        public void encode(ProtoWriter r6, RichTextElement r7) throws IOException {
            Tag.ADAPTER.encodeWithTag(r6, 1, r7.mtag);
            this.mstyle.encodeWithTag(r6, 2, r7.mstyle);
            ProtoAdapter r0 = ProtoAdapter.BYTES;
            r0.encodeWithTag(r6, 3, r7.mproperty);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            r1.asRepeated().encodeWithTag(r6, 4, r7.mchild_ids);
            r1.asRepeated().encodeWithTag(r6, 5, r7.mstyle_keys);
            ByteString r2 = r7.mupgrade_element;
            if (r2 == null) goto L5;
            r0.encodeWithTag(r6, 6, r2);
        L5:
            r6.writeBytes(r7.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RichTextElement) r2);
        }
    }

    public static final class QuoteProperty extends com.squareup.wire.Message<QuoteProperty, Builder> {
        public static final ProtoAdapter<QuoteProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<QuoteProperty, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public QuoteProperty m1484build() {
                return new QuoteProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1484build();
            }
        }

        public static final class ProtoAdapter_QuoteProperty extends ProtoAdapter<QuoteProperty> {
            public ProtoAdapter_QuoteProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, QuoteProperty.class);
            }

            public QuoteProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1484build();
            }

            public int encodedSize(QuoteProperty r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1485decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((QuoteProperty) r1);
            }

            public void encode(ProtoWriter r1, QuoteProperty r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (QuoteProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_QuoteProperty();
        }

        public QuoteProperty() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1483newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return QuoteProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1483newBuilder();
        }

        public QuoteProperty(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class ReactionProperty extends com.squareup.wire.Message<ReactionProperty, Builder> {
        public static final ProtoAdapter<ReactionProperty> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mkey;

        public static final class Builder extends com.squareup.wire.Message.Builder<ReactionProperty, Builder> {
            public String mkey;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ReactionProperty m1487build() {
                String r0 = this.mkey;
                if (r0 == null) goto L7;
                return new ReactionProperty(this.mkey, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mkey"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1487build();
            }

            public Builder key(String r1) {
                this.mkey = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ReactionProperty extends ProtoAdapter<ReactionProperty> {
            public ProtoAdapter_ReactionProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ReactionProperty.class);
            }

            public ReactionProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mkey = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1487build();
            }

            public int encodedSize(ReactionProperty r4) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r4.mkey) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1488decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ReactionProperty) r1);
            }

            public void encode(ProtoWriter r4, ReactionProperty r5) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mkey);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ReactionProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ReactionProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1486newBuilder() {
            Builder r0 = new Builder();
            r0.mkey = this.mkey;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ReactionProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1486newBuilder();
        }

        public ReactionProperty(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public ReactionProperty(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mkey = r2;
        }
    }

    public static final class SelectMenuProperty extends com.squareup.wire.Message<SelectMenuProperty, Builder> {
        public static final ProtoAdapter<SelectMenuProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_INITIAL_OPTION = "";
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ButtonConfirmProperty mconfirm;
        public final String minitial_option;
        public final List<MenuOption> moptions;
        public final String mplace_holder;
        public final String mplace_holder_i18n_key;
        public final Type mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<SelectMenuProperty, Builder> {
            public String maction_id;
            public ButtonConfirmProperty mconfirm;
            public String minitial_option;
            public List<MenuOption> moptions;
            public String mplace_holder;
            public String mplace_holder_i18n_key;
            public Type mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SelectMenuProperty m1490build() {
                return new SelectMenuProperty(this.mtype, this.maction_id, this.mplace_holder, this.mplace_holder_i18n_key, this.minitial_option, this.moptions, this.mconfirm, super.buildUnknownFields());
            }

            public Builder() {
                this.moptions = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1490build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r1) {
                this.mconfirm = r1;
                return this;
            }

            public Builder initial_option(String r1) {
                this.minitial_option = r1;
                return this;
            }

            public Builder options(List<MenuOption> r1) {
                Internal.checkElementsNotNull(r1);
                this.moptions = r1;
                return this;
            }

            public Builder place_holder(String r1) {
                this.mplace_holder = r1;
                return this;
            }

            public Builder place_holder_i18n_key(String r1) {
                this.mplace_holder_i18n_key = r1;
                return this;
            }

            public Builder type(Type r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SelectMenuProperty extends ProtoAdapter<SelectMenuProperty> {
            public ProtoAdapter_SelectMenuProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, SelectMenuProperty.class);
            }

            public SelectMenuProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                r0.mplace_holder = "";
                r0.mplace_holder_i18n_key = "";
                r0.minitial_option = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L17;
                switch(r3) {
                    case 1: goto L19;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L19:
                r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mconfirm = (ButtonConfirmProperty) ButtonConfirmProperty.ADAPTER.decode(r9);
                goto L3
            L8:
                r0.moptions.add((MenuOption) MenuOption.ADAPTER.decode(r9));
                goto L3
            L9:
                r0.minitial_option = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                r0.mplace_holder_i18n_key = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L11:
                r0.mplace_holder = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L12:
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L17:
                r9.endMessage(r1);
                return r0.m1490build();
            }

            public int encodedSize(SelectMenuProperty r6) {
                Type r0 = r6.mtype;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Type.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.maction_id;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mplace_holder;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mplace_holder_i18n_key;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                String r13 = r6.minitial_option;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
            L22:
                int r15 = (r12 + r14) + MenuOption.ADAPTER.asRepeated().encodedSizeWithTag(6, r6.moptions);
                ButtonConfirmProperty r16 = r6.mconfirm;
                if (r16 == null) goto L26;
                r1 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(7, r16);
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
            public /* bridge */ /* synthetic */ Object m1491decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SelectMenuProperty) r1);
            }

            public void encode(ProtoWriter r4, SelectMenuProperty r5) throws IOException {
                Type r0 = r5.mtype;
                if (r0 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.maction_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mplace_holder;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mplace_holder_i18n_key;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                String r6 = r5.minitial_option;
                if (r6 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
            L17:
                MenuOption.ADAPTER.asRepeated().encodeWithTag(r4, 6, r5.moptions);
                ButtonConfirmProperty r7 = r5.mconfirm;
                if (r7 == null) goto L20;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r4, 7, r7);
            L20:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SelectMenuProperty) r2);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type PERSON = null;
            public static final Type STATIC = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r0 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Type r1 = new Type("STATIC", 1, 1);
                STATIC = r1;
                Type r3 = new Type("PERSON", 2, 2);
                PERSON = r3;
                $VALUES = new Type[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return PERSON;
            L12:
                return STATIC;
            L14:
                return UNKNOWN;
            }

            public static Type valueOf(String r1) {
                return (Type) a.a(Type.class, r1);
            }

            private Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SelectMenuProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1489newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.maction_id = this.maction_id;
            r0.mplace_holder = this.mplace_holder;
            r0.mplace_holder_i18n_key = this.mplace_holder_i18n_key;
            r0.minitial_option = this.minitial_option;
            r0.moptions = Internal.copyOf("moptions", this.moptions);
            r0.mconfirm = this.mconfirm;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SelectMenuProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1489newBuilder();
        }

        public SelectMenuProperty(Type r10, String r11, String r12, String r13, String r14, List<MenuOption> r15, ButtonConfirmProperty r16) {
            this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
        }

        public SelectMenuProperty(Type r2, String r3, String r4, String r5, String r6, List<MenuOption> r7, ButtonConfirmProperty r8, ByteString r9) {
            super(ADAPTER, r9);
            this.mtype = r2;
            this.maction_id = r3;
            this.mplace_holder = r4;
            this.mplace_holder_i18n_key = r5;
            this.minitial_option = r6;
            this.moptions = Internal.immutableCopyOf("moptions", r7);
            this.mconfirm = r8;
        }
    }

    public static final class SelectProperty extends com.squareup.wire.Message<SelectProperty, Builder> {
        public static final ProtoAdapter<SelectProperty> ADAPTER = null;
        public static final Integer DEFAULT_MAX_PICK_NUM = null;
        public static final Integer DEFAULT_MIN_PICK_NUM = null;
        private static final long serialVersionUID = 0;
        public final Integer mmax_pick_num;
        public final Integer mmin_pick_num;

        public static final class Builder extends com.squareup.wire.Message.Builder<SelectProperty, Builder> {
            public Integer mmax_pick_num;
            public Integer mmin_pick_num;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SelectProperty m1493build() {
                return new SelectProperty(this.mmin_pick_num, this.mmax_pick_num, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1493build();
            }

            public Builder max_pick_num(Integer r1) {
                this.mmax_pick_num = r1;
                return this;
            }

            public Builder min_pick_num(Integer r1) {
                this.mmin_pick_num = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SelectProperty extends ProtoAdapter<SelectProperty> {
            public ProtoAdapter_SelectProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, SelectProperty.class);
            }

            public SelectProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mmin_pick_num = 1;
                r0.mmax_pick_num = 1;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 4) goto L8;
                r0.mmin_pick_num = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L8:
                if (r3 != 5) goto L9;
                r0.mmax_pick_num = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1493build();
            }

            public int encodedSize(SelectProperty r5) {
                Integer r0 = r5.mmin_pick_num;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT32.encodedSizeWithTag(4, r0);
            L6:
                Integer r3 = r5.mmax_pick_num;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.INT32.encodedSizeWithTag(5, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1494decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SelectProperty) r1);
            }

            public void encode(ProtoWriter r4, SelectProperty r5) throws IOException {
                Integer r0 = r5.mmin_pick_num;
                if (r0 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r4, 4, r0);
            L5:
                Integer r1 = r5.mmax_pick_num;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 5, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SelectProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SelectProperty();
            DEFAULT_MIN_PICK_NUM = 1;
            DEFAULT_MAX_PICK_NUM = 1;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1492newBuilder() {
            Builder r0 = new Builder();
            r0.mmin_pick_num = this.mmin_pick_num;
            r0.mmax_pick_num = this.mmax_pick_num;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SelectProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1492newBuilder();
        }

        public SelectProperty(Integer r2, Integer r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public SelectProperty(Integer r2, Integer r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mmin_pick_num = r2;
            this.mmax_pick_num = r3;
        }
    }

    public static final class TableCellProperty extends com.squareup.wire.Message<TableCellProperty, Builder> {
        public static final ProtoAdapter<TableCellProperty> ADAPTER = null;
        public static final Integer DEFAULT_COLSPAN = null;
        public static final Boolean DEFAULT_IS_MERGED = null;
        public static final Integer DEFAULT_ROWSPAN = null;
        private static final long serialVersionUID = 0;
        public final Integer mcolspan;
        public final HorizontalAlign mhorizontal_align;
        public final Boolean mis_merged;
        public final Integer mrowspan;
        public final VerticalAlign mvertical_align;

        public static final class Builder extends com.squareup.wire.Message.Builder<TableCellProperty, Builder> {
            public Integer mcolspan;
            public HorizontalAlign mhorizontal_align;
            public Boolean mis_merged;
            public Integer mrowspan;
            public VerticalAlign mvertical_align;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TableCellProperty m1496build() {
                return new TableCellProperty(this.mcolspan, this.mrowspan, this.mhorizontal_align, this.mvertical_align, this.mis_merged, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1496build();
            }

            public Builder colspan(Integer r1) {
                this.mcolspan = r1;
                return this;
            }

            public Builder horizontal_align(HorizontalAlign r1) {
                this.mhorizontal_align = r1;
                return this;
            }

            public Builder is_merged(Boolean r1) {
                this.mis_merged = r1;
                return this;
            }

            public Builder rowspan(Integer r1) {
                this.mrowspan = r1;
                return this;
            }

            public Builder vertical_align(VerticalAlign r1) {
                this.mvertical_align = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TableCellProperty extends ProtoAdapter<TableCellProperty> {
            public ProtoAdapter_TableCellProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TableCellProperty.class);
            }

            public TableCellProperty decode(ProtoReader r10) throws IOException {
                Builder r0 = new Builder();
                r0.mcolspan = 1;
                r0.mrowspan = 1;
                r0.mis_merged = Boolean.FALSE;
                long r2 = r10.beginMessage();
            L3:
                int r4 = r10.nextTag();
                if (r4 == (-1)) goto L26;
                if (r4 != 1) goto L7;
                r0.mcolspan = (Integer) ProtoAdapter.INT32.decode(r10);
                goto L3
            L7:
                if (r4 != 2) goto L9;
                r0.mrowspan = (Integer) ProtoAdapter.INT32.decode(r10);
                goto L3
            L9:
                if (r4 != 3) goto L11;
                r0.mhorizontal_align = (HorizontalAlign) HorizontalAlign.ADAPTER.decode(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r0.addUnknownField(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                if (r4 != 4) goto L13;
                r0.mvertical_align = (VerticalAlign) VerticalAlign.ADAPTER.decode(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r0.addUnknownField(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L13:
                if (r4 != 5) goto L14;
                r0.mis_merged = (Boolean) ProtoAdapter.BOOL.decode(r10);
                goto L3
            L14:
                FieldEncoding r5 = r10.peekFieldEncoding();
                r0.addUnknownField(r4, r5, r5.rawProtoAdapter().decode(r10));
                goto L3
            L26:
                r10.endMessage(r2);
                return r0.m1496build();
            }

            public int encodedSize(TableCellProperty r6) {
                Integer r0 = r6.mcolspan;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r6.mrowspan;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                HorizontalAlign r7 = r6.mhorizontal_align;
                if (r7 == null) goto L13;
                int r8 = HorizontalAlign.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                VerticalAlign r10 = r6.mvertical_align;
                if (r10 == null) goto L17;
                int r11 = VerticalAlign.ADAPTER.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Boolean r13 = r6.mis_merged;
                if (r13 == null) goto L22;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
            L22:
                return (r12 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1497decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TableCellProperty) r1);
            }

            public void encode(ProtoWriter r4, TableCellProperty r5) throws IOException {
                Integer r0 = r5.mcolspan;
                if (r0 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mrowspan;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
            L8:
                HorizontalAlign r2 = r5.mhorizontal_align;
                if (r2 == null) goto L11;
                HorizontalAlign.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                VerticalAlign r3 = r5.mvertical_align;
                if (r3 == null) goto L14;
                VerticalAlign.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                Boolean r6 = r5.mis_merged;
                if (r6 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
            L17:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TableCellProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TableCellProperty();
            DEFAULT_COLSPAN = 1;
            DEFAULT_ROWSPAN = 1;
            DEFAULT_IS_MERGED = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1495newBuilder() {
            Builder r0 = new Builder();
            r0.mcolspan = this.mcolspan;
            r0.mrowspan = this.mrowspan;
            r0.mhorizontal_align = this.mhorizontal_align;
            r0.mvertical_align = this.mvertical_align;
            r0.mis_merged = this.mis_merged;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TableCellProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1495newBuilder();
        }

        public TableCellProperty(Integer r8, Integer r9, HorizontalAlign r10, VerticalAlign r11, Boolean r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public TableCellProperty(Integer r2, Integer r3, HorizontalAlign r4, VerticalAlign r5, Boolean r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mcolspan = r2;
            this.mrowspan = r3;
            this.mhorizontal_align = r4;
            this.mvertical_align = r5;
            this.mis_merged = r6;
        }
    }

    public static final class TableProperty extends com.squareup.wire.Message<TableProperty, Builder> {
        public static final ProtoAdapter<TableProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Column> mcolumns;

        public static final class Builder extends com.squareup.wire.Message.Builder<TableProperty, Builder> {
            public List<Column> mcolumns;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TableProperty m1499build() {
                return new TableProperty(this.mcolumns, super.buildUnknownFields());
            }

            public Builder() {
                this.mcolumns = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1499build();
            }

            public Builder columns(List<Column> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcolumns = r1;
                return this;
            }
        }

        public static final class Column extends com.squareup.wire.Message<Column, Builder> {
            public static final ProtoAdapter<Column> ADAPTER = null;
            public static final Boolean DEFAULT_IS_HEADER = null;
            public static final Integer DEFAULT_WIDTH = null;
            private static final long serialVersionUID = 0;
            public final HorizontalAlign mhorizontal_align;
            public final Boolean mis_header;
            public final VerticalAlign mvertical_align;
            public final Integer mwidth;

            public static final class Builder extends com.squareup.wire.Message.Builder<Column, Builder> {
                public HorizontalAlign mhorizontal_align;
                public Boolean mis_header;
                public VerticalAlign mvertical_align;
                public Integer mwidth;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public Column m1501build() {
                    return new Column(this.mwidth, this.mhorizontal_align, this.mvertical_align, this.mis_header, super.buildUnknownFields());
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1501build();
                }

                public Builder horizontal_align(HorizontalAlign r1) {
                    this.mhorizontal_align = r1;
                    return this;
                }

                public Builder is_header(Boolean r1) {
                    this.mis_header = r1;
                    return this;
                }

                public Builder vertical_align(VerticalAlign r1) {
                    this.mvertical_align = r1;
                    return this;
                }

                public Builder width(Integer r1) {
                    this.mwidth = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_Column extends ProtoAdapter<Column> {
                public ProtoAdapter_Column() {
                    super(FieldEncoding.LENGTH_DELIMITED, Column.class);
                }

                public Column decode(ProtoReader r9) throws IOException {
                    Builder r0 = new Builder();
                    r0.mwidth = 0;
                    r0.mis_header = Boolean.FALSE;
                    long r1 = r9.beginMessage();
                L3:
                    int r3 = r9.nextTag();
                    if (r3 == (-1)) goto L24;
                    if (r3 != 1) goto L8;
                    r0.mwidth = (Integer) ProtoAdapter.INT32.decode(r9);
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.mhorizontal_align = (HorizontalAlign) HorizontalAlign.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
                L21:
                    e = move-exception;
                    r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r3 != 3) goto L12;
                    r0.mvertical_align = (VerticalAlign) VerticalAlign.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
                L17:
                    e = move-exception;
                    r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L12:
                    if (r3 != 4) goto L13;
                    r0.mis_header = (Boolean) ProtoAdapter.BOOL.decode(r9);
                    goto L3
                L13:
                    FieldEncoding r4 = r9.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                    goto L3
                L24:
                    r9.endMessage(r1);
                    return r0.m1501build();
                }

                public int encodedSize(Column r6) {
                    Integer r0 = r6.mwidth;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
                L6:
                    HorizontalAlign r3 = r6.mhorizontal_align;
                    if (r3 == null) goto L9;
                    int r4 = HorizontalAlign.ADAPTER.encodedSizeWithTag(2, r3);
                L10:
                    int r5 = r2 + r4;
                    VerticalAlign r7 = r6.mvertical_align;
                    if (r7 == null) goto L13;
                    int r8 = VerticalAlign.ADAPTER.encodedSizeWithTag(3, r7);
                L14:
                    int r9 = r5 + r8;
                    Boolean r10 = r6.mis_header;
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
                public /* bridge */ /* synthetic */ Object m1502decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((Column) r1);
                }

                public void encode(ProtoWriter r4, Column r5) throws IOException {
                    Integer r0 = r5.mwidth;
                    if (r0 == null) goto L5;
                    ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
                L5:
                    HorizontalAlign r1 = r5.mhorizontal_align;
                    if (r1 == null) goto L8;
                    HorizontalAlign.ADAPTER.encodeWithTag(r4, 2, r1);
                L8:
                    VerticalAlign r2 = r5.mvertical_align;
                    if (r2 == null) goto L11;
                    VerticalAlign.ADAPTER.encodeWithTag(r4, 3, r2);
                L11:
                    Boolean r3 = r5.mis_header;
                    if (r3 == null) goto L14;
                    ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
                L14:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (Column) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Column();
                DEFAULT_WIDTH = 0;
                DEFAULT_IS_HEADER = Boolean.FALSE;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1500newBuilder() {
                Builder r0 = new Builder();
                r0.mwidth = this.mwidth;
                r0.mhorizontal_align = this.mhorizontal_align;
                r0.mvertical_align = this.mvertical_align;
                r0.mis_header = this.mis_header;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return Column.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1500newBuilder();
            }

            public Column(Integer r7, HorizontalAlign r8, VerticalAlign r9, Boolean r10) {
                this(r7, r8, r9, r10, ByteString.EMPTY);
            }

            public Column(Integer r2, HorizontalAlign r3, VerticalAlign r4, Boolean r5, ByteString r6) {
                super(ADAPTER, r6);
                this.mwidth = r2;
                this.mhorizontal_align = r3;
                this.mvertical_align = r4;
                this.mis_header = r5;
            }
        }

        public static final class ProtoAdapter_TableProperty extends ProtoAdapter<TableProperty> {
            public ProtoAdapter_TableProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TableProperty.class);
            }

            public TableProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mcolumns.add((Column) Column.ADAPTER.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1499build();
            }

            public int encodedSize(TableProperty r4) {
                return Column.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mcolumns) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1503decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TableProperty) r1);
            }

            public void encode(ProtoWriter r4, TableProperty r5) throws IOException {
                Column.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mcolumns);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TableProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TableProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1498newBuilder() {
            Builder r0 = new Builder();
            r0.mcolumns = Internal.copyOf("mcolumns", this.mcolumns);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TableProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1498newBuilder();
        }

        public TableProperty(List<Column> r2) {
            this(r2, ByteString.EMPTY);
        }

        public TableProperty(List<Column> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mcolumns = Internal.immutableCopyOf("mcolumns", r2);
        }
    }

    public static final class TableRowProperty extends com.squareup.wire.Message<TableRowProperty, Builder> {
        public static final ProtoAdapter<TableRowProperty> ADAPTER = null;
        public static final Boolean DEFAULT_IS_HEADER = null;
        private static final long serialVersionUID = 0;
        public final HorizontalAlign mhorizontal_align;
        public final Boolean mis_header;
        public final VerticalAlign mvertical_align;

        public static final class Builder extends com.squareup.wire.Message.Builder<TableRowProperty, Builder> {
            public HorizontalAlign mhorizontal_align;
            public Boolean mis_header;
            public VerticalAlign mvertical_align;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TableRowProperty m1505build() {
                return new TableRowProperty(this.mhorizontal_align, this.mvertical_align, this.mis_header, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1505build();
            }

            public Builder horizontal_align(HorizontalAlign r1) {
                this.mhorizontal_align = r1;
                return this;
            }

            public Builder is_header(Boolean r1) {
                this.mis_header = r1;
                return this;
            }

            public Builder vertical_align(VerticalAlign r1) {
                this.mvertical_align = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TableRowProperty extends ProtoAdapter<TableRowProperty> {
            public ProtoAdapter_TableRowProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TableRowProperty.class);
            }

            public TableRowProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mis_header = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mhorizontal_align = (HorizontalAlign) HorizontalAlign.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mvertical_align = (VerticalAlign) VerticalAlign.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mis_header = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m1505build();
            }

            public int encodedSize(TableRowProperty r6) {
                HorizontalAlign r0 = r6.mhorizontal_align;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = HorizontalAlign.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                VerticalAlign r3 = r6.mvertical_align;
                if (r3 == null) goto L9;
                int r4 = VerticalAlign.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Boolean r7 = r6.mis_header;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
            L14:
                return (r5 + r1) + r6.unknownFields().size();
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1506decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TableRowProperty) r1);
            }

            public void encode(ProtoWriter r4, TableRowProperty r5) throws IOException {
                HorizontalAlign r0 = r5.mhorizontal_align;
                if (r0 == null) goto L5;
                HorizontalAlign.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                VerticalAlign r1 = r5.mvertical_align;
                if (r1 == null) goto L8;
                VerticalAlign.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                Boolean r2 = r5.mis_header;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TableRowProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TableRowProperty();
            DEFAULT_IS_HEADER = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1504newBuilder() {
            Builder r0 = new Builder();
            r0.mhorizontal_align = this.mhorizontal_align;
            r0.mvertical_align = this.mvertical_align;
            r0.mis_header = this.mis_header;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TableRowProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1504newBuilder();
        }

        public TableRowProperty(HorizontalAlign r2, VerticalAlign r3, Boolean r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public TableRowProperty(HorizontalAlign r2, VerticalAlign r3, Boolean r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mhorizontal_align = r2;
            this.mvertical_align = r3;
            this.mis_header = r4;
        }
    }

    public static final enum Tag extends Enum<Tag> implements WireEnum {
        private static final /* synthetic */ Tag[] $VALUES = null;
        public static final Tag A = null;
        public static final ProtoAdapter<Tag> ADAPTER = null;
        public static final Tag AT = null;
        public static final Tag AT_USER_GROUP = null;
        public static final Tag B = null;
        public static final Tag BUTTON = null;
        public static final Tag CODE = null;
        public static final Tag CODE_BLOCK = null;
        public static final Tag CODE_BLOCK_V2 = null;
        public static final Tag COLUMN = null;
        public static final Tag COLUMNS = null;
        public static final Tag DATEPICKER = null;
        public static final Tag DATETIMEPICKER = null;
        public static final Tag DIV = null;
        public static final Tag DOCS = null;
        public static final Tag EMOTION = null;
        public static final Tag FIGURE = null;
        public static final Tag H1 = null;
        public static final Tag H2 = null;
        public static final Tag H3 = null;
        public static final Tag H4 = null;
        public static final Tag H5 = null;
        public static final Tag H6 = null;
        public static final Tag HR = null;
        public static final Tag I = null;
        public static final Tag IMG = null;
        public static final Tag LI = null;
        public static final Tag LINK = null;
        public static final Tag MARKDOWN = null;
        public static final Tag MEDIA = null;
        public static final Tag MENTION = null;
        public static final Tag MY_AI_TOOL = null;
        public static final Tag OL = null;
        public static final Tag OVERFLOWMENU = null;
        public static final Tag P = null;
        public static final Tag PROGRESS_SELECT_OPTION = null;
        public static final Tag QUOTE = null;
        public static final Tag REACTION = null;
        public static final Tag SELECT = null;
        public static final Tag SELECTMENU = null;
        public static final Tag TABLE = null;
        public static final Tag TABLE_CELL = null;
        public static final Tag TABLE_ROW = null;
        public static final Tag TEXT = null;
        public static final Tag TEXTABLE_AREA = null;
        public static final Tag TIME = null;
        public static final Tag TIMEPICKER = null;
        public static final Tag U = null;
        public static final Tag UL = null;
        public static final Tag UNKNOWN_TAG = null;
        private final int value;

        static {
            Tag r0 = new Tag("UNKNOWN_TAG", 0, 0);
            UNKNOWN_TAG = r0;
            Tag r1 = new Tag("TEXT", 1, 1);
            TEXT = r1;
            Tag r3 = new Tag("IMG", 2, 2);
            IMG = r3;
            Tag r5 = new Tag("P", 3, 3);
            P = r5;
            Tag r7 = new Tag("FIGURE", 4, 4);
            FIGURE = r7;
            Tag r9 = new Tag("AT", 5, 5);
            AT = r9;
            Tag r11 = new Tag("A", 6, 6);
            A = r11;
            Tag r13 = new Tag("B", 7, 7);
            B = r13;
            Tag r15 = new Tag("I", 8, 8);
            I = r15;
            Tag r14 = new Tag("U", 9, 9);
            U = r14;
            Tag r12 = new Tag("EMOTION", 10, 10);
            EMOTION = r12;
            Tag r10 = new Tag("BUTTON", 11, 11);
            BUTTON = r10;
            Tag r8 = new Tag("SELECT", 12, 12);
            SELECT = r8;
            Tag r6 = new Tag("PROGRESS_SELECT_OPTION", 13, 13);
            PROGRESS_SELECT_OPTION = r6;
            Tag r4 = new Tag("DIV", 14, 14);
            DIV = r4;
            Tag r2 = new Tag("TEXTABLE_AREA", 15, 15);
            TEXTABLE_AREA = r2;
            Tag r16 = new Tag("TIME", 16, 16);
            TIME = r16;
            Tag r17 = new Tag("LINK", 17, 17);
            LINK = r17;
            Tag r18 = new Tag("MEDIA", 18, 18);
            MEDIA = r18;
            Tag r19 = new Tag("SELECTMENU", 19, 19);
            SELECTMENU = r19;
            Tag r20 = new Tag("OVERFLOWMENU", 20, 20);
            OVERFLOWMENU = r20;
            Tag r21 = new Tag("DATEPICKER", 21, 21);
            DATEPICKER = r21;
            Tag r22 = new Tag("DOCS", 22, 22);
            DOCS = r22;
            Tag r23 = new Tag("H1", 23, 23);
            H1 = r23;
            Tag r24 = new Tag("H2", 24, 24);
            H2 = r24;
            Tag r25 = new Tag("H3", 25, 25);
            H3 = r25;
            Tag r26 = new Tag("UL", 26, 26);
            UL = r26;
            Tag r27 = new Tag("OL", 27, 27);
            OL = r27;
            Tag r28 = new Tag("LI", 28, 28);
            LI = r28;
            Tag r29 = new Tag("QUOTE", 29, 29);
            QUOTE = r29;
            Tag r30 = new Tag("CODE", 30, 30);
            CODE = r30;
            Tag r31 = new Tag("CODE_BLOCK", 31, 31);
            CODE_BLOCK = r31;
            Tag r32 = new Tag("HR", 32, 32);
            HR = r32;
            Tag r33 = new Tag("TIMEPICKER", 33, 33);
            TIMEPICKER = r33;
            Tag r34 = new Tag("DATETIMEPICKER", 34, 34);
            DATETIMEPICKER = r34;
            Tag r35 = new Tag("REACTION", 35, 35);
            REACTION = r35;
            Tag r36 = new Tag("MENTION", 36, 36);
            MENTION = r36;
            Tag r37 = new Tag("CODE_BLOCK_V2", 37, 37);
            CODE_BLOCK_V2 = r37;
            Tag r38 = new Tag("MY_AI_TOOL", 38, 38);
            MY_AI_TOOL = r38;
            Tag r39 = new Tag("TABLE", 39, 39);
            TABLE = r39;
            Tag r40 = new Tag("TABLE_ROW", 40, 40);
            TABLE_ROW = r40;
            Tag r41 = new Tag("TABLE_CELL", 41, 41);
            TABLE_CELL = r41;
            Tag r42 = new Tag("COLUMNS", 42, 42);
            COLUMNS = r42;
            Tag r43 = new Tag("COLUMN", 43, 43);
            COLUMN = r43;
            Tag r44 = new Tag("H4", 44, 44);
            H4 = r44;
            Tag r45 = new Tag("H5", 45, 45);
            H5 = r45;
            Tag r46 = new Tag("H6", 46, 46);
            H6 = r46;
            Tag r47 = new Tag("AT_USER_GROUP", 47, 47);
            AT_USER_GROUP = r47;
            Tag r48 = new Tag("MARKDOWN", 48, 49);
            MARKDOWN = r48;
            $VALUES = new Tag[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48};
            ADAPTER = ProtoAdapter.newEnumAdapter(Tag.class);
        }

        public static Tag[] values() {
            return (Tag[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Tag fromValue(int r0) {
            switch(r0) {
                case 0: goto L102;
                case 1: goto L100;
                case 2: goto L98;
                case 3: goto L96;
                case 4: goto L94;
                case 5: goto L92;
                case 6: goto L90;
                case 7: goto L88;
                case 8: goto L86;
                case 9: goto L84;
                case 10: goto L82;
                case 11: goto L80;
                case 12: goto L78;
                case 13: goto L76;
                case 14: goto L74;
                case 15: goto L72;
                case 16: goto L70;
                case 17: goto L68;
                case 18: goto L66;
                case 19: goto L64;
                case 20: goto L62;
                case 21: goto L60;
                case 22: goto L58;
                case 23: goto L56;
                case 24: goto L54;
                case 25: goto L52;
                case 26: goto L50;
                case 27: goto L48;
                case 28: goto L46;
                case 29: goto L44;
                case 30: goto L42;
                case 31: goto L40;
                case 32: goto L38;
                case 33: goto L36;
                case 34: goto L34;
                case 35: goto L32;
                case 36: goto L30;
                case 37: goto L28;
                case 38: goto L26;
                case 39: goto L24;
                case 40: goto L22;
                case 41: goto L20;
                case 42: goto L18;
                case 43: goto L16;
                case 44: goto L14;
                case 45: goto L12;
                case 46: goto L10;
                case 47: goto L8;
                case 48: goto L3;
                case 49: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MARKDOWN;
        L8:
            return AT_USER_GROUP;
        L10:
            return H6;
        L12:
            return H5;
        L14:
            return H4;
        L16:
            return COLUMN;
        L18:
            return COLUMNS;
        L20:
            return TABLE_CELL;
        L22:
            return TABLE_ROW;
        L24:
            return TABLE;
        L26:
            return MY_AI_TOOL;
        L28:
            return CODE_BLOCK_V2;
        L30:
            return MENTION;
        L32:
            return REACTION;
        L34:
            return DATETIMEPICKER;
        L36:
            return TIMEPICKER;
        L38:
            return HR;
        L40:
            return CODE_BLOCK;
        L42:
            return CODE;
        L44:
            return QUOTE;
        L46:
            return LI;
        L48:
            return OL;
        L50:
            return UL;
        L52:
            return H3;
        L54:
            return H2;
        L56:
            return H1;
        L58:
            return DOCS;
        L60:
            return DATEPICKER;
        L62:
            return OVERFLOWMENU;
        L64:
            return SELECTMENU;
        L66:
            return MEDIA;
        L68:
            return LINK;
        L70:
            return TIME;
        L72:
            return TEXTABLE_AREA;
        L74:
            return DIV;
        L76:
            return PROGRESS_SELECT_OPTION;
        L78:
            return SELECT;
        L80:
            return BUTTON;
        L82:
            return EMOTION;
        L84:
            return U;
        L86:
            return I;
        L88:
            return B;
        L90:
            return A;
        L92:
            return AT;
        L94:
            return FIGURE;
        L96:
            return P;
        L98:
            return IMG;
        L100:
            return TEXT;
        L102:
            return UNKNOWN_TAG;
        }

        public static Tag valueOf(String r1) {
            return (Tag) a.a(Tag.class, r1);
        }

        private Tag(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class TextProperty extends com.squareup.wire.Message<TextProperty, Builder> {
        public static final ProtoAdapter<TextProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        public static final Integer DEFAULT_NUMBEROFLINES = null;
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mi18n_key;
        public final Integer mnumberOfLines;

        public static final class Builder extends com.squareup.wire.Message.Builder<TextProperty, Builder> {
            public String mcontent;
            public String mi18n_key;
            public Integer mnumberOfLines;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TextProperty m1508build() {
                String r0 = this.mcontent;
                if (r0 == null) goto L7;
                return new TextProperty(this.mcontent, this.mi18n_key, this.mnumberOfLines, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mcontent"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1508build();
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder i18n_key(String r1) {
                this.mi18n_key = r1;
                return this;
            }

            public Builder numberOfLines(Integer r1) {
                this.mnumberOfLines = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TextProperty extends ProtoAdapter<TextProperty> {
            public ProtoAdapter_TextProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TextProperty.class);
            }

            public TextProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcontent = "";
                r0.mi18n_key = "";
                r0.mnumberOfLines = 0;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mi18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mnumberOfLines = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1508build();
            }

            public int encodedSize(TextProperty r6) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r6.mcontent);
                String r2 = r6.mi18n_key;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = r0.encodedSizeWithTag(2, r2);
            L6:
                int r5 = r1 + r4;
                Integer r7 = r6.mnumberOfLines;
                if (r7 == null) goto L10;
                r3 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
            L10:
                return (r5 + r3) + r6.unknownFields().size();
            L5:
                r4 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1509decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TextProperty) r1);
            }

            public void encode(ProtoWriter r4, TextProperty r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mcontent);
                String r1 = r5.mi18n_key;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 2, r1);
            L5:
                Integer r2 = r5.mnumberOfLines;
                if (r2 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TextProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TextProperty();
            DEFAULT_NUMBEROFLINES = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1507newBuilder() {
            Builder r0 = new Builder();
            r0.mcontent = this.mcontent;
            r0.mi18n_key = this.mi18n_key;
            r0.mnumberOfLines = this.mnumberOfLines;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TextProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1507newBuilder();
        }

        public TextProperty(String r2, String r3, Integer r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public TextProperty(String r2, String r3, Integer r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mcontent = r2;
            this.mi18n_key = r3;
            this.mnumberOfLines = r4;
        }
    }

    public static final class TextableAreaProperty extends com.squareup.wire.Message<TextableAreaProperty, Builder> {
        public static final ProtoAdapter<TextableAreaProperty> ADAPTER = null;
        public static final Integer DEFAULT_NUMBEROFLINES = null;
        private static final long serialVersionUID = 0;
        public final Integer mnumberOfLines;

        public static final class Builder extends com.squareup.wire.Message.Builder<TextableAreaProperty, Builder> {
            public Integer mnumberOfLines;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TextableAreaProperty m1511build() {
                return new TextableAreaProperty(this.mnumberOfLines, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1511build();
            }

            public Builder numberOfLines(Integer r1) {
                this.mnumberOfLines = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TextableAreaProperty extends ProtoAdapter<TextableAreaProperty> {
            public ProtoAdapter_TextableAreaProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TextableAreaProperty.class);
            }

            public TextableAreaProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mnumberOfLines = 0;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mnumberOfLines = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1511build();
            }

            public int encodedSize(TextableAreaProperty r4) {
                Integer r0 = r4.mnumberOfLines;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1512decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TextableAreaProperty) r1);
            }

            public void encode(ProtoWriter r4, TextableAreaProperty r5) throws IOException {
                Integer r0 = r5.mnumberOfLines;
                if (r0 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TextableAreaProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TextableAreaProperty();
            DEFAULT_NUMBEROFLINES = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1510newBuilder() {
            Builder r0 = new Builder();
            r0.mnumberOfLines = this.mnumberOfLines;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TextableAreaProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1510newBuilder();
        }

        public TextableAreaProperty(Integer r2) {
            this(r2, ByteString.EMPTY);
        }

        public TextableAreaProperty(Integer r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mnumberOfLines = r2;
        }
    }

    public static final class TimePickerProperty extends com.squareup.wire.Message<TimePickerProperty, Builder> {
        public static final ProtoAdapter<TimePickerProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_INITIAL_TIME = "";
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ButtonConfirmProperty mconfirm;
        public final String minitial_time;
        public final String mplace_holder;
        public final String mplace_holder_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimePickerProperty, Builder> {
            public String maction_id;
            public ButtonConfirmProperty mconfirm;
            public String minitial_time;
            public String mplace_holder;
            public String mplace_holder_i18n_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TimePickerProperty m1514build() {
                return new TimePickerProperty(this.maction_id, this.mplace_holder, this.mplace_holder_i18n_key, this.minitial_time, this.mconfirm, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1514build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r1) {
                this.mconfirm = r1;
                return this;
            }

            public Builder initial_time(String r1) {
                this.minitial_time = r1;
                return this;
            }

            public Builder place_holder(String r1) {
                this.mplace_holder = r1;
                return this;
            }

            public Builder place_holder_i18n_key(String r1) {
                this.mplace_holder_i18n_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TimePickerProperty extends ProtoAdapter<TimePickerProperty> {
            public ProtoAdapter_TimePickerProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TimePickerProperty.class);
            }

            public TimePickerProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                r0.mplace_holder = "";
                r0.mplace_holder_i18n_key = "";
                r0.minitial_time = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mplace_holder = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mplace_holder_i18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.minitial_time = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mconfirm = (ButtonConfirmProperty) ButtonConfirmProperty.ADAPTER.decode(r7);
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m1514build();
            }

            public int encodedSize(TimePickerProperty r6) {
                String r0 = r6.maction_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mplace_holder;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mplace_holder_i18n_key;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.minitial_time;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                ButtonConfirmProperty r13 = r6.mconfirm;
                if (r13 == null) goto L22;
                r1 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                return (r12 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1515decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TimePickerProperty) r1);
            }

            public void encode(ProtoWriter r4, TimePickerProperty r5) throws IOException {
                String r0 = r5.maction_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mplace_holder;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mplace_holder_i18n_key;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.minitial_time;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                ButtonConfirmProperty r6 = r5.mconfirm;
                if (r6 == null) goto L17;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TimePickerProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimePickerProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1513newBuilder() {
            Builder r0 = new Builder();
            r0.maction_id = this.maction_id;
            r0.mplace_holder = this.mplace_holder;
            r0.mplace_holder_i18n_key = this.mplace_holder_i18n_key;
            r0.minitial_time = this.minitial_time;
            r0.mconfirm = this.mconfirm;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TimePickerProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1513newBuilder();
        }

        public TimePickerProperty(String r8, String r9, String r10, String r11, ButtonConfirmProperty r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public TimePickerProperty(String r2, String r3, String r4, String r5, ButtonConfirmProperty r6, ByteString r7) {
            super(ADAPTER, r7);
            this.maction_id = r2;
            this.mplace_holder = r3;
            this.mplace_holder_i18n_key = r4;
            this.minitial_time = r5;
            this.mconfirm = r6;
        }
    }

    public static final class TimeProperty extends com.squareup.wire.Message<TimeProperty, Builder> {
        public static final ProtoAdapter<TimeProperty> ADAPTER = null;
        public static final String DEFAULT_FORMAT = "YYYY.MM.DD(dddd) HH:mm (GMT)";
        public static final String DEFAULT_FORMAT_TYPE = "";
        public static final String DEFAULT_LINK = "";
        public static final Long DEFAULT_MILLISECOND_SINCE1970 = null;
        private static final long serialVersionUID = 0;
        public final String mformat;
        public final String mformat_type;
        public final String mlink;
        public final Long mmillisecond_since1970;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimeProperty, Builder> {
            public String mformat;
            public String mformat_type;
            public String mlink;
            public Long mmillisecond_since1970;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TimeProperty m1517build() {
                Long r0 = this.mmillisecond_since1970;
                if (r0 == null) goto L7;
                return new TimeProperty(this.mmillisecond_since1970, this.mformat, this.mlink, this.mformat_type, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mmillisecond_since1970"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1517build();
            }

            public Builder format(String r1) {
                this.mformat = r1;
                return this;
            }

            public Builder format_type(String r1) {
                this.mformat_type = r1;
                return this;
            }

            public Builder link(String r1) {
                this.mlink = r1;
                return this;
            }

            public Builder millisecond_since1970(Long r1) {
                this.mmillisecond_since1970 = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TimeProperty extends ProtoAdapter<TimeProperty> {
            public ProtoAdapter_TimeProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeProperty.class);
            }

            public TimeProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mmillisecond_since1970 = 0L;
                r0.mformat = TimeProperty.DEFAULT_FORMAT;
                r0.mlink = "";
                r0.mformat_type = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mmillisecond_since1970 = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mformat = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mlink = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mformat_type = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m1517build();
            }

            public int encodedSize(TimeProperty r6) {
                int r0 = ProtoAdapter.INT64.encodedSizeWithTag(1, r6.mmillisecond_since1970);
                String r1 = r6.mformat;
                int r2 = 0;
                if (r1 == null) goto L5;
                int r3 = ProtoAdapter.STRING.encodedSizeWithTag(2, r1);
            L6:
                int r4 = r0 + r3;
                String r5 = r6.mlink;
                if (r5 == null) goto L9;
                int r7 = ProtoAdapter.STRING.encodedSizeWithTag(3, r5);
            L10:
                int r8 = r4 + r7;
                String r9 = r6.mformat_type;
                if (r9 == null) goto L14;
                r2 = ProtoAdapter.STRING.encodedSizeWithTag(4, r9);
            L14:
                return (r8 + r2) + r6.unknownFields().size();
            L9:
                r7 = 0;
                goto L10
            L5:
                r3 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1518decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TimeProperty) r1);
            }

            public void encode(ProtoWriter r4, TimeProperty r5) throws IOException {
                ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.mmillisecond_since1970);
                String r0 = r5.mformat;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r0);
            L5:
                String r1 = r5.mlink;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r1);
            L8:
                String r2 = r5.mformat_type;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TimeProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeProperty();
            DEFAULT_MILLISECOND_SINCE1970 = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1516newBuilder() {
            Builder r0 = new Builder();
            r0.mmillisecond_since1970 = this.mmillisecond_since1970;
            r0.mformat = this.mformat;
            r0.mlink = this.mlink;
            r0.mformat_type = this.mformat_type;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TimeProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1516newBuilder();
        }

        public TimeProperty(Long r7, String r8, String r9, String r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public TimeProperty(Long r2, String r3, String r4, String r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mmillisecond_since1970 = r2;
            this.mformat = r3;
            this.mlink = r4;
            this.mformat_type = r5;
        }
    }

    public static final class ULProperty extends com.squareup.wire.Message<ULProperty, Builder> {
        public static final ProtoAdapter<ULProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Type mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<ULProperty, Builder> {
            public Type mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ULProperty m1520build() {
                return new ULProperty(this.mtype, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1520build();
            }

            public Builder type(Type r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ULProperty extends ProtoAdapter<ULProperty> {
            public ProtoAdapter_ULProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ULProperty.class);
            }

            public ULProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L12:
                r9.endMessage(r1);
                return r0.m1520build();
            }

            public int encodedSize(ULProperty r4) {
                Type r0 = r4.mtype;
                if (r0 == null) goto L5;
                int r1 = Type.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1521decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ULProperty) r1);
            }

            public void encode(ProtoWriter r4, ULProperty r5) throws IOException {
                Type r0 = r5.mtype;
                if (r0 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ULProperty) r2);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type CIRCLE = null;
            public static final Type DISC = null;
            public static final Type NONE = null;
            public static final Type SQUARE = null;
            private final int value;

            static {
                Type r0 = new Type("DISC", 0, 0);
                DISC = r0;
                Type r1 = new Type("CIRCLE", 1, 1);
                CIRCLE = r1;
                Type r3 = new Type("SQUARE", 2, 2);
                SQUARE = r3;
                Type r5 = new Type("NONE", 3, 3);
                NONE = r5;
                $VALUES = new Type[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return NONE;
            L14:
                return SQUARE;
            L16:
                return CIRCLE;
            L18:
                return DISC;
            }

            public static Type valueOf(String r1) {
                return (Type) a.a(Type.class, r1);
            }

            private Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ULProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1519newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ULProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1519newBuilder();
        }

        public ULProperty(Type r2) {
            this(r2, ByteString.EMPTY);
        }

        public ULProperty(Type r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mtype = r2;
        }
    }

    public static final class UnderlineProperty extends com.squareup.wire.Message<UnderlineProperty, Builder> {
        public static final ProtoAdapter<UnderlineProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mi18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<UnderlineProperty, Builder> {
            public String mcontent;
            public String mi18n_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public UnderlineProperty m1523build() {
                String r0 = this.mcontent;
                if (r0 == null) goto L7;
                return new UnderlineProperty(this.mcontent, this.mi18n_key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mcontent"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1523build();
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder i18n_key(String r1) {
                this.mi18n_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_UnderlineProperty extends ProtoAdapter<UnderlineProperty> {
            public ProtoAdapter_UnderlineProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, UnderlineProperty.class);
            }

            public UnderlineProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcontent = "";
                r0.mi18n_key = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mi18n_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1523build();
            }

            public int encodedSize(UnderlineProperty r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r5.mcontent);
                String r2 = r5.mi18n_key;
                if (r2 == null) goto L5;
                int r3 = r0.encodedSizeWithTag(2, r2);
            L7:
                return (r1 + r3) + r5.unknownFields().size();
            L5:
                r3 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1524decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((UnderlineProperty) r1);
            }

            public void encode(ProtoWriter r4, UnderlineProperty r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mcontent);
                String r1 = r5.mi18n_key;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 2, r1);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (UnderlineProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UnderlineProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1522newBuilder() {
            Builder r0 = new Builder();
            r0.mcontent = this.mcontent;
            r0.mi18n_key = this.mi18n_key;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return UnderlineProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1522newBuilder();
        }

        public UnderlineProperty(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public UnderlineProperty(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mcontent = r2;
            this.mi18n_key = r3;
        }
    }

    public static final enum VerticalAlign extends Enum<VerticalAlign> implements WireEnum {
        private static final /* synthetic */ VerticalAlign[] $VALUES = null;
        public static final ProtoAdapter<VerticalAlign> ADAPTER = null;
        public static final VerticalAlign VERTICAL_ALIGN_BOTTOM = null;
        public static final VerticalAlign VERTICAL_ALIGN_CENTER = null;
        public static final VerticalAlign VERTICAL_ALIGN_TOP = null;
        public static final VerticalAlign VERTICAL_ALIGN_UNKNOWN = null;
        private final int value;

        static {
            VerticalAlign r0 = new VerticalAlign("VERTICAL_ALIGN_UNKNOWN", 0, 0);
            VERTICAL_ALIGN_UNKNOWN = r0;
            VerticalAlign r1 = new VerticalAlign("VERTICAL_ALIGN_TOP", 1, 1);
            VERTICAL_ALIGN_TOP = r1;
            VerticalAlign r3 = new VerticalAlign("VERTICAL_ALIGN_CENTER", 2, 2);
            VERTICAL_ALIGN_CENTER = r3;
            VerticalAlign r5 = new VerticalAlign("VERTICAL_ALIGN_BOTTOM", 3, 3);
            VERTICAL_ALIGN_BOTTOM = r5;
            $VALUES = new VerticalAlign[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(VerticalAlign.class);
        }

        public static VerticalAlign[] values() {
            return (VerticalAlign[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static VerticalAlign fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return VERTICAL_ALIGN_BOTTOM;
        L14:
            return VERTICAL_ALIGN_CENTER;
        L16:
            return VERTICAL_ALIGN_TOP;
        L18:
            return VERTICAL_ALIGN_UNKNOWN;
        }

        public static VerticalAlign valueOf(String r1) {
            return (VerticalAlign) a.a(VerticalAlign.class, r1);
        }

        private VerticalAlign(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RichTextElement();
        ByteString r0 = ByteString.EMPTY;
        DEFAULT_PROPERTY = r0;
        DEFAULT_UPGRADE_ELEMENT = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1351newBuilder() {
        Builder r0 = new Builder();
        r0.mtag = this.mtag;
        r0.mstyle = Internal.copyOf("mstyle", this.mstyle);
        r0.mproperty = this.mproperty;
        r0.mchild_ids = Internal.copyOf("mchild_ids", this.mchild_ids);
        r0.mstyle_keys = Internal.copyOf("mstyle_keys", this.mstyle_keys);
        r0.mupgrade_element = this.mupgrade_element;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return RichTextElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1351newBuilder();
    }

    public RichTextElement(Tag r9, Map<String, String> r10, ByteString r11, List<String> r12, List<String> r13, ByteString r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public RichTextElement(Tag r2, Map<String, String> r3, ByteString r4, List<String> r5, List<String> r6, ByteString r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mtag = r2;
        this.mstyle = Internal.immutableCopyOf("mstyle", r3);
        this.mproperty = r4;
        this.mchild_ids = Internal.immutableCopyOf("mchild_ids", r5);
        this.mstyle_keys = Internal.immutableCopyOf("mstyle_keys", r6);
        this.mupgrade_element = r7;
    }
}
