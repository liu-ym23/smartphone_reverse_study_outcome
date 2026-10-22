package aa2;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.f0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a extends s42.d, s42.a, fa2.d {
    void A(ITextMessageView r1);

    void D(int r1, com.bytedance.android.livesdk.interactivity.api.entity.f r2);

    w G();

    void N();

    void Q(com.bytedance.android.live.base.model.message.t r1);

    boolean T();

    void X(f0 r1);

    com.bytedance.android.livesdk.interactivity.api.entity.f Z();

    boolean a();

    void b(com.bytedance.android.live.base.model.message.t r1);

    boolean canLoadMore();

    int d();

    void detachView();

    int r();

    void updateRoom(IRoom r1);

    void w(com.bytedance.android.livesdk.interactivity.publicscreen.pin.d r1);
}
