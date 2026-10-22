package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import com.bytedance.android.anniex.ability.service.AnnieXPitayaProvider;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Landroid/graphics/Bitmap;", "bitmap", "Lga/e;", "callback", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$getBlankDetections$1", f = "AnnieXBlankDetectorManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXBlankDetectorManager$getBlankDetections$1 extends SuspendLambda implements Function3<Bitmap, ga.e, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public AnnieXBlankDetectorManager$getBlankDetections$1(Continuation<? super AnnieXBlankDetectorManager$getBlankDetections$1> r10) {
        super(3, r10);
    }

    public final Object invoke(Bitmap r10, ga.e r11, Continuation<? super Unit> r12) {
        AnnieXBlankDetectorManager$getBlankDetections$1 r0 = new AnnieXBlankDetectorManager$getBlankDetections$1(r12);
        r0.L$0 = r10;
        r0.L$1 = r11;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10, Object r11) {
        return invoke((Bitmap) r1, (ga.e) r10, (Continuation) r11);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        Bitmap r11 = (Bitmap) this.L$0;
        ga.e r0 = (ga.e) this.L$1;
        AnnieXServiceCenter.a.getClass();
        if (((AnnieXPitayaProvider) AnnieXServiceCenter.d("default_bid", AnnieXPitayaProvider.class)) == null) goto L8;
        ga.d r1 = new ga.d();
        JSONObject r12 = new JSONObject();
        Intrinsics.checkNotNullParameter(r11, "snapshot");
        Intrinsics.checkNotNullParameter(r1, "taskConfig");
        Intrinsics.checkNotNullParameter(r12, "data");
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
