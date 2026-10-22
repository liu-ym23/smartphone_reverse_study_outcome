package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.j;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements f52.d, l {
    public Disposable a;
    public f52.b b;
    public final Map<String, com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a> c;
    public final String d;

    public static final class a {
    }

    static {
    }

    @Override // f52.d
    public final void onUnload() {
        ALogger.i("CommonTrayViewManager", "onUnload");
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
        this.b = null;
    }

    public e() {
        this.c = new HashMap();
        this.d = "CommonTrayViewManager";
    }

    @Override // f52.d
    public final String getId() {
        return this.d;
    }

    @Override // f52.d
    public final void j(f52.b r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        ALogger.i("CommonTrayViewManager", "onLoad");
        this.b = r3;
        vlc.d r4 = j.b(r3.getDataCenter());
        if (r4 == null) goto L5;
        Disposable r5 = j.c(r4, "WebcastTrayEffectMessage", this);
    L6:
        this.a = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onMessage(tlc.d r7) {
        if ((r7 instanceof n5) == false) goto L29;
        n5 r8 = (n5) r7;
        String r0 = r8.getScene();
        int r1 = 0;
        if (r0 != null) goto L7;
    L10:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L16;
        ALogger.e("CommonTrayViewManager", "scene is null or empty. msgId=" + r8.getMessageId());
        return;
    L16:
        if (r8.getContent() != null) goto L19;
        ALogger.e("CommonTrayViewManager", "content is null. msgId=" + r8.getMessageId());
        return;
    L19:
        StringBuilder r3 = new StringBuilder("onMessage. id=");
        r3.append(r8.getMessageId());
        r3.append(" scene=");
        r3.append(r8.getScene());
        r3.append(" subScene=");
        r3.append(r8.getSubScene());
        r3.append(" pri=");
        Intrinsics.checkNotNullParameter(r8, "$this$showPriority");
        n5.f r4 = r8.getPriorityConfig();
        if (r4 == null) goto L22;
        r1 = r4.priority;
    L22:
        r3.append(r1);
        ALogger.i("CommonTrayViewManager", r3.toString());
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a r5 = (com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a) ((HashMap) this.c).get(r0);
        if (r5 != null) goto L25;
        r5 = new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a();
        ((HashMap) this.c).put(r0, r5);
    L25:
        CommonTrayPSTopView r6 = new CommonTrayPSTopView(String.valueOf(r8.getMessageId()), r8, r5);
        f52.b r9 = this.b;
        if (r9 == null) goto L30;
        r9.a(r6);
        return;
    L30:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r2 = false;
        goto L12
    }
}
