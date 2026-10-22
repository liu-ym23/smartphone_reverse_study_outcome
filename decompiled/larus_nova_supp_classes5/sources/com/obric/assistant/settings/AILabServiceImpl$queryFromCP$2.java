package com.obric.assistant.settings;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.im.b;
import com.larus.utils.logger.FLogger;
import gd9.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.AILabServiceImpl$queryFromCP$2", f = "AILabServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AILabServiceImpl$queryFromCP$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ AILabSettingItem $item;
    int label;
    final /* synthetic */ AILabServiceImpl this$0;

    public AILabServiceImpl$queryFromCP$2(AILabSettingItem r1, AILabServiceImpl r2, Continuation<? super AILabServiceImpl$queryFromCP$2> r3) {
        this.$item = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AILabServiceImpl$queryFromCP$2(this.$item, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L88;
        ResultKt.throwOnFailure(r22);
        Uri r8 = UriProtector.parse("content://com.obric.memorydata.memory.ailabprovider/" + this.$item.getUriKey());
        AILabServiceImpl r9 = this.this$0;
        AILabSettingItem r10 = this.$item;
        int r0 = AILabServiceImpl.d;
        r9.getClass();
        String r7 = "queryFromCP: remote exception. ";
        String r6 = "queryFromCP: provider died. ";
        ContentProviderClient r5 = null;
        i r3 = b.a;     // Catch: Throwable -> L58 Exception -> L60 SecurityException -> L65 RemoteException -> L71 DeadObjectException -> L76
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L58 Exception -> L60 SecurityException -> L65 RemoteException -> L71 DeadObjectException -> L76
        ContentProviderClient r16 = AILabServiceImpl.c(r3.getApplication().getContentResolver(), r8);     // Catch: Throwable -> L58 Exception -> L60 SecurityException -> L65 RemoteException -> L71 DeadObjectException -> L76
        if (r16 != null) goto L97;
        FLogger.a.w("AILabServiceImpl", "queryFromCP: no unstable client, " + r10.getUriKey() + ", uri=" + r8);     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L15 DeadObjectException -> L17
        int r1 = r9.d(r10, "no_unstable_client");     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L15 DeadObjectException -> L17
    L82:
        return Boxing.boxInt(r1);
    L17:
        e = e;
    L57:
        r5 = r16;
    L78:
        FLogger.a.w("AILabServiceImpl", r6 + r10.getUriKey() + ", uri=" + r8, e);     // Catch: Throwable -> L83
        r1 = r9.d(r10, "dead_object");     // Catch: Throwable -> L83
        if (r5 == null) goto L89;
    L80:
        r5.close();
    L89:
    L15:
        e = e;
    L55:
        r5 = r16;
    L73:
        FLogger.a.w("AILabServiceImpl", r7 + r10.getUriKey() + ", uri=" + r8, e);     // Catch: Throwable -> L83
        r1 = r9.d(r10, "remote_exception");     // Catch: Throwable -> L83
        if (r5 == null) goto L89;
    L97:
        Cursor r2 = r16.query(r8, null, null, null, null);     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
        if (r2 == null) goto L49;
        Cursor r4 = r2;     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
        Cursor r11 = r4;     // Catch: Throwable -> L42
        if (r11.moveToFirst() == false) goto L39;
        int r12 = r11.getColumnIndex("status");     // Catch: Throwable -> L42
        if (r12 < 0) goto L35;
        r1 = r11.getInt(r12);     // Catch: Throwable -> L42
        FLogger.a.i("AILabServiceImpl", "queryFromCP: " + r10.getUriKey() + ", status = " + r1);     // Catch: Throwable -> L42
        if (r10.getAutoUpdate() == false) goto L32;
        r9.a.put(r10, Integer.valueOf(r1));     // Catch: Throwable -> L42
    L32:
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
    L50:
        r16.close();
        goto L82
    L35:
        FLogger.a.w("AILabServiceImpl", "queryFromCP: " + r10.getUriKey() + ", no status");     // Catch: Throwable -> L42
        r1 = r9.d(r10, "missing_status_column");     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
        goto L50
    L39:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
        FLogger.a.w("AILabServiceImpl", "queryFromCP: cursor is empty. " + r10.getUriKey());     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
        r1 = r9.d(r10, "empty_cursor");     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
        throw th;     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
    L49:
        FLogger.a.w("AILabServiceImpl", "queryFromCP: no cursor, " + r10.getUriKey() + ", uri=" + r8);     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
        r1 = r9.d(r10, "null_cursor");     // Catch: Throwable -> L9 Exception -> L11 SecurityException -> L13 RemoteException -> L54 DeadObjectException -> L56
    L56:
        e = e;
    L54:
        e = e;
    L13:
        e = e;
        r5 = r16;
    L67:
        FLogger.a.w("AILabServiceImpl", "queryFromCP: security exception. " + r10.getUriKey() + ", uri=" + r8, e);     // Catch: Throwable -> L83
        if (r5 == null) goto L70;
        r5.close();
    L70:
        r1 = -100;
    L11:
        e = e;
        r5 = r16;
    L62:
        FLogger.a.w("AILabServiceImpl", "queryFromCP: failed. " + r10.getUriKey() + ", uri=" + r8 + ", error=" + e.getMessage(), e);     // Catch: Throwable -> L83
        r1 = r9.d(r10, "exception");     // Catch: Throwable -> L83
        if (r5 == null) goto L89;
    L9:
        th = th;
        r5 = r16;
    L84:
        if (r5 == null) goto L86;
        r5.close();
    L86:
        throw th;
    L83:
        th = th;
    L76:
        e = e;
        r6 = "queryFromCP: provider died. ";
        r5 = null;
    L71:
        e = e;
        r7 = "queryFromCP: remote exception. ";
        r5 = null;
    L65:
        e = e;
        r5 = null;
    L60:
        e = e;
        r5 = null;
    L58:
        th = th;
        r5 = null;
        goto L84
    L88:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
