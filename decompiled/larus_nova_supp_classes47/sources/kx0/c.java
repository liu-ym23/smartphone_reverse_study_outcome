package kx0;

import android.view.View;
import com.bytedance.android.live.recharge.view.FastPayView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ FastPayView a;

    public c(FastPayView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        FastPayView.a(this.a);
    }
}
