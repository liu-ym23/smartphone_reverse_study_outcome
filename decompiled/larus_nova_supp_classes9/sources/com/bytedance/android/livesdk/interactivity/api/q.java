package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import com.bytedance.android.live.base.model.message.i6;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q {
    public static final q a = null;

    public q() {
    }

    public static final com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l a() {
        h r1 = i.b(null, 3);
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l> r2 = r1.getAudienceOperateManager();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l) r2.getValue();
    L8:
        return null;
    }

    public static final com.bytedance.android.livesdk.interactivity.api.publicscreen.b b() {
        h r1 = i.b(null, 3);
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r2 = r1.getBarrageContext();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) r2.getValue();
    L8:
        return null;
    }

    @JvmStatic
    public static final EffectiveActivityEmojiGroup c() {
        h r1 = i.b(null, 3);
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.d> r2 = r1.getActivityEmojiManager();
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.api.emoji.d r3 = (com.bytedance.android.livesdk.interactivity.api.emoji.d) r2.getValue();
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.a();
    L11:
        return null;
    L10:
        return null;
    }

    public static final com.bytedance.android.livesdk.interactivity.api.emoji.e d() {
        h r1 = i.b(null, 3);
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.e> r2 = r1.getFusionEmojiManager();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.livesdk.interactivity.api.emoji.e) r2.getValue();
    L8:
        return null;
    }

    @JvmStatic
    public static final String e() {
        h r1 = i.b(null, 3);
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.f> r2 = r1.getLowPcuGuideChatManager();
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.api.emoji.f r3 = (com.bytedance.android.livesdk.interactivity.api.emoji.f) r2.getValue();
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getCity();
    L11:
        return null;
    L10:
        return null;
    }

    @JvmStatic
    public static final i6 f() {
        h r1 = i.b(null, 3);
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.f> r2 = r1.getLowPcuGuideChatManager();
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.api.emoji.f r3 = (com.bytedance.android.livesdk.interactivity.api.emoji.f) r2.getValue();
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getLowPcuGuideChatData();
    L11:
        return null;
    L10:
        return null;
    }

    public static final IntercomSyncDataModel h() {
        h r1 = i.b(null, 3);
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.j<IntercomSyncDataModel> r2 = r1.getIntercomSyncDataModel();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (IntercomSyncDataModel) r2.getValue();
    L8:
        return null;
    }

    public static final com.bytedance.android.livesdk.interactivity.api.publicscreen.l i() {
        h r1 = i.b(null, 3);
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r2 = r1.getPublicScreenContext();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r2.getValue();
    L8:
        return null;
    }

    @JvmStatic
    public static final boolean k() {
        h r0 = i.b(null, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.f> r1 = r0.getLowPcuGuideChatManager();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.emoji.f r2 = (com.bytedance.android.livesdk.interactivity.api.emoji.f) r1.getValue();
        if (r2 == null) goto L9;
        return r2.a();
    L9:
        return false;
    }

    static {
        a = new q();
    }

    public static final h g() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(h.class);
        if ((r0 instanceof h) == true) goto L6;
        r0 = null;
    L6:
        return (h) r0;
    }

    public static RiskAdviseSyncModel j(DataCenter r1) {
        h r2 = i.a(null, r1);
        if (r2 == null) goto L8;
        com.bytedance.live.datacontext.j<RiskAdviseSyncModel> r3 = r2.getRiskAdviseSyncModel();
        if (r3 != null) goto L7;
        return null;
    L7:
        return (RiskAdviseSyncModel) r3.getValue();
    L8:
        return null;
    }
}
