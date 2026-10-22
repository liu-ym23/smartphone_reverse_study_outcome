package com.ss.android.lark.officesdk.minutes.ui.record.recording.aiinterpretation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.c;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmAIInterpretationView extends LinearLayout {
    public final MmRecordingViewModel a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public List<g> g;
    public g h;
    public g i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public Boolean n;
    public boolean o;
    public boolean p;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MmAIInterpretationView a;

        public a(MmAIInterpretationView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.b;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MmAIInterpretationView a;

        public b(MmAIInterpretationView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            MmAIInterpretationView r10 = this.a;
            boolean r1 = false;
            if (r10.k == false) goto L5;
        L8:
            boolean r0 = true;
        L10:
            if (r0 == false) goto L13;
            int r11 = bwb.b.a;
            bwb.b.g(MmUiLogScene.AI_NOTE, "actionClick", "skip updating", null, 8);
            return;
        L13:
            g r2 = r10.h;
            if (r2 != null) goto L18;
            int r12 = bwb.b.a;
            bwb.b.d(MmUiLogScene.AI_NOTE, "actionClick", "no selected language", null);
            return;
        L18:
            if (r10.j == false) goto L23;
            if (r10.d(r2) == true) goto L23;
        L25:
            boolean r13 = true;
        L26:
            MmAIInterpretationView r6 = this.a;
            r6.l = true;
            r6.m = false;
            r6.n = Boolean.valueOf(r13);
            MmAIInterpretationView r7 = this.a;
            if (r13 == true) goto L29;
        L31:
            r7.o = r1;
            r7.p = true;
            MmAIInterpretationView.a(r7);
            int r3 = bwb.b.a;
            MmUiLogScene r4 = MmUiLogScene.AI_NOTE;
            StringBuilder r5 = new StringBuilder("targetEnabled=");
            r5.append(r13);
            r5.append(", currentEnabled=");
            r5.append(this.a.j);
            r5.append(", language=");
            r5.append(r2.a);
            r5.append(", activeLanguage=");
            g r8 = this.a.i;
            if (r8 == null) goto L34;
            String r14 = r8.a;
        L35:
            r5.append(r14);
            r5.append(", selectedLanguage=");
            g r15 = this.a.h;
            if (r15 == null) goto L38;
            String r16 = r15.a;
        L39:
            r5.append(r16);
            r5.append(", languageSize=");
            r5.append(this.a.g.size());
            bwb.b.g(r4, "actionClick", r5.toString(), null, 8);
            this.a.a.dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.base.g.n(r13, r2));
            return;
        L38:
            r16 = null;
            goto L39
        L34:
            r14 = null;
            goto L35
        L29:
            if (r7.j == true) goto L31;
            r1 = true;
        L23:
            if (this.a.j == false) goto L25;
            r13 = false;
            goto L26
        L5:
            if (r10.l == true) goto L8;
            r0 = false;
            goto L10
        }
    }

    public final void c() {
        this.l = false;
        this.m = false;
        this.n = null;
        this.o = false;
        this.p = false;
    }

    public final boolean e() {
        Boolean r0 = this.n;
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L15;
        if (this.j == false) goto L24;
        g r1 = this.h;
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L25;
    L20:
        return true;
    L25:
        return false;
    L9:
        if (d(r1) != true) goto L11;
        r2 = true;
        goto L12
    L24:
        return false;
    L15:
        if (Intrinsics.areEqual(r0, Boolean.FALSE) == true) goto L17;
        if (r0 == null) goto L20;
        throw new NoWhenBranchMatchedException();
    L17:
        if (this.j == false) goto L20;
        return false;
    }

    public final void f() {
        boolean r1 = true;
        if (this.h == null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (this.l == true) goto L12;
    L16:
        boolean r3 = false;
    L18:
        if (this.j == true) goto L22;
        if (r3 == true) goto L22;
        r1 = false;
    L22:
        this.e.setEnabled(r0);
        this.f.setEnabled(r0);
        TextView r4 = this.e;
        float r5 = 1.0f;
        if (r0 == false) goto L25;
        float r6 = 1.0f;
    L26:
        r4.setAlpha(r6);
        TextView r7 = this.f;
        if (r0 == true) goto L30;
        r5 = 0.4f;
    L30:
        r7.setAlpha(r5);
        if (r1 == false) goto L33;
        this.e.setVisibility(8);
        this.f.setVisibility(0);
        return;
    L33:
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        return;
    L25:
        r6 = 0.4f;
        goto L26
    L12:
        if (Intrinsics.areEqual(this.n, Boolean.TRUE) == false) goto L16;
        if (this.p == true) goto L16;
        r3 = true;
        goto L18
    L5:
        if ((!this.g.isEmpty()) == true) goto L8;
        r0 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner r0 = ViewTreeLifecycleOwner.get(this);
        if (r0 == null) goto L8;
        CoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r1 == null) goto L9;
        int r2 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "onAttachedToWindow", "onAttachedToWindow scope=" + r1, null, 8);
        this.a.selectSubscribe(r1, MmAIInterpretationView$onAttachedToWindow$1$1.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$2(this, null));
        this.a.selectSubscribe(r1, MmAIInterpretationView$onAttachedToWindow$1$3.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$4(this, null));
        this.a.selectSubscribe(r1, MmAIInterpretationView$onAttachedToWindow$1$5.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$6(this, null));
        this.a.selectSubscribe(r1, MmAIInterpretationView$onAttachedToWindow$1$7.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$8(this, null));
        this.a.selectSubscribe(r1, MmAIInterpretationView$onAttachedToWindow$1$9.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$10(this, null));
        this.a.selectSubscribe(r1, MmAIInterpretationView$onAttachedToWindow$1$11.INSTANCE, new MmAIInterpretationView$onAttachedToWindow$1$12(this, null));
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "onDetachedFromWindow", null, null, 12);
    }

    public static final void a(final MmAIInterpretationView r12) {
        r12.d.removeAllViews();
        if (r12.g.isEmpty() == false) goto L9;
        LinearLayout r0 = r12.d;
        TextView r2 = new TextView(r12.getContext());
        if (r12.k == false) goto L7;
        String r3 = r2.getContext().getString(2131892856);
    L8:
        r2.setText(r3);
        r2.setTextColor(r2.getContext().getColor(2131106622));
        r2.setTextSize(16.0f);
        r2.setGravity(16);
        r2.setPadding(UIUtils.dp2px(r12.getContext(), 16.0f), 0, UIUtils.dp2px(r12.getContext(), 16.0f), 0);
        r2.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.dp2px(r12.getContext(), 52.0f)));
        r0.addView(r2);
        r12.f();
        return;
    L7:
        r3 = r2.getContext().getString(2131892878);
        goto L8
    L9:
        Iterator<T> r1 = r12.g.iterator();
        int r4 = 0;
    L11:
        if (r1.hasNext() == false) goto L43;
        Object r5 = r1.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        final g r7 = (g) r5;
        LinearLayout r8 = r12.d;
        int r9 = r12.g.size();
        e r10 = e.a;
        MmRecordingUILaunchMode r11 = r12.a.getUiLaunchMode();
        r10.getClass();
        View r13 = e.b(r11).getLayout().y(LayoutInflater.from(c.c(r12.getContext(), r12.a.getUiLaunchMode())), r12.d);
        boolean r14 = true;
        if (r9 != 1) goto L18;
        Drawable r15 = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r12.getContext()).m(r12.getContext());
    L24:
        r13.setBackground(r15);
        h.a(r13, new MmAIInterpretationView$createLanguageRow$1(r12, r7));
        TextView r16 = (TextView) r13.findViewById(2131389992);
        String r17 = r7.b;
        if (r17.length() == 0) goto L28;
        r14 = false;
    L28:
        if (r14 == false) goto L30;
        r17 = r7.a;
    L30:
        r16.setText(r17);
        g r18 = r12.h;
        if (r18 == null) goto L33;
        String r19 = r18.a;
    L34:
        boolean r20 = Intrinsics.areEqual(r19, r7.a);
        ImageView r21 = (ImageView) r13.findViewById(2131375896);
        if (r20 == false) goto L37;
        int r22 = 0;
    L38:
        r21.setVisibility(r22);
        View r23 = r13.findViewById(2131362332);
        if (r4 != (r9 - 1)) goto L41;
        int r24 = 8;
    L42:
        r23.setVisibility(r24);
        r8.addView(r13);
        r4 = r6;
        goto L11
    L41:
        r24 = 0;
        goto L42
    L37:
        r22 = 4;
        goto L38
    L33:
        r19 = null;
        goto L34
    L18:
        if (r4 != 0) goto L21;
        r15 = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r12.getContext()).r(r12.getContext());
        goto L24
    L21:
        if (r4 != (r9 - 1)) goto L23;
        r15 = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r12.getContext()).n(r12.getContext());
        goto L24
    L23:
        r15 = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r12.getContext()).b(r12.getContext());
        goto L24
    L43:
        r12.f();
    }

    public static final boolean b(MmAIInterpretationView r4) {
        if (r4.l == true) goto L5;
        return false;
    L5:
        if (r4.m == true) goto L7;
        return false;
    L7:
        if (r4.k == false) goto L10;
        return false;
    L10:
        if (r4.p == true) goto L12;
        boolean r0 = false;
    L20:
        if (r0 == false) goto L35;
        if (r4.o == true) goto L24;
    L30:
        r4.c();
        Function0<Unit> r5 = r4.b;
        if (r5 == null) goto L33;
        r5.invoke();
    L33:
        return true;
    L24:
        if (Intrinsics.areEqual(r4.n, Boolean.TRUE) == false) goto L30;
        if (r4.j == false) goto L30;
        Function0<Unit> r1 = r4.c;
        if (r1 == null) goto L30;
        r1.invoke();
        goto L30
    L35:
        if (r4.e() == false) goto L42;
        r4.c();
        return false;
    L42:
        return false;
    L12:
        Boolean r2 = r4.n;
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L16;
        r0 = r4.e();
        goto L20
    L16:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == true) goto L19;
        if (r2 == null) goto L19;
        throw new NoWhenBranchMatchedException();
    L19:
        r0 = true;
        goto L20
    }

    public final boolean d(g r2) {
        g r0 = this.i;
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L7:
        return Intrinsics.areEqual(r1, r2.a);
    L5:
        r1 = null;
        goto L7
    }

    public MmAIInterpretationView(Context r6, MmRecordingViewModel r7, Function0<Unit> r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        super(r6);
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.g = CollectionsKt.emptyList();
        setOrientation(1);
        e r10 = e.a;
        MmRecordingUILaunchMode r11 = r7.getUiLaunchMode();
        r10.getClass();
        e.b(r11).getLayout().k(LayoutInflater.from(c.c(r6, r7.getUiLaunchMode())), this);
        MmTitleBarView r12 = (MmTitleBarView) findViewById(2131388775);
        LinearLayout r13 = (LinearLayout) findViewById(2131362333);
        this.d = r13;
        TextView r1 = (TextView) findViewById(2131387200);
        this.e = r1;
        TextView r3 = (TextView) findViewById(2131387362);
        this.f = r3;
        int r4 = uvb.b.a;
        uvb.b.a(this, 2131362333, uvb.c.U);
        uvb.b.a(this, 2131375905, uvb.c.V);
        uvb.b.a(this, 2131387200, uvb.c.W);
        uvb.b.a(this, 2131387362, uvb.c.X);
        r12.setCloseClickListener(new a(this));
        r13.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r6).k(r6));
        final b r14 = new b(this);
        h.a(r1, new AnonymousClass2(r14));
        h.a(r3, new AnonymousClass3(r14));
        f();
    }
}
