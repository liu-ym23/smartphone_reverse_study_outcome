package pq0;

import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.comment.AudienceCommentContextService;
import com.bytedance.live.datacontext.n;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends yo0.a {
    public final String f;

    @Override // yo0.a
    public final String b() {
        return this.f;
    }

    @Override // yo0.a
    public void call(JSONObject r4, yo0.a.b r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        JSONObject r6 = new JSONObject();
        Map<Long, Integer> r0 = ((AudienceCommentContextService) this.b.getService(AudienceCommentContextService.class)).a;
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        if (r1 == null) goto L9;
        n<ShelfInfo> r2 = r1.m618getShelfInfo();
        if (r2 == null) goto L9;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
        if (r3 == null) goto L9;
        long r7 = r3.startId;
    L10:
        LinkedHashMap r8 = (LinkedHashMap) r0;
        Object r9 = r8.get(Long.valueOf(r7));
        if (r9 != null) goto L13;
        r9 = 0;
    L13:
        r6.put("commentCount", ((Number) r9).intValue());
        Unit r10 = Unit.INSTANCE;
        r5.c(r6);
        return;
    L9:
        r7 = 0;
        goto L10
    }

    public a(OpenPlatformContext r2, Queue<Long> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "callHistory");
        Intrinsics.checkNotNullParameter(r4, "appId");
        super(r2, r3, r4);
        this.f = "getSelfCommentCountDuringPluginRunning";
    }
}
