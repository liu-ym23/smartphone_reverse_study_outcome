package com.bytedance.android.live.effect.cameramovement;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveCameraMovementDialog$initViewModel$2 extends Lambda implements Function1<Class<?>, Object> {
    final /* synthetic */ LiveCameraMovementDialog this$0;

    public LiveCameraMovementDialog$initViewModel$2(LiveCameraMovementDialog r1) {
        this.this$0 = r1;
        super(1);
    }

    public final Object invoke(Class<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        LiveCameraMovementDialog r0 = this.this$0;
        int r1 = LiveCameraMovementDialog.d;
        r0.getClass();
        this.this$0.getClass();
        return new LiveCameraMovementRenderViewModel(null, null, "live_camera_move");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Class) r1);
    }
}
