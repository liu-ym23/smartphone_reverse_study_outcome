package a62;

import am2.x;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.VSLiveLandscapeBarrageSettingDialog;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ VSLiveLandscapeBarrageSettingDialog a;

    public i(VSLiveLandscapeBarrageSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        VSLiveLandscapeBarrageSettingDialog r6 = this.a;
        int r0 = VSLiveLandscapeBarrageSettingDialog.m;
        r6.getClass();
        BarrageSetting r7 = BarrageSetting.getDefaultVSLiveSetting();
        VSLiveLandscapeBarrageSettingDialog r1 = this.a;
        r1.h = r7;
        r1.X50(r7);
        WidgetManager r2 = this.a.l;
        if (r2 == null) goto L12;
        List r3 = r2.widgets;
        if (r3 == null) goto L12;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        AbsBarrageSettingWidget r8 = (Widget) r4.next();
        if ((r8 instanceof AbsBarrageSettingWidget) == false) goto L8;
        r8.xq(r7);
    L12:
        xs2.b.a().post(new q22.b(r7));
        f2.c("已恢复默认设置", 0);
        String r9 = this.a.k;
        if (r9 != null) goto L15;
        r9 = BuildConfig.FLAVOR;
    L15:
        j0.l().sendLog("livesdk_landscape_barrage_settings_default_setting_click", MapsKt.mapOf(TuplesKt.to("request_page", r9)), new Object[]{new x(), IRoom.class});
    }
}
