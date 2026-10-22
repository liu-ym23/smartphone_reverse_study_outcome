package com.obric.assistant.upload.internal;

import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.upload.internal.ObricFileUploader$deleteRemoteResources$1", f = "ObricFileUploader.kt", i = {0, 0}, l = {206}, m = "invokeSuspend", n = {"deleteEntities", "resourceIds"}, s = {"L$0", "L$1"})
public final class ObricFileUploader$deleteRemoteResources$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $identifiers;
    Object L$0;
    Object L$1;
    int label;

    public ObricFileUploader$deleteRemoteResources$1(List<String> r1, Continuation<? super ObricFileUploader$deleteRemoteResources$1> r2) {
        this.$identifiers = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricFileUploader$deleteRemoteResources$1(this.$identifiers, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        List r2 = (List) this.L$1;
        List r3 = (List) this.L$0;
        ResultKt.throwOnFailure(r8);
        List r4 = r3;
    L33:
        int r5 = m.a;
        StringBuilder r6 = new StringBuilder("deleteRemoteResources called, identifiers = ");
        r6.append(this.$identifiers);
        r6.append(", result = ");
        r6.append((String) r8);
        r6.append(", resourceIds = ");
        r6.append(r2);
        r6.append(", tosKeys = ");
        ArrayList r9 = new ArrayList();
        Iterator r7 = r4.iterator();
    L35:
        if (r7.hasNext() == false) goto L39;
        String r10 = l1.h((UplinkFileEntity) r7.next());
        if (r10 == null) goto L35;
        r9.add(r10);
        goto L35
    L39:
        r6.append(r9);
        m.c("ObricFileUploader", r6.toString());
        Iterator<T> r11 = this.$identifiers.iterator();
    L41:
        if (r11.hasNext() == false) goto L44;
        String r12 = (String) r11.next();
        ResourceCenter.a.getClass();
        ResourceCenter.a(r12);
        goto L41
    L44:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        ObricUploadEntityCache$entityMap$1 r13 = ObricUploadEntityCache.a;
        List<String> r14 = this.$identifiers;
        Intrinsics.checkNotNullParameter(r14, "identifiers");
        ArrayList r15 = new ArrayList();
        Object r16 = ObricUploadEntityCache.c;
        monitor-enter(r16);
        Iterator<T> r17 = r14.iterator();     // Catch: Throwable -> L45
    L12:
        if (r17.hasNext() == false) goto L21;
        String r18 = (String) r17.next();     // Catch: Throwable -> L45
        UplinkFileEntity r19 = (UplinkFileEntity) ObricUploadEntityCache.a.get(r18);     // Catch: Throwable -> L45
        if (r19 == null) goto L12;
        ResourceCenter r20 = ResourceCenter.a;     // Catch: Throwable -> L45
        String r21 = r19.getFileIdentifier();     // Catch: Throwable -> L45
        if (r21 != null) goto L18;
        r21 = "";
    L18:
        r20.getClass();     // Catch: Throwable -> L45
        if (ResourceCenter.d(r21) == false) goto L12;
        r15.add(r19);     // Catch: Throwable -> L45
        goto L12
    L21:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r16);
        ObricUploadEntityCache$entityMap$1 r23 = ObricUploadEntityCache.a;
        r15.removeAll(ObricUploadEntityCache.a(this.$identifiers));
        ArrayList r24 = new ArrayList();
        Iterator r25 = r15.iterator();
    L25:
        if (r25.hasNext() == false) goto L29;
        String r26 = l1.g((UplinkFileEntity) r25.next());
        if (r26 == null) goto L25;
        r24.add(r26);
        goto L25
    L29:
        ResourceCenter r27 = ResourceCenter.a;
        this.L$0 = r15;
        this.L$1 = r24;
        this.label = 1;
        Object r28 = r27.b(r24, this);
        if (r28 != r0) goto L32;
        return r0;
    L32:
        r2 = r24;
        r8 = r28;
        r4 = r15;
    L45:
        th = move-exception;
        throw th;
    }
}
