package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a {
    public Integer f;

    public static final class a {
    }

    public static final class b implements ov2.a {
        public final /* synthetic */ c a;

        public final void a() {
        }

        public final void c(RangeSeekBar r1, int r2, boolean r3) {
        }

        public final void b() {
            c r0 = this.a;
            ChangeSettingSource r1 = ChangeSettingSource.SETTING_PANEL_ALPHA;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "source");
            r0.b.yR(r1);
            this.a.b.dR();
            this.a.f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", "slide"), TuplesKt.to("item_type", "opacity"), TuplesKt.to("old_opacity_level", String.valueOf(this.a.f)), TuplesKt.to("new_opacity_level", String.valueOf(MathKt.roundToInt(this.a.a.b())))}));
            c r2 = this.a;
            r2.f = Integer.valueOf(MathKt.roundToInt(r2.a.b()));
        }

        public b(c r1) {
            this.a = r1;
        }

        public final void d(RangeSeekBar r3, float r4) {
            if (r3 == null) goto L4;
            int r5 = r3.getStepCount();
        L5:
            if (r5 > 0) goto L8;
            this.a.getClass();
            int r6 = MathKt.roundToInt((((int) r4) * 0.8f) + 20.0f);
            c r7 = this.a;
            r7.getClass();
            r7.k(String.valueOf(r6) + "%");
            this.a.a.g((float) r6);
            return;
        L8:
            return;
        L4:
            r5 = 0;
            goto L5
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final int a() {
        return 2131362540;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void b() {
        f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", "reset"), TuplesKt.to("item_type", "opacity"), TuplesKt.to("old_opacity_level", String.valueOf(this.f)), TuplesKt.to("new_opacity_level", String.valueOf(MathKt.roundToInt(this.a.b())))}));
        j();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final ov2.a g() {
        return new b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final f h() {
        return new f(0, 524287);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final void j() {
        float r0 = this.a.b();
        int r1 = MathKt.roundToInt((r0 - 20.0f) / 0.8f);
        k(String.valueOf(MathKt.roundToInt(r0)) + "%");
        float r2 = (float) r1;
        RangeSeekBar r3 = this.d;
        if (r3 == null) goto L5;
        r3.setProgress(r2);
    L5:
        this.f = Integer.valueOf(MathKt.roundToInt(r0));
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final String i() {
        return s1.B(2131915292);
    }

    public c(o r2, SimpleZDanmakuSettingDialogFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r3, "panelCallback");
        super(r2, r3);
    }
}
