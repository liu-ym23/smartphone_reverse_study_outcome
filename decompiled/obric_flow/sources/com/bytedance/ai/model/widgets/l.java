package com.bytedance.ai.model.widgets;

import android.util.LruCache;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.resource.e0;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.obric.feature.miniapp.widget.jsb.WidgetRefreshAffectedMethod;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2354b;

    public /* synthetic */ l(Object r5, int r10) {
        this.f2353a = r10;
        this.f2354b = r5;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(Object r5, Object r10) {
        Job r11 = null;
        Object r12 = this.f2354b;
        switch(this.f2353a) {
            case 0: goto L26;
            case 1: goto L25;
            default: goto L4;
        };
    L4:
        int r13 = ((Integer) r5).intValue();
        CoroutineContext.Element r14 = (CoroutineContext.Element) r10;
        CoroutineContext.Key<?> r15 = r14.getKey();
        CoroutineContext.Element r16 = ((SafeCollector) r12).collectContext.get(r15);
        if (r15 == Job.Key) goto L9;
        if (r14 == r16) goto L8;
        r13 = Integer.MIN_VALUE;
    L20:
        return Integer.valueOf(r13);
    L8:
        r13 = r13 + 1;
        goto L20
    L9:
        Job r17 = (Job) r16;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        Job r18 = (Job) r14;
    L10:
        if (r18 == null) goto L17;
        if (r18 == r17) goto L13;
        if ((r18 instanceof kotlinx.coroutines.internal.r) == false) goto L13;
        r18 = ((kotlinx.coroutines.internal.r) r18).getParent();
    L13:
        r11 = r18;
    L17:
        if (r11 != r17) goto L22;
        if (r17 != null) goto L8;
    L22:
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + r11 + ", expected child of " + r17 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    L26:
        String r19 = (String) r5;
        boolean r20 = ((Boolean) r10).booleanValue();
        Intrinsics.checkNotNullParameter(r19, "url");
        if (r20 == false) goto L31;
        Applet r21 = ((RelaxViewFloatingPageV2) r12).f2329a.f2197h;
        if (r21 == null) goto L31;
        LruCache r22 = e0.f2711a;
        String r23 = f4.b.b(new StringBuilder(), r21.F, "/pages/public/", r19);
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Intrinsics.checkNotNullParameter(r23, "filePath");
        r19 = e0.c(r21, r23);
    L31:
        LruCache r24 = e0.f2711a;
        u0.a r25 = s0.a.f21800c;
        if (r25 == null) goto L35;
        String r26 = r25.f22202m;
        if (r26 == null) goto L35;
    L36:
        Intrinsics.checkNotNullParameter(r26, "bid");
        if (r19 != null) goto L39;
    L41:
        String r27 = IIvyAIPackageResourceService.Companion.getImageUrl(null, r19, r26);
    L42:
        if (r27 != null) goto L45;
        return r19;
    L45:
        return r27;
    L39:
        if (StringsKt.P(r19, "content://") != true) goto L41;
        r27 = r19;
    L35:
        r26 = "";
        goto L36
    L25:
        return WidgetRefreshAffectedMethod.b((o1.f) r12, ((Integer) r5).intValue(), (List) r10);
    }
}
