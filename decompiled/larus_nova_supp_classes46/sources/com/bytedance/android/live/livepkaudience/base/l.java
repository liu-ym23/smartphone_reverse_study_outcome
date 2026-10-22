package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ o a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public l(p r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r11) {
        ApiServerException r12 = (Throwable) r11;
        this.a.h = false;
        long r0 = this.b;
        long r7 = System.currentTimeMillis() - r0;
        String r1 = this.c;
        dl0.m r2 = dl0.m.a;
        Intrinsics.checkNotNullParameter(r1, "reqFrom");
        JSONObject r9 = new JSONObject();
        BaseMonitor.add(r9, "request_source", r1);
        if (r12 != null) goto L5;
    L11:
        Iterator<g> r3 = this.a.e.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        r3.next().l0(r12);
        goto L13
    L15:
        this.a.i.put("cmd_finish_video_talk_room_result", Boolean.FALSE);
        return;
    L5:
        if ((r12 instanceof ApiServerException) == false) goto L10;
        dl0.m r4 = dl0.m.a;
        ApiServerException r5 = r12;
        int r6 = r5.getErrorCode();
        String r8 = r5.getErrorMsg();
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        r4.getClass();
        dl0.m.z("audience_finish", r6, r8, r7, r9);
        goto L11
    L10:
        dl0.m r10 = dl0.m.a;
        String r13 = r12.toString();
        r10.getClass();
        dl0.m.z("audience_finish", 1, r13, r7, r9);
        goto L11
    }
}
