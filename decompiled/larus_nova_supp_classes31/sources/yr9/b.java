package yr9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b extends as9.a {
    public a f;
    public final float g;

    public class a extends BroadcastReceiver {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r4, Intent r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            boolean r0 = false;
            float r6 = r5.getIntExtra("temperature", 0) / 10.0f;
            b r7 = this.a;
            float r1 = r7.c;
            float r8 = r7.g;
            boolean r2 = bs9.a.a;
            if (r8 <= 0.0f) goto L8;
            r6 = r8;
        L8:
            if (r6 != r1) goto L11;
            return;
        L11:
            if (Math.abs(r1 - r6) < 0.5f) goto L13;
            b r9 = this.a;
            if (r6 <= r9.c) goto L17;
            r0 = true;
        L17:
            r9.d = r9.d(r6, r0);
            b r10 = this.a;
            r10.c = r6;
            as9.a.InterfaceC0000a r3 = r10.a;
            if (r3 == null) goto L21;
            r3.onStatusGenerate(r10.d, r6);
            return;
        L21:
            return;
        }
    }

    @Override // as9.a
    public final boolean a() {
        if (this.f == null) goto L12;
    L11:
        return true;
    L12:
        a r0 = new a(this);     // Catch: Exception -> L9
        this.f = r0;     // Catch: Exception -> L9
        Intent r1 = h(this.b, r0, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Exception -> L9
        if (r1 != null) goto L7;
        return false;
    L7:
        float r2 = r1.getIntExtra("temperature", 0) / 10.0f;     // Catch: Exception -> L9
        this.c = r2;     // Catch: Exception -> L9
        this.d = d(r2, true);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.getStackTraceString(e);
        boolean r3 = bs9.a.a;
        goto L11
    }

    @Override // as9.a
    public final float b() {
        if (this.a != null) goto L7;
        return i();
    L7:
        return this.c;
    }

    @Override // as9.a
    public final int c() {
        if (this.a != null) goto L7;
        return d(i(), true);
    L7:
        return this.d;
    }

    @Override // as9.a
    public final void e() {
        a r0 = this.f;
        if (r0 == null) goto L19;
        Context r1 = this.b;
        ReceiverRegisterLancet.loge(r0, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L17;
        r1.unregisterReceiver(r0);
    L15:
        this.f = null;
        return;
    L17:
    L10:
        e = move-exception;
        if (r0 == null) goto L13;
        Npth.addTag("unregisterReceiver", r0.toString());
    L13:
        e.printStackTrace();
        goto L15
    L7:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r0, r1) == false) goto L15;
        r1.unregisterReceiver(r0);     // Catch: Exception -> L10
        goto L15
    }

    public final float i() {
        Intent r0 = h(this.b, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getIntExtra("temperature", 0) / 10.0f;
    }

    public b(Context r3, Looper r4) {
        super(r3, r4);
        this.g = -1.0f;
        List<Pair<Float, Float>> r5 = this.e;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new Pair(Float.valueOf(35.0f), Float.valueOf(34.0f)));
        List<Pair<Float, Float>> r7 = this.e;
        ArrayList r8 = (ArrayList) r7;
        r8.add(new Pair(Float.valueOf(38.0f), Float.valueOf(37.0f)));
        List<Pair<Float, Float>> r9 = this.e;
        ArrayList r10 = (ArrayList) r9;
        r10.add(new Pair(Float.valueOf(41.0f), Float.valueOf(40.0f)));
        List<Pair<Float, Float>> r11 = this.e;
        ArrayList r12 = (ArrayList) r11;
        r12.add(new Pair(Float.valueOf(45.0f), Float.valueOf(43.0f)));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent h(Context r8, a r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L39;
        throw e;
    L39:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L35
        int r1 = r0.result;     // Catch: Exception -> L35
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L18;
        return r8.registerReceiver(r9, r10);
    L18:
        return r0.intent;
    L20:
        return new Intent();
    L22:
        return r8.registerReceiver(r9, r10);
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L34;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L34:
        return r8.registerReceiver(r9, r10);
    }
}
