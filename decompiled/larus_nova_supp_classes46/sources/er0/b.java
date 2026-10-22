package er0;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.n;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.AudienceMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.launch.AudienceLaunchMgContextService;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements wo0.a {
    public OpenPlatformContext a;

    public b() {
    }

    @Override // wo0.a
    public final jr0.a getAudienceMiniGameWidgetDescriptor() {
        return new jr0.a();
    }

    @Override // wo0.a
    public final void reportMpShow() {
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L8;
        AudienceMiniGameAppLogContextService r1 = (AudienceMiniGameAppLogContextService) r0.getService(AudienceMiniGameAppLogContextService.class);
        if (r1 == null) goto L9;
        r1.h("mp_show", null);
        return;
    L9:
        return;
    }

    @Override // xo0.a
    public final OpenPlatformContext a() {
        return this.a;
    }

    @Override // xo0.a
    public final void b(OpenPlatformContext r1) {
        this.a = r1;
    }

    @Override // wo0.a
    public final void reportMpClick(MountedMiniGameSource r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        int r7 = a.a[r6.ordinal()];
        if (r7 != 1) goto L5;
        String r8 = kr0.a.a("mg_link");
    L9:
        OpenPlatformContext r1 = this.a;
        if (r1 == null) goto L23;
        AudienceMiniGameAppLogContextService r2 = (AudienceMiniGameAppLogContextService) r1.getService(AudienceMiniGameAppLogContextService.class);
        if (r2 == null) goto L24;
        HashMap<String, String> r3 = new HashMap();
        r3.put("location", r8);
        n.e(r3);
        OpenPlatformContext r9 = this.a;
        if (r9 == null) goto L20;
        AudienceLaunchMgContextService r10 = (AudienceLaunchMgContextService) r9.getService(AudienceLaunchMgContextService.class);
        if (r10 == null) goto L20;
        if (r10.d != true) goto L20;
        r3.put("is_mg_dail_page", "1");
    L21:
        Unit r11 = Unit.INSTANCE;
        r2.h("mp_click", r3);
        return;
    L20:
        r3.put("is_mg_dail_page", "0");
        goto L21
    L24:
        return;
    L23:
        return;
    L5:
        if (r7 == 2) goto L7;
        r8 = "";
        goto L9
    L7:
        r8 = kr0.a.a("mg_card");
        goto L9
    }

    @Override // wo0.a
    public final void openMountedMiniGame(MountedMiniGameSource r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        if (r4 == null) goto L6;
        HashMap r5 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("schema", r4)});
        if (r5 == null) goto L6;
    L7:
        OpenPlatformContext r0 = this.a;
        if (r0 == null) goto L13;
        AudienceLaunchMgContextService r1 = (AudienceLaunchMgContextService) r0.getService(AudienceLaunchMgContextService.class);
        if (r1 == null) goto L14;
        AudienceLaunchMgContextService.j(r1, r3, r5);
        return;
    L14:
        return;
    L13:
        return;
    L6:
        r5 = null;
        goto L7
    }
}
