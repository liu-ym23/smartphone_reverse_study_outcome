package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingNestedScrollMode;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingSlotKey;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingTopSlotMode;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTitleNameView;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mwb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final Fragment a;
    public final FragmentManager b;
    public final e c;
    public final d d;
    public final Function0<MmRecordingTopBarView> e;
    public final Function0<MmRecordingTitleNameView> f;
    public final Function0<mwb.d> g;
    public final Function0<Unit> h;
    public final Function0<Unit> i;
    public final Function0<Unit> j;
    public dwb.b k;
    public final Map<MmRecordingSlotKey, View> l;
    public MmRecordingTopBarView m;
    public MmRecordingTitleNameView n;
    public mwb.d o;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0064a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingSlotKey.values().length];
            r0[MmRecordingSlotKey.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MmRecordingSlotKey.TITLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MmRecordingSlotKey.MIDDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MmRecordingSlotKey.TOOLBAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public final void b() {
        int r2 = 0;
        if (this.k.f.a != MmRecordingTopSlotMode.OVERLAY) goto L5;
        boolean r0 = true;
    L6:
        ConstraintLayout.LayoutParams r1 = this.c.d.getLayoutParams();
        if ((r1 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r3 = r1;
    L10:
        if (r3 == null) goto L25;
        int r4 = -1;
        if (r0 == false) goto L15;
        int r5 = 0;
    L16:
        if (r0 == true) goto L20;
        r4 = this.c.c.getId();
    L20:
        if (r3.topToTop == r5) goto L22;
    L24:
        r3.topToTop = r5;
        r3.topToBottom = r4;
        this.c.d.setLayoutParams(r3);
        goto L25
    L22:
        if (r3.topToBottom != r4) goto L24;
    L15:
        r5 = -1;
    L25:
        if (r0 == false) goto L30;
        Integer r6 = this.k.f.b;
        if (r6 == null) goto L29;
        r2 = r6.intValue();
        goto L30
    L29:
        r2 = e().getHeight();
    L30:
        this.c.d.setContentTopInsetPx(r2);
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final View e() {
        Map<MmRecordingSlotKey, View> r0 = this.l;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        View r2 = (View) r1.get(MmRecordingSlotKey.TOP);
        if (r2 != null) goto L9;
        ConstraintLayout r3 = this.m;
        if (r3 == null) goto L8;
        return r3;
    L8:
        return this.c.c;
    L9:
        return r2;
    }

    public static FrameLayout.LayoutParams d(MmRecordingSlotKey r2) {
        if (r2 != MmRecordingSlotKey.MIDDLE) goto L5;
        int r3 = -1;
    L7:
        return new FrameLayout.LayoutParams(-1, r3);
    L5:
        r3 = -2;
        goto L7
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void f(dwb.b r13) {
        Intrinsics.checkNotNullParameter(r13, "config");
        this.k = r13;
        MmRecordingSlotKey[] r0 = MmRecordingSlotKey.values();
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L49;
        MmRecordingSlotKey r5 = r0[r3];
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "key");
        int r6 = dwb.b.a.a[r5.ordinal()];
        boolean r7 = true;
        if (r6 == 1) goto L15;
        if (r6 == 2) goto L14;
        if (r6 == 3) goto L13;
        if (r6 != 4) goto L12;
        dwb.a r8 = r13.d;
    L16:
        int r9 = C0064a.a[r5.ordinal()];
        if (r9 == 1) goto L47;
        if (r9 == 2) goto L46;
        if (r9 == 3) goto L39;
        if (r9 != 4) goto L38;
        MmRecordingSlotKey r10 = MmRecordingSlotKey.TOOLBAR;
        Fragment r11 = this.b.findFragmentByTag("mm_recording_slot_" + r10.name().toLowerCase(Locale.ROOT));
        if (r11 == null) goto L25;
        this.b.beginTransaction().remove(r11).commitNowAllowingStateLoss();
    L25:
        this.l.remove(r10);
        this.c.g.removeAllViews();
        if (r8 != null) goto L29;
        this.h.invoke();
    L48:
        r3 = r3 + 1;
        goto L4
    L29:
        if ((r8 instanceof dwb.a.C0134a) == true) goto L35;
        if ((r8 instanceof dwb.a.b) == false) goto L34;
        View r4 = (View) ((dwb.a.b) r8).a.invoke(this.a.requireContext(), this.d);
        this.c.g.addView(r4, new FrameLayout.LayoutParams(-1, -2));
        this.l.put(r10, r4);
        goto L48
    L34:
        throw new NoWhenBranchMatchedException();
    L35:
        FragmentContainerView r14 = new FragmentContainerView(this.a.requireContext());
        r14.setId(View.generateViewId());
        r14.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.c.g.addView(r14);
        r14.getId();
        dwb.a.C0134a r12 = (dwb.a.C0134a) r8;
        throw null;
    L38:
        throw new NoWhenBranchMatchedException();
    L39:
        a(MmRecordingSlotKey.MIDDLE, this.c.f, r8, new MmRecordingSlotsController$applyMiddleSlot$1(this));
        if (r8 == null) goto L48;
        MmRecordingNavLayout r15 = this.c.d;
        if (r8.a() == MmRecordingNestedScrollMode.Enabled) goto L45;
        r7 = false;
    L45:
        r15.setEnableScroll(r7);
        goto L48
    L46:
        a(MmRecordingSlotKey.TITLE, this.c.e, r8, new MmRecordingSlotsController$applyTitleSlot$1(this));
        goto L48
    L47:
        a(MmRecordingSlotKey.TOP, this.c.c, r8, new MmRecordingSlotsController$applyTopSlot$1(this));
        goto L48
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        r8 = r13.c;
        goto L16
    L14:
        r8 = r13.b;
        goto L16
    L15:
        r8 = r13.a;
        goto L16
    L49:
        b();
        this.c.d.setTopBarView(e());
        MmRecordingNavLayout r16 = this.c.d;
        ConstraintLayout r2 = (View) ((LinkedHashMap) this.l).get(MmRecordingSlotKey.TITLE);
        if (r2 != null) goto L55;
        r2 = this.n;
        if (r2 != null) goto L55;
        r2 = this.c.e;
    L55:
        FrameLayout r17 = this.c.f;
        r16.a = r2;
        r16.b = null;
        r16.d = r17;
        r16.a(r2);
        r16.d();
        r16.removeCallbacks(r16.u);
        r16.post(r16.u);
        r16.requestLayout();
        View r18 = e();
        if (r18.isLaidOut() == true) goto L58;
    L60:
        r18.addOnLayoutChangeListener(new b(this));
    L61:
        this.j.invoke();
        return;
    L58:
        if (r18.isLayoutRequested() == true) goto L60;
        b();
        this.j.invoke();
        goto L61
    }

    public static void c(FrameLayout r2, View r3, FrameLayout.LayoutParams r4) {
        if (r3.getParent() == r2) goto L12;
        ViewParent r0 = r3.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L7;
        ViewGroup r1 = (ViewGroup) r0;
    L8:
        if (r1 == null) goto L10;
        r1.removeView(r3);
    L10:
        r2.addView(r3, r4);
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void a(MmRecordingSlotKey r5, FrameLayout r6, dwb.a r7, Function0<Unit> r8) {
        Fragment r0 = this.b.findFragmentByTag("mm_recording_slot_" + r5.name().toLowerCase(Locale.ROOT));
        if (r0 == null) goto L6;
        this.b.beginTransaction().remove(r0).commitNowAllowingStateLoss();
    L6:
        this.l.remove(r5);
        r6.removeAllViews();
        if (r7 != null) goto L10;
        r8.invoke();
        return;
    L10:
        if ((r7 instanceof dwb.a.C0134a) == false) goto L12;
        dwb.a.C0134a r9 = (dwb.a.C0134a) r7;
        throw null;
    L12:
        if ((r7 instanceof dwb.a.b) == false) goto L16;
        View r10 = (View) ((dwb.a.b) r7).a.invoke(this.a.requireContext(), this.d);
        r6.addView(r10, d(r5));
        this.l.put(r5, r10);
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public a(Fragment r2, FragmentManager r3, e r4, d r5, Function0<MmRecordingTopBarView> r6, Function0<MmRecordingTitleNameView> r7, Function0<mwb.d> r8, Function0<Unit> r9, Function0<Unit> r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        Intrinsics.checkNotNullParameter(r3, "childFragmentManager");
        Intrinsics.checkNotNullParameter(r4, "recordingView");
        Intrinsics.checkNotNullParameter(r5, "slotScope");
        Intrinsics.checkNotNullParameter(r6, "defaultTopFactory");
        Intrinsics.checkNotNullParameter(r7, "defaultTitleFactory");
        Intrinsics.checkNotNullParameter(r8, "defaultMiddleFactory");
        Intrinsics.checkNotNullParameter(r9, "defaultToolbarBinder");
        Intrinsics.checkNotNullParameter(r10, "onDefaultMiddleAttached");
        Intrinsics.checkNotNullParameter(r11, "onSlotsChanged");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = new dwb.b(null, null, null, null, 63);
        this.l = new LinkedHashMap();
    }
}
