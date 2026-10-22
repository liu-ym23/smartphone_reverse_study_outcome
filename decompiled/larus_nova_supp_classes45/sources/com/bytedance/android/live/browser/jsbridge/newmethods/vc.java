package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class vc implements DialogInterface.OnClickListener {
    public final /* synthetic */ JSONObject a;

    public vc(JSONObject r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        r2.dismiss();
        this.a.put("isCancel", 0);
    }
}
