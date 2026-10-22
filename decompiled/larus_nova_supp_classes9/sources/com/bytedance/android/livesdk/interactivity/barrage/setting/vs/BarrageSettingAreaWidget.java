package com.bytedance.android.livesdk.interactivity.barrage.setting.vs;

import a62.b;
import a62.c;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/BarrageSettingAreaWidget;", "Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/AbsBarrageSettingWidget;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarrageSettingAreaWidget extends AbsBarrageSettingWidget {
    public RadioGroup c;
    public RadioButton d;
    public RadioButton e;
    public RadioButton f;
    public RadioButton g;

    public static final class a implements Runnable {
        public final /* synthetic */ BarrageSettingAreaWidget a;

        public a(BarrageSettingAreaWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.zq();     // Catch: Throwable -> L6
            BarrageSettingAreaWidget r0 = this.a;     // Catch: Throwable -> L6
            RadioGroup r1 = r0.c;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.setOnCheckedChangeListener(new c(r0));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final int getLayoutId() {
        return 2131566811;
    }

    public final void onUnload() {
    }

    public final void zq() {
        BarrageSettingArea r0 = this.a.getBarrageArea();
        if (r0 == null) goto L34;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L8;
        RadioButton r2 = this.d;
        if (r2 == null) goto L33;
        r2.setChecked(true);
        return;
    L33:
        return;
    L8:
        if (r1 != 2) goto L10;
        RadioButton r3 = this.e;
        if (r3 == null) goto L31;
        r3.setChecked(true);
        return;
    L31:
        return;
    L10:
        if (r1 != 3) goto L12;
        RadioButton r4 = this.f;
        if (r4 == null) goto L29;
        r4.setChecked(true);
        return;
    L29:
        return;
    L12:
        if (r1 != 4) goto L35;
        RadioButton r5 = this.g;
        if (r5 == null) goto L27;
        r5.setChecked(true);
        return;
    L27:
        return;
    L35:
        return;
    }

    public final void onInit(Object[] r1) {
        this.c = (RadioGroup) findViewById(2131378225);
        this.d = (RadioButton) findViewById(2131378246);
        this.e = (RadioButton) findViewById(2131378250);
        this.f = (RadioButton) findViewById(2131378249);
        this.g = (RadioButton) findViewById(2131378248);
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

    public BarrageSettingAreaWidget(BarrageSetting r2, AbsBarrageSettingWidget.a r3) {
        Intrinsics.checkNotNullParameter(r2, "barrageSetting");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2, r3);
    }
}
