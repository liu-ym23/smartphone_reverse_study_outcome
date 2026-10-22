package com.larus.camera.impl.ui.component.capture.health;

import android.content.Context;
import android.net.Uri;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.arch.b;
import com.larus.camera.impl.ui.component.capture.CaptureControlComponent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.utils.y0;
import fx8.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0014J\b\u0010\r\u001a\u00020\nH\u0014J&\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/camera/impl/ui/component/capture/health/MedicalCaptureControlComponent;", "Lcom/larus/camera/impl/ui/component/capture/CaptureControlComponent;", "<init>", "()V", "supportedCaptureMode", "", "", "getSupportedCaptureMode", "()Ljava/util/List;", "onHandlePictureSelected", "", "item", "Lcom/larus/platform/model/album/AlbumSelectItem;", "onHandleCapture", "interceptResultPageOpen", "", "outputParamList", "Lcom/larus/camera/api/params/OutputParam;", "isFromAlbum", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MedicalCaptureControlComponent extends CaptureControlComponent {
    public final List<String> v;

    @Override // com.larus.camera.impl.ui.component.capture.CaptureControlComponent
    public final void y() {
        CameraCaptureViewModel r1 = (CameraCaptureViewModel) ((b.a) this.e.getValue()).a();
        if (r1 != null) goto L5;
        return;
    L5:
        CameraCaptureViewModel.capturePhoto$default(r1, getContext(), true, new MedicalCaptureControlComponent$onHandleCapture$1(this), null, 8, null);
    }

    public MedicalCaptureControlComponent() {
        List<String> r0 = a.a;
        this.v = a.c;
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureControlComponent, com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.v;
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureControlComponent
    public final void z(List<AlbumSelectItem> r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.openResultPageFromAlbum(getContext(), r4, new MedicalCaptureControlComponent$onHandlePictureSelected$1(this));
    }

    public static final Object B(MedicalCaptureControlComponent r4, List r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof MedicalCaptureControlComponent$interceptResultPageOpen$1) == false) goto L7;
        MedicalCaptureControlComponent$interceptResultPageOpen$1 r0 = (MedicalCaptureControlComponent$interceptResultPageOpen$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L24:
        return Boxing.boxBoolean(!((Boolean) r7).booleanValue());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        CameraCaptureViewModel r8 = (CameraCaptureViewModel) ((b.a) r4.e.getValue()).a();
        if (r8 == null) goto L25;
        OutputParam r9 = (OutputParam) CollectionsKt.firstOrNull(r5);
        if (r9 == null) goto L26;
        Context r10 = r4.getContext();
        Uri r11 = y0.j(r9.getSrcAlbumUri());
        r0.label = 1;
        r7 = r8.healthImageIdentifyCheck(r10, r9, r11, r0);
        if (r7 != r2) goto L24;
        return r2;
    L26:
        return Boxing.boxBoolean(false);
    L25:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new MedicalCaptureControlComponent$interceptResultPageOpen$1(r4, r6);
        goto L8
    }
}
