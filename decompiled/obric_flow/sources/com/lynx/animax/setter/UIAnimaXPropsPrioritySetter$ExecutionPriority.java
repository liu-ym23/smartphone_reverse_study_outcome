package com.lynx.animax.setter;

/* JADX INFO: loaded from: classes2.dex */
public final enum UIAnimaXPropsPrioritySetter$ExecutionPriority extends Enum<UIAnimaXPropsPrioritySetter$ExecutionPriority> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UIAnimaXPropsPrioritySetter$ExecutionPriority f9694b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final UIAnimaXPropsPrioritySetter$ExecutionPriority f9695c = null;
    public static final UIAnimaXPropsPrioritySetter$ExecutionPriority d = null;
    public static final /* synthetic */ UIAnimaXPropsPrioritySetter$ExecutionPriority[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9696a;

    static {
        UIAnimaXPropsPrioritySetter$ExecutionPriority r5 = new UIAnimaXPropsPrioritySetter$ExecutionPriority("HIGH", 0, -100);
        f9694b = r5;
        UIAnimaXPropsPrioritySetter$ExecutionPriority r10 = new UIAnimaXPropsPrioritySetter$ExecutionPriority("DEFAULT", 1, 0);
        f9695c = r10;
        UIAnimaXPropsPrioritySetter$ExecutionPriority r11 = new UIAnimaXPropsPrioritySetter$ExecutionPriority("LOW", 2, 100);
        d = r11;
        e = new UIAnimaXPropsPrioritySetter$ExecutionPriority[]{r5, r10, r11};
    }

    public UIAnimaXPropsPrioritySetter$ExecutionPriority(String r5, int r10, int r11) {
        super(r5, r10);
        this.f9696a = r11;
    }

    public static UIAnimaXPropsPrioritySetter$ExecutionPriority valueOf(String r5) {
        return (UIAnimaXPropsPrioritySetter$ExecutionPriority) Enum.valueOf(UIAnimaXPropsPrioritySetter$ExecutionPriority.class, r5);
    }

    public static UIAnimaXPropsPrioritySetter$ExecutionPriority[] values() {
        return (UIAnimaXPropsPrioritySetter$ExecutionPriority[]) e.clone();
    }
}
