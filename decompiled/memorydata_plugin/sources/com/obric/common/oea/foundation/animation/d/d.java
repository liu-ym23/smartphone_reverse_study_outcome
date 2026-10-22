package com.obric.common.oea.foundation.animation.d;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u008a\u0001\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u00182\"\b\u0002\u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u001b2\u001e\b\u0002\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\n\u0018\u00010\u001eH\u0002J\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u0088\u0001\u0010\"\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u00182\"\b\u0002\u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u001b2\u001e\b\u0002\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\n\u0018\u00010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "", "()V", "instanceId", "", "runner", "Lcom/obric/common/oea/foundation/animation/manager/AnimatableRunner;", "stateManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimatableStateManager;", "cancelAnimation", "", "clearVelocity", "", "internalRunAnimation", "targetFps", "", "view", "Landroid/view/View;", "mode", "Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "speed", "repeatMode", "Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "animationInfos", "", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "onUpdateCallback", "Lkotlin/Function3;", "", "onEndCallback", "Lkotlin/Function2;", "", "pause", "resume", "runAnimation", "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7710a = null;
    private static final com.obric.common.oea.foundation.a.c e = null;
    private static int f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f7711b;
    private com.obric.common.oea.foundation.animation.d.a c;
    private final int d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/foundation/animation/manager/AnimationManager$Companion;", "", "()V", "TAG", "", "instanceCount", "", "sdkInit", "Lcom/obric/common/oea/foundation/util/SdkInit;", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 3})
    static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f7712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f7713b;
        final /* synthetic */ View c;
        final /* synthetic */ RunMode d;
        final /* synthetic */ float e;
        final /* synthetic */ RepeatMode f;
        final /* synthetic */ List g;
        final /* synthetic */ Function3 h;
        final /* synthetic */ Function2 i;

        b(d r3, float r4, View r5, RunMode r6, float r7, RepeatMode r8, List r9, Function3 r10, Function2 r11) {
            List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Function3 r13 = (Function3) ZeusTransformUtils.wrapperContextForParams(r10, Function3.class, "com.obric.memorydata.plugin");
            Function2 r14 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
            this.f7712a = r3;
            this.f7713b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r12;
            this.h = r13;
            this.i = r14;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.a(this.f7712a, this.f7713b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }
    }

    static {
        f7710a = new a(null);
        e = new com.obric.common.oea.foundation.a.c();
    }

    public d() {
        this.f7711b = new c();
        int r0 = f;
        f = r0 + 1;
        this.d = r0;
    }

    public static final /* synthetic */ void a(d r11, float r12, View r13, RunMode r14, float r15, RepeatMode r16, List r17, Function3 r18, Function2 r19) {
        r11.b(r12, r13, r14, r15, r16, (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r18, Function3.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r19, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void a(d r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.a(r1);
    }

    private final void b(float r21, View r22, RunMode r23, float r24, RepeatMode r25, List<? extends com.obric.common.oea.foundation.animation.a<?>> r26, Function3<? super String, Object, ? super Float, Unit> r27, Function2<? super Boolean, ? super Throwable, Unit> r28) {
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        Function3 r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r27, Function3.class, "com.obric.memorydata.plugin");
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r28, Function2.class, "com.obric.memorydata.plugin");
        com.obric.common.oea.foundation.a.b r8 = com.obric.common.oea.foundation.a.b.f7661a;
        StringBuilder r9 = new StringBuilder().append("start, instanceId: [").append(this.d).append("], runAnimation, mode: ").append(r23).append(", speed: ").append(r24).append(", repeatMode: ").append(r25).append(", animationInfos: ");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.common.oea.foundation.animation.a.class, "com.obric.memorydata.plugin")).d());
        goto L4
    L6:
        r8.e("AnimationManager", r9.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).toString());
        this.f7711b.a(r21);
        this.f7711b.a(r23);
        this.f7711b.a(r25);
        this.f7711b.a(r4);
        this.f7711b.a(r22);
        this.f7711b.b(r24);
        com.obric.common.oea.foundation.animation.d.a r1 = new com.obric.common.oea.foundation.animation.d.a(this.f7711b, r6, r7);
        this.c = r1;
        if (r1 == null) goto L11;
        r1.a();
        return;
    }

    public final void a(float r15, View r16, RunMode r17, float r18, RepeatMode r19, List<? extends com.obric.common.oea.foundation.animation.a<?>> r20, Function3<? super String, Object, ? super Float, Unit> r21, Function2<? super Boolean, ? super Throwable, Unit> r22) {
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Function3<? super String, Object, ? super Float, Unit> r10 = (Function3) ZeusTransformUtils.wrapperContextForParams(r21, Function3.class, "com.obric.memorydata.plugin");
        Function2<? super Boolean, ? super Throwable, Unit> r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r22, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "mode");
        Intrinsics.checkNotNullParameter(r19, "repeatMode");
        Intrinsics.checkNotNullParameter(r0, "animationInfos");
        Looper r2 = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(r2, "Looper.getMainLooper()");
        if ((!Intrinsics.areEqual(r2.getThread(), Thread.currentThread())) == false) goto L5;
        new Handler(Looper.getMainLooper()).post((Runnable) ZeusTransformUtils.preCheckCast(new b(this, r15, r16, r17, r18, r19, r0, r10, r11), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        b(r15, r16, r17, r18, r19, r0, r10, r11);
    }

    public final void a(boolean r4) {
        com.obric.common.oea.foundation.a.b.f7661a.e("AnimationManager", "cancel, instanceId: [" + this.d + "], clearVelocity: " + r4);
        com.obric.common.oea.foundation.animation.d.a r3 = this.c;
        if (r3 == null) goto L6;
        r3.a(r4);
        return;
    }
}
