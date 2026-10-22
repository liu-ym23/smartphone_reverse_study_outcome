package com.bytedance.ai.applet.app;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.app.view.AppletActionSheetDialog;
import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
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
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletEightScreenActivity$showOptionsMenu$1", f = "AppletEightScreenActivity.kt", i = {0, 0}, l = {327}, m = "invokeSuspend", n = {"$this$launch", "isFirstOpenActionSheet"}, s = {"L$0", "I$0"})
final class AppletEightScreenActivity$showOptionsMenu$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletApplication $app;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletEightScreenActivity this$0;

    /* JADX INFO: renamed from: com.bytedance.ai.applet.app.AppletEightScreenActivity$showOptionsMenu$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.applet.app.AppletEightScreenActivity$showOptionsMenu$1$1", f = "AppletEightScreenActivity.kt", i = {}, l = {349}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppletApplication $app;
        int label;
        final /* synthetic */ AppletEightScreenActivity this$0;

        public AnonymousClass1(AppletApplication r1, AppletEightScreenActivity r10, Continuation<? super AnonymousClass1> r11) {
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

    public /* synthetic */ class a implements com.bytedance.ai.applet.app.view.n, FunctionAdapter {
        public final /* synthetic */ AppletApplication a;

        public a(AppletApplication r1) {
            this.a = r1;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof com.bytedance.ai.applet.app.view.n) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference(1, this.a, AppletApplication.class, "onOptionsItemSelected", "onOptionsItemSelected(Lcom/bytedance/ai/applet/app/view/MenuItem;)Z", 8);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.bytedance.ai.applet.app.view.n
        public final void a(com.bytedance.ai.applet.app.view.m r10) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            this.a.w(r10);
        }
    }

    public AppletEightScreenActivity$showOptionsMenu$1(AppletEightScreenActivity r1, AppletApplication r10, Continuation<? super AppletEightScreenActivity$showOptionsMenu$1> r11) {
        this.this$0 = r1;
        this.$app = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletEightScreenActivity$showOptionsMenu$1 r0 = new AppletEightScreenActivity$showOptionsMenu$1(this.this$0, this.$app, r11);
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
    public static void INVOKEVIRTUAL_com_bytedance_ai_applet_app_AppletEightScreenActivity$showOptionsMenu$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AppletActionSheetDialog r10) {
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

    /* JADX WARN: Type inference failed for: r4v15, types: [android.app.Dialog, com.bytedance.ai.applet.app.view.AppletActionSheetDialog] */
    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        int r11 = this.I$0;
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);
        Object r13 = r20;
    L12:
        CoroutineScope r14 = r12;
        AppMeta r15 = (AppMeta) r13;
        if (this.this$0.isFinishing() == false) goto L15;
    L56:
        com.bytedance.ai.utils.g.a.w("AppletEightScreenActivity", "showOptionsMenu: activity is unavailable after loading meta info");
        return Unit.INSTANCE;
    L15:
        if (this.this$0.isDestroyed() == true) goto L56;
        List r16 = AppletEightScreenActivity.c2(this.this$0, this.$app);
        AppletActionSheetDialog r17 = this.this$0.v;
        if (r17 == null) goto L20;
        INVOKEVIRTUAL_com_bytedance_ai_applet_app_AppletEightScreenActivity$showOptionsMenu$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r17);
    L20:
        int r18 = AppletActionSheetDialog.f;
        AppletEightScreenActivity r19 = this.this$0;
        Integer r110 = Boxing.boxInt(2131235790);
        if (r15 == null) goto L24;
        String r21 = r15.getIconUrl();
        if (r21 == null) goto L24;
    L25:
        String r111 = r21;
        if (r15 == null) goto L29;
        String r22 = r15.getAppName();
        if (r22 == null) goto L29;
    L30:
        String r112 = r22;
        if (r15 == null) goto L34;
        String r23 = r15.getDescription();
        if (r23 == null) goto L34;
    L35:
        final ?? r24 = AppletActionSheetDialog.a.a(r19, new AppletActionSheetDialog.b(r110, r111, r112, r23, 16), CollectionsKt.toList(this.$app.n.a.values()), r16, new a(this.$app));
        final AppletEightScreenActivity r25 = this.this$0;
        r25.v = r24;
        AppletApplication r26 = this.$app;
        Job r27 = r25.w;
        Boolean r113 = null;
        if (r27 == null) goto L38;
        Job.DefaultImpls.cancel$default(r27, null, 1, null);
    L38:
        r24.setOnDismissListener(new h(r25, r24));
        r25.w = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r25), null, null, new AppletEightScreenActivity$observePinMenuStatus$2(r26, r25, r24, null), 3, null);
        if (r11 != 0) goto L41;
        BuildersKt.launch$default(r14, null, null, new AnonymousClass1(this.$app, this.this$0, null), 3, null);
    L41:
        com.bytedance.ai.applet.app.foundation.j r28 = this.$app.h().e();
        r28.getClass();
        r28.i("doubao_apps_info_panel_show", MapsKt.emptyMap());
        this.$app.h().e().e(CollectionsKt.plus(CollectionsKt.toList(this.$app.n.a.values()), r16));
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r29 = AppletRuntimeManager.d;
        if (r29 == null) goto L46;
        Map<String, Object> r30 = r29.getSettings();
        if (r30 == null) goto L46;
        Object r31 = r30.get("appsMultiworkEntranceEnable");
    L48:
        if ((r31 instanceof Boolean) == false) goto L50;
        r113 = (Boolean) r31;
    L50:
        boolean r32 = Intrinsics.areEqual(r113, Boxing.boxBoolean(true));
        com.bytedance.ai.utils.g r33 = com.bytedance.ai.utils.g.a;
        StringBuilder r34 = new StringBuilder("showOptionsMenu: action sheet shown, appsMultiworkEntranceEnable=");
        r34.append(r32);
        r34.append(", secondRowItemIds=");
        ArrayList r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r36 = ((ArrayList) r16).iterator();
    L52:
        if (r36.hasNext() == false) goto L54;
        r35.add(Boxing.boxInt(((com.bytedance.ai.applet.app.view.m) r36.next()).a));
        goto L52
    L54:
        r34.append(r35);
        r33.i("AppletEightScreenActivity", r34.toString());
        return Unit.INSTANCE;
    L46:
        r31 = null;
    L34:
        r23 = this.$app.j().f;
    L29:
        r22 = this.$app.j().a;
    L24:
        r21 = this.$app.j().b();
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        r12 = (CoroutineScope) this.L$0;
        AppletEightScreenActivity r37 = this.this$0;
        int r38 = !r37.x ? 1 : 0;
        r37.x = true;
        AppletApplication r39 = this.$app;
        this.L$0 = r12;
        this.I$0 = r38;
        this.label = 1;
        r13 = r39.k(this);
        if (r13 != r1) goto L11;
        return r1;
    L11:
        r11 = r38;
        goto L12
    }
}
