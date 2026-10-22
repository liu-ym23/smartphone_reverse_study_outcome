package com.larus.shortcuts.impl.pin;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.shortcuts.impl.pin.PinShortcutProcess$pinnedShortCut$1", f = "PinShortcutProcess.kt", i = {0}, l = {226, 255}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class PinShortcutProcess$pinnedShortCut$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $eventJson;
    final /* synthetic */ boolean $needAfterCheck;
    final /* synthetic */ tw9.a $shortcutInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PinShortcutProcess this$0;

    public PinShortcutProcess$pinnedShortCut$1(tw9.a r1, PinShortcutProcess r2, boolean r3, JSONObject r4, Continuation<? super PinShortcutProcess$pinnedShortCut$1> r5) {
        this.$shortcutInfo = r1;
        this.this$0 = r2;
        this.$needAfterCheck = r3;
        this.$eventJson = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        PinShortcutProcess$pinnedShortCut$1 r6 = new PinShortcutProcess$pinnedShortCut$1(this.$shortcutInfo, this.this$0, this.$needAfterCheck, this.$eventJson, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L13;
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L9;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L38
    L41:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L38
    L21:
        ShortcutInfo r12 = (ShortcutInfo) r11;     // Catch: Exception -> L38
        if (r12 != null) goto L25;
        FLogger.a.i("PinShortcutUtil", "buildShortcutInfo is null");     // Catch: Exception -> L38
        return Unit.INSTANCE;
    L25:
        FLogger r5 = FLogger.a;     // Catch: Exception -> L38
        r5.i("PinShortcutUtil", "system start request shortcut, shortcut is " + r12);     // Catch: Exception -> L38
        Application r1 = AppHost.a.getApplication();     // Catch: Exception -> L38
        Intent r6 = new Intent();     // Catch: Exception -> L38
        r6.putExtra("event_params", String.valueOf(this.$eventJson));     // Catch: Exception -> L38
        r6.setAction("com.larus.shortcut.action.INSTALL_SHORTCUT");     // Catch: Exception -> L38
        Unit r8 = Unit.INSTANCE;     // Catch: Exception -> L38
        if (Build.VERSION.SDK_INT < 23) goto L28;
        int r9 = 201326592;
    L29:
        PendingIntent r7 = PendingIntent.getBroadcast(r1, 0, r6, r9);     // Catch: Exception -> L38
        PinShortcutProcess r10 = this.this$0;     // Catch: Exception -> L38
        r12.getId();     // Catch: Exception -> L38
        PinShortcutProcess.c(r10, r1);     // Catch: Exception -> L38
        ShortcutManager r13 = (ShortcutManager) e.a.getValue();     // Catch: Exception -> L38
        if (r13 == null) goto L32;
        Boolean r14 = Boxing.boxBoolean(r13.requestPinShortcut(r12, r7.getIntentSender()));     // Catch: Exception -> L38
    L33:
        r5.i("PinShortcutUtil", "res is " + r14);     // Catch: Exception -> L38
        if (this.$needAfterCheck == false) goto L41;
        PinShortcutProcess r15 = this.this$0;     // Catch: Exception -> L38
        this.L$0 = null;     // Catch: Exception -> L38
        this.label = 2;     // Catch: Exception -> L38
        if (PinShortcutProcess.b(r15, this) != r2) goto L41;
        return r2;
    L32:
        r14 = null;
        goto L33
    L28:
        r9 = 134217728;
        goto L29
    L13:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        Lazy r17 = e.a;     // Catch: Exception -> L38
        if (e.a(this.$shortcutInfo.b()) == false) goto L18;
        s.a.g(AppHost.a.getApplication(), 2131905959, false);     // Catch: Exception -> L38
        return Unit.INSTANCE;
    L18:
        PinShortcutProcess r18 = this.this$0;     // Catch: Exception -> L38
        tw9.a r19 = this.$shortcutInfo;     // Catch: Exception -> L38
        this.L$0 = r16;     // Catch: Exception -> L38
        this.label = 1;     // Catch: Exception -> L38
        r11 = PinShortcutProcess.a(r18, r19, this);     // Catch: Exception -> L38
        if (r11 != r2) goto L21;
        return r2;
    L38:
        e = move-exception;
        FLogger.a.e("PinShortcutUtil", "pinned has exception " + e.getMessage());
        goto L41
    }
}
