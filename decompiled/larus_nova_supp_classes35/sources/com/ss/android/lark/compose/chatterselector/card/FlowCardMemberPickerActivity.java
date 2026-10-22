package com.ss.android.lark.compose.chatterselector.card;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.lark.kmp.rustclient.api.d;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.compose.chatsetting.common.platform.AndroidChatSettingPlatformEffects;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/compose/chatterselector/card/FlowCardMemberPickerActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "callbackKey", BuildConfig.FLAVOR, "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "submitSelectedIds", "selectedIds", BuildConfig.FLAVOR, "chatId", "notifyErrorAndFinish", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "resolveTitle", "title", "toErrorResult", "throwable", BuildConfig.FLAVOR, "PickerMode", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCardMemberPickerActivity extends Hilt_FlowCardMemberPickerActivity implements c {
    public static final a c = null;
    public static final Map<String, IGetDataCallback<List<ChatChatter>>> d = null;
    public String b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/compose/chatterselector/card/FlowCardMemberPickerActivity$PickerMode;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GROUP", "TARGET", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PickerMode extends Enum<PickerMode> {
        public static final a Companion = null;
        public static final PickerMode GROUP = null;
        public static final PickerMode TARGET = null;
        public static final /* synthetic */ PickerMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<PickerMode> getEntries() {
            return b;
        }

        static {
            PickerMode r0 = new PickerMode("GROUP", 0, "group");
            GROUP = r0;
            PickerMode r1 = new PickerMode("TARGET", 1, "target");
            TARGET = r1;
            PickerMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static PickerMode[] values() {
            return (PickerMode[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static PickerMode valueOf(String r1) {
            return (PickerMode) r27.a.a(PickerMode.class, r1);
        }

        public PickerMode(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public a() {
        }

        public static void a(Activity r9, String r10, List r11, boolean r12, String r13, IGetDataCallback r14) {
            if (r9 == null) goto L17;
            if (r10 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == true) goto L17;
            if (r14 == null) goto L17;
            PickerMode r2 = PickerMode.GROUP;
            List r4 = CollectionsKt.emptyList();
            if (r11 != null) goto L15;
            r11 = CollectionsKt.emptyList();
        L15:
            b(r9, r2, r10, r4, r11, r12, r13, r14);
            return;
        L5:
            if (StringsKt.isBlank(r10) == true) goto L8;
            r0 = false;
        L17:
            if (r14 == null) goto L20;
            r14.onError(new ErrorResult("invalid group member picker arguments"));
            return;
        }

        public static void c(Activity r8, List r9, List r10, boolean r11, String r12, String r13, IGetDataCallback r14) {
            if (r8 == null) goto L28;
            if (r14 == null) goto L28;
            if (r9 != null) goto L7;
            r9 = CollectionsKt.emptyList();
        L7:
            List r15 = r9;
            if (r15.isEmpty() == false) goto L19;
            r15 = null;
            if (r13 != null) goto L12;
        L17:
            if (r15 != null) goto L19;
            r15 = CollectionsKt.emptyList();
            goto L19
        L12:
            if ((!StringsKt.isBlank(r13)) == true) goto L15;
            r13 = null;
        L15:
            if (r13 == null) goto L17;
            r15 = CollectionsKt.listOf(r13);
        L19:
            List r3 = CollectionsKt.distinct(r15);
            if (r3.isEmpty() == false) goto L23;
            r14.onError(new ErrorResult("target member picker candidate ids are empty"));
            return;
        L23:
            PickerMode r1 = PickerMode.TARGET;
            if (r10 != null) goto L26;
            r10 = CollectionsKt.emptyList();
        L26:
            b(r8, r1, null, r3, r10, r11, r12, r14);
            return;
        L28:
            if (r14 == null) goto L31;
            r14.onError(new ErrorResult("invalid target member picker arguments"));
            return;
        }

        public static void b(Activity r3, PickerMode r4, String r5, List r6, List r7, boolean r8, String r9, IGetDataCallback r10) {
            String r0 = UUID.randomUUID().toString();
            ((ConcurrentHashMap) FlowCardMemberPickerActivity.d).put(r0, r10);
            Intent r1 = new Intent(r3, FlowCardMemberPickerActivity.class);
            r1.putExtra("callback_key", r0);
            r1.putExtra("picker_mode", r4.getValue());
            r1.putExtra("chat_id", r5);
            r1.putStringArrayListExtra("chatter_ids", new ArrayList(r6));
            r1.putStringArrayListExtra("selected_ids", new ArrayList(CollectionsKt.distinct(r7)));
            r1.putExtra("single_choice", r8);
            r1.putExtra("title", r9);
            PassportcConvention.e(r1, LarkContext.getApplication());
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
            r3.startActivity(r1);     // Catch: Throwable -> L5
            Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L13;
            ((ConcurrentHashMap) FlowCardMemberPickerActivity.d).remove(r0);
            r10.onError(new ErrorResult(new Exception(r13)));
            return;
        L13:
            return;
        L5:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    static {
        c = new a();
        d = new ConcurrentHashMap();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.compose.chatterselector.card.Hilt_FlowCardMemberPickerActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FlowCardMemberPickerActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(Bridge.TRANSFER_MAX_SIZE);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.compose.chatterselector.card.Hilt_FlowCardMemberPickerActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowCardMemberPickerActivity.class.getName()));
    L5:
        String r0 = this.b;
        if (r0 != null) goto L8;
    L16:
        super.onDestroy();
        return;
    L8:
        if (isFinishing() == false) goto L10;
    L11:
        IGetDataCallback r1 = (IGetDataCallback) ((ConcurrentHashMap) d).remove(r0);
        if (r1 == null) goto L16;
        if (isFinishing() == true) goto L16;
        r1.onError(new ErrorResult("card member picker destroyed"));
        goto L16
    L10:
        if (isChangingConfigurations() == true) goto L16;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final UserSession e9() {
        Intent r0 = getIntent();
        if (r0 != null) goto L5;
    L14:
        StringBuilder r2 = new StringBuilder("provideUserSession: invalid intent, intent is null: ");
        if (r0 != null) goto L17;
        boolean r1 = true;
    L18:
        r2.append(r1);
        Log.e("FlowCardMemberPickerActivity", r2.toString());
        finish();
        return PassportcConvention.a(getApplication());
    L17:
        r1 = false;
        goto L18
    L5:
        if (r0.getExtras() == null) goto L14;
        if (r0.hasExtra("iji.convention.user_id") == true) goto L10;
    L11:
        Log.e("FlowCardMemberPickerActivity", "provideUserSession: missing session extra, userId: " + r0.hasExtra("iji.convention.user_id") + ", sessionKey: " + r0.hasExtra("iji.convention.session_key"));
        PassportcConvention.e(r0, getApplication());
    L13:
        return PassportcConvention.c(this);
    L10:
        if (r0.hasExtra("iji.convention.session_key") == true) goto L13;
        goto L11
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

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m889provideComponent() {
        return provideComponent();
    }

    public FlowCardMemberPickerActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r14) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r14);
        String r0 = getIntent().getStringExtra("callback_key");
        this.b = r0;
        ImSdk r1 = ImSdk.a;
        boolean r2 = ImSdk.c;
        boolean r3 = OfficeSDKManager.isAvailable();
        boolean r4 = false;
        if (r3 == false) goto L73;
        if (r2 == false) goto L73;
        if (r0 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L22;
    L72:
        Log.e("FlowCardMemberPickerActivity", "callback is missing, finish card member picker");
        finish();
        return;
    L22:
        if (((ConcurrentHashMap) d).containsKey(r0) == false) goto L72;
        PickerMode.a r6 = PickerMode.Companion;
        String r7 = getIntent().getStringExtra("picker_mode");
        r6.getClass();
        PickerMode[] r8 = PickerMode.values();
        int r9 = r8.length;
        int r10 = 0;
    L26:
        if (r10 >= r9) goto L31;
        PickerMode r11 = r8[r10];
        if (Intrinsics.areEqual(r11.getValue(), r7) == true) goto L32;
        r10 = r10 + 1;
    L32:
        if (r11 != null) goto L34;
        final PickerMode r12 = PickerMode.GROUP;
    L35:
        String r13 = getIntent().getStringExtra("chat_id");
        if (r13 != null) goto L38;
        r13 = BuildConfig.FLAVOR;
    L38:
        final String r15 = r13;
        List r16 = getIntent().getStringArrayListExtra("chatter_ids");
        if (r16 != null) goto L41;
        r16 = CollectionsKt.emptyList();
    L41:
        final List r17 = r16;
        if (r12 != PickerMode.GROUP) goto L46;
        if (StringsKt.isBlank(r15) == false) goto L46;
    L49:
        ErrorResult r18 = new ErrorResult("invalid card member picker arguments");
        String r19 = this.b;
        if (r19 == null) goto L54;
        IGetDataCallback r20 = (IGetDataCallback) ((ConcurrentHashMap) d).remove(r19);
        if (r20 == null) goto L54;
        r20.onError(r18);
    L54:
        finish();
        return;
    L46:
        if (r12 == PickerMode.TARGET) goto L48;
    L55:
        UserSession r21 = e9();
        final d r22 = com.ss.android.lark.compose.chatsetting.common.repository.b.a(r21);
        final String r23 = getIntent().getStringExtra("title");
        if (r23 != null) goto L58;
    L61:
        boolean r24 = true;
    L62:
        if (r24 == false) goto L65;
        r23 = getString(2131891991);
    L65:
        final boolean r25 = getIntent().getBooleanExtra("single_choice", false);
        Iterable r26 = getIntent().getStringArrayListExtra("selected_ids");
        if (r26 != null) goto L68;
        r26 = CollectionsKt.emptyList();
    L68:
        List r27 = r26;
        if (r25 == false) goto L71;
        r27 = CollectionsKt.take(r27, 1);
    L71:
        final Set r28 = CollectionsKt.toSet(r27);
        final AndroidChatSettingPlatformEffects r29 = new AndroidChatSettingPlatformEffects(r21);
        com.ss.android.lark.compose.util.f.a(this, 2131102028);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1788759984, true, new AnonymousClass2(r12, r23, r15, r22, r29, r28, r25, this, r17)), 1, null);
        return;
    L58:
        if (StringsKt.isBlank(r23) == true) goto L61;
        r24 = false;
        goto L62
    L48:
        if (r17.isEmpty() == false) goto L55;
    L34:
        r12 = r11;
        goto L35
    L31:
        r11 = null;
        goto L32
    L16:
        if (StringsKt.isBlank(r0) == true) goto L19;
        r5 = false;
    L73:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r3 + ", im sdk ready: " + r2 + ", finish. " + FlowCardMemberPickerActivity.class.getName());
        finish();
        if (r0 != null) goto L76;
    L77:
        r4 = true;
    L78:
        if (r4 == true) goto L90;
        IGetDataCallback r30 = (IGetDataCallback) ((ConcurrentHashMap) d).remove(r0);
        if (r30 == null) goto L91;
        r30.onError(new ErrorResult("office sdk is not available"));
        return;
    L91:
        return;
    L90:
        return;
    L76:
        if (StringsKt.isBlank(r0) == false) goto L78;
        goto L77
    }

    public static final void z1(FlowCardMemberPickerActivity r11, Set r12, String r13) {
        String r4 = r11.b;
        if (r4 == null) goto L7;
        FlowCardMemberRepository r1 = new FlowCardMemberRepository(com.ss.android.lark.compose.chatsetting.common.repository.b.a(r11.e9()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), null, null, new FlowCardMemberPickerActivity$submitSelectedIds$1(r1, r12, r13, r4, r11, null), 3, null);
        return;
    }
}
