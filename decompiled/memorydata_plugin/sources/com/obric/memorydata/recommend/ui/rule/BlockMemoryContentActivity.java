package com.obric.memorydata.recommend.ui.rule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ActivityBlockMemoryContentBinding;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.BaseAuthActivity;
import com.obric.memorydata.utils.ba;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0014H\u0014J\b\u0010!\u001a\u00020\u0014H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentActivity;", "Lcom/obric/memorydata/ui/BaseAuthActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/recommend/databinding/ActivityBlockMemoryContentBinding;", "viewModel", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentViewModel;", "getViewModel", "()Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter;", "addAction", "Landroid/view/View;", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "setupRecyclerView", "showAddCustomContentDialog", "observeViewModel", "updateAddAction", "customRuleCount", "", "setAddActionEnabled", "enabled", "onStart", "onStop", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlockMemoryContentActivity extends BaseAuthActivity {
    public static final a Companion = null;
    private static final float DISABLED_ACTION_ALPHA = 0.3f;
    private h adapter;
    private View addAction;
    private ActivityBlockMemoryContentBinding binding;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentActivity$Companion;", "", "<init>", "()V", "DISABLED_ACTION_ALPHA", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r4) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intent r5 = new Intent(r3, BlockMemoryContentActivity.class);
            if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r3), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) != null) goto L5;
            r5.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r3, r5, "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.rule.BlockMemoryContentActivity$showAddCustomContentDialog$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Unit> {
        AnonymousClass1(Object r8) {
            super(1, r8, BlockMemoryContentViewModel.class, "addCustomBlockContent", "addCustomBlockContent(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(String r3) {
            invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            ((BlockMemoryContentViewModel) ZeusTransformUtils.preCheckCast(this.receiver, BlockMemoryContentViewModel.class, "com.obric.memorydata.plugin")).addCustomBlockContent(r3);
        }
    }

    static {
        Companion = new a(null);
    }

    public BlockMemoryContentActivity() {
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new BlockMemoryContentActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(BlockMemoryContentViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new BlockMemoryContentActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new BlockMemoryContentActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    private final BlockMemoryContentViewModel getViewModel() {
        return (BlockMemoryContentViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), BlockMemoryContentViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void initView() {
        BaseActivity r2 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");
        ActivityBlockMemoryContentBinding r0 = this.binding;
        View r10 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r3 = r0.title;
        Intrinsics.checkNotNullExpressionValue(r3, "title");
        ActivityBlockMemoryContentBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        BaseActivity.setupTitleBarBackAction$default(r2, r3, (View) ZeusTransformUtils.preCheckCast(r1.rvBlockContent, View.class, "com.obric.memorydata.plugin"), MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())), null, 8, null);
        ActivityBlockMemoryContentBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        View r5 = OFloatingTitleBar.b(r4.title, ZeusTransformUtils.mapRes(R.drawable.button_add_rule_icon, "drawable", "button_add_rule_icon"), 0, null, 6, null);
        this.addAction = r5;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("addAction");
    L15:
        r10.setOnClickListener(new $$Lambda$BlockMemoryContentActivity$iPjJ3Cypd2PF3hdxdIE9P783Iiw(this));
        setAddActionEnabled(false);
        setupRecyclerView();
        return;
    L14:
        r10 = r5;
        goto L15
    }

    private static final void initView$lambda$0(BlockMemoryContentActivity r1, View r2) {
        ((BlockMemoryContentActivity) ZeusTransformUtils.wrapperContextForParams(r1, BlockMemoryContentActivity.class, "com.obric.memorydata.plugin")).showAddCustomContentDialog();
    }

    public static /* synthetic */ Unit lambda$dnVUECcw06CcpAPbvj87akAR9bQ(BlockMemoryContentActivity r0, List r1) {
        return observeViewModel$lambda$2(r0, r1);
    }

    public static /* synthetic */ void lambda$iPjJ3Cypd2PF3hdxdIE9P783Iiw(BlockMemoryContentActivity r0, View r1) {
        initView$lambda$0(r0, r1);
    }

    private final void observeViewModel() {
        getViewModel().getShieldContentItems().observe((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin"), (Observer) ZeusTransformUtils.preCheckCast(new BlockMemoryContentActivity$sam$androidx_lifecycle_Observer$0(new $$Lambda$BlockMemoryContentActivity$dnVUECcw06CcpAPbvj87akAR9bQ(this)), Observer.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit observeViewModel$lambda$2(BlockMemoryContentActivity r4, List r5) {
        BlockMemoryContentActivity r6 = (BlockMemoryContentActivity) ZeusTransformUtils.wrapperContextForParams(r4, BlockMemoryContentActivity.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        h r0 = r6.adapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        Intrinsics.checkNotNull(r7);
        r0.b(b.a(r7));
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L8;
    L10:
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L18;
        if (ZeusTransformUtils.instanceOf((com.obric.memorydata.recommend.ui.rule.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.memorydata.recommend.ui.rule.a.class, "com.obric.memorydata.plugin"), com.obric.memorydata.recommend.ui.rule.a.C0686a.class) == false) goto L12;
        r2 = r2 + 1;
        if (r2 >= 0) goto L12;
        CollectionsKt.throwCountOverflow();
    L18:
        r6.updateAddAction(r2);
        return Unit.INSTANCE;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        goto L10
    }

    private final void setAddActionEnabled(boolean r4) {
        View r0 = this.addAction;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("addAction");
        r0 = null;
    L5:
        r0.setEnabled(r4);
        View r3 = this.addAction;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("addAction");
    L9:
        if (r4 == false) goto L11;
        float r5 = 1.0f;
    L12:
        r1.setAlpha(r5);
        return;
    L11:
        r5 = DISABLED_ACTION_ALPHA;
        goto L12
    L8:
        r1 = r3;
        goto L9
    }

    private final void setupRecyclerView() {
        this.adapter = new h(getViewModel(), (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.memorydata.plugin"));
        ActivityBlockMemoryContentBinding r0 = this.binding;
        h r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.rvBlockContent.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        ActivityBlockMemoryContentBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        RecyclerView r3 = r1.rvBlockContent;
        h r6 = this.adapter;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L12:
        r3.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r2, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        r2 = r6;
        goto L12
    }

    private final void showAddCustomContentDialog() {
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.memorydata.plugin");
        Function1 r5 = (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(getViewModel()), Function1.class, "com.obric.memorydata.plugin");
        new d(r2, false, null, null, r5, false, 46, null).a();
    }

    private final void updateAddAction(int r2) {
        if (r2 >= 100) goto L5;
        boolean r3 = true;
    L6:
        setAddActionEnabled(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r5) {
        prepareSystemBar();
        ActivityBlockMemoryContentBinding r6 = ActivityBlockMemoryContentBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.binding = r6;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityBlockMemoryContentBinding r7 = this.binding;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        RecyclerView r8 = r7.rvBlockContent;
        Intrinsics.checkNotNullExpressionValue(r8, "rvBlockContent");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        initView();
        observeViewModel();
        getViewModel().loadShieldContent();
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        getViewModel().initializeDefaultCustomContent();
        getViewModel().startObservingDataChanges();
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        getViewModel().stopObservingDataChanges();
    }
}
