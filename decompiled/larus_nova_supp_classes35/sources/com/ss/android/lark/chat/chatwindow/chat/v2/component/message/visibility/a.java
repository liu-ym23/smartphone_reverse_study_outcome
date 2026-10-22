package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility;

import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements SceneCoordinateRecyclerView.a {
    public final /* synthetic */ MessageVisibleManager a;
    public final /* synthetic */ SceneCoordinateRecyclerView b;

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView.a
    public final void onAttachedToWindow() {
        MessageVisibleManager$1$1 r0 = this.a.f;
        if (r0 == null) goto L6;
        this.b.addOnScrollListener(r0);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView.a
    public final void onDetachedFromWindow() {
        MessageVisibleManager$1$1 r0 = this.a.f;
        if (r0 == null) goto L6;
        this.b.removeOnScrollListener(r0);
        return;
    }

    public a(MessageVisibleManager r1, SceneCoordinateRecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }
}
