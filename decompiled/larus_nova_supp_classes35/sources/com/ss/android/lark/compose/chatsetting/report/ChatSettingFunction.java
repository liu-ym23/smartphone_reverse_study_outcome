package com.ss.android.lark.compose.chatsetting.report;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/report/ChatSettingFunction;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "ADD_MEMBER", "REMOVE_MEMBER", "GROUP_NAME_AND_AVATAR", "GROUP_QR_CODE", "GROUP_MANAGE", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatSettingFunction extends Enum<ChatSettingFunction> {
    public static final ChatSettingFunction ADD_MEMBER = null;
    public static final ChatSettingFunction GROUP_MANAGE = null;
    public static final ChatSettingFunction GROUP_NAME_AND_AVATAR = null;
    public static final ChatSettingFunction GROUP_QR_CODE = null;
    public static final ChatSettingFunction REMOVE_MEMBER = null;
    public static final /* synthetic */ ChatSettingFunction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatSettingFunction> getEntries() {
        return b;
    }

    static {
        ChatSettingFunction r0 = new ChatSettingFunction("ADD_MEMBER", 0);
        ADD_MEMBER = r0;
        ChatSettingFunction r1 = new ChatSettingFunction("REMOVE_MEMBER", 1);
        REMOVE_MEMBER = r1;
        ChatSettingFunction r3 = new ChatSettingFunction("GROUP_NAME_AND_AVATAR", 2);
        GROUP_NAME_AND_AVATAR = r3;
        ChatSettingFunction r5 = new ChatSettingFunction("GROUP_QR_CODE", 3);
        GROUP_QR_CODE = r5;
        ChatSettingFunction r7 = new ChatSettingFunction("GROUP_MANAGE", 4);
        GROUP_MANAGE = r7;
        ChatSettingFunction[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ChatSettingFunction[] values() {
        return (ChatSettingFunction[]) a.clone();
    }

    public static ChatSettingFunction valueOf(String r1) {
        return (ChatSettingFunction) r27.a.a(ChatSettingFunction.class, r1);
    }

    public ChatSettingFunction(String r1, int r2) {
        super(r1, r2);
    }
}
