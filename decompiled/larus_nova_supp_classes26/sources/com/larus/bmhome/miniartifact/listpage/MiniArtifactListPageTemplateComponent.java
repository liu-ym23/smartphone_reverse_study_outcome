package com.larus.bmhome.miniartifact.listpage;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.keva.Keva;
import com.larus.bmhome.miniartifact.input.MiniArtifactInputComponent;
import com.larus.bmhome.miniartifact.listpage.adapter.MiniArtifactDoubleColumnAdapter;
import com.larus.bmhome.miniartifact.listpage.adapter.MiniArtifactGridSpacingItemDecoration;
import com.larus.bmhome.miniartifact.listpage.request.ApplicationTemplate;
import com.larus.bmhome.miniartifact.listpage.request.MiniAppTemplateChooseState;
import com.larus.bmhome.miniartifact.listpage.request.MiniArtifactListPageViewModel;
import com.larus.bmhome.miniartifact.listpage.request.PageStatus;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.api.miniartifact.MiniArtifactInputContent;
import com.larus.mainbot.api.miniartifact.MiniArtifactListPageParams;
import com.larus.mainbot.api.miniartifact.MiniArtifactTemplateParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.t0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001F\u0018\u0000 P2\u00060\u0001j\u0002`\u0002:\u0001PB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0002J\b\u00103\u001a\u00020\u0015H\u0002J\b\u00104\u001a\u00020*H\u0002J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020*H\u0002J\b\u00107\u001a\u00020*H\u0002J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0002J\b\u0010:\u001a\u00020*H\u0002J\b\u0010;\u001a\u00020*H\u0002J\b\u0010<\u001a\u00020*H\u0002J\b\u0010=\u001a\u00020*H\u0002J\u0010\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020*H\u0002J\b\u0010B\u001a\u00020*H\u0002J\b\u0010C\u001a\u00020*H\u0002J\b\u0010D\u001a\u00020*H\u0002J\b\u0010H\u001a\u00020*H\u0002J\b\u0010I\u001a\u00020*H\u0016J\u0018\u0010J\u001a\u00020*2\u0006\u0010K\u001a\u00020\u00152\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020*2\u0006\u0010O\u001a\u00020\u0015H\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010G¨\u0006Q"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/MiniArtifactListPageTemplateComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "<init>", "()V", "emptyView", "Landroid/view/View;", "emptyHintTextView", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tvTitle", "ivBack", "Landroid/widget/ImageView;", "tvMyArtifacts", "loadingView", "Lcom/larus/common_ui/widget/LoadingWithRetryView;", "inputViewGroup", "adapter", "Lcom/larus/bmhome/miniartifact/listpage/adapter/MiniArtifactDoubleColumnAdapter;", "lastParentWidth", "", "itemWidth", "miniArtifactListPageViewModel", "Lcom/larus/bmhome/miniartifact/listpage/request/MiniArtifactListPageViewModel;", "getMiniArtifactListPageViewModel", "()Lcom/larus/bmhome/miniartifact/listpage/request/MiniArtifactListPageViewModel;", "miniArtifactListPageViewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "spanCount", "contentViewId", "getContentViewId", "()I", "setContentViewId", "(I)V", "onViewCreated", "", "view", "tryChangeSpanCount", "initExposeX", "setupBackButton", "trackMyArtifactsClick", "setupMyArtifacts", "onLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "calculateInitWidth", "renderLoading", "renderSuccess", "initRender", "subscribeEmptyHint", "subscribeMyArtifactTitle", "subscribeTitle", "renderFail", "putInputComponentData", "renderEmpty", "subscribePageStatus", "setupViesFromPageStatus", "it", "Lcom/larus/bmhome/miniartifact/listpage/request/PageStatus;", "tryShowMyArtifactGuideTip", "setupRenderList", "subscribeTemplateList", "updateInputVisibility", "listener", "com/larus/bmhome/miniartifact/listpage/MiniArtifactListPageTemplateComponent$listener$1", "Lcom/larus/bmhome/miniartifact/listpage/MiniArtifactListPageTemplateComponent$listener$1;", "setupRecyclerView", "onDestroy", "setOnItemClick", "index", "applicationTemplate", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "updateItemSize", "parentWidth", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactListPageTemplateComponent extends BaseContentWidget {
    public static final Lazy<Integer> D = null;
    public static final Lazy<Integer> E = null;
    public int A;
    public final j B;
    public final c C;
    public View m;
    public TextView n;
    public RecyclerView o;
    public TextView p;
    public ImageView q;
    public TextView r;
    public LoadingWithRetryView s;
    public View t;
    public MiniArtifactDoubleColumnAdapter u;
    public int v;
    public int w;
    public final com.larus.ui.arch.vm.internal.l x;
    public final Lazy y;
    public int z;

    public static final class a {
        public static final int a() {
            Lazy<Integer> r0 = MiniArtifactListPageTemplateComponent.D;
            return ((Number) MiniArtifactListPageTemplateComponent.D.getValue()).intValue();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PageStatus.values().length];
            r0[PageStatus.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PageStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PageStatus.EMPTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PageStatus.FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements s09.b {
        public final /* synthetic */ MiniArtifactListPageTemplateComponent a;

        public final String getUniqueId() {
            return "mini_artifact";
        }

        public final void onFailure() {
        }

        public c(MiniArtifactListPageTemplateComponent r1) {
            this.a = r1;
        }

        public final void a(s09.a r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            final MiniArtifactListPageTemplateComponent r3 = this.a;
            t0.c(new s(r3));
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
            return s1a.a.getActivity(this.a);
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

    static {
        new a();
        D = LazyKt.lazy(new m());
        E = LazyKt.lazy(new n());
    }

    public final MiniArtifactListPageViewModel Y2() {
        return (MiniArtifactListPageViewModel) this.x.getValue();
    }

    public final void onDestroy() {
        RecyclerView r0 = this.o;
        if (r0 == null) goto L5;
        ExposeXTrackerExtKt.e(r0);
    L5:
        RecyclerView r1 = this.o;
        if (r1 == null) goto L8;
        r1.removeOnLayoutChangeListener(this.B);
    L8:
        PollingConfigService.a.i(this.C);
    }

    public final void p3() {
        int r0 = MiniArtifactInputComponent.A;
        boolean r1 = !MiniArtifactInputComponent.a.a();
        FLogger.a.i("MiniArtifactListPage", "updateInputVisibility, inputDowngradeKeepNormal:" + r1);
        View r2 = this.t;
        if (r2 == null) goto L8;
        if (r1 == false) goto L6;
        int r3 = 0;
    L7:
        r2.setVisibility(r3);
        goto L8
    L6:
        r3 = 8;
    L8:
        if (r1 == false) goto L12;
        RecyclerView r4 = this.o;
        if (r4 == null) goto L16;
        r4.setPadding(0, 0, 0, c7.b(80));
        return;
    L16:
        return;
    L12:
        RecyclerView r5 = this.o;
        if (r5 == null) goto L18;
        r5.setPadding(0, 0, 0, 0);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.bmhome.miniartifact.listpage.j] */
    public MiniArtifactListPageTemplateComponent() {
        this.x = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(MiniArtifactListPageViewModel.class), Reflection.getOrCreateKotlinClass(MiniAppTemplateChooseState.class), new d(this), new e(this), f.a);
        this.y = LazyKt.lazy(new g());
        this.z = 2;
        this.A = 2131384813;
        this.B = new j(this);
        this.C = new c(this);
    }

    public final void m3() {
        MiniArtifactListPageParams r0 = s1a.d.a(this).a(MiniArtifactListPageParams.class);
        String r1 = null;
        if (r0 == null) goto L5;
        Map r2 = r0.getTrackParams();
    L6:
        int r3 = ar8.a.a;
        if (r2 == null) goto L9;
        String r4 = ar8.b.c(r2);
    L10:
        Intrinsics.checkNotNullParameter(this, "<this>");
        TraceFragment r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r5 instanceof TraceFragment) == false) goto L13;
        TraceFragment r6 = r5;
    L14:
        if (r6 == null) goto L16;
        String r7 = r6.k();
    L17:
        if (r2 == null) goto L19;
        r1 = ar8.b.e(r2);
    L19:
        JSONObject r8 = new JSONObject();
        if (r7 == null) goto L22;
        r8.put("current_page", r7);
    L22:
        if (r1 == null) goto L24;
        r8.put("previous_page", r1);
    L24:
        if (r4 == null) goto L26;
        r8.put("enter_method", r4);
    L26:
        com.larus.platform.service.o.a.reportEvent("ai_code_my_artifact_entrance_click", r8);
        return;
    L16:
        r7 = null;
        goto L17
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final int U2() {
        return this.A;
    }

    public final void X2(int r1) {
        this.A = r1;
    }

    public final void h3(PageStatus r20) {
        int r1 = b.a[r20.ordinal()];
        if (r1 != 1) goto L5;
        FLogger.a.i("MiniArtifactListPage", "renderLoading");
        LoadingWithRetryView r2 = this.s;
        if (r2 == null) goto L65;
        e1.x(r2);
    L65:
        LoadingWithRetryView r3 = this.s;
        if (r3 == null) goto L68;
        r3.b();
    L68:
        RecyclerView r4 = this.o;
        if (r4 == null) goto L77;
        e1.o(r4);
        return;
    L77:
        return;
    L5:
        if (r1 != 2) goto L7;
        FLogger.a.i("MiniArtifactListPage", "renderSuccess");
        LoadingWithRetryView r5 = this.s;
        if (r5 == null) goto L39;
        e1.o(r5);
    L39:
        p3();
        RecyclerView r6 = this.o;
        if (r6 == null) goto L42;
        e1.x(r6);
    L42:
        View r7 = this.m;
        if (r7 == null) goto L45;
        e1.o(r7);
    L45:
        Intrinsics.checkNotNullParameter(this, "<this>");
        t1a.b r8 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        String r10 = Y2().getInputEntranceUrl();
        Intrinsics.checkNotNullParameter(this, "<this>");
        MiniArtifactListPageParams r9 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).a(MiniArtifactListPageParams.class);
        if (r9 == null) goto L48;
        Map r11 = r9.getTrackParams();
    L49:
        r8.n(new MiniArtifactTemplateParams(new MiniArtifactInputContent(null, null, null, null, r11, 15, null), null, null, null, r10, null, 46, null), MiniArtifactTemplateParams.class);
        Lazy r12 = ik9.b.a;
        if (((Keva) r12.getValue()).getBoolean("key_show_my_artifact_guide_tip", false) == true) goto L78;
        final TextView r13 = this.r;
        if (r13 == null) goto L79;
        final String r14 = Y2().getTipTitle();
        if (r14 == null) goto L80;
        final String r15 = Y2().getTipSubTitle();
        if (r15 != null) goto L61;
        r15 = "";
    L61:
        t0.d(new p(this, r13, r14, r15), 100);
        ((Keva) r12.getValue()).storeBoolean("key_show_my_artifact_guide_tip", true);
        return;
    L80:
        return;
    L79:
        return;
    L78:
        return;
    L48:
        r11 = null;
        goto L49
    L7:
        if (r1 != 3) goto L9;
        FLogger.a.i("MiniArtifactListPage", "renderEmpty");
        LoadingWithRetryView r16 = this.s;
        if (r16 == null) goto L27;
        e1.o(r16);
    L27:
        View r17 = this.t;
        if (r17 == null) goto L30;
        e1.o(r17);
    L30:
        RecyclerView r18 = this.o;
        if (r18 == null) goto L33;
        e1.o(r18);
    L33:
        View r19 = this.m;
        if (r19 == null) goto L74;
        e1.x(r19);
        return;
    L74:
        return;
    L9:
        if (r1 != 4) goto L23;
        FLogger.a.i("MiniArtifactListPage", "renderFail");
        LoadingWithRetryView r21 = this.s;
        if (r21 == null) goto L13;
        r21.c(2131906531);
    L13:
        LoadingWithRetryView r22 = this.s;
        if (r22 == null) goto L16;
        r22.setOnRetryListener(new q(this));
    L16:
        View r23 = this.t;
        if (r23 == null) goto L19;
        e1.o(r23);
    L19:
        RecyclerView r24 = this.o;
        if (r24 == null) goto L72;
        e1.o(r24);
        return;
    L72:
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.bmhome.miniartifact.listpage.l] */
    public final void onViewCreated(View r20) {
        Intrinsics.checkNotNullParameter(r20, "view");
        Intrinsics.checkNotNullParameter(r20, "view");
        this.m = r20.findViewById(2131371607);
        this.o = r20.findViewById(2131380136);
        this.s = r20.findViewById(2131379091);
        this.q = (ImageView) r20.findViewById(2131375900);
        this.t = r20.findViewById(2131365588);
        this.r = (TextView) r20.findViewById(2131390051);
        this.n = (TextView) r20.findViewById(2131371579);
        this.p = (TextView) r20.findViewById(2131390084);
        if (c7.d(Integer.valueOf(com.larus.utils.i.d(getContext()))) <= 500.0f) goto L5;
        this.z = 3;
    L5:
        TextView r1 = this.n;
        if (r1 == null) goto L8;
        r1.setText(Y2().getTemplateEmptyHint());
    L8:
        TextView r2 = this.r;
        if (r2 == null) goto L11;
        r2.setText(Y2().getMyArtifactTitle());
    L11:
        TextView r3 = this.p;
        if (r3 == null) goto L14;
        r3.setText(Y2().getTemplatePageTitle());
    L14:
        ImageView r4 = this.q;
        if (r4 == null) goto L17;
        r4.setOnClickListener(new o(this));
    L17:
        StaggeredGridLayoutManager r5 = new StaggeredGridLayoutManager(this.z, 1);
        r5.setGapStrategy(0);
        RecyclerView r6 = this.o;
        if (r6 == null) goto L20;
        r6.setLayoutManager(r5);
    L20:
        RecyclerView r7 = this.o;
        if (r7 == null) goto L23;
        r7.setHasFixedSize(true);
    L23:
        this.u = new MiniArtifactDoubleColumnAdapter(new l(this));
        RecyclerView r8 = this.o;
        if (r8 == null) goto L26;
        Integer r9 = Integer.valueOf(r8.getWidth());
    L27:
        if (r9 == null) goto L39;
        RecyclerView r10 = this.o;
        if (r10 != null) goto L31;
    L33:
        boolean r11 = false;
    L34:
        if (r11 == true) goto L39;
        RecyclerView r12 = this.o;
        if (r12 == null) goto L38;
        int r13 = r12.getWidth();
    L40:
        z3(r13);
        RecyclerView r14 = this.o;
        if (r14 == null) goto L43;
        r14.setAdapter(this.u);
    L43:
        RecyclerView r15 = this.o;
        if (r15 == null) goto L55;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L55;
        if ((r16 instanceof FrameLayout.LayoutParams) == false) goto L50;
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r16;
    L51:
        if (r17 == null) goto L55;
        r17.setMarginStart(a.a());
        r17.setMarginEnd(a.a());
        RecyclerView r18 = this.o;
        if (r18 == null) goto L55;
        r18.setLayoutParams(r17);
        goto L55
    L50:
        r17 = null;
    L55:
        RecyclerView r19 = this.o;
        if (r19 == null) goto L58;
        r19.addItemDecoration(new MiniArtifactGridSpacingItemDecoration(this.z, ((Number) E.getValue()).intValue()));
    L58:
        RecyclerView r21 = this.o;
        if (r21 == null) goto L61;
        r21.addOnLayoutChangeListener(this.B);
    L61:
        TextView r22 = this.r;
        if (r22 == null) goto L64;
        r22.setOnClickListener(new k(this));
    L64:
        ComponentViewModel.onEach$default(Y2(), MiniArtifactListPageTemplateComponent$subscribePageStatus$1.INSTANCE, null, new MiniArtifactListPageTemplateComponent$subscribePageStatus$2(this, null), 2, null);
        h3(((MiniAppTemplateChooseState) Y2().getState()).getPageStatus());
        List<ApplicationTemplate> r23 = ((MiniAppTemplateChooseState) Y2().getState()).getCurrentRenderTemplateList();
        MiniArtifactDoubleColumnAdapter r24 = this.u;
        if (r24 == null) goto L69;
        if (r23 != null) goto L68;
        r23 = CollectionsKt.emptyList();
    L68:
        Intrinsics.checkNotNullParameter(r23, "items");
        r24.b = r23;
        r24.notifyDataSetChanged();
    L69:
        ComponentViewModel.onEach$default(Y2(), MiniArtifactListPageTemplateComponent$subscribeEmptyHint$1.INSTANCE, null, new MiniArtifactListPageTemplateComponent$subscribeEmptyHint$2(this, null), 2, null);
        ComponentViewModel.onEach$default(Y2(), MiniArtifactListPageTemplateComponent$subscribeMyArtifactTitle$1.INSTANCE, null, new MiniArtifactListPageTemplateComponent$subscribeMyArtifactTitle$2(this, null), 2, null);
        ComponentViewModel.onEach$default(Y2(), MiniArtifactListPageTemplateComponent$subscribeTitle$1.INSTANCE, null, new MiniArtifactListPageTemplateComponent$subscribeTitle$2(this, null), 2, null);
        ComponentViewModel.onEach$default(Y2(), MiniArtifactListPageTemplateComponent$subscribeTemplateList$1.INSTANCE, null, new MiniArtifactListPageTemplateComponent$subscribeTemplateList$2(this, null), 2, null);
        RecyclerView r25 = this.o;
        if (r25 == null) goto L72;
        ExposeXTrackerExtKt.c(r25);
    L72:
        MiniArtifactListPageViewModel.fetchMiniAppListPage$default(Y2(), false, 1, null);
        PollingConfigService.a.j(this.C);
        return;
    L38:
        r13 = 0;
        goto L40
    L31:
        if (r10.getWidth() != 0) goto L33;
        r11 = true;
    L39:
        int r26 = m0.a;
        r13 = m0.b(getContext());
        goto L40
    L26:
        r9 = null;
        goto L27
    }

    public final void z3(int r5) {
        int r0 = this.w;
        if (r5 <= 0) goto L6;
        this.w = ((r5 - (a.a() * 2)) - ((this.z - 1) * ((Number) E.getValue()).intValue())) / this.z;
    L6:
        if (r0 == this.w) goto L14;
        MiniArtifactDoubleColumnAdapter r6 = this.u;
        if (r6 == null) goto L10;
        int r1 = this.w;
        Size r2 = new Size(r1, ((int) (r1 * 1.3333334f)) + ((Number) E.getValue()).intValue());
        Intrinsics.checkNotNullParameter(r2, "size");
        r6.c = r2;
    L10:
        MiniArtifactDoubleColumnAdapter r7 = this.u;
        if (r7 == null) goto L15;
        r7.notifyDataSetChanged();
        return;
    L15:
        return;
    }
}
