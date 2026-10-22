package com.bytedance.forest.postprocessor;

import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import java.util.LinkedList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f4553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Request f4554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.forest.utils.e f4555c;

    public h(Request r5, com.bytedance.forest.utils.e r10) {
        this.f4554b = r5;
        this.f4555c = r10;
        LinkedList r11 = new LinkedList();
        if (r5.getLoadToMemory() == false) goto L13;
        if (r5.isASync() == true) goto L7;
    L10:
        boolean r12 = true;
    L11:
        r11.add(new LoadToMemoryProcessor(r12));
        goto L13
    L7:
        if (r5.getAllowIOOnMainThread() == true) goto L10;
        r12 = false;
    L13:
        if ((r5 instanceof PostProcessRequest) == true) goto L15;
        Request r13 = null;
    L16:
        PostProcessRequest r14 = (PostProcessRequest) r13;
        if (r14 == null) goto L20;
        r11.add(r14.getPostProcessor$forest_release());
    L20:
        if (r5.getEnableMemoryCache() == false) goto L22;
        r11.add(new UpdateToMemoryCacheProcessor());
    L22:
        this.f4553a = r11;
        return;
    L15:
        r13 = r5;
        goto L16
    }

    public final void a(final w r10, final Function1 r11) {
        w r5 = null;
        if (r10.f4442r == false) goto L5;
        ForestPostProcessor r12 = (ForestPostProcessor) this.f4553a.poll();
        if (r12 != null) goto L18;
        ((ResourceProcessChain$process$1) r11).invoke(r10);
        return;
    L18:
        r12.setContext$forest_release(this.f4555c);
        if ((r12 instanceof a) == true) goto L31;
        r12.process$forest_release(r10, new ResourceProcessChain$performProcessor$3(this, r10, r11));     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        g r13 = (g) r10;
        r13.D = false;
        r13.C = null;
        com.bytedance.forest.model.c r14 = r13.s;
        ErrorInfo$Type r15 = ErrorInfo$Type.f;
        String r16 = "error occurs in executing " + this.f4553a + ", cause by " + th.getMessage();
        r14.getClass();
        r14.f4360a += r14.a(r15, 1, r16);
        a(r13, r11);
        return;
    L31:
        ((a) r12).process$forest_release(r10, new ResourceProcessChain$performProcessor$2(this, r11));     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        com.bytedance.forest.model.c r17 = r10.s;
        ErrorInfo$Type r18 = ErrorInfo$Type.f4309a;
        String r19 = "error occurs in " + r12.getClass() + " cause by " + th.getMessage();
        r17.getClass();
        r17.f4360a += r17.a(r18, 3, r19);
        r10.f4442r = false;
        a(r10, r11);
        return;
    L5:
        if ((r10 instanceof g) == false) goto L7;
    L8:
        r5 = r10;
    L9:
        if (r5 != null) goto L12;
        r5 = new g(r10, (PostProcessRequest) this.f4554b);
    L12:
        ((ResourceProcessChain$process$1) r11).invoke(r5);
        return;
    L7:
        if ((this.f4554b instanceof PostProcessRequest) == true) goto L9;
        goto L8
    }

    public final void b(w r5, Function1 r10) {
        com.bytedance.forest.utils.e r11 = this.f4555c;
        r11.b(new String[]{"post_processor_execute_start"});
        a(r5, new ResourceProcessChain$process$1(this, r10));
    }
}
