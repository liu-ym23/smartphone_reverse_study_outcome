package com.bytedance.android.livesdk.feedback;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.jsbridge.base.CloseFeedbackPageResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.s50;
import com.bytedance.android.livesdkapi.feedback.IFeedbackCallback;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackView;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.f;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import w20.e8;
import w20.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements ILiveFeedbackView {
    public final Disposable a;
    public final e b;
    public final HybridCard c;
    public final IFeedbackCallback d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.a$a, reason: collision with other inner class name */
    public static final class C0313a extends b7.a {
        public final /* synthetic */ a a;

        public C0313a(a r1) {
            this.a = r1;
        }

        public final void onLoadSuccess(View r2) {
            super.onLoadSuccess(r2);
            this.a.d.onLoadSucceed();
            ALogger.d("LiveFeedbackLynxView", "onLoadSuccess");
        }

        public final void onLoadStart(View r1, boolean r2) {
            super.onLoadStart(r1, r2);
            ALogger.d("LiveFeedbackLynxView", "onLoadStart");
        }
    }

    public static final class b implements IHybridComponent.a {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.a$b$a, reason: collision with other inner class name */
        public static final class C0314a implements f.b {
            public final /* synthetic */ b a;

            public C0314a(b r1) {
                this.a = r1;
            }

            public final f<Object, Object> a() {
                return this.a.a.b;
            }
        }

        public b(a r1) {
            this.a = r1;
        }

        public final void onJSBridgeCreated(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            r3.registerMethod(((w) this.a.b).a, new C0314a(this));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (TextUtils.equals(((SubscriberJsEvent) r2).component1(), "community_page_change") == false) goto L6;
            this.a.d.onUIUpdate();
            return;
        }
    }

    public static final class d {
    }

    public static final class e extends w<e8, CloseFeedbackPageResultModel> {
        public final /* synthetic */ a b;

        public e(a r1) {
            this.b = r1;
        }

        public final void invoke(Object r3, CallContext r4) {
            e8 r5 = (e8) r3;
            Intrinsics.checkNotNullParameter(r5, "params");
            Intrinsics.checkNotNullParameter(r4, "context");
            Integer r6 = r5.a();
            if (r6 == null) goto L5;
            int r7 = r6.intValue();
        L7:
            if (r7 != (-1)) goto L9;
            this.b.d.onSubmit(false, r5.b());
            return;
        L9:
            if (r7 == 1) goto L11;
            this.b.d.onClose();
            return;
        L11:
            this.b.d.onSubmit(true, r5.b());
            return;
        L5:
            r7 = 0;
            goto L7
        }
    }

    static {
    }

    public final void destroy() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        HybridCard r1 = this.c;
        if (r1 == null) goto L9;
        r1.release();
        return;
    }

    public final View getView() {
        return this.c;
    }

    public final void loadView(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        HybridCard r0 = this.c;
        if (r0 == null) goto L6;
        r0.load(null, r3);
        return;
    }

    public final void updateLayputParams(int r3, int r4) {
        HybridCard r5 = this.c;
        if ((r5 instanceof AnnieCard) == true) goto L5;
        r5 = null;
    L5:
        AnnieCard r6 = (AnnieCard) r5;
        if (r6 == null) goto L15;
        View r7 = r6.getHybridView();
        if ((r7 instanceof WebView) == true) goto L10;
        r7 = null;
    L10:
        WebView r8 = (WebView) r7;
        if (r8 == null) goto L13;
        r8.getSettings().setCacheMode(2);
    L13:
        a7.a.a(r6, null, null, 3);
        return;
    }

    public a(Context r3, IFeedbackCallback r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.d = r4;
        Disposable r0 = null;
        if (r5 != 1) goto L5;
        Uri r6 = com.bytedance.android.livesdk.feedback.b.a(s50.a.getValue().a(), null);
    L18:
        this.b = new e(this);
        if (r6 == null) goto L21;
        HybridCard r7 = k.n(IBrowserService.class).getHybridCard(r3, r6, new C0313a(this));
    L22:
        this.c = r7;
        if (r7 == null) goto L25;
        r7.setJSBridgeListener(new b(this));
    L25:
        Disposable r8 = this.a;
        if (r8 == null) goto L28;
        r8.dispose();
    L28:
        IBrowserService r9 = k.f(IBrowserService.class);
        if (r9 == null) goto L35;
        Observable r10 = r9.registerJsEventSubscriber("community_page_change");
        if (r10 == null) goto L35;
        Observable r11 = r10.observeOn(AndroidSchedulers.mainThread());
        if (r11 == null) goto L35;
        r0 = r11.subscribe(new c(this));
    L35:
        this.a = r0;
        return;
    L21:
        r7 = null;
        goto L22
    L5:
        if (r5 != 2) goto L7;
        s50 r12 = s50.a;
        r6 = com.bytedance.android.livesdk.feedback.b.a(r12.getValue().e(), r12.getValue().f());
        goto L18
    L7:
        if (r5 != 3) goto L9;
        s50 r13 = s50.a;
        r6 = com.bytedance.android.livesdk.feedback.b.a(r13.getValue().b(), r13.getValue().d());
        goto L18
    L9:
        if (r5 != 4) goto L11;
        r6 = com.bytedance.android.livesdk.feedback.b.a(s50.a.getValue().g(), null);
        goto L18
    L11:
        if (r5 == 5) goto L13;
        r6 = null;
        goto L18
    L13:
        r6 = com.bytedance.android.livesdk.feedback.b.a(s50.a.getValue().a(), null);
        goto L18
    }
}
