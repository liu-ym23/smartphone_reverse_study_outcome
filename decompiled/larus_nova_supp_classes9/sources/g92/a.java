package g92;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.v0;
import com.bytedance.android.livesdk.event.a0;
import com.bytedance.android.livesdk.event.m;
import com.bytedance.android.livesdk.event.n;
import com.bytedance.android.livesdk.event.q;
import com.bytedance.android.livesdk.event.r;
import com.bytedance.android.livesdk.interactivity.api.comment.CommentApi;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public Integer a;
    public Long b;
    public String c;
    public String d;
    public d e;
    public final Map<String, String> f;
    public final long g;
    public final String h;
    public final int i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;

    /* JADX INFO: renamed from: g92.a$a, reason: collision with other inner class name */
    public static final class C0233a {
    }

    static {
    }

    public final int getType() {
        return this.i;
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.f.put(r2, r3);
    }

    public final HashMap<String, String> c(List<n> r9, List<r> r10) {
        Pair[] r0 = new Pair[13];
        r0[0] = TuplesKt.to("content", this.h);
        r0[1] = TuplesKt.to("room_id", String.valueOf(this.g));
        r0[2] = TuplesKt.to("request_id", this.j);
        r0[3] = TuplesKt.to("common_label_list", this.k);
        r0[4] = TuplesKt.to("enter_source", this.l);
        r0[5] = TuplesKt.to("type", String.valueOf(this.i));
        Integer r1 = this.a;
        String r4 = null;
        if (r1 == null) goto L5;
        String r2 = String.valueOf(r1.intValue());
    L6:
        r0[6] = TuplesKt.to("agree_msg_id", r2);
        Long r3 = this.b;
        if (r3 == null) goto L9;
        String r5 = String.valueOf(r3.longValue());
    L10:
        r0[7] = TuplesKt.to("flow_time", r5);
        r0[8] = TuplesKt.to("color_value", this.c);
        r0[9] = TuplesKt.to("camera_id", this.d);
        d r6 = this.e;
        if (r6 == null) goto L13;
        JSONObject r7 = new JSONObject();
        r7.put("episode_id", r6.a);
        r7.put("stage", r6.b);
        r4 = r7.toString();
    L13:
        r0[10] = TuplesKt.to("episode_info_str", r4);
        r0[11] = TuplesKt.to("rtf_content", new a0(r9, r10).a());
        r0[12] = TuplesKt.to("intent_recognition", this.m);
        Map r11 = MapsKt.mapOf(r0);
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r11.entrySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L22;
        Map.Entry r8 = (Map.Entry) r14.next();
        if (r8.getValue() == null) goto L19;
        boolean r15 = true;
    L20:
        if (r15 == false) goto L15;
        r13.put(r8.getKey(), r8.getValue());
        goto L15
    L19:
        r15 = false;
        goto L20
    L22:
        HashMap<String, String> r16 = new HashMap(r13);
        if ((!this.f.isEmpty()) == false) goto L25;
        r16.putAll(this.f);
    L25:
        return r16;
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final Observable<Response<v0>> b(m r4, q r5, boolean r6) {
        List<r> r0 = null;
        if (r6 == false) goto L11;
        CommentApi r7 = (CommentApi) com.bytedance.android.live.network.c.b().e(CommentApi.class);
        long r1 = this.g;
        if (r4 == null) goto L7;
        List<n> r8 = r4.a;
    L8:
        if (r5 == null) goto L19;
        r0 = r5.a;
    L19:
        return r7.sendSpecialTextMessage(r1, c(r8, r0)).compose(RxUtil.rxSchedulerHelper());
    L7:
        r8 = null;
        goto L8
    L11:
        CommentApi r9 = (CommentApi) com.bytedance.android.live.network.c.b().e(CommentApi.class);
        if (r4 == null) goto L14;
        List<n> r10 = r4.a;
    L15:
        if (r5 == null) goto L18;
        r0 = r5.a;
    L18:
        return r9.sendTextMessage(c(r10, r0)).compose(RxUtil.rxSchedulerHelper());
    L14:
        r10 = null;
        goto L15
    }

    public a(long r2, String r4, int r5, String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r4, "content");
        this.g = r2;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.k = r7;
        this.l = r8;
        this.m = r9;
        this.f = new LinkedHashMap();
    }
}
