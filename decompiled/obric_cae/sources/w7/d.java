package w7;

import android.content.Context;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static d f13042e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f13043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f13044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f13045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<b> f13046d;

    public d(Context r8) {
        AtomicBoolean r10 = new AtomicBoolean(false);
        this.f13045c = r10;
        LinkedList<b> r11 = new LinkedList();
        this.f13046d = r11;
        Context r12 = r8.getApplicationContext();
        this.f13043a = new ConcurrentHashMap();
        f r13 = new f(r12, this, r11, r10);
        this.f13044b = r13;
        r13.start();
    }
}
