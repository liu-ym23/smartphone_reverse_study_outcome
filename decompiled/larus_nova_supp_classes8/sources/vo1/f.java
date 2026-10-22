package vo1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.CommonIconModel$loadHybridComponent$1;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements i {
    public HybridCard a;
    public final Map<String, HybridCard> b;

    public static final class a {
    }

    public static final class b extends b7.a {
        public final /* synthetic */ IBaseBrowserService.PageErrorListener a;
        public final /* synthetic */ IBaseBrowserService.PageFinishedListener b;
        public final /* synthetic */ String c;

        public final void onLoadSuccess(View r3) {
            super.onLoadSuccess(r3);
            IBaseBrowserService.PageFinishedListener r0 = this.b;
            if (r0 == null) goto L8;
            if (r3 == null) goto L7;
            r0.onPageFinished((WebView) r3, this.c);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.webkit.WebView");
        }

        public b(IBaseBrowserService.PageErrorListener r1, IBaseBrowserService.PageFinishedListener r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onLoadFail(View r3, String r4, String r5) {
            super.onLoadFail(r3, r4, r5);
            if (r3 == null) goto L13;
            IBaseBrowserService.PageErrorListener r0 = this.a;
            if (r0 == null) goto L14;
            WebView r6 = (WebView) r3;
            if (r4 != null) goto L9;
            r4 = "";
        L9:
            if (r5 != null) goto L11;
            r5 = "";
        L11:
            r0.onReceiveError(r6, r4, r5);
            return;
        L14:
            return;
        }
    }

    static {
    }

    @Override // vo1.i
    public final void b(String r1, CommonIconModel$loadHybridComponent$1.a r2) {
        Intrinsics.checkNotNullParameter(r1, "url");
    }

    @Override // vo1.i
    public final boolean e() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // vo1.i
    public final View g() {
        HybridCard r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHybridView();
    }

    @Override // vo1.i
    public final IHybridComponent.HybridType hybridType() {
        HybridCard r0 = this.a;
        if (r0 == null) goto L7;
        IHybridComponent.HybridType r1 = r0.hybridType();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return IHybridComponent.HybridType.H5;
    }

    @Override // vo1.i
    public final void release() {
        HybridCard r0 = this.a;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L7:
        if ((r1 instanceof Activity) == false) goto L24;
        HybridCard r2 = this.a;
        if (r2 == null) goto L11;
        Context r3 = r2.getContext();
    L13:
        if ((r3 instanceof Activity) == true) goto L15;
        r3 = null;
    L15:
        Activity r4 = (Activity) r3;
        if (r4 != null) goto L18;
        return;
    L18:
        if (r4.isFinishing() != true) goto L26;
        HybridCard r5 = this.a;
        if (r5 == null) goto L22;
        r5.release();
    L22:
        this.a = null;
        ((LinkedHashMap) this.b).clear();
        return;
    L26:
        return;
    L11:
        r3 = null;
        goto L13
    L24:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public f() {
        this.b = new LinkedHashMap();
    }

    @Override // vo1.i
    public final View c() {
        return this.a;
    }

    @Override // vo1.i
    public final void loadUrl(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        HybridCard r0 = this.a;
        if (r0 == null) goto L6;
        Uri r4 = x6.a.b(r3);
        int r1 = HybridCard.i;
        r0.a(r4, null);
        return;
    }

    @Override // vo1.i
    public final void a(String r1, Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r1, "url");
        loadUrl(r1);
    }

    @Override // vo1.i
    public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r3, "provider");
        HybridCard r0 = this.a;
        if (r0 == null) goto L6;
        r0.registerMethod(r2, r3);
        return;
    }

    @Override // vo1.i
    public final <T> void sendJsEvent(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "params");
        HybridCard r0 = this.a;
        if (r0 == null) goto L6;
        r0.sendJsEvent(r2, r3);
        return;
    }

    @Override // vo1.i
    public final void h(String r1, Map r2, CommonIconModel$loadHybridComponent$1.a r3) {
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r1, "url");
        loadUrl(r1);
    }

    @Override // vo1.i
    public final void f(Activity r6, String r7, LynxThreadStrategy r8, d0 r9) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r8, "threadStrategy");
        HybridCard r10 = (HybridCard) ((LinkedHashMap) this.b).get("card_lynx");
        if (r10 != null) goto L5;
        IBaseBrowserService r11 = k.n(IBaseBrowserService.class);
        Uri r3 = x6.a.d(r7);
        r3.buildUpon().appendQueryParameter("lynx_thread", "0");
        Unit r4 = Unit.INSTANCE;
        r10 = r11.getHybridCard(r6, r3, new g(r9, r7));
        this.b.put("card_lynx", r10);
    L5:
        this.a = r10;
        Uri r12 = x6.a.d(r7);
        r12.buildUpon().appendQueryParameter("lynx_thread", "0");
        this.a = k.n(IBaseBrowserService.class).getHybridCard(r6, r12, new h(r9, r7));
    }

    @Override // vo1.i
    public final void d(Activity r4, String r5, IBaseBrowserService.PageFinishedListener r6, IBaseBrowserService.PageErrorListener r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r8, "sourceSpm");
        HybridCard r9 = (HybridCard) ((LinkedHashMap) this.b).get("card_h5");
        if (r9 != null) goto L5;
        r9 = k.n(IBaseBrowserService.class).getHybridCard(r4, x6.a.b(r5), new b(r7, r6, r5));
        this.b.put("card_h5", r9);
        Unit r10 = Unit.INSTANCE;
    L5:
        this.a = r9;
    }
}
