package com.larus.camera.impl.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.camera.api.params.CaptureMode;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.Scene;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.component.result.general.ResultCropComponent;
import com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent;
import com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent;
import com.larus.camera.impl.ui.component.result.general.p;
import com.larus.camera.impl.ui.viewmodel.r0;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.utils.CaptureResultDetectLogic;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\r\u0010\u001c\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH$J\b\u0010 \u001a\u00020\u000fH\u0002J\u0016\u0010!\u001a\u00020\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0014J\b\u0010%\u001a\u00020\u000fH\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020'0#H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006("}, d2 = {"Lcom/larus/camera/impl/ui/base/BaseCameraFragment;", "VM", "Lcom/larus/camera/impl/ui/base/BaseCameraViewModel;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "scene", "", "vmAbility", "Lcom/larus/camera/impl/ui/viewmodel/ViewModelAbilityManager;", "getVmAbility", "()Lcom/larus/camera/impl/ui/viewmodel/ViewModelAbilityManager;", "vmAbility$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onDestroy", "viewModel", "()Lcom/larus/camera/impl/ui/base/BaseCameraViewModel;", "cameraScene", "Lcom/larus/camera/impl/ui/Scene;", "initViewModel", "onPictureSelected", "result", "", "Lcom/larus/platform/model/album/AlbumSelectItem;", "initContainer", "componentsByCameraScene", "Lcom/larus/camera/impl/ui/arch/Component;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseCameraFragment<VM extends BaseCameraViewModel> extends Fragment {
    public static final /* synthetic */ int f = 0;
    public final String d;
    public final Lazy e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Scene.values().length];
            r0[Scene.CAPTURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Scene.RESULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Scene.EDIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public abstract Scene S90();

    public abstract VM U90();

    public BaseCameraFragment() {
        this.d = "BASE_CAMERA";
        this.e = LazyKt.lazy(new d(this));
    }

    public void onDestroy() {
        super.onDestroy();
        ((r0) this.e.getValue()).t0();
        com.larus.platform.service.g.a.g(this.d);
        FLogger.a.j(this.d, "CameraFragment onDestroy");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        View r0 = getView();
        if (r0 == null) goto L8;
        CameraContainer r1 = (CameraContainer) r0.findViewById(2131367728);
        if (r1 == null) goto L9;
        r1.c();
        return;
    L9:
        return;
    }

    public void T90(List<AlbumSelectItem> r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        FLogger.a.i(getClass().getName(), "[onPictureSelected] result:" + r5);
        U90().interceptPickResultOversize(requireContext(), r5, new e(this));
    }

    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        com.larus.platform.service.g.a.e(this.d);
        FLogger.a.j(this.d, "CameraFragment onCreate");
    }

    public void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        ((r0) this.e.getValue()).v(new com.larus.camera.impl.ui.base.a(this), new b(this), new c(this), new f(this));
        U90().bindAbility((r0) this.e.getValue());
        U90().onInitialized();
        CameraData r10 = U90().getCameraData();
        int r11 = rx8.a.a;
        int r12 = a.a[S90().ordinal()];
        boolean r0 = false;
        if (r12 != 1) goto L5;
        Intrinsics.checkNotNullParameter(r10, "cameraData");
        List<CaptureMode> r13 = r10.getCaptureModeList();
        if (r13.isEmpty() == true) goto L78;
        Iterator<T> r14 = r13.iterator();
        int r2 = 0;
    L60:
        if (r14.hasNext() == false) goto L73;
        String r3 = ((CaptureMode) r14.next()).getMode();
        if (fx8.a.a.contains(r3) == true) goto L63;
        if (fx8.a.e.contains(r3) == true) goto L66;
        if (fx8.a.c.contains(r3) == true) goto L69;
        if (fx8.a.b.contains(r3) == false) goto L60;
        r2 = r2 | 8;
        goto L60
    L69:
        r2 = r2 | 4;
        goto L60
    L66:
        r2 = r2 | 2;
        goto L60
    L63:
        r2 = r2 | 1;
        goto L60
    L73:
        int r15 = 0;
    L74:
        if (r2 == 0) goto L76;
        r15 = r15 + (r2 & 1);
        r2 = r2 >> 1;
        goto L74
    L76:
        if (r15 <= 1) goto L78;
        r0 = true;
    L78:
        if (r0 == false) goto L90;
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r10.getCaptureModeList().iterator();
    L81:
        if (r17.hasNext() == false) goto L83;
        CaptureMode r1 = (CaptureMode) r17.next();
        int r4 = rx8.a.a;
        r16.addAll(rx8.a.a(r1.getMode()));
        goto L81
    L83:
        HashSet r18 = new HashSet();
        ArrayList r5 = new ArrayList();
        Iterator r19 = r16.iterator();
    L85:
        if (r19.hasNext() == false) goto L89;
        Object r6 = r19.next();
        if (r18.add(((tx8.d) r6).getId()) == false) goto L85;
        r5.add(r6);
    L89:
        List r20 = r5;
    L91:
        FLogger r21 = FLogger.a;
        StringBuilder r7 = new StringBuilder("[initContainer] scene=");
        r7.append(S90());
        r7.append(", components=");
        List r22 = r20;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r24 = r22.iterator();
    L93:
        if (r24.hasNext() == false) goto L95;
        r23.add(((tx8.d) r24.next()).getClass().getSimpleName());
        goto L93
    L95:
        r7.append(r23);
        r21.i("BaseCameraFragment", r7.toString());
        View r25 = getView();
        if (r25 == null) goto L123;
        CameraContainer r26 = (CameraContainer) r25.findViewById(2131367728);
        if (r26 == null) goto L124;
        r26.b(U90(), this, r20);
        return;
    L124:
        return;
    L123:
        return;
    L90:
        r20 = rx8.a.a(r10.getCaptureMode());
        goto L91
    L5:
        if (r12 != 2) goto L7;
        boolean r27 = U90().shouldSupportEdit();
        OutputParam r28 = U90().getCurrentDisplayOutputParam();
        Intrinsics.checkNotNullParameter(r10, "cameraData");
        if (r28 != null) goto L29;
    L31:
        boolean r29 = false;
    L32:
        CaptureResultDetectLogic r30 = CaptureResultDetectLogic.a;
        boolean r31 = CaptureResultDetectLogic.a(r10);
        FLogger.a.i("CameraContainerComponents", "[resultPageComponents] scene=" + r10.getScene() + ", captureMode=" + r10.getCaptureMode() + ", enableResultSuggestedAction=" + r10.getEnableResultSuggestedAction() + ", detectEnabled=" + r31 + ", resultIsVideo=" + r29);
        if (fx8.a.e.contains(r10.getCaptureMode()) == false) goto L36;
        r20 = rx8.a.b(r10, r29, r10.getCaptureMode(), r27);
        goto L91
    L36:
        if (fx8.a.c.contains(r10.getCaptureMode()) == false) goto L38;
        r20 = rx8.a.d(r10, r27);
        goto L91
    L38:
        if (r31 == false) goto L46;
        if (r29 == true) goto L46;
        if (r10.getEnableFocusFrame() == true) goto L43;
    L45:
        r20 = rx8.a.c(r10, r0, r27);
        goto L91
    L43:
        if (Intrinsics.areEqual(r10.getCaptureMode(), "CAPTURE_MODE_PHOTO") == false) goto L45;
        r0 = true;
    L46:
        r5 = new ArrayList();
        yx8.a r32 = yx8.c.a;
        r5.addAll(yx8.c.a(yx8.b.a.a));
        r5.add(new ResultPreviewComponent());
        if (r27 == false) goto L50;
        r5.add(new ResultCropComponent());
    L50:
        if (r10.getEnableResultSuggestedAction() == false) goto L53;
        r5.add(new ResultSuggestedActionComponent());
    L53:
        if (r10.getEnableResultMarkedTips() == false) goto L89;
        r5.add(new p());
        goto L89
    L29:
        if (r28.isVideo() != true) goto L31;
        r29 = true;
        goto L32
    L7:
        if (r12 != 3) goto L25;
        Intrinsics.checkNotNullParameter(r10, "cameraData");
        if (fx8.a.e.contains(r10.getCaptureMode()) == false) goto L12;
        r20 = rx8.a.b(r10, false, null, false);
        goto L91
    L12:
        if (fx8.a.c.contains(r10.getCaptureMode()) == false) goto L14;
        r20 = rx8.a.d(r10, false);
        goto L91
    L14:
        CaptureResultDetectLogic r33 = CaptureResultDetectLogic.a;
        if (CaptureResultDetectLogic.a(r10) == false) goto L17;
        r20 = rx8.a.c(r10, false, false);
        goto L91
    L17:
        ArrayList r34 = new ArrayList();
        yx8.a r35 = yx8.c.a;
        r34.addAll(yx8.c.a(yx8.b.a.a));
        r34.add(new ResultPreviewComponent());
        if (r10.getEnableResultSuggestedAction() == false) goto L20;
        r34.add(new ResultSuggestedActionComponent());
    L20:
        r34.add(new ResultCropComponent());
        if (r10.getEnableResultMarkedTips() == false) goto L23;
        r34.add(new p());
    L23:
        r20 = r34;
        goto L91
    L25:
        throw new NoWhenBranchMatchedException();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562820, r3, false);
    }
}
