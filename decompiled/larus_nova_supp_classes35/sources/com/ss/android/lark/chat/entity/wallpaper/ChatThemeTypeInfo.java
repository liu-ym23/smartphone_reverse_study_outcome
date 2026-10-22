package com.ss.android.lark.chat.entity.wallpaper;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeTypeInfo;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN_CHAT_THEME_TYPE", "PERSONAL_CHAT_THEME", "GROUP_CHAT_THEME", "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatThemeTypeInfo extends Enum<ChatThemeTypeInfo> {
    public static final a Companion = null;
    public static final ChatThemeTypeInfo GROUP_CHAT_THEME = null;
    public static final ChatThemeTypeInfo PERSONAL_CHAT_THEME = null;
    public static final ChatThemeTypeInfo UNKNOWN_CHAT_THEME_TYPE = null;
    public static final /* synthetic */ ChatThemeTypeInfo[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int number;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ChatThemeTypeInfo> getEntries() {
        return b;
    }

    static {
        ChatThemeTypeInfo r0 = new ChatThemeTypeInfo("UNKNOWN_CHAT_THEME_TYPE", 0, 0);
        UNKNOWN_CHAT_THEME_TYPE = r0;
        ChatThemeTypeInfo r1 = new ChatThemeTypeInfo("PERSONAL_CHAT_THEME", 1, 1);
        PERSONAL_CHAT_THEME = r1;
        ChatThemeTypeInfo r3 = new ChatThemeTypeInfo("GROUP_CHAT_THEME", 2, 2);
        GROUP_CHAT_THEME = r3;
        ChatThemeTypeInfo[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static ChatThemeTypeInfo[] values() {
        return (ChatThemeTypeInfo[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final ChatThemeTypeInfo fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        return null;
    L14:
        return GROUP_CHAT_THEME;
    L15:
        return PERSONAL_CHAT_THEME;
    L12:
        return UNKNOWN_CHAT_THEME_TYPE;
    }

    public static ChatThemeTypeInfo valueOf(String r1) {
        return (ChatThemeTypeInfo) r27.a.a(ChatThemeTypeInfo.class, r1);
    }

    public ChatThemeTypeInfo(String r1, int r2, int r3) {
        super(r1, r2);
        this.number = r3;
    }
}
