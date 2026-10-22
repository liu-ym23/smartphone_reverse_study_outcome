package zx0;

import android.graphics.RectF;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.r0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import z41.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements zx0.a {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // zx0.a
    public final b a(com.bytedance.android.live.revenue.common.player.vendor.link.c r7) {
        Intrinsics.checkNotNullParameter(r7, "reduceContext");
        RectF r0 = b(r7);
        float r1 = r7.j.f();
        if (r7.k == false) goto L17;
        int r2 = ay0.a.a();
        if (r2 == 1) goto L17;
        if (r2 != 2) goto L15;
        int r3 = r7.g;
        if (r3 == 0) goto L15;
        int r4 = r7.f;
        if (r4 == 0) goto L15;
        float r5 = r4 * 1.0f;
        float r6 = r3;
    L16:
        r1 = r5 / r6;
    L15:
        r6 = r1;
        r5 = 1;
    L17:
        sx0.a.g r8 = new sx0.a.g(r1);
        JSONObject r9 = r7.j.d();
        if (r9 != null) goto L31;
    L23:
        float r10 = 1.78f;
    L25:
        if (((Number) r7.j.u.getValue()).intValue() == 0) goto L27;
        g90.b r12 = new g90.b(r10);
    L29:
        return new b(r0, r8, r12);
    L27:
        r12 = null;
        goto L29
    L31:
        JSONObject r13 = r9.optJSONObject("stream_size");     // Catch: Throwable -> L30
        if (r13 == null) goto L23;
        r10 = (float) JSONObjectProtectorUtils.getDouble(r13, "game_ratio");
        goto L25
    }

    @Override // zx0.a
    public final RectF b(com.bytedance.android.live.revenue.common.player.vendor.link.c r15) {
        Intrinsics.checkNotNullParameter(r15, "reduceContext");
        RectF r2 = null;
        JSONObject r3 = null;
        r2 = null;
        if (((Number) r15.j.u.getValue()).intValue() == 0) goto L27;
        RevSeiFrame r0 = r15.j;
        int r4 = ((Number) r0.t.getValue()).intValue();
        if (r15.a == false) goto L8;
        if (r4 == 0) goto L8;
    L60:
        return new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    L8:
        if (r4 == 1) goto L60;
        int r1 = ((Number) r0.v.getValue()).intValue();
        float r5 = r15.j.f();
        JSONObject r16 = r15.j.d();
        if (r16 == null) goto L13;
        r3 = r16.optJSONObject("stream_size");
    L13:
        if (r3 == null) goto L15;
        float r17 = (float) r3.optDouble("y");
    L16:
        if (r3 == null) goto L18;
        float r6 = (float) r3.optDouble("h");
    L19:
        if (r3 == null) goto L21;
        float r7 = (float) r3.optDouble("game_ratio");
    L22:
        if (r1 != 0) goto L24;
        float r8 = 0.0f;
    L26:
        return new RectF(0.0f, r17, 1.0f, (r6 + r17) + r8);
    L24:
        r8 = r5 / r7;
        goto L26
    L21:
        r7 = 1.78f;
        goto L22
    L18:
        r6 = 0.0f;
        goto L19
    L15:
        r17 = 0.0f;
        goto L16
    L27:
        p0 r9 = r15.j.b();
        if (r9 == null) goto L34;
        m0 r10 = r9.f();
        if (r10 == null) goto L34;
        r0 r12 = r10.a();
        if (r12 == null) goto L34;
        Intrinsics.checkNotNullParameter(r12, "$this$rectF");
        RectF r13 = new RectF((float) r12.c(), (float) r12.d(), (float) (r12.c() + r12.b()), (float) (r12.d() + r12.a()));
    L36:
        if (r13 == null) goto L42;
        float r14 = 0;
        if (r13.height() <= r14) goto L42;
        if (r13.width() <= r14) goto L42;
        return r13;
    L42:
        p0 r18 = r15.j.b();
        if (r18 == null) goto L51;
        List r19 = r18.h();
        if (r19 == null) goto L51;
        List r110 = r19;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r111 = r110.iterator();
    L48:
        if (r111.hasNext() == false) goto L50;
        RevSeiRegion r22 = (RevSeiRegion) r111.next();
        Intrinsics.checkNotNullParameter(r22, "$this$rectF");
        r20.add(new RectF((float) r22.getX(), (float) r22.getY(), (float) (r22.getX() + r22.getWidth()), (float) (r22.getY() + r22.getHeight())));
        goto L48
    L50:
        r2 = o51.a.d(r20);
    L51:
        if (r2 == null) goto L58;
        float r23 = 0;
        if (r2.height() <= r23) goto L58;
        if (r2.width() <= r23) goto L58;
        return r2;
    L58:
        return new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    L34:
        r13 = null;
        goto L36
    }

    @Override // zx0.a
    public final boolean c(com.bytedance.android.live.revenue.common.player.vendor.link.c r2) {
        Intrinsics.checkNotNullParameter(r2, "reduceContext");
        if (g.o.b() == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.j.h() == false) goto L7;
        return true;
    }
}
