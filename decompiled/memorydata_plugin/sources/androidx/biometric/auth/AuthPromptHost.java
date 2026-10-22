package androidx.biometric.auth;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AuthPromptHost {
    private FragmentActivity mActivity;
    private Fragment mFragment;

    public AuthPromptHost(Fragment r1) {
        this.mFragment = r1;
    }

    public AuthPromptHost(FragmentActivity r3) {
        this.mActivity = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
    }

    public FragmentActivity getActivity() {
        return this.mActivity;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }
}
