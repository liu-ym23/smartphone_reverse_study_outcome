package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements Runnable {
    public final /* synthetic */ LikeEggView a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a b;

    public f(LikeEggView r1, com.bytedance.android.livesdk.chatroom.likeegg.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView r0 = this.a.d;     // Catch: Throwable -> L16
        if (r0 == null) goto L19;
        String r1 = this.b.finishContent;     // Catch: Throwable -> L16
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        String r3 = "点赞完成 彩蛋即将揭晓";
    L14:
        r0.setText(r3);     // Catch: Throwable -> L16
        return;
    L13:
        r3 = this.b.finishContent;     // Catch: Throwable -> L16
        goto L14
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
        goto L11
    L19:
        return;
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }
}
