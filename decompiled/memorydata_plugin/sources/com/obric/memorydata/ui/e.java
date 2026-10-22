package com.obric.memorydata.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ba;
import com.obric.oui.window.permission.PrivacyStatementActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/ui/GlobalPrivacyController;", "", "<init>", "()V", "TAG", "", "PRIVACY_STATEMENT_URL", Constants.LAUNCH_TAG, "", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function1;", "", "listenerRegistered", "activityLifecycleListener", "com/obric/memorydata/ui/GlobalPrivacyController$activityLifecycleListener$1", "Lcom/obric/memorydata/ui/GlobalPrivacyController$activityLifecycleListener$1;", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f13004a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f13005b;
    private static final a c = null;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/ui/GlobalPrivacyController$activityLifecycleListener$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r7, Bundle r8) {
            Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r7, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "activity");
            if (ZeusTransformUtils.instanceOf(r6, PrivacyStatementActivity.class) == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalPrivacyController", "PrivacyStatementActivity onActivityCreated", false, 4, null);
            ba.a(r6);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/ui/GlobalPrivacyController$launch$1$1", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$PrivacyConsentCallback;", "onAgree", "", "onCancel", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements PrivacyStatementActivity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f13006a;

        b(Function1<? super Boolean, Unit> r3) {
            this.f13006a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.c
        public void a() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalPrivacyController", "onAgree UI", false, 4, null);
            UserSettings.INSTANCE.updateAgreePrivacy(true);
            this.f13006a.invoke(true);
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.c
        public boolean a(Activity r3) {
            return PrivacyStatementActivity.c.a.a(this, (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.c
        public void b() {
            this.f13006a.invoke(false);
        }

        @Override // com.obric.oui.window.permission.PrivacyStatementActivity.c
        public boolean b(Activity r3) {
            return PrivacyStatementActivity.c.a.b(this, (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f13004a = new e();
        c = new a();
    }

    private e() {
    }

    public final void a(Context r8, Function1<? super Boolean, Unit> r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r10, "callback");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalPrivacyController", Constants.LAUNCH_TAG, false, 4, null);
        PrivacyStatementActivity.a.b r11 = new PrivacyStatementActivity.a.b(r7);
        String r1 = r7.getString(ZeusTransformUtils.mapRes(R.string.memory_app_title, TypedValues.Custom.S_STRING, "memory_app_title"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        r11.a(r1);
        r11.a(ZeusTransformUtils.mapRes(R.drawable.memory_icon, "drawable", "memory_icon"));
        String r2 = r7.getString(ZeusTransformUtils.mapRes(R.string.memory_app_global_privacy, TypedValues.Custom.S_STRING, "memory_app_global_privacy"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        r11.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        r11.a(new String[]{"https://os.obriccloud.com/agreement/sum_memory_privacy"});
        r11.a((PrivacyStatementActivity.c) ZeusTransformUtils.preCheckCast(new b(r10), PrivacyStatementActivity.c.class, "com.obric.memorydata.plugin"));
        if (f13005b == true) goto L5;
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) ZeusTransformUtils.preCheckCast(c, Application.ActivityLifecycleCallbacks.class, "com.obric.memorydata.plugin"));
        f13005b = true;
    L5:
        Intent r12 = new Intent(r7, PrivacyStatementActivity.class);
        r12.addFlags(268468224);
        r12.addFlags(8388608);
        r11.a(r12, null);
    }
}
