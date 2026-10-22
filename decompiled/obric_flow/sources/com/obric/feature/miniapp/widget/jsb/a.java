package com.obric.feature.miniapp.widget.jsb;

import com.bytedance.ai.bridge.method.system.AbsOpenMapAppMethodIDL;
import com.bytedance.ai.bridge.method.system.OpenMapAppMethod;
import kotlin.jvm.functions.Function1;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f11429b;

    public /* synthetic */ a(f r5, int r10) {
        this.f11428a = r10;
        this.f11429b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        int r10 = this.f11428a;
        f r11 = this.f11429b;
        switch(r10) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            default: goto L5;
        };
    L5:
        return OpenMapAppMethod.b(r11, (AbsOpenMapAppMethodIDL.OpenMapAppResultModel) r5);
    L7:
        return WidgetUpdateMethod.b(r11, (String) r5);
    L9:
        return WidgetUpdateMethod.c(r11, (String) r5);
    L11:
        return WidgetSendPayloadMethod.c(r11, (String) r5);
    L13:
        return WidgetSendPayloadMethod.b(r11, (String) r5);
    L15:
        return WidgetRefreshAffectedMethod.c(r11, (String) r5);
    }
}
