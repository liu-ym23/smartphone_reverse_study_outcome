package com.bytedance.android.ec.core.anchorv3;

import com.bytedance.dataplatform.config.SettingPanel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    @SettingPanel("Schema链路改造总开关，true走老链路，false走新链路")
    public static final boolean a() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_video_disable_purchase_refactor", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("Schema链路改造entrance_info优化开关，默认true, 使用同一entrance_info")
    public static final boolean b() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_video_purchase_api_entrance_info_opt", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("业务服务端客户端 Diff 实验")
    public static final boolean c() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_video_purchase_biz_schema_diff", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("新旧 Diff 实验")
    public static final boolean d() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_video_purchase_refactor_schema_diff", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("Schema链路改造删除无用参数，默认true")
    public static boolean e() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_video_purchase_schema_delete_useless_params", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("Schema链路改造参数第一轮修复开关，默认true")
    public static final boolean f() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.TRUE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_video_purchase_schema_param_fix_opt", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("是否消费新参数总开关：提单、SKU 使用新方式打开")
    public static final boolean g() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_video_purchase_schema_refactor", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("多sku极致提单是否消费新参数")
    public static final boolean h() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_video_purchase_schema_refactor_multi_sku_ultimate", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    @SettingPanel("多sku非极致提单是否消费新参数")
    public static final boolean i() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L7
        Object r12 = jj4.a.a("ec_video_purchase_schema_refactor_multi_sku_unultimate", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r12).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L12;
        r1 = r14;
    L12:
        r12 = r1;
        goto L14
    }

    static {
    }
}
