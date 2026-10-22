package com.bytedance.ai.widget;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3071b;

    public /* synthetic */ j(Object r5, int r10) {
        this.f3070a = r10;
        this.f3071b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        Context r5 = null;
        Object r11 = this.f3071b;
        switch(this.f3070a) {
            case 0: goto L16;
            default: goto L4;
        };
    L4:
        Map.Entry r12 = (Map.Entry) r10;
        Intrinsics.checkNotNullParameter(r12, ST.IMPLICIT_ARG_NAME);
        Lazy r13 = c.f2935a;
        StringBuilder r14 = new StringBuilder("onActivityPostDestroyed ");
        Activity r15 = (Activity) r11;
        r14.append(r15);
        r14.append(' ');
        r14.append(r12.getValue());
        r14.append(" isSame=");
        WidgetContainer r16 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.f) r12.getValue());
        r16.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        LinearLayout r17 = ((AppletWidgetContainer) r16).C;
        if (r17 == null) goto L7;
        Context r18 = r17.getContext();
    L8:
        r14.append(Intrinsics.areEqual(r15, r18));
        String r19 = r14.toString();
        Intrinsics.checkNotNullParameter("WidgetGlobalCache", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L11;
        r20.d("WidgetGlobalCache", r19);
    L11:
        WidgetContainer r21 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.f) r12.getValue());
        r21.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        LinearLayout r22 = ((AppletWidgetContainer) r21).C;
        if (r22 == null) goto L15;
        r5 = r22.getContext();
    L15:
        return Boolean.valueOf(Intrinsics.areEqual(r15, r5));
    L7:
        r18 = null;
        goto L8
    L16:
        Throwable r110 = (Throwable) r10;
        if ((r110 instanceof CancellationException) == false) goto L23;
        String r23 = "createWidgetContainer: Coroutine was cancelled with message: " + ((CancellationException) r110).getMessage();
        Intrinsics.checkNotNullParameter("WidgetManager", "tag");
        t0.d r24 = com.bytedance.ai.utils.c.f2846a;
        if (r24 == null) goto L21;
        r24.e("WidgetManager", r23);
    L21:
        BuildersKt.launch$default(h0.a(t2.b.d), null, null, new WidgetManager$createWidgetContainer$2$1((AppletWidgetContainer) r11, null), 3, null);
    L23:
        return Unit.INSTANCE;
    }
}
