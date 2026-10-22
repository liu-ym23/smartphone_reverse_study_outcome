package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.android.livesdk.y6;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e0 extends tk6.e<com.bytedance.android.livesdk.interactivity.zdanmaku.j, View> {
    public final StrokeColorTextView e;
    public final StrokeColorTextView f;
    public final StrokeColorTextView g;
    public final StrokeColorTextView h;
    public final StrokeColorTextView i;
    public final LinearLayout j;
    public final LinearLayout k;
    public final LinearLayout l;
    public final StrokeColorTextView[] m;
    public final h80.d<p22.k> n;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.widget.TextView, com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.widget.TextView, com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView] */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.widget.TextView, com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.widget.TextView, com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView] */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.widget.TextView, com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView] */
    public e0(View r13, h80.d<p22.k> r14) {
        Intrinsics.checkNotNullParameter(r13, "itemView");
        Intrinsics.checkNotNullParameter(r14, "danmakuSettingConfigSupplier");
        super(r13, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.n = r14;
        StrokeTextView r15 = (StrokeColorTextView) r13.findViewById(2131387748);
        StrokeTextView r0 = (StrokeColorTextView) r13.findViewById(2131387749);
        ?? r1 = (StrokeColorTextView) r13.findViewById(2131387750);
        this.e = r1;
        ?? r3 = (StrokeColorTextView) r13.findViewById(2131387751);
        this.f = r3;
        StrokeTextView r4 = (StrokeColorTextView) r13.findViewById(2131387752);
        StrokeTextView r5 = (StrokeColorTextView) r13.findViewById(2131387753);
        ?? r6 = (StrokeColorTextView) r13.findViewById(2131387754);
        this.g = r6;
        StrokeTextView r7 = (StrokeColorTextView) r13.findViewById(2131387755);
        StrokeTextView r8 = (StrokeColorTextView) r13.findViewById(2131387756);
        ?? r9 = (StrokeColorTextView) r13.findViewById(2131387757);
        this.h = r9;
        ?? r10 = (StrokeColorTextView) r13.findViewById(2131387758);
        this.i = r10;
        this.j = (LinearLayout) r13.findViewById(2131379426);
        this.k = (LinearLayout) r13.findViewById(2131387759);
        this.l = (LinearLayout) r13.findViewById(2131387760);
        this.m = new StrokeColorTextView[]{r15, r0, r1, r3, r4, r5, r6, r7, r8, r9, r10};
        r15.setAlpha(0.7f);
        r0.setAlpha(1.0f);
        r1.setAlpha(0.7f);
        r3.setAlpha(1.0f);
        r4.setAlpha(1.0f);
        r5.setAlpha(0.7f);
        r6.setAlpha(1.0f);
        r7.setAlpha(1.0f);
        r8.setAlpha(0.8f);
        r9.setAlpha(0.7f);
        r10.setAlpha(1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17, types: [android.text.SpannableString, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView[]] */
    public final void b(Object r8, RenderEntity r9) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.j r10 = (com.bytedance.android.livesdk.interactivity.zdanmaku.j) r8;
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r9, "entity");
        p22.k r11 = (p22.k) this.n.get();
        StrokeTextView[] r0 = this.m;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        StrokeTextView r4 = r0[r3];
        r4.setTextSize(0, r11.d.c);
        r4.setText(r10.a.getContent());
        r4.setVisibility(0);
        r3 = r3 + 1;
        goto L3
    L5:
        int r5 = x52.a.a;
        s3 r13 = r10.a;
        float r6 = r11.d.c;
        Intrinsics.checkNotNullParameter(r13, "privilegeScreenChatMessage");
        String r7 = r13.getContent();
        CharSequence r14 = BuildConfig.FLAVOR;
        ?? r15 = r7;
        if (r7 != null) goto L10;
        r15 = BuildConfig.FLAVOR;
    L10:
        if (r13.getRenderSpan() != null) goto L12;
    L18:
        SpannableString r16 = ab2.a.f(r15, r6);
        if (r16 == null) goto L21;
        r14 = r16;
    L21:
        ?? r17 = this.m;
        int r18 = r17.length;
        int r19 = 0;
    L22:
        if (r19 >= r18) goto L24;
        r17[r19].setText(r14);
        r19 = r19 + 1;
        goto L22
    L24:
        String r20 = r14.toString();
        ArrayList r21 = (ArrayList) ab2.a.d(r20);
        Iterator r23 = r21.iterator();
        int r24 = 0;
    L26:
        if (r23.hasNext() == false) goto L28;
        db2.a r25 = (db2.a) r23.next();
        r24 = r24 + (r25.c - r25.b);
        goto L26
    L28:
        int r26 = r21.size() + (r20.length() - r24);
        if (r26 <= 5) goto L32;
        this.f.setVisibility(8);
        this.i.setVisibility(8);
    L32:
        if (r26 <= 10) goto L35;
        this.e.setVisibility(8);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
    L35:
        if (r11.b != BarrageSettingFont.SMALL) goto L41;
        ViewGroup.LayoutParams r27 = this.j.getLayoutParams();
        if (r27 == null) goto L40;
        LinearLayout.LayoutParams r28 = (LinearLayout.LayoutParams) r27;
        r28.setMargins(0, s1.f(4.0f), 0, s1.f(5.0f));
        this.j.setLayoutParams(r28);
    L44:
        p22.k.b r29 = r11.d;
        int r30 = r29.f;
        int r31 = r29.g;
        ViewGroup.LayoutParams r33 = this.k.getLayoutParams();
        if (r33 == null) goto L55;
        LinearLayout.LayoutParams r34 = (LinearLayout.LayoutParams) r33;
        r34.setMargins(r30, 0, 0, 0);
        this.k.setLayoutParams(r34);
        ViewGroup.LayoutParams r35 = this.l.getLayoutParams();
        if (r35 == null) goto L53;
        LinearLayout.LayoutParams r36 = (LinearLayout.LayoutParams) r35;
        r36.setMargins(r31, 0, 0, 0);
        this.l.setLayoutParams(r36);
        StrokeColorTextView[] r37 = this.m;
        int r38 = r37.length;
    L49:
        if (r2 >= r38) goto L51;
        StrokeColorTextView r39 = r37[r2];
        r39.x(s1.f(0.5f), r11.d.i);
        r39.setTextColor(r11.d.h);
        r2 = r2 + 1;
        goto L49
    L51:
        return;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L55:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L41:
        ViewGroup.LayoutParams r40 = this.j.getLayoutParams();
        if (r40 == null) goto L57;
        LinearLayout.LayoutParams r41 = (LinearLayout.LayoutParams) r40;
        r41.setMargins(0, s1.f(3.0f), 0, s1.f(7.0f));
        this.j.setLayoutParams(r41);
        goto L44
    L57:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L12:
        if (((Boolean) y6.a.getValue()).booleanValue() == false) goto L14;
        r15 = new SpannableString(r13.getRenderSpan());
    L15:
        ForegroundColorSpan[] r43 = (ForegroundColorSpan[]) r15.getSpans(0, r15.length(), ForegroundColorSpan.class);
        int r44 = r43.length;
        int r45 = 0;
    L16:
        if (r45 >= r44) goto L18;
        r15.removeSpan(r43[r45]);
        r45 = r45 + 1;
        goto L16
    L14:
        r15 = new SpannableString(String.valueOf(r13.getRenderSpan()));
        goto L15
    }
}
