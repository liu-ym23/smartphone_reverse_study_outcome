package i82;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.VSMsgBoardSkinViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements View.OnTouchListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ VSMsgBoardDress c;
    public final /* synthetic */ VSMsgBoardSkinViewHolder d;

    public h(g r1, boolean r2, VSMsgBoardDress r3, VSMsgBoardSkinViewHolder r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        int r0 = r6.getAction();
        if (r0 != 0) goto L5;
        r5.setAlpha(0.8f);
    L21:
        return true;
    L5:
        if (r0 != 1) goto L7;
        r5.setAlpha(1.0f);
        if ((r6.getEventTime() - r6.getDownTime()) >= ViewConfiguration.getLongPressTimeout()) goto L21;
        if (this.b == true) goto L15;
        this.a.c = String.valueOf(this.c.getDressId());
    L15:
        i r7 = this.a.h;
        if (r7 == null) goto L18;
        r7.j(this.c);
    L18:
        ((me.drakeet.multitype.b) this.a).a.notifyDataSetChanged();
        this.a.j(300, this.d, this.c);
        return true;
    L7:
        if (r0 != 3) goto L21;
        r5.setAlpha(1.0f);
        goto L21
    }
}
