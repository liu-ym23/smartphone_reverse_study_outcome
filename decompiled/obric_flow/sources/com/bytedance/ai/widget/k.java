package com.bytedance.ai.widget;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f3073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3074c;

    public /* synthetic */ k(String r5, String r10) {
        this.f3072a = 2;
        this.f3074c = r5;
        this.f3073b = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        switch(this.f3072a) {
            case 0: goto L23;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        com.bytedance.ai.widget.contianer.f r10 = (com.bytedance.ai.widget.contianer.f) r5;
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        ArrayList r11 = (ArrayList) this.f3073b;
        if (r11 == null) goto L20;
        WidgetContainer r12 = (WidgetContainer) r10;
        com.bytedance.ai.widget.contianer.h r13 = r12.f;
        String r14 = null;
        if (r13 == null) goto L11;
        String r15 = r13.f3047a;
    L12:
        boolean r16 = r11.contains(r15);
        boolean r17 = true;
        if (r16 != true) goto L20;
        com.bytedance.ai.widget.contianer.h r18 = r12.f;
        if (r18 == null) goto L18;
        r14 = r18.f3048b;
    L18:
        if (Intrinsics.areEqual(r14, this.f3074c) == false) goto L20;
    L22:
        return Boolean.valueOf(r17);
    L11:
        r15 = null;
    L20:
        r17 = false;
        goto L22
    L23:
        com.bytedance.ai.widget.contianer.f r19 = (com.bytedance.ai.widget.contianer.f) r5;
        Intrinsics.checkNotNullParameter(r19, ST.IMPLICIT_ARG_NAME);
        ArrayList r20 = (ArrayList) this.f3073b;
        if (r20 == null) goto L37;
        WidgetContainer r21 = (WidgetContainer) r19;
        com.bytedance.ai.widget.contianer.h r22 = r21.f;
        String r23 = null;
        if (r22 == null) goto L28;
        String r24 = r22.f3047a;
    L29:
        boolean r25 = r20.contains(r24);
        boolean r26 = true;
        if (r25 != true) goto L37;
        com.bytedance.ai.widget.contianer.h r27 = r21.f;
        if (r27 == null) goto L35;
        r23 = r27.f3048b;
    L35:
        if (Intrinsics.areEqual(r23, this.f3074c) == false) goto L37;
    L39:
        return Boolean.valueOf(r26);
    L28:
        r24 = null;
    L37:
        r26 = false;
        goto L39
    L5:
        return Boolean.valueOf(GlobalWidgetCache$1$onCompleteUpdate$1.a(this.f3074c, (String) this.f3073b, (Map.Entry) r5));
    }

    public /* synthetic */ k(ArrayList r5, String r10, int r11) {
        this.f3072a = r11;
        this.f3073b = r5;
        this.f3074c = r10;
    }
}
