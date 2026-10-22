package s81;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.k21;
import com.bytedance.mobsec.metasec.ml.MSManager;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static k21 a;
    public static MSManager b;
    public static WeakReference<Context> c;
    public static CompositeDisposable d;
    public static C0315a e;
    public static boolean f;

    /* JADX INFO: renamed from: s81.a$a, reason: collision with other inner class name */
    public static final class C0315a {
        public final Boolean a;
        public final Boolean b;
        public final List<String> c;
        public final Long d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0315a) == false) goto L14;
            C0315a r4 = (C0315a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            Boolean r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Boolean r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            List<String> r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Long r10 = this.d;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "VolumeData(isMute=" + this.a + ", isMusicActive=" + this.b + ", volumeList=" + this.c + ", currentTime=" + this.d + ")";
        }

        public C0315a(Boolean r1, Boolean r2, List<String> r3, Long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        a = new k21(0);
        f = true;
    }

    public static void a() {
        JSONObject r0 = new JSONObject();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L27
        C0315a r4 = e;     // Catch: Throwable -> L27
        if (r4 == null) goto L6;
        Boolean r5 = r4.a;     // Catch: Throwable -> L27
    L8:
        if (Intrinsics.areEqual(r5, Boolean.FALSE) == false) goto L10;
        int r6 = 1;
    L11:
        r0.put("st", r6);     // Catch: Throwable -> L27
        C0315a r7 = e;     // Catch: Throwable -> L27
        if (r7 == null) goto L14;
        Boolean r8 = r7.b;     // Catch: Throwable -> L27
    L15:
        r0.put("bm", Intrinsics.areEqual(r8, Boolean.TRUE) ? 1 : 0);     // Catch: Throwable -> L27
        C0315a r9 = e;     // Catch: Throwable -> L27
        if (r9 == null) goto L18;
        List<String> r10 = r9.c;     // Catch: Throwable -> L27
    L19:
        r0.put("vol", r10);     // Catch: Throwable -> L27
        C0315a r12 = e;     // Catch: Throwable -> L27
        if (r12 == null) goto L24;
        Long r13 = r12.d;     // Catch: Throwable -> L27
        if (r13 == null) goto L24;
        long r14 = r13.longValue();     // Catch: Throwable -> L27
    L25:
        r0.put("ts", r14);     // Catch: Throwable -> L27
        Result.constructor-impl(r0);     // Catch: Throwable -> L27
    L29:
        HashMap r15 = new HashMap();
        r15.put("live_mic", r0.toString());
        MSManager r1 = b;
        if (r1 == null) goto L32;
        r1.setCustomInfo(r15, true);
    L32:
        ALogger.i("DataCollector", "flush data = " + r15);
        e = null;
        return;
    L24:
        r14 = -1;
        goto L25
    L18:
        r10 = null;
        goto L19
    L14:
        r8 = null;
        goto L15
    L10:
        r6 = 0;
        goto L11
    L6:
        r5 = null;
    L27:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    public static void b(boolean r3) {
        if (r3 == false) goto L8;
        Intent r4 = new Intent();
        Bundle r0 = new Bundle();
        r0.putCharSequence("appID", String.valueOf(k.n(IHostContext.class).appId()));
        r0.putCharSequence("type", "background");
        r4.putExtra("live_tes", r0);
        r4.setAction("com.bytedance.metasec.notification.live.on");
        WeakReference<Context> r1 = c;
        if (r1 == null) goto L14;
        Context r2 = r1.get();
        if (r2 == null) goto L15;
        LocalBroadcastManager.getInstance(r2).sendBroadcast(r4);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        Intent r5 = new Intent();
        r5.setAction("com.bytedance.metasec.notification.live.off");
        WeakReference<Context> r6 = c;
        if (r6 == null) goto L17;
        Context r7 = r6.get();
        if (r7 == null) goto L18;
        LocalBroadcastManager.getInstance(r7).sendBroadcast(r5);
        return;
    L18:
        return;
    }
}
