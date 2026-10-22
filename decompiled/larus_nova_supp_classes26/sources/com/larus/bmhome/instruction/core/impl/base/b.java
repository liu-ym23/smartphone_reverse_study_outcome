package com.larus.bmhome.instruction.core.impl.base;

import com.larus.bmhome.actionbar.model.u;
import com.larus.im.internal.delegate.c0;
import cq8.a0;
import cq8.q0;
import cq8.y;
import cq8.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b implements e {
    public final String a;
    public u b;
    public c c;
    public e d;
    public Function1<? super y, Unit> e;
    public final List<e> f;
    public CoroutineScope g;
    public Integer h;
    public final StateFlowImpl i;
    public final b1 j;
    public final MutableSharedFlow<d> k;
    public final a1 l;
    public final MutableSharedFlow<k> m;
    public final a1 n;
    public final C0015b o;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.bmhome.instruction.core.impl.base.b$b, reason: collision with other inner class name */
    public static final class C0015b implements z {
        public final /* synthetic */ b a;

        public C0015b(b r1) {
            this.a = r1;
        }

        @Override // cq8.z
        public final void a(y r2) {
            Intrinsics.checkNotNullParameter(r2, "action");
            this.a.e.invoke(r2);
        }
    }

    static {
    }

    public List<u> c() {
        return null;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public abstract /* synthetic */ int getType();

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public void h(Integer r1) {
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public void i(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "defaultStateTemplate");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public void l(Map<String, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "instructionDefaultParams");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public void m(y r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
    }

    public void onEvent(d r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public a0 d() {
        return new q0(getWidgetId(), this.o);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String getWidgetId() {
        return this.a + '#' + hashCode();
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final void j() {
        a0 r0 = d();
        c0.b.i("AbsInstructionController", "[emitDescriptor] from:" + this.a + ", descriptor:" + r0.a + ", version:" + r0.a());
        this.i.setValue(r0);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String f() {
        return this.a;
    }

    public b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "logName");
        this.a = r4;
        this.e = new com.larus.bmhome.instruction.core.impl.base.a();
        this.f = new ArrayList();
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        StateFlowImpl r0 = j1.a(null);
        this.i = r0;
        this.j = kotlinx.coroutines.flow.e.b(r0);
        MutableSharedFlow<d> r1 = SharedFlowKt.MutableSharedFlow$default(0, 8, null, 5, null);
        this.k = r1;
        this.l = kotlinx.coroutines.flow.e.a(r1);
        MutableSharedFlow<k> r5 = SharedFlowKt.MutableSharedFlow$default(0, 16, null, 5, null);
        this.m = r5;
        this.n = kotlinx.coroutines.flow.e.a(r5);
        this.o = new C0015b(this);
    }

    public final void e(d r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        c0.b.i("AbsInstructionController", "[emitControllerEvent] from:" + this.a + ", event:" + r4.a + ", sourceWidgetId:" + r4.a());
        this.k.tryEmit(r4);
    }

    public final void o(k r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        c0.b.i("AbsInstructionController", "[emitToHostEvent] from:" + this.a + ", event:" + r4.a);
        this.m.tryEmit(r4);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 k(u r2, c r3, Function1<? super y, Unit> r4, e r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "controllerContext");
        Intrinsics.checkNotNullParameter(r4, "dispatcher");
        this.b = r2;
        this.c = r3;
        this.g = r3.b;
        this.d = r5;
        this.e = r4;
        if (r6 != null) goto L8;
        if (r2 == null) goto L6;
        r6 = r2.d;
        goto L8
    L6:
        r6 = null;
    L8:
        return n(r6);
    }
}
