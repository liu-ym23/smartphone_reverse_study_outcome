package uc0;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class b extends ns0.b {
    public b() {
    }

    public void modifyLayoutParamsIfIMButton(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r2 = null;
    L5:
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
        if (r3 == null) goto L9;
        r3.weight = ((Number) LiveConfigSettingKeys.SETTINGS_IM_WIDTH_WEIGHT.getValue()).floatValue();
        return;
    }
}
