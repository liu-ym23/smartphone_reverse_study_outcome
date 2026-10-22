package com.larus.uaigc.chat.notification;

import com.larus.im.bean.message.Message;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationRefreshNotificationStrategy$a {
    public Message a;
    public final Job b;
    public final HashMap<String, CreationRefreshNotificationStrategy$b> c;
    public long d;

    public CreationRefreshNotificationStrategy$a() {
        throw null;
    }

    public CreationRefreshNotificationStrategy$a(Message r3, Job r4) {
        HashMap<String, CreationRefreshNotificationStrategy$b> r0 = new HashMap();
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "regularlyRefreshNotificationJob");
        Intrinsics.checkNotNullParameter(r0, "curUnfinishedTaskIdMap");
        this.a = r3;
        this.b = r4;
        this.c = r0;
        this.d = 2000;
    }
}
