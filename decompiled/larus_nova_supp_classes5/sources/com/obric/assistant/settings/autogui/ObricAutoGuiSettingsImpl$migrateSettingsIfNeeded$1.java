package com.obric.assistant.settings.autogui;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import java.util.Iterator;
import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$migrateSettingsIfNeeded$1", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricAutoGuiSettingsImpl$migrateSettingsIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$migrateSettingsIfNeeded$1(ObricAutoGuiSettingsImpl r1, Continuation<? super ObricAutoGuiSettingsImpl$migrateSettingsIfNeeded$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricAutoGuiSettingsImpl$migrateSettingsIfNeeded$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L43;
        ResultKt.throwOnFailure(r11);
        ObricAutoGuiSettingsImpl r12 = this.this$0;
        Keva r0 = r12.a;
        Keva r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L8:
        if (r0.contains("auto_gui_app_migrated_action") == false) goto L16;
        Keva r2 = r12.a;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r2 = null;
    L13:
        if (r2.getBoolean("auto_gui_app_migrated_action", true) == false) goto L16;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "doMigrateSettingsIfNeeded, already migrated, skip");
    L41:
        return Unit.INSTANCE;
    L16:
        if (t1.a.getAutoGuiEnabledScene() != 1) goto L22;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "doMigrateSettingsIfNeeded, auto gui disabled, mark migrated only");
        Keva r13 = r12.a;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L21:
        r1.storeBoolean("auto_gui_app_migrated_action", true);
        goto L41
    L20:
        r1 = r13;
        goto L21
    L22:
        List r3 = r12.p(AppHost.a.getApplication().getApplicationContext());
        FLogger.a.i("ObricAutoGuiSettingsImpl", "doMigrateSettingsIfNeeded, appList size: " + r3.size());
        Iterator r4 = r3.iterator();
    L24:
        if (r4.hasNext() == false) goto L35;
        String r6 = (String) r4.next();
        Keva r7 = r12.a;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r7 = null;
    L29:
        if (r7.contains(r6) == false) goto L30;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "doMigrateSettingsIfNeeded, keep user setting for app: " + r6);
        goto L24
    L30:
        FLogger.a.i("ObricAutoGuiSettingsImpl", "doMigrateSettingsIfNeeded, set default enable for app: " + r6);
        Keva r8 = r12.a;
        if (r8 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r8 = null;
    L33:
        r8.storeBoolean(r6, true);
        goto L24
    L35:
        Keva r14 = r12.a;
        if (r14 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L39:
        r1.storeBoolean("auto_gui_app_migrated_action", true);
        goto L41
    L38:
        r1 = r14;
        goto L39
    L43:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
