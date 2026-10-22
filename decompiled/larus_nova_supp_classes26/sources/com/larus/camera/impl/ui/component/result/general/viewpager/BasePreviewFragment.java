package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.utils.logger.FLogger;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010'\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010(\u001a\u0004\u0018\u00010)H\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/viewpager/BasePreviewFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/IMultiPreview;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "displayParam", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/ResultDisplayParam;", "getDisplayParam", "()Lcom/larus/camera/impl/ui/component/result/general/viewpager/ResultDisplayParam;", "setDisplayParam", "(Lcom/larus/camera/impl/ui/component/result/general/viewpager/ResultDisplayParam;)V", "viewModel", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel;", "getViewModel", "()Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onStop", "onDestroy", "onResume", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreate", "getBitmap", "Landroid/graphics/Bitmap;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BasePreviewFragment extends Fragment implements d {
    public static final /* synthetic */ int g = 0;
    public final String d;
    public ResultDisplayParam e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.d
    public final void BI() {
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.d
    public void oK() {
    }

    public final Bitmap S90() {
        ResultDisplayParam r0 = this.e;
        if (r0 == null) goto L14;
        com.larus.camera.impl.ui.viewmodel.t r1 = com.larus.camera.impl.ui.viewmodel.t.a;
        String r2 = r0.getOutputKey();
        FLogger.a.i("CameraMultiCaptureOutputManager", "[getBitmap] key:" + r2);
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        return com.larus.camera.impl.ui.viewmodel.t.d().a(r2);
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
    L14:
        return null;
    }

    public final CameraResultViewModel T90() {
        return (CameraResultViewModel) this.f.getValue();
    }

    public final void onDestroy() {
        FLogger r0 = FLogger.a;
        String r1 = this.d;
        StringBuilder r2 = new StringBuilder("[onDestroy] position = ");
        ResultDisplayParam r3 = this.e;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getInitPosition());
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        super.onDestroy();
        return;
    L5:
        r4 = null;
        goto L6
    }

    public void onPause() {
        FLogger r0 = FLogger.a;
        String r1 = this.d;
        StringBuilder r2 = new StringBuilder("[onPause] position = ");
        ResultDisplayParam r3 = this.e;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getInitPosition());
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        super.onPause();
        return;
    L5:
        r4 = null;
        goto L6
    }

    public void onResume() {
        FLogger r0 = FLogger.a;
        String r1 = this.d;
        StringBuilder r2 = new StringBuilder("[onResume] position = ");
        ResultDisplayParam r3 = this.e;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getInitPosition());
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        super.onResume();
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onStart() {
        FLogger r0 = FLogger.a;
        String r1 = this.d;
        StringBuilder r2 = new StringBuilder("[onStart] position = ");
        ResultDisplayParam r3 = this.e;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getInitPosition());
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        super.onStart();
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onStop() {
        FLogger r0 = FLogger.a;
        String r1 = this.d;
        StringBuilder r2 = new StringBuilder("[onStop] position = ");
        ResultDisplayParam r3 = this.e;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getInitPosition());
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        super.onStop();
        return;
    L5:
        r4 = null;
        goto L6
    }

    public BasePreviewFragment() {
        this.d = getClass().getSimpleName() + '_' + hashCode() + ' ';
        final Function0 r0 = new com.larus.camera.impl.ui.component.result.general.viewpager.a(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CameraResultViewModel.class), new BasePreviewFragment$special$$inlined$viewModels$default$1(r0), new BasePreviewFragment$special$$inlined$viewModels$default$2(r0, this));
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Bundle r6 = getArguments();
        Integer r0 = null;
        if (r6 == null) goto L9;
        Serializable r7 = r6.getSerializable("display_param");
        if ((r7 instanceof ResultDisplayParam) == false) goto L7;
        ResultDisplayParam r8 = (ResultDisplayParam) r7;
    L8:
        this.e = r8;
        goto L9
    L7:
        r8 = null;
    L9:
        FLogger r9 = FLogger.a;
        String r1 = this.d;
        StringBuilder r2 = new StringBuilder("[onCreate] position = ");
        ResultDisplayParam r3 = this.e;
        if (r3 == null) goto L12;
        r0 = Integer.valueOf(r3.getInitPosition());
    L12:
        r2.append(r0);
        r9.i(r1, r2.toString());
    }

    public void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        FLogger r0 = FLogger.a;
        String r1 = this.d;
        StringBuilder r2 = new StringBuilder("[onViewCreated] position = ");
        ResultDisplayParam r3 = this.e;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getInitPosition());
    L6:
        r2.append(r4);
        r2.append("， parent:");
        r2.append(getParentFragment());
        r0.i(r1, r2.toString());
        super.onViewCreated(r5, r6);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        FLogger r0 = FLogger.a;
        String r1 = this.d;
        StringBuilder r2 = new StringBuilder("[onCreateView] position = ");
        ResultDisplayParam r3 = this.e;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getInitPosition());
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        return super.onCreateView(r5, r6, r7);
    L5:
        r4 = null;
        goto L6
    }
}
