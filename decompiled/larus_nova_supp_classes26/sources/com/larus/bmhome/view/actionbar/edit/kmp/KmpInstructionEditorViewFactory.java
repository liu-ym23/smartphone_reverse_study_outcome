package com.larus.bmhome.view.actionbar.edit.kmp;

import android.content.Intent;
import android.net.Uri;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import aq8.c$d;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.platform.kmp.chat.TemplateInfo;
import com.larus.platform.service.z2;
import com.larus.uaigc.createpage.component.mediaselector.imageselector.KmpInstructionAttachmentProviderAdapter;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import cq8.a0;
import cq8.b0;
import cq8.l0;
import cq8.o0;
import cq8.u0;
import cq8.w;
import cq8.x0;
import cq8.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class KmpInstructionEditorViewFactory implements com.larus.bmhome.view.actionbar.edit.b {
    public static final /* synthetic */ int p = 0;
    public final AttachReceiver a;
    public final LifecycleCoroutineScope b;
    public final String c;
    public Job d;
    public Job e;
    public final List<AbsKmpInstructionWidget> f;
    public final Map<String, AbsKmpInstructionWidget> g;
    public LinearLayout h;
    public String i;
    public String j;
    public com.larus.bmhome.view.actionbar.edit.n k;
    public com.larus.bmhome.view.actionbar.edit.c l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final Integer j() {
        return 0;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void m() {
        p(true);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void T1() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ConstraintLayout r1 = (AbsKmpInstructionWidget) r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r1.clearFocus();     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L4;
        FLogger.a.e("KmpInstructionEditorViewFactory", "[clearInputComponentFocus] widget=" + Reflection.getOrCreateKotlinClass(r1.getClass()).getSimpleName() + " error=" + r4.getMessage());
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void k() {
        FLogger.a.d("KmpInstructionEditorViewFactory", "[setMultiSelectorScrollViewVisibility] visibility=8 (not yet wired)");
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final boolean l() {
        return ((ArrayList) this.f).isEmpty();
    }

    public final com.larus.bmhome.instruction.kmp.a o() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl((com.larus.bmhome.instruction.kmp.a) s1a.d.a(this.a).getAbility(com.larus.bmhome.instruction.kmp.a.class));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        return (com.larus.bmhome.instruction.kmp.a) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void onViewShow() {
        FLogger.a.d("KmpInstructionEditorViewFactory", "[onViewShow] widgetCount=" + ((ArrayList) this.f).size());
    }

    public final wp8.c q() {
        return (wp8.c) this.n.getValue();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void requestFocus() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ConstraintLayout r1 = (AbsKmpInstructionWidget) r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Boolean.valueOf(r1.requestFocus()));     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L4;
        FLogger.a.e("KmpInstructionEditorViewFactory", "[requestFocus] widget=" + Reflection.getOrCreateKotlinClass(r1.getClass()).getSimpleName() + " error=" + r4.getMessage());
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final Pair<Boolean, Boolean> F7() {
        Iterator r0 = ((b0) q().Jf(this.c).getValue()).b.iterator();
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L21;
        a0 r3 = (a0) ((y0) r0.next()).c.getValue();
        if ((r3 instanceof u0) == true) goto L8;
        if ((r3 instanceof x0) == true) goto L13;
        if ((r3 instanceof cq8.m) == false) goto L4;
        if (((cq8.m) r3).l == false) goto L4;
        r2 = true;
        goto L4
    L13:
        if (((x0) r3).g == false) goto L4;
    L9:
        r1 = true;
        goto L4
    L8:
        if (((u0) r3).g == false) goto L4;
    L21:
        return new Pair(Boolean.valueOf(r1), Boolean.valueOf(r2));
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final boolean a() {
        aq8.f r0 = q().ki(new aq8.c.g(this.c));
        Boolean r2 = null;
        if ((r0 instanceof aq8.f.c) == false) goto L5;
        aq8.f.c r1 = (aq8.f.c) r0;
    L6:
        if (r1 == null) goto L8;
        Object r3 = r1.a;
    L10:
        if ((r3 instanceof Boolean) == false) goto L12;
        r2 = (Boolean) r3;
    L12:
        if (r2 != null) goto L16;
        return true;
    L16:
        return r2.booleanValue();
    L8:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final List<u> b() {
        aq8.f r0 = q().ki(new aq8.c.b(this.c));
        List<u> r2 = null;
        if ((r0 instanceof aq8.f.c) == false) goto L5;
        aq8.f.c r1 = (aq8.f.c) r0;
    L6:
        if (r1 == null) goto L8;
        Object r3 = r1.a;
    L10:
        if ((r3 instanceof List) == false) goto L12;
        r2 = (List) r3;
    L12:
        if (r2 == null) goto L14;
        return r2;
    L14:
        return CollectionsKt.emptyList();
    L8:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final List<u> c() {
        aq8.f r0 = q().ki(new aq8.c.b(this.c));
        List<u> r2 = null;
        if ((r0 instanceof aq8.f.c) == false) goto L5;
        aq8.f.c r1 = (aq8.f.c) r0;
    L6:
        if (r1 == null) goto L8;
        Object r3 = r1.a;
    L10:
        if ((r3 instanceof List) == false) goto L12;
        r2 = (List) r3;
    L12:
        if (r2 == null) goto L14;
        return r2;
    L14:
        return CollectionsKt.emptyList();
    L8:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final Long d() {
        Iterator r0 = ((b0) q().Jf(this.c).getValue()).b.iterator();
    L3:
        Long r2 = null;
        if (r0.hasNext() == false) goto L22;
        a0 r1 = (a0) ((y0) r0.next()).c.getValue();
        if ((r1 instanceof o0) == true) goto L7;
        if ((r1 instanceof w) == false) goto L3;
        TemplateInfo.TemplateInfo r3 = ((w) r1).k;
        if (r3 == null) goto L19;
        r2 = Long.valueOf(r3.a);
    L19:
        if (r2 == null) goto L3;
        if (r2.longValue() == 0) goto L3;
    L7:
        bq8.a r4 = ((o0) r1).j;
        if (r4 == null) goto L10;
        r2 = Long.valueOf(r4.a);
    L10:
        if (r2 == null) goto L3;
        if (r2.longValue() == 0) goto L3;
        return r2;
    L22:
        return r2;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final List<u> e() {
        aq8.f r0 = q().ki(new aq8.c.b(this.c));
        List r2 = null;
        if ((r0 instanceof aq8.f.c) == false) goto L5;
        aq8.f.c r1 = (aq8.f.c) r0;
    L6:
        if (r1 == null) goto L8;
        Object r3 = r1.a;
    L10:
        if ((r3 instanceof List) == false) goto L12;
        r2 = (List) r3;
    L12:
        if (r2 == null) goto L14;
        z2 r4 = z2.a;
        boolean r5 = r4.T();
        boolean r6 = r4.L();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r2.iterator();
    L17:
        if (r8.hasNext() == false) goto L35;
        Object r9 = r8.next();
        u r10 = (u) r9;
        boolean r11 = true;
        if (r5 == false) goto L25;
        Integer r12 = r10.a;
        if (r12 == null) goto L25;
        if (r12.intValue() != 1) goto L25;
    L33:
        if (r11 == false) goto L17;
        r7.add(r9);
    L25:
        if (r6 == false) goto L32;
        Integer r13 = r10.a;
        if (r13 == null) goto L32;
        if (r13.intValue() == 2) goto L33;
    L32:
        r11 = false;
        goto L33
    L35:
        return r7;
    L14:
        return CollectionsKt.emptyList();
    L8:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final LiveData<Map<String, Object>> g() {
        com.larus.bmhome.instruction.kmp.a r0 = o();
        if (r0 == null) goto L7;
        MediatorLiveData r1 = r0.p30();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new MediatorLiveData(MapsKt.emptyMap());
    }

    public static final y n(KmpInstructionEditorViewFactory r1) {
        return s1a.d.a(r1.a).getAbility(y.class);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void h(Uri r4) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        FLogger.a.i("KmpInstructionEditorViewFactory", "[bindPickPictureResult] uri=" + r4 + ", widgetCount=" + ((ArrayList) this.f).size());
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void i(int r4) {
        Iterator r0 = ((b0) q().Jf(this.c).getValue()).b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        y0 r1 = (y0) r0.next();
        if ((r1.c.getValue() instanceof l0) == false) goto L4;
        Map<String, AbsKmpInstructionWidget> r2 = this.g;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        ConstraintLayout r5 = (AbsKmpInstructionWidget) r3.get(r1.a);
    L9:
        if (r5 == null) goto L11;
        r5.setVisibility(r4);
        return;
    L11:
        FLogger.a.e("KmpInstructionEditorViewFactory", "[setMultiSelectorVisibility] no MultiSelector widget found");
        return;
    L8:
        r5 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(boolean r6) {
        LinearLayout r0 = this.h;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        Iterator<T> r1 = this.f.iterator();
    L7:
        if (r1.hasNext() == false) goto L17;
        AbsKmpInstructionWidget r2 = (AbsKmpInstructionWidget) r1.next();
        Job r4 = r2.a;
        if (r4 == null) goto L11;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L11:
        r2.a = null;
        r2.b = null;
        if ((r2 instanceof com.larus.bmhome.instruction.kmp.b) == false) goto L14;
        com.larus.bmhome.instruction.kmp.b r3 = (com.larus.bmhome.instruction.kmp.b) r2;
    L15:
        if (r3 == null) goto L7;
        r3.L4(null);
        goto L7
    L14:
        r3 = null;
        goto L15
    L17:
        ((ArrayList) this.f).clear();
        ((LinkedHashMap) this.g).clear();
        this.j = null;
        Job r5 = this.e;
        if (r5 == null) goto L20;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L20:
        if (r6 == false) goto L41;
        n r7 = n.a;
        com.larus.bmhome.view.actionbar.edit.n r8 = this.k;
        monitor-enter(r7);
        if (r8 != null) goto L34;
    L31:
        monitor-exit(r7);
        this.k = null;
        return;
    L34:
    L28:
        th = move-exception;
        throw th;
    L25:
        if (n.b != r8) goto L31;
        n.b = null;     // Catch: Throwable -> L28
        goto L31
    }

    public KmpInstructionEditorViewFactory(AttachReceiver r13, r r14, com.larus.bmhome.view.actionbar.edit.d r15) {
        Intrinsics.checkNotNullParameter(r13, "attachReceiver");
        this.a = r13;
        this.b = LifecycleOwnerKt.getLifecycleScope(r13);
        this.c = com.flow.kmp.common.util.i.a();
        this.f = new ArrayList();
        this.g = new LinkedHashMap();
        this.m = LazyKt.lazy(new g(this));
        this.n = LazyKt.lazy(new h(this));
        this.o = LazyKt.lazy(new i(this));
        if (r14 == null) goto L6;
        com.larus.bmhome.view.actionbar.edit.b.a.a(this, r14, null, null, null, null, null, r15, null, false, null, 958);
        return;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.b
    public final void f(r r13, LinearLayout r14, com.larus.bmhome.view.actionbar.edit.c r15, ActivityResultLauncher<String> r16, ActivityResultLauncher<Intent> r17, com.larus.bmhome.view.actionbar.edit.n r18, com.larus.bmhome.view.actionbar.edit.d r19, List<Integer> r20, boolean r21, Function1<? super up8.b, Unit> r22) {
        Intrinsics.checkNotNullParameter(r13, "instructionConf");
        Intrinsics.checkNotNullParameter(r20, "ignoreInstructionTypes");
        List r0 = r13.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        p(true);
        m r7 = new m(this, r15);
        l r8 = new l(r15, this);
        r r9 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        com.larus.bmhome.instruction.kmp.a r3 = (com.larus.bmhome.instruction.kmp.a) s1a.d.a(this.a).getAbility(com.larus.bmhome.instruction.kmp.a.class);     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        KmpInstructionAttachmentProviderAdapter r4 = r3.oy();     // Catch: Throwable -> L18
    L16:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r5) == false) goto L23;
        r5 = null;
    L23:
        dq8.c r6 = (dq8.f) r5;
        if (r6 != null) goto L26;
        r6 = dq8.c.a;
    L26:
        q().sl(new aq8.d(r7, r8, r6));
        this.k = r18;
        this.l = r15;
        n r10 = n.a;
        monitor-enter(r10);
        n.b = r18;     // Catch: Throwable -> L58
        monitor-exit(r10);
        h1 r11 = r13.c;
        if (r11 == null) goto L33;
        String r12 = r11.a;
    L34:
        this.i = r12;
        this.j = null;
        this.h = r14;
        if (r14 == null) goto L40;
        Job r23 = this.d;
        if (r23 == null) goto L39;
        Job.DefaultImpls.cancel$default(r23, null, 1, null);
    L39:
        this.d = BuildersKt.launch$default(this.b, Dispatchers.getMain(), null, new KmpInstructionEditorViewFactory$observeInstructionWidgetRenderModel$1(this, r14, null), 2, null);
    L40:
        Job r24 = this.e;
        if (r24 == null) goto L43;
        Job.DefaultImpls.cancel$default(r24, null, 1, null);
    L43:
        if (r15 == null) goto L46;
        this.e = BuildersKt.launch$default(this.b, Dispatchers.getMain(), null, new KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1(r15, this, null), 2, null);
    L46:
        wp8.c r25 = q();
        String r26 = this.c;
        if (r15 == null) goto L49;
        r r27 = r15.getInstructionRebuildStateConf();
    L50:
        if (r15 == null) goto L52;
        r9 = r15.getCurrentInstructionUsuallyConfig();
    L52:
        r25.ki(new c$d(r13, r26, r27, r9));
        if (r15 == null) goto L66;
        t1 r28 = r15.getOptionParamFilterConf();
        if (r28 == null) goto L67;
        q().ki(new aq8.c.e(r28, true, this.c));
        return;
    L67:
        return;
    L66:
        return;
    L49:
        r27 = null;
        goto L50
    L33:
        r12 = null;
    L58:
        th = move-exception;
        throw th;
    L15:
        r4 = null;
    L18:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
