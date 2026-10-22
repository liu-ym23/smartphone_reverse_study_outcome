package io.noties.markwon;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class f implements d {
    public f() {
    }

    private static Uri a(String r1) {
        Uri r2 = Uri.parse(r1);
        if (TextUtils.isEmpty(r2.getScheme()) == true) goto L5;
        return r2;
    L5:
        return r2.buildUpon().scheme(LocationInfoConst.HTTPS).build();
    }

    @Override // io.noties.markwon.d
    public void resolve(View r4, String r5) {
        Uri r3 = a(r5);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intent r1 = new Intent("android.intent.action.VIEW", r3);
        r1.putExtra("com.android.browser.application_id", r6.getPackageName());
        ZeusTransformUtils.startActivity(r6, r1, "com.obric.memorydata.plugin");     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        Log.w("LinkResolverDef", "Actvity was not found for the link: '" + r5 + "'");
    }
}
