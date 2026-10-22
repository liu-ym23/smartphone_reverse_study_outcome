package com.obric.memorydata.ui.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0014J\b\u0010\u0018\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/ui/impl/AuthProxyActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "needLogin", "", "callbackInstanceId", "", "isResultDelivered", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "finishWithStrategy", "keepTask", "isOnlyActivityInTask", "finish", "onDestroy", "setupImmersiveTransparentBars", "Companion", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AuthProxyActivity extends AppCompatActivity {
    private static final String ACTION_START_AGREE_PRIVACY = "com.obric.assistant.action.REQUEST_PRIVACY_AGREE";
    private static final String ACTION_START_AGREE_PRIVACY_LOGIN = "com.obric.assistant.action.REQUEST_LOGIN";
    public static final a Companion = null;
    private static final String EXTRA_KEY_CALLBACK_INSTANCE_ID = "extra_key_callback_instance_id";
    private static final String EXTRA_KEY_START_CODE = "extra_key_start_code";
    private static final String RECEIVE_ERROR_VALUE_LOGIN_FAIL = "login_fail";
    private static final String RECEIVE_ERROR_VALUE_PRIVACY_REFUSED = "privacy_refused";
    private static final String RECEIVE_EXTRA_KEY_ERROR_CODE = "extra_error_code";
    private static final int REQUEST_CODE_AUTH = 1001;
    private static final int START_FOR_AGREE_PRIVACY = 2;
    private static final int START_FOR_AGREE_PRIVACY_LOGIN = 1;
    private static final String TAG = "AuthProxyActivity";
    private static final Map<String, Function1<Boolean, Unit>> callbacks = null;
    private static int count;
    private String callbackInstanceId;
    private boolean isResultDelivered;
    private boolean needLogin;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0006H\u0002J*\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0011\u001a\u00020\bJ\u001f\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0015R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/ui/impl/AuthProxyActivity$Companion;", "", "<init>", "()V", "callbacks", "", "", "Lkotlin/Function1;", "", "", CommonConsts.COUNT_TYPE, "", "activityInstanceId", CommonConsts.APM_INNER_EVENT_COST_START, "context", "Landroid/content/Context;", "callback", "isLogin", "deliverLoginResult", "callbackId", "isSuccess", "deliverLoginResult$ui_obricRelease", "TAG", "EXTRA_KEY_CALLBACK_INSTANCE_ID", "EXTRA_KEY_START_CODE", "START_FOR_AGREE_PRIVACY_LOGIN", "START_FOR_AGREE_PRIVACY", "REQUEST_CODE_AUTH", "RECEIVE_EXTRA_KEY_ERROR_CODE", "RECEIVE_ERROR_VALUE_PRIVACY_REFUSED", "RECEIVE_ERROR_VALUE_LOGIN_FAIL", "ACTION_START_AGREE_PRIVACY_LOGIN", "ACTION_START_AGREE_PRIVACY", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final String a() {
            StringBuilder r2 = new StringBuilder().append("AuthProxyActivity_").append(UUID.randomUUID()).append('_');
            int r0 = AuthProxyActivity.access$getCount$cp();
            AuthProxyActivity.access$setCount$cp(r0 + 1);
            return r2.append(r0).toString();
        }

        public final void a(Context r5, Function1<? super Boolean, Unit> r6, boolean r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r9, "callback");
            RunLog.INSTANCE.debug(AuthProxyActivity.TAG, "enter start");
            String r4 = a();
            AuthProxyActivity.access$getCallbacks$cp().put(r4, r9);
            Intent r10 = new Intent(r8, AuthProxyActivity.class);
            r10.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            r10.putExtra(AuthProxyActivity.EXTRA_KEY_CALLBACK_INSTANCE_ID, r4);
            if (r7 == false) goto L5;
            int r11 = 1;
        L6:
            r10.putExtra(AuthProxyActivity.EXTRA_KEY_START_CODE, r11);
            ZeusTransformUtils.startActivity(r8, r10, "com.obric.memorydata.plugin");
            Activity r12 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r8), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, Activity.class) == true) goto L10;
            r12 = null;
        L10:
            if (r12 == null) goto L13;
            r12.overridePendingTransition(0, 0);
            return;
        L13:
            return;
        L5:
            r11 = 2;
            goto L6
        }

        public final void a(String r5, boolean r6) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
            boolean r1 = false;
            if (r4 != null) goto L5;
        L8:
            boolean r7 = true;
        L9:
            if (r7 == false) goto L11;
            return;
        L11:
            Function1 r8 = (Function1) ZeusTransformUtils.preCheckCast(AuthProxyActivity.access$getCallbacks$cp().remove(r5), Function1.class, "com.obric.memorydata.plugin");
            RunLog r9 = RunLog.INSTANCE;
            StringBuilder r0 = new StringBuilder().append("deliverLoginResult,callback==null:");
            if (r8 != null) goto L14;
            r1 = true;
        L14:
            r9.debug(AuthProxyActivity.TAG, r0.append(r1).append(",isSuccess=").append(r6).toString());
            if (r8 == null) goto L18;
            r8.invoke(Boolean.valueOf(r6));
            return;
        L18:
            return;
        L5:
            if (r4.length() == 0) goto L8;
            r7 = false;
            goto L9
        }
    }

    static {
        Companion = new a(null);
        callbacks = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public AuthProxyActivity() {
        this.needLogin = true;
    }

    public static final /* synthetic */ Map access$getCallbacks$cp() {
        return callbacks;
    }

    public static final /* synthetic */ int access$getCount$cp() {
        return count;
    }

    public static final /* synthetic */ void access$setCount$cp(int r0) {
        count = r0;
    }

    private final void finishWithStrategy(boolean r8) {
        if (r8 == false) goto L14;
        finish();
        return;
    L14:
    L10:
        th = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "finishAndRemoveTask failed: " + th.getMessage(), null, 4, null);
        finish();
        return;
    L6:
        if (isOnlyActivityInTask() == false) goto L8;
        finishAndRemoveTask();     // Catch: Throwable -> L10
    L13:
        return;
    L8:
        finish();     // Catch: Throwable -> L10
        goto L13
    }

    private final boolean isOnlyActivityInTask() {
        Object r2 = getSystemService("activity");     // Catch: Throwable -> L32
        Object r4 = null;
        if (ZeusTransformUtils.instanceOf(r2, ActivityManager.class) == false) goto L6;
        ActivityManager r3 = (ActivityManager) ZeusTransformUtils.preCheckCast(r2, ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        List<ActivityManager.AppTask> r5 = r3.getAppTasks();     // Catch: Throwable -> L32
        if (r5 != null) goto L12;
        return false;
    L12:
        int r8 = getTaskId();     // Catch: Throwable -> L32
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L32
    L14:
        if (r6.hasNext() == false) goto L23;
        Object r7 = r6.next();     // Catch: Throwable -> L32
        ActivityManager.RecentTaskInfo r9 = ((ActivityManager.AppTask) ZeusTransformUtils.preCheckCast(r7, ActivityManager.AppTask.class, "com.obric.memorydata.plugin")).getTaskInfo();     // Catch: Throwable -> L32
        if (r9 != null) goto L18;
    L20:
        boolean r10 = false;
    L21:
        if (r10 == false) goto L14;
        r4 = r7;
        goto L23
    L18:
        if (r9.taskId != r8) goto L20;
        r10 = true;
    L23:
        ActivityManager.AppTask r11 = (ActivityManager.AppTask) ZeusTransformUtils.preCheckCast(r4, ActivityManager.AppTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r11 == null) goto L31;
        ActivityManager.RecentTaskInfo r12 = r11.getTaskInfo();     // Catch: Throwable -> L32
        if (r12 == null) goto L31;
        if (r12.numActivities <= 1) goto L43;
        return false;
    L43:
        return true;
    L31:
        return false;
    L6:
        r3 = null;
    L32:
        th = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "isOnlyActivityInTask check failed: " + th.getMessage(), null, 4, null);
        return false;
    }

    private final void setupImmersiveTransparentBars() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setBackgroundDrawable((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(0), Drawable.class, "com.obric.memorydata.plugin"));
        if (Build.VERSION.SDK_INT < 29) goto L6;
        getWindow().setNavigationBarContrastEnforced(false);
        getWindow().setStatusBarContrastEnforced(false);
        return;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onActivityResult(int r9, int r10, Intent r11) {
        super.onActivityResult(r9, r10, r11);
        if (r9 == 1001) goto L6;
        return;
    L6:
        if (r10 != (-1)) goto L8;
        boolean r12 = true;
    L9:
        String r1 = "";
        if (r12 == false) goto L14;
        UserSettings r13 = UserSettings.INSTANCE;
        r13.updateAgreePrivacy(true);
        if (this.needLogin == false) goto L19;
        r13.updateIsLogin(true);
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onActivityResult called, isSuccess=" + r12 + ",code=" + r10 + ",error=" + r1, false, 4, null);
        Companion.a(this.callbackInstanceId, r12);
        this.isResultDelivered = true;
        finishWithStrategy(r12);
        return;
    L14:
        if (r11 == null) goto L19;
        String r14 = r11.getStringExtra(RECEIVE_EXTRA_KEY_ERROR_CODE);
        if (r14 == null) goto L19;
        r1 = r14;
        goto L19
    L8:
        r12 = false;
        goto L9
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r12) {
        setupImmersiveTransparentBars();
        super.onCreate(r12);
        overridePendingTransition(0, 0);
        String r1 = getIntent().getStringExtra(EXTRA_KEY_CALLBACK_INSTANCE_ID);
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreate failed, callback instance id is null", false, 4, null);
        finishWithStrategy(false);
        return;
    L12:
        this.callbackInstanceId = r1;
        if (getIntent().getIntExtra(EXTRA_KEY_START_CODE, 1) != 1) goto L15;
        boolean r4 = true;
    L16:
        this.needLogin = r4;
        if (r12 != null) goto L27;
        if (r4 == false) goto L20;
        String r13 = ACTION_START_AGREE_PRIVACY_LOGIN;
    L21:
        Intent r5 = new Intent(r13);
        r5.setPackage(AppContext.INSTANCE.getHostPkgName());
        ZeusTransformUtils.startActivityForResult(this, r5, 1001, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
    L30:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreate, enter AuthProxyActivity", false, 4, null);
        return;
    L24:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "start real auth activity failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Companion.a(this.callbackInstanceId, false);
        this.isResultDelivered = true;
        finishWithStrategy(false);
        goto L30
    L20:
        r13 = ACTION_START_AGREE_PRIVACY;
        goto L21
    L27:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == false) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreate, savedInstanceState not null, has login, finish", false, 4, null);
        Companion.a(this.callbackInstanceId, true);
        this.isResultDelivered = true;
        finishWithStrategy(true);
        return;
    L15:
        r4 = false;
        goto L16
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onDestroy, isResultDelivered=" + this.isResultDelivered, false, 4, null);
        super.onDestroy();
        if (this.isResultDelivered == false) goto L5;
        return;
    L5:
        if (isFinishing() == false) goto L9;
        Companion.a(this.callbackInstanceId, false);
        return;
    }
}
