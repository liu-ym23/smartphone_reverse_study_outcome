package com.larus.dora.impl.device.manage;

import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;
import com.larus.dora.impl.databinding.LarusDoraGDeviceManagementPageBinding;
import com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f0<T> implements FlowCollector {
    public final /* synthetic */ DoraGDeviceManagementFragment a;

    public f0(DoraGDeviceManagementFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        DoraGDeviceManagementViewModel.c r5 = (DoraGDeviceManagementViewModel.c) r3;
        g49.d.d("DoraGDeviceManagementFragment", "collect state=" + r5.a + " device=" + r5.c + " status=" + r5.e + " items=" + r5.g.size() + " isInitialized=" + r5.l);
        if (r5.l == true) goto L5;
        g49.d.d("DoraGDeviceManagementFragment", "collect: state not initialized yet, skip");
        return Unit.INSTANCE;
    L5:
        LarusDoraGDeviceManagementPageBinding r6 = this.a.g;
        if (r6 == null) goto L10;
        SuperSwipeRefreshLayout r7 = r6.c;
        if (r7 == null) goto L10;
        r7.setRefreshing(r5.h);
    L10:
        LarusDoraGDeviceManagementPageBinding r8 = this.a.g;
        if (r8 == null) goto L15;
        AppCompatTextView r9 = r8.h;
        if (r9 == null) goto L15;
        r9.setText(r5.c);
    L15:
        Object r10 = CollectionsKt.firstOrNull(r5.g);
        if ((r10 instanceof c) == false) goto L18;
        c r11 = (c) r10;
    L19:
        if (r11 != null) goto L21;
    L41:
        LarusDoraGDeviceManagementPageBinding r12 = this.a.g;
        if (r12 == null) goto L46;
        LinearLayout r13 = r12.e;
        if (r13 == null) goto L46;
        r13.setVisibility(8);
    L46:
        LarusDoraGDeviceManagementPageBinding r14 = this.a.g;
        if (r14 == null) goto L55;
        AppCompatImageView r15 = r14.j;
        if (r15 == null) goto L55;
        r15.setEnabled(r5.k);
        if (r5.k == false) goto L53;
        float r0 = 1.0f;
    L54:
        r15.setAlpha(r0);
        goto L55
    L53:
        r0 = 0.4f;
    L55:
        this.a.ea0(r5.k);
        DoraGDeviceManagementFragment r16 = this.a;
        DoraGDeviceManagementAdapter r1 = r16.j;
        if (r1 == null) goto L59;
        r1.submitList(r5.g, new e0(r16));
    L59:
        return Unit.INSTANCE;
    L21:
        if (r11.f == false) goto L41;
        LarusDoraGDeviceManagementPageBinding r2 = this.a.g;
        if (r2 == null) goto L27;
        AppCompatTextView r17 = r2.f;
        if (r17 == null) goto L27;
        r17.setText(r0.b(Boxing.boxInt(r11.j)));
    L27:
        LarusDoraGDeviceManagementPageBinding r18 = this.a.g;
        if (r18 == null) goto L34;
        LinearLayout r20 = r18.i;
        if (r20 == null) goto L34;
        if (r20.getVisibility() != 0) goto L34;
        boolean r21 = true;
    L35:
        if (r21 == false) goto L46;
        LarusDoraGDeviceManagementPageBinding r22 = this.a.g;
        if (r22 == null) goto L46;
        LinearLayout r23 = r22.e;
        if (r23 == null) goto L46;
        r23.setVisibility(0);
    L34:
        r21 = false;
        goto L35
    L18:
        r11 = null;
        goto L19
    }
}
