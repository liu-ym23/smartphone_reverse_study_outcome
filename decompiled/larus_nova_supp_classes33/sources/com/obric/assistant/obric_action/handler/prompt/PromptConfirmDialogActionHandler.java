package com.obric.assistant.obric_action.handler.prompt;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activity_stack.IObricActivityStackService;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J:\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/obric/assistant/obric_action/handler/prompt/PromptConfirmDialogActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/prompt/PromptConfirmDialogActionParams;", "Lcom/obric/assistant/obric_action/handler/prompt/PromptDialogActionResult;", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/prompt/PromptConfirmDialogActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConfirmDialog", "Landroidx/fragment/app/DialogFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "complete", "Lkotlin/Function1;", "", "onDismiss", "Lkotlin/Function0;", "hasVisibleContent", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptConfirmDialogActionHandler implements IObricActionHandler<e, j> {
    public static final /* synthetic */ int c = 0;
    public final Class<e> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final com.obric.assistant.obric_action.d c() {
        com.obric.assistant.obric_action.d r0 = com.obric.assistant.obric_action.d.h.a;
        return com.obric.assistant.obric_action.d.h.a;
    }

    public PromptConfirmDialogActionHandler() {
        this.b = e.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<e> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final e a(Context r1, String r2) {
        return (e) IObricActionHandler.b.a(this, r1, r2);
    }

    public final Object e(final e r8, Continuation r9) {
        if ((r9 instanceof PromptConfirmDialogActionHandler$execute$1) == false) goto L7;
        PromptConfirmDialogActionHandler$execute$1 r0 = (PromptConfirmDialogActionHandler$execute$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.obric.assistant.obric_action.h.a r11 = (com.obric.assistant.obric_action.h.a) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L50:
        return com.obric.assistant.obric_action.h.a.c(r11, r10, null, 2);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (r8 == null) goto L17;
        String r12 = r8.e();
        boolean r4 = false;
        if (r12 != null) goto L21;
    L24:
        boolean r13 = true;
    L25:
        if (r13 == false) goto L34;
        String r14 = r8.d();
        if (r14 != null) goto L29;
    L32:
        boolean r15 = true;
    L33:
        if (r15 == false) goto L34;
    L35:
        if (r4 == false) goto L37;
        IObricActivityStackService r16 = (IObricActivityStackService) ServiceManager.get().getService(IObricActivityStackService.class);
        if (r16 == null) goto L41;
        final FragmentActivity r17 = (FragmentActivity) r16.a(FragmentActivity.class);
    L42:
        if (r17 != null) goto L45;
        FLogger.a.w("PromptConfirmDialogActionHandler", "handle: no available fragment activity");
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.d, "no available fragment activity", 2);
    L45:
        com.obric.assistant.obric_action.h.a r5 = com.obric.assistant.obric_action.h.d;
        Function2 r6 = new com.obric.assistant.obric_action.handler.prompt.a(this, r17, r8);
        r0.L$0 = r5;
        r0.label = 1;
        r10 = h.a(r17, r6, r0);
        if (r10 != r2) goto L48;
        return r2;
    L48:
        r11 = r5;
        goto L50
    L41:
        r17 = null;
        goto L42
    L37:
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.d, "title and message are empty", 2);
    L29:
        if (StringsKt.isBlank(r14) == true) goto L32;
        r15 = false;
    L34:
        r4 = true;
        goto L35
    L21:
        if (StringsKt.isBlank(r12) == true) goto L24;
        r13 = false;
        goto L25
    L17:
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.d, "params is null", 2);
    L7:
        r0 = new PromptConfirmDialogActionHandler$execute$1(this, r9);
        goto L8
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r1, e r2, Continuation<? super com.obric.assistant.obric_action.h<? extends j>> r3) {
        return e(r2, r3);
    }
}
