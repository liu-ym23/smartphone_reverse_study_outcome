package zr0;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.platform.ILiveProfilePlatformService;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.model.h;
import com.bytedance.android.live.profile.ui.base.f;
import com.bytedance.android.live.profile.ui.base.l;
import com.bytedance.android.live.profile.ui.component.ProfileButtonAreaComponent;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.base.d;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class a implements ILiveProfilePlatformService {
    @Override // com.bytedance.android.live.platform.ILiveProfilePlatformService
    public <T extends com.bytedance.android.live.profile.ui.component.base.b> d<T> createAssembledDataHandler(l r2) {
        Intrinsics.checkNotNullParameter(r2, "hostInterface");
        return null;
    }

    @Override // com.bytedance.android.live.platform.ILiveProfilePlatformService
    public jt0.b createTagItem(l r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "hostBehavior");
        return null;
    }

    @Override // com.bytedance.android.live.platform.ILiveProfilePlatformService
    public h getProfileBtnResource() {
        return null;
    }

    public a() {
    }

    @Override // com.bytedance.android.live.platform.ILiveProfilePlatformService
    public NewProfileInfoViewModel createProfileViewModel(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return ViewModelProviders.of(r2).get(NewProfileInfoViewModel.class);
    }

    @Override // com.bytedance.android.live.platform.ILiveProfilePlatformService
    public List<com.bytedance.android.live.profile.ui.base.b> processBusinessOpenAreaDescList(List<? extends com.bytedance.android.live.profile.ui.base.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r2, "list");
        return r2;
    }

    @Override // com.bytedance.android.live.platform.ILiveProfilePlatformService
    public List<f> processCompDescList(List<f> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r2, "list");
        return r2;
    }

    @Override // com.bytedance.android.live.platform.ILiveProfilePlatformService
    public DataAssembler<st0.b> createButtonAreaComponent(l r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "hostBehavior");
        Intrinsics.checkNotNullParameter(r3, "container");
        return new ProfileButtonAreaComponent(r2, r3);
    }
}
