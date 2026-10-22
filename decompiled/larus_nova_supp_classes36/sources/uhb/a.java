package uhb;

import android.view.View;
import com.ss.android.lark.flow.passport.ui.widget.verifycode.VerifyCodeEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnLongClickListener {
    public final /* synthetic */ VerifyCodeEditText a;

    public a(VerifyCodeEditText r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        this.a.a.setCursorVisible(true);
        return false;
    }
}
