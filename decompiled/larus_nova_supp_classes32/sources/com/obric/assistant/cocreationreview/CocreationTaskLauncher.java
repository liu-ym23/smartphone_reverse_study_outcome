package com.obric.assistant.cocreationreview;

import android.os.Bundle;
import com.obric.assistant.AutoEndConversationTime;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import gd8.g;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class CocreationTaskLauncher {
    public static final CocreationTaskLauncher a = null;

    public static final class a {
        public final boolean a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Result(sent=" + this.a + ", errorMessage=" + this.b + ')';
        }

        public a(boolean r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
        public final String a;
        public final g b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "SendTarget(conversationId=" + this.a + ", sender=" + this.b + ')';
        }

        public b(String r2, g r3) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            Intrinsics.checkNotNullParameter(r3, "sender");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new CocreationTaskLauncher();
    }

    public CocreationTaskLauncher() {
    }

    public final Object a(e4 r27, String r28, Continuation<? super a> r29) {
        if ((r29 instanceof CocreationTaskLauncher$run$1) == false) goto L7;
        CocreationTaskLauncher$run$1 r3 = (CocreationTaskLauncher$run$1) r29;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L19;
        if (r6 == 1) goto L16;
        if (r6 != 2) goto L15;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L44 CancellationException -> L47
    L39:
        a r1 = (a) r0;     // Catch: Exception -> L44 CancellationException -> L47
        if (r1 == null) goto L51;
        return r1;
    L51:
        return new a(false, "未收到发送结果，请先查看豆包会话");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Ref.ObjectRef r7 = (Ref.ObjectRef) r3.L$2;
        String r9 = (String) r3.L$1;
        e4 r12 = (e4) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L44 CancellationException -> L47
        String r13 = r9;
    L27:
        b r2 = (b) r0;     // Catch: Exception -> L44 CancellationException -> L47
        if (r2 != null) goto L31;
        int r8 = s3.a;     // Catch: Exception -> L44 CancellationException -> L47
        s3.c("task.run", "readiness timeout waitingFor=" + ((String) r7.element));     // Catch: Exception -> L44 CancellationException -> L47
        return new a(false, "手机模式未就绪，请稍后重试");
    L31:
        Map r10 = MapsKt.plus(ObricActionBarSendServiceDelegate.b.v(), r12.a());     // Catch: Exception -> L44 CancellationException -> L47
        if (Intrinsics.areEqual(r10.get("o_task_type"), "complex_task") == false) goto L43;
        if (Intrinsics.areEqual(r10.get("o_task_state"), "start_complex_task") == false) goto L43;
        int r11 = s3.a;     // Catch: Exception -> L44 CancellationException -> L47
        s3.b("task.run", "phone mode ready, sending textLength=" + r13.length());     // Catch: Exception -> L44 CancellationException -> L47
        CocreationTaskLauncher$run$3 r14 = new CocreationTaskLauncher$run$3(r2, r13, r10, null);     // Catch: Exception -> L44 CancellationException -> L47
        r3.L$0 = null;     // Catch: Exception -> L44 CancellationException -> L47
        r3.L$1 = null;     // Catch: Exception -> L44 CancellationException -> L47
        r3.L$2 = null;     // Catch: Exception -> L44 CancellationException -> L47
        r3.label = 2;     // Catch: Exception -> L44 CancellationException -> L47
        r0 = TimeoutKt.c(AutoEndConversationTime.AFTER_60_SECONDS, r14, r3);     // Catch: Exception -> L44 CancellationException -> L47
        if (r0 != r5) goto L39;
        return r5;
    L43:
        return new a(false, "手机任务暂不可用，请稍后重试");
    L19:
        ResultKt.throwOnFailure(r0);
        IAssistantChatWindow r15 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r15 == null) goto L22;
        Boolean r16 = Boxing.boxBoolean(false);     // Catch: Exception -> L44 CancellationException -> L47
        Bundle r17 = new Bundle();     // Catch: Exception -> L44 CancellationException -> L47
        r17.putBoolean("arg_launch_half_screen", true);     // Catch: Exception -> L44 CancellationException -> L47
        Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L44 CancellationException -> L47
        IAssistantChatWindow.DefaultImpls.openChatWindow$default(r15, "cocreation_task_center", false, r16, r17, false, false, null, null, false, false, 1008, null);     // Catch: Exception -> L44 CancellationException -> L47
        r7 = new Ref.ObjectRef();     // Catch: Exception -> L44 CancellationException -> L47
        r7.element = "window";     // Catch: Exception -> L44 CancellationException -> L47
        CocreationTaskLauncher$run$target$1 r19 = new CocreationTaskLauncher$run$target$1(r15, r7, null);     // Catch: Exception -> L44 CancellationException -> L47
        r3.L$0 = r27;     // Catch: Exception -> L44 CancellationException -> L47
        r13 = r28;
        r3.L$1 = r13;     // Catch: Exception -> L44 CancellationException -> L47
        r3.L$2 = r7;     // Catch: Exception -> L44 CancellationException -> L47
        r3.label = 1;     // Catch: Exception -> L44 CancellationException -> L47
        Object r20 = TimeoutKt.c(15000, r19, r3);     // Catch: Exception -> L44 CancellationException -> L47
        if (r20 != r5) goto L26;
        return r5;
    L26:
        r12 = r27;
        r0 = r20;
        goto L27
    L22:
        return new a(false, "豆包暂不可用，请稍后重试");
    L47:
        e = move-exception;
        throw e;
    L44:
        e = move-exception;
        int r21 = s3.a;
        s3.c("task.run", "launch failed type=".concat(e.getClass().getSimpleName()));
        return new a(false, "任务启动失败，请稍后重试");
    L7:
        r3 = new CocreationTaskLauncher$run$1(this, r29);
        goto L8
    }
}
