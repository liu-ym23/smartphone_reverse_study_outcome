package com.ss.android.lark.flow.feed.base;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "entities", "Lcom/ss/android/lark/feed/shared/data/UpdateRecord;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.base.MixedFeedDataController$observeStateFlow$1$1$2", f = "MixedFeedDataController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MixedFeedDataController$observeStateFlow$1$1$2 extends SuspendLambda implements Function2<UpdateRecord, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MixedFeedDataController<s> this$0;

    public MixedFeedDataController$observeStateFlow$1$1$2(MixedFeedDataController<s> r1, Continuation<? super MixedFeedDataController$observeStateFlow$1$1$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MixedFeedDataController$observeStateFlow$1$1$2 r0 = new MixedFeedDataController$observeStateFlow$1$1$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(UpdateRecord r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((UpdateRecord) r1, (Continuation) r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r10);
        UpdateRecord r11 = (UpdateRecord) this.L$0;
        if (r11 == null) goto L31;
        MixedFeedDataController<s> r1 = this.this$0;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "observeStateFlow onServerRecord");
        com.ss.android.lark.flow.feed.data.a r2 = r1.d;
        int r3 = 0;
        if (r2 == null) goto L11;
        boolean r4 = true;
        if (r2.b() != true) goto L11;
    L12:
        if (r4 == false) goto L30;
        List r5 = CollectionsKt.sorted(r1.b.h1(r11.b));
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "onServerRecord: server data direct update, size=" + r5.size());
        if (r1.a == false) goto L16;
    L18:
        List r6 = r5;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L20:
        if (r8.hasNext() == false) goto L22;
        r7.add(((UIFeedCard) r8.next()).getId());
        goto L20
    L22:
        Iterator r9 = CollectionsKt.chunked(r7, 20).iterator();
    L24:
        if (r9.hasNext() == false) goto L29;
        Object r12 = r9.next();
        int r13 = r3 + 1;
        if (r3 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "onServerRecord after sorted feedIds part" + r3 + '=' + ((List) r12));
        r3 = r13;
        goto L24
    L29:
        LarkFeedInBoxListAdapter r0 = r1.b.getAdapter();
        r11.a(r5);
        r11.c = r5.isEmpty();
        r0.update(r11);
        r1.b.d1(r11);
    L33:
        return Unit.INSTANCE;
    L16:
        if (r5.isEmpty() == false) goto L18;
        com.ss.android.lark.flow.feed.utils.b.d("MixedFeedDataController", "onServerRecord - skip dispatch empty merge ");
        goto L33
    L30:
        r1.h = r11;
        r1.d();
    L11:
        r4 = false;
        goto L12
    L31:
        com.ss.android.lark.flow.feed.utils.b.b("MixedFeedDataController", "receive feedItemEntities changed, update inbox data failed, data is null");
        goto L33
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
