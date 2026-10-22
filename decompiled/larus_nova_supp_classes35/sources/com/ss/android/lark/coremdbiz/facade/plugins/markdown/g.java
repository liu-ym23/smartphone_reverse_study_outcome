package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import android.view.View;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import java.util.Map;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends com.ss.android.lark.movable.a {
    public final /* synthetic */ Function3<View, String, Map<String, ImageSetV2>, Boolean> a;
    public final /* synthetic */ Map<String, ImageSetV2> b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function3<? super View, ? super String, ? super Map<String, ImageSetV2>, Boolean> r1, Map<String, ImageSetV2> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean c(View r3, String r4, com.ss.android.lark.movable.attatchment.b r5) {
        Intrinsics.checkNotNullParameter(r3, "anchorView");
        Intrinsics.checkNotNullParameter(r4, "imageKey");
        Intrinsics.checkNotNullParameter(r5, "attachmentInfo");
        Function3<View, String, Map<String, ImageSetV2>, Boolean> r6 = this.a;
        if (r6 != null) goto L5;
        return false;
    L5:
        if (((Boolean) r6.invoke(r3, r4, this.b)).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
