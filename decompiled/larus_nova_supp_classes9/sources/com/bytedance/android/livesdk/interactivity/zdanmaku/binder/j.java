package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends tk6.e<q72.b, View> {
    public final LinearLayout e;
    public final LinearLayout f;
    public final TextView g;
    public final ImageView h;
    public final LinearLayout i;
    public final TextView j;
    public final ImageView k;
    public final LinearLayout l;
    public final LinearLayout m;
    public boolean n;
    public int o;
    public List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> p;
    public com.bytedance.android.livesdk.interactivity.api.barrage.data.f q;
    public float r;
    public final BarrageWidgetContext s;

    public j(View r4, BarrageWidgetContext r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.s = r5;
        this.e = (LinearLayout) r4.findViewById(2131365237);
        this.f = (LinearLayout) r4.findViewById(2131367765);
        this.g = (TextView) r4.findViewById(2131374514);
        this.h = (ImageView) r4.findViewById(2131374513);
        this.i = (LinearLayout) r4.findViewById(2131367791);
        this.j = (TextView) r4.findViewById(2131392218);
        this.k = (ImageView) r4.findViewById(2131392217);
        this.l = (LinearLayout) r4.findViewById(2131392222);
        this.m = (LinearLayout) r4.findViewById(2131392223);
        this.r = 1.0f;
    }

    public final void b(Object r8, RenderEntity r9) {
        q72.b r10 = (q72.b) r8;
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r9, "entity");
        if (this.s == null) goto L63;
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);     // Catch: Exception -> L58
        com.bytedance.android.livesdk.interactivity.api.barrage.data.f r1 = null;
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r0, null, 0, 3);     // Catch: Exception -> L58
    L9:
        int r3 = a1.a;     // Catch: Exception -> L58
        if (a1.a.a().d() == false) goto L25;
        if (r2 == null) goto L13;
        Boolean r4 = r2.isVSRoom();     // Catch: Exception -> L58
    L15:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L25;
        if (Intrinsics.areEqual(r2.isPortraitInteraction(), Boolean.FALSE) == false) goto L25;
        pk6.a r5 = r9.e(pk6.a.class);     // Catch: Exception -> L58
        if (r5 == null) goto L25;
        BarrageSetting r6 = (BarrageSetting) l42.a.d.getValue();     // Catch: Exception -> L58
        if (r6 == null) goto L23;
        float r7 = r6.getAlpha();     // Catch: Exception -> L58
    L24:
        r5.a = (int) (r5.a * (r7 / 100.0f));     // Catch: Exception -> L58
        goto L25
    L23:
        r7 = 75;
        goto L24
    L13:
        r4 = null;
    L25:
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r11 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) this.s.getChatCarnivalMessage().getValue();     // Catch: Exception -> L58
        if (r11 != null) goto L28;
    L30:
        boolean r13 = false;
    L31:
        this.n = r13;     // Catch: Exception -> L58
        this.o = r10.e;     // Catch: Exception -> L58
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r14 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) this.s.getChatCarnivalMessage().getValue();     // Catch: Exception -> L58
        if (r14 == null) goto L36;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r15 = r14.q();     // Catch: Exception -> L58
        if (r15 == null) goto L36;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r16 = CollectionsKt.toMutableList(r15);     // Catch: Exception -> L58
    L37:
        this.p = r16;     // Catch: Exception -> L58
        if (r16 == null) goto L40;
        int r17 = r16.size();     // Catch: Exception -> L58
    L41:
        int r18 = this.o;     // Catch: Exception -> L58
        if (r18 >= r17) goto L61;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r19 = this.p;     // Catch: Exception -> L58
        if (r19 == null) goto L47;
        r1 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.f) ListProtector.get(r19, r18);     // Catch: Exception -> L58
    L47:
        this.q = r1;     // Catch: Exception -> L58
        this.r = ((Number) this.s.getScaleRate().getValue()).floatValue();     // Catch: Exception -> L58
        tc2.f r20 = (tc2.f) r9.e(tc2.f.class);     // Catch: Exception -> L58
        if (r20 == null) goto L52;
        Float r21 = r20.a;     // Catch: Exception -> L58
        if (r21 == null) goto L52;
        float r23 = r21.floatValue();     // Catch: Exception -> L58
    L53:
        this.r *= r23;     // Catch: Exception -> L58
        if (this.n == false) goto L56;
        this.f.setVisibility(8);     // Catch: Exception -> L58
        this.i.setVisibility(0);     // Catch: Exception -> L58
        d(this.j, this.k, this.n, r10);     // Catch: Exception -> L58
        return;
    L56:
        this.i.setVisibility(8);     // Catch: Exception -> L58
        this.f.setVisibility(0);     // Catch: Exception -> L58
        d(this.g, this.h, this.n, r10);     // Catch: Exception -> L58
        return;
    L52:
        r23 = 1.0f;
        goto L53
    L61:
        return;
    L40:
        r17 = 0;
    L36:
        r16 = null;
        goto L37
    L28:
        if (r11.z() != 1) goto L30;
        r13 = true;
        goto L31
    L8:
        r2 = null;
    L58:
        ALogger.e("CARNIVAL_MESSAGE", "bind danmaku error");
        return;
    }

    public final void d(TextView r5, ImageView r6, boolean r7, q72.b r8) {
        this.e.setBackground(null);
        int r0 = x52.a.a;
        r8.isSelfSendFake();
        r5.setText(x52.a.b(r8, r5.getTextSize(), r7));
        com.bytedance.android.livesdk.interactivity.api.barrage.data.f r1 = this.q;
        float r2 = 20.0f;
        if (r1 == null) goto L5;
        float r3 = r1.d();
    L6:
        r5.setTextSize(0, s1.f(r3 * this.r));
        com.bytedance.android.livesdk.interactivity.api.barrage.data.f r4 = this.q;     // Catch: Exception -> L14
        if (r4 == null) goto L11;
        String r9 = r4.c();     // Catch: Exception -> L14
        if (r9 == null) goto L11;
    L12:
        r5.setTextColor(Color.parseColor(r9));     // Catch: Exception -> L14
    L15:
        r5.setTypeface(Typeface.DEFAULT);
        if (r8.isSelfSendFake() == true) goto L18;
        r6.setVisibility(8);
    L24:
        Bitmap r10 = r8.b;
        if (r7 == false) goto L37;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.f r11 = this.q;
        if (r11 == null) goto L29;
        float r13 = r11.b();
    L30:
        int r14 = s1.f(r13);
        if (r10 == null) goto L35;
        byte[] r15 = r10.getNinePatchChunk();
        if (r15 == null) goto L35;
        Rect r16 = com.bytedance.android.livesdk.chatroom.utils.a1.i(r15);
        r14 = r14 - (r16.bottom + r16.top);
    L35:
        int r17 = (int) (r14 * this.r);
        ViewGroup.LayoutParams r18 = this.i.getLayoutParams();
        r18.height = r17;
        this.i.setLayoutParams(r18);
        int r19 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.m.measure(r19, r19);
        int r20 = this.m.getMeasuredWidth();
        int r21 = this.m.getMeasuredHeight();
        ViewGroup.LayoutParams r23 = this.l.getLayoutParams();
        r23.width = r21;
        r23.height = r21;
        this.l.setLayoutParams(r23);
        float r24 = r20 * 0.5f;
        this.l.setPivotX(r24);
        this.l.setPivotY(r24);
        this.i.setPadding(0, (this.i.getHeight() - this.m.getWidth()) / 2, 0, 0);
        goto L37
    L29:
        r13 = 36.0f;
    L37:
        if (s1.getResources() == null) goto L39;
        Resources r25 = s1.getResources();
        float r26 = WindowDisplayMetricsOverride.apply(r25, r25.getDisplayMetrics()).density / 3.0f;
    L40:
        float r27 = r26 * this.r;
        if (r10 == null) goto L46;
        s1.H(this.e, com.bytedance.android.livesdk.chatroom.utils.a1.h(r10, r27));
        return;
    L46:
        return;
    L39:
        r26 = 1.0f;
        goto L40
    L18:
        r6.setVisibility(0);
        com.bytedance.android.livesdk.interactivity.api.barrage.data.f r28 = this.q;
        if (r28 == null) goto L21;
        r2 = r28.e();
    L21:
        float r29 = r2 * this.r;
        Bitmap r30 = r8.a;
        if (r30 == null) goto L24;
        ViewGroup.LayoutParams r31 = r6.getLayoutParams();
        r31.height = s1.f(r29);
        r31.width = s1.f(r29);
        r6.setLayoutParams(r31);
        r6.setImageBitmap(r30);
    L11:
        r9 = "#FFFFFF";
    L14:
        r5.setTextColor(-1);
        goto L15
    L5:
        r3 = 20.0f;
        goto L6
    }
}
