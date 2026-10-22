package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.link.model.bridge.q;
import com.bytedance.android.livesdk.link.model.bridge.u0;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.d1;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.k5;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedMultiBridgePresenter {
    public boolean a;
    public e b;
    public boolean c;
    public final CompositeDisposable d;
    public final a e;
    public final z21.a f;

    public static final class a<T> implements Observer {
        public final /* synthetic */ FeedMultiBridgePresenter a;

        public a(FeedMultiBridgePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Unit r4 = (Unit) r3;
            FeedMultiBridgePresenter r5 = this.a;
            mx0.a r0 = r5.f.c;
            if (r5.a == false) goto L7;
            if (r0 == null) goto L8;
            r5.b(r0);
            return;
        L8:
            return;
        }
    }

    public FeedMultiBridgePresenter(z21.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.f = r2;
        this.d = new CompositeDisposable();
        this.e = new a(this);
    }

    public final void b(mx0.a r4) {
        if (this.c == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r0 = r4.a(com.bytedance.android.live.revenue.common.message.b.c);
        final FeedMultiBridgePresenter$doMessageListen$1 r1 = new FeedMultiBridgePresenter$doMessageListen$1(this);
        Disposable r2 = r0.subscribe(new b(r1));
        if (r2 == null) goto L8;
        RxUtilKt.c(r2, this.d);
    L8:
        Observable r3 = r4.a(com.bytedance.android.live.revenue.common.message.b.j);
        final FeedMultiBridgePresenter$doMessageListen$2 r5 = new FeedMultiBridgePresenter$doMessageListen$2(this);
        Disposable r6 = r3.subscribe(new b(r5));
        if (r6 == null) goto L11;
        RxUtilKt.c(r6, this.d);
    L11:
        Observable r7 = r4.a(com.bytedance.android.live.revenue.common.message.b.d);
        final FeedMultiBridgePresenter$doMessageListen$3 r8 = new FeedMultiBridgePresenter$doMessageListen$3(this);
        Disposable r9 = r7.subscribe(new b(r8));
        if (r9 == null) goto L14;
        RxUtilKt.c(r9, this.d);
    L14:
        this.c = true;
    }

    public static final void a(FeedMultiBridgePresenter r2, yh6.c r3) {
        r2.getClass();
        if ((r3 instanceof z0) == false) goto L10;
        k5 r4 = ((z0) r3).castTo(k5.class);
        if (((int) r4.getType2()) != 202) goto L22;
        e r5 = r2.b;
        if (r5 == null) goto L23;
        r5.c(r4);
        return;
    L23:
        return;
    L22:
        return;
    L10:
        if ((r3 instanceof q) == false) goto L17;
        d1 r6 = ((vh7.c) r3).castTo(d1.class);
        if (TextUtils.isEmpty(r6.getBattleEffectInfo()) == true) goto L25;
        e r7 = r2.b;
        if (r7 == null) goto L26;
        r7.a(r6);
        return;
    L26:
        return;
    L25:
        return;
    L17:
        if ((r3 instanceof u0) == false) goto L28;
        g5 r8 = ((vh7.c) r3).castTo(g5.class);
        e r9 = r2.b;
        if (r9 == null) goto L29;
        r9.b(r8);
        return;
    L29:
        return;
    }
}
