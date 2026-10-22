package nz;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.broadcast.api.BubblePosition;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemBubbleInfo;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface h {
    CompositeDisposable a(Context r1, View r2, ItemBubbleInfo r3, BubblePosition r4);

    CompositeDisposable b(Context r1, View r2, String r3);
}
