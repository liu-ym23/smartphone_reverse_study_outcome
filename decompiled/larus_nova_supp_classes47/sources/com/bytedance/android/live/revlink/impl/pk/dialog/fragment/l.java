package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.disposables.Disposable;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ InteractPkRecordFragmentNew a;

    public l(InteractPkRecordFragmentNew r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [android.view.ViewGroup, com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkReserveView] */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.view.ViewGroup, com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkRecordView] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        ConstraintLayout r7 = this.a.w;
        if (r7 != null) goto L5;
    L7:
        ?? r8 = this.a.x;
        if (r8 == 0) goto L28;
        r8.setVisibility(8);
        LinkedList<Object> r1 = r8.e;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L12:
        r1.clear();
        MultiTypeAdapter r2 = r8.a;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L15:
        LinkedList<Object> r4 = r8.e;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L18:
        r2.a = r4;
        MultiTypeAdapter r3 = r8.a;
        if (r3 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L21:
        r3.notifyDataSetChanged();
        n r9 = r8.c;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L24:
        Disposable r5 = r9.a;
        if (r5 == null) goto L27;
        r5.dispose();
    L27:
        r9.b = false;
        r9.d = "";
    L28:
        ?? r10 = this.a.w;
        if (r10 == 0) goto L40;
        x31.p r12 = r10.m;
        if (r12 == null) goto L33;
        r12.n(-1);
    L33:
        x31.p r13 = r10.m;
        if (r13 == null) goto L36;
        r13.n(0);
    L36:
        r10.setVisibility(0);
        View r14 = r10.c;
        if (r14 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L39:
        r14.setVisibility(0);
    L40:
        InteractPkRecordFragmentNew r15 = this.a;
        r15.t = 0;
        ViewGroup r16 = r15.o;
        if (r16 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L43:
        ((TextView) r16.findViewById(2131391606)).setTextColor(s1.h(2131107936));
        ViewGroup r17 = this.a.o;
        if (r17 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L46:
        ((TextView) r17.findViewById(2131391626)).setTextColor(s1.h(2131107328));
        return;
    L5:
        if (r7.getVisibility() != 0) goto L7;
    }
}
