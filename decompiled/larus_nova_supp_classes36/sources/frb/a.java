package frb;

import android.os.SystemClock;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.statistics.c;
import com.ss.android.lark.mention.base.impl.statistics.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final Map<String, Boolean> e = null;
    public static final Map<String, Long> f = null;
    public static boolean g;
    public final String a;
    public final String b;
    public final boolean c;
    public boolean d;

    /* JADX INFO: renamed from: frb.a$a, reason: collision with other inner class name */
    public static final class C0266a {
        @JvmStatic
        public static Pair a() {
            Intrinsics.checkNotNullParameter("mention_ai_knowledge", "targetId");
            Boolean r0 = (Boolean) ((LinkedHashMap) a.e).get("mention_ai_knowledge");
            if (r0 == null) goto L5;
            boolean r1 = r0.booleanValue();
        L6:
            if (r1 == false) goto L8;
            Long r2 = (Long) ((LinkedHashMap) a.f).get("mention_ai_knowledge");
            if (r2 == null) goto L12;
            long r3 = r2.longValue();
        L14:
            if ((SystemClock.elapsedRealtime() - r3) < 1500) goto L17;
            return new Pair(Boolean.TRUE, Boolean.valueOf(a.g));
        L17:
            return new Pair(Boolean.FALSE, Boolean.valueOf(a.g));
        L12:
            r3 = SystemClock.elapsedRealtime();
            goto L14
        L8:
            return new Pair(Boolean.FALSE, Boolean.valueOf(a.g));
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
        e = new LinkedHashMap();
        f = new LinkedHashMap();
    }

    public final void a(RecyclerView r8) {
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        LinearLayoutManager r0 = r8.getLayoutManager();
        b r2 = null;
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        RecyclerView.Adapter r9 = r8.getAdapter();
        if ((r9 instanceof b) == false) goto L11;
        r2 = (b) r9;
    L11:
        if (r2 != null) goto L13;
        return;
    L13:
        boolean r10 = this.d;
        int r3 = r1.findFirstVisibleItemPosition();
        int r4 = r1.findLastVisibleItemPosition();
        int r5 = r2.getItemCount();
        boolean r6 = false;
        int r7 = Math.max(0, r3);
        int r11 = Math.min(r4, r5 - 1);
        if (r7 <= r11) goto L16;
    L20:
        this.d = r6;
        e.put(this.a, Boolean.valueOf(r6));
        g = this.c;
        if (r10 == false) goto L23;
        return;
    L23:
        if (this.d == false) goto L29;
        f.put(this.a, Long.valueOf(SystemClock.elapsedRealtime()));
        String r12 = this.a;
        boolean r13 = this.c;
        String r14 = this.b;
        Log.i("ItemVisibilityTracker", "mention ai knowledge is visible , " + r13);
        int r15 = e.a;
        Intrinsics.checkNotNullParameter(r12, "targetId");
        Intrinsics.checkNotNullParameter(r14, "configJson");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new c(r12, r14, r13));
        return;
    L29:
        return;
    L16:
        if (Intrinsics.areEqual(r2.k2(r7), this.a) == true) goto L17;
        if (r7 == r11) goto L20;
        r7 = r7 + 1;
        goto L16
    L17:
        r6 = true;
        goto L20
    L5:
        r1 = null;
        goto L6
    }

    public a(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter("mention_ai_knowledge", "targetId");
        Intrinsics.checkNotNullParameter(r3, "configJson");
        this.a = "mention_ai_knowledge";
        this.b = r3;
        this.c = r4;
    }
}
