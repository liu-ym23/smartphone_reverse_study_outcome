package com.bytedance.android.live.profile.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profile/model/EnterExitStateType;", "", "INIT", "WILL_ENTER", "ENTER_START", "ENTER_END", "EXIT_START", "EXIT_END", "SLIDE_DISMISS", "COMPLETE", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EnterExitStateType extends Enum<EnterExitStateType> {
    public static final EnterExitStateType COMPLETE = null;
    public static final EnterExitStateType ENTER_END = null;
    public static final EnterExitStateType ENTER_START = null;
    public static final EnterExitStateType EXIT_END = null;
    public static final EnterExitStateType EXIT_START = null;
    public static final EnterExitStateType INIT = null;
    public static final EnterExitStateType SLIDE_DISMISS = null;
    public static final EnterExitStateType WILL_ENTER = null;
    public static final /* synthetic */ EnterExitStateType[] a = null;

    static {
        EnterExitStateType r1 = new EnterExitStateType("INIT", 0);
        INIT = r1;
        EnterExitStateType r2 = new EnterExitStateType("WILL_ENTER", 1);
        WILL_ENTER = r2;
        EnterExitStateType r3 = new EnterExitStateType("ENTER_START", 2);
        ENTER_START = r3;
        EnterExitStateType r4 = new EnterExitStateType("ENTER_END", 3);
        ENTER_END = r4;
        EnterExitStateType r5 = new EnterExitStateType("EXIT_START", 4);
        EXIT_START = r5;
        EnterExitStateType r6 = new EnterExitStateType("EXIT_END", 5);
        EXIT_END = r6;
        EnterExitStateType r7 = new EnterExitStateType("SLIDE_DISMISS", 6);
        SLIDE_DISMISS = r7;
        EnterExitStateType r8 = new EnterExitStateType("COMPLETE", 7);
        COMPLETE = r8;
        a = new EnterExitStateType[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public static EnterExitStateType valueOf(String r1) {
        return (EnterExitStateType) r27.a.a(EnterExitStateType.class, r1);
    }

    public static EnterExitStateType[] values() {
        return (EnterExitStateType[]) a.clone();
    }

    public EnterExitStateType(String r1, int r2) {
        super(r1, r2);
    }
}
