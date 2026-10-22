package com.obric.assistant.cocreationreview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationReviewServiceImpl;", "Lcom/obric/assistant/cocreationreview/IObricCocreationReviewService;", "<init>", "()V", "open", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "resetSettlementTimeMillis", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationReviewServiceImpl implements IObricCocreationReviewService {
    public CocreationReviewServiceImpl() {
    }

    @Override // com.obric.assistant.cocreationreview.IObricCocreationReviewService
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Set<String> r1 = CocreationReviewActivity.P1;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intent r0 = new Intent(r3, CocreationReviewActivity.class);
        if ((r3 instanceof Activity) == true) goto L5;
        r0.addFlags(268435456);
    L5:
        r3.startActivity(r0);
    }
}
