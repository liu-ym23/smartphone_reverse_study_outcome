package com.obric.memorydata.ui.settingsharness;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010 \u001a\u00020\u0016H\u0007J(\u0010!\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\"\u0010&\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\"\u0010*\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0018\u0010+\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0013H\u0002J\b\u0010-\u001a\u00020\u0016H\u0002J\b\u0010.\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsPageHarness;", "", "rejectionPresenter", "Lcom/obric/memorydata/ui/settingsharness/SettingsRejectionPresenter;", "<init>", "(Lcom/obric/memorydata/ui/settingsharness/SettingsRejectionPresenter;)V", "actionCoordinator", "Lcom/obric/memorydata/ui/settingsharness/SettingsActionCoordinator;", "mainHandler", "Landroid/os/Handler;", "binding", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageViewBinding;", "stateJob", "Lkotlinx/coroutines/Job;", "actionJobs", "", "", "authoritativeStates", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageState;", "latestState", "bind", "", "root", "Landroid/view/View;", "spec", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageBindingSpec;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "states", "handler", "Lcom/obric/memorydata/ui/settingsharness/SettingsActionHandler;", "unbind", "dispatch", "expectedGeneration", "", "action", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction;", "completeAction", "rowId", "result", "Lcom/obric/memorydata/ui/settingsharness/SettingsMutationResult;", "finishAction", "renderState", "state", "renderLatestState", "checkMainThread", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f13040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f13041b;
    private final Handler c;
    private j d;
    private bx e;
    private final Map<String, bx> f;
    private ar<i> g;
    private i h;

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public h(l r3) {
        l r4 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rejectionPresenter");
        this.f13040a = r4;
        this.f13041b = new c();
        this.c = new Handler(Looper.getMainLooper());
        this.f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ h(l r2, int r3, DefaultConstructorMarker r4) {
        l r5 = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (l) ZeusTransformUtils.preCheckCast(a.f13027a, l.class, "com.obric.memorydata.plugin");
    L5:
        this(r5);
    }

    private static final Unit a(h r1, long r2, b r4, AtomicReference r5, Throwable r6) {
        r1.a(r2, ((b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin")).a(), (f) ZeusTransformUtils.preCheckCast(r5.get(), f.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit a(h r8, al r9, d r10, long r11, b r13) {
        al r3 = (al) ZeusTransformUtils.wrapperContextForParams(r9, al.class, "com.obric.memorydata.plugin");
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.memorydata.plugin");
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r13, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "action");
        r8.a(r3, r4, r11, r7);
        return Unit.INSTANCE;
    }

    private final void a(long r2, i r4) {
        if (this.f13041b.a(r2) == true) goto L5;
        return;
    L5:
        this.h = r4;
        j r3 = this.d;
        if (r3 == null) goto L9;
        r3.a(r4, this.f13041b.c());
        return;
    }

    private final void a(final long r8, final String r10, f r11) {
        final f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r11, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        b(r8, r10, r5);
        return;
    L5:
        this.c.post(new $$Lambda$h$Chk_rLYEutBXkGyprvdjbqImzU8(this, r8, r10, r5));
    }

    public static final /* synthetic */ void a(h r0, long r1, i r3) {
        r0.a(r1, r3);
    }

    private static final void a(h r2, long r3, String r5, f r6) {
        r2.b(r3, r5, (f) ZeusTransformUtils.wrapperContextForParams(r6, f.class, "com.obric.memorydata.plugin"));
    }

    private final void a(al r10, d r11, final long r12, b r14) {
        al r2 = (al) ZeusTransformUtils.wrapperContextForParams(r10, al.class, "com.obric.memorydata.plugin");
        d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.memorydata.plugin");
        final b r15 = (b) ZeusTransformUtils.wrapperContextForParams(r14, b.class, "com.obric.memorydata.plugin");
        i r16 = this.h;
        if (r16 != null) goto L6;
        return;
    L6:
        if (this.f13041b.a(r12, r15, r16) == false) goto L8;
        b();
        final AtomicReference r8 = new AtomicReference();
        bx r17 = kotlinx.coroutines.i.a(r2, null, CoroutineStart.LAZY, (Function2) ZeusTransformUtils.preCheckCast(new SettingsPageHarness$dispatch$job$1(r8, r13, r15, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        this.f.put(r15.a(), r17);
        r17.a(new $$Lambda$h$eRX1wSIsx0IOEhIixijpl9a50(this, r12, r15, r8));
        r17.s_();
        return;
    L8:
        if (this.f13041b.a(r12) == false) goto L13;
        b();
        return;
    }

    private final void b() {
        i r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        j r1 = this.d;
        if (r1 == null) goto L9;
        r1.a(r0, this.f13041b.c());
        return;
    }

    private final void b(long r3, String r5, f r6) {
        f r7 = (f) ZeusTransformUtils.wrapperContextForParams(r6, f.class, "com.obric.memorydata.plugin");
        if (this.f13041b.a(r3, r5) == true) goto L5;
        return;
    L5:
        this.f.remove(r5);
        ar<i> r4 = this.g;
        if (r4 == null) goto L9;
        i r8 = (i) ZeusTransformUtils.preCheckCast(r4.c(), i.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L9;
    L10:
        this.h = r8;
        b();
        if (ZeusTransformUtils.instanceOf(r7, f.b.class) == false) goto L16;
        j r9 = this.d;
        if (r9 == null) goto L17;
        this.f13040a.a(r9.a(), ((f.b) ZeusTransformUtils.preCheckCast(r7, f.b.class, "com.obric.memorydata.plugin")).a());
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r8 = this.h;
        goto L10
    }

    private final void c() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("SettingsPageHarness must be accessed from the main thread".toString());
    }

    public static /* synthetic */ void lambda$Chk_rLYEutBXkGyprvdjbqImzU8(h r0, long r1, String r3, f r4) {
        a(r0, r1, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$eRX1wSI-sx0IOEhIixijpl-9a50, reason: not valid java name */
    public static /* synthetic */ Unit m1222lambda$eRX1wSIsx0IOEhIixijpl9a50(h r0, long r1, b r3, AtomicReference r4, Throwable r5) {
        return a(r0, r1, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$zuOzdjOnEbmrGZAY-gtLDyIlPPU, reason: not valid java name */
    public static /* synthetic */ Unit m1223lambda$zuOzdjOnEbmrGZAYgtLDyIlPPU(h r0, al r1, d r2, long r3, b r5) {
        return a(r0, r1, r2, r3, r5);
    }

    public final void a() {
        c();
        this.f13041b.b();
        bx r0 = this.e;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.e = null;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        bx.a.a((bx) ZeusTransformUtils.preCheckCast(r1.next(), bx.class, "com.obric.memorydata.plugin"), null, 1, null);
        goto L7
    L9:
        this.f.clear();
        this.g = null;
        this.h = null;
        j r2 = this.d;
        if (r2 == null) goto L12;
        r2.b();
    L12:
        this.d = null;
    }

    public final void a(View r11, g r12, al r13, ar<i> r14, d r15) {
        final al r16 = (al) ZeusTransformUtils.wrapperContextForParams(r13, al.class, "com.obric.memorydata.plugin");
        ar<i> r17 = (ar) ZeusTransformUtils.wrapperContextForParams(r14, ar.class, "com.obric.memorydata.plugin");
        final d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r15, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "root");
        Intrinsics.checkNotNullParameter(r12, "spec");
        Intrinsics.checkNotNullParameter(r16, "scope");
        Intrinsics.checkNotNullParameter(r17, "states");
        Intrinsics.checkNotNullParameter(r5, "handler");
        c();
        if (this.d != null) goto L5;
        boolean r18 = true;
    L6:
        if (r18 == false) goto L14;
        if (am.a(r16) == false) goto L12;
        j r19 = j.f13043a.a(r11, r12);
        r19.a((i) ZeusTransformUtils.preCheckCast(r17.c(), i.class, "com.obric.memorydata.plugin"), new k(null, null, 3, null));
        final long r8 = this.f13041b.a();
        this.d = r19;
        this.g = r17;
        this.h = (i) ZeusTransformUtils.preCheckCast(r17.c(), i.class, "com.obric.memorydata.plugin");
        r19.a(new $$Lambda$h$zuOzdjOnEbmrGZAYgtLDyIlPPU(this, r16, r5, r8));
        this.e = kotlinx.coroutines.i.a(r16, null, null, (Function2) ZeusTransformUtils.preCheckCast(new SettingsPageHarness$bind$4(r17, this, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L12:
        throw new IllegalArgumentException("SettingsPageHarness requires an active CoroutineScope".toString());
    L14:
        throw new IllegalStateException("SettingsPageHarness is already bound; call unbind() first".toString());
    L5:
        r18 = false;
        goto L6
    }
}
