package com.larus.setting.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.NetworkUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.model.SettingsAccountInfo;
import com.larus.account.base.model.SettingsBaseAccountInfo;
import com.larus.account.base.model.SettingsConnectAccountInfo;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.login.api.LoginService;
import com.larus.search.api.IBrowserService;
import com.larus.setting.impl.databinding.LarusPageSettingAccountInfoBinding;
import com.larus.setting.impl.track.SettingTrace;
import com.larus.settings.value.e10;
import com.larus.settings.value.kg;
import com.larus.settings.value.m8;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.trace.tracknode.a$a;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.account.ObricAccountSPIServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 P2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050'H\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\u001c\u0010)\u001a\u0004\u0018\u00010\u00122\u0006\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020\u0018H\u0002J\u0012\u0010.\u001a\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010/\u001a\u00020\u001cH\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0002J\u0010\u00107\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\u0018J\u001c\u00109\u001a\u00020\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010<\u001a\u00020\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010=\u001a\u00020\u001c2\b\u0010>\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020\u0005H\u0002J\u0012\u0010A\u001a\u00020\u001c2\b\u0010>\u001a\u0004\u0018\u00010\u0012H\u0002J$\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00052\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010F\u001a\u00020\u001c2\b\u0010>\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010G\u001a\u00020\u001c2\b\u0010>\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010H\u001a\u00020\u001c2\b\u0010>\u001a\u0004\u0018\u00010\u0012H\u0002J*\u0010I\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00122\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010KH\u0002J\u0010\u0010L\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020OH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/larus/setting/impl/SettingAccountInfoFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "TAG", "", "binding", "Lcom/larus/setting/impl/databinding/LarusPageSettingAccountInfoBinding;", "model", "Lcom/larus/setting/impl/SettingModel;", "getModel", "()Lcom/larus/setting/impl/SettingModel;", "model$delegate", "Lkotlin/Lazy;", "trace", "Lcom/larus/setting/impl/track/SettingTrace;", "thirdLoginItems", "Ljava/util/LinkedHashMap;", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "Lkotlin/collections/LinkedHashMap;", "switchBindDouYinLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "noneBindPlatform", "", "canOperatorAccount", "getDeleteAccountUrl", "onResume", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "shouldShowUnsubscribeDialog", "getThirdLoginPlatformList", "", "initThirdBindAccountButton", "addThirdBindAccountButton", "platform", "text", "refreshAccountSettingEntryVisibility", "shouldShowAccountSettingPhoneEntry", "shouldShowAccountSettingPlatformEntry", "onDestroyView", "autoLogEnterPage", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "updateAccountInfo", "isForceRequest", "setAccountInfo", "accountInfo", "Lcom/larus/account/base/model/SettingsAccountInfo;", "refreshSubTextColor", "handleDouyinBindAccountClick", "itemTextArrow", "handleSwitchBindDouYinAccount", "profileKey", "handleWeixinBindAccountClick", "handleBindWithAccount", "success", "type", "errorResult", "handleFacebookBindAccountClick", "handleLineBindAccountClick", "handleGoogleBindAccountClick", "showUnBindDialog", "unbindCallback", "Lkotlin/Function0;", "canUnbind", "getStringSafely", "resId", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SettingAccountInfoFragment extends TraceFragment {
    public static final Set<String> m = null;
    public static final String n = null;
    public static final String o = null;
    public static final String p = null;
    public static final String q = null;
    public static final String r = null;
    public static final HashMap<String, String> s = null;
    public final String e;
    public LarusPageSettingAccountInfoBinding f;
    public final Lazy g;
    public final SettingTrace h;
    public final LinkedHashMap<String, ItemTextArrow> i;
    public ActivityResultLauncher<Intent> j;
    public boolean k;
    public boolean l;

    public static final class a {
    }

    public static final class b implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ Context a;

        public final void confirm() {
            LoginService.a.w(this.a, false);
        }

        public b(Context r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public c() {
        }

        public final void cancel() {
        }
    }

    public static final class d implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ SettingAccountInfoFragment a;

        public final void confirm() {
            if (NetworkUtils.isNetworkAvailable(this.a.requireContext().getApplicationContext()) == false) goto L21;
            Pair[] r2 = new Pair[1];
            StringBuilder r3 = new StringBuilder();
            SettingAccountInfoFragment r4 = this.a;
            Set<String> r5 = SettingAccountInfoFragment.m;
            r4.getClass();
            e10 r6 = e10.a;
            String r7 = (String) com.larus.utils.l0.a(null, new m8());
            if (r7 != null) goto L7;
        L12:
            r7 = kb9.c.b;
        L13:
            r3.append(r7);
            r3.append("?hide_title_bar=1");
            r2[0] = TuplesKt.to("link_url", r3.toString());
            Bundle r0 = com.larus.utils.f.c(r2);
            LarusPageSettingAccountInfoBinding r8 = this.a.f;
            if (r8 == null) goto L20;
            LinearLayout r9 = r8.a;
            if (r9 == null) goto L20;
            IBrowserService r10 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
            if (r10 == null) goto L20;
            r10.i(r9, r0, null);
        L20:
            this.a.h.getClass();
            IApplog.a.b("click_clear_account_confirm", com.larus.utils.f.c(new Pair[0]));
            return;
        L7:
            if ((true ^ StringsKt.isBlank(r7)) == true) goto L10;
            r7 = null;
        L10:
            if (r7 == null) goto L12;
        L21:
            t19.s r1 = t19.s.a;
            Context r11 = this.a.requireActivity().getApplicationContext();
            r1.getClass();
            t19.s.b(r11, 2131906741, false);
        }

        public d(SettingAccountInfoFragment r1) {
            this.a = r1;
        }
    }

    public static final class e implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ SettingAccountInfoFragment a;

        public final void cancel() {
            this.a.h.getClass();
            IApplog.a.b("click_clear_account_cancel", com.larus.utils.f.c(new Pair[0]));
        }

        public e(SettingAccountInfoFragment r1) {
            this.a = r1;
        }
    }

    public static final class f implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ SettingAccountInfoFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ItemTextArrow c;
        public final /* synthetic */ Function0<Unit> d;

        public static final class a implements n38.m {
            public final /* synthetic */ SettingAccountInfoFragment a;
            public final /* synthetic */ ItemTextArrow b;
            public final /* synthetic */ Function0<Unit> c;

            public final void onSuccess(String r4) {
                t19.s r5 = t19.s.a;
                Context r0 = this.a.getContext();
                SettingAccountInfoFragment r1 = this.a;
                Set<String> r2 = SettingAccountInfoFragment.m;
                String r3 = r1.X90(2131910785);
                r5.getClass();
                t19.s.p(r0, r3);
                this.b.getSubTextView().setText(this.a.X90(2131910789));
                this.a.aa0(true);
                Function0<Unit> r6 = this.c;
                if (r6 == null) goto L6;
                r6.invoke();
                return;
            }

            public a(SettingAccountInfoFragment r1, ItemTextArrow r2, Function0<Unit> r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void a(int r1, String r2, String r3, String r4) {
                t19.s r5 = t19.s.a;
                Context r6 = this.a.getContext();
                if (r2 != null) goto L5;
            L8:
                boolean r7 = true;
            L9:
                if (r7 == false) goto L11;
                SettingAccountInfoFragment r8 = this.a;
                Set<String> r9 = SettingAccountInfoFragment.m;
                r2 = r8.X90(2131907052);
            L11:
                r5.getClass();
                t19.s.t(r6, r2);
                return;
            L5:
                if (r2.length() == 0) goto L8;
                r7 = false;
                goto L9
            }
        }

        public final void confirm() {
            SettingAccountInfoFragment r0 = this.a;
            String r1 = this.b;
            Set<String> r2 = SettingAccountInfoFragment.m;
            r0.getClass();
            SettingsAccountInfo r3 = IAccountService.a.w();
            if (r3 == null) goto L7;
            SettingsBaseAccountInfo r4 = r3.a();
            if (r4 == null) goto L7;
            String r5 = r4.a();
        L9:
            if (com.larus.utils.o0.d(r5) == true) goto L23;
            if (r3 == null) goto L24;
            List r6 = r3.b();
            if (r6 == null) goto L24;
            Iterator r7 = r6.iterator();
        L16:
            if (r7.hasNext() == false) goto L24;
            SettingsConnectAccountInfo r8 = (SettingsConnectAccountInfo) r7.next();
            if (r8 == null) goto L16;
            if (com.larus.utils.o0.d(r8.a()) == false) goto L16;
            if (Intrinsics.areEqual(r8.a(), r1) == true) goto L16;
        L24:
            boolean r9 = false;
        L25:
            if (r9 == true) goto L28;
            t19.s r10 = t19.s.a;
            Context r11 = this.a.getContext();
            String r12 = this.a.X90(2131910784);
            r10.getClass();
            t19.s.t(r11, r12);
            return;
        L28:
            ILoginService.a.e(this.b, new a(this.a, this.c, this.d));
            return;
        L23:
            r9 = true;
        L7:
            r5 = null;
            goto L9
        }

        public f(SettingAccountInfoFragment r1, String r2, ItemTextArrow r3, Function0<Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class g implements com.larus.common_ui.dialog.u {
        public g() {
        }

        public final void cancel() {
        }
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "setting";
    }

    static {
        m = SetsKt.setOf(new String[]{"1030", "1041"});
        n = "aweme_v2";
        o = "google";
        p = "line";
        q = "facebook";
        r = "weixin";
        HashMap<String, String> r5 = new HashMap();
        r5.put("douyin", "aweme_v2");
        r5.put("google", "google");
        r5.put("line", "line");
        r5.put("facebook", "facebook");
        r5.put("wechat", "weixin");
        s = r5;
    }

    public SettingAccountInfoFragment() {
        this.e = "SettingAccountInfoFragment";
        final Function0<Fragment> r0 = new SettingAccountInfoFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingModel.class), new SettingAccountInfoFragment$special$$inlined$viewModels$default$2(r0), new SettingAccountInfoFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = new SettingTrace();
        this.i = new LinkedHashMap();
        this.l = true;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.j = null;
        this.f = null;
        this.i.clear();
    }

    public final void onResume() {
        super.onResume();
        aa0(true);
    }

    public final String X90(int r2) {
        if (getContext() != null) goto L7;
        return "";
    L7:
        return getString(r2);
    }

    public final void aa0(boolean r8) {
        LarusPageSettingAccountInfoBinding r0 = this.f;
        if (r0 == null) goto L6;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new SettingAccountInfoFragment$updateAccountInfo$1$1(r8, r0, this, null), 2, null);
        return;
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        a$a.a(this, r3);
        r3.put("encrypted_status", "not_turned_on");
    }

    public static void U90(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public final ItemTextArrow W90(String r4, String r5) {
        Context r0 = getContext();
        if (r0 == null) goto L15;
        View r2 = new ItemTextArrow(r0);
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r2.setText(r5);
        r2.Z5(X90(2131910789), null);
        r2.setTextFontWeight(500);
        LarusPageSettingAccountInfoBinding r6 = this.f;
        if (r6 == null) goto L13;
        ItemGroup r7 = r6.b;
        if (r7 == null) goto L13;
        r7.addView(r2);
    L13:
        this.i.put(r4, r2);
        return this.i.get(r4);
    L15:
        return null;
    }

    public static final void V90(SettingAccountInfoFragment r12, LarusPageSettingAccountInfoBinding r13, SettingsAccountInfo r14) {
        Object r3 = null;
        if (r13 == null) goto L143;
        LarusPageSettingAccountInfoBinding r4 = r12.f;
        if (r4 == null) goto L16;
        ItemTextArrow r5 = r4.c;
        if (r5 == null) goto L16;
        if (ObricFeatureServiceDelegate.b.b() == true) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        int r7 = 0;
    L15:
        r5.setVisibility(r7);
        goto L16
    L14:
        r7 = 8;
        goto L15
    L11:
        r6 = ObricAccountSPIServiceDelegate.b.c();
    L16:
        Iterator<Map.Entry<String, ItemTextArrow>> r8 = r12.i.entrySet().iterator();
    L18:
        if (r8.hasNext() == false) goto L27;
        Map.Entry<String, ItemTextArrow> r9 = r8.next();
        String r10 = r9.getKey();
        ItemTextArrow r11 = r9.getValue();
        if (ObricFeatureServiceDelegate.b.b() == true) goto L22;
        boolean r15 = true;
    L23:
        if (r15 == false) goto L25;
        int r16 = 0;
    L26:
        r11.setVisibility(r16);
        goto L18
    L25:
        r16 = 8;
        goto L26
    L22:
        r15 = ObricAccountSPIServiceDelegate.b.b(r10);
        goto L23
    L27:
        if (r14 == null) goto L29;
        SettingsBaseAccountInfo r17 = r14.a();
    L30:
        if (r17 == null) goto L52;
        SettingsBaseAccountInfo r18 = r14.a();
        if (r18 == null) goto L34;
        String r19 = r18.a();
    L35:
        if (r19 != null) goto L37;
    L40:
        boolean r20 = true;
    L41:
        if (r20 == false) goto L47;
        yp9.d r21 = yp9.d.b;
        String r22 = r12.e;
        StringBuilder r23 = new StringBuilder("mobile is ");
        SettingsBaseAccountInfo r24 = r14.a();
        if (r24 == null) goto L45;
        String r25 = r24.a();
    L46:
        r23.append(r25);
        r21.a(r22, r23.toString());
    L53:
        if (r14 == null) goto L143;
        List r110 = r14.b();
        if (r110 == null) goto L143;
        List r111 = CollectionsKt.filterNotNull(r110);
        if (r111 == null) goto L143;
        Iterator r26 = r111.iterator();
    L60:
        if (r26.hasNext() == false) goto L116;
        SettingsConnectAccountInfo r27 = (SettingsConnectAccountInfo) r26.next();
        if (r27 == null) goto L60;
        String r28 = r27.a();
        if (r28 != null) goto L67;
    L70:
        boolean r29 = true;
    L71:
        if (r29 == true) goto L72;
        if (Intrinsics.areEqual(r28, n) == true) goto L75;
        if (Intrinsics.areEqual(r28, o) == true) goto L89;
        if (com.larus.utils.o0.d(r27.c()) == true) goto L105;
        if (com.larus.utils.o0.d(r27.b()) == true) goto L110;
        yp9.d.b.a(r12.e, "info.platformScreenName info.platformEmail is null");
        ItemTextArrow r30 = r12.i.get(r28);
        if (r30 == null) goto L60;
        String r31 = r12.X90(2131899736);
        int r32 = ItemTextArrow.k;
        r30.Z5(r31, null);
        goto L60
    L110:
        ItemTextArrow r33 = r12.i.get(r28);
        if (r33 == null) goto L60;
        String r34 = String.valueOf(r27.b());
        int r35 = ItemTextArrow.k;
        r33.Z5(r34, null);
        goto L60
    L105:
        ItemTextArrow r36 = r12.i.get(r28);
        if (r36 == null) goto L60;
        String r37 = String.valueOf(r27.c());
        int r38 = ItemTextArrow.k;
        r36.Z5(r37, null);
        goto L60
    L89:
        String r39 = r27.b();
        if (r39 != null) goto L92;
    L95:
        boolean r40 = true;
    L96:
        if (r40 == true) goto L97;
        ItemTextArrow r41 = r12.i.get(r28);
        if (r41 == null) goto L60;
        String r42 = String.valueOf(r27.b());
        int r43 = ItemTextArrow.k;
        r41.Z5(r42, null);
        goto L60
    L97:
        yp9.d.b.a(r12.e, "platform email is " + r27.b());
        ItemTextArrow r44 = r12.i.get(r28);
        if (r44 == null) goto L60;
        String r45 = r12.X90(2131899736);
        int r46 = ItemTextArrow.k;
        r44.Z5(r45, null);
        goto L60
    L92:
        if (r39.length() == 0) goto L95;
        r40 = false;
        goto L96
    L75:
        String r47 = r27.c();
        if (r47 != null) goto L78;
    L81:
        boolean r48 = true;
    L82:
        if (r48 == true) goto L83;
        ItemTextArrow r49 = r12.i.get(r28);
        if (r49 == null) goto L60;
        String r50 = String.valueOf(r27.c());
        int r51 = ItemTextArrow.k;
        r49.Z5(r50, null);
        goto L60
    L83:
        yp9.d.b.a(r12.e, "screen name is " + r27.c());
        goto L60
    L78:
        if (r47.length() == 0) goto L81;
        r48 = false;
        goto L82
    L72:
        yp9.d.b.a(r12.e, "platform is " + r28);
        goto L60
    L67:
        if (r28.length() == 0) goto L70;
        r29 = false;
        goto L71
    L116:
        SettingsAccountInfo r52 = IAccountService.a.w();
        if (r52 == null) goto L143;
        List r53 = r52.b();
        if (r53 == null) goto L143;
        List r54 = CollectionsKt.filterNotNull(r53);
        if (r54 == null) goto L143;
        Iterator r55 = r54.iterator();
    L124:
        if (r55.hasNext() == false) goto L143;
        SettingsConnectAccountInfo r56 = (SettingsConnectAccountInfo) r55.next();
        if (r56 == null) goto L124;
        String r57 = r56.a();
        if (ObricFeatureServiceDelegate.b.b() == true) goto L130;
        boolean r58 = true;
    L131:
        if (r58 == false) goto L124;
        Iterator r59 = r111.iterator();
    L134:
        if (r59.hasNext() == false) goto L138;
        Object r60 = r59.next();
        if (Intrinsics.areEqual(r56.a(), ((SettingsConnectAccountInfo) r60).a()) == false) goto L134;
    L139:
        if (r60 != null) goto L124;
        ItemTextArrow r61 = r12.i.get(r56.a());
        if (r61 == null) goto L124;
        String r62 = r12.X90(2131910789);
        int r63 = ItemTextArrow.k;
        r61.Z5(r62, null);
        goto L124
    L138:
        r60 = null;
        goto L139
    L130:
        r58 = ObricAccountSPIServiceDelegate.b.b(r57);
        goto L131
    L45:
        r25 = null;
        goto L46
    L47:
        ItemTextArrow r64 = r13.c;
        SettingsBaseAccountInfo r65 = r14.a();
        if (r65 == null) goto L50;
        String r66 = r65.a();
    L51:
        String r67 = String.valueOf(r66);
        int r68 = ItemTextArrow.k;
        r64.Z5(r67, null);
        goto L53
    L50:
        r66 = null;
        goto L51
    L37:
        if (r19.length() == 0) goto L40;
        r20 = false;
        goto L41
    L34:
        r19 = null;
        goto L35
    L52:
        ItemTextArrow r69 = r13.c;
        String r70 = r12.X90(2131910789);
        int r71 = ItemTextArrow.k;
        r69.Z5(r70, null);
        goto L53
    L29:
        r17 = null;
    L143:
        if (r13 == null) goto L211;
        Collection<ItemTextArrow> r112 = r12.i.values();
        ArrayList r72 = new ArrayList();
        Iterator<T> r113 = r112.iterator();
    L146:
        if (r113.hasNext() == false) goto L154;
        Object r73 = r113.next();
        if (((ItemTextArrow) r73).getVisibility() != 0) goto L150;
        boolean r74 = true;
    L151:
        if (r74 == false) goto L146;
        r72.add(r73);
        goto L146
    L150:
        r74 = false;
        goto L151
    L154:
        if (r13.c.getVisibility() != 0) goto L156;
    L159:
        boolean r114 = true;
    L160:
        if (r114 == true) goto L163;
        r12.k = false;
        com.larus.utils.e1.x(r13.e);
        return;
    L163:
        if (r13.c.getVisibility() == 0) goto L165;
    L168:
        boolean r115 = true;
    L169:
        Iterator r75 = r72.iterator();
    L171:
        if (r75.hasNext() == false) goto L175;
        Object r76 = r75.next();
        if ((!Intrinsics.areEqual(((ItemTextArrow) r76).getSubTextView().getText(), r12.X90(2131910789))) == false) goto L171;
        r3 = r76;
    L175:
        if (r3 != null) goto L177;
        boolean r77 = true;
    L178:
        if (r115 == false) goto L194;
        if (r77 == false) goto L194;
        if (r13.c.getVisibility() != 0) goto L186;
        ItemTextArrow r116 = r13.c;
        Context r78 = r12.getContext();
        if (r78 == null) goto L286;
        r116.setSubTextColor(Integer.valueOf(ContextCompat.getColor(r78, v19.c.b(2130970996, r12.getContext(), 2131102650))));
        goto L186
    L286:
        return;
    L186:
        Iterator r117 = r72.iterator();
    L188:
        if (r117.hasNext() == false) goto L193;
        ItemTextArrow r79 = (ItemTextArrow) r117.next();
        Context r80 = r12.getContext();
        if (r80 == null) goto L288;
        r79.setSubTextColor(Integer.valueOf(ContextCompat.getColor(r80, v19.c.b(2130970996, r12.getContext(), 2131102650))));
        goto L188
    L288:
        return;
    L193:
        r12.k = true;
        com.larus.utils.e1.o(r13.e);
        return;
    L194:
        com.larus.utils.e1.x(r13.e);
        r12.k = false;
        if (r13.c.getVisibility() == 0) goto L197;
    L202:
        Iterator r118 = r72.iterator();
    L204:
        if (r118.hasNext() == false) goto L289;
        ItemTextArrow r119 = (ItemTextArrow) r118.next();
        if (Intrinsics.areEqual(r119.getSubTextView().getText(), r12.X90(2131910789)) == false) goto L204;
        Context r81 = r12.getContext();
        if (r81 == null) goto L290;
        r119.setSubTextColor(Integer.valueOf(ContextCompat.getColor(r81, v19.c.b(2130972123, r12.getContext(), 2131103203))));
        goto L204
    L290:
        return;
    L289:
        return;
    L197:
        if (Intrinsics.areEqual(r13.c.getSubTextView().getText(), r12.X90(2131910789)) == false) goto L202;
        ItemTextArrow r120 = r13.c;
        Context r121 = r12.getContext();
        if (r121 == null) goto L287;
        r120.setSubTextColor(Integer.valueOf(ContextCompat.getColor(r121, v19.c.b(2130972123, r12.getContext(), 2131103203))));
        goto L202
    L287:
        return;
    L177:
        r77 = false;
        goto L178
    L165:
        if (Intrinsics.areEqual(r13.c.getSubTextView().getText(), r12.X90(2131910789)) == true) goto L168;
        r115 = false;
        goto L169
    L156:
        if ((!r72.isEmpty()) == true) goto L159;
        r114 = false;
        goto L160
    L211:
        r12.getClass();
    }

    public final void Y90(boolean r10, String r11, String r12) {
        if (r10 == false) goto L5;
        r12 = null;
    L5:
        tx9.s1.a("setting", null, r10, r12, null, r11, "click_setting", this, 146);
    }

    public final void Z90(String r5, ItemTextArrow r6, Function0<Unit> r7) {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return;
    L6:
        if (getContext() != null) goto L8;
    L22:
        String r1 = "";
        String r2 = "";
    L23:
        CommonDialog.a r3 = new CommonDialog.a();
        r3.i(r1);
        r3.g(r2);
        CommonDialog.a.f(r3, new f(this, r5, r6, r7), X90(2131910872), false, 12);
        CommonDialog.a.e(r3, new g(), X90(2131899259), 4);
        U90(r3.b(ContextCompat.getColor(r0, v19.c.b(2130972079, r0, 2131103136))), getChildFragmentManager());
        return;
    L8:
        if (Intrinsics.areEqual(r5, o) == false) goto L11;
        r1 = X90(2131910864);
        r2 = X90(2131910863);
        goto L23
    L11:
        if (Intrinsics.areEqual(r5, n) == false) goto L14;
        r1 = X90(2131910869);
        r2 = X90(2131910867);
        goto L23
    L14:
        if (Intrinsics.areEqual(r5, p) == false) goto L17;
        r1 = X90(2131910866);
        r2 = X90(2131910865);
        goto L23
    L17:
        if (Intrinsics.areEqual(r5, q) == false) goto L20;
        r1 = X90(2131910862);
        r2 = X90(2131910861);
        goto L23
    L20:
        if (Intrinsics.areEqual(r5, r) == false) goto L22;
        r1 = X90(2131911199);
        r2 = X90(2131911198);
        goto L23
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        View r15 = r12.inflate(2131563068, r13, false);
        int r16 = 2131362015;
        ItemGroup r3 = ViewBindings.findChildViewById(r15, 2131362015);
        if (r3 == null) goto L124;
        r16 = 2131362016;
        if (ViewBindings.findChildViewById(r15, 2131362016) == null) goto L124;
        r16 = 2131362017;
        NovaTitleBarEx r17 = ViewBindings.findChildViewById(r15, 2131362017);
        if (r17 == null) goto L124;
        r16 = 2131362021;
        ItemTextArrow r5 = ViewBindings.findChildViewById(r15, 2131362021);
        if (r5 == null) goto L124;
        r16 = 2131362308;
        if (ViewBindings.findChildViewById(r15, 2131362308) == null) goto L124;
        r16 = 2131368924;
        ItemTextArrow r6 = ViewBindings.findChildViewById(r15, 2131368924);
        if (r6 == null) goto L124;
        LinearLayout r2 = (LinearLayout) r15;
        r16 = 2131385970;
        ItemTextView r7 = ViewBindings.findChildViewById(r15, 2131385970);
        if (r7 == null) goto L124;
        r16 = 2131385971;
        ItemTextView r8 = ViewBindings.findChildViewById(r15, 2131385971);
        if (r8 == null) goto L124;
        r16 = 2131385980;
        CardView r9 = ViewBindings.findChildViewById(r15, 2131385980);
        if (r9 == null) goto L124;
        this.f = new LarusPageSettingAccountInfoBinding(r2, r3, r17, r5, r6, r7, r8, r9);
        NovaTitleBarEx.Y5(r17, X90(2131899062), null, null, 6);
        NovaTitleBarEx.b6(r17, 2131241477, false, null, null, new y2(this), 14);
        final LarusPageSettingAccountInfoBinding r18 = this.f;
        if (r18 == null) goto L119;
        final Context r19 = getContext();
        if (r19 == null) goto L119;
        r18.e.setTextColor(ContextCompat.getColor(r19, v19.c.b(2130970996, r19, 2131102650)));
        r18.f.setTextColor(ContextCompat.getColor(r19, v19.c.b(2130970996, r19, 2131102650)));
        r18.f.setOnClickListener(new j2(this));
        if (ObricFeatureServiceDelegate.b.b() == true) goto L28;
    L30:
        r18.c.setOnClickListener(new u2(this, r18, r19));
        LinkedHashSet r110 = new LinkedHashSet();
        Iterator r4 = ((ArrayList) uj9.d.a(false, false)).iterator();
    L32:
        if (r4.hasNext() == false) goto L36;
        String r10 = (String) r4.next();
        String r11 = s.get(r10);
        if (r11 == null) goto L32;
        r110.add(r11);
        goto L32
    L36:
        SettingsAccountInfo r20 = IAccountService.a.w();
        if (r20 == null) goto L48;
        List r21 = r20.b();
        if (r21 == null) goto L48;
        Iterator r22 = r21.iterator();
    L42:
        if (r22.hasNext() == false) goto L48;
        SettingsConnectAccountInfo r23 = (SettingsConnectAccountInfo) r22.next();
        if (r23 == null) goto L42;
        String r24 = r23.a();
        if (r24 == null) goto L42;
        r110.add(r24);
    L48:
        Iterator r111 = r110.iterator();
    L49:
        boolean r25 = true;
        if (r111.hasNext() == false) goto L112;
        String r26 = (String) r111.next();
        if (Intrinsics.areEqual(r26, o) == true) goto L53;
        if (Intrinsics.areEqual(r26, n) == true) goto L65;
        if (Intrinsics.areEqual(r26, p) == true) goto L77;
        if (Intrinsics.areEqual(r26, q) == true) goto L89;
        if (Intrinsics.areEqual(r26, r) == false) goto L49;
        ILoginService r27 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r27 != null) goto L104;
    L106:
        r25 = false;
    L107:
        if (r25 == false) goto L49;
        ItemTextArrow r28 = W90(r26, X90(2131911191));
        if (r28 == null) goto L49;
        r28.setOnClickListener(new k2(this));
        goto L49
    L104:
        if (r27.C(LoginPlatform.WEIXIN) != true) goto L106;
    L89:
        ILoginService r29 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r29 != null) goto L92;
    L94:
        r25 = false;
    L95:
        if (r25 == false) goto L49;
        ItemTextArrow r30 = W90(r26, X90(2131898947));
        if (r30 == null) goto L49;
        r30.setOnClickListener(new c3(this));
        goto L49
    L92:
        if (r29.C(LoginPlatform.FACEBOOK) != true) goto L94;
    L77:
        ILoginService r31 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r31 != null) goto L80;
    L82:
        r25 = false;
    L83:
        if (r25 == false) goto L49;
        ItemTextArrow r32 = W90(r26, X90(2131898949));
        if (r32 == null) goto L49;
        r32.setOnClickListener(new b3(this));
        goto L49
    L80:
        if (r31.C(LoginPlatform.LINE) != true) goto L82;
    L65:
        ILoginService r33 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r33 != null) goto L68;
    L70:
        r25 = false;
    L71:
        if (r25 == false) goto L49;
        ItemTextArrow r34 = W90(r26, X90(2131898950));
        if (r34 == null) goto L49;
        r34.setOnClickListener(new a3(this));
        goto L49
    L68:
        if (r33.C(LoginPlatform.DOUYIN) != true) goto L70;
    L53:
        ILoginService r35 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r35 != null) goto L56;
    L58:
        r25 = false;
    L59:
        if (r25 == false) goto L49;
        ItemTextArrow r36 = W90(r26, X90(2131898948));
        if (r36 == null) goto L49;
        r36.setOnClickListener(new z2(this));
        goto L49
    L56:
        if (r35.C(LoginPlatform.GOOGLE) != true) goto L58;
    L112:
        if (IAccountService.a.w() == null) goto L115;
        r25 = false;
    L115:
        aa0(r25);
        r18.e.setOnClickListener(new v2(this, r19));
        e10 r112 = e10.a;
        if (((tv9.a) com.larus.utils.l0.a(new tv9.a(0), new kg())).a() == false) goto L118;
        com.larus.utils.e1.x(r18.g);
        com.larus.utils.e1.d(r18.d, new w2(r18));
        goto L119
    L118:
        com.larus.utils.e1.o(r18.g);
        goto L119
    L28:
        if (ObricAccountSPIServiceDelegate.b.h() == true) goto L30;
        r18.f.setVisibility(8);
    L119:
        this.j = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new x2(this));
        LarusPageSettingAccountInfoBinding r113 = this.f;
        if (r113 != null) goto L122;
        return null;
    L122:
        return r113.a;
    L124:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
