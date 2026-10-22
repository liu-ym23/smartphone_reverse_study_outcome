package i82;

import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.VSMsgBoardBadgeViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ VSMsgBoardBadgeViewHolder b;
    public final /* synthetic */ VSMsgBoardDress c;

    public b(a r1, VSMsgBoardBadgeViewHolder r2, VSMsgBoardDress r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.b.getAdapterPosition() == (-1)) goto L9;
        a.j(this.a, 10, this.b, this.c);     // Catch: Throwable -> L6
        return;
    }
}
