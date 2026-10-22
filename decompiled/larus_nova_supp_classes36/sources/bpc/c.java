package bpc;

import android.view.View;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnLongClickListener {
    public final /* synthetic */ FileView a;

    public c(FileView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r1) {
        this.a.performLongClick();
        return true;
    }
}
