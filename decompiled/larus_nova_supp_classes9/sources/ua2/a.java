package ua2;

import android.os.SystemClock;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.settings.config.q;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import r52.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final ArrayDeque<f<?>> a;
    public final LinkedList<f<?>> b;
    public final int c;
    public final Set<String> d;
    public final Map<Integer, Long> e;
    public final Map<Integer, Pair<Long, Integer>> f;
    public final int g;
    public final int h;
    public final long i;
    public final int j;
    public boolean k;

    /* JADX INFO: renamed from: ua2.a$a, reason: collision with other inner class name */
    public static final class C0286a {
    }

    static {
    }

    public a() {
        this.b = new LinkedList();
        this.c = 100;
        this.d = SetsKt.mutableSetOf(new String[]{"WebcastGiftMessage", "GiftGroupMessage", "WebcastDoodleGiftMessage", "WebcastChatMessage", "WebcastMemberMessage", "WebcastScreenChatMessage", "WebcastLikeMessage", "WebcastSocialMessage", "WebcastRoomMessage", "WebcastPrivilegeScreenChatMessage"});
        LinkedHashMap r1 = new LinkedHashMap();
        this.e = r1;
        this.f = new LinkedHashMap();
        this.a = new ArrayDeque(100);
        q r0 = (q) p0.a.getValue();
        this.g = r0.c();
        this.h = r0.d();
        this.i = r0.b();
        this.j = r0.a();
        r1.put(1, 0L);
        r1.put(2, 0L);
    }

    public final boolean a(int r11) {
        long r0 = SystemClock.uptimeMillis();
        Map<Integer, Pair<Long, Integer>> r2 = this.f;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        Pair r4 = (Pair) r3.get(Integer.valueOf(r11));
        if (r4 != null) goto L5;
    L11:
        this.f.put(Integer.valueOf(r11), new Pair(Long.valueOf(r0), 1));
        return false;
    L5:
        if ((r0 - ((Number) r4.getFirst()).longValue()) > this.i) goto L11;
        if (((Number) r4.getSecond()).intValue() >= this.j) goto L10;
        this.f.put(Integer.valueOf(r11), new Pair(Long.valueOf(r0), Integer.valueOf(((Number) r4.getSecond()).intValue() + 1)));
        return false;
    L10:
        return true;
    }
}
