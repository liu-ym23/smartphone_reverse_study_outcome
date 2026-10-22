package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.app.Application;
import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.bmhome.chat.api.sidebar.ISideBarConversationIconService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.MentionPanelContent;
import com.larus.bmhome.chat.component.bottom.core.inputtext.SkillPanelSearch;
import com.larus.bmhome.chat.component.bottom.core.inputtext.SkillSearchIndex;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.s1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import com.larus.bmhome.taskskill.b2;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.main.side_bar.view.SideBarConversationIconSessionImpl;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import tx9.y1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MentionPanelController {
    public static final /* synthetic */ int R = 0;
    public b A;
    public long B;
    public long C;
    public List<be8.b> D;
    public final SkillPanelSearch E;
    public s1 F;
    public final gc8.b G;
    public boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public final m0 P;
    public final MentionPanelController$backCallback$1 Q;
    public final ChatInputWithMentionDelegate a;
    public final CoroutineScope b;
    public final q0 c;
    public final qp8.e d;
    public final Function1<MentionFilePickerType, Unit> e;
    public final Function0<be8.a> f;
    public final Function0<Boolean> g;
    public final Function0<Unit> h;
    public final boolean i;
    public final Set<MentionPanelContent> j;
    public final Function1<Boolean, Unit> k;
    public final Function0<Unit> l;
    public final Function1<k1, Boolean> m;
    public k1 n;
    public List<com.larus.bmhome.chat.component.bottom.core.inputtext.d0> o;
    public Job p;
    public Job q;
    public Job r;
    public Job s;
    public String t;
    public f0 u;
    public boolean v;
    public SearchState w;
    public Page x;
    public MentionSearchDomain y;
    public MentionSearchDomain z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelController$Page;", "", "<init>", "(Ljava/lang/String;I)V", "ROOT", "REMOTE_DOMAIN", "ATTACHMENT_DOMAIN", "SKILL_DOMAIN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum Page extends Enum<Page> {
        public static final Page ATTACHMENT_DOMAIN = null;
        public static final Page REMOTE_DOMAIN = null;
        public static final Page ROOT = null;
        public static final Page SKILL_DOMAIN = null;
        public static final /* synthetic */ Page[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Page> getEntries() {
            return b;
        }

        static {
            Page r0 = new Page("ROOT", 0);
            ROOT = r0;
            Page r1 = new Page("REMOTE_DOMAIN", 1);
            REMOTE_DOMAIN = r1;
            Page r3 = new Page("ATTACHMENT_DOMAIN", 2);
            ATTACHMENT_DOMAIN = r3;
            Page r5 = new Page("SKILL_DOMAIN", 3);
            SKILL_DOMAIN = r5;
            Page[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Page[] values() {
            return (Page[]) a.clone();
        }

        public static Page valueOf(String r1) {
            return (Page) r27.a.a(Page.class, r1);
        }

        public Page(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelController$SearchState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "FULL_LOADING", "CONTACT_READY_WAITING_REFERENCES", "READY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum SearchState extends Enum<SearchState> {
        public static final SearchState CONTACT_READY_WAITING_REFERENCES = null;
        public static final SearchState FULL_LOADING = null;
        public static final SearchState IDLE = null;
        public static final SearchState READY = null;
        public static final /* synthetic */ SearchState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<SearchState> getEntries() {
            return b;
        }

        static {
            SearchState r0 = new SearchState("IDLE", 0);
            IDLE = r0;
            SearchState r1 = new SearchState("FULL_LOADING", 1);
            FULL_LOADING = r1;
            SearchState r3 = new SearchState("CONTACT_READY_WAITING_REFERENCES", 2);
            CONTACT_READY_WAITING_REFERENCES = r3;
            SearchState r5 = new SearchState("READY", 3);
            READY = r5;
            SearchState[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static SearchState[] values() {
            return (SearchState[]) a.clone();
        }

        public static SearchState valueOf(String r1) {
            return (SearchState) r27.a.a(SearchState.class, r1);
        }

        public SearchState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final long a;
        public final MentionSearchDomain b;
        public final String c;

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
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "PageRequestKey(generation=" + this.a + ", domain=" + this.b + ", cursor=" + this.c + ')';
        }

        public b(long r2, MentionSearchDomain r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "domain");
            Intrinsics.checkNotNullParameter(r5, "cursor");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class c<T> {
        public final List<T> a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "SearchRootPreview(items=" + this.a + ", showMore=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends T> r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "items");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MentionSearchDomain.values().length];
            r0[MentionSearchDomain.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[MentionSearchDomain.CONTACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r0[MentionSearchDomain.DRIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[MentionSearchDomain.CONVERSATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            a = r0;
            int[] r1 = new int[SearchState.values().length];
            r1[SearchState.READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r1[SearchState.CONTACT_READY_WAITING_REFERENCES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r1[SearchState.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r1[SearchState.FULL_LOADING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            b = r1;
        }
    }

    static {
    }

    public static String k() {
        Application r0 = AppHost.a.getApplication();
        if (AccountService.a.isEnterpriseAccount() == false) goto L5;
        int r1 = 2131906196;
    L7:
        return r0.getString(r1);
    L5:
        r1 = 2131906195;
        goto L7
    }

    public final void i() {
        Job r0 = this.q;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.E.a();
        this.F = null;
        this.C++;
        Job r1 = this.r;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.r = null;
        gc8.b r2 = this.G;
        if (r2 == null) goto L11;
        r2.deactivate();
    L11:
        this.B++;
        Job r3 = this.p;
        if (r3 == null) goto L14;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L14:
        q();
        this.n = null;
        this.t = null;
        this.v = false;
        this.w = SearchState.IDLE;
        this.H = false;
        m0 r4 = this.P;
        r4.c = false;
        ExposeXTrackerExtKt.a(r4.a, "mention_panel_option:");
    }

    public final void n() {
        this.E.a();
        this.F = null;
        gc8.b r1 = this.G;
        if (r1 == null) goto L5;
        r1.deactivate();
    L5:
        this.B++;
        this.C++;
        Job r2 = this.p;
        if (r2 == null) goto L8;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L8:
        Job r3 = this.r;
        if (r3 == null) goto L11;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L11:
        this.r = null;
        q();
        this.n = null;
        this.t = null;
        this.u = new f0(null, null, null, null, 31);
        this.D = CollectionsKt.emptyList();
        this.H = false;
        this.v = false;
        this.w = SearchState.IDLE;
        m0 r4 = this.P;
        r4.c = false;
        ExposeXTrackerExtKt.a(r4.a, "mention_panel_option:");
        if (this.O == false) goto L15;
        MentionRecommendStore r0 = MentionRecommendStore.a;
        qp8.e r5 = this.d;
        boolean r6 = this.K;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "config");
        MentionRecommendStore.f(r5, r6);
        return;
    }

    public final void q() {
        Job r0 = this.s;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.s = null;
        this.z = null;
        this.A = null;
        this.x = Page.ROOT;
        this.y = null;
        setEnabled(false);
        MentionPanelListView r1 = this.c.a;
        r1.f(true);
        r1.j(0);
        r1.h = null;
    }

    public final f0 j(f0 r8) {
        List<c1> r0 = r8.a;
        List<c1> r2 = null;
        if (this.M == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        r0 = CollectionsKt.emptyList();
    L8:
        List r1 = CollectionsKt.filterNotNull(r0);
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r3 = r8.b;
        if (this.K == true) goto L12;
        r3 = null;
    L12:
        if (r3 != null) goto L14;
        r3 = CollectionsKt.emptyList();
    L14:
        List r4 = CollectionsKt.filterNotNull(r3);
        List<c1> r5 = r8.c;
        if (this.L == true) goto L18;
        r5 = null;
    L18:
        if (r5 != null) goto L20;
        r5 = CollectionsKt.emptyList();
    L20:
        List r6 = CollectionsKt.filterNotNull(r5);
        List<c1> r7 = r8.d;
        if (this.N == false) goto L23;
        r2 = r7;
    L23:
        if (r2 != null) goto L25;
        r2 = CollectionsKt.emptyList();
    L25:
        List r9 = CollectionsKt.filterNotNull(r2);
        Map<MentionSearchDomain, d1> r10 = r8.e;
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<Map.Entry<MentionSearchDomain, d1>> r12 = r10.entrySet().iterator();
    L27:
        if (r12.hasNext() == false) goto L32;
        Map.Entry<MentionSearchDomain, d1> r13 = r12.next();
        if (l(r13.getKey()) == false) goto L27;
        r11.put(r13.getKey(), r13.getValue());
        goto L27
    L32:
        return f0.a(r1, r4, r6, r9, r11);
    }

    public final boolean l(MentionSearchDomain r2) {
        int r3 = d.a[r2.ordinal()];
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L19;
        if (r3 == 3) goto L18;
        if (r3 != 4) goto L12;
        return this.N;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return this.M;
    L19:
        return this.K;
    L16:
        return this.L;
    }

    public final void m(MentionSearchDomain r19) {
        if (l(r19) == true) goto L5;
        return;
    L5:
        Page r0 = this.x;
        Page r1 = Page.REMOTE_DOMAIN;
        if (r0 == r1) goto L8;
        return;
    L8:
        if (this.y == r19) goto L10;
        return;
    L10:
        if (this.z != null) goto L53;
        d1 r2 = this.u.e.get(r19);
        if (r2 == null) goto L47;
        k1 r3 = null;
        if (r2.a() == true) goto L18;
        r2 = null;
    L18:
        if (r2 == null) goto L48;
        String r7 = r2.b;
        if (r7 == null) goto L49;
        String r4 = this.t;
        if (r4 == null) goto L50;
        boolean r5 = true;
        if (r4.length() <= 0) goto L26;
        boolean r6 = true;
    L27:
        if (r6 == false) goto L29;
        String r8 = r4;
    L30:
        if (r8 == null) goto L54;
        long r10 = this.B;
        b r9 = new b(r10, r19, r7);
        k1 r11 = h(r8, r10);
        if (r11 != null) goto L35;
        return;
    L35:
        if (this.x == r1) goto L37;
    L39:
        r5 = false;
    L40:
        if (r5 == false) goto L42;
        r3 = r11;
    L42:
        if (r3 == null) goto L52;
        this.z = r19;
        p(r3);
        this.s = BuildersKt.launch$default(this.b, null, null, new MentionPanelController$loadMore$1(this, r8, r10, r9, r19, r7, null), 3, null);
        return;
    L52:
        return;
    L37:
        if (this.y != r19) goto L39;
    L54:
        return;
    L29:
        r8 = null;
        goto L30
    L26:
        r6 = false;
        goto L27
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    }

    public final void o(MentionSearchDomain r10) {
        if (this.x == Page.ROOT) goto L5;
        return;
    L5:
        if (l(r10) == false) goto L59;
        k1 r0 = this.n;
        if (r0 == null) goto L57;
        boolean r2 = false;
        if (StringsKt.isBlank(r0.c) == true) goto L12;
        SearchState r1 = this.w;
        int r3 = d.b[r1.ordinal()];
        if (r3 == 1) goto L30;
        if (r3 == 2) goto L27;
        if (r3 == 3) goto L29;
        if (r3 == 4) goto L29;
        throw new NoWhenBranchMatchedException();
    L29:
        boolean r4 = false;
    L31:
        if (r4 == true) goto L34;
        r0 = null;
    L34:
        if (r0 == null) goto L58;
        q0 r5 = this.c;
        int r7 = d.a[r10.ordinal()];
        if (r7 == 1) goto L45;
        if (r7 == 2) goto L44;
        if (r7 == 3) goto L43;
        if (r7 != 4) goto L42;
        MentionPanelSection r6 = MentionPanelSection.CONVERSATION;
    L46:
        MentionPanelListView.f r8 = r5.a(r6);
        this.c.b();
        this.x = Page.REMOTE_DOMAIN;
        this.y = r10;
        setEnabled(true);
        d1 r9 = this.u.e.get(r10);
        if (r9 != null) goto L49;
    L51:
        if (r2 == false) goto L53;
        m(r10);
    L54:
        this.c.c(r8);
        return;
    L53:
        p(r0);
        goto L54
    L49:
        if (r9.a() != true) goto L51;
        r2 = true;
        goto L51
    L42:
        throw new NoWhenBranchMatchedException();
    L43:
        r6 = MentionPanelSection.DRIVE;
        goto L46
    L44:
        r6 = MentionPanelSection.CONTACT;
        goto L46
    L45:
        r6 = MentionPanelSection.GROUP;
        goto L46
    L58:
        return;
    L27:
        if (r10 != MentionSearchDomain.CONTACT) goto L29;
    L30:
        r4 = true;
        goto L31
    L12:
        if (this.v == true) goto L29;
        if (r10 == MentionSearchDomain.CONTACT) goto L30;
        if (r10 != MentionSearchDomain.GROUP) goto L29;
    L57:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v139, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v144, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v147, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v149, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v150, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v174, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v73, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r71v0, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController] */
    public final void p(k1 r72) {
        gc8.b r0 = this.G;
        if (r0 == null) goto L16;
        List<c1> r1 = this.u.d;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        c1 r4 = (c1) r3.next();
        if (r4 == null) goto L12;
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r5 = r4.a;
        if (r5 == null) goto L12;
        String r6 = r5.a;
    L13:
        if (r6 == null) goto L6;
        r2.add(r6);
    L12:
        r6 = null;
        goto L13
    L15:
        r0.a(r2);
        Unit r7 = Unit.INSTANCE;
    L16:
        String r10 = StringsKt.trim(r72.c).toString();
        if (r10.length() != 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L22;
        this.E.a();
        s1 r9 = null;
    L29:
        this.F = r9;
        MentionSearchDomain r11 = this.y;
        if (r11 != null) goto L32;
    L39:
        MentionSearchDomain r13 = null;
    L41:
        if (this.x != Page.ATTACHMENT_DOMAIN) goto L43;
        boolean r14 = true;
    L45:
        if (r10.length() <= 0) goto L47;
        boolean r12 = true;
    L48:
        if (r12 == true) goto L50;
    L52:
        boolean r15 = false;
    L53:
        if (r13 != null) goto L58;
        if (r14 == true) goto L58;
        if (r15 == true) goto L58;
        boolean r16 = false;
    L60:
        if (r13 == null) goto L77;
        List r17 = CollectionsKt.createListBuilder();
        if (l(r13) == false) goto L76;
        int r18 = d.a[r13.ordinal()];
        if (r18 != 1) goto L67;
        f(this, r17, k(), this.u.c, MentionPanelSection.GROUP, null, true, 8);
        goto L76
    L67:
        if (r18 == 2) goto L74;
        if (r18 == 3) goto L73;
        if (r18 != 4) goto L72;
        f(this, r17, AppHost.a.getApplication().getString(2131897987), this.u.d, MentionPanelSection.CONVERSATION, null, true, 8);
        goto L76
    L72:
        throw new NoWhenBranchMatchedException();
    L73:
        f(this, r17, AppHost.a.getApplication().getString(2131906707), this.u.a, MentionPanelSection.DRIVE, null, true, 8);
        goto L76
    L74:
        d(this, r17, this.u.b, MentionPanelSection.CONTACT, null, true, 4);
    L76:
        ?? r19 = CollectionsKt.build(r17);
    L214:
        final m0 r20 = this.P;
        if (r10.length() <= 0) goto L217;
        boolean r21 = true;
    L218:
        r20.getClass();
        Intrinsics.checkNotNullParameter(r19, "items");
        Iterable r22 = (Iterable) r19;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r24 = r22.iterator();
        final m0 r25 = r20;
        int r26 = 1;
    L220:
        if (r24.hasNext() == false) goto L250;
        final y r27 = (y) r24.next();
        boolean r28 = r27 instanceof y.d;
        if (r28 == false) goto L225;
        h0 r110 = ((y.d) r27).b;
    L227:
        String r111 = r110.a;
        String r29 = r110.b;
        String r30 = r110.c;
        if (Intrinsics.areEqual(r111, "contact") == false) goto L230;
    L233:
        boolean r31 = true;
    L234:
        if (r31 == true) goto L236;
        String r32 = r30;
    L237:
        if (r32 != null) goto L239;
        String r210 = "";
    L240:
        int r33 = r26 + 1;
        final m0.b r112 = new m0.b(r111, r29, r210, r21, r26);
        if (r28 == false) goto L243;
        y.d r34 = (y.d) r27;
        r25.getClass();
        String r35 = m0.a(r112);
        boolean r38 = r21;
        Function0 r36 = new i0(r25, r112);
        Function0 r37 = new j0(r25, r112, r27);
        String r39 = r34.a;
        h0 r40 = r34.b;
        g0 r113 = r34.c;
        List<String> r114 = r34.d;
        String r115 = r34.e;
        int r310 = r33;
        t1 r41 = r34.f;
        Integer r42 = r34.g;
        b2.b r43 = r34.h;
        String r44 = r34.i;
        String r45 = r34.j;
        com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r46 = r34.k;
        com.larus.bmhome.chat.referenceicon.b r47 = r34.l;
        String r48 = r34.m;
        String r49 = r34.n;
        String r50 = r34.o;
        Intrinsics.checkNotNullParameter(r39, "title");
        Intrinsics.checkNotNullParameter(r40, "trace");
        Intrinsics.checkNotNullParameter(r115, "secondaryText");
        Intrinsics.checkNotNullParameter(r37, "action");
        r27 = new y.d(r39, r40, r113, r114, r115, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r35, r36, r37);
    L246:
        r25 = r20;
        r26 = r310;
    L248:
        r23.add(r27);
        r24 = r24;
        r21 = r38;
        goto L220
    L243:
        r38 = r21;
        r310 = r33;
        if ((r27 instanceof y.c) == false) goto L246;
        String r51 = m0.a(r112);
        Function0 r52 = new k0(r20, r112);
        Function0 r53 = new l0(r20, r112, r27);
        h0 r54 = ((y.c) r27).a;
        Intrinsics.checkNotNullParameter(r54, "trace");
        Intrinsics.checkNotNullParameter(r53, "action");
        r27 = new y.c(r54, r51, r52, r53);
        goto L246
    L239:
        r210 = r32;
        goto L240
    L236:
        r32 = null;
        goto L237
    L230:
        if (Intrinsics.areEqual(r110.a, "group_chat") == true) goto L233;
        r31 = false;
        goto L234
    L225:
        if ((r27 instanceof y.c) == false) goto L247;
        r110 = ((y.c) r27).a;
        goto L227
    L247:
        r38 = r21;
        goto L248
    L250:
        if (r10.length() <= 0) goto L252;
        boolean r55 = true;
    L253:
        if (r55 == false) goto L258;
        if (r16 == true) goto L258;
        if (this.w == SearchState.READY) goto L258;
        boolean r56 = true;
    L260:
        if (r10.length() <= 0) goto L262;
        boolean r57 = true;
    L263:
        if (r57 == false) goto L268;
        if (r16 == true) goto L268;
        if (this.w != SearchState.CONTACT_READY_WAITING_REFERENCES) goto L268;
        boolean r58 = true;
    L270:
        if (r10.length() <= 0) goto L272;
        boolean r59 = true;
    L273:
        if (r59 == false) goto L278;
        if (r16 == true) goto L278;
        if (this.w != SearchState.READY) goto L278;
        boolean r60 = true;
    L279:
        if (r13 != null) goto L281;
    L283:
        boolean r61 = false;
    L285:
        if (r23.isEmpty() == true) goto L301;
        Iterator r62 = r23.iterator();
    L289:
        if (r62.hasNext() == false) goto L301;
        y r63 = (y) r62.next();
        if ((r63 instanceof y.d) == false) goto L293;
    L298:
        boolean r64 = true;
    L299:
        if (r64 == false) goto L289;
        boolean r65 = true;
    L302:
        if (r56 == true) goto L307;
        if (r61 == true) goto L307;
        if (r65 == true) goto L307;
        this.k.invoke(Boolean.FALSE);
        return;
    L307:
        q0 r66 = this.c;
        if (r13 != null) goto L310;
    L333:
        Function0<Unit> r67 = null;
    L334:
        if (r58 == true) goto L340;
        if (r13 != null) goto L337;
    L339:
        boolean r68 = false;
    L341:
        if (r14 == true) goto L356;
        if (r60 == true) goto L356;
        if (r15 == true) goto L356;
        if (r13 != null) goto L346;
    L355:
        boolean r69 = false;
    L357:
        if (r14 == true) goto L362;
        if (r60 == true) goto L362;
        if (r15 == true) goto L362;
        boolean r70 = false;
    L363:
        r66.getClass();
        Intrinsics.checkNotNullParameter(r23, "items");
        Intrinsics.checkNotNullParameter(r10, "highlightKeyword");
        if (r66.d.p == true) goto L440;
        Object r71 = CollectionsKt.firstOrNull(r23);
        if ((r71 instanceof y.a) == false) goto L369;
        y.a r73 = (y.a) r71;
    L370:
        if (r73 == null) goto L375;
        String r74 = r73.a;
        if (r74 == null) goto L375;
        if (r16 == false) goto L375;
    L376:
        r66.c.setText(r74);
        TextView r116 = r66.c;
        if (r74 == null) goto L379;
        boolean r117 = true;
    L380:
        if (r117 == false) goto L382;
        int r118 = 0;
    L383:
        r116.setVisibility(r118);
        MentionPanelListView r119 = r66.a;
        if (r74 == null) goto L386;
        boolean r75 = true;
    L387:
        r119.getClass();
        Intrinsics.checkNotNullParameter(r23, "items");
        Intrinsics.checkNotNullParameter(r10, "highlightKeyword");
        if (r10.length() <= 0) goto L390;
        boolean r76 = true;
    L391:
        if (r76 == true) goto L393;
    L406:
        boolean r77 = false;
    L407:
        r119.f(r77);
        r119.f = r67;
        r119.j = r23;
        r119.l = r10;
        r119.m = r68;
        r119.n = !r75;
        if (r69 == false) goto L417;
        Integer r78 = r119.h;
        if (r78 != null) goto L412;
    L414:
        LinearLayoutManager r79 = null;
        boolean r80 = false;
    L415:
        if (r80 == false) goto L418;
        boolean r81 = true;
    L419:
        List<y> r82 = r119.e();
        r119.k = r82;
        r119.c(r82);
        r119.d.y2(r82, r10, r119.n);
        r119.u.invalidateItemDecorations();
        Integer r83 = r119.h;
        if (r83 == null) goto L422;
        int r84 = r83.intValue();
    L423:
        r119.i = r84;
        Function1<Boolean, Unit> r85 = r119.b;
        if (r70 == false) goto L427;
        if (r81 == false) goto L427;
        boolean r86 = true;
    L428:
        r85.invoke(Boolean.valueOf(r86));
        if (r77 == false) goto L436;
        r119.u.stopScroll();
        LinearLayoutManager r87 = r119.u.getLayoutManager();
        if ((r87 instanceof LinearLayoutManager) == false) goto L433;
        LinearLayoutManager r88 = r87;
    L434:
        if (r88 == null) goto L439;
        r88.scrollToPositionWithOffset(0, 0);
    L439:
        r119.u.addOnLayoutChangeListener(new e0(r119));
        r66.d.i(true);
        goto L440
    L433:
        r88 = r79;
        goto L434
    L436:
        MentionPanelListView.f r89 = r119.p;
        if (r89 == null) goto L439;
        r119.d(r89);
    L427:
        r86 = false;
        goto L428
    L422:
        r84 = RangesKt.coerceAtMost(r119.g(r82), r119.g);
    L418:
        r81 = false;
        goto L419
    L412:
        if (r119.g(r23) >= r78.intValue()) goto L414;
        r79 = null;
        r119.h = null;
        r80 = true;
        goto L415
    L417:
        r79 = null;
        goto L418
    L393:
        if ((!r23.isEmpty()) == false) goto L406;
        if (r23.isEmpty() == true) goto L403;
        Iterator r90 = r23.iterator();
    L399:
        if (r90.hasNext() == false) goto L403;
        if (Intrinsics.areEqual((y) r90.next(), y.b.a) == true) goto L399;
        boolean r91 = false;
    L404:
        if (r91 == false) goto L406;
        r77 = true;
    L403:
        r91 = true;
        goto L404
    L390:
        r76 = false;
        goto L391
    L386:
        r75 = false;
        goto L387
    L382:
        r118 = 8;
        goto L383
    L379:
        r117 = false;
    L375:
        r74 = null;
        goto L376
    L369:
        r73 = null;
    L440:
        this.k.invoke(Boolean.TRUE);
        m0 r92 = this.P;
        if (((Boolean) r92.b.invoke()).booleanValue() == true) goto L443;
        return;
    L443:
        if (r92.c == true) goto L465;
        r92.c = true;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter("", "skillId");
        JSONObject r93 = new JSONObject();
        r93.put("current_page", "chat");
        r93.put("skill_id", "");
        y1.b("mention_panel_show", r93);
        return;
    L465:
        return;
    L362:
        r70 = true;
        goto L363
    L346:
        if (this.z != null) goto L355;
        d1 r94 = this.u.e.get(r13);
        if (r94 != null) goto L350;
    L352:
        boolean r95 = false;
    L353:
        if (r95 == false) goto L355;
    L350:
        if (r94.a == true) goto L352;
        r95 = true;
    L356:
        r69 = true;
        goto L357
    L337:
        if (this.z != r13) goto L339;
    L340:
        r68 = true;
        goto L341
    L310:
        if (this.z != null) goto L327;
        d1 r96 = this.u.e.get(r13);
        if (r96 != null) goto L314;
    L316:
        boolean r97 = false;
    L317:
        if (r97 == false) goto L327;
        d1 r99 = this.u.e.get(r13);
        if (r99 == null) goto L324;
        String r100 = r99.b;
        if (r100 == null) goto L324;
        boolean r101 = Intrinsics.areEqual(this.A, new b(this.B, r13, r100));
    L325:
        if (r101 == true) goto L327;
        boolean r102 = true;
    L328:
        if (r102 == false) goto L330;
        final MentionSearchDomain r103 = r13;
    L331:
        if (r103 == null) goto L333;
        r67 = new u(this, r103);
        goto L334
    L330:
        r103 = null;
    L324:
        r101 = false;
        goto L325
    L314:
        if (r96.a() != true) goto L316;
        r97 = true;
    L327:
        r102 = false;
        goto L328
    L293:
        if ((r63 instanceof y.c) == true) goto L298;
        if ((r63 instanceof y.b) == true) goto L298;
        r64 = false;
    L301:
        r65 = false;
        goto L302
    L281:
        if (this.z != r13) goto L283;
        r61 = true;
    L278:
        r60 = false;
        goto L279
    L272:
        r59 = false;
    L268:
        r58 = false;
        goto L270
    L262:
        r57 = false;
    L258:
        r56 = false;
        goto L260
    L252:
        r55 = false;
        goto L253
    L217:
        r21 = false;
        goto L218
    L77:
        if (r14 == false) goto L79;
        List r104 = CollectionsKt.createListBuilder();
        b(r104, r10, true);
        r19 = CollectionsKt.build(r104);
        goto L214
    L79:
        if (r15 == false) goto L82;
        List r105 = CollectionsKt.createListBuilder();
        g(r105, r10, true);
        r19 = CollectionsKt.build(r105);
        goto L214
    L82:
        if (r10.length() <= 0) goto L84;
        boolean r106 = true;
    L85:
        if (r106 == false) goto L92;
        if (this.w != SearchState.FULL_LOADING) goto L92;
        r19 = new ArrayList(15);
        int r107 = 0;
    L89:
        if (r107 >= 15) goto L214;
        r19.add(y.b.a);
        r107 = r107 + 1;
    L92:
        if (r10.length() <= 0) goto L94;
        boolean r108 = true;
    L95:
        if (r108 == true) goto L97;
    L109:
        List r109 = CollectionsKt.createListBuilder();
        if (r10.length() != 0) goto L112;
        boolean r120 = true;
    L113:
        if (r120 == true) goto L115;
    L120:
        b(r109, r10, false);
        if (r10.length() <= 0) goto L123;
        boolean r121 = true;
    L124:
        if (r121 == false) goto L176;
        f0 r122 = this.u;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r123 = r122.b;
        Map<MentionSearchDomain, d1> r124 = r122.e;
        MentionSearchDomain r125 = MentionSearchDomain.CONTACT;
        d1 r126 = r124.get(r125);
        if (r126 != null) goto L128;
    L130:
        boolean r127 = false;
    L131:
        c r128 = u(r123, 3, r127, false);
        List r129 = r128.a;
        MentionPanelSection r130 = MentionPanelSection.CONTACT;
        if (r128.b == false) goto L134;
        MentionSearchDomain r131 = r125;
    L135:
        List r132 = r109;
        d(this, r109, r129, r130, r131, false, 8);
        if (this.L == false) goto L149;
        f0 r133 = this.u;
        List<c1> r134 = r133.c;
        Map<MentionSearchDomain, d1> r135 = r133.e;
        MentionSearchDomain r136 = MentionSearchDomain.GROUP;
        d1 r137 = r135.get(r136);
        if (r137 != null) goto L140;
    L142:
        boolean r138 = false;
    L143:
        c r139 = u(r134, 3, r138, false);
        String r140 = k();
        List r141 = r139.a;
        MentionPanelSection r142 = MentionPanelSection.GROUP;
        if (r139.b == false) goto L146;
        MentionSearchDomain r143 = r136;
    L147:
        f(this, r132, r140, r141, r142, r143, false, 16);
        goto L149
    L146:
        r143 = null;
        goto L147
    L140:
        if (r137.a != true) goto L142;
        r138 = true;
    L149:
        g(r132, r10, false);
        if (this.M == false) goto L162;
        f0 r144 = this.u;
        List<c1> r145 = r144.a;
        Map<MentionSearchDomain, d1> r146 = r144.e;
        MentionSearchDomain r147 = MentionSearchDomain.DRIVE;
        d1 r148 = r146.get(r147);
        if (r148 != null) goto L154;
    L156:
        boolean r149 = false;
    L157:
        c r150 = v(this, r145, r149, 4);
        String r151 = AppHost.a.getApplication().getString(2131906707);
        List r152 = r150.a;
        MentionPanelSection r153 = MentionPanelSection.DRIVE;
        if (r150.b == false) goto L160;
        MentionSearchDomain r154 = r147;
    L161:
        int r155 = 4;
        f(this, r132, r151, r152, r153, r154, false, 16);
    L164:
        if (this.N == false) goto L213;
        f0 r156 = this.u;
        List<c1> r157 = r156.d;
        Map<MentionSearchDomain, d1> r158 = r156.e;
        MentionSearchDomain r159 = MentionSearchDomain.CONVERSATION;
        d1 r160 = r158.get(r159);
        if (r160 != null) goto L168;
    L170:
        boolean r161 = false;
    L171:
        c r162 = v(this, r157, r161, r155);
        String r163 = AppHost.a.getApplication().getString(2131897987);
        List r164 = r162.a;
        MentionPanelSection r165 = MentionPanelSection.CONVERSATION;
        if (r162.b == false) goto L174;
        MentionSearchDomain r166 = r159;
    L175:
        f(this, r132, r163, r164, r165, r166, false, 16);
        goto L213
    L174:
        r166 = null;
        goto L175
    L168:
        if (r160.a != true) goto L170;
        r161 = true;
    L213:
        r19 = CollectionsKt.build(r132);
        goto L214
    L160:
        r154 = null;
        goto L161
    L154:
        if (r148.a != true) goto L156;
        r149 = true;
        goto L157
    L162:
        r155 = 4;
        goto L164
    L134:
        r131 = null;
        goto L135
    L128:
        if (r126.a != true) goto L130;
        r127 = true;
        goto L131
    L176:
        r132 = r109;
        if (this.v == true) goto L179;
        List r167 = CollectionsKt.filterNotNull(this.u.b);
        List r168 = CollectionsKt.take(r167, 5);
        MentionPanelSection r169 = MentionPanelSection.CONTACT;
        MentionSearchDomain r170 = MentionSearchDomain.CONTACT;
        if (r167.size() <= 5) goto L193;
        boolean r171 = true;
    L194:
        if (r171 == false) goto L196;
        MentionSearchDomain r172 = r170;
    L197:
        d(this, r132, r168, r169, r172, false, 8);
        if (this.L == false) goto L208;
        List r173 = CollectionsKt.filterNotNull(this.u.c);
        String r174 = k();
        List r175 = CollectionsKt.take(r173, 5);
        MentionPanelSection r176 = MentionPanelSection.GROUP;
        MentionSearchDomain r177 = MentionSearchDomain.GROUP;
        if (r173.size() <= 5) goto L202;
        boolean r178 = true;
    L203:
        if (r178 == false) goto L205;
        MentionSearchDomain r179 = r177;
    L206:
        f(this, r132, r174, r175, r176, r179, false, 16);
        goto L208
    L205:
        r179 = null;
        goto L206
    L202:
        r178 = false;
    L208:
        if (this.M == false) goto L211;
        f(this, r132, AppHost.a.getApplication().getString(2131906707), this.u.a, null, null, false, 28);
    L211:
        if (this.N == false) goto L213;
        f(this, r132, AppHost.a.getApplication().getString(2131897987), this.u.d, null, null, false, 28);
        goto L213
    L196:
        r172 = null;
        goto L197
    L193:
        r171 = false;
        goto L194
    L179:
        if (this.K == false) goto L182;
        e(r132, AppHost.a.getApplication().getString(2131906705));
    L182:
        if (this.L == false) goto L185;
        e(r132, k());
    L185:
        if (this.M == false) goto L188;
        e(r132, AppHost.a.getApplication().getString(2131906707));
    L188:
        if (this.N == false) goto L213;
        e(r132, AppHost.a.getApplication().getString(2131897987));
        goto L213
    L123:
        r121 = false;
        goto L124
    L115:
        if (this.I == false) goto L120;
        AppHost.Companion r180 = AppHost.a;
        String r181 = r180.getApplication().getString(2131900535);
        String r182 = r180.getApplication().getString(2131908357);
        String r183 = r180.getApplication().getString(2131898815);
        r109.add(new y.a(r180.getApplication().getString(2131906726)));
        r109.add(new y.d(r181, new h0(MemoryActionTag.MEMORY_ACTION_TAG_ADD, "category", r181), null, null, null, null, 2131242482, null, null, null, null, null, null, null, null, new p(this), 131004));
        r109.add(new y.d(r182, new h0(MemoryActionTag.MEMORY_ACTION_TAG_ADD, "category", r182), null, null, null, null, 2131242472, null, null, null, null, null, null, null, null, new q(this), 131004));
        r109.add(new y.d(r183, new h0(MemoryActionTag.MEMORY_ACTION_TAG_ADD, "category", r183), null, null, null, null, 2131242498, null, null, null, null, null, null, null, null, new r(this), 131004));
        if (this.i == false) goto L119;
        String r184 = r180.getApplication().getString(2131906731);
        r109.add(new y.d(r184, new h0(MemoryActionTag.MEMORY_ACTION_TAG_ADD, "category", r184), null, null, null, null, 2131242818, null, null, null, null, null, null, null, null, new s(this), 131004));
    L119:
        String r185 = r180.getApplication().getString(2131906669);
        r109.add(new y.d(r185, new h0(MemoryActionTag.MEMORY_ACTION_TAG_ADD, "category", r185), null, null, null, null, 2131242817, null, null, null, null, null, null, null, null, new t(this), 131004));
        goto L120
    L112:
        r120 = false;
        goto L113
    L97:
        if (this.w != SearchState.CONTACT_READY_WAITING_REFERENCES) goto L109;
        List r186 = CollectionsKt.createListBuilder();
        f0 r187 = this.u;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r188 = r187.b;
        Map<MentionSearchDomain, d1> r189 = r187.e;
        MentionSearchDomain r190 = MentionSearchDomain.CONTACT;
        d1 r191 = r189.get(r190);
        if (r191 != null) goto L101;
    L103:
        boolean r192 = false;
    L104:
        c r193 = u(r188, 3, r192, false);
        List r194 = r193.a;
        MentionPanelSection r195 = MentionPanelSection.CONTACT;
        if (r193.b == false) goto L107;
        MentionSearchDomain r196 = r190;
    L108:
        c(r186, r194, r195, r196, true);
        r19 = CollectionsKt.build(r186);
        goto L214
    L107:
        r196 = null;
        goto L108
    L101:
        if (r191.a != true) goto L103;
        r192 = true;
        goto L104
    L94:
        r108 = false;
        goto L95
    L84:
        r106 = false;
    L58:
        r16 = true;
        goto L60
    L50:
        if (this.x != Page.SKILL_DOMAIN) goto L52;
        r15 = true;
        goto L53
    L47:
        r12 = false;
        goto L48
    L43:
        r14 = false;
        goto L45
    L32:
        if (this.x == Page.REMOTE_DOMAIN) goto L34;
    L36:
        boolean r197 = false;
    L37:
        if (r197 == false) goto L39;
        r13 = r11;
        goto L41
    L34:
        if (l(r11) == false) goto L36;
        r197 = true;
        goto L37
    L22:
        Page r198 = this.x;
        if (r198 != Page.ROOT) goto L25;
    L28:
        r9 = this.E.update(this.D, r10, new k(this));
        goto L29
    L25:
        if (r198 == Page.SKILL_DOMAIN) goto L28;
        r9 = this.F;
        goto L29
    L19:
        r8 = false;
        goto L20
    }

    public final void r(MentionFilePickerType r3) {
        k1 r0 = this.n;
        if (r0 != null) goto L6;
        return;
    L6:
        if (((Boolean) this.m.invoke(r0)).booleanValue() == true) goto L8;
        return;
    L8:
        i();
        this.l.invoke();
        this.e.invoke(r3);
    }

    public final void s(com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r9) {
        k1 r0 = this.n;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r9.getType() != InputReferenceType.GROUP) goto L13;
        if (this.L == false) goto L11;
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.f() == true) goto L13;
        return;
    L11:
        return;
    L13:
        if (r9.getType() != InputReferenceType.SKILL) goto L19;
        if (((Boolean) this.g.invoke()).booleanValue() == true) goto L19;
        Context r1 = this.a.a.getContext();
        t19.s.j(t19.s.a, r1, r1.getString(2131900187), null, false, 28);
        return;
    L19:
        if (r9.getType() != InputReferenceType.ATTACHMENT) goto L41;
        Iterator<T> r2 = this.o.iterator();
    L22:
        if (r2.hasNext() == false) goto L37;
        Object r3 = r2.next();
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r5 = (com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r3;
        if (Intrinsics.areEqual(r5.a, r9.a) == false) goto L34;
        String r6 = r5.d;
        boolean r7 = true;
        if (r6 != null) goto L28;
    L31:
        boolean r8 = true;
    L32:
        if (r8 == true) goto L34;
    L35:
        if (r7 == false) goto L22;
    L38:
        r9 = (com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r3;
        if (r9 != null) goto L41;
        return;
    L28:
        if (StringsKt.isBlank(r6) == true) goto L31;
        r8 = false;
    L34:
        r7 = false;
        goto L35
    L37:
        r3 = null;
    L41:
        ChatInputWithMentionDelegate r4 = this.a;
        int r10 = r0.a;
        int r11 = r0.b;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.d0> r12 = CollectionsKt.listOf(r9);
        int r13 = ChatInputWithMentionDelegate.m;
        r4.j(r10, r11, r12, false);
        q();
        this.n = null;
        this.l.invoke();
    }

    public final void t(k1 r19) {
        Intrinsics.checkNotNullParameter(r19, "queryRange");
        gc8.b r1 = this.G;
        if (r1 == null) goto L5;
        r1.c();
    L5:
        boolean r9 = false;
        if (this.n != null) goto L8;
        this.P.c = false;
    L8:
        this.n = r19;
        ArrayList r11 = null;
        if (this.H == true) goto L30;
        be8.a r2 = (be8.a) this.f.invoke();
        if (r2 == null) goto L30;
        this.H = true;
        List r3 = r2.iH();
        if ((!r3.isEmpty()) == true) goto L18;
        r3 = null;
    L18:
        if (r3 == null) goto L26;
        HashSet r4 = new HashSet();
        ArrayList r5 = new ArrayList();
        Iterator r6 = r3.iterator();
    L21:
        if (r6.hasNext() == false) goto L25;
        Object r7 = r6.next();
        if (r4.add(((be8.b) r7).a) == false) goto L21;
        r5.add(r7);
        goto L21
    L25:
        this.D = r5;
    L26:
        long r8 = this.C;
        String r10 = AccountService.a.getUserId();
        Job r12 = this.r;
        if (r12 == null) goto L29;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L29:
        this.r = BuildersKt.launch$default(this.b, null, null, new MentionPanelController$refreshSkillsIfNeeded$3(r2, r8, this, r10, null), 3, null);
    L30:
        String r13 = StringsKt.trim(r19.c).toString();
        if (Intrinsics.areEqual(this.t, r13) == false) goto L33;
        p(r19);
        return;
    L33:
        Job r14 = this.q;
        if (r14 == null) goto L36;
        Job.DefaultImpls.cancel$default(r14, null, 1, null);
    L36:
        Job r15 = this.p;
        if (r15 == null) goto L39;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
    L39:
        q();
        long r16 = this.B + 1;
        this.B = r16;
        this.t = r13;
        if (this.O == true) goto L49;
        this.u = new f0(null, null, null, null, 31);
        this.v = false;
        if (r13.length() != 0) goto L44;
        r9 = true;
    L44:
        if (r9 == false) goto L46;
        SearchState r17 = SearchState.IDLE;
    L47:
        this.w = r17;
        p(r19);
        return;
    L46:
        r17 = SearchState.READY;
        goto L47
    L49:
        if (r13.length() != 0) goto L51;
        boolean r18 = true;
    L52:
        if (r18 == false) goto L86;
        MentionRecommendStore.a.getClass();
        String r20 = AccountService.a.getUserId();
        Object r21 = MentionRecommendStore.e;
        monitor-enter(r21);
        MentionRecommendStore.a r22 = MentionRecommendStore.f;     // Catch: Throwable -> L83
        if (r22 == null) goto L60;
        if (Intrinsics.areEqual(r22.a, r20) == false) goto L60;
    L61:
        monitor-exit(r21);
        if (r22 == null) goto L64;
        f0 r23 = r22.b;
    L81:
        if (r23 == null) goto L86;
        f0 r24 = j(r23);
    L88:
        if (r13.length() != 0) goto L90;
        boolean r25 = true;
    L91:
        if (r25 == false) goto L113;
        FLogger r26 = FLogger.a;
        StringBuilder r27 = new StringBuilder("[load] recommend cached=");
        if (r24 == null) goto L95;
        boolean r110 = true;
    L96:
        r27.append(r110);
        r27.append(", cachedContacts=");
        if (r24 == null) goto L112;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r111 = r24.b;
        if (r111 == null) goto L112;
        ArrayList r112 = new ArrayList();
        Iterator<T> r113 = r111.iterator();
    L102:
        if (r113.hasNext() == false) goto L111;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c r114 = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c) r113.next();
        if (r114 == null) goto L108;
        qp8.c r115 = r114.a;
        if (r115 == null) goto L108;
        String r116 = r115.a;
    L109:
        if (r116 == null) goto L102;
        r112.add(r116);
    L108:
        r116 = null;
        goto L109
    L111:
        r11 = r112;
    L112:
        r27.append(r11);
        r26.i("MentionPanelController", r27.toString());
        goto L113
    L95:
        r110 = false;
    L113:
        if (r24 != null) goto L115;
        f0 r28 = new f0(null, null, null, null, 31);
    L116:
        this.u = r28;
        if (r13.length() != 0) goto L119;
        boolean r29 = true;
    L120:
        if (r29 == false) goto L123;
        if (r24 != null) goto L123;
        boolean r30 = true;
    L124:
        this.v = r30;
        if (r13.length() != 0) goto L127;
        r9 = true;
    L127:
        if (r9 == false) goto L129;
        SearchState r31 = SearchState.IDLE;
    L130:
        this.w = r31;
        p(r19);
        this.p = BuildersKt.launch$default(this.b, null, null, new MentionPanelController$load$2(r13, this, r16, r24, null), 3, null);
        return;
    L129:
        r31 = SearchState.FULL_LOADING;
    L123:
        r30 = false;
        goto L124
    L119:
        r29 = false;
        goto L120
    L115:
        r28 = r24;
        goto L116
    L90:
        r25 = false;
        goto L91
    L64:
        f0 r32 = MentionRecommendStore.c(r20);
        if (r32 == null) goto L80;
        monitor-enter(r21);
        MentionRecommendStore.a r33 = MentionRecommendStore.f;     // Catch: Throwable -> L77
        if (r33 == null) goto L70;
        String r34 = r33.a;     // Catch: Throwable -> L77
    L72:
        if (Intrinsics.areEqual(r34, r20) == true) goto L74;
        MentionRecommendStore.f = new MentionRecommendStore.a(r20, r32);     // Catch: Throwable -> L77
    L74:
        Unit r35 = Unit.INSTANCE;     // Catch: Throwable -> L77
        monitor-exit(r21);
        r23 = r32;
        goto L81
    L70:
        r34 = null;
    L77:
        th = move-exception;
        throw th;
    L80:
        r23 = null;
    L60:
        r22 = null;
    L83:
        th = move-exception;
        throw th;
    L86:
        r24 = null;
        goto L88
    L51:
        r18 = false;
        goto L52
    }

    public static void e(List r1, String r2) {
        r1.add(new y.a(r2));
        int r3 = 0;
    L4:
        if (r3 >= 5) goto L6;
        r1.add(y.b.a);
        r3 = r3 + 1;
        goto L4
    }

    public final k1 h(String r6, long r7) {
        k1 r0 = this.n;
        if (r0 == null) goto L15;
        if (Intrinsics.areEqual(this.t, r6) == true) goto L7;
    L11:
        boolean r8 = false;
    L12:
        if (r8 == false) goto L15;
        return r0;
    L7:
        if (this.B != r7) goto L11;
        if (Intrinsics.areEqual(StringsKt.trim(r0.c).toString(), r6) == false) goto L11;
        r8 = true;
    L15:
        return null;
    }

    public static final Object a(MentionPanelController r4, Function1 r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof MentionPanelController$loadCatching$1) == false) goto L7;
        MentionPanelController$loadCatching$1 r0 = (MentionPanelController$loadCatching$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L19 CancellationException -> L22
    L24:
    L21:
        return r7;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;     // Catch: Throwable -> L19 CancellationException -> L22
        r7 = r5.invoke(r0);     // Catch: Throwable -> L19 CancellationException -> L22
        if (r7 != r8) goto L24;
        return r8;
    L22:
        e = move-exception;
        throw e;
    L19:
        r7 = null;
    L7:
        r0 = new MentionPanelController$loadCatching$1(r4, r6);
        goto L8
    }

    public final void b(List<y> r12, String r13, boolean r14) {
        if (this.J == true) goto L5;
        return;
    L5:
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.d0> r0 = this.o;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L30;
        Object r4 = r2.next();
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r5 = (com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r4;
        String r6 = r5.d;
        if (r6 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
    L28:
        if (r3 == false) goto L6;
        r1.add(r4);
        goto L6
    L17:
        if (r13.length() != 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L22;
    L25:
        boolean r9 = true;
    L26:
        if (r9 == false) goto L28;
        r3 = true;
        goto L28
    L22:
        if (StringsKt.contains(r5.b, r13, true) == true) goto L25;
        r9 = false;
        goto L26
    L19:
        r8 = false;
        goto L20
    L11:
        if (StringsKt.isBlank(r6) == true) goto L14;
        r7 = false;
        goto L15
    L30:
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r10 = r1.iterator();
    L32:
        if (r10.hasNext() == false) goto L34;
        r15.add(new c1((com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r10.next(), null, null, 6));
        goto L32
    L34:
        c r11 = v(this, r15, false, 2);
        List r16 = r15;
        if (r14 == true) goto L38;
        r16 = r11.a;
    L38:
        List r17 = r16;
        f(this, r12, AppHost.a.getApplication().getString(2131906688), r17, MentionPanelSection.ATTACHMENT, null, false, 24);
        if (r14 == false) goto L41;
        return;
    L41:
        if (r11.b == false) goto L51;
        r12.add(new y.c(this.P.b("attachment"), null, null, new MentionPanelController$addAttachmentSection$1(this)));
        return;
    }

    public final void g(List<y> r29, String r30, boolean r31) {
        if (r30.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        s1 r3 = this.F;
        if (r3 != null) goto L12;
        e(r29, AppHost.a.getApplication().getString(2131906731));
        return;
    L12:
        List<t1> r6 = r3.a;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L17;
        r7.add(((t1) r8.next()).a);
        goto L14
    L17:
        if (r7.isEmpty() == false) goto L19;
        return;
    L19:
        c r4 = v(this, r7, false, 6);
        Iterable r9 = r7;
        if (r31 == true) goto L23;
        r9 = r4.a;
    L23:
        boolean r10 = v19.h.a;
        boolean r11 = v19.h.b(this.a.a.getContext());
        r29.add(new y.a(AppHost.a.getApplication().getString(2131906731)));
        Iterator r5 = r9.iterator();
    L24:
        g0 r12 = null;
        if (r5.hasNext() == false) goto L33;
        final be8.b r13 = (be8.b) r5.next();
        String r14 = r13.b;
        h0 r15 = new h0("skill", "item", r14);
        String r16 = r13.a;
        if ((!StringsKt.isBlank(r16)) == true) goto L30;
        r16 = null;
    L30:
        if (r16 == null) goto L32;
        r12 = new g0(MentionPanelSection.SKILL, r16);
    L32:
        String r17 = r13.d;
        LinkedHashMap r18 = (LinkedHashMap) r3.c;
        b2.b r19 = b2.a;
        r29.add(new y.d(r14, r15, r12, null, r17, (t1) r18.get(r13.a), 2131242818, b2.b(r13.a, r11), null, null, null, null, null, null, null, new x(this, r13), 130824));
        goto L24
    L33:
        if (r31 == false) goto L35;
        return;
    L35:
        if (r4.b == false) goto L43;
        r29.add(new y.c(this.P.b("skill"), null, null, new MentionPanelController$addSkillSection$2(this)));
        return;
    L43:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static c u(List r1, int r2, boolean r3, boolean r4) {
        List r5 = CollectionsKt.filterNotNull(r1);
        if (r3 == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        List r7 = r5;
        if (r6 == true) goto L14;
        r2 = r2 + (r4 ? 1 : 0);
    L14:
        return new c(CollectionsKt.take(r7, r2), r6);
    L5:
        if (r5.size() > (r2 + (r4 ? 1 : 0))) goto L8;
        r6 = false;
        goto L9
    }

    public static /* synthetic */ c v(MentionPanelController r2, List r3, boolean r4, int r5) {
        boolean r1 = false;
        if ((r5 & 2) == 0) goto L6;
        r4 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r1 = true;
    L8:
        r2.getClass();
        return u(r3, 5, r4, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(List<y> r27, List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r28, MentionPanelSection r29, final MentionSearchDomain r30, boolean r31) {
        if (this.K == true) goto L5;
        return;
    L5:
        List r4 = CollectionsKt.filterNotNull(r28);
        if (r4.isEmpty() == false) goto L10;
        if (r30 != null) goto L10;
        if (r31 == true) goto L10;
        return;
    L10:
        r27.add(new y.a(AppHost.a.getApplication().getString(2131906705)));
        Iterator r5 = r4.iterator();
    L11:
        String r6 = null;
        if (r5.hasNext() == false) goto L30;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c r7 = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c) r5.next();
        final qp8.c r8 = r7.a;
        String r9 = r8.b;
        h0 r10 = new h0("contact", "item", r9);
        if (r29 == null) goto L21;
        String r11 = r8.a;
        if ((!StringsKt.isBlank(r11)) == true) goto L19;
        r11 = null;
    L19:
        if (r11 == null) goto L21;
        g0 r12 = new g0(r29, r11);
    L22:
        String r13 = r8.d;
        List<String> r14 = r7.b;
        if (r14 == null) goto L25;
        List r15 = CollectionsKt.filterNotNull(r14);
    L27:
        if (StringsKt.isBlank(r8.c) == false) goto L29;
        r6 = "@";
    L29:
        t1 r16 = null;
        Object[] r17 = 0 == true ? 1 : 0;
        Object[] r18 = 0 == true ? 1 : 0;
        r27.add(new y.d(r9, r10, r12, r15, r13, r16, null, r17, r6, r18, null, null, null, r8.c, r8.a, new v(this, r8), 106144));
        goto L11
    L25:
        r15 = null;
    L21:
        r12 = null;
        goto L22
    L30:
        if (r30 == null) goto L36;
        r27.add(new y.c(this.P.b(n0.a(r30)), null, null, new w(this, r30)));
        return;
    }

    public static /* synthetic */ void d(MentionPanelController r8, List r9, List r10, MentionPanelSection r11, MentionSearchDomain r12, boolean r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        MentionPanelSection r5 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        MentionSearchDomain r6 = null;
    L11:
        if ((r14 & 8) == 0) goto L13;
        boolean r7 = false;
    L14:
        r8.c(r9, r10, r5, r6, r7);
        return;
    L13:
        r7 = r13;
        goto L14
    L9:
        r6 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public static void f(final MentionPanelController r28, List r29, String r30, List r31, MentionPanelSection r32, MentionSearchDomain r33, boolean r34, int r35) {
        if ((r35 & 4) == 0) goto L5;
        MentionPanelSection r2 = null;
    L7:
        if ((r35 & 8) == 0) goto L9;
        MentionSearchDomain r4 = null;
    L10:
        char r6 = 0;
        if ((r35 & 16) == 0) goto L13;
        boolean r5 = false;
    L14:
        r28.getClass();
        List r7 = CollectionsKt.filterNotNull(r31);
        if (r7.isEmpty() == false) goto L19;
        if (r4 != null) goto L19;
        if (r5 == true) goto L19;
        return;
    L19:
        r29.add(new y.a(r30));
        Iterator r8 = r7.iterator();
    L21:
        if (r8.hasNext() == false) goto L89;
        c1 r9 = (c1) r8.next();
        final com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r10 = r9.a;
        String r11 = r10.b;
        InputReferenceType r12 = r10.getType();
        Intrinsics.checkNotNullParameter(r12, "<this>");
        switch(n0.a.a[r12.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            default: goto L25;
        };
    L26:
        String r13 = "conversation";
    L32:
        h0 r14 = new h0(r13, "item", r10.b);
        if (r2 == null) goto L40;
        String r15 = r10.a;
        if ((!StringsKt.isBlank(r15)) == true) goto L38;
        r15 = null;
    L38:
        if (r15 == null) goto L40;
        g0 r16 = new g0(r2, r15);
    L41:
        List<String> r17 = r9.b;
        if (r17 == null) goto L44;
        List r18 = CollectionsKt.filterNotNull(r17);
    L45:
        Long r19 = r9.c;
        if (r19 == null) goto L68;
        long r110 = r19.longValue();
        MentionSearchDomain r36 = r4;
        long r3 = System.currentTimeMillis();
        Calendar r20 = Calendar.getInstance();
        r20.setTimeInMillis(r110 * 1000);
        Calendar r111 = Calendar.getInstance();
        r111.setTimeInMillis(r3);
        Calendar r112 = Calendar.getInstance();
        r112.setTimeInMillis(r3);
        r112.add(6, -1);
        StringCompanionObject r21 = StringCompanionObject.INSTANCE;
        Locale r22 = Locale.ROOT;
        Object[] r23 = new Object[2];
        r23[r6] = Integer.valueOf(r20.get(11));
        r23[1] = Integer.valueOf(r20.get(12));
        String r24 = String.format(r22, "%02d:%02d", Arrays.copyOf(r23, 2));
        int r25 = r20.get(2) + 1;
        int r26 = r20.get(5);
        Intrinsics.checkNotNull(r20);
        Intrinsics.checkNotNull(r111);
        MentionPanelSection r27 = r2;
        Iterator r37 = r8;
        if (r20.get(1) == r111.get(1)) goto L50;
    L52:
        boolean r38 = false;
    L54:
        if (r38 == false) goto L56;
        String r39 = AppHost.a.getApplication().getString(2131897945) + ' ' + r24;
    L69:
        if (r39 != null) goto L71;
        r39 = "";
    L71:
        String r113 = r39;
        Integer r114 = com.larus.bmhome.chat.component.bottom.core.inputtext.k0.c(r10.getType());
        if (r10.getType() != InputReferenceType.CONTACT) goto L74;
    L77:
        String r115 = "@";
    L78:
        String r40 = r10.i;
        String r41 = r10.j;
        String r42 = r10.e;
        com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r43 = r10.f;
        com.larus.bmhome.chat.referenceicon.b r44 = r10.h;
        String r45 = r10.a;
        if (r10.getType() == InputReferenceType.CONVERSATION) goto L81;
    L83:
        boolean r46 = false;
    L85:
        if (Boolean.valueOf(r46).booleanValue() == false) goto L87;
        String r210 = r45;
    L88:
        r29.add(new y.d(r11, r14, r16, r18, r113, null, r114, null, r115, r42, r43, r44, r210, r40, r41, new l(r28, r10), 98464));
        r4 = r36;
        r8 = r37;
        r2 = r27;
        r6 = 0;
        goto L21
    L87:
        r210 = null;
        goto L88
    L81:
        if ((!StringsKt.isBlank(r10.a)) == false) goto L83;
        r46 = true;
        goto L85
    L74:
        if (r10.getType() == InputReferenceType.GROUP) goto L77;
        r115 = null;
        goto L78
    L56:
        Intrinsics.checkNotNull(r112);
        if (r20.get(1) == r112.get(1)) goto L59;
    L61:
        boolean r47 = false;
    L62:
        if (r47 == false) goto L65;
        r39 = AppHost.a.getApplication().getString(2131897946) + ' ' + r24;
        goto L69
    L65:
        if (r20.get(1) != r111.get(1)) goto L67;
        StringBuilder r48 = new StringBuilder();
        r48.append(r25);
        AppHost.Companion r49 = AppHost.a;
        r48.append(r49.getApplication().getString(2131907418));
        r48.append(r26);
        r48.append(r49.getApplication().getString(2131907415));
        r48.append(' ');
        r48.append(r24);
        r39 = r48.toString();
        goto L69
    L67:
        StringBuilder r50 = new StringBuilder();
        r50.append(r20.get(1));
        AppHost.Companion r51 = AppHost.a;
        r50.append(r51.getApplication().getString(2131907424));
        r50.append(r25);
        r50.append(r51.getApplication().getString(2131907418));
        r50.append(r26);
        r50.append(r51.getApplication().getString(2131907415));
        r50.append(' ');
        r50.append(r24);
        r39 = r50.toString();
        goto L69
    L59:
        if (r20.get(6) != r112.get(6)) goto L61;
        r47 = true;
        goto L62
    L50:
        if (r20.get(6) != r111.get(6)) goto L52;
        r38 = true;
        goto L54
    L68:
        r27 = r2;
        r36 = r4;
        r37 = r8;
        r39 = null;
        goto L69
    L44:
        r18 = null;
    L40:
        r16 = null;
        goto L41
    L27:
        r13 = "cloud_doc";
        goto L32
    L28:
        r13 = "skill";
        goto L32
    L29:
        r13 = "attachment";
        goto L32
    L30:
        r13 = "group_chat";
        goto L32
    L31:
        r13 = "contact";
        goto L32
    L25:
        throw new NoWhenBranchMatchedException();
    L89:
        final MentionSearchDomain r310 = r4;
        if (r310 == null) goto L97;
        r29.add(new y.c(r28.P.b(n0.a(r310)), null, null, new m(r28, r310)));
        return;
    L97:
        return;
    L13:
        r5 = r34;
        goto L14
    L9:
        r4 = r33;
        goto L10
    L5:
        r2 = r32;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.activity.OnBackPressedCallback, com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$backCallback$1] */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.mention.n] */
    public MentionPanelController(ChatInputWithMentionDelegate r22, CoroutineScope r23, Fragment r24, q0 r25, qp8.e r26, Function1 r27, Function0 r28, Function0 r29, Function0 r30, boolean r31, Set r32, com.larus.bmhome.chat.component.bottom.core.inputtext.u0 r33, com.larus.bmhome.chat.component.bottom.core.inputtext.v0 r34, Function1 r35, SkillSearchIndex r36) {
        Intrinsics.checkNotNullParameter(r22, "inputDelegate");
        Intrinsics.checkNotNullParameter(r23, "coroutineScope");
        Intrinsics.checkNotNullParameter(r24, "hostFragment");
        Intrinsics.checkNotNullParameter(r25, "panelView");
        Intrinsics.checkNotNullParameter(r26, "officeMentionConfig");
        Intrinsics.checkNotNullParameter(r27, "onSelectFile");
        Intrinsics.checkNotNullParameter(r28, "skillAbilityProvider");
        Intrinsics.checkNotNullParameter(r29, "switchToTaskModeIfNeeded");
        Intrinsics.checkNotNullParameter(r30, "onSwitchToSkillPanel");
        Intrinsics.checkNotNullParameter(r32, "enabledContents");
        Intrinsics.checkNotNullParameter(r33, "onPanelVisibilityChanged");
        Intrinsics.checkNotNullParameter(r34, "onQueryFinished");
        Intrinsics.checkNotNullParameter(r35, "onConsumeQuery");
        Intrinsics.checkNotNullParameter(r36, "skillSearchIndex");
        this.a = r22;
        this.b = r23;
        this.c = r25;
        this.d = r26;
        this.e = r27;
        this.f = r28;
        this.g = r29;
        this.h = r30;
        this.i = r31;
        this.j = r32;
        this.k = r33;
        this.l = r34;
        this.m = r35;
        this.o = CollectionsKt.emptyList();
        this.u = new f0(null, null, null, null, 31);
        this.w = SearchState.IDLE;
        this.x = Page.ROOT;
        this.D = CollectionsKt.emptyList();
        this.E = new SkillPanelSearch(r22.a.getContext(), r23, r36);
        int r2 = gc8.a.a;
        LifecycleOwner r3 = r24.getViewLifecycleOwner();
        MentionPanelController$conversationIconSession$1 r6 = new MentionPanelController$conversationIconSession$1(r25);
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "onIconsChanged");
        ISideBarConversationIconService r7 = (ISideBarConversationIconService) ServiceManager.get().getService(ISideBarConversationIconService.class);
        if (r7 == null) goto L5;
        SideBarConversationIconSessionImpl r4 = r7.a(r3, r6);
    L6:
        this.G = r4;
        this.I = r32.contains(MentionPanelContent.ADD);
        this.J = r32.contains(MentionPanelContent.ATTACHMENT);
        boolean r8 = false;
        if (r32.contains(MentionPanelContent.CONTACT) == false) goto L11;
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.f() == false) goto L11;
        boolean r5 = true;
    L12:
        this.K = r5;
        this.L = r5;
        boolean r9 = r32.contains(MentionPanelContent.DRIVE);
        this.M = r9;
        boolean r10 = r32.contains(MentionPanelContent.CONVERSATION);
        this.N = r10;
        if (r5 == true) goto L16;
        if (r9 == true) goto L16;
        if (r10 == true) goto L16;
    L17:
        this.O = r8;
        this.P = new m0(r22.a.getContext(), new n(this));
        ?? r1 = new MentionPanelController$backCallback$1(this);
        this.Q = r1;
        r24.requireActivity().getOnBackPressedDispatcher().addCallback(r24, r1);
        Function1<? super String, ? extends gc8.c> r11 = new o(this);
        Intrinsics.checkNotNullParameter(r11, "provider");
        MentionPanelListView r12 = r25.a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "provider");
        r12.r = r11;
        if (r8 == true) goto L20;
        return;
    L20:
        if ((!StringsKt.isBlank((CharSequence) r26.d.invoke())) == false) goto L24;
        MentionRecommendStore.a.getClass();
        Intrinsics.checkNotNullParameter(r26, "config");
        MentionRecommendStore.f(r26, r5);
        return;
    L24:
        return;
    L16:
        r8 = true;
    L11:
        r5 = false;
        goto L12
    L5:
        r4 = null;
        goto L6
    }
}
