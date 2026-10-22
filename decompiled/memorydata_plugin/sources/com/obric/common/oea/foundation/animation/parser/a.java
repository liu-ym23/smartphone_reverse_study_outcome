package com.obric.common.oea.foundation.animation.parser;

import android.view.View;
import com.obric.common.oea.foundation.animation.b;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.d.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u008c\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00112\"\b\u0002\u0010\u0013\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0003J\u0018\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00122\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J\u008c\u0001\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u00112\"\b\u0002\u0010\u0013\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u001e\b\u0002\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/common/oea/foundation/animation/parser/AnimatableSubmitter;", "", "()V", "TAG", "", "animate", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "targetFps", "", "view", "Landroid/view/View;", "mode", "Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "speed", "repeatMode", "Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "animationInfos", "", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "onUpdateCallback", "Lkotlin/Function3;", "", "onEndCallback", "Lkotlin/Function2;", "", "", "convertToAnimatedPropertyInfo", "command", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "parseAndExecute", "animationCommands", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7717a = null;

    static {
        f7717a = new a();
    }

    private a() {
    }

    private final com.obric.common.oea.foundation.animation.a<?> a(com.obric.common.oea.foundation.animation.b.a<?> r1) {
        return r1.a();
    }

    private final d b(float r13, View r14, RunMode r15, float r16, RepeatMode r17, List<? extends com.obric.common.oea.foundation.animation.a<?>> r18, Function3<? super String, Object, ? super Float, Unit> r19, Function2<? super Boolean, ? super Throwable, Unit> r20) {
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Function3<? super String, Object, ? super Float, Unit> r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r19, Function3.class, "com.obric.memorydata.plugin");
        final Function2 r0 = (Function2) ZeusTransformUtils.wrapperContextForParams(r20, Function2.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L15;
        com.obric.common.oea.foundation.animation.a<?> r3 = b.f7673a.a(r14);
        float r4 = 0.0f;
        if (r3 == null) goto L7;
        r4 = r3.i();
    L7:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        com.obric.common.oea.foundation.animation.a<?> r8 = (com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.common.oea.foundation.animation.a.class, "com.obric.memorydata.plugin");
        if (r8.h() != null) goto L13;
        com.obric.common.oea.foundation.a.b.f7661a.b("AnimatableSubmitter", "没指定初始速度，重设velocity " + r4);
        r8.a(Float.valueOf(r4));
    L14:
        b.f7673a.a(r14, r8);
        goto L9
    L13:
        com.obric.common.oea.foundation.a.b.f7661a.b("AnimatableSubmitter", "指定了初始速度，" + r8.h());
    L15:
        final d r9 = new d();
        b.f7673a.a(r9);
        r9.a(r13, r14, r15, r16, r17, r6, r7, (Function2) ZeusTransformUtils.preCheckCast(new AnimatableSubmitter$animate$2(r0, r9), Function2.class, "com.obric.memorydata.plugin"));
        return r9;
    }

    public final d a(float r13, View r14, RunMode r15, float r16, RepeatMode r17, List<? extends com.obric.common.oea.foundation.animation.b.a<?>> r18, Function3<? super String, Object, ? super Float, Unit> r19, Function2<? super Boolean, ? super Throwable, Unit> r20) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Function3<? super String, Object, ? super Float, Unit> r10 = (Function3) ZeusTransformUtils.wrapperContextForParams(r19, Function3.class, "com.obric.memorydata.plugin");
        Function2<? super Boolean, ? super Throwable, Unit> r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r20, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "mode");
        Intrinsics.checkNotNullParameter(r17, "repeatMode");
        Intrinsics.checkNotNullParameter(r0, "animationCommands");
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        com.obric.common.oea.foundation.animation.b.a<?> r2 = (com.obric.common.oea.foundation.animation.b.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.common.oea.foundation.animation.b.a.class, "com.obric.memorydata.plugin");
        r9.add(f7717a.a(r2));
        goto L4
    L7:
        return b(r13, r14, r15, r16, r17, r9, r10, r11);
    }
}
