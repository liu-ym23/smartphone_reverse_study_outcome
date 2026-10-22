package org.threeten.bp.zone;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21302a = null;

    static {
        int[] r5 = new int[ZoneOffsetTransitionRule.TimeDefinition.values().length];
        f21302a = r5;
        r5[ZoneOffsetTransitionRule.TimeDefinition.UTC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f21302a[ZoneOffsetTransitionRule.TimeDefinition.STANDARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
