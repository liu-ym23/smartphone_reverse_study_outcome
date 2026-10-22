package dw1;

import android.view.View;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.SingleDrawTabViewHolder;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdk.viewmodel.i;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ SingleDrawTabViewHolder a;
    public final /* synthetic */ e b;

    public d(SingleDrawTabViewHolder r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        SingleDrawViewModel r5 = this.a.c;
        if (r5 == null) goto L8;
        NextLiveData r6 = r5.getShowLoading();
        if (r6 == null) goto L9;
        r6.setValue(new i(this.b.f()));
        return;
    L9:
        return;
    }
}
