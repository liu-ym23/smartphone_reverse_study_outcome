package lib;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o extends RecyclerView.ItemDecoration {
    public final /* synthetic */ Activity a;

    public o(Activity r1) {
        this.a = r1;
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        super.getItemOffsets(r1, r2, r3, r4);
        r1.bottom = UIUtils.dp2px(this.a, 10.0f);
    }
}
