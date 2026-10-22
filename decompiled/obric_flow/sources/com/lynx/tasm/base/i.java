package com.lynx.tasm.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TraceController f10133a;

    public i(TraceController r5) {
        this.f10133a = r5;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r10, Intent r11) {
        boolean r5 = r11.getAction().endsWith("LYNX_TRACE_START");
        TraceController r12 = this.f10133a;
        if (r5 == false) goto L13;
        String r13 = r11.getStringExtra("categories");
        String r14 = r11.getStringExtra("file");
        int r15 = r11.getIntExtra("buffer", 40960);
        TraceController.f10108h = r11.getBooleanExtra("nativeOnly", false);
        if (r14 != null) goto L7;
        r14 = r12.a().getPath();
    L7:
        if (r13 == null) goto L9;
        String[] r16 = r13.split(",");
    L10:
        r12.a(r15, r16, r14);
        String r17 = td.d.b("Trace started at: ", r14);
        Toast.makeText(r10, r17, 0).show();
        Log.i("Lynx startup trace", r17);
        return;
    L9:
        r16 = null;
        goto L10
    L13:
        if (r11.getAction().endsWith("LYNX_TRACE_STOP") == false) goto L16;
        TraceController.f10108h = false;
        r12.e();
        Toast.makeText(r10, "Trace stopped", 0).show();
        Log.i("Lynx startup trace", "Trace stopped");
        return;
    }
}
