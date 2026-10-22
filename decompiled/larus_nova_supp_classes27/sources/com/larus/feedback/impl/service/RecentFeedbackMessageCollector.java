package com.larus.feedback.impl.service;

import com.google.gson.Gson;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniArchiveStatus;
import com.larus.im.internal.jni.bean.OmniConversationSortType;
import com.larus.im.internal.jni.bean.OmniMainConversationStatus;
import com.larus.im.internal.jni.bean.OmniSelectConversationListRequest;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.j;
import wc9.e;
import wc9.l;
import wc9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class RecentFeedbackMessageCollector {
    public static final RecentFeedbackMessageCollector a = null;

    public static final class a {
        public final String a;
        public final String b;
        public final long c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "CollectedMessage(messageId=" + this.a + ", logId=" + this.b + ", createTime=" + this.c + ')';
        }

        public a(String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            Intrinsics.checkNotNullParameter(r3, "logId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
        public final e a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "RecentConversation(conversation=" + this.a + ", latestMessageTime=" + this.b + ')';
        }

        public b(e r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, FlowProtocolAbility.FEATURE_CONVERSATION);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((a) r4).c), Long.valueOf(((a) r3).c));
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((b) r4).b), Long.valueOf(((b) r3).b));
        }
    }

    static {
        a = new RecentFeedbackMessageCollector();
    }

    public RecentFeedbackMessageCollector() {
    }

    public final Object a(Continuation<? super String> r20) {
        if ((r20 instanceof RecentFeedbackMessageCollector$collect$1) == false) goto L7;
        RecentFeedbackMessageCollector$collect$1 r2 = (RecentFeedbackMessageCollector$collect$1) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        long r6 = r2.J$1;
        long r10 = r2.J$0;
        List r7 = (List) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L35:
        List r1 = (List) r0;
        if ((r1 instanceof Collection) == true) goto L38;
    L40:
        Iterator r12 = r1.iterator();
    L42:
        if (r12.hasNext() == false) goto L39;
        if (((List) r12.next()) != null) goto L46;
        boolean r14 = true;
    L47:
        if (r14 == false) goto L42;
        boolean r13 = true;
    L49:
        if (r13 == false) goto L52;
        FLogger.a.e("RecentFeedbackMessageCollector", "load recent messages failed");
        return null;
    L52:
        List r8 = CollectionsKt.flatten(CollectionsKt.filterNotNull(r1));
        ArrayList r15 = new ArrayList();
        Iterator r9 = r8.iterator();
    L54:
        if (r9.hasNext() == false) goto L71;
        Message r16 = (Message) r9.next();
        String r17 = r16.getMessageId();
        if (r17 != null) goto L58;
    L67:
        a r11 = null;
    L68:
        if (r11 == null) goto L54;
        r15.add(r11);
        goto L54
    L58:
        if ((!StringsKt.isBlank(r17)) == true) goto L61;
        r17 = null;
    L61:
        if (r17 == null) goto L67;
        String r18 = com.larus.im.bean.message.a.x(r16);
        if (r18 != null) goto L66;
        r18 = "";
    L66:
        r11 = new a(r17, r18, r16.getCreateTime());
        goto L68
    L71:
        ArrayList r21 = new ArrayList();
        Iterator r22 = r15.iterator();
    L73:
        if (r22.hasNext() == false) goto L80;
        Object r23 = r22.next();
        if (((a) r23).c < r6) goto L77;
        boolean r24 = true;
    L78:
        if (r24 == false) goto L73;
        r21.add(r23);
        goto L73
    L77:
        r24 = false;
        goto L78
    L80:
        List r25 = CollectionsKt.sortedWith(r21, new c());
        HashSet r26 = new HashSet();
        ArrayList r27 = new ArrayList();
        Iterator r28 = r25.iterator();
    L82:
        if (r28.hasNext() == false) goto L86;
        Object r30 = r28.next();
        if (r26.add(((a) r30).a) == false) goto L82;
        r27.add(r30);
        goto L82
    L86:
        List r31 = CollectionsKt.take(r27, 20);
        if (r31.isEmpty() == false) goto L100;
        FLogger.a.d("RecentFeedbackMessageCollector", "no valid recent messages");
        return null;
    L100:
        Gson r32 = new Gson();     // Catch: Exception -> L97
        List r33 = r31;     // Catch: Exception -> L97
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));     // Catch: Exception -> L97
        Iterator r35 = r33.iterator();     // Catch: Exception -> L97
    L92:
        if (r35.hasNext() == false) goto L94;
        a r36 = (a) r35.next();     // Catch: Exception -> L97
        r34.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("msg_id", r36.a), TuplesKt.to("log_id", r36.b)}));     // Catch: Exception -> L97
        goto L92
    L94:
        String r37 = r32.toJson(MapsKt.mapOf(TuplesKt.to("recent_msgs", r34)));     // Catch: Exception -> L97
        FLogger.a.d("RecentFeedbackMessageCollector", "collect recent messages success, conversations=" + r7.size() + ", messages=" + r31.size() + ", cost=" + (System.currentTimeMillis() - r10));
        return r37;
    L97:
        e = move-exception;
        FLogger.a.e("RecentFeedbackMessageCollector", "encode recent messages failed", e);
        return null;
    L46:
        r14 = false;
    L39:
        r13 = false;
        goto L49
    L38:
        if (r1.isEmpty() == false) goto L40;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r110 = r2.J$1;
        long r111 = r2.J$0;
        ResultKt.throwOnFailure(r0);
    L20:
        List r38 = (List) r0;
        if (r38 != null) goto L24;
        return null;
    L24:
        if (r38.isEmpty() == false) goto L27;
        FLogger.a.d("RecentFeedbackMessageCollector", "no recent conversation with messages");
        return null;
    L27:
        List r40 = r38;
        ArrayList r41 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
        Iterator r42 = r40.iterator();
    L29:
        if (r42.hasNext() == false) goto L31;
        r41.add(((b) r42.next()).a);
        goto L29
    L31:
        RecentFeedbackMessageCollector$collect$messageLists$1 r43 = new RecentFeedbackMessageCollector$collect$messageLists$1(r41, null);
        r2.L$0 = r41;
        r2.J$0 = r111;
        r2.J$1 = r110;
        r2.label = 2;
        r0 = CoroutineScopeKt.coroutineScope(r43, r2);
        if (r0 != r4) goto L34;
        return r4;
    L34:
        r7 = r41;
        r6 = r110;
        r10 = r111;
        goto L35
    L16:
        ResultKt.throwOnFailure(r0);
        long r112 = System.currentTimeMillis();
        long r113 = (r112 / ((long) 1000)) - 172800;
        r2.J$0 = r112;
        r2.J$1 = r113;
        r2.label = 1;
        r0 = b(r2);
        if (r0 != r4) goto L19;
        return r4;
    L19:
        r110 = r113;
        r111 = r112;
    L7:
        r2 = new RecentFeedbackMessageCollector$collect$1(this, r20);
        goto L8
    }

    public final Object b(Continuation<? super List<b>> r22) {
        if ((r22 instanceof RecentFeedbackMessageCollector$loadRecentConversations$1) == false) goto L7;
        RecentFeedbackMessageCollector$loadRecentConversations$1 r1 = (RecentFeedbackMessageCollector$loadRecentConversations$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L19:
        s r5 = (s) r0;
        if (r5 != null) goto L22;
        return null;
    L22:
        ArrayList r6 = new ArrayList();
        LinkedHashSet r7 = new LinkedHashSet();
        Iterator r8 = r5.a.iterator();
    L24:
        if (r8.hasNext() == false) goto L52;
        l r9 = (l) r8.next();
        e r10 = r9.a;
        if (r10 == null) goto L24;
        List r11 = r9.b;
        if (r11 == null) goto L39;
        Iterator r12 = r11.iterator();
        if (r12.hasNext() == false) goto L39;
        Long r13 = Boxing.boxLong(((Message) r12.next()).getCreateTime());
    L35:
        if (r12.hasNext() == false) goto L40;
        Long r14 = Boxing.boxLong(((Message) r12.next()).getCreateTime());
        if (r13.compareTo(r14) >= 0) goto L35;
        r13 = r14;
    L40:
        if (r13 == null) goto L24;
        if (StringsKt.isBlank(r10.a) == true) goto L24;
        Integer r15 = r10.v;
        if (r15 == null) goto L49;
        if (r15.intValue() == 6) goto L24;
    L49:
        if (r7.add(r10.a) == false) goto L24;
        r6.add(new b(r10, r13.longValue()));
    L39:
        r13 = null;
        goto L40
    L52:
        FLogger.a.d("RecentFeedbackMessageCollector", "load recent conversations success, count=" + RangesKt.coerceAtMost(r6.size(), 3));
        return CollectionsKt.take(CollectionsKt.sortedWith(r6, new d()), 3);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r1.label = 1;
        j r16 = new j(IntrinsicsKt.intercepted(r1), 1);
        r16.C();
        com.larus.im.d.d().selectConversationList(new OmniSelectConversationListRequest(null, null, null, OmniMainConversationStatus.MainConversationStatus_INCLUDE, OmniArchiveStatus.ArchiveStatus_ALL, true, j0.G2_OTA_RECOVERY_BLOCK_FOREVER, "", OmniConversationSortType.OmniConversationSortType_UPDATE_TIME, 10, 7, null), new com.larus.feedback.impl.service.b(r16));
        r0 = r16.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L17:
        if (r0 != r3) goto L19;
        return r3;
    L7:
        r1 = new RecentFeedbackMessageCollector$loadRecentConversations$1(this, r22);
        goto L8
    }
}
