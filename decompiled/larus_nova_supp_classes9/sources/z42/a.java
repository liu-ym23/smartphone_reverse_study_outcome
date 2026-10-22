package z42;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.f;
import com.bytedance.android.livesdk.interactivity.api.settings.config.l0;
import com.bytedance.android.livesdk.sharedpref.e;
import d52.b;
import d52.c;
import java.util.HashMap;
import r52.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BaseStyleSettingModel<b> {
    public static final String b = null;
    public static final a c = null;

    static {
        c = new a();
        b = "public_screen_style_audience_height";
    }

    public final b e() {
        int r0 = f.a;
        if (((Boolean) new e("audience_public_screen_setting_saved", Boolean.FALSE).getValue()).booleanValue() == true) goto L28;
        String r1 = (String) ((HashMap) l42.a.b.getValue()).get("public_screen_operate_freq");
        if (r1 != null) goto L7;
        r1 = "0";
    L7:
        int r2 = r1.hashCode();
        if (r2 == 49) goto L16;
        if (r2 == 51) goto L13;
    L18:
        int r3 = ((l0) q.a.getValue()).normaFreq;
    L20:
        if (r3 == 1) goto L26;
        if (r3 == 2) goto L30;
        return b.C0225b.a;
    L30:
        return b.a.b;
    L26:
        return b.c.b;
    L13:
        if (r1.equals("3") == false) goto L18;
        r3 = ((l0) q.a.getValue()).highFreq;
        goto L20
    L16:
        if (r1.equals("1") == false) goto L18;
        r3 = ((l0) q.a.getValue()).lowFreq;
        goto L20
    L28:
        return (b) super.b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final /* bridge */ /* synthetic */ c b() {
        return e();
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final c a() {
        return b.c.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final String c() {
        return b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final c d(int r2) {
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L11;
        return b.C0225b.a;
    L11:
        return b.a.b;
    L9:
        return b.c.b;
    }
}
