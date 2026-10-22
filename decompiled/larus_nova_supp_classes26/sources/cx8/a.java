package cx8;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter;
import com.larus.bmhome.chat.j4;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonLoadView;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements TTCJPayLoadingAdapter<CommonLoadView> {
    public a() {
    }

    public final void onHide(Object r2) {
        CommonLoadView r3 = (CommonLoadView) r2;
        if (r3 == null) goto L6;
        r3.setVisibility(8);
        return;
    }

    public final void onShow(Object r2) {
        CommonLoadView r3 = (CommonLoadView) r2;
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        return;
    }

    public final Object initLoadingView(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        List r9 = AppHost.a.a().g();
        ListIterator r10 = r9.listIterator(r9.size());
    L4:
        if (r10.hasPrevious() == false) goto L8;
        Object r11 = r10.previous();
        if ((((Activity) r11) instanceof j4) == false) goto L4;
    L9:
        Context r12 = (Activity) r11;
        if (r12 != null) goto L13;
        r12 = AppHost.a.getApplication().getApplicationContext();
    L13:
        Intrinsics.checkNotNull(r12);
        CommonLoadView r13 = new CommonLoadView(f.d(r12), null, 0, true, 6);
        r13.setVisibility(8);
        return r13;
    L8:
        r11 = null;
        goto L9
    }

    public final void textAndBackgroundVisible(Object r1, boolean r2) {
        TTCJPayLoadingAdapter.DefaultImpls.textAndBackgroundVisible(this, (CommonLoadView) r1, r2);
    }
}
