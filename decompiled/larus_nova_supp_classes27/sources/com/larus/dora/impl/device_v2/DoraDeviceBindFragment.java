package com.larus.dora.impl.device_v2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.databinding.LarusDoraDeviceBindPageBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0002#&\b\u0016\u0018\u0000 E2\u00020\u0001:\u0003EFGB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u001a\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020\u0015H\u0002J\b\u0010:\u001a\u00020\u0015H\u0002J \u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00102\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0010H\u0002J\b\u0010@\u001a\u00020\u0015H\u0002J\b\u0010A\u001a\u00020\u0015H\u0002J\b\u0010B\u001a\u00020\u0015H\u0002J\b\u0010C\u001a\u00020\u0015H\u0016J\b\u0010D\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006H"}, d2 = {"Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "isChecking", "", "isFirst", "binding", "Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment$DeviceBindPageBinding;", "dataLoader", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader;", "onboardingDialogFragment", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "lastOnboardingDialogFragment", "Landroidx/fragment/app/Fragment;", "prePage", "", "gpsDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "pendingCheckAction", "Lkotlin/Function0;", "", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pageKey", "productID", "", "Ljava/lang/Integer;", "productModel", "buryPointSource", "unbindDialog", "connectFailedDialog", "Lcom/larus/dora/impl/device/DoraDeviceConnectFailedDialog;", "fragmentLifecycleCallbacks", "com/larus/dora/impl/device_v2/DoraDeviceBindFragment$fragmentLifecycleCallbacks$1", "Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment$fragmentLifecycleCallbacks$1;", "receiver", "com/larus/dora/impl/device_v2/DoraDeviceBindFragment$receiver$1", "Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment$receiver$1;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "createPageBinding", "onViewCreated", "view", "setupPage", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslSimplePage;", "dismissUnbindDialog", "startBind", "checkReady", "from", "doNext", "handlePermissionDenied", "reason", "launchOnboarding", "showConnectFailedDialog", "dismissConnectFailedDialog", "onDestroyView", "getCurrentPageName", "Companion", "DeviceBindPageBinding", "DefaultDeviceBindPageBinding", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoraDeviceBindFragment extends DoraBaseFragment {
    public static final /* synthetic */ int t = 0;
    public boolean f;
    public c g;
    public final com.larus.dora.impl.dynamic.loader.d h;
    public BottomSheetDialogFragment i;
    public String j;
    public CommonDialog k;
    public Function0<Unit> l;
    public ActivityResultLauncher<Intent> m;
    public String n;
    public Integer o;
    public String p;
    public String q;
    public final DoraDeviceBindFragment$fragmentLifecycleCallbacks$1 r;
    public final DoraDeviceBindFragment$receiver$1 s;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.device_v2.DoraDeviceBindFragment$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment$Companion$DslBindDevicePage;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "desc", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "bindButtonInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslButton;", "buyButtonInfo", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslButton;Lcom/larus/dora/impl/dynamic/dsl/DslButton;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getDesc", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "getBindButtonInfo", "()Lcom/larus/dora/impl/dynamic/dsl/DslButton;", "getBuyButtonInfo", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0058a {

            @SerializedName("bind_button_info")
            private final c59.h bindButtonInfo;

            @SerializedName("buy_button_info")
            private final c59.h buyButtonInfo;

            @SerializedName("desc")
            private final c59.t desc;

            @SerializedName("image_link")
            private final c59.u imageLink;

            @SerializedName("title")
            private final c59.t title;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0058a) == true) goto L8;
                return false;
            L8:
                C0058a r6 = (C0058a) r5;
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.imageLink, r6.imageLink) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.bindButtonInfo, r6.bindButtonInfo) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.buyButtonInfo, r6.buyButtonInfo) == true) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                c59.t r0 = this.title;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                c59.t r4 = this.desc;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                c59.u r7 = this.imageLink;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                c59.h r10 = this.bindButtonInfo;
                if (r10 != null) goto L17;
                int r11 = 0;
            L18:
                int r12 = (r9 + r11) * 31;
                c59.h r13 = this.buyButtonInfo;
                if (r13 == null) goto L23;
                r1 = r13.hashCode();
            L23:
                return r12 + r1;
            L17:
                r11 = r10.hashCode();
                goto L18
            L13:
                r8 = r7.hashCode();
                goto L14
            L9:
                r5 = r4.hashCode();
                goto L10
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "DslBindDevicePage(title=" + this.title + ", desc=" + this.desc + ", imageLink=" + this.imageLink + ", bindButtonInfo=" + this.bindButtonInfo + ", buyButtonInfo=" + this.buyButtonInfo + ')';
            }

            public C0058a() {
                this.title = null;
                this.desc = null;
                this.imageLink = null;
                this.bindButtonInfo = null;
                this.buyButtonInfo = null;
            }

            public final c59.h a() {
                return this.bindButtonInfo;
            }

            public final c59.h b() {
                return this.buyButtonInfo;
            }

            public final c59.t c() {
                return this.desc;
            }

            public final c59.u d() {
                return this.imageLink;
            }

            public final c59.t e() {
                return this.title;
            }
        }
    }

    public static final class b implements c {
        public final LarusDoraDeviceBindPageBinding a;

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final TextView b() {
            return this.a.f;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final SimpleDraweeView d() {
            return this.a.e;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final TextView e() {
            return this.a.g;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final View f() {
            return this.a.c;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final View getRoot() {
            return this.a.a;
        }

        public b(LarusDoraDeviceBindPageBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            this.a = r2;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a.c.setText(r2);
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void c(final j r3) {
            Intrinsics.checkNotNullParameter(r3, "onBackClick");
            e1.x(this.a.d);
            ViewGroup.LayoutParams r0 = this.a.d.getLayoutParams();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) r0;
            com.larus.utils.i0.a.getClass();
            r1.topMargin = com.larus.utils.i0.g();
            this.a.d.setLayoutParams(r1);
            this.a.d.setLeftClickListener(new o(r3));
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void g(final s r3) {
            Intrinsics.checkNotNullParameter(r3, "action");
            e1.d(this.a.b, new q(r3));
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a.b.setText(r2);
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void i(final t r3) {
            Intrinsics.checkNotNullParameter(r3, "action");
            e1.d(this.a.c, new p(r3));
        }
    }

    public interface c {
        void a(String r1);

        TextView b();

        void c(j r1);

        SimpleDraweeView d();

        TextView e();

        View f();

        void g(s r1);

        View getRoot();

        void h(String r1);

        void i(t r1);
    }

    static {
    }

    public final String k() {
        return "DoraDeviceBindFragment";
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.impl.device_v2.DoraDeviceBindFragment$fragmentLifecycleCallbacks$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.device_v2.DoraDeviceBindFragment$receiver$1] */
    public DoraDeviceBindFragment() {
        this.h = new com.larus.dora.impl.dynamic.loader.d();
        this.l = new l();
        this.q = "";
        this.r = new DoraDeviceBindFragment$fragmentLifecycleCallbacks$1();
        this.s = new DoraDeviceBindFragment$receiver$1();
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).unregisterReceiver(this.s);
    }

    public final void Y90(String r2) {
        g49.d.d("DoraDeviceBindFragment", "handlePermissionDenied: ".concat(r2));
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.m = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(this));
    }

    public final void W90(String r8, Function0<Unit> r9) {
        g49.d.d("DoraDeviceBindFragment", "checkReady: " + r8 + " start");
        if (Intrinsics.areEqual(r8, "check_from_MAIN") == true) goto L5;
    L8:
        this.f = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraDeviceBindFragment$checkReady$1(r8, r9, this, null), 3, null);
        return;
    L5:
        if (this.f == false) goto L8;
        g49.d.d("DoraDeviceBindFragment", "checkReady: " + r8 + " isChecking");
    }

    public c X90(LayoutInflater r11, ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        View r13 = r11.inflate(2131562146, r12, false);
        int r14 = 2131364656;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r13, 2131364656);
        if (r4 == null) goto L17;
        r14 = 2131364665;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r13, 2131364665);
        if (r5 == null) goto L17;
        r14 = 2131368926;
        HistoryDeviceNavigationBar r6 = (HistoryDeviceNavigationBar) ViewBindings.findChildViewById(r13, 2131368926);
        if (r6 == null) goto L17;
        r14 = 2131376390;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(r13, 2131376390);
        if (r7 == null) goto L17;
        r14 = 2131390487;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, 2131390487);
        if (r8 == null) goto L17;
        r14 = 2131391606;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r13, 2131391606);
        if (r9 == null) goto L17;
        return new b(new LarusDoraDeviceBindPageBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9));
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.device_v2.j] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onViewCreated(View r12, Bundle r13) {
        String r0 = "";
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        Bundle r14 = getArguments();
        if (r14 == null) goto L53;
        r14.getString("page_title");
    L53:
        Bundle r15 = getArguments();     // Catch: Throwable -> L14
        if (r15 == null) goto L9;
        String r16 = r15.getString("product_id");     // Catch: Throwable -> L14
    L10:
        if (r16 != null) goto L12;
        r16 = "";
    L12:
        this.o = Integer.valueOf(CastIntegerProtector.parseInt(r16));     // Catch: Throwable -> L14
    L16:
        Bundle r17 = getArguments();
        if (r17 == null) goto L19;
        String r18 = r17.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L20:
        if (r18 != null) goto L22;
        r18 = "";
    L22:
        this.p = r18;
        Bundle r110 = getArguments();
        if (r110 == null) goto L25;
        String r111 = r110.getString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY);
    L26:
        if (r111 != null) goto L28;
        r111 = "";
    L28:
        boolean r2 = true;
        if (r111.length() != 0) goto L31;
        boolean r1 = true;
    L32:
        if (r1 == false) goto L34;
        r111 = "bind_device_v2";
    L34:
        this.n = r111;
        Bundle r112 = getArguments();
        if (r112 == null) goto L37;
        String r113 = r112.getString("bury_point_source");
    L38:
        if (r113 == null) goto L41;
        r0 = r113;
    L41:
        this.q = r0;
        c r114 = this.g;
        if (r114 == 0) goto L44;
        r114.c(new j(this));
    L44:
        com.larus.dora.impl.dynamic.loader.d.b(this.h, LifecycleOwnerKt.getLifecycleScope(this), 1, this.o, this.p, this.n, new AnonymousClass3(this));
        getParentFragmentManager().registerFragmentLifecycleCallbacks(this.r, false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        Bundle r115 = getArguments();
        if (r115 != null) goto L47;
    L49:
        r2 = false;
    L50:
        if (r2 == false) goto L55;
        W90("check_from_MAIN", new m(this));
        return;
    L55:
        return;
    L47:
        if (r115.getBoolean("key_dora_onboarding_auto_connect") != true) goto L49;
    L37:
        r113 = null;
        goto L38
    L31:
        r1 = false;
        goto L32
    L25:
        r111 = null;
        goto L26
    L19:
        r18 = null;
        goto L20
    L9:
        r16 = null;
    L14:
        th = move-exception;
        this.o = Integer.valueOf(ProductNameType.DORA_LITE.id);
        g49.d.b("DoraDeviceBindFragment", "onViewCreated, error is " + th.getMessage());
        goto L16
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        this.g = X90(r1, r2);
        IntentFilter r4 = new IntentFilter("action.DEVICE_TO_GUIDE");
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).registerReceiver(this.s, r4);
        Bundle r5 = getArguments();
        String r6 = "";
        if (r5 == null) goto L8;
        String r7 = r5.getString("device_manage", "");
        if (r7 == null) goto L8;
        r6 = r7;
    L8:
        this.j = r6;
        c r8 = this.g;
        if (r8 != null) goto L13;
        return null;
    L13:
        return r8.getRoot();
    }
}
