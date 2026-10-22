package com.obric.assistant.remote_card_container;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import me.ele.lancet.base.annotations.Skip;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.RemoteCardImpl$init$1$copyContent$1", f = "RemoteCardImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteCardImpl$init$1$copyContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CharSequence $content;
    int label;

    public RemoteCardImpl$init$1$copyContent$1(CharSequence r1, Continuation<? super RemoteCardImpl$init$1$copyContent$1> r2) {
        this.$content = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RemoteCardImpl$init$1$copyContent$1(this.$content, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        AppHost.Companion r5 = AppHost.a;
        Object r0 = r5.getApplication().getSystemService("clipboard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.content.ClipboardManager");
        INVOKEVIRTUAL_com_obric_assistant_remote_card_container_RemoteCardImpl$init$1$copyContent$1_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip((ClipboardManager) r0, ClipData.newPlainText(null, this.$content));
        s r1 = s.a;
        Application r2 = r5.getApplication();
        String r6 = r5.getApplication().getString(2131900359);
        r1.getClass();
        s.p(r2, r6);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Skip({"com.bytedance.timonbase.clipboard.ClipboardMonitorManager", "com.bytedance.timon.clipboard.suite.TimonClipboardSuite", "com.bytedance.timon.clipboard.suite.TimonClipboardSuiteKt"})
    public static void INVOKEVIRTUAL_com_obric_assistant_remote_card_container_RemoteCardImpl$init$1$copyContent$1_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(ClipboardManager r3, ClipData r4) {
        Intrinsics.checkNotNullParameter(r4, "clip");
        FLogger.a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
        a(r3, r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
    }

    public static void a(ClipboardManager r18, ClipData r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101807);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.setPrimaryClip(r19);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
