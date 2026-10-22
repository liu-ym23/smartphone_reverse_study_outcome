package com.obric.common.oea.foundation.animation.d;

import android.view.Choreographer;
import android.view.View;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0013\u0018\u0000 &2\u00020\u0001:\u0001&Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012:\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u000bJ\u0012\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u000bH\u0002J6\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0006\u0010%\u001a\u00020\bR\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/common/oea/foundation/animation/manager/AnimatableRunner;", "", "stateManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimatableStateManager;", "onUpdateCallback", "Lkotlin/Function3;", "", "", "", "onEndCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "finished", "", "e", "(Lcom/obric/common/oea/foundation/animation/manager/AnimatableStateManager;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "frameCallback", "com/obric/common/oea/foundation/animation/manager/AnimatableRunner$frameCallback$1", "Lcom/obric/common/oea/foundation/animation/manager/AnimatableRunner$frameCallback$1;", "cancelAnimation", "clearVelocity", "endAnimationInternal", "executeAnimation", MemoryInfoSectionEditActivity.KIND_SCENE, "playTimeNanos", "", "animationInfo", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "frameTimeNanos", "notifyWhenFinished", "releaseCallbacks", "resetAnimation", "shouldReverse", "runParallelAnimations", "runSequentialAnimations", "startAnimation", "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0375a f7703a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f7704b;
    private final c c;
    private Function3<? super String, Object, ? super Float, Unit> d;
    private Function2<? super Boolean, ? super Throwable, Unit> e;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.d.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/foundation/animation/manager/AnimatableRunner$Companion;", "", "()V", "TAG", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0375a {
        private C0375a() {
        }

        public /* synthetic */ C0375a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/common/oea/foundation/animation/manager/AnimatableRunner$frameCallback$1", "Landroid/view/Choreographer$FrameCallback;", "doFrame", "", "frameTimeNanos", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f7705a;

        b(a r1) {
            this.f7705a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long r9) {
            if (a.a(this.f7705a).a() == false) goto L9;
            if (a.a(this.f7705a).d() != null) goto L9;
            com.obric.common.oea.foundation.a.b.f7661a.c("AnimatableRunner", "doFrame, view is null");
            return;
        L9:
            if (a.a(this.f7705a).i() != 0) goto L12;
            a.a(this.f7705a).a(r9);
        L12:
            if (a.a(this.f7705a).j() == 0) goto L14;
            a.a(this.f7705a).j();
        L14:
            a.a(this.f7705a).b(r9);
            if (a.a(this.f7705a).b() == false) goto L20;
            if (a.a(this.f7705a).k() != 0) goto L40;
            a.a(this.f7705a).c(r9);
            return;
        L40:
            return;
        L20:
            if (a.a(this.f7705a).k() <= 0) goto L22;
            long r2 = r9 - a.a(this.f7705a).k();
            a.a(this.f7705a).d(a.a(this.f7705a).l() + r2);
            a.a(this.f7705a).c(0);
        L22:
            long r3 = (r9 - a.a(this.f7705a).i()) - a.a(this.f7705a).l();
            RunMode r0 = a.a(this.f7705a).e();
            int r1 = com.obric.common.oea.foundation.animation.d.b.f7706a[r0.ordinal()];
            if (r1 == 1) goto L27;
            if (r1 != 2) goto L29;
            a.b(this.f7705a, r3, r9);
        L29:
            if (a.a(this.f7705a).c() == false) goto L31;
        L30:
            Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this, Choreographer.FrameCallback.class, "com.obric.memorydata.plugin"));
            return;
        L31:
            Choreographer.getInstance().removeFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this, Choreographer.FrameCallback.class, "com.obric.memorydata.plugin"));
            RepeatMode r10 = a.a(this.f7705a).f();
            int r11 = com.obric.common.oea.foundation.animation.d.b.f7707b[r10.ordinal()];
            if (r11 == 1) goto L39;
            if (r11 != 2) goto L35;
            com.obric.common.oea.foundation.a.b.f7661a.c("AnimatableRunner", "doFrame, 触发 reverse");
            a.a(this.f7705a).a(CollectionsKt.reversed((Iterable) ZeusTransformUtils.preCheckCast(a.a(this.f7705a).g(), Iterable.class, "com.obric.memorydata.plugin")));
            a.a(this.f7705a, true);
            goto L30
        L35:
            if (r11 != 3) goto L44;
            a.b(this.f7705a, true);
            return;
        L44:
            return;
        L39:
            com.obric.common.oea.foundation.a.b.f7661a.c("AnimatableRunner", "doFrame, 触发 loop");
            a.a(this.f7705a, false);
            goto L30
        L27:
            a.a(this.f7705a, r3, r9);
            goto L29
        }
    }

    static {
        f7703a = new C0375a(null);
    }

    public a(c r3, Function3<? super String, Object, ? super Float, Unit> r4, Function2<? super Boolean, ? super Throwable, Unit> r5) {
        Function3<? super String, Object, ? super Float, Unit> r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Function2<? super Boolean, ? super Throwable, Unit> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "stateManager");
        this.c = r3;
        this.d = r6;
        this.e = r7;
        this.f7704b = new b(this);
    }

    public static final /* synthetic */ c a(a r0) {
        return r0.c;
    }

    private final void a(long r17, long r19) {
        List<com.obric.common.oea.foundation.animation.a<?>> r9 = this.c.g();
        int r1 = 0;
        if (r9.size() <= 1) goto L14;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if (((com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r4, com.obric.common.oea.foundation.animation.a.class, "com.obric.memorydata.plugin")).c() == false) goto L6;
        r2.add(r4);
        goto L6
    L11:
        if (((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin")).size() == 1) goto L14;
        boolean r12 = false;
    L15:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r14 = 0;
    L17:
        if (r13.hasNext() == false) goto L27;
        Object r5 = r13.next();
        int r15 = r1 + 1;
        if (r1 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        com.obric.common.oea.foundation.animation.a<?> r6 = (com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r5, com.obric.common.oea.foundation.animation.a.class, "com.obric.memorydata.plugin");
        if (r6.c() == true) goto L24;
    L25:
        r14 = r14 + 1;
    L26:
        r1 = r15;
        goto L17
    L24:
        if (a("runParallelAnimations", r17, r6, r19, r12) == false) goto L26;
    L27:
        if (r12 == false) goto L29;
        return;
    L29:
        if (r14 != r9.size()) goto L43;
        com.obric.common.oea.foundation.a.b.f7661a.b("AnimatableRunner", "runParallelAnimations, all finished");
        Function2<? super Boolean, ? super Throwable, Unit> r7 = this.e;
        if (r7 == null) goto L44;
        Unit r8 = (Unit) ZeusTransformUtils.preCheckCast(r7.invoke(true, null), Unit.class, "com.obric.memorydata.plugin");
        return;
    L44:
        return;
    L43:
        return;
    L14:
        r12 = true;
        goto L15
    }

    public static final /* synthetic */ void a(a r0, long r1, long r3) {
        r0.a(r1, r3);
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.b(r1);
    }

    private final void a(String r4) {
        com.obric.common.oea.foundation.a.b.f7661a.b("AnimatableRunner", "releaseCallbacks, scene: " + r4);
        this.d = (Function3) ZeusTransformUtils.preCheckCast(null, Function3.class, "com.obric.memorydata.plugin");
        this.e = (Function2) ZeusTransformUtils.preCheckCast(null, Function2.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ boolean a(a r9, String r10, long r11, com.obric.common.oea.foundation.animation.a r13, long r14, boolean r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        boolean r8 = true;
    L7:
        return r9.a(r10, r11, r13, r14, r8);
    L5:
        r8 = r16;
        goto L7
    }

    private final boolean a(String r7, long r8, com.obric.common.oea.foundation.animation.a<?> r10, long r11, boolean r13) {
        long r9 = (long) (r8 * this.c.h());
        Object r0 = r10.c(r9);
        View r1 = this.c.d();
        if (r10.b() != (-1)) goto L5;
        r10.a(r11);
    L5:
        boolean r2 = r10.e(r9);
        if (r1 == null) goto L12;
        String r3 = r10.e();
        if (r2 == false) goto L10;
        Object r4 = r10.g();
    L11:
        h.a(r1, r3, r4);
        goto L12
    L10:
        r4 = r0;
    L12:
        r10.b(r11);
        r10.a(!r2);
        float r12 = r10.d(r9);
        if (r2 == true) goto L15;
        Function3<? super String, Object, ? super Float, Unit> r6 = this.d;
        if (r6 == null) goto L27;
        Unit r14 = r6.invoke(r10.e(), r0, Float.valueOf(r12));
    L26:
        Unit r15 = (Unit) ZeusTransformUtils.preCheckCast(r14, Unit.class, "com.obric.memorydata.plugin");
    L27:
        return r2;
    L15:
        if (r13 == false) goto L22;
        com.obric.common.oea.foundation.a.b.f7661a.c("AnimatableRunner", "executeAnimation, " + r7 + ", return case 1, property: " + r10.e() + ", targetValue: " + r10.g());
        Function3<? super String, Object, ? super Float, Unit> r16 = this.d;
        if (r16 == null) goto L19;
        Unit r17 = (Unit) ZeusTransformUtils.preCheckCast(r16.invoke(r10.e(), r10.g(), Float.valueOf(r12)), Unit.class, "com.obric.memorydata.plugin");
    L19:
        Function2<? super Boolean, ? super Throwable, Unit> r18 = this.e;
        if (r18 == null) goto L27;
        r14 = r18.invoke(true, null);
        goto L26
    L22:
        com.obric.common.oea.foundation.a.b.f7661a.c("AnimatableRunner", "executeAnimation, " + r7 + ", return case 2, property: " + r10.e() + ", targetValue: " + r10.g());
        goto L27
    }

    private final void b(long r12, long r14) {
        if (this.c.m() != (-1)) goto L6;
        this.c.a(0);
    L6:
        if (this.c.m() < this.c.g().size()) goto L9;
        com.obric.common.oea.foundation.a.b.f7661a.b("AnimatableRunner", "runSequentialAnimations, return case 1");
        return;
    L9:
        long r0 = (long) (r12 * this.c.h());
        com.obric.common.oea.foundation.animation.a<?> r4 = (com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(this.c.g().get(this.c.m()), com.obric.common.oea.foundation.animation.a.class, "com.obric.memorydata.plugin");
        boolean r1 = r4.e(r0);
        r4.a(!r1);
        boolean r7 = false;
        if (r1 == false) goto L18;
        a("runSequentialAnimations 1", r12, r4, r14, false);
        c r2 = this.c;
        r2.a(r2.m() + 1);
        if (this.c.m() < this.c.g().size()) goto L17;
        com.obric.common.oea.foundation.a.b.f7661a.b("AnimatableRunner", "runSequentialAnimations, return case 2");
        Function2<? super Boolean, ? super Throwable, Unit> r3 = this.e;
        if (r3 == null) goto L21;
        Unit r5 = (Unit) ZeusTransformUtils.preCheckCast(r3.invoke(true, null), Unit.class, "com.obric.memorydata.plugin");
        return;
    L21:
        return;
    L17:
        this.c.a(0);
        this.c.c(0);
        this.c.d(0);
        this.c.b(0);
        long r6 = 0;
        r4 = (com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(this.c.g().get(this.c.m()), com.obric.common.oea.foundation.animation.a.class, "com.obric.memorydata.plugin");
        r7 = false;
        int r9 = 16;
        Object r10 = null;
        String r8 = "runSequentialAnimations 2";
    L19:
        a(this, r8, r6, r4, r14, r7, r9, r10);
        return;
    L18:
        r9 = 16;
        r10 = null;
        r8 = "runSequentialAnimations 3";
        r6 = r12;
        goto L19
    }

    public static final /* synthetic */ void b(a r0, long r1, long r3) {
        r0.b(r1, r3);
    }

    public static final /* synthetic */ void b(a r0, boolean r1) {
        r0.c(r1);
    }

    private final void b(boolean r7) {
        View r0 = this.c.d();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c.g(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        com.obric.common.oea.foundation.animation.a r2 = (com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.common.oea.foundation.animation.a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        String r4 = r2.e();
        if (r7 == false) goto L10;
        Object r5 = r2.g();
    L11:
        h.a(r0, r4, r5);
        goto L12
    L10:
        r5 = r2.f();
    L12:
        r2.a(true, r7, true);
        goto L4
    L13:
        this.c.a(0);
        this.c.c(0);
        this.c.d(0);
        this.c.b(0);
        this.c.a(-1);
    }

    private final void c(boolean r5) {
        com.obric.common.oea.foundation.a.b.f7661a.c("AnimatableRunner", "endAnimationInternal, clearVelocity: " + r5);
        Choreographer.getInstance().removeFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this.f7704b, Choreographer.FrameCallback.class, "com.obric.memorydata.plugin"));
        this.c.a(r5);
        a("endAnimationInternal");
    }

    public final void a() {
        Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this.f7704b, Choreographer.FrameCallback.class, "com.obric.memorydata.plugin"));
    }

    public final void a(boolean r5) {
        com.obric.common.oea.foundation.a.b.f7661a.c("AnimatableRunner", "cancelAnimation, clearVelocity: " + r5);
        Choreographer.getInstance().removeFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this.f7704b, Choreographer.FrameCallback.class, "com.obric.memorydata.plugin"));
        this.c.a(r5);
        Function2<? super Boolean, ? super Throwable, Unit> r6 = this.e;
        if (r6 == null) goto L5;
        Unit r7 = (Unit) ZeusTransformUtils.preCheckCast(r6.invoke(false, null), Unit.class, "com.obric.memorydata.plugin");
    L5:
        a("cancelAnimation");
    }
}
