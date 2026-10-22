package com.ss.android.lark.flow.chat.page;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.t;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.base.frame.FrameFragment;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.j;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.chatwindow.IllegalUserSessionException;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.theme.CodeBlockV2ThemeManager;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.f;
import zsb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\"\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0014J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u0010H\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006*"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/FlowChatActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "chatId", "", "activityHookManager", "Lcom/ss/android/lark/chat/core/extension/ActivityHookManager;", "mIsFromNotification", "", "TAG", "getTAG", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "configActivityHook", "setupActivityHookOnBackPressed", "onNewIntent", "intent", "Landroid/content/Intent;", "onActivityResult", "requestCode", "", "resultCode", "data", "resolveIntent", "fromNewIntent", "showChatFragment", "statisticsPrefIfNeed", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "shouldNotifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class FlowChatActivity extends Hilt_FlowChatActivity implements d0c.c, d {
    public String b;
    public final com.ss.android.lark.chat.core.extension.a c;
    public boolean d;

    public static final class a {
    }

    static {
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

    public final void B1() {
        PerfLog.start("showChatFragment", "");
        Bundle r0 = getIntent().getExtras();
        FragmentManager r1 = getSupportFragmentManager();
        ChatFragment r2 = new ChatFragment();
        r2.setArguments(r0);
        FragmentTransaction r3 = r1.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "content_fragment", R.id.content) == true) goto L6;
        r3.replace(R.id.content, r2, "content_fragment");
    L6:
        r3.commitAllowingStateLoss();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.flow.chat.page.Hilt_FlowChatActivity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    @Override // com.ss.android.lark.flow.chat.page.Hilt_FlowChatActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        ((itb.c) LarkContext.spiByDwarf(itb.c.class)).V(this);     // Catch: Throwable -> L8
        t.c(this);     // Catch: Throwable -> L8
        t.b(this);     // Catch: Throwable -> L8
        j.a.clear();     // Catch: Throwable -> L8
        CodeBlockV2ThemeManager.a();     // Catch: Throwable -> L8
        TableUtils.a = null;     // Catch: Throwable -> L8
        ColumnsUtils.a = null;     // Catch: Throwable -> L8
        TextLayoutBuilder.b();     // Catch: Throwable -> L8
        this.c.d();     // Catch: Throwable -> L8
        z6b.a.a = false;     // Catch: Throwable -> L8
        ChatCoreModule.a().getChatDependency().r();     // Catch: Throwable -> L8
        u.a.a.a();     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public FlowChatActivity() {
        this.c = new com.ss.android.lark.chat.core.extension.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final UserSession e9() {
        Intent r0 = getIntent();
        if (r0 != null) goto L5;
    L14:
        StringBuilder r2 = new StringBuilder("invalid intent, intent:");
        if (r0 != null) goto L17;
        boolean r1 = true;
    L18:
        r2.append(r1);
        Log.e(((BaseFragmentActivity) this).PARENT_TAG, new IllegalUserSessionException(r2.toString()), true);
        finish();
        return PassportcConvention.a(getApplication());
    L17:
        r1 = false;
        goto L18
    L5:
        if (r0.getExtras() == null) goto L14;
        if (r0.hasExtra("iji.convention.user_id") == true) goto L10;
    L11:
        Log.e(((BaseFragmentActivity) this).PARENT_TAG, new IllegalUserSessionException("provideUserSession invalid extra, id:" + r0.hasExtra("iji.convention.user_id") + ", key:" + r0.hasExtra("iji.convention.session_key")), true);
        PassportcConvention.e(r0, getApplication());
    L13:
        return PassportcConvention.c(this);
    L10:
        if (r0.hasExtra("iji.convention.session_key") == true) goto L13;
        goto L11
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m116provideComponent() {
        return provideComponent();
    }

    public static final String z1(FlowChatActivity r0) {
        return ((BaseFragmentActivity) r0).PARENT_TAG;
    }

    @Override // zsb.d
    public final boolean Cy(Notice r2) {
        String r0 = this.b;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return t0.a(r2, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        ImSdk r0 = ImSdk.a;
        boolean r1 = ImSdk.c;
        boolean r2 = OfficeSDKManager.isAvailable();
        if (r2 == false) goto L18;
        if (r1 == false) goto L18;
        ((BaseFragmentActivity) this).PARENT_TAG = "FlowChatActivity";
        int r3 = FlowChatModule.d;
        FlowChatModule.a.a().a().getPerfEnterChatMonitor().l(false);
        fsb.f.c(getClass().getSimpleName()).j();
        fsb.f.b().i("onCreate");
        disableColorNavigationBarBeforeOnCreate();
        super.onCreate(r5);
        zfb.a.a(this);
        if (FlowChatModule.a.a().a().getLoginDependency().isLogin() == true) goto L17;
        egb.f r6 = FlowChatModule.a.a().a().getLoginDependency();
        int r4 = ozb.b.a;
        Intrinsics.checkNotNullParameter("im_chat_window_check_logout", "scene");
        r6.a(this, new ozb.b());
        finish();
        return;
    L17:
        final OnBackPressedDispatcher r7 = getOnBackPressedDispatcher();
        r7.addCallback(this, new FlowChatActivity$setupActivityHookOnBackPressed$1(this, r7));
        A1(getIntent(), false);
        this.c.c(r5);
        WindowInsetsUtils.f(this);
        WindowInsetsUtils.d(this);
        WindowInsetsUtils.c(this).b(UIUtils.getColor(this, 2131102022));
        fsb.f.b().h("onCreate");
        return;
    L18:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r2 + ", im sdk ready: " + r1 + ", finish. " + getClass().getName());
        super.onCreate(r5);
        finish();
    }

    public final void onNewIntent(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r2);
        A1(r2, true);
        this.c.e(r2);
    }

    public final void A1(Intent r8, boolean r9) {
        Bundle r0 = r8.getExtras();
        if (r0 != null) goto L6;
        finish();
        return;
    L6:
        this.b = r0.getString("chatID");
        Log.i(((BaseFragmentActivity) this).PARENT_TAG, "Enter chat:" + this.b);
        fxa.b r1 = fxa.a.a(r0);
        if (getIntent() != null) goto L9;
    L11:
        String r2 = "";
    L12:
        boolean r3 = true;
        if (StringsKt.equals("notification", r2, true) == false) goto L15;
        ChatCoreModule.a().getPerfEnterChatMonitor().a(SourceType.PUSH.value);
        this.d = true;
    L16:
        Log.i(((BaseFragmentActivity) this).PARENT_TAG, "statisticsPrefIfNeed:" + r2 + ", isFromNotification:" + this.d);
        ChatFragment r4 = getSupportFragmentManager().findFragmentById(R.id.content);
        if (r4 == null) goto L46;
        if (r9 == false) goto L46;
        if ((r4 instanceof ChatFragment) == false) goto L41;
        ChatFragment r5 = r4;
        FrameFragment r10 = r5.T90();
        Bundle r6 = r8.getExtras();
        FrameFragment r7 = null;
        if (r6 == null) goto L24;
        fxa.b r11 = fxa.a.a(r6);
    L25:
        if (r11 == null) goto L27;
        r3 = r11.s();
    L27:
        if (r3 == false) goto L36;
        Log.i("ChatFragment", "ChatFragment: onNewIntent rebuild ChatWindow fragment");
        Bundle r12 = r8.getExtras();
        if (r12 != null) goto L32;
        Log.e("ChatFragment", "extras == null");
        return;
    L32:
        if (fxa.a.a(r12).getChatId() != null) goto L34;
        Log.e("ChatFragment", "chatId == null");
        return;
    L34:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r5), null, null, new ChatFragment$setupContentFragment$1(r5, r12, null), 3, null);
        return;
    L36:
        if ((r10 instanceof FrameFragment) == false) goto L38;
        r7 = r10;
    L38:
        if (r7 == null) goto L51;
        r7.A0(r8);
        return;
    L51:
        return;
    L24:
        r11 = null;
        goto L25
    L41:
        if ((r4 instanceof FrameFragment) == true) goto L43;
        return;
    L43:
        if (r1.s() == false) goto L45;
        Log.i(((BaseFragmentActivity) this).PARENT_TAG, "ChatWindowActivity: onNewIntent rebuild ChatWindow fragment");
        B1();
        return;
    L45:
        ((FrameFragment) r4).A0(r8);
        return;
    L46:
        B1();
        return;
    L15:
        this.d = false;
        goto L16
    L9:
        if (getIntent().getExtras() == null) goto L11;
        r2 = r1.q();
        goto L12
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r3, r4, r5);
        Fragment r0 = getSupportFragmentManager().findFragmentById(R.id.content);
        if (r0 == null) goto L5;
        r0.onActivityResult(r3, r4, r5);
    L5:
        this.c.a(r3, r4, r5);
    }
}
