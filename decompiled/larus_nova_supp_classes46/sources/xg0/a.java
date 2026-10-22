package xg0;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFoldButtonViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPCLandscapeViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends hg0.a, MultiLinkGuestViewBinder.b, MultiLinkSpecialViewBinder.b, MultiLinkNormalEmptyViewBinder.b, MultiLinkPCLandscapeViewBinder.b, MultiLinkFoldButtonViewBinder.b, MultiLinkPreOnlineViewBinder.b, MultiLinkAudioFirstUserVirtualAvatarViewBinder.b, com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.a {
    DataCenter getDataCenter();

    int getFeedType();

    RecyclerView getMicSeatRecyclerView();

    IRoom getRoom();
}
