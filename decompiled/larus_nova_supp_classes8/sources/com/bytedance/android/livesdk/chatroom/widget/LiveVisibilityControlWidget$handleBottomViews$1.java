package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/visibilitycontrol/d;", "item", "", "invoke", "(Lcom/bytedance/android/live/room/api/visibilitycontrol/d;)V", "realHandle"}, k = 3, mv = {1, 4, 3})
public final class LiveVisibilityControlWidget$handleBottomViews$1 extends Lambda implements Function1<com.bytedance.android.live.room.api.visibilitycontrol.d, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $entiretyVisible;
    final /* synthetic */ LiveVisibilityControlWidget this$0;

    public LiveVisibilityControlWidget$handleBottomViews$1(LiveVisibilityControlWidget r1, boolean r2, long r3) {
        this.this$0 = r1;
        this.$entiretyVisible = r2;
        this.$duration = r3;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(com.bytedance.android.live.room.api.visibilitycontrol.d r13) {
        Intrinsics.checkNotNullParameter(r13, "item");
        if (r13.n == true) goto L5;
        boolean r0 = this.$entiretyVisible;
    L9:
        int r2 = !r0;
        Integer r3 = (Integer) r13.e.getValue();
        if (r3 != null) goto L13;
    L15:
        r13.e.postValue(Integer.valueOf(r2));
        if (com.bytedance.android.live.core.utils.z.m(((Widget) this.this$0).dataCenter, true) == false) goto L18;
        int r4 = 55;
    L19:
        float r5 = 0.0f;
        if (r0 == 0) goto L22;
        float r7 = UtilityKotlinExtentionsKt.h(r4);
    L23:
        if (r0 == 0) goto L25;
        float r8 = 0.0f;
    L26:
        int r6 = e1.f[r13.j.ordinal()];
        if (r6 != 1) goto L29;
        long r9 = this.$duration;
        if (r9 <= 0) goto L45;
        Animator r10 = LiveVisibilityControlWidget.Aq(this.this$0, r13.h, r7, r8, r9);
        LiveVisibilityControlWidget r11 = this.this$0;
        View r14 = r13.h;
        if (r0 == 0) goto L44;
        r5 = 1.0f;
    L44:
        Animator r15 = LiveVisibilityControlWidget.wq(r11, r14, r5, this.$duration);
        ((ArrayList) this.this$0.v).add(r10);
        ((ArrayList) this.this$0.v).add(r15);
        return;
    L45:
        View r12 = r13.h;
        if (r0 == 0) goto L48;
        r5 = 1.0f;
    L48:
        r12.setAlpha(r5);
        r13.h.setTranslationY(r8);
        return;
    L29:
        if (r6 != 2) goto L53;
        float r16 = (this.this$0.s - r13.a) - UtilityKotlinExtentionsKt.h(r13.k);
        long r17 = this.$duration;
        if (r17 <= 0) goto L34;
        ((ArrayList) this.this$0.v).add(LiveVisibilityControlWidget.yq(this.this$0, r13.h, r7, r8, r16, r17));
        return;
    L34:
        View r18 = r13.h;
        if (r0 != 0) goto L38;
        r5 = r16;
    L38:
        r18.setTranslationY(r5);
        return;
    L53:
        return;
    L25:
        r8 = UtilityKotlinExtentionsKt.h(r4);
        goto L26
    L22:
        r7 = 0.0f;
        goto L23
    L18:
        r4 = 105;
        goto L19
    L13:
        if (r3.intValue() != r2) goto L15;
        return;
    L5:
        if (this.$entiretyVisible == true) goto L7;
        r0 = 1;
        goto L9
    L7:
        r0 = 0;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.live.room.api.visibilitycontrol.d) r1);
        return Unit.INSTANCE;
    }
}
