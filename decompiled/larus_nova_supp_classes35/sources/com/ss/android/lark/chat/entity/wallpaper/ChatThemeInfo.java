package com.ss.android.lark.chat.entity.wallpaper;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 72\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0003789B]\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010%\u001a\u00020\nH\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010)\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0000H\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J%\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jp\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020'2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006:"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "id", BuildConfig.FLAVOR, "imageEntity", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;", "componentScene", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;", IPortraitService.NAME, BuildConfig.FLAVOR, "i18nName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "themeType", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$ThemeType;", "<init>", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;Ljava/lang/String;Ljava/util/HashMap;Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$ThemeType;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getImageEntity", "()Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;", "setImageEntity", "(Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;)V", "getComponentScene", "()Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;", "setComponentScene", "(Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getI18nName", "()Ljava/util/HashMap;", "getThemeType", "()Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$ThemeType;", "toString", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;Ljava/lang/String;Ljava/util/HashMap;Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$ThemeType;)Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "Companion", "ThemeType", "Scene", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatThemeInfo implements Serializable, b<ChatThemeInfo> {
    public static final a Companion = null;
    public static final long FAKE_ID = -10000;
    private Scene componentScene;
    private final HashMap<String, String> i18nName;
    private final Long id;
    private ChatBackgroundEntity imageEntity;
    private String name;
    private final ThemeType themeType;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "DEFAULT_SCENE", "DARK", "BRIGHT", "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scene extends Enum<Scene> {
        public static final Scene BRIGHT = null;
        public static final a Companion = null;
        public static final Scene DARK = null;
        public static final Scene DEFAULT_SCENE = null;
        public static final /* synthetic */ Scene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Scene> getEntries() {
            return b;
        }

        static {
            Scene r0 = new Scene("DEFAULT_SCENE", 0, 0);
            DEFAULT_SCENE = r0;
            Scene r1 = new Scene("DARK", 1, 1);
            DARK = r1;
            Scene r3 = new Scene("BRIGHT", 2, 2);
            BRIGHT = r3;
            Scene[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static Scene[] values() {
            return (Scene[]) a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return name();
        }

        public final int getNumber() {
            return this.number;
        }

        @JvmStatic
        public static final Scene fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return BRIGHT;
        L15:
            return DARK;
        L12:
            return DEFAULT_SCENE;
        }

        public static Scene valueOf(String r1) {
            return (Scene) r27.a.a(Scene.class, r1);
        }

        public Scene(String r1, int r2, int r3) {
            super(r1, r2);
            this.number = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$ThemeType;", BuildConfig.FLAVOR, "themeType", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getThemeType", "()I", "UNKNOWN_TYPE", "SYSTEM_THEME", "CUSTOMIZE_THEME", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ThemeType extends Enum<ThemeType> {
        public static final ThemeType CUSTOMIZE_THEME = null;
        public static final a Companion = null;
        public static final ThemeType SYSTEM_THEME = null;
        public static final ThemeType UNKNOWN_TYPE = null;
        public static final /* synthetic */ ThemeType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int themeType;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static ThemeType a(Integer r2) {
                if (r2 != null) goto L5;
            L7:
                if (r2 != null) goto L10;
            L12:
                if (r2 != null) goto L15;
            L17:
                return null;
            L15:
                if (r2.intValue() != 2) goto L17;
                return ThemeType.CUSTOMIZE_THEME;
            L10:
                if (r2.intValue() != 1) goto L12;
                return ThemeType.SYSTEM_THEME;
            L5:
                if (r2.intValue() != 0) goto L7;
                return ThemeType.UNKNOWN_TYPE;
            }
        }

        @JvmStatic
        public static final ThemeType fromValue(Integer r1) {
            Companion.getClass();
            return a.a(r1);
        }

        public static EnumEntries<ThemeType> getEntries() {
            return b;
        }

        static {
            ThemeType r0 = new ThemeType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            ThemeType r1 = new ThemeType("SYSTEM_THEME", 1, 1);
            SYSTEM_THEME = r1;
            ThemeType r3 = new ThemeType("CUSTOMIZE_THEME", 2, 2);
            CUSTOMIZE_THEME = r3;
            ThemeType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static ThemeType[] values() {
            return (ThemeType[]) a.clone();
        }

        public final int getThemeType() {
            return this.themeType;
        }

        public static ThemeType valueOf(String r1) {
            return (ThemeType) r27.a.a(ThemeType.class, r1);
        }

        public ThemeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.themeType = r3;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatThemeInfo copy$default(ChatThemeInfo r4, Long r5, ChatBackgroundEntity r6, Scene r7, String r8, HashMap r9, ThemeType r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.imageEntity;
    L8:
        ChatBackgroundEntity r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.componentScene;
    L11:
        Scene r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.name;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.i18nName;
    L17:
        HashMap r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.themeType;
    L20:
        Long r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Long component1() {
        return this.id;
    }

    public final ChatBackgroundEntity component2() {
        return this.imageEntity;
    }

    public final Scene component3() {
        return this.componentScene;
    }

    public final String component4() {
        return this.name;
    }

    public final HashMap<String, String> component5() {
        return this.i18nName;
    }

    public final ThemeType component6() {
        return this.themeType;
    }

    public final ChatThemeInfo copy(Long r9, ChatBackgroundEntity r10, Scene r11, String r12, HashMap<String, String> r13, ThemeType r14) {
        Intrinsics.checkNotNullParameter(r13, "i18nName");
        return new ChatThemeInfo(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatThemeInfo) == true) goto L8;
        return false;
    L8:
        ChatThemeInfo r6 = (ChatThemeInfo) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageEntity, r6.imageEntity) == true) goto L15;
        return false;
    L15:
        if (this.componentScene == r6.componentScene) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.i18nName, r6.i18nName) == true) goto L24;
        return false;
    L24:
        if (this.themeType == r6.themeType) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ChatBackgroundEntity r4 = this.imageEntity;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Scene r7 = this.componentScene;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.name;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.i18nName.hashCode()) * 31;
        ThemeType r13 = this.themeType;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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

    @JvmStatic
    public static final ChatThemeInfo fake() {
        Companion.getClass();
        return new ChatThemeInfo(null, new ChatBackgroundEntity(ChatBackgroundEntity.BackgroundMode.IMAGE_MODE, null, null, null), null, null, new HashMap(), ThemeType.CUSTOMIZE_THEME);
    }

    public String toString() {
        return "ChatThemeInfo(id=" + this.id + ", imageEntity=" + this.imageEntity + ", componentScene=" + this.componentScene + ", name=" + this.name + ')';
    }

    public final Scene getComponentScene() {
        return this.componentScene;
    }

    public final HashMap<String, String> getI18nName() {
        return this.i18nName;
    }

    public final Long getId() {
        return this.id;
    }

    public final ChatBackgroundEntity getImageEntity() {
        return this.imageEntity;
    }

    public final String getName() {
        return this.name;
    }

    public final ThemeType getThemeType() {
        return this.themeType;
    }

    public boolean isContentSame(ChatThemeInfo r6) {
        if (Intrinsics.areEqual(this, r6) == false) goto L5;
        return true;
    L5:
        Long r0 = this.id;
        HashMap<String, String> r2 = null;
        if (r6 == null) goto L8;
        Long r3 = r6.id;
    L10:
        if (Intrinsics.areEqual(r0, r3) == true) goto L12;
        return false;
    L12:
        ChatBackgroundEntity r1 = this.imageEntity;
        if (r1 == null) goto L20;
        if (r6 == null) goto L16;
        ChatBackgroundEntity r4 = r6.imageEntity;
    L18:
        if (r1.isContentSame(r4) == true) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == false) goto L23;
        return false;
    L23:
        Scene r7 = this.componentScene;
        if (r6 == null) goto L26;
        Scene r8 = r6.componentScene;
    L27:
        if (r7 == r8) goto L29;
        return false;
    L29:
        String r9 = this.name;
        if (r6 == null) goto L32;
        String r10 = r6.name;
    L34:
        if (Intrinsics.areEqual(r9, r10) == true) goto L36;
        return false;
    L36:
        HashMap<String, String> r11 = this.i18nName;
        if (r6 == null) goto L40;
        r2 = r6.i18nName;
    L40:
        if (Intrinsics.areEqual(r11, r2) == true) goto L42;
        return false;
    L42:
        return true;
    L32:
        r10 = null;
        goto L34
    L26:
        r8 = null;
        goto L27
    L16:
        r4 = null;
    L20:
        r5 = false;
        goto L21
    L8:
        r3 = null;
        goto L10
    }

    public boolean isItemSame(ChatThemeInfo r2) {
        Long r0 = this.id;
        if (r2 == null) goto L5;
        Long r3 = r2.id;
    L7:
        return Intrinsics.areEqual(r0, r3);
    L5:
        r3 = null;
        goto L7
    }

    public final void setComponentScene(Scene r1) {
        this.componentScene = r1;
    }

    public final void setImageEntity(ChatBackgroundEntity r1) {
        this.imageEntity = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((ChatThemeInfo) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((ChatThemeInfo) r1);
    }

    public ChatThemeInfo(Long r2, ChatBackgroundEntity r3, Scene r4, String r5, HashMap<String, String> r6, ThemeType r7) {
        Intrinsics.checkNotNullParameter(r6, "i18nName");
        this.id = r2;
        this.imageEntity = r3;
        this.componentScene = r4;
        this.name = r5;
        this.i18nName = r6;
        this.themeType = r7;
    }
}
