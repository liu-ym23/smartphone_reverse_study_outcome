package com.bytedance.android.live.cloudgrouplive.widget;

import a40.k;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.cloudgrouplive.core.CloudGroupLiveManager;
import com.bytedance.android.live.cloudgrouplive.im.CloudGroupLiveMsgManager;
import com.bytedance.android.live.cloudgrouplive.im.CloudGroupLiveMsgManager$mOnMessageListener$2;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.cloudgrouplive.rtc.CloudGroupLiveRTCManager;
import com.bytedance.android.live.cloudgrouplive.utils.AnchorExitGroupLiveType;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.ui.framework.a;
import com.bytedance.android.livesdk.message.model.d3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import e40.f;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/widget/CloudGroupLiveWidget;", "Lcom/bytedance/android/live/cloudgrouplive/widget/BaseCloudGroupLiveWidget;", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CloudGroupLiveWidget extends BaseCloudGroupLiveWidget {
    public CloudGroupLiveManager a;
    public final ViewGroup b;
    public final a c;

    public final int getLayoutId() {
        return 2131567631;
    }

    public final void onCreate() {
        super.onCreate();
        CloudGroupLiveManager r0 = new CloudGroupLiveManager();
        this.a = r0;
        Context r1 = ((Widget) this).context;
        DataCenter r2 = ((Widget) this).dataCenter;
        View r3 = ((Widget) this).contentView;
        if ((r3 instanceof ViewGroup) == true) goto L5;
        r3 = null;
    L5:
        r0.e(r1, r2, (ViewGroup) r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        CloudGroupLiveManager r0 = this.a;
        if (r0 == null) goto L48;
        ALogger.i("CloudGroupLiveManager", "destroy");
        int r2 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.LIVE_MANAGER, "destroy", 0, null, 28);
        if (r0.d == CloudGroupLivePipelineStatus.END) goto L17;
        d3 r3 = r0.k;
        if (r3 == null) goto L11;
        IBaseUser r4 = r3.getFromUser();
        if (r4 == null) goto L11;
        String r5 = r4.getUserId();
    L12:
        String r6 = String.valueOf(r5);
        d3 r7 = r0.k;
        if (r7 == null) goto L15;
        Long r8 = r7.E();
    L16:
        f40.a.a(r6, String.valueOf(r8), AnchorExitGroupLiveType.CLOSE_LIVE);
        goto L17
    L15:
        r8 = null;
    L11:
        r5 = null;
    L17:
        CloudGroupLiveRTCManager r9 = r0.e;
        if (r9 == null) goto L20;
        r9.d = null;
    L20:
        if (r9 == null) goto L22;
        f40.a.d(CloudGroupLiveTraceEvent.RTC_MANAGER, "destroy", 0, null, 28);
        ALogger.i("CloudGroupLiveRTCManager", "destroy");
        r9.f("destroy");
    L22:
        CloudGroupLiveMsgManager r11 = r0.f;
        if (r11 == null) goto L31;
        d r12 = r11.a;
        if (r12 == null) goto L27;
        r12.removeMessageListener((CloudGroupLiveMsgManager$mOnMessageListener$2.a) r11.c.getValue());
    L27:
        Iterator<com.bytedance.android.live.cloudgrouplive.im.a> r13 = r11.b.iterator();
    L29:
        if (r13.hasNext() == false) goto L31;
        com.bytedance.android.live.cloudgrouplive.im.a r14 = r13.next();
        Intrinsics.checkNotNullParameter(r14, "listener");
        r11.b.remove(r14);
    L31:
        f r15 = r0.g;
        if (r15 == null) goto L34;
        r15.a();
    L34:
        c40.a r16 = r0.h;
        if (r16 != null) goto L37;
    L39:
        k r17 = r0.i;
        if (r17 != null) goto L42;
    L44:
        d40.a r18 = r0.j;
        if (r18 == null) goto L47;
        r18.b();
    L47:
        r0.l = null;
        goto L48
    L42:
        if (r17.a.isDisposed() == true) goto L44;
        r17.a.dispose();
        goto L44
    L37:
        if (r16.a.isDisposed() == true) goto L39;
        r16.a.dispose();
    L48:
        this.a = null;
    }

    public CloudGroupLiveWidget(ViewGroup r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        this.b = r2;
        this.c = r3;
    }
}
