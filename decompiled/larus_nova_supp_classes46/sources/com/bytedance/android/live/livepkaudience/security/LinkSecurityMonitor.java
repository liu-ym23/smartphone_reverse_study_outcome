package com.bytedance.android.live.livepkaudience.security;

import android.util.Log;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.i;
import dl0.n;
import hd0.c;
import io.reactivex.disposables.CompositeDisposable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class LinkSecurityMonitor {
    public static final /* synthetic */ int c = 0;
    public final b a;
    public final Set<Integer> b;

    public static final class a {
    }

    public static final class b extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public final DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA);
        }

        public b() {
        }
    }

    static {
    }

    public abstract boolean b();

    public LinkSecurityMonitor() {
        new CompositeDisposable();
        this.a = new b();
        this.b = SetsKt.setOf(new Integer[]{1, 2, 3, 4});
    }

    public final void a(Map<String, String> r6) {
        if (b() == true) goto L5;
        return;
    L5:
        r6.put("scene", String.valueOf(n.a()));
        r6.put("play_mode", "[normal]");
        r6.put("stack_track", Log.getStackTraceString(new Throwable()));
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L13;
        i r1 = r0.isAnchor();
        if (r1 == null) goto L13;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L13;
        String r2 = "anchor";
    L16:
        r6.put("role", r2);
        r6.put("is_self_singer", "false");
        return;
    L13:
        if (c.f().h() == false) goto L15;
        r2 = "guest";
        goto L16
    L15:
        r2 = "user";
        goto L16
    }

    public final void c(String r10, Map<String, String> r11, com.bytedance.android.live.core.privacy.av.api.b r12, com.bytedance.android.live.core.privacy.av.api.a r13) {
        Intrinsics.checkNotNullParameter(r10, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r11);
        DateFormat r2 = this.a.get();
        if (r2 == null) goto L8;
        String r3 = r2.format(new Date());
    L9:
        String r4 = String.valueOf(r3);
        Intrinsics.checkNotNullParameter("revenue_pk", "biz");
        Intrinsics.checkNotNullParameter(r10, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r4, "timeStamp");
        q60.a.d.d("revenue_pk", r10, r11, r12, r13);
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final void d(String r10, Map<String, String> r11, com.bytedance.android.live.core.privacy.av.api.b r12, com.bytedance.android.live.core.privacy.av.api.a r13) {
        Intrinsics.checkNotNullParameter(r10, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r11);
        DateFormat r2 = this.a.get();
        if (r2 == null) goto L8;
        String r3 = r2.format(new Date());
    L9:
        String r4 = String.valueOf(r3);
        Intrinsics.checkNotNullParameter("revenue_pk", "biz");
        Intrinsics.checkNotNullParameter(r10, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r4, "timeStamp");
        q60.a.d.c("revenue_pk", r10, r11, r12, r13);
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final void e(String r10, Map<String, String> r11, com.bytedance.android.live.core.privacy.av.api.b r12, com.bytedance.android.live.core.privacy.av.api.a r13) {
        Intrinsics.checkNotNullParameter(r10, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r11);
        DateFormat r2 = this.a.get();
        if (r2 == null) goto L8;
        String r3 = r2.format(new Date());
    L9:
        String r4 = String.valueOf(r3);
        Intrinsics.checkNotNullParameter("revenue_pk", "biz");
        Intrinsics.checkNotNullParameter(r10, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r4, "timeStamp");
        q60.a.d.e("revenue_pk", r10, r11, r12, r13);
        return;
    L8:
        r3 = null;
        goto L9
    }
}
