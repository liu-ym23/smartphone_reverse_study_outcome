package com.larus.share.impl.sdk.special;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.platform.service.e;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.share.impl.panel.SharePanelServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import nr9.g;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.sdk.special.ShareImageSpecialHandler$handleShareVideo$1", f = "ShareImageSpecialHandler.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 5}, l = {111, 129, 144, 148, 152, 208}, m = "invokeSuspend", n = {"$this$launch", "perf", "aiResolvedUrl", "aiResolvedFilehash", "$this$launch", "perf", "aiResolvedUrl", "aiResolvedFilehash", "$this$launch", "perf", "downloadUrl", "path", "$this$launch", "perf", "$this$launch", "perf", "e"}, s = {"L$0", "L$1", "L$9", "L$10", "L$0", "L$1", "L$9", "L$10", "L$0", "L$1", "L$9", "L$10", "L$0", "L$1", "L$0", "L$1", "L$0"})
public final class ShareImageSpecialHandler$handleShareVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Integer, Unit> $listener;
    final /* synthetic */ String $shareChannel;
    final /* synthetic */ com.larus.bmhome.share.panel.b $shareContent;
    final /* synthetic */ String $shareType;
    final /* synthetic */ boolean $showLoading;
    final /* synthetic */ WeakReference<l0> $weakRefDialog;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    final /* synthetic */ ShareImageSpecialHandler this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ShareImageSpecialHandler$handleShareVideo$1(com.larus.bmhome.share.panel.b r1, ShareImageSpecialHandler r2, Context r3, String r4, String r5, boolean r6, Function1<? super Integer, Unit> r7, WeakReference<l0> r8, Continuation<? super ShareImageSpecialHandler$handleShareVideo$1> r9) {
        this.$shareContent = r1;
        this.this$0 = r2;
        this.$context = r3;
        this.$shareChannel = r4;
        this.$shareType = r5;
        this.$showLoading = r6;
        this.$listener = r7;
        this.$weakRefDialog = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        ShareImageSpecialHandler$handleShareVideo$1 r10 = new ShareImageSpecialHandler$handleShareVideo$1(this.$shareContent, this.this$0, this.$context, this.$shareChannel, this.$shareType, this.$showLoading, this.$listener, this.$weakRefDialog, r13);
        r10.L$0 = r12;
        return r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_share_impl_sdk_special_ShareImageSpecialHandler$handleShareVideo$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final Object invokeSuspend(Object r37) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L39;
            case 1: goto L34;
            case 2: goto L29;
            case 3: goto L22;
            case 4: goto L16;
            case 5: goto L11;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        Exception r2 = (Exception) this.L$0;
        ResultKt.throwOnFailure(r37);     // Catch: Throwable -> L9
        Object r0 = r37;
        String r3 = "ShareImageSpecialHandler";
    L324:
        Result.constructor-impl((Unit) r0);     // Catch: Throwable -> L326
    L328:
        FLogger.a.i(r3, "[handleShareVideo] loadingDialog dismiss due to exception: " + r2.getMessage());
    L330:
        return Unit.INSTANCE;
    L326:
        Throwable th = th;
    L327:
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L9:
        th = th;
        r3 = "ShareImageSpecialHandler";
        goto L327
    L11:
        boolean r1 = this.Z$0;
        WeakReference<l0> r6 = (WeakReference) this.L$8;
        Function1<Integer, Unit> r7 = (Function1) this.L$7;
        String r11 = (String) this.L$6;
        String r12 = (String) this.L$5;
        Context r13 = (Context) this.L$4;
        com.larus.bmhome.share.panel.b r14 = (com.larus.bmhome.share.panel.b) this.L$3;
        ShareImageSpecialHandler r15 = (ShareImageSpecialHandler) this.L$2;
        Ref.ObjectRef r8 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r37);     // Catch: Exception -> L14
        boolean r10 = r1;
        String r28 = "[saveVideo] videoPath ";
        Object r16 = r37;
        WeakReference<l0> r17 = r6;
        r3 = "ShareImageSpecialHandler";
        Object r18 = r5;
    L216:
        String r19 = (String) r16;     // Catch: Exception -> L305
        if (r19 != null) goto L343;
        boolean r20 = r10;
    L224:
        ShareImageSpecialHandler.b r21 = null;
    L225:
        if (r21 != null) goto L384;
        String r22 = null;
    L230:
        if (r22 == null) goto L236;
        if (r22.length() == 0) goto L236;
        boolean r23 = false;
    L238:
        if (r23 == true) goto L275;
        FLogger r24 = FLogger.a;     // Catch: Exception -> L305
        r5 = r18;
        r24.i(r3, r28 + r22);     // Catch: Exception -> L177
        if (r14.q == false) goto L244;
        e.b(r22);     // Catch: Exception -> L177
    L244:
        Function2 r25 = r14.B;     // Catch: Exception -> L177
        if (r25 == null) goto L250;
        if (r21 == null) goto L248;
        Boolean r26 = Boxing.boxBoolean(r21.b);     // Catch: Exception -> L177
    L249:
        r25.invoke(r22, r26);     // Catch: Exception -> L177
        Unit r27 = Unit.INSTANCE;     // Catch: Exception -> L177
        goto L250
    L248:
        r26 = null;
    L250:
        Function1 r29 = r14.A;     // Catch: Exception -> L177
        if (r29 == null) goto L254;
        r29.invoke(r22);     // Catch: Exception -> L177
        Unit r30 = Unit.INSTANCE;     // Catch: Exception -> L177
    L254:
        if (Build.VERSION.SDK_INT > 28) goto L256;
        ShareImageSpecialHandler.g(r15, r13, r22);     // Catch: Exception -> L177
    L257:
        WatermarkPerfLogger.a r31 = (WatermarkPerfLogger.a) r8.element;     // Catch: Exception -> L177
        if (r31 == null) goto L260;
        r31.a("saveVideo");     // Catch: Exception -> L177
    L260:
        WatermarkPerfLogger.a r32 = (WatermarkPerfLogger.a) r8.element;     // Catch: Exception -> L177
        if (r32 == null) goto L264;
        r32.b(WatermarkPerfLogger.Result.SUCCESS, null);     // Catch: Exception -> L177
        Unit r33 = Unit.INSTANCE;     // Catch: Exception -> L177
    L264:
        if ((r13 instanceof Activity) == false) goto L270;
        boolean r34 = ((Activity) r13).isFinishing();     // Catch: Exception -> L177
        boolean r35 = ((Activity) r13).isDestroyed();     // Catch: Exception -> L177
        if (r34 == true) goto L268;
        if (r35 == false) goto L270;
    L268:
        r24.i(r3, "[handleShareVideo] activity is finishing or destroyed, skip share");     // Catch: Exception -> L177
        return Unit.INSTANCE;
    L270:
        SharePanelServiceDelegate r36 = SharePanelServiceDelegate.b;     // Catch: Exception -> L177
        com.larus.bmhome.share.panel.b r210 = com.larus.bmhome.share.panel.b.a(r14, null, null, null, r22, null, null, false, 67108847);     // Catch: Exception -> L177
        if (r20 == false) goto L273;
        boolean r211 = true;
    L274:
        r36.b(r13, r12, r11, r210, r211, r7);     // Catch: Exception -> L177
        Unit r38 = Unit.INSTANCE;     // Catch: Exception -> L177
    L345:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L301
        if (r17 == null) goto L294;
        l0 r40 = r17.get();     // Catch: Throwable -> L301
        if (r40 == null) goto L294;
        if (r40.isShowing() != true) goto L294;
        boolean r41 = true;
    L295:
        if (r41 == false) goto L299;
        l0 r42 = r17.get();     // Catch: Throwable -> L301
        if (r42 == null) goto L299;
        INVOKEVIRTUAL_com_larus_share_impl_sdk_special_ShareImageSpecialHandler$handleShareVideo$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r42);     // Catch: Throwable -> L301
        Unit r43 = Unit.INSTANCE;     // Catch: Throwable -> L301
    L299:
        Object r44 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L301
    L303:
        Result.box-impl(r44);     // Catch: Exception -> L177
        goto L330
    L294:
        r41 = false;
    L301:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Exception -> L177
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L177
    L177:
        e = e;
    L316:
        r2 = e;
    L317:
        WatermarkPerfLogger.a r46 = (WatermarkPerfLogger.a) r8.element;
        if (r46 == null) goto L320;
        r46.b(WatermarkPerfLogger.Result.FAIL, r2.getClass().getSimpleName());
        Unit r47 = Unit.INSTANCE;
    L320:
        WeakReference<l0> r48 = this.$weakRefDialog;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L326
        MainCoroutineDispatcher r50 = Dispatchers.getMain();     // Catch: Throwable -> L326
        ShareImageSpecialHandler$handleShareVideo$1$2$1 r51 = new ShareImageSpecialHandler$handleShareVideo$1$2$1(r48, null);     // Catch: Throwable -> L326
        this.L$0 = r2;     // Catch: Throwable -> L326
        this.L$1 = null;     // Catch: Throwable -> L326
        this.L$2 = null;     // Catch: Throwable -> L326
        this.L$3 = null;     // Catch: Throwable -> L326
        this.L$4 = null;     // Catch: Throwable -> L326
        this.L$5 = null;     // Catch: Throwable -> L326
        this.L$6 = null;     // Catch: Throwable -> L326
        this.L$7 = null;     // Catch: Throwable -> L326
        this.L$8 = null;     // Catch: Throwable -> L326
        this.L$9 = null;     // Catch: Throwable -> L326
        this.L$10 = null;     // Catch: Throwable -> L326
        this.label = 6;     // Catch: Throwable -> L326
        r0 = BuildersKt.withContext(r50, r51, this);     // Catch: Throwable -> L326
        Object r52 = r5;
        if (r0 != r52) goto L324;
        return r52;
    L273:
        r211 = false;
        goto L274
    L256:
        r.u(r13, r22, false);     // Catch: Exception -> L177
    L305:
        e = e;
        r5 = r18;
        goto L316
    L275:
        r5 = r18;
        if (CollectionsKt.contains(ShareImageSpecialHandler.b, r12) == true) goto L281;
        s.a.g(r13, 2131909350, false);     // Catch: Exception -> L177
        if (r7 == null) goto L281;
        r7.invoke(Boxing.boxInt(2));     // Catch: Exception -> L177
        Unit r53 = Unit.INSTANCE;     // Catch: Exception -> L177
    L281:
        WatermarkPerfLogger.a r54 = (WatermarkPerfLogger.a) r8.element;     // Catch: Exception -> L177
        if (r54 == null) goto L284;
        r54.a("saveVideo");     // Catch: Exception -> L177
    L284:
        WatermarkPerfLogger.a r55 = (WatermarkPerfLogger.a) r8.element;     // Catch: Exception -> L177
        if (r55 == null) goto L345;
        r55.b(WatermarkPerfLogger.Result.FAIL, "save_video_failed");     // Catch: Exception -> L177
        Unit r56 = Unit.INSTANCE;     // Catch: Exception -> L177
    L227:
        e = e;
        Ref.ObjectRef r57 = r8;
    L209:
        r8 = r57;
    L235:
        r2 = e;
        r5 = r18;
    L236:
        r23 = true;
        goto L238
    L384:
        r22 = r21.a;     // Catch: Exception -> L227
        goto L230
    L343:
        r21 = new ShareImageSpecialHandler.b(r19, false);     // Catch: Exception -> L220
        r20 = r10;
    L220:
        e = e;
        Ref.ObjectRef r110 = r8;
    L222:
        r8 = r110;
    L14:
        e = e;
    L21:
        r2 = e;
        r5 = r5;
        r3 = "ShareImageSpecialHandler";
        goto L317
    L16:
        r20 = this.Z$0;
        WeakReference<l0> r58 = (WeakReference) this.L$8;
        r7 = (Function1) this.L$7;
        String r59 = (String) this.L$6;
        String r60 = (String) this.L$5;
        Context r111 = (Context) this.L$4;
        com.larus.bmhome.share.panel.b r112 = (com.larus.bmhome.share.panel.b) this.L$3;
        ShareImageSpecialHandler r113 = (ShareImageSpecialHandler) this.L$2;
        r110 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r114 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r37);     // Catch: Exception -> L19
        r28 = "[saveVideo] videoPath ";
        Object r61 = r37;
        r17 = r58;
        r3 = "ShareImageSpecialHandler";
        r18 = r5;
    L333:
        String r62 = (String) r61;     // Catch: Exception -> L205
        if (r62 == null) goto L204;
        r21 = new ShareImageSpecialHandler.b(r62, false);     // Catch: Exception -> L205
        r15 = r113;
        r13 = r111;
        r11 = r59;
        com.larus.bmhome.share.panel.b r310 = r112;
        r12 = r60;
        r8 = r110;
        r14 = r310;
        goto L225
    L204:
        r15 = r113;
        r13 = r111;
        r11 = r59;
        com.larus.bmhome.share.panel.b r311 = r112;
        r12 = r60;
        r8 = r110;
        r14 = r311;
    L205:
        e = e;
    L19:
        e = e;
        r8 = r110;
        goto L21
    L22:
        r20 = this.Z$0;
        String r63 = (String) this.L$10;
        String r64 = (String) this.L$9;
        WeakReference<l0> r65 = (WeakReference) this.L$8;
        Function1<Integer, Unit> r66 = (Function1) this.L$7;
        r11 = (String) this.L$6;
        r12 = (String) this.L$5;
        r13 = (Context) this.L$4;
        r14 = (com.larus.bmhome.share.panel.b) this.L$3;
        r15 = (ShareImageSpecialHandler) this.L$2;
        r57 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r67 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r37);     // Catch: Exception -> L26
        r28 = "[saveVideo] videoPath ";
        String r68 = r63;
        r3 = "ShareImageSpecialHandler";
        r18 = r5;
        r17 = r65;
        Object r69 = r37;
        CoroutineScope r312 = r67;
        String r70 = r64;
        r7 = r66;
    L25:
        CoroutineScope r71 = r312;
        ShareImageSpecialHandler.b r72 = (ShareImageSpecialHandler.b) r69;     // Catch: Exception -> L208
        if (r72 != null) goto L207;
        Application r73 = AppHost.a.getApplication();     // Catch: Exception -> L208
        this.L$0 = r71;     // Catch: Exception -> L208
        this.L$1 = r57;     // Catch: Exception -> L208
        this.L$2 = r15;     // Catch: Exception -> L208
        this.L$3 = r14;     // Catch: Exception -> L208
        this.L$4 = r13;     // Catch: Exception -> L208
        this.L$5 = r12;     // Catch: Exception -> L208
        this.L$6 = r11;     // Catch: Exception -> L208
        this.L$7 = r7;     // Catch: Exception -> L208
        this.L$8 = r17;     // Catch: Exception -> L208
        this.L$9 = null;     // Catch: Exception -> L208
        this.L$10 = null;     // Catch: Exception -> L208
        this.Z$0 = r20;     // Catch: Exception -> L208
        this.label = 4;     // Catch: Exception -> L208
        r61 = ShareImageSpecialHandler.f(r15, r73, r70, r68, this);     // Catch: Exception -> L208
        if (r61 != r18) goto L199;
        return r18;
    L199:
        r59 = r11;
        r60 = r12;
        r111 = r13;
        r112 = r14;
        r113 = r15;
        r110 = r57;
        goto L333
    L207:
        r21 = r72;
        r8 = r57;
    L208:
        e = e;
    L26:
        e = e;
        r8 = r57;
    L28:
        r3 = "ShareImageSpecialHandler";
        goto L316
    L29:
        boolean r74 = this.Z$0;
        Ref.ObjectRef r75 = (Ref.ObjectRef) this.L$10;
        Ref.ObjectRef r76 = (Ref.ObjectRef) this.L$9;
        WeakReference<l0> r77 = (WeakReference) this.L$8;
        Function1<Integer, Unit> r78 = (Function1) this.L$7;
        r11 = (String) this.L$6;
        r12 = (String) this.L$5;
        r13 = (Context) this.L$4;
        r14 = (com.larus.bmhome.share.panel.b) this.L$3;
        r15 = (ShareImageSpecialHandler) this.L$2;
        Ref.ObjectRef r115 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r116 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r37);     // Catch: Throwable -> L32
        Object r79 = r37;
        r28 = "[saveVideo] videoPath ";
        String r212 = "[handleShareVideo] resolveFileFinalDownloadUrl execute failed, ";
        Object r80 = r5;
        String r313 = "ShareImageSpecialHandler";
    L370:
        Object r81 = Result.constructor-impl((String) r79);     // Catch: Throwable -> L149
    L148:
        Ref.ObjectRef r82 = r76;
        WeakReference<l0> r83 = r77;
        r8 = r115;
        CoroutineScope r84 = r116;
        Function1<Integer, Unit> r314 = r78;
        Object r85 = r81;
        boolean r86 = r74;
        r7 = r314;
        Throwable r117 = Result.exceptionOrNull-impl(r85);     // Catch: Exception -> L307
        if (r117 == null) goto L170;
        r5 = r80;
        r3 = r313;
        FLogger.a.e(r3, r212 + r117);     // Catch: Exception -> L177
    L172:
        if (Result.isFailure-impl(r85) == false) goto L174;
        r85 = null;
    L174:
        String r87 = (String) r85;     // Catch: Exception -> L177
        if (r87 != null) goto L179;
        String r88 = (String) r82.element;     // Catch: Exception -> L177
    L180:
        WatermarkPerfLogger.a r89 = (WatermarkPerfLogger.a) r8.element;     // Catch: Exception -> L177
        if (r89 == null) goto L183;
        r89.a("watermark");     // Catch: Exception -> L177
    L183:
        r68 = r.h() + File.separator + ShareImageSpecialHandler.c(r15, r88);     // Catch: Exception -> L177
        Object r90 = r75.element;     // Catch: Exception -> L177
        String r91 = (String) r90;     // Catch: Exception -> L177
        if (Intrinsics.areEqual(r88, r82.element) == true) goto L187;
        r90 = null;
    L187:
        String r92 = (String) r90;     // Catch: Exception -> L177
        if (z2.a.enableCreationVideoDownloadOpt() == true) goto L341;
        r10 = r86;
        r17 = r83;
        r18 = r5;
        Application r93 = AppHost.a.getApplication();     // Catch: Exception -> L305
        this.L$0 = r84;     // Catch: Exception -> L305
        this.L$1 = r8;     // Catch: Exception -> L305
        this.L$2 = r15;     // Catch: Exception -> L305
        this.L$3 = r14;     // Catch: Exception -> L305
        this.L$4 = r13;     // Catch: Exception -> L305
        this.L$5 = r12;     // Catch: Exception -> L305
        this.L$6 = r11;     // Catch: Exception -> L305
        this.L$7 = r7;     // Catch: Exception -> L305
        this.L$8 = r17;     // Catch: Exception -> L305
        this.L$9 = null;     // Catch: Exception -> L305
        this.L$10 = null;     // Catch: Exception -> L305
        this.Z$0 = r10;     // Catch: Exception -> L305
        this.label = 5;     // Catch: Exception -> L305
        r16 = ShareImageSpecialHandler.f(r15, r93, r88, r68, this);     // Catch: Exception -> L305
        if (r16 != r18) goto L216;
        return r18;
    L341:
        this.L$0 = r84;     // Catch: Exception -> L210
        this.L$1 = r8;     // Catch: Exception -> L210
        this.L$2 = r15;     // Catch: Exception -> L210
        this.L$3 = r14;     // Catch: Exception -> L210
        this.L$4 = r13;     // Catch: Exception -> L210
        this.L$5 = r12;     // Catch: Exception -> L210
        this.L$6 = r11;     // Catch: Exception -> L210
        this.L$7 = r7;     // Catch: Exception -> L210
        r17 = r83;
        this.L$8 = r17;     // Catch: Exception -> L210
        this.L$9 = r88;     // Catch: Exception -> L210
        this.L$10 = r68;     // Catch: Exception -> L210
        this.Z$0 = r86;     // Catch: Exception -> L210
        this.label = 3;     // Catch: Exception -> L210
        r69 = ShareImageSpecialHandler.e(r15, r92, r88, r68, this);     // Catch: Exception -> L210
        r18 = r5;
        if (r69 != r18) goto L193;
        return r18;
    L193:
        r312 = r84;
        r70 = r88;
        r20 = r86;
        r57 = r8;
    L210:
        e = e;
        r18 = r5;
        goto L235
    L179:
        r88 = r87;
    L168:
        e = e;
    L169:
        r3 = r313;
        goto L316
    L170:
        r5 = r80;
        r3 = r313;
    L307:
        e = e;
        r5 = r80;
    L149:
        th = th;
    L398:
        Result.Companion r94 = Result.Companion;     // Catch: Exception -> L309
        r81 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L309
    L309:
        e = e;
        r5 = r80;
        r3 = r313;
        r8 = r115;
    L32:
        th = th;
        r28 = "[saveVideo] videoPath ";
        r212 = "[handleShareVideo] resolveFileFinalDownloadUrl execute failed, ";
        r80 = r5;
        r313 = "ShareImageSpecialHandler";
        goto L398
    L34:
        boolean r95 = this.Z$0;
        Ref.ObjectRef r96 = (Ref.ObjectRef) this.L$10;
        Ref.ObjectRef r97 = (Ref.ObjectRef) this.L$9;
        WeakReference<l0> r98 = (WeakReference) this.L$8;
        Function1<Integer, Unit> r118 = (Function1) this.L$7;
        String r119 = (String) this.L$6;
        String r120 = (String) this.L$5;
        Context r121 = (Context) this.L$4;
        com.larus.bmhome.share.panel.b r122 = (com.larus.bmhome.share.panel.b) this.L$3;
        ShareImageSpecialHandler r123 = (ShareImageSpecialHandler) this.L$2;
        Ref.ObjectRef r124 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r125 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r37);     // Catch: Throwable -> L37
        Object r99 = r37;
        r28 = "[saveVideo] videoPath ";
        r212 = "[handleShareVideo] resolveFileFinalDownloadUrl execute failed, ";
        String r315 = "[handleShareVideo] AI no-watermark resolve failed, ";
        r80 = r5;
        r313 = "ShareImageSpecialHandler";
    L366:
        g r100 = (g) r99;     // Catch: Throwable -> L92
        if (r100 == null) goto L80;
        String r101 = r100.c;     // Catch: Throwable -> L92
        if (r101 != null) goto L74;
    L77:
        boolean r102 = true;
    L78:
        if (r102 == true) goto L80;
        String r103 = r100.c;     // Catch: Throwable -> L92
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L92
        r97.element = r103;     // Catch: Throwable -> L92
        goto L80
    L74:
        if (r101.length() == 0) goto L77;
        r102 = false;
    L80:
        if (r100 == null) goto L90;
        String r104 = r100.d;     // Catch: Throwable -> L92
        if (r104 != null) goto L84;
    L87:
        boolean r105 = true;
    L88:
        if (r105 == true) goto L90;
        r96.element = r100.d;     // Catch: Throwable -> L92
        goto L90
    L84:
        if (r104.length() == 0) goto L87;
        r105 = false;
    L90:
        Object r106 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L92
    L107:
        Throwable r107 = Result.exceptionOrNull-impl(r106);     // Catch: Exception -> L117
        if (r107 == null) goto L115;
        String r108 = r313;
        FLogger.a.e(r108, r315 + r107);     // Catch: Exception -> L113
    L116:
        r74 = r95;
        r75 = r96;
        r76 = r97;
        r77 = r98;
        r78 = r118;
        r11 = r119;
        r12 = r120;
        r13 = r121;
        r14 = r122;
        r15 = r123;
        Ref.ObjectRef r109 = r124;
        CoroutineScope r126 = r125;
    L394:
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L157
        IAIChatUgcAIGCService.Companion r128 = IAIChatUgcAIGCService.a;     // Catch: Throwable -> L157
        r313 = r108;
        String r129 = (String) r76.element;     // Catch: Throwable -> L155
        Object r316 = r80;
        Integer r130 = r14.w;     // Catch: Throwable -> L153
        if (r130 == null) goto L132;
        String r317 = "Creation";
    L133:
        if (r130 != null) goto L347;
        String r131 = null;
    L138:
        if (r131 != null) goto L140;
        r131 = "";
    L140:
        this.L$0 = r126;     // Catch: Throwable -> L153
        this.L$1 = r109;     // Catch: Throwable -> L153
        this.L$2 = r15;     // Catch: Throwable -> L153
        this.L$3 = r14;     // Catch: Throwable -> L153
        this.L$4 = r13;     // Catch: Throwable -> L153
        this.L$5 = r12;     // Catch: Throwable -> L153
        this.L$6 = r11;     // Catch: Throwable -> L153
        this.L$7 = r78;     // Catch: Throwable -> L153
        this.L$8 = r77;     // Catch: Throwable -> L153
        this.L$9 = r76;     // Catch: Throwable -> L153
        this.L$10 = r75;     // Catch: Throwable -> L153
        this.Z$0 = r74;     // Catch: Throwable -> L153
        r115 = r109;
        this.label = 2;     // Catch: Throwable -> L151
        r79 = IAIChatUgcAIGCService.a.d(r128, r129, r317, r131, this);     // Catch: Throwable -> L151
        r80 = r316;
        if (r79 != r80) goto L146;
        return r80;
    L146:
        r116 = r126;
    L151:
        th = th;
    L152:
        r80 = r316;
    L159:
        r116 = r126;
        goto L398
    L347:
        int r132 = r130.intValue();     // Catch: Throwable -> L130
        r15.getClass();     // Catch: Throwable -> L130
        r131 = ShareImageSpecialHandler.k(r132);     // Catch: Throwable -> L130
    L130:
        th = th;
        r115 = r109;
        r116 = r126;
        r80 = r316;
        goto L398
    L132:
        r317 = "";
    L153:
        th = th;
        r115 = r109;
    L155:
        th = th;
        r115 = r109;
    L157:
        th = th;
        r115 = r109;
        r313 = r108;
    L113:
        e = e;
        r5 = r80;
        r3 = r108;
        r8 = r124;
    L117:
        e = e;
        r18 = r80;
        r3 = r313;
        r8 = r124;
        goto L235
    L115:
        r108 = r313;
    L92:
        th = th;
    L331:
        Result.Companion r133 = Result.Companion;     // Catch: Exception -> L117
        r106 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L117
    L37:
        th = th;
        r28 = "[saveVideo] videoPath ";
        r212 = "[handleShareVideo] resolveFileFinalDownloadUrl execute failed, ";
        r315 = "[handleShareVideo] AI no-watermark resolve failed, ";
        r80 = r5;
        r313 = "ShareImageSpecialHandler";
        goto L331
    L39:
        ResultKt.throwOnFailure(r37);
        CoroutineScope r134 = (CoroutineScope) this.L$0;
        r8 = new Ref.ObjectRef();
        r122 = this.$shareContent;     // Catch: Exception -> L314
        String r135 = r122.e;     // Catch: Exception -> L314
        if (r135 == null) goto L330;
        ShareImageSpecialHandler r136 = this.this$0;     // Catch: Exception -> L314
        r121 = this.$context;     // Catch: Exception -> L314
        r120 = this.$shareChannel;     // Catch: Exception -> L314
        r119 = this.$shareType;     // Catch: Exception -> L314
        boolean r137 = this.$showLoading;     // Catch: Exception -> L314
        r118 = this.$listener;     // Catch: Exception -> L314
        r28 = "[saveVideo] videoPath ";
        WeakReference<l0> r138 = this.$weakRefDialog;     // Catch: Exception -> L314
        r212 = "[handleShareVideo] resolveFileFinalDownloadUrl execute failed, ";
        r8.element = ShareImageSpecialHandler.b(r136, r135, r122);     // Catch: Exception -> L314
        Ref.ObjectRef r139 = new Ref.ObjectRef();     // Catch: Exception -> L314
        r139.element = r135;     // Catch: Exception -> L314
        r313 = "ShareImageSpecialHandler";
        Ref.ObjectRef r140 = new Ref.ObjectRef();     // Catch: Exception -> L311
        r315 = "[handleShareVideo] AI no-watermark resolve failed, ";
        r140.element = r122.f;     // Catch: Exception -> L311
        if (r122.q == true) goto L335;
    L121:
        r80 = r5;
        r74 = r137;
        r108 = r313;
        r78 = r118;
        r11 = r119;
        r12 = r120;
        r13 = r121;
        r14 = r122;
        r15 = r136;
        r76 = r139;
        r109 = r8;
        r77 = r138;
        r126 = r134;
        r75 = r140;
        goto L394
    L335:
        String r141 = r122.g;     // Catch: Exception -> L119
        if (r141 != null) goto L356;
    L54:
        boolean r142 = true;
    L55:
        if (r142 == true) goto L121;
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L103
        IAIChatUgcAIGCService.Companion r144 = IAIChatUgcAIGCService.a;     // Catch: Throwable -> L103
        g r145 = new g(r122.g, null, r135, r122.f, null, null, null, null, null, null, 1010);     // Catch: Throwable -> L99
        this.L$0 = r134;     // Catch: Throwable -> L99
        this.L$1 = r8;     // Catch: Throwable -> L99
        this.L$2 = r136;     // Catch: Throwable -> L99
        this.L$3 = r122;     // Catch: Throwable -> L99
        this.L$4 = r121;     // Catch: Throwable -> L99
        this.L$5 = r120;     // Catch: Throwable -> L99
        this.L$6 = r119;     // Catch: Throwable -> L99
        this.L$7 = r118;     // Catch: Throwable -> L99
        this.L$8 = r138;     // Catch: Throwable -> L99
        this.L$9 = r139;     // Catch: Throwable -> L99
        this.L$10 = r140;     // Catch: Throwable -> L99
        boolean r146 = r137;
        this.Z$0 = r146;     // Catch: Throwable -> L96
        this.label = 1;     // Catch: Throwable -> L96
        WeakReference<l0> r147 = r138;
        r99 = r144.L0(r145, "download_save", null, this);     // Catch: Throwable -> L94
        r80 = r5;
        if (r99 != r80) goto L68;
        return r80;
    L68:
        r125 = r134;
        r124 = r8;
        r98 = r147;
        r97 = r139;
        r95 = r146;
        r123 = r136;
        r96 = r140;
    L94:
        th = th;
    L98:
        r80 = r5;
    L105:
        r125 = r134;
        r124 = r8;
        r98 = r147;
        r97 = r139;
        r95 = r146;
        r123 = r136;
        r96 = r140;
    L96:
        th = th;
        r147 = r138;
    L99:
        th = th;
        r147 = r138;
        r80 = r5;
        r146 = r137;
    L101:
        th = th;
        r147 = r138;
        r146 = r137;
    L103:
        th = th;
        r147 = r138;
        r80 = r5;
        r146 = r137;
        goto L105
    L356:
        if (r141.length() == 0) goto L54;
        r142 = false;
    L52:
        e = e;
        r18 = r5;
        r3 = r313;
    L119:
        e = e;
        r5 = r5;
        r3 = r313;
    L311:
        e = e;
        r5 = r5;
    L314:
        e = e;
        goto L28
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
