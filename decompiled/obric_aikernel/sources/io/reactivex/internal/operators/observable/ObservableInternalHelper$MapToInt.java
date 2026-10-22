package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes2.dex */
final enum ObservableInternalHelper$MapToInt extends Enum<ObservableInternalHelper$MapToInt> implements zb.h<Object, Object> {
    private static final /* synthetic */ ObservableInternalHelper$MapToInt[] $VALUES = null;
    public static final ObservableInternalHelper$MapToInt INSTANCE = null;

    static {
        ObservableInternalHelper$MapToInt r10 = new ObservableInternalHelper$MapToInt("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new ObservableInternalHelper$MapToInt[]{r10};
    }

    private ObservableInternalHelper$MapToInt(String r10, int r11) {
        super(r10, r11);
    }

    public static ObservableInternalHelper$MapToInt valueOf(String r10) {
        return (ObservableInternalHelper$MapToInt) Enum.valueOf(ObservableInternalHelper$MapToInt.class, r10);
    }

    public static ObservableInternalHelper$MapToInt[] values() {
        return (ObservableInternalHelper$MapToInt[]) $VALUES.clone();
    }

    @Override // zb.h
    public Object apply(Object r10) {
        return 0;
    }
}
