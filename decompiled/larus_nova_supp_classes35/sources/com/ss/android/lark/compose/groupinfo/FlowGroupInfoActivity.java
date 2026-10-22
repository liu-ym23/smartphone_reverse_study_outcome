package com.ss.android.lark.compose.groupinfo;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"Lcom/ss/android/lark/compose/groupinfo/FlowGroupInfoActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "photoPicker", "Lcom/ss/android/lark/biz/officesdk/im/photopicker/IOfficeSDKPhotoPicker;", "getPhotoPicker", "()Lcom/ss/android/lark/biz/officesdk/im/photopicker/IOfficeSDKPhotoPicker;", "photoPicker$delegate", "Lkotlin/Lazy;", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "finish", "Companion", "flow-chat_productionChinaRelease", "viewModel", "Lcom/ss/android/lark/compose/groupinfo/GroupInfoViewModel;"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowGroupInfoActivity extends Hilt_FlowGroupInfoActivity implements d0c.c {
    public static final /* synthetic */ int c = 0;
    public final Lazy b;

    public static final class a {
    }

    public static final class b<O> implements ActivityResultCallback {
        public static final b<O> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void onActivityResult(Object r3) {
            int r0 = com.ss.android.lark.compose.groupinfo.c.a;
            com.ss.android.lark.compose.groupinfo.c.b("FlowGroupInfoActivity pickLauncher " + ((Uri) r3));
        }
    }

    public static final class c<O> implements ActivityResultCallback {
        public final /* synthetic */ Lazy<GroupInfoViewModel> a;

        public c(ViewModelLazy r1) {
            this.a = r1;
        }

        public final void onActivityResult(Object r3) {
            ActivityResult r4 = (ActivityResult) r3;
            if (r4.getResultCode() != (-1)) goto L19;
            Intent r5 = r4.getData();
            if (r5 == null) goto L9;
            Bundle r6 = r5.getExtras();
            if (r6 == null) goto L9;
            String r7 = r6.getString("key_pic_uri");
        L10:
            if (r7 != null) goto L12;
            r7 = BuildConfig.FLAVOR;
        L12:
            int r0 = com.ss.android.lark.compose.groupinfo.c.a;
            com.ss.android.lark.compose.groupinfo.c.b("FlowGroupInfoActivity pickSDKLauncher uri = ".concat(r7));
            if (r7.length() <= 0) goto L15;
            boolean r1 = true;
        L16:
            if (r1 == false) goto L20;
            Lazy<GroupInfoViewModel> r2 = this.a;
            int r8 = FlowGroupInfoActivity.c;
            ((GroupInfoViewModel) r2.getValue()).changeSelectedImageUri(r7);
            return;
        L20:
            return;
        L15:
            r1 = false;
        L9:
            r7 = null;
            goto L10
        }
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

    /* JADX INFO: Removed unreachable split cross block B:53:0x0107 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.compose.groupinfo.Hilt_FlowGroupInfoActivity
    public final void finish() {
        KeyboardUtils.hideKeyboard(this);
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FlowGroupInfoActivity.class.getName()));
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
        r1.addFlags(Bridge.TRANSFER_MAX_SIZE);     // Catch: Throwable -> L42
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

    @Override // com.ss.android.lark.compose.groupinfo.Hilt_FlowGroupInfoActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowGroupInfoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public FlowGroupInfoActivity() {
        this.b = LazyKt.lazy(FlowGroupInfoActivity$photoPicker$2.INSTANCE);
    }

    public final UserSession e9() {
        return PassportcConvention.c(this);
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
    public final /* bridge */ /* synthetic */ Object m918provideComponent() {
        return provideComponent();
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
        ImSdk r14 = ImSdk.a;
        boolean r15 = ImSdk.c;
        boolean r0 = OfficeSDKManager.isAvailable();
        if (r0 == false) goto L43;
        if (r15 == false) goto L43;
        String r16 = getIntent().getStringExtra("chat_id");
        if (r16 != null) goto L17;
        final String r2 = BuildConfig.FLAVOR;
    L18:
        String r17 = getIntent().getStringExtra("avatar_key");
        if (r17 != null) goto L21;
        final String r3 = BuildConfig.FLAVOR;
    L22:
        String r18 = getIntent().getStringExtra("chat_name");
        if (r18 != null) goto L25;
        final String r4 = BuildConfig.FLAVOR;
    L26:
        boolean r1 = false;
        final boolean r5 = getIntent().getBooleanExtra("can_edit", false);
        if (r2.length() != 0) goto L29;
        boolean r19 = true;
    L30:
        if (r19 == false) goto L32;
    L42:
        finish();
        return;
    L32:
        if (r3.length() != 0) goto L34;
        boolean r110 = true;
    L35:
        if (r110 == true) goto L42;
        if (r4.length() != 0) goto L39;
        r1 = true;
    L39:
        if (r1 == true) goto L42;
        final com.lark.kmp.rustclient.api.d r11 = com.ss.android.lark.compose.chatsetting.common.repository.b.a(PassportcConvention.c(this));
        final AndroidGroupInfoPlatformService r7 = new AndroidGroupInfoPlatformService(getApplicationContext());
        Function0<ViewModelProvider.Factory> r111 = new FlowGroupInfoActivity$onCreate$viewModel$2(r2, r3, r4, r5, r11, r7);
        final Function0 r6 = null;
        final ViewModelLazy r8 = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GroupInfoViewModel.class), new FlowGroupInfoActivity$onCreate$$inlined$viewModels$default$2(this), r111, new FlowGroupInfoActivity$onCreate$$inlined$viewModels$default$3(r6, this));
        final ActivityResultLauncher r9 = registerForActivityResult(new ActivityResultContracts.GetContent(), b.a);
        final ActivityResultLauncher r10 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(r8));
        com.ss.android.lark.compose.util.f.a(this, 2131102032);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1352932637, true, new AnonymousClass2(r8, this, r9, r10, r11)), 1, null);
        return;
    L34:
        r110 = false;
        goto L35
    L29:
        r19 = false;
        goto L30
    L25:
        r4 = r18;
        goto L26
    L21:
        r3 = r17;
        goto L22
    L17:
        r2 = r16;
    L43:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r0 + ", im sdk ready: " + r15 + ", finish. " + FlowGroupInfoActivity.class.getName());
        finish();
    }
}
