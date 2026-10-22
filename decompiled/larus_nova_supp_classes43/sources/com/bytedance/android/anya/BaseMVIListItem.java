package com.bytedance.android.anya;

import android.view.View;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import kotlin.jvm.internal.FunctionReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseMVIListItem<STATE extends MVIState<?>, ACTION extends p> extends BaseMVIView<STATE, ACTION> {
    public FunctionReference h;
    public FunctionReference i;
    public final View j;
    public STATE k;

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void f() {
        this.h = new BaseMVIListItem$internalDetach$1(this);
        this.i = new BaseMVIListItem$internalDetach$2(this);
    }

    public final int p() {
        return ((Number) this.i.invoke()).intValue();
    }

    public BaseMVIListItem(View r1, STATE r10) {
        this.j = r1;
        this.k = r10;
        this.h = new BaseMVIListItem$getLayoutPosition$1(this);
        this.i = new BaseMVIListItem$getAdapterPosition$1(this);
    }
}
