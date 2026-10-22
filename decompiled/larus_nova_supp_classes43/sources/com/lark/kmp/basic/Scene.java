package com.lark.kmp.basic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/lark/kmp/basic/Scene;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_ONLINE", "SWITCH_ONLINE", "FAST_ONLINE", "SWITCH_BACKGROUND", "SWITCH_FOREGROUND", "CREATE_USER_COMPONENT", "user-state-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Scene extends Enum<Scene> {
    public static final Scene CREATE_USER_COMPONENT = null;
    public static final Scene FAST_ONLINE = null;
    public static final Scene FIRST_ONLINE = null;
    public static final Scene SWITCH_BACKGROUND = null;
    public static final Scene SWITCH_FOREGROUND = null;
    public static final Scene SWITCH_ONLINE = null;
    public static final /* synthetic */ Scene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Scene> getEntries() {
        return b;
    }

    static {
        Scene r0 = new Scene("FIRST_ONLINE", 0);
        FIRST_ONLINE = r0;
        Scene r1 = new Scene("SWITCH_ONLINE", 1);
        SWITCH_ONLINE = r1;
        Scene r10 = new Scene("FAST_ONLINE", 2);
        FAST_ONLINE = r10;
        Scene r11 = new Scene("SWITCH_BACKGROUND", 3);
        SWITCH_BACKGROUND = r11;
        Scene r12 = new Scene("SWITCH_FOREGROUND", 4);
        SWITCH_FOREGROUND = r12;
        Scene r13 = new Scene("CREATE_USER_COMPONENT", 5);
        CREATE_USER_COMPONENT = r13;
        Scene[] r14 = {r0, r1, r10, r11, r12, r13};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static Scene[] values() {
        return (Scene[]) a.clone();
    }

    public static Scene valueOf(String r1) {
        return (Scene) a.a(Scene.class, r1);
    }

    public Scene(String r1, int r10) {
        super(r1, r10);
    }
}
