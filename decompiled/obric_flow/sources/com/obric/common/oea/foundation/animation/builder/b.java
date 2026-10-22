package com.obric.common.oea.foundation.animation.builder;

import android.util.Log;
import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.util.ArrayList;
import jp.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f11314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f11315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11316c;
    public final ArrayList d;
    public final Lambda e;
    public final Lambda f;

    /* JADX WARN: Multi-variable type inference failed */
    public b(View r5, float r10, float r11, ArrayList r12, Function3 r13, Function2 r14) {
        this.f11314a = r5;
        this.f11315b = r10;
        this.f11316c = r11;
        this.d = r12;
        this.e = (Lambda) r13;
        this.f = (Lambda) r14;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    public static d a(b r10) {
        RunMode r5 = RunMode.PARALLEL;
        RepeatMode r11 = RepeatMode.NORMAL;
        Intrinsics.checkNotNullParameter(r5, "mode");
        Intrinsics.checkNotNullParameter(r11, "repeatMode");
        Intrinsics.checkNotNullParameter("PropertyAnimatable", "tag");
        Intrinsics.checkNotNullParameter("执行start ", "msg");
        if (rp.b.f21793a == null) goto L5;
        Intrinsics.checkNotNullParameter("PropertyAnimatable", "tag");
        Intrinsics.checkNotNullParameter("执行start ", "msg");
        Log.d("OEA_SDK", "PropertyAnimatable->执行start ");
    L5:
        ArrayList r12 = r10.d;
        if (r12 == null) goto L10;
        float r13 = r10.f11315b;
        float r14 = r10.f11316c;
        ?? r15 = r10.e;
        ?? r16 = r10.f;
        return com.obric.common.oea.foundation.animation.parser.a.a(r14, r10.f11314a, r5, r13, r11, r12, r15, r16);
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.obric.common.oea.foundation.animation.command.AnimationCommand<kotlin.Any>>");
    }
}
