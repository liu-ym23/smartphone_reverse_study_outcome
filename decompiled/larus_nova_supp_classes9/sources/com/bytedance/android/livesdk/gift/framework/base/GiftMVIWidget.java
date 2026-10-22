package com.bytedance.android.livesdk.gift.framework.base;

import com.bytedance.android.GiftRecyclableWidget;
import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.MVIBindingImpl;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.GiftMVIPanelView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.core.f;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.m;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lb.d;
import lb.g;
import lb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/framework/base/GiftMVIWidget;", "Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/GiftRecyclableWidget;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class GiftMVIWidget<STATE extends MVIState<?>> extends GiftRecyclableWidget {
    public MVIBindingImpl b;
    public Disposable c;

    public static final class a implements d {
        public a() {
        }

        public final GiftMVITraceListener a(com.bytedance.android.anya.b r2, MVIBindingImpl r3) {
            Intrinsics.checkNotNullParameter(r2, "facade");
            Intrinsics.checkNotNullParameter(r3, "binding");
            return new GiftMVITraceListener();
        }
    }

    public void onInit(Object[] r1) {
    }

    public abstract GiftMVIPanelView wq();

    public abstract Class<? extends BaseMVIViewModel<STATE, GiftAction>> xq();

    public void onUnload() {
        this.c.dispose();
        MVIBindingImpl r0 = this.b;
        if (r0 == null) goto L6;
        r0.unbind();
        return;
    }

    public GiftMVIWidget() {
        this.c = Disposables.disposed();
    }

    public void onLoad(Object[] r4) {
        MVIBindingImpl r1 = null;
        if (((Boolean) f.c.getValue(null, f.a[1])).booleanValue() == false) goto L5;
        lb.c r5 = lb.c.b;
        a r0 = new a();
        ((h) r5).a.add(r0);
        this.c = Disposables.fromAction(new g(r5, r0));
    L5:
        j r6 = ((GiftRecyclableWidget) this).a;
        if (r6 == null) goto L8;
        uz1.a r7 = (uz1.a) m.e.d(r6, uz1.a.class);
    L9:
        if (r7 == null) goto L11;
        r1 = r7.c(wq(), xq());
    L11:
        this.b = r1;
        if (r1 == null) goto L15;
        r1.a();
        return;
    L15:
        return;
    L8:
        r7 = null;
        goto L9
    }
}
