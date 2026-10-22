package com.bytedance.geckox;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public pa.a f4760c;
    public final com.bytedance.iesgurd.h d;
    public final LinkedHashMap e;
    public final String f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f4761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f4762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IESGurdUpdatePriority f4763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1 f4764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f4765l;

    public n(String r5, String r10, List r11, boolean r12, IESGurdUpdatePriority r13, Function1 r14, boolean r15, int r16) {
        if ((r16 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r16 & 4) == 0) goto L9;
        r11 = null;
    L9:
        if ((r16 & 16) == 0) goto L12;
        r12 = false;
    L12:
        if ((r16 & 32) == 0) goto L15;
        r13 = IESGurdUpdatePriority.f6591b;
    L15:
        if ((r16 & 64) == 0) goto L18;
        r14 = null;
    L18:
        if ((r16 & 256) == 0) goto L20;
        r15 = true;
    L20:
        this.f = r5;
        this.g = r10;
        this.f4761h = r11;
        this.f4762i = r12;
        this.f4763j = r13;
        this.f4764k = r14;
        this.f4765l = r15;
        this.f4758a = true;
        this.f4759b = true;
        if (r14 == null) goto L31;
        this.d = new com.bytedance.iesgurd.h();
        this.e = new LinkedHashMap();
        if (r11 == null) goto L35;
        Iterator r17 = r11.iterator();
    L26:
        if (r17.hasNext() == false) goto L36;
        String r18 = (String) r17.next();
        LinkedHashMap r19 = this.e;
        if (r19 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
    L30:
        r19.put(r18, Boolean.FALSE);
        goto L26
    L36:
        return;
    L35:
        return;
    }

    public final void a(String r10, com.bytedance.iesgurd.g r11) {
        LinkedHashMap r5 = this.e;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
    L5:
        Boolean r12 = (Boolean) r5.get(r10);
        Boolean r13 = Boolean.TRUE;
        boolean r14 = Intrinsics.areEqual(r12, r13);
        com.bytedance.iesgurd.h r15 = this.d;
        if (r14 == false) goto L12;
        StringBuilder r16 = com.lynx.tasm.utils.e.b("onUpdateFinish repeat: ", r10, ", ");
        if (r15 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("result");
    L10:
        r16.append((com.bytedance.iesgurd.g) r15.f6630a.get(r10));
        GeckoLogger.b(r16.toString());
        return;
    L12:
        r5.put(r10, r13);
        if (r11.f6627a == true) goto L17;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("result");
    L16:
        r15.getClass();
    L17:
        if (r15 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("result");
    L19:
        r15.getClass();
        r15.f6630a.put(r10, r11);
        Iterator r17 = r5.entrySet().iterator();
    L21:
        if (r17.hasNext() == false) goto L25;
        if (((Boolean) ((Map.Entry) r17.next()).getValue()).booleanValue() == true) goto L21;
        return;
    L25:
        Function1 r18 = this.f4764k;
        if (r18 != null) goto L28;
        Intrinsics.throwNpe();
    L28:
        r18.invoke(r15);
    }

    public final void b(String r5, String r10) {
        if (this.f4764k != null) goto L5;
        return;
    L5:
        a(r5, new com.bytedance.iesgurd.g(r10, 0, false));
    }
}
