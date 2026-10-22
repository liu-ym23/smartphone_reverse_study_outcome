package com.bytedance.android.live.room;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.depend.IStartLiveVerifyCallback;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.livesdk.module.LiveSDKService")
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JF\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&Jp\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\nH&Jd\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\n\u0010!\u001a\u0004\u0018\u00010 H&¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/room/IMiddlewareLiveSDKService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/app/Activity;", "activity", "", "requestCode", "Lcom/bytedance/android/live/base/model/verify/c;", "status", "Landroid/os/Bundle;", "logBundle", "", "videoChatContent", "Lcom/bytedance/android/livehostapi/business/depend/IStartLiveVerifyCallback;", "callback", "", "handleRealNameConflict", "Landroidx/fragment/app/Fragment;", "fragment", "tag", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "aspectWidth", "aspectHeight", "minWidth", "minHeight", "Lcom/bytedance/android/live/room/g$b;", "listener", "Lcom/bytedance/android/live/room/IEntranceContext;", "entranceContext", "suffix", "Lcom/bytedance/android/live/room/g;", "createImagePicker", "Lcom/bytedance/android/live/room/o;", "getLottiePlayService", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareLiveSDKService extends IService {
    g createImagePicker(Activity r1, Fragment r2, String r3, DataCenter r4, int r5, int r6, int r7, int r8, g.b r9, IEntranceContext r10);

    g createImagePicker(Activity r1, Fragment r2, String r3, DataCenter r4, int r5, int r6, int r7, int r8, g.b r9, IEntranceContext r10, String r12);

    o getLottiePlayService();

    void handleRealNameConflict(Activity r1, int r2, com.bytedance.android.live.base.model.verify.c r3, Bundle r4, String r5, IStartLiveVerifyCallback r6);
}
