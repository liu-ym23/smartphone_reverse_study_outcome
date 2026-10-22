package com.bytedance.android.livesdk.interactivity.medialink.logs;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.medialink.contract.b;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import hy.e;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MediaMultiEnterRoomTracer {
    public static MultiLoadSource a;
    public static long b;
    public static long c;
    public static long d;
    public static long e;
    public static long f;
    public static long g;
    public static long h;
    public static long i;
    public static long j;
    public static boolean k;
    public static boolean l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/logs/MediaMultiEnterRoomTracer$MultiLoadSource;", BuildConfig.FLAVOR, "RoomEnter", "LinkerEnter", "SeiBackUp", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MultiLoadSource extends Enum<MultiLoadSource> {
        public static final MultiLoadSource LinkerEnter = null;
        public static final MultiLoadSource RoomEnter = null;
        public static final MultiLoadSource SeiBackUp = null;
        public static final /* synthetic */ MultiLoadSource[] a = null;

        static {
            MultiLoadSource r1 = new MultiLoadSource("RoomEnter", 0);
            RoomEnter = r1;
            MultiLoadSource r2 = new MultiLoadSource("LinkerEnter", 1);
            LinkerEnter = r2;
            MultiLoadSource r3 = new MultiLoadSource("SeiBackUp", 2);
            SeiBackUp = r3;
            a = new MultiLoadSource[]{r1, r2, r3};
        }

        public static MultiLoadSource valueOf(String r1) {
            return (MultiLoadSource) a.a(MultiLoadSource.class, r1);
        }

        public static MultiLoadSource[] values() {
            return (MultiLoadSource[]) a.clone();
        }

        public MultiLoadSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static void a() {
        if (k == true) goto L30;
        long r0 = h;
        if (r0 != 0) goto L7;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L31;
        k = true;
        long r1 = RangesKt.coerceAtLeast(f, r0);
        long r5 = c;
        long r6 = b;
        long r8 = r5 - r6;
        long r10 = d;
        long r7 = r10 - r5;
        long r13 = j - i;
        long r14 = h;
        long r16 = r14 - g;
        long r18 = f - e;
        long r2 = r1 - r6;
        if (r14 < r10) goto L19;
    L21:
        boolean r9 = false;
    L22:
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("link_waiting_duration", String.valueOf(r8));
        r11.put("link_load_duration", String.valueOf(r7));
        r11.put("link_total_duration", String.valueOf(r8 + r7));
        r11.put("layout_duration", String.valueOf(r13));
        r11.put("first_sei_update_duration", String.valueOf(r16));
        r11.put("api_call_duration", String.valueOf(r18));
        r11.put("total_duration", String.valueOf(r2));
        r11.put("has_first_sei", String.valueOf(l));
        r11.put("first_sei_valid", String.valueOf(r9));
        r11.put("enter_source", String.valueOf(a));
        b.R0.getClass();
        b r3 = b.a.a();
        if (r3 == null) goto L27;
        e r15 = r3.Np();
        if (r15 == null) goto L27;
        int r17 = r15.c();
    L28:
        r11.put("anchor_connect_status", String.valueOf(r17));
        r11.put("link_list_failed", String.valueOf(false));
        ALogger.e("MediaLinkEnterRoomTracer", r11.toString());
        u.l().sendLog("livesdk_media_multi_load_duration", r11, new Object[]{Room.class, x.class});
        return;
    L27:
        r17 = 2;
        goto L28
    L19:
        if (l == false) goto L21;
        r9 = true;
        goto L22
    L31:
        return;
    L7:
        if (j == 0) goto L13;
        if (d == 0) goto L13;
        if (f == 0) goto L13;
        r4 = true;
        goto L14
    }

    static {
    }
}
