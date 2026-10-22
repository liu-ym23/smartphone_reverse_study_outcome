package com.obric.assistant.obric_action.handler.prompt;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activity_stack.IObricActivityStackService;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013JH\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fH\u0002J\u0012\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u0002H\u0002J\f\u0010!\u001a\u00020\u0003*\u00020\u001aH\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006$"}, d2 = {"Lcom/obric/assistant/obric_action/handler/prompt/PromptOptionsDialogActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/prompt/PromptOptionsDialogActionParams;", "Lcom/obric/assistant/obric_action/handler/prompt/PromptDialogActionResult;", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/prompt/PromptOptionsDialogActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOptionsDialog", "Landroidx/fragment/app/DialogFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "options", "", "Lcom/obric/assistant/obric_action/handler/prompt/PromptOptionsDialogActionHandler$IndexedOption;", "complete", "Lkotlin/Function1;", "", "onDismiss", "Lkotlin/Function0;", "validOptions", "toResult", "Companion", "IndexedOption", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptOptionsDialogActionHandler implements IObricActionHandler<q, j> {
    public static final /* synthetic */ int c = 0;
    public final Class<q> b;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final i b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "IndexedOption(index=" + this.a + ", option=" + this.b + ')';
        }

        public b(int r2, i r3) {
            Intrinsics.checkNotNullParameter(r3, "option");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final com.obric.assistant.obric_action.d c() {
        com.obric.assistant.obric_action.d r0 = com.obric.assistant.obric_action.d.h.a;
        return com.obric.assistant.obric_action.d.h.b;
    }

    public PromptOptionsDialogActionHandler() {
        this.b = q.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<q> b() {
        return this.b;
    }

    public static final j e(PromptOptionsDialogActionHandler r3, b r4) {
        r3.getClass();
        return new j("selected", r4.b.a(), r4.b.b(), Integer.valueOf(r4.a));
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final q a(Context r1, String r2) {
        return (q) IObricActionHandler.b.a(this, r1, r2);
    }

    public final Object f(final q r12, Continuation r13) {
        if ((r13 instanceof PromptOptionsDialogActionHandler$execute$1) == false) goto L7;
        PromptOptionsDialogActionHandler$execute$1 r0 = (PromptOptionsDialogActionHandler$execute$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.obric.assistant.obric_action.h.a r15 = (com.obric.assistant.obric_action.h.a) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L63:
        return com.obric.assistant.obric_action.h.a.c(r15, r14, null, 2);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r12 == null) goto L17;
        List<i> r16 = r12.c();
        if (r16 != null) goto L21;
        r16 = CollectionsKt.emptyList();
    L21:
        final ArrayList r4 = new ArrayList();
        Iterator<T> r17 = r16.iterator();
        int r7 = 0;
    L23:
        if (r17.hasNext() == false) goto L44;
        Object r8 = r17.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        i r10 = (i) r8;
        if (r10 == null) goto L38;
        String r11 = r10.b();
        if (r11 != null) goto L33;
    L36:
        boolean r18 = true;
    L37:
        if (r18 == true) goto L38;
        b r19 = new b(r7, r10);
    L40:
        if (r19 == null) goto L42;
        r4.add(r19);
    L42:
        r7 = r9;
        goto L23
    L33:
        if (StringsKt.isBlank(r11) == true) goto L36;
        r18 = false;
    L38:
        r19 = null;
        goto L40
    L44:
        if (r4.isEmpty() == false) goto L48;
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.d, "options is empty", 2);
    L48:
        if (r4.size() > 3) goto L50;
        IObricActivityStackService r110 = (IObricActivityStackService) ServiceManager.get().getService(IObricActivityStackService.class);
        if (r110 == null) goto L54;
        final FragmentActivity r111 = (FragmentActivity) r110.a(FragmentActivity.class);
    L55:
        if (r111 != null) goto L58;
        FLogger.a.w("PromptOptionsDialogActionHandler", "handle: no available fragment activity");
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.d, "no available fragment activity", 2);
    L58:
        com.obric.assistant.obric_action.h.a r6 = com.obric.assistant.obric_action.h.d;
        Function2 r20 = new k(this, r111, r12, r4);
        r0.L$0 = r6;
        r0.label = 1;
        r14 = h.a(r111, r20, r0);
        if (r14 != r2) goto L61;
        return r2;
    L61:
        r15 = r6;
        goto L63
    L54:
        r111 = null;
        goto L55
    L50:
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.d, "dialog options size exceeds current dialog button slot count: 3", 2);
    L17:
        return com.obric.assistant.obric_action.h.a.a(com.obric.assistant.obric_action.h.d, "params is null", 2);
    L7:
        r0 = new PromptOptionsDialogActionHandler$execute$1(this, r13);
        goto L8
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r1, q r2, Continuation<? super com.obric.assistant.obric_action.h<? extends j>> r3) {
        return f(r2, r3);
    }
}
