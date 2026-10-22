package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text;

import android.view.View;
import com.ss.android.lark.biz.im.api.message.params.z;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.select.m;
import g3b.u;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnLongClickListener {
    public final /* synthetic */ TextClickListenerProviderV2 a;
    public final /* synthetic */ TextChatView2 b;
    public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> c;
    public final /* synthetic */ boolean d;

    public b(TextClickListenerProviderV2 r1, TextChatView2 r2, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r6) {
        u r0 = (u) this.a.a.d0(u.class);
        if (r0 == null) goto L5;
        Function1<? super View, Unit> r2 = r0.d.b;
    L7:
        if (r2 == null) goto L12;
        Function1<? super View, Unit> r1 = r0.d.b;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNull(r6);
        r1.invoke(r6);
    L11:
        return true;
    L12:
        z r7 = this.a.a.d0(z.class);
        boolean r3 = false;
        if (r7 != null) goto L15;
    L17:
        boolean r8 = false;
    L19:
        if ((!this.a.a.e0()) == true) goto L21;
    L33:
        TextClickListenerProviderV2.a r9 = this.a.c;
        if (r9 == null) goto L36;
        r9.a(this.c);
    L36:
        return true;
    L21:
        if (this.b.c.getVisibility() != 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == true) goto L33;
        LKUILightTextView r5 = this.b.getLightTextView();
        WeakReference<m> r10 = com.ss.android.lark.chat.message.menu.a.a;
        Intrinsics.checkNotNullParameter(r5, "view");
        if (com.ss.android.lark.chat.message.menu.a.b(r5) == false) goto L28;
    L29:
        r3 = true;
    L30:
        if (r3 == false) goto L33;
        if (r8 == true) goto L33;
        this.a.d(this.b.getLightTextView(), this.c, this.d, null);
        goto L36
    L28:
        if (com.ss.android.lark.chat.utils.u.a.a.e == true) goto L30;
    L23:
        r4 = false;
        goto L24
    L15:
        if (r7.a != true) goto L17;
        r8 = true;
        goto L19
    L5:
        r2 = null;
        goto L7
    }
}
