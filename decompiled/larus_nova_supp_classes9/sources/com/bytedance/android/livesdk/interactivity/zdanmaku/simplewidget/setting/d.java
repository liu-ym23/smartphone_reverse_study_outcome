package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a {
    public Integer f;

    public static final class a implements ov2.a {
        public final /* synthetic */ d a;

        public final void a() {
        }

        public final void d(RangeSeekBar r1, float r2) {
        }

        public final void b() {
            d r0 = this.a;
            ChangeSettingSource r1 = ChangeSettingSource.SETTING_PANEL_LINE;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "source");
            r0.b.yR(r1);
            this.a.b.dR();
            this.a.f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", "slide"), TuplesKt.to("item_type", "show_area"), TuplesKt.to("old_show_area_level", String.valueOf(this.a.f)), TuplesKt.to("new_show_area_level", String.valueOf(this.a.a.d()))}));
            d r2 = this.a;
            r2.f = Integer.valueOf(r2.a.d());
        }

        public a(d r1) {
            this.a = r1;
        }

        public final void c(RangeSeekBar r2, int r3, boolean r4) {
            if (r4 == false) goto L4;
            return;
        L4:
            if (r2 == null) goto L6;
            int r5 = r2.getStepCount();
        L7:
            if (r5 <= 0) goto L20;
            this.a.getClass();
            int r6 = 1;
            if (r3 != 0) goto L11;
        L18:
            d r7 = this.a;
            r7.getClass();
            StringBuilder r8 = new StringBuilder();
            r8.append(r6);
            r8.append(34892);
            r7.k(r8.toString());
            this.a.a.j(r6);
            return;
        L11:
            if (r3 == 1) goto L17;
            r6 = 3;
            if (r3 == 2) goto L18;
            if (r3 != 3) goto L18;
            r6 = 4;
            goto L18
        L17:
            r6 = 2;
            goto L18
        L20:
            return;
        L6:
            r5 = 0;
            goto L7
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final int a() {
        return 2131363226;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void b() {
        f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", "reset"), TuplesKt.to("item_type", "show_area"), TuplesKt.to("old_show_area_level", String.valueOf(this.f)), TuplesKt.to("new_show_area_level", String.valueOf(this.a.d()))}));
        j();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final ov2.a g() {
        return new a(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final f h() {
        return new f(3, 262143);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final void j() {
        int r0 = this.a.d();
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        r1.append(34892);
        k(r1.toString());
        int r2 = 1;
        if (r0 != 1) goto L5;
        r2 = 0;
    L14:
        RangeSeekBar r3 = this.d;
        if (r3 == null) goto L17;
        r3.setStep(r2);
    L17:
        this.f = Integer.valueOf(r0);
        return;
    L5:
        if (r0 == 2) goto L14;
        if (r0 != 3) goto L9;
        r2 = 2;
        goto L14
    L9:
        if (r0 != 4) goto L14;
        r2 = 3;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final String i() {
        return s1.B(2131915293);
    }

    public d(o r2, SimpleZDanmakuSettingDialogFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r3, "panelCallback");
        super(r2, r3);
    }
}
