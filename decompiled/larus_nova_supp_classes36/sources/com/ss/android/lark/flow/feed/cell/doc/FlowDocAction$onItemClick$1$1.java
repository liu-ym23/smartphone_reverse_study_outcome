package com.ss.android.lark.flow.feed.cell.doc;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.preview.DocFeedPreview;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.cell.doc.FlowDocAction$onItemClick$1$1", f = "FlowDocAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowDocAction$onItemClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ UIFeedCard $uiFeedCard;
    int label;
    final /* synthetic */ FlowDocAction this$0;

    public FlowDocAction$onItemClick$1$1(FlowDocAction r1, Fragment r2, UIFeedCard r3, Continuation<? super FlowDocAction$onItemClick$1$1> r4) {
        this.this$0 = r1;
        this.$fragment = r2;
        this.$uiFeedCard = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowDocAction$onItemClick$1$1(this.this$0, this.$fragment, this.$uiFeedCard, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r5);
        FlowDocAction r6 = this.this$0;
        this.$fragment.requireContext();
        DocFeedPreview r0 = this.$uiFeedCard;
        r6.getClass();
        if ((r0 instanceof DocFeedPreview) == false) goto L7;
        DocFeedPreview r1 = r0;
    L8:
        if (r1 != null) goto L10;
        com.ss.android.lark.flow.feed.utils.b.b("FlowChatAction", "openDocUrl: unsupported id=" + r0.getId() + ", card=" + r0.getClass().getSimpleName());
    L15:
        if (r0.getBadgeCount() <= 0) goto L18;
        peb.b.e r7 = heb.a.a.getDocDependency();
        r0.getId();
        r7.b();
    L18:
        return Unit.INSTANCE;
    L10:
        r1.getDocUrl();
        peb.b r2 = heb.a.a;
        peb.b.e r3 = r2.getDocDependency();
        if (r3 == null) goto L13;
        r1.getDocUrl();
        r1.buildQuerys();
        r1.getDocType();
        r3.a();
    L13:
        peb.b.c r4 = r2.getBrowserDependency();
        r1.buildExtra();
        r6.c.getHost().getParentFragment();
        r4.a();
        goto L15
    L7:
        r1 = null;
        goto L8
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
