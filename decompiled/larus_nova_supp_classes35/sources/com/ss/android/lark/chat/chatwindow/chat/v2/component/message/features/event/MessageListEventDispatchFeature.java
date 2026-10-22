package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b3b.i;
import b3b.q;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList;
import com.ss.android.lark.biz.im.api.m1;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.n;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.o;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleEntity;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import oxa.c;
import t6b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageListEventDispatchFeature implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a, c<IMessageListComponent.a> {
    public final /* synthetic */ oxa.b<IMessageListComponent.a> a;
    public final e b;
    public final h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> c;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b d;
    public final List<com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.InterfaceC0063a> e;
    public final Lazy f;
    public i g;
    public o4b.a h;
    public q i;
    public final List<ChatWindowMessageList.a> j;
    public final ArrayList<o> k;
    public final ArrayList<IMessageListComponent.i> l;
    public final ArrayList<IMessageListComponent.g> m;
    public final ArrayList<IMessageListComponent.h> n;
    public final List<m1> o;
    public final ArrayList<IMessageListComponent.j> p;
    public final ArrayList<IMessageListComponent.d> q;
    public final ArrayList<IMessageListComponent.b> r;
    public final ArrayList<jya.a> s;

    public static final class a implements e3b.a.InterfaceC0213a {
        public final /* synthetic */ MessageListEventDispatchFeature a;

        @Override // e3b.a.InterfaceC0213a
        public final Fragment getFragment() {
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.d;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("env");
            r0 = null;
        L6:
            return r0.getFragment();
        }

        public a(MessageListEventDispatchFeature r1) {
            this.a = r1;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ MessageListEventDispatchFeature a;

        public b(MessageListEventDispatchFeature r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Chat r2 = (Chat) r1;
            this.a.F();
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r1, int r2, Intent r3) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    public final void F() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.d;
        d.b r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        IMessageListViewModel r1 = r0.f();
        if (r1 != null) goto L8;
        return;
    L8:
        Chat r10 = (Chat) r1.getCurrentChat().getValue();
        if (r10 != null) goto L11;
        return;
    L11:
        a r11 = new a(this);
        h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> r3 = this.c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r4 = this.d;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r4 = null;
    L14:
        v r5 = r4.getContainer();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r6 = this.d;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r6 = null;
    L17:
        FragmentActivity r7 = r6.getActivity();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r8 = this.d;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r8 = null;
    L20:
        this.g = r3.b(r10, r5, r7, r1, r11, r8.a());
        h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> r9 = this.c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r12 = this.d;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r12 = null;
    L23:
        v r13 = r12.getContainer();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r14 = this.d;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r14 = null;
    L26:
        FragmentActivity r15 = r14.getActivity();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r16 = this.d;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r16 = null;
    L29:
        this.h = r9.c(r10, r13, r15, r1, r11, r16.a());
        h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> r17 = this.c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r18 = this.d;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r18 = null;
    L32:
        v r19 = r18.getContainer();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r20 = this.d;
        if (r20 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r20 = null;
    L35:
        FragmentActivity r21 = r20.getActivity();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r22 = this.d;
        if (r22 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r22 = null;
    L38:
        s2b.d r23 = r22.a();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r24 = this.d;
        if (r24 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r24 = null;
    L41:
        IMessageListComponent.e r25 = r24.getDependency();
        if (r25 == null) goto L44;
        r2 = r25.a();
    L44:
        this.i = r17.e(r10, r19, r21, r1, r23, r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a
    public final boolean b0() {
        return !this.n.isEmpty();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a
    public final Map<String, String> n0() {
        Iterator<T> r0 = this.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        n r1 = (o) r0.next();
        if ((r1 instanceof b3b.e) == false) goto L4;
        return ((b3b.e) r1).h();
    L10:
        return new LinkedHashMap();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a
    public final void k(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.InterfaceC0063a r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        if (((ArrayList) this.e).contains(r2) == true) goto L6;
        ((ArrayList) this.e).add(r2);
        return;
    }

    public final void l(com.ss.android.lark.biz.im.api.extension.chat_window.e r2) {
        IMessageListComponent.a r3 = (IMessageListComponent.a) r2;
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a.l(r3);
    }

    public final void m(com.ss.android.lark.biz.im.api.extension.chat_window.e r2) {
        IMessageListComponent.a r3 = (IMessageListComponent.a) r2;
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a.m(r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a
    public final void m0(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.g) == false) goto L9;
        Iterator r0 = this.a.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L201;
        ((IMessageListComponent.a) r0.next()).e(((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.g) r10).a);
    L201:
        Iterator r1 = ((ArrayList) this.e).iterator();
    L203:
        if (r1.hasNext() == false) goto L205;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.InterfaceC0063a) r1.next()).l(r10);
        goto L203
    L205:
        List r2 = (List) ((Map) this.f.getValue()).get(r10.getClass());
        if (r2 == null) goto L211;
        Iterator r3 = r2.iterator();
    L209:
        if (r3.hasNext() == false) goto L255;
        e.b r4 = (e.b) r3.next();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.spec.messagelist.MessageListEventFeatureSpec.IMessageListEventObserver<com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.MessageListEvent>");
        r4.onEvent(r10);
        goto L209
    L255:
        return;
    L211:
        return;
    L9:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.d) == false) goto L19;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.d r5 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.d) r10;
        Iterator r6 = this.a.a.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        ((IMessageListComponent.a) r6.next()).A9();
        goto L12
    L14:
        Iterator r7 = ((ArrayList) this.j).iterator();
    L16:
        if (r7.hasNext() == false) goto L201;
        ChatWindowMessageList.a r8 = (ChatWindowMessageList.a) r7.next();
        long r9 = r5.a;
        r8.b();
        goto L16
    L19:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.h) == false) goto L29;
        Iterator r11 = this.a.a.iterator();
    L22:
        if (r11.hasNext() == false) goto L24;
        ((IMessageListComponent.a) r11.next()).y9();
        goto L22
    L24:
        Iterator r12 = ((ArrayList) this.j).iterator();
    L26:
        if (r12.hasNext() == false) goto L201;
        ((ChatWindowMessageList.a) r12.next()).a();
        goto L26
    L29:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.i) == false) goto L35;
        Iterator r13 = this.a.a.iterator();
    L32:
        if (r13.hasNext() == false) goto L201;
        ((IMessageListComponent.a) r13.next()).x9();
        goto L32
    L35:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.g0) == false) goto L41;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.g0 r14 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.g0) r10;
        Iterator<o> r15 = this.k.iterator();
    L38:
        if (r15.hasNext() == false) goto L201;
        o r16 = r15.next();
        String r17 = r14.a;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "messageId");
        goto L38
    L41:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.j) == false) goto L47;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.j r18 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.j) r10;
        Iterator<IMessageListComponent.g> r19 = this.m.iterator();
    L44:
        if (r19.hasNext() == false) goto L201;
        r19.next().a(r18.a);
        goto L44
    L47:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.c0) == false) goto L53;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.c0 r20 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.c0) r10;
        Iterator<IMessageListComponent.i> r21 = this.l.iterator();
    L50:
        if (r21.hasNext() == false) goto L201;
        IMessageListComponent.i r22 = r21.next();
        int r23 = r20.a;
        r22.a();
        goto L50
    L53:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.C0064b) == false) goto L66;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.C0064b r24 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.C0064b) r10;
        Iterator r25 = ((ArrayList) this.o).iterator();
    L56:
        if (r25.hasNext() == false) goto L201;
        m1 r26 = (m1) r25.next();
        if (r24.a == true) goto L59;
        r26.c();
        m1 r27 = this.b.e();
        if (r27 == null) goto L56;
        r27.c();
        goto L56
    L59:
        r26.b();
        m1 r28 = this.b.e();
        if (r28 == null) goto L56;
        r28.b();
        goto L56
    L66:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.l) == false) goto L72;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.l r29 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.l) r10;
        Iterator<o> r30 = this.k.iterator();
    L69:
        if (r30.hasNext() == false) goto L201;
        r30.next().R(r29.a);
        goto L69
    L72:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.a) == false) goto L78;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.a r31 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.a) r10;
        Iterator<IMessageListComponent.j> r32 = this.p.iterator();
    L75:
        if (r32.hasNext() == false) goto L201;
        IMessageListComponent.j r33 = r32.next();
        r31.getClass();
        r33.a();
        goto L75
    L78:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.e0) == false) goto L84;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.e0 r34 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.e0) r10;
        Iterator<o> r35 = this.k.iterator();
    L81:
        if (r35.hasNext() == false) goto L201;
        o r36 = r35.next();
        r34.getClass();
        r36.getClass();
        goto L81
    L84:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.f0) == false) goto L90;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.f0 r37 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.f0) r10;
        Iterator<o> r38 = this.k.iterator();
    L87:
        if (r38.hasNext() == false) goto L201;
        o r39 = r38.next();
        r37.getClass();
        r39.getClass();
        Intrinsics.checkNotNullParameter(null, "itemView");
        Intrinsics.checkNotNullParameter(null, "translatableMessageVO");
        goto L87
    L90:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.o) == false) goto L95;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.o r40 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.o) r10;
        o4b.a r41 = this.h;
        if (r41 == null) goto L201;
        r41.U(r40.a, r40.b);
        goto L201
    L95:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.p) == false) goto L100;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.p r42 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.p) r10;
        i r43 = this.g;
        if (r43 == null) goto L201;
        r43.s(r42.a, r42.b, r42.c, r42.d, r42.e, r42.f, r42.g);
        goto L201
    L100:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.r) == false) goto L105;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.r r44 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.r) r10;
        q r45 = this.i;
        if (r45 == null) goto L201;
        r45.t(r44.a, r44.b);
        goto L201
    L105:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.v) == false) goto L110;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.v r46 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.v) r10;
        i r47 = this.g;
        if (r47 == null) goto L201;
        r47.n(r46.a, r46.b, r46.c, r46.d);
        goto L201
    L110:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.q) == false) goto L115;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.q r48 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.q) r10;
        i r49 = this.g;
        if (r49 == null) goto L201;
        r49.v(r48.a, r48.b, r48.c);
        goto L201
    L115:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.k) == false) goto L121;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.k r50 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.k) r10;
        Iterator<IMessageListComponent.h> r51 = this.n.iterator();
    L118:
        if (r51.hasNext() == false) goto L201;
        IMessageListComponent.h r52 = r51.next();
        MessageVisibleEntity r53 = r50.a;
        r52.a();
        goto L118
    L121:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.e) == false) goto L127;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.e r54 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.e) r10;
        Iterator<IMessageListComponent.h> r55 = this.n.iterator();
    L124:
        if (r55.hasNext() == false) goto L201;
        IMessageListComponent.h r56 = r55.next();
        y6b.c<?> r57 = r54.a;
        r56.b();
        goto L124
    L127:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.s) == false) goto L133;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.s r58 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.s) r10;
        Iterator<IMessageListComponent.b> r59 = this.r.iterator();
    L130:
        if (r59.hasNext() == false) goto L201;
        IMessageListComponent.b r60 = r59.next();
        r58.getClass();
        r60.a();
        goto L130
    L133:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.t) == false) goto L139;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.t r61 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.t) r10;
        Iterator<IMessageListComponent.d> r62 = this.q.iterator();
    L136:
        if (r62.hasNext() == false) goto L201;
        IMessageListComponent.d r63 = r62.next();
        int r64 = r61.a;
        r63.a();
        goto L136
    L139:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.z) == false) goto L145;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.z r65 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.z) r10;
        Iterator<o> r66 = this.k.iterator();
    L142:
        if (r66.hasNext() == false) goto L201;
        r66.next().d(r65.a, r65.b);
        goto L142
    L145:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.y) == false) goto L151;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.y r67 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.y) r10;
        Iterator<o> r68 = this.k.iterator();
    L148:
        if (r68.hasNext() == false) goto L201;
        o r69 = r68.next();
        String r70 = r67.a;
        r69.getClass();
        goto L148
    L151:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.u) == false) goto L157;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.u r71 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.u) r10;
        Iterator<o> r72 = this.k.iterator();
    L154:
        if (r72.hasNext() == false) goto L201;
        o r73 = r72.next();
        v5b.c<v5b.a<?>> r74 = r71.a;
        r73.getClass();
        goto L154
    L157:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.a0) == false) goto L163;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.a0 r75 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.a0) r10;
        Iterator<o> r76 = this.k.iterator();
    L160:
        if (r76.hasNext() == false) goto L201;
        r76.next().p(r75.a, r75.b);
        goto L160
    L163:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.x) == false) goto L171;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.x r77 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.x) r10;
        Iterator<o> r78 = this.k.iterator();
    L166:
        if (r78.hasNext() == false) goto L201;
        n r79 = (o) r78.next();
        if ((r79 instanceof b3b.e) == false) goto L166;
        ((b3b.e) r79).o(r77.a, r77.b, r77.c);
        goto L166
    L171:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.n) == false) goto L177;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.n r80 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.n) r10;
        Iterator<jya.a> r81 = this.s.iterator();
    L174:
        if (r81.hasNext() == false) goto L201;
        r81.next().a(r80.a);
        goto L174
    L177:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.m) == false) goto L183;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.m r82 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.m) r10;
        Iterator<jya.a> r83 = this.s.iterator();
    L180:
        if (r83.hasNext() == false) goto L201;
        r83.next().b(r82.a);
        goto L180
    L183:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.c) == false) goto L189;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.c r84 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.c) r10;
        Iterator r85 = this.a.a.iterator();
    L186:
        if (r85.hasNext() == false) goto L201;
        ((IMessageListComponent.a) r85.next()).z9(r84.a);
        goto L186
    L189:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.b0) == false) goto L195;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.b0 r86 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.b0) r10;
        Iterator r87 = this.a.a.iterator();
    L192:
        if (r87.hasNext() == false) goto L201;
        ((IMessageListComponent.a) r87.next()).B9(r86.a);
        goto L192
    L195:
        if ((r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.d0) == false) goto L200;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.d0 r88 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.d0) r10;
        Iterator r89 = this.a.a.iterator();
    L198:
        if (r89.hasNext() == false) goto L201;
        ((IMessageListComponent.a) r89.next()).w9(r88.a);
        goto L198
    L200:
        boolean r90 = r10 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.f;
        goto L201
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "initData");
        Intrinsics.checkNotNullParameter(r4, "initData");
        F();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = this.d;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r5 = null;
    L5:
        IMessageListViewModel r6 = r5.f();
        if (r6 == null) goto L15;
        MutableLiveData<Chat> r7 = r6.getCurrentChat();
        if (r7 == null) goto L16;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = this.d;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L13:
        r7.observe(r0.getLifecycleOwner(), new b(this));
        return;
    L12:
        r0 = r2;
        goto L13
    L16:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.d = r2;
    }

    public MessageListEventDispatchFeature(e r2, h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        Intrinsics.checkNotNullParameter(r3, "listRenderer");
        this.a = new oxa.b();
        this.b = r2;
        this.c = r3;
        this.e = new ArrayList();
        this.f = LazyKt.lazy(new MessageListEventDispatchFeature$mappedObservers$2(this));
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
    }
}
