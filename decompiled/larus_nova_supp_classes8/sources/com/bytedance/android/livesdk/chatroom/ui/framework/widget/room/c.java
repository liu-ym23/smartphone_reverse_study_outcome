package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.model.b3;
import com.bytedance.android.livesdk.chatroom.model.s;
import com.bytedance.android.livesdk.chatroom.model.w3;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ AudienceRoomManageWidget a;
    public final /* synthetic */ String b;

    public c(AudienceRoomManageWidget r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        s r8 = (s) r7;
        Intrinsics.checkNotNullParameter(r8, "response");
        Iterator r9 = r8.a().iterator();
    L4:
        if (r9.hasNext() == false) goto L19;
        b3 r0 = (b3) r9.next();
        if (r0 == null) goto L4;
        if (r0.a() != 195) goto L4;
        List r1 = r0.b();
        if (r1 == null) goto L4;
        Iterator r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L4;
        w3 r3 = (w3) r2.next();
        if (TextUtils.equals(String.valueOf(r3.d()), this.b) == false) goto L13;
        if (r3.c() != 0) goto L13;
        this.a.zq();
        ALogger.d("CheckUserLiveStatus", "Close check_user_live_status failed");
        goto L13
    }
}
