package com.larus.uaigc.chat.markdown.video;

import android.text.Spanned;
import android.widget.TextView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.MDMultiVideoWidget$addMessageChangeObserver$1", f = "MDMultiVideoWidget.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
final class MDMultiVideoWidget$addMessageChangeObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MDMultiVideoWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MDMultiVideoWidget a;

        public a(MDMultiVideoWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            Message r11 = (Message) r9;
            if (r11 == null) goto L5;
            String r1 = r11.getMessageId();
        L6:
            Message r2 = this.a.f;
            if (r2 == null) goto L9;
            String r3 = r2.getMessageId();
        L11:
            if (Intrinsics.areEqual(r1, r3) == false) goto L72;
            MDMultiVideoWidget r4 = this.a;
            r4.f = r11;
            if (r11 == null) goto L15;
            CreationMsgContentData r12 = dp8.e.c(r11);
        L16:
            r4.h = r12;
            MDMultiVideoWidget r13 = this.a;
            CreationMsgContentData r5 = r13.h;
            if (r5 == null) goto L27;
            CreationInfo r6 = r5.creationInfo;
            if (r6 == null) goto L27;
            Map r7 = r6.taskInfo;
            if (r7 == null) goto L27;
            Collection r8 = r7.values();
            if (r8 == null) goto L27;
            List r14 = CollectionsKt.toList(r8);
            if (r14 == null) goto L27;
            List r15 = CollectionsKt.filterNotNull(r14);
        L28:
            if (r15 != null) goto L30;
            r15 = CollectionsKt.emptyList();
        L30:
            boolean r16 = true;
            if (r13.v.keySet().size() != r15.size()) goto L54;
            List r17 = r15;
            if ((r17 instanceof Collection) == true) goto L36;
        L38:
            Iterator<T> r18 = r17.iterator();
        L40:
            if (r18.hasNext() == false) goto L53;
            CreationTask r19 = (CreationTask) r18.next();
            HashMap<String, MDSingleVideoWidget> r20 = r13.v;
            String r21 = r19.id;
            if (r21 != null) goto L44;
            r21 = "";
        L44:
            MDSingleVideoWidget r22 = r20.get(r21);
            if (r22 == null) goto L49;
            CreationTask r23 = r22.m;
            if (r23 == null) goto L49;
            Integer r24 = r23.status;
        L51:
            if ((!Intrinsics.areEqual(r24, r19.status)) == false) goto L40;
        L49:
            r24 = null;
        L53:
            r16 = false;
            goto L54
        L36:
            if (r17.isEmpty() == false) goto L38;
        L54:
            if (r16 == false) goto L72;
            Integer r25 = this.a.s;
            if (r25 == null) goto L80;
            int r26 = r25.intValue();
            MDMultiVideoWidget r27 = this.a;
            TextView r28 = r27.p;
            if (r28 == null) goto L76;
            Spanned r29 = r27.q;
            if (r29 == null) goto L77;
            usc.e r30 = r27.r;
            if (r30 == null) goto L78;
            Object r31 = BuildersKt.withContext(Dispatchers.getMain(), new MDMultiVideoWidget$addMessageChangeObserver$1$1$1(this.a, r28, r29, r30, r26, null), r10);
            if (r31 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L79;
            return r31;
        L79:
            return Unit.INSTANCE;
        L78:
            return Unit.INSTANCE;
        L77:
            return Unit.INSTANCE;
        L76:
            return Unit.INSTANCE;
        L80:
            return Unit.INSTANCE;
        L27:
            r15 = null;
            goto L28
        L15:
            r12 = null;
        L72:
            return Unit.INSTANCE;
        L9:
            r3 = null;
            goto L11
        L5:
            r1 = null;
            goto L6
        }
    }

    public MDMultiVideoWidget$addMessageChangeObserver$1(MDMultiVideoWidget r1, Continuation<? super MDMultiVideoWidget$addMessageChangeObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MDMultiVideoWidget$addMessageChangeObserver$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L18:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        q0.a r6 = this.this$0.m;
        if (r6 == null) goto L20;
        zd8.b r7 = r6.P9();
        if (r7 == null) goto L20;
        d1 r8 = r7.R2();
        if (r8 == null) goto L20;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L18;
        return r0;
    L20:
        return Unit.INSTANCE;
    }
}
