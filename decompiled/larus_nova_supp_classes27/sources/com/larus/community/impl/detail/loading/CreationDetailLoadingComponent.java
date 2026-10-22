package com.larus.community.impl.detail.loading;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.community.impl.detail.CreationDetailFragment;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.ui.arch.vm.internal.l;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.j1;
import tx9.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H\u0016J\u001a\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020&H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/larus/community/impl/detail/loading/CreationDetailLoadingComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "<init>", "()V", "viewModel", "Lcom/larus/community/impl/detail/loading/CreationDetailLoadingViewModel;", "getViewModel", "()Lcom/larus/community/impl/detail/loading/CreationDetailLoadingViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "_currentStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/platform/api/creation/UserCreation;", "creationLoadingState", "Lkotlinx/coroutines/flow/StateFlow;", "userCreationDataWrap", "Lcom/larus/community/impl/detail/model/UserCreationDataWrap;", "getUserCreationDataWrap", "()Lcom/larus/community/impl/detail/model/UserCreationDataWrap;", "userCreationDataWrap$delegate", "Lkotlin/Lazy;", "creationTrackParams", "Lcom/larus/platform/api/creation/CreationFeedTrackParams;", "getCreationTrackParams", "()Lcom/larus/platform/api/creation/CreationFeedTrackParams;", "creationTrackParams$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "onAttach", "observer", "getCreationLoadingState", "mobEnterTemplateDetail", "userCreation", FlowDoraConnectReason.SUCCESS, "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailLoadingComponent extends BaseContentWidget implements com.larus.community.impl.detail.loading.a {
    public static final /* synthetic */ int r = 0;
    public final l m;
    public final StateFlowImpl n;
    public final b1 o;
    public final Lazy p;
    public final Lazy q;

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
            return this.a;
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

    public final zp9.g Y2() {
        return (zp9.g) this.q.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.community.impl.detail.loading.a.class);
    }

    public CreationDetailLoadingComponent() {
        this.m = new l(Reflection.getOrCreateKotlinClass(CreationDetailLoadingViewModel.class), Reflection.getOrCreateKotlinClass(CreationLoadingState.class), new a(this), new b(this), c.a);
        StateFlowImpl r0 = j1.a(new UserCreation(null, 0, null, null, 131071));
        this.n = r0;
        CoroutineScope r7 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        g1.a.getClass();
        this.o = kotlinx.coroutines.flow.e.F(r0, r7, g1.a.c, new UserCreation(null, 0, null, null, 131071));
        this.p = LazyKt.lazy(new com.larus.community.impl.detail.loading.c(this));
        this.q = LazyKt.lazy(new d(this));
    }

    @Override // com.larus.community.impl.detail.loading.a
    public final b1 tb() {
        return this.o;
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [com.larus.community.impl.detail.loading.b, java.lang.Object] */
    public final void onViewCreated(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        j29.c r9 = (j29.c) this.p.getValue();
        UserCreation r0 = null;
        if (r9 == null) goto L7;
        UserCreation r10 = r9.a;
        if (r10 == null) goto L7;
        UserCreationContent r11 = r10.e;
    L8:
        if (r11 == null) goto L15;
        e1.o(F2());
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof CreationDetailFragment) == false) goto L27;
        j29.c r12 = (j29.c) this.p.getValue();
        if (r12 == null) goto L14;
        r0 = r12.a;
    L14:
        h3(r0, true);
        return;
    L27:
        return;
    L15:
        Object r13 = F2();
        if ((r13 instanceof CreationDetailLoadingView) == false) goto L18;
        CreationDetailLoadingView r14 = (CreationDetailLoadingView) r13;
    L19:
        if (r14 == null) goto L21;
        final ?? r1 = new com.larus.community.impl.detail.loading.b(this);
        Intrinsics.checkNotNullParameter(r1, "retryAction");
        r14.a.b.setOnClickListener(new e(r1));
    L21:
        CreationDetailLoadingViewModel r15 = (CreationDetailLoadingViewModel) this.m.getValue();
        j29.c r2 = (j29.c) this.p.getValue();
        if (r2 == null) goto L24;
        String r3 = r2.b;
    L25:
        r15.init(String.valueOf(r3));
        ComponentViewModel.onEach$default((CreationDetailLoadingViewModel) this.m.getValue(), null, null, new CreationDetailLoadingComponent$observer$1(this, null), 3, null);
        return;
    L24:
        r3 = null;
        goto L25
    L18:
        r14 = null;
    L7:
        r11 = null;
        goto L8
    }

    public final void h3(UserCreation r37, boolean r38) {
        zp9.g r1 = Y2();
        if (r1 == null) goto L6;
        String r2 = r1.c;
        if (r2 == null) goto L6;
    L7:
        String r3 = r2;
        if (r37 == null) goto L10;
        String r4 = r37.a;
    L11:
        if (r37 == null) goto L13;
        String r5 = zp9.d.d(r37);
    L14:
        if (r37 == null) goto L16;
        String r6 = zp9.d.c(r37);
    L17:
        if (r37 == null) goto L21;
        UserCreationTrackParams r7 = r37.n;
        if (r7 == null) goto L21;
        String r10 = r7.a;
    L22:
        zp9.g r8 = Y2();
        if (r8 == null) goto L25;
        Integer r15 = r8.e;
    L26:
        zp9.g r9 = Y2();
        if (r9 == null) goto L29;
        String r21 = r9.d;
    L30:
        zp9.g r11 = Y2();
        if (r11 == null) goto L33;
        String r14 = r11.f;
    L34:
        zp9.g r12 = Y2();
        if (r12 == null) goto L37;
        String r13 = r12.j;
    L38:
        if (r37 == null) goto L40;
        String r16 = zp9.d.b(r37);
    L41:
        if (r37 == null) goto L43;
        Long r17 = r37.f;
    L44:
        if (r37 == null) goto L48;
        AuthorInfo r18 = r37.g;
        if (r18 == null) goto L48;
        String r20 = r18.b;
    L49:
        if (r37 == null) goto L53;
        UserCreationTrackParams r22 = r37.n;
        if (r22 == null) goto L53;
        Integer r23 = r22.b;
    L54:
        zp9.g r110 = Y2();
        if (r110 == null) goto L57;
        String r111 = r110.a;
    L58:
        zp9.g r112 = Y2();
        if (r112 == null) goto L61;
        String r24 = r112.h;
    L62:
        zp9.g r113 = Y2();
        if (r113 == null) goto L65;
        String r114 = r113.i;
    L66:
        zp9.g r115 = Y2();
        if (r115 == null) goto L69;
        String r210 = r115.q;
    L70:
        zp9.g r116 = Y2();
        if (r116 == null) goto L73;
        String r30 = r116.r;
    L74:
        zp9.g r117 = Y2();
        if (r117 == null) goto L77;
        String r31 = r117.s;
    L78:
        if (r37 == null) goto L82;
        UserCreationTrackParams r118 = r37.n;
        if (r118 == null) goto L82;
        String r119 = r118.f;
    L83:
        if (r37 == null) goto L87;
        UserCreationTrackParams r120 = r37.n;
        if (r120 == null) goto L87;
        String r121 = r120.d;
    L88:
        if (r37 == null) goto L92;
        UserCreationTrackParams r122 = r37.n;
        if (r122 == null) goto L92;
        String r123 = r122.e;
    L93:
        if (r37 == null) goto L95;
        String r25 = r37.i;
    L96:
        if (r37 == null) goto L98;
        String r26 = zp9.d.c(r37);
    L99:
        if (r37 == null) goto L101;
        Boolean r27 = Boolean.valueOf(r37.D());
    L102:
        if (r37 == null) goto L108;
        UserCreationRefContent r124 = r37.o;
        if (r124 == null) goto L108;
        List r125 = r124.a();
        if (r125 == null) goto L108;
        Integer r28 = Integer.valueOf(r125.size());
    L109:
        if (r37 == null) goto L111;
        Boolean r211 = Boolean.valueOf(r37.z());
    L112:
        if (r37 == null) goto L114;
        String r212 = zp9.d.e(r37);
    L115:
        if (r37 == null) goto L119;
        UserCreationTrackParams r0 = r37.n;
        if (r0 == null) goto L119;
        Integer r126 = r0.c;
    L120:
        zp9.g r32 = Y2();
        if (r32 == null) goto L123;
        String r33 = r32.n;
    L124:
        zp9.g r34 = Y2();
        if (r34 == null) goto L127;
        String r35 = r34.o;
    L128:
        u3.g(r3, r4, r5, r6, r20, r16, r17, r23, r10, r114, r13, r126, r14, r15, r121, r119, r123, r111, r24, r21, Boolean.valueOf(r38), r25, r26, r27, r28, r211, r212, r210, r30, r31, r33, r35, 2048, 6);
        return;
    L127:
        r35 = null;
        goto L128
    L123:
        r33 = null;
    L119:
        r126 = null;
        goto L120
    L114:
        r212 = null;
        goto L115
    L111:
        r211 = null;
    L108:
        r28 = null;
        goto L109
    L101:
        r27 = null;
        goto L102
    L98:
        r26 = null;
        goto L99
    L95:
        r25 = null;
    L92:
        r123 = null;
    L87:
        r121 = null;
    L82:
        r119 = null;
        goto L83
    L77:
        r31 = null;
        goto L78
    L73:
        r30 = null;
        goto L74
    L69:
        r210 = null;
        goto L70
    L65:
        r114 = null;
        goto L66
    L61:
        r24 = null;
        goto L62
    L57:
        r111 = null;
    L53:
        r23 = null;
    L48:
        r20 = null;
        goto L49
    L43:
        r17 = null;
        goto L44
    L40:
        r16 = null;
        goto L41
    L37:
        r13 = null;
        goto L38
    L33:
        r14 = null;
        goto L34
    L29:
        r21 = null;
        goto L30
    L25:
        r15 = null;
    L21:
        r10 = null;
        goto L22
    L16:
        r6 = null;
        goto L17
    L13:
        r5 = null;
        goto L14
    L10:
        r4 = null;
    L6:
        r2 = "";
        goto L7
    }
}
