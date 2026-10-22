package c91;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.message.model.j4;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ j4 a;

    public n(j4 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        String r0 = this.a.G();
        if (r0 == null) goto L6;
        jc1.k.n(IBaseLiveActionHandler.class).handle(r5.getContext(), y0.a(r0, null, 6));
        return;
    }
}
