package com.bytedance.android.live.openplatform.impl.miniappaudience.intention.action;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.AudienceHighIntentionContextService;
import com.bytedance.android.livesdk.config.qc1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kq0.a;
import oq0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/intention/action/HighValueCommentAction;", "Lkq0/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HighValueCommentAction extends a implements Observer<KVData> {
    @Override // kq0.b
    public final String type() {
        return "comment_high_intention";
    }

    @Override // kq0.b
    public final boolean a() {
        String r0 = String.valueOf(this.a.getRoomId());
        c r1 = this.d.b("comment_high_intention_records", r0);
        if (r1 == null) goto L5;
        long r2 = r1.a();
    L7:
        if (r2 < this.b.a()) goto L9;
        return true;
    L9:
        return false;
    L5:
        r2 = 0;
        goto L7
    }

    @Override // kq0.b
    public final void init() {
        DataCenter r0 = this.a.getDataCenter();
        if (r0 == null) goto L6;
        r0.observe("open_platform_high_value_comment_user", this);
        return;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L18;
        String r0 = r7.getKey();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.hashCode() == (-1116776705)) goto L11;
        return;
    L11:
        if (r0.equals("open_platform_high_value_comment_user") == false) goto L19;
        oq0.a r1 = this.d;
        if (Intrinsics.areEqual((Boolean) r7.getData(Boolean.FALSE), Boolean.TRUE) == false) goto L15;
        long r2 = 1;
    L16:
        r1.c("comment_high_intention_records", r2, String.valueOf(this.a.getRoomId()));
        this.c.a("comment_high_intention");
        return;
    L15:
        r2 = 0;
        goto L16
    L19:
        return;
    }

    public HighValueCommentAction(OpenPlatformContext r2, qc1 r3, AudienceHighIntentionContextService r4, oq0.a r5) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "condition");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "prefHelper");
        super(r2, r3, r4, r5);
    }
}
