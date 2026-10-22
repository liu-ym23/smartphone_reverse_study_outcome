package com.obric.oui.banner;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/banner/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class BannerViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int f = 0;
    public boolean a;
    public kla.a b;
    public int c;
    public CoroutineScope d;
    public final c e;

    public abstract void U3(b r1);

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.oui.banner.c] */
    public BannerViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.c = -1;
        this.e = new c(this);
    }

    public final void T3(boolean r6) {
        kla.a r0 = this.b;
        if (r0 == null) goto L14;
        LiveData<Integer> r1 = r0.getSelectedPosition();
        if (r1 == null) goto L14;
        Integer r2 = (Integer) r1.getValue();
        int r3 = this.c;
        if (r2 == null) goto L14;
        if (r2.intValue() != r3) goto L14;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L21;
        if (r6 == false) goto L19;
    L20:
        CoroutineScope r5 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.d = r5;
        this.a = true;
        goto L21
    L19:
        if (this.a == false) goto L20;
    L21:
        kla.a r7 = this.b;
        if (r7 == null) goto L33;
        LiveData<Integer> r8 = r7.getSelectedPosition();
        if (r8 == null) goto L33;
        Integer r9 = (Integer) r8.getValue();
        int r10 = this.c;
        if (r9 == null) goto L33;
        if (r9.intValue() != r10) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == true) goto L43;
        if (r6 == false) goto L37;
    L38:
        CoroutineScope r12 = this.d;
        if (r12 == null) goto L41;
        CoroutineScopeKt.cancel$default(r12, null, 1, null);
    L41:
        this.a = false;
        return;
    L37:
        if (this.a == true) goto L38;
        return;
    L43:
        return;
    L33:
        r11 = false;
    L14:
        r4 = false;
        goto L16
    }
}
