package com.ss.ugc.live.sdk.platform.imbroadcast;

import com.bytedance.common.utility.collection.WeakContainer;
import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import omc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IMBroadcast {
    public final HashMap<String, WeakContainer<a>> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/live/sdk/platform/imbroadcast/IMBroadcast$DecodeFailedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "method", "", "msgId", "(Ljava/lang/String;Ljava/lang/String;)V", "platform_release"}, k = 1, mv = {1, 4, 0})
    public static final class DecodeFailedException extends Exception {
        public DecodeFailedException(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "method");
            Intrinsics.checkNotNullParameter(r4, "msgId");
            super("DecodeFailedException: [" + r3 + '_' + r4 + ']');
        }
    }

    public IMBroadcast() {
        new LimitedSizeHashMap(1024);
        this.a = new HashMap();
    }

    public final void a(String r2, a r3) {
        if (r2 == null) goto L8;
        WeakContainer<a> r0 = this.a.get(r2);
        if (r0 == null) goto L6;
        r0.add(r3);
        return;
    L6:
        WeakContainer<a> r1 = new WeakContainer();
        r1.add(r3);
        this.a.put(r2, r1);
        return;
    }
}
