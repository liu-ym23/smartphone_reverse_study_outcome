package wgb;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ b<Object> a;

    public c(b<Object> r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        com.ss.android.lark.chatwindow.view.tip.a r2 = this.a.e;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r2 = null;
    L5:
        r2.e();
    }
}
