package com.google.common.collect;

import java.util.Map;
import java.util.function.Function;

/* JADX INFO: renamed from: com.google.common.collect.-$$Lambda$kPj8Ioh2qrHaOpflIdB8Zk2L0PY, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$kPj8Ioh2qrHaOpflIdB8Zk2L0PY implements Function {
    public static final /* synthetic */ $$Lambda$kPj8Ioh2qrHaOpflIdB8Zk2L0PY INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$kPj8Ioh2qrHaOpflIdB8Zk2L0PY();
    }

    private /* synthetic */ $$Lambda$kPj8Ioh2qrHaOpflIdB8Zk2L0PY() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return ((Map.Entry) r1).getValue();
    }
}
