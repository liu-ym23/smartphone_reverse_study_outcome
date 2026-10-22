package ha;

import ai.j0;
import android.content.Context;
import android.text.TextUtils;
import ja.d;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q7.a f17288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f17289c;
    public String d;
    public final s6.c e;
    public long f;
    public final /* synthetic */ String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f17290h;

    public a(b r5, Context r10, q7.a r11, s6.c r12, String r13) {
        this.f17290h = r5;
        this.g = r13;
        this.f17288b = r11;
        this.e = r12;
        String r14 = j0.q(new StringBuilder(), (String) r11.f21488b, "sdk_monitor");
        this.f17287a = r14;
        if (TextUtils.isEmpty(r14) == true) goto L22;
        if (d.e == null) goto L7;
    L17:
        d r15 = d.e;
        this.f17289c = r15;
        if (((AtomicBoolean) r15.f18303c).get() == true) goto L25;
        ((ConcurrentHashMap) r15.f18301a).put(r14, this);
        return;
    L25:
        return;
    L7:
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (d.e != null) goto L13;
        d.e = new d(r10);     // Catch: Throwable -> L11
    L13:
        monitor-exit(d.class);     // Catch: Throwable -> L11
        goto L17
    L22:
        throw new IllegalArgumentException("type is empty.");
    }
}
