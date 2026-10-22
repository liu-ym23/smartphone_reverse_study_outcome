package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeAbility;", "", "dredge", "", "interval", "", "prepare", "onPoolSizeConfigChange", "", "minSize", "", "maxSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IDredgeAbility {
    boolean dredge();

    long interval(boolean r1);

    void onPoolSizeConfigChange(int r1, int r2);

    boolean prepare();
}
