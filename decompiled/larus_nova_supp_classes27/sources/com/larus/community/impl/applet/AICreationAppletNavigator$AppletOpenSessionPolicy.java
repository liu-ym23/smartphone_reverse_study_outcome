package com.larus.community.impl.applet;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/community/impl/applet/AICreationAppletNavigator$AppletOpenSessionPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "RESTORE_AI_CREATION_HOME", "RETAIN_AI_CREATION_HOME_MEMORY", "RESET_STACK", "KEEP_CURRENT_STACK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AICreationAppletNavigator$AppletOpenSessionPolicy extends Enum<AICreationAppletNavigator$AppletOpenSessionPolicy> {
    public static final AICreationAppletNavigator$AppletOpenSessionPolicy KEEP_CURRENT_STACK = null;
    public static final AICreationAppletNavigator$AppletOpenSessionPolicy RESET_STACK = null;
    public static final AICreationAppletNavigator$AppletOpenSessionPolicy RESTORE_AI_CREATION_HOME = null;
    public static final AICreationAppletNavigator$AppletOpenSessionPolicy RETAIN_AI_CREATION_HOME_MEMORY = null;
    public static final /* synthetic */ AICreationAppletNavigator$AppletOpenSessionPolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AICreationAppletNavigator$AppletOpenSessionPolicy> getEntries() {
        return b;
    }

    static {
        AICreationAppletNavigator$AppletOpenSessionPolicy r0 = new AICreationAppletNavigator$AppletOpenSessionPolicy("RESTORE_AI_CREATION_HOME", 0);
        RESTORE_AI_CREATION_HOME = r0;
        AICreationAppletNavigator$AppletOpenSessionPolicy r1 = new AICreationAppletNavigator$AppletOpenSessionPolicy("RETAIN_AI_CREATION_HOME_MEMORY", 1);
        RETAIN_AI_CREATION_HOME_MEMORY = r1;
        AICreationAppletNavigator$AppletOpenSessionPolicy r3 = new AICreationAppletNavigator$AppletOpenSessionPolicy("RESET_STACK", 2);
        RESET_STACK = r3;
        AICreationAppletNavigator$AppletOpenSessionPolicy r5 = new AICreationAppletNavigator$AppletOpenSessionPolicy("KEEP_CURRENT_STACK", 3);
        KEEP_CURRENT_STACK = r5;
        AICreationAppletNavigator$AppletOpenSessionPolicy[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static AICreationAppletNavigator$AppletOpenSessionPolicy[] values() {
        return (AICreationAppletNavigator$AppletOpenSessionPolicy[]) a.clone();
    }

    public static AICreationAppletNavigator$AppletOpenSessionPolicy valueOf(String r1) {
        return (AICreationAppletNavigator$AppletOpenSessionPolicy) r27.a.a(AICreationAppletNavigator$AppletOpenSessionPolicy.class, r1);
    }

    public AICreationAppletNavigator$AppletOpenSessionPolicy(String r1, int r2) {
        super(r1, r2);
    }
}
