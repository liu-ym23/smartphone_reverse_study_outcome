package com.ss.android.lark.preload.v2.task;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import o1c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/preload/v2/task/OneTimeTask;", "P", "T", "Lcom/ss/android/lark/preload/v2/task/AbsTask;", "<init>", "()V", "executeFrequency", "", "getExecuteFrequency", "()I", "setExecuteFrequency", "(I)V", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class OneTimeTask<P, T> extends a<P, T> {
    public int o;

    public OneTimeTask() {
        this.o = 1;
    }

    @Override // o1c.c
    public final int f0() {
        return this.o;
    }

    @Override // o1c.c
    public final void S(int r1) {
        this.o = r1;
    }
}
