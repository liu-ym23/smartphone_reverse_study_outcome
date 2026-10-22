package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentContainer {
    public FragmentContainer() {
    }

    @Deprecated
    public Fragment instantiate(Context r2, String r3, Bundle r4) {
        return Fragment.instantiate((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public abstract View onFindViewById(int r1);

    public abstract boolean onHasView();
}
