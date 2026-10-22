package com.larus.bmhome.miniartifact.listpage;

import com.larus.bmhome.miniartifact.listpage.adapter.MiniArtifactDoubleColumnAdapter;
import com.larus.bmhome.miniartifact.listpage.request.ApplicationTemplate;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.miniartifact.listpage.MiniArtifactListPageTemplateComponent$subscribeTemplateList$2", f = "MiniArtifactListPageTemplateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiniArtifactListPageTemplateComponent$subscribeTemplateList$2 extends SuspendLambda implements Function2<List<? extends ApplicationTemplate>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MiniArtifactListPageTemplateComponent this$0;

    public MiniArtifactListPageTemplateComponent$subscribeTemplateList$2(MiniArtifactListPageTemplateComponent r1, Continuation<? super MiniArtifactListPageTemplateComponent$subscribeTemplateList$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MiniArtifactListPageTemplateComponent$subscribeTemplateList$2 r0 = new MiniArtifactListPageTemplateComponent$subscribeTemplateList$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((List) r1, (Continuation) r2);
    }

    public final Object invoke(List<ApplicationTemplate> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r4);
        List<ApplicationTemplate> r5 = (List) this.L$0;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("current template list size:");
        if (r5 == null) goto L7;
        Integer r2 = Boxing.boxInt(r5.size());
    L8:
        r1.append(r2);
        r0.i("MiniArtifactListPage", r1.toString());
        MiniArtifactDoubleColumnAdapter r3 = this.this$0.u;
        if (r3 == null) goto L14;
        if (r5 != null) goto L12;
        r5 = CollectionsKt.emptyList();
    L12:
        Intrinsics.checkNotNullParameter(r5, "items");
        r3.b = r5;
        r3.notifyDataSetChanged();
    L14:
        return Unit.INSTANCE;
    L7:
        r2 = null;
        goto L8
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
