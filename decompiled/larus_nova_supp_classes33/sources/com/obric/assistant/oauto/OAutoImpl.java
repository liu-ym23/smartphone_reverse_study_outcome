package com.obric.assistant.oauto;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.util.AssistantInteractionListenerIDLWrapper;
import com.obric.assistant.util.StartActivityForResultHelper;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J6\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016JY\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\n0\u001dH\u0016J.\u0010!\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0002¨\u0006#"}, d2 = {"Lcom/obric/assistant/oauto/OAutoImpl;", "Lcom/obric/assistant/oauto/IOAutoApi;", "<init>", "()V", "isAssistantDisplayInOAuto", "", "isDisplayInOAuto", "task", "Landroid/app/TaskInfo;", "notifyAssistantTakeOver", "", "isOAutoVirtualDisplayIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "jumpToOAutoVirtualDisplay", "context", "Landroid/content/Context;", "catchError", "jumpToOAutoTaskList", "jumpToOAutoConditionEventDetailStarter", "jumpToOAutoCreateShortcut", "query", "", "messageId", "taskModelJson", "jumpToOAutoCreateShortcutForResult", "activity", "Landroid/app/Activity;", "onCreateResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", WindowEvent.WindowOpenPerfResult.SUCCESS, "buildCreateShortcutIntent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OAutoImpl implements IOAutoApi {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public OAutoImpl() {
    }

    @Override // com.obric.assistant.oauto.IOAutoApi
    public final boolean b() {
        if (Build.VERSION.SDK_INT < 30) goto L20;
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 == null) goto L9;
        Display r1 = r0.getDisplay();
        if (r1 == null) goto L9;
        String r2 = r1.getName();
    L10:
        if (r0 == null) goto L14;
        Display r3 = r0.getDisplay();
        if (r3 == null) goto L14;
        int r4 = r3.getDisplayId();
    L15:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("isAssistantDisplayInOAuto: curActivity = ");
        r6.append(r0);
        r6.append(", displayName = ");
        if (r2 != null) goto L18;
        String r7 = "";
    L19:
        r6.append(r7);
        r6.append(", displayId = ");
        r6.append(r4);
        r5.i("OAutoImpl", r6.toString());
        return Intrinsics.areEqual(r2, "auto_action");
    L18:
        r7 = r2;
    L14:
        r4 = -1;
    L9:
        r2 = null;
        goto L10
    L20:
        FLogger.a.w("OAutoImpl", "isAssistantDisplayInOAuto: api version is lower than R, can not check assistant display in oauto");
        return false;
    }

    @Override // com.obric.assistant.oauto.IOAutoApi
    public final void f() {
        FLogger.a.i("OAutoImpl", "notifyAssistantTakeOver");
        ISpecialInputTask r0 = com.obric.assistant.special_input.c.a();
        if (r0 == null) goto L8;
        AssistantInteractionListenerIDLWrapper r1 = r0.h("com.obric.autoaction");
        if (r1 == null) goto L9;
        r1.onAssistantTakeOver();
        return;
    L9:
        return;
    }

    @Override // com.obric.assistant.oauto.IOAutoApi
    public final boolean c(Intent r4) {
        if (r4 == null) goto L16;
        ComponentName r5 = r4.getComponent();
        if (r5 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r5.getClassName(), "com.obric.autoaction.app.presentation.SurfaceCardStarterActivity") == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r5.getPackageName(), "com.obric.autoaction") == false) goto L13;
    L14:
        return true;
    L13:
        if (Intrinsics.areEqual(r5.getPackageName(), AppHost.a.getApplication().getPackageName()) == true) goto L14;
        return false;
    L16:
        return false;
    }

    @Override // com.obric.assistant.oauto.IOAutoApi
    public final void e(Context r4, Intent r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intent r0 = new Intent(r5);
        r0.setComponent(new ComponentName(r4.getPackageName(), "com.obric.autoaction.app.launcherpage.ConditionEventDetailStarterActivity"));
        if ((r4 instanceof Activity) == true) goto L17;
        r0.addFlags(268435456);
    L17:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L7
        r4.startActivity(r0);     // Catch: Throwable -> L7
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        if (Result.isSuccess-impl(r7) == false) goto L12;
        Unit r8 = (Unit) r7;
        FLogger.a.i("OAutoImpl", "jumpToOAutoConditionEventDetailStarter success");
    L12:
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 != null) goto L15;
        return;
    L15:
        FLogger r10 = FLogger.a;
        r10.w("OAutoImpl", "jumpToOAutoConditionEventDetailStarter failed. " + r9.getMessage(), r9);
        r10.w("OAutoImpl", "jumpToOAutoConditionEventDetailStarter failed, and catchError is false. " + r9.getMessage(), r9);
        throw r9;
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.obric.assistant.oauto.IOAutoApi
    public final void h(Context r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Intent r1 = new Intent();     // Catch: Throwable -> L8
        r1.setComponent(new ComponentName(r5.getPackageName(), "com.obric.autoaction.app.launcherpage.LauncherPageStarterActivity"));     // Catch: Throwable -> L8
        if ((r5 instanceof Activity) == true) goto L6;
        r1.addFlags(268435456);     // Catch: Throwable -> L8
    L6:
        r5.startActivity(r1);     // Catch: Throwable -> L8
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (Result.isSuccess-impl(r7) == false) goto L13;
        Unit r2 = (Unit) r7;
        FLogger.a.i("OAutoImpl", "jumpToOAutoTaskList success");
    L13:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L20;
        FLogger r3 = FLogger.a;
        r3.w("OAutoImpl", "jumpToOAutoTaskList failed. " + r8.getMessage(), r8);
        if (r6 == true) goto L23;
        r3.w("OAutoImpl", "jumpToOAutoTaskList failed, and catchError is false. " + r8.getMessage(), r8);
        throw r8;
    L23:
        return;
    L20:
        return;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.obric.assistant.oauto.IOAutoApi
    public final boolean g(Context r5, Intent r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        FLogger.a.i("OAutoImpl", "jumpToOAutoVirtualDisplay: intent = " + r6 + ", catchError = " + r7 + "，throwException " + Log.getStackTraceString(new Throwable()));
        if (r6 == null) goto L5;
        Intent r0 = new Intent(r6);
    L6:
        r0.setComponent(new ComponentName(AppHost.a.getApplication().getPackageName(), "com.obric.autoaction.app.presentation.SurfaceCardStarterActivity"));
        if ((r5 instanceof Activity) == true) goto L32;
        r0.addFlags(268435456);
    L32:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L15
        if (Build.VERSION.SDK_INT < 26) goto L12;
        ActivityOptions r9 = ActivityOptions.makeBasic();     // Catch: Throwable -> L15
        r9.setLaunchDisplayId(0);     // Catch: Throwable -> L15
        r5.startActivity(r0, r9.toBundle());     // Catch: Throwable -> L15
    L13:
        Object r10 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L15
    L18:
        if (Result.isSuccess-impl(r10) == false) goto L20;
        ((Boolean) r10).booleanValue();
        FLogger.a.i("OAutoImpl", "jumpToOAutoVirtualDisplay success");
    L20:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L27;
        FLogger r1 = FLogger.a;
        r1.w("OAutoImpl", "jumpToOAutoVirtualDisplay failed. " + r11.getMessage(), r11);
        if (r7 == true) goto L27;
        r1.w("OAutoImpl", "jumpToOAutoVirtualDisplay failed, and catchError is false. " + r11.getMessage(), r11);
        throw r11;
    L27:
        Boolean r12 = Boolean.FALSE;
        if (Result.isFailure-impl(r10) == false) goto L31;
        r10 = r12;
    L31:
        return ((Boolean) r10).booleanValue();
    L12:
        r5.startActivity(r0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        r0 = new Intent();
        goto L6
    }

    public static Intent i(Context r3, String r4, String r5, String r6) {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(r3.getPackageName(), "com.obric.autoaction.app.launcherpage.ShortCutCreateStarterActivity"));
        r0.putExtra("key_enter_from", "create_from_msg");
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.putExtra("key_query", r4);
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r0.putExtra("key_source_message_id", r5);
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r0.putExtra("key_task_model", r6);
        return r0;
    }

    @Override // com.obric.assistant.oauto.IOAutoApi
    public final void a(Context r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intent r6 = i(r2, r3, r4, r5);
        if ((r2 instanceof Activity) == true) goto L17;
        r6.addFlags(268435456);
    L17:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L7
        r2.startActivity(r6);     // Catch: Throwable -> L7
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        if (Result.isSuccess-impl(r8) == false) goto L12;
        Unit r9 = (Unit) r8;
        FLogger.a.i("OAutoImpl", "jumpToOAutoCreateShortcut success");
    L12:
        Throwable r10 = Result.exceptionOrNull-impl(r8);
        if (r10 != null) goto L15;
        return;
    L15:
        FLogger r11 = FLogger.a;
        r11.w("OAutoImpl", "jumpToOAutoCreateShortcut failed. " + r10.getMessage(), r10);
        r11.w("OAutoImpl", "jumpToOAutoCreateShortcut failed, and catchError is false. " + r10.getMessage(), r10);
        throw r10;
    L7:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.obric.assistant.oauto.c] */
    @Override // com.obric.assistant.oauto.IOAutoApi
    public final void d(Activity r2, String r3, String r4, String r5, final com.obric.assistant.obric_action.handler.a r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r6, "onCreateResult");
        Intent r7 = i(r2, r3, r4, r5);
        final AtomicBoolean r8 = new AtomicBoolean(false);
        final ?? r9 = new c(r8, r6);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        StartActivityForResultHelper.a.startActivityForResult(r7, new d(r9), new e(r9));     // Catch: Throwable -> L5
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 != null) goto L10;
        return;
    L10:
        FLogger.a.w("OAutoImpl", "jumpToOAutoCreateShortcutForResult failed. " + r12.getMessage(), r12);
        r9.invoke(Boolean.FALSE);
        throw r12;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
