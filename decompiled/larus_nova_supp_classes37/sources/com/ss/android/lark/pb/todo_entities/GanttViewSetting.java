package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GanttViewSetting extends Message<GanttViewSetting, Builder> {
    public static final ProtoAdapter<GanttViewSetting> ADAPTER = null;
    public static final Boolean DEFAULT_IS_HIDDEN_WEEKEND = null;
    public static final Boolean DEFAULT_IS_HIGHLIGHT_OVERDUE_TASK = null;
    public static final Boolean DEFAULT_IS_SHOW_CRITICAL_PATH = null;
    public static final Boolean DEFAULT_IS_TIMELINE_MODE = null;
    private static final long serialVersionUID = 0;
    public final ColorSetting mcolor_setting;
    public final Boolean mis_hidden_weekend;
    public final Boolean mis_highlight_overdue_task;
    public final Boolean mis_show_critical_path;
    public final Boolean mis_timeline_mode;
    public final MoveType mmove_type;
    public final ZoomLevel mzoom_level;

    public static final class Builder extends Message.Builder<GanttViewSetting, Builder> {
        public ColorSetting mcolor_setting;
        public Boolean mis_hidden_weekend;
        public Boolean mis_highlight_overdue_task;
        public Boolean mis_show_critical_path;
        public Boolean mis_timeline_mode;
        public MoveType mmove_type;
        public ZoomLevel mzoom_level;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GanttViewSetting m2294build() {
            return new GanttViewSetting(this.mis_hidden_weekend, this.mis_show_critical_path, this.mis_highlight_overdue_task, this.mcolor_setting, this.mmove_type, this.mzoom_level, this.mis_timeline_mode, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2294build();
        }

        public Builder color_setting(ColorSetting r1) {
            this.mcolor_setting = r1;
            return this;
        }

        public Builder is_hidden_weekend(Boolean r1) {
            this.mis_hidden_weekend = r1;
            return this;
        }

        public Builder is_highlight_overdue_task(Boolean r1) {
            this.mis_highlight_overdue_task = r1;
            return this;
        }

        public Builder is_show_critical_path(Boolean r1) {
            this.mis_show_critical_path = r1;
            return this;
        }

        public Builder is_timeline_mode(Boolean r1) {
            this.mis_timeline_mode = r1;
            return this;
        }

        public Builder move_type(MoveType r1) {
            this.mmove_type = r1;
            return this;
        }

        public Builder zoom_level(ZoomLevel r1) {
            this.mzoom_level = r1;
            return this;
        }
    }

    public static final class ColorSetting extends Message<ColorSetting, Builder> {
        public static final ProtoAdapter<ColorSetting> ADAPTER = null;
        public static final Integer DEFAULT_CUSTOM_COLOR_INDEX = null;
        public static final String DEFAULT_FOLLOW_COLOR_OF_FIELD_KEY = "";
        private static final long serialVersionUID = 0;
        public final Integer mcustom_color_index;
        public final String mfollow_color_of_field_key;
        public final Type mtype;

        public static final class Builder extends Message.Builder<ColorSetting, Builder> {
            public Integer mcustom_color_index;
            public String mfollow_color_of_field_key;
            public Type mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ColorSetting m2296build() {
                return new ColorSetting(this.mtype, this.mcustom_color_index, this.mfollow_color_of_field_key, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2296build();
            }

            public Builder custom_color_index(Integer r1) {
                this.mcustom_color_index = r1;
                this.mfollow_color_of_field_key = null;
                return this;
            }

            public Builder follow_color_of_field_key(String r1) {
                this.mfollow_color_of_field_key = r1;
                this.mcustom_color_index = null;
                return this;
            }

            public Builder type(Type r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ColorSetting extends ProtoAdapter<ColorSetting> {
            public ProtoAdapter_ColorSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ColorSetting.class);
            }

            public ColorSetting decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.custom_color_index(0);
                r0.follow_color_of_field_key("");
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 101) goto L10;
                r0.custom_color_index((Integer) ProtoAdapter.INT32.decode(r9));
                goto L3
            L10:
                if (r3 != 102) goto L11;
                r0.follow_color_of_field_key((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m2296build();
            }

            public int encodedSize(ColorSetting r6) {
                Type r0 = r6.mtype;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Type.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r6.mcustom_color_index;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.INT32.encodedSizeWithTag(BaseField.FIELD_TYPE_S_PHONE_NUMBER, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mfollow_color_of_field_key;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(BaseField.FIELD_TYPE_S_FRIEND_LINK, r7);
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
            public /* bridge */ /* synthetic */ Object m2297decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ColorSetting) r1);
            }

            public void encode(ProtoWriter r4, ColorSetting r5) throws IOException {
                Type r0 = r5.mtype;
                if (r0 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mcustom_color_index;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, BaseField.FIELD_TYPE_S_PHONE_NUMBER, r1);
            L8:
                String r2 = r5.mfollow_color_of_field_key;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, BaseField.FIELD_TYPE_S_FRIEND_LINK, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ColorSetting) r2);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type CUSTOM = null;
            public static final Type FOLLOW_FIELD = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r0 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Type r1 = new Type("CUSTOM", 1, 1);
                CUSTOM = r1;
                Type r3 = new Type("FOLLOW_FIELD", 2, 2);
                FOLLOW_FIELD = r3;
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
                return FOLLOW_FIELD;
            L12:
                return CUSTOM;
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
            ADAPTER = new ProtoAdapter_ColorSetting();
            DEFAULT_CUSTOM_COLOR_INDEX = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2295newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.mcustom_color_index = this.mcustom_color_index;
            r0.mfollow_color_of_field_key = this.mfollow_color_of_field_key;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ColorSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2295newBuilder();
        }

        public ColorSetting(Type r2, Integer r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public ColorSetting(Type r2, Integer r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            if (Internal.countNonNull(r3, r4) > 1) goto L7;
            this.mtype = r2;
            this.mcustom_color_index = r3;
            this.mfollow_color_of_field_key = r4;
            return;
        L7:
            throw new IllegalArgumentException("at most one of mcustom_color_index, mfollow_color_of_field_key may be non-null");
        }
    }

    public static final class ProtoAdapter_GanttViewSetting extends ProtoAdapter<GanttViewSetting> {
        public ProtoAdapter_GanttViewSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, GanttViewSetting.class);
        }

        public GanttViewSetting decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.mis_hidden_weekend = r1;
            r0.mis_show_critical_path = r1;
            r0.mis_highlight_overdue_task = r1;
            r0.mis_timeline_mode = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L22;
                case 6: goto L24;
                case 7: goto L7;
                default: goto L6;
            };
        L22:
            r0.mmove_type = (MoveType) MoveType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L24:
            r0.mzoom_level = (ZoomLevel) ZoomLevel.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mis_timeline_mode = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L16:
            r0.mcolor_setting = (ColorSetting) ColorSetting.ADAPTER.decode(r9);
            goto L3
        L17:
            r0.mis_highlight_overdue_task = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L18:
            r0.mis_show_critical_path = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L19:
            r0.mis_hidden_weekend = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L20:
            r9.endMessage(r2);
            return r0.m2294build();
        }

        public int encodedSize(GanttViewSetting r6) {
            Boolean r0 = r6.mis_hidden_weekend;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.mis_show_critical_path;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mis_highlight_overdue_task;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            ColorSetting r10 = r6.mcolor_setting;
            if (r10 == null) goto L17;
            int r11 = ColorSetting.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            MoveType r13 = r6.mmove_type;
            if (r13 == null) goto L21;
            int r14 = MoveType.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            ZoomLevel r16 = r6.mzoom_level;
            if (r16 == null) goto L25;
            int r17 = ZoomLevel.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Boolean r19 = r6.mis_timeline_mode;
            if (r19 == null) goto L30;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r19);
        L30:
            return (r18 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2298decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GanttViewSetting) r1);
        }

        public void encode(ProtoWriter r4, GanttViewSetting r5) throws IOException {
            Boolean r0 = r5.mis_hidden_weekend;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mis_show_critical_path;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mis_highlight_overdue_task;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            ColorSetting r3 = r5.mcolor_setting;
            if (r3 == null) goto L14;
            ColorSetting.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            MoveType r6 = r5.mmove_type;
            if (r6 == null) goto L17;
            MoveType.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            ZoomLevel r7 = r5.mzoom_level;
            if (r7 == null) goto L20;
            ZoomLevel.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            Boolean r8 = r5.mis_timeline_mode;
            if (r8 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GanttViewSetting) r2);
        }
    }

    public static final enum ZoomLevel extends Enum<ZoomLevel> implements WireEnum {
        private static final /* synthetic */ ZoomLevel[] $VALUES = null;
        public static final ProtoAdapter<ZoomLevel> ADAPTER = null;
        public static final ZoomLevel MONTH = null;
        public static final ZoomLevel UNKNOWN = null;
        public static final ZoomLevel WEEK = null;
        public static final ZoomLevel YEAR = null;
        private final int value;

        static {
            ZoomLevel r0 = new ZoomLevel("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ZoomLevel r1 = new ZoomLevel("WEEK", 1, 1);
            WEEK = r1;
            ZoomLevel r3 = new ZoomLevel("MONTH", 2, 2);
            MONTH = r3;
            ZoomLevel r5 = new ZoomLevel("YEAR", 3, 3);
            YEAR = r5;
            $VALUES = new ZoomLevel[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(ZoomLevel.class);
        }

        public static ZoomLevel[] values() {
            return (ZoomLevel[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ZoomLevel fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return YEAR;
        L14:
            return MONTH;
        L16:
            return WEEK;
        L18:
            return UNKNOWN;
        }

        public static ZoomLevel valueOf(String r1) {
            return (ZoomLevel) a.a(ZoomLevel.class, r1);
        }

        private ZoomLevel(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GanttViewSetting();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_HIDDEN_WEEKEND = r0;
        DEFAULT_IS_SHOW_CRITICAL_PATH = r0;
        DEFAULT_IS_HIGHLIGHT_OVERDUE_TASK = r0;
        DEFAULT_IS_TIMELINE_MODE = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2293newBuilder() {
        Builder r0 = new Builder();
        r0.mis_hidden_weekend = this.mis_hidden_weekend;
        r0.mis_show_critical_path = this.mis_show_critical_path;
        r0.mis_highlight_overdue_task = this.mis_highlight_overdue_task;
        r0.mcolor_setting = this.mcolor_setting;
        r0.mmove_type = this.mmove_type;
        r0.mzoom_level = this.mzoom_level;
        r0.mis_timeline_mode = this.mis_timeline_mode;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GanttViewSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2293newBuilder();
    }

    public GanttViewSetting(Boolean r10, Boolean r11, Boolean r12, ColorSetting r13, MoveType r14, ZoomLevel r15, Boolean r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public GanttViewSetting(Boolean r2, Boolean r3, Boolean r4, ColorSetting r5, MoveType r6, ZoomLevel r7, Boolean r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mis_hidden_weekend = r2;
        this.mis_show_critical_path = r3;
        this.mis_highlight_overdue_task = r4;
        this.mcolor_setting = r5;
        this.mmove_type = r6;
        this.mzoom_level = r7;
        this.mis_timeline_mode = r8;
    }
}
