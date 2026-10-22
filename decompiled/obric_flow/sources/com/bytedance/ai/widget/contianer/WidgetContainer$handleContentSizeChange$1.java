package com.bytedance.ai.widget.contianer;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.api.model.view.WidgetEvent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w0.m;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.WidgetContainer$handleContentSizeChange$1", f = "WidgetContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WidgetContainer$handleContentSizeChange$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ int f3035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WidgetContainer f3036b;

    public WidgetContainer$handleContentSizeChange$1(WidgetContainer r5, Continuation r10) {
        this.f3036b = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        WidgetContainer$handleContentSizeChange$1 r11 = new WidgetContainer$handleContentSizeChange$1(this.f3036b, r10);
        r11.f3035a = ((Number) r5).intValue();
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(Integer r5, Continuation<? super Unit> r10) {
        int r11 = r5.intValue();
        WidgetContainer r12 = this.f3036b;
        WidgetContainer$handleContentSizeChange$1 r13 = new WidgetContainer$handleContentSizeChange$1(r12, r10);
        r13.f3035a = r11;
        return r13.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r10);
        int r11 = this.f3035a;
        StringBuilder r5 = new StringBuilder("handleContentSizeChange: ");
        h r12 = this.f3036b.f;
        String r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.a();
    L6:
        r5.append(r14);
        r5.append(" widget change height to ");
        r5.append(r11);
        String r15 = r5.toString();
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L9;
        r16.d("WidgetContainer", r15);
    L9:
        WidgetContainer r17 = this.f3036b;
        WidgetContainer.LifecycleEvent r18 = r17.f3023j;
        WidgetContainer.LifecycleEvent r19 = WidgetContainer.LifecycleEvent.d;
        if (r18 == r19) goto L12;
        r17.i(r19);
    L16:
        WidgetContainer r20 = this.f3036b;
        r20.getClass();
        LinearLayout r21 = ((AppletWidgetContainer) r20).C;
        if (r21 == null) goto L19;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
    L20:
        if (r22 == null) goto L22;
        r22.height = r11;
    L22:
        if (r21 == null) goto L24;
        r21.setLayoutParams(r22);
    L24:
        if (r21 == null) goto L29;
        ViewParent r23 = r21.getParent();
        if (r23 == null) goto L29;
        r23.requestLayout();
    L29:
        if (r20.s == false) goto L42;
        if (r11 <= 0) goto L42;
        h r24 = r20.f;
        if (r24 == null) goto L34;
        String r25 = r24.a();
    L35:
        r20.f3021h.storeInt(r25, r11);
        StringBuilder r26 = new StringBuilder();
        h r27 = r20.f;
        if (r27 == null) goto L38;
        r13 = r27.a();
    L38:
        r26.append(r13);
        r26.append(" storeInt ");
        r26.append(r11);
        String r28 = r26.toString();
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r29 = com.bytedance.ai.utils.c.f2846a;
        if (r29 == null) goto L42;
        r29.d("WidgetContainer", r28);
        goto L42
    L34:
        r25 = null;
    L42:
        return Unit.INSTANCE;
    L19:
        r22 = null;
        goto L20
    L12:
        WidgetEvent r30 = WidgetEvent.f1707a;
        Intrinsics.checkNotNullParameter(r30, "event");
        Iterator r31 = r17.d.iterator();
    L14:
        if (r31.hasNext() == false) goto L16;
        ((m) r31.next()).onEvent(r30);
        goto L14
    L5:
        r14 = null;
        goto L6
    }
}
