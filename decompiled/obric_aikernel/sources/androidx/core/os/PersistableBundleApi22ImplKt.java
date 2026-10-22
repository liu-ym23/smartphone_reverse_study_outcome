package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
final class PersistableBundleApi22ImplKt {
    public static final PersistableBundleApi22ImplKt INSTANCE = null;

    static {
        INSTANCE = new PersistableBundleApi22ImplKt();
    }

    private PersistableBundleApi22ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    public static final void putBoolean(PersistableBundle r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "persistableBundle");
        r10.putBoolean(r11, r12);
    }

    @JvmStatic
    @DoNotInline
    public static final void putBooleanArray(PersistableBundle r10, String r11, boolean[] r12) {
        Intrinsics.checkNotNullParameter(r10, "persistableBundle");
        Intrinsics.checkNotNullParameter(r12, EventBody.KEY_VALUE);
        r10.putBooleanArray(r11, r12);
    }
}
