package com.larus.dora.impl.nl.notification_rule.ui;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.impl.databinding.LarusDoraFragmentCustomBroadcastRulesBinding;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y<T> implements FlowCollector {
    public final /* synthetic */ CustomBroadcastRulesFragment a;

    public y(CustomBroadcastRulesFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        List r5 = (List) r3;
        if (r5 == null) goto L57;
        NotificationRuleAdapter r6 = this.a.f;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r6 = null;
    L8:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "newItems");
        WeakReference<SwipeLayout> r1 = r6.f;
        if (r1 == null) goto L13;
        SwipeLayout r2 = r1.get();
        if (r2 == null) goto L13;
        r2.a();
    L13:
        r6.f = null;
        ((ArrayList) r6.e).clear();
        ((ArrayList) r6.e).addAll(r5);
        r6.notifyDataSetChanged();
        if (r5.isEmpty() == false) goto L35;
        LarusDoraFragmentCustomBroadcastRulesBinding r7 = this.a.d;
        if (r7 == null) goto L20;
        Group r8 = r7.e;
        if (r8 == null) goto L20;
        r8.setVisibility(0);
    L20:
        LarusDoraFragmentCustomBroadcastRulesBinding r9 = this.a.d;
        if (r9 == null) goto L25;
        RecyclerView r10 = r9.f;
        if (r10 == null) goto L25;
        r10.setVisibility(8);
    L25:
        LarusDoraFragmentCustomBroadcastRulesBinding r11 = this.a.d;
        if (r11 == null) goto L30;
        AppCompatTextView r12 = r11.c;
        if (r12 == null) goto L30;
        r12.setVisibility(8);
    L30:
        LarusDoraFragmentCustomBroadcastRulesBinding r13 = this.a.d;
        if (r13 == null) goto L56;
        View r14 = r13.d;
        if (r14 == null) goto L56;
        r14.setVisibility(8);
    L56:
        return Unit.INSTANCE;
    L35:
        LarusDoraFragmentCustomBroadcastRulesBinding r15 = this.a.d;
        if (r15 == null) goto L40;
        Group r16 = r15.e;
        if (r16 == null) goto L40;
        r16.setVisibility(8);
    L40:
        LarusDoraFragmentCustomBroadcastRulesBinding r17 = this.a.d;
        if (r17 == null) goto L45;
        RecyclerView r18 = r17.f;
        if (r18 == null) goto L45;
        r18.setVisibility(0);
    L45:
        LarusDoraFragmentCustomBroadcastRulesBinding r20 = this.a.d;
        if (r20 == null) goto L50;
        AppCompatTextView r21 = r20.c;
        if (r21 == null) goto L50;
        r21.setVisibility(0);
    L50:
        LarusDoraFragmentCustomBroadcastRulesBinding r22 = this.a.d;
        if (r22 == null) goto L56;
        View r23 = r22.d;
        if (r23 == null) goto L56;
        r23.setVisibility(0);
        goto L56
    L57:
        return Unit.INSTANCE;
    }
}
