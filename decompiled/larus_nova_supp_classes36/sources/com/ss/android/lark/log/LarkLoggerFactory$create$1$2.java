package com.ss.android.lark.log;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class LarkLoggerFactory$create$1$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ f $logConfig;

    public LarkLoggerFactory$create$1$2(f r1) {
        this.$logConfig = r1;
        super(0);
    }

    public final Boolean invoke() {
        int r0 = e.a;
        f r1 = this.$logConfig;
        int r2 = r1.b;
        boolean r3 = true;
        if (r2 == 4) goto L14;
        if (r2 == 8) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L14;
        r3 = false;
        goto L14
    L7:
        if (r1.j.isEnable() == false) goto L9;
        r4 = true;
    L14:
        return Boolean.valueOf(r3);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1407invoke() {
        return invoke();
    }
}
