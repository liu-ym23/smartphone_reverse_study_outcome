package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data;

import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.b1;
import com.ss.android.lark.biz.im.api.d0;
import com.ss.android.lark.biz.im.api.f0;
import com.ss.android.lark.biz.im.api.h1;
import com.ss.android.lark.biz.im.api.message.params.l;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.u0;
import com.ss.android.lark.biz.im.api.v0;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.chatbase.i;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import y6b.c;
import y6b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements p {
    public final /* synthetic */ MessageListDataFeature a;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final m2b.a a() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.f;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L6:
        return r0.a();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final s0 b() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a r0 = MessageListDataFeature.l(this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final d0 c() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r0 = this.a.F();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final Map<Class<? extends l>, l> d() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r0 = this.a.F();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final q4b.a getMessageSender() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        IMessageListComponent.e r1 = r0.getDependency();
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getMessageSender();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final a1 h() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a r0 = MessageListDataFeature.l(this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final w0 i() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a r0 = MessageListDataFeature.l(this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final z0 j() {
        return this.a.a.f();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final List<b1> k() {
        return this.a.k;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final List<i<MessageInfo>> l() {
        return this.a.n;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final f0 m() {
        return this.a.a.h();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final Boolean n() {
        return this.a.a.l();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final boolean o() {
        return this.a.a.c();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final v0 p() {
        return this.a.a.e();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final jya.b q() {
        return this.a.a.i();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final z2b.a r() {
        return this.a.c;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final List<h1> s() {
        return this.a.l;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final Boolean t() {
        return this.a.i;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final e<c<?>> u() {
        return this.a.a.k();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final Integer v() {
        return Integer.valueOf(this.a.a.j());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final List<u0> w() {
        return this.a.j;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final List<y3b.a> x() {
        return this.a.m;
    }

    public b(MessageListDataFeature r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p
    public final void e(BasePageStore<MessageInfo, ? extends x4b.a<MessageInfo>> r3) {
        Intrinsics.checkNotNullParameter(r3, "store");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r1 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
        if (r1 == null) goto L9;
        r1.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.g(r3));
        return;
    }
}
