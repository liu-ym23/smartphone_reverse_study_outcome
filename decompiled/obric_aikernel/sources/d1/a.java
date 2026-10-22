package d1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.applog.i;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, CopyOnWriteArraySet<i>> f8439a;

    public a() {
        this.f8439a = new ConcurrentHashMap();
    }

    public boolean a(int r10) {
        return !this.f8439a.containsKey(Integer.valueOf(r10));
    }

    public void b(int r12, @NonNull String r13, @NonNull String r14, String r15, long r16, long r18, String r20) {
        if (a(r12) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet<i> r10 = this.f8439a.get(Integer.valueOf(r12));
        if (r10 != null) goto L8;
        return;
    L8:
        Iterator<i> r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        r11.next().c(r13, r14, r15, r16, r18, r20);
        goto L10
    }

    public void c(int r10, @NonNull String r11, @Nullable JSONObject r12) {
        if (a(r10) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet<i> r13 = this.f8439a.get(Integer.valueOf(r10));
        if (r13 != null) goto L8;
        return;
    L8:
        Iterator<i> r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r14.next().a(r11, r12);
        goto L10
    }

    public void d(int r10, @NonNull String r11, @Nullable JSONObject r12) {
        if (a(r10) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet<i> r13 = this.f8439a.get(Integer.valueOf(r10));
        if (r13 != null) goto L8;
        return;
    L8:
        Iterator<i> r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r14.next().b(r11, r12);
        goto L10
    }
}
