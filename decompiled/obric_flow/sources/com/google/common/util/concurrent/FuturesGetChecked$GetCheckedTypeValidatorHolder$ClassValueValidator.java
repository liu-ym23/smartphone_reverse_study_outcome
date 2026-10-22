package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
final enum FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator extends Enum<FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator> {
    public static final FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f9390a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator[] f9391b = null;

    static {
        FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator r5 = new FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator("INSTANCE", 0);
        INSTANCE = r5;
        f9391b = new FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator[]{r5};
        f9390a = new r0(0);
    }

    public static FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator valueOf(String r5) {
        return (FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator) Enum.valueOf(FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator.class, r5);
    }

    public static FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator[] values() {
        return (FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator[]) f9391b.clone();
    }

    public void validateClass(Class<? extends Exception> r5) {
        androidx.room.b.l(f9390a, r5);
    }
}
