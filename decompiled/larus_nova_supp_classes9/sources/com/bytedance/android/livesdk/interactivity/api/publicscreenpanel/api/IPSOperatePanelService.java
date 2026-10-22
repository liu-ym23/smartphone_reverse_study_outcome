package com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.r;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.PSOperatePanelService")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/api/IPSOperatePanelService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/base/model/message/t;", "message", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/s;", "messageModel", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/r;", "callback", BuildConfig.FLAVOR, "openOperatePanel", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPSOperatePanelService extends IService {
    void openOperatePanel(t r1, Context r2, s r3, r r4);
}
