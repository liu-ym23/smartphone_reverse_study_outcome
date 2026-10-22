package s62;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AICloneConvItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        AICloneConvItem r4 = this.a.a();
        if (r4 == null) goto L8;
        String r5 = r4.getSchema();
        if (r5 == null) goto L9;
        this.a.b(r5, "live_comment");
        return;
    L9:
        return;
    }
}
