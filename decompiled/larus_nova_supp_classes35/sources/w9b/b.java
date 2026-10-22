package w9b;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.coremd.clickcompat.ChatAtClickHandler;
import com.ss.android.lark.coremd.clickcompat.ChatCodeBlockClickHandler;
import com.ss.android.lark.coremd.clickcompat.ChatImageClickHandler;
import com.ss.android.lark.coremd.clickcompat.ChatLinkClickHandler;
import com.ss.android.lark.coremd.clickcompat.ChatMediaClickHandler;
import com.ss.android.lark.coremd.clickcompat.d;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import com.ss.android.lark.widget.table.entity.TableInfo;
import eab.f;
import eab.h;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v7b.g;
import v7b.l;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements c {
    public final String a;
    public final Function0<com.ss.android.lark.coremd.clickcompat.c> b;

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final com.ss.android.lark.coremd.clickcompat.c i() {
        return (com.ss.android.lark.coremd.clickcompat.c) this.b.invoke();
    }

    @Override // w9b.c
    public final void a(g r3) {
        Intrinsics.checkNotNullParameter(r3, "code");
        com.ss.android.lark.coremd.clickcompat.c r0 = i();
        if (r0 == null) goto L8;
        ChatCodeBlockClickHandler r1 = r0.e;
        if (r1 == null) goto L9;
        r1.a(r3, this.a);
        return;
    L9:
        return;
    }

    @Override // w9b.c
    public final void b(n r3) {
        Intrinsics.checkNotNullParameter(r3, "link");
        com.ss.android.lark.coremd.clickcompat.c r0 = i();
        if (r0 == null) goto L8;
        ChatLinkClickHandler r1 = r0.c;
        if (r1 == null) goto L9;
        r1.a(r3, this.a);
        return;
    L9:
        return;
    }

    @Override // w9b.c
    public final void e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "number");
        com.ss.android.lark.coremd.clickcompat.c r1 = i();
        if (r1 == null) goto L8;
        com.ss.android.lark.coremd.clickcompat.b r2 = r1.f;
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r3, "number");
        ChatCoreModule.a().getPhoneDependency().a(r2.a.getContext(), r3);
        return;
    L9:
        return;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (r3 == null) goto L8;
        Class<?> r1 = r3.getClass();
    L10:
        if (Intrinsics.areEqual(b.class, r1) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.coremd.facade.click.ChatMessageNodeClickDelegate");
        return Intrinsics.areEqual(this.a, ((b) r3).a);
    L8:
        r1 = null;
        goto L10
    }

    @Override // w9b.c
    public final void g(eab.a r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        com.ss.android.lark.coremd.clickcompat.c r0 = i();
        if (r0 == null) goto L8;
        ChatAtClickHandler r1 = r0.b;
        if (r1 == null) goto L9;
        r1.a(r3, this.a);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r2, Function0<? extends com.ss.android.lark.coremd.clickcompat.c> r3) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "clickAdapterProvider");
        this.a = r2;
        this.b = r3;
    }

    @Override // w9b.c
    public final void c(View r7, eab.b r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "info");
        com.ss.android.lark.coremd.clickcompat.c r1 = i();
        if (r1 == null) goto L11;
        com.ss.android.lark.coremd.clickcompat.a r2 = r1.g;
        if (r2 == null) goto L12;
        String r3 = this.a;
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "node");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        y6b.a<?> r0 = r2.b.getMessageById(r3);
        if (r0 != null) goto L9;
        Log.e("ChatAtUserGroupClickHandler", "message not found");
        return;
    L9:
        AtUserGroupInfo r4 = new AtUserGroupInfo(r8.j, r8.k, r8.l);
        w.a(r2.a).E().H8(r7.getContext(), r4);
        int r9 = f3b.c.a;
        f3b.c.b(r2.a, r0, r4);
        return;
    L12:
        return;
    }

    @Override // w9b.c
    public final void f(View r5, h r6, com.ss.android.lark.coremdbiz.facade.table.a r7) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "info");
        Intrinsics.checkNotNullParameter(r7, "factory");
        com.ss.android.lark.coremd.clickcompat.c r2 = i();
        if (r2 == null) goto L19;
        d r3 = r2.h;
        if (r3 == null) goto L20;
        String r4 = this.a;
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "node");
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r7, "factory");
        y6b.a<?> r0 = r3.b.getMessageById(r4);
        if (r0 != null) goto L9;
        Log.e("ChatTableClickHandler", "message not found");
        return;
    L9:
        Object r1 = r0.b();
        if ((r1 instanceof BaseTextContentVO) == false) goto L12;
        BaseTextContentVO r8 = (BaseTextContentVO) r1;
    L13:
        if (r8 != null) goto L15;
        return;
    L15:
        if (r8.g() == null) goto L23;
        int r9 = com.ss.android.lark.coremdbiz.facade.table.d.a;
        TableInfo r10 = com.ss.android.lark.coremdbiz.facade.table.d.a(r5.getContext(), r7, r6);
        ChatCoreModule.a().getChatDependency().y(r3.a.getContext(), r10);
        return;
    L23:
        return;
    L12:
        r8 = null;
        goto L13
    L20:
        return;
    }

    @Override // w9b.c
    public final void h(f r9, View r10, Rect r11, Drawable r12, pwa.a r13) {
        Intrinsics.checkNotNullParameter(r9, "media");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "clickBounds");
        com.ss.android.lark.coremd.clickcompat.c r0 = i();
        if (r0 == null) goto L8;
        ChatMediaClickHandler r1 = r0.a();
        if (r1 == null) goto L9;
        r1.a(r9, this.a, r10, r11, r12, r13);
        return;
    L9:
        return;
    }

    @Override // w9b.c
    public final void d(l r10, View r11, Rect r12, Drawable r13, pwa.a r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "image");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "clickBounds");
        com.ss.android.lark.coremd.clickcompat.c r0 = i();
        if (r0 == null) goto L8;
        ChatImageClickHandler r1 = r0.a;
        if (r1 == null) goto L9;
        r1.a(r10, this.a, r11, r12, r13, r14, r15);
        return;
    L9:
        return;
    }
}
