package vo1;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.p0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.CommonIconModel$loadHybridComponent$1;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.utils.c0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.TemplateData;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements i {
    public HybridCard a;
    public AnnieXLynxView b;
    public m16.b c;
    public ra.a d;
    public com.bytedance.android.live.lynx.api.a e;

    /* JADX INFO: renamed from: vo1.a$a, reason: collision with other inner class name */
    public static final class C0422a extends b7.a {
        public final /* synthetic */ IBaseBrowserService.PageErrorListener a;
        public final /* synthetic */ IBaseBrowserService.PageFinishedListener b;
        public final /* synthetic */ String c;

        public final void onLoadSuccess(View r3) {
            super.onLoadSuccess(r3);
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
            if (r3 == null) goto L9;
            IBaseBrowserService.PageFinishedListener r0 = this.b;     // Catch: Throwable -> L12
            if (r0 == null) goto L8;
            r0.onPageFinished((WebView) r3, this.c);     // Catch: Throwable -> L12
        L8:
            int r4 = c0.a;     // Catch: Throwable -> L12
            Intrinsics.checkNotNullParameter("", "errorMsg");     // Catch: Throwable -> L12
            v.a();     // Catch: Throwable -> L12
        L10:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
            return;
        L9:
            SafetyGuard.a(null, null, "webview is null " + this.c.toString());     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        public C0422a(IBaseBrowserService.PageErrorListener r1, IBaseBrowserService.PageFinishedListener r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onContainerError(View r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorMessage");
            super.onContainerError(r2, r3, r4);
            int r5 = c0.a;
            Intrinsics.checkNotNullParameter(r4, "errorMsg");
            v.a();
        }

        public final void onLoadFail(View r5, String r6, String r7) {
            super.onLoadFail(r5, r6, r7);
            if (r5 == null) goto L14;
            IBaseBrowserService.PageErrorListener r1 = this.a;
            if (r1 == null) goto L14;
            WebView r8 = (WebView) r5;
            if (r6 != null) goto L9;
            String r2 = "";
        L10:
            if (r7 != null) goto L12;
            String r3 = "";
        L13:
            r1.onReceiveError(r8, r2, r3);
            goto L14
        L12:
            r3 = r7;
            goto L13
        L9:
            r2 = r6;
        L14:
            int r9 = c0.a;
            StringBuilder r10 = new StringBuilder("url: ");
            if (r6 != null) goto L17;
            r6 = "";
        L17:
            r10.append(r6);
            r10.append("\nreason: ");
            if (r7 != null) goto L20;
            r7 = "";
        L20:
            r10.append(r7);
            Intrinsics.checkNotNullParameter(r10.toString(), "errorMsg");
            v.a();
        }
    }

    public a() {
    }

    public final boolean j() {
        if (((Boolean) p0.a.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.b == null) goto L7;
        return true;
    }

    @Override // vo1.i
    public final View c() {
        if (j() == false) goto L6;
        return this.b;
    L6:
        return this.a;
    }

    @Override // vo1.i
    public final boolean e() {
        if (j() == false) goto L6;
        return true;
    L6:
        if (this.a != null) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // vo1.i
    public final View g() {
        if (j() == true) goto L10;
        HybridCard r0 = this.a;
        if (r0 != null) goto L11;
        return null;
    L11:
        return r0.getHybridView();
    L10:
        return this.b;
    }

    @Override // vo1.i
    public final IHybridComponent.HybridType hybridType() {
        if (j() == true) goto L11;
        HybridCard r0 = this.a;
        if (r0 == null) goto L10;
        IHybridComponent.HybridType r1 = r0.hybridType();
        if (r1 == null) goto L10;
        return r1;
    L10:
        return IHybridComponent.HybridType.H5;
    L11:
        return IHybridComponent.HybridType.LYNX;
    }

    @Override // vo1.i
    public final void release() {
        if (j() == false) goto L7;
        AnnieXLynxView r0 = this.b;
        if (r0 == null) goto L11;
        r0.destroy();
        return;
    L11:
        return;
    L7:
        HybridCard r1 = this.a;
        if (r1 == null) goto L13;
        r1.release();
        return;
    }

    @Override // vo1.i
    public final void loadUrl(String r4) {
        Intrinsics.checkNotNullParameter(r4, "url");
        HybridCard r0 = this.a;
        if (r0 == null) goto L6;
        a7.a.a(r0, r4, null, 2);
        return;
    }

    public static Uri k(Uri r3, String r4) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        String r5 = UriProtector.getQueryParameter(UriProtector.parse(r4), "enable_canvas");     // Catch: Throwable -> L11
        if (r5 != null) goto L6;
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        return r3;
    L6:
        if (Intrinsics.areEqual(r5, "1") == false) goto L9;
        return r3.buildUpon().appendQueryParameter("enable_canvas", "1").build();
    L11:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // vo1.i
    public final void a(String r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (j() == true) goto L5;
        HybridCard r0 = this.a;
        if (r0 == null) goto L16;
        r0.load(r5, r6);
        return;
    L16:
        return;
    L5:
        if (this.c != null) goto L7;
        this.c = new m16.b();
    L7:
        Uri r1 = k(x6.a.d(r5), r5);
        r1.buildUpon().appendQueryParameter("lynx_thread", "0");
        ra.a r7 = i(r6, r1, r5);
        AnnieXLynxView r8 = this.b;
        if (r8 == null) goto L14;
        r8.A(r7, this.c, null);
        return;
    }

    @Override // vo1.i
    public final void b(String r6, CommonIconModel$loadHybridComponent$1.a r7) {
        Intrinsics.checkNotNullParameter(r6, "url");
        if (j() == true) goto L5;
        HybridCard r8 = this.a;
        if (r8 == null) goto L16;
        a7.a.a(r8, r6, null, 2);
        return;
    L16:
        return;
    L5:
        if (this.c != null) goto L7;
        this.c = new m16.b();
    L7:
        Uri r0 = k(x6.a.d(r6), r6);
        r0.buildUpon().appendQueryParameter("lynx_thread", "0");
        ra.a r1 = i(null, r0, r6);
        AnnieXLynxView r2 = this.b;
        if (r2 == null) goto L14;
        r2.A(r1, this.c, new c(r7, r6));
        return;
    }

    @Override // vo1.i
    public final void registerMethod(String r3, com.bytedance.ies.web.jsbridge2.f.b r4) {
        Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r4, "provider");
        if (j() == false) goto L7;
        com.bytedance.android.live.lynx.api.a r0 = this.e;
        if (r0 == null) goto L11;
        int r1 = com.bytedance.android.live.lynx.api.a.d;
        r0.k(r3, r4, null);
        return;
    L11:
        return;
    L7:
        HybridCard r2 = this.a;
        if (r2 == null) goto L13;
        r2.registerMethod(r3, r4);
        return;
    }

    @Override // vo1.i
    public final <T> void sendJsEvent(String r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "params");
        if (j() == false) goto L7;
        AnnieXLynxView r0 = this.b;
        if (r0 == null) goto L11;
        int r1 = AnnieXLynxView.B;
        r0.O(r3, r4, true);
        return;
    L11:
        return;
    L7:
        HybridCard r2 = this.a;
        if (r2 == null) goto L13;
        r2.sendJsEvent(r3, r4);
        return;
    }

    @Override // vo1.i
    public final void h(String r5, Map r6, CommonIconModel$loadHybridComponent$1.a r7) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (j() == true) goto L5;
        HybridCard r8 = this.a;
        if (r8 == null) goto L16;
        r8.load(r5, r6);
        return;
    L16:
        return;
    L5:
        if (this.c != null) goto L7;
        this.c = new m16.b();
    L7:
        Uri r0 = k(x6.a.d(r5), r5);
        r0.buildUpon().appendQueryParameter("lynx_thread", "0");
        ra.a r9 = i(r6, r0, r5);
        AnnieXLynxView r1 = this.b;
        if (r1 == null) goto L14;
        r1.A(r9, this.c, new d(r7, r5));
        return;
    }

    public final ra.a i(Map<String, ? extends Object> r28, Uri r29, String r30) {
        ra.a r1 = this.d;
        if (r1 == null) goto L5;
        return r1;
    L5:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("location", r30);
        ra.a r3 = com.bytedance.android.anniex.api.d.g(new com.bytedance.android.anniex.api.d("webcast", r2, new ra.b(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, false, false, false, false, null, false, 0.0f, 16777215), 8), r29, TemplateData.fromMap(r28), null, 24);
        this.d = r3;
        return r3;
    }

    @Override // vo1.i
    public final void f(Activity r4, String r5, LynxThreadStrategy r6, d0 r7) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "threadStrategy");
        Uri r8 = k(x6.a.d(r5), r5);
        r8.buildUpon().appendQueryParameter("lynx_thread", "0");
        this.a = k.n(IBaseBrowserService.class).getHybridCard(r4, r8, new b(r7, r5));
    }

    @Override // vo1.i
    public final void d(Activity r3, String r4, IBaseBrowserService.PageFinishedListener r5, IBaseBrowserService.PageErrorListener r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r7, "sourceSpm");
        this.a = k.n(IBaseBrowserService.class).getHybridCard(r3, x6.a.b(r4), new C0422a(r6, r5, r4));
    }
}
