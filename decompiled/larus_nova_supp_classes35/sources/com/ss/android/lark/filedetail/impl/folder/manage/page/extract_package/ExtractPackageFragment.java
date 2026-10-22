package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.folder.manage.page.BaseFolderContentFragment;
import com.ss.android.lark.filedetail.impl.folder.manage.service.ExtractConfig;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 K2\u00020\u0001:\u0001KB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020.H\u0016J&\u00102\u001a\u0004\u0018\u00010\t2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00107\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u0010:\u001a\u00020.H\u0002J\b\u0010;\u001a\u00020.H\u0002J\u0010\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020.H\u0002J0\u0010@\u001a\u00020.2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020B2\b\b\u0002\u0010D\u001a\u00020B2\b\b\u0002\u0010E\u001a\u00020BH\u0002J\u0010\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020B2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010J\u001a\u00020BH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0&X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010,0+0&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/extract_package/ExtractPackageFragment;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/BaseFolderContentFragment;", "params", "Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "dependency", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/extract_package/IExtractDependency;", "<init>", "(Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;Lcom/ss/android/lark/filedetail/impl/folder/manage/page/extract_package/IExtractDependency;)V", "extractProgressLayout", "Landroid/view/View;", "extractPackageSize", "Landroid/widget/TextView;", "extractProgress", "Lcom/larksuite/component/universe_design/progress/UDProgress;", "extractProgressDesc", "extractPackageTip", "loadingLayout", "loadingIV", "Landroid/widget/ImageView;", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "loadingStatus", BuildConfig.FLAVOR, "retryLayout", "retrySize", "retryBtn", "Lcom/larksuite/component/universe_design/button/UDButton;", "failedLayout", "failedTip", "failedSize", "openWithOtherBtn", "packageCleanedLayout", "fileName", "viewModel", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/extract_package/ExtractPackageViewModel;", "curFileKey", BuildConfig.FLAVOR, "progressObserver", "Landroidx/lifecycle/Observer;", BuildConfig.FLAVOR, "errorObserver", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "folderResponseObserver", "Lkotlin/Pair;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FolderPreviewResponse;", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onActivityCreated", "onViewCreated", "view", "initView", "initExtractTip", "updatePackageSize", "size", BuildConfig.FLAVOR, "initClickListeners", "handleLayoutVisible", "loadingVisible", BuildConfig.FLAVOR, "progressVisible", "failedVisible", "retryVisible", "fetchData", Keys.API_RETURN_KEY_DATA, "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FilePreviewInfo;", "isCachedData", "onBackPressed", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtractPackageFragment extends BaseFolderContentFragment {
    public final com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.a A;
    public final b B;
    public final FolderManageLaunchParams d;
    public final g e;
    public View f;
    public TextView g;
    public UDProgress h;
    public TextView i;
    public TextView j;
    public View k;
    public ImageView l;
    public UDLoadingDrawable m;
    public int n;
    public View o;
    public TextView p;
    public UDButton q;
    public View r;
    public TextView s;
    public TextView t;
    public UDButton u;
    public View v;
    public TextView w;
    public ExtractPackageViewModel x;
    public String y;
    public final f z;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.BaseFolderContentFragment
    public final boolean T90(nfb.a r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
        return false;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.c
    public final boolean onBackPressed() {
        return false;
    }

    public final void onDestroy() {
        ExtractPackageViewModel r0 = this.x;
        ExtractPackageViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.getProgressLiveData().removeObserver(this.z);
        ExtractPackageViewModel r2 = this.x;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L8:
        r2.getFolderResponseLiveData().removeObserver(this.B);
        ExtractPackageViewModel r3 = this.x;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        r1.onDestroy();
        super.onDestroy();
        return;
    L11:
        r1 = r3;
        goto L12
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.BaseFolderContentFragment
    public final void S90(nfb.a r12) {
        Intrinsics.checkNotNullParameter(r12, Keys.API_RETURN_KEY_DATA);
        this.y = r12.a;
        String r0 = FileUtils.h(r12.d);
        TextView r1 = this.g;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("extractPackageSize");
        r1 = null;
    L5:
        r1.setText(r0);
        TextView r2 = this.p;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("retrySize");
        r2 = null;
    L8:
        r2.setText(r0);
        TextView r3 = this.t;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("failedSize");
        r3 = null;
    L11:
        r3.setText(r0);
        U90(this, true, false, false, false, 14);
        this.e.d();
        ExtractPackageViewModel r4 = this.x;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        ExtractPackageViewModel r5 = null;
    L15:
        r5.requestExtractPackage(this.y, r12.k, this.d.u, r12.l, ((Number) this.e.a().getFirst()).longValue(), this.d.f);
        return;
    L14:
        r5 = r4;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityCreated(Bundle r5) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r5);
        ExtractPackageViewModel r6 = this.x;
        ExtractPackageViewModel r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L5:
        r6.getProgressLiveData().observe(getViewLifecycleOwner(), this.z);
        ExtractPackageViewModel r7 = this.x;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L8:
        r7.getErrorLiveData().observe(getViewLifecycleOwner(), this.A);
        ExtractPackageViewModel r8 = this.x;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        r0.getFolderResponseLiveData().observe(getViewLifecycleOwner(), this.B);
        return;
    L11:
        r0 = r8;
        goto L12
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        ExtractPackageViewModel r4 = (ExtractPackageViewModel) new ViewModelProvider(this).get(ExtractPackageViewModel.class);
        this.x = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L5:
        r4.onCreate(this.y, this.d.t);
    }

    public ExtractPackageFragment(FolderManageLaunchParams r2, com.ss.android.lark.filedetail.impl.folder.manage.page.a r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.d = r2;
        this.e = r3;
        this.n = -1;
        this.y = r2.g;
        this.z = new f(this);
        this.A = new com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.a(this);
        this.B = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        StringBuilder r8 = new StringBuilder();
        List<String> r9 = ExtractConfig.a.getExtractConfig().getSupportedFormat();
        Iterator<T> r0 = r9.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r8.append((String) r3);
        if (r2 >= CollectionsKt.getLastIndex(r9)) goto L11;
        r8.append(UIUtils.getString(getContext(), 2131892117));
    L11:
        r2 = r4;
        goto L4
    L12:
        String r10 = FileUtils.h(ExtractConfig.a.getExtractConfig().getMaxExtractSize());
        TextView r1 = this.j;
        Drawable r5 = null;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("extractPackageTip");
        r1 = null;
    L15:
        r1.setText(UIHelper.mustacheFormat(2131890911, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("Num", r10), TuplesKt.to("FileTypes", r8.toString())})));
        Button r11 = this.q;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
        r11 = null;
    L18:
        r11.setOnClickListener(new d(this));
        Button r12 = this.u;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("openWithOtherBtn");
        r12 = null;
    L21:
        r12.setOnClickListener(new e(this));
        UDLoadingDrawable r13 = new UDLoadingDrawable(((BaseFragment) this).mContext);
        r13.setColorSchemeColors(new int[]{UIUtils.getColor(((BaseFragment) this).mContext, 2131105548)});
        this.m = r13;
        ImageView r14 = this.l;
        if (r14 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("loadingIV");
        r14 = null;
    L24:
        Drawable r15 = this.m;
        if (r15 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L28:
        r14.setImageDrawable(r5);
        return;
    L27:
        r5 = r15;
        goto L28
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        View r7 = r4.inflate(2131561190, r5, false);
        View r8 = r7.findViewById(2131372027);
        this.f = r8;
        View r9 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("extractProgressLayout");
        r8 = null;
    L5:
        ImageView r10 = (ImageView) r8.findViewById(2131372406);
        if (r10 == null) goto L8;
        r10.setImageResource(kac.a.b(2131254749));
    L8:
        this.g = (TextView) r7.findViewById(2131372028);
        this.h = r7.findViewById(2131372031);
        this.i = (TextView) r7.findViewById(2131372032);
        this.j = (TextView) r7.findViewById(2131372029);
        this.k = r7.findViewById(2131372321);
        this.l = (ImageView) r7.findViewById(2131372322);
        View r11 = r7.findViewById(2131372035);
        this.o = r11;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
        r11 = null;
    L11:
        ImageView r12 = (ImageView) r11.findViewById(2131372452);
        if (r12 == null) goto L14;
        r12.setImageResource(kac.a.b(2131254749));
    L14:
        this.p = (TextView) r7.findViewById(2131372036);
        this.q = r7.findViewById(2131384465);
        this.r = r7.findViewById(2131372022);
        this.s = (TextView) r7.findViewById(2131372024);
        this.t = (TextView) r7.findViewById(2131372023);
        this.u = r7.findViewById(2131381499);
        View r13 = r7.findViewById(2131372020);
        this.v = r13;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("packageCleanedLayout");
        r13 = null;
    L17:
        ImageView r14 = (ImageView) r13.findViewById(2131372401);
        if (r14 == null) goto L20;
        r14.setImageResource(kac.a.b(2131254749));
    L20:
        View r15 = this.v;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("packageCleanedLayout");
    L24:
        this.w = (TextView) r9.findViewById(2131390623);
        return r7;
    L23:
        r9 = r15;
        goto L24
    }

    public static void U90(ExtractPackageFragment r5, boolean r6, boolean r7, boolean r8, boolean r9, int r10) {
        int r1 = 0;
        if ((r10 & 1) == 0) goto L6;
        r6 = false;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r7 = false;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r8 = false;
    L12:
        if ((r10 & 8) == 0) goto L14;
        r9 = false;
    L14:
        View r2 = null;
        if (r6 == false) goto L20;
        r5.n = 2;
        View r11 = r5.k;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        r11 = null;
    L19:
        r11.postDelayed(new c(r5), 300);
    L27:
        View r12 = r5.f;
        if (r12 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("extractProgressLayout");
        r12 = null;
    L30:
        if (r7 == false) goto L32;
        int r13 = 0;
    L33:
        r12.setVisibility(r13);
        View r14 = r5.r;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("failedLayout");
        r14 = null;
    L36:
        if (r8 == false) goto L38;
        int r15 = 0;
    L39:
        r14.setVisibility(r15);
        View r16 = r5.o;
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
    L43:
        if (r9 == true) goto L46;
        r1 = 8;
    L46:
        r2.setVisibility(r1);
        return;
    L42:
        r2 = r16;
        goto L43
    L38:
        r15 = 8;
        goto L39
    L32:
        r13 = 8;
        goto L33
    L20:
        CircularProgressDrawable r17 = r5.m;
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r17 = null;
    L23:
        r17.stop();
        View r18 = r5.k;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        r18 = null;
    L26:
        r18.setVisibility(8);
        r5.n = 1;
        goto L27
    }
}
