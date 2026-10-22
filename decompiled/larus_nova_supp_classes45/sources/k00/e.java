package k00;

import com.bytedance.android.live.broadcast.api.model.k1;
import com.bytedance.android.live.broadcast.api.model.l1;
import com.bytedance.android.live.broadcast.api.model.m1;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.depend.share.LiveFansContactData;
import com.bytedance.android.livehostapi.business.depend.share.LiveFansDataSource;
import com.bytedance.android.livesdk.share.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final com.bytedance.android.livesdk.sharedpref.e<String> a = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<String> b = null;
    public static Map<String, Map<String, Object>> c;
    public static boolean d;
    public static final e e = null;

    public e() {
    }

    static {
        e = new e();
        a = new com.bytedance.android.livesdk.sharedpref.e("share_fans_list", "");
        b = new com.bytedance.android.livesdk.sharedpref.e("share_fans_list_uid", "");
    }

    public static final void a(e r18, l1 r19) {
        r18.getClass();
        ArrayList r0 = new ArrayList();
        Map<String, Map<String, Object>> r1 = c;
        if (r1 == null) goto L5;
        ((LinkedHashMap) r1).clear();
    L6:
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        List<m1> r4 = r19.b();
        long r5 = 0;
        if (r4 == null) goto L32;
        Iterator<T> r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L32;
        m1 r8 = (m1) r6.next();
        if (r8.f() <= r5) goto L30;
        if (r8.c().length() <= 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L30;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("live_score", Float.valueOf(r8.d()));
        r11.put("live_relation_type", Integer.valueOf(r8.b()));
        if (r8.b() != 1) goto L25;
        r11.put("live_text", r8.a());
        if (r8.e() <= 0) goto L23;
        r11.put("live_fans_label_type", Integer.valueOf(r8.e()));
    L23:
        r2.add(new LiveFansContactData(r11, r8.f(), r8.c(), 0));
    L27:
        Map<String, Map<String, Object>> r7 = c;
        if (r7 == null) goto L30;
        Map<String, Object> r12 = r7.put(String.valueOf(r8.f()), r11);
        goto L30
    L25:
        if (r8.b() != 2) goto L27;
        r3.add(new LiveFansContactData(r11, r8.f(), r8.c(), 0));
        goto L27
    L16:
        r9 = false;
    L30:
        r5 = 0;
    L32:
        if ((!r3.isEmpty()) == false) goto L34;
    L35:
        r0.add(new LiveFansDataSource(1, r3, r2));
    L36:
        List<k1> r13 = r19.a();
        if (r13 == null) goto L53;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L40:
        if (r15.hasNext() == false) goto L51;
        k1 r16 = (k1) r15.next();
        if (r16.a() <= 0) goto L47;
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("live_score", Float.valueOf(r16.b()));
        Map<String, Map<String, Object>> r21 = c;
        if (r21 == null) goto L46;
        Map<String, Object> r22 = r21.put(String.valueOf(r16.a()), r17);
    L46:
        LiveFansContactData r23 = new LiveFansContactData(r17, 0, "", r16.a());
    L48:
        if (r23 == null) goto L40;
        r14.add(r23);
        goto L40
    L47:
        r23 = null;
        goto L48
    L51:
        if ((!r14.isEmpty()) == false) goto L53;
        r0.add(new LiveFansDataSource(2, r14, null, 4, null));
    L53:
        h r24 = k.n(IMiddlewareRoomService.class).share();
        if (r24 == null) goto L69;
        IHostShare r25 = r24.a;
        if (r25 == null) goto L70;
        r25.addExternalDataSource(r0);
        return;
    L70:
        return;
    L69:
        return;
    L34:
        if ((!r2.isEmpty()) == false) goto L36;
    L5:
        c = new LinkedHashMap();
        goto L6
    }
}
