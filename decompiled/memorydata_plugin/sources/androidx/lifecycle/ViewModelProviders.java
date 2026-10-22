package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelProviders {

    @Deprecated
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(Application r3) {
            super((Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin"));
        }
    }

    @Deprecated
    public ViewModelProviders() {
    }

    private static Activity checkActivity(Fragment r2) {
        GeneratePluginActivity r3 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        return r3;
    L6:
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    private static Application checkApplication(Activity r2) {
        Application r3 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        return r3;
    L6:
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    public static ViewModelProvider of(Fragment r1) {
        return of(r1, null);
    }

    public static ViewModelProvider of(Fragment r3, ViewModelProvider.Factory r4) {
        ViewModelProvider.Factory r5 = (ViewModelProvider.Factory) ZeusTransformUtils.wrapperContextForParams(r4, ViewModelProvider.Factory.class, "com.obric.memorydata.plugin");
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(checkApplication((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(checkActivity(r3), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        r5 = ViewModelProvider.AndroidViewModelFactory.getInstance(r0);
    L6:
        return new ViewModelProvider(r3.getViewModelStore(), r5);
    }

    public static ViewModelProvider of(FragmentActivity r2) {
        return of((FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.memorydata.plugin"), null);
    }

    public static ViewModelProvider of(FragmentActivity r3, ViewModelProvider.Factory r4) {
        GeneratePluginActivity r5 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        ViewModelProvider.Factory r6 = (ViewModelProvider.Factory) ZeusTransformUtils.wrapperContextForParams(r4, ViewModelProvider.Factory.class, "com.obric.memorydata.plugin");
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(checkApplication(r5), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        r6 = ViewModelProvider.AndroidViewModelFactory.getInstance(r0);
    L6:
        return new ViewModelProvider(r5.getViewModelStore(), r6);
    }
}
