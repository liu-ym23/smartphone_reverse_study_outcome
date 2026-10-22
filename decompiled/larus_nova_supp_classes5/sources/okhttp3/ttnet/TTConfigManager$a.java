package okhttp3.ttnet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TTConfigManager$a {
    public final CopyOnWriteArrayList<String> a;
    public final CopyOnWriteArrayList<String> b;
    public final AtomicBoolean c;
    public final CopyOnWriteArrayList<String> d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public final AtomicBoolean h;
    public final List<String> i;
    public final List<String> j;

    public TTConfigManager$a() {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new AtomicBoolean(false);
        this.d = new CopyOnWriteArrayList();
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = new ArrayList();
        this.j = new ArrayList();
    }
}
