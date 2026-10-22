package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.widget.span.MediaInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements com.ss.android.lark.coremd.base.parse.n.b<eab.f> {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.b
    public final void a(final com.ss.android.lark.coremd.impl.parse.f r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        int r0 = aab.a.a;
        ImageSpan r1 = aab.a.b(r7.i, r7.f, r7.g);
        if (r1 == null) goto L13;
        Drawable r2 = r1.getDrawable();
        if (r2 == null) goto L10;
        Drawable.ConstantState r3 = r2.getConstantState();
        if (r3 == null) goto L10;
        final Drawable r4 = r3.newDrawable();
    L11:
        final Rect r5 = aab.a.a(r1, r7.h, r7.i, r7.f, r7.g);
        MediaInfo r6 = (MediaInfo) IMMediaExtend.q.b(new MessageFullScreenClickPlugin$configureClick$1$7$mediaInfo$1(r4, r7, r5));
        i r8 = this.a;
        new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.n(r8.a, r8.b, r8.c).m(r7.h, r6);
        return;
    L10:
        r4 = null;
        goto L11
    }
}
