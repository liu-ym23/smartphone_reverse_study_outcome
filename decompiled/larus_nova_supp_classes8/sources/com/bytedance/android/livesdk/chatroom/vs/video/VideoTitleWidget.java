package com.bytedance.android.livesdk.chatroom.vs.video;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdkapi.paid.PaidPrivilegeItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/VideoTitleWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoTitleWidget extends LiveRecyclableWidget {
    public PaidPrivilegeItem a;
    public TextView b;

    public final int getLayoutId() {
        return 2131567020;
    }

    public final void onUnload() {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setText("");
        return;
    }

    public VideoTitleWidget() {
    }

    public final void onInit(Object[] r3) {
        this.b = (TextView) findViewById(2131380468);
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L5;
        PaidPrivilegeItem r5 = (PaidPrivilegeItem) r4.get("paid_privilege_item", new PaidPrivilegeItem());
    L6:
        this.a = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onLoad(Object[] r4) {
        DataCenter r5 = ((Widget) this).dataCenter;
        String r0 = null;
        if (r5 != null) goto L5;
    L30:
        TextView r6 = this.b;
        if (r6 == null) goto L36;
        PaidPrivilegeItem r1 = this.a;
        if (r1 == null) goto L35;
        r0 = r1.getTitle();
    L35:
        r6.setText(r0);
    L36:
        TextView r7 = this.b;
        if (r7 == null) goto L42;
        r7.setGravity(17);
        return;
    L42:
        return;
    L5:
        if (z.m(r5, true) == true) goto L30;
        TextView r8 = this.b;
        if (r8 == null) goto L27;
        PaidPrivilegeItem r2 = this.a;
        if (r2 == null) goto L12;
        String r3 = r2.getDescription();
    L14:
        if (TextUtils.isEmpty(r3) == false) goto L18;
        PaidPrivilegeItem r9 = this.a;
        if (r9 == null) goto L26;
        r0 = r9.getTitle();
    L26:
        r8.setText(r0);
        goto L27
    L18:
        StringBuilder r10 = new StringBuilder();
        PaidPrivilegeItem r11 = this.a;
        if (r11 == null) goto L21;
        String r12 = r11.getTitle();
    L22:
        r10.append(r12);
        r10.append(" | ");
        PaidPrivilegeItem r13 = this.a;
        if (r13 == null) goto L25;
        r0 = r13.getDescription();
    L25:
        r10.append(r0);
        r0 = r10.toString();
        goto L26
    L21:
        r12 = null;
        goto L22
    L12:
        r3 = null;
    L27:
        TextView r14 = this.b;
        if (r14 == null) goto L40;
        r14.setGravity(16);
        return;
    }
}
