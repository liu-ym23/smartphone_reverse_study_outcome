package com.larus.app.settings.impl;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.uaigc.api.SettingWatermarkConfigApi;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.app.settings.impl.CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1", f = "CreationOutputSettingsActivity.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
final class CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ CreationOutputSettingsFragment this$0;

    public CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1(Context r1, CreationOutputSettingsFragment r2, Continuation<? super CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1> r3) {
        this.$context = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1(this.$context, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        List r6 = null;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15 CancellationException -> L17
    L13:
        dm9.a r9 = (dm9.a) r8;     // Catch: Throwable -> L15 CancellationException -> L17
    L21:
        if ((r9 instanceof dm9.a.b) == false) goto L23;
        dm9.a.b r10 = (dm9.a.b) r9;     // Catch: Throwable -> L45
    L24:
        if (r10 != null) goto L26;
    L28:
        r10 = null;
    L29:
        if (r10 != null) goto L38;
        FLogger.a.w("CreationOutputSettings", "preload watermark config failed, block routing");     // Catch: Throwable -> L45
        t19.s r11 = t19.s.a;     // Catch: Throwable -> L45
        Context r0 = this.$context;     // Catch: Throwable -> L45
        int r3 = c0.a;     // Catch: Throwable -> L45
        if (r0 == null) goto L34;
        String r4 = r0.getString(2131897436);     // Catch: Throwable -> L45
        if (r4 == null) goto L34;
    L35:
        r11.getClass();     // Catch: Throwable -> L45
        t19.s.t(r0, r4);     // Catch: Throwable -> L45
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L45
        this.this$0.h = false;
        return r12;
    L34:
        r4 = "";
        goto L35
    L38:
        com.larus.uaigc.api.k r13 = (com.larus.uaigc.api.k) r10.a.getData();     // Catch: Throwable -> L45
        if (r13 == null) goto L41;
        r6 = r13.a();     // Catch: Throwable -> L45
    L41:
        com.bytedance.router.i r14 = SmartRouter.buildRoute(this.$context, "//flow/remove_ai_watermark");     // Catch: Throwable -> L45
        r14.c.putExtra("extra_watermark_media_enabled", n.b(r6, 150));     // Catch: Throwable -> L45
        r14.c.putExtra("extra_watermark_document_enabled", n.b(r6, 151));     // Catch: Throwable -> L45
        r14.d = 2130772401;     // Catch: Throwable -> L45
        r14.e = 2130772399;     // Catch: Throwable -> L45
        r14.d();     // Catch: Throwable -> L45
        this.this$0.h = false;
        return Unit.INSTANCE;
    L26:
        if (r10.a.isSuccess() == false) goto L28;
    L23:
        r10 = null;
        goto L24
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        SettingWatermarkConfigApi.Companion r15 = SettingWatermarkConfigApi.a;     // Catch: Throwable -> L15 CancellationException -> L17
        CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1$result$1 r5 = new CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1$result$1(null);     // Catch: Throwable -> L15 CancellationException -> L17
        this.label = 1;     // Catch: Throwable -> L15 CancellationException -> L17
        r15.getClass();     // Catch: Throwable -> L15 CancellationException -> L17
        r8 = SettingWatermarkConfigApi.Companion.a(r5, this);     // Catch: Throwable -> L15 CancellationException -> L17
        if (r8 != r1) goto L13;
        return r1;
    L45:
        th = move-exception;
        this.this$0.h = false;
        throw th;
    L15:
        th = move-exception;
        FLogger.a.w("CreationOutputSettings", "preload watermark config failed, msg=" + th.getMessage());     // Catch: Throwable -> L45
        r9 = null;
    L17:
        e = move-exception;
        throw e;     // Catch: Throwable -> L45
    }
}
