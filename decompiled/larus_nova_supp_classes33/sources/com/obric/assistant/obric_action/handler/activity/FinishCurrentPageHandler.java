package com.obric.assistant.obric_action.handler.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.IObricActionService;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.utils.e;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/obric_action/handler/activity/FinishCurrentPageHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/activity/FinishCurrentPageHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/activity/FinishCurrentPageHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleDispatchAfterStopped", "target", "Landroid/app/Activity;", "flowIntent", "", "dispatchFlowIntent", "", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FinishCurrentPageHandler implements IObricActionHandler<b, Unit> {
    public static final /* synthetic */ int c = 0;
    public final Class<b> b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/obric_action/handler/activity/FinishCurrentPageHandler$Params;", "", "flowIntent", "", "<init>", "(Ljava/lang/String;)V", "getFlowIntent", "()Ljava/lang/String;", "component1", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("flow_intent")
        private final String flowIntent;

        public b() {
            this(0);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.flowIntent, ((b) r4).flowIntent) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.flowIntent;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Params(flowIntent=" + this.flowIntent + ')';
        }

        public final String a() {
            return this.flowIntent;
        }

        public b(int r1) {
            this.flowIntent = null;
        }
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.a.a;
        return d.a.a;
    }

    public FinishCurrentPageHandler() {
        this.b = b.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return this.b;
    }

    public static boolean e(Context r6, String r7) {
        boolean r2 = false;
        if (r7.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L25;
        FLogger.a.i("FinishCurrentPageHandler", "dispatchFlowIntent: flowIntent is empty, skip");
        return true;
    L25:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        FLogger.a.i("FinishCurrentPageHandler", "dispatchFlowIntent: dispatch flowIntent = ".concat(r7));     // Catch: Throwable -> L15
        IObricActionService r0 = (IObricActionService) ServiceManager.get().getService(IObricActionService.class);     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        r0.d(r6, r7, "always_pass");     // Catch: Throwable -> L15
        r2 = true;
    L13:
        Object r8 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L15
    L17:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L20;
        FLogger.a.w("FinishCurrentPageHandler", "dispatchFlowIntent: dispatch failed. " + r9.getMessage(), r9);
    L20:
        Boolean r10 = Boolean.TRUE;
        if (Result.isFailure-impl(r8) == false) goto L24;
        r8 = r10;
    L24:
        return ((Boolean) r8).booleanValue();
    L15:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r1, String r2) {
        return (b) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(final Context r7, b r8, Continuation<? super h<? extends Unit>> r9) {
        b r10 = r8;
        boolean r11 = false;
        if (r10 != null) goto L5;
        r10 = new b(0);
    L5:
        FLogger r0 = FLogger.a;
        r0.i("FinishCurrentPageHandler", "handle: params = " + r10);
        final String r12 = r10.a();
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        if ((r7 instanceof Activity) == false) goto L11;
        Activity r1 = (Activity) r7;
    L13:
        if (r1 != null) goto L20;
        int r2 = e.a;
        r1 = (Activity) e.a(Activity.class);
        if (r1 != null) goto L17;
    L19:
        r1 = null;
        goto L20
    L17:
        if ((!r1.isFinishing()) == false) goto L19;
    L20:
        if (r1 != null) goto L23;
        r0.w("FinishCurrentPageHandler", "handle: no available activity to finish, dispatch flowIntent immediately");
        return h.d.b(e(r7, r12));
    L23:
        if (r12.length() <= 0) goto L25;
        r11 = true;
    L25:
        if (r11 == false) goto L35;
        final Handler r13 = new Handler(Looper.getMainLooper());
        if ((r1 instanceof LifecycleOwner) == false) goto L29;
        LifecycleOwner r4 = (LifecycleOwner) r1;
    L30:
        if (r4 == null) goto L35;
        Lifecycle r5 = r4.getLifecycle();
        if (r5 == null) goto L35;
        r5.addObserver(new FinishCurrentPageHandler$scheduleDispatchAfterStopped$1(r13, this, r7, r12));
        goto L35
    L29:
        r4 = null;
    L35:
        if (r1.isFinishing() == false) goto L37;
    L39:
        r0.i("FinishCurrentPageHandler", "handle: activity already finishing/destroyed, skip finish call");
    L41:
        return h.a.c(h.d, null, null, 3);
    L37:
        if (r1.isDestroyed() == true) goto L39;
        r0.i("FinishCurrentPageHandler", "handle: finish activity " + r1);
        r1.finish();
        goto L41
    L11:
        r1 = null;
        goto L13
    }
}
