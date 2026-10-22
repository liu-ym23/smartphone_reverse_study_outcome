package l92;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.pin.business.im.PinImHighlightPageItemView;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ PinImHighlightPageItemView b;

    public c(String r1, PinImHighlightPageItemView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        k.n(ILiveActionHandler.class).handle(this.b.getContext(), this.a);
    }
}
