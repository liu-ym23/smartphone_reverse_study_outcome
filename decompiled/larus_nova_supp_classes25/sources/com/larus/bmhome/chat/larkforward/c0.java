package com.larus.bmhome.chat.larkforward;

import android.app.Activity;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tx9.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ v0.a a;
    public final /* synthetic */ v0.b b;
    public final /* synthetic */ List<String> c;
    public final /* synthetic */ String d;
    public final /* synthetic */ o e;
    public final /* synthetic */ Activity f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ List<Long> h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ FlowLarkToDoubaoServiceImpl k;
    public final /* synthetic */ wc9.e l;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        FLogger.a.w("FlowLarkToDoubaoService", "forward to doubao failed, code=" + r6.getCode() + ", tips=" + r6.getTips());
        ConcurrentHashMap r0 = v0.a;
        v0.a r1 = this.a;
        String r2 = r6.getTips();
        if (r2 != null) goto L5;
        r2 = String.valueOf(r6.getCode());
    L5:
        v0.f(r1, false, null, r2);
        v0.b r3 = this.b;
        List<String> r4 = this.c;
        String r5 = String.valueOf(r6.getCode());
        String r7 = r6.getTips();
        if (r7 != null) goto L8;
        r7 = this.d;
    L8:
        v0.i(r3, false, r4, r5, r7);
        o r8 = this.e;
        int r9 = r6.getCode();
        String r10 = r6.getTips();
        if (r10 != null) goto L11;
        r10 = this.d;
    L11:
        r8.onFailure(r9, r10);
    }

    public final void onSuccess(Object r11) {
        List r12 = (List) r11;
        Intrinsics.checkNotNullParameter(r12, "result");
        final Message r3 = (Message) CollectionsKt.firstOrNull(r12);
        if (r3 != null) goto L5;
        ConcurrentHashMap r0 = v0.a;
        v0.f(this.a, false, null, "-5");
        v0.i(this.b, false, this.c, "-5", this.d);
        this.e.onFailure(-5, this.d);
        return;
    L5:
        ConcurrentHashMap r1 = v0.a;
        v0.f(this.a, true, r3.getMessageId(), null);
        v0.j(this.b, true, this.c, null, null, 24);
        Activity r13 = this.f;
        final o r2 = this.e;
        final boolean r4 = this.g;
        final List<Long> r5 = this.h;
        final String r6 = this.i;
        final String r7 = this.j;
        final FlowLarkToDoubaoServiceImpl r8 = this.k;
        final wc9.e r9 = this.l;
        r13.runOnUiThread(new b0(r2, r4, r3, r5, r6, r7, r8, r9));
    }

    public c0(v0.a r1, v0.b r2, List<String> r3, String r4, o r5, Activity r6, boolean r7, List<Long> r8, String r9, String r10, FlowLarkToDoubaoServiceImpl r11, wc9.e r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }
}
