package com.ss.ugc.live.barrage.controller;

import android.content.Context;
import android.graphics.Canvas;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends AbsBarrageController {
    public static final /* synthetic */ KProperty[] n = null;

    public static final class a {
    }

    static {
        n = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "danmakuLinePaint", "getDanmakuLinePaint()Landroid/graphics/Paint;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "paint0", "getPaint0()Landroid/graphics/Paint;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "paint1", "getPaint1()Landroid/graphics/Paint;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "paint2", "getPaint2()Landroid/graphics/Paint;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "paint3", "getPaint3()Landroid/graphics/Paint;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "paint4", "getPaint4()Landroid/graphics/Paint;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "paint5", "getPaint5()Landroid/graphics/Paint;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "paint6", "getPaint6()Landroid/graphics/Paint;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "paint7", "getPaint7()Landroid/graphics/Paint;"))};
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void d(Canvas r1) {
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void m() {
        p();     // Catch: Throwable -> L4
        super.m();     // Catch: Throwable -> L4
        return;
    }

    private final Context getContext() {
        throw null;
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void c(Canvas r8) {
        r8.saveLayer(0.0f, 0.0f, r8.getWidth(), r8.getHeight(), null, 31);
        r8.save();
        float r2 = 0.0f - 1;
        r8.translate(((-r8.getWidth()) * r2) * 0.5f, ((-r8.getHeight()) * r2) * 0.5f);
        throw null;
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void j(com.ss.ugc.live.barrage.util.a r1, float r2) {
        throw null;
    }
}
