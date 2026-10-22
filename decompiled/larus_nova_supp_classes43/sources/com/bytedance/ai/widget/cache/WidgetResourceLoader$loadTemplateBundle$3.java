package com.bytedance.ai.widget.cache;

import com.bytedance.ai.model.objects.Widget;
import com.lynx.tasm.TemplateBundle;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/lynx/tasm/TemplateBundle;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader$loadTemplateBundle$3", f = "WidgetResourceLoader.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetResourceLoader$loadTemplateBundle$3 extends SuspendLambda implements Function1<Continuation<? super TemplateBundle>, Object> {
    final /* synthetic */ String $packageName;
    final /* synthetic */ String $versionTag;
    final /* synthetic */ String $widgetId;
    int label;
    final /* synthetic */ WidgetResourceLoader this$0;

    public WidgetResourceLoader$loadTemplateBundle$3(WidgetResourceLoader r1, String r10, String r11, String r12, Continuation<? super WidgetResourceLoader$loadTemplateBundle$3> r13) {
        this.this$0 = r1;
        this.$packageName = r10;
        this.$widgetId = r11;
        this.$versionTag = r12;
        super(1, r13);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new WidgetResourceLoader$loadTemplateBundle$3(this.this$0, this.$packageName, this.$widgetId, this.$versionTag, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super TemplateBundle> r10) {
        return create(r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r11 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        TemplateBundle r12 = (TemplateBundle) r10;
        if (r12 != null) goto L14;
    L30:
        com.bytedance.ai.applet.base.log.b r13 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "Loader(" + this.this$0.b + ") loadTemplateBundle: ERROR, widget is NULL", null);
    L32:
        return this.this$0.d;
    L14:
        if (r12.i() == false) goto L30;
        this.this$0.d = r12;
        ConcurrentHashMap<String, Widget> r14 = a.a;
        String r15 = this.$packageName;
        String r16 = this.$widgetId;
        String r17 = this.$versionTag;
        Intrinsics.checkNotNullParameter(r15, "packageName");
        Intrinsics.checkNotNullParameter(r16, "widgetId");
        Intrinsics.checkNotNullParameter(r12, "templateBundle");
        boolean r18 = false;
        if (a.c == false) goto L19;
    L29:
        Boxing.boxBoolean(r18);
        goto L32
    L19:
        if (a.a.size() < 3) goto L21;
        boolean r19 = true;
    L22:
        if (r19 == true) goto L29;
        if (a.b.put(a.b(r15, r16, r17), r12) == null) goto L28;
        r11 = false;
    L28:
        r18 = r11;
        goto L29
    L21:
        r19 = false;
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        WidgetResourceLoader r20 = this.this$0;
        this.label = 1;
        r10 = r20.l(this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
