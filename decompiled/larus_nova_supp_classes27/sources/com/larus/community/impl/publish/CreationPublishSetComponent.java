package com.larus.community.impl.publish;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.community.impl.databinding.LarusCommunityCreationPublishSetLayoutBinding;
import com.larus.community.impl.publish.viewmodel.CreationPublishSetState;
import com.larus.community.impl.publish.viewmodel.CreationPublishSetViewModel;
import com.larus.community.impl.publish.viewmodel.CreationPublishShowImageState;
import com.larus.community.impl.publish.viewmodel.CreationPublishShowImageViewModel;
import com.larus.ugc.community.adapter.RefViewAdapter;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020*H\u0016J\u000f\u0010+\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0002\u0010-R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/community/impl/publish/CreationPublishSetComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/community/impl/publish/ability/ICreationPublishSetAbility;", "<init>", "()V", "fragmentViewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "getFragmentViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "fragmentViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishSetViewModel;", "getViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishSetViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "showImageViewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishShowImageViewModel;", "getShowImageViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishShowImageViewModel;", "showImageViewModel$delegate", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationPublishSetLayoutBinding;", "refViewAdapter", "Lcom/larus/ugc/community/adapter/RefViewAdapter;", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "initView", "initInfoIcon", "showInfoDialog", "initRefViews", "handlePublishInfoLoading", "buildPromptInfo", "", "publisherCreation", "Lcom/larus/platform/api/creation/PublisherCreation;", "handlePublishInfoValid", "isPublicOpen", "", "refImageCount", "", "()Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishSetComponent extends BaseContentWidget implements n29.c {
    public static final /* synthetic */ int r = 0;
    public final Lazy m;
    public final com.larus.ui.arch.vm.internal.l n;
    public final com.larus.ui.arch.vm.internal.l o;
    public LarusCommunityCreationPublishSetLayoutBinding p;
    public RefViewAdapter q;

    public static final class a implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public a(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class b implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public b(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return s1a.a.c(this.a);
        }
    }

    public static final class c implements Function0<ViewModelProvider.Factory> {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public static final class d implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public d(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class e implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public e(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return s1a.a.c(this.a);
        }
    }

    public static final class f implements Function0<ViewModelProvider.Factory> {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    @Override // n29.c
    public final boolean d30() {
        return ((CreationPublishSetState) ((CreationPublishSetViewModel) this.n.getValue()).getState()).isChecked();
    }

    @Override // n29.c
    public final Integer o30() {
        RefViewAdapter r0 = this.q;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getItemCount());
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).c(this, n29.c.class);
    }

    public CreationPublishSetComponent() {
        this.m = LazyKt.lazy(new s(this));
        this.n = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CreationPublishSetViewModel.class), Reflection.getOrCreateKotlinClass(CreationPublishSetState.class), new a(this), new b(this), c.a);
        this.o = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CreationPublishShowImageViewModel.class), Reflection.getOrCreateKotlinClass(CreationPublishShowImageState.class), new d(this), new e(this), f.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        View r1 = F2();
        if ((r1 instanceof FrameLayout) == false) goto L5;
        ViewGroup r2 = (FrameLayout) r1;
    L6:
        if (r2 == null) goto L32;
        View r3 = LayoutInflater.from(getContext()).inflate(2131561967, r2, false);
        r2.addView(r3);
        int r4 = 2131366848;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r3, 2131366848);
        if (r7 == null) goto L31;
        r4 = 2131366887;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r3, 2131366887);
        if (r8 == null) goto L31;
        r4 = 2131369159;
        View r9 = ViewBindings.findChildViewById(r3, 2131369159);
        if (r9 == null) goto L31;
        r4 = 2131376314;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r3, 2131376314);
        if (r10 == null) goto L31;
        r4 = 2131379092;
        View r11 = ViewBindings.findChildViewById(r3, 2131379092);
        if (r11 == null) goto L31;
        r4 = 2131379093;
        View r12 = ViewBindings.findChildViewById(r3, 2131379093);
        if (r12 == null) goto L31;
        r4 = 2131384998;
        RecyclerView r13 = ViewBindings.findChildViewById(r3, 2131384998);
        if (r13 == null) goto L31;
        r4 = 2131389030;
        CustomSwitchCompat r14 = ViewBindings.findChildViewById(r3, 2131389030);
        if (r14 == null) goto L31;
        r4 = 2131390460;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r3, 2131390460);
        if (r15 == null) goto L31;
        r4 = 2131391200;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r3, 2131391200);
        if (r16 == null) goto L31;
        r4 = 2131392500;
        View r17 = ViewBindings.findChildViewById(r3, 2131392500);
        if (r17 == null) goto L31;
        this.p = new LarusCommunityCreationPublishSetLayoutBinding((RoundConstraintLayout) r3, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r4)));
    L32:
        LarusCommunityCreationPublishSetLayoutBinding r5 = this.p;
        if (r5 == null) goto L37;
        ImageView r6 = r5.e;
        if (r6 == null) goto L37;
        r6.setOnClickListener(new p(this));
    L37:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationPublishSetComponent$initView$1(this, null), 3, null);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
