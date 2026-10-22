package com.bytedance.android.livesdk.gift.format;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.profit.format.voicechat.fragment.FormatVoiceChatFragment$onViewCreated$;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.i;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.k;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/format/GiftPlayerView;", "Landroid/widget/FrameLayout;", "Ltr/d;", "Landroid/view/View;", "getView", "Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/AssetsService;", "h", "Lkotlin/Lazy;", "getAssetsManager", "()Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/AssetsService;", "assetsManager", "Ljy0/a;", "i", "getLogger", "()Ljy0/a;", "logger", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPlayerView extends FrameLayout implements tr.d {
    public static final /* synthetic */ int k = 0;
    public k a;
    public tr.c b;
    public final BehaviorSubject<tr.a> c;
    public final ArrayDeque<tr.a> d;
    public final ArrayList<tr.a> e;
    public final CompositeDisposable f;
    public boolean g;
    public final Lazy h;
    public final Lazy i;
    public final b j;

    public final class a implements IPlayerActionListener {
        public final /* synthetic */ GiftPlayerView a;

        public final void onFileLoaded(int r1, int r2) {
        }

        public final /* synthetic */ void onReportPlayMetrics(Map r1) {
            IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
        }

        public final void updateTextEffectPosition(float r1, float r2, float r3, float r4) {
        }

        public final void onEnd() {
            GiftPlayerView.c(this.a);
        }

        public final void onFirstFrame() {
            GiftPlayerView r0 = this.a;
            int r1 = GiftPlayerView.k;
            r0.e("on first frame");
            tr.a r2 = (tr.a) r0.c.getValue();
            if (r2 == null) goto L8;
            tr.c r3 = r0.b;
            if (r3 == null) goto L9;
            r3.c(r2);
            return;
        L9:
            return;
        }

        public final void onStart() {
            GiftPlayerView r0 = this.a;
            int r1 = GiftPlayerView.k;
            r0.e("on play start");
            tr.a r2 = (tr.a) r0.c.getValue();
            if (r2 == null) goto L12;
            k r3 = r0.a;
            if (r3 == null) goto L7;
            long r4 = r3.getDuration();
        L8:
            r2.e = r4;
            tr.c r5 = r0.b;
            if (r5 == null) goto L13;
            r5.b(r2);
            return;
        L13:
            return;
        L7:
            r4 = 0;
            goto L8
        }

        public final void onStop() {
            GiftPlayerView.c(this.a);
        }

        public a(GiftPlayerView r1) {
            this.a = r1;
        }
    }

    public static final class b implements IAssetsManager.b {
        public final /* synthetic */ GiftPlayerView a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
        }

        public b(GiftPlayerView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r5) {
            Intrinsics.checkNotNullParameter(r5, "assetsModels");
            Iterator<tr.a> r6 = this.a.e.iterator();
        L4:
            if (r6.hasNext() == false) goto L8;
            tr.a r0 = r6.next();
            if (GiftPlayerView.b(this.a).G1(r0.d) == null) goto L4;
            this.a.d.addLast(r0);
            r6.remove();
            goto L4
        L8:
            GiftPlayerView r7 = this.a;
            if (r7.g == false) goto L11;
            return;
        L11:
            if ((!r7.d.isEmpty()) == false) goto L20;
            GiftPlayerView r8 = this.a;
            r8.c.onNext(r8.d.removeFirst());
            return;
        }
    }

    public GiftPlayerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftPlayerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final AssetsService getAssetsManager() {
        return (AssetsService) this.h.getValue();
    }

    private final jy0.a getLogger() {
        return (jy0.a) this.i.getValue();
    }

    public View getView() {
        return this;
    }

    public final void release() {
        this.f.dispose();
        k r0 = this.a;
        if (r0 == null) goto L5;
        r0.b = null;
    L5:
        if (r0 == null) goto L7;
        r0.detachAlphaView(this);
    L7:
        k r1 = this.a;
        if (r1 == null) goto L10;
        r1.release();
    L10:
        this.a = null;
        getAssetsManager().l0(this.j);
    }

    public static final /* synthetic */ AssetsService b(GiftPlayerView r0) {
        return r0.getAssetsManager();
    }

    public static final void c(GiftPlayerView r2) {
        r2.getClass();
        r2.e("on play finished, is queue empty: " + r2.d.isEmpty());
        r2.g = false;
        tr.a r0 = (tr.a) r2.c.getValue();
        if (r0 == null) goto L8;
        tr.c r1 = r2.b;
        if (r1 == null) goto L8;
        r1.a(r0);
    L8:
        if ((!r2.d.isEmpty()) == false) goto L11;
        r2.c.onNext(r2.d.removeFirst());
        return;
    }

    public final void a(h1 r9) {
        Intrinsics.checkNotNullParameter(r9, "gift");
        long r2 = r9.getId();
        String r4 = r9.getName();
        py.k r1 = r9.getImage();
        if (r1 == null) goto L8;
        List r3 = r1.getUrls();
        if (r3 == null) goto L8;
        String r5 = (String) CollectionsKt.firstOrNull(r3);
        if (r5 == null) goto L8;
    L9:
        tr.a r0 = new tr.a(r2, r4, r5, r9.getPrimaryEffectId());
        Intrinsics.checkNotNullParameter(r9, "$this$isMp4Gift");
        if (r9.getType() != 2) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == true) goto L19;
        e("not mp4 gift, stop play");
        tr.c r11 = this.b;
        if (r11 == null) goto L26;
        r11.a(r0);
        return;
    L26:
        return;
    L19:
        if (getAssetsManager().G1(r0.d) != null) goto L22;
        e("assets manager is not ready");
        this.e.add(r0);
        getAssetsManager().d4(2, false, r0.d, "FormatGift");
        return;
    L22:
        this.d.addLast(r0);
        if (this.g == true) goto L27;
        this.c.onNext(this.d.removeFirst());
        return;
    L27:
        return;
    L12:
        r10 = false;
    L8:
        r5 = BuildConfig.FLAVOR;
        goto L9
    }

    public final void e(String r3) {
        getLogger().k("GiftPlayerView", r3);
    }

    public final void f(FormatVoiceChatFragment$onViewCreated$.inlined.apply.lambda.1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    public static final void d(GiftPlayerView r3, tr.a r4) {
        r3.g = true;
        r3.e("on start play");
        String r0 = r3.getAssetsManager().H0(r4.d);
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        com.bytedance.revenue.platform.api.core.rx.f.a(Single.just(r0).flatMap(new d(r3, r4)).subscribe(new e(r3), new f(r3, r4)), r3.f);
    }

    public GiftPlayerView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        BehaviorSubject<tr.a> r7 = BehaviorSubject.create();
        this.c = r7;
        this.d = new ArrayDeque();
        this.e = new ArrayList();
        a r8 = new a(this);
        CompositeDisposable r9 = new CompositeDisposable();
        this.f = r9;
        this.h = LazyKt.lazy(GiftPlayerView$assetsManager$2.INSTANCE);
        this.i = LazyKt.lazy(GiftPlayerView$logger$2.INSTANCE);
        b r0 = new b(this);
        this.j = r0;
        i r1 = i.a();
        FragmentActivity r2 = getContext();
        if (r2 == null) goto L10;
        k r3 = (k) r1.createTextureViewPlayer(r2);
        this.a = r3;
        Intrinsics.checkNotNullParameter(r8, "listener");
        r3.b = r8;
        k r10 = this.a;
        if (r10 == null) goto L7;
        r10.attachAlphaView(this);
    L7:
        com.bytedance.revenue.platform.api.core.rx.f.a(r7.subscribe(new c(this)), r9);
        getAssetsManager().T(r0);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public /* synthetic */ GiftPlayerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
