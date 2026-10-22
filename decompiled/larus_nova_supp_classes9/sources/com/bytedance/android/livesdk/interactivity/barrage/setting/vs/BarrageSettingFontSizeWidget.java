package com.bytedance.android.livesdk.interactivity.barrage.setting.vs;

import a62.e;
import a62.f;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.barrage.setting.InterceptConstraintLayout;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import com.bytedance.android.livesdk.widget.rangeseekbar.SeekBar;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ov2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/BarrageSettingFontSizeWidget;", "Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/AbsBarrageSettingWidget;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarrageSettingFontSizeWidget extends AbsBarrageSettingWidget {
    public RangeSeekBar c;
    public TextView d;

    public static final class a implements Runnable {
        public final /* synthetic */ BarrageSettingFontSizeWidget a;

        public a(BarrageSettingFontSizeWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BarrageSettingFontSizeWidget r0 = this.a;     // Catch: Throwable -> L10
            RangeSeekBar r1 = r0.c;     // Catch: Throwable -> L10
            if (r1 == null) goto L5;
            r1.setStepCount(2);     // Catch: Throwable -> L10
        L5:
            RangeSeekBar r2 = r0.c;     // Catch: Throwable -> L10
            if (r2 == null) goto L8;
            r2.setOnRangeChangedListener(new f(r0));     // Catch: Throwable -> L10
        L8:
            this.a.zq();     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public final int getLayoutId() {
        return 2131566814;
    }

    public final void onUnload() {
    }

    public final void zq() {
        BarrageSettingFont r0 = this.a.getFontSize();
        TextView r1 = this.d;
        if (r1 == null) goto L15;
        int r2 = e.a[r0.ordinal()];
        if (r2 != 1) goto L7;
        String r3 = "小号";
    L14:
        r1.setText(r3);
        goto L15
    L7:
        if (r2 != 2) goto L9;
    L12:
        r3 = "中号";
        goto L14
    L9:
        if (r2 != 3) goto L12;
        r3 = "大号";
    L15:
        RangeSeekBar r4 = this.c;
        if (r4 == null) goto L19;
        r4.setStep(r0.getLevel());
        return;
    }

    public final void onInit(Object[] r5) {
        RangeSeekBar r6 = findViewById(2131386798);
        if (r6 == null) goto L33;
        r6.setGravity(2);
        r6.setSeekBarMode(1);
        Context r1 = r6.getContext();
        if (r1 == null) goto L9;
        Resources r2 = r1.getResources();
        if (r2 == null) goto L9;
        r6.setProgressColor(r2.getColor(2131106876));
    L9:
        Context r3 = r6.getContext();
        if (r3 == null) goto L14;
        Resources r4 = r3.getResources();
        if (r4 == null) goto L14;
        r6.setProgressDefaultColor(r4.getColor(2131106877));
    L14:
        r6.setProgressHeight(c.b(r6.getContext(), 3.0f));
        r6.setProgressRadius(c.b(r6.getContext(), 2.0f));
        r6.setStepCircleStyle(true);
        r6.setStepsColor(-1);
        r6.setStepsHeight(c.b(r6.getContext(), 3.0f));
        r6.setStepsWidth(c.b(r6.getContext(), 3.0f));
        SeekBar r7 = r6.getLeftSeekBar();
        if (r7 == null) goto L17;
        r7.t = c.b(r6.getContext(), 14.0f);
    L17:
        SeekBar r8 = r6.getLeftSeekBar();
        if (r8 == null) goto L20;
        r8.s = c.b(r6.getContext(), 14.0f);
    L20:
        SeekBar r9 = r6.getRightSeekBar();
        if (r9 == null) goto L23;
        r9.t = c.b(r6.getContext(), 14.0f);
    L23:
        SeekBar r10 = r6.getRightSeekBar();
        if (r10 == null) goto L26;
        r10.s = c.b(r6.getContext(), 14.0f);
    L26:
        SeekBar r11 = r6.getLeftSeekBar();
        if (r11 == null) goto L29;
        r11.a = 1;
    L29:
        SeekBar r13 = r6.getRightSeekBar();
        if (r13 == null) goto L32;
        r13.a = 1;
    L32:
        Unit r0 = Unit.INSTANCE;
    L34:
        this.c = r6;
        this.d = (TextView) findViewById(2131373135);
        return;
    L33:
        r6 = null;
        goto L34
    }

    public final void onLoad(Object[] r2) {
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L6;
        r3.post(new a(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget
    public final void xq(BarrageSetting r2) {
        Intrinsics.checkNotNullParameter(r2, "barrageSetting");
        Intrinsics.checkNotNullParameter(r2, "barrageSetting");
        this.a = r2;
        zq();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.bytedance.android.livesdk.interactivity.barrage.setting.InterceptConstraintLayout] */
    @Override // com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget
    public final void yq(boolean r3) {
        Object r0 = ((Widget) this).contentView;
        if ((r0 instanceof InterceptConstraintLayout) == true) goto L5;
        r0 = null;
    L5:
        ?? r1 = (InterceptConstraintLayout) r0;
        if (r1 == 0) goto L13;
        r1.setmIsIntercept(r3);
        if (r3 == false) goto L10;
        float r4 = 0.5f;
    L11:
        r1.setAlpha(r4);
        return;
    L10:
        r4 = 1.0f;
        goto L11
    }

    public BarrageSettingFontSizeWidget(BarrageSetting r2, AbsBarrageSettingWidget.a r3) {
        Intrinsics.checkNotNullParameter(r2, "barrageSetting");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2, r3);
    }
}
