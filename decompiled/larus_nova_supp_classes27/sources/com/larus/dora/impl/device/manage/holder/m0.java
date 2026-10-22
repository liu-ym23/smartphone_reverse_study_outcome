package com.larus.dora.impl.device.manage.holder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementSodaBannerBinding;
import java.util.List;
import kotlin.collections.CollectionsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m0 implements Runnable {
    public final /* synthetic */ SodaBannerComponent a;

    public /* synthetic */ m0(SodaBannerComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SodaBannerComponent r0 = this.a;
        LarusItemDoraGDeviceManagementSodaBannerBinding r1 = r0.d;
        if (r1 == null) goto L39;
        RecyclerView r2 = r1.a.getParent();
        ViewGroup.MarginLayoutParams r4 = null;
        if ((r2 instanceof RecyclerView) == false) goto L8;
        RecyclerView r3 = r2;
    L9:
        if (r3 == null) goto L40;
        int r5 = r3.getChildAdapterPosition(r1.a);
        if (r5 == (-1)) goto L41;
        ListAdapter r6 = r3.getAdapter();
        if ((r6 instanceof ListAdapter) == false) goto L17;
        ListAdapter r7 = r6;
    L18:
        if (r7 == null) goto L22;
        List r8 = r7.getCurrentList();
        if (r8 == null) goto L22;
        Object r9 = CollectionsKt.getOrNull(r8, r5 - 1);
    L23:
        boolean r10 = r9 instanceof com.larus.dora.impl.device.manage.g;
        LarusItemDoraGDeviceManagementSodaBannerBinding r11 = r0.d;
        if (r11 == null) goto L42;
        ViewGroup.LayoutParams r12 = r11.a.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L29;
        r4 = (ViewGroup.MarginLayoutParams) r12;
    L29:
        if (r4 == null) goto L43;
        if (r10 == false) goto L33;
        int r13 = i5.h();
    L35:
        if (r4.topMargin == r13) goto L44;
        r4.topMargin = r13;
        r11.a.setLayoutParams(r4);
        return;
    L44:
        return;
    L33:
        r13 = i5.q();
        goto L35
    L43:
        return;
    L42:
        return;
    L22:
        r9 = null;
        goto L23
    L17:
        r7 = null;
        goto L18
    L41:
        return;
    L40:
        return;
    L8:
        r3 = null;
        goto L9
    }
}
