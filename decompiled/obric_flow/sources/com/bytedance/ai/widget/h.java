package com.bytedance.ai.widget;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f3067b;

    public /* synthetic */ h(o r5, int r10) {
        this.f3066a = r10;
        this.f3067b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        switch(this.f3066a) {
            case 0: goto L26;
            case 1: goto L17;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        WeakReference r10 = (WeakReference) r5;
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        return Boolean.valueOf(Intrinsics.areEqual(r10.get(), this.f3067b));
    L6:
        WeakReference r11 = (WeakReference) r5;
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        return Boolean.valueOf(Intrinsics.areEqual(r11.get(), this.f3067b));
    L8:
        com.bytedance.ai.widget.contianer.f r12 = (com.bytedance.ai.widget.contianer.f) r5;
        Intrinsics.checkNotNullParameter(r12, ST.IMPLICIT_ARG_NAME);
        o r13 = this.f3067b;
        StringBuilder r14 = new StringBuilder("buildLoginWidget setAdditionalContext different sectionId: current=null widget=");
        m r15 = (m) r13.e.get(r12);
        if (r15 == null) goto L11;
        String r16 = r15.f3076b;
    L12:
        String r17 = androidx.room.jarjarred.org.antlr.runtime.a.v(r14, r16, "WidgetManager", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L16;
        r18.w("WidgetManager", r17);
    L16:
        return Unit.INSTANCE;
    L11:
        r16 = null;
        goto L12
    L17:
        com.bytedance.ai.widget.contianer.f r19 = (com.bytedance.ai.widget.contianer.f) r5;
        Intrinsics.checkNotNullParameter(r19, ST.IMPLICIT_ARG_NAME);
        o r20 = this.f3067b;
        StringBuilder r21 = new StringBuilder("setAdditionalContext different sectionId current=null widget=");
        m r22 = (m) r20.e.get(r19);
        if (r22 == null) goto L20;
        String r23 = r22.f3076b;
    L21:
        String r24 = androidx.room.jarjarred.org.antlr.runtime.a.v(r21, r23, "WidgetManager", "tag");
        t0.d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L25;
        r25.w("WidgetManager", r24);
    L25:
        return Unit.INSTANCE;
    L20:
        r23 = null;
        goto L21
    L26:
        Map r26 = TypeIntrinsics.asMutableMap(this.f3067b.e);
        r26.remove((com.bytedance.ai.widget.contianer.f) r5);
        return Unit.INSTANCE;
    }
}
