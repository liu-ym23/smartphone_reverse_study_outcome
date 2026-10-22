package com.larus.bmhome.chat.layout.widget.handler;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.deepsearch.DeepSearchLoadingView;
import com.larus.common_ui.widget.roundlayout.RoundImageView;
import com.larus.mainbot.impl.databinding.LarusDeepSearchLoadingBinding;
import com.larus.platform.service.c1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements pw8.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ f.a b;
    public final /* synthetic */ f c;

    /* JADX WARN: Type inference failed for: r9v6, types: [com.larus.bmhome.chat.layout.widget.handler.h] */
    public final void a(ViewGroup r18) {
        Intrinsics.checkNotNullParameter(r18, "parent");
        LinearLayout r2 = new LinearLayout(this.a);
        boolean r3 = true;
        r2.setOrientation(1);
        TextView r4 = new TextView(this.a);
        Context r5 = this.a;
        r4.setText(r5.getResources().getString(2131909113));
        r4.setTextSize(20.0f);
        r4.setTextColor(ContextCompat.getColor(r5, v19.c.b(2130972079, r5, 2131103136)));
        r4.setPadding(i5.Y(), i5.Q(), 0, i5.h());
        r4.setTypeface(Typeface.DEFAULT_BOLD);
        r2.addView(r4);
        if (Intrinsics.areEqual(this.b.c(), Boolean.TRUE) == false) goto L9;
        final DeepSearchLoadingView r6 = new DeepSearchLoadingView(this.a, null);
        final LarusDeepSearchLoadingBinding r7 = r6.a;
        r7.c.cancelAnimation();
        LottieAdapterView r9 = r7.c;
        Intrinsics.checkNotNull(r9);
        e1.x(r9);
        r9.setRepeatCount(-1);
        r9.setRepeatMode(1);
        boolean r10 = v19.h.a;
        if (v19.h.b(r9.getContext()) == false) goto L7;
        String r11 = "lottie/sparkle_dark.json";
    L8:
        r9.setAnimation(r11);
        r9.playAnimation();
        final RoundImageView r12 = r7.b;
        final int r13 = r12.getResources().getColor(v19.c.b(2130970533, null, 2131102542));
        final int r14 = r12.getResources().getColor(v19.c.b(2130972086, null, 2131103159));
        final Ref.BooleanRef r15 = new Ref.BooleanRef();
        r15.element = true;
        final ValueAnimator r8 = ValueAnimator.ofArgb(new int[]{r13, r14});
        r8.setDuration(1000);
        r8.setRepeatCount(-1);
        r8.addUpdateListener(new com.larus.bmhome.chat.deepsearch.h(r12, r15, r14, r13, r8, r6, r7));
        r8.start();
        r2.addView(r6);
    L18:
        r18.addView(r2);
        return;
    L7:
        r11 = "lottie/sparkle_light.json";
        goto L8
    L9:
        FrameLayout r16 = new FrameLayout(this.a);
        r16.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        if ((this.a.getResources().getConfiguration().uiMode & 48) == 32) goto L13;
        r3 = false;
    L13:
        Uri.Builder r17 = UriProtector.parse(this.b.b()).buildUpon();
        if (r3 == false) goto L16;
        String r19 = "dark";
    L17:
        final Uri r20 = r17.appendQueryParameter("appTheme", r19).appendQueryParameter("mindmapMarkdown", this.b.a()).build();
        FLogger.a.d(this.c.b, "[biz_deep_search] finalUrl = " + r20 + "...");
        ImageView r21 = new ImageView(this.a);
        Context r22 = this.a;
        r21.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (((double) m0.b(r22)) * 0.75d)));
        r21.setBackground(ContextCompat.getDrawable(r22, v19.c.b(2130970793, r22, 2131239553)));
        r21.setOnClickListener(new g(r20));
        c1 r23 = c1.a;
        Context r24 = this.a;
        String r25 = r20.toString();
        final f r26 = this.c;
        r16.addView(r23.c(r24, r25, new h(r26)));
        r16.addView(r21);
        r2.addView(r16);
        goto L18
    L16:
        r19 = "light";
        goto L17
    }

    public final void b(int r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "currentViewGroup");
    }

    public i(Context r1, f.a r2, f r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
