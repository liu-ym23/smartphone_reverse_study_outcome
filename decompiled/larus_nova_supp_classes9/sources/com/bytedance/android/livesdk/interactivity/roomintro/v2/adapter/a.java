package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.config.gr0;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.IntroGuideButton;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int f = 0;
    public String a;
    public final RoomIntroDataSource b;
    public final TextCorrectionEditText c;
    public final TextView d;
    public final ViewGroup e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a$a, reason: collision with other inner class name */
    public static final class C0219a {
    }

    static {
    }

    public final int b() {
        return ((com.bytedance.android.livesdk.interactivity.api.settings.config.d) this.b.a.getValue()).a();
    }

    public final void c() {
        boolean r2 = true;
        if (((Boolean) gr0.a.getValue()).booleanValue() == false) goto L15;
        TextCorrectionEditText r0 = this.c;
        if (r0 == null) goto L15;
        r0.setListener(new h(this));
        r0.setPopDown(false);
        r0.setAdjustSize(true);
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r4 = this.b.n;
        if (r4 == null) goto L9;
        String r5 = r4.c();
    L10:
        r0.setLiveType(r5);
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r6 = this.b.n;
        if (r6 == null) goto L13;
        String r7 = r6.a();
    L14:
        r0.setCurrentUserId(r7);
        r0.addTextChangedListener(new i(r0, this));
        goto L15
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
    L15:
        TextView r1 = this.d;
        if (r1 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r1);
    L18:
        TextCorrectionEditText r3 = this.c;
        if (r3 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r3);
    L21:
        TextCorrectionEditText r8 = this.c;
        if (r8 == null) goto L24;
        r8.addTextChangedListener(new e(this));
    L24:
        TextCorrectionEditText r9 = this.c;
        if (r9 == null) goto L27;
        r9.setOnEditorActionListener(f.a);
    L27:
        String r10 = this.b.o.e();
        if (r10 != null) goto L30;
    L33:
        if (r2 == true) goto L35;
        d(this.b.o.e(), false);
    L35:
        TextView r11 = this.d;
        if (r11 == null) goto L38;
        r11.setText(this.a);
    L38:
        TextView r13 = this.d;
        if (r13 == null) goto L41;
        r13.setHint(((com.bytedance.android.livesdk.interactivity.api.settings.config.d) this.b.a.getValue()).e());
    L41:
        TextCorrectionEditText r14 = this.c;
        if (r14 == null) goto L44;
        r14.setHint(((com.bytedance.android.livesdk.interactivity.api.settings.config.d) this.b.a.getValue()).e());
    L44:
        TextView r15 = this.d;
        if (r15 == null) goto L47;
        r15.setOnClickListener(new g(this));
    L47:
        List<IntroGuideButton> r16 = this.b.r;
        if (r16 == null) goto L70;
        Iterator<T> r17 = r16.iterator();
    L51:
        if (r17.hasNext() == false) goto L78;
        final IntroGuideButton r18 = (IntroGuideButton) r17.next();
        ViewGroup r19 = this.e;
        if (r19 == null) goto L64;
        Context r20 = r19.getContext();
        if (r20 == null) goto L64;
        View r21 = LayoutInflater.from(r20).inflate(2131566149, this.e, false);
        if (r21 == null) goto L62;
        TextView r23 = (TextView) r21.findViewById(2131374109);
        if (r23 == null) goto L62;
        r23.setText(r18.getButtonText());
    L62:
        if (r21 == null) goto L65;
        r21.setOnClickListener(x0.a(new RoomIntroEditViewAdapter$createGuideButton$2(this, r18)));
    L65:
        if (r21 == null) goto L51;
        ViewGroup r24 = this.e;
        if (r24 == null) goto L51;
        r24.addView(r21);
    L64:
        r21 = null;
        goto L65
    L78:
        return;
    L70:
        return;
    L30:
        if (r10.length() == 0) goto L33;
        r2 = false;
        goto L33
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        boolean r0 = UIUtils.isViewVisible(this.c);
        String r1 = BuildConfig.FLAVOR;
        if (r0 == false) goto L18;
        TextCorrectionEditText r2 = this.c;
        if (r2 == null) goto L12;
        Editable r4 = r2.getText();
        if (r4 == null) goto L12;
        String r5 = r4.toString();
        if (r5 == null) goto L12;
        r1 = r5;
    L12:
        String r6 = r1.concat(r3);
        TextCorrectionEditText r7 = this.c;
        if (r7 == null) goto L15;
        r7.setText(r6);
    L15:
        TextCorrectionEditText r8 = this.c;
        if (r8 == null) goto L33;
        r8.setSelection(RangesKt.coerceAtMost(r6.length(), b()));
        return;
    L33:
        return;
    L18:
        String r9 = this.a;
        if (r9 == null) goto L22;
        r1 = r9;
    L22:
        boolean r10 = true;
        d(r1.concat(r3), true);
        String r11 = this.a;
        if (r11 != null) goto L25;
    L28:
        if (r10 == true) goto L35;
        TextView r13 = this.d;
        if (r13 == null) goto L36;
        r13.setText(this.a);
        return;
    L36:
        return;
    L35:
        return;
    L25:
        if (r11.length() == 0) goto L28;
        r10 = false;
        goto L28
    }

    public final void d(String r2, boolean r3) {
        if (r3 == true) goto L5;
        this.a = r2;
        return;
    L5:
        int r4 = b();
        if (r2 != null) goto L8;
    L11:
        this.a = r2;
        return;
    L8:
        if (r2.length() <= r4) goto L11;
        this.a = r2.substring(0, r4);
        f2.c(s1.C(2131919924, new Object[]{Integer.valueOf(r4)}), 0);
    }

    public a(RoomIntroDataSource r2, TextCorrectionEditText r3, TextView r4, WrapLineFlowLayout r5) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
