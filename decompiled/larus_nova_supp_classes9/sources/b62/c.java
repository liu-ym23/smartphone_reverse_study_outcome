package b62;

import am2.x;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class c implements View.OnClickListener {
    public static boolean b = true;
    public static final b c = null;
    public final long a;

    /* JADX WARN: Type inference failed for: r0v0, types: [b62.b] */
    static {
        c = new b();
    }

    public c() {
        this.a = 1500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        if (b == false) goto L6;
        b = false;
        r6.postDelayed(c, this.a);
        z52.c r7 = (z52.c) this;
        z52.b r1 = r7.d;
        r1.getClass();
        BarrageSetting r2 = new BarrageSetting();
        r2.setBarrageArea(BarrageSettingArea.HALF);
        r2.setFontSize(BarrageSettingFont.MID);
        r2.setAlpha(75.0f);
        r2.setGiftOpen(true);
        r2.setChatChannelOpen(true);
        r1.y = r2;
        z52.b r3 = r7.d;
        r3.e(r3.y);
        r7.d.s.setOnSeekBarChangeListener(null);
        z52.b r4 = r7.d;
        r4.d(r4.y);
        z52.b r5 = r7.d;
        r5.s.setOnSeekBarChangeListener(r5.J);
        r7.d.getClass();
        j0.l().sendLog("livesdk_landscape_barrage_settings_default_setting_click", null, new Object[]{new x(), IRoom.class});
        f2.c("已恢复默认设置", 0);
        return;
    }
}
