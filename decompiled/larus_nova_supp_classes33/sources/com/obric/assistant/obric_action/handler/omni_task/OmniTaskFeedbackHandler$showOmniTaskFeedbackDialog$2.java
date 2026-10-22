package com.obric.assistant.obric_action.handler.omni_task;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.security.api.g;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.tipoff.IObricTipOffService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/obric_action/ObricActionResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.handler.omni_task.OmniTaskFeedbackHandler$showOmniTaskFeedbackDialog$2", f = "OmniTaskFeedbackHandler.kt", i = {0, 1}, l = {114, 126}, m = "invokeSuspend", n = {"destination$iv$iv", "msgList"}, s = {"L$0", "L$0"})
public final class OmniTaskFeedbackHandler$showOmniTaskFeedbackDialog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h<? extends Unit>>, Object> {
    final /* synthetic */ String $feedbackBizType;
    final /* synthetic */ String $feedbackMsgId;
    final /* synthetic */ String $feedbackSource;
    final /* synthetic */ FragmentManager $fragmentManager;
    final /* synthetic */ List<String> $msgIdList;
    final /* synthetic */ String $omniTaskId;
    final /* synthetic */ String $searchTool;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.obric_action.handler.omni_task.OmniTaskFeedbackHandler$showOmniTaskFeedbackDialog$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.obric_action.handler.omni_task.OmniTaskFeedbackHandler$showOmniTaskFeedbackDialog$2$2", f = "OmniTaskFeedbackHandler.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Message> $msgList;
        int label;

        public AnonymousClass2(List<Message> r1, Continuation<? super AnonymousClass2> r2) {
            this.$msgList = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$msgList, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            FLogger.a.i("OmniTaskFeedbackHandler", "generateListAndUploadFornaxToken finish");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            FLogger.a.i("OmniTaskFeedbackHandler", "generateListAndUploadFornaxToken start");
            int r6 = g.a;
            List<Message> r7 = this.$msgList;
            this.label = 1;
            if (g.b(r7, 7, this) != r0) goto L11;
            return r0;
        }
    }

    public OmniTaskFeedbackHandler$showOmniTaskFeedbackDialog$2(List<String> r1, FragmentManager r2, String r3, String r4, String r5, String r6, String r7, Continuation<? super OmniTaskFeedbackHandler$showOmniTaskFeedbackDialog$2> r8) {
        this.$msgIdList = r1;
        this.$fragmentManager = r2;
        this.$omniTaskId = r3;
        this.$feedbackMsgId = r4;
        this.$feedbackSource = r5;
        this.$feedbackBizType = r6;
        this.$searchTool = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new OmniTaskFeedbackHandler$showOmniTaskFeedbackDialog$2(this.$msgIdList, this.$fragmentManager, this.$omniTaskId, this.$feedbackMsgId, this.$feedbackSource, this.$feedbackBizType, this.$searchTool, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super h<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0068 -> B:18:0x006b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006e -> B:20:0x006f). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        List r3 = (List) this.L$0;
        ResultKt.throwOnFailure(r21);
        OmniTaskFeedbackHandler$showOmniTaskFeedbackDialog$2 r7 = this;
        List r11 = r3;
    L30:
        IObricTipOffService r8 = (IObricTipOffService) ServiceManager.get().getService(IObricTipOffService.class);
        if (r8 == null) goto L33;
        DialogFragment r4 = IObricTipOffService.a.a(r8, r7.$fragmentManager, null, r11, false, null, r7.$omniTaskId, r7.$feedbackMsgId, r7.$feedbackSource, r7.$feedbackBizType, r7.$searchTool, 24);
    L34:
        if (r4 == null) goto L37;
        return h.a.c(h.d, null, null, 3);
    L37:
        return h.a.a(h.d, "show feedback dialog failed", 2);
    L33:
        r4 = null;
        goto L34
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Iterator r5 = (Iterator) this.L$1;
        Collection r6 = (Collection) this.L$0;
        ResultKt.throwOnFailure(r21);
        Object r9 = r21;
        r7 = this;
    L18:
        Message r10 = (Message) r9;
    L20:
        if (r10 == null) goto L12;
        r6.add(r10);
    L12:
        if (r5.hasNext() == false) goto L22;
        String r12 = (String) r5.next();
        IChatRepoService r13 = (IChatRepoService) ServiceManager.get().getService(IChatRepoService.class);
        if (r13 == null) goto L19;
        r7.L$0 = r6;
        r7.L$1 = r5;
        r7.label = 1;
        r9 = r13.E1(r12, r7);
        if (r9 != r1) goto L18;
        return r1;
    L19:
        r10 = null;
        goto L20
    L22:
        List r14 = (List) r6;
        if (r14.isEmpty() == false) goto L26;
        FLogger.a.w("OmniTaskFeedbackHandler", "showOmniTaskFeedbackDialog: no msg is found");
        return h.a.a(h.d, "no message found", 2);
    L26:
        FLogger.a.i("OmniTaskFeedbackHandler", "showOmniTaskFeedbackDialog: found msg list = " + CollectionsKt.joinToString$default(r14, null, null, null, 0, null, new a(), 31, null));
        CoroutineDispatcher r15 = Dispatchers.getIO();
        AnonymousClass2 r16 = new AnonymousClass2(r14, null);
        r7.L$0 = r14;
        r7.L$1 = null;
        r7.label = 2;
        if (BuildersKt.withContext(r15, r16, r7) != r1) goto L29;
        return r1;
    L29:
        r11 = r14;
        goto L30
    L10:
        ResultKt.throwOnFailure(r21);
        List<String> r17 = this.$msgIdList;
        r6 = new ArrayList();
        r5 = r17.iterator();
        r7 = this;
        goto L12
    }
}
