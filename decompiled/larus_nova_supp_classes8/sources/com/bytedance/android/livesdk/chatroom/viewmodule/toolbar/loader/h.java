package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.content.Context;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.v3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.room.placeholder.behavior.p;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ TempAreaDynamicLoader a;

    public h(TempAreaDynamicLoader r1) {
        this.a = r1;
    }

    public final Object apply(Object r21) {
        Response r1 = (Response) r21;
        ArrayList r2 = new ArrayList();
        if (r1 == null) goto L7;
        v3 r4 = (v3) ((BaseResponse) r1).data;
        if (r4 == null) goto L7;
        List r5 = r4.a();
    L8:
        if (r5 == null) goto L29;
        v3 r6 = (v3) ((BaseResponse) r1).data;
        if (r6 == null) goto L29;
        List r7 = r6.a();
        if (r7 == null) goto L29;
        v3 r3 = (v3) ((BaseResponse) r1).data;
        if (r3 == null) goto L18;
        int r8 = (int) r3.b();
    L19:
        int r9 = Math.min(r7.size(), r8);
        int r10 = 0;
    L20:
        if (r10 >= r9) goto L29;
        v3.a r11 = (v3.a) ListProtector.get(r7, r10);
        if (r11 == null) goto L24;
        v3.b r12 = r11.d();
    L25:
        if (r12 == null) goto L28;
        TempAreaDynamicLoader r13 = this.a;
        String r14 = r11.d().b();
        String r15 = r11.d().c();
        String r16 = r11.d().a();
        String r17 = String.valueOf(r11.c());
        long r18 = r11.b();
        long r19 = r11.a();
        int r20 = TempAreaDynamicLoader.t;
        r13.getClass();
        ExtendedToolbarButton.c r22 = TempAreaDynamicLoader.j(r14, r15, r16, r17, r18, r19, false);
        r2.add(r22);
        DataCenter r23 = this.a.a;
        long r110 = r11.b();
        Context r111 = this.a.getContext();
        boolean r112 = this.a.d;
        long r113 = r11.c();
        long r114 = r11.a();
        String r115 = r11.d().c();
        r11.d().getClass();
        this.a.i().a(r22, new p(r23, r110, r111, r112, r113, r114, r115));
    L28:
        r10 = r10 + 1;
        goto L20
    L24:
        r12 = null;
        goto L25
    L18:
        r8 = 8;
    L29:
        return r2;
    L7:
        r5 = null;
        goto L8
    }
}
