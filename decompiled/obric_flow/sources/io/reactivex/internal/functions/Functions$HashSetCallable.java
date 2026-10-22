package io.reactivex.internal.functions;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final enum Functions$HashSetCallable extends Enum<Functions$HashSetCallable> implements Callable<Set<Object>> {
    public static final Functions$HashSetCallable INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Functions$HashSetCallable[] f17612a = null;

    static {
        Functions$HashSetCallable r5 = new Functions$HashSetCallable("INSTANCE", 0);
        INSTANCE = r5;
        f17612a = new Functions$HashSetCallable[]{r5};
    }

    public static Functions$HashSetCallable valueOf(String r5) {
        return (Functions$HashSetCallable) Enum.valueOf(Functions$HashSetCallable.class, r5);
    }

    public static Functions$HashSetCallable[] values() {
        return (Functions$HashSetCallable[]) f17612a.clone();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Set<Object> call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Set<Object> call2() throws Exception {
        return new HashSet();
    }
}
