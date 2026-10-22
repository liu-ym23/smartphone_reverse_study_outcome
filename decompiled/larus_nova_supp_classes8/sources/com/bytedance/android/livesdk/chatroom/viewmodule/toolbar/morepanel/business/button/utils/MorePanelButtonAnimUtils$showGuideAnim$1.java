package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.utils;

import android.view.View;
import com.bytedance.android.livesdk.utils.q4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class MorePanelButtonAnimUtils$showGuideAnim$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ int $darkColor;
    final /* synthetic */ boolean $endWithShadow;
    final /* synthetic */ View $iconBgView;
    final /* synthetic */ int $lightColor;
    final /* synthetic */ float $sourceScale;
    final /* synthetic */ float $targetScale;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.utils.MorePanelButtonAnimUtils$showGuideAnim$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<q4, Unit> {
        final /* synthetic */ MorePanelButtonAnimUtils$showGuideAnim$1 this$0;

        public AnonymousClass1(MorePanelButtonAnimUtils$showGuideAnim$1 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(final q4 r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.d(new C00761(this));
            r2.b(new AnonymousClass2(this));
            r2.b(new AnonymousClass3(this));
            r2.b(new AnonymousClass4(this));
            r2.b(new AnonymousClass5(this, r2));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((q4) r1);
            return Unit.INSTANCE;
        }
    }

    public MorePanelButtonAnimUtils$showGuideAnim$1(View r1, float r2, float r3, int r4, int r5, boolean r6) {
        this.$iconBgView = r1;
        this.$sourceScale = r2;
        this.$targetScale = r3;
        this.$lightColor = r4;
        this.$darkColor = r5;
        this.$endWithShadow = r6;
        super(1);
    }

    public final void invoke(q4 r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.c(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((q4) r1);
        return Unit.INSTANCE;
    }
}
