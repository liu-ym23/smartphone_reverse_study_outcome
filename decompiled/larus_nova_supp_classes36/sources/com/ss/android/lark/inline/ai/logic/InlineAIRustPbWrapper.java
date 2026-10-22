package com.ss.android.lark.inline.ai.logic;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.doc.v1.InlineAICancelTaskRequest;
import com.bytedance.lark.pb.space.doc.v1.InlineAICreateTaskRequest;
import com.bytedance.lark.pb.space.doc.v1.InlineAICreateTaskResponse;
import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatusPushResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.ai_engine.DebugInfoRequest;
import com.ss.android.lark.pb.ai_engine.DebugInfoResponse;
import com.ss.android.lark.pb.ai_engine.WorkMode;
import com.ss.android.lark.pb.office_ai_inline.FetchQuickActionRequest;
import com.ss.android.lark.pb.office_ai_inline.FetchQuickActionResponse;
import com.ss.android.lark.pb.office_ai_inline.Scenario;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import slb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InlineAIRustPbWrapper {
    public static final List<slb.d.a> a = null;

    public static final class a implements com.ss.android.lark.sdk.g.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void a(byte[] r4) {
            InlineAITaskStatus r5 = ((InlineAITaskStatusPushResponse) InlineAITaskStatusPushResponse.ADAPTER.decode(r4)).inline_ai_task_status;     // Catch: Throwable -> L9
            if (r5 == null) goto L16;
            zlb.b.a(r5);     // Catch: Throwable -> L9
            Iterator r0 = ((ArrayList) InlineAIRustPbWrapper.a).iterator();     // Catch: Throwable -> L9
        L6:
            if (r0.hasNext() == false) goto L17;
            ((slb.d.a) r0.next()).a(r5, false);     // Catch: Throwable -> L9
            goto L6
        L17:
            return;
        L16:
            return;
        L9:
            th = move-exception;
            Log.e("InlineAIRustPbWrapper", "push error", th);
        }
    }

    public interface b {

        public static final class a implements b {
            public final String a;
            public final String b;
            public final Map<String, String> c;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
            }

            public final String toString() {
                return "QuickActionParams(actionId=" + this.a + ", displayContent=" + this.b + ", params=" + this.c + ')';
            }

            @Override // com.ss.android.lark.inline.ai.logic.InlineAIRustPbWrapper.b
            public final String a() {
                return this.a;
            }

            public a(String r2, String r3, Map<String, String> r4) {
                Intrinsics.checkNotNullParameter(r2, "actionId");
                Intrinsics.checkNotNullParameter(r3, "displayContent");
                Intrinsics.checkNotNullParameter(r4, "params");
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.InlineAIRustPbWrapper$b$b, reason: collision with other inner class name */
        public static final class C0103b implements b {
            public final String a;
            public final Map<String, String> b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0103b) == true) goto L8;
                return false;
            L8:
                C0103b r6 = (C0103b) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                Map<String, String> r1 = this.b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public final String toString() {
                return "UserPromptParams(userPrompt=" + this.a + ", params=" + this.b + ')';
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.ss.android.lark.inline.ai.logic.InlineAIRustPbWrapper.b
            public final String a() {
                if ((this instanceof a) == true) goto L7;
                return "";
            L7:
                return ((a) this).a;
            }

            public C0103b(String r2, Map<String, String> r3) {
                Intrinsics.checkNotNullParameter(r2, "userPrompt");
                this.a = r2;
                this.b = r3;
            }
        }

        String a();
    }

    public static final class c<T> implements SdkSender.IParser {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object parse(byte[] r1) {
            return r1;
        }
    }

    public static final class d<T> implements SdkSender.IParser {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object parse(byte[] r2) {
            return (DebugInfoResponse) DebugInfoResponse.ADAPTER.decode(r2);
        }
    }

    public static final class e<T> implements SdkSender.IParser {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object parse(byte[] r2) {
            return (FetchQuickActionResponse) FetchQuickActionResponse.ADAPTER.decode(r2);
        }
    }

    public static final class f<T> implements SdkSender.IParser {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object parse(byte[] r2) {
            return (InlineAICreateTaskResponse) InlineAICreateTaskResponse.ADAPTER.decode(r2);
        }
    }

    static {
        com.ss.android.lark.sdk.g.e.a.b(Command.INLINE_AI_TASK_STATUS_PUSH, a.a);
        a = new ArrayList();
    }

    public static void a(String r19, final String r20) {
        Intrinsics.checkNotNullParameter(r19, "conversationId");
        Intrinsics.checkNotNullParameter(r20, "taskId");
        Map<String, zlb.b.a> r2 = zlb.b.a;
        Intrinsics.checkNotNullParameter(r20, "taskId");
        Map<String, zlb.b.a> r3 = zlb.b.a;
        zlb.b.a r4 = (zlb.b.a) ((LinkedHashMap) r3).get(r20);
        if (r4 == null) goto L22;
        long r5 = System.currentTimeMillis();
        int r6 = zlb.a.d;
        ScenarioType r7 = r4.b;
        String r8 = r4.c;
        String r9 = r4.d;
        long r12 = r4.f;
        if (r12 <= 0) goto L7;
        int r10 = (int) (r12 - r4.e);
    L8:
        if (r12 <= 0) goto L10;
        int r13 = (int) (r5 - r12);
    L11:
        int r14 = (int) (r5 - r4.e);
        InlineAITaskStatus r11 = r4.h;
        if (r11 == null) goto L16;
        String r15 = r11.content;
        if (r15 == null) goto L16;
        int r16 = r15.length();
    L17:
        int r17 = r4.i;
        long r0 = r4.g;
        if (r0 > 0) goto L21;
        r0 = r4.e;
    L21:
        int r18 = r10;
        zlb.a.C0355a.b(r7, r8, r9, -1, "cancel", r18, r13, r14, r16, r17, (int) (r5 - r0));
        String r1 = r4.a;
        Intrinsics.checkNotNullParameter(r1, "taskId");
        r3.remove(r1);
    L16:
        r16 = 0;
        goto L17
    L10:
        r13 = 0;
        goto L11
    L7:
        r10 = 0;
    L22:
        SdkSender.asynSendRequestNonWrap(Command.INLINE_AI_CANCEL_TASK, new InlineAICancelTaskRequest.Builder().unique_task_id(r20), new InlineAIRustPbWrapper$cancelTask$1(r20), c.a);
    }

    public static void b(String r2, IGetDataCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "aiMessageId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Log.i("InlineAIRustPbWrapper", "getDebugInfo()... aiMessageId = ".concat(r2));
        SdkSender.sendPassThroughRequest(com.ss.android.lark.pb.improto.Command.LARK_AI_GET_DEBUG_INFO, new DebugInfoRequest.Builder().message_id(r2).mode(WorkMode.Inline), r3, d.a);
    }

    public static void c(final ScenarioType r5, Map r6, final slb.e.a r7) {
        Intrinsics.checkNotNullParameter(r5, "scenario");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Log.i("InlineAIRustPbWrapper", "getQuickAction()... scenario = " + r5 + ", triggerParamsMap = " + r6);
        final long r0 = System.currentTimeMillis();
        com.ss.android.lark.pb.improto.Command r2 = com.ss.android.lark.pb.improto.Command.LARK_OFFICE_AI_INLINE_FETCH_QUICK_ACTION;
        FetchQuickActionRequest.Builder r3 = new FetchQuickActionRequest.Builder().scenario(Scenario.fromValue(r5.getInt()));
        if (r6 != null) goto L5;
        r6 = MapsKt.emptyMap();
    L5:
        SdkSender.sendPassThroughRequest(r2, r3.trigger_params_map(r6), new InlineAIRustPbWrapper$getQuickAction$1(r7, r0, r5), e.a);
    }

    public static void d(final ScenarioType r16, String r17, final String r18, final slb.j r19, j r20, l r21, final IGetDataCallback r22) {
        Intrinsics.checkNotNullParameter(r16, "scenario");
        Intrinsics.checkNotNullParameter(r18, "taskId");
        Intrinsics.checkNotNullParameter(r19, "prompt");
        Intrinsics.checkNotNullParameter(r21, "promptConfirmOptions");
        Intrinsics.checkNotNullParameter(r22, "callback");
        Log.i("InlineAIRustPbWrapper", "getQuickAction()... scenario = " + r16 + ", conversationId = " + r17 + ", taskId = " + r18);
        final long r10 = System.currentTimeMillis();
        if (r19.a.length() == 0) goto L5;
        String r6 = r19.a;
        if (r20 == null) goto L14;
        String r12 = g.d(r20);
        if (r12 == null) goto L14;
    L15:
        LinkedHashMap r13 = new LinkedHashMap();
        r13.putAll(r21.b);
        if ((r20 instanceof j.b) == false) goto L21;
        Iterator<T> r1 = ((j.b) r20).b.iterator();
    L19:
        if (r1.hasNext() == false) goto L21;
        j.b.a r2 = (j.b.a) r1.next();
        r13.put(r2.a, r2.d);
    L21:
        Unit r3 = Unit.INSTANCE;
        b r14 = new b.a(r6, r12, r13);
    L22:
        final String r7 = r14.a();
        String r4 = r19.getType();
        boolean r15 = false;
        if (r4.length() != 0) goto L25;
        boolean r5 = true;
    L27:
        if (r5 == false) goto L29;
        String r8 = "user_prompt";
    L30:
        Map<String, zlb.b.a> r9 = zlb.b.a;
        Intrinsics.checkNotNullParameter(r18, "taskId");
        Intrinsics.checkNotNullParameter(r16, "scenario");
        Intrinsics.checkNotNullParameter(r7, "promptId");
        Intrinsics.checkNotNullParameter(r8, "promptType");
        zlb.b.a.put(r18, new zlb.b.a(r18, r16, r7, r8));
        Command r11 = Command.INLINE_AI_CREATE_TASK;
        InlineAICreateTaskRequest.Builder r23 = new InlineAICreateTaskRequest.Builder();
        if (r17 != null) goto L33;
    L34:
        r15 = true;
    L35:
        if (r15 == true) goto L37;
        r23.session_id(r17);
    L37:
        r23.unique_task_id(r18);
        r23.scenario(com.bytedance.lark.pb.space.doc.v1.Scenario.fromValue(r16.getInt()));
        if ((r14 instanceof b.a) == false) goto L41;
        r23.action_type("quick_action");
        b.a r0 = (b.a) r14;
        r23.action_id(r0.a);
        r23.display_content(r0.b);
        r23.params(r0.c);
    L45:
        final String r110 = r8;
        final b r24 = r14;
        SdkSender.asynSendRequestNonWrap(r11, r23, new InlineAIRustPbWrapper$sendPrompt$2(r22, r10, r16, r7, r110, r18, r24, r19), f.a);
        return;
    L41:
        if ((r14 instanceof b.C0103b) == false) goto L48;
        r23.action_type("user_prompt");
        b.C0103b r25 = (b.C0103b) r14;
        r23.user_prompt(r25.a);
        Map<String, String> r26 = r25.b;
        if (r26 == null) goto L45;
        r23.params(r26);
        goto L45
    L48:
        throw new NoWhenBranchMatchedException();
    L33:
        if (r17.length() != 0) goto L35;
    L29:
        r8 = r4;
        goto L30
    L25:
        r5 = false;
    L14:
        r12 = r19.d;
        goto L15
    L5:
        if (r20 == null) goto L8;
        String r27 = g.d(r20);
        if (r27 == null) goto L8;
    L9:
        r14 = new b.C0103b(r27, r21.b);
    L8:
        r27 = "";
        goto L9
    }
}
