package com.ss.android.lark.chat.entity.wallpaper;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002()B5\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0019\u001a\u00020\bH\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0000H\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006*"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "backgroundMode", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$BackgroundMode;", "colorInfo", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;", "imageKey", BuildConfig.FLAVOR, "fsUnit", "<init>", "(Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$BackgroundMode;Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundMode", "()Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$BackgroundMode;", "setBackgroundMode", "(Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$BackgroundMode;)V", "getColorInfo", "()Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;", "setColorInfo", "(Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;)V", "getImageKey", "()Ljava/lang/String;", "setImageKey", "(Ljava/lang/String;)V", "getFsUnit", "toString", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "BackgroundMode", "ColorInfo", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatBackgroundEntity implements Serializable, b<ChatBackgroundEntity> {
    private BackgroundMode backgroundMode;
    private ColorInfo colorInfo;
    private final String fsUnit;
    private String imageKey;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$BackgroundMode;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "ORIGIN_MODE", "COLOR_MODE", "IMAGE_MODE", "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BackgroundMode extends Enum<BackgroundMode> {
        public static final BackgroundMode COLOR_MODE = null;
        public static final a Companion = null;
        public static final BackgroundMode IMAGE_MODE = null;
        public static final BackgroundMode ORIGIN_MODE = null;
        public static final /* synthetic */ BackgroundMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int number;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static BackgroundMode a(int r1) {
                if (r1 == 0) goto L11;
                if (r1 == 1) goto L14;
                if (r1 == 2) goto L13;
                return BackgroundMode.ORIGIN_MODE;
            L13:
                return BackgroundMode.IMAGE_MODE;
            L14:
                return BackgroundMode.COLOR_MODE;
            L11:
                return BackgroundMode.ORIGIN_MODE;
            }
        }

        @JvmStatic
        public static final BackgroundMode fromValue(int r1) {
            Companion.getClass();
            return a.a(r1);
        }

        public static EnumEntries<BackgroundMode> getEntries() {
            return b;
        }

        static {
            BackgroundMode r0 = new BackgroundMode("ORIGIN_MODE", 0, 0);
            ORIGIN_MODE = r0;
            BackgroundMode r1 = new BackgroundMode("COLOR_MODE", 1, 1);
            COLOR_MODE = r1;
            BackgroundMode r3 = new BackgroundMode("IMAGE_MODE", 2, 2);
            IMAGE_MODE = r3;
            BackgroundMode[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static BackgroundMode[] values() {
            return (BackgroundMode[]) a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return name();
        }

        public final int getNumber() {
            return this.number;
        }

        @JvmStatic
        public static final BackgroundMode valueOf(int r1) {
            Companion.getClass();
            return a.a(r1);
        }

        public static BackgroundMode valueOf(String r1) {
            return (BackgroundMode) r27.a.a(BackgroundMode.class, r1);
        }

        public BackgroundMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.number = r3;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ2\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "udToken", BuildConfig.FLAVOR, "lightColor", BuildConfig.FLAVOR, "darkColor", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getUdToken", "()Ljava/lang/String;", "setUdToken", "(Ljava/lang/String;)V", "getLightColor", "()Ljava/lang/Integer;", "setLightColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDarkColor", "setDarkColor", "toString", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ColorInfo implements Serializable, b<ColorInfo> {
        private Integer darkColor;
        private Integer lightColor;
        private String udToken;

        public static /* synthetic */ ColorInfo copy$default(ColorInfo r0, String r1, Integer r2, Integer r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.udToken;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.lightColor;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.darkColor;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.udToken;
        }

        public final Integer component2() {
            return this.lightColor;
        }

        public final Integer component3() {
            return this.darkColor;
        }

        public final ColorInfo copy(String r2, Integer r3, Integer r4) {
            return new ColorInfo(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ColorInfo) == true) goto L8;
            return false;
        L8:
            ColorInfo r6 = (ColorInfo) r5;
            if (Intrinsics.areEqual(this.udToken, r6.udToken) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.lightColor, r6.lightColor) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.darkColor, r6.darkColor) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.udToken;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.lightColor;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.darkColor;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ColorInfo(udToken=" + this.udToken + ", lightColor=" + this.lightColor + ", darkColor=" + this.darkColor + ')';
        }

        public final Integer getDarkColor() {
            return this.darkColor;
        }

        public final Integer getLightColor() {
            return this.lightColor;
        }

        public final String getUdToken() {
            return this.udToken;
        }

        public boolean isContentSame(ColorInfo r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<ColorInfo> r2 = ColorInfo.class;
        L10:
            if (Intrinsics.areEqual(ColorInfo.class, r2) == true) goto L13;
            return false;
        L13:
            if (Intrinsics.areEqual(this.udToken, r5.udToken) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.lightColor, r5.lightColor) == true) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(this.darkColor, r5.darkColor) == true) goto L21;
            return false;
        L21:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
            return isItemSame((ColorInfo) r1);
        }

        public final void setDarkColor(Integer r1) {
            this.darkColor = r1;
        }

        public final void setLightColor(Integer r1) {
            this.lightColor = r1;
        }

        public final void setUdToken(String r1) {
            this.udToken = r1;
        }

        public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
            return isContentSame((ColorInfo) r1);
        }

        public boolean isItemSame(ColorInfo r1) {
            return isContentSame(r1);
        }

        public ColorInfo(String r1, Integer r2, Integer r3) {
            this.udToken = r1;
            this.lightColor = r2;
            this.darkColor = r3;
        }
    }

    public static /* synthetic */ ChatBackgroundEntity copy$default(ChatBackgroundEntity r0, BackgroundMode r1, ColorInfo r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.backgroundMode;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.colorInfo;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.imageKey;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.fsUnit;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final BackgroundMode component1() {
        return this.backgroundMode;
    }

    public final ColorInfo component2() {
        return this.colorInfo;
    }

    public final String component3() {
        return this.imageKey;
    }

    public final String component4() {
        return this.fsUnit;
    }

    public final ChatBackgroundEntity copy(BackgroundMode r2, ColorInfo r3, String r4, String r5) {
        return new ChatBackgroundEntity(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatBackgroundEntity) == true) goto L8;
        return false;
    L8:
        ChatBackgroundEntity r6 = (ChatBackgroundEntity) r5;
        if (this.backgroundMode == r6.backgroundMode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.colorInfo, r6.colorInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageKey, r6.imageKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fsUnit, r6.fsUnit) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        BackgroundMode r0 = this.backgroundMode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ColorInfo r4 = this.colorInfo;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.imageKey;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.fsUnit;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ChatBackgroundEntity(backgroundMode=" + this.backgroundMode + ", colorInfo=" + this.colorInfo + ", imageKey=" + this.imageKey + ", fsUnit=" + this.fsUnit + ')';
    }

    public final BackgroundMode getBackgroundMode() {
        return this.backgroundMode;
    }

    public final ColorInfo getColorInfo() {
        return this.colorInfo;
    }

    public final String getFsUnit() {
        return this.fsUnit;
    }

    public final String getImageKey() {
        return this.imageKey;
    }

    public boolean isContentSame(ChatBackgroundEntity r5) {
        if (Intrinsics.areEqual(this, r5) == false) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<ChatBackgroundEntity> r2 = ChatBackgroundEntity.class;
    L10:
        if (Intrinsics.areEqual(ChatBackgroundEntity.class, r2) == true) goto L13;
        return false;
    L13:
        if (this.backgroundMode == r5.backgroundMode) goto L15;
        return false;
    L15:
        ColorInfo r0 = this.colorInfo;
        if (r0 != null) goto L18;
    L20:
        boolean r1 = false;
    L21:
        if (r1 == false) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.imageKey, r5.imageKey) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fsUnit, r5.fsUnit) == true) goto L29;
        return false;
    L29:
        return true;
    L18:
        if (r0.isContentSame(r5.colorInfo) == true) goto L20;
        r1 = true;
        goto L21
    L8:
        r2 = null;
        goto L10
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((ChatBackgroundEntity) r1);
    }

    public final void setBackgroundMode(BackgroundMode r1) {
        this.backgroundMode = r1;
    }

    public final void setColorInfo(ColorInfo r1) {
        this.colorInfo = r1;
    }

    public final void setImageKey(String r1) {
        this.imageKey = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((ChatBackgroundEntity) r1);
    }

    public boolean isItemSame(ChatBackgroundEntity r1) {
        return isContentSame(r1);
    }

    public ChatBackgroundEntity(BackgroundMode r1, ColorInfo r2, String r3, String r4) {
        this.backgroundMode = r1;
        this.colorInfo = r2;
        this.imageKey = r3;
        this.fsUnit = r4;
    }

    public /* synthetic */ ChatBackgroundEntity(BackgroundMode r2, ColorInfo r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }
}
