package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke", "com/bytedance/android/livesdk/chatroom/ui/QuickShotPresenter$onClickQuickShotBtn$1$1"}, k = 3, mv = {1, 4, 3})
public final class QuickShotPresenter$onClickQuickShotBtn$$inlined$apply$lambda$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ long $catchFrameStartTime;
    final /* synthetic */ long $clickTime$inlined;
    final /* synthetic */ Activity $this_apply;
    final /* synthetic */ QuickShotPresenter this$0;

    public QuickShotPresenter$onClickQuickShotBtn$$inlined$apply$lambda$1(Activity r1, long r2, QuickShotPresenter r4, long r5) {
        this.$this_apply = r1;
        this.$catchFrameStartTime = r2;
        this.this$0 = r4;
        this.$clickTime$inlined = r5;
        super(1);
    }

    public final void invoke(Bitmap r8) {
        if (r8 == null) goto L5;
        this.this$0.a(this.$this_apply, r8, this.$clickTime$inlined, this.$catchFrameStartTime);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Bitmap) r1);
        return Unit.INSTANCE;
    }
}
