package com.larus.bmhome.view.textview.impl.phone;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.list.trace.HighlightWordShowScene;
import com.larus.utils.logger.FLogger;
import fh8.o;
import io.noties.markwon.core.spans.LinkSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.textview.impl.phone.PhoneAppLogHelper$reportPhoneAppLog$1", f = "PhoneAppLogHelper.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class PhoneAppLogHelper$reportPhoneAppLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q0 $adapter;
    final /* synthetic */ String $botId;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isRetry;
    final /* synthetic */ SpannableStringBuilder $markdownCopy;
    final /* synthetic */ String $messageId;
    int label;

    public PhoneAppLogHelper$reportPhoneAppLog$1(boolean r1, SpannableStringBuilder r2, Context r3, String r4, String r5, q0 r6, Continuation<? super PhoneAppLogHelper$reportPhoneAppLog$1> r7) {
        this.$isRetry = r1;
        this.$markdownCopy = r2;
        this.$context = r3;
        this.$messageId = r4;
        this.$botId = r5;
        this.$adapter = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new PhoneAppLogHelper$reportPhoneAppLog$1(this.$isRetry, this.$markdownCopy, this.$context, this.$messageId, this.$botId, this.$adapter, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L43:
        List r12 = o.c(this.$markdownCopy, LinkSpan.class);     // Catch: ArrayStoreException -> L37
        final ArrayList r2 = new ArrayList();
        Iterator r13 = r12.iterator();
        int r3 = 0;
    L15:
        Pair r5 = null;
        if (r13.hasNext() == false) goto L32;
        Object r4 = r13.next();
        int r6 = r3 + 1;
        if (r3 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        LinkSpan r7 = (LinkSpan) r4;
        String r8 = r7.getURL();
        if (r8 != null) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L28;
        r5 = TuplesKt.to(Boxing.boxInt(r3), r7);
    L28:
        if (r5 == null) goto L30;
        r2.add(r5);
    L30:
        r3 = r6;
        goto L15
    L23:
        if (StringsKt.startsWith$default(r8, "sslocal://flow/phone_number", false, 2, null) != true) goto L25;
        r9 = true;
        goto L26
    L32:
        if (r2.isEmpty() == true) goto L34;
        Set r14 = com.larus.bmhome.chat.list.trace.a.a;
        HighlightWordShowScene r15 = HighlightWordShowScene.LINK_PHONE_NUMBER;
        q0 r10 = this.$adapter;
        final String r16 = this.$messageId;
        final String r17 = this.$botId;
        com.larus.bmhome.chat.list.trace.a.e(r15, r10, r16, null, new a(r2, r17, r16));
        return Unit.INSTANCE;
    L34:
        return Unit.INSTANCE;
    L37:
        e = move-exception;
        FLogger.a.e("PhoneAppLogHelper", "getSpans error, isRetry: " + this.$isRetry, e);
        if (this.$isRetry == true) goto L42;
        int r18 = PhoneAppLogHelper.a;
        PhoneAppLogHelper.a(this.$context, this.$messageId, this.$botId, this.$markdownCopy, this.$adapter, true);
    L42:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        if (this.$isRetry == false) goto L43;
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L43;
        return r0;
    }
}
