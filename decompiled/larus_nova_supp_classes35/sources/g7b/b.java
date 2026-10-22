package g7b;

import android.view.View;
import com.larksuite.framework.ui.BasePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.chat.utils.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ BasePopupWindow b;

    public b(a r1, BasePopupWindow r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        int r3 = y0.a;
        if (y0.a(this.a.b.getChat()) == true) goto L6;
        y0.f(this.a.b.getContext());
        return;
    L6:
        a r4 = this.a;
        r4.d.a(r4.c);
        BasePopupWindow r5 = this.b;
        PopupWindowLancet.handleDismissBeforeOrigin(r5);
        r5.dismiss();
    }
}
