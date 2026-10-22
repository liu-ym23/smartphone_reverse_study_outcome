package com.larus.camera.impl.starter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.activity.CameraResultActivity;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.ui.viewmodel.m0;
import com.larus.camera.impl.utils.CameraData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.starter.CameraStarter$Companion$result$1$1$3$1", f = "CameraStarter.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
final class CameraStarter$Companion$result$1$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Uri $albumUri;
    final /* synthetic */ boolean $enableEduCheck;
    final /* synthetic */ String $imagePath;
    final /* synthetic */ CameraStarter $starter;
    final /* synthetic */ boolean $supportCrop;
    final /* synthetic */ boolean $supportMark;
    int label;

    public CameraStarter$Companion$result$1$1$3$1(boolean r1, CameraStarter r2, FragmentActivity r3, String r4, Uri r5, boolean r6, boolean r7, Continuation<? super CameraStarter$Companion$result$1$1$3$1> r8) {
        this.$enableEduCheck = r1;
        this.$starter = r2;
        this.$activity = r3;
        this.$imagePath = r4;
        this.$albumUri = r5;
        this.$supportMark = r6;
        this.$supportCrop = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CameraStarter$Companion$result$1$1$3$1(this.$enableEduCheck, this.$starter, this.$activity, this.$imagePath, this.$albumUri, this.$supportMark, this.$supportCrop, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r4 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L22:
        if (((Boolean) r13).booleanValue() == false) goto L24;
    L25:
        CameraStarter r14 = this.$starter;
        FragmentActivity r2 = this.$activity;
        boolean r3 = this.$supportMark;
        boolean r6 = this.$supportCrop;
        CameraStarter.Companion r7 = CameraStarter.h;
        Bundle r8 = r14.getArguments();
        if (r8 == null) goto L28;
        Serializable r5 = r8.getSerializable("STARTER_INPUT_PARAM");
    L30:
        if ((r5 instanceof InputParam) == false) goto L32;
        InputParam r9 = (InputParam) r5;
    L33:
        Bundle r10 = r14.getArguments();
        if (r10 == null) goto L36;
        Serializable r11 = r10.getSerializable("STARTER_OUTPUT_PARAM");
    L38:
        if ((r11 instanceof OutputParam) == false) goto L40;
        OutputParam r12 = (OutputParam) r11;
    L41:
        Bundle r15 = r14.getArguments();
        String r16 = "";
        if (r15 == null) goto L44;
        r4 = r15.getString("STARTER_ALBUM_URI", "");
    L44:
        if (r4 == null) goto L47;
        r16 = r4;
    L47:
        Intent r17 = new Intent(r2, CameraResultActivity.class);
        r17.putExtra("CAMERA_INPUT_PARAM", r9);
        CameraOutputContext r18 = new CameraOutputContext();
        r18.setOutputParamList(CollectionsKt.mutableListOf(new OutputParam[]{r12}));
        r17.putExtra("CAMERA_OUTPUT_CONTEXT", r18);
        r17.putExtra("PREVIEW_PARAM_ORIENTATION", 0);
        r17.putExtra("SUPPORT_MARK_PARAM", r3);
        r17.putExtra("SUPPORT_CROP_PARAM", r6);
        r17.putExtra("PREVIEW_PARAM_ALBUM_URI", r16);
        ActivityResultLauncher<Intent> r19 = r14.e;
        if (r19 == null) goto L51;
        r19.launch(r17);
    L51:
        return Unit.INSTANCE;
    L40:
        r12 = null;
        goto L41
    L36:
        r11 = null;
        goto L38
    L32:
        r9 = null;
        goto L33
    L28:
        r5 = null;
        goto L30
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        if (this.$enableEduCheck == false) goto L25;
        CameraStarter r110 = this.$starter;
        Context r20 = this.$activity;
        String r111 = this.$imagePath;
        Uri r21 = this.$albumUri;
        this.label = 1;
        CameraStarter.Companion r22 = CameraStarter.h;
        Bundle r23 = r110.getArguments();
        if (r23 == null) goto L13;
        Serializable r24 = r23.getSerializable("STARTER_INPUT_PARAM");
    L15:
        if ((r24 instanceof InputParam) == false) goto L17;
        InputParam r25 = (InputParam) r24;
    L18:
        Bundle r26 = new Bundle();
        r26.putSerializable("CAMERA_INPUT_PARAM", r25);
        final CameraData.Manager r27 = new CameraData.Manager(LifecycleOwnerKt.getLifecycleScope(r110));
        r27.b(r26);
        ((m0) r110.d.getValue()).l0(new g(r27));
        r13 = CameraCaptureViewModel.Companion.a((m0) r110.d.getValue(), r20, r21, r111, this);
        if (r13 != r0) goto L22;
        return r0;
    L17:
        r25 = null;
        goto L18
    L13:
        r24 = null;
        goto L15
    }
}
