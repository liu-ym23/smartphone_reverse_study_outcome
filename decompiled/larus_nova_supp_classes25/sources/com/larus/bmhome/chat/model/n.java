package com.larus.bmhome.chat.model;

import android.os.Looper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hq9.a4;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements j1, t1a.c {
    public volatile String a;
    public volatile String b;
    public volatile String c;
    public volatile boolean d;
    public boolean e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public String j;
    public String k;
    public boolean l;
    public b m;
    public final Map<String, Pair<String, String>> n;
    public final Lazy o;
    public volatile List<ChatDraftItem> p;
    public boolean q;

    public static final class a {
    }

    public static final class b {
        public final Long a;
        public final String b;
        public final Map<String, List<ChatDraftItem>> c;
        public String d;
        public String e;
        public String f;
        public List<ChatDraftItem> g;
        public Long h;

        public final String a() {
            Long r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.toString();
        }

        public b(Long r1, String r2) {
            this.a = r1;
            this.b = r2;
            this.c = new LinkedHashMap();
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/model/ChatDraft$getObricSkillIdsDraft$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class c extends TypeToken<List<? extends String>> {
        public c() {
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final ChatDraftItem d() {
        Iterator<T> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r1).getType(), ChatDraftItem.TYPE_NESTED_FILE) == false) goto L4;
    L9:
        ChatDraftItem r2 = (ChatDraftItem) r1;
        FLogger.a.d("ChatDraft", "getNestedFileTypeDraft nestedFileTypeChatDraftItem:" + r2);
        return r2;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final ChatDraftItem f() {
        Iterator<T> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r1).getType(), ChatDraftItem.TYPE_SUGGESTED_ACTION_OPERATIONS) == false) goto L4;
    L9:
        ChatDraftItem r2 = (ChatDraftItem) r1;
        FLogger.a.d("ChatDraft", "getSuggestedActionOperationsDraftItem suggestedActionChatDraftItem:" + r2);
        return r2;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final void h() {
        if (this.d == false) goto L5;
        return;
    L5:
        FLogger.a.d("ChatDraft", "deleteSuggestedActionOperationsDraftItem");
        List<ChatDraftItem> r0 = this.p;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if ((true ^ Intrinsics.areEqual(((ChatDraftItem) r3).getType(), ChatDraftItem.TYPE_SUGGESTED_ACTION_OPERATIONS)) == false) goto L7;
        r1.add(r3);
        goto L7
    L11:
        this.p = CollectionsKt.toMutableList(r1);
        A(this, false, false, null, 15);
        this.q = true;
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final void i() {
        if (this.d == false) goto L5;
        return;
    L5:
        FLogger.a.d("ChatDraft", "deleteNestedFileTypeDraft");
        List<ChatDraftItem> r0 = this.p;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L16;
        Object r4 = r2.next();
        ChatDraftItem r5 = (ChatDraftItem) r4;
        if (Intrinsics.areEqual(r5.getType(), ChatDraftItem.TYPE_NESTED_FILE) == false) goto L11;
    L13:
        r3 = false;
    L14:
        if (r3 == false) goto L6;
        r1.add(r4);
        goto L6
    L11:
        if (Intrinsics.areEqual(r5.getType(), ChatDraftItem.TYPE_SUGGESTED_ACTION_OPERATIONS) == true) goto L13;
    L16:
        this.p = CollectionsKt.toMutableList(r1);
        this.q = true;
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final ChatDraftItem m() {
        Iterator<T> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r1).getType(), ChatDraftItem.TYPE_REPLY) == false) goto L4;
    L9:
        ChatDraftItem r2 = (ChatDraftItem) r1;
        FLogger.a.d("ChatDraft", "getReplyTypeDraft replyTypeChatDraftItem:" + r2);
        return r2;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final void n() {
        if (this.d == false) goto L5;
        return;
    L5:
        FLogger.a.d("ChatDraft", "deleteReplyTypeDraft");
        List<ChatDraftItem> r0 = this.p;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if ((true ^ Intrinsics.areEqual(((ChatDraftItem) r3).getType(), ChatDraftItem.TYPE_REPLY)) == false) goto L7;
        r1.add(r3);
        goto L7
    L11:
        this.p = CollectionsKt.toMutableList(r1);
        A(this, false, false, null, 15);
        this.q = true;
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final List<String> o() {
        return y(ChatDraftItem.TYPE_OBRIC_MENTION_SKILL_IDS);
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final boolean p() {
        return x.a.f(this.b, this.k);
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final void q() {
        if (this.d == false) goto L5;
        return;
    L5:
        FLogger.a.d("ChatDraft", "deleteTextChatDraftItem currentConversationId:" + this.a);
        j1.a.c(this, "", null, false, null, null, null, 60);
        w();
        this.q = true;
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final List<String> r() {
        return y(ChatDraftItem.TYPE_OBRIC_SELECTED_SKILL_IDS);
    }

    public final void v() {
        x r2 = x.a;
        String r3 = this.b;
        String r8 = this.k;
        Intrinsics.checkNotNullParameter(r8, "userId");
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L49;
        final Ref.LongRef r6 = new Ref.LongRef();
        final Ref.LongRef r7 = new Ref.LongRef();
        List<ChatDraftItem> r9 = r2.d(r3, r8, new s(r6, r7));
        if (r9.isEmpty() == true) goto L50;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L16:
        if (r11.hasNext() == false) goto L31;
        Object r12 = r11.next();
        ChatDraftItem r13 = (ChatDraftItem) r12;
        if (r13 != null) goto L21;
    L25:
        boolean r14 = true;
    L28:
        if ((!r14) == false) goto L16;
        r10.add(r12);
        goto L16
    L21:
        if (r13.getUpdateTime() <= 0) goto L25;
        long r15 = System.currentTimeMillis() - r13.getUpdateTime();
        ChatDraftItem.Companion.getClass();
        if (r15 >= ChatDraftItem.access$getDRAFT_EXPIRED_TIMTE$cp()) goto L25;
        r14 = false;
        goto L28
    L31:
        if (r10.size() == r9.size()) goto L40;
        FLogger.a.d("ChatDraftRepo", "deleteExpiredDraft conversationId:" + r3 + " oldDraftList:" + r9 + " newDraftList:" + r10);
        monitor-enter(r2);
        long r0 = Math.max(System.currentTimeMillis(), Math.max(x.g + 1, r6.element + 1));     // Catch: Throwable -> L37
        x.g = r0;     // Catch: Throwable -> L37
        monitor-exit(r2);
        x.i(r2, r3, r10, r0, false, r8, Long.valueOf(r6.element), r7.element, 8);
        return;
    L37:
        th = move-exception;
        throw th;
    L40:
        return;
    L50:
        return;
    L49:
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public final void w() {
        List<ChatDraftItem> r0 = this.p;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((true ^ Intrinsics.areEqual(((ChatDraftItem) r3).getType(), ChatDraftItem.TYPE_OBRIC_MENTION_SKILL_IDS)) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        this.p = CollectionsKt.toMutableList(r1);
        this.q = true;
    }

    public final ChatDraftItem x() {
        Iterator<T> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r1).getType(), ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) == false) goto L4;
    L9:
        ChatDraftItem r2 = (ChatDraftItem) r1;
        FLogger.a.d("ChatDraft", "getActionBarInstructionDraft actionBarInstructionDraftItem:" + r2);
        return r2;
    L8:
        r1 = null;
        goto L9
    }

    public final void z() {
        FLogger.a.i("ChatDraft", "loadChatDraftItemListFromRepo[start] currentDraftItemList");
        final Ref.LongRef r0 = new Ref.LongRef();
        final Ref.LongRef r1 = new Ref.LongRef();
        this.p = x.a.d(this.b, this.k, new j(r0, r1));
        Long r2 = Long.valueOf(r1.element);
        boolean r4 = true;
        if (r2.longValue() <= 0) goto L5;
        boolean r3 = true;
    L6:
        Long r5 = null;
        if (Boolean.valueOf(r3).booleanValue() == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        long r6 = r2.longValue();
    L25:
        this.f = r6;
        this.g = r6;
        Long r7 = Long.valueOf(r0.element);
        if (r7.longValue() <= 0) goto L28;
        boolean r8 = true;
    L29:
        if (r8 == true) goto L32;
        r7 = null;
    L32:
        if (r7 == null) goto L34;
        long r9 = r7.longValue();
    L43:
        this.h = r9;
        Iterator r10 = SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(this.p), new k()), new l()).iterator();
    L45:
        if (r10.hasNext() == false) goto L50;
        String r11 = (String) r10.next();
        Map<String, Pair<String, String>> r12 = this.n;
        String r13 = this.b;
        if (r13 != null) goto L49;
        r13 = "";
    L49:
        r12.put(r11, new Pair(r13, this.k));
        goto L45
    L50:
        x r14 = x.a;
        monitor-enter(r14);
        x.g = Math.max(x.g, this.h);     // Catch: Throwable -> L56
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L56
        monitor-exit(r14);
        FLogger.a.i("ChatDraft", "loadChatDraftItemListFromRepo[end] currentDraftItemList:" + this.p);
        return;
    L56:
        th = move-exception;
        throw th;
    L34:
        Long r16 = Long.valueOf(this.f);
        if (r16.longValue() > 0) goto L38;
        r4 = false;
    L38:
        if (r4 == false) goto L40;
        r5 = r16;
    L40:
        if (r5 == null) goto L42;
        r9 = r5.longValue();
        goto L43
    L42:
        r9 = System.currentTimeMillis();
        goto L43
    L28:
        r8 = false;
        goto L29
    L12:
        Iterator<T> r17 = this.p.iterator();
        if (r17.hasNext() == true) goto L15;
        Long r18 = null;
    L21:
        Long r19 = r18;
        if (r19 == null) goto L24;
        r6 = r19.longValue();
        goto L25
    L24:
        r6 = 0;
        goto L25
    L15:
        r18 = Long.valueOf(((ChatDraftItem) r17.next()).getUpdateTime());
    L17:
        if (r17.hasNext() == false) goto L21;
        Long r20 = Long.valueOf(((ChatDraftItem) r17.next()).getUpdateTime());
        if (r18.compareTo(r20) >= 0) goto L17;
        r18 = r20;
        goto L17
    L5:
        r3 = false;
        goto L6
    }

    public n() {
        this.a = "";
        this.b = "";
        this.h = System.currentTimeMillis();
        this.k = AccountService.a.getUserId();
        this.m = new b(null, null);
        this.n = new LinkedHashMap();
        this.o = LazyKt.lazy(new d());
        this.p = CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final int a() {
        ChatDraftItem r0 = x();
        if (r0 == null) goto L7;
        boolean r3 = true;
        if (z.a(r0) != true) goto L7;
    L8:
        if (r3 == true) goto L27;
        FLogger.a.d("ChatDraft", "getActionBarInstructionTypeDraft");
        return 0;
    L27:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        ouc.v r4 = xt7.d.b;     // Catch: Throwable -> L14
        juc.c r5 = com.larus.bmhome.actionbar.model.r.Companion.serializer();     // Catch: Throwable -> L14
        String r1 = r0.getContent();     // Catch: Throwable -> L14
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        Object r6 = Result.constructor-impl((com.larus.bmhome.actionbar.model.r) r4.c(r5, r1));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r6) == false) goto L19;
        r6 = null;
    L19:
        com.larus.bmhome.actionbar.model.r r7 = (com.larus.bmhome.actionbar.model.r) r6;
        if (r7 == null) goto L29;
        Integer r8 = r7.a;
        if (r8 != null) goto L24;
        return 0;
    L24:
        return r8.intValue();
    L29:
        return 0;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = false;
        goto L8
    }

    public final void B(String r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        if (Intrinsics.areEqual(this.k, r5) == true) goto L20;
        this.m = new b(null, null);
        if (this.l == true) goto L7;
        ((LinkedHashMap) this.n).clear();
        goto L20
    L7:
        if (x.f == false) goto L20;
        Iterator r0 = CollectionsKt.toList(((LinkedHashMap) this.n).keySet()).iterator();
    L10:
        if (r0.hasNext() == false) goto L20;
        String r1 = (String) r0.next();
        Pair r2 = (Pair) ((LinkedHashMap) this.n).get(r1);
        if (r2 == null) goto L10;
        String r3 = (String) r2.getFirst();
        if (r3 == null) goto L10;
        if (Intrinsics.areEqual(r3, this.b) == false) goto L10;
        this.n.put(r1, TuplesKt.to(r3, r5));
    L20:
        this.k = r5;
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final void b(boolean r7) {
        if (this.d == false) goto L5;
        return;
    L5:
        FLogger.a.d("ChatDraft", "deleteActionBarInstructionDraftItem");
        List<ChatDraftItem> r0 = this.p;
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((ChatDraftItem) r1.next()).getType(), ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) == false) goto L12;
        boolean r2 = false;
    L17:
        if (r2 == false) goto L19;
        return;
    L19:
        List<ChatDraftItem> r3 = this.p;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L21:
        if (r5.hasNext() == false) goto L25;
        Object r6 = r5.next();
        if ((!Intrinsics.areEqual(((ChatDraftItem) r6).getType(), ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION)) == false) goto L21;
        r4.add(r6);
        goto L21
    L25:
        this.p = CollectionsKt.toMutableList(r4);
        this.q = true;
        A(this, r7, r7, null, 12);
        return;
    L16:
        r2 = true;
        goto L17
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L10
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final void j(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "skillIds");
        F(ChatDraftItem.TYPE_OBRIC_SELECTED_SKILL_IDS, r2);
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final void k(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "skillIds");
        F(ChatDraftItem.TYPE_OBRIC_MENTION_SKILL_IDS, r2);
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final void l(String r14) {
        boolean r0 = false;
        if (r14 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        z2 r3 = z2.a;
        if (z2.c4() == false) goto L42;
        String r4 = this.b;
        if (r4 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == false) goto L26;
        this.j = r14;
        return;
    L26:
        Lazy r6 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        if (com.larus.im.j.f(r14) == false) goto L34;
        if (Intrinsics.areEqual(r4, "__mobile_new_session_mode_draft_chat__") == false) goto L31;
    L32:
        r0 = true;
        goto L34
    L31:
        if (Intrinsics.areEqual(r4, "__mobile_new_session_mode_draft_office__") == true) goto L32;
    L34:
        if (Intrinsics.areEqual(r14, r4) == true) goto L40;
        if (r0 == true) goto L40;
        x r1 = x.a;
        if (x.h(r14, r4, this.k) == false) goto L39;
        this.j = null;
        z();
        goto L40
    L39:
        this.j = r14;
    L40:
        this.d = true;
        return;
    L19:
        if (StringsKt.isBlank(r4) == true) goto L22;
        r5 = false;
    L42:
        FLogger.a.d("ChatDraft", "deleteAllChatDraftItem currentDraftStorageId:" + this.b);
        this.p = CollectionsKt.emptyList();
        z2 r15 = z2.a;
        if (z2.c4() == false) goto L45;
        A(this, false, false, null, 15);
    L46:
        this.q = true;
        return;
    L45:
        x.b(x.a, this.b, 0, false, this.k, null, null, 54);
        goto L46
    L12:
        if (this.d == false) goto L42;
        return;
    L5:
        if (StringsKt.isBlank(r14) == true) goto L8;
        r2 = false;
        goto L10
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final boolean u(ChatDraftItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return z.a(r2);
    }

    public final List<String> y(String r4) {
        Iterator<T> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r1).getType(), r4) == false) goto L4;
    L9:
        final ChatDraftItem r2 = (ChatDraftItem) r1;
        if (r2 == null) goto L12;
        final Type r5 = new c().getType();
        int r3 = com.larus.utils.l0.a;
        return (List) com.larus.utils.l0.a(CollectionsKt.emptyList(), new m(r2, r5));
    L12:
        return CollectionsKt.emptyList();
    L8:
        r1 = null;
        goto L9
    }

    public final void F(String r12, List<String> r13) {
        if (this.d == false) goto L5;
        return;
    L5:
        FLogger.a.d("ChatDraft", "updateObricSkillIdsDraftItem type:" + r12 + " size:" + r13.size());
        List<String> r14 = r13;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        r0.add(StringsKt.trim((String) r15.next()).toString());
        goto L7
    L9:
        ArrayList r16 = new ArrayList();
        Iterator r1 = r0.iterator();
    L10:
        boolean r2 = false;
        if (r1.hasNext() == false) goto L17;
        Object r3 = r1.next();
        if (((String) r3).length() <= 0) goto L15;
        r2 = true;
    L15:
        if (r2 == false) goto L10;
        r16.add(r3);
        goto L10
    L17:
        List r17 = CollectionsKt.distinct(r16);
        List<ChatDraftItem> r4 = this.p;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L19:
        if (r6.hasNext() == false) goto L23;
        Object r7 = r6.next();
        if ((!Intrinsics.areEqual(((ChatDraftItem) r7).getType(), r12)) == false) goto L19;
        r5.add(r7);
        goto L19
    L23:
        List<ChatDraftItem> r8 = CollectionsKt.toMutableList(r5);
        if ((!r17.isEmpty()) == false) goto L26;
        r8.add(ChatDraftItem.a.a(ChatDraftItem.Companion, r12, GsonProtectorUtils.toJson(new Gson(), r17), "", "", null, DoraCallStateCode.DOUBAO_CMD_12));
    L26:
        this.p = r8;
        this.q = true;
        A(this, false, false, null, 15);
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final void t(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "suggestedActionOperationsJson");
        if (this.d == false) goto L5;
        return;
    L5:
        FLogger.a.d("ChatDraft", "updateSuggestedActionOperationsDraftItem[" + r11 + "] content:" + r12);
        ChatDraftItem r13 = ChatDraftItem.a.a(ChatDraftItem.Companion, ChatDraftItem.TYPE_SUGGESTED_ACTION_OPERATIONS, r12, r11, null, null, 120);
        List<ChatDraftItem> r14 = this.p;
        ArrayList r0 = new ArrayList();
        Iterator<T> r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L11;
        Object r1 = r15.next();
        if ((true ^ Intrinsics.areEqual(((ChatDraftItem) r1).getType(), ChatDraftItem.TYPE_SUGGESTED_ACTION_OPERATIONS)) == false) goto L7;
        r0.add(r1);
        goto L7
    L11:
        List<ChatDraftItem> r16 = CollectionsKt.toMutableList(r0);
        r16.add(r13);
        this.p = r16;
        this.q = true;
        A(this, false, false, null, 15);
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final synchronized void c(String r9, String r10, Long r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "localMsgId");     // Catch: Throwable -> L52
        if (this.d == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<T> r0 = this.p.iterator();     // Catch: Throwable -> L52
    L8:
        Object r2 = null;
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();     // Catch: Throwable -> L52
        if (Intrinsics.areEqual(((ChatDraftItem) r1).getType(), ChatDraftItem.TYPE_NESTED_FILE) == false) goto L8;
    L14:
        ChatDraftItem r3 = (ChatDraftItem) r1;     // Catch: Throwable -> L52
        if (r3 == null) goto L50;
        NestedFileContent r4 = r3.getNestedFileContent();     // Catch: Throwable -> L52
        if (r4 == null) goto L50;
        List r5 = r4.getEntities();     // Catch: Throwable -> L52
        if (r5 == null) goto L50;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L52
    L23:
        if (r6.hasNext() == false) goto L28;
        Object r7 = r6.next();     // Catch: Throwable -> L52
        if (Intrinsics.areEqual(((UplinkFileEntity) r7).getFileIdentifier(), r10) == false) goto L23;
        r2 = r7;
    L28:
        if (((UplinkFileEntity) r2) != null) goto L31;
        monitor-exit(this);
        return;
    L31:
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L52
        Iterator r12 = r5.iterator();     // Catch: Throwable -> L52
    L33:
        if (r12.hasNext() == false) goto L37;
        Object r13 = r12.next();     // Catch: Throwable -> L52
        if ((!Intrinsics.areEqual(((UplinkFileEntity) r13).getFileIdentifier(), r10)) == false) goto L33;
        r8.add(r13);     // Catch: Throwable -> L52
        goto L33
    L37:
        List r14 = CollectionsKt.toMutableList(r8);     // Catch: Throwable -> L52
        NestedFileContent r15 = new NestedFileContent(r14, null, false, null, 14, null);     // Catch: Throwable -> L52
        z2 r16 = z2.a;     // Catch: Throwable -> L52
        if (E(r9, r15, false, z2.c4(), r11) == true) goto L40;
    L48:
        monitor-exit(this);
        return;
    L40:
        if (z2.c4() == false) goto L48;
        if (r14.isEmpty() == false) goto L44;
        this.n.remove(r9);     // Catch: Throwable -> L52
        goto L48
    L44:
        Map<String, Pair<String, String>> r17 = this.n;     // Catch: Throwable -> L52
        String r18 = this.b;     // Catch: Throwable -> L52
        if (r18 != null) goto L47;
        r18 = "";
    L47:
        r17.put(r9, new Pair(r18, this.k));     // Catch: Throwable -> L52
    L50:
        monitor-exit(this);
        return;
    L13:
        r1 = null;
    L52:
        th = move-exception;
        throw th;
    }

    public static boolean A(final n r31, boolean r32, boolean r33, Long r34, int r35) {
        if ((r35 & 1) == 0) goto L5;
        final boolean r14 = false;
    L7:
        if ((r35 & 2) == 0) goto L9;
        boolean r16 = false;
    L11:
        if ((r35 & 4) == 0) goto L13;
        final boolean r15 = true;
    L15:
        if ((r35 & 8) == 0) goto L17;
        Long r1 = null;
    L18:
        r31.getClass();
        z2 r3 = z2.a;
        final boolean r18 = z2.c4();
        if (r18 == true) goto L21;
        com.larus.utils.t0.a(new com.larus.bmhome.chat.model.b(r31));
    L63:
        return true;
    L21:
        AccountService r4 = AccountService.a;
        String r5 = r4.getUserId();
        if (r18 == true) goto L24;
    L31:
        if (r18 == false) goto L37;
        if (r14 == true) goto L37;
        if (r1 == null) goto L37;
        if (r1.longValue() >= r31.g) goto L37;
        return false;
    L37:
        final long r10 = r31.h;
        x r2 = x.a;
        monitor-enter(r2);
        if (r14 == true) goto L45;
        if (r1 == null) goto L43;
        long r6 = r1.longValue();     // Catch: Throwable -> L65
    L44:
        r31.g = Math.max(r31.g, r6);     // Catch: Throwable -> L65
        r31.f = Math.max(r6, r31.f + 1);     // Catch: Throwable -> L65
        goto L45
    L43:
        r6 = System.currentTimeMillis();     // Catch: Throwable -> L65
    L45:
        long r7 = Math.max(System.currentTimeMillis(), Math.max(r31.h + 1, x.g + 1));     // Catch: Throwable -> L65
        r31.h = r7;     // Catch: Throwable -> L65
        x.g = r7;     // Catch: Throwable -> L65
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L65
        monitor-exit(r2);
        if (r18 == false) goto L49;
        String r9 = r31.b;
    L50:
        final String r11 = r9;
        final long r12 = r31.h;
        final long r13 = r31.f;
        if (r18 == false) goto L53;
        String r17 = r31.k;
    L54:
        final String r19 = r17;
        List<ChatDraftItem> r20 = r31.p;
        final ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator<T> r22 = r20.iterator();
    L56:
        if (r22.hasNext() == false) goto L58;
        r21.add(ChatDraftItem.copy$default((ChatDraftItem) r22.next(), null, null, null, r13, null, null, null, null, 247, null));
        goto L56
    L58:
        r31.p = r21;
        final Ref.BooleanRef r23 = new Ref.BooleanRef();
        Runnable r110 = new com.larus.bmhome.chat.model.c(r11, r21, r23, r18, r31, r12, r19, r10, r13, r14, r15);
        if (r18 == false) goto L62;
        if (r16 == false) goto L62;
        r110.run();
        return r23.element;
    L62:
        com.larus.utils.t0.a(r110);
        goto L63
    L53:
        r17 = r4.getUserId();
        goto L54
    L49:
        r9 = r31.a;
    L65:
        th = move-exception;
        throw th;
    L24:
        if (Intrinsics.areEqual(r31.k, r5) == true) goto L31;
        if (r31.l == true) goto L28;
    L30:
        FLogger.a.w("ChatDraft", "ignore draft write after account changed");
        return false;
    L28:
        if (r4.isLogin().booleanValue() == false) goto L30;
        r31.B(r5);
        goto L31
    L17:
        r1 = r34;
        goto L18
    L13:
        r15 = false;
        goto L15
    L9:
        r16 = r33;
        goto L11
    L5:
        r14 = r32;
        goto L7
    }

    public final boolean E(String r16, NestedFileContent r17, boolean r18, boolean r19, Long r20) {
        List<ChatDraftItem> r1 = this.p;
        long r2 = this.f;
        long r4 = this.h;
        boolean r6 = this.q;
        ChatDraftItem r7 = ChatDraftItem.a.a(ChatDraftItem.Companion, ChatDraftItem.TYPE_NESTED_FILE, null, r16, null, r17, 96);
        List r8 = r17.getEntities();
        if (r8 != null) goto L5;
    L8:
        boolean r9 = true;
    L10:
        if (r9 == false) goto L12;
        List r10 = CollectionsKt.listOf(new String[]{ChatDraftItem.TYPE_NESTED_FILE, ChatDraftItem.TYPE_SUGGESTED_ACTION_OPERATIONS});
    L13:
        List<ChatDraftItem> r11 = this.p;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L15:
        if (r13.hasNext() == false) goto L19;
        Object r14 = r13.next();
        if ((!CollectionsKt.contains(r10, ((ChatDraftItem) r14).getType())) == false) goto L15;
        r12.add(r14);
        goto L15
    L19:
        List<ChatDraftItem> r15 = CollectionsKt.toMutableList(r12);
        if (z.a(r7) == false) goto L22;
        r15.add(r7);
    L22:
        this.p = r15;
        this.q = true;
        boolean r21 = A(this, r18, r19, r20, 4);
        if (r21 == true) goto L25;
        this.p = r1;
        this.f = r2;
        this.h = r4;
        this.q = r6;
    L25:
        return r21;
    L12:
        r10 = CollectionsKt.listOf(ChatDraftItem.TYPE_NESTED_FILE);
        goto L13
    L5:
        if (r8.isEmpty() == true) goto L8;
        r9 = false;
        goto L10
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final boolean g(String r22, String r23, boolean r24, Long r25, String r26, String r27) {
        if (this.d == false) goto L6;
        if (r24 == true) goto L6;
        return false;
    L6:
        if (r25 != null) goto L8;
    L11:
        if (r25 == null) goto L14;
        this.g = Math.max(this.g, r25.longValue());
    L14:
        if (r22 != null) goto L16;
    L19:
        boolean r0 = true;
    L20:
        if (r0 == true) goto L22;
    L24:
        boolean r1 = false;
    L25:
        if (r22 == null) goto L27;
        int r2 = r22.length();
    L28:
        z2 r3 = z2.a;
        if (z2.c4() == false) goto L31;
    L35:
        boolean r11 = r1;
    L36:
        if (r22 != null) goto L38;
    L41:
        boolean r4 = true;
    L42:
        if (r4 == true) goto L46;
        if (r11 == true) goto L46;
        boolean r12 = false;
    L48:
        if (r11 == false) goto L50;
        ChatDraftItem r5 = null;
    L51:
        if (r11 == true) goto L55;
        if (r23 == null) goto L55;
        ChatDraftItem r6 = ChatDraftItem.a.a(ChatDraftItem.Companion, ChatDraftItem.TYPE_MSG_EXT, r23, "", "", null, DoraCallStateCode.DOUBAO_CMD_12);
    L56:
        if (r24 == false) goto L58;
        List<ChatDraftItem> r7 = CollectionsKt.emptyList();
    L59:
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L61:
        if (r9.hasNext() == false) goto L73;
        Object r10 = r9.next();
        ChatDraftItem r13 = (ChatDraftItem) r10;
        if (Intrinsics.areEqual(r13.getType(), ChatDraftItem.TYPE_TEXT) == false) goto L65;
    L70:
        boolean r14 = false;
    L71:
        if (r14 == false) goto L61;
        r8.add(r10);
        goto L61
    L65:
        if (Intrinsics.areEqual(r13.getType(), ChatDraftItem.TYPE_MSG_EXT) == true) goto L70;
        if (r12 == true) goto L68;
    L69:
        r14 = true;
        goto L71
    L68:
        if (Intrinsics.areEqual(r13.getType(), ChatDraftItem.TYPE_OBRIC_MENTION_SKILL_IDS) == true) goto L70;
    L73:
        List<ChatDraftItem> r15 = CollectionsKt.toMutableList(r8);
        if (r5 == null) goto L76;
        r15.add(r5);
    L76:
        if (r6 == null) goto L78;
        r15.add(r6);
    L78:
        if (r24 == false) goto L86;
        if (r27 == null) goto L86;
        if ((!StringsKt.isBlank(r27)) == false) goto L83;
        String r16 = r27;
    L84:
        if (r16 == null) goto L86;
        r15.add(ChatDraftItem.a.a(ChatDraftItem.Companion, ChatDraftItem.TYPE_REPLY, r16, null, null, null, 124));
        goto L86
    L83:
        r16 = null;
    L86:
        if (r24 == true) goto L88;
        this.p = r15;
        this.q = true;
        return A(this, false, false, r25, 7);
    L88:
        return j1.a.b(this, r15, false, true, null, r26, r25, 10);
    L58:
        r7 = this.p;
    L55:
        r6 = null;
        goto L56
    L50:
        r5 = ChatDraftItem.a.a(ChatDraftItem.Companion, ChatDraftItem.TYPE_TEXT, r22, "", "", null, DoraCallStateCode.DOUBAO_CMD_12);
    L46:
        r12 = true;
        goto L48
    L38:
        if (r22.length() == 0) goto L41;
        r4 = false;
        goto L42
    L31:
        if (((a4) this.o.getValue()).b() == false) goto L35;
        if (r2 <= ((a4) this.o.getValue()).d()) goto L35;
        r11 = true;
        goto L36
    L27:
        r2 = 0;
        goto L28
    L22:
        if (z2.a.enablePreloadChatPageView().b() == false) goto L24;
        r1 = true;
        goto L25
    L16:
        if (r22.length() == 0) goto L19;
        r0 = false;
        goto L20
    L8:
        if (r25.longValue() >= this.g) goto L11;
        FLogger.a.i("ChatDraft", "ignore stale text draft event:" + r25 + " latestEvent:" + this.g);
        return false;
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final boolean s(List<ChatDraftItem> r27, boolean r28, boolean r29, String r30, String r31, Long r32) {
        Intrinsics.checkNotNullParameter(r27, "draftItems");
        if (this.d == false) goto L6;
        if (r29 == true) goto L6;
        return false;
    L6:
        List<ChatDraftItem> r1 = r27;
        ArrayList r5 = new ArrayList();
        Iterator<T> r7 = r1.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        String r8 = ((ChatDraftItem) r7.next()).getType();
        if (r8 == null) goto L8;
        r5.add(r8);
        goto L8
    L12:
        Set r6 = CollectionsKt.toSet(r5);
        List<ChatDraftItem> r9 = this.p;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L14:
        if (r11.hasNext() == false) goto L18;
        Object r12 = r11.next();
        if (CollectionsKt.contains(r6, ((ChatDraftItem) r12).getType()) == true) goto L14;
        r10.add(r12);
        goto L14
    L18:
        List<ChatDraftItem> r13 = CollectionsKt.toMutableList(r10);
        ArrayList r14 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L20:
        if (r2.hasNext() == false) goto L24;
        Object r15 = r2.next();
        if (z.a((ChatDraftItem) r15) == false) goto L20;
        r14.add(r15);
        goto L20
    L24:
        List<ChatDraftItem> r3 = CollectionsKt.toMutableList(r14);
        if (r30 == null) goto L36;
        if (r30.length() <= 0) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L32;
        String r17 = r30;
    L33:
        if (r17 == null) goto L36;
        r3.add(ChatDraftItem.a.a(ChatDraftItem.Companion, ChatDraftItem.TYPE_TEXT, r17, null, null, null, 124));
        goto L36
    L32:
        r17 = null;
        goto L33
    L29:
        r16 = false;
    L36:
        if (r29 == true) goto L53;
        r13.addAll(r3);
        if (r28 == false) goto L50;
        List<ChatDraftItem> r4 = r13;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r19 = r4.iterator();
    L41:
        if (r19.hasNext() == false) goto L43;
        r18.add(ChatDraftItem.copy$default((ChatDraftItem) r19.next(), null, null, null, 0, null, null, null, null, 247, null));
        goto L41
    L43:
        List<ChatDraftItem> r20 = this.p;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator<T> r22 = r20.iterator();
    L45:
        if (r22.hasNext() == false) goto L48;
        r21.add(ChatDraftItem.copy$default((ChatDraftItem) r22.next(), null, null, null, 0, null, null, null, null, 247, null));
        goto L45
    L48:
        if (Intrinsics.areEqual(r18, r21) == false) goto L50;
        return true;
    L50:
        this.p = r13;
        this.q = true;
        return A(this, r28, r28, r32, 4);
    L53:
        if (Intrinsics.areEqual(this.b, "__mobile_new_session_mode_draft_chat__") == false) goto L55;
    L58:
        boolean r23 = true;
    L59:
        if (r31 != null) goto L61;
    L68:
        if (r23 == true) goto L70;
        if (r31 != null) goto L70;
    L82:
        String r24 = ChatDraftItem.TYPE_NESTED_FILE;
        if (r23 == false) goto L174;
        Map<String, List<ChatDraftItem>> r25 = this.m.c;
        String r110 = this.b;
        if (r110 != null) goto L87;
        r110 = "";
    L87:
        List r26 = (List) ((LinkedHashMap) r25).get(r110);
        if (r26 != null) goto L90;
        r26 = CollectionsKt.emptyList();
    L90:
        List r33 = r26;
        LinkedHashMap r111 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r33, 10)), 16));
        Iterator r34 = r33.iterator();
    L92:
        if (r34.hasNext() == false) goto L94;
        Object r112 = r34.next();
        r111.put(((ChatDraftItem) r112).getType(), r112);
        goto L92
    L94:
        List<ChatDraftItem> r35 = this.p;
        LinkedHashMap r113 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r35, 10)), 16));
        Iterator<T> r36 = r35.iterator();
    L96:
        if (r36.hasNext() == false) goto L98;
        Object r37 = r36.next();
        r113.put(((ChatDraftItem) r37).getType(), r37);
        goto L96
    L98:
        Iterator r38 = SetsKt.plus(r111.keySet(), r113.keySet()).iterator();
    L100:
        if (r38.hasNext() == false) goto L117;
        final String r39 = (String) r38.next();
        if (Intrinsics.areEqual(r39, ChatDraftItem.TYPE_NESTED_FILE) == true) goto L100;
        ChatDraftItem r114 = (ChatDraftItem) r111.get(r39);
        if (r114 == null) goto L106;
        ChatDraftItem r115 = ChatDraftItem.copy$default(r114, null, null, null, 0, null, null, null, null, 247, null);
    L107:
        ChatDraftItem r116 = (ChatDraftItem) r113.get(r39);
        if (r116 == null) goto L110;
        ChatDraftItem r117 = ChatDraftItem.copy$default(r116, null, null, null, 0, null, null, null, null, 247, null);
    L112:
        if (Intrinsics.areEqual(r115, r117) == true) goto L100;
        CollectionsKt.removeAll(r3, new g(r39));
        ChatDraftItem r40 = (ChatDraftItem) r113.get(r39);
        if (r40 == null) goto L100;
        r3.add(r40);
        goto L100
    L110:
        r117 = null;
        goto L112
    L106:
        r115 = null;
        goto L107
    L117:
        ChatDraftItem r41 = (ChatDraftItem) r111.get(ChatDraftItem.TYPE_NESTED_FILE);
        if (r41 == null) goto L122;
        NestedFileContent r42 = r41.getNestedFileContent();
        if (r42 == null) goto L122;
        List r43 = r42.getEntities();
    L123:
        if (r43 != null) goto L125;
        r43 = CollectionsKt.emptyList();
    L125:
        ArrayList r44 = new ArrayList();
        Iterator r45 = r43.iterator();
    L127:
        if (r45.hasNext() == false) goto L131;
        String r118 = ((UplinkFileEntity) r45.next()).getFileIdentifier();
        if (r118 == null) goto L127;
        r44.add(r118);
        goto L127
    L131:
        Set r46 = CollectionsKt.toSet(r44);
        ChatDraftItem r47 = (ChatDraftItem) r113.get(ChatDraftItem.TYPE_NESTED_FILE);
        if (r47 == null) goto L136;
        NestedFileContent r119 = r47.getNestedFileContent();
        if (r119 == null) goto L136;
        List r120 = r119.getEntities();
    L137:
        if (r120 != null) goto L139;
        r120 = CollectionsKt.emptyList();
    L139:
        ArrayList r121 = new ArrayList();
        Iterator r122 = r120.iterator();
    L141:
        if (r122.hasNext() == false) goto L146;
        Object r123 = r122.next();
        if ((!CollectionsKt.contains(r46, ((UplinkFileEntity) r123).getFileIdentifier())) == false) goto L141;
        r121.add(r123);
        goto L141
    L146:
        if ((!r121.isEmpty()) == false) goto L174;
        Iterator<T> r48 = r3.iterator();
    L149:
        if (r48.hasNext() == false) goto L153;
        Object r124 = r48.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r124).getType(), ChatDraftItem.TYPE_NESTED_FILE) == false) goto L149;
    L154:
        ChatDraftItem r125 = (ChatDraftItem) r124;
        if (r125 != null) goto L157;
        ChatDraftItem r126 = r47;
    L158:
        if (r126 == null) goto L174;
        CollectionsKt.removeAll(r3, new h());
        if (r125 == null) goto L164;
        NestedFileContent r49 = r125.getNestedFileContent();
        if (r49 == null) goto L164;
        List r50 = r49.getEntities();
    L165:
        if (r50 != null) goto L167;
        r50 = CollectionsKt.emptyList();
    L167:
        List r51 = CollectionsKt.plus(r50, r121);
        HashSet r52 = new HashSet();
        ArrayList r127 = new ArrayList();
        Iterator r53 = r51.iterator();
    L169:
        if (r53.hasNext() == false) goto L173;
        Object r128 = r53.next();
        if (r52.add(((UplinkFileEntity) r128).getFileIdentifier()) == false) goto L169;
        r127.add(r128);
        goto L169
    L173:
        r3.add(ChatDraftItem.copy$default(r126, null, null, null, 0, null, new NestedFileContent(CollectionsKt.toMutableList(r127), null, false, null, 14, null), null, null, 223, null));
    L164:
        r50 = null;
        goto L165
    L157:
        r126 = r125;
        goto L158
    L153:
        r124 = null;
    L136:
        r120 = null;
    L122:
        r43 = null;
    L174:
        List<ChatDraftItem> r54 = this.p;
        long r55 = this.f;
        long r129 = this.g;
        long r130 = this.h;
        boolean r131 = this.q;
        this.p = r3;
        this.q = true;
        if (r32 == null) goto L177;
        long r56 = r32.longValue();
    L178:
        Long r57 = this.m.a;
        if (r57 == null) goto L181;
        long r58 = r57.longValue();
    L182:
        Long r59 = Long.valueOf(Math.max(r56, Math.max(r58, this.g)));
        if (r59.longValue() <= 0) goto L185;
        boolean r60 = true;
    L186:
        if (r60 == true) goto L190;
        r59 = null;
    L190:
        if (A(this, false, true, r59, 5) == true) goto L193;
        this.p = r54;
        this.f = r55;
        this.g = r129;
        this.h = r130;
        this.q = r131;
        return false;
    L193:
        String r61 = this.m.e;
        if (r61 != null) goto L196;
    L198:
        this.m = new b(null, null);
        CollectionsKt.removeAll(((LinkedHashMap) this.n).entrySet(), new i(this));
        List<ChatDraftItem> r62 = this.p;
        ArrayList r63 = new ArrayList();
        Iterator<T> r64 = r62.iterator();
    L200:
        if (r64.hasNext() == false) goto L205;
        Object r65 = r64.next();
        String r66 = r24;
        if (Intrinsics.areEqual(((ChatDraftItem) r65).getType(), r66) == false) goto L204;
        r63.add(r65);
    L204:
        r24 = r66;
        goto L200
    L205:
        ArrayList r67 = new ArrayList();
        Iterator r68 = r63.iterator();
    L207:
        if (r68.hasNext() == false) goto L216;
        String r69 = ((ChatDraftItem) r68.next()).getKey();
        if (r69 != null) goto L211;
    L213:
        r69 = null;
    L214:
        if (r69 == null) goto L207;
        r67.add(r69);
        goto L207
    L211:
        if ((!StringsKt.isBlank(r69)) == false) goto L213;
    L216:
        Iterator r70 = r67.iterator();
    L218:
        if (r70.hasNext() == false) goto L223;
        String r71 = (String) r70.next();
        Map<String, Pair<String, String>> r72 = this.n;
        String r73 = this.b;
        if (r73 != null) goto L222;
        r73 = "";
    L222:
        r72.put(r71, TuplesKt.to(r73, this.k));
        goto L218
    L223:
        this.d = true;
        return true;
    L196:
        if (Intrinsics.areEqual(r61, this.b) == true) goto L198;
        x.b(x.a, r61, 0, false, this.k, null, null, 54);
        goto L198
    L185:
        r60 = false;
        goto L186
    L181:
        r58 = 0;
        goto L182
    L177:
        r56 = 0;
    L70:
        if (r31 != null) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(r31, this.m.a()) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.m.d, this.b) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.m.e, this.a) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.m.f, this.c) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.m.b, this.k) == true) goto L82;
        return false;
    L61:
        if (Intrinsics.areEqual(r31, this.m.a()) == false) goto L68;
        if (Intrinsics.areEqual(this.m.b, this.k) == false) goto L68;
        b r74 = this.m;
        if (r74.d != null) goto L68;
        r74.g = r3;
        r74.h = r32;
        return true;
    L55:
        if (Intrinsics.areEqual(this.b, "__mobile_new_session_mode_draft_office__") == true) goto L58;
        r23 = false;
        goto L59
    }

    public final synchronized String C(String r40, String r41, boolean r42, String r43, boolean r44, boolean r45, Long r46) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r41, "source");     // Catch: Throwable -> L177
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L177
        r4.d("ChatDraft", "updateConversationId currentConversationId:" + this.a + " currentDraftStorageId:" + this.b + " conversationId:" + r40 + " conversationModeKey:" + r43);     // Catch: Throwable -> L177
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L7;
        r4.i("ChatDraft", "updateConversationId run not in main thread, current thread is " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L177
    L7:
        z2 r2 = z2.a;     // Catch: Throwable -> L177
        if (z2.c4() == true) goto L10;
        B(AccountService.a.getUserId());     // Catch: Throwable -> L177
    L10:
        this.i = r44;     // Catch: Throwable -> L177
        if (z2.c4() == false) goto L27;
        if (r45 == false) goto L27;
        if (r46 == null) goto L27;
        if (Intrinsics.areEqual(this.m.a, r46) == true) goto L17;
    L18:
        this.m = new b(r46, this.k);     // Catch: Throwable -> L177
        Iterator r1 = CollectionsKt.listOf(new String[]{"__mobile_new_session_mode_draft_chat__", "__mobile_new_session_mode_draft_office__"}).iterator();     // Catch: Throwable -> L177
    L20:
        if (r1.hasNext() == false) goto L27;
        String r3 = (String) r1.next();     // Catch: Throwable -> L177
        List r5 = x.e(x.a, r3, this.k, null, 4);     // Catch: Throwable -> L177
        Map<String, List<ChatDraftItem>> r6 = this.m.c;     // Catch: Throwable -> L177
        List r7 = r5;     // Catch: Throwable -> L177
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Throwable -> L177
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L177
    L23:
        if (r9.hasNext() == false) goto L25;
        r8.add(ChatDraftItem.copy$default((ChatDraftItem) r9.next(), null, null, null, 0, null, null, null, null, 247, null));     // Catch: Throwable -> L177
        goto L23
    L25:
        r6.put(r3, r8);     // Catch: Throwable -> L177
        goto L20
    L17:
        if (Intrinsics.areEqual(this.m.b, this.k) == false) goto L18;
    L27:
        if (r40 != null) goto L29;
    L32:
        boolean r10 = true;
    L33:
        if (r10 == false) goto L37;
        String r0 = this.m.a();     // Catch: Throwable -> L177
        monitor-exit(this);
        return r0;
    L37:
        boolean r16 = !Intrinsics.areEqual(this.a, r40);     // Catch: Throwable -> L177
        if (r16 == false) goto L42;
        Lazy r11 = ic8.n.a;     // Catch: Throwable -> L177
        Intrinsics.checkNotNullParameter(r40, "<this>");     // Catch: Throwable -> L177
        if (com.larus.im.j.f(r40) == false) goto L42;
        this.e = false;     // Catch: Throwable -> L177
    L46:
        if (Intrinsics.areEqual(r43, "office") == false) goto L49;
        String r12 = "office";
    L61:
        String r13 = r12;
    L62:
        z2 r14 = z2.a;     // Catch: Throwable -> L177
        if (z2.c4() == true) goto L65;
    L72:
        boolean r17 = false;
    L73:
        if (r17 == true) goto L76;
        String r15 = r40;
    L80:
        if (r17 == true) goto L85;
        if (r42 == true) goto L85;
        if (this.m.a == null) goto L85;
        this.m = new b(null, null);     // Catch: Throwable -> L177
    L85:
        if (r17 == false) goto L103;
        if (r42 == false) goto L89;
        if (r45 == true) goto L89;
        x r18 = x.a;     // Catch: Throwable -> L177
        boolean r19 = x.h(r40, r15, this.k);     // Catch: Throwable -> L177
        String r110 = r15;
        String r26 = r13;
    L105:
        boolean r20 = true;
        boolean r21 = !Intrinsics.areEqual(this.b, r110);     // Catch: Throwable -> L177
        if (r16 == true) goto L114;
        if (r21 == true) goto L114;
        if (r19 == true) goto L114;
        String r22 = r26;
        if (r22 == null) goto L152;
        this.c = r22;     // Catch: Throwable -> L177
    L152:
        if (this.m.a == null) goto L174;
        if (r17 == false) goto L174;
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{"chat", "office"}), r43) == false) goto L174;
        b r23 = this.m;     // Catch: Throwable -> L177
        if (r23.d != null) goto L174;
        if (Intrinsics.areEqual(r23.b, this.k) == false) goto L173;
        String r24 = this.m.a();     // Catch: Throwable -> L177
        if (r24 != null) goto L163;
    L166:
        if (r20 == true) goto L173;
        b r25 = this.m;     // Catch: Throwable -> L177
        r25.d = r110;     // Catch: Throwable -> L177
        r25.e = r40;     // Catch: Throwable -> L177
        r25.f = r22;     // Catch: Throwable -> L177
        List<ChatDraftItem> r27 = r25.g;     // Catch: Throwable -> L177
        if (r27 == null) goto L174;
        if (j1.a.b(this, r27, false, true, null, r25.a(), this.m.h, 10) == true) goto L174;
        this.m = new b(null, null);     // Catch: Throwable -> L177
        goto L174
    L163:
        if (StringsKt.isBlank(r24) == true) goto L166;
        r20 = false;
    L173:
        FLogger.a.w("ChatDraft", "skip entry replacement after owner changed");     // Catch: Throwable -> L177
        this.m = new b(null, null);     // Catch: Throwable -> L177
    L174:
        String r28 = this.m.a();     // Catch: Throwable -> L177
        monitor-exit(this);
        return r28;
    L114:
        r22 = r26;
        FLogger.a.i("ChatDraft", "perform change conversationId, source:" + r41 + ",isOnlyRevertImageFile:" + r42);     // Catch: Throwable -> L177
        this.a = r40;     // Catch: Throwable -> L177
        this.c = r22;     // Catch: Throwable -> L177
        this.b = r110;     // Catch: Throwable -> L177
        if (this.m.a != null) goto L117;
        v();     // Catch: Throwable -> L177
    L117:
        z();     // Catch: Throwable -> L177
        this.d = false;     // Catch: Throwable -> L177
        if (r42 == false) goto L122;
        z2 r29 = z2.a;     // Catch: Throwable -> L177
        if (z2.c4() == true) goto L122;
        q();     // Catch: Throwable -> L177
        n();     // Catch: Throwable -> L177
        w();     // Catch: Throwable -> L177
        b(false);     // Catch: Throwable -> L177
    L122:
        String r30 = this.j;     // Catch: Throwable -> L177
        if (r30 == null) goto L141;
        Lazy r31 = ic8.n.a;     // Catch: Throwable -> L177
        Intrinsics.checkNotNullParameter(r30, "<this>");     // Catch: Throwable -> L177
        if (com.larus.im.j.f(r30) == true) goto L127;
    L131:
        boolean r32 = false;
    L133:
        if (Intrinsics.areEqual(r30, r110) == true) goto L138;
        if (r32 == true) goto L138;
        x r33 = x.a;     // Catch: Throwable -> L177
        boolean r34 = x.h(r30, r110, this.k);     // Catch: Throwable -> L177
        if (r34 == false) goto L139;
        z();     // Catch: Throwable -> L177
    L139:
        if (r34 == false) goto L141;
        this.j = null;     // Catch: Throwable -> L177
        boolean r35 = true;
    L142:
        this.q = false;     // Catch: Throwable -> L177
        if (r19 == true) goto L149;
        if (r35 == true) goto L149;
        if (r21 == false) goto L148;
        if (r16 == false) goto L149;
    L148:
        boolean r36 = false;
    L150:
        this.d = r36;     // Catch: Throwable -> L177
    L149:
        r36 = true;
    L138:
        r34 = true;
        goto L139
    L127:
        if (Intrinsics.areEqual(r110, "__mobile_new_session_mode_draft_chat__") == false) goto L129;
    L130:
        r32 = true;
        goto L133
    L129:
        if (Intrinsics.areEqual(r110, "__mobile_new_session_mode_draft_office__") == false) goto L131;
    L141:
        r35 = false;
    L89:
        if (r42 == true) goto L103;
        x r37 = x.a;     // Catch: Throwable -> L177
        if ((!x.e(r37, r40, this.k, null, 4).isEmpty()) == false) goto L103;
        r110 = r15;
        r26 = r13;
        if (r37.g(r40, r15, this.k, true, true) == false) goto L104;
        b r38 = this.m;     // Catch: Throwable -> L177
        if (r38.d != null) goto L104;
        if (Intrinsics.areEqual(r38.b, this.k) == false) goto L104;
        Map<String, List<ChatDraftItem>> r39 = this.m.c;     // Catch: Throwable -> L177
        List r47 = x.e(r37, r110, this.k, null, 4);     // Catch: Throwable -> L177
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));     // Catch: Throwable -> L177
        Iterator r49 = r47.iterator();     // Catch: Throwable -> L177
    L100:
        if (r49.hasNext() == false) goto L102;
        r48.add(ChatDraftItem.copy$default((ChatDraftItem) r49.next(), null, null, null, 0, null, null, null, null, 247, null));     // Catch: Throwable -> L177
        goto L100
    L102:
        r39.put(r110, r48);     // Catch: Throwable -> L177
    L104:
        r19 = false;
    L103:
        r110 = r15;
        r26 = r13;
        goto L104
    L76:
        if (Intrinsics.areEqual(r13, "office") == false) goto L78;
        String r50 = "__mobile_new_session_mode_draft_office__";
    L79:
        r15 = r50;
        goto L80
    L78:
        r50 = "__mobile_new_session_mode_draft_chat__";
        goto L79
    L65:
        if (this.e == true) goto L72;
        Intrinsics.checkNotNullParameter(r40, "<this>");     // Catch: Throwable -> L177
        if (com.larus.im.j.f(r40) == false) goto L72;
        if (this.i == false) goto L72;
        if (r13 == null) goto L72;
        r17 = true;
        goto L73
    L49:
        if (Intrinsics.areEqual(r43, "chat") == false) goto L51;
        r12 = "chat";
        goto L61
    L51:
        r12 = this.c;     // Catch: Throwable -> L177
        if (r12 != null) goto L61;
        z2 r51 = z2.a;     // Catch: Throwable -> L177
        if (z2.c4() == false) goto L60;
        Intrinsics.checkNotNullParameter(r40, "<this>");     // Catch: Throwable -> L177
        if (com.larus.im.j.f(r40) == false) goto L60;
        if (this.i == false) goto L60;
        r12 = "chat";
    L60:
        r13 = null;
    L42:
        Lazy r52 = ic8.n.a;     // Catch: Throwable -> L177
        Intrinsics.checkNotNullParameter(r40, "<this>");     // Catch: Throwable -> L177
        if (com.larus.im.j.f(r40) == true) goto L46;
        this.e = true;     // Catch: Throwable -> L177
        goto L46
    L29:
        if (r40.length() == 0) goto L32;
        r10 = false;
    L177:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ String D(n r8, String r9, String r10, String r11, boolean r12, boolean r13, Long r14, int r15) {
        if ((r15 & 8) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r15 & 16) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r15 & 32) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r15 & 64) == 0) goto L17;
        Long r7 = null;
    L19:
        return r8.C(r9, r10, false, r4, r5, r6, r7);
    L17:
        r7 = r14;
        goto L19
    L13:
        r6 = r13;
        goto L15
    L9:
        r5 = r12;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }

    @Override // com.larus.bmhome.chat.model.j1
    public final synchronized boolean e(String r26, final UplinkFileEntity r27, List<UplinkFileEntity> r28, boolean r29, boolean r30, String r31, String r32, Long r33, String r34) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r26, "localMsgId");     // Catch: Throwable -> L37
        z2 r4 = z2.a;     // Catch: Throwable -> L37
        boolean r5 = false;
        Object r6 = null;
        if (z2.c4() == false) goto L7;
        if (r28 != null) goto L41;
        List<UplinkFileEntity> r1 = CollectionsKt.listOfNotNull(r27);     // Catch: Throwable -> L37
    L43:
        if (this.d == false) goto L46;
        if (r30 == true) goto L46;
    L47:
        monitor-exit(this);
        return false;
    L46:
        if (StringsKt.isBlank(r26) == true) goto L47;
        AccountService r2 = AccountService.a;     // Catch: Throwable -> L37
        String r3 = r2.getUserId();     // Catch: Throwable -> L37
        if (z2.c4() == false) goto L62;
        if (Intrinsics.areEqual(this.k, r3) == true) goto L62;
        if (this.l == true) goto L56;
    L59:
        monitor-exit(this);
        return false;
    L56:
        if (r2.isLogin().booleanValue() == false) goto L59;
        B(r3);     // Catch: Throwable -> L37
    L62:
        if (r1.isEmpty() == false) goto L67;
        if (r29 == false) goto L89;
        if (r30 == true) goto L89;
    L90:
        boolean r7 = true;
    L91:
        if (r7 == true) goto L95;
        FLogger.a.e("ChatDraft", "addOrUpdateNestedFileEntityItem failed, localMsgId:" + r26);     // Catch: Throwable -> L37
        monitor-exit(this);
        return false;
    L95:
        if (r29 == false) goto L115;
        if (r30 == true) goto L115;
        if (r34 != null) goto L99;
    L113:
        monitor-exit(this);
        return false;
    L99:
        if ((!StringsKt.isBlank(r34)) == false) goto L101;
        String r8 = r34;
    L102:
        if (r8 == null) goto L113;
        Iterator<T> r9 = r1.iterator();     // Catch: Throwable -> L37
    L106:
        if (r9.hasNext() == false) goto L110;
        Object r10 = r9.next();     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(((UplinkFileEntity) r10).getFileIdentifier(), r8) == false) goto L106;
    L111:
        r1 = CollectionsKt.listOfNotNull(r10);     // Catch: Throwable -> L37
        goto L115
    L110:
        r10 = null;
        goto L111
    L101:
        r8 = null;
    L115:
        final Gson r11 = new Gson();     // Catch: Throwable -> L37
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L37
        Iterator<T> r13 = r1.iterator();     // Catch: Throwable -> L37
    L117:
        if (r13.hasNext() == false) goto L122;
        final UplinkFileEntity r14 = (UplinkFileEntity) r13.next();     // Catch: Throwable -> L37
        UplinkFileEntity r15 = (UplinkFileEntity) com.larus.utils.l0.a(null, new e(r11, r14));     // Catch: Throwable -> L37
        if (r15 == null) goto L117;
        r12.add(r15);     // Catch: Throwable -> L37
        goto L117
    L122:
        if (r12.size() == r1.size()) goto L125;
        monitor-exit(this);
        return false;
    L125:
        if (r30 == false) goto L139;
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L37
        if (r31 != null) goto L129;
    L136:
        r16.add(ChatDraftItem.a.a(ChatDraftItem.Companion, ChatDraftItem.TYPE_NESTED_FILE, null, r26, null, new NestedFileContent(CollectionsKt.toMutableList(r12), null, false, null, 14, null), MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY));     // Catch: Throwable -> L37
        boolean r0 = j1.a.b(this, r16, false, true, null, r32, null, 42);     // Catch: Throwable -> L37
        monitor-exit(this);
        return r0;
    L129:
        if (r31.length() <= 0) goto L131;
        r5 = true;
    L131:
        if (r5 == false) goto L133;
        String r17 = r31;
    L134:
        if (r17 == null) goto L136;
        r16.add(ChatDraftItem.a.a(ChatDraftItem.Companion, ChatDraftItem.TYPE_TEXT, r17, null, null, null, 124));     // Catch: Throwable -> L37
        goto L136
    L133:
        r17 = null;
        goto L134
    L139:
        z2 r18 = z2.a;     // Catch: Throwable -> L37
        if (z2.c4() == false) goto L281;
        if (r29 == false) goto L281;
        if (r34 != null) goto L145;
    L279:
        monitor-exit(this);
        return false;
    L145:
        if ((!StringsKt.isBlank(r34)) == false) goto L147;
        String r19 = r34;
    L148:
        if (r19 == null) goto L279;
        Pair r20 = (Pair) ((LinkedHashMap) this.n).get(r26);     // Catch: Throwable -> L37
        if (r20 != null) goto L154;
        monitor-exit(this);
        return false;
    L154:
        Iterator<T> r21 = this.p.iterator();     // Catch: Throwable -> L37
    L156:
        if (r21.hasNext() == false) goto L165;
        Object r22 = r21.next();     // Catch: Throwable -> L37
        ChatDraftItem r110 = (ChatDraftItem) r22;     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(r110.getType(), ChatDraftItem.TYPE_NESTED_FILE) == true) goto L160;
    L162:
        boolean r111 = false;
    L163:
        if (r111 == false) goto L156;
    L166:
        ChatDraftItem r23 = (ChatDraftItem) r22;     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(r20.getFirst(), this.b) == true) goto L169;
    L209:
        final Ref.LongRef r24 = new Ref.LongRef();     // Catch: Throwable -> L37
        final Ref.LongRef r25 = new Ref.LongRef();     // Catch: Throwable -> L37
        List<ChatDraftItem> r112 = x.a.d((String) r20.getFirst(), (String) r20.getSecond(), new f(r24, r25));     // Catch: Throwable -> L37
        Iterator<T> r113 = r112.iterator();     // Catch: Throwable -> L37
    L211:
        if (r113.hasNext() == false) goto L220;
        Object r114 = r113.next();     // Catch: Throwable -> L37
        ChatDraftItem r115 = (ChatDraftItem) r114;     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(r115.getType(), ChatDraftItem.TYPE_NESTED_FILE) == true) goto L215;
    L217:
        boolean r116 = false;
    L218:
        if (r116 == false) goto L211;
    L221:
        ChatDraftItem r117 = (ChatDraftItem) r114;     // Catch: Throwable -> L37
        if (r117 != null) goto L225;
        monitor-exit(this);
        return false;
    L225:
        NestedFileContent r35 = r117.getNestedFileContent();     // Catch: Throwable -> L37
        if (r35 == null) goto L228;
        List r36 = r35.getEntities();     // Catch: Throwable -> L37
    L229:
        if (r36 != null) goto L231;
        r36 = CollectionsKt.emptyList();     // Catch: Throwable -> L37
    L231:
        List r118 = r36;     // Catch: Throwable -> L37
        if ((r118 instanceof Collection) == true) goto L234;
    L236:
        Iterator r119 = r118.iterator();     // Catch: Throwable -> L37
    L238:
        if (r119.hasNext() == false) goto L242;
        if (Intrinsics.areEqual(((UplinkFileEntity) r119.next()).getFileIdentifier(), r19) == false) goto L238;
    L243:
        if (r5 == false) goto L246;
        monitor-exit(this);
        return true;
    L246:
        Iterator r37 = r12.iterator();     // Catch: Throwable -> L37
    L248:
        if (r37.hasNext() == false) goto L252;
        Object r38 = r37.next();     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(((UplinkFileEntity) r38).getFileIdentifier(), r19) == false) goto L248;
        r6 = r38;
    L252:
        UplinkFileEntity r39 = (UplinkFileEntity) r6;     // Catch: Throwable -> L37
        ArrayList r40 = new ArrayList();     // Catch: Throwable -> L37
        Iterator r41 = r36.iterator();     // Catch: Throwable -> L37
    L254:
        if (r41.hasNext() == false) goto L260;
        UplinkFileEntity r42 = (UplinkFileEntity) r41.next();     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(r42.getFileIdentifier(), r19) == false) goto L258;
        r42 = r39;
    L258:
        if (r42 == null) goto L254;
        r40.add(r42);     // Catch: Throwable -> L37
        goto L254
    L260:
        ArrayList r43 = new ArrayList();     // Catch: Throwable -> L37
        Iterator<T> r44 = r112.iterator();     // Catch: Throwable -> L37
    L262:
        if (r44.hasNext() == false) goto L266;
        Object r45 = r44.next();     // Catch: Throwable -> L37
        if ((!Intrinsics.areEqual(((ChatDraftItem) r45).getType(), ChatDraftItem.TYPE_NESTED_FILE)) == false) goto L262;
        r43.add(r45);     // Catch: Throwable -> L37
        goto L262
    L266:
        List r46 = CollectionsKt.toMutableList(r43);     // Catch: Throwable -> L37
        if ((!r40.isEmpty()) == false) goto L269;
        r46.add(ChatDraftItem.copy$default(r117, null, null, null, 0, null, new NestedFileContent(CollectionsKt.toMutableList(r40), null, false, null, 14, null), null, null, 223, null));     // Catch: Throwable -> L37
    L269:
        x r120 = x.a;     // Catch: Throwable -> L37
        monitor-enter(r120);     // Catch: Throwable -> L37
        long r121 = Math.max(System.currentTimeMillis(), Math.max(r24.element + 1, 1 + x.g));     // Catch: Throwable -> L276
        x.g = r121;     // Catch: Throwable -> L276
        monitor-exit(r120);     // Catch: Throwable -> L37
        boolean r47 = x.i(r120, (String) r20.getFirst(), r46, r121, false, (String) r20.getSecond(), Long.valueOf(r24.element), r25.element, 8);     // Catch: Throwable -> L37
        monitor-exit(this);
        return r47;
    L276:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L242:
        r5 = true;
        goto L243
    L234:
        if (r118.isEmpty() == false) goto L236;
    L228:
        r36 = null;
        goto L229
    L215:
        if (Intrinsics.areEqual(r115.getKey(), r26) == false) goto L217;
        r116 = true;
        goto L218
    L220:
        r114 = null;
        goto L221
    L169:
        if (Intrinsics.areEqual(r20.getSecond(), this.k) == false) goto L209;
        if (r23 == null) goto L209;
        NestedFileContent r48 = r23.getNestedFileContent();     // Catch: Throwable -> L37
        if (r48 == null) goto L174;
        List r49 = r48.getEntities();     // Catch: Throwable -> L37
    L175:
        if (r49 != null) goto L177;
        r49 = CollectionsKt.emptyList();     // Catch: Throwable -> L37
    L177:
        List r50 = r49;     // Catch: Throwable -> L37
        if ((r50 instanceof Collection) == true) goto L180;
    L182:
        Iterator r51 = r50.iterator();     // Catch: Throwable -> L37
    L184:
        if (r51.hasNext() == false) goto L188;
        if (Intrinsics.areEqual(((UplinkFileEntity) r51.next()).getFileIdentifier(), r19) == false) goto L184;
    L189:
        if (r5 == false) goto L192;
        monitor-exit(this);
        return true;
    L192:
        Iterator r52 = r12.iterator();     // Catch: Throwable -> L37
    L194:
        if (r52.hasNext() == false) goto L198;
        Object r53 = r52.next();     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(((UplinkFileEntity) r53).getFileIdentifier(), r19) == false) goto L194;
        r6 = r53;
    L198:
        UplinkFileEntity r54 = (UplinkFileEntity) r6;     // Catch: Throwable -> L37
        ArrayList r55 = new ArrayList();     // Catch: Throwable -> L37
        Iterator r56 = r49.iterator();     // Catch: Throwable -> L37
    L200:
        if (r56.hasNext() == false) goto L206;
        UplinkFileEntity r57 = (UplinkFileEntity) r56.next();     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(r57.getFileIdentifier(), r19) == false) goto L204;
        r57 = r54;
    L204:
        if (r57 == null) goto L200;
        r55.add(r57);     // Catch: Throwable -> L37
        goto L200
    L206:
        boolean r58 = E(r26, new NestedFileContent(CollectionsKt.toMutableList(r55), null, false, null, 14, null), true, true, null);     // Catch: Throwable -> L37
        monitor-exit(this);
        return r58;
    L188:
        r5 = true;
        goto L189
    L180:
        if (r50.isEmpty() == false) goto L182;
    L174:
        r49 = null;
        goto L175
    L160:
        if (Intrinsics.areEqual(r110.getKey(), r26) == false) goto L162;
        r111 = true;
        goto L163
    L165:
        r22 = null;
        goto L166
    L147:
        r19 = null;
    L281:
        boolean r59 = E(r26, new NestedFileContent(CollectionsKt.toMutableList(r12), null, false, null, 14, null), false, z2.c4(), r33);     // Catch: Throwable -> L37
        if (r59 == true) goto L284;
    L289:
        monitor-exit(this);
        return r59;
    L284:
        if (z2.c4() == false) goto L289;
        Map<String, Pair<String, String>> r60 = this.n;     // Catch: Throwable -> L37
        String r61 = this.b;     // Catch: Throwable -> L37
        if (r61 != null) goto L288;
        r61 = "";
    L288:
        r60.put(r26, new Pair(r61, this.k));     // Catch: Throwable -> L37
    L89:
        r7 = false;
        goto L91
    L67:
        if (z2.c4() == false) goto L79;
        List<UplinkFileEntity> r62 = r1;     // Catch: Throwable -> L37
        if ((r62 instanceof Collection) == true) goto L71;
    L73:
        Iterator<T> r63 = r62.iterator();     // Catch: Throwable -> L37
    L75:
        if (r63.hasNext() == false) goto L90;
        if (com.larus.utils.o0.d(((UplinkFileEntity) r63.next()).getFileIdentifier()) == true) goto L75;
    L71:
        if (r62.isEmpty() == false) goto L73;
    L79:
        List<UplinkFileEntity> r64 = r1;     // Catch: Throwable -> L37
        if ((r64 instanceof Collection) == true) goto L82;
    L84:
        Iterator<T> r65 = r64.iterator();     // Catch: Throwable -> L37
    L86:
        if (r65.hasNext() == false) goto L90;
        if (yc9.l1.m((UplinkFileEntity) r65.next()) == true) goto L86;
    L82:
        if (r64.isEmpty() == false) goto L84;
    L41:
        r1 = r28;
        goto L43
    L7:
        if (this.d == false) goto L10;
        monitor-exit(this);
        return false;
    L10:
        if (r27 != null) goto L14;
        monitor-exit(this);
        return false;
    L14:
        if (yc9.l1.m(r27) == true) goto L18;
        FLogger.a.e("ChatDraft", "addNestedFileChatDraftEntityItem failed, localMsgId:" + r26);     // Catch: Throwable -> L37
        monitor-exit(this);
        return false;
    L18:
        FLogger.a.d("ChatDraft", "addNestedFileChatDraftEntityItem localMsgId:" + r26);     // Catch: Throwable -> L37
        Iterator<T> r66 = this.p.iterator();     // Catch: Throwable -> L37
    L20:
        if (r66.hasNext() == false) goto L24;
        Object r67 = r66.next();     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(((ChatDraftItem) r67).getType(), ChatDraftItem.TYPE_NESTED_FILE) == false) goto L20;
        r6 = r67;
    L24:
        ChatDraftItem r68 = (ChatDraftItem) r6;     // Catch: Throwable -> L37
        if (r68 == null) goto L33;
        NestedFileContent r69 = r68.getNestedFileContent();     // Catch: Throwable -> L37
        if (r69 == null) goto L33;
        List r70 = r69.getEntities();     // Catch: Throwable -> L37
        if (r70 == null) goto L33;
        List r71 = CollectionsKt.toMutableList(r70);     // Catch: Throwable -> L37
        if (r71 == null) goto L33;
    L34:
        com.larus.utils.h.e(r71, new com.larus.bmhome.chat.model.a(r27));     // Catch: Throwable -> L37
        r71.add(r27);     // Catch: Throwable -> L37
        boolean r72 = E(r26, new NestedFileContent(r71, null, false, null, 14, null), false, false, null);     // Catch: Throwable -> L37
        monitor-exit(this);
        return r72;
    L33:
        r71 = new ArrayList();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }
}
