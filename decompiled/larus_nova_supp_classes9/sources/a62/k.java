package a62;

import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.VSLiveLandscapeBarrageSettingDialog;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements Runnable {
    public final /* synthetic */ VSLiveLandscapeBarrageSettingDialog a;

    public k(VSLiveLandscapeBarrageSettingDialog r1) {
        this.a = r1;
    }

    public final void a() {
        VSLiveLandscapeBarrageSettingDialog r0 = this.a;
        int r1 = VSLiveLandscapeBarrageSettingDialog.m;
        r0.getClass();
        Boolean r2 = (Boolean) l42.a.g.getValue();
        WidgetManager r3 = r0.l;
        if (r3 == null) goto L12;
        List r4 = r3.widgets;
        if (r4 == null) goto L18;
        Iterator r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L19;
        AbsBarrageSettingWidget r6 = (Widget) r5.next();
        if ((r6 instanceof AbsBarrageSettingWidget) == false) goto L8;
        r6.yq(r2.booleanValue());
        goto L8
    L19:
        return;
    L18:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
