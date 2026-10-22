package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements h {
    public a() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.h
    public final boolean a(IMusicControlNode r11, CopyOnWriteArrayList<IMusicControlNode> r12, CopyOnWriteArrayList<IMusicControlNode> r13) {
        Intrinsics.checkNotNullParameter(r11, "node");
        Intrinsics.checkNotNullParameter(r12, "waitingList");
        Intrinsics.checkNotNullParameter(r13, "runningList");
        boolean r1 = false;
        if (r13.isEmpty() == false) goto L6;
        return false;
    L6:
        if ((r13.get(0) instanceof b) == true) goto L8;
    L49:
        return true;
    L8:
        if ((r11 instanceof b) == false) goto L49;
        int r0 = r13.size();
        int r3 = 0;
    L11:
        if (r3 >= r0) goto L29;
        IMusicControlNode r5 = r13.get(r3);
        if ((r5 instanceof b) == false) goto L27;
        MusicPanel r6 = ((b) r5).d;
        if (r6 == null) goto L27;
        KtvMusic r7 = r6.a;
        if (r7 == null) goto L27;
        long r8 = r7.getId();
        MusicPanel r9 = ((b) r11).d;
        if (r9 == null) goto L23;
        KtvMusic r14 = r9.a;
        if (r14 == null) goto L23;
        Long r15 = Long.valueOf(r14.getId());
    L25:
        if (r8 != r15.longValue()) goto L27;
        r12.remove(r11);
        r1 = true;
    L23:
        r15 = null;
    L27:
        r3 = r3 + 1;
    L29:
        if (r12.isEmpty() == true) goto L48;
        Iterator<IMusicControlNode> r16 = r12.iterator();
    L32:
        if (r16.hasNext() == false) goto L48;
        IMusicControlNode r2 = r16.next();
        if ((r2 instanceof b) == false) goto L32;
        MusicPanel r4 = ((b) r2).d;
        if (r4 == null) goto L32;
        KtvMusic r17 = r4.a;
        if (r17 == null) goto L32;
        long r18 = r17.getId();
        MusicPanel r19 = ((b) r11).d;
        if (r19 == null) goto L44;
        KtvMusic r21 = r19.a;
        if (r21 == null) goto L44;
        Long r22 = Long.valueOf(r21.getId());
    L46:
        if (r18 != r22.longValue()) goto L32;
        r12.remove(r11);
    L44:
        r22 = null;
    L48:
        return r1;
    }
}
