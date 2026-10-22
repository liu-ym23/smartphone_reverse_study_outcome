package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.m1;
import com.ss.android.lark.chat.utils.n1;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements h4b.c.a {
    public final /* synthetic */ MessageListRendererFeature a;
    public final /* synthetic */ m2b.a b;
    public final /* synthetic */ b3b.f c;

    public static final class a implements Runnable {
        public final /* synthetic */ y6b.c<?> a;
        public final /* synthetic */ MessageListRendererFeature b;

        public a(y6b.c<?> r1, MessageListRendererFeature r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            m1 r0 = m1.a.a;
            y6b.c<?> r1 = this.a;
            MessageListRendererFeature r2 = this.b;
            long r3 = System.currentTimeMillis();
            long r5 = r3 - r0.b;
            if (r5 <= 1000) goto L6;
            r0.a = 0;
        L6:
            if (r5 <= 100) goto L20;
            int r6 = r0.a + 1;
            r0.a = r6;
            r0.b = r3;
            if (r6 != 1) goto L10;
            n1.a("click :" + r1.c);
            return;
        L10:
            if (r6 != 3) goto L23;
            boolean r4 = MessageListRendererFeature.x;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r7 = r2.G();
            if (r7 == null) goto L15;
            MessageInfo r8 = r7.getMessageInfoById(r1.c);
        L16:
            if (r8 == null) goto L21;
            n1.a("click 3:" + r8);
            return;
        L21:
            return;
        L15:
            r8 = null;
            goto L16
        L23:
            return;
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

    @Override // h4b.c.a
    public final boolean a(y6b.c r6, com.ss.android.lark.chat.message.menu.context.a r7) {
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r7, "itemHook");
        Function1<y6b.c<?>, Boolean> r0 = this.a.a.p();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = this.a.c;
        ListMode r3 = null;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r2 = null;
    L13:
        e4b.a r4 = (e4b.a) r2.b(e4b.a.class);
        if (r4 == null) goto L17;
        r3 = r4.o();
    L17:
        if (r3 != ListMode.MULTI_SELECT) goto L19;
        return true;
    L19:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a r5 = this.a.J();
        if (r5 != null) goto L22;
        return false;
    L22:
        return r5.B(r6, r7);
    L5:
        if (((Boolean) r0.invoke(r6)).booleanValue() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // h4b.c.a
    public final void b(y6b.c<?> r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "item");
        Function1<y6b.c<?>, Unit> r0 = this.a.a.o();
        if (r0 == null) goto L6;
        r0.invoke(r13);
        return;
    L6:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r1 = this.a.c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = null;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r1 = null;
    L9:
        e4b.a r3 = (e4b.a) r1.b(e4b.a.class);
        boolean r4 = true;
        if (r3 != null) goto L12;
    L14:
        boolean r15 = false;
    L15:
        if (r15 == false) goto L18;
        return;
    L18:
        if (this.b.isClickable() == true) goto L25;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r16 = this.a.G();
        if (r16 == null) goto L84;
        s2b.e r17 = r16.getUIModel();
        if (r17 == null) goto L84;
        r17.i(r13.c);
    L84:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r18 = this.a.c;
        if (r18 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L89:
        if (DevEnvUtil.isDebugMode(r2.getContext()) == false) goto L94;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r19 = this.a.G();
        if (r19 == null) goto L95;
        r19.executeMessage(new a(r13, this.a));
        return;
    L95:
        return;
    L94:
        return;
    L87:
        r2 = r18;
        goto L89
    L25:
        if (r13.d() == false) goto L76;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r110 = this.a.c;
        if (r110 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r110 = null;
    L29:
        s2b.d r111 = r110.a();
        if (r111 == null) goto L32;
        boolean r112 = r111.q8();
    L33:
        if (r112 == true) goto L42;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r113 = this.a.c;
        if (r113 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r113 = null;
    L37:
        s2b.d r114 = r113.a();
        if (r114 == null) goto L40;
        boolean r115 = r114.e0();
    L41:
        if (r115 == false) goto L76;
    L40:
        r115 = false;
    L42:
        List<y6b.f> r116 = r13.g2;
        if (r116 == null) goto L45;
        int r117 = r116.size();
    L46:
        if (r117 <= 0) goto L76;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r118 = this.a.c;
        if (r118 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r118 = null;
    L50:
        s2b.d r119 = r118.a();
        if (r119 == null) goto L53;
        boolean r120 = r119.Y();
    L54:
        if (r120 == true) goto L76;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r121 = this.a.c;
        if (r121 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r121 = null;
    L58:
        s2b.d r122 = r121.a();
        if (r122 == null) goto L84;
        b3b.f r5 = this.c;
        String r6 = r13.c;
        String r7 = r13.Q1;
        if (r7 != null) goto L63;
    L66:
        if (r4 == false) goto L68;
        String r8 = r13.c;
    L71:
        String r9 = r8;
        String r10 = r13.Q1;
        if (r10 == null) goto L74;
        r10.length();
    L74:
        r5.D(r6, r9, r122.getChatId(), null, Boolean.FALSE, r122.r);
        goto L84
    L68:
        r8 = r13.Q1;
        if (r8 != null) goto L71;
        r8 = BuildConfig.FLAVOR;
        goto L71
    L63:
        if (r7.length() == 0) goto L66;
        r4 = false;
        goto L66
    L53:
        r120 = false;
        goto L54
    L45:
        r117 = 0;
        goto L46
    L32:
        r112 = false;
    L76:
        if (r13.d() == false) goto L78;
    L79:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r123 = this.a.G();
        if (r123 == null) goto L84;
        s2b.e r124 = r123.getUIModel();
        if (r124 == null) goto L84;
        r124.i(r13.c);
        goto L84
    L78:
        if (ReplyInThreadUtil.b(r13) == true) goto L84;
    L12:
        if (r3.E(r13, r14) != true) goto L14;
        r15 = true;
        goto L15
    }

    @Override // h4b.c.a
    public final void c(y6b.c r2, com.ss.android.lark.chat.message.menu.context.a r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "itemHook");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a r0 = this.a.J();
        if (r0 == null) goto L6;
        r0.D(r2, r3);
        return;
    }

    public c(MessageListRendererFeature r1, m2b.a r2, b3b.f r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
