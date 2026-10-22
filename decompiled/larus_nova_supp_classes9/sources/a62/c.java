package a62;

import android.widget.RadioGroup;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.BarrageSettingAreaWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import java.util.List;
import zg1.e3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ BarrageSettingAreaWidget a;

    public c(BarrageSettingAreaWidget r1) {
        this.a = r1;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup r6, int r7) {
        boolean r8 = false;
        if (r7 != 2131378246) goto L6;
        this.a.a.setBarrageArea(BarrageSettingArea.CLOSE);
    L14:
        BarrageSettingAreaWidget r1 = this.a;
        r1.b.X50(r1.a);
        this.a.wq();
        BarrageSettingAreaWidget r2 = this.a;
        if (r7 != 2131378246) goto L17;
        boolean r9 = true;
    L18:
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r0 = l42.a.g;
        Boolean r3 = Boolean.valueOf(r9);
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r3);
        xs2.b.a().post(new e3(r9, 0, "vs"));
        if (r9 == true) goto L28;
        int r10 = a1.a;
        if (a1.a.a().d() == true) goto L29;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r11 = q.b();
        if (r11 == null) goto L29;
        m<Boolean> r13 = r11.isCarnivalStarted();
        if (r13 == null) goto L29;
        if (((Boolean) r13.getValue()).booleanValue() == true) goto L28;
    L29:
        Widget.WidgetCallback r14 = ((Widget) r2).widgetCallback;
        if (r14 == null) goto L41;
        WidgetManager r15 = r14.getWidgetManager();
        if (r15 == null) goto L47;
        List r16 = r15.widgets;
        if (r16 == null) goto L48;
        Iterator r17 = r16.iterator();
    L37:
        if (r17.hasNext() == false) goto L49;
        AbsBarrageSettingWidget r4 = (Widget) r17.next();
        if ((r4 instanceof AbsBarrageSettingWidget) == false) goto L37;
        r4.yq(r8);
        goto L37
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L41:
        return;
    L28:
        r8 = true;
        goto L29
    L17:
        r9 = false;
        goto L18
    L6:
        if (r7 != 2131378250) goto L9;
        this.a.a.setBarrageArea(BarrageSettingArea.TOP);
        this.a.a.setNeedRollback(false);
        goto L14
    L9:
        if (r7 != 2131378249) goto L12;
        this.a.a.setBarrageArea(BarrageSettingArea.HALF);
        this.a.a.setNeedRollback(false);
        goto L14
    L12:
        if (r7 != 2131378248) goto L14;
        this.a.a.setBarrageArea(BarrageSettingArea.FULL);
        this.a.a.setNeedRollback(false);
        goto L14
    }
}
