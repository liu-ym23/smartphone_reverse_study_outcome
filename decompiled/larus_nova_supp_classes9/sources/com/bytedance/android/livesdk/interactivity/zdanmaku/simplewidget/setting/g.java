package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a {
    public String f;

    public static final class a implements ov2.a {
        public final /* synthetic */ g a;

        public final void a() {
        }

        public final void d(RangeSeekBar r1, float r2) {
        }

        public final void b() {
            g r0 = this.a;
            ChangeSettingSource r1 = ChangeSettingSource.SETTING_PANEL_SPEED;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "source");
            r0.b.yR(r1);
            this.a.b.dR();
            g r2 = this.a;
            g r3 = this.a;
            String r4 = r3.l(r3.a.e());
            this.a.f = r4;
            Unit r5 = Unit.INSTANCE;
            r2.f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", "slide"), TuplesKt.to("item_type", "move_speed"), TuplesKt.to("old_move_speed_level", String.valueOf(this.a.f)), TuplesKt.to("new_move_speed_level", r4)}));
        }

        public a(g r1) {
            this.a = r1;
        }

        public final void c(RangeSeekBar r1, int r2, boolean r3) {
            if (r3 == false) goto L4;
            return;
        L4:
            if (r1 == null) goto L6;
            int r4 = r1.getStepCount();
        L7:
            if (r4 <= 0) goto L26;
            this.a.getClass();
            if (r2 != 0) goto L11;
            float r5 = 0.6f;
        L24:
            g r6 = this.a;
            r6.k(r6.l(r5));
            this.a.a.k(r5);
            return;
        L11:
            if (r2 != 1) goto L13;
            r5 = 0.8f;
            goto L24
        L13:
            if (r2 != 2) goto L15;
        L21:
            r5 = 1.0f;
            goto L24
        L15:
            if (r2 != 3) goto L17;
            r5 = 1.2f;
            goto L24
        L17:
            if (r2 != 4) goto L21;
            r5 = 1.4f;
            goto L24
        L26:
            return;
        L6:
            r4 = 0;
            goto L7
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final int a() {
        return 2131387092;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void b() {
        f(MapsKt.mapOf(new Pair[]{TuplesKt.to("change_type", "reset"), TuplesKt.to("item_type", "move_speed"), TuplesKt.to("old_move_speed_level", String.valueOf(this.f)), TuplesKt.to("new_move_speed_level", l(this.a.e()))}));
        j();
    }

    public final String l(float r3) {
        if (r3 != 0.6f) goto L6;
        return "慢";
    L6:
        if (r3 != 0.8f) goto L9;
        return "较慢";
    L9:
        if (r3 != 1.0f) goto L12;
    L20:
        return "适中";
    L12:
        if (r3 != 1.2f) goto L15;
        return "较快";
    L15:
        if (r3 != 1.4f) goto L20;
        return "快";
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final ov2.a g() {
        return new a(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final f h() {
        return new f(4, 262143);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final void j() {
        float r0 = this.a.e();
        String r1 = l(r0);
        this.f = r1;
        Unit r2 = Unit.INSTANCE;
        k(r1);
        if (r0 != 0.6f) goto L6;
        int r3 = 0;
    L18:
        RangeSeekBar r4 = this.d;
        if (r4 == null) goto L22;
        r4.setStep(r3);
        return;
    L22:
        return;
    L6:
        if (r0 != 0.8f) goto L9;
        r3 = 1;
        goto L18
    L9:
        if (r0 != 1.0f) goto L12;
    L17:
        r3 = 2;
        goto L18
    L12:
        if (r0 != 1.2f) goto L15;
        r3 = 3;
        goto L18
    L15:
        if (r0 != 1.4f) goto L17;
        r3 = 4;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.a
    public final String i() {
        return s1.B(2131915298);
    }

    public g(o r2, SimpleZDanmakuSettingDialogFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r3, "panelCallback");
        super(r2, r3);
    }
}
