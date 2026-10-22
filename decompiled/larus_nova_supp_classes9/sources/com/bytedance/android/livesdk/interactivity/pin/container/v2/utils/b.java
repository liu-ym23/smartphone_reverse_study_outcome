package com.bytedance.android.livesdk.interactivity.pin.container.v2.utils;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.common.utils.h;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.bdlocation.BuildConfig;
import g42.c;
import g42.d;
import g42.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final Map<String, a> a;
    public final c b;

    public static final class a {
        public HighlightItem a;
        public final long b;

        public a(HighlightItem r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
            this.b = r3;
        }
    }

    public b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        this.b = r2;
        this.a = new LinkedHashMap();
    }

    public final void a(List<HighlightItem> r20) {
        Intrinsics.checkNotNullParameter(r20, "highlightItems");
        LinkedHashSet r2 = new LinkedHashSet(((LinkedHashMap) this.a).keySet());
        Iterator<T> r1 = r20.iterator();
    L3:
        boolean r4 = false;
        com.bytedance.android.livesdk.wrds.syncdata.highlight.b r9 = null;
        if (r1.hasNext() == false) goto L22;
        final HighlightItem r3 = (HighlightItem) r1.next();
        String r15 = this.b.c(r3);
        r2.remove(r15);
        a r10 = (a) ((LinkedHashMap) this.a).get(r15);
        if (r10 == null) goto L7;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r10.a = r3;
        goto L3
    L7:
        this.a.put(r15, new a(r3, System.currentTimeMillis()));
        f r11 = this.b.m(r3);
        if (r11 == null) goto L10;
        final PinType r13 = r11.f();
    L11:
        if (r11 == null) goto L13;
        r9 = r11.q(r3);
    L13:
        if (r9 == null) goto L15;
        final long r14 = r9.getMessageId();
    L16:
        if (r9 == null) goto L19;
        String r7 = r9.getCommentContent();
        if (r7 == null) goto L19;
    L20:
        final String r16 = r7;
        int r8 = PinContainerAppLogger.a;
        final boolean r5 = z.e(this.b.getDataCenter(), false);
        final List<d> r17 = this.b.g(r13);
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r16, "commentContent");
        Intrinsics.checkNotNullParameter(r17, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_on_wall_show", new PinContainerAppLogger$logPinItemFirstShow$1(r13, r14, r16, r5, r17, r3));
        o32.a.a("onItem show uniqueKey=" + r15);
    L19:
        r7 = BuildConfig.FLAVOR;
        goto L20
    L15:
        r14 = 0;
        goto L16
    L10:
        r13 = null;
        goto L11
    L22:
        Iterator r6 = r2.iterator();
    L24:
        if (r6.hasNext() == false) goto L47;
        String r18 = (String) r6.next();
        a r19 = this.a.remove(r18);
        if (r19 == null) goto L46;
        final HighlightItem r110 = r19.a;
        final long r111 = System.currentTimeMillis() - r19.b;
        f r21 = this.b.m(r110);
        if (r21 == null) goto L30;
        final PinType r112 = r21.f();
    L31:
        if (r21 == null) goto L33;
        com.bytedance.android.livesdk.wrds.syncdata.highlight.b r23 = r21.q(r110);
    L34:
        if (r23 == null) goto L36;
        boolean r113 = r23.isReviewing();
    L37:
        if (r113 == true) goto L45;
        if (h.b(z.e(this.b.getDataCenter(), r4)) == false) goto L45;
        if (r23 == null) goto L42;
        final long r114 = r23.getMessageId();
    L43:
        int r24 = PinContainerAppLogger.a;
        final boolean r25 = z.e(this.b.getDataCenter(), r4);
        final List<d> r115 = this.b.g(r112);
        Intrinsics.checkNotNullParameter(r110, "item");
        Intrinsics.checkNotNullParameter(r115, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_stay_duration_v2", new PinContainerAppLogger$logPinShowDuration$1(r112, r114, r25, r111, r115, r110));
        goto L45
    L42:
        r114 = 0;
    L45:
        o32.a.a("onItemHide uniqueKey=" + r18 + " isReviewing=" + r113);
        goto L46
    L36:
        r113 = false;
        goto L37
    L33:
        r23 = null;
        goto L34
    L30:
        r112 = null;
    L46:
        r4 = false;
        goto L24
    }
}
