package com.bytedance.android.live.profit.player;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.profit.util.AssetUtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class EnterEffectProfilePreviewView extends FrameLayout implements uu0.a {
    public final CompositeDisposable a;
    public ITextureViewPlayerController b;
    public final Lazy c;
    public final uu0.b.a d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ EnterEffectProfilePreviewView a;

        public a(EnterEffectProfilePreviewView r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Unit r8 = (Unit) r7;
            ALogger.w("EnterEffectProfilePreview", "loading effect asset: asset_id=" + this.a.getPreviewData().b.getProfilePreviewAssetId());
            AssetUtilsKt.a(EnterEffectProfilePreviewView.d(this.a), this.a.getPreviewData().b.getProfilePreviewAssetId(), 4, WebcastRedirectException.MISS_REDIRECT_RULE, new EnterEffectProfilePreviewView$onPreviewCreate$1$1(this));
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            ALogger.e("EnterEffectProfilePreview", "sync asset list: error=" + ((Throwable) r3));
        }
    }

    private final IAssetsManager getAssetManager() {
        return (IAssetsManager) this.c.getValue();
    }

    @Override // uu0.a
    public final View a() {
        return this;
    }

    @Override // uu0.a
    public final void b() {
        ITextureViewPlayerController r0 = this.b;
        if (r0 == null) goto L5;
        r0.detachAlphaView(this);
    L5:
        ITextureViewPlayerController r1 = this.b;
        if (r1 == null) goto L9;
        r1.release();
        return;
    }

    @Override // uu0.a
    public final void c() {
        ITextureViewPlayerController r0 = com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).giftPlayControllerManager().createTextureViewPlayer(ContextUtil.contextToFragmentActivity(getContext()));
        this.b = r0;
        r0.setEnableCropView(false);
        ALogger.w("EnterEffectProfilePreview", "waiting for asset sync");
        IAssetsManager r1 = getAssetManager();
        Intrinsics.checkNotNullParameter(r1, "$this$ensureSynced");
        if (r1.B7() <= 0) goto L5;
        Single r2 = Single.just(Unit.INSTANCE);
    L6:
        RxUtilKt.c(r2.subscribe(new a(this), b.a), this.a);
        return;
    L5:
        r2 = Single.create(new com.bytedance.android.live.profit.util.a(r1));
        goto L6
    }

    @Override // uu0.a
    public /* bridge */ /* synthetic */ uu0.b getPreviewData() {
        return getPreviewData();
    }

    @Override // uu0.a
    public uu0.b.a getPreviewData() {
        return this.d;
    }

    public static final /* synthetic */ IAssetsManager d(EnterEffectProfilePreviewView r0) {
        return r0.getAssetManager();
    }

    public EnterEffectProfilePreviewView(Context r2, uu0.b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "previewData");
        super(r2);
        this.d = r3;
        this.a = new CompositeDisposable();
        this.c = LazyKt.lazy(EnterEffectProfilePreviewView$assetManager$2.INSTANCE);
    }
}
