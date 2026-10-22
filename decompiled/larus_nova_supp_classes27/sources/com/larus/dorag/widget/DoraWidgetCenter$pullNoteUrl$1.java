package com.larus.dorag.widget;

import android.content.SharedPreferences;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.dorag.widget.api.DoraWidgetGetNoteUrlApi;
import com.larus.dorag.widget.api.NoteUrl;
import com.larus.network.FlowHttpConnection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dorag.widget.DoraWidgetCenter$pullNoteUrl$1", f = "DoraWidgetCenter.kt", i = {}, l = {284}, m = "invokeSuspend", n = {}, s = {})
final class DoraWidgetCenter$pullNoteUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraWidgetCenter$pullNoteUrl$1(Continuation<? super DoraWidgetCenter$pullNoteUrl$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraWidgetCenter$pullNoteUrl$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r10 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
        Object r1 = r13;
    L15:
        dm9.a.b r2 = (dm9.a) r1;
        if ((r2 instanceof dm9.a.b) == false) goto L26;
        StringBuilder r3 = new StringBuilder("getNoteUrl success, noteUrl: ");
        dm9.a.b r4 = r2;
        NoteUrl r5 = (NoteUrl) r4.a.getData();
        if (r5 == null) goto L20;
        r10 = r5.getNoteUrl();
    L20:
        r3.append(r10);
        n1.d("DoraWidgetCenter", r3.toString());
        NoteUrl r6 = (NoteUrl) r4.a.getData();
        if (r6 == null) goto L29;
        String r7 = r6.getNoteUrl();
        if (r7 == null) goto L29;
        int r8 = f79.a.a;
        Intrinsics.checkNotNullParameter(r7, "url");
        SharedPreferences.Editor r11 = AppHost.a.getApplication().getSharedPreferences(f79.a.c(), 0).edit();
        r11.putString("noteUrl", r7);
        r11.apply();
    L29:
        return Unit.INSTANCE;
    L26:
        if ((r2 instanceof dm9.a.a) == false) goto L31;
        n1.b("DoraWidgetCenter", "getNoteUrl failed: " + ((dm9.a.a) r2).b);
        goto L29
    L31:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        int r12 = f79.a.a;
        AppHost.Companion r14 = AppHost.a;
        String r15 = "";
        String r16 = r14.getApplication().getSharedPreferences(f79.a.c(), 0).getString("serialNumber", "");
        if (r16 == null) goto L12;
        r15 = r16;
    L12:
        int r17 = r14.getApplication().getSharedPreferences(f79.a.c(), 0).getInt("productId", 16);
        DoraWidgetGetNoteUrlApi.a r18 = DoraWidgetGetNoteUrlApi.a;
        DoraWidgetCenter$pullNoteUrl$1$result$1 r20 = new DoraWidgetCenter$pullNoteUrl$1$result$1(r17, r15, null);
        this.label = 1;
        r18.getClass();
        FlowHttpConnection r21 = FlowHttpConnection.a;
        r1 = FlowHttpConnection.g("DORA", DoraWidgetGetNoteUrlApi.class, r20, false, null, null, null, this, 248);
        if (r1 != r9) goto L15;
        return r9;
    }
}
