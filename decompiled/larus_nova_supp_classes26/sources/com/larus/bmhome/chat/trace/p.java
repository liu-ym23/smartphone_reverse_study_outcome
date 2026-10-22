package com.larus.bmhome.chat.trace;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.bmhome.chat.component.list.c5;
import com.larus.bmhome.chat.component.list.d5;
import com.larus.bmhome.chat.list.base.MessageCellHolder;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.TextCellCutType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.list.arch.FlowListViewHolder;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.platform.service.AccountService;
import com.larus.trace.SendingTextEditTriggeredScene;
import com.larus.utils.logger.FLogger;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p implements l0 {
    public final by7.e b;
    public final Lazy c;
    public RecyclerView d;
    public Function0<String> e;
    public Function0<Pair<String, Integer>> f;
    public WeakReference<Activity> g;
    public MessageAdapter h;
    public boolean i;
    public long j;
    public final Set<String> k;
    public final Set<String> l;
    public final Set<String> m;
    public boolean n;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void onResume() {
        this.n = true;
        j();
        Activity r0 = AppHost.a.a().getCurrentActivity();
        WeakReference<Activity> r1 = this.g;
        if (r1 == null) goto L5;
        Activity r2 = r1.get();
    L7:
        if (Intrinsics.areEqual(r0, r2) == true) goto L9;
        a("enter_chat_or_new_message", "background");
        return;
    L9:
        a("foreground", "background");
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void A() {
        if (this.i == true) goto L6;
        this.i = true;
        FLogger.a.d("ChatMessageReadTrace", "first layout completed");
        a("enter_chat_or_new_message", "scroll");
        this.j = System.currentTimeMillis();
        com.larus.bmhome.chat.trace.container.b r0 = com.larus.bmhome.chat.trace.container.b.a;
        com.larus.bmhome.chat.trace.container.b.k();
        return;
    }

    public final TextCellCutType c() {
        return (TextCellCutType) this.c.getValue();
    }

    public final void j() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("tryReportAllExposeItems:");
        l0.a.getClass();
        ConcurrentHashMap<String, s> r2 = l0.a.b;
        r1.append(r2.size());
        r0.d("ChatMessageReadTrace", r1.toString());
        Iterator<Map.Entry<String, s>> r3 = r2.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        h(r3.next().getValue());
        goto L4
    L6:
        l0.a.getClass();
        l0.a.b.clear();
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void onCreate() {
        this.g = new WeakReference(AppHost.a.a().getCurrentActivity());
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void onDestroy() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onDestroy:--------needExpose message:");
        l0.a.getClass();
        ConcurrentHashMap<String, s> r2 = l0.a.b;
        r1.append(r2.size());
        r0.d("ChatMessageReadTrace", r1.toString());
        Iterator<Map.Entry<String, s>> r3 = r2.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Map.Entry<String, s> r4 = r3.next();
        if (r4.getValue().d != (-1)) goto L8;
        s r5 = r4.getValue();
        r5.d = System.currentTimeMillis();
    L8:
        s r6 = r4.getValue();
        r6.getClass();
        Intrinsics.checkNotNullParameter("leave_chat", "<set-?>");
        r6.e = "leave_chat";
        goto L4
    L9:
        GlobalScope r7 = GlobalScope.INSTANCE;
        j();
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void onPause() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onPause:----expose size:");
        l0.a r2 = l0.a;
        r2.getClass();
        ConcurrentHashMap<String, s> r3 = l0.a.b;
        r1.append(r3.size());
        r1.append("------");
        r1.append(AppHost.a.a().getCurrentActivity());
        r0.d("ChatMessageReadTrace", r1.toString());
        this.n = false;
        this.i = true;
        r2.getClass();
        Iterator<Map.Entry<String, s>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L14;
        Map.Entry<String, s> r5 = r4.next();
        if (r5.getValue().d != (-1)) goto L9;
        s r6 = r5.getValue();
        r6.d = System.currentTimeMillis();
    L9:
        if (r5.getValue().z != 0) goto L13;
        if (r5.getValue().y == 0) goto L13;
        s r7 = r5.getValue();
        r7.z = System.currentTimeMillis();
    L13:
        s r8 = r5.getValue();
        r8.getClass();
        Intrinsics.checkNotNullParameter("background", "<set-?>");
        r8.e = "background";
        goto L4
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void onStop() {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        WeakReference<Activity> r1 = this.g;
        if (r1 == null) goto L5;
        Activity r2 = r1.get();
    L6:
        boolean r3 = !Intrinsics.areEqual(r0, r2);
        l0.a.getClass();
        ConcurrentHashMap<String, s> r4 = l0.a.b;
        if (r4.isEmpty() == true) goto L23;
        if (r3 == false) goto L22;
        Iterator<Map.Entry<String, s>> r5 = r4.entrySet().iterator();
    L12:
        if (r5.hasNext() == false) goto L17;
        Map.Entry<String, s> r6 = r5.next();
        if (r6.getValue().d != (-1)) goto L16;
        r6.getValue().d = System.currentTimeMillis();
    L16:
        s r7 = r6.getValue();
        r7.getClass();
        Intrinsics.checkNotNullParameter("leave_chat", "<set-?>");
        r7.e = "leave_chat";
        goto L12
    L17:
        j();
        return;
    L22:
        return;
    L23:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void z() {
        FLogger.a.i("ChatMessageReadTrace", "onKeyboardShow");
        w(SendingTextEditTriggeredScene.EDIT_TEXT);
        a("scroll", "scroll");
    }

    public final void e(List<Message> r10) {
        LinkedHashSet r0 = new LinkedHashSet();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Message r2 = (Message) r11.next();
        if (r2 == null) goto L8;
        String r3 = r2.getMessageId();
    L9:
        r1.add(Boolean.valueOf(r0.add(r3)));
        goto L4
    L8:
        r3 = null;
        goto L9
    L10:
        l0.a.getClass();
        Iterator<T> r12 = l0.a.b.keySet().iterator();
    L12:
        if (r12.hasNext() == false) goto L26;
        String r4 = (String) r12.next();
        if (r0.contains(r4) == true) goto L12;
        l0.a.getClass();
        ConcurrentHashMap<String, s> r5 = l0.a.b;
        s r6 = r5.get(r4);
        if (r6 != null) goto L18;
    L20:
        boolean r7 = false;
    L21:
        if (r7 == false) goto L23;
        r6.d = System.currentTimeMillis();
    L23:
        if (r6 == null) goto L25;
        Intrinsics.checkNotNullParameter("scroll", "<set-?>");
        r6.e = "scroll";
    L25:
        r5.remove(r4);
        h(r6);
        FLogger.a.d("ChatMessageReadTrace", "message is deleted----" + r4);
        goto L12
    L18:
        if (r6.d != (-1)) goto L20;
        r7 = true;
        goto L21
    }

    public final void f(Message r10) {
        String r0 = r10.getMessageId();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L11;
        return;
    L11:
        if (r.b(r10) == false) goto L14;
        return;
    L14:
        if (this.m.add(r0) == true) goto L16;
        return;
    L16:
        AccountService r3 = AccountService.a;
        long r5 = System.currentTimeMillis();
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("message_count", "1");
        String r11 = r10.getConversationId();
        if (r11 != null) goto L19;
        r11 = "";
    L19:
        r1[1] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, r11);
        r3.p("browse_excessive_chat_history", r5, MapsKt.mapOf(r1), "ChatMessageReadTrace");
    }

    public final void h(s r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatMessageReadTrace$trackReadMessage$1(r7, this, null), 2, null);
    }

    public final void i(String r8) {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.j) <= 500) goto L10;
        FLogger.a.d("ChatMessageReadTrace", r8);
        if (this.i == false) goto L7;
        String r9 = "scroll";
    L8:
        a(r9, "scroll");
        this.j = r0;
        return;
    L7:
        r9 = "enter_chat_or_new_message";
        goto L8
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void p(Message r9) {
        Intrinsics.checkNotNullParameter(r9, "message");
        String r3 = "";
        if (CollectionsKt.contains(this.k, r9.getMessageId()) == true) goto L5;
        String r0 = r9.getReplyId();
        if (r0 != null) goto L21;
    L24:
        boolean r1 = true;
    L25:
        if (r1 == false) goto L27;
        return;
    L27:
        Map r2 = r9.getExt();
        if (r2 == null) goto L30;
        String r4 = (String) r2.get("is_deep_thinking");
    L32:
        if (Intrinsics.areEqual("1", r4) == true) goto L34;
    L44:
        Set<String> r5 = this.k;
        String r6 = r9.getMessageId();
        if (r6 != null) goto L47;
        r6 = "";
    L47:
        r5.add(r6);
        String r10 = r9.getReplyId();
        if (r10 == null) goto L51;
        r3 = r10;
    L51:
        l0.a.getClass();
        Iterator<Map.Entry<String, s>> r11 = l0.a.b.entrySet().iterator();
    L53:
        if (r11.hasNext() == false) goto L68;
        Map.Entry<String, s> r7 = r11.next();
        Message r8 = r7.getValue().g;
        if (r8 == null) goto L57;
        String r12 = r8.getReplyId();
    L59:
        if (Intrinsics.areEqual(r12, r3) == true) goto L53;
        if (r7.getValue().k == false) goto L53;
        if (r7.getValue().c != (-1)) goto L66;
        r7.getValue().c = System.currentTimeMillis();
    L66:
        if (r7.getValue().t != null) goto L53;
        r7.getValue().t = "edit";
        goto L53
    L57:
        r12 = null;
        goto L59
    L68:
        return;
    L34:
        if (com.larus.bmhome.chat.bean.d.e0(r9) == true) goto L44;
        Set<String> r13 = this.l;
        String r14 = r9.getMessageId();
        if (r14 != null) goto L38;
        r14 = "";
    L38:
        r13.add(r14);
        l0.a.getClass();
        ConcurrentHashMap<String, s> r15 = l0.a.b;
        String r16 = r9.getMessageId();
        if (r16 != null) goto L41;
        r16 = "";
    L41:
        s r17 = r15.get(r16);
        if (r17 == null) goto L44;
        r17.r = true;
        goto L44
    L30:
        r4 = null;
        goto L32
    L21:
        if (r0.length() == 0) goto L24;
        r1 = false;
        goto L25
    L5:
        if (CollectionsKt.contains(this.l, r9.getMessageId()) == true) goto L7;
        return;
    L7:
        if (com.larus.bmhome.chat.bean.d.e0(r9) == false) goto L79;
        Set<String> r18 = this.l;
        String r19 = r9.getMessageId();
        if (r19 == null) goto L12;
        r3 = r19;
    L12:
        r18.remove(r3);
        l0.a.getClass();
        s r20 = l0.a.b.get(r9.getMessageId());
        if (r20 != null) goto L15;
        return;
    L15:
        if (r20.s != (-1)) goto L81;
        r20.s = System.currentTimeMillis();
        return;
    L81:
        return;
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void r(MessageAdapter r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.bmhome.chat.adapter.MessageAdapter");
        this.h = r2;
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void s(ChatMessageList r1) {
        this.d = r1;
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void t(d5 r2) {
        Intrinsics.checkNotNullParameter(r2, "botInfoGetter");
        this.f = r2;
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void v(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "chatMessage");
        Set<String> r0 = this.k;
        TypeIntrinsics.asMutableCollection(r0).remove(r7.getMessageId());
        Set<String> r1 = this.l;
        TypeIntrinsics.asMutableCollection(r1).remove(r7.getMessageId());
        RecyclerView r2 = this.d;     // Catch: Exception -> L20
        LinearLayoutManager r3 = null;
        if (r2 == null) goto L6;
        RecyclerView.LayoutManager r4 = r2.getLayoutManager();     // Catch: Exception -> L20
    L8:
        if ((r4 instanceof LinearLayoutManager) == false) goto L10;
        r3 = (LinearLayoutManager) r4;     // Catch: Exception -> L20
    L10:
        if (r3 == null) goto L22;
        MessageAdapter r5 = this.h;     // Catch: Exception -> L20
        if (r5 == null) goto L22;
        List<Message> r6 = r5.getCurrentList();     // Catch: Exception -> L20
        int r8 = r3.findFirstVisibleItemPosition();     // Catch: Exception -> L20
        int r9 = r3.findLastVisibleItemPosition();     // Catch: Exception -> L20
        Message r10 = (Message) CollectionsKt.getOrNull(r6, r8);     // Catch: Exception -> L20
        Message r11 = (Message) CollectionsKt.getOrNull(r6, r9);     // Catch: Exception -> L20
        if (r10 != null) goto L18;
        if (r11 != null) goto L18;
        FLogger.a.d("ChatMessageReadTrace", "on expose data -----return ");     // Catch: Exception -> L20
    L18:
        k(r6, r8, r9);     // Catch: Exception -> L20
        l(r6, r8, r9);     // Catch: Exception -> L20
    L22:
        i("onMessageTypeWriterEnd for msg. msg_id=" + r7.getMessageId() + " local_msg_id=" + r7.getLocalMessageId());
        return;
    L6:
        r4 = null;
    L20:
        e = move-exception;
        j();
        FLogger.a.d("ChatMessageReadTrace", "updateHeightWhenTypingEnd meet crash " + e + ' ');
        goto L22
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void w(SendingTextEditTriggeredScene r9) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        long r0 = System.currentTimeMillis();
        l0.a.getClass();
        Iterator<Map.Entry<String, s>> r10 = l0.a.b.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L21;
        s r2 = r10.next().getValue();
        if (r2.k == false) goto L4;
        if (r2.c != (-1)) goto L11;
        r2.c = r0;
    L11:
        if (r2.d != (-1)) goto L14;
        r2.d = r0;
    L14:
        if (r2.r == false) goto L19;
        if (r2.s != (-1)) goto L19;
        r2.s = r0;
    L19:
        if (r2.t != null) goto L4;
        r2.t = "edit";
        goto L4
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void x(c5 r2) {
        Intrinsics.checkNotNullParameter(r2, "chatTypeGetter");
        this.e = r2;
    }

    public p(Fragment r2, by7.e r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "iTrackNode");
        this.b = r3;
        this.c = LazyKt.lazy(new n());
        this.j = -1;
        this.k = new LinkedHashSet();
        this.l = new LinkedHashSet();
        this.m = new LinkedHashSet();
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void C(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        if (r3 != 0) goto L6;
        a("scroll", "scroll");
        return;
    }

    public final void a(String r18, String r19) {
        RecyclerView r7 = this.d;
        Long r8 = null;
        if (r7 == null) goto L5;
        RecyclerView.LayoutManager r9 = r7.getLayoutManager();
    L7:
        if ((r9 instanceof LinearLayoutManager) == false) goto L9;
        LinearLayoutManager r10 = (LinearLayoutManager) r9;
    L10:
        if (r10 != null) goto L12;
        return;
    L12:
        MessageAdapter r11 = this.h;
        if (r11 == null) goto L52;
        List<Message> r12 = r11.getCurrentList();
        int r13 = r10.findFirstVisibleItemPosition();     // Catch: Exception -> L43
        int r14 = r10.findLastVisibleItemPosition();     // Catch: Exception -> L43
        Message r15 = (Message) CollectionsKt.getOrNull(r12, r13);     // Catch: Exception -> L43
        Message r16 = (Message) CollectionsKt.getOrNull(r12, r14);     // Catch: Exception -> L43
        FLogger r17 = FLogger.a;     // Catch: Exception -> L43
        StringBuilder r110 = new StringBuilder("checkVisibleItemExpose [");     // Catch: Exception -> L43
        r110.append(r18);     // Catch: Exception -> L43
        r110.append(',');     // Catch: Exception -> L43
        r110.append(r19);     // Catch: Exception -> L43
        r110.append("]  visiblePos=[");     // Catch: Exception -> L43
        r110.append(r13);     // Catch: Exception -> L43
        r110.append(',');     // Catch: Exception -> L43
        r110.append(r14);     // Catch: Exception -> L43
        r110.append("] first=");     // Catch: Exception -> L43
        if (r15 == null) goto L18;
        String r6 = r15.getMessageId();     // Catch: Exception -> L43
    L19:
        r110.append(r6);     // Catch: Exception -> L43
        r110.append('_');     // Catch: Exception -> L43
        if (r15 == null) goto L22;
        Long r111 = Long.valueOf(r15.getLocalIndex());     // Catch: Exception -> L43
    L23:
        r110.append(r111);     // Catch: Exception -> L43
        r110.append(" last=");     // Catch: Exception -> L43
        if (r16 == null) goto L26;
        String r112 = r16.getMessageId();     // Catch: Exception -> L43
    L27:
        r110.append(r112);     // Catch: Exception -> L43
        r110.append('_');     // Catch: Exception -> L43
        if (r16 == null) goto L30;
        r8 = Long.valueOf(r16.getLocalIndex());     // Catch: Exception -> L43
    L30:
        r110.append(r8);     // Catch: Exception -> L43
        r17.i("ChatMessageReadTrace", r110.toString());     // Catch: Exception -> L43
        if (r15 != null) goto L41;
        if (r16 != null) goto L41;
        r17.d("ChatMessageReadTrace", "on expose data -----return ");     // Catch: Exception -> L43
        l0.a.getClass();     // Catch: Exception -> L43
        Iterator<Map.Entry<String, s>> r0 = l0.a.b.entrySet().iterator();     // Catch: Exception -> L43
    L35:
        if (r0.hasNext() == false) goto L39;
        Map.Entry<String, s> r2 = r0.next();     // Catch: Exception -> L43
        if (r2.getValue().d != (-1)) goto L35;
        r2.getValue().d = System.currentTimeMillis();     // Catch: Exception -> L43
        goto L35
    L39:
        j();     // Catch: Exception -> L43
        return;
    L41:
        this.i = true;     // Catch: Exception -> L43
        StringBuilder r20 = new StringBuilder("checkVisibleItemExpose:");     // Catch: Exception -> L43
        r20.append(r18);     // Catch: Exception -> L43
        r20.append("--------before size:");     // Catch: Exception -> L43
        l0.a.getClass();     // Catch: Exception -> L43
        ConcurrentHashMap<String, s> r21 = l0.a.b;     // Catch: Exception -> L43
        r20.append(r21.size());     // Catch: Exception -> L43
        r20.append("---------");     // Catch: Exception -> L43
        r17.d("ChatMessageReadTrace", r20.toString());     // Catch: Exception -> L43
        g(r12, r13, r14, r18);     // Catch: Exception -> L43
        k(r12, r13, r14);     // Catch: Exception -> L43
        l(r12, r13, r14);     // Catch: Exception -> L43
        b(r12, r13, r14, r19);     // Catch: Exception -> L43
        r17.d("ChatMessageReadTrace", "checkVisibleItemExpose:" + r18 + "--------after size:" + r21.size() + "---------");     // Catch: Exception -> L43
        return;
    L26:
        r112 = null;
        goto L27
    L22:
        r111 = null;
        goto L23
    L18:
        r6 = null;
    L43:
        e = move-exception;
        j();
        FLogger.a.d("ChatMessageReadTrace", "checkVisibleItemExpose crash :" + e);
        return;
    L52:
        return;
    L9:
        r10 = null;
        goto L10
    L5:
        r9 = null;
        goto L7
    }

    public final po8.p d(RecyclerView r4, int r5) {
        if (c() != TextCellCutType.NewTextCell) goto L5;
    L6:
        if (r4 == null) goto L8;
        RecyclerView.ViewHolder r6 = r4.findViewHolderForAdapterPosition(r5);
    L10:
        if ((r6 instanceof MessageCellHolder) == false) goto L12;
        MessageCellHolder r7 = (MessageCellHolder) r6;
    L13:
        if (r7 == null) goto L24;
        BaseCompositeTextCell r8 = ((FlowListViewHolder) r7).b;
        if ((r8 instanceof BaseCompositeTextCell) == false) goto L18;
        BaseCompositeTextCell r9 = r8;
    L19:
        if (r9 != null) goto L22;
        return null;
    L22:
        return IFlowMainBot.a.g8(r9);
    L18:
        r9 = null;
        goto L19
    L24:
        return null;
    L12:
        r7 = null;
        goto L13
    L8:
        r6 = null;
        goto L10
    L5:
        if (c() == TextCellCutType.NewCutThreeTextCell) goto L6;
        return null;
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void q(boolean r2, Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if (r2 == false) goto L5;
        return;
    L5:
        if (com.larus.bmhome.chat.bean.d.Q0(r3) == false) goto L9;
        a("click_expand", "click_expand");
        return;
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void y(int r4, int r5) {
        FLogger.a.d("ChatMessageReadTrace", "onItemRangeRemoved positionStart：" + r4 + " itemCount:" + r5);
        SoftReference r6 = com.larus.utils.y.a;
        Runnable r7 = new o(this);
        Intrinsics.checkNotNullParameter(r7, "action");
        com.larus.utils.y.c(r7);
    }

    public final void k(List<Message> r12, int r13, int r14) {
        if (c() != TextCellCutType.NewCutThreeTextCell) goto L5;
    L61:
        LinkedHashMap r0 = new LinkedHashMap();
        ArrayList r1 = new ArrayList();
        Iterator<T> r15 = r12.iterator();
        int r5 = 0;
    L63:
        if (r15.hasNext() == false) goto L84;
        Object r6 = r15.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L67;
        CollectionsKt.throwIndexOverflow();
    L67:
        Message r8 = (Message) r6;
        if (r13 > r5) goto L71;
        if (r5 > r14) goto L71;
        boolean r9 = true;
    L72:
        if (r9 == false) goto L80;
        List r10 = (List) r0.get(r8.getMessageId());
        if (r10 != null) goto L76;
        r10 = new ArrayList();
    L76:
        r10.add(Integer.valueOf(r5));
        String r11 = r8.getMessageId();
        if (r11 != null) goto L79;
        r11 = "";
    L79:
        r0.put(r11, r10);
        boolean r16 = true;
    L81:
        if (r16 == false) goto L83;
        r1.add(r6);
    L83:
        r5 = r7;
        goto L63
    L80:
        r16 = false;
    L71:
        r9 = false;
        goto L72
    L84:
        Iterator r17 = r1.iterator();
    L86:
        if (r17.hasNext() == false) goto L139;
        Message r18 = (Message) r17.next();
        l0.a.getClass();
        s r19 = l0.a.b.get(r18.getMessageId());
        if (r19 == null) goto L86;
        List r2 = (List) r0.get(r18.getMessageId());
        if (r2 == null) goto L86;
        Iterator r3 = r2.iterator();
        int r4 = 0;
        int r20 = 0;
    L95:
        if (r3.hasNext() == false) goto L138;
        int r21 = ((Number) r3.next()).intValue();
        RecyclerView r22 = this.d;
        if (r22 == null) goto L103;
        RecyclerView.ViewHolder r23 = r22.findViewHolderForAdapterPosition(r21);
        if (r23 == null) goto L103;
        View r24 = r23.itemView;
        if (r24 == null) goto L103;
        int r25 = r24.getHeight();
    L104:
        r4 = r4 + r25;
        if (com.larus.im.bean.message.a.f0(r18) == false) goto L95;
        po8.p r26 = d(this.d, r21);
        if (r26 == null) goto L111;
        ViewGroup r27 = r26.getThinkingContainer();
        if (r27 == null) goto L111;
        int r28 = (int) c7.d(Integer.valueOf(r27.getHeight()));
    L112:
        RecyclerView r29 = this.d;
        if (c() != TextCellCutType.DeepThinkCutMultipleCell) goto L136;
        ComponentCellStateType r30 = null;
        if (r29 == null) goto L117;
        RecyclerView.Adapter r31 = r29.getAdapter();
    L119:
        if ((r31 instanceof MessageAdapter) == false) goto L121;
        MessageAdapter r32 = (MessageAdapter) r31;
    L122:
        if (r32 == null) goto L126;
        List r33 = r32.z2();
        if (r33 == null) goto L126;
        xc8.b r34 = (xc8.b) CollectionsKt.getOrNull(r33, r21);
    L127:
        if (r29 == null) goto L129;
        RecyclerView.ViewHolder r35 = r29.findViewHolderForAdapterPosition(r21);
    L130:
        if (r34 == null) goto L133;
        r30 = r34.f();
    L133:
        if (r30 != ComponentCellStateType.DEEP_THINK_CONTENT_CELL) goto L136;
        if (r35 == null) goto L136;
        int r36 = r35.itemView.getHeight();
    L137:
        r20 = r20 + RangesKt.coerceAtLeast(r36, r28);
        goto L95
    L129:
        r35 = null;
    L126:
        r34 = null;
        goto L127
    L121:
        r32 = null;
        goto L122
    L117:
        r31 = null;
    L136:
        r36 = 0;
    L111:
        r28 = 0;
    L103:
        r25 = 0;
        goto L104
    L138:
        r19.j = r4;
        r19.x = RangesKt.coerceAtLeast(r20, r19.x);
        goto L86
    L139:
        return;
    L5:
        if (c() == TextCellCutType.DeepThinkCutMultipleCell) goto L61;
        LinkedHashMap r37 = new LinkedHashMap();
        ArrayList r38 = new ArrayList();
        Iterator<T> r110 = r12.iterator();
        int r39 = 0;
    L9:
        if (r110.hasNext() == false) goto L27;
        Object r40 = r110.next();
        int r41 = r39 + 1;
        if (r39 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        Message r42 = (Message) r40;
        if (r13 > r39) goto L17;
        if (r39 > r14) goto L17;
        boolean r43 = true;
    L18:
        if (r43 == false) goto L23;
        String r44 = r42.getMessageId();
        if (r44 != null) goto L22;
        r44 = "";
    L22:
        r37.put(r44, Integer.valueOf(r39));
        boolean r45 = true;
    L24:
        if (r45 == false) goto L26;
        r38.add(r40);
    L26:
        r39 = r41;
        goto L9
    L23:
        r45 = false;
    L17:
        r43 = false;
        goto L18
    L27:
        Iterator r111 = r38.iterator();
    L29:
        if (r111.hasNext() == false) goto L60;
        Message r112 = (Message) r111.next();
        if (r112.getMessageId() == null) goto L29;
        l0.a.getClass();
        ConcurrentHashMap<String, s> r113 = l0.a.b;
        if (r113.containsKey(r112.getMessageId()) == false) goto L29;
        Integer r46 = (Integer) r37.get(r112.getMessageId());
        if (r46 == null) goto L37;
        int r47 = r46.intValue();
    L38:
        RecyclerView r48 = this.d;
        if (r48 == null) goto L45;
        RecyclerView.ViewHolder r49 = r48.findViewHolderForAdapterPosition(r47);
        if (r49 == null) goto L45;
        View r50 = r49.itemView;
        if (r50 == null) goto L45;
        int r51 = r50.getHeight();
    L46:
        s r114 = r113.get(r112.getMessageId());
        if (r114 == null) goto L50;
        r114.j = r51;
    L50:
        if (com.larus.im.bean.message.a.f0(r112) == false) goto L29;
        po8.p r115 = d(this.d, r47);
        if (r114 == null) goto L29;
        int r52 = r114.x;
        if (r115 == null) goto L58;
        ViewGroup r116 = r115.getThinkingContainer();
        if (r116 == null) goto L58;
        int r117 = (int) c7.d(Integer.valueOf(r116.getHeight()));
    L59:
        r114.x = Math.max(r52, r117);
    L58:
        r117 = 0;
    L45:
        r51 = 0;
        goto L46
    L37:
        r47 = 0;
        goto L38
    }

    /* JADX WARN: Type inference failed for: r5v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    public final void l(List<Message> r26, int r27, int r28) {
        List<Message> r1 = r26;
        int r8 = 23;
        String r11 = " message.messageStatusLocal == MessageStatusLocal.RECEIVE_INTERRUPT = ";
        String r12 = "  info.isThinkingContentBottomShown = ";
        String r15 = "info.isThinkingContentFinishedGeneration = ";
        if (c() != TextCellCutType.NewCutThreeTextCell) goto L5;
    L119:
        String r19 = "info.isThinkingContentFinishedGeneration = ";
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<T> r5 = r26.iterator();
        int r6 = 0;
    L121:
        if (r5.hasNext() == false) goto L139;
        Object r7 = r5.next();
        int r9 = r6 + 1;
        if (r6 >= 0) goto L125;
        CollectionsKt.throwIndexOverflow();
    L125:
        Message r10 = (Message) r7;
        if (r27 > r6) goto L129;
        if (r6 > r28) goto L129;
        boolean r16 = true;
    L130:
        if (r16 == false) goto L138;
        List r17 = (List) r4.get(r10.getMessageId());
        if (r17 != null) goto L134;
        r17 = new ArrayList();
    L134:
        r17.add(Integer.valueOf(r6));
        String r13 = r10.getMessageId();
        if (r13 != null) goto L137;
        r13 = "";
    L137:
        r4.put(r13, r17);
    L138:
        r6 = r9;
    L129:
        r16 = false;
        goto L130
    L139:
        int[] r2 = new int[2];
        RecyclerView r3 = this.d;
        if (r3 == null) goto L142;
        r3.getLocationOnScreen(r2);
    L142:
        int r14 = r2[1];
        RecyclerView r18 = this.d;
        if (r18 == null) goto L145;
        int r20 = r18.getHeight();
    L146:
        int r21 = r20 + r14;
        Iterator r22 = r4.entrySet().iterator();
    L148:
        if (r22.hasNext() == false) goto L365;
        Map.Entry r23 = (Map.Entry) r22.next();
        l0.a.getClass();
        s r24 = l0.a.b.get(r23.getKey());
        if (r24 != null) goto L152;
    L151:
        Iterator r29 = r22;
    L363:
        String r25 = r11;
    L364:
        r22 = r29;
        r14 = r14;
        r12 = r12;
        r11 = r25;
        r1 = r26;
        goto L148
    L152:
        Integer r30 = (Integer) CollectionsKt.firstOrNull((List) r23.getValue());
        if (r30 == null) goto L151;
        int r31 = r30.intValue();
        Integer r32 = (Integer) CollectionsKt.lastOrNull((List) r23.getValue());
        if (r32 == null) goto L151;
        int r33 = r32.intValue();
        Message r110 = (Message) ListProtector.get(r1, r31);
        r24.g = r110;
        if (com.larus.bmhome.chat.bean.d.Q0(r110) == true) goto L161;
        r29 = r22;
        if (r110.getMessageStatusLocal() == 23) goto L162;
        boolean r34 = true;
    L163:
        r24.m = r34;
        RecyclerView r35 = this.d;
        if (r35 == null) goto L363;
        r24.q = Integer.valueOf((r35.getHeight() - r35.getPaddingTop()) - r35.getPaddingBottom());
        Integer r36 = (Integer) CollectionsKt.firstOrNull((List) r23.getValue());
        if (r36 == null) goto L363;
        int r37 = r36.intValue();
        String r210 = r11;
        RecyclerView r111 = this.d;
        if (r111 == null) goto L361;
        RecyclerView.ViewHolder r112 = r111.findViewHolderForAdapterPosition(r37);
        if (r112 == null) goto L361;
        View r113 = r112.itemView;
        if (r113 == null) goto L361;
        Message r38 = (Message) CollectionsKt.getOrNull(r1, r37 - 1);
        if (r38 == null) goto L178;
        String r39 = r38.getMessageId();
    L180:
        if (Intrinsics.areEqual(r39, r110.getMessageId()) == true) goto L187;
        int[] r40 = new int[2];
        r113.getLocationOnScreen(r40);
        int r41 = r40[1] + r113.getHeight();
        if (r41 <= r21) goto L184;
    L186:
        Integer r42 = Integer.valueOf(r41);
    L188:
        Integer r114 = (Integer) CollectionsKt.lastOrNull((List) r23.getValue());
        if (r114 == null) goto L358;
        int r115 = r114.intValue();
        RecyclerView r116 = this.d;
        if (r116 == null) goto L358;
        RecyclerView.ViewHolder r117 = r116.findViewHolderForAdapterPosition(r115);
        if (r117 == null) goto L358;
        View r118 = r117.itemView;
        if (r118 == null) goto L358;
        Message r119 = (Message) CollectionsKt.getOrNull(r1, r115 + 1);
        if (r119 == null) goto L200;
        String r120 = r119.getMessageId();
    L202:
        if (Intrinsics.areEqual(r120, r110.getMessageId()) == true) goto L207;
        int[] r43 = new int[2];
        r118.getLocationOnScreen(r43);
        int r44 = r43[1];
        if (r44 < r14) goto L206;
        r24.n = true;
    L206:
        Integer r45 = Integer.valueOf(r44);
    L209:
        if (Intrinsics.areEqual(r39, r110.getMessageId()) == true) goto L211;
    L213:
        if (r45 == null) goto L222;
        if (r42 == null) goto L222;
        if (r45.intValue() <= r14) goto L218;
    L220:
        boolean r46 = false;
    L221:
        r24.l = r46;
        goto L222
    L218:
        if (r42.intValue() < r21) goto L220;
        r46 = true;
    L222:
        Iterable r47 = (Iterable) r23.getValue();
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator r49 = r47.iterator();
    L224:
        if (r49.hasNext() == false) goto L232;
        int r50 = ((Number) r49.next()).intValue();
        RecyclerView r51 = this.d;
        if (r51 == null) goto L230;
        RecyclerView.ViewHolder r52 = r51.findViewHolderForAdapterPosition(r50);
        if (r52 == null) goto L230;
        View r53 = r52.itemView;
    L231:
        r48.add(TuplesKt.to(r53, Integer.valueOf(r50)));
    L230:
        r53 = null;
        goto L231
    L232:
        ArrayList r54 = new ArrayList();
        Iterator r55 = r48.iterator();
    L234:
        if (r55.hasNext() == false) goto L242;
        Object r56 = r55.next();
        if (((Pair) r56).getFirst() == null) goto L238;
        boolean r57 = true;
    L239:
        if (r57 == false) goto L234;
        r54.add(r56);
        goto L234
    L238:
        r57 = false;
        goto L239
    L242:
        if (r54.isEmpty() == true) goto L250;
        Iterator r58 = r54.iterator();
    L246:
        if (r58.hasNext() == false) goto L250;
        Pair r59 = (Pair) r58.next();
        Object r60 = r59.getFirst();
        Intrinsics.checkNotNull(r60);
        View r61 = (View) r60;
        if (IFlowMainBot.a.f8(((Number) r59.getSecond()).intValue(), r35) == false) goto L246;
        boolean r62 = true;
    L251:
        if (r62 == false) goto L254;
        r24.p = true;
    L254:
        if (com.larus.im.bean.message.a.f0(r110) == false) goto L358;
        if (com.larus.bmhome.chat.bean.d.f0(r110) == false) goto L258;
    L260:
        boolean r63 = false;
    L261:
        r24.u = r63;
        String r64 = r19;
        FLogger.a.d("ChatMessageReadTrace", r64 + r24.u);
        Iterable r65 = (Iterable) r23.getValue();
        ArrayList r66 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r65, 10));
        Iterator r67 = r65.iterator();
    L263:
        if (r67.hasNext() == false) goto L265;
        r66.add(d(r35, ((Number) r67.next()).intValue()));
        goto L263
    L265:
        Iterator r68 = r66.iterator();
    L267:
        if (r68.hasNext() == false) goto L274;
        Object r69 = r68.next();
        if (((po8.p) r69) == null) goto L271;
        boolean r70 = true;
    L272:
        if (r70 == false) goto L267;
    L275:
        po8.p r71 = (po8.p) r69;
        if (r71 == null) goto L282;
        DeepThinkFoldStatus r72 = r71.getDeepThinkFoldStatus();
        if (r72 == null) goto L282;
        boolean r73 = true;
        ?? r74 = 1;
        if (ic8.q.b(r72) != true) goto L283;
        boolean r121 = true;
    L285:
        if (r121 == false) goto L295;
        int[] r75 = new int[2];
        r71.getView().getLocationOnScreen(r75);
        int r76 = r75[r74];
        if ((r71.getView().getHeight() + r76) <= r21) goto L289;
    L291:
        if (r76 < r14) goto L295;
        if (r24.v == true) goto L295;
        r24.v = r74;
        r24.y = System.currentTimeMillis();
        FLogger.a.d("ChatMessageReadTrace", "info.isThinkingContentTopShown = true thinkingReadStartTimeStamp = " + r24.y);
        goto L295
    L289:
        if (com.larus.bmhome.chat.bean.d.f0(r110) == true) goto L291;
        r24.w = r74;
        FLogger.a.d("ChatMessageReadTrace", "info.isThinkingContentBottomShown = true");
    L295:
        IFlowMainBot.Companion r77 = IFlowMainBot.a;
        MessageAdapter r78 = this.h;
        Intrinsics.checkNotNull(r78, "null cannot be cast to non-null type com.larus.bmhome.chat.api.MessageAdapter");
        DeepThinkFoldStatus r79 = r77.q8(r110, r78);
        if (ic8.q.b(r79) == false) goto L327;
        RecyclerView r80 = this.d;
        if (r80 == null) goto L300;
        RecyclerView.Adapter r81 = r80.getAdapter();
    L302:
        if ((r81 instanceof MessageAdapter) == false) goto L304;
        MessageAdapter r82 = (MessageAdapter) r81;
    L305:
        if (r82 == null) goto L307;
        List r83 = r82.z2();
    L308:
        if (r83 == null) goto L310;
        xc8.b r122 = (xc8.b) CollectionsKt.getOrNull(r83, r31);
    L311:
        if (r83 == null) goto L313;
        xc8.b r84 = (xc8.b) CollectionsKt.getOrNull(r83, r33);
    L314:
        if (r122 == null) goto L316;
        ComponentCellStateType r123 = r122.f();
    L318:
        if (r123 != ComponentCellStateType.DEEP_THINK_HEADER_TITLE_CELL) goto L320;
        boolean r124 = true;
        r24.v = true;
        r24.y = System.currentTimeMillis();
    L321:
        if (r84 == null) goto L323;
        ComponentCellStateType r85 = r84.f();
    L325:
        if (r85 == ComponentCellStateType.DEEP_THINK_CONTENT_CELL) goto L328;
        r24.w = r124;
    L328:
        if (r71 == null) goto L334;
        DeepThinkFoldStatus r86 = r71.getDeepThinkFoldStatus();
        if (r86 == null) goto L334;
        if (ic8.q.b(r86) == true) goto L334;
        boolean r87 = true;
    L335:
        if (r87 == false) goto L337;
    L340:
        boolean r88 = true;
    L341:
        if (r88 == true) goto L349;
        if (r24.w == true) goto L349;
        if (r110.getMessageStatusLocal() == 23) goto L349;
        r19 = r64;
        r25 = r210;
        r12 = r12;
    L349:
        if (r24.z == 0) goto L351;
    L357:
        r19 = r64;
        r25 = r210;
        r12 = r12;
        goto L364
    L351:
        if (r24.k == false) goto L357;
        FLogger r89 = FLogger.a;
        StringBuilder r90 = new StringBuilder("(headerSourceView.isExpand = ");
        r90.append(!r88);
        r12 = r12;
        r90.append(r12);
        r90.append(r24.w);
        r25 = r210;
        r90.append(r25);
        if (r110.getMessageStatusLocal() != 23) goto L355;
        boolean r91 = true;
    L356:
        r90.append(r91);
        r89.d("ChatMessageReadTrace", r90.toString());
        r19 = r64;
        r24.z = System.currentTimeMillis();
        goto L364
    L355:
        r91 = false;
        goto L356
    L337:
        if (ic8.q.b(r79) == false) goto L340;
        r88 = false;
    L334:
        r87 = false;
        goto L335
    L323:
        r85 = null;
        goto L325
    L320:
        r124 = true;
        goto L321
    L316:
        r123 = null;
        goto L318
    L313:
        r84 = null;
        goto L314
    L310:
        r122 = null;
        goto L311
    L307:
        r83 = null;
        goto L308
    L304:
        r82 = null;
        goto L305
    L300:
        r81 = null;
        goto L302
    L327:
        r14 = r14;
    L283:
        r121 = false;
        r74 = r73;
    L282:
        r73 = true;
        goto L283
    L271:
        r70 = false;
        goto L272
    L274:
        r69 = null;
        goto L275
    L258:
        if (com.larus.bmhome.chat.bean.d.e0(r110) == false) goto L260;
        r63 = true;
    L250:
        r62 = false;
        goto L251
    L211:
        if (Intrinsics.areEqual(r120, r110.getMessageId()) == false) goto L213;
        r24.l = true;
        goto L222
    L207:
        r45 = null;
        goto L209
    L200:
        r120 = null;
    L358:
        r14 = r14;
        r25 = r210;
        goto L364
    L184:
        if (com.larus.bmhome.chat.bean.d.Q0(r110) == true) goto L186;
        r24.o = true;
        goto L186
    L187:
        r42 = null;
        goto L188
    L178:
        r39 = null;
    L361:
        r14 = r14;
        r25 = r210;
    L162:
        r34 = false;
        goto L163
    L161:
        r29 = r22;
        goto L162
    L365:
        return;
    L145:
        r20 = 0;
        goto L146
    L5:
        if (c() == TextCellCutType.DeepThinkCutMultipleCell) goto L119;
        ArrayList r92 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r93 = r26.iterator();
        int r94 = 0;
    L9:
        if (r93.hasNext() == false) goto L14;
        Object r95 = r93.next();
        int r125 = r94 + 1;
        if (r94 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        r92.add(TuplesKt.to((Message) r95, Integer.valueOf(r94)));
        r94 = r125;
        goto L9
    L14:
        ArrayList r96 = new ArrayList();
        Iterator r97 = r92.iterator();
    L16:
        if (r97.hasNext() == false) goto L24;
        Object r98 = r97.next();
        int r99 = ((Number) ((Pair) r98).getSecond()).intValue();
        if (r27 > r99) goto L21;
        if (r99 > r28) goto L21;
        boolean r100 = true;
    L22:
        if (r100 == false) goto L16;
        r96.add(r98);
    L21:
        r100 = false;
        goto L22
    L24:
        int[] r101 = new int[2];
        RecyclerView r102 = this.d;
        if (r102 == null) goto L27;
        r102.getLocationOnScreen(r101);
    L27:
        int r103 = r101[1];
        RecyclerView r104 = this.d;
        if (r104 == null) goto L30;
        int r105 = r104.getHeight();
    L31:
        int r106 = r105 + r103;
        Iterator r107 = r96.iterator();
    L33:
        if (r107.hasNext() == false) goto L118;
        Pair r108 = (Pair) r107.next();
        l0.a.getClass();
        s r109 = l0.a.b.get(((Message) r108.getFirst()).getMessageId());
        if (r109 == null) goto L116;
        Message r126 = (Message) r108.getFirst();
        r109.g = r126;
        if (com.larus.bmhome.chat.bean.d.Q0(r126) == false) goto L39;
    L41:
        boolean r127 = false;
    L42:
        r109.m = r127;
        RecyclerView r128 = this.d;
        if (r128 == null) goto L116;
        r109.q = Integer.valueOf((r128.getHeight() - r128.getPaddingTop()) - r128.getPaddingBottom());
        RecyclerView r129 = this.d;
        if (r129 == null) goto L116;
        RecyclerView.ViewHolder r130 = r129.findViewHolderForAdapterPosition(((Number) r108.getSecond()).intValue());
        if (r130 == null) goto L116;
        View r131 = r130.itemView;
        if (r131 == null) goto L116;
        Iterator r211 = r107;
        int[] r132 = new int[2];
        r131.getLocationOnScreen(r132);
        int r133 = r132[1];
        int r134 = r131.getHeight() + r133;
        if (r133 > r103) goto L56;
        if (r134 < r106) goto L56;
        r109.l = true;
    L56:
        if (r134 <= r106) goto L58;
    L60:
        if (r133 < r103) goto L62;
        r109.n = true;
    L62:
        boolean r135 = IFlowMainBot.a.f8(((Number) r108.getSecond()).intValue(), r128);
        po8.p r136 = d(r128, ((Number) r108.getSecond()).intValue());
        if (r135 == false) goto L66;
        r109.p = true;
    L66:
        if (com.larus.im.bean.message.a.f0(r126) == false) goto L115;
        if (r136 == null) goto L115;
        if (com.larus.bmhome.chat.bean.d.f0(r126) == false) goto L72;
    L74:
        boolean r137 = false;
    L75:
        r109.u = r137;
        FLogger r138 = FLogger.a;
        r138.d("ChatMessageReadTrace", r15 + r109.u);
        DeepThinkFoldStatus r139 = r136.getDeepThinkFoldStatus();
        if (r139 == null) goto L88;
        int r140 = oi8.f.a;
        Intrinsics.checkNotNullParameter(r139, "<this>");
        int r141 = oi8.f.a.b[r139.ordinal()];
        String r142 = r15;
        if (r141 != 1) goto L80;
        String r143 = "fold";
    L89:
        r109.A = r143;
        if (ic8.q.b(r139) == false) goto L101;
        int[] r144 = new int[2];
        r136.getView().getLocationOnScreen(r144);
        int r145 = r144[1];
        if ((r133 + r136.getView().getHeight()) <= r106) goto L94;
    L96:
        if (r145 < r103) goto L101;
        if (r109.v == true) goto L101;
        r109.v = true;
        r109.y = System.currentTimeMillis();
        r138.d("ChatMessageReadTrace", "info.isThinkingContentTopShown = true thinkingReadStartTimeStamp = " + r109.y);
        goto L101
    L94:
        if (com.larus.bmhome.chat.bean.d.f0(r126) == true) goto L96;
        r109.w = true;
        r138.d("ChatMessageReadTrace", "info.isThinkingContentBottomShown = true");
    L101:
        if (ic8.q.b(r136.getDeepThinkFoldStatus()) == false) goto L107;
        if (r109.w == true) goto L107;
        if (r126.getMessageStatusLocal() == 23) goto L107;
    L117:
        r107 = r211;
        r15 = r142;
        r8 = 23;
    L107:
        if (r109.z != 0) goto L117;
        if (r109.k == false) goto L117;
        StringBuilder r146 = new StringBuilder("(!headerSourceView.isExpand = ");
        r146.append(!ic8.q.b(r136.getDeepThinkFoldStatus()));
        r146.append("  info.isThinkingContentBottomShown = ");
        r146.append(r109.w);
        r146.append(" message.messageStatusLocal == MessageStatusLocal.RECEIVE_INTERRUPT = ");
        if (r126.getMessageStatusLocal() != 23) goto L113;
        boolean r147 = true;
    L114:
        r146.append(r147);
        r138.d("ChatMessageReadTrace", r146.toString());
        r109.z = System.currentTimeMillis();
        goto L117
    L113:
        r147 = false;
        goto L114
    L80:
        if (r141 != 2) goto L82;
        r143 = "unfold";
        goto L89
    L82:
        if (r141 != 3) goto L85;
        r143 = "half_fold";
        goto L89
    L85:
        throw new NoWhenBranchMatchedException();
    L88:
        r142 = r15;
        r143 = null;
        goto L89
    L72:
        if (com.larus.bmhome.chat.bean.d.e0(r126) == false) goto L74;
        r137 = true;
    L115:
        r142 = r15;
        goto L117
    L58:
        if (com.larus.bmhome.chat.bean.d.Q0(r126) == true) goto L60;
        r109.o = true;
        goto L60
    L39:
        if (r126.getMessageStatusLocal() == r8) goto L41;
        r127 = true;
    L116:
        r211 = r107;
        goto L115
    L118:
        return;
    L30:
        r105 = 0;
        goto L31
    }

    @Override // com.larus.bmhome.chat.trace.l0
    public final void u(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        if (r3 != 0) goto L8;
        if (r4 != 0) goto L8;
        if (this.i == true) goto L8;
        return;
    L8:
        i("onScrolled beyond check interval dy: " + r4);
    }

    public final void b(List<Message> r19, int r20, int r21, String r22) {
        if (c() != TextCellCutType.NewCutThreeTextCell) goto L5;
    L41:
        e(r19);
        LinkedHashSet r4 = new LinkedHashSet();
        LinkedHashSet r5 = new LinkedHashSet();
        Iterator<T> r14 = r19.iterator();
        int r15 = 0;
    L43:
        if (r14.hasNext() == false) goto L59;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        Message r18 = (Message) r16;
        if (r20 > r15) goto L51;
        if (r15 > r21) goto L51;
        boolean r110 = true;
    L52:
        if (r110 == true) goto L57;
        if (r18 == null) goto L55;
        String r111 = r18.getMessageId();
    L56:
        r4.add(r111);
    L58:
        r15 = r17;
        goto L43
    L55:
        r111 = null;
        goto L56
    L57:
        r5.add(r18.getMessageId());
    L51:
        r110 = false;
        goto L52
    L59:
        r4.removeAll(r5);
        l0.a.getClass();
        Iterator<T> r1 = l0.a.b.keySet().iterator();
    L61:
        if (r1.hasNext() == false) goto L75;
        String r2 = (String) r1.next();
        if (r4.contains(r2) == false) goto L61;
        l0.a.getClass();
        ConcurrentHashMap<String, s> r6 = l0.a.b;
        s r13 = r6.get(r2);
        if (r13 != null) goto L67;
    L69:
        boolean r112 = false;
    L70:
        if (r112 == false) goto L72;
        r13.d = System.currentTimeMillis();
    L72:
        if (r13 == null) goto L74;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r13.e = r22;
    L74:
        r6.remove(r2);
        h(r13);
        com.larus.bmhome.chat.trace.container.b r7 = com.larus.bmhome.chat.trace.container.b.a;
        Intrinsics.checkNotNull(r2);
        com.larus.bmhome.chat.trace.container.b.l(r2);
        FLogger.a.d("ChatMessageReadTrace", "scroll item is invisible----".concat(r2));
        goto L61
    L67:
        if (r13.d != (-1)) goto L69;
        r112 = true;
        goto L70
    L75:
        return;
    L5:
        if (c() == TextCellCutType.DeepThinkCutMultipleCell) goto L41;
        e(r19);
        LinkedHashSet r8 = new LinkedHashSet();
        Iterator<T> r9 = r19.iterator();
        int r113 = 0;
    L9:
        if (r9.hasNext() == false) goto L24;
        Object r114 = r9.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        Message r116 = (Message) r114;
        if (r20 > r113) goto L17;
        if (r113 > r21) goto L17;
        boolean r117 = true;
    L18:
        if (r117 == true) goto L23;
        if (r116 == null) goto L21;
        String r118 = r116.getMessageId();
    L22:
        r8.add(r118);
        goto L23
    L21:
        r118 = null;
    L23:
        r113 = r115;
    L17:
        r117 = false;
        goto L18
    L24:
        l0.a.getClass();
        Iterator<T> r3 = l0.a.b.keySet().iterator();
    L26:
        if (r3.hasNext() == false) goto L40;
        String r10 = (String) r3.next();
        if (r8.contains(r10) == false) goto L26;
        l0.a.getClass();
        ConcurrentHashMap<String, s> r11 = l0.a.b;
        s r119 = r11.get(r10);
        if (r119 != null) goto L32;
    L34:
        boolean r120 = false;
    L35:
        if (r120 == false) goto L37;
        r119.d = System.currentTimeMillis();
    L37:
        if (r119 == null) goto L39;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r119.e = r22;
    L39:
        r11.remove(r10);
        h(r119);
        com.larus.bmhome.chat.trace.container.b r12 = com.larus.bmhome.chat.trace.container.b.a;
        Intrinsics.checkNotNull(r10);
        com.larus.bmhome.chat.trace.container.b.l(r10);
        FLogger.a.d("ChatMessageReadTrace", "scroll item is invisible----".concat(r10));
        goto L26
    L32:
        if (r119.d != (-1)) goto L34;
        r120 = true;
        goto L35
    }

    public final void g(List<Message> r19, int r20, int r21, String r22) {
        long r5 = 200;
        if (c() == TextCellCutType.NewCutThreeTextCell) goto L71;
        if (c() == TextCellCutType.DeepThinkCutMultipleCell) goto L71;
        if (this.n == true) goto L10;
        return;
    L10:
        LinkedHashMap r3 = new LinkedHashMap();
        ArrayList r4 = new ArrayList();
        Iterator<T> r12 = r19.iterator();
        int r13 = 0;
    L12:
        if (r12.hasNext() == false) goto L27;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        Message r16 = (Message) r14;
        if (r20 > r13) goto L20;
        if (r13 > r21) goto L20;
        boolean r17 = true;
    L21:
        if (r17 == false) goto L23;
        r3.put(r16.getMessageId(), Integer.valueOf(r13));
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        r4.add(r14);
    L26:
        r13 = r15;
        goto L12
    L23:
        r7 = false;
    L20:
        r17 = false;
        goto L21
    L27:
        Iterator r1 = r4.iterator();
    L29:
        if (r1.hasNext() == false) goto L69;
        Message r2 = (Message) r1.next();
        f(r2);
        if (r2.getMessageId() == null) goto L68;
        l0.a.getClass();
        ConcurrentHashMap<String, s> r6 = l0.a.b;
        if (r6.containsKey(r2.getMessageId()) == true) goto L68;
        if (r.a(r2) == true) goto L68;
        Integer r8 = (Integer) r3.get(r2.getMessageId());
        if (r8 == null) goto L39;
        int r9 = r8.intValue();
    L40:
        RecyclerView r18 = this.d;
        if (r18 == null) goto L47;
        RecyclerView.ViewHolder r110 = r18.findViewHolderForAdapterPosition(r9);
        if (r110 == null) goto L47;
        View r111 = r110.itemView;
        if (r111 == null) goto L47;
        int r112 = r111.getHeight();
    L48:
        long r113 = r2.getCreateTime();
        if (com.larus.bmhome.chat.bean.d.Q0(r2) == true) goto L51;
    L53:
        String r114 = r22;
    L54:
        s r115 = new s();
        String r116 = r2.getMessageId();
        if (r116 != null) goto L57;
        r116 = "";
    L57:
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r115.a = r116;
        r115.b = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r115.f = r114;
        r115.h = r9;
        r115.j = r112;
        r115.g = r2;
        r115.k = com.larus.bmhome.chat.bean.d.Q0(r2);
        MessageAdapter r10 = this.h;
        if (r10 == null) goto L64;
        com.larus.bmhome.chat.component.regen.a r11 = r10.getProvider().s5();
        if (r11 == null) goto L64;
        if (r11.DL(r2) != true) goto L64;
        boolean r23 = true;
    L65:
        r115.i = r23;
        r115.r = this.l.contains(r115.a);
        String r24 = r2.getMessageId();
        if (r24 == null) goto L68;
        r6.put(r24, r115);
    L64:
        r23 = false;
        goto L65
    L51:
        if (r113 >= r5) goto L53;
        r114 = "enter_chat_or_new_message";
    L47:
        r112 = 0;
        goto L48
    L39:
        r9 = 0;
    L68:
        r5 = 200;
        goto L29
    L69:
        return;
    L71:
        if (this.n == false) goto L151;
        LinkedHashMap r25 = new LinkedHashMap();
        ArrayList r26 = new ArrayList();
        Iterator<T> r27 = r19.iterator();
        int r28 = 0;
    L75:
        if (r27.hasNext() == false) goto L96;
        Object r29 = r27.next();
        int r117 = r28 + 1;
        if (r28 >= 0) goto L79;
        CollectionsKt.throwIndexOverflow();
    L79:
        Message r118 = (Message) r29;
        if (r20 > r28) goto L83;
        if (r28 > r21) goto L83;
        boolean r119 = true;
    L84:
        if (r119 == false) goto L92;
        List r120 = (List) r25.get(r118.getMessageId());
        if (r120 != null) goto L88;
        r120 = new ArrayList();
    L88:
        r120.add(Integer.valueOf(r28));
        String r30 = r118.getMessageId();
        if (r30 != null) goto L91;
        r30 = "";
    L91:
        r25.put(r30, r120);
        boolean r31 = true;
    L93:
        if (r31 == false) goto L95;
        r26.add(r29);
    L95:
        r28 = r117;
        goto L75
    L92:
        r31 = false;
    L83:
        r119 = false;
        goto L84
    L96:
        LinkedHashSet r32 = new LinkedHashSet(r19);
        Iterator r33 = r26.iterator();
    L98:
        if (r33.hasNext() == false) goto L178;
        Message r34 = (Message) r33.next();
        f(r34);
        l0.a.getClass();
        if (l0.a.b.containsKey(r34.getMessageId()) == true) goto L98;
        if (r.a(r34) == true) goto L98;
        List r35 = (List) r25.get(r34.getMessageId());
        if (r35 == null) goto L98;
        Iterator r36 = r35.iterator();
        int r37 = 0;
    L109:
        if (r36.hasNext() == false) goto L119;
        int r38 = ((Number) r36.next()).intValue();
        RecyclerView r121 = this.d;
        if (r121 == null) goto L117;
        RecyclerView.ViewHolder r39 = r121.findViewHolderForAdapterPosition(r38);
        if (r39 == null) goto L117;
        View r40 = r39.itemView;
        if (r40 == null) goto L117;
        int r41 = r40.getHeight();
    L118:
        r37 = r37 + r41;
    L117:
        r41 = 0;
        goto L118
    L119:
        long r122 = r34.getCreateTime();
        if (com.larus.bmhome.chat.bean.d.Q0(r34) == true) goto L122;
    L124:
        String r42 = r22;
    L125:
        s r43 = new s();
        String r123 = r34.getMessageId();
        if (r123 != null) goto L128;
        r123 = "";
    L128:
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        r43.a = r123;
        r43.b = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r42, "<set-?>");
        r43.f = r42;
        Iterator r44 = r32.iterator();
        int r124 = 0;
    L130:
        if (r44.hasNext() == false) goto L138;
        Object r125 = r44.next();
        if (r124 >= 0) goto L135;
        CollectionsKt.throwIndexOverflow();
    L135:
        if (Intrinsics.areEqual(((Message) r125).getMessageId(), r34.getMessageId()) == true) goto L139;
        r124 = r124 + 1;
    L139:
        r43.h = r124;
        r43.j = r37;
        r43.g = r34;
        r43.k = com.larus.bmhome.chat.bean.d.Q0(r34);
        MessageAdapter r45 = this.h;
        if (r45 == null) goto L146;
        com.larus.bmhome.chat.component.regen.a r46 = r45.getProvider().s5();
        if (r46 == null) goto L146;
        if (r46.DL(r34) != true) goto L146;
        boolean r47 = true;
    L147:
        r43.i = r47;
        r43.r = this.l.contains(r43.a);
        l0.a.getClass();
        ConcurrentHashMap<String, s> r48 = l0.a.b;
        String r49 = r34.getMessageId();
        if (r49 != null) goto L150;
        r49 = "";
    L150:
        r48.put(r49, r43);
    L146:
        r47 = false;
        goto L147
    L138:
        r124 = -1;
        goto L139
    L122:
        if (r122 >= 200) goto L124;
        r42 = "enter_chat_or_new_message";
        goto L125
    L178:
        return;
    }
}
