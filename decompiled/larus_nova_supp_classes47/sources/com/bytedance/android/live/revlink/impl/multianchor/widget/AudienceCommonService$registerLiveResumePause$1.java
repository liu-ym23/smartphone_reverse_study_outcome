package com.bytedance.android.live.revlink.impl.multianchor.widget;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class AudienceCommonService$registerLiveResumePause$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $onStatusChange;
    final /* synthetic */ c this$0;

    public AudienceCommonService$registerLiveResumePause$1(c r1, Function1 r2) {
        this.this$0 = r1;
        this.$onStatusChange = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m712invoke() {
        List<Function1<Boolean, Unit>> r0 = this.this$0.b;
        ArrayList r1 = (ArrayList) r0;
        r1.remove(this.$onStatusChange);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m712invoke();
        return Unit.INSTANCE;
    }
}
