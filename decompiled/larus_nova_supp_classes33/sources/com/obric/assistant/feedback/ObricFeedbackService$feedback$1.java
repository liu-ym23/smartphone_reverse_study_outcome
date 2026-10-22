package com.obric.assistant.feedback;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.obric.assistant.feedback.upload.bean.ReportUploadTask;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.ss.android.agilelogger.ALog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.ObricFeedbackService$feedback$1", f = "ObricFeedbackService.kt", i = {0}, l = {ApWakeEvent.OTHER_START}, m = "invokeSuspend", n = {"feedbackMsgId"}, s = {"L$0"})
public final class ObricFeedbackService$feedback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AtomicBoolean $isPrivacyNotAgree;
    final /* synthetic */ IObricFeedbackService$c $param;
    Object L$0;
    int label;
    final /* synthetic */ ObricFeedbackService this$0;

    /* JADX INFO: renamed from: com.obric.assistant.feedback.ObricFeedbackService$feedback$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.feedback.ObricFeedbackService$feedback$1$2", f = "ObricFeedbackService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AtomicBoolean $isPrivacyNotAgree;
        final /* synthetic */ IObricFeedbackService$c $param;
        int label;

        public AnonymousClass2(IObricFeedbackService$c r1, AtomicBoolean r2, Continuation<? super AnonymousClass2> r3) {
            this.$param = r1;
            this.$isPrivacyNotAgree = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$param, this.$isPrivacyNotAgree, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            Function1<IObricFeedbackService$b, Unit> r4 = this.$param.s;
            if (r4 == null) goto L8;
            r4.invoke(new IObricFeedbackService$b(this.$isPrivacyNotAgree.get()));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ObricFeedbackService$feedback$1(IObricFeedbackService$c r1, ObricFeedbackService r2, AtomicBoolean r3, Continuation<? super ObricFeedbackService$feedback$1> r4) {
        this.$param = r1;
        this.this$0 = r2;
        this.$isPrivacyNotAgree = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricFeedbackService$feedback$1(this.$param, this.this$0, this.$isPrivacyNotAgree, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        String r1 = (String) this.L$0;
        ResultKt.throwOnFailure(r21);
        String r6 = r1;
        Object r3 = r21;
    L49:
        ObricFeedbackService$b r4 = (ObricFeedbackService$b) r3;
        if (r6.length() <= 0) goto L52;
        boolean r5 = true;
    L53:
        if (r5 == false) goto L91;
        if (r4 == null) goto L91;
        Map<String, Message> r7 = r4.a;
        if (r7 == null) goto L91;
        Message r8 = r7.get(r6);
        if (r8 == null) goto L91;
        IObricFeedbackService$c r9 = this.$param;
        d r10 = d.a;
        String r11 = r9.g;
        List<String> r12 = r9.a;
        String r13 = r9.f;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r8, "message");
        IObricFeedbackService.a.getClass();
        if (IObricFeedbackService.a.b(r11) == true) goto L91;
        Intrinsics.checkNotNullParameter(r8, "message");
        Map r14 = r8.getExt();
        if (r14 != null) goto L65;
        r14 = MapsKt.emptyMap();
    L65:
        if (r14.containsKey("o_omni_err_code") == false) goto L67;
    L72:
        boolean r15 = true;
    L73:
        if (r15 == false) goto L91;
        JSONObject r16 = d.a(r8);
        JSONArray r17 = new JSONArray();
        if (r12 != null) goto L78;
        r12 = CollectionsKt.emptyList();
    L78:
        Iterator<T> r18 = r12.iterator();
    L80:
        if (r18.hasNext() == false) goto L82;
        r17.put((String) r18.next());
        goto L80
    L82:
        Unit r19 = Unit.INSTANCE;
        r16.put("feedback_tags", r17);
        if (r13 != null) goto L85;
    L90:
        o.a.reportEvent("obric_omni_feedback_commit_click", r16);
        goto L91
    L85:
        if ((!StringsKt.isBlank(r13)) == true) goto L88;
        r13 = null;
    L88:
        if (r13 == null) goto L90;
        r16.put("source", r13);
        goto L90
    L67:
        if (r14.containsKey("o_omni_task_id") == true) goto L72;
        if (Intrinsics.areEqual(r14.get("o_is_omni_agent"), "1") == true) goto L72;
        r15 = false;
    L91:
        IObricFeedbackService$c r20 = this.$param;
        if (r20.r == false) goto L97;
        String r22 = r20.b;
        if (r22 != null) goto L96;
        r22 = "";
    L96:
        String r23 = r22;
        FLogger r24 = FLogger.a;
        r24.i("ObricFeedbackService", "feedback: called, wrapContent =\n" + r23);
        AppHost.Companion r25 = AppHost.a;
        if (r25.isTestChannel() == false) goto L153;
        Keva r26 = this.this$0.b;
        if (r26 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r26 = null;
    L151:
        boolean r27 = r26.getBoolean("obric_feedback_mode", true);
    L156:
        if (r27 == true) goto L166;
        List<String> r28 = this.$param.l;
        if (r28 != null) goto L160;
    L162:
        boolean r29 = false;
    L163:
        if (r29 == false) goto L165;
        Application r30 = aka.a.a;
        Bundle r31 = aka.a.a(r23, ObricFeedbackService.c(this.this$0, this.$param));
    L167:
        if (r31 == null) goto L169;
        Boolean r32 = Boxing.boxBoolean(r31.getBoolean(WindowEvent.WindowOpenPerfResult.SUCCESS, false));
    L170:
        if (r31 == null) goto L172;
        String r33 = r31.getString(WindowEvent.Params.ERROR_MSG, "");
    L173:
        if (r31 == null) goto L175;
        Integer r34 = Boxing.boxInt(r31.getInt("error_code"));
    L176:
        r24.i("ObricFeedbackService", "feedback: called, result = " + r31 + ", success = " + r32 + ", errCode = " + r34 + ", errorMsg = " + r33);
        if (r34 != null) goto L180;
    L182:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass2(this.$param, this.$isPrivacyNotAgree, null), 3, null);
        if (Intrinsics.areEqual(r33, "acquire content provider client failed") == false) goto L205;
        ObricFeedbackService r35 = this.this$0;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L187
        Object r37 = Result.constructor-impl(ObricFeedbackService.b(r35, r25.getApplication()));     // Catch: Throwable -> L187
    L189:
        List r38 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r37) == false) goto L192;
        r37 = r38;
    L192:
        List r39 = (List) r37;
        FLogger.a.i("ObricFeedbackService", "feedback: called, aiKernelAlogFiles = " + r39);
        ALog.asyncFlush();     // Catch: Exception -> L195
        ObricAlogServiceDelegate.b.e();     // Catch: Exception -> L195
        Thread.sleep(1000);     // Catch: Exception -> L195
    L197:
        com.obric.assistant.feedback.upload.d r40 = com.obric.assistant.feedback.upload.d.a;
        Application r41 = AppHost.a.getApplication();
        ReportUploadTask r42 = new ReportUploadTask(r23, true, CollectionsKt.plus(ObricFeedbackService.c(this.this$0, this.$param), r39), true, 327);
        monitor-enter(r40);
        Intrinsics.checkNotNullParameter(r41, "context");     // Catch: Throwable -> L202
        Intrinsics.checkNotNullParameter(r42, "task");     // Catch: Throwable -> L202
        FLogger.a.i("ReportUploadManager", "enqueueTask");     // Catch: Throwable -> L202
        com.obric.assistant.feedback.upload.d.b.a(r42);     // Catch: Throwable -> L202
        com.obric.assistant.feedback.upload.d.a();     // Catch: Throwable -> L202
        monitor-exit(r40);
    L225:
        return Unit.INSTANCE;
    L202:
        th = move-exception;
        throw th;
    L195:
        e = move-exception;
        FLogger.a.e("ObricFeedbackService", "uploadAlog Error in flush Alog to file!", e);
    L187:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L189
    L205:
        if (r34 == null) goto L220;
        if (r34.intValue() != 1001) goto L220;
        if (this.$param.m == false) goto L220;
        r24.e("ObricFeedbackService", "uploadUserReport: failed to upload user-report (not agreed license).");
        ObricFeedbackService.d(this.this$0, 2131912948);
        this.this$0.getClass();
        Intent r44 = new Intent("android.intent.action.MAIN");
        r44.setPackage("com.obric.feedbackserviceproject");
        r44.setClassName("com.obric.feedbackserviceproject", "com.obric.feedbackserviceproject.MainActivity");
        r44.addCategory("android.intent.category.LAUNCHER");
        r44.addFlags(268435456);
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L214
        r25.getApplication().startActivity(r44);     // Catch: Throwable -> L214
        Object r46 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L214
    L216:
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L225;
        FLogger.a.e("ObricFeedbackService", "launchReportApp: failed to launch report app", r47);
    L214:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r46 = Result.constructor-impl(ResultKt.createFailure(th));
    L220:
        if (Intrinsics.areEqual(r32, Boxing.boxBoolean(true)) == false) goto L225;
        if (this.$param.o == false) goto L225;
        ObricFeedbackService.d(this.this$0, 2131912949);
        goto L225
    L180:
        if (r34.intValue() != 1001) goto L182;
        this.$isPrivacyNotAgree.set(true);
        goto L182
    L175:
        r34 = null;
        goto L176
    L172:
        r33 = null;
        goto L173
    L169:
        r32 = null;
        goto L170
    L165:
        r31 = aka.a.a(r23, null);
        goto L167
    L160:
        if ((!r28.isEmpty()) != true) goto L162;
        r29 = true;
        goto L163
    L166:
        r31 = new Bundle();
        r31.putBoolean(WindowEvent.WindowOpenPerfResult.SUCCESS, false);
        r31.putString(WindowEvent.Params.ERROR_MSG, "acquire content provider client failed");
        goto L167
    L153:
        if (t9a.b.a().b() == true) goto L155;
        r27 = true;
        goto L156
    L155:
        r27 = false;
        goto L156
    L97:
        ObricFeedbackService r49 = this.this$0;
        List<String> r50 = r20.a;
        String r51 = r20.b;
        List<String> r52 = r20.c;
        Integer r53 = r20.j;
        if (r4 == null) goto L100;
        List<String> r54 = r4.b;
    L101:
        int r110 = ObricFeedbackService.e;
        r49.getClass();
        List<String> r55 = r50;
        if (r55 != null) goto L104;
    L107:
        boolean r56 = true;
    L108:
        String r111 = "无";
        if (r56 == false) goto L111;
        String r57 = "无";
    L112:
        if (r51 != null) goto L114;
    L117:
        boolean r58 = true;
    L118:
        if (r58 == false) goto L120;
        r51 = "无";
    L120:
        List<String> r59 = r52;
        if (r59 != null) goto L123;
    L126:
        boolean r60 = true;
    L127:
        if (r60 == true) goto L130;
        r111 = CollectionsKt.joinToString$default(r52, "、", null, null, 0, null, null, 62, null);
    L130:
        List<String> r61 = r54;
        if (r61 != null) goto L133;
    L136:
        boolean r62 = true;
    L137:
        if (r62 == false) goto L139;
        String r63 = "未指定";
    L140:
        if (r53 == null) goto L142;
        String r64 = "\n打分：" + r53.intValue();
    L143:
        if (r64 != null) goto L145;
        r64 = "";
    L145:
        r22 = "标签：" + r57 + "\n描述：" + r51 + "\n附件：" + r111 + r64 + "\nLogId：" + r63;
        goto L96
    L142:
        r64 = null;
        goto L143
    L139:
        r63 = CollectionsKt.joinToString$default(r54, "、", null, null, 0, null, null, 62, null);
        goto L140
    L133:
        if (r61.isEmpty() == true) goto L136;
        r62 = false;
        goto L137
    L123:
        if (r59.isEmpty() == true) goto L126;
        r60 = false;
        goto L127
    L114:
        if (r51.length() == 0) goto L117;
        r58 = false;
        goto L118
    L111:
        r57 = CollectionsKt.joinToString$default(r50, "、", null, null, 0, null, null, 62, null);
        goto L112
    L104:
        if (r55.isEmpty() == true) goto L107;
        r56 = false;
        goto L108
    L100:
        r54 = null;
        goto L101
    L52:
        r5 = false;
        goto L53
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        IObricFeedbackService.a r65 = IObricFeedbackService.a;
        String r66 = this.$param.g;
        r65.getClass();
        if (IObricFeedbackService.a.b(r66) == false) goto L11;
        FLogger.a.i("ObricFeedbackService", "feedback: skip Omni image drain for " + this.$param.g);
    L34:
        List<String> r67 = this.$param.d;
        if (r67 != null) goto L37;
        r67 = CollectionsKt.emptyList();
    L37:
        r6 = this.$param.e;
        if (r6 != null) goto L40;
        r6 = "";
    L40:
        LinkedHashSet r68 = new LinkedHashSet();
        r68.addAll(r67);
        if (r6.length() <= 0) goto L43;
        boolean r69 = true;
    L44:
        if (r69 == false) goto L46;
        r68.add(r6);
    L46:
        CoroutineDispatcher r70 = Dispatchers.getIO();
        ObricFeedbackService$feedback$1$messageResult$1 r71 = new ObricFeedbackService$feedback$1$messageResult$1(r68, this.this$0, r67, null);
        this.L$0 = r6;
        this.label = 1;
        r3 = BuildersKt.withContext(r70, r71, this);
        if (r3 != r2) goto L49;
        return r2;
    L43:
        r69 = false;
        goto L44
    L11:
        ObricFeedbackService r72 = this.this$0;
        IObricFeedbackService$c r73 = this.$param;
        int r74 = ObricFeedbackService.e;
        r72.getClass();
        String r75 = r73.p;
        if (r75 == null) goto L34;
        if ((!StringsKt.isBlank(r75)) == false) goto L16;
        String r76 = r75;
    L17:
        if (r76 == null) goto L34;
        Result.Companion r77 = Result.Companion;     // Catch: Throwable -> L29
        IAgentAppIntentIDL r78 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L29
        if (r78 == null) goto L27;
        List r112 = ObricFeedbackService.e(r73);     // Catch: Throwable -> L29
        String r113 = r73.b;     // Catch: Throwable -> L29
        Integer r79 = r73.j;     // Catch: Throwable -> L29
        if (r79 == null) goto L25;
        String r114 = r79.toString();     // Catch: Throwable -> L29
    L26:
        r78.drainOmniUploadImagesForFeedbackWithInfo(r76, r113, r112, r114, r73.k);     // Catch: Throwable -> L29
        goto L27
    L25:
        r114 = null;
    L27:
        Object r80 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r81 = Result.exceptionOrNull-impl(r80);
        if (r81 == null) goto L34;
        FLogger.a.w("ObricFeedbackService", "drainOmniUploadImagesForFeedback failed: " + r81.getMessage(), r81);
    L29:
        th = move-exception;
        Result.Companion r82 = Result.Companion;
        r80 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L16:
        r76 = null;
        goto L17
    }
}
