package bf;

import android.content.Context;
import com.bytedance.ies.xelement.viewpager.viewpager.CustomViewPager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import xe.i;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends i {
    public g(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(new CustomViewPager(r5), r5);
    }

    @Override // xe.i
    public void setTabBarElementAdded(boolean r5) {
    }
}
