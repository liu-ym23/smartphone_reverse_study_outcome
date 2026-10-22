package a62;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.VSLiveLandscapeBarrageSettingDialog;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ VSLiveLandscapeBarrageSettingDialog a;

    public j(VSLiveLandscapeBarrageSettingDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        VSLiveLandscapeBarrageSettingDialog r0 = this.a;
        BarrageSetting r5 = ((q22.b) r4).a;
        int r1 = VSLiveLandscapeBarrageSettingDialog.m;
        r0.getClass();
        boolean r6 = VSLiveLandscapeBarrageSettingDialog.S90(r5, BarrageSetting.getDefaultVSLiveSetting());
        View r2 = r0.g;
        if (r2 == null) goto L8;
        if (r6 == false) goto L6;
        float r3 = 0.5f;
    L7:
        r2.setAlpha(r3);
        goto L8
    L6:
        r3 = 1.0f;
    L8:
        View r7 = r0.g;
        if (r7 == null) goto L12;
        r7.setClickable(!r6);
        return;
    }
}
