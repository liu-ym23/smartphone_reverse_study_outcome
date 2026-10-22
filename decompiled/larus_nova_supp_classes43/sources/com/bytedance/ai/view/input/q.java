package com.bytedance.ai.view.input;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class q implements View.OnTouchListener {
    public final /* synthetic */ ChatInput a;

    public /* synthetic */ q(ChatInput r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r11, MotionEvent r12) {
        ChatInput r0 = this.a;
        int r1 = ChatInput.v;
        int r10 = r12.getActionMasked();
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNull(r12);
        r0.getClass();
        int[] r13 = new int[2];
        r11.getLocationOnScreen(r13);
        boolean r14 = false;
        Pair r15 = new Pair(Float.valueOf(r13[0] + r12.getX()), Float.valueOf(r13[1] + r12.getY()));
        if (r10 == 0) goto L39;
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L10;
        if (r10 == 3) goto L15;
    L56:
        return true;
    L10:
        if ((System.currentTimeMillis() - r0.u) < 300) goto L56;
        Function3<Integer, Float, Float, Boolean> r16 = r0.getOnSpeakEvent();
        if (r16 == null) goto L56;
        Boolean r17 = (Boolean) r16.invoke(2, r15.getFirst(), r15.getSecond());
    L15:
        Function0<z0<FloatingChatStatus>> r18 = r0.getChatStatus();
        if (r18 == null) goto L20;
        z0 r19 = (z0) r18.invoke();
        if (r19 == null) goto L20;
        FloatingChatStatus r110 = (FloatingChatStatus) r19.getValue();
    L22:
        if (r110 != FloatingChatStatus.ON_SPEAK) goto L56;
        if (r0.k == false) goto L31;
        Function0<z0<FloatingChatStatus>> r111 = r0.getChatStatus();
        if (r111 == null) goto L36;
        z0 r112 = (z0) r111.invoke();
        if (r112 == null) goto L36;
        r112.tryEmit(FloatingChatStatus.READY_TO_INPUT);
    L36:
        Function3<Integer, Float, Float, Boolean> r113 = r0.getOnSpeakEvent();
        if (r113 == null) goto L56;
        Boolean r114 = (Boolean) r113.invoke(1, r15.getFirst(), r15.getSecond());
        goto L56
    L31:
        Function0<z0<FloatingChatStatus>> r115 = r0.getChatStatus();
        if (r115 == null) goto L36;
        z0 r116 = (z0) r115.invoke();
        if (r116 == null) goto L36;
        r116.tryEmit(FloatingChatStatus.READY_TO_SPEAK);
    L20:
        r110 = null;
        goto L22
    L39:
        long r20 = System.currentTimeMillis();
        if ((r20 - r0.u) < 300) goto L56;
        Function3<Integer, Float, Float, Boolean> r21 = r0.getOnSpeakEvent();
        if (r21 != null) goto L45;
    L47:
        if (r14 == false) goto L56;
        if (((z0) r0.getChatStatus().invoke()).getValue() != FloatingChatStatus.READY_TO_INPUT) goto L51;
        r0.k = true;
    L51:
        r0.u = r20;
        Function0<z0<FloatingChatStatus>> r117 = r0.getChatStatus();
        if (r117 == null) goto L56;
        z0 r118 = (z0) r117.invoke();
        if (r118 == null) goto L56;
        r118.tryEmit(FloatingChatStatus.ON_SPEAK);
        goto L56
    L45:
        if (((Boolean) r21.invoke(0, r15.getFirst(), r15.getSecond())).booleanValue() != true) goto L47;
        r14 = true;
        goto L47
    }
}
