package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatTheme extends com.squareup.wire.Message<ChatTheme, Builder> {
    public static final ProtoAdapter<ChatTheme> ADAPTER = null;
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final ChatBackgroundEntity mbackground_entity;
    public final Scene mcomponent_scene;
    public final Map<String, String> mi18n_name;
    public final Long mid;
    public final String mname;
    public final ThemeType mtheme_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatTheme, Builder> {
        public ChatBackgroundEntity mbackground_entity;
        public Scene mcomponent_scene;
        public Map<String, String> mi18n_name;
        public Long mid;
        public String mname;
        public ThemeType mtheme_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatTheme m1163build() {
            return new ChatTheme(this.mcomponent_scene, this.mid, this.mbackground_entity, this.mname, this.mi18n_name, this.mtheme_type, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_name = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1163build();
        }

        public Builder background_entity(ChatBackgroundEntity r1) {
            this.mbackground_entity = r1;
            return this;
        }

        public Builder component_scene(Scene r1) {
            this.mcomponent_scene = r1;
            return this;
        }

        public Builder i18n_name(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_name = r1;
            return this;
        }

        public Builder id(Long r1) {
            this.mid = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder theme_type(ThemeType r1) {
            this.mtheme_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatTheme extends ProtoAdapter<ChatTheme> {
        private final ProtoAdapter<Map<String, String>> mi18n_name;

        public ProtoAdapter_ChatTheme() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatTheme.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_name = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public ChatTheme decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = 0L;
            r0.mname = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L21;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L23;
                default: goto L6;
            };
        L21:
            r0.mcomponent_scene = (Scene) Scene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r0.mtheme_type = (ThemeType) ThemeType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r0.mi18n_name.putAll((Map) this.mi18n_name.decode(r9));
            goto L3
        L12:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mbackground_entity = (ChatBackgroundEntity) ChatBackgroundEntity.ADAPTER.decode(r9);
            goto L3
        L14:
            r0.mid = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L19:
            r9.endMessage(r1);
            return r0.m1163build();
        }

        public int encodedSize(ChatTheme r6) {
            Scene r0 = r6.mcomponent_scene;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Scene.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mid;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ChatBackgroundEntity r7 = r6.mbackground_entity;
            if (r7 == null) goto L13;
            int r8 = ChatBackgroundEntity.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mname;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = (r9 + r11) + this.mi18n_name.encodedSizeWithTag(5, r6.mi18n_name);
            ThemeType r13 = r6.mtheme_type;
            if (r13 == null) goto L22;
            r1 = ThemeType.ADAPTER.encodedSizeWithTag(6, r13);
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
        public /* bridge */ /* synthetic */ Object m1164decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatTheme) r1);
        }

        public void encode(ProtoWriter r4, ChatTheme r5) throws IOException {
            Scene r0 = r5.mcomponent_scene;
            if (r0 == null) goto L5;
            Scene.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mid;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            ChatBackgroundEntity r2 = r5.mbackground_entity;
            if (r2 == null) goto L11;
            ChatBackgroundEntity.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mname;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            this.mi18n_name.encodeWithTag(r4, 5, r5.mi18n_name);
            ThemeType r6 = r5.mtheme_type;
            if (r6 == null) goto L17;
            ThemeType.ADAPTER.encodeWithTag(r4, 6, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatTheme) r2);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene BRIGHT = null;
        public static final Scene DARK = null;
        public static final Scene DEFAULT_SCENE = null;
        private final int value;

        static {
            Scene r0 = new Scene("DEFAULT_SCENE", 0, 0);
            DEFAULT_SCENE = r0;
            Scene r1 = new Scene("DARK", 1, 1);
            DARK = r1;
            Scene r3 = new Scene("BRIGHT", 2, 2);
            BRIGHT = r3;
            $VALUES = new Scene[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return BRIGHT;
        L12:
            return DARK;
        L14:
            return DEFAULT_SCENE;
        }

        public static Scene valueOf(String r1) {
            return (Scene) a.a(Scene.class, r1);
        }

        private Scene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ThemeType extends Enum<ThemeType> implements WireEnum {
        private static final /* synthetic */ ThemeType[] $VALUES = null;
        public static final ProtoAdapter<ThemeType> ADAPTER = null;
        public static final ThemeType CUSTOMIZE_THEME = null;
        public static final ThemeType SYSTEM_THEME = null;
        public static final ThemeType UNKNOWN_TYPE = null;
        private final int value;

        static {
            ThemeType r0 = new ThemeType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            ThemeType r1 = new ThemeType("SYSTEM_THEME", 1, 1);
            SYSTEM_THEME = r1;
            ThemeType r3 = new ThemeType("CUSTOMIZE_THEME", 2, 2);
            CUSTOMIZE_THEME = r3;
            $VALUES = new ThemeType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ThemeType.class);
        }

        public static ThemeType[] values() {
            return (ThemeType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ThemeType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return CUSTOMIZE_THEME;
        L12:
            return SYSTEM_THEME;
        L14:
            return UNKNOWN_TYPE;
        }

        public static ThemeType valueOf(String r1) {
            return (ThemeType) a.a(ThemeType.class, r1);
        }

        private ThemeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatTheme();
        DEFAULT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1162newBuilder() {
        Builder r0 = new Builder();
        r0.mcomponent_scene = this.mcomponent_scene;
        r0.mid = this.mid;
        r0.mbackground_entity = this.mbackground_entity;
        r0.mname = this.mname;
        r0.mi18n_name = Internal.copyOf("mi18n_name", this.mi18n_name);
        r0.mtheme_type = this.mtheme_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatTheme.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1162newBuilder();
    }

    public ChatTheme(Scene r9, Long r10, ChatBackgroundEntity r11, String r12, Map<String, String> r13, ThemeType r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public ChatTheme(Scene r2, Long r3, ChatBackgroundEntity r4, String r5, Map<String, String> r6, ThemeType r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mcomponent_scene = r2;
        this.mid = r3;
        this.mbackground_entity = r4;
        this.mname = r5;
        this.mi18n_name = Internal.immutableCopyOf("mi18n_name", r6);
        this.mtheme_type = r7;
    }
}
