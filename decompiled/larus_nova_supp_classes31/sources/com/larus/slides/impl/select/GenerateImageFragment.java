package com.larus.slides.impl.select;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.slides.biz.impl.databinding.LarusSlidesPageGenerateImageBinding;
import com.larus.slides.impl.select.widget.GenerateImageViewPagerContainer;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010-\u001a\u00020\"H\u0016J\b\u0010.\u001a\u00020\"H\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000202H\u0016J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020$J\b\u00105\u001a\u00020\"H\u0002J\n\u00106\u001a\u0004\u0018\u00010&H\u0002J\u000f\u00107\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00108J\u000f\u00109\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00108J\b\u0010:\u001a\u00020\"H\u0002J\u0017\u0010<\u001a\u0004\u0018\u00010\"2\u0006\u0010=\u001a\u00020>H\u0002¢\u0006\u0002\u0010?J\u0017\u0010@\u001a\u0004\u0018\u00010\"2\u0006\u0010A\u001a\u000200H\u0002¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020\"H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010;\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/larus/slides/impl/select/GenerateImageFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/slides/biz/impl/databinding/LarusSlidesPageGenerateImageBinding;", "viewModel", "Lcom/larus/slides/impl/select/IGenerateImageViewModel;", "getViewModel", "()Lcom/larus/slides/impl/select/IGenerateImageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "pictureSaveActionSheet", "Lcom/larus/slides/impl/select/PictureSaveActionSheet;", "adapter", "Lcom/larus/slides/impl/select/GenerateImageAdapter;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "chatParams", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParams", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParams$delegate", "slidesMobConfig", "Lcom/larus/platform/model/slides/SlidesMobConfig;", "getSlidesMobConfig", "()Lcom/larus/platform/model/slides/SlidesMobConfig;", "slidesMobConfig$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onDestroy", "autoLogEnterPage", "", "getCurrentPageName", "", "onResult", "data", "initView", "initTitle", "initBottomButtons", "()Lkotlin/Unit;", "initViewPager", "bindObservers", "hasAnyImageSucceeded", "refreshUIState", "state", "Lcom/larus/slides/impl/select/GenerateImageUIState;", "(Lcom/larus/slides/impl/select/GenerateImageUIState;)Lkotlin/Unit;", "updateConfirmButton", "enabled", "(Z)Lkotlin/Unit;", "performManualBack", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GenerateImageFragment extends TraceFragment {
    public static final /* synthetic */ int n = 0;
    public LarusSlidesPageGenerateImageBinding e;
    public final Lazy f;
    public PictureSaveActionSheet g;
    public GenerateImageAdapter h;
    public final Lazy i;
    public FragmentExtKt$addOnBackPressed$callback$1 j;
    public final Lazy k;
    public final Lazy l;
    public boolean m;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "";
    }

    public final lr9.a U90() {
        return (lr9.a) this.l.getValue();
    }

    public final t V90() {
        return (t) this.f.getValue();
    }

    public final void onDestroy() {
        FragmentExtKt$addOnBackPressed$callback$1 r0 = this.j;
        if (r0 == null) goto L5;
        r0.remove();
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public GenerateImageFragment() {
        final Function0<Fragment> r0 = new GenerateImageFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GenerateImageViewModel.class), new GenerateImageFragment$special$$inlined$viewModels$default$2(r0), new GenerateImageFragment$special$$inlined$viewModels$default$3(r0, this));
        this.i = LazyKt.lazy(new j(this));
        this.k = LazyKt.lazy(new k(this));
        this.l = LazyKt.lazy(new l(this));
    }

    public final void W90() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L5;
        r0.setResult(100, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("quit_ai_gen_process", Boolean.TRUE)})));
    L5:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L8;
        r1.finish();
    L8:
        lr9.a r2 = U90();
        String r3 = null;
        if (r2 == null) goto L11;
        String r4 = r2.e();
    L12:
        lr9.a r5 = U90();
        if (r5 == null) goto L15;
        String r6 = r5.f();
    L16:
        lr9.a r7 = U90();
        if (r7 == null) goto L19;
        Integer r8 = r7.g();
    L20:
        lr9.a r9 = U90();
        if (r9 == null) goto L23;
        String r10 = r9.b();
    L24:
        lr9.a r11 = U90();
        if (r11 == null) goto L27;
        Integer r12 = r11.c();
    L28:
        ChatParam r13 = (ChatParam) this.k.getValue();
        if (r13 == null) goto L31;
        String r14 = r13.a;
    L32:
        ChatParam r15 = (ChatParam) this.k.getValue();
        if (r15 == null) goto L35;
        String r16 = r15.b;
    L36:
        lr9.a r17 = U90();
        if (r17 == null) goto L39;
        String r18 = r17.d();
    L40:
        lr9.a r19 = U90();
        if (r19 == null) goto L43;
        r3 = r19.a();
    L43:
        tx9.a.a(r4, r6, r8, r10, r12, r3, r14, r16, r18, "cancel");
        return;
    L39:
        r18 = null;
        goto L40
    L35:
        r16 = null;
        goto L36
    L31:
        r14 = null;
        goto L32
    L27:
        r12 = null;
        goto L28
    L23:
        r10 = null;
        goto L24
    L19:
        r8 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L11:
        r4 = null;
        goto L12
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        V90().dispatchUIAction(new n.b(getArguments()));
        this.j = com.larus.utils.v.a(this, new f(this));
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        LarusSlidesPageGenerateImageBinding r14 = this.e;
        if (r14 == null) goto L10;
        NovaTitleBarEx r1 = r14.d;
        Context r2 = getContext();
        if (r2 == null) goto L8;
        String r3 = r2.getString(2131909813);
        if (r3 == null) goto L8;
    L9:
        NovaTitleBarEx.Y5(r1, r3, null, null, 6);
        NovaTitleBarEx.b6(r14.d, 2131243399, false, null, null, new e(this), 14);
    L8:
        r3 = "";
    L10:
        LarusSlidesPageGenerateImageBinding r15 = this.e;
        if (r15 == null) goto L13;
        e1.d(r15.b, new i(this));
        Unit r16 = Unit.INSTANCE;
    L13:
        LarusSlidesPageGenerateImageBinding r17 = this.e;
        if (r17 == null) goto L57;
        Bundle r4 = getArguments();
        if (r4 == null) goto L21;
        String r5 = r4.getString("gen_images_query_ratio", "");
        if (r5 == null) goto L21;
        String r6 = r5;
    L22:
        int r0 = 0;
        List r7 = StringsKt.split$default(r6, new String[]{":"}, false, 0, 6, null);     // Catch: Exception -> L41
        if (r7 != null) goto L27;
        r7 = CollectionsKt.emptyList();     // Catch: Exception -> L41
    L27:
        if (r7.size() < 2) goto L40;
        String r8 = (String) CollectionsKt.getOrNull(r7, 0);     // Catch: Exception -> L41
        if (r8 == null) goto L32;
        Integer r9 = StringsKt.toIntOrNull(r8);     // Catch: Exception -> L41
    L61:
        String r10 = (String) CollectionsKt.getOrNull(r7, 1);     // Catch: Exception -> L38
        if (r10 == null) goto L44;
        Integer r11 = StringsKt.toIntOrNull(r10);     // Catch: Exception -> L38
    L45:
        GenerateImageAdapter r18 = new GenerateImageAdapter(r9, r11);
        r18.d = new g(this);
        r18.e = new h(this);
        this.h = r18;
        r17.e.getViewPager().setAdapter(this.h);
        r17.e.getViewPager().setOffscreenPageLimit(3);
        r17.e.getViewPager().registerOnPageChangeCallback(new GenerateImageFragment$initViewPager$1$2(this));
        IndefinitePagerIndicator r19 = r17.c;
        ViewPager2 r110 = r17.e.getViewPager();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r110, "viewPager2");
        IndefinitePagerIndicator.InternalPageChangeCallback r20 = r19.b;
        if (r20 == null) goto L50;
        ViewPager2 r21 = r19.a;
        if (r21 == null) goto L50;
        r21.unregisterOnPageChangeCallback(r20);
    L50:
        r19.a = r110;
        IndefinitePagerIndicator.InternalPageChangeCallback r111 = new IndefinitePagerIndicator.InternalPageChangeCallback(r19);
        r19.b = r111;
        ViewPager2 r22 = r19.a;
        if (r22 == null) goto L53;
        r22.registerOnPageChangeCallback(r111);
    L53:
        ViewPager2 r112 = r19.a;
        if (r112 == null) goto L56;
        r0 = r112.getCurrentItem();
    L56:
        r19.l = r0;
        Unit r113 = Unit.INSTANCE;
    L44:
        r11 = null;
    L38:
        e = e;
    L43:
        FLogger.a.e("SlidesBgSelectFragment", "parse image ratio failed", e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        goto L44
    L32:
        r9 = null;
        goto L61
    L40:
        r11 = null;
        r9 = null;
    L41:
        e = e;
        r9 = null;
    L21:
        r6 = "";
    L57:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GenerateImageFragment$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(V90().getUiEvent(), new GenerateImageFragment$bindObservers$2(this, null)), LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()));
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131563141, r8, false);
        int r11 = 2131367647;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r10, 2131367647);
        if (r2 == null) goto L13;
        r11 = 2131375226;
        IndefinitePagerIndicator r3 = (IndefinitePagerIndicator) ViewBindings.findChildViewById(r10, 2131375226);
        if (r3 == null) goto L13;
        r11 = 2131388772;
        NovaTitleBarEx r4 = ViewBindings.findChildViewById(r10, 2131388772);
        if (r4 == null) goto L13;
        r11 = 2131392571;
        GenerateImageViewPagerContainer r5 = (GenerateImageViewPagerContainer) ViewBindings.findChildViewById(r10, 2131392571);
        if (r5 == null) goto L13;
        ConstraintLayout r12 = r10;
        this.e = new LarusSlidesPageGenerateImageBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
