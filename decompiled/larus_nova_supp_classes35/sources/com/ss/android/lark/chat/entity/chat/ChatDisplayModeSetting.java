package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatDisplayModeSetting;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "DEFAULT", "THREAD", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatDisplayModeSetting extends Enum<ChatDisplayModeSetting> {
    public static final a Companion = null;
    public static final ChatDisplayModeSetting DEFAULT = null;
    public static final ChatDisplayModeSetting THREAD = null;
    public static final ChatDisplayModeSetting UNKNOWN = null;
    public static final /* synthetic */ ChatDisplayModeSetting[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int number;

    public static EnumEntries<ChatDisplayModeSetting> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting$a] */
    static {
        ChatDisplayModeSetting r0 = new ChatDisplayModeSetting("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        ChatDisplayModeSetting r1 = new ChatDisplayModeSetting("DEFAULT", 1, 1);
        DEFAULT = r1;
        ChatDisplayModeSetting r3 = new ChatDisplayModeSetting("THREAD", 2, 2);
        THREAD = r3;
        ChatDisplayModeSetting[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static ChatDisplayModeSetting[] values() {
        return (ChatDisplayModeSetting[]) a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static ChatDisplayModeSetting valueOf(String r1) {
        return (ChatDisplayModeSetting) r27.a.a(ChatDisplayModeSetting.class, r1);
    }

    public ChatDisplayModeSetting(String r1, int r2, int r3) {
        super(r1, r2);
        this.number = r3;
    }
}
