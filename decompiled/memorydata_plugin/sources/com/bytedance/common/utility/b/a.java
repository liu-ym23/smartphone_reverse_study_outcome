package com.bytedance.common.utility.b;

import android.util.Log;
import com.bytedance.rpc.internal.RpcUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x006a: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:24:0x006a */
    static String a(String r7) {
        BufferedReader r2 = null;
        BufferedReader r4 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + r7).getInputStream(), RpcUtils.CHARSET_UTF8), 1024);     // Catch: Throwable -> L12 IOException -> L14
        String r3 = r4.readLine();     // Catch: IOException -> L10 Throwable -> L23
        r4.close();     // Catch: IOException -> L10 Throwable -> L23
        r4.close();     // Catch: IOException -> L7
    L9:
        return r3;
    L7:
        e = move-exception;
        Log.e("CmdSystemProperties", "Exception while closing InputStream", e);
    L10:
        e = e;
    L16:
        Log.e("CmdSystemProperties", "Unable to read sysprop " + r7, e);     // Catch: Throwable -> L23
        if (r4 != null) goto L31;
    L22:
        return null;
    L31:
        r4.close();     // Catch: IOException -> L20
    L20:
        e = move-exception;
        Log.e("CmdSystemProperties", "Exception while closing InputStream", e);
        goto L22
    L23:
        th = th;
        r2 = r4;
    L25:
        if (r2 != null) goto L33;
    L30:
        throw th;
    L33:
        r2.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        Log.e("CmdSystemProperties", "Exception while closing InputStream", e);
    L14:
        e = e;
        r4 = null;
    L12:
        th = th;
        goto L25
    }
}
