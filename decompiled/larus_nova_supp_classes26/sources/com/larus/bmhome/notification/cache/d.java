package com.larus.bmhome.notification.cache;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.resp.NotificationList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static int a;
    public static final Lazy b = null;
    public static MutableLiveData<Triple<com.larus.network.http.a<NotificationList>, Boolean, Boolean>> c;
    public static final b d = null;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.bmhome.notification.cache.b] */
    static {
        b = LazyKt.lazy(new a());
        d = new b();
    }
}
