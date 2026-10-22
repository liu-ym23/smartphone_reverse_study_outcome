package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.View;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowBanner;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.flow.chat.page.flow.plugin.FlowRelationshipBanner;
import com.ss.android.lark.framework.larkwidget.Widget;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.view.SizeDetectFrameLayout;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\r\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010%\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\nH\u0016J\u001c\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\n2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+H\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\nH\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0004H\u0016J\u0010\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00103\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0017H\u0016J\u0010\u00104\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0017H\u0016J\b\u00105\u001a\u00020\u001dH\u0016J\u0010\u00106\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\bH\u0016J\u001e\u00107\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020:09\u0012\u0004\u0012\u00020:\u0018\u000108H\u0016J\u0011\u0010;\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010<\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0004H\u0096\u0001R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010\u0019¨\u0006?"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/banner/BaseBannerComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/banner/IBannerComponent;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowBanner$IBannerComponentCallbacks;", "<init>", "()V", "hasView", BuildConfig.FLAVOR, "getLayoutResId", BuildConfig.FLAVOR, "()Ljava/lang/Integer;", "lastBannerHeight", "mBannerRoot", "Lcom/ss/android/lark/view/SizeDetectFrameLayout;", "getMBannerRoot", "()Lcom/ss/android/lark/view/SizeDetectFrameLayout;", "setMBannerRoot", "(Lcom/ss/android/lark/view/SizeDetectFrameLayout;)V", "mBannerController", "Lcom/ss/android/lark/chat/chatwindow/biz/component/banner/BannerController;", "mBannerVisibilityListeners", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/chatwindow/biz/component/banner/IBannerComponent$IBannerVisibilityListener;", "getMBannerVisibilityListeners", "()Ljava/util/List;", "mBannerVisibilityListeners$delegate", "Lkotlin/Lazy;", "onCreate", BuildConfig.FLAVOR, "initBanner", "getRootView", "Landroid/view/View;", "showBanner", IPortraitService.TYPE, Keys.API_RETURN_KEY_DATA, "Lcom/ss/android/lark/biz/im/extension/chat_window/banner/IBannerData;", "view", "hideBanner", "bannerType", "registerBanner", "key", "banner", "Lcom/ss/android/lark/biz/im/extension/chat_window/banner/IBanner;", "unregisterBanner", "registerBannerCallback", "callback", "addBannerSizeChangeListener", "listener", "Lcom/ss/android/lark/widget/listener/OnSizeChangeListener;", "removeBannerSizeChangeListener", "addBannerVisibilityListener", "removeBannerVisibilityListener", "onDestroy", "setBannerVisibility", "provideWidgetExport", BuildConfig.FLAVOR, "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "registerCallback", "unregisterCallback", "callbacks", "getCallbacks", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseBannerComponent extends ChatBaseComponent implements IBannerComponent, oxa.c<ChatWindowBanner.a> {
    public static final /* synthetic */ int p = 0;
    public final /* synthetic */ oxa.a<ChatWindowBanner.a> l;
    public int m;

    @BindView(9642)
    public SizeDetectFrameLayout mBannerRoot;
    public com.ss.android.lark.chat.chatwindow.biz.component.banner.a n;
    public final Lazy o;

    public static final class a<T> implements Observer {
        public final /* synthetic */ BaseBannerComponent a;

        public a(BaseBannerComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Intrinsics.checkNotNullParameter((i7b.a) r4, "it");
            PerfLog.start("banner_init_with_data", BuildConfig.FLAVOR);
            Iterator r1 = this.a.l.a.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((ChatWindowBanner.a) r1.next()).c();
            goto L4
        L6:
            PerfLog.end("banner_init_with_data", BuildConfig.FLAVOR);
        }
    }

    public final boolean v0() {
        return true;
    }

    public final SizeDetectFrameLayout E0() {
        SizeDetectFrameLayout r0 = this.mBannerRoot;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mBannerRoot");
        return null;
    }

    public final List<IBannerComponent.a> F0() {
        return (List) this.o.getValue();
    }

    public final void VH() {
        com.ss.android.lark.chat.chatwindow.biz.component.banner.a r0 = this.n;
        if (r0 == null) goto L9;
        wya.b r1 = (wya.b) ((LinkedHashMap) r0.c).get(2048);
        if (r1 == null) goto L7;
        r1.destroy();
    L7:
        r0.c.remove(2048);
        return;
    }

    public Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(TuplesKt.to(IBannerComponent.class, this));
    }

    public BaseBannerComponent() {
        this.l = new oxa.a();
        this.o = LazyKt.lazy(BaseBannerComponent$mBannerVisibilityListeners$2.INSTANCE);
    }

    public final void U20() {
        if (E0().isShown() == false) goto L7;
        com.ss.android.lark.chat.chatwindow.biz.component.banner.a r0 = this.n;
        if (r0 == null) goto L9;
        r0.a(2048);
        return;
    L9:
        return;
    L7:
        E0().getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
    }

    public final View getRootView() {
        return E0();
    }

    public final void onCreate() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onCreate();
        PerfLog.start("banner_init", BuildConfig.FLAVOR);
        View r2 = ((Widget) this).e;
        if (r2 == null) goto L7;
        ButterKnife.bind(this, r2);
        this.n = new com.ss.android.lark.chat.chatwindow.biz.component.banner.a(E0(), new f(this));
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(D0(), this, new a(this));
        PerfLog.end("banner_init", BuildConfig.FLAVOR);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void onDestroy() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onDestroy();
        com.ss.android.lark.chat.chatwindow.biz.component.banner.a r0 = this.n;
        if (r0 == null) goto L9;
        Iterator r1 = ((LinkedHashMap) r0.c).entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((wya.b) ((Map.Entry) r1.next()).getValue()).destroy();
        goto L6
    L8:
        ((LinkedHashMap) r0.c).clear();
    L9:
        this.n = null;
        F0().clear();
    }

    public final Integer r0() {
        return 2131559312;
    }

    public final void AI(wya.b r3) {
        Intrinsics.checkNotNullParameter(r3, "banner");
        com.ss.android.lark.chat.chatwindow.biz.component.banner.a r0 = this.n;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "bannerView");
        r3.a(new c(r0, r3));
        r0.c.put(Integer.valueOf(r3.getType()), r3);
        return;
    }

    public final void hO(boolean r2) {
        SizeDetectFrameLayout r0 = E0();
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent
    public final void jx(IBannerComponent.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        F0().add(r2);
    }

    public final void lq(FlowRelationshipBanner.d r3) {
        if (E0().isShown() == false) goto L7;
        com.ss.android.lark.chat.chatwindow.biz.component.banner.a r0 = this.n;
        if (r0 == null) goto L9;
        r0.b(2048, r3);
        return;
    L9:
        return;
    L7:
        E0().getViewTreeObserver().addOnGlobalLayoutListener(new g(this, r3));
    }
}
