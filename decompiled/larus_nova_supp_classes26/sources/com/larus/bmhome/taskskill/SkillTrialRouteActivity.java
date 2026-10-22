package com.larus.bmhome.taskskill;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.connector.t;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.exp.o;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatConversationService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u001e\u0010\u0012\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/taskskill/SkillTrialRouteActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "buildRouteParams", "tryApplySkillToCurrentChat", "", "routeParams", "readParam", "", "extras", "queryUri", "Landroid/net/Uri;", "key", "putStringIfNotBlank", "value", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SkillTrialRouteActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int g = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.bmhome.taskskill.SkillTrialRouteActivity$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.taskskill.SkillTrialRouteActivity$onCreate$1", f = "SkillTrialRouteActivity.kt", i = {1, 2}, l = {58, 62, GuidePriority.VLM_REALTIME_CALL_PRIORITY}, m = "invokeSuspend", n = {"localConversationId", "mainConversation"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $inputText;
        final /* synthetic */ Bundle $routeParams;
        final /* synthetic */ String $selectedSkillsPayload;
        Object L$0;
        int label;
        final /* synthetic */ SkillTrialRouteActivity this$0;

        public AnonymousClass1(SkillTrialRouteActivity r1, Bundle r2, String r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$routeParams = r2;
            this.$selectedSkillsPayload = r3;
            this.$inputText = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$routeParams, this.$selectedSkillsPayload, this.$inputText, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r23) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            String r6 = "";
            String r7 = null;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            wc9.e r3 = (wc9.e) this.L$0;
            ResultKt.throwOnFailure(r23);
            Object r8 = r23;
            wc9.e r17 = r3;
        L53:
            String r16 = (String) r8;
            if (r16 != null) goto L56;
        L59:
            boolean r4 = true;
        L60:
            if (r4 == false) goto L63;
            FLogger.a.w("SkillTrialRouteActivity", "[onCreate] skip skill trial, botId is blank");
            this.this$0.finish();
            return Unit.INSTANCE;
        L63:
            IAIChatConversationService.Companion r14 = IAIChatConversationService.a;
            FlowCommonAppCompatActivity r15 = this.this$0;
            String r18 = this.$routeParams.getString("enter_method");
            String r19 = this.$routeParams.getString("previous_page");
            Bundle r20 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("selected_skills", this.$selectedSkillsPayload), TuplesKt.to("input_text", this.$inputText)});
            com.larus.bmhome.chat.mode.a.a(r20);
            Unit r5 = Unit.INSTANCE;
            IAIChatConversationService.a.a(r14, r15, r16, r17, r18, r19, r20, 384);
            this.this$0.finish();
            return Unit.INSTANCE;
        L56:
            if (StringsKt.isBlank(r16) == true) goto L59;
            r4 = false;
            goto L60
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            String r9 = (String) this.L$0;
            ResultKt.throwOnFailure(r23);
            Object r10 = r23;
        L26:
            String r11 = (String) r10;
            if (r11 == null) goto L31;
            r6 = r11;
        L31:
            if (r9.length() != 0) goto L33;
            boolean r12 = true;
        L34:
            if (r12 == false) goto L36;
        L47:
            FLogger.a.w("SkillTrialRouteActivity", "[onCreate] skip downgraded skill trial, local conversation is unavailable");
            this.this$0.finish();
            return Unit.INSTANCE;
        L36:
            if (r6.length() != 0) goto L38;
            boolean r13 = true;
        L39:
            if (r13 == true) goto L47;
            Bundle r21 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("argConversationId", r9), TuplesKt.to("argBotId", r6), TuplesKt.to("argBotConversationType", Boxing.boxInt(3)), TuplesKt.to("is_create_sub_conversation", Boxing.boxBoolean(true)), TuplesKt.to("arg_need_to_show_ime", Boxing.boxBoolean(true)), TuplesKt.to("enter_method", this.$routeParams.getString("enter_method")), TuplesKt.to("previous_page", this.$routeParams.getString("previous_page")), TuplesKt.to("selected_skills", this.$selectedSkillsPayload), TuplesKt.to("input_text", this.$inputText)});
            com.larus.bmhome.chat.mode.a.a(r21);
            FlowCommonAppCompatActivity r22 = this.this$0;
            if (z2.a.enableChatWithTab() == false) goto L44;
            String r24 = "//flow/chat_page";
        L45:
            com.bytedance.router.i r25 = SmartRouter.buildRoute(r22, r24);
            r25.c.addFlags(67108864);
            r25.c.putExtras(r21);
            r25.d();
            this.this$0.finish();
            return Unit.INSTANCE;
        L44:
            r24 = "//flow/chat_page_bridge";
            goto L45
        L38:
            r13 = false;
            goto L39
        L33:
            r12 = false;
            goto L34
        L11:
            ResultKt.throwOnFailure(r23);
            Object r26 = r23;
        L17:
            wc9.e r27 = (wc9.e) r26;
            if (r27 == null) goto L20;
            r7 = r27.a;
        L20:
            if (r7 != null) goto L22;
            r7 = "";
        L22:
            LocalSubConvHelper r110 = LocalSubConvHelper.a;
            this.L$0 = r7;
            this.label = 2;
            r10 = r110.f(r27, this);
            if (r10 != r1) goto L25;
            return r1;
        L25:
            r9 = r7;
            goto L26
        L12:
            ResultKt.throwOnFailure(r23);
            if (o.a() == false) goto L49;
            LocalSubConvHelper r28 = LocalSubConvHelper.a;
            String r111 = AccountService.a.getSecUserId();
            this.label = 1;
            r26 = r28.c(r111, null, this);
            if (r26 != r1) goto L17;
            return r1;
        L49:
            wc9.e r29 = (wc9.e) AuthModelDelegate.b.y().getValue();
            LocalSubConvHelper r30 = LocalSubConvHelper.a;
            this.L$0 = r29;
            this.label = 3;
            r8 = r30.f(r29, this);
            if (r8 != r1) goto L52;
            return r1;
        L52:
            r17 = r29;
            goto L53
        }
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(SkillTrialRouteActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(SkillTrialRouteActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public SkillTrialRouteActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r13) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r13);
        Intent r14 = getIntent();
        Fragment r0 = null;
        if (r14 == null) goto L13;
        Bundle r15 = r14.getExtras();
    L14:
        Intent r1 = getIntent();
        if (r1 == null) goto L17;
        Uri r2 = r1.getData();
    L19:
        if (Intrinsics.areEqual(O1(r15, r2, "close_all_above_chat_page"), "1") == false) goto L21;
        StateFlowImpl r16 = t.a;
        r16.setValue(Long.valueOf(((Number) r16.getValue()).longValue() + 1));
    L21:
        Intent r17 = getIntent();
        if (r17 == null) goto L24;
        Bundle r18 = r17.getExtras();
    L25:
        Intent r3 = getIntent();
        if (r3 == null) goto L28;
        Uri r4 = r3.getData();
    L29:
        Bundle r5 = new Bundle();
        N1(r5, "selected_skills", O1(r18, r4, "selected_skills"));
        N1(r5, "input_text", O1(r18, r4, "input_text"));
        N1(r5, "skill_type", O1(r18, r4, "skill_type"));
        N1(r5, "enter_method", O1(r18, r4, "enter_method"));
        N1(r5, "previous_page", O1(r18, r4, "previous_page"));
        String r19 = r5.getString("input_text");
        boolean r6 = false;
        if (r19 != null) goto L32;
    L35:
        boolean r110 = true;
    L36:
        if (r110 == false) goto L70;
        String r111 = r5.getString("skill_type");
        if (r111 == null) goto L41;
        Integer r112 = StringsKt.toIntOrNull(r111);
    L42:
        e2 r7 = e2.a;
        String r8 = r5.getString("selected_skills");
        r7.getClass();
        TaskSkill r113 = (TaskSkill) CollectionsKt.firstOrNull(e2.a(r8, r112));
        if (r113 == null) goto L70;
        be8.b r114 = r113.h();
        String r9 = r114.c;
        if (r9 != null) goto L47;
    L50:
        boolean r10 = true;
    L51:
        if (r10 == true) goto L70;
        if (r114.getType() <= 0) goto L70;
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L70;
        r11.P();
        final ChatServiceImpl r12 = ChatServiceImpl.a;
        Activity r20 = AppHost.a.a().a(this, new d2(r12));
        if (r20 == null) goto L70;
        Fragment r21 = r12.a(r20);
        if (r21 == null) goto L70;
        if (r21.isAdded() == false) goto L65;
        r0 = r21;
    L65:
        if (r0 == null) goto L70;
        ICoreInputAbility r22 = s1a.a.g(r0).getAbility(ICoreInputAbility.class);
        if (r22 == null) goto L70;
        boolean r115 = r22.fa(r114);
    L72:
        if (r115 == false) goto L74;
        FLogger.a.i("SkillTrialRouteActivity", "[onCreate] applied skill trial to current chat");
        finish();
        return;
    L74:
        String r23 = r5.getString("selected_skills");
        String r116 = r5.getString("input_text");
        FLogger r24 = FLogger.a;
        StringBuilder r25 = new StringBuilder("[onCreate] open chat for skill trial, hasSkills=");
        if (r23 != null) goto L77;
    L80:
        boolean r26 = true;
    L81:
        r25.append(!r26);
        r25.append(", hasInputText=");
        if (r116 != null) goto L84;
    L85:
        r6 = true;
    L86:
        r25.append(true ^ r6);
        r24.i("SkillTrialRouteActivity", r25.toString());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, r5, r23, r116, null), 3, null);
        return;
    L84:
        if (StringsKt.isBlank(r116) == false) goto L86;
    L77:
        if (StringsKt.isBlank(r23) == true) goto L80;
        r26 = false;
        goto L81
    L47:
        if (StringsKt.isBlank(r9) == true) goto L50;
        r10 = false;
        goto L51
    L41:
        r112 = null;
    L70:
        r115 = false;
        goto L72
    L32:
        if (StringsKt.isBlank(r19) == true) goto L35;
        r110 = false;
        goto L36
    L28:
        r4 = null;
        goto L29
    L24:
        r18 = null;
        goto L25
    L17:
        r2 = null;
        goto L19
    L13:
        r15 = null;
        goto L14
    }

    public static void N1(Bundle r1, String r2, String r3) {
        if (StringsKt.isBlank(r3) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r1.putString(r2, r3);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static String O1(Bundle r2, Uri r3, String r4) {
        String r0 = null;
        if (r2 == null) goto L5;
        String r5 = r2.getString(r4);
    L6:
        if (r5 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        r5 = null;
    L15:
        if (r5 != null) goto L22;
        if (r3 == null) goto L18;
        r0 = UriProtector.getQueryParameter(r3, r4);
    L18:
        if (r0 != null) goto L21;
        return "";
    L21:
        return r0;
    L22:
        return r5;
    L8:
        if (StringsKt.isBlank(r5) == true) goto L11;
        r1 = false;
        goto L12
    L5:
        r5 = null;
        goto L6
    }
}
