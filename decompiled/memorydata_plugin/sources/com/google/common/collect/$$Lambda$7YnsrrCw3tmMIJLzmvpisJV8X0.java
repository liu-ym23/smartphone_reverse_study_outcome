package com.google.common.collect;

import java.util.function.IntFunction;

/* JADX INFO: renamed from: com.google.common.collect.-$$Lambda$7Yn-srrCw3tmMIJLzmvpisJV8X0, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$7YnsrrCw3tmMIJLzmvpisJV8X0 implements IntFunction {
    public final /* synthetic */ ImmutableList f$0;

    public /* synthetic */ $$Lambda$7YnsrrCw3tmMIJLzmvpisJV8X0(ImmutableList r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int r1) {
        return this.f$0.get(r1);
    }
}
