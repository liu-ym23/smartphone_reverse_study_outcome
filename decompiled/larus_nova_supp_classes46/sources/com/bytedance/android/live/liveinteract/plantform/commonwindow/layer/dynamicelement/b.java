package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkbase.api.SeatItemId;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import nh0.c;
import py.k;
import tf0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.a<MultiLinkNormalEmptyViewBinder.a> {
    public IVoiceLiveTheme b;
    public String c;
    public int d;
    public int e;
    public k f;
    public int g;
    public Integer h;
    public final int i;
    public final ImageView j;
    public final TextView k;
    public final ImageView l;
    public final boolean m;

    public static final class a {
    }

    static {
    }

    public final c b() {
        MultiLinkNormalEmptyViewBinder.a r0 = (MultiLinkNormalEmptyViewBinder.a) this.a;
        d r1 = null;
        if (r0 == null) goto L7;
        HashMap<String, d> r2 = r0.i;
        if (r2 == null) goto L7;
        d r3 = r2.get(SeatItemId.EMPTY_INFO.name());
    L9:
        if ((r3 instanceof c) == false) goto L13;
        r1 = r3;
    L13:
        return (c) r1;
    L7:
        r3 = null;
        goto L9
    }

    public final String c() {
        return this.k.getText().toString();
    }

    public final boolean a() {
        if (b() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void h() {
        c r0 = b();
        if (r0 != null) goto L5;
        k r1 = this.f;
        if (r1 == null) goto L25;
        this.f = r1;
        if (a() == false) goto L27;
        ImageUtil.loadImage(this.j, r1, 0);
    L27:
        if (this.m == false) goto L29;
        int r2 = this.d;
        ViewGroup.LayoutParams r3 = this.j.getLayoutParams();
        r3.width = r2;
        r3.height = r2;
        this.j.setLayoutParams(r3);
    L29:
        g(this.c);
        Integer r4 = this.h;
        if (r4 == null) goto L34;
        Intrinsics.checkNotNull(r4);
        int r5 = r4.intValue();
        this.h = Integer.valueOf(r5);
        ImageView r6 = this.l;
        if (r6 == null) goto L39;
        r6.setBackgroundResource(r5);
    L39:
        this.k.setTextColor(this.i);
        IVoiceLiveTheme r7 = this.b;
        if (r7 == null) goto L45;
        f(r7);
        return;
    L45:
        return;
    L34:
        int r8 = this.g;
        this.g = r8;
        if (a() == false) goto L39;
        ImageView r9 = this.l;
        if (r9 == null) goto L39;
        r9.setBackgroundColor(r8);
        goto L39
    L25:
        d(this.e);
        goto L27
    L5:
        if (TextUtils.isEmpty(r0.h()) == true) goto L8;
        this.k.setText(r0.h());
    L8:
        if (TextUtils.isEmpty(r0.i()) == true) goto L13;
        ImageView r10 = this.j;
        int r11 = qy.a.a;
        ImageUtil.loadImage(r10, qy.a.a(r0.i()), 0);
        if (this.m == false) goto L13;
        int r12 = this.d / 2;
        ViewGroup.LayoutParams r13 = this.j.getLayoutParams();
        r13.width = r12;
        r13.height = r12;
        this.j.setLayoutParams(r13);
    L13:
        if (TextUtils.isEmpty(r0.g()) == true) goto L18;
        ImageView r14 = this.l;
        if (r14 == null) goto L18;
        r14.setBackgroundColor(ColorProtector.parseColor(r0.g()));
    L18:
        if (TextUtils.isEmpty(r0.j()) == true) goto L43;
        this.k.setTextColor(ColorProtector.parseColor(r0.j()));
        return;
    }

    public final void d(int r2) {
        this.e = r2;
        if (a() == false) goto L6;
        this.j.setImageResource(r2);
        return;
    }

    public final void e(int r2) {
        this.j.setVisibility(r2);
    }

    public final void f(IVoiceLiveTheme r4) {
        this.b = r4;
        if (a() == false) goto L39;
        MultiLinkNormalEmptyViewBinder.a r0 = (MultiLinkNormalEmptyViewBinder.a) this.a;
        if (r0 == null) goto L7;
        int r1 = r0.b();
    L8:
        boolean r2 = false;
        if (r1 < 0) goto L25;
        if (r4 == null) goto L14;
        List r3 = r4.getIconMicNormals();
        if (r3 == null) goto L14;
        int r5 = r3.size();
    L15:
        if (r1 >= r5) goto L25;
        if (r4 == null) goto L20;
        List r6 = r4.getIconMicNormals();
        if (r6 == null) goto L20;
        k r7 = (k) ListProtector.get(r6, r1);
    L22:
        if (IVoiceLiveTheme.Companion.isImageModelValid(r7) == false) goto L25;
        if (r7 == null) goto L25;
        ImageUtil.loadImage(this.j, r7, 0);
    L20:
        r7 = null;
    L14:
        r5 = 0;
    L25:
        if (r4 == null) goto L35;
        String r8 = r4.getColorMicText();
        if (r8 == null) goto L35;
        if (r8.length() <= 0) goto L31;
        r2 = true;
    L31:
        if (r2 != true) goto L35;
        this.k.setTextColor(Color.parseColor(r4.getColorMicText()));     // Catch: Exception -> L34
        return;
    L34:
        ALogger.e("LinkSeatEmptyElement", "set color mic failed, color is " + r4.getColorMicText());
        return;
    L35:
        this.k.setTextColor(this.i);
        return;
    L7:
        r1 = -1;
        goto L8
    }

    public final void g(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.c = r2;
        if (a() == false) goto L8;
        this.k.setText(r2);
        return;
    }

    public b(ImageView r2, TextView r3, ImageView r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "emptyAvatarIv");
        Intrinsics.checkNotNullParameter(r3, "emptyTipsTv");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r6;
        this.c = s1.B(2131919833);
        this.d = s1.j(2131169246);
        this.e = r5;
        this.g = ColorProtector.parseColor("#1AFFFFFF");
        this.i = ColorProtector.parseColor("#87FFFFFF");
    }
}
