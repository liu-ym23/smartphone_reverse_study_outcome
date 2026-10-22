package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;", "item", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;)V", "realHandle"}, k = 3, mv = {1, 4, 3})
public final class PlayerVisibilityControllerWidget$handleLeftViews$1 extends Lambda implements Function1<com.bytedance.android.livesdk.chatroom.vsplayer.model.c, Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $entiretyVisible;
    final /* synthetic */ PlayerVisibilityControllerWidget this$0;

    public PlayerVisibilityControllerWidget$handleLeftViews$1(PlayerVisibilityControllerWidget r1, boolean r2, long r3) {
        this.this$0 = r1;
        this.$entiretyVisible = r2;
        this.$duration = r3;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r13) {
        Intrinsics.checkNotNullParameter(r13, "item");
        if (r13.o == true) goto L5;
        boolean r0 = this.$entiretyVisible;
    L9:
        int r2 = !r0;
        Integer r3 = (Integer) r13.f.getValue();
        if (r3 != null) goto L13;
    L15:
        r13.f.postValue(Integer.valueOf(r2));
        float r4 = 0.0f;
        if (r0 == 0) goto L18;
        float r8 = 0.0f;
    L19:
        int r5 = s1.g[r13.k.ordinal()];
        if (r5 == 1) goto L36;
        if (r5 != 2) goto L49;
        float r9 = (this.this$0.s - r13.c) + UtilityKotlinExtentionsKt.h(r13.l);
        if (this.$duration <= 0) goto L30;
        if (r0 == 0) goto L28;
        float r7 = UtilityKotlinExtentionsKt.h(-65);
    L29:
        ((ArrayList) this.this$0.u).add(PlayerVisibilityControllerWidget.xq(this.this$0, r13.i, r7, r8, r9, this.$duration));
        return;
    L28:
        r7 = 0.0f;
        goto L29
    L30:
        View r14 = r13.i;
        if (r0 != 0) goto L34;
        r4 = r9;
    L34:
        r14.setTranslationX(r4);
        return;
    L49:
        return;
    L36:
        if (this.$duration <= 0) goto L41;
        PlayerVisibilityControllerWidget r6 = this.this$0;
        View r10 = r13.i;
        Animator r1 = PlayerVisibilityControllerWidget.zq(r6, r10, r10.getTranslationX(), r8, this.$duration);
        PlayerVisibilityControllerWidget r11 = this.this$0;
        View r15 = r13.i;
        if (r0 == 0) goto L40;
        r4 = 1.0f;
    L40:
        Animator r16 = PlayerVisibilityControllerWidget.wq(r11, r15, r4, this.$duration);
        ((ArrayList) this.this$0.u).add(r1);
        ((ArrayList) this.this$0.u).add(r16);
        return;
    L41:
        View r12 = r13.i;
        if (r0 == 0) goto L44;
        r4 = 1.0f;
    L44:
        r12.setAlpha(r4);
        r13.i.setTranslationX(r8);
        return;
    L18:
        r8 = UtilityKotlinExtentionsKt.h(-65);
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
        invoke((com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r1);
        return Unit.INSTANCE;
    }
}
