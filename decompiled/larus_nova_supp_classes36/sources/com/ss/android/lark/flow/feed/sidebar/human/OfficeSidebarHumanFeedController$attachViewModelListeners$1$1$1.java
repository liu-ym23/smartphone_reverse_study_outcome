package com.ss.android.lark.flow.feed.sidebar.human;

import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "record", "Lcom/ss/android/lark/feed/shared/data/UpdateRecord;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.sidebar.human.OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$1", f = "OfficeSidebarHumanFeedController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$1 extends SuspendLambda implements Function2<UpdateRecord, Continuation<? super Unit>, Object> {
    final /* synthetic */ OfficeSidebarHumanFeedController $this_with;
    /* synthetic */ Object L$0;
    int label;

    public OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$1(OfficeSidebarHumanFeedController r1, Continuation<? super OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$1> r2) {
        this.$this_with = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$1 r0 = new OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$1(this.$this_with, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(UpdateRecord r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((UpdateRecord) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L114;
        ResultKt.throwOnFailure(r15);
        UpdateRecord r16 = (UpdateRecord) this.L$0;
        if (r16 == null) goto L112;
        OfficeSidebarHumanFeedController r0 = this.$this_with;
        int r1 = OfficeSidebarHumanFeedController.E;
        r0.getClass();
        String r2 = r16.e;
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "accept UpdateRecord without userId: version=" + r16.a);
    L27:
        boolean r3 = true;
    L29:
        if (r3 == false) goto L112;
        List<? extends UIFeedCard> r5 = r0.p;
        List r6 = r16.b;
        if (r6 != null) goto L34;
        r6 = CollectionsKt.emptyList();
    L34:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L36:
        if (r8.hasNext() == false) goto L47;
        Object r9 = r8.next();
        UIFeedCard r10 = (UIFeedCard) r9;
        if (r10.getBizType() != AppFeedCardType.CONTACT) goto L40;
    L44:
        boolean r11 = false;
    L45:
        if (r11 == false) goto L36;
        r7.add(r9);
        goto L36
    L40:
        if (r10.getType() == FeedCard.Type.DOUBAO_CONVERSATION) goto L44;
        if (r10.getIsFlowMainBot() == true) goto L44;
        r11 = true;
        goto L45
    L47:
        List<? extends UIFeedCard> r12 = CollectionsKt.sorted(r7);
        if (r0.t == true) goto L50;
    L56:
        boolean r13 = false;
    L57:
        if (r13 == true) goto L112;
        List<? extends UIFeedCard> r14 = r12;
        if ((r14 instanceof Collection) == true) goto L62;
    L64:
        Iterator<T> r17 = r14.iterator();
        int r18 = 0;
    L66:
        if (r17.hasNext() == false) goto L75;
        if (((UIFeedCard) r17.next()).getOnTopRankTime() > 0) goto L70;
        boolean r19 = true;
    L71:
        if (r19 == false) goto L66;
        r18 = r18 + 1;
        if (r18 >= 0) goto L66;
        CollectionsKt.throwCountOverflow();
        goto L66
    L70:
        r19 = false;
    L75:
        boolean r20 = r0.t;
        if (r20 == true) goto L78;
    L84:
        if (r20 == false) goto L86;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "return first page data: normalCount = " + r18 + ", firstPageNormalCount = " + r0.u + " canLoadMore = " + r0.q);
    L86:
        r0.u = 0;
        r0.s = true;
        r0.t = false;
        r0.r = r16.a;
        r0.p = r12;
        r0.h.clear();
        Iterator<T> r110 = r14.iterator();
    L88:
        if (r110.hasNext() == false) goto L90;
        UIFeedCard r21 = (UIFeedCard) r110.next();
        r0.h.put(r21.getId(), r21);
        goto L88
    L90:
        List<iza.c> r111 = r0.m(r5, r12);
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "onSourceRecord source=" + r12.size() + ", changed=" + r111.size() + ", hasMore=" + r0.q + ", userId=" + r0.o);
        if ((!r111.isEmpty()) == false) goto L97;
        List<iza.c> r22 = r111;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L94:
        if (r24.hasNext() == false) goto L96;
        r23.add(((iza.c) r24.next()).a);
        goto L94
    L96:
        r0.r(r111, r23);
    L97:
        r0.y();
        List<OfficeSidebarHumanFeedController.b> r25 = r0.i;
        ArrayList r26 = new ArrayList();
        Iterator r27 = ((ArrayList) r25).iterator();
    L99:
        if (r27.hasNext() == false) goto L103;
        Object r28 = r27.next();
        if (((OfficeSidebarHumanFeedController.b) r28).f == false) goto L99;
        r26.add(r28);
        goto L99
    L103:
        Iterator r29 = r26.iterator();
    L105:
        if (r29.hasNext() == false) goto L110;
        OfficeSidebarHumanFeedController.b r30 = (OfficeSidebarHumanFeedController.b) r29.next();
        r30.f = false;
        if (r111.isEmpty() == true) goto L108;
        r30.g = 0;
        goto L105
    L108:
        r30.g++;
        goto L105
    L110:
        r0.p();
        goto L112
    L78:
        if (r18 >= r0.u) goto L84;
        if (r0.q == false) goto L84;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "first page normal count is not enough, try to load more");
        s r112 = r0.n.get();
        if (r112 == null) goto L112;
        r112.onItemChanged(RangesKt.coerceAtLeast(CollectionsKt.getLastIndex(r12), 0), (UIFeedCard) CollectionsKt.lastOrNull(r12), false);
        goto L112
    L62:
        if (r14.isEmpty() == false) goto L64;
        r18 = 0;
        goto L75
    L50:
        if ((!r12.isEmpty()) == true) goto L56;
        if (r16.a > r0.r) goto L56;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "ignore initial empty live record after cache restore: recordVersion=" + r16.a + ", cacheVersion=" + r0.r + ", cachedSize=" + r0.p.size());
        r13 = true;
        goto L57
    L16:
        String r31 = r0.o;
        if (r31 != null) goto L19;
    L22:
        boolean r32 = true;
    L23:
        if (r32 == false) goto L25;
    L28:
        com.ss.android.lark.flow.feed.utils.b.e("OfficeSidebarHumanFeedController", "skip UpdateRecord: expectedUserId=" + r31 + ", recordUserId=" + r2 + ", version=" + r16.a);
        r3 = false;
        goto L29
    L25:
        if (Intrinsics.areEqual(r31, r2) == true) goto L27;
    L19:
        if (StringsKt.isBlank(r31) == true) goto L22;
        r32 = false;
        goto L23
    L9:
        if (StringsKt.isBlank(r2) == true) goto L12;
        r4 = false;
    L112:
        return Unit.INSTANCE;
    L114:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
