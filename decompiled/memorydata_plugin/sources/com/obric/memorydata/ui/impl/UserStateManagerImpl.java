package com.obric.memorydata.ui.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import com.obric.memorydata.middleware.api.app.IUserStateManager;
import com.obric.memorydata.plugin_api.login.LoginRestartPageRecorder;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J$\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016J$\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/ui/impl/UserStateManagerImpl;", "Lcom/obric/memorydata/middleware/api/app/IUserStateManager;", "<init>", "()V", "getInst", "isAuthInProgress", "", "pendingCallback", "Lkotlin/Function1;", "", "requestAgreePrivacyAndLogin", "context", "Landroid/content/Context;", "callback", "requestAgreePrivacy", "bringAuthTaskToFront", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserStateManagerImpl implements IUserStateManager {
    public static final UserStateManagerImpl INSTANCE = null;
    private static boolean isAuthInProgress;
    private static Function1<? super Boolean, Unit> pendingCallback;

    static {
        INSTANCE = new UserStateManagerImpl();
    }

    private UserStateManagerImpl() {
    }

    private final boolean bringAuthTaskToFront(Context r6) {
        Object r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin")).getSystemService("activity");     // Catch: Exception -> L28
        if (ZeusTransformUtils.instanceOf(r5, ActivityManager.class) == false) goto L6;
        ActivityManager r7 = (ActivityManager) ZeusTransformUtils.preCheckCast(r5, ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
    L7:
        if (r7 != null) goto L9;
        return false;
    L9:
        List<ActivityManager.AppTask> r8 = r7.getAppTasks();     // Catch: Exception -> L28
        if (r8 != null) goto L12;
        return false;
    L12:
        Iterator<ActivityManager.AppTask> r9 = r8.iterator();     // Catch: Exception -> L28
    L14:
        if (r9.hasNext() == false) goto L27;
        ActivityManager.AppTask r1 = (ActivityManager.AppTask) ZeusTransformUtils.preCheckCast(r9.next(), ActivityManager.AppTask.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
        ActivityManager.RecentTaskInfo r3 = r1.getTaskInfo();     // Catch: Exception -> L28
        if (r3 == null) goto L14;
        ComponentName r4 = r3.baseActivity;     // Catch: Exception -> L28
        if (r4 == null) goto L21;
        String r10 = r4.getClassName();     // Catch: Exception -> L28
    L23:
        if (Intrinsics.areEqual(r10, AuthProxyActivity.class.getName()) == false) goto L14;
        r1.moveToFront();     // Catch: Exception -> L28
        return true;
    L21:
        r10 = null;
        goto L23
    L6:
        r7 = null;
    L27:
        return false;
    }

    @JvmStatic
    public static final UserStateManagerImpl getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ Unit lambda$832mq1LWoPuTr5065qPwNEff16s(boolean r0) {
        return requestAgreePrivacy$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$J8uE4sI4z02-Pykal8_8HmgiwrQ, reason: not valid java name */
    public static /* synthetic */ Unit m1218lambda$J8uE4sI4z02Pykal8_8HmgiwrQ(boolean r0) {
        return requestAgreePrivacyAndLogin$lambda$0(r0);
    }

    private static final Unit requestAgreePrivacy$lambda$1(boolean r2) {
        isAuthInProgress = false;
        Function1<? super Boolean, Unit> r0 = pendingCallback;
        pendingCallback = null;
        if (r0 == null) goto L6;
        r0.invoke(Boolean.valueOf(r2));
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit requestAgreePrivacyAndLogin$lambda$0(boolean r2) {
        isAuthInProgress = false;
        Function1<? super Boolean, Unit> r0 = pendingCallback;
        pendingCallback = null;
        if (r2 == true) goto L5;
        LoginRestartPageRecorder.clear();
    L5:
        if (r0 == null) goto L8;
        r0.invoke(Boolean.valueOf(r2));
    L8:
        return Unit.INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserStateManager
    public void requestAgreePrivacy(Context r3, Function1<? super Boolean, Unit> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "callback");
        pendingCallback = r6;
        if (isAuthInProgress == true) goto L5;
    L7:
        isAuthInProgress = true;
        AuthProxyActivity.Companion.a(r5, $$Lambda$UserStateManagerImpl$832mq1LWoPuTr5065qPwNEff16s.INSTANCE, false);
        return;
    L5:
        if (bringAuthTaskToFront(r5) == false) goto L7;
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserStateManager
    public void requestAgreePrivacyAndLogin(Context r3, Function1<? super Boolean, Unit> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "callback");
        pendingCallback = r6;
        if (isAuthInProgress == true) goto L5;
    L7:
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r5), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        LoginRestartPageRecorder.capture(r2);
    L11:
        isAuthInProgress = true;
        AuthProxyActivity.Companion.a(r5, $$Lambda$UserStateManagerImpl$J8uE4sI4z02Pykal8_8HmgiwrQ.INSTANCE, true);
        return;
    L10:
        LoginRestartPageRecorder.clear();
        goto L11
    L5:
        if (bringAuthTaskToFront(r5) == false) goto L7;
    }
}
