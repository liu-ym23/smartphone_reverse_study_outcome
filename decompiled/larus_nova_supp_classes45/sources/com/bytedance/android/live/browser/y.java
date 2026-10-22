package com.bytedance.android.live.browser;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.jsbridge.newmethods.a4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y extends y6.b<a4> {
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ Context c;

    public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
        return new a4(this.b);
    }

    public y(Fragment r1, FragmentActivity r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void onActivityResult(int r6, int r7, Intent r8) {
        a4 r9 = (a4) ((y6.b) this).a;
        if (r9 == null) goto L34;
        Context r0 = this.c;
        if (r6 != 998) goto L35;
        if (r8 == null) goto L36;
        Uri r11 = r8.getData();     // Catch: Exception -> L27
        ContentResolver r12 = r0.getContentResolver();     // Catch: Exception -> L27
        Cursor r3 = null;
        if (r11 == null) goto L11;
        Cursor r13 = a4.j(r12, r11, new String[]{"display_name", "data1"});     // Catch: Exception -> L27
        String r14 = null;
        r3 = r13;
        String r15 = null;
    L13:
        if (r3.moveToNext() == false) goto L15;
        r14 = r3.getString(r3.getColumnIndex("display_name"));     // Catch: Exception -> L27
        r15 = r3.getString(r3.getColumnIndex("data1"));     // Catch: Exception -> L27
        goto L13
    L15:
        r3.close();     // Catch: Exception -> L27
        if (r15 == null) goto L19;
        r15 = r15.replaceAll("-", " ").replaceAll(" ", "");     // Catch: Exception -> L27
    L19:
        if (TextUtils.isEmpty(r14) == false) goto L21;
    L25:
        r9.finishWithFailure();     // Catch: Exception -> L27
        return;
    L21:
        if (TextUtils.isEmpty(r15) == true) goto L25;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L24 Exception -> L27
        r1.put("name", r14);     // Catch: JSONException -> L24 Exception -> L27
        r1.put("phone", r15);     // Catch: JSONException -> L24 Exception -> L27
        r9.finishWithResult(r1);     // Catch: JSONException -> L24 Exception -> L27
    L38:
        return;
    L24:
        r9.finishWithFailure();     // Catch: Exception -> L27
        return;
    L11:
        r15 = null;
        r14 = null;
    L27:
        r9.finishWithFailure();
        return;
    L36:
        return;
    L35:
        return;
    }
}
