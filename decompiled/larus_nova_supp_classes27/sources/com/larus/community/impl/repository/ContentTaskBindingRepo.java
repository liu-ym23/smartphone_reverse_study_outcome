package com.larus.community.impl.repository;

import com.larus.community.impl.api.ContentTaskBindingApi;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ContentTaskBindingRepo {
    public static final ContentTaskBindingRepo a = null;

    static {
        a = new ContentTaskBindingRepo();
    }

    public ContentTaskBindingRepo() {
    }

    public final Object a(String r5, String r6, String r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1) == false) goto L7;
        ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1 r0 = (ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L27:
        dm9.a.a r10 = (dm9.a) r9;
        if ((r10 instanceof dm9.a.b) == false) goto L31;
        FLogger.a.i("ContentTaskBindingRepo", "saveContentTaskBinding success");
    L34:
        return Unit.INSTANCE;
    L31:
        if ((r10 instanceof dm9.a.a) == false) goto L34;
        FLogger.a.e("ContentTaskBindingRepo", "saveContentTaskBinding failed: " + r10.c);
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (r5 != null) goto L17;
    L20:
        boolean r11 = true;
    L21:
        if (r11 == false) goto L34;
        if (o0.d(r6) == false) goto L34;
        ContentTaskBindingApi.Companion r12 = ContentTaskBindingApi.a;
        ContentTaskBindingRepo$checkAndSaveContentTaskBinding$result$1 r13 = new ContentTaskBindingRepo$checkAndSaveContentTaskBinding$result$1(r6, r7, null);
        r0.label = 1;
        r12.getClass();
        r9 = ContentTaskBindingApi.Companion.a(r13, r0);
        if (r9 != r2) goto L27;
        return r2;
    L17:
        if (r5.length() == 0) goto L20;
        r11 = false;
    L7:
        r0 = new ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1(this, r8);
        goto L8
    }
}
