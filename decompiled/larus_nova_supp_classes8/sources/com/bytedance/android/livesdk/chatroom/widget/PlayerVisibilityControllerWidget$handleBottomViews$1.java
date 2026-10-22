package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;", "item", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;)V", "realHandle"}, k = 3, mv = {1, 4, 3})
public final class PlayerVisibilityControllerWidget$handleBottomViews$1 extends Lambda implements Function1<com.bytedance.android.livesdk.chatroom.vsplayer.model.c, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $entiretyVisible;
    final /* synthetic */ PlayerVisibilityControllerWidget this$0;

    public PlayerVisibilityControllerWidget$handleBottomViews$1(PlayerVisibilityControllerWidget r1, boolean r2, long r3) {
        this.this$0 = r1;
        this.$entiretyVisible = r2;
        this.$duration = r3;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r19) {
        Intrinsics.checkNotNullParameter(r19, "item");
        if (r19.o == true) goto L5;
        boolean r2 = this.$entiretyVisible;
    L9:
        int r4 = !r2;
        Integer r5 = (Integer) r19.f.getValue();
        if (r5 != null) goto L13;
    L15:
        r19.f.postValue(Integer.valueOf(r4));
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(((Widget) this.this$0).dataCenter, true) == false) goto L18;
        int r6 = 55;
    L19:
        float r7 = 0.0f;
        if (r2 == 0) goto L22;
        float r9 = UtilityKotlinExtentionsKt.h(r6);
    L23:
        if (r2 == 0) goto L25;
        float r10 = 0.0f;
    L26:
        int r8 = s1.f[r19.k.ordinal()];
        if (r8 != 1) goto L29;
        long r11 = this.$duration;
        if (r11 <= 0) goto L59;
        Animator r12 = PlayerVisibilityControllerWidget.Aq(this.this$0, r19.i, r9, r10, r11);
        PlayerVisibilityControllerWidget r13 = this.this$0;
        View r1 = r19.i;
        if (r2 == 0) goto L58;
        r7 = 1.0f;
    L58:
        Animator r3 = PlayerVisibilityControllerWidget.wq(r13, r1, r7, this.$duration);
        ((ArrayList) this.this$0.u).add(r12);
        ((ArrayList) this.this$0.u).add(r3);
        return;
    L59:
        View r14 = r19.i;
        if (r2 == 0) goto L62;
        r7 = 1.0f;
    L62:
        r14.setAlpha(r7);
        r19.i.setTranslationY(r10);
        return;
    L29:
        if (r8 != 2) goto L67;
        float r15 = (this.this$0.r - r19.a) - UtilityKotlinExtentionsKt.h(r19.l);
        long r16 = this.$duration;
        if (r16 > 0) goto L34;
        View r17 = r19.i;
        if (r2 != 0) goto L52;
        r7 = r15;
    L52:
        r17.setTranslationY(r7);
        return;
    L34:
        if (r19.e == false) goto L42;
        if (r2 == 0) goto L37;
        float r18 = r15;
    L38:
        float r110 = r18;
        if (r2 == 0) goto L41;
        r10 = 0.0f;
    L44:
        if (r19.g != PlayerViewControl.KEY.GiftTray) goto L46;
        float r111 = 0.0f;
    L47:
        ((ArrayList) this.this$0.u).add(PlayerVisibilityControllerWidget.yq(this.this$0, r19.i, r110, r111, r15, r16));
        return;
    L46:
        r111 = r10;
        goto L47
    L41:
        r10 = r15;
        goto L44
    L37:
        r18 = 0.0f;
        goto L38
    L42:
        r110 = r9;
        goto L44
    L67:
        return;
    L25:
        r10 = UtilityKotlinExtentionsKt.h(r6);
        goto L26
    L22:
        r9 = 0.0f;
        goto L23
    L18:
        r6 = 105;
        goto L19
    L13:
        if (r5.intValue() != r4) goto L15;
        return;
    L5:
        if (this.$entiretyVisible == true) goto L7;
        r2 = 1;
        goto L9
    L7:
        r2 = 0;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r1);
        return Unit.INSTANCE;
    }
}
