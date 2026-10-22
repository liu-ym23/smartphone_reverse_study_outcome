package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import xb.s;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final enum SingleInternalHelper$ToObservable extends Enum<SingleInternalHelper$ToObservable> implements h<s, Observable> {
    private static final /* synthetic */ SingleInternalHelper$ToObservable[] $VALUES = null;
    public static final SingleInternalHelper$ToObservable INSTANCE = null;

    static {
        SingleInternalHelper$ToObservable r10 = new SingleInternalHelper$ToObservable("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new SingleInternalHelper$ToObservable[]{r10};
    }

    private SingleInternalHelper$ToObservable(String r10, int r11) {
        super(r10, r11);
    }

    public static SingleInternalHelper$ToObservable valueOf(String r10) {
        return (SingleInternalHelper$ToObservable) Enum.valueOf(SingleInternalHelper$ToObservable.class, r10);
    }

    public static SingleInternalHelper$ToObservable[] values() {
        return (SingleInternalHelper$ToObservable[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Observable apply2(s r10) {
        return new SingleToObservable(r10);
    }

    @Override // zb.h
    public /* bridge */ /* synthetic */ Observable apply(s r10) {
        return apply2(r10);
    }
}
