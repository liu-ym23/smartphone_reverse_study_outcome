package zka;

import androidx.core.util.Consumer;
import com.google.gson.Gson;
import com.obric.miniapp.calendar.proxy.function.AppletVersionInfo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final AtomicBoolean a;
    public final ConcurrentHashMap<String, CopyOnWriteArraySet<Consumer<AppletVersionInfo>>> b;

    /* JADX INFO: renamed from: zka.a$a, reason: collision with other inner class name */
    public static final class C0077a {
    }

    static {
    }

    public a() {
        this.a = new AtomicBoolean(false);
        this.b = new ConcurrentHashMap();
        new Gson();
    }
}
