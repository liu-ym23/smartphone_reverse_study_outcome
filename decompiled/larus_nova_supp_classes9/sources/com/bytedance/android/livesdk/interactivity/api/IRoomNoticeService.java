package com.bytedance.android.livesdk.interactivity.api;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import nz.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.RoomNoticeService")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J6\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H&J0\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IRoomNoticeService;", "Lcom/bytedance/android/live/base/IService;", "Landroidx/fragment/app/FragmentActivity;", "activity", BuildConfig.FLAVOR, "userId", "enterType", "Lnz/z;", "iDialogDismissListener", BuildConfig.FLAVOR, "openRoomNoticeDialog", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "openLandscapeRoomNoticeDialog", BuildConfig.FLAVOR, "length", "getNoticeLengthTip", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomNoticeService extends IService {
    String getNoticeLengthTip(int r1);

    void openLandscapeRoomNoticeDialog(FragmentActivity r1, Room r2, String r3, String r4);

    void openRoomNoticeDialog(FragmentActivity r1, String r2, String r3, z<String> r4);
}
