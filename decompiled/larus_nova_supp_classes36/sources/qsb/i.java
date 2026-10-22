package qsb;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public static final int a(int r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return UIUtils.dp2px(r2, r1);
    }
}
