package io.reactivex.internal.operators.single;

import tc.b;
import xb.s;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final enum SingleInternalHelper$ToFlowable extends Enum<SingleInternalHelper$ToFlowable> implements h<s, b> {
    private static final /* synthetic */ SingleInternalHelper$ToFlowable[] $VALUES = null;
    public static final SingleInternalHelper$ToFlowable INSTANCE = null;

    static {
        SingleInternalHelper$ToFlowable r10 = new SingleInternalHelper$ToFlowable("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new SingleInternalHelper$ToFlowable[]{r10};
    }

    private SingleInternalHelper$ToFlowable(String r10, int r11) {
        super(r10, r11);
    }

    public static SingleInternalHelper$ToFlowable valueOf(String r10) {
        return (SingleInternalHelper$ToFlowable) Enum.valueOf(SingleInternalHelper$ToFlowable.class, r10);
    }

    public static SingleInternalHelper$ToFlowable[] values() {
        return (SingleInternalHelper$ToFlowable[]) $VALUES.clone();
    }

    @Override // zb.h
    public /* bridge */ /* synthetic */ b apply(s r10) {
        return apply2(r10);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public b apply2(s r10) {
        return new SingleToFlowable(r10);
    }
}
