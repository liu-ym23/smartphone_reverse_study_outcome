package com.bytedance.ai.widget.cache;

import com.bytedance.ai.model.objects.Widget;
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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/objects/Widget;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader$loadWidget$3", f = "WidgetResourceLoader.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetResourceLoader$loadWidget$3 extends SuspendLambda implements Function1<Continuation<? super Widget>, Object> {
    final /* synthetic */ String $versionTag;
    Object L$0;
    int label;
    final /* synthetic */ WidgetResourceLoader this$0;

    public WidgetResourceLoader$loadWidget$3(WidgetResourceLoader r1, String r10, Continuation<? super WidgetResourceLoader$loadWidget$3> r11) {
        this.this$0 = r1;
        this.$versionTag = r10;
        super(1, r11);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new WidgetResourceLoader$loadWidget$3(this.this$0, this.$versionTag, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Widget> r10) {
        return create(r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r11 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        WidgetResourceLoader r12 = (WidgetResourceLoader) this.L$0;
        ResultKt.throwOnFailure(r10);
    L12:
        r12.c = (Widget) r10;
        Widget r13 = this.this$0.c;
        if (r13 == null) goto L27;
        String r14 = this.$versionTag;
        ConcurrentHashMap<String, Widget> r15 = a.a;
        Intrinsics.checkNotNullParameter(r13, "widget");
        if (a.c == true) goto L22;
        ConcurrentHashMap<String, Widget> r16 = a.a;
        if (r16.size() < 3) goto L20;
        boolean r17 = true;
    L21:
        if (r17 == true) goto L22;
        r13.e();
        Widget r18 = r16.put(a.b(r13.b, r13.K, r14), r13);
        if (r18 == null) goto L26;
        r18.g();
    L26:
        Boxing.boxBoolean(r11);
    L29:
        return this.this$0.c;
    L20:
        r17 = false;
    L22:
        r11 = false;
        goto L26
    L27:
        WidgetResourceLoader r19 = this.this$0;
        com.bytedance.ai.applet.base.log.b r20 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("WidgetResourceLoader", "Loader(" + r19.b + ") loadWidget: ERROR, widget is NULL", null);
        goto L29
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        WidgetResourceLoader r21 = this.this$0;
        WidgetResourceLoader r22 = this.this$0;
        this.L$0 = r21;
        this.label = 1;
        Object r23 = WidgetResourceLoader.h(r22, this);
        if (r23 != r0) goto L11;
        return r0;
    L11:
        r12 = r21;
        r10 = r23;
        goto L12
    }
}
