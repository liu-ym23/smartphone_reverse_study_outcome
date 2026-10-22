package com.bytedance.android.live.room.navi.userinfo_p.viewmodel;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final o81.a a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getAnchorInfoWidgetContext");
        r r3 = z51.a.e(r2);
        ViewModel r0 = null;
        if (r3 == null) goto L7;
        j r4 = r3.t();
        if (r4 == null) goto L7;
        ViewModel r5 = (ViewModel) r4.getValue();
    L9:
        if ((r5 instanceof o81.a) == false) goto L13;
        r0 = r5;
    L13:
        return (o81.a) r0;
    L7:
        r5 = null;
        goto L9
    }
}
