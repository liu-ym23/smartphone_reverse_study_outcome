package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.effectmanager.common.ConcurrentHashSet;
import io.reactivex.Observable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements v {
    public static final ConcurrentHashSet<Long> a = null;
    public static final String b = null;
    public static boolean c;
    public static final m d = null;

    public m() {
    }

    public final void onRemove() {
    }

    static {
        d = new m();
        a = new ConcurrentHashSet();
        b = "WatchLaterBubbleShowController";
    }

    public final void Rd() {
        if (c == true) goto L6;
        c = true;
        Observable.interval(3, TimeUnit.HOURS).subscribe(l.a);
        return;
    }

    public final void L9(String r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r9, "params");
    L22:
        e = move-exception;
        ALogger.e(b, String.valueOf(e));
        return;
    L4:
        if (r8.hashCode() == 1549130846) goto L7;
        return;
    L7:
        if (r8.equals("livesdk_watch_seconds") == false) goto L28;
        String r10 = r9.get("watch_time");     // Catch: Exception -> L22
        if (r10 == null) goto L11;
        long r2 = CastLongProtector.parseLong(r10);     // Catch: Exception -> L22
    L12:
        String r11 = r9.get("room_id");     // Catch: Exception -> L22
        if (r11 == null) goto L15;
        long r12 = CastLongProtector.parseLong(r11);     // Catch: Exception -> L22
    L17:
        if (r2 == 10) goto L19;
        return;
    L19:
        if (r12 <= 0) goto L30;
        a.add(Long.valueOf(r12));     // Catch: Exception -> L22
        return;
    L30:
        return;
    L15:
        r12 = 0;
        goto L17
    L11:
        r2 = 0;
        goto L12
    }
}
