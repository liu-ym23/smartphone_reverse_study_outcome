package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$loadMore$1", f = "MentionPanelController.kt", i = {}, l = {842, 847}, m = "invokeSuspend", n = {}, s = {})
public final class MentionPanelController$loadMore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cursor;
    final /* synthetic */ MentionSearchDomain $domain;
    final /* synthetic */ long $generation;
    final /* synthetic */ String $query;
    final /* synthetic */ MentionPanelController.b $requestKey;
    int label;
    final /* synthetic */ MentionPanelController this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$loadMore$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$loadMore$1$1", f = "MentionPanelController.kt", i = {}, l = {848}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super f0>, Object> {
        final /* synthetic */ String $cursor;
        final /* synthetic */ MentionSearchDomain $domain;
        final /* synthetic */ String $query;
        int label;

        public AnonymousClass1(String r1, MentionSearchDomain r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$query = r1;
            this.$domain = r2;
            this.$cursor = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass1(this.$query, this.$domain, this.$cursor, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super f0> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MentionSearchRepository r7 = MentionSearchRepository.a;
            String r2 = this.$query;
            MentionSearchDomain r3 = this.$domain;
            String r4 = this.$cursor;
            this.label = 1;
            r6 = r7.f(r2, r3, r4, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    public MentionPanelController$loadMore$1(MentionPanelController r1, String r2, long r3, MentionPanelController.b r5, MentionSearchDomain r6, String r7, Continuation<? super MentionPanelController$loadMore$1> r8) {
        this.this$0 = r1;
        this.$query = r2;
        this.$generation = r3;
        this.$requestKey = r5;
        this.$domain = r6;
        this.$cursor = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MentionPanelController$loadMore$1(this.this$0, this.$query, this.$generation, this.$requestKey, this.$domain, this.$cursor, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r18);
        Object r3 = r18;
    L18:
        f0 r4 = (f0) r3;
    L19:
        JobKt.ensureActive(getContext());
        MentionPanelController r5 = this.this$0;
        String r6 = this.$query;
        long r7 = this.$generation;
        int r9 = MentionPanelController.R;
        k1 r8 = r5.h(r6, r7);
        if (r8 == null) goto L195;
        MentionPanelController r10 = this.this$0;
        MentionSearchDomain r11 = this.$domain;
        if (r10.x == MentionPanelController.Page.REMOTE_DOMAIN) goto L24;
    L26:
        boolean r12 = false;
    L27:
        if (r12 == true) goto L30;
        r8 = null;
    L30:
        if (r8 == null) goto L195;
        r10.z = null;
        if (r4 != null) goto L35;
        r10.A = this.$requestKey;
        r10.p(r8);
        return Unit.INSTANCE;
    L35:
        r10.A = null;
        String r13 = this.$cursor;
        d1 r14 = r4.e.get(r11);
        if (r14 == null) goto L192;
        f0 r15 = r10.u;
        int r16 = MentionPanelController.d.a[r11.ordinal()];
        if (r16 == 1) goto L93;
        if (r16 == 2) goto L77;
        if (r16 == 3) goto L61;
        if (r16 != 4) goto L60;
        List<c1> r17 = r15.d;
        if ((r17 instanceof Collection) == true) goto L46;
    L48:
        Iterator<T> r19 = r17.iterator();
        int r110 = 0;
    L50:
        if (r19.hasNext() == false) goto L109;
        if (((c1) r19.next()) == null) goto L54;
        boolean r111 = true;
    L55:
        if (r111 == false) goto L50;
        r110 = r110 + 1;
        if (r110 >= 0) goto L50;
        CollectionsKt.throwCountOverflow();
        goto L50
    L54:
        r111 = false;
    L109:
        int r20 = MentionPanelController.d.a[r11.ordinal()];
        if (r20 == 1) goto L138;
        if (r20 == 2) goto L131;
        if (r20 == 3) goto L124;
        if (r20 != 4) goto L123;
        List r21 = CollectionsKt.filterNotNull(CollectionsKt.plus(r10.u.d, r4.d));
        HashSet r112 = new HashSet();
        ArrayList r113 = new ArrayList();
        Iterator r22 = r21.iterator();
    L116:
        if (r22.hasNext() == false) goto L121;
        Object r114 = r22.next();
        if (r112.add(((c1) r114).a.a) == false) goto L116;
        r113.add(r114);
        goto L116
    L121:
        int r23 = r113.size();
    L145:
        boolean r24 = !Intrinsics.areEqual(r14.b, r13);
        if (r23 <= r110) goto L148;
        boolean r25 = true;
    L150:
        if (r14.a == false) goto L154;
        if (r24 == false) goto L153;
        if (r25 == true) goto L154;
    L153:
        r14 = new d1(false, r14.b);
    L154:
        Map r115 = MapsKt.plus(r10.u.e, TuplesKt.to(r11, r14));
        int r26 = MentionPanelController.d.a[r11.ordinal()];
        if (r26 == 1) goto L184;
        if (r26 != 2) goto L158;
        f0 r27 = r10.u;
        List r28 = CollectionsKt.filterNotNull(CollectionsKt.plus(r27.b, r4.b));
        HashSet r29 = new HashSet();
        ArrayList r116 = new ArrayList();
        Iterator r30 = r28.iterator();
    L179:
        if (r30.hasNext() == false) goto L183;
        Object r31 = r30.next();
        if (r29.add(((c) r31).a.a) == false) goto L179;
        r116.add(r31);
        goto L179
    L183:
        f0 r32 = f0.b(r27, null, r116, null, null, r115, 13);
    L191:
        r10.u = r32;
        goto L192
    L158:
        if (r26 != 3) goto L160;
        f0 r33 = r10.u;
        List r34 = CollectionsKt.filterNotNull(CollectionsKt.plus(r33.a, r4.a));
        HashSet r35 = new HashSet();
        ArrayList r117 = new ArrayList();
        Iterator r36 = r34.iterator();
    L172:
        if (r36.hasNext() == false) goto L176;
        Object r37 = r36.next();
        if (r35.add(((c1) r37).a.a) == false) goto L172;
        r117.add(r37);
        goto L172
    L176:
        r32 = f0.b(r33, r117, null, null, null, r115, 14);
        goto L191
    L160:
        if (r26 != 4) goto L169;
        f0 r38 = r10.u;
        List r39 = CollectionsKt.filterNotNull(CollectionsKt.plus(r38.d, r4.d));
        HashSet r40 = new HashSet();
        ArrayList r118 = new ArrayList();
        Iterator r41 = r39.iterator();
    L163:
        if (r41.hasNext() == false) goto L167;
        Object r42 = r41.next();
        if (r40.add(((c1) r42).a.a) == false) goto L163;
        r118.add(r42);
        goto L163
    L167:
        r32 = f0.b(r38, null, null, null, r118, r115, 7);
        goto L191
    L169:
        throw new NoWhenBranchMatchedException();
    L184:
        f0 r43 = r10.u;
        List r44 = CollectionsKt.filterNotNull(CollectionsKt.plus(r43.c, r4.c));
        HashSet r45 = new HashSet();
        ArrayList r119 = new ArrayList();
        Iterator r46 = r44.iterator();
    L186:
        if (r46.hasNext() == false) goto L190;
        Object r47 = r46.next();
        if (r45.add(((c1) r47).a.a) == false) goto L186;
        r119.add(r47);
        goto L186
    L190:
        r32 = f0.b(r43, null, null, r119, null, r115, 11);
        goto L191
    L148:
        r25 = false;
        goto L150
    L123:
        throw new NoWhenBranchMatchedException();
    L124:
        List r48 = CollectionsKt.filterNotNull(CollectionsKt.plus(r10.u.a, r4.a));
        HashSet r120 = new HashSet();
        ArrayList r121 = new ArrayList();
        Iterator r49 = r48.iterator();
    L126:
        if (r49.hasNext() == false) goto L130;
        Object r122 = r49.next();
        if (r120.add(((c1) r122).a.a) == false) goto L126;
        r121.add(r122);
        goto L126
    L130:
        r23 = r121.size();
        goto L145
    L131:
        List r50 = CollectionsKt.filterNotNull(CollectionsKt.plus(r10.u.b, r4.b));
        HashSet r123 = new HashSet();
        ArrayList r124 = new ArrayList();
        Iterator r51 = r50.iterator();
    L133:
        if (r51.hasNext() == false) goto L137;
        Object r125 = r51.next();
        if (r123.add(((c) r125).a.a) == false) goto L133;
        r124.add(r125);
        goto L133
    L137:
        r23 = r124.size();
        goto L145
    L138:
        List r52 = CollectionsKt.filterNotNull(CollectionsKt.plus(r10.u.c, r4.c));
        HashSet r126 = new HashSet();
        ArrayList r127 = new ArrayList();
        Iterator r53 = r52.iterator();
    L140:
        if (r53.hasNext() == false) goto L144;
        Object r128 = r53.next();
        if (r126.add(((c1) r128).a.a) == false) goto L140;
        r127.add(r128);
        goto L140
    L144:
        r23 = r127.size();
        goto L145
    L46:
        if (r17.isEmpty() == false) goto L48;
    L97:
        r110 = 0;
        goto L109
    L60:
        throw new NoWhenBranchMatchedException();
    L61:
        List<c1> r54 = r15.a;
        if ((r54 instanceof Collection) == true) goto L64;
    L66:
        Iterator<T> r55 = r54.iterator();
        r110 = 0;
    L68:
        if (r55.hasNext() == false) goto L109;
        if (((c1) r55.next()) == null) goto L72;
        boolean r129 = true;
    L73:
        if (r129 == false) goto L68;
        r110 = r110 + 1;
        if (r110 >= 0) goto L68;
        CollectionsKt.throwCountOverflow();
        goto L68
    L72:
        r129 = false;
        goto L73
    L64:
        if (r54.isEmpty() == false) goto L66;
    L77:
        List<c> r56 = r15.b;
        if ((r56 instanceof Collection) == true) goto L80;
    L82:
        Iterator<T> r57 = r56.iterator();
        r110 = 0;
    L84:
        if (r57.hasNext() == false) goto L109;
        if (((c) r57.next()) == null) goto L88;
        boolean r130 = true;
    L89:
        if (r130 == false) goto L84;
        r110 = r110 + 1;
        if (r110 >= 0) goto L84;
        CollectionsKt.throwCountOverflow();
        goto L84
    L88:
        r130 = false;
        goto L89
    L80:
        if (r56.isEmpty() == false) goto L82;
    L93:
        List<c1> r58 = r15.c;
        if ((r58 instanceof Collection) == true) goto L96;
    L98:
        Iterator<T> r59 = r58.iterator();
        r110 = 0;
    L100:
        if (r59.hasNext() == false) goto L109;
        if (((c1) r59.next()) == null) goto L104;
        boolean r131 = true;
    L105:
        if (r131 == false) goto L100;
        r110 = r110 + 1;
        if (r110 >= 0) goto L100;
        CollectionsKt.throwCountOverflow();
        goto L100
    L104:
        r131 = false;
        goto L105
    L96:
        if (r58.isEmpty() == false) goto L98;
    L192:
        this.this$0.p(r8);
        return Unit.INSTANCE;
    L24:
        if (r10.y != r11) goto L26;
        r12 = true;
    L195:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
        Object r60 = r18;
    L13:
        r4 = (f0) r60;
        if (r4 != null) goto L19;
        JobKt.ensureActive(getContext());
        MentionPanelController r61 = this.this$0;
        AnonymousClass1 r62 = new AnonymousClass1(this.$query, this.$domain, this.$cursor, null);
        this.label = 2;
        r3 = MentionPanelController.a(r61, r62, this);
        if (r3 != r1) goto L18;
        return r1;
    L10:
        ResultKt.throwOnFailure(r18);
        MentionPanelController r63 = this.this$0;
        MentionPanelController$loadMore$1$nextPage$1 r64 = new MentionPanelController$loadMore$1$nextPage$1(this.$query, this.$domain, this.$cursor, null);
        this.label = 1;
        r60 = MentionPanelController.a(r63, r64, this);
        if (r60 != r1) goto L13;
        return r1;
    }
}
