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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/intention/action/DiggCountAction;", "Lkq0/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DiggCountAction extends a implements Observer<KVData> {
    @Override // kq0.b
    public final String type() {
        return "digg_count";
    }

    @Override // kq0.b
    public final boolean a() {
        String r0 = String.valueOf(this.a.getRoomId());
        c r1 = this.d.b("digg_count_records", r0);
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
        r0.observe("data_self_digg_count", this);
        return;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L18;
        String r0 = r7.getKey();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.hashCode() == 605962419) goto L11;
        return;
    L11:
        if (r0.equals("data_self_digg_count") == false) goto L19;
        oq0.a r1 = this.d;
        Integer r8 = (Integer) r7.getData(0);
        if (r8 == null) goto L15;
        long r2 = r8.intValue();
    L16:
        r1.c("digg_count_records", r2, String.valueOf(this.a.getRoomId()));
        this.c.a("digg_count");
        return;
    L15:
        r2 = 0;
        goto L16
    L19:
        return;
    }

    public DiggCountAction(OpenPlatformContext r2, qc1 r3, AudienceHighIntentionContextService r4, oq0.a r5) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "condition");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "prefHelper");
        super(r2, r3, r4, r5);
    }
}
