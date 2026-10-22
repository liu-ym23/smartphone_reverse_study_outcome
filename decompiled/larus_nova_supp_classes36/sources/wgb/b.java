package wgb;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.utils.AndroidThrottle;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.chatwindow.view.tip.NewMessageTipUtils;
import com.ss.android.lark.flow.chat.databinding.LayoutFlowMessageTipBinding;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> {
    public static final /* synthetic */ int l = 0;
    public final r7b.c a;
    public final e b;
    public final e c;
    public final f<T> d;
    public final wgb.a<T> e;
    public boolean f;
    public final AndroidThrottle<Runnable> g;
    public final boolean h;
    public boolean i;
    public boolean j;
    public boolean k;

    public static final class a {
    }

    /* JADX INFO: renamed from: wgb.b$b, reason: collision with other inner class name */
    public static final class RunnableC0340b implements Runnable {
        public final /* synthetic */ b<T> a;

        public RunnableC0340b(b<T> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b<T> a;

        public c(b<T> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c();     // Catch: Throwable -> L4
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

    public final void c() {
        com.ss.android.lark.chatwindow.view.tip.a r0 = this.d;
        com.ss.android.lark.chatwindow.view.tip.a r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r0 = null;
    L5:
        boolean r3 = true;
        boolean r2 = b(r0, this.b, true);
        com.ss.android.lark.chatwindow.view.tip.a r4 = this.e;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
    L9:
        e r5 = this.c;
        if (this.f == false) goto L13;
        if (r2 == true) goto L13;
    L14:
        b(r1, r5, r3);
        return;
    L13:
        r3 = false;
        goto L14
    L8:
        r1 = r4;
        goto L9
    }

    public final boolean d() {
        if (this.h == true) goto L6;
        Log.e("FlowMessageTipController", "Un-init");
    L6:
        return this.h;
    }

    public final void e() {
        if (d() == true) goto L5;
        return;
    L5:
        this.b.setLoadingState(false);
        this.c.setLoadingState(false);
    }

    public final void g() {
        if (d() == true) goto L5;
        return;
    L5:
        com.ss.android.lark.chatwindow.view.tip.a r0 = this.d;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r0 = null;
    L8:
        ((com.ss.android.lark.chatwindow.view.tip.c) r0).h = r0.b.e() + 1;
        ((com.ss.android.lark.chatwindow.view.tip.c) r0).f = r0.b.l() + 1;
        ((com.ss.android.lark.chatwindow.view.tip.c) r0).g = r0.b.i() + 1;
    }

    public final void j() {
        if (d() == true) goto L5;
        return;
    L5:
        wgb.a<T> r0 = this.e;
        wgb.a<T> r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r0 = null;
    L8:
        ((com.ss.android.lark.chatwindow.view.tip.b) r0).f = 0;
        e r2 = this.c;
        wgb.a<T> r3 = this.e;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
    L12:
        ViewGroup.LayoutParams r4 = this.c.getLayoutParams();
        r1.k(r4);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "layoutParams");
        r2.setLayoutParams(r4);
        return;
    L11:
        r1 = r3;
        goto L12
    }

    public final void l() {
        if (d() == true) goto L5;
        return;
    L5:
        this.b.setLoadingState(true);
        this.c.setLoadingState(true);
    }

    public final void o() {
        if (d() == true) goto L5;
        return;
    L5:
        e r0 = this.b;
        f<T> r1 = this.d;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r1 = null;
    L8:
        ViewGroup.LayoutParams r2 = this.b.getLayoutParams();
        r1.k(r2);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "layoutParams");
        r0.setLayoutParams(r2);
    }

    public final void f(boolean r4) {
        if (d() == true) goto L5;
        return;
    L5:
        com.ss.android.lark.chatwindow.view.tip.a r0 = this.e;
        com.ss.android.lark.chatwindow.view.tip.a r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r0 = null;
    L8:
        r0.d = true;
        com.ss.android.lark.chatwindow.view.tip.a r2 = this.d;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
    L12:
        r1.d = true;
        m(r4);
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public final void h(List<? extends MessageInfo> r7) {
        if (d() == true) goto L6;
        return;
    L6:
        if (this.a.f() != Chat.MessagePosition.NEWEST_UNREAD) goto L9;
        ArrayList r0 = new ArrayList();
    L13:
        StringBuilder r1 = new StringBuilder("new message tip strategy: ");
        Chat.MessagePosition r2 = this.a.f();
        com.ss.android.lark.chatwindow.view.tip.a r3 = null;
        if (r2 == null) goto L16;
        String r4 = r2.desc();
    L17:
        r1.append(r4);
        Log.i("FlowMessageTipController", r1.toString());
        com.ss.android.lark.chatwindow.view.tip.a r5 = this.d;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r5 = null;
    L21:
        if (r7 != null) goto L24;
        r7 = CollectionsKt.emptyList();
    L24:
        ArrayList r6 = new ArrayList(r7);
        r5.getClass();
        Iterator r8 = r6.iterator();
    L26:
        if (r8.hasNext() == false) goto L30;
        if (r5.b.d((MessageInfo) r8.next()) < ((com.ss.android.lark.chatwindow.view.tip.c) r5).g) goto L26;
        r8.remove();
        goto L26
    L30:
        CollectionUtils.resetToList(r5.a, r6);
        Collections.sort(r5.a);
        Collections.reverse(r5.a);
        com.ss.android.lark.chatwindow.view.tip.a r9 = this.e;
        if (r9 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
    L34:
        r3.getClass();
        Iterator r10 = r0.iterator();
    L36:
        if (r10.hasNext() == false) goto L40;
        if (r3.b.d((MessageInfo) r10.next()) > ((com.ss.android.lark.chatwindow.view.tip.b) r3).h) goto L36;
        r10.remove();
        goto L36
    L40:
        CollectionUtils.resetToList(r3.a, r0);
        this.j = true;
        m(true);
        return;
    L33:
        r3 = r9;
        goto L34
    L16:
        r4 = null;
        goto L17
    L9:
        if (r7 == null) goto L11;
        List<? extends MessageInfo> r11 = r7;
    L12:
        r0 = new ArrayList(r11);
        goto L13
    L11:
        r11 = CollectionsKt.emptyList();
        goto L12
    }

    public final void k(com.ss.android.lark.chatwindow.view.tip.a.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (d() == true) goto L5;
        return;
    L5:
        com.ss.android.lark.chatwindow.view.tip.a r0 = this.e;
        com.ss.android.lark.chatwindow.view.tip.a r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r0 = null;
    L8:
        r0.e = r3;
        com.ss.android.lark.chatwindow.view.tip.a r2 = this.d;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
    L12:
        r1.e = r3;
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public final void m(boolean r4) {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.i == true) goto L7;
        return;
    L7:
        if (this.j == false) goto L26;
        if (r4 == false) goto L13;
        c();
        return;
    L13:
        if (this.k == false) goto L18;
        AndroidThrottle<Runnable> r5 = this.g;
        if (r5 == null) goto L17;
        RunnableC0340b r0 = new RunnableC0340b(this);
        r5.a.post(new com.larksuite.framework.utils.a(r5, r0));
    L17:
        this.k = false;
        return;
    L18:
        AndroidThrottle<Runnable> r6 = this.g;
        if (r6 == null) goto L25;
        r6.d(new c(this));
        return;
    L25:
        return;
    }

    public final void n(boolean r4) {
        if (d() == true) goto L5;
        return;
    L5:
        com.ss.android.lark.chatwindow.view.tip.a r0 = this.e;
        com.ss.android.lark.chatwindow.view.tip.a r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r0 = null;
    L8:
        r0.d = false;
        com.ss.android.lark.chatwindow.view.tip.a r2 = this.d;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
    L12:
        r1.d = false;
        m(r4);
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public final void a(List<? extends MessageInfo> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "messageInfos");
        if (d() == true) goto L5;
        return;
    L5:
        this.f = r4;
        Log.i("FlowMessageTipController", "add new messages count: " + r3.size());
        com.ss.android.lark.chatwindow.view.tip.a r5 = this.e;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r5 = null;
    L8:
        r5.getClass();
        Iterator<? extends MessageInfo> r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        MessageInfo r0 = r6.next();
        if (r5.b.g(r0) == false) goto L10;
        ((ArrayList) r5.a).add(r0);
        goto L10
    L14:
        Iterator r7 = ((ArrayList) r5.a).iterator();
    L16:
        if (r7.hasNext() == false) goto L20;
        if (r5.b.k((MessageInfo) r7.next()) == false) goto L16;
        r7.remove();
        goto L16
    L20:
        StringBuilder r8 = new StringBuilder("strategy: ");
        r8.append(r5.b.f().desc());
        r8.append(" add unread at messages: ");
        int r1 = NewMessageTipUtils.a;
        r8.append(NewMessageTipUtils.a(r5.a));
        Log.i("NewMessageTipController", r8.toString());
        ((com.ss.android.lark.chatwindow.view.tip.b) r5).g = true;
        m(false);
    }

    public final void i(List<? extends T> r3, com.ss.android.lark.chatwindow.view.tip.a.b<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "passedDataList");
        Intrinsics.checkNotNullParameter(r4, "fetcher");
        if (d() == true) goto L5;
        return;
    L5:
        f<T> r0 = this.d;
        wgb.a<T> r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r0 = null;
    L8:
        r0.j(r3, r4);
        wgb.a<T> r2 = this.e;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
    L12:
        r1.j(r3, r4);
        m(false);
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public final boolean b(com.ss.android.lark.chatwindow.view.tip.a<?> r9, e r10, boolean r11) {
        if (r9 == null) goto L76;
        if (r10 != null) goto L7;
        return false;
    L7:
        if (d() == true) goto L10;
        return false;
    L10:
        if (r9.i() == true) goto L14;
        r10.setVisibility(8);
        return false;
    L14:
        if (r9.d == false) goto L16;
    L18:
        boolean r1 = false;
    L19:
        LayoutFlowMessageTipBinding r5 = null;
        if (r1 == false) goto L52;
        if (r11 == false) goto L52;
        if (((ArrayList) r9.a).isEmpty() == true) goto L25;
        MessageInfo r12 = (MessageInfo) ListProtector.get(r9.a, 0);
    L26:
        if (r12 != null) goto L28;
    L39:
        ((ArrayList) r9.a).remove(r12);
    L40:
        com.ss.android.lark.chatwindow.view.tip.a.a r13 = null;
    L41:
        if (r13 == null) goto L50;
        String r14 = r13.a;
        Intrinsics.checkNotNullParameter(r14, "atTip");
        r10.a();
        LayoutFlowMessageTipBinding r15 = r10.a;
        if (r15 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L45:
        r15.g.setVisibility(0);
        LayoutFlowMessageTipBinding r16 = r10.a;
        if (r16 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L49:
        r5.g.setText(r14);
        d();
    L73:
        return true;
    L48:
        r5 = r16;
        goto L49
    L50:
        Log.e("FlowMessageTipController", "cannot get at content when show top tips");
        return false;
    L28:
        if (r12.getMessageSender() == null) goto L39;
        if (r12.getMessage().isFromMe() == true) goto L39;
        ChatChatter r2 = r12.getMessageSender();
        String r3 = m.b(r2, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, false);
        Message r6 = r12.getMessage();
        String r7 = r9.a(r6, r3);
        if (r7 != null) goto L35;
        Log.e("chatwindow", "show at tip, but message is not at me or at all. message: " + r6);
        ((ArrayList) r9.a).remove(r12);
        goto L40
    L35:
        r13 = new com.ss.android.lark.chatwindow.view.tip.a.a();
        r9.b.c(r6);
        r13.a = r7;
        if (TextUtils.isEmpty(r7) == true) goto L38;
        r7.replace(r3, "");
    L38:
        r2.getAvatarKey();
        r2.getId();
        goto L41
    L25:
        r12 = null;
    L52:
        if (r9.h() == false) goto L63;
        if (r11 == false) goto L63;
        String r17 = r9.d();
        Intrinsics.checkNotNullParameter(r17, "newMessageTip");
        r10.a();
        LayoutFlowMessageTipBinding r18 = r10.a;
        if (r18 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L57:
        r18.g.setVisibility(0);
        LayoutFlowMessageTipBinding r19 = r10.a;
        if (r19 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L61:
        r5.g.setText(r17);
        goto L73
    L60:
        r5 = r19;
    L63:
        if (r9.g() == false) goto L74;
        if (r11 == false) goto L74;
        r10.setVisibility(0);
        LayoutFlowMessageTipBinding r20 = r10.a;
        if (r20 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L68:
        r20.c.setVisibility(0);
        LayoutFlowMessageTipBinding r21 = r10.a;
        if (r21 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L72:
        r5.f.setVisibility(8);
        goto L73
    L71:
        r5 = r21;
    L74:
        r10.setVisibility(8);
        return false;
    L16:
        if (((ArrayList) r9.a).isEmpty() == true) goto L18;
        r1 = true;
        goto L19
    L76:
        return false;
    }

    public b(Context r4, r7b.c r5, e r6, e r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "dataStrategy");
        Intrinsics.checkNotNullParameter(r6, "topTipView");
        Intrinsics.checkNotNullParameter(r7, "bottomTipView");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.f = true;
        new HashSet();
        this.k = true;
        f<T> r1 = new f(r4, r5);
        this.d = r1;
        wgb.a<T> r2 = new wgb.a(r4, r5);
        this.e = r2;
        r5.h();
        r6.setOnClickListener(new d(this));
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        r1.k(r8);
        Intrinsics.checkNotNullParameter(r8, "layoutParams");
        r6.setLayoutParams(r8);
        r6.setArrowDirection(true);
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        r2.k(r9);
        Intrinsics.checkNotNullParameter(r9, "layoutParams");
        r7.setLayoutParams(r9);
        r7.setOnClickListener(new wgb.c(this));
        r7.setArrowDirection(false);
        new CallbackManager();
        AndroidThrottle.a r10 = new AndroidThrottle.a();
        r10.b = 500;
        r10.e = new AndroidThrottle.b();
        this.g = new AndroidThrottle(r10);
        this.h = true;
    }
}
