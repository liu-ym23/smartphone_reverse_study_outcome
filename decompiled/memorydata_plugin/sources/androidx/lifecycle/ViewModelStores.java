package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ViewModelStores {
    private ViewModelStores() {
    }

    @Deprecated
    public static ViewModelStore of(Fragment r0) {
        return r0.getViewModelStore();
    }

    @Deprecated
    public static ViewModelStore of(FragmentActivity r2) {
        return ((FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.memorydata.plugin")).getViewModelStore();
    }
}
