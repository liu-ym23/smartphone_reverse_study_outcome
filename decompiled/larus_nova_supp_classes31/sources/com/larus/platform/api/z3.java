package com.larus.platform.api;

import com.bytedance.applet.aibridge.AIBridgePreloadMediaResourceMethod;
import com.larus.platform.constants.media.DataLoaderPreloadPriority;
import com.larus.video.impl.sdk.o;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface z3 {

    public static final class a {
        public static /* synthetic */ void a(z3 r9, com.larus.video.impl.sdk.a r10, String r11, long r12, k0 r14, int r15) {
            if ((r15 & 2) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r15 & 4) == 0) goto L9;
            r12 = 512000;
        L9:
            long r5 = r12;
            if ((r15 & 8) == 0) goto L12;
            DataLoaderPreloadPriority r7 = DataLoaderPreloadPriority.DEFAULT;
        L14:
            if ((r15 & 16) == 0) goto L16;
            k0 r8 = null;
        L17:
            r9.l(r10, r4, r5, r7, r8);
            return;
        L16:
            r8 = r14;
            goto L17
        L12:
            r7 = null;
            goto L14
        L5:
            r4 = r11;
            goto L7
        }
    }

    int e(com.larus.video.impl.sdk.a r1);

    void f(String r1, l4 r2);

    yq9.a g(String r1);

    Object h(String r1, String r2, Continuation<? super String> r3);

    void i(yq9.d r1, AIBridgePreloadMediaResourceMethod.b r2);

    void j();

    void k(Function1<? super IVideoController, Boolean> r1);

    void l(com.larus.video.impl.sdk.a r1, String r2, long r3, DataLoaderPreloadPriority r5, k0 r6);

    o m(String r1, boolean r2, Integer r3);

    void n(Function1<? super IVideoController, Boolean> r1);

    void o();

    void switchToCellularNetwork();

    void switchToDefaultNetwork();
}
