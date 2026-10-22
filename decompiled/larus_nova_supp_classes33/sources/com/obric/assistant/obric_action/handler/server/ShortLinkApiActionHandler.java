package com.obric.assistant.obric_action.handler.server;

import android.content.Context;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/server/ShortLinkApiActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShortLinkApiActionHandler implements IObricActionHandler<String, Unit> {
    public final Class<String> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.j.a;
        return d.j.a;
    }

    public ShortLinkApiActionHandler() {
        this.b = String.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<String> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final String a(Context r1, String r2) {
        return (String) IObricActionHandler.b.a(this, r1, r2);
    }

    public final Object e(String r8, Continuation r9) {
        if ((r9 instanceof ShortLinkApiActionHandler$execute$1) == false) goto L7;
        ShortLinkApiActionHandler$execute$1 r0 = (ShortLinkApiActionHandler$execute$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        h.a r11 = (h.a) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L23:
        return r11.b(((Boolean) r10).booleanValue());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (r8 == null) goto L17;
        h.a r12 = h.d;
        CoroutineDispatcher r4 = Dispatchers.getIO();
        ShortLinkApiActionHandler$execute$2 r5 = new ShortLinkApiActionHandler$execute$2(r8, null);
        r0.L$0 = r12;
        r0.label = 1;
        Object r13 = BuildersKt.withContext(r4, r5, r0);
        if (r13 != r2) goto L21;
        return r2;
    L21:
        r10 = r13;
        r11 = r12;
        goto L23
    L17:
        return h.a.a(h.d, "short link is null", 2);
    L7:
        r0 = new ShortLinkApiActionHandler$execute$1(this, r9);
        goto L8
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r1, String r2, Continuation<? super h<? extends Unit>> r3) {
        return e(r2, r3);
    }
}
