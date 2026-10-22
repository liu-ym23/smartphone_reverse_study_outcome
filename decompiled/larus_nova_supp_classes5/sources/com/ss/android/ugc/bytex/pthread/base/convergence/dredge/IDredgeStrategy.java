package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "", "dredgeInterval", "", "prepare", "", "currentPoolSize", "", "maxPoolSize", "expandPoolSize", "blockSize", "foldPoolSize", "blockFlag", "isContinueDredge", "onPoolSizeConfigChange", "minSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IDredgeStrategy {
    long dredgeInterval(boolean r1, int r2, int r3);

    int expandPoolSize(int r1, int r2, int r3);

    int foldPoolSize(int r1, int r2, int r3);

    boolean isContinueDredge(int r1, int r2, int r3);

    int onPoolSizeConfigChange(int r1, int r2);
}
