package com.ss.android.lark.chat.core.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import f5b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import x4b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a<T extends f5b.b, PageData extends x4b.a<T>> extends PageLoader<c, PageData> {
    public static int b = 30;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.core.model.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0085a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageFetchScene.values().length];
            a = r0;
            r0[MessageFetchScene.FIRST_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[MessageFetchScene.SPECIFIED_POSITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[MessageFetchScene.PREVIOUS_PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[MessageFetchScene.NEXT_PAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public abstract String b();

    public abstract int c(T r1);

    public abstract String d();

    public abstract x4b.a f(MessageFetchScene r1, int r2, int r3, int r4, int r5, ChannelDataFetcherStrategy r6, String r7);

    public a(Executor r1) {
        super(r1);
        if (DevicePerfManager.b.a.e.h == false) goto L6;
        b = 10;
        return;
    }

    public final void e(MessageFetchScene r19, int r20, int r21, ChannelDataFetcherStrategy r22, PageLoader.a<PageData> r23) {
        long r12 = System.currentTimeMillis();
        String r7 = com.ss.android.lark.sdk.a.a();
        int r0 = C0085a.a[r19.ordinal()];
        if (r0 != 1) goto L5;
    L7:
        int r4 = 5;
    L8:
        Log.i(d(), "load: fetchScene = [" + r19 + "], position = [" + r20 + "], pageSize = [" + r21 + "], strategy = [" + r22 + "]");
        x4b.a r1 = f(r19, r20, r21, r4, b, r22, r7);
        long r2 = System.currentTimeMillis() - r12;
        StringBuilder r3 = new StringBuilder("load success, total cost = [");
        StringBuilder r5 = new StringBuilder();
        r5.append(r2);
        r5.append("ms], channelId = [");
        r3.append(r5.toString());
        r3.append(b());
        r3.append("], type = [");
        r3.append(r19.getDesc());
        r3.append("], start position = [");
        r3.append(r20);
        if (r1 != null) goto L11;
    L14:
        r3.append("], ");
        if (r1 != null) goto L17;
        String r6 = "page data is null";
    L18:
        r3.append(r6);
    L19:
        Log.i(d(), r3.toString());
        if (r23 == null) goto L25;
        if (r1 == null) goto L23;
        r23.a(r1);
        return;
    L23:
        r23.onError(new Throwable("load data failed :" + r19.getDesc() + " " + r20 + " " + r21));
        return;
    L25:
        return;
    L17:
        r6 = "data list is empty";
        goto L18
    L11:
        if (CollectionUtils.isEmpty(r1.a) == true) goto L14;
        int r8 = c((f5b.b) ListProtector.get(r1.a, 0));
        List<T> r9 = r1.a;
        int r10 = c((f5b.b) ListProtector.get(r9, ((ArrayList) r9).size() - 1));
        r3.append("], start = [");
        r3.append(r8);
        r3.append("], end = [");
        r3.append(r10);
        r3.append("], size = [");
        r3.append(((ArrayList) r1.a).size());
        r3.append("]");
        goto L19
    L5:
        if (r0 == 2) goto L7;
        r4 = 0;
        goto L8
    }
}
