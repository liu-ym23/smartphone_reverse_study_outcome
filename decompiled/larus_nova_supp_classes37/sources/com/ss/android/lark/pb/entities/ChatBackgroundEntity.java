package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatBackgroundEntity extends com.squareup.wire.Message<ChatBackgroundEntity, Builder> {
    public static final ProtoAdapter<ChatBackgroundEntity> ADAPTER = null;
    public static final String DEFAULT_FSUNIT = "";
    public static final String DEFAULT_IMAGE_KEY = "";
    private static final long serialVersionUID = 0;
    public final ColorInfo mcolor;
    public final String mfsunit;
    public final String mimage_key;
    public final BackgroundMode mmode;

    public static final enum BackgroundMode extends Enum<BackgroundMode> implements WireEnum {
        private static final /* synthetic */ BackgroundMode[] $VALUES = null;
        public static final ProtoAdapter<BackgroundMode> ADAPTER = null;
        public static final BackgroundMode COLOR_MODE = null;
        public static final BackgroundMode IMAGE_MODE = null;
        public static final BackgroundMode ORIGIN_MODE = null;
        private final int value;

        static {
            BackgroundMode r0 = new BackgroundMode("ORIGIN_MODE", 0, 0);
            ORIGIN_MODE = r0;
            BackgroundMode r1 = new BackgroundMode("COLOR_MODE", 1, 1);
            COLOR_MODE = r1;
            BackgroundMode r3 = new BackgroundMode("IMAGE_MODE", 2, 2);
            IMAGE_MODE = r3;
            $VALUES = new BackgroundMode[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(BackgroundMode.class);
        }

        public static BackgroundMode[] values() {
            return (BackgroundMode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BackgroundMode fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return IMAGE_MODE;
        L12:
            return COLOR_MODE;
        L14:
            return ORIGIN_MODE;
        }

        public static BackgroundMode valueOf(String r1) {
            return (BackgroundMode) a.a(BackgroundMode.class, r1);
        }

        private BackgroundMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatBackgroundEntity, Builder> {
        public ColorInfo mcolor;
        public String mfsunit;
        public String mimage_key;
        public BackgroundMode mmode;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatBackgroundEntity m1070build() {
            return new ChatBackgroundEntity(this.mmode, this.mcolor, this.mimage_key, this.mfsunit, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1070build();
        }

        public Builder color(ColorInfo r1) {
            this.mcolor = r1;
            return this;
        }

        public Builder fsunit(String r1) {
            this.mfsunit = r1;
            return this;
        }

        public Builder image_key(String r1) {
            this.mimage_key = r1;
            return this;
        }

        public Builder mode(BackgroundMode r1) {
            this.mmode = r1;
            return this;
        }
    }

    public static final class ColorInfo extends com.squareup.wire.Message<ColorInfo, Builder> {
        public static final ProtoAdapter<ColorInfo> ADAPTER = null;
        public static final Integer DEFAULT_DARK_COLOR = null;
        public static final Integer DEFAULT_LIGHT_COLOR = null;
        public static final String DEFAULT_UD_TOKEN = "";
        private static final long serialVersionUID = 0;
        public final Integer mdark_color;
        public final Integer mlight_color;
        public final String mud_token;

        public static final class Builder extends com.squareup.wire.Message.Builder<ColorInfo, Builder> {
            public Integer mdark_color;
            public Integer mlight_color;
            public String mud_token;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ColorInfo m1072build() {
                return new ColorInfo(this.mud_token, this.mlight_color, this.mdark_color, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1072build();
            }

            public Builder dark_color(Integer r1) {
                this.mdark_color = r1;
                return this;
            }

            public Builder light_color(Integer r1) {
                this.mlight_color = r1;
                return this;
            }

            public Builder ud_token(String r1) {
                this.mud_token = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ColorInfo extends ProtoAdapter<ColorInfo> {
            public ProtoAdapter_ColorInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ColorInfo.class);
            }

            public ColorInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mud_token = "";
                r0.mlight_color = 0;
                r0.mdark_color = 0;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mud_token = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mlight_color = (Integer) ProtoAdapter.UINT32.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mdark_color = (Integer) ProtoAdapter.UINT32.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1072build();
            }

            public int encodedSize(ColorInfo r6) {
                String r0 = r6.mud_token;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r6.mlight_color;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.UINT32.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Integer r7 = r6.mdark_color;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.UINT32.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m1073decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ColorInfo) r1);
            }

            public void encode(ProtoWriter r4, ColorInfo r5) throws IOException {
                String r0 = r5.mud_token;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mlight_color;
                if (r1 == null) goto L8;
                ProtoAdapter.UINT32.encodeWithTag(r4, 2, r1);
            L8:
                Integer r2 = r5.mdark_color;
                if (r2 == null) goto L11;
                ProtoAdapter.UINT32.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ColorInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ColorInfo();
            DEFAULT_LIGHT_COLOR = 0;
            DEFAULT_DARK_COLOR = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1071newBuilder() {
            Builder r0 = new Builder();
            r0.mud_token = this.mud_token;
            r0.mlight_color = this.mlight_color;
            r0.mdark_color = this.mdark_color;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ColorInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1071newBuilder();
        }

        public ColorInfo(String r2, Integer r3, Integer r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public ColorInfo(String r2, Integer r3, Integer r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mud_token = r2;
            this.mlight_color = r3;
            this.mdark_color = r4;
        }
    }

    public static final class ProtoAdapter_ChatBackgroundEntity extends ProtoAdapter<ChatBackgroundEntity> {
        public ProtoAdapter_ChatBackgroundEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatBackgroundEntity.class);
        }

        public ChatBackgroundEntity decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mimage_key = "";
            r0.mfsunit = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mmode = (BackgroundMode) BackgroundMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcolor = (ColorInfo) ColorInfo.ADAPTER.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mimage_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mfsunit = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m1070build();
        }

        public int encodedSize(ChatBackgroundEntity r6) {
            BackgroundMode r0 = r6.mmode;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = BackgroundMode.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            ColorInfo r3 = r6.mcolor;
            if (r3 == null) goto L9;
            int r4 = ColorInfo.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mimage_key;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mfsunit;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m1074decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatBackgroundEntity) r1);
        }

        public void encode(ProtoWriter r4, ChatBackgroundEntity r5) throws IOException {
            BackgroundMode r0 = r5.mmode;
            if (r0 == null) goto L5;
            BackgroundMode.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            ColorInfo r1 = r5.mcolor;
            if (r1 == null) goto L8;
            ColorInfo.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mimage_key;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mfsunit;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatBackgroundEntity) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatBackgroundEntity();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1069newBuilder() {
        Builder r0 = new Builder();
        r0.mmode = this.mmode;
        r0.mcolor = this.mcolor;
        r0.mimage_key = this.mimage_key;
        r0.mfsunit = this.mfsunit;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatBackgroundEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1069newBuilder();
    }

    public ChatBackgroundEntity(BackgroundMode r7, ColorInfo r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public ChatBackgroundEntity(BackgroundMode r2, ColorInfo r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mmode = r2;
        this.mcolor = r3;
        this.mimage_key = r4;
        this.mfsunit = r5;
    }
}
