package com.obric.assistant.obric_action;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.utils.FunctionsKt;
import com.obric.assistant.obric_action.executor.ObricActionExecutor;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0002\u0010\u0017J0\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0002\u0010\u0017J\"\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u001c\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/assistant/obric_action/ObricActionServiceImpl;", "Lcom/obric/assistant/obric_action/IObricActionService;", "<init>", "()V", "handlerMap", "", "", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "intentResolver", "Lcom/obric/assistant/obric_action/protocol/ObricActionIntentResolver;", "actionExecutor", "Lcom/obric/assistant/obric_action/executor/ObricActionExecutor;", "actionUIScope", "Lkotlinx/coroutines/CoroutineScope;", "dispatchAsync", "", "context", "Landroid/content/Context;", "fullUrl", "expectKey", "dispatch", "Lcom/obric/assistant/obric_action/ObricActionResult;", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchInternal", "toObricActionString", "actionHost", "data", "key", "isSchemaMatch", "", MemorySourceLinkType.URL, "generateKey", "obricActionKey", "blockId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionServiceImpl implements IObricActionService {
    public final Map<String, IObricActionHandler<?, ?>> a;
    public final ffa.a b;
    public final ObricActionExecutor c;
    public final CoroutineScope d;

    public static final class a {
    }

    static {
    }

    public ObricActionServiceImpl() {
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        LinkedHashMap r0 = new LinkedHashMap();
        IObricActionHandler.a.getClass();
        Iterator r1 = ((List) IObricActionHandler.a.b.getValue()).iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        IObricActionHandler r2 = (IObricActionHandler) r1.next();
        Iterator<T> r3 = r2.c().b.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        String r4 = (String) r3.next();
        if (r0.containsKey(r4) == true) goto L11;
        FLogger.a.i("ObricActionServiceImpl", "register " + r4 + " with " + r2);
        r0.put(r4, r2);
        goto L7
    L11:
        FLogger.a.e("ObricActionServiceImpl", "duplicate host " + r4);
        throw new RuntimeException("should not register duplicate host " + r4);
    L13:
        this.a = r0;
        this.b = new ffa.a(r0.keySet());
        this.c = new ObricActionExecutor(r0);
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.URL);
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.URL);
        String r4 = UriProtector.parse(r3).getScheme();
        if (Intrinsics.areEqual(r4, "obric_action") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r4, "obric_intent") == true) goto L8;
        return false;
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final String c(String r7, String r8) {
        FLogger r0 = FLogger.a;
        r0.i("ObricActionServiceImpl", "generateKey: obricActionKey = " + r7 + ", blockId = " + r8);
        boolean r1 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        return "";
    L12:
        if (r8 != null) goto L14;
    L15:
        r1 = true;
    L16:
        if (r1 == false) goto L18;
        return "";
    L18:
        String r9 = FunctionsKt.b(r7 + '/' + r8);
        StringBuilder r10 = new StringBuilder("generateKey: result ");
        r10.append(r9);
        r0.i("ObricActionServiceImpl", r10.toString());
        return r9;
    L14:
        if (r8.length() != 0) goto L16;
    L5:
        if (r7.length() == 0) goto L8;
        r4 = false;
        goto L10
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final String b(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "actionHost");
        Intrinsics.checkNotNullParameter(r11, "data");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r10, "actionHost");
        Intrinsics.checkNotNullParameter(r11, "data");
        String[] r0 = new String[2];
        boolean r1 = false;
        r0[0] = "data=" + Uri.encode(r11);
        StringBuilder r13 = new StringBuilder("key=");
        if (r12 != null) goto L5;
    L6:
        r1 = true;
    L7:
        if (r1 == false) goto L9;
        String r14 = "";
    L10:
        r13.append(r14);
        r0[1] = r13.toString();
        return "obric_action://" + r10 + '?' + CollectionsKt.joinToString$default(CollectionsKt.mutableListOf(r0), "&", null, null, 0, null, null, 62, null);
    L9:
        r14 = Uri.encode(r12);
        goto L10
    L5:
        if (r12.length() != 0) goto L7;
        goto L6
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final void d(Context r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "fullUrl");
        BuildersKt.launch$default(this.d, null, null, new ObricActionServiceImpl$dispatchAsync$1(this, r11, r12, r13, null), 3, null);
    }

    @Override // com.obric.assistant.obric_action.IObricActionService
    public final Object e(Context r11, String r12, String r13, Continuation<? super h<? extends Object>> r14) {
        return BuildersKt.async$default(this.d, null, null, new ObricActionServiceImpl$dispatch$2(this, r11, r12, r13, null), 3, null).await(r14);
    }

    public static final Object f(ObricActionServiceImpl r10, Context r11, String r12, String r13, Continuation r14) {
        r10.getClass();
        if ((r14 instanceof ObricActionServiceImpl$dispatchInternal$1) == false) goto L7;
        ObricActionServiceImpl$dispatchInternal$1 r4 = (ObricActionServiceImpl$dispatchInternal$1) r14;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r15 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        boolean r8 = true;
        if (r7 == 0) goto L16;
        if (r7 != 1) goto L15;
        efa.a r16 = (efa.a) r4.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L30
    L27:
        FLogger.a.i("ObricActionServiceImpl", "dispatchInternal: action=" + r16.a + ", result=" + ((h) r15));     // Catch: Throwable -> L30
        h<Object> r17 = (h) r15;     // Catch: Throwable -> L30
    L28:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L30
    L32:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 != null) goto L36;
    L51:
        return r18;
    L36:
        if ((r19 instanceof CancellationException) == true) goto L48;
        FLogger.a.e("ObricActionServiceImpl", "dispatchInternal failed. " + r19.getMessage(), r19);
        h.a r110 = h.d;
        String r111 = r19.getMessage();
        if (r111 != null) goto L41;
        r111 = "";
    L41:
        if (r111.length() == 0) goto L44;
        r8 = false;
    L44:
        if (r8 == false) goto L46;
        r111 = "dispatch obric action failed";
    L46:
        r18 = h.a.a(r110, r111, 2);
        goto L51
    L48:
        throw r19;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r15);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L30
        FLogger r113 = FLogger.a;     // Catch: Throwable -> L30
        r113.i("ObricActionServiceImpl", "dispatchInternal: context=" + r11 + ", fullUrl=" + r12 + ", expectKey=" + r13);     // Catch: Throwable -> L30
        Uri r114 = UriProtector.parse(r12);     // Catch: Throwable -> L30
        ffa.b r115 = r10.b.a(r114, r13);     // Catch: Throwable -> L30
        efa.a r3 = r115.a;     // Catch: Throwable -> L30
        if (r3 != null) goto L23;
        r17 = r115.b;     // Catch: Throwable -> L30
        if (r17 != null) goto L22;
        r17 = h.a.a(h.d, "resolve obric action failed", 2);     // Catch: Throwable -> L30
    L22:
        r113.w("ObricActionServiceImpl", "dispatchInternal: resolve obric action failed, uri=" + r114 + ", errorResult=" + r17);     // Catch: Throwable -> L30
        goto L28
    L23:
        r113.i("ObricActionServiceImpl", "dispatchInternal: use action=" + r3.a + " handle " + r114);     // Catch: Throwable -> L30
        ObricActionExecutor r116 = r10.c;     // Catch: Throwable -> L30
        r4.L$0 = r3;     // Catch: Throwable -> L30
        r4.label = 1;     // Catch: Throwable -> L30
        r15 = r116.a(r11, r3, r4);     // Catch: Throwable -> L30
        if (r15 == r6) goto L47;
        r16 = r3;
        goto L27
    L47:
        return r6;
    L30:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r4 = new ObricActionServiceImpl$dispatchInternal$1(r10, r14);
        goto L8
    }
}
