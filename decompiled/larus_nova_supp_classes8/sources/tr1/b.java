package tr1;

import android.widget.FrameLayout;
import com.bytedance.android.livesdk.chatroom.vs_impl.widget.BusinessScreenBarWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ BusinessScreenBarWidget a;

    public b(BusinessScreenBarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        FrameLayout r4 = this.a.b;
        if (r4 == null) goto L6;
        r4.setVisibility(0);
        return;
    }
}
