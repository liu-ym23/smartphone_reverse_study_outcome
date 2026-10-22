package i59;

import com.larus.dora.impl.guide.DoraBatteryGuide;
import com.larus.dora.impl.guide.DoraBindGuide;
import com.larus.dora.impl.guide.DoraBtPermissionGuide;
import com.larus.dora.impl.guide.DoraConnectDeviceGuide;
import com.larus.dora.impl.guide.DoraDNULostUserGuide;
import com.larus.dora.impl.guide.DoraKeepAliveGuide;
import com.larus.dora.impl.guide.DoraNotificationGuide;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.service.GuideSession;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public final GuideSession a;

    public d(GuideSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.a = r2;
    }

    public final l a(int r9) {
        b r0 = this.a.b;
        if (r0 != null) goto L5;
        g49.d.b("DoraGuideFactory", "createGuide, session config is null, guideId=" + r9);
        new c();
        r0 = c.a();
    L5:
        List r1 = r0.d();
        if (r1 != null) goto L10;
        new c();
        r1 = c.a().d();
        if (r1 != null) goto L10;
        r1 = CollectionsKt.emptyList();
    L10:
        List r7 = CollectionsKt.filterNotNull(r1);
        long r2 = 2592000000L;
        boolean r4 = false;
        if (r9 != DoraGuideMeta.DoraBtPermissionGuide.getGuideId()) goto L20;
        String r3 = this.a.d;
        Boolean r5 = r0.c();
        if (r5 == null) goto L15;
        r4 = r5.booleanValue();
    L15:
        Long r6 = r0.b();
        if (r6 == null) goto L45;
        r2 = r6.longValue();
    L45:
        return new DoraBtPermissionGuide(r3, r4, r2, r7);
    L20:
        if (r9 != DoraGuideMeta.DoraBindGuide.getGuideId()) goto L29;
        String r8 = this.a.d;
        Boolean r10 = r0.c();
        if (r10 == null) goto L24;
        r4 = r10.booleanValue();
    L24:
        Long r11 = r0.a();
        if (r11 == null) goto L46;
        r2 = r11.longValue();
    L46:
        return new DoraBindGuide(r8, r4, r2, r7);
    L29:
        if (r9 != DoraGuideMeta.DoraKeepAliveGuide.getGuideId()) goto L32;
        return new DoraKeepAliveGuide(this.a.d);
    L32:
        if (r9 != DoraGuideMeta.DoraConnectDeviceGuide.getGuideId()) goto L35;
        return new DoraConnectDeviceGuide(this.a.d);
    L35:
        if (r9 != DoraGuideMeta.DoraDNULostUserGuide.getGuideId()) goto L38;
        return new DoraDNULostUserGuide(this.a.d);
    L38:
        if (r9 != DoraGuideMeta.DoraNotificationGuide.getGuideId()) goto L41;
        return new DoraNotificationGuide(this.a.d);
    L41:
        if (r9 == DoraGuideMeta.DoraBatteryGuide.getGuideId()) goto L51;
        return null;
    L51:
        return new DoraBatteryGuide(this.a.d);
    }
}
