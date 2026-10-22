package com.bytedance.android.live.effect.beauty.body;

import android.graphics.Rect;
import android.view.TouchDelegate;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements Runnable {
    public final /* synthetic */ LiveBodyBeautyAdapter.b a;

    public f(LiveBodyBeautyAdapter.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveSwitchButton r0 = ((RecyclerView.ViewHolder) this.a).itemView.findViewById(2131387878);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Rect r1 = new Rect();     // Catch: Throwable -> L6
        ((RecyclerView.ViewHolder) this.a).itemView.getHitRect(r1);     // Catch: Throwable -> L6
        TouchDelegate r2 = new TouchDelegate(r1, r0);     // Catch: Throwable -> L6
        ((RecyclerView.ViewHolder) this.a).itemView.setTouchDelegate(r2);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
