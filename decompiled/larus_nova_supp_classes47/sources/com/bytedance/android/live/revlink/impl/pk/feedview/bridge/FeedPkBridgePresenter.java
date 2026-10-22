package com.bytedance.android.live.revlink.impl.pk.feedview.bridge;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.link.model.b8;
import com.bytedance.android.livesdk.link.model.bridge.f2;
import com.bytedance.android.livesdk.link.model.bridge.q;
import com.bytedance.android.livesdk.link.model.bridge.u0;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.d1;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.k5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedPkBridgePresenter {
    public boolean a;
    public d b;
    public mx0.a c;
    public final CompositeDisposable d;
    public boolean e;
    public IRoom f;
    public int g;
    public boolean h;
    public Disposable i;
    public boolean j;
    public Map<String, ? extends b8> k;
    public final MutableLiveData<String> l;
    public final MutableLiveData<String> m;
    public Disposable n;

    public FeedPkBridgePresenter() {
        this.d = new CompositeDisposable();
        this.h = true;
        this.j = true;
        this.l = new MutableLiveData();
        this.m = new MutableLiveData();
    }

    public final void b(mx0.a r4) {
        if (this.e == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r0 = r4.a(com.bytedance.android.live.revenue.common.message.b.c);
        final FeedPkBridgePresenter$doMessageListen$1 r1 = new FeedPkBridgePresenter$doMessageListen$1(this);
        Disposable r2 = r0.subscribe(new a(r1));
        if (r2 == null) goto L8;
        RxUtilKt.c(r2, this.d);
    L8:
        Observable r3 = r4.a(com.bytedance.android.live.revenue.common.message.b.d);
        final FeedPkBridgePresenter$doMessageListen$2 r5 = new FeedPkBridgePresenter$doMessageListen$2(this);
        Disposable r6 = r3.subscribe(new a(r5));
        if (r6 == null) goto L11;
        RxUtilKt.c(r6, this.d);
    L11:
        Observable r7 = r4.a(com.bytedance.android.live.revenue.common.message.b.j);
        final FeedPkBridgePresenter$doMessageListen$3 r8 = new FeedPkBridgePresenter$doMessageListen$3(this);
        Disposable r9 = r7.subscribe(new a(r8));
        if (r9 == null) goto L14;
        RxUtilKt.c(r9, this.d);
    L14:
        Observable r10 = r4.a(com.bytedance.android.live.revenue.common.message.b.i);
        final FeedPkBridgePresenter$doMessageListen$4 r12 = new FeedPkBridgePresenter$doMessageListen$4(this);
        Disposable r13 = r10.subscribe(new a(r12));
        if (r13 == null) goto L17;
        RxUtilKt.c(r13, this.d);
    L17:
        this.e = true;
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.j = true;
        Disposable r3 = this.i;
        if (r3 == null) goto L5;
        r3.dispose();
    L5:
        Disposable r4 = this.n;
        if (r4 == null) goto L9;
        r4.dispose();
        return;
    }

    public static final void a(FeedPkBridgePresenter r5, yh6.c r6) {
        r5.getClass();
        if ((r6 instanceof z0) == false) goto L10;
        k5 r7 = ((z0) r6).castTo(k5.class);
        if (((int) r7.getType2()) != 202) goto L53;
        d r8 = r5.b;
        if (r8 == null) goto L54;
        r8.c(r7);
        return;
    L54:
        return;
    L53:
        return;
    L10:
        if ((r6 instanceof u0) == false) goto L15;
        g5 r9 = ((vh7.c) r6).castTo(g5.class);
        d r10 = r5.b;
        if (r10 == null) goto L56;
        r10.b(r9);
        return;
    L56:
        return;
    L15:
        if ((r6 instanceof f2) == false) goto L46;
        c8 r12 = ((vh7.c) r6).castTo(c8.class);
        int r0 = r12.getScoreUpdateType();
        r5.g = r0;
        boolean r2 = true;
        if (r5.j == true) goto L23;
        if (r0 != 1) goto L20;
        boolean r1 = true;
    L21:
        if (r1 == true) goto L23;
        r5.c("scoreStatus_" + r5.g);
        goto L23
    L20:
        r1 = false;
    L23:
        IRoom r3 = r5.f;
        if (r3 == null) goto L28;
        if (r3.isLiveTypeAudio() != true) goto L28;
    L29:
        boolean r4 = false;
    L32:
        if (r4 != r5.h) goto L35;
        r2 = false;
    L35:
        r5.h = r4;
        if (r5.j == false) goto L38;
        r5.k = r12.getAnchorInfoMap();
    L38:
        r5.l.setValue(String.valueOf(r12.getLinkStartTime()));
        if (r2 == false) goto L41;
    L42:
        d r13 = r5.b;
        if (r13 == null) goto L59;
        r13.e();
        return;
    L59:
        return;
    L41:
        if (r5.j == true) goto L42;
        return;
    L28:
        if (v41.b.f.a() == false) goto L29;
        r4 = com.bytedance.android.live.revlink.impl.multianchor.profit.c.a(r5.g);
        goto L32
    L46:
        if ((r6 instanceof q) == false) goto L61;
        d1 r14 = ((vh7.c) r6).castTo(d1.class);
        if (TextUtils.isEmpty(r14.getBattleEffectInfo()) == true) goto L62;
        d r15 = r5.b;
        if (r15 == null) goto L63;
        r15.a(r14);
        return;
    L63:
        return;
    L62:
        return;
    }
}
