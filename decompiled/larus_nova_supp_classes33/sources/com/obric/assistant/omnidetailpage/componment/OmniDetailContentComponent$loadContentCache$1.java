package com.obric.assistant.omnidetailpage.componment;

import android.graphics.drawable.Drawable;
import com.obric.assistant.omnidetailpage.util.OmniPageUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent$loadContentCache$1", f = "OmniDetailContentComponent.kt", i = {}, l = {1149}, m = "invokeSuspend", n = {}, s = {})
final class OmniDetailContentComponent$loadContentCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$loadContentCache$1(OmniDetailContentComponent r1, Continuation<? super OmniDetailContentComponent$loadContentCache$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OmniDetailContentComponent$loadContentCache$1(this.this$0, r3);
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
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ConcurrentHashMap<String, Pair<Drawable, String>> r6 = OmniPageUtil.a;
        Map<String, List<ifa.f>> r7 = OmniPageUtil.b;
        OmniDetailContentComponent r2 = this.this$0;
        int r3 = OmniDetailContentComponent.I;
        List<ifa.f> r8 = r7.get(r2.W3());
        if (r8 == null) goto L14;
        OmniDetailContentComponent r4 = this.this$0;
        this.label = 1;
        if (OmniDetailContentComponent.m3(r4, r8, this) != r0) goto L14;
        return r0;
    }
}
