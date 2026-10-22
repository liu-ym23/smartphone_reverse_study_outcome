package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.view.View;
import com.bytedance.android.livesdk.utils.q4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LandscapeSpiltControllerWidget$updateSpiltAreaVisibility$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ int $initialMargin;
    final /* synthetic */ r $spiltManager;
    final /* synthetic */ View $spiltPublicScreenLayout;
    final /* synthetic */ float $spiltPublicScreenWidth;
    final /* synthetic */ int $toLeftMargin;
    final /* synthetic */ int $toRightMargin;
    final /* synthetic */ int $updateVisibility;
    final /* synthetic */ LandscapeSpiltControllerWidget this$0;

    public LandscapeSpiltControllerWidget$updateSpiltAreaVisibility$1(LandscapeSpiltControllerWidget r1, View r2, float r3, r r4, int r5, int r6, int r7, int r8) {
        this.this$0 = r1;
        this.$spiltPublicScreenLayout = r2;
        this.$spiltPublicScreenWidth = r3;
        this.$spiltManager = r4;
        this.$initialMargin = r5;
        this.$toLeftMargin = r6;
        this.$toRightMargin = r7;
        this.$updateVisibility = r8;
        super(1);
    }

    public final void invoke(q4 r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.b(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((q4) r1);
        return Unit.INSTANCE;
    }
}
