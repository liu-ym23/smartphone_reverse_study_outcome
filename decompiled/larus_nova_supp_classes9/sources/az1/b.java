package az1;

import com.bytedance.android.livesdk.gift.guide.view.CommentGiftGuideView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ CommentGiftGuideView a;

    public b(CommentGiftGuideView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        CommentGiftGuideView r4 = this.a;
        int r0 = CommentGiftGuideView.i;
        r4.e("time_up");
    }
}
