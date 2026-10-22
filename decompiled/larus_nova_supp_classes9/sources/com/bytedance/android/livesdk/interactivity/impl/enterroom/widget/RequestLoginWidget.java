package com.bytedance.android.livesdk.interactivity.impl.enterroom.widget;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.ies.sdk.widgets.Widget;
import g50.c;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/impl/enterroom/widget/RequestLoginWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class RequestLoginWidget extends LiveRecyclableWidget {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RequestLoginWidget a;

        public a(RequestLoginWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            IBaseUser r2 = (IBaseUser) r1;
            this.a.wq();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RequestLoginWidget a;

        public b(RequestLoginWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            this.a.wq();
        }
    }

    public RequestLoginWidget() {
        throw null;
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
    }

    public final void wq() {
        if (k.f(c.class) != null) goto L6;
        return;
    L6:
        throw null;
    }

    public final void onLoad(Object[] r3) {
        e r4 = k.n(IMiddlewareUserService.class).user();
        if (r4.isLogin() == true) goto L5;
        l.a r0 = new l.a();
        r0.c = -1;
        r0.d = "coin_task";
        l r1 = new l(r0);
        r4.login(((Widget) this).context, r1).subscribe(new a(this), new b(this));
        return;
    L5:
        wq();
    }
}
