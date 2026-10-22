package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UserSearchAndMatchStrategy {
    public final CoroutineScope a;
    public final String b;
    public final Function1<ChatChatter, String> c;
    public final Function4<String, String, String, Boolean, ccb.d> d;
    public final Function2<String, String, ChatChatter> e;
    public final Function2<String, String, Boolean> f;
    public final MatchMode g;
    public final boolean h;
    public final String i;
    public final ConcurrentHashMap<String, b> j;

    public abstract class BaseSearchStrategy implements a {
        public final c a;
        public volatile ChatChatter b;
        public volatile SearchStatus c;
        public final List<Deferred<Unit>> d;
        public Deferred<? extends Deferred<Unit>> e;
        public final /* synthetic */ UserSearchAndMatchStrategy f;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public Object a(Continuation<? super Unit> r1) {
            return e(this, r1);
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public boolean b() {
            if (this.b == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public boolean d() {
            if (this.c != SearchStatus.NET_SEARCH_FINISH) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public ChatChatter c() {
            return this.b;
        }

        public BaseSearchStrategy(UserSearchAndMatchStrategy r2, c r3) {
            Intrinsics.checkNotNullParameter(r3, "searchParams");
            this.f = r2;
            this.a = r3;
            this.c = SearchStatus.NOT_SEARCH;
            this.d = new ArrayList();
        }

        public static Object e(BaseSearchStrategy r7, Continuation<? super Unit> r8) {
            if ((r8 instanceof UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1) == false) goto L7;
            UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1 r2 = (UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1) r8;
            int r3 = r2.label;
            if ((r3 & Target.SIZE_ORIGINAL) == 0) goto L7;
            r2.label = r3 - Target.SIZE_ORIGINAL;
        L8:
            Object r9 = r2.result;
            Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r5 = r2.label;
            if (r5 == 0) goto L20;
            if (r5 == 1) goto L17;
            if (r5 != 2) goto L16;
            r7 = (BaseSearchStrategy) r2.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Exception -> L35
        L33:
            Log.i(r7.f.i, "[awaitFinish]end requestId:" + r7.a.d);     // Catch: Exception -> L35
        L38:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            r7 = (BaseSearchStrategy) r2.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Exception -> L35
        L28:
            Deferred r10 = (Deferred) r9;     // Catch: Exception -> L35
        L29:
            Log.i(r7.f.i, "[awaitFinish]wait execute end");     // Catch: Exception -> L35
        L30:
            List<Deferred<Unit>> r11 = r7.d;     // Catch: Exception -> L35
            r2.L$0 = r7;     // Catch: Exception -> L35
            r2.label = 2;     // Catch: Exception -> L35
            if (AwaitKt.a(r11, r2) != r4) goto L33;
            return r4;
        L20:
            ResultKt.throwOnFailure(r9);
            Log.i(r7.f.i, "[awaitFinish]start requestId:" + r7.a.d + " deferred size:" + ((ArrayList) r7.d).size());     // Catch: Exception -> L35
            if (((ArrayList) r7.d).isEmpty() == false) goto L30;
            Log.i(r7.f.i, "[awaitFinish]wait execute start");     // Catch: Exception -> L35
            Deferred<? extends Deferred<Unit>> r12 = r7.e;     // Catch: Exception -> L35
            if (r12 == null) goto L29;
            r2.L$0 = r7;     // Catch: Exception -> L35
            r2.label = 1;     // Catch: Exception -> L35
            r9 = r12.await(r2);     // Catch: Exception -> L35
            if (r9 != r4) goto L28;
            return r4;
        L35:
            e = move-exception;
            Log.e(r7.f.i, "[awaitFinish]error", e);
        L7:
            r2 = new UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1(r7, r8);
            goto L8
        }
    }

    public final class ClientSearchStrategy extends BaseSearchStrategy {
        public final c g;
        public final String h;
        public final /* synthetic */ UserSearchAndMatchStrategy i;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final void startSearch() {
            c r0 = this.g;
            this.e = BuildersKt.async$default(this.i.a, Dispatchers.getIO(), null, new UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1(this, r0, null), 2, null);
        }

        public ClientSearchStrategy(UserSearchAndMatchStrategy r2, c r3) {
            Intrinsics.checkNotNullParameter(r3, "searchParams");
            this.i = r2;
            super(r2, r3);
            this.g = r3;
            this.h = "ClientSearchStrategy";
        }

        public final void f(ccb.d r8, boolean r9) {
            if ((!((ArrayList) r8.b).isEmpty()) == false) goto L6;
            Log.i(this.h, "[mathUser]inChatUsers searchKey:" + this.g.a.length() + " userId:" + ((ChatChatter) ListProtector.get(r8.b, 0)).getId() + " fromServer:" + r9);
            ChatChatter r10 = (ChatChatter) ListProtector.get(r8.b, 0);
            r10.setOutChatUser(false);
        L9:
            if (r10 != null) goto L11;
            return;
        L11:
            if (r10.isBot() == false) goto L14;
            Log.i(this.h, "[mathUser]searchKey:" + this.g.a.length() + " userId:" + r10.getId() + " is bot");
            return;
        L14:
            if (r9 == false) goto L17;
            this.b = r10;
            return;
        L17:
            if (this.b != null) goto L22;
            this.b = r10;
            return;
        L22:
            return;
        L6:
            if ((!((ArrayList) r8.c).isEmpty()) == false) goto L8;
            Log.i(this.h, "[mathUser]outChatUsers searchKey:" + this.g.a.length() + "  userId:" + ((ChatChatter) ListProtector.get(r8.c, 0)).getId() + " fromServer:" + r9);
            r10 = (ChatChatter) ListProtector.get(r8.c, 0);
            r10.setOutChatUser(this.i.h ^ true);
            goto L9
        L8:
            Log.e(this.h, "[mathUser]searchKey:" + this.g.a.length() + " userId is empty fromServer:" + r9);
            r10 = null;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/UserSearchAndMatchStrategy$SearchStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_SEARCH", "LOCAL_SEARCH_FINISH", "NET_SEARCH_FINISH", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum SearchStatus extends Enum<SearchStatus> {
        public static final SearchStatus LOCAL_SEARCH_FINISH = null;
        public static final SearchStatus NET_SEARCH_FINISH = null;
        public static final SearchStatus NOT_SEARCH = null;
        public static final /* synthetic */ SearchStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<SearchStatus> getEntries() {
            return b;
        }

        static {
            SearchStatus r0 = new SearchStatus("NOT_SEARCH", 0);
            NOT_SEARCH = r0;
            SearchStatus r1 = new SearchStatus("LOCAL_SEARCH_FINISH", 1);
            LOCAL_SEARCH_FINISH = r1;
            SearchStatus r3 = new SearchStatus("NET_SEARCH_FINISH", 2);
            NET_SEARCH_FINISH = r3;
            SearchStatus[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static SearchStatus[] values() {
            return (SearchStatus[]) a.clone();
        }

        public static SearchStatus valueOf(String r1) {
            return (SearchStatus) r27.a.a(SearchStatus.class, r1);
        }

        public SearchStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final class ServerSearchStrategy extends BaseSearchStrategy {
        public final c g;
        public final String h;
        public final /* synthetic */ UserSearchAndMatchStrategy i;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final void startSearch() {
            String r0 = this.g.c;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            Log.w(this.h, "[startSearch]userIdFromServer is empty");
            return;
        L12:
            c r5 = this.g;
            String r4 = r5.c;
            UserSearchAndMatchStrategy r6 = this.i;
            this.e = BuildersKt.async$default(r6.a, Dispatchers.getIO(), null, new UserSearchAndMatchStrategy$ServerSearchStrategy$startSearch$1$1(this, r4, r5, r6, null), 2, null);
            return;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        public ServerSearchStrategy(UserSearchAndMatchStrategy r2, c r3) {
            Intrinsics.checkNotNullParameter(r3, "searchParams");
            this.i = r2;
            super(r2, r3);
            this.g = r3;
            this.h = "ServerSearchStrategy";
        }
    }

    public interface a {
        Object a(Continuation<? super Unit> r1);

        boolean b();

        ChatChatter c();

        boolean d();

        void startSearch();
    }

    public final class b {
        public final c a;
        public BaseSearchStrategy b;
        public final /* synthetic */ UserSearchAndMatchStrategy c;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MatchMode.values().length];
                r0[MatchMode.ClientMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[MatchMode.ServerMode.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[MatchMode.ServerWithClientMode.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final synchronized boolean a() {
            monitor-enter(this);
            BaseSearchStrategy r0 = this.b;     // Catch: Throwable -> L10
            if (r0 == null) goto L7;
            boolean r1 = r0.d();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return r1;
        L7:
            r1 = false;
        L10:
            th = move-exception;
            throw th;
        }

        public final synchronized ChatChatter b() {
            monitor-enter(this);
            BaseSearchStrategy r0 = this.b;     // Catch: Throwable -> L10
            if (r0 == null) goto L7;
            ChatChatter r1 = r0.c();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return r1;
        L7:
            r1 = null;
        L10:
            th = move-exception;
            throw th;
        }

        public b(UserSearchAndMatchStrategy r2, c r3) {
            Intrinsics.checkNotNullParameter(r3, "searchParams");
            this.c = r2;
            this.a = r3;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.d.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "SearchParams(searchKey=" + this.a + ", chatId=" + this.b + ", userIdFromServer=" + this.c + ", requestId=" + this.d + ')';
        }

        public c(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "searchKey");
            Intrinsics.checkNotNullParameter(r3, "chatId");
            Intrinsics.checkNotNullParameter(r5, "requestId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public final class d extends BaseSearchStrategy {
        public final c g;
        public BaseSearchStrategy h;
        public final String i;
        public final /* synthetic */ UserSearchAndMatchStrategy j;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.BaseSearchStrategy, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final boolean b() {
            BaseSearchStrategy r0 = this.h;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.b();
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.BaseSearchStrategy, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final ChatChatter c() {
            BaseSearchStrategy r0 = this.h;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.c();
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.BaseSearchStrategy, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final boolean d() {
            BaseSearchStrategy r0 = this.h;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.d();
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final void startSearch() {
            Log.i(this.i, "[startSearch]userIdFromServer:" + this.g.c);
            String r0 = this.g.c;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            BaseSearchStrategy r2 = new ClientSearchStrategy(this.j, this.g);
        L12:
            r2.startSearch();
            this.h = r2;
            return;
        L11:
            r2 = new ServerSearchStrategy(this.j, this.g);
            goto L12
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.BaseSearchStrategy, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final Object a(Continuation<? super Unit> r2) {
            BaseSearchStrategy r0 = this.h;
            if (r0 == null) goto L10;
            Object r3 = r0.a(r2);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
            return r3;
        L8:
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        }

        public d(UserSearchAndMatchStrategy r2, c r3) {
            Intrinsics.checkNotNullParameter(r3, "searchParams");
            this.j = r2;
            super(r2, r3);
            this.g = r3;
            this.i = "ServerWithClientModeStrategy";
        }
    }

    public final boolean b() {
        Iterator<T> r0 = this.j.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        b r1 = (b) r0.next();
        String r2 = this.i;
        StringBuilder r3 = new StringBuilder("[hasSearchFinished]searchKey:");
        r3.append(r1.a.d);
        r3.append(" hasResult:");
        monitor-enter(r1);
        BaseSearchStrategy r4 = r1.b;     // Catch: Throwable -> L16
        if (r4 == null) goto L11;
        boolean r5 = r4.b();     // Catch: Throwable -> L16
    L12:
        monitor-exit(r1);
        r3.append(r5);
        r3.append(" hasFinish:");
        r3.append(r1.a());
        Log.i(r2, r3.toString());
        if (r1.a() == true) goto L4;
        return false;
    L11:
        r5 = false;
    L16:
        th = move-exception;
        throw th;
    L19:
        Log.i(this.i, "[hasSearchFinished]ner info.size: " + this.j.size());
        return true;
    }

    public final void c() {
        if ((!this.j.isEmpty()) == false) goto L6;
        Log.i(this.i, "[onSessionEnd]clear searchAndMatchTaskMap");
        this.j.clear();
        return;
    }

    public static String e(com.ss.android.lark.audio.voiceinput.a r2) {
        String r0 = r2.d;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return r0;
    L11:
        return r2.c;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void f(com.ss.android.lark.audio.voiceinput.a r5) {
        if (r5 != null) goto L5;
        Log.e(this.i, "[searchUser]asrUserInfo or chatId is null");
        return;
    L5:
        String r0 = e(r5);
        if (this.j.containsKey(r0) == false) goto L9;
        Log.i(this.i, "[searchUser]searchUser task already exist");
        return;
    L9:
        Log.i(this.i, "[searchUser]searchUser ken_len:" + r0.length());
        b r6 = new b(this, new c(r0, this.b, r5.g, com.ss.android.lark.sdk.a.a()));
        this.j.put(r0, r6);
        MatchMode r1 = this.g;
        Intrinsics.checkNotNullParameter(r1, "matchMode");
        Log.i(r6.c.i, "[SearchAndMatchTask]matchMode:" + r1);
        int r2 = b.a.a[r1.ordinal()];
        if (r2 != 1) goto L12;
        BaseSearchStrategy r3 = new ClientSearchStrategy(r6.c, r6.a);
    L20:
        r6.b = r3;
        r3.startSearch();
        return;
    L12:
        if (r2 != 2) goto L14;
        r3 = new ServerSearchStrategy(r6.c, r6.a);
        goto L20
    L14:
        if (r2 != 3) goto L17;
        r3 = new d(r6.c, r6.a);
        goto L20
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public final String d(String r3, int r4, int r5) {
        if (r3 == null) goto L13;
        if (r4 >= r5) goto L13;
        if (r4 >= r3.length()) goto L13;
        return r3.substring(RangesKt.coerceAtLeast(r4, 0), RangesKt.coerceAtMost(r5, r3.length()));
    L11:
        e = move-exception;
        Log.e(this.i, "[safeSubString]subString error", e);
    L13:
        return "";
    }

    public final Pair<RichText, SpannableStringBuilder> a(String r18, List<com.ss.android.lark.audio.voiceinput.a> r19, int r20, Function2<? super String, ? super Integer, ? extends SpannableStringBuilder> r21) {
        ArrayList r5 = new ArrayList();
        List<com.ss.android.lark.audio.voiceinput.a> r6 = r19;
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L25;
        Object r0 = new SpannableStringBuilder();
        if (r18 != null) goto L14;
        String r8 = "";
    L15:
        int r9 = r8.length();
        if (r20 == (-1)) goto L21;
        if (r20 >= r9) goto L21;
        List r2 = com.ss.android.lark.widget.richtext.c.d(d(r8, 0, r20));
        Intrinsics.checkNotNull(r2);
        r5.addAll(r2);
        if (r21 == null) goto L24;
        r0 = r21.invoke(d(r8, r20, r9), 0);
    L24:
        SpannableStringBuilder r1 = (SpannableStringBuilder) r0;
    L115:
        return new Pair(com.ss.android.lark.widget.richtext.c.b(r5), r1);
    L21:
        List r3 = com.ss.android.lark.widget.richtext.c.d(r18);
        Intrinsics.checkNotNull(r3);
        r5.addAll(r3);
        if (r21 == null) goto L24;
        r0 = r21.invoke("", Integer.valueOf(r20));
        goto L24
    L14:
        r8 = r18;
        goto L15
    L25:
        SpannableStringBuilder r10 = new SpannableStringBuilder();
        Iterator<T> r11 = r19.iterator();
        int r12 = 0;
    L27:
        if (r11.hasNext() == false) goto L79;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        com.ss.android.lark.audio.voiceinput.a r15 = (com.ss.android.lark.audio.voiceinput.a) r13;
        if (r18 == null) goto L37;
        if (r12 != 0) goto L35;
        int r16 = 0;
    L36:
        String r17 = d(r18, r16, r15.a);
    L38:
        if (r17 != null) goto L40;
    L43:
        boolean r110 = true;
    L44:
        if (r110 == true) goto L46;
        List r111 = com.ss.android.lark.widget.richtext.c.d(r17);
        Intrinsics.checkNotNull(r111);
        r5.addAll(r111);
    L46:
        b r112 = this.j.get(e(r15));
        if (r112 == null) goto L68;
        monitor-enter(r112);
        BaseSearchStrategy r113 = r112.b;     // Catch: Throwable -> L65
        if (r113 == null) goto L53;
        boolean r114 = r113.b();     // Catch: Throwable -> L65
    L54:
        monitor-exit(r112);
        if (r114 == false) goto L68;
        ChatChatter r115 = r112.b();
        if (r115 == null) goto L64;
        String r116 = (String) this.c.invoke(r115);
        String r117 = r115.getId();
        boolean r118 = r115.isOutChatUser();
        boolean r22 = r115.isAnonymous();
        String r23 = r115.getLocalizedName();
        Map r119 = RichTextElementCreator.a;
        SpannableStringBuilder r120 = r10;
        Intrinsics.checkNotNullParameter(r23, "originChatterName");
        if (r117 != null) goto L61;
        r117 = "";
    L61:
        if (r116 != null) goto L63;
        r116 = "";
    L63:
        r5.add(RichTextElementCreator.h(RichTextElementCreator.b(r117, r116, r23, r118, r22)));
        r5.add(RichTextElementCreator.e(" "));
        Log.i(this.i, "[buildRichText]user:" + r115.getId() + " isAnonymous:" + r115.isAnonymous() + " isOutOfChatUser:" + r115.isOutChatUser());
    L78:
        r12 = r14;
        r10 = r120;
        goto L27
    L64:
        r120 = r10;
        goto L78
    L53:
        r114 = false;
    L65:
        th = move-exception;
        throw th;
    L68:
        r120 = r10;
        Log.i(this.i, "[buildRichText]asrUserInfo start:" + r15.a + " end:" + r15.b + " not found");
        if (r18 == null) goto L78;
        String r24 = d(r18, r15.a, r15.b);
        if (r24 == null) goto L78;
        if (r24.length() <= 0) goto L75;
        boolean r25 = true;
    L76:
        if (r25 == false) goto L78;
        List r26 = com.ss.android.lark.widget.richtext.c.d(r24);
        Intrinsics.checkNotNull(r26);
        r5.addAll(r26);
        goto L78
    L75:
        r25 = false;
        goto L76
    L40:
        if (r17.length() == 0) goto L43;
        r110 = false;
        goto L44
    L35:
        r16 = ((com.ss.android.lark.audio.voiceinput.a) ListProtector.get(r19, r12 - 1)).b;
        goto L36
    L37:
        r17 = null;
        goto L38
    L79:
        SpannableStringBuilder r121 = r10;
        boolean r27 = true;
        int r28 = ((com.ss.android.lark.audio.voiceinput.a) ListProtector.get(r19, r19.size() - 1)).b;
        if (r18 != null) goto L82;
    L112:
        Object r29 = r121;
    L113:
        r1 = (SpannableStringBuilder) r29;
        goto L115
    L82:
        if (r28 < r18.length()) goto L118;
    L89:
        String r4 = "";
    L90:
        if (r4 == null) goto L112;
        StringBuilder r122 = new StringBuilder();
        if (r4.length() > 0) goto L95;
        r27 = false;
    L95:
        if (r27 == true) goto L97;
        if (r21 == null) goto L110;
        Object r30 = r21.invoke("", Integer.valueOf(r20));
    L109:
        r29 = r30;
    L111:
        Log.i(this.i, r122.toString());
    L110:
        r29 = r121;
        goto L111
    L97:
        if (r20 == (-1)) goto L104;
        if (r20 <= r28) goto L104;
        List r31 = com.ss.android.lark.widget.richtext.c.d(d(r18, r28, r20));
        Intrinsics.checkNotNull(r31);
        r5.addAll(r31);
        String r32 = d(r18, r20, r18.length());
        if (r21 == null) goto L102;
        r30 = r21.invoke(r32, Integer.valueOf(r20));
    L103:
        d(r18, r28, r20);
        d(r18, r20, r18.length());
        goto L109
    L102:
        r30 = r121;
    L104:
        List r33 = com.ss.android.lark.widget.richtext.c.d(r4);
        Intrinsics.checkNotNull(r33);
        r5.addAll(r33);
        if (r21 == null) goto L110;
        r30 = r21.invoke("", Integer.valueOf(r20));
        goto L109
    L118:
        r4 = r18.substring(RangesKt.coerceAtLeast(r28, 0));     // Catch: Exception -> L87
    L87:
        e = move-exception;
        Log.e(this.i, "[safeSubString]subString error", e);
        goto L89
    L5:
        if (r6.isEmpty() == true) goto L8;
        r7 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserSearchAndMatchStrategy(CoroutineScope r2, String r3, Function1<? super ChatChatter, String> r4, Function4<? super String, ? super String, ? super String, ? super Boolean, ? extends ccb.d> r5, Function2<? super String, ? super String, ? extends ChatChatter> r6, Function2<? super String, ? super String, Boolean> r7, MatchMode r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "viewModelScoped");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "getDisplayName");
        Intrinsics.checkNotNullParameter(r5, "syncSearchMentionChatChatters");
        Intrinsics.checkNotNullParameter(r6, "syncGetChatChatter");
        Intrinsics.checkNotNullParameter(r7, "syncCheckUserIsInChat");
        Intrinsics.checkNotNullParameter(r8, "matchMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = "UserSearchAndMatchStrategy";
        this.j = new ConcurrentHashMap();
    }
}
