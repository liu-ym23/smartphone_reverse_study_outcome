package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends AbsTextLayoutCacheStore {
    public final int e;

    public static final class a {
    }

    static {
    }

    public h() {
        this.e = 60;
    }

    public static int i(com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r5) {
        Object[] r0 = new Object[36];
        r0[0] = r5.a;
        int r2 = 1;
        r0[1] = r5.b;
        r0[2] = Boolean.valueOf(r5.c);
        r0[3] = Boolean.valueOf(r5.d);
        r0[4] = Boolean.valueOf(r5.e);
        r0[5] = Boolean.valueOf(r5.f);
        r0[6] = Boolean.valueOf(r5.g);
        r0[7] = Boolean.valueOf(r5.h);
        r0[8] = Boolean.valueOf(r5.i);
        r0[9] = Boolean.valueOf(r5.k);
        r0[10] = r5.l;
        r0[11] = Boolean.valueOf(r5.m);
        ResultType r1 = r5.n.getResult();
        if (r1 != ResultType.ALLOW) goto L5;
    L8:
        r0[12] = Integer.valueOf(r2);
        r0[13] = Boolean.valueOf(r5.o);
        r0[14] = r5.p;
        r0[15] = Boolean.valueOf(r5.r);
        r0[16] = Boolean.valueOf(r5.s);
        r0[17] = r5.t;
        Boolean r3 = Boolean.FALSE;
        r0[18] = r3;
        r0[19] = r5.v;
        r0[20] = Boolean.valueOf(r5.w);
        r0[21] = Integer.valueOf(r5.x);
        r0[22] = Integer.valueOf(r5.y);
        r0[23] = r5.B;
        r0[24] = Boolean.valueOf(r5.D);
        r0[25] = Boolean.valueOf(r5.E);
        r0[26] = Boolean.valueOf(r5.F);
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b.InterfaceC0038b r4 = r5.G;
        if (r4 == null) goto L11;
        Integer r6 = r4.a();
    L12:
        r0[27] = r6;
        r0[28] = Boolean.valueOf(r5.J);
        r0[29] = Boolean.valueOf(r5.K);
        r0[30] = Integer.valueOf(r5.L);
        r0[31] = Integer.valueOf(r5.M);
        r0[32] = r3;
        r0[33] = 0;
        r0[34] = 0;
        r0[35] = Boolean.valueOf(r5.O);
        return Objects.hash(r0);
    L11:
        r6 = null;
        goto L12
    L5:
        if (r1 == ResultType.NULL) goto L8;
        r2 = r1.hashCode();
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.AbsTextLayoutCacheStore
    public final AbsTextLayoutCacheStore.b f(TextLayoutRender.e r6) {
        Intrinsics.checkNotNullParameter(r6, "renderRequest");
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r0 = r6.c;
        long r1 = System.currentTimeMillis();
        if (j(r0) == true) goto L5;
        int r7 = Objects.hash(new Object[]{Integer.valueOf(r6.d.hashCode()), Integer.valueOf(i(r0))});
        Log.d("TextLayoutCacheStore", "obtainParseCacheKey: hash cost: " + (System.currentTimeMillis() - r1));
        String r2 = r0.p;
        if (r2 != null) goto L10;
        r2 = BuildConfig.FLAVOR;
    L10:
        return new AbsTextLayoutCacheStore.b(r2, r7);
    L5:
        return AbsTextLayoutCacheStore.d;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.AbsTextLayoutCacheStore
    public final AbsTextLayoutCacheStore.b g(TextLayoutRender.g r6) {
        Intrinsics.checkNotNullParameter(r6, "renderRequest");
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r0 = r6.c;
        long r1 = System.currentTimeMillis();
        if (j(r0) == true) goto L5;
        int r7 = Objects.hash(new Object[]{Integer.valueOf(r6.d.hashCode()), Integer.valueOf(i(r0))});
        Log.d("TextLayoutCacheStore", "obtainRenderCacheKey: hash cost: " + (System.currentTimeMillis() - r1));
        String r2 = r0.p;
        if (r2 != null) goto L10;
        r2 = BuildConfig.FLAVOR;
    L10:
        return new AbsTextLayoutCacheStore.b(r2, r7);
    L5:
        return AbsTextLayoutCacheStore.d;
    }

    public final boolean j(com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r4) {
        if (this.e == 0) goto L17;
        String r0 = r4.p;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        return true;
    L13:
        if (r4.P == true) goto L19;
        return false;
    L19:
        return true;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L17:
        return true;
    }
}
