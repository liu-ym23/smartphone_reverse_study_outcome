package com.obric.assistant.obric_action.handler;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentTaskAppIDL;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import gd9.i;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/obric_action/handler/ObricOpenEventTaskDetailHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/ObricOpenEventTaskDetailHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/ObricOpenEventTaskDetailHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOpenEventTaskDetailHandler implements IObricActionHandler<b, Unit> {

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/obric_action/handler/ObricOpenEventTaskDetailHandler$Params;", "", "taskId", "", "enterFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getEnterFrom", "component1", "component2", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("enter_from")
        private final String enterFrom;

        @SerializedName("instruction_id")
        private final String taskId;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.enterFrom, r6.enterFrom) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.taskId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.enterFrom;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(taskId=" + this.taskId + ", enterFrom=" + this.enterFrom + ')';
        }

        public b() {
            this.taskId = null;
            this.enterFrom = null;
        }

        public final String a() {
            return this.enterFrom;
        }

        public final String b() {
            return this.taskId;
        }
    }

    static {
    }

    public ObricOpenEventTaskDetailHandler() {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.g.a;
        return d.g.c;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return b.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r1, String r2) {
        return (b) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r7, b r8, Continuation<? super h<? extends Unit>> r9) {
        b r10 = r8;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L32
        if (r10 == null) goto L6;
        String r3 = r10.b();     // Catch: Throwable -> L32
    L7:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L32
        r4.i("ObricOpenEventTaskDetailHandler", "openEventTaskDetailPage, task_id=".concat(r3));     // Catch: Throwable -> L32
        boolean r0 = false;
        if (r7.getResources().getConfiguration().orientation != 2) goto L13;
        r4.i("ObricOpenEventTaskDetailHandler", "openEventTaskDetailPage failed, landscape is not supported");     // Catch: Throwable -> L32
        s r11 = s.a;     // Catch: Throwable -> L32
        i r12 = com.larus.im.b.a;     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L32
        r11.g(r12.getApplication(), 2131912394, false);     // Catch: Throwable -> L32
        h r13 = h.a.a(h.d, "landscape is not supported", 2);     // Catch: Throwable -> L32
    L30:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L32
    L34:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L37;
        FLogger.a.w("ObricOpenEventTaskDetailHandler", "openEventTaskDetailPage failed. " + r15.getMessage(), r15);
    L37:
        Throwable r16 = Result.exceptionOrNull-impl(r14);
        if (r16 != null) goto L41;
        return r14;
    L41:
        return h.a.a(h.d, r16.getMessage(), 2);
    L13:
        if (r3.length() != 0) goto L15;
        r0 = true;
    L15:
        if (r0 == false) goto L17;
        r13 = h.a.a(h.d, "task_id is empty", 2);     // Catch: Throwable -> L32
        goto L30
    L17:
        IAgentTaskAppIDL r17 = com.obric.aiagent.assistant.idl.s.a(Reflection.getOrCreateKotlinClass(IAgentTaskAppIDL.class));     // Catch: Throwable -> L32
        if (r17 != null) goto L20;
        r4.w("ObricOpenEventTaskDetailHandler", "openEventTaskDetailPage failed, IAgentTaskAppIDL is null");     // Catch: Throwable -> L32
        r13 = h.a.a(h.d, "IAgentTaskAppIDL is null", 2);     // Catch: Throwable -> L32
        goto L30
    L20:
        if (r10 == null) goto L28;
        String r18 = r10.a();     // Catch: Throwable -> L32
        if (r18 == null) goto L28;
        if ((!StringsKt.isBlank(r18)) == true) goto L27;
        r18 = null;
    L27:
        if (r18 == null) goto L28;
    L29:
        r17.openEventTaskDetailPage(r3, r18);     // Catch: Throwable -> L32
        r13 = h.a.c(h.d, null, "openEventTaskDetailPage success", 1);     // Catch: Throwable -> L32
    L28:
        r18 = "obric_action";
        goto L29
    L6:
        r3 = null;
    L32:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    }
}
