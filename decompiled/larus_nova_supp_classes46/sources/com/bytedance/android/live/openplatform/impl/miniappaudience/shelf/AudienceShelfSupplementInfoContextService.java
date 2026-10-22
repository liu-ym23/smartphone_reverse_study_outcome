package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.live.datacontext.j;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/AudienceShelfSupplementInfoContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceShelfSupplementInfoContextService extends OpenPlatformContextService {
    public final Map<Long, com.bytedance.android.livesdk.wrds.syncdata.openplatform.b> a;
    public final Map<Long, com.bytedance.android.livesdk.wrds.syncdata.openplatform.c> b;

    public static final class a {
    }

    static {
    }

    public final void h() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        j r1 = r0.getOpenPlatformMicroAppSyncModel();
        if (r1 == null) goto L9;
        r1.c(new AudienceShelfSupplementInfoContextService$start$1(this));
        return;
    L9:
        return;
    }

    public AudienceShelfSupplementInfoContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public static int g(com.bytedance.android.livesdk.wrds.syncdata.openplatform.c r4) {
        List r0 = ((uc1) ee0.a.getValue()).j();
        if (r0 == null) goto L19;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        Object r2 = r1.next();
        int r3 = ((Number) r2).intValue();
        Map r5 = r4.explainCardSupplementMap;
        if (r5 == null) goto L12;
        boolean r6 = r5.containsKey(Integer.valueOf(r3));
        boolean r7 = true;
        if (r6 != true) goto L12;
    L13:
        if (r7 == false) goto L6;
    L16:
        Integer r8 = (Integer) r2;
        if (r8 == null) goto L19;
        return r8.intValue();
    L12:
        r7 = false;
        goto L13
    L15:
        r2 = null;
    L19:
        return -1;
    }

    public final com.bytedance.android.livesdk.wrds.syncdata.openplatform.a f(Long r4) {
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.c r5 = (com.bytedance.android.livesdk.wrds.syncdata.openplatform.c) ((LinkedHashMap) this.b).get(r4);
        if (r5 != null) goto L5;
        return null;
    L5:
        int r1 = g(r5);
        if (r1 != (-1)) goto L8;
        return null;
    L8:
        Map r6 = r5.explainCardSupplementMap;
        if (r6 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.livesdk.wrds.syncdata.openplatform.a) r6.get(Integer.valueOf(r1));
    }
}
