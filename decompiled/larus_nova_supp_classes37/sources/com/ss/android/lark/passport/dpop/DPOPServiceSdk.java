package com.ss.android.lark.passport.dpop;

import android.os.Build;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/passport/dpop/DPOPServiceSdk;", "", "<init>", "()V", "TAG", "", "baStub", "", "serv", "Lcom/ss/android/lark/passport/dpop/IDPoPService;", "getServ", "()Lcom/ss/android/lark/passport/dpop/IDPoPService;", "serv$delegate", "Lcom/ss/android/lark/passport/dpop/DPOPServiceSdk$UntilSuccess;", "getDPOPToken", "uri", "method", "UntilSuccess", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DPOPServiceSdk {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    public static final DPOPServiceSdk INSTANCE = null;
    public static final String TAG = "DPOPServiceSdk";
    private static final byte[] baStub = null;
    private static final a serv$delegate = null;

    public static final class a<T> {
        public final Function0<T> a;
        public volatile T b;
        public final Object c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends T> r2) {
            Intrinsics.checkNotNullParameter(r2, "getter");
            this.a = r2;
            this.c = new Object();
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(DPOPServiceSdk.class, "serv", "getServ()Lcom/ss/android/lark/passport/dpop/IDPoPService;", 0))};
        INSTANCE = new DPOPServiceSdk();
        baStub = new byte[0];
        serv$delegate = new a(DPOPServiceSdk$serv$2.INSTANCE);
    }

    private DPOPServiceSdk() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.ss.android.lark.passport.dpop.a getServ() {
        a r0 = serv$delegate;
        KProperty<Object> r1 = $$delegatedProperties[0];
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "property");
        if (r0.b != 0) goto L29;
        Object r2 = r0.c;
        monitor-enter(r2);
    L26:
        th = move-exception;
        throw th;
    L7:
        if (r0.b != 0) goto L23;
        Function0<T> r3 = r0.a;     // Catch: Throwable -> L26
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(r3.invoke());     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == false) goto L16;
        T r6 = 0;
    L17:
        r0.b = r6;     // Catch: Throwable -> L26
        Throwable r7 = Result.exceptionOrNull-impl(r5);     // Catch: Throwable -> L26
        if (r7 == null) goto L21;
        Log.w(TAG, "err:" + ExceptionsKt.stackTraceToString(r7));     // Catch: Throwable -> L26
    L21:
        if (Result.isFailure-impl(r5) == false) goto L24;
        r5 = null;
    L24:
        monitor-exit(r2);
    L31:
        return (com.ss.android.lark.passport.dpop.a) r5;
    L16:
        r6 = r5;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L26
        r5 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
        goto L14
    L23:
        r5 = r0.b;     // Catch: Throwable -> L26
        goto L24
    L29:
        r5 = r0.b;
        goto L31
    }

    @JvmStatic
    public static final byte[] getDPOPToken(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        Intrinsics.checkNotNullParameter(r2, "method");
        if (Build.VERSION.SDK_INT < 24) goto L19;
        com.ss.android.lark.passport.dpop.a r3 = INSTANCE.getServ();
        if (r3 == null) goto L21;
        com.ss.android.lark.passport.dpop.a.b r4 = r3.a();
        if (r4 == null) goto L21;
        String r0 = null;
        if ((r4 instanceof com.ss.android.lark.passport.dpop.a.f) == false) goto L11;
        com.ss.android.lark.passport.dpop.a.f r5 = (com.ss.android.lark.passport.dpop.a.f) r4;
    L12:
        if (r5 == null) goto L14;
        r0 = r5.a;
    L14:
        if (r0 == null) goto L21;
        byte[] r6 = r0.getBytes(Charsets.UTF_8);
        if (r6 == null) goto L21;
        return r6;
    L11:
        r5 = null;
    L21:
        return baStub;
    L19:
        return baStub;
    }
}
