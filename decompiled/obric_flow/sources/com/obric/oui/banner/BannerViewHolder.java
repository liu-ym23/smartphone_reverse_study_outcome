package com.obric.oui.banner;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/banner/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BannerViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wq.a f12004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12005c;
    public kotlinx.coroutines.internal.c d;
    public final a e;

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.oui.banner.a] */
    public BannerViewHolder(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super(r5);
        this.f12005c = -1;
        this.e = new a(this);
    }

    public final void a(boolean r5) {
        wq.a r10 = this.f12004b;
        if (r10 == null) goto L17;
        LiveData r11 = r10.getSelectedPosition();
        if (r11 == null) goto L17;
        Integer r12 = (Integer) r11.getValue();
        int r13 = this.f12005c;
        if (r12 == null) goto L17;
        if (r12.intValue() != r13) goto L17;
        if (r5 == false) goto L15;
    L16:
        kotlinx.coroutines.internal.c r14 = h0.a(Dispatchers.getMain().plus(j0.b()));
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        this.d = r14;
        this.f12003a = true;
        goto L17
    L15:
        if (this.f12003a == false) goto L16;
    L17:
        wq.a r15 = this.f12004b;
        if (r15 == null) goto L29;
        LiveData r16 = r15.getSelectedPosition();
        if (r16 == null) goto L29;
        Integer r17 = (Integer) r16.getValue();
        int r18 = this.f12005c;
        if (r17 == null) goto L29;
        if (r17.intValue() != r18) goto L29;
        return;
    L29:
        if (r5 == false) goto L31;
    L32:
        kotlinx.coroutines.internal.c r19 = this.d;
        if (r19 == null) goto L35;
        h0.c(r19, null);
    L35:
        this.f12003a = false;
        return;
    L31:
        if (this.f12003a == true) goto L32;
    }

    public abstract void b(d r5);
}
