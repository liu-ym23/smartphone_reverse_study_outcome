package com.bytedance.android.livesdk.interactivity.quickcomment;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements com.bytedance.android.livesdk.interactivity.api.quickcomment.e {
    public final List<IQuickCommentShowWord> b;
    public final int c;
    public final int d;
    public final DataCenter e;

    public static final class a {
    }

    static {
    }

    public final String b() {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L10;
        o r1 = IRoomContextService.a.a(r0, this.e, 0, 2);
        if (r1 == null) goto L10;
        m r2 = r1.K2();
        if (r2 == null) goto L10;
        String r3 = (String) r2.getValue();
        if (r3 == null) goto L10;
        return r3;
    L10:
        return BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.e
    public final List<IQuickCommentShowWord> a() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.e
    public final int getDuration() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.quickcomment.e
    public int getType() {
        return this.d;
    }

    public c(com.bytedance.android.livesdk.interactivity.api.quickcomment.d r13, DataCenter r14) {
        Intrinsics.checkNotNullParameter(r13, "fixedSyncData");
        this.e = r14;
        this.b = new ArrayList();
        this.c = 30;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a.getClass();
        this.d = 3;
        Intrinsics.checkNotNullParameter(r13, "syncData");
        com.bytedance.android.livesdk.interactivity.api.quickcomment.b r15 = r13.fastChatInfo;
        if (r15 == null) goto L42;
        List<com.bytedance.android.livesdk.interactivity.api.quickcomment.b.a> r16 = r15.fastChatList;
        ArrayList r0 = null;
        if (r16 == null) goto L34;
        ArrayList r1 = new ArrayList();
        Iterator<T> r17 = r16.iterator();
    L8:
        if (r17.hasNext() == false) goto L33;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.b.a r2 = (com.bytedance.android.livesdk.interactivity.api.quickcomment.b.a) r17.next();
        long r3 = r2.type;
        if (r3 != 1) goto L13;
        String r4 = r2.content;
    L28:
        if (r4 != null) goto L30;
        r4 = BuildConfig.FLAVOR;
    L30:
        QuickCommentShowWord r5 = new QuickCommentShowWord(r4, getType(), r15.bubbleColor);
    L31:
        if (r5 == null) goto L8;
        r1.add(r5);
        goto L8
    L13:
        if (r3 == 2) goto L15;
        r4 = r2.content;
        goto L28
    L15:
        if (b().length() != 0) goto L17;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L21;
        ALogger.e("OGCFixedCommentShowEvent", "replace cityName null, skip");
        r5 = null;
        goto L31
    L21:
        String r7 = r2.content;
        if (r7 == null) goto L24;
        r4 = StringsKt.replace$default(r7, "%v", b(), false, 4, null);
    L25:
        ALogger.i("OGCFixedCommentShowEvent", "replace cityName: result = " + r4);
        goto L28
    L24:
        r4 = null;
        goto L25
    L17:
        r6 = false;
        goto L19
    L33:
        r0 = r1;
    L34:
        if (r0 == null) goto L43;
        this.b.addAll(r0);
        return;
    L43:
        return;
    }
}
