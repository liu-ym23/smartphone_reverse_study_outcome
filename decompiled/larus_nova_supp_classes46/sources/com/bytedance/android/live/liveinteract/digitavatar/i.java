package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;

    static {
        if (jc1.k.n(IMiddleWareHostContext.class).isBoe() == false) goto L9;
        if (a() == false) goto L7;
        String r0 = "2388856";
    L12:
        a = r0;
        if (jc1.k.n(IMiddleWareHostContext.class).isBoe() == false) goto L19;
        if (a() == false) goto L17;
        String r1 = "2388858";
    L22:
        b = r1;
        if (jc1.k.n(IMiddleWareHostContext.class).isBoe() == false) goto L29;
        if (a() == false) goto L27;
        String r2 = "2388860";
    L32:
        c = r2;
        if (jc1.k.n(IMiddleWareHostContext.class).isBoe() == false) goto L39;
        if (a() == false) goto L37;
        String r3 = "2388862";
    L42:
        d = r3;
        if (jc1.k.n(IMiddleWareHostContext.class).isBoe() == false) goto L49;
        if (a() == false) goto L47;
        String r4 = "2388864";
    L52:
        e = r4;
        return;
    L47:
        r4 = "2388865";
        goto L52
    L49:
        if (a() == false) goto L51;
        r4 = "1235503";
        goto L52
    L51:
        r4 = "1235504";
        goto L52
    L37:
        r3 = "2388863";
        goto L42
    L39:
        if (a() == false) goto L41;
        r3 = "1209123";
        goto L42
    L41:
        r3 = "1209124";
        goto L42
    L27:
        r2 = "2388861";
        goto L32
    L29:
        if (a() == false) goto L31;
        r2 = "1120551";
        goto L32
    L31:
        r2 = "1120552";
        goto L32
    L17:
        r1 = "2388859";
        goto L22
    L19:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L21;
        r1 = "1120549";
        goto L22
    L21:
        r1 = "1120550";
        goto L22
    L7:
        r0 = "2388857";
        goto L12
    L9:
        if (a() == false) goto L11;
        r0 = "1120533";
        goto L12
    L11:
        r0 = "1120534";
        goto L12
    }

    public static boolean a() {
        return Intrinsics.areEqual("local_test", jc1.k.n(IMiddleWareHostContext.class).getChannel());
    }
}
