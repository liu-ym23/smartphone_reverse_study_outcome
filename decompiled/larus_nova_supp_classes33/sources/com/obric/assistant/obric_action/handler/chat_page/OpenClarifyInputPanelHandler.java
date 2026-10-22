package com.obric.assistant.obric_action.handler.chat_page;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.ISpecialInputTask$a;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.special_input.c;
import com.obric.assistant.special_input.util.j;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.utils.e;
import com.obric.assistant.utils.f;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenClarifyInputPanelHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/chat_page/OpenClarifyInputPanelHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/chat_page/OpenClarifyInputPanelHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenClarifyInputPanelHandler implements IObricActionHandler<b, Unit> {
    public final Class<b> b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\b\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\t\u0010\u0011¨\u0006\""}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenClarifyInputPanelHandler$Params;", "", "needMonitorAnim", "", "taskId", "sourceFrom", "force", "", "isAppInnerCall", "isAutoOpen", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getNeedMonitorAnim", "()Ljava/lang/String;", "getTaskId", "getSourceFrom", "getForce", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "needMonitorAnimEnabled", "default", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/assistant/obric_action/handler/chat_page/OpenClarifyInputPanelHandler$Params;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("force")
        private final Boolean force;

        @SerializedName("is_app_inner_call")
        private final Boolean isAppInnerCall;

        @SerializedName("is_auto_open")
        private final Boolean isAutoOpen;

        @SerializedName("need_monitor_animkey")
        private final String needMonitorAnim;

        @SerializedName("source_from")
        private final String sourceFrom;

        @SerializedName("task_id")
        private final String taskId;

        public b() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.needMonitorAnim, r6.needMonitorAnim) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.sourceFrom, r6.sourceFrom) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.force, r6.force) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.isAppInnerCall, r6.isAppInnerCall) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.isAutoOpen, r6.isAutoOpen) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.needMonitorAnim;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.taskId;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.sourceFrom;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Boolean r10 = this.force;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Boolean r13 = this.isAppInnerCall;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Boolean r16 = this.isAutoOpen;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(needMonitorAnim=" + this.needMonitorAnim + ", taskId=" + this.taskId + ", sourceFrom=" + this.sourceFrom + ", force=" + this.force + ", isAppInnerCall=" + this.isAppInnerCall + ", isAutoOpen=" + this.isAutoOpen + ')';
        }

        public final Boolean a() {
            return this.force;
        }

        public final String b() {
            return this.sourceFrom;
        }

        public final String c() {
            return this.taskId;
        }

        public final Boolean d() {
            return this.isAppInnerCall;
        }

        public final Boolean e() {
            return this.isAutoOpen;
        }

        public b(int r1) {
            this.needMonitorAnim = null;
            this.taskId = null;
            this.sourceFrom = null;
            this.force = null;
            this.isAppInnerCall = null;
            this.isAutoOpen = null;
        }

        public static boolean f(b r3) {
            String r4 = r3.needMonitorAnim;
            if (r4 == null) goto L7;
            String r5 = StringsKt.trim(r4).toString();
            if (r5 == null) goto L7;
            String r6 = r5.toLowerCase(Locale.ROOT);
        L9:
            if (r6 == null) goto L29;
            int r1 = r6.hashCode();
            if (r1 != 48) goto L13;
            String r2 = "0";
        L20:
            r6.equals(r2);
            return false;
        L13:
            if (r1 == 49) goto L25;
            if (r1 == 3569038) goto L22;
            if (r1 != 97196323) goto L32;
            r2 = "false";
            goto L20
        L32:
            return false;
        L22:
            if (r6.equals("true") == false) goto L33;
        L27:
            return true;
        L33:
            return false;
        L25:
            if (r6.equals("1") == true) goto L27;
            return false;
        L29:
            return false;
        L7:
            r6 = null;
            goto L9
        }
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.C0010d.a;
        return d.C0010d.e;
    }

    public OpenClarifyInputPanelHandler() {
        this.b = b.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r1, String r2) {
        return (b) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r24, b r25, Continuation<? super h<? extends Unit>> r26) {
        b r0 = r25;
        boolean r1 = false;
        if (r0 != null) goto L5;
        r0 = new b(0);
    L5:
        FLogger r2 = FLogger.a;
        r2.i("OpenAssistantInputPanelHandler", "handle: params = " + r0);
        String r3 = r0.c();
        String r5 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (r3.length() != 0) goto L11;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        r2.w("OpenAssistantInputPanelHandler", "handle: task_id is empty, abort");
        return h.a.a(h.d, "task_id is empty", 2);
    L15:
        ObricTaskStatusManager.a.getClass();
        DMTaskState r7 = ObricTaskStatusManager.e(r3);
        if (r7 != null) goto L18;
        r2.w("OpenAssistantInputPanelHandler", "handle: no such task for task_id=".concat(r3));
        return h.a.a(h.d, "task not found", 2);
    L18:
        String r8 = r0.b();
        if (r8 != null) goto L21;
    L28:
        r8 = "bot_chat_card";
    L29:
        ISpecialInputTask r16 = c.a();
        if (r16 == null) goto L45;
        StateInfo r17 = j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), false, MapsKt.mapOf(TuplesKt.to("source_from", r8)), null, r7, 10);
        Boolean r9 = r0.a();
        if (r9 == null) goto L34;
        boolean r18 = r9.booleanValue();
    L35:
        Boolean r10 = r0.d();
        if (r10 == null) goto L38;
        boolean r19 = r10.booleanValue();
    L39:
        Boolean r11 = r0.e();
        if (r11 == null) goto L42;
        boolean r20 = r11.booleanValue();
    L43:
        ISpecialInputTask$a.a(r16, r17, r18, r19, r20, null, 16);
        goto L45
    L42:
        r20 = true;
        goto L43
    L38:
        r19 = true;
        goto L39
    L34:
        r18 = true;
    L45:
        if (b.f(r0) == true) goto L47;
        r2.i("OpenAssistantInputPanelHandler", "handle: needMonitorAnim is false, skip anchor anim");
        return h.a.c(h.d, null, null, 3);
    L47:
        DMTaskInfo r4 = r7.getTaskInfo();
        if (r4 == null) goto L50;
        String r12 = f.a(r4);
    L51:
        if (r12 == null) goto L54;
        r5 = r12;
    L54:
        r2.i("OpenAssistantInputPanelHandler", "handle: resolved lastReplyMsgId=" + r5 + " from task_id=" + r3);
        if (r5.length() != 0) goto L57;
        r1 = true;
    L57:
        if (r1 == false) goto L59;
        r2.w("OpenAssistantInputPanelHandler", "handle: lastReplyMsgId is empty, skip scroll");
        return h.a.c(h.d, null, null, 3);
    L59:
        int r13 = e.a;
        Object r14 = e.a(Activity.class);
        if ((r14 instanceof FragmentActivity) == false) goto L62;
        FragmentActivity r15 = (FragmentActivity) r14;
    L63:
        if (r15 != null) goto L65;
    L67:
        r15 = null;
    L68:
        if (r15 == null) goto L70;
        laa.c r21 = cfa.e.a(r15.getSupportFragmentManager());
    L71:
        if (r21 == null) goto L74;
        r21.vC(r5);
    L74:
        return h.a.c(h.d, null, null, 3);
    L70:
        r21 = null;
        goto L71
    L65:
        if ((!r15.isFinishing()) == false) goto L67;
    L62:
        r15 = null;
        goto L63
    L50:
        r12 = null;
        goto L51
    L21:
        if (r8.length() <= 0) goto L23;
        boolean r22 = true;
    L24:
        if (r22 == true) goto L27;
        r8 = null;
    L27:
        if (r8 != null) goto L29;
    L23:
        r22 = false;
        goto L24
    L11:
        r6 = false;
        goto L13
    }
}
