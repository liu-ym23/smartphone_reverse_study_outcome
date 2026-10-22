package g42;

import android.content.Context;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface f {
    void a(g r1);

    boolean b(HighlightItem r1);

    String c(HighlightItem r1);

    void d(g r1);

    void e(c r1);

    PinType f();

    e g(Context r1);

    void h(com.bytedance.android.livesdk.interactivity.api.message.model.a r1);

    boolean i(h<?> r1, HighlightItem r2);

    Observable<j> j(h<?> r1);

    Integer k();

    String l(com.bytedance.android.livesdk.interactivity.api.message.model.a r1);

    Long m(HighlightItem r1);

    Observable<k> n(l<?> r1);

    e o(Context r1);

    void onDestroy();

    void p(HighlightItem r1);

    com.bytedance.android.livesdk.wrds.syncdata.highlight.b q(HighlightItem r1);
}
