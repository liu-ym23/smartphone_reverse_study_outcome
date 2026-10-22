package com.larus.common.account.bdauth.impl;

import com.larus.common.account.bdauth.model.CustomBDAuthorizeModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import za7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/account/bdauth/api/DoubaoOpenAuthCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.impl.BdauthServiceImpl$requestOpenAuthCode$2", f = "BdauthServiceImpl.kt", i = {0, 0, 1, 1, 1}, l = {51, 59, 60}, m = "invokeSuspend", n = {"scopes", "extra", "scopes", "extra", "response"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
public final class BdauthServiceImpl$requestOpenAuthCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super t38.b>, Object> {
    final /* synthetic */ t38.a $request;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ BdauthServiceImpl this$0;

    public BdauthServiceImpl$requestOpenAuthCode$2(t38.a r1, BdauthServiceImpl r2, Continuation<? super BdauthServiceImpl$requestOpenAuthCode$2> r3) {
        this.$request = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BdauthServiceImpl$requestOpenAuthCode$2(this.$request, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super t38.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r110) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r110);
        Object r3 = r110;
    L51:
        za7.a r9 = (za7.a) r3;
    L53:
        if (r9 != null) goto L55;
    L57:
        boolean r4 = false;
    L58:
        if (r4 == false) goto L69;
        String r5 = r9.e;
        if (r5 != null) goto L62;
    L65:
        boolean r6 = true;
    L66:
        if (r6 == true) goto L69;
        return new t38.b(r9.e, 0, null, 6);
    L62:
        if (StringsKt.isBlank(r5) == true) goto L65;
        r6 = false;
    L69:
        if (r9 == null) goto L71;
        int r7 = ((d) r9).b;
    L72:
        if (r9 == null) goto L74;
        String r8 = ((d) r9).c;
    L76:
        return new t38.b(null, r7, r8, 1);
    L74:
        r8 = null;
        goto L76
    L71:
        r7 = -1;
        goto L72
    L55:
        if (((d) r9).a != true) goto L57;
        r4 = true;
        goto L58
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        za7.a r10 = (za7.a) this.L$2;
        Map r11 = (Map) this.L$1;
        String r12 = (String) this.L$0;
        ResultKt.throwOnFailure(r110);
        String r13 = r12;
        Map r14 = r11;
        Object r15 = r110;
    L47:
        if (((Boolean) r15).booleanValue() == false) goto L52;
        CustomBDAuthorizeModel r16 = (CustomBDAuthorizeModel) this.this$0.a.getValue();
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        r3 = r16.b(null, r13, r14, this);
        if (r3 != r1) goto L51;
        return r1;
    L52:
        r9 = r10;
        goto L53
    L11:
        Map r17 = (Map) this.L$1;
        String r18 = (String) this.L$0;
        ResultKt.throwOnFailure(r110);
        Object r20 = r110;
    L29:
        r9 = (za7.a) r20;
        if (r9 != null) goto L32;
    L34:
        boolean r111 = false;
    L35:
        if (r111 == true) goto L53;
        if (r9 != null) goto L38;
    L40:
        boolean r112 = false;
    L41:
        if (r112 == false) goto L53;
        CustomBDAuthorizeModel r113 = (CustomBDAuthorizeModel) this.this$0.a.getValue();
        this.L$0 = r18;
        this.L$1 = r17;
        this.L$2 = r9;
        this.label = 2;
        r15 = r113.registerNewUser(this);
        if (r15 != r1) goto L45;
        return r1;
    L45:
        String r114 = r18;
        r14 = r17;
        r10 = r9;
        r13 = r114;
        goto L47
    L38:
        if (((d) r9).b != 4099) goto L40;
        r112 = true;
        goto L41
    L32:
        if (((d) r9).a != true) goto L34;
        r111 = true;
        goto L35
    L12:
        ResultKt.throwOnFailure(r110);
        List r21 = this.$request.b;
        ArrayList r22 = new ArrayList();
        Iterator r23 = r21.iterator();
    L14:
        if (r23.hasNext() == false) goto L18;
        Object r24 = r23.next();
        if ((!StringsKt.isBlank((String) r24)) == false) goto L14;
        r22.add(r24);
        goto L14
    L18:
        String r25 = CollectionsKt.joinToString$default(r22, ",", null, null, 0, null, null, 62, null);
        if (StringsKt.isBlank(this.$request.a) == true) goto L78;
        if (StringsKt.isBlank(r25) == true) goto L78;
        if (StringsKt.isBlank(this.$request.d) == true) goto L78;
        Map r26 = MapsKt.mapOf(new Pair[]{TuplesKt.to("client_key", this.$request.a), TuplesKt.to("aid", String.valueOf(this.$request.c)), TuplesKt.to("response_type", "code"), TuplesKt.to("source", this.$request.d)});
        CustomBDAuthorizeModel r27 = (CustomBDAuthorizeModel) this.this$0.a.getValue();
        this.L$0 = r25;
        this.L$1 = r26;
        this.label = 1;
        r20 = r27.b(null, r25, r26, this);
        if (r20 != r1) goto L28;
        return r1;
    L28:
        r18 = r25;
        r17 = r26;
    L78:
        return new t38.b(null, 0, "Invalid open auth request", 3);
    }
}
