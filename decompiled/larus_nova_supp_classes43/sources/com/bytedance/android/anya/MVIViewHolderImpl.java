package com.bytedance.android.anya;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.DelegatingMVIBindingImpl;
import com.bytedance.android.anya.p;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anya/MVIViewHolderImpl;", "Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "runtime_release"}, k = 1, mv = {1, 4, 0})
public final class MVIViewHolderImpl<STATE extends MVIState<?>, ACTION extends p> extends RecyclerView.ViewHolder {
    public final DelegatingMVIBindingImpl<STATE, ACTION, BaseMVIListItem<STATE, ACTION>> a;
    public boolean b;
    public final BaseMVIListItem<STATE, ACTION> c;

    public final void T3(STATE r10) {
        this.c.k = r10;
        DelegatingMVIBindingImpl<STATE, ACTION, BaseMVIListItem<STATE, ACTION>> r0 = this.a;
        r0.e = r10;
        r0.a();
        this.c.c(new k(r10, this.a.f(), this.b));     // Catch: Throwable -> L6
        this.b = false;
        return;
    L6:
        th = move-exception;
        this.b = false;
        throw th;
    }

    public MVIViewHolderImpl(BaseMVIView<?, ?> r10, BaseMVIListItem<STATE, ACTION> r11) {
        super(r11.j);
        this.c = r11;
        com.bytedance.android.anya.internal.m<?, ACTION> r12 = r10.b;
        if (r12 == null) goto L7;
        this.a = new DelegatingMVIBindingImpl(r12, r11, r11.k, new MVIViewHolderImpl$binding$1(this));
        this.b = true;
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.MVIBindingExt<*, ACTION>");
    }
}
