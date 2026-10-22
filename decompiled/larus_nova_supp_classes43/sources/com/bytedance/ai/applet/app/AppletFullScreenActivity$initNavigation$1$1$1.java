package com.bytedance.ai.applet.app;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.app.view.AppletActionSheetDialog;
import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletFullScreenActivity$initNavigation$1$1$1", f = "AppletFullScreenActivity.kt", i = {0, 0}, l = {200}, m = "invokeSuspend", n = {"$this$launch", "isFirstOpenActionSheet"}, s = {"L$0", "I$0"})
final class AppletFullScreenActivity$initNavigation$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletApplication $app;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletFullScreenActivity this$0;

    /* JADX INFO: renamed from: com.bytedance.ai.applet.app.AppletFullScreenActivity$initNavigation$1$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.applet.app.AppletFullScreenActivity$initNavigation$1$1$1$1", f = "AppletFullScreenActivity.kt", i = {}, l = {225}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppletApplication $app;
        int label;
        final /* synthetic */ AppletFullScreenActivity this$0;

        public AnonymousClass1(AppletApplication r1, AppletFullScreenActivity r10, Continuation<? super AnonymousClass1> r11) {
            this.$app = r1;
            this.this$0 = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$app, this.this$0, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            AppletApplication r11 = this.$app;
            AppCompatActivity r12 = this.this$0;
            this.label = 1;
            if (r11.E(r12, true, this) != r0) goto L12;
            return r0;
        }
    }

    public AppletFullScreenActivity$initNavigation$1$1$1(AppletFullScreenActivity r1, AppletApplication r10, Continuation<? super AppletFullScreenActivity$initNavigation$1$1$1> r11) {
        this.this$0 = r1;
        this.$app = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletFullScreenActivity$initNavigation$1$1$1 r0 = new AppletFullScreenActivity$initNavigation$1$1$1(this.this$0, this.$app, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void INVOKEVIRTUAL_com_bytedance_ai_applet_app_AppletFullScreenActivity$initNavigation$1$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AppletActionSheetDialog r10) {
        Handler r0 = DialogLancet.resolveDialogHandler(r10);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r10);
        r10.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r10);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r10);
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
        r0.post(DialogLancet.createDismissRunnable(r10));
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [android.app.Dialog, com.bytedance.ai.applet.app.view.AppletActionSheetDialog] */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r10 = this.I$0;
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
    L12:
        CoroutineScope r12 = r11;
        AppMeta r16 = (AppMeta) r15;
        if (r16 == null) goto L16;
        String r13 = r16.getIconUrl();
        if (r13 == null) goto L16;
    L17:
        String r14 = r13;
        if (r16 == null) goto L21;
        String r17 = r16.getAppName();
        if (r17 == null) goto L21;
    L22:
        String r18 = r17;
        if (r16 == null) goto L26;
        String r19 = r16.getDescription();
        if (r19 == null) goto L26;
    L27:
        String r20 = r19;
        ConcurrentHashMap<Integer, com.bytedance.ai.applet.app.view.m> r110 = this.$app.n.b;
        AppletActionSheetDialog r21 = this.this$0.l;
        if (r21 == null) goto L30;
        INVOKEVIRTUAL_com_bytedance_ai_applet_app_AppletFullScreenActivity$initNavigation$1$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r21);
    L30:
        int r22 = AppletActionSheetDialog.f;
        AppletFullScreenActivity r23 = this.this$0;
        AppletActionSheetDialog.b r111 = new AppletActionSheetDialog.b(Boxing.boxInt(2131235790), r14, r18, r20, 16);
        List r24 = CollectionsKt.toList(this.$app.n.a.values());
        List r25 = CollectionsKt.toList(r110.values());
        final AppletApplication r26 = this.$app;
        final ?? r27 = AppletActionSheetDialog.a.a(r23, r111, r24, r25, new r(r26));
        final AppletFullScreenActivity r28 = this.this$0;
        r28.l = r27;
        AppletApplication r29 = this.$app;
        Job r30 = r28.m;
        if (r30 == null) goto L33;
        Job.DefaultImpls.cancel$default(r30, null, 1, null);
    L33:
        r27.setOnDismissListener(new q(r28, r27));
        r28.m = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r28), null, null, new AppletFullScreenActivity$observePinMenuStatus$2(r29, r28, r27, null), 3, null);
        if (r10 != 0) goto L36;
        BuildersKt.launch$default(r12, null, null, new AnonymousClass1(this.$app, this.this$0, null), 3, null);
    L36:
        AppletApplication r31 = this.this$0.e;
        if (r31 == null) goto L43;
        v r32 = r31.h();
        if (r32 == null) goto L43;
        com.bytedance.ai.applet.app.foundation.j r33 = r32.e();
        if (r33 == null) goto L43;
        r33.i("doubao_apps_info_panel_show", MapsKt.emptyMap());
    L43:
        List<com.bytedance.ai.applet.app.view.m> r112 = CollectionsKt.plus(CollectionsKt.toList(this.$app.n.a.values()), CollectionsKt.toList(r110.values()));
        AppletApplication r34 = this.this$0.e;
        if (r34 == null) goto L51;
        v r35 = r34.h();
        if (r35 == null) goto L51;
        com.bytedance.ai.applet.app.foundation.j r36 = r35.e();
        if (r36 == null) goto L51;
        r36.e(r112);
    L51:
        return Unit.INSTANCE;
    L26:
        r19 = this.$app.j().f;
    L21:
        r17 = this.$app.j().a;
    L16:
        r13 = this.$app.j().b();
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        r11 = (CoroutineScope) this.L$0;
        AppletFullScreenActivity r113 = this.this$0;
        int r37 = !r113.n ? 1 : 0;
        r113.n = true;
        AppletApplication r114 = this.$app;
        this.L$0 = r11;
        this.I$0 = r37;
        this.label = 1;
        r15 = r114.k(this);
        if (r15 != r0) goto L11;
        return r0;
    L11:
        r10 = r37;
        goto L12
    }
}
