package he0;

import aj6.d;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiCreator;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.live.livelink.kmp.api.base.config.Vendor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qi6.g;
import ti6.f;
import ti6.h;
import ti6.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements j {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final InterfaceC0218a f;
    public fi6.a g;
    public final LiveSeiCreator h;
    public j1 i;

    /* JADX INFO: renamed from: he0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0218a {
        boolean B7(String r1);

        String Kn(String r1);

        boolean isMicRoomHost(String r1);

        int tc(String r1);
    }

    public final /* synthetic */ boolean b(d r1, aj6.b r2) {
        ti6.a.a(r1, r2);
        return false;
    }

    public a(g r9, InterfaceC0218a r10, j1 r11) {
        this.i = null;
        this.f = r10;
        int r12 = r9.c;
        int r13 = r9.d;
        double r2 = (r12 * 1.0f) / 360.0f;
        double r0 = ((double) ((r13 * 1.0f) / 640.0f)) * 78.0d;
        double r4 = r12;
        double r6 = r0 / r4;
        this.a = r6;
        double r14 = r13;
        this.b = r0 / r14;
        this.c = (1.0d - r6) - ((9.0d * r2) / r4);
        this.d = (70.0d * r2) / r14;
        this.e = (r2 * 6.0d) / r14;
        this.h = new LiveSeiCreator();
        this.i = r11;
    }

    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [boolean, int] */
    public final String a(int r18, int r19, List<f> r20) {
        String r2 = tc0.c.h().f;
        String r3 = k.f(IMiddlewareUserService.class).user().n();
        HashMap r4 = new HashMap();
        r4.put("event", "mixStream");
        r4.put("selfInteractId", String.valueOf(r2));
        b0.o().j("ttlive_pk", r4);
        if (r20.size() == 3) goto L5;
    L7:
        Iterator<f> r5 = r20.iterator();
        ?? r6 = 0;
        int r8 = 0;
    L9:
        if (r5.hasNext() == false) goto L18;
        f r9 = r5.next();
        if (TextUtils.equals(r9.b, r2) == false) goto L13;
        r9.a = 1;
        r9.f = 1.0d;
        r9.g = 1.0d;
        r9.d = 0.0d;
        r9.e = 0.0d;
        r9.l = r6;
        r9.c(r3);
        r9.i = r6;
    L17:
        r6 = 0;
        goto L9
    L13:
        r8 = r8 + 1;
        double r13 = (1.0d - this.d) - (((double) r8) * this.b);
        if (r8 <= 1) goto L16;
        r13 = r13 - (((double) (r8 - 1)) * this.e);
    L16:
        r9.a = this.f.tc(r9.b);
        double r7 = this.a;
        double r10 = this.b;
        r9.f = r7;
        r9.g = r10;
        r9.d = this.c;
        r9.e = r13;
        r9.o = 1;
        r9.c(this.f.Kn(r9.b));
        r9.i = !this.f.B7(r9.b) ? 1 : 0;
        goto L17
    L18:
        JSONObject r11 = null;
        if (((Boolean) vm2.d.S3.getValue(null, vm2.d.a[250(0xfa, float:3.5E-43)])).booleanValue() == false) goto L93;
        LiveSeiCreator r12 = this.h;
        fi6.a r14 = this.g;
        long r15 = tc0.c.h().getChannelId();
        r12.getClass();
        int r16 = com.bytedance.android.live.liveinteract.api.utils.k.c;
        Intrinsics.checkNotNullParameter(r20, "regionList");
        List<f> r1 = r20;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r21 = r1.iterator();
    L22:
        if (r21.hasNext() == false) goto L103;
        r17.add(new com.bytedance.android.live.liveinteract.api.utils.k((f) r21.next()));
        goto L22
    L103:
        int r22 = com.bytedance.android.live.liveinteract.api.utils.k.c;     // Catch: JSONException -> L100
        Intrinsics.checkNotNullParameter(r17, "regionList");     // Catch: JSONException -> L100
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));     // Catch: JSONException -> L100
        Iterator r24 = r17.iterator();     // Catch: JSONException -> L100
    L26:
        if (r24.hasNext() == false) goto L28;
        r23.add(((com.bytedance.android.live.liveinteract.api.utils.k) r24.next()).a);     // Catch: JSONException -> L100
        goto L26
    L28:
        JSONObject r25 = new JSONObject();     // Catch: JSONException -> L100
        r25.put("ver", r14.d);     // Catch: JSONException -> L100
        r25.put("vendor", Vendor.BYTE.getValue());     // Catch: JSONException -> L100
        if (r12.b != 0) goto L101;
    L51:
        long r110 = System.currentTimeMillis();     // Catch: JSONException -> L90
        r12.b = r110;     // Catch: JSONException -> L90
        r25.put("timestamp", r110);     // Catch: JSONException -> L90
        ALogger.e("ttlive_anchor_link_sei", "region changed, update timestamp, new:" + LiveSeiCreator.f(r23) + "last:" + LiveSeiCreator.f(r12.c));     // Catch: JSONException -> L90
    L52:
        r12.c = r23;     // Catch: JSONException -> L90
        r25.put("channel_id", String.valueOf(r15));     // Catch: JSONException -> L90
        JSONArray r26 = new JSONArray();     // Catch: JSONException -> L90
        Iterator r27 = r17.iterator();     // Catch: JSONException -> L90
        int r28 = 0;
    L54:
        if (r27.hasNext() == false) goto L74;
        f r29 = ((com.bytedance.android.live.liveinteract.api.utils.k) r27.next()).a;     // Catch: JSONException -> L90
        if (r29.l == false) goto L54;
        r28 = r28 + 1;     // Catch: JSONException -> L90
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L90
        r30.put("type", r29.a);     // Catch: JSONException -> L90
        r30.put("alpha", 1);     // Catch: JSONException -> L90
        r30.put("w", r29.f);     // Catch: JSONException -> L90
        if (r14.d != 2) goto L64;
        if (r28 != 1) goto L64;
        r30.put("h", 0.0d);     // Catch: JSONException -> L90
    L65:
        r30.put("x", r29.d);     // Catch: JSONException -> L90
        r30.put("y", r29.e);     // Catch: JSONException -> L90
        r30.put("account", 0);     // Catch: JSONException -> L90
        r30.put("uid", 0);     // Catch: JSONException -> L90
        r30.put("uid_str", r29.b);     // Catch: JSONException -> L90
        r30.put("zorder", 0);     // Catch: JSONException -> L90
        r30.put("stat", r29.i);     // Catch: JSONException -> L90
        if (r29.j == true) goto L68;
        int r111 = 0;
    L69:
        r30.put("talk", r111);     // Catch: JSONException -> L90
        if (r29.m == false) goto L72;
        int r31 = 1;
    L73:
        r30.put("mute_audio", r31);     // Catch: JSONException -> L90
        r26.put(r30);     // Catch: JSONException -> L90
        goto L54
    L72:
        r31 = 0;
        goto L73
    L68:
        r111 = 2;
    L64:
        r30.put("h", r29.g);     // Catch: JSONException -> L90
        goto L65
    L74:
        r25.put("grids", r26);     // Catch: JSONException -> L90
        JSONObject r32 = new JSONObject();     // Catch: JSONException -> L90
        r11 = null;
        Room r33 = k.f(IRoomContextService.class).getRoomDataContext(null).getCurrentRoom();     // Catch: JSONException -> L100
        if (r33 != null) goto L80;
    L82:
        g r34 = r14.F;     // Catch: JSONException -> L100
        if (r34 == null) goto L85;
        r32.put("width", r34.c);     // Catch: JSONException -> L100
        r32.put("height", r14.F.d);     // Catch: JSONException -> L100
    L85:
        h r35 = r14.T;     // Catch: JSONException -> L100
        if (r35 == null) goto L88;
        r32.put("background", r35.b());     // Catch: JSONException -> L100
    L88:
        r25.put("canvas", r32);     // Catch: JSONException -> L100
        new HashMap().put("sei", r25.toString());     // Catch: JSONException -> L100
        r11 = r25;
        goto L92
    L80:
        if (r33.getStreamUrlExtra() == null) goto L82;
        r32.put("width", r33.getStreamUrlExtra().getWidth());     // Catch: JSONException -> L100
        r32.put("height", r33.getStreamUrlExtra().getHeight());     // Catch: JSONException -> L100
    L90:
        r11 = null;
        goto L92
    L101:
        List<f> r112 = r12.c;     // Catch: JSONException -> L90
        if (Lists.isEmpty(r112) == false) goto L34;
    L47:
        boolean r113 = false;
    L48:
        if (r113 == false) goto L51;
        r25.put("timestamp", r12.b);     // Catch: JSONException -> L90
        goto L52
    L34:
        if (Lists.isEmpty(r23) == true) goto L47;
        ArrayList r114 = (ArrayList) r112;     // Catch: JSONException -> L90
        if (r114.size() != r23.size()) goto L47;
        int r115 = 0;
    L41:
        if (r115 >= r114.size()) goto L46;
        if (r12.a.a((f) ListProtector.get(r114, r115), (f) ListProtector.get(r23, r115)) == false) goto L47;
        r115 = r115 + 1;     // Catch: JSONException -> L90
        goto L41
    L46:
        r113 = true;
    L92:
        return r11.toString();
    L93:
        j1 r36 = this.i;
        if (r36 == null) goto L99;
        dn0.c r37 = (dn0.c) r36.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r37 == null) goto L99;
        r37.o3(r20);
    L99:
        return LiveSeiCreator.a(r20, this.g, tc0.c.h().getChannelId()).toString();
    L5:
        if (this.f.isMicRoomHost(((f) ListProtector.get(r20, 2)).b) == false) goto L7;
        ListProtector.add(r20, 1, (f) ListProtector.remove(r20, 2));
        goto L7
    }
}
