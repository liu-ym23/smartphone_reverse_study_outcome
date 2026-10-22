package i52;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnLongClickListener {
    public final /* synthetic */ AbsPublicScreenMessageViewHolder a;

    public d(AbsPublicScreenMessageViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        AbsPublicScreenMessageViewHolder r3 = this.a;
        r3.b = false;
        r3.d3();
        return false;
    }
}
