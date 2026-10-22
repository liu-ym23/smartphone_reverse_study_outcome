package apc;

import android.view.View;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.PlayControlBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends OnSingleClickListener {
    public final /* synthetic */ PlayControlBar a;

    public b(PlayControlBar r1) {
        this.a = r1;
    }

    public final void onSingleClick(View r2) {
        PlayControlBar r3 = this.a;
        if (r3.i == true) goto L6;
        LKUIToast.show(r3.getContext(), 2131892385);
        return;
    L6:
        if (r3.h != null) goto L8;
        return;
    L8:
        if (r3.a.isChecked() == false) goto L10;
        r3.h.onPlay();
        return;
    L10:
        r3.h.onPause();
    }
}
