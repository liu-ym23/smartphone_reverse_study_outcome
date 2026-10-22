package lx0;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.bytedance.android.live.record.LiveScreenRecordPublishGuideDialog;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LiveScreenRecordPublishGuideDialog a;

    public c(LiveScreenRecordPublishGuideDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        ImageView r0 = this.a.E;
        if (r0 == null) goto L6;
        r0.setBackground(new BitmapDrawable(this.a.getContext().getResources(), r5));
        return;
    }
}
