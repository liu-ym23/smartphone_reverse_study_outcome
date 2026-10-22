package com.larus.bmhome.chat.trace.container;

import com.larus.bmhome.ability.ContainerExceptionType;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import lw8.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.container.RenderExceptionTrace$1$onParseError$1", f = "RenderExceptionTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RenderExceptionTrace$1$onParseError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ String $parseContent;
    int label;

    public RenderExceptionTrace$1$onParseError$1(String r1, String r2, int r3, Continuation<? super RenderExceptionTrace$1$onParseError$1> r4) {
        this.$parseContent = r1;
        this.$errorMsg = r2;
        this.$errorCode = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RenderExceptionTrace$1$onParseError$1(this.$parseContent, this.$errorMsg, this.$errorCode, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r10);
        RenderExceptionTrace r11 = RenderExceptionTrace.a;
        String r12 = this.$parseContent;
        String r0 = this.$errorMsg;
        int r1 = this.$errorCode;
        Iterator<T> r2 = RenderExceptionTrace.c.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L31;
        Object r3 = r2.next();
        Map.Entry r4 = (Map.Entry) r3;
        Intrinsics.checkNotNull(r4);
        RenderExceptionTrace.c r5 = (RenderExceptionTrace.c) r4.getValue();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r12, "latex");
        boolean r6 = false;
        if (StringsKt.isBlank(r12) == true) goto L29;
        CopyOnWriteArrayList<WeakReference<rt8.a>> r7 = r5.a;
        if ((r7 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r8 = r7.iterator();
    L17:
        if (r8.hasNext() == false) goto L29;
        rt8.a r9 = (rt8.a) ((WeakReference) r8.next()).get();
        if (r9 == null) goto L26;
        l r13 = r9.getMarkdownContent();
        if (r13 == null) goto L26;
        uvc.b r14 = r13.getNode();
        if (r14 == null) goto L26;
        boolean r15 = RenderExceptionTrace.c.b(r14, r12);
    L27:
        if (r15 == false) goto L17;
        r6 = true;
    L26:
        r15 = false;
        goto L27
    L13:
        if (r7.isEmpty() == false) goto L15;
    L29:
        if (r6 == false) goto L6;
    L32:
        Map.Entry r16 = (Map.Entry) r3;
        if (r16 == null) goto L36;
        String r17 = (String) r16.getKey();
        JSONObject r18 = new JSONObject();
        r18.put("content", r12);
        r18.put("error_msg", r0);
        r18.put("error_code", r1);
        RenderExceptionTrace r19 = RenderExceptionTrace.a;
        ContainerExceptionType r20 = ContainerExceptionType.FAILED_FORMULA;
        RenderExceptionTrace.a.h(r17, r20, "", r18, null);
    L36:
        return Unit.INSTANCE;
    L31:
        r3 = null;
        goto L32
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
