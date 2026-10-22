package com.obric.matrix.sdk.push.cross_process;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import kka.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/sdk/push/cross_process/MessageReceiver;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/matrix/sdk/push/a;", "<init>", "()V", "sdk_push_release"}, k = 1, mv = {1, 6, 0})
public abstract class MessageReceiver extends BroadcastReceiver implements com.obric.matrix.sdk.push.a {
    public MessageReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r9, Intent r10) {
        if (r10 == null) goto L32;
        int r2 = r10.getIntExtra("msg_type", 1);
        String r4 = r10.getStringExtra("msg_id");
        Integer r5 = Integer.valueOf(r2);
        String r6 = null;
        if (r9 != null) goto L27;
        Context r11 = null;
    L7:
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L12
        r7.put("msg_type", r5);     // Catch: Throwable -> L12
        r7.put("msg_id", r4);     // Catch: Throwable -> L12
        if (r11 == null) goto L10;
        r6 = r11.getPackageName();     // Catch: Throwable -> L12
    L10:
        r7.put("package_name", r6);     // Catch: Throwable -> L12
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L12
        r0.add("push_sdk_receive");     // Catch: Throwable -> L12
        r0.add(r7.toString());     // Catch: Throwable -> L12
        ika.a r3 = ika.a.a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L12
        r3.a(r11).b("sdk_event", r0, new a());     // Catch: Throwable -> L12
    L30:
        if (r2 != 1) goto L17;
        String r12 = r10.getStringExtra("pass_though_data");
        if (TextUtils.isEmpty(r12) == true) goto L33;
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r4, "msgId");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r12, "data");     // Catch: Throwable -> L26
        b();     // Catch: Throwable -> L26
    L29:
        return;
    L33:
        return;
    L17:
        if (r2 != 2) goto L34;
        String r1 = r10.getStringExtra("revoke_id");
        r10.getStringExtra("revoke_data");
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r4, "msgId");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r1, "revokeId");     // Catch: Throwable -> L26
        a();     // Catch: Throwable -> L26
        goto L29
    L34:
        return;
    L35:
        return;
    L12:
        th = move-exception;
        b.b("onEvent error: " + th);
        goto L30
    L27:
        r11 = r9.getApplicationContext();     // Catch: Throwable -> L12
        goto L7
    }
}
