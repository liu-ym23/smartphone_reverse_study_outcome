package y42;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import d52.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BaseStyleSettingModel<d52.a> {
    public static final String b = null;
    public static final a c = null;

    static {
        c = new a();
        b = "public_screen_style_audience_font_size";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final c a() {
        float r0 = q.i();
        if (r0 != 1.15f) goto L6;
        return d52.a.C0224a.b;
    L6:
        if (r0 != 1.3f) goto L9;
        return d52.a.b.b;
    L9:
        return d52.a.c.a;
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final String c() {
        return b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final c d(int r2) {
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L11;
        return d52.a.c.a;
    L11:
        return d52.a.b.b;
    L9:
        return d52.a.C0224a.b;
    }
}
