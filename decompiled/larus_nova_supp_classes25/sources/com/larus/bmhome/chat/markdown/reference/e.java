package com.larus.bmhome.chat.markdown.reference;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.layout.widget.AtMostHeightLinearLayout;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.mainbot.impl.databinding.LarusMdThinkEmphasizeSearchReferenceBinding;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import po8.z;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public LarusMdThinkEmphasizeSearchReferenceBinding a;
    public DeepThinkCommonToolHeader b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationCancel(r2);
            RecyclerView r3 = this.a.a();
            if (r3 == null) goto L5;
            r3.setAlpha(1.0f);
        L5:
            LarusMdThinkEmphasizeSearchReferenceBinding r4 = this.a.a;
            if (r4 == null) goto L8;
            TextView r5 = r4.c;
        L9:
            if (r5 == null) goto L12;
            r5.setAlpha(1.0f);
            return;
        L12:
            return;
        L8:
            r5 = null;
            goto L9
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            RecyclerView r3 = this.a.a();
            if (r3 == null) goto L5;
            r3.setAlpha(1.0f);
        L5:
            LarusMdThinkEmphasizeSearchReferenceBinding r4 = this.a.a;
            if (r4 == null) goto L8;
            TextView r5 = r4.c;
        L9:
            if (r5 == null) goto L12;
            r5.setAlpha(1.0f);
            return;
        L12:
            return;
        L8:
            r5 = null;
            goto L9
        }
    }

    static {
    }

    public final AtMostHeightRecyclerView a() {
        LarusMdThinkEmphasizeSearchReferenceBinding r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final void b() {
        DeepThinkCommonToolHeader r0 = this.b;
        if (r0 == null) goto L7;
        z r1 = r0.c;
        if (r1 == null) goto L7;
        r1.b();
    L7:
        LarusMdThinkEmphasizeSearchReferenceBinding r2 = this.a;
        if (r2 == null) goto L13;
        AtMostHeightLinearLayout r3 = r2.a;
        if (r3 == null) goto L14;
        e1.o(r3);
        return;
    L14:
        return;
    }

    public e() {
        this.c = LazyKt.lazy(new com.larus.bmhome.chat.markdown.reference.b());
        this.d = LazyKt.lazy(new c());
    }

    public final void f(Integer r3) {
        if (r3 == null) goto L4;
        int r4 = r3.intValue();
    L11:
        LarusMdThinkEmphasizeSearchReferenceBinding r0 = this.a;
        if (r0 == null) goto L17;
        AtMostHeightLinearLayout r1 = r0.b;
        if (r1 == null) goto L18;
        r1.setBackgroundResource(r4);
        return;
    L18:
        return;
    L17:
        return;
    L4:
        LarusMdThinkEmphasizeSearchReferenceBinding r5 = this.a;
        if (r5 == null) goto L9;
        AtMostHeightLinearLayout r6 = r5.a;
        if (r6 == null) goto L9;
        Context r7 = r6.getContext();
    L10:
        r4 = v19.c.b(2130970716, r7, 2131239260);
    L9:
        r7 = null;
        goto L10
    }

    public final AtMostHeightLinearLayout c(Context r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "viewGroup");
        View r10 = LayoutInflater.from(r8).inflate(2131562956, r9, false);
        r9.addView(r10);
        int r11 = 2131367580;
        DeepThinkCommonToolHeader r0 = (DeepThinkCommonToolHeader) ViewBindings.findChildViewById(r10, 2131367580);
        if (r0 == null) goto L13;
        AtMostHeightLinearLayout r12 = (AtMostHeightLinearLayout) r10;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131385521);
        if (r5 == null) goto L11;
        AtMostHeightRecyclerView r6 = (AtMostHeightRecyclerView) ViewBindings.findChildViewById(r10, 2131385561);
        if (r6 == null) goto L10;
        this.a = new LarusMdThinkEmphasizeSearchReferenceBinding(r12, r0, r12, r5, r6);
        this.b = r0;
        return r12;
    L10:
        r11 = 2131385561;
        goto L13
    L11:
        r11 = 2131385521;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public final void g(boolean r3, boolean r4) {
        if (r3 == false) goto L6;
        if (r4 == true) goto L7;
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
        r5.addUpdateListener(new d(this));
        r5.addListener(new b(this));
        r5.start();
        return;
    L7:
        return;
    }

    public final void d(boolean r11, ToolType r12, SearchReferenceData r13, Boolean r14) {
        DeepThinkCommonToolHeader r0 = this.b;
        List<String> r1 = null;
        boolean r2 = true;
        int r3 = 0;
        if (r0 == null) goto L19;
        if (r.c(r13) == false) goto L7;
    L10:
        boolean r15 = true;
    L11:
        if (r13 == null) goto L13;
        String r4 = r13.getIcon();
    L14:
        if (r13 == null) goto L16;
        String r5 = r13.getIconDark();
    L17:
        r0.b(r12, r15, r4, r5);
        goto L19
    L16:
        r5 = null;
        goto L17
    L13:
        r4 = null;
        goto L14
    L7:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == true) goto L10;
        r15 = false;
    L19:
        if (r.b(r13) == false) goto L34;
        if (r11 == true) goto L34;
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L34;
        if (r13 == null) goto L25;
        r1 = r13.getQueries();
    L25:
        List<String> r6 = r1;
        if (r6 != null) goto L28;
    L31:
        boolean r16 = true;
    L32:
        if (r16 == true) goto L34;
    L35:
        LarusMdThinkEmphasizeSearchReferenceBinding r17 = this.a;
        if (r17 == null) goto L40;
        TextView r7 = r17.c;
        if (r7 == null) goto L40;
        we8.a.b(r7, i5.o(), false, null, null, 12);
    L40:
        if (r2 == false) goto L69;
        LarusMdThinkEmphasizeSearchReferenceBinding r18 = this.a;
        if (r18 == null) goto L46;
        TextView r19 = r18.c;
        if (r19 == null) goto L46;
        e1.x(r19);
    L46:
        LarusMdThinkEmphasizeSearchReferenceBinding r110 = this.a;
        if (r110 == null) goto L79;
        TextView r111 = r110.c;
        if (r111 == null) goto L80;
        if (r13 == null) goto L67;
        List<String> r112 = r13.getQueries();
        if (r112 == null) goto L67;
        int r113 = r112.size();
        StringBuilder r114 = new StringBuilder();
        Iterator<T> r115 = r13.getQueries().iterator();
    L55:
        if (r115.hasNext() == false) goto L66;
        Object r8 = r115.next();
        int r9 = r3 + 1;
        if (r3 >= 0) goto L59;
        CollectionsKt.throwIndexOverflow();
    L59:
        String r10 = (String) r8;
        if (r3 >= r113) goto L65;
        if (r3 >= (r113 - 1)) goto L64;
        r114.append("“" + r10 + "”、");
        goto L65
    L64:
        r114.append("“" + r10 + 8221);
    L65:
        r3 = r9;
        goto L55
    L66:
        String r116 = r114.toString();
    L68:
        r111.setText(r116);
        return;
    L67:
        r116 = "";
        goto L68
    L80:
        return;
    L79:
        return;
    L69:
        LarusMdThinkEmphasizeSearchReferenceBinding r117 = this.a;
        if (r117 == null) goto L82;
        TextView r118 = r117.c;
        if (r118 == null) goto L83;
        e1.o(r118);
        return;
    L83:
        return;
    L82:
        return;
    L28:
        if (r6.isEmpty() == true) goto L31;
        r16 = false;
    L34:
        r2 = false;
        goto L35
    }

    public final void e(ToolType r7, boolean r8, SearchReferenceData r9, ArrayList<Object> r10, Context r11, boolean r12, Integer r13, Boolean r14, Function0<Unit> r15) {
        Intrinsics.checkNotNullParameter(r7, "toolType");
        Intrinsics.checkNotNullParameter(r10, "dataList");
        Intrinsics.checkNotNullParameter(r11, "context");
        f(r13);
        d(r12, r7, r9, r14);
        DeepThinkCommonToolHeader r0 = this.b;
        if (r0 == null) goto L6;
        r0.d(r7, com.larus.bmhome.chat.markdown.reference.a.a(r9), r12, r14, r15);
        return;
    }
}
