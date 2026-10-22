package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJob;
import com.larus.im.bean.job.AIJobChainResult;
import com.larus.im.bean.job.AIJobListQuery;
import com.larus.im.bean.job.AIJobListResult;
import com.larus.im.bean.job.AIJobRecommendResult;
import com.larus.im.bean.job.AIJobRequestState;
import com.larus.im.bean.job.AIJobRequestStatus;
import com.larus.im.bean.job.AIJobRequestType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.job.AIJobServiceImpl;
import com.larus.im.service.AIJobObserver;
import com.larus.im.service.IAIJobService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatJobListLoader implements AIJobObserver {
    public static final /* synthetic */ int t = 0;
    public final IAIJobService a;
    public final Function1<j, Unit> b;
    public boolean c;
    public boolean d;
    public AIJobRequestState e;
    public List<AIJob> f;
    public boolean g;
    public boolean h;
    public boolean i;
    public b j;
    public Set<? extends AIJobRequestType> k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public Set<String> r;
    public boolean s;

    public static final class a {
        public a() {
        }

        public static final String a(List r12) {
            int r0 = ChatJobListLoader.t;
            StringBuilder r1 = new StringBuilder();
            r1.append(CollectionsKt.joinToString$default(CollectionsKt.take(r12, 5), null, "[", "]", 0, null, new q(), 25, null));
            if (r12.size() <= 5) goto L5;
            String r13 = "...+" + (r12.size() - 5);
        L6:
            r1.append(r13);
            return r1.toString();
        L5:
            r13 = "";
            goto L6
        }

        public static final String b(List r9) {
            int r0 = ChatJobListLoader.t;
            if (r9.isEmpty() == false) goto L6;
            return "empty";
        L6:
            return CollectionsKt.joinToString$default(CollectionsKt.sortedWith(GroupingKt.eachCount(new r(r9)).entrySet(), new s()), null, "[", "]", 0, null, new p(), 25, null);
        }

        public static final String c(AIJob r2) {
            int r0 = ChatJobListLoader.t;
            return "id=" + e(r2.getJobId()) + ",type=" + r2.getJobType() + ",status=" + r2.getStatus() + ",contentLength=" + r2.getContent().length() + ",extLength=" + r2.getExt().length();
        }

        public static final String d(IIMError r2) {
            int r0 = ChatJobListLoader.t;
            StringBuilder r1 = new StringBuilder("code=");
            r1.append(r2.getCode());
            r1.append(" tips=");
            r1.append(r2.getTips());
            r1.append(" exception=");
            Throwable r3 = r2.getException();
            if (r3 == null) goto L5;
            String r4 = r3.getClass().getSimpleName();
        L6:
            r1.append(r4);
            return r1.toString();
        L5:
            r4 = null;
            goto L6
        }

        public static String e(String r1) {
            String r2 = StringsKt.takeLast(r1, 6);
            if (StringsKt.isBlank(r2) == false) goto L6;
            return "blank";
        L6:
            return r2;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final long c;
        public final String d;

        public b() {
            this(0);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            long r1 = this.c;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            String r3 = this.d;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r2 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public final String toString() {
            return "LocalJobPageQuery(jobType=" + this.a + ", status=" + this.b + ", anchorCreateTime=" + this.c + ", anchorJobId=" + this.d + ')';
        }

        public /* synthetic */ b(int r7) {
            this(0, 0, 0, null);
        }

        public b(int r1, int r2, long r3, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }
    }

    public static abstract class c {

        public static final class a extends c {
            public final IIMError a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Failure(error=" + this.a + ')';
            }

            public a(IIMError r2) {
                Intrinsics.checkNotNullParameter(r2, "error");
                this.a = r2;
            }
        }

        public static final class b extends c {
            public final AIJobListResult a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Success(result=" + this.a + ')';
            }

            public b(AIJobListResult r2) {
                Intrinsics.checkNotNullParameter(r2, "result");
                this.a = r2;
            }
        }

        public c() {
        }
    }

    public final class d implements IIMCallback<AIJobChainResult> {
        public final Function1<AIJobRequestType, Unit> a;

        public final boolean mustInMain() {
            return true;
        }

        public d(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "onComplete");
            this.a = r2;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("pullJobChain failed ");
            int r2 = ChatJobListLoader.t;
            r1.append(a.d(r4));
            r0.e("ChatJobListLoader", r1.toString());
            gz8.h.b(r4);
            this.a.invoke(AIJobRequestType.JOB_CHAIN);
        }

        public final void onSuccess(Object r4) {
            AIJobChainResult r5 = (AIJobChainResult) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("pullJobChain success fetched=");
            r1.append(r5.getFetchedCount());
            r1.append(" changed=");
            int r2 = ChatJobListLoader.t;
            r1.append(a.a(r5.getChangedJobIds()));
            r1.append(" cursorBlank=");
            r1.append(StringsKt.isBlank(r5.getCursor()));
            r0.i("ChatJobListLoader", r1.toString());
            this.a.invoke(AIJobRequestType.JOB_CHAIN);
        }
    }

    public static final class e {
        public final boolean a;
        public final int b;
        public final IIMError c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = ((r0 * 31) + this.b) * 31;
            IIMError r2 = this.c;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "RemotePullOutcome(didChange=" + this.a + ", successfulRequestCount=" + this.b + ", firstError=" + this.c + ')';
        }

        public e(boolean r1, int r2, IIMError r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f implements IIMCallback<AIJobListResult> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ChatJobListLoader b;
        public final /* synthetic */ String c;
        public final /* synthetic */ b d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ Function1<c, Unit> f;
        public final /* synthetic */ boolean g;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            if (this.a == true) goto L5;
            ChatJobListLoader r0 = this.b;
            r0.c = true;
            r0.d = true;
            r0.f = CollectionsKt.emptyList();
            this.b.s = false;
        L6:
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("loadLocalJobs failed ");
            int r3 = ChatJobListLoader.t;
            r2.append(a.d(r5));
            r1.e("ChatJobListLoader", r2.toString());
            if (this.g == false) goto L9;
            gz8.h.b(r5);
        L9:
            ChatJobListLoader r4 = this.b;
            boolean r6 = this.e;
            r4.g = false;
            if (r6 == false) goto L12;
            r4.d();
        L12:
            Function1<c, Unit> r7 = this.f;
            if (r7 == null) goto L15;
            r7.invoke(new c.a(r5));
        L15:
            ChatJobListLoader r8 = this.b;
            if (r8.h == false) goto L19;
            r8.h = false;
            ChatJobListLoader.g(r8, "pending", 14);
            return;
        L19:
            return;
        L5:
            ChatJobListLoader r9 = this.b;
            r9.i = false;
            r9.j = null;
            goto L6
        }

        public final void onSuccess(Object r12) {
            AIJobListResult r13 = (AIJobListResult) r12;
            Intrinsics.checkNotNullParameter(r13, "result");
            if (this.a == false) goto L18;
            List<AIJob> r0 = this.b.f;
            List r1 = r13.getJobs();
            if (r1.isEmpty() == true) goto L19;
            LinkedHashSet r3 = new LinkedHashSet();
            Iterator<T> r2 = r0.iterator();
        L9:
            if (r2.hasNext() == false) goto L11;
            r3.add(((AIJob) r2.next()).getJobId());
            goto L9
        L11:
            List<AIJob> r4 = r0;
            ArrayList r5 = new ArrayList();
            Iterator r6 = r1.iterator();
        L13:
            if (r6.hasNext() == false) goto L17;
            Object r7 = r6.next();
            if (r3.add(((AIJob) r7).getJobId()) == false) goto L13;
            r5.add(r7);
            goto L13
        L17:
            r0 = CollectionsKt.plus(r4, r5);
        L19:
            AIJob r8 = (AIJob) CollectionsKt.lastOrNull(r13.getJobs());
            ChatJobListLoader r9 = this.b;
            String r10 = null;
            if (r13.getHasMore() == false) goto L23;
            if (r8 == null) goto L23;
            b r11 = this.d;
            b r14 = new b(r11.a, r11.b, r8.getCreateTime(), r8.getJobId());
        L24:
            r9.j = r14;
            ChatJobListLoader r15 = this.b;
            if (r15.j == null) goto L27;
            boolean r16 = true;
        L28:
            r15.i = r16;
            FLogger r17 = FLogger.a;
            StringBuilder r18 = new StringBuilder("loadLocalJobs page success reason=");
            r18.append(this.c);
            r18.append(" pageCount=");
            r18.append(r13.getJobs().size());
            r18.append(" totalCount=");
            r18.append(r0.size());
            r18.append(" hasMore=");
            r18.append(r13.getHasMore());
            r18.append(" append=");
            r18.append(this.a);
            r18.append(" jobType=");
            r18.append(this.d.a);
            r18.append(" status=");
            r18.append(this.d.b);
            r18.append(" anchorCreateTime=");
            r18.append(this.d.c);
            r18.append(" anchorJobId=");
            String r19 = this.d.d;
            if (r19 == null) goto L31;
            int r20 = ChatJobListLoader.t;
            r10 = a.e(r19);
        L31:
            r18.append(r10);
            r18.append(" statuses=");
            int r21 = ChatJobListLoader.t;
            r18.append(a.b(r13.getJobs()));
            r17.i("ChatJobListLoader", r18.toString());
            if (r13.getHasMore() == false) goto L35;
            if (r8 != null) goto L35;
            r17.e("ChatJobListLoader", "loadLocalJobs hasMore with empty page, reason=" + this.c + " totalCount=" + r0.size());
        L35:
            ChatJobListLoader r22 = this.b;
            r22.c = true;
            r22.d = false;
            r22.f = r0;
            r17.i("ChatJobListLoader", "loadLocalJobs success reason=" + this.c + " count=" + r0.size() + " statuses=" + a.b(r0));
            ChatJobListLoader r23 = this.b;
            r23.m = false;
            r23.g = false;
            String r24 = this.c;
            boolean r25 = this.a;
            boolean r26 = r23.i;
            if (r25 == false) goto L38;
        L41:
            boolean r27 = true;
        L42:
            if (r26 == false) goto L44;
            r23.s = false;
        L69:
            if (this.e == false) goto L71;
            this.b.d();
        L71:
            Function1<c, Unit> r28 = this.f;
            if (r28 == null) goto L74;
            r28.invoke(new c.b(r13));
        L74:
            ChatJobListLoader r110 = this.b;
            if (r110.h == false) goto L89;
            r110.h = false;
            ChatJobListLoader.g(r110, "pending", 14);
            return;
        L89:
            return;
        L44:
            r23.s = false;
            r23.n = true;
            if (r25 == true) goto L65;
            List<AIJob> r29 = r23.f;
            if ((r29 instanceof Collection) == true) goto L49;
        L51:
            Iterator<T> r30 = r29.iterator();
        L53:
            if (r30.hasNext() == false) goto L62;
            AIJob r31 = (AIJob) r30.next();
            if (r31.getJobType() == 2) goto L57;
        L59:
            boolean r32 = false;
        L60:
            if (r32 == false) goto L53;
            boolean r33 = true;
        L63:
            if (r33 == false) goto L65;
            r23.p = true;
            goto L69
        L57:
            if (r31.getStatus() != 1) goto L59;
            r32 = true;
        L62:
            r33 = false;
            goto L63
        L49:
            if (r29.isEmpty() == false) goto L51;
        L65:
            if (r27 == false) goto L69;
            r23.i(r24);
            goto L69
        L38:
            if (r23.s == true) goto L41;
            r27 = false;
            goto L42
        L27:
            r16 = false;
        L23:
            r14 = null;
            goto L24
        L18:
            r0 = r13.getJobs();
            goto L19
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(boolean r1, ChatJobListLoader r2, String r3, b r4, boolean r5, Function1<? super c, Unit> r6, boolean r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class g implements IIMCallback<AIJobRecommendResult> {
        public final /* synthetic */ int a;
        public final /* synthetic */ ChatJobListLoader b;
        public final /* synthetic */ String c;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            if (this.a == this.b.q) goto L6;
            FLogger.a.i("ChatJobListLoader", "pullRecommendJobs failure ignored stale generation reason=" + this.c);
            return;
        L6:
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("pullRecommendJobs failed after local end reason=");
            r1.append(this.c);
            r1.append(' ');
            int r3 = ChatJobListLoader.t;
            r1.append(a.d(r5));
            r0.e("ChatJobListLoader", r1.toString());
            gz8.h.b(r5);
            ChatJobListLoader.a(this.b, "recommendPullFailed:" + this.c);
        }

        public final void onSuccess(Object r14) {
            AIJobRecommendResult r15 = (AIJobRecommendResult) r14;
            Intrinsics.checkNotNullParameter(r15, "result");
            if (this.a == this.b.q) goto L5;
            FLogger.a.i("ChatJobListLoader", "pullRecommendJobs success ignored stale generation reason=" + this.c);
            return;
        L5:
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("pullRecommendJobs success after local end reason=");
            r1.append(this.c);
            r1.append(" fetched=");
            r1.append(r15.getFetchedCount());
            r1.append(" changed=");
            int r3 = ChatJobListLoader.t;
            r1.append(a.a(r15.getChangedJobIds()));
            r0.i("ChatJobListLoader", r1.toString());
            ChatJobListLoader r16 = this.b;
            String r2 = "recommendAfterLocalEnd:" + this.c;
            r16.a.getLocalJobList(new AIJobListQuery(2, 0, 0, null, 100, 14, null), new t(this.a, r16, r2));
        }

        public g(int r1, ChatJobListLoader r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class h implements IIMCallback<AIJobChainResult> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ Ref.IntRef c;
        public final /* synthetic */ Ref.ObjectRef<IIMError> d;
        public final /* synthetic */ Ref.IntRef e;
        public final /* synthetic */ ChatJobListLoader f;
        public final /* synthetic */ Function1<e, Unit> g;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r13) {
            Intrinsics.checkNotNullParameter(r13, "error");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("pullRemoteSnapshots pullJobChain failed reason=");
            r1.append(this.a);
            r1.append(' ');
            int r2 = ChatJobListLoader.t;
            r1.append(a.d(r13));
            r0.e("ChatJobListLoader", r1.toString());
            ChatJobListLoader.b(this.b, this.c, this.d, this.e, this.f, this.a, this.g, false, r13);
        }

        public final void onSuccess(Object r13) {
            AIJobChainResult r14 = (AIJobChainResult) r13;
            Intrinsics.checkNotNullParameter(r14, "result");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("pullRemoteSnapshots pullJobChain success reason=");
            r1.append(this.a);
            r1.append(" fetched=");
            r1.append(r14.getFetchedCount());
            r1.append(" changed=");
            int r2 = ChatJobListLoader.t;
            r1.append(a.a(r14.getChangedJobIds()));
            r0.i("ChatJobListLoader", r1.toString());
            Ref.BooleanRef r3 = this.b;
            Ref.IntRef r4 = this.c;
            Ref.ObjectRef<IIMError> r5 = this.d;
            Ref.IntRef r6 = this.e;
            ChatJobListLoader r7 = this.f;
            String r8 = this.a;
            Function1<e, Unit> r9 = this.g;
            if (r14.getFetchedCount() <= 0) goto L5;
        L8:
            boolean r10 = true;
        L9:
            ChatJobListLoader.b(r3, r4, r5, r6, r7, r8, r9, r10, null);
            return;
        L5:
            if ((!r14.getChangedJobIds().isEmpty()) == true) goto L8;
            r10 = false;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        public h(String r1, Ref.BooleanRef r2, Ref.IntRef r3, Ref.ObjectRef<IIMError> r4, Ref.IntRef r5, ChatJobListLoader r6, Function1<? super e, Unit> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    static {
        new a();
    }

    public final j c() {
        List<AIJob> r0 = this.f;
        int r1 = g0.a;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (g0.c((AIJob) r4) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r2.iterator();
    L9:
        boolean r7 = false;
        if (r6.hasNext() == false) goto L18;
        Object r8 = r6.next();
        AIJob r9 = (AIJob) r8;
        if (r9.getStatus() != 1) goto L14;
    L15:
        r7 = true;
    L16:
        if (r7 == false) goto L9;
        r5.add(r8);
        goto L9
    L14:
        if (r9.getStatus() != (-1)) goto L16;
    L18:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r2.iterator();
    L20:
        if (r11.hasNext() == false) goto L27;
        Object r12 = r11.next();
        if (((AIJob) r12).getStatus() != 2) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == false) goto L20;
        r10.add(r12);
        goto L20
    L24:
        r13 = false;
        goto L25
    L27:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r2.iterator();
    L29:
        if (r15.hasNext() == false) goto L37;
        Object r16 = r15.next();
        if (((AIJob) r16).getStatus() != 3) goto L33;
        boolean r17 = true;
    L34:
        if (r17 == false) goto L29;
        r14.add(r16);
        goto L29
    L33:
        r17 = false;
        goto L34
    L37:
        if ((!CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.sortedWith(r5, new u()), CollectionsKt.sortedWith(r10, new v())), CollectionsKt.sortedWith(r14, new w())).isEmpty()) == true) goto L67;
        List<AIJob> r18 = this.f;
        if ((r18 instanceof Collection) == true) goto L41;
    L43:
        Iterator<T> r19 = r18.iterator();
    L45:
        if (r19.hasNext() == false) goto L63;
        AIJob r20 = (AIJob) r19.next();
        if (this.p == true) goto L49;
    L53:
        boolean r21 = false;
    L54:
        if (r21 == true) goto L56;
    L60:
        boolean r22 = false;
    L61:
        if (r22 == false) goto L45;
        boolean r23 = true;
    L64:
        if (r23 == true) goto L67;
        boolean r24 = false;
    L69:
        if (this.e.getStatus() != AIJobRequestStatus.LOADING) goto L71;
        boolean r25 = true;
    L72:
        boolean r110 = !this.k.isEmpty();
        if (r110 == true) goto L81;
        if (r24 == true) goto L81;
        if (this.c == false) goto L80;
        if (r25 == true) goto L80;
        if (this.l == false) goto L81;
    L80:
        boolean r26 = true;
    L82:
        if (r110 == true) goto L92;
        if (r26 == true) goto L92;
        if (r24 == true) goto L92;
        if (this.l == true) goto L92;
        if (this.d == false) goto L90;
    L91:
        boolean r27 = true;
    L93:
        List<AIJob> r28 = this.f;
        if (this.p == true) goto L96;
    L100:
        boolean r111 = false;
    L102:
        return new j(r28, r26, r27, r110, r111);
    L96:
        if (this.g == true) goto L100;
        if (this.i == true) goto L100;
        r111 = true;
        goto L102
    L90:
        if (this.m == true) goto L91;
    L92:
        r27 = false;
    L81:
        r26 = false;
        goto L82
    L71:
        r25 = false;
        goto L72
    L56:
        if (r20.getJobType() != 2) goto L60;
        if (r20.getStatus() != 1) goto L60;
        r22 = true;
        goto L61
    L49:
        if (this.g == true) goto L53;
        if (this.i == true) goto L53;
        r21 = true;
    L63:
        r23 = false;
        goto L64
    L41:
        if (r18.isEmpty() == false) goto L43;
    L67:
        r24 = true;
        goto L69
    }

    public final void d() {
        this.b.invoke(c());
    }

    public final void e(AIJobRequestType r5) {
        if (this.k.contains(r5) == true) goto L5;
        return;
    L5:
        this.k = SetsKt.minus(this.k, r5);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("pull refresh request finished type=");
        r1.append(r5);
        r1.append(" remaining=");
        Set<? extends AIJobRequestType> r6 = this.k;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        r2.add(((AIJobRequestType) r7.next()).name());
        goto L7
    L9:
        r1.append(r2);
        r0.i("ChatJobListLoader", r1.toString());
        d();
    }

    public final void i(String r6) {
        if (this.n == true) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (r0 == true) goto L14;
        FLogger.a.i("ChatJobListLoader", "pullRecommendJobs skipped reason=" + r6 + " localEndReachedAfterLoadMore=" + this.n + " recommendPullInFlight=" + this.o + " recommendLoadedAfterLocalEnd=" + this.p);
        return;
    L14:
        FLogger.a.i("ChatJobListLoader", "pullRecommendJobs request after local end reason=" + r6);
        this.o = true;
        int r1 = this.q + 1;
        this.q = r1;
        this.a.pullRecommendJobs(new g(r1, this, r6));
        return;
    L5:
        if (this.o == true) goto L9;
        if (this.p == true) goto L9;
        r0 = true;
        goto L11
    }

    public final void k(boolean r9) {
        FLogger r0 = FLogger.a;
        r0.i("ChatJobListLoader", "refresh showPullRefreshing=" + r9);
        if (r9 == true) goto L6;
        r0.i("ChatJobListLoader", "loadInitialLocalFirst");
        this.k = SetsKt.emptySet();
        this.f = CollectionsKt.emptyList();
        this.c = false;
        this.d = false;
        this.l = false;
        this.m = false;
        this.e = new AIJobRequestState(AIJobRequestType.JOB_CHAIN, AIJobRequestStatus.IDLE, 0, null, 12, null);
        this.b.invoke(new j(CollectionsKt.emptyList(), true, false, false, false));
        f("initial", false, false, new m(this));
        return;
    L6:
        this.k = SetsKt.setOf(AIJobRequestType.JOB_CHAIN);
        d();
        g(this, "pullRefresh", 14);
        this.a.pullJobChain(100, new d(new ChatJobListLoader$refresh$1(this)));
    }

    public final void onJobsChanged(List<String> r7) {
        Intrinsics.checkNotNullParameter(r7, "ids");
        FLogger.a.i("ChatJobListLoader", "onJobsChanged ids=" + a.a(r7));
        if (this.o == true) goto L5;
    L19:
        g(this, "jobsChanged", 14);
        return;
    L5:
        if (this.n == false) goto L19;
        if (this.i == true) goto L19;
        Set<String> r0 = this.r;
        ArrayList r3 = new ArrayList();
        Iterator<T> r1 = r7.iterator();
    L10:
        if (r1.hasNext() == false) goto L17;
        Object r4 = r1.next();
        if (((String) r4).length() <= 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L10;
        r3.add(r4);
        goto L10
    L14:
        r5 = false;
        goto L15
    L17:
        this.r = SetsKt.plus(r0, r3);
        FLogger.a.i("ChatJobListLoader", "onJobsChanged deferred during recommend pull ids=" + a.a(r7));
    }

    public final void onRequestStateChanged(AIJobRequestState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        if (r4.getStatus() != AIJobRequestStatus.FAILURE) goto L6;
        FLogger.a.e("ChatJobListLoader", "requestState failed type=" + r4.getRequestType() + " errorCode=" + r4.getErrorCode() + " errorMessage=" + r4.getErrorMessage());
    L6:
        if (r4.getRequestType() == AIJobRequestType.JOB_CHAIN) goto L8;
        return;
    L8:
        this.e = r4;
        boolean r0 = this.k.contains(r4.getRequestType());
        if (r4.getStatus() == AIJobRequestStatus.LOADING) goto L11;
        e(r4.getRequestType());
        return;
    L11:
        if (r0 == true) goto L15;
        d();
        return;
    }

    public ChatJobListLoader(AIJobServiceImpl r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r9, "aiJobService");
        Intrinsics.checkNotNullParameter(r10, "onSnapshotChanged");
        this.a = r9;
        this.b = r10;
        this.e = new AIJobRequestState(AIJobRequestType.JOB_CHAIN, AIJobRequestStatus.IDLE, 0, null, 12, null);
        this.f = CollectionsKt.emptyList();
        this.k = SetsKt.emptySet();
        this.r = SetsKt.emptySet();
    }

    public static final void a(ChatJobListLoader r6, String r7) {
        boolean r0 = false;
        r6.o = false;
        Set<String> r1 = r6.r;
        r6.r = SetsKt.emptySet();
        Set r2 = SequencesKt.toSet(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(r6.f), new k()), new l()));
        if ((!r1.isEmpty()) == true) goto L5;
    L26:
        if (r0 == false) goto L28;
        FLogger.a.i("ChatJobListLoader", "refresh task jobs after recommend pull reason=" + r7 + " changedIds=" + a.a(CollectionsKt.toList(r1)));
        StringBuilder r3 = new StringBuilder("pendingTaskChangedAfterRecommendPull:");
        r3.append(r7);
        g(r6, r3.toString(), 14);
        return;
    L28:
        r6.d();
        return;
    L5:
        if (r6.l == false) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L25;
        Set<String> r5 = r1;
        if ((r5 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r8 = r5.iterator();
    L19:
        if (r8.hasNext() == false) goto L23;
        if ((!r2.contains((String) r8.next())) == false) goto L19;
        boolean r9 = true;
    L24:
        if (r9 == false) goto L26;
    L23:
        r9 = false;
        goto L24
    L15:
        if (r5.isEmpty() == false) goto L17;
    L25:
        r0 = true;
        goto L26
    L7:
        if (r6.k.contains(AIJobRequestType.JOB_CHAIN) == true) goto L10;
        r4 = false;
        goto L11
    }

    public final void j(String r11, Function1<? super e, Unit> r12) {
        FLogger.a.i("ChatJobListLoader", "pullRemoteSnapshots reason=".concat(r11));
        this.l = true;
        this.m = false;
        d();
        Ref.IntRef r7 = new Ref.IntRef();
        r7.element = 1;
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        Ref.IntRef r5 = new Ref.IntRef();
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        this.a.pullJobChain(100, new h(r11, r4, r5, r6, r7, this, r12));
    }

    public static /* synthetic */ void g(ChatJobListLoader r3, String r4, int r5) {
        boolean r1 = true;
        if ((r5 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r5 & 4) != 0) goto L10;
        r1 = false;
    L10:
        r3.f(r4, r0, r1, null);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void f(String r12, boolean r13, boolean r14, Function1<? super c, Unit> r15) {
        if (this.g == false) goto L6;
        this.h = true;
        return;
    L6:
        this.g = true;
        int r2 = 0;
        if (this.n == false) goto L9;
    L28:
        boolean r0 = true;
    L29:
        this.i = false;
        this.j = null;
        this.n = false;
        this.o = false;
        this.p = false;
        this.r = SetsKt.emptySet();
        this.q++;
        this.s = r0;
        h(r12, new b(r2), false, r13, r14, r15);
        return;
    L9:
        if (this.p == true) goto L28;
        List<AIJob> r1 = this.f;
        if ((r1 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r3 = r1.iterator();
    L17:
        if (r3.hasNext() == false) goto L24;
        if (((AIJob) r3.next()).getJobType() != 2) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == false) goto L17;
        boolean r5 = true;
    L25:
        if (r5 == true) goto L28;
        r0 = false;
        goto L29
    L21:
        r4 = false;
    L24:
        r5 = false;
        goto L25
    L13:
        if (r1.isEmpty() == false) goto L15;
        goto L15
    }

    public final void h(String r18, b r19, boolean r20, boolean r21, boolean r22, Function1<? super c, Unit> r23) {
        this.a.getLocalJobList(new AIJobListQuery(r19.a, r19.b, r19.c, r19.d, 20), new f(r20, this, r18, r19, r21, r23, r22));
    }

    public static final void b(Ref.BooleanRef r3, Ref.IntRef r4, Ref.ObjectRef r5, Ref.IntRef r6, ChatJobListLoader r7, String r8, Function1 r9, boolean r10, IIMError r11) {
        if (r3.element == true) goto L7;
        if (r10 == true) goto L7;
        boolean r12 = false;
    L8:
        r3.element = r12;
        if (r11 != null) goto L12;
        r4.element++;
    L14:
        int r13 = r6.element - 1;
        r6.element = r13;
        if (r13 != 0) goto L23;
        r7.l = false;
        int r14 = r4.element;
        IIMError r15 = (IIMError) r5.element;
        e r16 = new e(r12, r14, r15);
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("pullRemoteSnapshots finished reason=");
        r18.append(r8);
        r18.append(" didChange=");
        r18.append(r12);
        r18.append(" successfulRequestCount=");
        r18.append(r14);
        r18.append(" firstError=");
        if (r15 == null) goto L20;
        String r19 = a.d(r15);
    L21:
        r18.append(r19);
        r17.i("ChatJobListLoader", r18.toString());
        r9.invoke(r16);
        return;
    L20:
        r19 = null;
        goto L21
    L23:
        return;
    L12:
        if (r5.element != null) goto L14;
        r5.element = r11;
    L7:
        r12 = true;
        goto L8
    }
}
