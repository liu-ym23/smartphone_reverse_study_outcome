package p82;

import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ p a;

    public q(p r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        LiveSwitchButton r4 = this.a.e;
        if (r4 == null) goto L6;
        r4.setEnabled(true);
        return;
    }
}
