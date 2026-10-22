package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import android.util.SparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.chatroom.model.interact.w;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ ToolbarMultiSceneGamePlayBehavior a;

    public c(ToolbarMultiSceneGamePlayBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
        Intrinsics.checkNotNullParameter(r7, "response");
        ToolbarMultiSceneGamePlayBehavior r0 = this.a;
        r0.g = ((w) r7.data).getLatestMap();
        Map<Long, Boolean> r8 = this.a.g;
        if (r8 == null) goto L10;
        Iterator<Map.Entry<Long, Boolean>> r9 = r8.entrySet().iterator();
    L6:
        if (r9.hasNext() == false) goto L10;
        Map.Entry<Long, Boolean> r1 = r9.next();
        com.bytedance.android.livesdk.sharedpref.e r2 = b6.m0;
        SparseArray r3 = (SparseArray) r2.getValue();
        if (r3.get((int) r1.getKey().longValue()) != null) goto L6;
        r3.put((int) r1.getKey().longValue(), r1.getValue());
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
        com.bytedance.android.livesdk.sharedpref.e r4 = b6.l0;
        Boolean r5 = r1.getValue();
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
    L10:
        StringBuilder r10 = new StringBuilder("hasLatestInteract: ");
        Map<Long, Boolean> r11 = this.a.g;
        boolean r12 = false;
        if (r11 == null) goto L13;
        int r13 = r11.size();
    L14:
        if (r13 <= 0) goto L16;
        r12 = true;
    L16:
        r10.append(r12);
        ALogger.w("ToolbarMultiSceneGamePlayBehavior", r10.toString());
        return;
    L13:
        r13 = 0;
        goto L14
    }
}
