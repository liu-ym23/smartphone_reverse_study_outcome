package com.larus.bmhome.view;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageList$i implements ViewTreeObserver.OnPreDrawListener {
    public int a;
    public final /* synthetic */ ChatMessageList b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ ChatMessageList$ChatLayoutManager d;
    public final /* synthetic */ int e;
    public final /* synthetic */ List<String> f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ChatMessageList r1 = this.b;
        if (r1.t == this.c) goto L6;
        r1.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L6:
        View r2 = this.d.findViewByPosition(this.e);
        if (this.a < 2) goto L9;
        boolean r3 = true;
    L11:
        if (r2 == null) goto L55;
        ChatMessageList r8 = this.b;
        ChatMessageList$ChatLayoutManager r9 = this.d;
        int r10 = this.e;
        List<String> r11 = this.f;
        r8.getClass();
        ChatMessageList$d r12 = ChatMessageList.D(r2, r11, true, "highlight_span");
        if (r12 != null) goto L23;
        if (r3 == false) goto L22;
        ChatMessageList$d r4 = ChatMessageList.D(r2, r11, false, "text_candidate");
        if (r4 != null) goto L21;
        r4 = ChatMessageList.C(r2, true);
        if (r4 != null) goto L21;
        r4 = ChatMessageList.C(r2, false);
    L21:
        r12 = r4;
        goto L23
    L22:
        r12 = null;
    L23:
        if (r12 == null) goto L51;
        View r5 = r12.a;
        int r13 = 0;
    L26:
        if (r5 == null) goto L34;
        if (Intrinsics.areEqual(r5, r2) == true) goto L34;
        r13 = r13 + (r5.getTop() - r5.getScrollY());
        Object r6 = r5.getParent();
        if ((r6 instanceof View) == true) goto L31;
        r5 = null;
        goto L26
    L31:
        r5 = (View) r6;
    L34:
        if (Intrinsics.areEqual(r5, r2) == false) goto L36;
        Integer r7 = Integer.valueOf(r13);
    L37:
        if (r7 == null) goto L51;
        int r14 = r7.intValue() + r12.b;
        int r15 = (r8.getHeight() - r8.getPaddingTop()) - r8.getPaddingBottom();
        boolean r16 = r12.d;
        if (r16 == false) goto L41;
        int r17 = r8.getPaddingTop();
    L43:
        if (r2.getHeight() > r15) goto L49;
        int r18 = r8.getHeight() - r2.getHeight();
        if (r10 != 0) goto L47;
        int r19 = i5.h();
    L48:
        int r20 = r18 - r19;
    L50:
        FLogger.a.d("search_landing", "text landing offset position=" + r10 + ", off=" + r20 + ", anchorY=" + r17 + ", targetTopInHolder=" + r14 + ", lineTop=" + r12.b + ", targetView=" + r12.a.getClass().getSimpleName() + ", holderHeight=" + r2.getHeight() + ", source=" + r12.c + ", blockTarget=" + r16);
        r9.scrollToPositionWithOffset(r10, r20);
        boolean r21 = true;
    L52:
        if (r21 == false) goto L55;
        ChatMessageList r22 = this.b;
        r22.u = this.g;
        r22.v = this.e;
        r22.t = null;
        r22.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    L47:
        r19 = 0;
        goto L48
    L49:
        r20 = ((r8.getHeight() - r2.getHeight()) - r17) + r14;
        goto L50
    L41:
        r17 = r8.getPaddingTop() + ((int) (RangesKt.coerceAtLeast(r15, 0) * 0.25f));
        goto L43
    L36:
        r7 = null;
    L51:
        r21 = false;
    L55:
        int r23 = this.a + 1;
        this.a = r23;
        if (r23 < 5) goto L72;
        ChatMessageList r24 = this.b;
        r24.t = null;
        r24.getViewTreeObserver().removeOnPreDrawListener(this);
        String r25 = this.g;
        if (r25 != null) goto L60;
    L63:
        if (r2 == null) goto L70;
        ChatMessageList r26 = this.b;
        int r27 = this.e;
        String r28 = this.h;
        ChatMessageList$ChatLayoutManager r110 = this.d;
        int r111 = r26.getHeight() - r2.getHeight();
        if (r27 != 0) goto L67;
        int r29 = i5.h();
    L68:
        int r112 = r111 - r29;
        FLogger.a.d("search_landing", "text landing fallback message offset position=" + r27 + ", off=" + r112 + ", waitCount=" + this.a + ", keyword=" + ChatMessageList.b0(r26, r28));
        r110.scrollToPositionWithOffset(r27, r112);
        return false;
    L67:
        r29 = 0;
        goto L68
    L70:
        FLogger.a.d("search_landing", "text landing give up waiting holder position=" + this.e + ", waitCount=" + this.a + ", keyword=" + ChatMessageList.b0(this.b, this.h));
        return true;
    L60:
        if (Intrinsics.areEqual(this.b.u, r25) == false) goto L63;
        FLogger.a.d("search_landing", "skip text landing fallback after landed targetMessageId=" + this.g + ", landedPosition=" + this.b.v + ", retryPosition=" + this.e + ", waitCount=" + this.a + ", keyword=" + ChatMessageList.b0(this.b, this.h));
        return true;
    L72:
        boolean r30 = true;
        FLogger r31 = FLogger.a;
        StringBuilder r32 = new StringBuilder("text landing wait target position=");
        r32.append(this.e);
        r32.append(", holderReady=");
        if (r2 != null) goto L76;
        r30 = false;
    L76:
        r32.append(r30);
        r32.append(", waitCount=");
        r32.append(this.a);
        r32.append(", keyword=");
        r32.append(ChatMessageList.b0(this.b, this.h));
        r31.d("search_landing", r32.toString());
        return false;
    L9:
        r3 = false;
        goto L11
    }

    public ChatMessageList$i(ChatMessageList r1, Object r2, ChatMessageList$ChatLayoutManager r3, int r4, List<String> r5, String r6, String r7) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
    }
}
