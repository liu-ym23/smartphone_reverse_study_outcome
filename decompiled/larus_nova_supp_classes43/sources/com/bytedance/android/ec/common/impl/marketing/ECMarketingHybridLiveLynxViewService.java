package com.bytedance.android.ec.common.impl.marketing;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pd.e;
import pd.h;
import pd.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\b\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0016\u001a\u00020\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/common/impl/marketing/ECMarketingHybridLiveLynxViewService;", "Lcom/bytedance/android/ec/common/api/marketing/IMarketingLiveLynxViewService;", "Landroid/app/Activity;", a.VALUE_ACTIVITY, "", a.KEY_URL, "Lkf/a;", "callback", "createLynxComponent", "", "", "m", "", "renderTemplate", "Landroid/view/View;", "getView", "release", "getKitView", "eventName", "params", "sendJSEvent", "data", "updateGlobalProps", "<init>", "()V", "ECMarketingHybridLiveLynxAdapter", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMarketingHybridLiveLynxViewService implements IMarketingLiveLynxViewService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/marketing/ECMarketingHybridLiveLynxViewService$ECMarketingHybridLiveLynxAdapter;", "Lcom/bytedance/android/ec/common/api/marketing/IMarketingLiveLynxViewService;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ECMarketingHybridLiveLynxAdapter implements IMarketingLiveLynxViewService {
        public j a;

        public static final class a implements h {
            public final /* synthetic */ kf.a a;

            @Override // pd.h
            public final void onRuntimeReady(View r10) {
                Intrinsics.checkNotNullParameter(r10, "lynxView");
            }

            @Override // pd.h
            public final void b() {
                Intrinsics.checkNotNullParameter("", "errorMessage");
                this.a.b();
            }

            public a(kf.a r1) {
                this.a = r1;
            }

            @Override // pd.h
            public final void onFirstScreen(View r10) {
                Intrinsics.checkNotNullParameter(r10, "lynxView");
                this.a.onFirstScreen(r10);
            }

            @Override // pd.h
            public final void onLoadSuccess(View r10) {
                Intrinsics.checkNotNullParameter(r10, "lynxView");
                this.a.onLoadSuccess(r10);
            }

            @Override // pd.h
            public final void onLoadFailed(View r1, String r10) {
                Intrinsics.checkNotNullParameter(r1, "lynxView");
                this.a.onLoadFailed();
            }

            @Override // pd.h
            public final void onPageStart(View r1, String r10) {
                Intrinsics.checkNotNullParameter(r1, "lynxView");
                this.a.c(r1);
            }

            @Override // pd.h
            public final void onReceivedError(View r10, String r11) {
                Intrinsics.checkNotNullParameter(r10, "lynxView");
                this.a.onReceivedError(r10, r11);
            }
        }

        public ECMarketingHybridLiveLynxAdapter() {
        }

        @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
        public final View getKitView() {
            j r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.b();
        }

        @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
        public final View getView() {
            j r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getHybridView();
        }

        @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
        public final void release() {
            j r0 = this.a;
            if (r0 == null) goto L6;
            r0.release();
            return;
        }

        @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
        public final void updateGlobalProps(Map<String, ? extends Object> r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            j r0 = this.a;
            if (r0 == null) goto L6;
            r0.updateBusinessGlobalProps(r10);
            return;
        }

        @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
        public final void renderTemplate(String r10, Map<String, ? extends Object> r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            if (r10.length() <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L24;
            j r12 = this.a;
            if (r12 == null) goto L25;
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            if (StringsKt.startsWith$default(r10, "http", false, 2, null) == false) goto L22;
        L19:
            r12.renderTemplate(r10, r11);
            return;
        L22:
            Uri r13 = UriProtector.parse(r10);     // Catch: Exception -> L21
            String r0 = UriProtector.getQueryParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Exception -> L21
            if (r0 != null) goto L15;
            r0 = UriProtector.getQueryParameter(r13, "surl");     // Catch: Exception -> L21
        L15:
            if (r0 == null) goto L18;
            r10 = r0;
        L18:
            r10 = "";
            goto L19
        L25:
            return;
        L24:
            return;
        L5:
            r1 = false;
            goto L6
        }

        @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
        public final void sendJSEvent(String r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            j r0 = this.a;
            if (r0 == null) goto L8;
            if (r11 != null) goto L6;
            r11 = Unit.INSTANCE;
        L6:
            r0.sendJsEvent(r10, r11);
            return;
        }

        @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
        public final IMarketingLiveLynxViewService createLynxComponent(Activity r10, String r11, kf.a r12) {
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r12, "callback");
            if (r10 != null) goto L5;
            return null;
        L5:
            int r1 = ECSdk.a;
            IAdapterService r13 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r13 == null) goto L10;
            e r14 = r13.getIExternaHybridService();
            if (r14 == null) goto L10;
            final j r15 = r14.createLynxComponent(r10, r11, new a(r12), true);
        L11:
            if (r15 == null) goto L21;
            r15.registerCrashMonitor();
            if ((r10 instanceof FragmentActivity) == true) goto L15;
            r10 = null;
        L15:
            FragmentActivity r16 = (FragmentActivity) r10;
            if (r16 == null) goto L20;
            final Lifecycle r17 = r16.getLifecycle();
            if (r17 == null) goto L20;
            r17.addObserver(new ECMarketingHybridLiveLynxViewService$ECMarketingHybridLiveLynxAdapter$createLynxComponent$$inlined$let$lambda$1(r17, this, r15));
        L20:
            this.a = r15;
        L21:
            return this;
        L10:
            r15 = null;
            goto L11
        }
    }

    public ECMarketingHybridLiveLynxViewService() {
    }

    @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
    public View getKitView() {
        return null;
    }

    @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
    public View getView() {
        return null;
    }

    @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
    public void release() {
    }

    @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
    public void renderTemplate(String r1, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r1, a.KEY_URL);
    }

    @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
    public void sendJSEvent(String r1, Object r10) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
    }

    @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
    public void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
    }

    @Override // com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService
    public IMarketingLiveLynxViewService createLynxComponent(Activity r10, String r11, kf.a r12) {
        Intrinsics.checkNotNullParameter(r11, a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "callback");
        ECMarketingHybridLiveLynxAdapter r0 = new ECMarketingHybridLiveLynxAdapter();
        r0.createLynxComponent(r10, r11, r12);
        return r0;
    }
}
