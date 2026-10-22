package com.bytedance.android.live.livesdkapi;

import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/livesdkapi/LiveSdkApiForSaaS;", "Lil0/a;", "<init>", "()V", "Companion", "a", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveSdkApiForSaaS extends il0.a {
    public static final a Companion = null;
    private static LiveSdkApiForSaaS impl;

    public static final class a {
        public static LiveSdkApiForSaaS a() {
            LiveSdkApiForSaaS r0 = LiveSdkApiForSaaS.access$getImpl$cp();
            if (r0 == null) goto L5;
            return r0;
        L5:
            LiveSdkApiForSaaS r1 = (LiveSdkApiForSaaS) k.f(LiveSdkApiForSaaS.class);
            if (r1 != null) goto L8;
            r1 = new LiveSdkApiForSaaS();
        L8:
            LiveSdkApiForSaaS.access$setImpl$cp(r1);
            return r1;
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LiveSdkApiForSaaS() {
    }

    public static final /* synthetic */ LiveSdkApiForSaaS access$getImpl$cp() {
        return impl;
    }

    public static final /* synthetic */ void access$setImpl$cp(LiveSdkApiForSaaS r0) {
        impl = r0;
    }
}
