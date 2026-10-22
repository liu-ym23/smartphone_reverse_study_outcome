package com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext;

import af2.b;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.f;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.impl.multianchor.pk.d;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/datacontext/MultiTeamPkDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "Laf2/b;", "scoreList", "", "setPkResult", "", "", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResult;", "getPkResult", "pkResult", "Ljava/util/Map;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/f;", "getPKBaseUtils", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/f;", "pKBaseUtils", "<init>", "(Lcom/bytedance/android/live/revlink/impl/global/c;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiTeamPkDataContext extends DataContext {
    private final c linkFakeGlobalService;
    private Map<String, ? extends PkBaseResult> pkResult;

    private final f getPKBaseUtils() {
        c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPKBaseUtils();
    }

    public final Map<String, PkBaseResult> getPkResult() {
        c r0 = this.linkFakeGlobalService;
        if (r0 == null) goto L9;
        e r1 = r0.Ig();
        if (r1 == null) goto L9;
        LiveData<Map<String, PkBaseResult>> r2 = r1.getPkBaseResult();
        if (r2 == null) goto L9;
        return (Map) r2.getValue();
    L9:
        return null;
    }

    public MultiTeamPkDataContext(c r1) {
        this.linkFakeGlobalService = r1;
    }

    public final void setPkResult(List<? extends b> r5) {
        Intrinsics.checkNotNullParameter(r5, "scoreList");
        int r1 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a;
        Intrinsics.checkNotNullParameter(r5, "scoreList");
        this.pkResult = new d(PkBaseResult.WIN, PkBaseResult.LOSE, PkBaseResult.EVEN).b(r5);
    }
}
