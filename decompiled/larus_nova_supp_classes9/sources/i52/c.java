package i52;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener a;
    public final /* synthetic */ AbsPublicScreenMessageViewHolder b;

    public c(View.OnClickListener r1, AbsPublicScreenMessageViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.onClick(r2);
        AbsPublicScreenMessageViewHolder r3 = this.b;
        r3.b = false;
        r3.d3();
    }
}
