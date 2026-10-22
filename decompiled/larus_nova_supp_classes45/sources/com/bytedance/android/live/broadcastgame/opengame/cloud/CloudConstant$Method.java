package com.bytedance.android.live.broadcastgame.opengame.cloud;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/android/live/broadcastgame/opengame/cloud/CloudConstant$Method", "", "Lcom/bytedance/android/live/broadcastgame/opengame/cloud/CloudConstant$Method;", "Companion", "a", "GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CloudConstant$Method extends Enum<CloudConstant$Method> {
    public static final a Companion = null;
    public static final CloudConstant$Method DELETE = null;
    public static final CloudConstant$Method GET = null;
    public static final CloudConstant$Method HEAD = null;
    public static final CloudConstant$Method OPTIONS = null;
    public static final CloudConstant$Method POST = null;
    public static final CloudConstant$Method PUT = null;
    public static final /* synthetic */ CloudConstant$Method[] a = null;

    public static final class a {
        public a() {
        }
    }

    static {
        CloudConstant$Method r1 = new CloudConstant$Method("GET", 0);
        GET = r1;
        CloudConstant$Method r2 = new CloudConstant$Method("POST", 1);
        POST = r2;
        CloudConstant$Method r3 = new CloudConstant$Method("PUT", 2);
        PUT = r3;
        CloudConstant$Method r4 = new CloudConstant$Method("DELETE", 3);
        DELETE = r4;
        CloudConstant$Method r5 = new CloudConstant$Method("HEAD", 4);
        HEAD = r5;
        CloudConstant$Method r6 = new CloudConstant$Method("OPTIONS", 5);
        OPTIONS = r6;
        a = new CloudConstant$Method[]{r1, r2, r3, r4, r5, r6};
        Companion = new a();
    }

    public static CloudConstant$Method valueOf(String r1) {
        return (CloudConstant$Method) r27.a.a(CloudConstant$Method.class, r1);
    }

    public static CloudConstant$Method[] values() {
        return (CloudConstant$Method[]) a.clone();
    }

    public CloudConstant$Method(String r1, int r2) {
        super(r1, r2);
    }
}
