package com.ss.android.lark.reaction.service.impl;

import android.os.SystemClock;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.PushEmojiPanel;
import com.bytedance.lark.pb.im.v1.PushUserMRUReactions;
import com.bytedance.lark.pb.im.v1.UpdateUserReactionSkinRequest;
import com.bytedance.lark.pb.im.v1.UpdateUserReactionSkinResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.passport.base.core.log.LevelTypes;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.picker.base.view.ItemViewType;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import jdb.g;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class ReactionOrderService2 extends c0c.c implements m2c.a {
    public static final /* synthetic */ int s = 0;
    public final l b;
    public final rsb.b c;
    public final rsb.a d;
    public final m2c.b e;
    public final g f;
    public final String[] g;
    public final Lazy h;
    public DefaultEmojiPanelData i;
    public final List<String> j;
    public List<String> k;
    public int l;
    public volatile FetchEmojiPanelState m;
    public final Lazy n;
    public final List<m2c.c> o;
    public final c p;
    public Disposable q;
    public Disposable r;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/reaction/service/impl/ReactionOrderService2$FetchEmojiPanelState;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "LOADING", "SUCCESS", "reaction-component_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum FetchEmojiPanelState extends Enum<FetchEmojiPanelState> {
        public static final FetchEmojiPanelState INIT = null;
        public static final FetchEmojiPanelState LOADING = null;
        public static final FetchEmojiPanelState SUCCESS = null;
        public static final /* synthetic */ FetchEmojiPanelState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<FetchEmojiPanelState> getEntries() {
            return b;
        }

        static {
            FetchEmojiPanelState r0 = new FetchEmojiPanelState("INIT", 0);
            INIT = r0;
            FetchEmojiPanelState r1 = new FetchEmojiPanelState("LOADING", 1);
            LOADING = r1;
            FetchEmojiPanelState r3 = new FetchEmojiPanelState("SUCCESS", 2);
            SUCCESS = r3;
            FetchEmojiPanelState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static FetchEmojiPanelState[] values() {
            return (FetchEmojiPanelState[]) a.clone();
        }

        public static FetchEmojiPanelState valueOf(String r1) {
            return (FetchEmojiPanelState) r27.a.a(FetchEmojiPanelState.class, r1);
        }

        public FetchEmojiPanelState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ReactionOrderService2 a;

        public b(ReactionOrderService2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReactionOrderService2.m(this.a, true);     // Catch: Throwable -> L6
            if (this.a.u() == false) goto L9;
            ReactionOrderService2.m(this.a, false);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements zob.b {
        public final /* synthetic */ ReactionOrderService2 a;

        public c(ReactionOrderService2 r1) {
            this.a = r1;
        }

        public final void a(Locale r3, Locale r4) {
            Log.i("ReactionOrderService2", "onLanguageChange, from " + wsb.c.a(r3) + " to " + wsb.c.a(r4));
            this.a.x();
            this.a.fetchData();
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ReactionOrderService2 a;
        public final /* synthetic */ boolean b;

        public d(ReactionOrderService2 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            List<String> r0 = this.a.e.N(this.b);
            StringBuilder r1 = new StringBuilder("syncMRUReactionList, isFromLocal: ");
            r1.append(this.b);
            r1.append(", result: ");
            if (CollectionUtils.isEmpty(r0) == false) goto L5;
            Object r2 = "[]";
        L6:
            r1.append(r2);
            Log.i("ReactionOrderService2", r1.toString());
            ReactionOrderService2.p(this.a, r0);
            return;
        L5:
            r2 = r0;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // m2c.a
    @Deprecated(message = "Deprecated, delete please")
    public final void I2() {
    }

    @Override // m2c.a
    public final synchronized List<String> U2() {
        monitor-enter(this);
        r();     // Catch: Throwable -> L6
        List<String> r0 = this.i.b();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // m2c.a
    public final synchronized DefaultEmojiPanelData a() {
        monitor-enter(this);
        r();     // Catch: Throwable -> L6
        DefaultEmojiPanelData r0 = this.i;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // m2c.a
    @Deprecated(message = "Deprecated, delete please", replaceWith = @ReplaceWith(expression = "nothing", imports = {}))
    public final List<String> f() {
        monitor-enter(this);
        List<String> r0 = CollectionsKt.emptyList();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // m2c.a
    public final synchronized List<String> h() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList(this.j);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // c0c.c
    public final void c() {
        Log.i("ReactionOrderService2", "destroy");
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        com.ss.android.lark.language.service.impl.a.b.a.k(this.p);
        Disposable r1 = this.q;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.q = null;
        Disposable r2 = this.r;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        this.r = null;
    }

    @Override // c0c.c
    public final void e() {
        Log.i("ReactionOrderService2", "onPrepared");
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        com.ss.android.lark.language.service.impl.a.b.a.c(this.p);
        Disposable r1 = this.q;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.q = this.b.i(Command.PUSH_EMOJI_PANEL, PushEmojiPanel.ADAPTER).subscribe(new com.ss.android.lark.reaction.service.impl.b(this), com.ss.android.lark.reaction.service.impl.c.a);
        Disposable r2 = this.r;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        this.r = this.b.i(Command.PUSH_USER_MRU_REACTIONS, PushUserMRUReactions.ADAPTER).subscribe(new com.ss.android.lark.reaction.service.impl.d(this), e.a);
        fetchData();
    }

    @Override // m2c.a
    public final void fetchData() {
        Log.i("ReactionOrderService2", "fetchData");
        r();
        Log.i("ReactionOrderService2", "initMRUReactionList");
        md(true);
        md(false);
    }

    public final void r() {
        if (this.m != FetchEmojiPanelState.INIT) goto L6;
        this.m = FetchEmojiPanelState.LOADING;
        Log.i("ReactionOrderService2", "fetchEmojiPanelData, disablePullOptimization: " + u());
        ((ExecutorService) this.h.getValue()).execute(new b(this));
        return;
    }

    public final boolean u() {
        return ((Boolean) this.n.getValue()).booleanValue();
    }

    public final void x() {
        this.m = FetchEmojiPanelState.INIT;
        this.i = new DefaultEmojiPanelData();
        DefaultEmojiPanelData.a r0 = new DefaultEmojiPanelData.a();
        DefaultEmojiPanelData.Type r1 = DefaultEmojiPanelData.Type.DEFAULT;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.a = r1;
        ArrayList r2 = new ArrayList();
        String[] r3 = this.g;
        int r4 = r3.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L5;
        String r6 = r3[r5];
        r2.add(new Pair(r6, r6));
        r5 = r5 + 1;
        goto L3
    L5:
        r0.c(r2);
        DefaultEmojiPanelData r7 = this.i;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "group");
        ((ArrayList) r7.a).add(r0);
    }

    @Override // m2c.a
    @Deprecated(message = "Deprecated, delete please", replaceWith = @ReplaceWith(expression = "nothing", imports = {}))
    public final List<String> o() {
        return CollectionsKt.emptyList();
    }

    @Override // m2c.a
    public final List<String> N(boolean r7) {
        if (r7 == false) goto L4;
        List<String> r8 = CollectionsKt.toMutableList(h());
        Iterator<String> r0 = U2().iterator();
        String r1 = null;
        String r2 = null;
    L7:
        if (r0.hasNext() == false) goto L19;
        String r3 = r0.next();
        if (r1 != null) goto L13;
        Set r5 = wsb.b.a;
        Intrinsics.checkNotNullParameter(r3, "reactionKey");
        if (wsb.b.a.contains(r3) == false) goto L13;
        r1 = r3;
    L13:
        if (r2 != null) goto L17;
        Set r6 = wsb.b.a;
        Intrinsics.checkNotNullParameter(r3, "reactionKey");
        if (wsb.b.b.contains(r3) == false) goto L17;
        r2 = r3;
    L17:
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
    L19:
        if (r1 != null) goto L21;
        r1 = "THUMBSUP";
    L21:
        if (r2 != null) goto L23;
        r2 = "ThumbsDown";
    L23:
        r8.remove(r1);
        r8.remove(r2);
        ListProtector.add(r8, 0, r2);
        ListProtector.add(r8, 0, r1);
        return r8;
    L4:
        return h();
    }

    @Override // m2c.a
    public final synchronized boolean j5(String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "emojiKey");     // Catch: Throwable -> L17
        if (this.l == this.i.hashCode()) goto L6;
    L7:
        this.k = this.i.a();     // Catch: Throwable -> L17
        this.l = this.i.hashCode();     // Catch: Throwable -> L17
    L8:
        List<String> r0 = this.k;     // Catch: Throwable -> L17
        if (r0 == null) goto L14;
        boolean r4 = r0.contains(r3);     // Catch: Throwable -> L17
        boolean r1 = true;
        if (r4 != true) goto L14;
    L15:
        monitor-exit(this);
        return r1;
    L14:
        r1 = false;
        goto L15
    L6:
        if (this.k != null) goto L8;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // m2c.a
    public final void md(boolean r3) {
        ((ExecutorService) this.h.getValue()).execute(new d(this, r3));
    }

    @Override // m2c.a
    public final void q8(m2c.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        List<m2c.c> r0 = this.o;
        monitor-enter(r0);
        ((ArrayList) this.o).remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void s(List<String> r3) {
        if (CollectionUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        Iterator<String> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        String r0 = r4.next();
        if (this.d.i7(r0) == false) goto L7;
        r4.remove();
        goto L7
    }

    @Override // m2c.a
    public final void v2(m2c.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        List<m2c.c> r0 = this.o;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.o).contains(r3) == true) goto L7;
        ((ArrayList) this.o).add(r3);     // Catch: Throwable -> L10
    L7:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.ss.android.lark.reaction.service.impl.ReactionOrderService2$fetchEmojiPanelData$2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void m(final ReactionOrderService2 r4, final boolean r5) {
        r4.getClass();
        Log.i("ReactionOrderService2", "fetchEmojiPanelData start, isFromLocal: " + r5);
        final long r0 = SystemClock.elapsedRealtime();
        r4.e.o7(r5, new ReactionOrderService2$fetchEmojiPanelData$2(r5, r0, r4));
    }

    public static final void n(ReactionOrderService2 r1, DefaultEmojiPanelData r2) {
        List<m2c.c> r3 = r1.o;
        monitor-enter(r3);
        Iterator r4 = ((ArrayList) r1.o).iterator();     // Catch: Throwable -> L11
    L6:
        if (r4.hasNext() == false) goto L8;
        ((m2c.c) r4.next()).a();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r3);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static final void p(ReactionOrderService2 r2, List r3) {
        r2.getClass();
        List r0 = r3;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L21;
        List<String> r4 = r2.j;
        monitor-enter(r4);
        ((ArrayList) r2.j).clear();     // Catch: Throwable -> L16
        ArrayList r5 = (ArrayList) r2.j;     // Catch: Throwable -> L16
        r5.addAll(r3);     // Catch: Throwable -> L16
        r2.s(r2.j);     // Catch: Throwable -> L16
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r4);
        return;
    L16:
        th = move-exception;
        throw th;
    L21:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // m2c.a
    public final void Wc(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "staticKey");
        Intrinsics.checkNotNullParameter(r13, "skinedKey");
        Log.i("ReactionOrderService2", "updateEmojiSkinedReactionKey, staticKey: " + r12 + ", skined key: " + r13);
        UpdateUserReactionSkinRequest.Builder r3 = new UpdateUserReactionSkinRequest.Builder().reaction_to_skin_key(Collections.singletonMap(r12, r13));
        l r0 = this.b;
        Intrinsics.checkNotNull(r3);
        t.a(r0.h(new com.bytedance.lark.rustclient.api.d(r3, UpdateUserReactionSkinResponse.ADAPTER, Command.UPDATE_USER_REACTION_SKIN, null, null, null, null, 248)).a(), ReactionOrderService2$updateEmojiSkinedReactionKey$1.INSTANCE, ReactionOrderService2$updateEmojiSkinedReactionKey$2.INSTANCE, ReactionOrderService2$updateEmojiSkinedReactionKey$3.INSTANCE);
        com.ss.android.lark.newemoji.larkemoji.c.f(r12, r13);
        com.ss.android.lark.newemoji.larkemoji.c.b();
    }

    @Inject
    public ReactionOrderService2(m r147, l r148, rsb.b r149, rsb.a r150, m2c.b r151, g r152) {
        Intrinsics.checkNotNullParameter(r147, "passport");
        Intrinsics.checkNotNullParameter(r148, "rustClient");
        Intrinsics.checkNotNullParameter(r149, "emojiService");
        Intrinsics.checkNotNullParameter(r150, "emojiMapManager");
        Intrinsics.checkNotNullParameter(r151, "reactionService");
        Intrinsics.checkNotNullParameter(r152, "userFeatureGatingService");
        super(r147);
        this.b = r148;
        this.c = r149;
        this.d = r150;
        this.e = r151;
        this.f = r152;
        String[] r0 = {"OK", "FACEPALM", "LOL", "Get", "GLANCE", "CRY", "SOB", "FINGERHEART", "THUMBSUP", "Yes", "FISTBUMP", "JIAYI", "DONE", "LOVE", "YouAreTheBest", "LAUGH", "THANKS", "FullMoonFace"};
        this.g = new String[]{"OK", "THUMBSUP", "THANKS", "MUSCLE", "FINGERHEART", "APPLAUSE", "FISTBUMP", "JIAYI", "DONE", "SMILE", "BLUSH", "LAUGH", "SMIRK", "LOL", "FACEPALM", "LOVE", "WINK", "PROUD", "WITTY", "SMART", "SCOWL", "THINKING", "SOB", "CRY", LevelTypes.TYPE_ERROR, "NOSEPICK", "HAUGHTY", "SLAP", "SPITBLOOD", "TOASTED", "BLACKFACE", "GLANCE", "DULL", "ROSE", "HEART", "PARTY", "INNOCENTSMILE", "SHY", "CHUCKLE", "JOYFUL", "WOW", "TRICK", "YEAH", "ENOUGH", "TEARS", "EMBARRASSED", "KISS", "SMOOCH", "DROOL", "OBSESSED", "MONEY", "TEASE", "SHOWOFF", "COMFORT", "CLAP", "PRAISE", "STRIVE", "XBLUSH", "SILENT", "WAVE", "EATING", "WHAT", "FROWN", "DULLSTARE", "DIZZY", "LOOKDOWN", "WAIL", "CRAZY", "WHIMPER", "HUG", "BLUBBER", "WRONGED", "HUSKY", "SHHH", "SMUG", "ANGRY", "HAMMER", "SHOCKED", "TERROR", "PETRIFIED", "SKULL", "SWEAT", "SPEECHLESS", "SLEEP", "DROWSY", "YAWN", "SICK", "PUKE", "BIGKISS", "BETRAYED", "HEADSET", "DONNOTGO", "EatingFood", "Typing", "Lemon", "Get", "LGTM", "SALUTE", "SHAKE", "HIGHFIVE", "UPPERLEFT", "ThumbsDown", "SLIGHT", "TONGUE", "EYESCLOSED", "BEAR", "BULL", "CALF", "LIPS", "BEER", "CAKE", "GIFT", "CUCUMBER", "Drumstick", "Pepper", "CANDIEDHAWS", "BubbleTea", "Coffee", "Yes", "No", "OKR", "CheckMark", "CrossMark", "MinusOne", "Hundred", "2021", "AWESOMEN", "Pin", "Alarm", "Loudspeaker", "Trophy", "Fire", "RAINBOWPUKE", "Music", "FIREWORKS", "REDPACKET", "FORTUNE", "LUCK", "FIRECRACKER", "HEARTBROKEN", "BOMB", "POOP", "18X", "CLEAVER"};
        this.h = LazyKt.lazy(ReactionOrderService2$threadPool$2.INSTANCE);
        this.i = new DefaultEmojiPanelData();
        ArrayList r2 = new ArrayList();
        this.j = r2;
        this.m = FetchEmojiPanelState.INIT;
        this.n = LazyKt.lazy(new ReactionOrderService2$disablePullOptimization$2(this));
        this.o = new ArrayList();
        this.p = new c(this);
        Log.i("ReactionOrderService2", "init");
        x();
        monitor-enter(r2);
        r2.clear();     // Catch: Throwable -> L8
        r2.addAll(CollectionsKt.listOf(Arrays.copyOf(r0, r0.length)));     // Catch: Throwable -> L8
        s(r2);     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r2);
        s.a(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
