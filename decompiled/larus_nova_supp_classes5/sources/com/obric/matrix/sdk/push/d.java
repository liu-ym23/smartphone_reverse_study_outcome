package com.obric.matrix.sdk.push;

import android.content.Context;
import android.util.Log;
import com.obric.matrix.push.common.cross_process.CrossProcessService;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public final String a;

    public static final class a implements jka.a {
        public a() {
        }

        @Override // jka.a
        public final void onCallback(List<Object> r3) {
            String r4 = "sdk event: " + r3;
            int r0 = kka.b.a;
            Intrinsics.checkNotNullParameter(r4, "msg");
            kka.b.a("", r4);
        }
    }

    public d() {
        this.a = "PushImpl";
    }

    public static void a(Context r3) {
        Context r0 = r3.getApplicationContext();     // Catch: Throwable -> L4
        String r4 = r3.getPackageName();     // Catch: Throwable -> L4
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L4
        r1.put("package_name", r4);     // Catch: Throwable -> L4
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L4
        r5.add("push_sdk_register");     // Catch: Throwable -> L4
        r5.add(r1.toString());     // Catch: Throwable -> L4
        ika.a r2 = ika.a.a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L4
        jka.c r6 = r2.a(r0);     // Catch: Throwable -> L4
        CrossProcessService r7 = (CrossProcessService) r6;     // Catch: Throwable -> L4
        r7.b("sdk_event", r5, new a());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        kka.b.b(Log.getStackTraceString(th));
    }
}
