package gh;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.room.f;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import kotlin.jvm.internal.Intrinsics;
import nh.d;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PiaMethod$Scope f17098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f17099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f17100c;
    public boolean d;
    public final com.bytedance.pia.core.utils.a e;
    public hh.a f;
    public final SparseArray g;

    public c(PiaMethod$Scope r5, d r10, a r11) {
        this.d = false;
        this.e = new com.bytedance.pia.core.utils.a();
        this.f = null;
        this.g = new SparseArray();
        this.f17098a = r5;
        this.f17099b = r10;
        this.f17100c = r11;
    }

    public static void b(fh.a r5, PiaMethod$Error r10) {
        if (r5 == null) goto L10;
        r5.accept(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Bridge] invoke callback error:", "message");
        j.x("[Bridge] invoke callback error:", th);
        return;
    }

    public final void a(int r5, String r10, String r11, Throwable r12) {
        StringBuilder r13 = new StringBuilder("name=");
        r13.append(r10);
        if (TextUtils.isEmpty(r11) == true) goto L5;
        r13.append(", message=");
        r13.append(r11);
    L5:
        if (r12 == null) goto L7;
        r13.append(", error=");
        r13.append(Log.getStackTraceString(r12));
    L7:
        d r14 = this.f17099b;
        if (r14 == null) goto L11;
        String r15 = r13.toString();
        r14.f20239j.b(r5, "bridge", r15);
        return;
    }

    public final void c(String r5, Object r10) {
        m.b(new f(this, r10, r5));
    }
}
