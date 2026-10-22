package com.bytedance.android.live.platform;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.model.h;
import com.bytedance.android.live.profile.ui.base.f;
import com.bytedance.android.live.profile.ui.base.l;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.base.b;
import com.bytedance.android.live.profile.ui.component.base.d;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J \u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017\"\b\b\u0000\u0010\u0015*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\rH&J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/platform/ILiveProfilePlatformService;", "Lcom/bytedance/android/live/base/IService;", "", "Lcom/bytedance/android/live/profile/ui/base/f;", "list", "", "processCompDescList", "Lcom/bytedance/android/live/profile/ui/base/b;", "processBusinessOpenAreaDescList", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/bytedance/android/live/profile/NewProfileInfoViewModel;", "createProfileViewModel", "Lcom/bytedance/android/live/profile/ui/base/l;", "hostBehavior", "Landroid/view/ViewGroup;", "container", "Lcom/bytedance/android/live/profile/ui/component/base/DataAssembler;", "Lst0/b;", "createButtonAreaComponent", "Lcom/bytedance/android/live/profile/ui/component/base/b;", "T", "hostInterface", "Lcom/bytedance/android/live/profile/ui/component/base/d;", "createAssembledDataHandler", "", "tagType", "Ljt0/b;", "createTagItem", "Lcom/bytedance/android/live/profile/model/h;", "getProfileBtnResource", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveProfilePlatformService extends IService {
    <T extends b> d<T> createAssembledDataHandler(l r1);

    DataAssembler<st0.b> createButtonAreaComponent(l r1, ViewGroup r2);

    NewProfileInfoViewModel createProfileViewModel(Fragment r1);

    jt0.b createTagItem(l r1, long r2);

    h getProfileBtnResource();

    List<com.bytedance.android.live.profile.ui.base.b> processBusinessOpenAreaDescList(List<? extends com.bytedance.android.live.profile.ui.base.b> r1);

    List<f> processCompDescList(List<f> r1);
}
