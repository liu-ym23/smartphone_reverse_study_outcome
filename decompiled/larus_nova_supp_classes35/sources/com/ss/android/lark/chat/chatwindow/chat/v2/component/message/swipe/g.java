package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ SwipeActionHandler a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        SwipeActionHandler r0 = this.a;
        SwipeActionHandler.CapturedItemInfo r1 = r0.g;
        if (r1 == null) goto L17;
        RecyclerView.ViewHolder r2 = r1.b;
        if (r2 == null) goto L19;
        View r3 = r2.itemView;
        RecyclerView r4 = r0.j;
        if (r4 != null) goto L11;
        return;
    L11:
        if (r3.getTranslationX() != this.a.h) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L18;
        Log.d("SwipeActionHandler", "force update translationX, xx: " + r3.getTranslationX() + ", pre: " + this.a.h);
        r4.invalidateItemDecorations();
        r3.setTranslationX(this.a.h);
        return;
    L18:
        return;
    L13:
        r5 = false;
        goto L14
    L19:
        return;
    }

    public g(SwipeActionHandler r1) {
        this.a = r1;
    }
}
