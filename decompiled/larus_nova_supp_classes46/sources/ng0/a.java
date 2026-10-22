package ng0;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRoomAnchorView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements Runnable {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ VoiceChatRoomAnchorView b;

    public a(FrameLayout r1, VoiceChatRoomAnchorView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        int r0 = this.a.getWidth();
        int r1 = (this.a.getWidth() * 2) / 3;
        a1.p(this.b.a(2131389468), r1);
        a1.k(this.b.a(2131389468), r1);
        a1.p(this.b.a(2131383601), r0);
        a1.k(this.b.a(2131383601), r0);
        a1.p(this.b.a(2131387480), r0);
        a1.k(this.b.a(2131387480), r0);
        a1.k(this.b.a(2131362578), r0);
        this.b.setUserNameVisibility(8);
        UtilityKotlinExtentionsKt.w(this.b);
        VoiceChatRoomAnchorView r2 = this.b;
        r2.q = true;
        r2.d(1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
