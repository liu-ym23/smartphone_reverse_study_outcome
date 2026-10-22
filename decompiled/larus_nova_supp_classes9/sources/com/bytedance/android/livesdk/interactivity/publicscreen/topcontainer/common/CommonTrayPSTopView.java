package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.PSTopContainer;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import f52.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CommonTrayPSTopView extends j<n5> {
    public static final /* synthetic */ int s = 0;
    public final Handler n;
    public CommonTrayView o;
    public q4.b p;
    public q4.b q;
    public final com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a r;

    public static final class a {
    }

    static {
    }

    @Override // f52.c
    public final void a(DiscardReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        o("onDiscard. reason=" + r3);
    }

    @Override // f52.c
    public final void h(final f52.b r15) {
        Intrinsics.checkNotNullParameter(r15, "container");
        o("onShow id=" + this.a);
        n5.e r0 = ((n5) this.m).getDynamicConfig();
        Integer r1 = null;
        if (r0 == null) goto L5;
        final n5.b r5 = r0.comboInfo;
    L7:
        if (r5 == null) goto L35;
        List r2 = r5.numList;
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L35;
        List r4 = r5.durationList;
        if (r4 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L35;
        List r7 = r5.numList;
        if (r7 == null) goto L27;
        Integer r8 = Integer.valueOf(r7.size());
    L28:
        List r9 = r5.durationList;
        if (r9 == null) goto L31;
        Integer r10 = Integer.valueOf(r9.size());
    L33:
        if (Intrinsics.areEqual(r8, r10) == false) goto L35;
        final boolean r11 = true;
    L37:
        if (r11 == false) goto L54;
        Intrinsics.checkNotNull(r5);
        List r13 = r5.numList;
        if (r13 == null) goto L43;
        Long r14 = (Long) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L43;
        long r16 = r14.longValue();
    L44:
        long r17 = r5.seqId;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a r18 = this.r;
        long r19 = r18.a;
        if (r17 > r19) goto L51;
        if (r17 == r19) goto L48;
    L50:
        boolean r20 = false;
    L52:
        if (r20 == true) goto L64;
        ALogger.e("CommonTrayPSTopView", "combo is invalid. seqId=" + r5.seqId + " firstComboNum=" + r16 + " stats=" + this.r);
    L63:
        boolean r21 = false;
    L65:
        if (r21 == true) goto L68;
        r15.d(this);
        return;
    L68:
        ((n5) this.m).setShowTimestamp(System.currentTimeMillis());
        final CommonTrayView r23 = new CommonTrayView(r15.getContext(), null, 6, 0);
        r23.setComboStats(this.r);
        r15.b(this, r23, null);
        r23.c((n5) this.m);
        this.o = r23;
        final Function0<Unit> r24 = new CommonTrayPSTopView$onShow$1(this, r11, r5, r23, r15);
        n5.e r25 = ((n5) this.m).getDynamicConfig();
        if (r25 == null) goto L71;
        r1 = Integer.valueOf(r25.displayEffectType);
    L71:
        if (r1 != null) goto L74;
    L76:
        if (r1 != null) goto L79;
    L81:
        q4.b r110 = u4.c(new CommonTrayPSTopView$getEnterAnim$3(r23, r15, r24));
    L82:
        this.p = r110;
        r110.c();
        int r111 = b.a;
        n5 r112 = (n5) this.m;
        Intrinsics.checkNotNullParameter(r112, "msg");
        b.a("livesdk_common_tray_show", r112);
        return;
    L79:
        if (r1.intValue() != 2) goto L81;
        r110 = u4.c(new CommonTrayPSTopView$getEnterAnim$2(r23, r15, r24));
        goto L82
    L74:
        if (r1.intValue() != 1) goto L76;
        r110 = u4.c(new CommonTrayPSTopView$getEnterAnim$1(r23, r24));
    L64:
        r21 = true;
        goto L65
    L48:
        if (r16 < r18.b) goto L50;
    L51:
        r20 = true;
    L43:
        r16 = -1;
        goto L44
    L54:
        n5.e r26 = ((n5) this.m).getDynamicConfig();
        if (r26 == null) goto L57;
        long r27 = r26.endTimestamp;
    L59:
        if (r27 <= 0) goto L64;
        if (r27 > System.currentTimeMillis()) goto L64;
        ALogger.e("CommonTrayPSTopView", "timeout. endTimestamp=" + r27);
        goto L63
    L57:
        r27 = 0;
        goto L59
    L31:
        r10 = null;
        goto L33
    L27:
        r8 = null;
        goto L28
    L19:
        if (r4.isEmpty() == true) goto L22;
        r6 = false;
        goto L23
    L11:
        if (r2.isEmpty() == true) goto L14;
        r3 = false;
    L35:
        r11 = false;
        goto L37
    L5:
        r5 = null;
        goto L7
    }

    @Override // f52.c
    public final CleanStrategy i(f52.b r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        o("onShowFinish id=" + this.a);
        this.p = null;
        this.q = null;
        this.o = null;
        return CleanStrategy.REMOVE_WRAP_VIEW;
    }

    @Override // f52.j, f52.c
    public final boolean j(f52.c r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        if ((r6 instanceof CommonTrayPSTopView) == false) goto L51;
        n5.e r7 = ((n5) ((CommonTrayPSTopView) r6).m).getDynamicConfig();
        Long r0 = null;
        if (r7 == null) goto L7;
        n5.b r8 = r7.comboInfo;
    L9:
        if (r8 == null) goto L37;
        List r3 = r8.numList;
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L37;
        List r5 = r8.durationList;
        if (r5 != null) goto L21;
    L24:
        boolean r9 = true;
    L25:
        if (r9 == true) goto L37;
        List r10 = r8.numList;
        if (r10 == null) goto L29;
        Integer r11 = Integer.valueOf(r10.size());
    L30:
        List r13 = r8.durationList;
        if (r13 == null) goto L33;
        Integer r14 = Integer.valueOf(r13.size());
    L35:
        if (Intrinsics.areEqual(r11, r14) == false) goto L37;
        boolean r15 = true;
    L38:
        if (r15 == false) goto L52;
        if (r8 == null) goto L41;
        Long r16 = Long.valueOf(r8.seqId);
    L42:
        n5.e r17 = ((n5) this.m).getDynamicConfig();
        if (r17 == null) goto L48;
        n5.b r18 = r17.comboInfo;
        if (r18 == null) goto L48;
        r0 = Long.valueOf(r18.seqId);
    L48:
        if (Intrinsics.areEqual(r16, r0) == false) goto L53;
        return true;
    L53:
        return false;
    L41:
        r16 = null;
        goto L42
    L52:
        return false;
    L33:
        r14 = null;
        goto L35
    L29:
        r11 = null;
        goto L30
    L21:
        if (r5.isEmpty() == true) goto L24;
        r9 = false;
        goto L25
    L13:
        if (r3.isEmpty() == true) goto L16;
        r4 = false;
    L37:
        r15 = false;
        goto L38
    L7:
        r8 = null;
        goto L9
    L51:
        return false;
    }

    public final void o(String r2) {
        ALogger.i("CommonTrayPSTopView", r2);
    }

    public static final void n(final CommonTrayPSTopView r4, final f52.b r5) {
        r4.getClass();
        final Function0<Unit> r0 = new CommonTrayPSTopView$playExitAnim$1(r4, r5);
        final CommonTrayView r1 = r4.o;
        Integer r2 = null;
        if (r1 == null) goto L15;
        n5.e r3 = ((n5) r4.m).getDynamicConfig();
        if (r3 == null) goto L8;
        r2 = Integer.valueOf(r3.displayEffectType);
    L8:
        if (r2 != null) goto L11;
    L13:
        Integer r6 = u4.c(new CommonTrayPSTopView$getExitAim$2(r1, r0));
    L14:
        r2 = r6;
        goto L15
    L11:
        if (r2.intValue() != 2) goto L13;
        r6 = u4.c(new CommonTrayPSTopView$getExitAim$1(r1, r0));
    L15:
        if (r2 == null) goto L17;
        r4.q = r2;
        r2.c();
        return;
    L17:
        r4.o("exitAnim is null");
        r5.d(r4);
        Unit r7 = Unit.INSTANCE;
    }

    @Override // f52.c
    public final CleanStrategy b(f52.b r1, f52.c r2) {
        Intrinsics.checkNotNullParameter(r1, "container");
        o("onInterrupt id=" + this.a);
        q4.b r3 = this.p;
        if (r3 == null) goto L5;
        r3.a();
    L5:
        this.p = null;
        q4.b r4 = this.q;
        if (r4 == null) goto L8;
        r4.a();
    L8:
        this.q = null;
        this.n.removeCallbacksAndMessages(null);
        CommonTrayView r5 = this.o;
        if (r5 == null) goto L11;
        r5.e();
    L11:
        this.o = null;
        return CleanStrategy.REMOVE_WRAP_VIEW;
    }

    @Override // f52.j, f52.c
    public final void e(f52.c r10, PSTopContainer r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "container");
        if ((r10 instanceof CommonTrayPSTopView) == false) goto L47;
        StringBuilder r13 = new StringBuilder("onAssemble. msgId=");
        CommonTrayPSTopView r14 = (CommonTrayPSTopView) r10;
        r13.append(((n5) r14.m).getMessageId());
        o(r13.toString());
        CommonTrayView r15 = this.o;
        if (r15 == null) goto L48;
        n5.e r16 = ((n5) r14.m).getDynamicConfig();
        if (r16 == null) goto L9;
        n5.b r17 = r16.comboInfo;
    L11:
        if (r15.g == false) goto L49;
        if (r17 != null) goto L14;
        return;
    L14:
        if (r17.seqId == r15.e) goto L16;
        return;
    L16:
        if (r15.f >= ((ArrayList) r15.h).size()) goto L54;
        List r0 = r17.numList;
        if (r0 == null) goto L55;
        List r18 = r17.durationList;
        if (r18 != null) goto L25;
        return;
    L25:
        if (r0.isEmpty() == false) goto L27;
        return;
    L27:
        if (r0.size() == r18.size()) goto L30;
        return;
    L30:
        if (((ArrayList) r15.h).isEmpty() == false) goto L32;
    L40:
        ArrayList r1 = (ArrayList) r15.h;
        r1.addAll(r0);
        ArrayList r2 = (ArrayList) r15.i;
        r2.addAll(r18);
    L41:
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a r19 = r15.m;
        if (r19 == null) goto L53;
        r19.b = ((Number) CollectionsKt.last(r15.h)).longValue();
        return;
    L53:
        return;
    L32:
        if (((Number) ListProtector.get(r0, 0)).longValue() >= ((Number) CollectionsKt.last(r15.h)).longValue()) goto L40;
        int r3 = ((ArrayList) r15.h).size();
        int r4 = 0;
    L35:
        if (r4 >= r3) goto L41;
        if (((Number) ListProtector.get(r15.h, r4)).longValue() > ((Number) ListProtector.get(r0, 0)).longValue()) goto L38;
        r4 = r4 + 1;
        goto L35
    L38:
        ArrayList r5 = (ArrayList) r15.h;
        r5.addAll(r4, r0);
        ArrayList r6 = (ArrayList) r15.i;
        r6.addAll(r4, r18);
        goto L41
    L55:
        return;
    L54:
        return;
    L49:
        return;
    L9:
        r17 = null;
        goto L11
    L48:
        return;
    }

    public CommonTrayPSTopView(String r20, n5 r21, com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a r23) {
        Intrinsics.checkNotNullParameter(r20, "id");
        Intrinsics.checkNotNullParameter(r21, "msg");
        Intrinsics.checkNotNullParameter(r23, "comboStats");
        String r0 = r21.getScene();
        String r3 = r21.getSubScene();
        Intrinsics.checkNotNullParameter(r21, "$this$showPriority");
        n5.f r4 = r21.getPriorityConfig();
        if (r4 == null) goto L5;
        int r5 = r4.priority;
    L6:
        d r2 = new d(r0, r3, r5);
        n5.e r1 = r21.getDynamicConfig();
        if (r1 == null) goto L9;
        long r6 = r1.startTimestamp;
    L10:
        n5.e r7 = r21.getDynamicConfig();
        if (r7 == null) goto L13;
        int r8 = (int) r7.allowExceedTime;
    L14:
        n5.e r9 = r21.getDynamicConfig();
        if (r9 == null) goto L17;
        int r10 = r9.delayTime;
    L18:
        Intrinsics.checkNotNullParameter(r21, "$this$priorityLowerStrategy");
        n5.f r11 = r21.getPriorityConfig();
        if (r11 == null) goto L21;
        int r13 = r11.priorityLowerStrategy;
    L22:
        ConflictStrategy r14 = c.a(r13);
        Intrinsics.checkNotNullParameter(r21, "$this$priorityEqualStrategy");
        n5.f r15 = r21.getPriorityConfig();
        if (r15 == null) goto L25;
        int r16 = r15.priorityEqualStrategy;
    L26:
        ConflictStrategy r17 = c.a(r16);
        Intrinsics.checkNotNullParameter(r21, "$this$priorityHigherStrategy");
        n5.f r18 = r21.getPriorityConfig();
        if (r18 == null) goto L29;
        int r19 = r18.priorityHigherStrategy;
    L30:
        ConflictStrategy r110 = c.a(r19);
        Intrinsics.checkNotNullParameter(r21, "$this$isAssemble");
        n5.e r24 = r21.getDynamicConfig();
        if (r24 == null) goto L33;
        boolean r111 = r24.isAssemble;
    L34:
        int r25 = r8;
        int r26 = r10;
        boolean r112 = r111;
        super(r20, r2, r6, r25, r26, 0, 0, r14, r17, r110, r112, r21.getHighlightAreaPriorityConfig(), r21);
        this.r = r23;
        this.n = new Handler(Looper.getMainLooper());
        return;
    L33:
        r111 = false;
        goto L34
    L29:
        r19 = 2;
        goto L30
    L25:
        r16 = 1;
        goto L26
    L21:
        r13 = 0;
        goto L22
    L17:
        r10 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }
}
