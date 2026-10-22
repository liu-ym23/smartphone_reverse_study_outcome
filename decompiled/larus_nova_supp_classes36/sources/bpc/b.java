package bpc;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends OnSingleClickListener {
    public final /* synthetic */ FileView a;

    public b(FileView r1) {
        this.a = r1;
    }

    public final void onSingleClick(View r1) {
        this.a.performClick();
    }
}
