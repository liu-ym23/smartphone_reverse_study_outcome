package com.larus.setting.impl.iconchanger;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.e0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.home.api.main.AppIconsType;
import com.larus.platform.service.AccountService;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconManager$postShowSyncDialog$1", f = "ChangeAppIconManager.kt", i = {}, l = {286}, m = "invokeSuspend", n = {}, s = {})
public final class ChangeAppIconManager$postShowSyncDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $useLocalBot;
    int label;

    public ChangeAppIconManager$postShowSyncDialog$1(boolean r1, Continuation<? super ChangeAppIconManager$postShowSyncDialog$1> r2) {
        this.$useLocalBot = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChangeAppIconManager$postShowSyncDialog$1(this.$useLocalBot, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        AppHost.Companion r12 = AppHost.a;
        FragmentActivity r3 = r12.a().getCurrentActivity();
        if ((r3 instanceof FragmentActivity) == false) goto L14;
        FragmentActivity r4 = r3;
    L15:
        if (r4 == null) goto L49;
        boolean r5 = this.$useLocalBot;
        if (r4.isFinishing() == true) goto L49;
        WeakReference<CommonDialog> r6 = ChangeAppIconManager.a;
        new WeakReference(r4);
        if (Build.VERSION.SDK_INT < 29) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L49;
        if (AccountService.a.isLogin().booleanValue() == false) goto L49;
        AuthModelDelegate r8 = AuthModelDelegate.b;
        c1 r9 = (c1) r8.c().getValue();
        if (r9 == null) goto L30;
        e0 r10 = (e0) r9.d;
    L31:
        if (r10 == null) goto L49;
        r12.getApplication();
        c1 r13 = (c1) r8.c().getValue();
        if (r13 == null) goto L38;
        e0 r14 = (e0) r13.d;
        if (r14 == null) goto L38;
        List r15 = r14.p();
    L39:
        List r16 = r15;
        if (r16 != null) goto L42;
    L45:
        if (r2 == false) goto L47;
        ChangeAppIconManager.h(AppIconsType.DEFAULT.getAppIconId());
    L47:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4), null, null, new ChangeAppIconManager$tryShowSyncDialog$1(r5, null), 3, null);
        goto L49
    L42:
        if (r16.isEmpty() == true) goto L45;
        r2 = false;
    L38:
        r15 = null;
        goto L39
    L30:
        r10 = null;
        goto L31
    L21:
        r7 = false;
    L49:
        return Unit.INSTANCE;
    L14:
        r4 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        this.label = 1;
        if (DelayKt.delay(3000, this) != r0) goto L11;
        return r0;
    }
}
