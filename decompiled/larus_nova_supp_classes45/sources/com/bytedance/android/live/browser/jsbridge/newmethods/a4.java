package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a4 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final Fragment a;
    public TokenCert b;

    public final void onTerminate() {
    }

    public final void k() {
        if (this.a == null) goto L5;
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.PICK");
        r0.addCategory("android.intent.category.DEFAULT");
        r0.setType("vnd.android.cursor.dir/phone_v2");
        this.a.startActivityForResult(r0, 998);
        return;
    L5:
        finishWithFailure();
    }

    public a4(Fragment r2) {
        this.b = TokenCert.with("bpea-live_getContactMethod_jsb_get_read_contacts");
        this.a = r2;
    }

    public final void invoke(Object r4, CallContext r5) throws Exception {
        JSONObject r6 = (JSONObject) r4;
        if (r5 != null) goto L5;
    L19:
        finishWithFailure();
        return;
    L5:
        if ((r5.getContext() instanceof Activity) == false) goto L19;
        String r7 = r6.optString("token", "");
        if (r7 != null) goto L10;
    L12:
        Activity r8 = (Activity) r5.getContext();
        AlertDialog.setNightMode(new y3());
        if (Build.VERSION.SDK_INT < 23) goto L16;
        SettingKey<Boolean> r9 = m60.i.a;
        new m60.i.b(r8).b(new z3(this), null, this.b, new String[]{"android.permission.READ_CONTACTS"});
        return;
    L16:
        if (m60.c.d(r8, new String[]{"android.permission.READ_CONTACTS"}) == false) goto L18;
        k();
        return;
    L18:
        finishWithFailure();
        return;
    L10:
        if (r7.isEmpty() == true) goto L12;
        this.b = TokenCert.with(r7);
        goto L12
    }

    public static Cursor j(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r11 = new f06.b();
        f06.d r15 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r11);
        if (r15.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r11, false);
        return (Cursor) r15.b;
    L6:
        Cursor r16 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r16, r11, true);
        return r16;
    }
}
