package com.larus.e_commerce.impl.order;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.account.saas.security.api.IAccountSecurityService;
import com.larus.account.saas.security.model.AccountSecurityEventType;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.a0;
import com.larus.bmhome.c0;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.btm.api.IBTMService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.e_commerce.api.IECommerceService;
import com.larus.login.api.CommonDouYinLoginKV;
import com.larus.login.api.DouYinBindStatus;
import com.larus.login.api.b0;
import com.larus.network.http.AsyncLiveData;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.larus.settings.value.ro;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.e1;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001<B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0017H\u0002J9\u00101\u001a\u00020\u001d2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d032!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u001d05H\u0002JA\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u00172\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d032!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u001d05H\u0002J\b\u0010;\u001a\u00020\u001dH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/e_commerce/impl/order/OrderSettingsComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bmhome/ISideBarLayoutListener;", "<init>", "()V", "eCommerceAuthConfig", "Lcom/larus/platform/model/ecommerce/ECommerceAuthConfig;", "getECommerceAuthConfig", "()Lcom/larus/platform/model/ecommerce/ECommerceAuthConfig;", "eCommerceAuthConfig$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/bmhome/setting/ICommonSettingBinding;", "getBinding", "()Lcom/larus/bmhome/setting/ICommonSettingBinding;", "isResumed", "", "bindJob", "Lkotlinx/coroutines/Job;", "observer", "Landroidx/lifecycle/Observer;", "Lcom/larus/network/http/Async;", "", "getObserver", "()Landroidx/lifecycle/Observer;", "bindDouyinCallback", "Lcom/larus/login/api/DouYinBoundCallback;", "jumpToOrderPage", "", "navigateToOrderPage", "schema", "onCreate", "onDestroy", "onResume", "onPause", "cancelBindDouYin", "onSideBarOpen", "isClick", "onSideBarClose", "onSideBarStateChanged", "newState", "", "onParentViewCreated", "generateLearnMoreSpan", "Landroid/text/SpannableStringBuilder;", "context", "Landroid/content/Context;", "checkDescText", "readyToECommercePlugin", FlowDoraConnectReason.SUCCESS, "Lkotlin/Function0;", "fail", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "reason", "loadInEcommercePlugin", "initSource", "reportViewOrder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrderSettingsComponent extends ComponentFeature implements c0 {
    public static final /* synthetic */ int m = 0;
    public final Lazy h;
    public boolean i;
    public Job j;
    public final OrderSettingsComponent$observer$1 k;
    public final b l;

    public static final class a {
    }

    public static final class b implements b0 {
        public final /* synthetic */ OrderSettingsComponent a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[DouYinBindStatus.values().length];
                r0[DouYinBindStatus.ALREADY_BOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[DouYinBindStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[DouYinBindStatus.FAILURE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[DouYinBindStatus.CANCEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[DouYinBindStatus.GO_MARKET.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[DouYinBindStatus.GO_ACCOUNT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }

        public b(OrderSettingsComponent r1) {
            this.a = r1;
        }

        public final void a(DouYinBindStatus r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "status");
            OrderSettingsComponent r5 = this.a;
            int r6 = OrderSettingsComponent.m;
            com.larus.bmhome.setting.c r7 = r5.N2();
            if (r7 == null) goto L8;
            ItemTextArrow r8 = r7.A0();
            if (r8 == null) goto L8;
            r8.V5();
        L8:
            if (this.a.i == true) goto L11;
            return;
        L11:
            switch(a.a[r2.ordinal()]) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L18;
                case 5: goto L18;
                case 6: goto L18;
                default: goto L13;
            };
        L14:
            s r9 = s.a;
            FragmentActivity r10 = s1a.a.getActivity(this.a);
            String r11 = AppHost.a.getApplication().getString(2131905611);
            r9.getClass();
            s.c(r10, r11);
            return;
        L15:
            Lazy r12 = CommonDouYinLoginKV.a;
            CommonDouYinLoginKV.d();
            OrderSettingsComponent.F2(this.a);
            return;
        L16:
            Lazy r13 = CommonDouYinLoginKV.a;
            CommonDouYinLoginKV.d();
            OrderSettingsComponent.F2(this.a);
            return;
        L18:
            return;
        L13:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c extends ClickableSpan {
        public final /* synthetic */ Context a;

        public c(Context r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r4) {
            Intrinsics.checkNotNullParameter(r4, "widget");
            com.bytedance.router.i r5 = SmartRouter.buildRoute(this.a, "//flow/webview");
            Bundle r0 = new Bundle();
            r0.putString("link_url", "https://lf9-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/grace_legal/Shopping-Payment-FAQ.html");
            r5.c.putExtras(r0);
            r5.d();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r4) {
            Intrinsics.checkNotNullParameter(r4, "ds");
            r4.setUnderlineText(false);
            Context r0 = this.a;
            r4.setColor(ContextCompat.getColor(r0, v19.c.b(2130972079, r0, 2131103136)));
        }
    }

    static {
    }

    public final void H0(int r1) {
    }

    public final void n0(boolean r1) {
    }

    public final void onDestroy() {
    }

    public final void onPause() {
        this.i = false;
    }

    public final void onResume() {
        boolean r0 = true;
        this.i = true;
        Job r1 = this.j;
        if (r1 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == true) goto L15;
        com.larus.bmhome.setting.c r2 = N2();
        if (r2 == null) goto L16;
        ItemTextArrow r3 = r2.A0();
        if (r3 == null) goto L17;
        r3.V5();
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r1.isActive() != true) goto L7;
        goto L7
    }

    public final void B2() {
        AccountService r0 = AccountService.a;
        if (r0.isLogin().booleanValue() == true) goto L5;
    L41:
        com.larus.bmhome.setting.c r1 = N2();
        if (r1 == null) goto L48;
        ItemTextArrow r2 = r1.A0();
        if (r2 == null) goto L49;
        r2.setVisibility(8);
        return;
    L49:
        return;
    L48:
        return;
    L5:
        if (r0.a() == true) goto L41;
        e10 r3 = e10.a;
        int r4 = l0.a;
        new pv9.b();
        if (((pv9.a) l0.a(pv9.b.a(), new ro())).a() == false) goto L41;
        AsyncLiveData<String> r5 = OrderSchemaService.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        OrderSchemaService.a(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)));
        final JSONObject r6 = new JSONObject();
        r6.put("current_page", "setting");
        IApplog r7 = (IApplog) ServiceManager.get().getService(IApplog.class);
        if (r7 == null) goto L12;
        r7.reportEvent("order_manage_show", r6);
    L12:
        com.larus.bmhome.setting.c r8 = N2();
        if (r8 == null) goto L17;
        ItemGroup r9 = r8.r0();
        if (r9 == null) goto L17;
        e1.x(r9);
    L17:
        com.larus.bmhome.setting.c r10 = N2();
        if (r10 == null) goto L22;
        ItemTextArrow r11 = r10.A0();
        if (r11 == null) goto L22;
        r11.setVisibility(0);
    L22:
        com.larus.bmhome.setting.c r12 = N2();
        if (r12 == null) goto L25;
        ItemTextArrow r13 = r12.A0();
    L27:
        if ((r13 instanceof ItemTextArrow) == true) goto L30;
        r13 = null;
    L30:
        if (r13 == null) goto L32;
        int r14 = ItemTextArrow.k;
        r13.Z5("", null);
    L32:
        com.larus.bmhome.setting.c r15 = N2();
        if (r15 == null) goto L37;
        ItemTextArrow r16 = r15.A0();
        if (r16 == null) goto L37;
        e1.d(r16, new com.larus.e_commerce.impl.order.c(this, r6));
    L37:
        Intrinsics.checkNotNullParameter(this, "<this>");
        a0 r17 = com.larus.bmhome.b0.a(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        if (r17 == null) goto L47;
        r17.If(this);
        return;
    L47:
        return;
    L25:
        r13 = null;
        goto L27
    }

    public final void onCreate() {
        IBTMService r0 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r0.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), "a35794.b85487");
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.e_commerce.impl.order.OrderSettingsComponent$observer$1] */
    public OrderSettingsComponent() {
        this.h = LazyKt.lazy(new d());
        this.k = new OrderSettingsComponent$observer$1(this);
        this.l = new b(this);
    }

    public final com.larus.bmhome.setting.c N2() {
        return s1a.d.a(this).a(com.larus.bmhome.setting.c.class);
    }

    public static final void F2(OrderSettingsComponent r4) {
        r4.getClass();
        AsyncLiveData r0 = OrderSchemaService.b;
        y r1 = (com.larus.network.http.a) r0.getValue();
        if ((r1 instanceof y) == false) goto L9;
        String r2 = (String) ((com.larus.network.http.a) r1).b;
        if (r2 == null) goto L9;
        if (OrderSchemaService.b() == true) goto L9;
        r4.P2(r2);
        return;
    L9:
        FLogger.a.i("OrderSettingsComponent", "Schema expired or not available, fetching new one");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r0.observe(com.larus.ui.arch.component.internal.attach.a.b(r4, r4), r4.k);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        OrderSchemaService.a(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(r4, r4)));
    }

    public final void G(boolean r4) {
        com.larus.bmhome.setting.c r5 = N2();
        if (r5 == null) goto L14;
        ItemTextArrow r6 = r5.A0();
        if (r6 == null) goto L15;
        r6.V5();
        Object r0 = r6.getTag();
        if ((r0 instanceof Job) == false) goto L9;
        Job r1 = (Job) r0;
    L10:
        if (r1 == null) goto L12;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L12:
        r6.setTag(null);
        return;
    L9:
        r1 = null;
        goto L10
    L15:
        return;
    }

    public final void P2(String r9) {
        IECommerceService r0 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r0 != null) goto L5;
        return;
    L5:
        FragmentActivity r1 = s1a.a.getActivity(this);
        if (r1 != null) goto L8;
        return;
    L8:
        IBTMService r2 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        Uri r3 = null;
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r3 = r2.j(r9, "a35794.b85487.c93478.d38388", null, com.larus.ui.arch.component.internal.attach.a.b(this, this));
    L12:
        if (r0.i() == true) goto L14;
        return;
    L14:
        if (r0.c(r1, r3) == false) goto L18;
        IAccountSecurityService.a.h(new e48.d(AccountSecurityEventType.VIEW_ORDER, AccountService.a.getSecUserId(), System.currentTimeMillis(), MapsKt.emptyMap(), "OrderSettingsComponent"));
        return;
    }

    public final SpannableStringBuilder L2(Context r6, String r7) {
        String r0 = ContextCompat.getString(r6, 2131906798);
        SpannableString r1 = new SpannableString(r0);
        r1.setSpan(new c(r6), 0, r0.length(), 33);
        r1.setSpan(new StyleSpan(1), 0, r0.length(), 33);
        r1.setSpan(new vj9.a(), 0, r0.length(), 33);
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        r8.append(r7);
        r8.append(r1);
        return r8;
    }
}
