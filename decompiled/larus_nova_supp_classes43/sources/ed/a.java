package ed;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.k;
import com.bytedance.android.btm.bridge.HybridSchemaHelper;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements j8.b {
    public a() {
    }

    @Override // j8.b
    public final void a(View r10, String r11) {
        BtmSetting r0 = BtmSetting.d;
        Uri r12 = null;
        boolean r13 = true;
        if (r0.c().c().F().f() == 1) goto L5;
    L13:
        if (r10 == null) goto L23;
        k r1 = BtmSDK.INSTANCE.getOnHybridContainerLoadSchemaCallback();
        if (r11 == null) goto L17;
        String r14 = r11;
    L18:
        Map<View, String> r15 = HybridSchemaHelper.a;
        if (r11 == null) goto L21;
        r12 = UriProtector.parse(r11);
    L21:
        k.a.a(r1, r14, r10, HybridSchemaHelper.b(r10, r12));
        return;
    L17:
        r14 = "";
        goto L18
    L23:
        return;
    L5:
        if (r0.c().b().h() == 1) goto L8;
        r13 = false;
    L8:
        Map<View, String> r16 = HybridSchemaHelper.a;
        if (r11 == null) goto L11;
        Uri r17 = UriProtector.parse(r11);
    L12:
        HybridSchemaHelper.a(r10, r17, r13);
        goto L13
    L11:
        r17 = null;
        goto L12
    }

    @Override // j8.b
    public final void b(View r10, String r11) {
        if (r10 == null) goto L13;
        k r0 = BtmSDK.INSTANCE.getOnHybridContainerLoadSchemaCallback();
        if (r11 == null) goto L6;
        String r1 = r11;
    L7:
        Map<View, String> r12 = HybridSchemaHelper.a;
        if (r11 == null) goto L10;
        Uri r13 = UriProtector.parse(r11);
    L11:
        k.a.a(r0, r1, r10, HybridSchemaHelper.b(r10, r13));
        return;
    L10:
        r13 = null;
        goto L11
    L6:
        r1 = "";
        goto L7
    }

    @Override // j8.b
    public final void onAttachView(View r10, String r11) {
        if (BtmSetting.d.c().c().F().g() != 1) goto L10;
        Map<View, String> r0 = HybridSchemaHelper.a;
        if (r11 == null) goto L7;
        Uri r12 = UriProtector.parse(r11);
    L8:
        HybridSchemaHelper.a(r10, r12, false);
        return;
    L7:
        r12 = null;
        goto L8
    }
}
