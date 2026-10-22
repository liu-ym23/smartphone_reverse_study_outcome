package lq0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.AudienceHighIntentionContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends vq0.a {
    public a(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        String r3 = r9.getString("mpId", "");
        String r5 = r9.getString("pagePath", "");
        String r10 = r9.getString("roomId", "");
        AudienceHighIntentionContextService r2 = (AudienceHighIntentionContextService) this.a.getService(AudienceHighIntentionContextService.class);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "mpId");
        Intrinsics.checkNotNullParameter(r5, "pagePath");
        Intrinsics.checkNotNullParameter(r10, "roomId");
        qo0.a.c("AudienceHighIntentionContextService", "onClueComplete");
        r2.b.d("clue_complete_records", String.valueOf(r2.e), 1);
        return null;
    }
}
