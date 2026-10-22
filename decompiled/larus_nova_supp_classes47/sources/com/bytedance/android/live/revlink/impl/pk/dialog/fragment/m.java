package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ InteractPkRecordFragmentNew a;

    public m(InteractPkRecordFragmentNew r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.ViewGroup, com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkRecordView] */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.view.ViewGroup, com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkReserveView] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        InteractPkRecordFragmentNew r7 = this.a;
        if (r7.t != 1) goto L5;
        return;
    L5:
        ?? r8 = r7.w;
        if (r8 == 0) goto L26;
        x31.p r0 = r8.m;
        if (r0 == null) goto L10;
        r0.m();
    L10:
        x31.p r1 = r8.m;
        if (r1 == null) goto L13;
        r1.n(-1);
    L13:
        LinkedList<Object> r2 = r8.d;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L16:
        r2.clear();
        MultiTypeAdapter r3 = r8.a;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L19:
        LinkedList<Object> r4 = r8.d;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L22:
        r3.a = r4;
        MultiTypeAdapter r5 = r8.a;
        if (r5 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L25:
        r5.notifyDataSetChanged();
        r8.setVisibility(8);
    L26:
        ?? r9 = this.a.x;
        if (r9 == 0) goto L35;
        r9.setVisibility(0);
        View r10 = r9.d;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L31:
        r10.setVisibility(0);
        n r12 = r9.c;
        if (r12 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L34:
        r12.a();
        InteractPkReserveView.S5(0, false);
    L35:
        InteractPkRecordFragmentNew r13 = this.a;
        r13.t = 1;
        ViewGroup r14 = r13.o;
        if (r14 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L38:
        ((TextView) r14.findViewById(2131391626)).setTextColor(s1.h(2131107936));
        ViewGroup r15 = this.a.o;
        if (r15 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L41:
        ((TextView) r15.findViewById(2131391606)).setTextColor(s1.h(2131107328));
    }
}
