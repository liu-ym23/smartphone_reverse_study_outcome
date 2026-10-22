package com.larus.bmhome.view.actionbar.edit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.instruction.IInstructionCreator;
import com.larus.bmhome.instruction.IInstructionSubCreator;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.actionbar.edit.component.MultiSelectorWidget;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements b {
    public final Fragment a;
    public final LifecycleCoroutineScope b;
    public final List<AbsInstructionWidget> c;
    public final List<up8.b> d;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final Pair<Boolean, Boolean> F7() {
        Iterator<T> r0 = this.d.iterator();
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L18;
        up8.b r3 = (up8.b) r0.next();
        Integer r4 = r3.h();
        if (r4 != null) goto L9;
    L11:
        Integer r5 = r3.h();
        if (r5 == null) goto L4;
        if (r5.intValue() != 2) goto L4;
        r2 = r3.j();
        goto L4
    L9:
        if (r4.intValue() != 1) goto L11;
        r1 = r3.j();
        goto L11
    L18:
        return new Pair(Boolean.valueOf(r1), Boolean.valueOf(r2));
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void T1() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((AbsInstructionWidget) r0.next()).U5();
        goto L4
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final boolean a() {
        Iterator<T> r0 = this.d.iterator();
        boolean r1 = true;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 & ((up8.b) r0.next()).a();
        goto L4
    L6:
        return r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final List<u> b() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((ArrayList) this.d).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        final up8.b r2 = (up8.b) r1.next();
        String r7 = r2.g();
        if (o0.d(r7) == false) goto L4;
        final u r12 = new u(r2.h(), Integer.valueOf(r2.getType()), null, r7, null, null, null, 244);
        mg9.a.a("InstructionEditorViewFactory", new e(r2, r12));
        r0.add(r12);
        goto L4
    L8:
        return r0;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final List<u> c() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((ArrayList) this.d).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        up8.b r2 = (up8.b) r1.next();
        if (o0.d(r2.g()) == false) goto L4;
        r0.add(new u(r2.h(), Integer.valueOf(r2.getType()), null, r2.g(), null, null, null, 244));
        goto L4
    L8:
        return r0;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final Long d() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Long r1 = ((up8.b) r0.next()).c();
        if (r1 == null) goto L4;
        if (r1.longValue() == 0) goto L4;
        return r1;
    L10:
        return null;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final List<u> e() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((ArrayList) this.d).iterator();
    L4:
        if (r1.hasNext() == false) goto L27;
        up8.b r2 = (up8.b) r1.next();
        z2 r3 = z2.a;
        boolean r5 = false;
        if (r3.L() == false) goto L13;
        Integer r4 = r2.h();
        if (r4 == null) goto L13;
        if (r4.intValue() != 2) goto L13;
        boolean r6 = true;
    L15:
        if (r3.T() == false) goto L23;
        Integer r7 = r2.h();
        if (r7 == null) goto L23;
        if (r7.intValue() != 1) goto L23;
        r5 = true;
    L23:
        if (o0.d(r2.g()) == false) goto L4;
        if (r6 == true) goto L26;
        if (r5 == false) goto L4;
    L26:
        r0.add(new u(r2.h(), Integer.valueOf(r2.getType()), null, r2.g(), null, null, null, 244));
    L13:
        r6 = false;
        goto L15
    L27:
        return r0;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final LiveData<Map<String, Object>> g() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        up8.d r1 = (up8.b) r0.next();
        if ((r1 instanceof com.larus.bmhome.instruction.k) == false) goto L4;
        LiveData<Map<String, Object>> r2 = ((com.larus.bmhome.instruction.k) r1).ja();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.Map<kotlin.String, kotlin.Any>>");
        return r2;
    L10:
        return new MediatorLiveData(MapsKt.emptyMap());
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final Integer j() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        up8.b r1 = (up8.b) r0.next();
        if ((r1 instanceof xs8.j) == false) goto L4;
        List<up8.b> r2 = r1.f();
        if (r2 == null) goto L4;
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L4;
        if (((up8.b) r3.next()).i() != 8) goto L11;
        return 1;
    L17:
        return 0;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void k() {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L3:
        MultiSelectorWidget r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((((AbsInstructionWidget) r1) instanceof MultiSelectorWidget) == false) goto L3;
    L10:
        if ((r1 instanceof MultiSelectorWidget) == false) goto L12;
        r2 = (MultiSelectorWidget) r1;
    L12:
        if (r2 == null) goto L14;
        r2.getBinding().d.setVisibility(8);
        return;
    L14:
        FLogger.a.e("InstructionEditorViewFactory", "setMultiSelectorContentVisibility multi selector is null,can not bind multi file result");
        return;
    L8:
        r1 = null;
        goto L10
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final boolean l() {
        return ((ArrayList) this.c).isEmpty();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void m() {
        this.d.clear();
        this.c.clear();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void onViewShow() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((AbsInstructionWidget) r0.next()).Z5();
        goto L4
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void requestFocus() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((AbsInstructionWidget) r0.next()).c6();
        goto L4
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void h(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, "uri");
        Iterator<T> r0 = this.c.iterator();
    L3:
        MultiSelectorWidget r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((((AbsInstructionWidget) r1) instanceof MultiSelectorWidget) == false) goto L3;
    L10:
        if ((r1 instanceof MultiSelectorWidget) == false) goto L12;
        r2 = (MultiSelectorWidget) r1;
    L12:
        if (r2 == null) goto L14;
        r2.S5(r5);
        return;
    L14:
        FLogger.a.e("InstructionEditorViewFactory", "multi selector is null,can not bind picture result");
        return;
    L8:
        r1 = null;
        goto L10
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void i(int r5) {
        Iterator<T> r0 = this.c.iterator();
    L3:
        ConstraintLayout r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((((AbsInstructionWidget) r1) instanceof MultiSelectorWidget) == false) goto L3;
    L10:
        if ((r1 instanceof MultiSelectorWidget) == false) goto L12;
        r2 = (MultiSelectorWidget) r1;
    L12:
        if (r2 == null) goto L14;
        r2.setVisibility(r5);
        return;
    L14:
        FLogger.a.e("InstructionEditorViewFactory", "setMultiSelectorVisibility multi selector is null,can not bind multi file result");
        return;
    L8:
        r1 = null;
        goto L10
    }

    public h(r r13, d r14, Fragment r15) {
        this.a = r15;
        if (r15 == null) goto L5;
        LifecycleCoroutineScope r16 = LifecycleOwnerKt.getLifecycleScope(r15);
    L6:
        this.b = r16;
        this.c = new ArrayList();
        this.d = new ArrayList();
        if (r13 == null) goto L10;
        b.a.a(this, r13, null, null, null, null, null, r14, null, false, null, 958);
        return;
    L10:
        return;
    L5:
        r16 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void f(r r18, LinearLayout r19, c r20, ActivityResultLauncher<String> r21, ActivityResultLauncher<Intent> r22, n r23, d r24, List<Integer> r25, boolean r26, Function1<? super up8.b, Unit> r27) {
        r r1 = r18;
        List<Integer> r3 = r25;
        Intrinsics.checkNotNullParameter(r1, "instructionConf");
        Intrinsics.checkNotNullParameter(r3, "ignoreInstructionTypes");
        Fragment r5 = this.a;
        up8.b r6 = null;
        if (r5 == null) goto L5;
        Context r7 = r5.getContext();
    L6:
        if (r19 == null) goto L9;
        if (r7 != null) goto L9;
        return;
    L9:
        List r8 = r1.b;
        if (r8 != null) goto L12;
    L15:
        boolean r9 = true;
    L16:
        if (r9 == false) goto L18;
        return;
    L18:
        m();
        Iterator<T> r10 = rs8.m.b.iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        final IInstructionCreator r11 = (IInstructionCreator) r10.next();
        mg9.a.a("InstructionCollector", new rs8.k(r11));
        goto L20
    L22:
        Iterator<T> r12 = rs8.m.c.iterator();
    L24:
        if (r12.hasNext() == false) goto L27;
        final IInstructionSubCreator r13 = (IInstructionSubCreator) r12.next();
        mg9.a.a("InstructionCollector", new rs8.l(r13));
        goto L24
    L27:
        if (rs8.m.a == false) goto L43;
        Set<IInstructionCreator> r14 = rs8.m.b;
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator<T> r16 = r14.iterator();
    L30:
        if (r16.hasNext() == false) goto L35;
        Object r17 = r16.next();
        Integer r110 = Integer.valueOf(((IInstructionCreator) r17).p());
        Object r111 = r15.get(r110);
        if (r111 != null) goto L34;
        r111 = new ArrayList();
        r15.put(r110, r111);
    L34:
        ((List) r111).add(r17);
        goto L30
    L35:
        Iterator r28 = r15.entrySet().iterator();
    L37:
        if (r28.hasNext() == false) goto L43;
        Map.Entry r112 = (Map.Entry) r28.next();
        if (((List) r112.getValue()).size() <= 1) goto L37;
        throw new RuntimeException("Please find wujinwo, InstructionItemType" + ((Number) r112.getKey()).intValue() + ",contain " + ((List) r112.getValue()).size() + " times, dangerous!");
    L43:
        List r29 = r1.b;
        if (r29 == null) goto L110;
        Iterator r30 = r29.iterator();
    L47:
        if (r30.hasNext() == false) goto L126;
        final u r113 = (u) r30.next();
        final Ref.ObjectRef r114 = new Ref.ObjectRef();
        mg9.a.a("InstructionEditorViewFactory", new f(r113));
        if (CollectionsKt.contains(r3, r113.b) == true) goto L109;
        Iterator<T> r115 = rs8.m.b.iterator();
    L53:
        if (r115.hasNext() == false) goto L64;
        Object r116 = r115.next();
        int r117 = ((IInstructionCreator) r116).p();
        Integer r31 = r113.b;
        if (r31 != null) goto L58;
    L60:
        boolean r32 = false;
    L61:
        if (r32 == false) goto L53;
    L65:
        IInstructionCreator r118 = (IInstructionCreator) r116;
        if (r118 == null) goto L71;
        up8.b r33 = r118.d();
        r33.d = this.b;
        r33.e = r23;
        r33.g = r1.a;
        r33.h = r21;
        r33.i = r22;
        r114.element = r33.b(r113, r20, r24, r6);
        if (r27 == null) goto L70;
        r27.invoke(r33);
    L70:
        mg9.a.a("InstructionEditorViewFactory", new g(r113, r114));
    L72:
        a0 r4 = (a0) r114.element;
        if (r4 == null) goto L75;
        boolean r34 = Intrinsics.areEqual(r4.a, Boolean.TRUE);
    L76:
        if (r34 == false) goto L97;
        if (r33 == null) goto L78;
        if (r19 == null) goto L96;
        if (r7 == null) goto L96;
        ConstraintLayout r35 = r33.d(r7, this.a);
        r19.addView(r35);
        if (r26 == false) goto L84;
    L95:
        ((ArrayList) this.c).add(r35);
        goto L96
    L84:
        if (((ArrayList) this.c).isEmpty() == false) goto L95;
        if ((r35 instanceof MultiSelectorWidget) == false) goto L88;
        MultiSelectorWidget r119 = (MultiSelectorWidget) r35;
    L89:
        if (r119 == 0) goto L95;
        HorizontalScrollView r120 = r119.getBinding().d;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if (r121 == null) goto L94;
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r121;
        r36.topMargin = 0;
        r120.setLayoutParams(r36);
        goto L95
    L94:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L88:
        r119 = r6;
    L96:
        ((ArrayList) this.d).add(r33);
        goto L97
    L78:
        return;
    L97:
        Pair[] r2 = new Pair[3];
        a0 r37 = (a0) r114.element;
        if (r37 == null) goto L100;
        boolean r38 = Intrinsics.areEqual(r37.a, Boolean.TRUE);
    L101:
        if (r38 == false) goto L103;
        String r39 = "1";
    L104:
        r2[0] = TuplesKt.to("is_success", r39);
        a0 r40 = (a0) r114.element;
        if (r40 == null) goto L107;
        String r41 = r40.b;
    L108:
        r2[1] = TuplesKt.to("fail_reason", r41);
        r2[2] = TuplesKt.to("instruction_item_type", String.valueOf(r113.b));
        com.larus.platform.service.o.a.b("flow_instruction_decode_template", com.larus.utils.f.c(r2));
        goto L109
    L107:
        r41 = null;
        goto L108
    L103:
        r39 = TriggerSendLoading.NO_LOADING;
        goto L104
    L100:
        r38 = false;
        goto L101
    L75:
        r34 = false;
        goto L76
    L71:
        r33 = r6;
        goto L72
    L58:
        if (r117 != r31.intValue()) goto L60;
        r32 = true;
        goto L61
    L64:
        r116 = r6;
    L109:
        r1 = r18;
        r3 = r25;
        r6 = null;
        goto L47
    L126:
        return;
    L110:
        return;
    L12:
        if (r8.isEmpty() == true) goto L15;
        r9 = false;
        goto L16
    L5:
        r7 = null;
        goto L6
    }
}
