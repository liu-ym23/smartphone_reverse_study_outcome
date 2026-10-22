package com.ss.android.lark.create.groupchat.dto;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/create/groupchat/dto/CreateGroupScene;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "P2P", "ADD_GROUP_MEMBER", "PLUS_MENU", "FORWARD", "CREATE_SECRET_CHAT", "CREATE_DEPARTMENT_CHAT", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateGroupScene extends Enum<CreateGroupScene> {
    public static final CreateGroupScene ADD_GROUP_MEMBER = null;
    public static final CreateGroupScene CREATE_DEPARTMENT_CHAT = null;
    public static final CreateGroupScene CREATE_SECRET_CHAT = null;
    public static final CreateGroupScene FORWARD = null;
    public static final CreateGroupScene P2P = null;
    public static final CreateGroupScene PLUS_MENU = null;
    public static final /* synthetic */ CreateGroupScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreateGroupScene> getEntries() {
        return b;
    }

    static {
        CreateGroupScene r0 = new CreateGroupScene("P2P", 0);
        P2P = r0;
        CreateGroupScene r1 = new CreateGroupScene("ADD_GROUP_MEMBER", 1);
        ADD_GROUP_MEMBER = r1;
        CreateGroupScene r3 = new CreateGroupScene("PLUS_MENU", 2);
        PLUS_MENU = r3;
        CreateGroupScene r5 = new CreateGroupScene("FORWARD", 3);
        FORWARD = r5;
        CreateGroupScene r7 = new CreateGroupScene("CREATE_SECRET_CHAT", 4);
        CREATE_SECRET_CHAT = r7;
        CreateGroupScene r9 = new CreateGroupScene("CREATE_DEPARTMENT_CHAT", 5);
        CREATE_DEPARTMENT_CHAT = r9;
        CreateGroupScene[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static CreateGroupScene[] values() {
        return (CreateGroupScene[]) a.clone();
    }

    public static CreateGroupScene valueOf(String r1) {
        return (CreateGroupScene) a.a(CreateGroupScene.class, r1);
    }

    public CreateGroupScene(String r1, int r2) {
        super(r1, r2);
    }
}
