package ox1;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final InnerContextEntity a(Activity r1, InnerContextEntity.InnerFloatExtra r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        InnerContextEntity r0 = new InnerContextEntity(r1);
        r0.setDataSource(c.a(r2));
        if (r2 == null) goto L5;
        HashMap r3 = r2.getMobParams();
    L6:
        r0.setMobParams(r3);
        r0.setEnterExtra(r2);
        return r0;
    L5:
        r3 = null;
        goto L6
    }

    @JvmStatic
    public static final InnerContextEntity b(DialogFragment r1, FrameLayout r2, InnerContextEntity.InnerFloatExtra r3) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        InnerContextEntity r0 = new InnerContextEntity(r1, r2, r3);
        r0.setDataSource(c.a(r3));
        if (r3 == null) goto L5;
        HashMap r4 = r3.getMobParams();
    L6:
        r0.setMobParams(r4);
        r0.setEnterExtra(r3);
        return r0;
    L5:
        r4 = null;
        goto L6
    }
}
