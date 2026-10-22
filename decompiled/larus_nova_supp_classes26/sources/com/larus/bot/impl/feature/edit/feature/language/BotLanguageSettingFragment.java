package com.larus.bot.impl.feature.edit.feature.language;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelectorSubTitle;
import com.larus.bot.impl.databinding.LarusPageBotLanguageSettingBinding;
import com.larus.home.impl.sdk.u2;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.v;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tx9.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J\u001a\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020\u001eH\u0002J\u0016\u00100\u001a\u00020\u001e2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001102H\u0002J\b\u00103\u001a\u00020\u001eH\u0002J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0011H\u0002J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u0011H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u0011H\u0002J\u000f\u0010;\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010<R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/language/BotLanguageSettingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusPageBotLanguageSettingBinding;", "viewModel", "Lcom/larus/bot/impl/feature/edit/feature/language/BotLanguageSettingViewModel;", "getViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/language/BotLanguageSettingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "trace", "Lcom/larus/bmhome/setting/IBotSettingTrace;", "uiMode", "", "initialLanguage", "Lcom/larus/bmhome/bot/bean/BotLanguage;", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "sourceCurrentPage", "", "searchStartTime", "", "currentBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "currentLanguage", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "onResume", "onPause", "reportSearchStayTime", "initView", "performBack", "initData", "renderLanguageList", "languageList", "", "renderInitialLanguage", "updateSelectedLanguage", "botLanguage", "buildLanguageItem", "Lcom/larus/bmhome/view/item/ItemTextSelectorSubTitle;", "data", "selectLanguageForUIMode", "language", "hideLoading", "()Lkotlin/Unit;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotLanguageSettingFragment extends Fragment {
    public static final /* synthetic */ int n = 0;
    public LarusPageBotLanguageSettingBinding d;
    public final Lazy e;
    public final com.larus.bmhome.setting.b f;
    public boolean g;
    public BotLanguage h;
    public SearchMobParam i;
    public String j;
    public long k;
    public BotModel l;
    public BotLanguage m;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final BotLanguageSettingViewModel S90() {
        return (BotLanguageSettingViewModel) this.e.getValue();
    }

    public final void onPause() {
        super.onPause();
        if (this.i != null) goto L5;
        return;
    L5:
        if (this.k == 0) goto L32;
        long r1 = SystemClock.elapsedRealtime() - this.k;
        BotModel r5 = S90().getBotInfo();
        String r6 = null;
        if (r5 == null) goto L10;
        String r7 = r5.getBotId();
    L11:
        String r8 = this.j;
        SearchMobParam r9 = this.i;
        if (r9 == null) goto L14;
        String r10 = r9.a;
    L15:
        if (r9 == null) goto L17;
        String r11 = r9.b;
    L18:
        if (r9 == null) goto L20;
        String r13 = r9.c;
    L21:
        if (r9 == null) goto L23;
        String r14 = r9.d;
    L24:
        if (r9 == null) goto L26;
        String r15 = r9.e;
    L27:
        if (r9 == null) goto L29;
        r6 = r9.f;
    L29:
        i3.h(r7, r8, Long.valueOf(r1), r10, r11, r6, r13, r14, r15, null, 3136);
        this.k = 0;
        return;
    L26:
        r15 = null;
        goto L27
    L23:
        r14 = null;
        goto L24
    L20:
        r13 = null;
        goto L21
    L17:
        r11 = null;
        goto L18
    L14:
        r10 = null;
        goto L15
    L10:
        r7 = null;
        goto L11
    }

    public BotLanguageSettingFragment() {
        final Function0<Fragment> r0 = new BotLanguageSettingFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotLanguageSettingViewModel.class), new BotLanguageSettingFragment$special$$inlined$viewModels$default$2(r0), new BotLanguageSettingFragment$special$$inlined$viewModels$default$3(r0, this));
        this.f = IAIChatService.a.k8();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onResume() {
        super.onResume();
        if (this.i == null) goto L6;
        this.k = SystemClock.elapsedRealtime();
        return;
    }

    public final void zg() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L5;
        r0.setResult(100, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("select_language_result", this.l), TuplesKt.to("key_selected_language", this.m)})));
    L5:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        r1.finish();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.widget.LinearLayout, com.larus.bmhome.view.item.ItemGroup] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.ViewGroup, com.larus.bmhome.view.item.ItemTextSelectorSubTitle] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
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
    public final void T90(List<BotLanguage> r9) {
        FLogger.a.d("BotLanguageSettingFragment", "fetch languageList: " + r9);
        Iterator r0 = r9.iterator();
    L4:
        if (r0.hasNext() == false) goto L35;
        final BotLanguage r1 = (BotLanguage) r0.next();
        final ?? r2 = new ItemTextSelectorSubTitle(requireContext());
        String r3 = r1.d();
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        ?? r5 = 0;
    L22:
        if (r5 == 0) goto L4;
        if (Intrinsics.areEqual(r1, CollectionsKt.first(r9)) == false) goto L27;
        r5.setBackgroundResource(2131239212);
    L30:
        LarusPageBotLanguageSettingBinding r6 = this.d;
        if (r6 == null) goto L4;
        ?? r7 = r6.b;
        if (r7 == 0) goto L4;
        r7.addView(r5);
        goto L4
    L27:
        if (Intrinsics.areEqual(r1, CollectionsKt.last(r9)) == false) goto L29;
        r5.setBackgroundResource(2131239215);
        goto L30
    L29:
        r5.setBackgroundResource(2131239218);
        goto L30
    L14:
        r2.setTag(r1.c());
        String r8 = r1.d();
        String r10 = "";
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r2.setMainTitle(r8);
        r2.getBinding().c.setTextColor(ContextCompat.getColor(r2.getContext(), 2131103136));
        String r11 = r1.b();
        if (r11 == null) goto L21;
        r10 = r11;
    L21:
        r2.setSubTitle(r10);
        r2.getBinding().e.setTextColor(ContextCompat.getColor(r2.getContext(), 2131103143));
        r2.setSelected(false);
        r2.getBinding();
        r2.setOnClickListener(new g(this, r1, r2));
        r5 = r2;
        goto L22
    L8:
        if (r3.length() == 0) goto L11;
        r4 = false;
        goto L12
    }

    public final void U90(BotLanguage r5) {
        FLogger.a.d("BotLanguageSettingFragment", "current language: " + r5);
        LarusPageBotLanguageSettingBinding r0 = this.d;
        if (r0 == null) goto L8;
        Iterator r1 = ViewGroupKt.getChildren(r0.b).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        View r2 = (View) r1.next();
        r2.setSelected(Intrinsics.areEqual(r2.getTag(), r5.c()));
        goto L6
    L10:
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        BotLanguageSettingViewModel r5 = S90();
        Bundle r0 = getArguments();
        BotModel r1 = null;
        if (r0 == null) goto L5;
        Serializable r2 = r0.getSerializable("select_language_argument");
    L7:
        if ((r2 instanceof BotModel) == false) goto L9;
        r1 = (BotModel) r2;
    L9:
        r5.setBotInfo(r1);
        Bundle r6 = getArguments();
        if (r6 == null) goto L12;
        this.g = r6.getBoolean("key_ui_mode", false);
        this.h = r6.getParcelable("key_initial_language");
        this.i = r6.getParcelable("argSearchMobParam");
        this.j = r6.getString("source_current_page");
    L12:
        v.a(this, new com.larus.bot.impl.feature.edit.feature.language.b(this));
        return;
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LarusPageBotLanguageSettingBinding r10 = this.d;
        if (r10 == null) goto L9;
        NovaTitleBarEx r0 = r10.c;
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L7;
        r11.i();
        u2.a.b();
    L7:
        NovaTitleBarEx.Y5(r0, getString(2131906783), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new com.larus.bot.impl.feature.edit.feature.language.a(this), 14);
    L9:
        if (this.g == false) goto L26;
        e0 r12 = (e0) AuthModelDelegate.b.e().getValue();
        if (r12 == null) goto L29;
        LaunchInfo r13 = r12.a;
        if (r13 == null) goto L30;
        List r14 = r13.j();
        if (r14 == null) goto L20;
        List r15 = r14;
        List r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
    L18:
        if (r16.hasNext() == false) goto L21;
        com.larus.im.bean.bot.BotLanguage r2 = (com.larus.im.bean.bot.BotLanguage) r16.next();
        r1.add(new BotLanguage(r2.getLanguageCode(), r2.getLanguage(), r2.getLanguageLocal()));
    L21:
        if (r1 != 0) goto L23;
        r1 = CollectionsKt.emptyList();
    L23:
        T90(r1);
        BotLanguage r17 = this.h;
        if (r17 == null) goto L31;
        U90(r17);
        this.m = r17;
        this.h = null;
        return;
    L31:
        return;
    L20:
        r1 = 0;
        goto L21
    L30:
        return;
    L29:
        return;
    L26:
        S90().getLanguageList().observe(getViewLifecycleOwner(), new b(new c(this)));
        S90().getCurrentLanguage().observe(getViewLifecycleOwner(), new b(new d(this)));
        S90().getUpdatedBotInfo().observe(getViewLifecycleOwner(), new b(new e(this)));
        S90().getLanguageUpdate().observe(getViewLifecycleOwner(), new b(new f(this)));
        S90().getBotLanguageList();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131563004, r3, false);
        int r6 = 2131377148;
        ItemGroup r7 = (ItemGroup) ViewBindings.findChildViewById(r5, 2131377148);
        if (r7 == null) goto L11;
        r6 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r5, 2131385238)) == null) goto L11;
        r6 = 2131388772;
        NovaTitleBarEx r0 = (NovaTitleBarEx) ViewBindings.findChildViewById(r5, 2131388772);
        if (r0 == null) goto L11;
        LinearLayout r8 = (LinearLayout) r5;
        this.d = new LarusPageBotLanguageSettingBinding(r8, r7, r0);
        return r8;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
