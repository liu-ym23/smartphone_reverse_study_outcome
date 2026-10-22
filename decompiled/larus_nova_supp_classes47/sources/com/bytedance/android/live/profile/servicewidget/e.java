package com.bytedance.android.live.profile.servicewidget;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ProfileServiceWidget a;

    public e(ProfileServiceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        ic6.a r7 = (ic6.a) r6;
        ProfileServiceWidget r0 = this.a;
        int r1 = ProfileServiceWidget.h;
        r0.getClass();
        if (r7 == null) goto L24;
        UserProfileEvent r2 = new UserProfileEvent(r7.b);
        r2.setClickUserPosition(r7.c);
        Map r8 = r7.d;
        if (r8 == null) goto L17;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r9 = r8.entrySet().iterator();
    L9:
        if (r9.hasNext() == false) goto L16;
        Map.Entry r4 = (Map.Entry) r9.next();
        if (r4.getValue() == null) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L9;
        r3.put(r4.getKey(), r4.getValue());
        goto L9
    L13:
        r5 = false;
        goto L14
    L16:
        HashMap r10 = new HashMap();
        r10.putAll(r3);
        Unit r12 = Unit.INSTANCE;
        r2.extraFollowParams = r10;
    L17:
        r0.Aq(r2);
        return;
    }
}
