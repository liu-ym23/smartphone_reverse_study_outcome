package p20;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.IHybridBaseService;
import com.bytedance.android.live.core.utils.ContextUtil;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;

    public a(String r1, String r2) {
        this.a = r1;
        this.b = true;
        this.c = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        FragmentActivity r6 = ContextUtil.contextToFragmentActivity(r5.getContext());
        if (r6 == null) goto L8;
        IHybridBaseService r0 = (IHybridBaseService) k.f(IHybridBaseService.class);
        if (r0 == null) goto L9;
        r0.showHybridDebugFragment(r6, this.a, this.b, this.c);
        return;
    L9:
        return;
    }
}
