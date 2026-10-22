package com.obric.memorydata.ui;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.ao;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u000fJ\u0006\u0010\u001f\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bJ\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u000fH\u0002J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002J.\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010\t2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\u00012\u0006\u0010+\u001a\u00020\tH\u0002J\u0006\u00101\u001a\u00020\u000bJ\u0006\u00102\u001a\u00020\u000bJ\u0006\u00103\u001a\u00020\u000fJ\u0006\u00104\u001a\u00020\u000fJ\b\u00105\u001a\u00020\u000fH\u0003J\b\u00106\u001a\u00020\u000fH\u0002J\u001e\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020$2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010:\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006="}, d2 = {"Lcom/obric/memorydata/ui/AuthOverlayDelegate;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "mainHandler", "Landroid/os/Handler;", "overlayView", "Landroid/view/View;", "stoppedSinceLastAuth", "", "firstResumeConsumed", "onAuthPassed", "Lkotlin/Function0;", "", "getOnAuthPassed", "()Lkotlin/jvm/functions/Function0;", "setOnAuthPassed", "(Lkotlin/jvm/functions/Function0;)V", "onUserCancel", "getOnUserCancel", "setOnUserCancel", "attachOverlay", "onCreate", "onStart", "onResume", "onStop", "onWindowFocusChanged", "hasFocus", "onDestroy", "handleBackPressed", "requestAuth", "userInitiated", "tryAutoTrigger", "from", "", "syncOverlayVisibility", "dismissFloatingWindowsIfLocked", "dismissFloatingWindows", "clearLongPressOverlayState", "getFloatingWindowDismissDecision", "Lcom/obric/memorydata/ui/AuthOverlayDelegate$DismissDecision;", "windowView", TrackerImpl.PARAMS, "Landroid/view/WindowManager$LayoutParams;", "activityDecor", "callback", "getWindowCallback", "isLocked", "isAuthed", "freeAuthed", "exitApp", "removeCurrentAppTask", "launchHome", "runFinishStep", "step", "action", "activityStateForLog", "Companion", "DismissDecision", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0710a f12981a = null;
    private static long i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentActivity f12982b;
    private final Handler c;
    private View d;
    private boolean e;
    private boolean f;
    private Function0<Unit> g;
    private Function0<Boolean> h;

    /* JADX INFO: renamed from: com.obric.memorydata.ui.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/ui/AuthOverlayDelegate$Companion;", "", "<init>", "()V", "TAG", "", "LOCK_EXIT_SUPPRESS_AUTO_AUTH_MS", "", "lockedExitAtElapsedMs", "markLockedExit", "", "isLockedExitCoolingDown", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0710a {
        private C0710a() {
        }

        public /* synthetic */ C0710a(DefaultConstructorMarker r1) {
            this();
        }

        private final void a() {
            a.a(SystemClock.elapsedRealtime());
        }

        public static final /* synthetic */ boolean a(C0710a r0) {
            return r0.b();
        }

        public static final /* synthetic */ void b(C0710a r0) {
            r0.a();
        }

        private final boolean b() {
            if ((SystemClock.elapsedRealtime() - a.k()) >= 3000) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/ui/AuthOverlayDelegate$DismissDecision;", "", "shouldDismiss", "", InfoRequestQPSOptTraceLogger.REASON, "", "<init>", "(ZLjava/lang/String;)V", "getShouldDismiss", "()Z", "getReason", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12984b;

        public b(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, InfoRequestQPSOptTraceLogger.REASON);
            this.f12983a = r2;
            this.f12984b = r3;
        }

        public final boolean a() {
            return this.f12983a;
        }

        public final String b() {
            return this.f12984b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f12983a == r6.f12983a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12984b, r6.f12984b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f12983a) * 31) + this.f12984b.hashCode();
        }

        public String toString() {
            return "DismissDecision(shouldDismiss=" + this.f12983a + ", reason=" + this.f12984b + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12985a = null;

        static {
            int[] r0 = new int[IdentityController.AuthCancelSource.values().length];
            r0[IdentityController.AuthCancelSource.USER_CANCEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[IdentityController.AuthCancelSource.SYSTEM_INTERRUPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f12985a = r0;
        }
    }

    static {
        f12981a = new C0710a(null);
    }

    public a(FragmentActivity r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "activity");
        this.f12982b = r4;
        this.c = new Handler(Looper.getMainLooper());
    }

    private final b a(View r5, WindowManager.LayoutParams r6, View r7, Object r8) {
        if (r7 == null) goto L8;
        if (r5 != r7) goto L8;
        return new b(false, "activityDecor");
    L8:
        if (r8 != this.f12982b) goto L12;
        return new b(false, "activityCallback");
    L12:
        if (ZeusTransformUtils.instanceOf(r8, Dialog.class) == false) goto L18;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Dialog) ZeusTransformUtils.preCheckCast(r8, Dialog.class, "com.obric.memorydata.plugin")).getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "getContext(...)");
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r9), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) != this.f12982b) goto L17;
        return new b(true, "dialogCallback");
    L17:
        return new b(false, "otherActivityDialog");
    L18:
        if (r6 == null) goto L67;
        int r4 = r6.type;
        if (r4 == 1) goto L65;
        if (r4 == 3) goto L65;
        if (1000 <= r4) goto L26;
    L28:
        boolean r10 = false;
    L30:
        if (r4 != 2) goto L32;
        boolean r11 = true;
    L33:
        if (r10 == true) goto L37;
        if (r11 == true) goto L37;
        return new b(false, "notFloating");
    L37:
        IBinder r12 = null;
        if (r7 == null) goto L40;
        IBinder r1 = r7.getWindowToken();
    L41:
        IBinder r3 = r5.getWindowToken();
        IBinder r13 = r6.token;
        if (r1 != null) goto L44;
    L54:
        boolean r14 = true;
    L55:
        if (r14 == true) goto L59;
        return new b(false, "otherActivityWindow");
    L59:
        if (r10 == false) goto L61;
        String r15 = "activitySubWindow";
    L63:
        return new b(true, r15);
    L61:
        r15 = "activityApplicationWindow";
        goto L63
    L44:
        if (Intrinsics.areEqual(r3, r1) == true) goto L54;
        if (Intrinsics.areEqual(r13, r1) == true) goto L54;
        IBinder r16 = r5.getApplicationWindowToken();
        if (r7 == null) goto L51;
        r12 = r7.getApplicationWindowToken();
    L51:
        if (Intrinsics.areEqual(r16, r12) == true) goto L54;
        r14 = false;
        goto L55
    L40:
        r1 = null;
        goto L41
    L32:
        r11 = false;
        goto L33
    L26:
        if (r4 >= 2000) goto L28;
        r10 = true;
    L65:
        return new b(false, "baseOrStarting");
    L67:
        return new b(false, "noType");
    }

    private static final CharSequence a(ActivityManager.AppTask r3) {
        ActivityManager.RecentTaskInfo r4 = r3.getTaskInfo();
        StringBuilder r0 = new StringBuilder().append("[id=").append(r4.id).append(",taskId=").append(r4.taskId).append(",base=");
        ComponentName r1 = r4.baseActivity;
        String r2 = null;
        if (r1 == null) goto L5;
        String r5 = r1.getClassName();
    L6:
        StringBuilder r6 = r0.append(r5).append(",top=");
        ComponentName r7 = r4.topActivity;
        if (r7 == null) goto L10;
        r2 = r7.getClassName();
    L10:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r6.append(r2).append(",num=").append(r4.numActivities).append(']').toString(), CharSequence.class, "com.obric.memorydata.plugin");
    L5:
        r5 = null;
        goto L6
    }

    private final Object a(View r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        Object r4 = Result.m1421constructorimpl(ao.call(ao.a(r3, "mWindow"), "getCallback", new Object[0]));     // Catch: Throwable -> L4
    L7:
        if (Result.m1427isFailureimpl(r4) == false) goto L12;
        return null;
    L12:
        return r4;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit a(a r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "auth onPassed", false, 4, null);
        r7.l();
        Function0<Unit> r8 = r7.g;
        if (r8 == null) goto L6;
        r8.invoke();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit a(a r9, int r10, IdentityController.AuthCancelSource r11) {
        Intrinsics.checkNotNullParameter(r11, AILabCheckPermissionTask.KEY_SOURCE);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "auth onFail code=" + r10 + " source=" + r11, false, 4, null);
        r9.l();
        int r12 = c.f12985a[r11.ordinal()];
        if (r12 != 1) goto L5;
        Function0<Boolean> r13 = r9.h;
        if (r13 == null) goto L13;
        boolean r14 = ((Boolean) ZeusTransformUtils.preCheckCast(r13.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L14:
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r2 = "user cancel handled by caller=" + r14;
        boolean r3 = false;
        int r4 = 4;
        Object r5 = null;
        String r1 = "AuthOverlayDelegate";
    L7:
        IRunLog.a.a(r0, r1, r2, r3, r4, r5);
        return Unit.INSTANCE;
    L13:
        r14 = false;
        goto L14
    L5:
        if (r12 != 2) goto L9;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = false;
        r4 = 4;
        r5 = null;
        r1 = "AuthOverlayDelegate";
        r2 = "system interrupt: keep locked, wait for user click";
        goto L7
    L9:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ void a(long r0) {
        i = r0;
    }

    private static final void a(a r6, View r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "overlay action click → requestAuth(userInitiated=true)", false, 4, null);
        r6.b(true);
    }

    private final void a(String r9) {
        if (IdentityController.f12979a.d() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "tryAutoTrigger(" + r9 + "): no need, skip", false, 4, null);
        return;
    L7:
        if (IdentityController.f12979a.e() == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "tryAutoTrigger(" + r9 + "): in flight, skip", false, 4, null);
        return;
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "tryAutoTrigger(" + r9 + ") → requestAuth", false, 4, null);
        b(false);
    }

    private final void a(String r10, Function0<Unit> r11) {
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: " + r10 + " before " + o(), false, 4, null);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r12.invoke();     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: " + r10 + " success " + r1.o(), false, 4, null);     // Catch: Throwable -> L5
        Object r13 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
        if (r14 == null) goto L13;
        RunLog.INSTANCE.error("AuthOverlayDelegate", "exitApp: " + r10 + " failed " + o(), r14);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit b(a r0) {
        r0.f12982b.finishAffinity();
        return Unit.INSTANCE;
    }

    private final void b(String r7) {
        if (g() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "dismissFloatingWindowsIfLocked(" + r7 + "): unlocked, skip", false, 4, null);
        return;
    L6:
        c(r7);
    }

    private static final Unit c(a r0) {
        r0.f12982b.finishAndRemoveTask();
        return Unit.INSTANCE;
    }

    private final void c(String r25) {
        Window r3 = this.f12982b.getWindow();
        if (r3 == null) goto L5;
        View r4 = r3.getDecorView();
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "dismissFloatingWindows(" + r25 + "): start", false, 4, null);
        d(r25);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L91
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
        Object r8 = ao.call(ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.memorydata.plugin"), "getInstance", new Object[0]);     // Catch: Throwable -> L91
        Object r0 = ao.a(r8, "mViews");     // Catch: Throwable -> L91
        if (ZeusTransformUtils.instanceOf(r0, List.class) == false) goto L10;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
    L11:
        if (r1 != null) goto L13;
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L91
    L13:
        Object r10 = ao.a(r8, "mParams");     // Catch: Throwable -> L91
        if (ZeusTransformUtils.instanceOf(r10, List.class) == false) goto L16;
        List r11 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
    L17:
        if (r11 != null) goto L19;
        r11 = CollectionsKt.emptyList();     // Catch: Throwable -> L91
    L19:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L91
        int r15 = 0;
    L21:
        if (r14.hasNext() == false) goto L35;
        Object r16 = r14.next();     // Catch: Throwable -> L91
        int r17 = r15 + 1;     // Catch: Throwable -> L91
        if (r15 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L91
    L26:
        if (ZeusTransformUtils.instanceOf(r16, View.class) == false) goto L28;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
    L29:
        if (r7 == null) goto L31;
        Pair r9 = TuplesKt.to(Integer.valueOf(r15), r7);     // Catch: Throwable -> L91
    L32:
        if (r9 == null) goto L34;
        r13.add(r9);     // Catch: Throwable -> L91
    L34:
        r15 = r17;
        goto L21
    L31:
        r9 = null;
        goto L32
    L28:
        r7 = null;
        goto L29
    L35:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "dismissFloatingWindows(" + r25 + "): views=" + r1.size() + " params=" + r11.size() + " candidates=" + r18.size(), false, 4, null);     // Catch: Throwable -> L91
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L91
        int r110 = 0;
    L37:
        if (r19.hasNext() == false) goto L89;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r19.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
        int r111 = ((Number) ZeusTransformUtils.preCheckCast(r2.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L91
        View r20 = (View) ZeusTransformUtils.preCheckCast(r2.component2(), View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
        Object r112 = CollectionsKt.getOrNull(r11, r111);     // Catch: Throwable -> L91
        if (ZeusTransformUtils.instanceOf(r112, WindowManager.LayoutParams.class) == false) goto L41;
        WindowManager.LayoutParams r113 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r112, WindowManager.LayoutParams.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
    L42:
        Object r114 = r6.a(r20);     // Catch: Throwable -> L91
        b r115 = r6.a(r20, r113, r4, r114);     // Catch: Throwable -> L91
        View r116 = r4;
        IRunLog r117 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
        StringBuilder r21 = new StringBuilder().append("dismissFloatingWindows(").append(r25).append("): index=").append(r111).append(" type=");     // Catch: Throwable -> L91
        if (r113 == null) goto L45;
        Integer r22 = Integer.valueOf(r113.type);     // Catch: Throwable -> L91
    L46:
        StringBuilder r23 = r21.append(r22).append(" title=");     // Catch: Throwable -> L91
        if (r113 == null) goto L49;
        CharSequence r24 = r113.getTitle();     // Catch: Throwable -> L91
    L50:
        StringBuilder r26 = r23.append(r24).append(" view=").append(r20.getClass().getName()).append(" context=");     // Catch: Throwable -> L91
        Context r27 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
        if (r27 == null) goto L55;
        Class<?> r28 = r27.getClass();     // Catch: Throwable -> L91
        if (r28 == null) goto L55;
        String r29 = r28.getName();     // Catch: Throwable -> L91
    L56:
        StringBuilder r30 = r26.append(r29).append(" callback=");     // Catch: Throwable -> L91
        if (r114 == null) goto L61;
        Class<?> r31 = r114.getClass();     // Catch: Throwable -> L91
        if (r31 == null) goto L61;
        String r32 = r31.getName();     // Catch: Throwable -> L91
    L62:
        StringBuilder r33 = r30.append(r32).append(" action=");     // Catch: Throwable -> L91
        if (r115.a() == false) goto L65;
        String r34 = "dismiss";
    L66:
        IRunLog.a.a(r117, "AuthOverlayDelegate", r33.append(r34).append(" reason=").append(r115.b()).toString(), false, 4, null);     // Catch: Throwable -> L91
        if (r115.a() == true) goto L99;
        boolean r118 = false;
    L88:
        r4 = r116;
        goto L37
    L99:
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L81
        if (ZeusTransformUtils.instanceOf(r114, Dialog.class) == false) goto L71;
        Dialog r36 = (Dialog) ZeusTransformUtils.preCheckCast(r114, Dialog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L81
    L72:
        if (r36 == null) goto L74;
        r36.dismiss();     // Catch: Throwable -> L81
        r118 = false;
    L97:
        r110 = r110 + 1;     // Catch: Throwable -> L79
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "dismissFloatingWindows(" + r25 + "): removed index=" + r111, false, 4, null);     // Catch: Throwable -> L79
        Object r37 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L79
    L84:
        Throwable r38 = Result.m1424exceptionOrNullimpl(r37);     // Catch: Throwable -> L91
        if (r38 == null) goto L88;
        RunLog.INSTANCE.error("AuthOverlayDelegate", "dismissFloatingWindows(" + r25 + "): remove failed index=" + r111, r38);     // Catch: Throwable -> L91
    L79:
        th = th;
    L83:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L91
        r37 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L91
        goto L84
    L74:
        Object[] r40 = new Object[2];     // Catch: Throwable -> L81
        r118 = false;
        r40[0] = r20;     // Catch: Throwable -> L79
        r40[1] = true;     // Catch: Throwable -> L79
        ao.call(r8, "removeView", r40);     // Catch: Throwable -> L79
        goto L97
    L71:
        r36 = null;
    L81:
        th = th;
        r118 = false;
        goto L83
    L65:
        r34 = "skip";
    L61:
        r32 = null;
    L55:
        r29 = null;
        goto L56
    L49:
        r24 = null;
        goto L50
    L45:
        r22 = null;
        goto L46
    L41:
        r113 = null;
        goto L42
    L89:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "dismissFloatingWindows(" + r25 + "): end dismissedCount=" + r110, false, 4, null);     // Catch: Throwable -> L91
        Object r41 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L91
    L93:
        Throwable r42 = Result.m1424exceptionOrNullimpl(r41);
        if (r42 == null) goto L110;
        RunLog.INSTANCE.error("AuthOverlayDelegate", "dismissFloatingWindows(" + r25 + "): reflect failed", r42);
        return;
    L110:
        return;
    L16:
        r11 = null;
        goto L17
    L10:
        r1 = null;
    L91:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r41 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L93
    L5:
        r4 = null;
        goto L6
    }

    private static final Unit d(a r0) {
        r0.f12982b.finish();
        return Unit.INSTANCE;
    }

    private final void d(String r9) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        a r8 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        ZeusTransformUtils.forName("com.obric.memorydata.memory.ui.list.LongPressOverlayStateCleaner", "com.obric.memorydata.plugin").getMethod("clear", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "clearLongPressOverlayState(" + r9 + "): success", false, 4, null);     // Catch: Throwable -> L5
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "clearLongPressOverlayState(" + r9 + "): skip " + r11.getClass().getSimpleName(), false, 4, null);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final void e(a r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: delayedCheck100ms " + r7.o(), false, 4, null);
    }

    private static final void f(a r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: delayedCheck500ms " + r7.o(), false, 4, null);
    }

    public static final /* synthetic */ long k() {
        return i;
    }

    private final void l() {
        boolean r0 = g();
        View r8 = this.d;
        if (r8 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "syncOverlayVisibility: overlayView null, locked=" + r0, false, 4, null);
        return;
    L6:
        if (r0 == false) goto L8;
        int r2 = 0;
    L9:
        r8.setVisibility(r2);
        if (r0 == false) goto L12;
        r8.bringToFront();
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "syncOverlayVisibility: locked=" + r0 + " visibility=" + r8.getVisibility(), false, 4, null);
        return;
    L8:
        r2 = 8;
        goto L9
    }

    /* JADX INFO: renamed from: lambda$080-E79GJse_9dJ8g2e9Vo_YCDI, reason: not valid java name */
    public static /* synthetic */ void m1208lambda$080E79GJse_9dJ8g2e9Vo_YCDI(a r0) {
        f(r0);
    }

    /* JADX INFO: renamed from: lambda$6TqmT0zZAW5-tEg9ujidFZgfdGU, reason: not valid java name */
    public static /* synthetic */ void m1209lambda$6TqmT0zZAW5tEg9ujidFZgfdGU(a r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$7mUhmixR7hJtZK0UrOvAONNYnk8(a r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$9fMDd5FtmWNfG4sqo4hr0s_iNxA(a r0, int r1, IdentityController.AuthCancelSource r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$JWv8mlJnYWq5D2maULMkcjbutGE(a r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$PGQydS8tWv9eQcpwhgw6GpoQUsk(a r0) {
        e(r0);
    }

    public static /* synthetic */ Unit lambda$TdbgkA1xGsG2eeTtO6IvQYF6qC8(a r0) {
        return d(r0);
    }

    public static /* synthetic */ Unit lambda$WFNxc0HUiRnC6CBZbPd5Yn0jk7I(a r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$X7ltMEgOxG-WYQc97C3ARFuKr3c, reason: not valid java name */
    public static /* synthetic */ CharSequence m1210lambda$X7ltMEgOxGWYQc97C3ARFuKr3c(ActivityManager.AppTask r0) {
        return a(r0);
    }

    private final void m() {
        int r3 = this.f12982b.getTaskId();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: removeCurrentAppTask before currentTaskId=" + r3 + ' ' + o(), false, 4, null);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L64
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        Object r7 = r5.f12982b.getSystemService("activity");     // Catch: Throwable -> L64
        if (ZeusTransformUtils.instanceOf(r7, ActivityManager.class) == false) goto L6;
        ActivityManager r8 = (ActivityManager) ZeusTransformUtils.preCheckCast(r7, ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
    L7:
        if (r8 != null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: removeCurrentAppTask skip, ActivityManager null", null, 4, null);     // Catch: Throwable -> L64
        return;
    L10:
        List<ActivityManager.AppTask> r9 = r8.getAppTasks();     // Catch: Throwable -> L64
        Intrinsics.checkNotNullExpressionValue(r9, "getAppTasks(...)");     // Catch: Throwable -> L64
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: removeCurrentAppTask snapshot=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$a$X7ltMEgOxGWYQc97C3ARFuKr3c.INSTANCE, 31, null), false, 4, null);     // Catch: Throwable -> L64
        List<ActivityManager.AppTask> r10 = r8.getAppTasks();     // Catch: Throwable -> L64
        Intrinsics.checkNotNullExpressionValue(r10, "getAppTasks(...)");     // Catch: Throwable -> L64
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L64
        int r12 = 0;
    L12:
        if (r11.hasNext() == false) goto L62;
        ActivityManager.AppTask r13 = (ActivityManager.AppTask) ZeusTransformUtils.preCheckCast(r11.next(), ActivityManager.AppTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        Object r1 = Result.m1421constructorimpl(r13.getTaskInfo());     // Catch: Throwable -> L16
    L19:
        if (Result.m1427isFailureimpl(r1) == false) goto L21;
        r1 = null;
    L21:
        ActivityManager.RecentTaskInfo r14 = (ActivityManager.RecentTaskInfo) ZeusTransformUtils.preCheckCast(r1, ActivityManager.RecentTaskInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        if (r14 == null) goto L12;
        if (r14.id != r3) goto L27;
    L30:
        boolean r2 = true;
    L32:
        if (r2 == false) goto L33;
        IRunLog r18 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        StringBuilder r6 = new StringBuilder().append("exitApp: removeCurrentAppTask remove id=").append(r14.id).append(" taskId=").append(r14.taskId).append(" base=");     // Catch: Throwable -> L64
        ComponentName r15 = r14.baseActivity;     // Catch: Throwable -> L64
        if (r15 == null) goto L45;
        String r16 = r15.getClassName();     // Catch: Throwable -> L64
    L46:
        StringBuilder r17 = r6.append(r16).append(" top=");     // Catch: Throwable -> L64
        ComponentName r19 = r14.topActivity;     // Catch: Throwable -> L64
        if (r19 == null) goto L49;
        String r20 = r19.getClassName();     // Catch: Throwable -> L64
    L50:
        IRunLog.a.a(r18, "AuthOverlayDelegate", r17.append(r20).append(" num=").append(r14.numActivities).toString(), false, 4, null);     // Catch: Throwable -> L64
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L57
        r13.finishAndRemoveTask();     // Catch: Throwable -> L57
        int r22 = r12 + 1;
        Object r23 = Result.m1421constructorimpl(Integer.valueOf(r12));     // Catch: Throwable -> L55
        r12 = r22;
    L59:
        Throwable r24 = Result.m1424exceptionOrNullimpl(r23);     // Catch: Throwable -> L64
        if (r24 == null) goto L12;
        RunLog.INSTANCE.error("AuthOverlayDelegate", "exitApp: removeCurrentAppTask remove failed taskId=" + r14.taskId, r24);     // Catch: Throwable -> L64
    L55:
        th = th;
        r12 = r22;
    L58:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L64
        r23 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L64
    L57:
        th = th;
        goto L58
    L49:
        r20 = null;
        goto L50
    L45:
        r16 = null;
        goto L46
    L33:
        IRunLog r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        StringBuilder r26 = new StringBuilder().append("exitApp: removeCurrentAppTask skip id=").append(r14.id).append(" taskId=").append(r14.taskId).append(" base=");     // Catch: Throwable -> L64
        ComponentName r27 = r14.baseActivity;     // Catch: Throwable -> L64
        if (r27 == null) goto L36;
        String r28 = r27.getClassName();     // Catch: Throwable -> L64
    L37:
        StringBuilder r29 = r26.append(r28).append(" top=");     // Catch: Throwable -> L64
        ComponentName r30 = r14.topActivity;     // Catch: Throwable -> L64
        if (r30 == null) goto L40;
        String r31 = r30.getClassName();     // Catch: Throwable -> L64
    L41:
        IRunLog.a.a(r110, "AuthOverlayDelegate", r29.append(r31).append(" num=").append(r14.numActivities).toString(), false, 4, null);     // Catch: Throwable -> L64
        goto L12
    L40:
        r31 = null;
        goto L41
    L36:
        r28 = null;
        goto L37
    L27:
        if (r14.taskId == r3) goto L30;
        r2 = false;
    L16:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L64
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L64
        goto L19
    L62:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: removeCurrentAppTask end removedCount=" + r12 + ' ' + r5.o(), false, 4, null);     // Catch: Throwable -> L64
        Object r32 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L64
    L66:
        Throwable r33 = Result.m1424exceptionOrNullimpl(r32);
        if (r33 == null) goto L88;
        RunLog.INSTANCE.error("AuthOverlayDelegate", "exitApp: removeCurrentAppTask failed " + o(), r33);
        return;
    L88:
        return;
    L6:
        r8 = null;
    L64:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r32 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L66
    }

    private final void n() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: launchHome before " + o(), false, 4, null);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Intent r2 = new Intent("android.intent.action.MAIN");     // Catch: Throwable -> L5
        r2.addCategory("android.intent.category.HOME");     // Catch: Throwable -> L5
        r2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);     // Catch: Throwable -> L5
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.f12982b.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: launchHome success " + r1.o(), false, 4, null);     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 == null) goto L13;
        RunLog.INSTANCE.error("AuthOverlayDelegate", "exitApp: launchHome failed " + o(), r4);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final String o() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(Integer.valueOf(ba.c()));     // Catch: Throwable -> L5
    L8:
        if (Result.m1424exceptionOrNullimpl(r3) == null) goto L11;
        r3 = -1;
    L11:
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        StringBuilder r4 = new StringBuilder();
        StringBuilder r5 = r4.append("activity=").append(this.f12982b.getClass().getSimpleName()).append('@').append(Integer.toHexString(this.f12982b.hashCode())).append(" taskId=").append(this.f12982b.getTaskId()).append(" numActivities=").append(r0).append(" isTaskRoot=").append(this.f12982b.isTaskRoot()).append(" isFinishing=").append(this.f12982b.isFinishing()).append(" isDestroyed=").append(this.f12982b.isDestroyed()).append(" lifecycle=").append(this.f12982b.getLifecycle().getCurrentState()).append(" locked=").append(g()).append(" authed=").append(h()).append(" decor=");
        Window r6 = this.f12982b.getWindow();
        if (r6 == null) goto L18;
        View r7 = r6.getDecorView();
        if (r7 == null) goto L18;
        Class<?> r8 = r7.getClass();
        if (r8 == null) goto L18;
        String r9 = r8.getSimpleName();
    L19:
        r5.append(r9).append('@');
        Window r10 = this.f12982b.getWindow();
        if (r10 == null) goto L24;
        View r11 = r10.getDecorView();
        if (r11 == null) goto L24;
        int r12 = r11.hashCode();
    L25:
        r4.append(Integer.toHexString(r12));
        return r4.toString();
    L24:
        r12 = 0;
    L18:
        r9 = null;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void a() {
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.f12982b.findViewById(R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "attachOverlay: android.R.id.content not found, defer", false, 4, null);
        return;
    L6:
        View r1 = this.d;
        if (r1 == null) goto L14;
        ViewParent r4 = r1.getParent();
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L11;
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
    L12:
        if (r5 == null) goto L14;
        r5.removeView(r1);
        goto L14
    L11:
        r5 = null;
    L14:
        this.d = null;
        View r2 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this.f12982b, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.layout.view_identity_lock_overlay, "layout", "view_identity_lock_overlay"), r0, false, "com.obric.memorydata.plugin");
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r2.setClickable(true);
        r2.setFocusable(true);
        r0.addView(r2);
        r2.bringToFront();
        ViewParent r3 = r2.getParent();
        if (r3 == null) goto L17;
        r3.requestLayout();
    L17:
        this.d = r2;
        View r6 = r2.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.identity_lock_action, OaidModel.KEY_ID, "identity_lock_action"));
        if (r6 == null) goto L20;
        r6.setOnClickListener(new $$Lambda$a$6TqmT0zZAW5tEg9ujidFZgfdGU(this));
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "attachOverlay: attached to content, locked=" + g(), false, 4, null);
        l();
        b("attachOverlay");
    }

    public final void a(Function0<Unit> r3) {
        this.g = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public final void a(boolean r2) {
        if (r2 == false) goto L6;
        View r0 = this.d;
        if (r0 == null) goto L6;
        r0.bringToFront();
    L6:
        l();
        if (r2 == false) goto L10;
        b("onWindowFocusChanged");
        return;
    }

    public final void b() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "onCreate", false, 4, null);
    }

    public final void b(boolean r8) {
        b("requestAuth");
        if (IdentityController.f12979a.e() == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "requestAuth: in flight, skip", false, 4, null);
        return;
    L7:
        if (IdentityController.f12979a.b((Context) ZeusTransformUtils.preCheckCast(this.f12982b, Context.class, "com.obric.memorydata.plugin")) == true) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "requestAuth: device auth unavailable, pass through", false, 4, null);
        IdentityController.f12979a.g();
        l();
        Function0<Unit> r7 = this.g;
        if (r7 == null) goto L14;
        r7.invoke();
        return;
    L14:
        return;
    L12:
        this.e = false;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "requestAuth userInitiated=" + r8 + " → reset stoppedSinceLastAuth", false, 4, null);
        IdentityController.f12979a.a(this.f12982b, r8, new $$Lambda$a$JWv8mlJnYWq5D2maULMkcjbutGE(this), new $$Lambda$a$9fMDd5FtmWNfG4sqo4hr0s_iNxA(this));
    }

    public final void c() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "onStart stoppedSinceLastAuth=" + this.e, false, 4, null);
        View r0 = this.d;
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L6:
        if (r1 != null) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "onStart: overlay lost, reattach", false, 4, null);
        a();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void d() {
        boolean r0 = IdentityController.f12979a.d();
        boolean r1 = IdentityController.f12979a.e();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "onResume needAuth=" + r0 + " inFlight=" + r1 + " firstResumeConsumed=" + this.f + " stoppedSinceLastAuth=" + this.e + " autoRetryEnabled=false", false, 4, null);
        View r2 = this.d;
        if (r2 == null) goto L5;
        r2.bringToFront();
    L5:
        l();
        b("onResume");
        if (r0 == false) goto L26;
        if (r1 == false) goto L10;
        return;
    L10:
        if (IdentityController.f12979a.b((Context) ZeusTransformUtils.preCheckCast(this.f12982b, Context.class, "com.obric.memorydata.plugin")) == true) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "onResume: device auth unavailable, pass through", false, 4, null);
        IdentityController.f12979a.g();
        l();
        Function0<Unit> r11 = this.g;
        if (r11 == null) goto L25;
        r11.invoke();
        return;
    L25:
        return;
    L16:
        if (C0710a.a(f12981a) == false) goto L20;
        this.f = true;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "onResume: skip auto trigger (locked exit cooling down)", false, 4, null);
        return;
    L20:
        if ((!this.f) == true) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "onResume: skip auto trigger (already consumed)", false, 4, null);
        return;
    L23:
        this.f = true;
        a("onResume");
        return;
    }

    public final void e() {
        this.e = true;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "onStop → stoppedSinceLastAuth=true", false, 4, null);
        IdentityController.f12979a.a(this.f12982b, "onStop");
    }

    public final void f() {
        IdentityController.f12979a.a(this.f12982b, "onDestroy");
        this.c.removeCallbacksAndMessages(null);
        this.d = null;
    }

    public final boolean g() {
        return IdentityController.f12979a.d();
    }

    public final boolean h() {
        return IdentityController.f12979a.f();
    }

    public final void i() {
        IdentityController.f12979a.h();
        this.f = false;
        this.e = false;
        l();
    }

    public final void j() {
        C0710a.b(f12981a);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: start " + o(), false, 4, null);
        c("exitApp");
        n();
        m();
        a("finishAffinity", new $$Lambda$a$7mUhmixR7hJtZK0UrOvAONNYnk8(this));
        a("finishAndRemoveTask", new $$Lambda$a$WFNxc0HUiRnC6CBZbPd5Yn0jk7I(this));
        a("finish", new $$Lambda$a$TdbgkA1xGsG2eeTtO6IvQYF6qC8(this));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuthOverlayDelegate", "exitApp: end " + o(), false, 4, null);
        this.c.postDelayed(new $$Lambda$a$PGQydS8tWv9eQcpwhgw6GpoQUsk(this), 100);
        this.c.postDelayed(new $$Lambda$a$080E79GJse_9dJ8g2e9Vo_YCDI(this), 500);
    }
}
