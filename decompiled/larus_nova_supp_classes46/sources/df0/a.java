package df0;

import aj6.d;
import android.text.TextUtils;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiCreator;
import com.bytedance.android.live.liveinteract.api.utils.StringEscapeUtils;
import com.bytedance.android.live.liveinteract.api.utils.g;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.wz;
import com.bytedance.android.livesdk.config.xz;
import com.bytedance.ies.sdk.widgets.DataCenter;
import he0.b;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import tc0.c;
import ti6.f;
import ti6.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements j {
    public final b.a a;
    public fi6.a b;
    public final Map<String, Integer> c;
    public boolean d;
    public final HashMap<String, Integer> e;
    public String f;
    public final DataCenter g;

    public final /* synthetic */ boolean b(d r1, aj6.b r2) {
        ti6.a.a(r1, r2);
        return false;
    }

    public a(b.a r2, String r3, DataCenter r4) {
        this.c = new HashMap();
        this.e = new HashMap();
        this.a = r2;
        this.f = r3;
        this.g = r4;
    }

    public final String a(int r17, int r18, List<f> r19) {
        Intrinsics.checkNotNullParameter(r19, "mixRegions");
        b.a r2 = this.a;
        if (r2 == null) goto L5;
        int r7 = r2.getUILayout();
    L7:
        if (ArraysKt.contains((Integer[]) vm2.d.X2.getValue(null, vm2.d.a[203(0xcb, float:2.84E-43)]), Integer.valueOf(je0.d.f())) == false) goto L9;
        HashMap<String, Integer> r3 = new HashMap();
    L10:
        HashMap<String, Integer> r4 = r3;
        if (r4 == null) goto L13;
        r4.clear();
    L13:
        Iterator<f> r5 = r19.iterator();
    L15:
        if (r5.hasNext() == false) goto L46;
        f r6 = r5.next();
        String r12 = c.h().f;
        String r14 = r6.b;
        LinkUserDataMergeContext.a r15 = LinkUserDataMergeContext.Companion;
        if (r15 == null) goto L32;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r8 = LinkUserDataMergeContext.a.b(r15, this.g);
        if (r8 == null) goto L32;
        BehaviorSubject<List<e>> r9 = r8.f();
        if (r9 == null) goto L32;
        List r10 = (List) r9.getValue();
        if (r10 == null) goto L32;
        Iterator r11 = r10.iterator();
    L26:
        if (r11.hasNext() == false) goto L30;
        Object r16 = r11.next();
        if (Intrinsics.areEqual(((e) r16).a.getInteractId(), r14) == false) goto L26;
    L31:
        e r110 = (e) r16;
    L33:
        if (r110 == null) goto L40;
        ILinkPlayerInfoBridge r13 = r110.a;
        if (r13 == null) goto L40;
        IBaseUser r20 = r13.getUser();
        if (r20 == null) goto L40;
        String r21 = r20.getIdString();
        if (r21 == null) goto L40;
    L42:
        if (TextUtils.equals(r12, r6.b) == false) goto L44;
        r6.a = 1;
        r6.f = 1.0d;
        r6.g = 1.0d;
        r6.c(r21);
        r6.d = 0.0d;
        r6.e = 0.0d;
        r6.i = 0;
        r6.m = true;
        goto L15
    L44:
        r6.a = 2;
        r6.f = 0.1d;
        r6.g = 0.1d;
        r6.c(r21);
        r6.d = 1.0d;
        r6.e = 1.0d;
        r6.m = true;
    L40:
        r21 = "";
        goto L42
    L30:
        r16 = null;
    L32:
        r110 = null;
        goto L33
    L46:
        boolean r22 = ff0.c.a;
        boolean r23 = ((Boolean) xz.a.getValue()).booleanValue();
        boolean r24 = ((Boolean) wz.a.getValue()).booleanValue();
        f r25 = new f();
        r25.a = 1;
        r25.f = 1.0d;
        r25.g = 1.0d;
        r25.y = this.f;
        r25.d = 0.0d;
        r25.e = 0.0d;
        r25.o = 1;
        r25.A = r24;
        r25.z = r23;
        r19.add(r25);
        b.a r26 = this.a;
        if (r26 == null) goto L49;
        boolean r27 = r26.J8();
    L50:
        b.a r28 = this.a;
        if (r28 == null) goto L53;
        int r111 = r28.he();
    L54:
        Map<String, Integer> r29 = this.c;
        fi6.a r30 = this.b;
        long r31 = c.h().getChannelId();
        b.a r112 = this.a;
        if (r112 == null) goto L57;
        List<Integer> r113 = r112.R4();
    L58:
        String r1 = LiveSeiCreator.b(r19, r29, r30, r4, r31, r7, r27, 0, r111, r113, -1).toString();
        if (StringEscapeUtils.a(r1).length() >= 950) goto L61;
    L63:
        return r1;
    L61:
        if (this.d == true) goto L63;
        HashMap r32 = new HashMap();
        r32.put("sei", r1);
        g.n("sei_too_long", r32, c.h(), true);
        this.d = true;
        goto L63
    L57:
        r113 = null;
        goto L58
    L53:
        r111 = 0;
        goto L54
    L49:
        r27 = false;
        goto L50
    L9:
        r3 = this.e;
        goto L10
    L5:
        r7 = 0;
        goto L7
    }
}
