package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.PrivilegeDanmakuType;
import com.bytedance.android.livesdk.x6;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f0 extends com.bytedance.live.zdanmaku.data.b<com.bytedance.android.livesdk.interactivity.zdanmaku.j> {
    public final e0 a;
    public final g0 b;
    public final c c;
    public final d d;
    public final View e;
    public final View f;
    public final h80.d<p22.k> g;
    public final BarrageWidgetContext h;

    public final List b(Object r10) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.j r11 = (com.bytedance.android.livesdk.interactivity.zdanmaku.j) r10;
        Intrinsics.checkNotNullParameter(r11, "data");
        long r0 = r11.a.getStyle();
        View r5 = null;
        if (r0 != 3) goto L11;
        com.bytedance.android.livesdk.interactivity.zdanmaku.units.c r1 = new com.bytedance.android.livesdk.interactivity.zdanmaku.units.c(r11, this.a);
        com.bytedance.android.livesdk.interactivity.zdanmaku.units.f r2 = new com.bytedance.android.livesdk.interactivity.zdanmaku.units.f(r11, this.b, true);
        BarrageWidgetContext r13 = this.h;
        if (r13 == null) goto L9;
        com.bytedance.live.datacontext.n<View> r14 = r13.getScrollBarrageView();
        if (r14 == null) goto L9;
        r5 = (View) r14.getValue();
    L9:
        r2.l = r5;
        return CollectionsKt.listOf(new tk6.b[]{r1, r2});
    L11:
        if (r0 != 2) goto L19;
        com.bytedance.android.livesdk.interactivity.zdanmaku.units.f r3 = new com.bytedance.android.livesdk.interactivity.zdanmaku.units.f(r11, this.c, false);
        BarrageWidgetContext r4 = this.h;
        if (r4 == null) goto L17;
        com.bytedance.live.datacontext.n<View> r6 = r4.getScrollBarrageView();
        if (r6 == null) goto L17;
        r5 = (View) r6.getValue();
    L17:
        r3.l = r5;
        return CollectionsKt.listOf(new tk6.b[]{new tk6.b(r11, this.c), r3});
    L19:
        if (r0 != 1) goto L27;
        com.bytedance.android.livesdk.interactivity.zdanmaku.units.f r7 = new com.bytedance.android.livesdk.interactivity.zdanmaku.units.f(r11, this.c, false);
        BarrageWidgetContext r8 = this.h;
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.n<View> r9 = r8.getScrollBarrageView();
        if (r9 == null) goto L25;
        r5 = (View) r9.getValue();
    L25:
        r7.l = r5;
        return CollectionsKt.listOf(new tk6.b[]{new tk6.b(r11, this.d), r7});
    L27:
        return CollectionsKt.emptyList();
    }

    public final void a(RenderEntity r21, Object r23) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.j r2 = (com.bytedance.android.livesdk.interactivity.zdanmaku.j) r23;
        Intrinsics.checkNotNullParameter(r21, "entity");
        Intrinsics.checkNotNullParameter(r2, "data");
        r21.b(DanmakuType.Privilege);
        r21.a(tc2.h.class, new tc2.h(r2.a.getMessageId()));
        if (r2.a.getStyle() != 3) goto L5;
        r21.a(tc2.i.class, new tc2.i(((p22.k) this.g.get()).f));
        r21.b(PrivilegeDanmakuType.MultiLine);
    L6:
        BarrageWidgetContext r3 = this.h;
        if (r3 != null) goto L9;
    L13:
        s3 r4 = r2.a;
        if (r4.isInsert() == true) goto L16;
    L23:
        r21.a(tc2.e.class, new tc2.e(r4.getReceiveTime(), r4.getConsumeTime(), r4.getDanmakuReceiveTime()));
        return;
    L16:
        if (r4.getHttpSendTime() <= 0) goto L23;
        if (r4.getReceiveTime() <= r4.getHttpSendTime()) goto L23;
        String r9 = com.bytedance.android.livesdk.interactivity.api.monitor.a.a(r4);
        long r10 = r4.getHttpSendTime();
        long r13 = r4.getReceiveTime();
        long r14 = r4.getStartSendTime();
        long r16 = r4.getApiSuccessTime();
        String r5 = r4.getMessageMethod();
        if (r5 != null) goto L22;
        r5 = "--default--";
    L22:
        r21.a(tc2.j.class, new tc2.j(r9, r10, r13, r14, r16, r5, 64));
        goto L23
    L9:
        if (r3.isPortrait() == true) goto L13;
        pk6.a r6 = (pk6.a) this.h.getDanmakuAlpha().getValue();
        if (r6 == null) goto L13;
        r21.a(pk6.a.class, r6);
        goto L13
    L5:
        r21.a(tc2.i.class, new tc2.i(((p22.k) this.g.get()).g));
        r21.b(PrivilegeDanmakuType.SingleLine);
        goto L6
    }

    public f0(View r5, View r6, h80.d<p22.k> r7, BarrageWidgetContext r8) {
        Intrinsics.checkNotNullParameter(r5, "atmosphereView");
        Intrinsics.checkNotNullParameter(r6, "normalView");
        Intrinsics.checkNotNullParameter(r7, "danmakuSettingConfigSupplier");
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        boolean r1 = false;
        if (((Boolean) x6.a.getValue()).booleanValue() == false) goto L12;
        StrokeTextView r0 = (StrokeColorTextView) r6.findViewById(2131362306);
        if (r0 == null) goto L12;
        r0.setIncludeFontPadding(true);
        r0.setSingleLine(false);
        AppCompatTextView r3 = r0.getOutlineTextView();
        if (r3 == null) goto L9;
        r3.setIncludeFontPadding(true);
    L9:
        AppCompatTextView r2 = r0.getOutlineTextView();
        if (r2 == null) goto L12;
        r2.setSingleLine(false);
    L12:
        this.a = new e0(r5, r7);
        if (r8 == null) goto L15;
        boolean r4 = r8.isAnchor();
    L16:
        this.b = new g0(r6, r4, r7);
        if (r8 == null) goto L19;
        boolean r9 = r8.isAnchor();
    L20:
        this.c = new c(r6, r9, r7);
        if (r8 == null) goto L23;
        r1 = r8.isAnchor();
    L23:
        this.d = new d(r6, r1, r7);
        return;
    L19:
        r9 = false;
        goto L20
    L15:
        r4 = false;
        goto L16
    }
}
