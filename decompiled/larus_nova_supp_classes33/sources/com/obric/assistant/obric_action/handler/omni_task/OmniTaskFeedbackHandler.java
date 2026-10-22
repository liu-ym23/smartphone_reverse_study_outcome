package com.obric.assistant.obric_action.handler.omni_task;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import va8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013Jb\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0002\u0010 R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lcom/obric/assistant/obric_action/handler/omni_task/OmniTaskFeedbackHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/omni_task/OmniTaskFeedbackHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/omni_task/OmniTaskFeedbackHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showOmniTaskFeedbackDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "msgIdList", "", "", "omniTaskId", "botId", "feedbackMsgId", "feedbackSource", "feedbackBizType", "searchTool", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniTaskFeedbackHandler implements IObricActionHandler<b, Unit> {
    public final Class<b> b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003JY\u0010\u001a\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/assistant/obric_action/handler/omni_task/OmniTaskFeedbackHandler$Params;", "", "messageIdList", "", "", "omniTaskId", "feedbackMsgId", "feedbackSource", "feedbackBizType", "searchTool", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageIdList", "()Ljava/util/List;", "getOmniTaskId", "()Ljava/lang/String;", "getFeedbackMsgId", "getFeedbackSource", "getFeedbackBizType", "getSearchTool", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("feedbackBizType")
        private final String feedbackBizType;

        @SerializedName("feedback_msg_id")
        private final String feedbackMsgId;

        @SerializedName("source")
        private final String feedbackSource;

        @SerializedName("messageIdList")
        private final List<String> messageIdList;

        @SerializedName("omniTaskId")
        private final String omniTaskId;

        @SerializedName("searchTool")
        private final String searchTool;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.messageIdList, r6.messageIdList) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.omniTaskId, r6.omniTaskId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.feedbackMsgId, r6.feedbackMsgId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.feedbackSource, r6.feedbackSource) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.feedbackBizType, r6.feedbackBizType) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.searchTool, r6.searchTool) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            List<String> r0 = this.messageIdList;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.omniTaskId;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.feedbackMsgId;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.feedbackSource;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.feedbackBizType;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.searchTool;
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
            return "Params(messageIdList=" + this.messageIdList + ", omniTaskId=" + this.omniTaskId + ", feedbackMsgId=" + this.feedbackMsgId + ", feedbackSource=" + this.feedbackSource + ", feedbackBizType=" + this.feedbackBizType + ", searchTool=" + this.searchTool + ')';
        }

        public b() {
            this.messageIdList = null;
            this.omniTaskId = null;
            this.feedbackMsgId = null;
            this.feedbackSource = null;
            this.feedbackBizType = null;
            this.searchTool = null;
        }

        public final String a() {
            return this.feedbackBizType;
        }

        public final String b() {
            return this.feedbackMsgId;
        }

        public final String c() {
            return this.feedbackSource;
        }

        public final List<String> d() {
            return this.messageIdList;
        }

        public final String e() {
            return this.omniTaskId;
        }

        public final String f() {
            return this.searchTool;
        }
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.g.a;
        return d.g.a;
    }

    public OmniTaskFeedbackHandler() {
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
    public final /* bridge */ /* synthetic */ Object d(Context r1, b r2, Continuation<? super h<? extends Unit>> r3) {
        return e(r1, r2, r3);
    }

    public final Object e(Context r17, b r18, Continuation<? super h<Unit>> r19) {
        if ((r19 instanceof OmniTaskFeedbackHandler$execute$1) == false) goto L7;
        OmniTaskFeedbackHandler$execute$1 r2 = (OmniTaskFeedbackHandler$execute$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        OmniTaskFeedbackHandler$execute$1 r12 = r2;
        Object r1 = r12.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r12.label;
        boolean r14 = true;
        String r15 = "";
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L55
        Object r0 = r1;
        String r6 = "OmniTaskFeedbackHandler";
    L50:
        h r7 = (h) r0;     // Catch: Throwable -> L53
    L51:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L53
    L58:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L61;
        FLogger.a.w(r6, "showFeedbackDialog failed. " + r9.getMessage(), r9);
    L61:
        Throwable r10 = Result.exceptionOrNull-impl(r8);
        if (r10 == null) goto L79;
        h.a r11 = h.d;
        String r13 = r10.getMessage();
        if (r13 == null) goto L69;
        r15 = r13;
    L69:
        if (r15.length() == 0) goto L72;
        r14 = false;
    L72:
        if (r14 == false) goto L75;
        r15 = "show feedback dialog failed";
    L75:
        return h.a.a(r11, r15, 2);
    L79:
        return r8;
    L53:
        th = th;
    L57:
        Result.Companion r16 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r1);
        if (r18 == null) goto L18;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L55
        List<String> r21 = r18.d();     // Catch: Throwable -> L55
        if (r21 != null) goto L22;
        r21 = CollectionsKt.emptyList();     // Catch: Throwable -> L55
    L22:
        List r22 = CollectionsKt.filterNotNull(r21);     // Catch: Throwable -> L55
        if (r22.isEmpty() == false) goto L25;
        FLogger.a.w("OmniTaskFeedbackHandler", "no msg list");     // Catch: Throwable -> L55
        r7 = h.a.a(h.d, "messageIdList is empty", 2);     // Catch: Throwable -> L55
    L38:
        r6 = "OmniTaskFeedbackHandler";
        goto L51
    L25:
        String r23 = r18.e();     // Catch: Throwable -> L55
        if (r23 != null) goto L28;
        String r24 = "";
    L29:
        String r25 = null;
        if ((r17 instanceof Activity) == false) goto L32;
        Activity r26 = (Activity) r17;     // Catch: Throwable -> L55
    L33:
        if (r26 != null) goto L36;
        FLogger.a.w("OmniTaskFeedbackHandler", "not top activity");     // Catch: Throwable -> L55
        r7 = h.a.a(h.d, "context is not activity", 2);     // Catch: Throwable -> L55
        goto L38
    L36:
        if ((r26 instanceof FragmentActivity) == true) goto L39;
        FLogger.a.w("OmniTaskFeedbackHandler", "top activity is not FragmentActivity");     // Catch: Throwable -> L55
        r7 = h.a.a(h.d, "activity is not fragment activity", 2);     // Catch: Throwable -> L55
        goto L38
    L39:
        a0 r27 = s1a.a.h((FragmentActivity) r26).getAbility(a0.class);     // Catch: Throwable -> L55
        if (r27 == null) goto L42;
        r25 = r27.getBotId();     // Catch: Throwable -> L55
    L42:
        if (r25 != null) goto L44;
        String r28 = "";
    L45:
        FragmentManager r29 = ((FragmentActivity) r26).getSupportFragmentManager();     // Catch: Throwable -> L55
        String r30 = r18.b();     // Catch: Throwable -> L55
        String r31 = r18.c();     // Catch: Throwable -> L55
        String r110 = r18.a();     // Catch: Throwable -> L55
        String r32 = r18.f();     // Catch: Throwable -> L55
        r12.label = 1;     // Catch: Throwable -> L55
        r6 = "OmniTaskFeedbackHandler";
        r0 = f(r29, r22, r24, r28, r30, r31, r110, r32, r12);     // Catch: Throwable -> L53
        if (r0 != r4) goto L50;
        return r4;
    L44:
        r28 = r25;
        goto L45
    L32:
        r26 = null;
        goto L33
    L28:
        r24 = r23;
        goto L29
    L18:
        return h.a.a(h.d, "params is null", 2);
    L55:
        th = th;
        r6 = "OmniTaskFeedbackHandler";
    L7:
        r2 = new OmniTaskFeedbackHandler$execute$1(this, r19);
        goto L8
    }

    public static Object f(FragmentManager r12, List r13, String r14, String r15, String r16, String r17, String r18, String r19, Continuation r20) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("showOmniTaskFeedbackDialog, msgIdList: ");
        r1.append(r13);
        r1.append(", omniTaskId: ");
        r1.append(r14);
        r1.append(", botId: ");
        r1.append(r15);
        r1.append(", feedbackMsgId: ");
        String r3 = "";
        if (r16 != null) goto L5;
        String r4 = "";
    L6:
        r1.append(r4);
        r1.append(", feedbackSource: ");
        if (r17 != null) goto L9;
        String r5 = "";
    L10:
        r1.append(r5);
        r1.append(", feedbackBizType: ");
        if (r18 != null) goto L13;
        String r6 = "";
    L14:
        r1.append(r6);
        r1.append(", searchTool: ");
        if (r19 == null) goto L18;
        r3 = r19;
    L18:
        r1.append(r3);
        r0.i("OmniTaskFeedbackHandler", r1.toString());
        return BuildersKt.withContext(Dispatchers.getMain(), new OmniTaskFeedbackHandler$showOmniTaskFeedbackDialog$2(r13, r12, r14, r16, r17, r18, r19, null), r20);
    L13:
        r6 = r18;
        goto L14
    L9:
        r5 = r17;
        goto L10
    L5:
        r4 = r16;
        goto L6
    }
}
