package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.base.LivePrefStatus;
import com.bytedance.android.live.room.api.playopt.topspeed.base.LiveRiskStatus;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    public final a a;
    public final CompositeDisposable b;

    public final class a {
        public View a;
        public View b;
        public TextView c;
        public TextView d;
        public LinearLayout e;
        public LiveSwitchButton f;
        public LiveSwitchButton g;
        public LiveSwitchButton h;
        public boolean i;

        public a() {
        }

        public static void a(TextView r4, View r5) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.c.a).booleanValue() == false) goto L8;
            r4.setVisibility(8);
            if (r5 == null) goto L35;
            r5.setVisibility(8);
            return;
        L35:
            return;
        L8:
            r4.setVisibility(0);
            if (r5 == null) goto L11;
            r5.setVisibility(0);
        L11:
            Lazy r6 = TopSpeedModeUtils.a;
            TopSpeedModeManager r7 = TopSpeedModeManager.l;
            int r0 = ((Number) r7.e.a).intValue();
            int r1 = ((Number) r7.f.a).intValue();
            LivePrefStatus r2 = LivePrefStatus.PREF_NORMAL;
            if (r0 != r2.getCode()) goto L21;
            if (TopSpeedModeUtils.d().d() == false) goto L17;
        L19:
            String r3 = "当前性能状态良好，暂时无需开启";
        L27:
            r4.setText(r3);
            if (((Number) r7.e.a).intValue() == r2.getCode()) goto L30;
        L32:
            r4.setTextColor(ColorProtector.parseColor("#FE2C55"));
            return;
        L30:
            if (((Number) r7.f.a).intValue() != LiveRiskStatus.LOW_RISK.getCode()) goto L32;
            r4.setTextColor(KtvUtilsKt.f(2131107286));
            return;
        L17:
            if (r1 != LiveRiskStatus.HIGH_RISK.getCode()) goto L19;
            r3 = "卡顿发热耗电风险大，建议提前开启功能";
            goto L27
        L21:
            if (r0 != LivePrefStatus.PREF_MEDIUM.getCode()) goto L24;
        L25:
            r3 = "检测到轻微卡顿，开启后流畅看播";
            goto L27
        L24:
            if (r0 == LivePrefStatus.PREF_SERIOUS.getCode()) goto L25;
            r3 = "";
            goto L27
        }
    }

    public h() {
        this.a = new a();
        this.b = new CompositeDisposable();
    }
}
