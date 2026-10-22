package kw1;

import am2.x;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.open.OpenRoom;
import com.bytedance.android.livesdkapi.depend.model.open.OpenUser;
import com.bytedance.android.livesdkapi.feed.EnterParams;
import com.bytedance.android.livesdkapi.feed.IOpenFeedLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements IOpenFeedLogger {
    public static final d a = null;

    public d() {
    }

    static {
        a = new d();
    }

    public final void logShow(OpenRoom r6) {
        Intrinsics.checkNotNullParameter(r6, "openRoom");
        LinkedHashMap r0 = new LinkedHashMap();
        o r1 = u.l().c(x.class);
        String r2 = (String) r1.getMap().get("enter_from_merge");
        String r4 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.put("enter_from_merge", r2);
        String r3 = (String) r1.getMap().get("enter_method");
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put("enter_method", r3);
        r0.put("room_id", String.valueOf(r6.getId()));
        OpenUser r5 = r6.getOwner();
        if (r5 == null) goto L12;
        String r7 = r5.getOpenId();
        if (r7 == null) goto L12;
    L13:
        r0.put("anchor_id", r7);
        r0.put("action_type", "click");
        String r8 = r6.getResId();
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        r0.put("request_id", r8);
        String r9 = r6.getLogPb();
        if (r9 == null) goto L20;
        r4 = r9;
    L20:
        r0.put("log_pb", r4);
        u.l().sendLog("livesdk_live_show", r0, new Object[]{Room.class});
        return;
    L12:
        r7 = "";
        goto L13
    }

    public final void logWindowDuration(OpenRoom r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "openRoom");
        LinkedHashMap r0 = new LinkedHashMap();
        o r1 = u.l().c(x.class);
        String r2 = (String) r1.getMap().get("enter_from_merge");
        String r4 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.put("enter_from_merge", r2);
        String r3 = (String) r1.getMap().get("enter_method");
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put("enter_method", r3);
        r0.put("room_id", String.valueOf(r6.getId()));
        OpenUser r5 = r6.getOwner();
        if (r5 == null) goto L12;
        String r8 = r5.getOpenId();
        if (r8 == null) goto L12;
    L13:
        r0.put("anchor_id", r8);
        r0.put("action_type", "click");
        String r9 = r6.getResId();
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        r0.put("request_id", r9);
        String r10 = r6.getLogPb();
        if (r10 == null) goto L20;
        r4 = r10;
    L20:
        r0.put("log_pb", r4);
        r0.put("duration", String.valueOf(r7));
        u.l().sendLog("livesdk_live_window_duration_v2", r0, new Object[0]);
        return;
    L12:
        r8 = "";
        goto L13
    }

    public final void logShow(OpenRoom r10, EnterParams r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "openRoom");
        Intrinsics.checkNotNullParameter(r11, "enterParams");
        LinkedHashMap r0 = new LinkedHashMap();
        o r1 = u.l().c(x.class);
        if (r11.getEnterFromMerge().length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        String r6 = "";
        if (r2 == false) goto L9;
        String r3 = r11.getEnterFromMerge();
    L13:
        if (r11.getEnterMethod().length() <= 0) goto L15;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L19;
        String r13 = r11.getEnterMethod();
    L22:
        r0.put("enter_from_merge", r3);
        r0.put("enter_method", r13);
        r0.put("room_id", String.valueOf(r10.getId()));
        OpenUser r14 = r10.getOwner();
        if (r14 == null) goto L26;
        String r15 = r14.getOpenId();
        if (r15 == null) goto L26;
    L27:
        r0.put("anchor_id", r15);
        r0.put("action_type", "click");
        String r16 = r10.getResId();
        if (r16 != null) goto L30;
        r16 = "";
    L30:
        r0.put("request_id", r16);
        String r17 = r10.getLogPb();
        if (r17 == null) goto L34;
        r6 = r17;
    L34:
        r0.put("log_pb", r6);
        if (r12 == null) goto L40;
        Iterator<Map.Entry<String, String>> r18 = r12.entrySet().iterator();
    L38:
        if (r18.hasNext() == false) goto L40;
        Map.Entry<String, String> r19 = r18.next();
        r0.put(r19.getKey(), r19.getValue());
    L40:
        u.l().sendLog("livesdk_live_show", r0, new Object[]{Room.class});
        return;
    L26:
        r15 = "";
        goto L27
    L19:
        r13 = (String) r1.getMap().get("enter_method");
        if (r13 != null) goto L22;
        r13 = "";
        goto L22
    L15:
        r7 = false;
        goto L17
    L9:
        r3 = (String) r1.getMap().get("enter_from_merge");
        if (r3 != null) goto L13;
        r3 = "";
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    public final void logWindowDuration(OpenRoom r9, long r10, EnterParams r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r9, "openRoom");
        Intrinsics.checkNotNullParameter(r12, "enterParams");
        LinkedHashMap r0 = new LinkedHashMap();
        o r1 = u.l().c(x.class);
        boolean r3 = true;
        if (r12.getEnterFromMerge().length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        String r6 = "";
        if (r2 == false) goto L9;
        String r4 = r12.getEnterFromMerge();
    L13:
        if (r12.getEnterMethod().length() > 0) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        String r14 = r12.getEnterMethod();
    L22:
        r0.put("enter_from_merge", r4);
        r0.put("enter_method", r14);
        r0.put("room_id", String.valueOf(r9.getId()));
        OpenUser r15 = r9.getOwner();
        if (r15 == null) goto L26;
        String r16 = r15.getOpenId();
        if (r16 == null) goto L26;
    L27:
        r0.put("anchor_id", r16);
        r0.put("action_type", "click");
        String r17 = r9.getResId();
        if (r17 != null) goto L30;
        r17 = "";
    L30:
        r0.put("request_id", r17);
        String r11 = r9.getLogPb();
        if (r11 == null) goto L34;
        r6 = r11;
    L34:
        r0.put("log_pb", r6);
        r0.put("duration", String.valueOf(r10));
        if (r13 == null) goto L40;
        Iterator<Map.Entry<String, String>> r18 = r13.entrySet().iterator();
    L38:
        if (r18.hasNext() == false) goto L40;
        Map.Entry<String, String> r19 = r18.next();
        r0.put(r19.getKey(), r19.getValue());
    L40:
        u.l().sendLog("livesdk_live_window_duration_v2", r0, new Object[0]);
        return;
    L26:
        r16 = "";
        goto L27
    L19:
        r14 = (String) r1.getMap().get("enter_method");
        if (r14 != null) goto L22;
        r14 = "";
        goto L22
    L9:
        r4 = (String) r1.getMap().get("enter_from_merge");
        if (r4 != null) goto L13;
        r4 = "";
        goto L13
    L5:
        r2 = false;
        goto L6
    }
}
