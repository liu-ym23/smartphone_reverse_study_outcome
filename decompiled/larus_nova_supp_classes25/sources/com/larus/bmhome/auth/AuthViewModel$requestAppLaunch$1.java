package com.larus.bmhome.auth;

import com.google.gson.Gson;
import com.larus.bmhome.chat.api.a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.utils.t0;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.auth.AuthViewModel$requestAppLaunch$1", f = "AuthViewModel.kt", i = {}, l = {361}, m = "invokeSuspend", n = {}, s = {})
public final class AuthViewModel$requestAppLaunch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $launchInfoWithStatus;
    int label;
    final /* synthetic */ AuthViewModel this$0;

    public AuthViewModel$requestAppLaunch$1(AuthViewModel r1, a r2, Continuation<? super AuthViewModel$requestAppLaunch$1> r3) {
        this.this$0 = r1;
        this.$launchInfoWithStatus = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AuthViewModel$requestAppLaunch$1(this.this$0, this.$launchInfoWithStatus, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
        Object r1 = r18;
    L11:
        y r2 = (com.larus.network.http.a) r1;
        boolean r3 = r2 instanceof y;
        if (r3 == false) goto L24;
        if (r3 == false) goto L15;
        y r4 = r2;
    L16:
        if (r4 == null) goto L18;
        final a r5 = (a) ((com.larus.network.http.a) r4).b;
    L19:
        if (r5 != null) goto L22;
        this.this$0.p.setValue(a.a(this.$launchInfoWithStatus, null, 3, null, 5));
        return Unit.INSTANCE;
    L22:
        this.this$0.p.setValue(a.a(this.$launchInfoWithStatus, r5, 2, null, 4));
        Gson r6 = z0.a;
        z0.c = LazyKt.lazy(new t0());
        t0.a(new v0(r5));
    L28:
        return Unit.INSTANCE;
    L18:
        r5 = null;
        goto L19
    L15:
        r4 = null;
        goto L16
    L24:
        if ((r2 instanceof f) == false) goto L28;
        this.this$0.p.setValue(a.a(this.$launchInfoWithStatus, null, 3, ((f) r2).d, 1));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        this.this$0.p.setValue(a.a(this.$launchInfoWithStatus, null, 1, null, 5));
        JSONObject r7 = new JSONObject();
        this.label = 1;
        r1 = HttpExtKt.k("Basic", a.class, "/alice/app_launch/launch", r7, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L11;
        return r13;
    }
}
