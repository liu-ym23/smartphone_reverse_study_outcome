package jv1;

import com.bytedance.android.livesdk.room.LiveScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveScope.values().length];
        a = r0;
        r0[LiveScope.SESSION.ordinal()] = 1;
        r0[LiveScope.ROOM.ordinal()] = 2;
        r0[LiveScope.LIVE.ordinal()] = 3;
    }
}
