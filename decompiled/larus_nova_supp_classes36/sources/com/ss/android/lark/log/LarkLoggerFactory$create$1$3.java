package com.ss.android.lark.log;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class LarkLoggerFactory$create$1$3 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ f $logConfig;

    public LarkLoggerFactory$create$1$3(f r1) {
        this.$logConfig = r1;
        super(0);
    }

    public final Boolean invoke() {
        int r0 = e.a;
        f r1 = this.$logConfig;
        if (r1.b == 8) goto L5;
    L7:
        boolean r2 = false;
    L9:
        return Boolean.valueOf(r2);
    L5:
        if (r1.j.isEnable() == false) goto L7;
        r2 = true;
        goto L9
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1408invoke() {
        return invoke();
    }
}
