package com.obric.assistant.audio;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.voice.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.audio.ObricEnrollInteropServiceImpl$setSvaSdkEnrollingStatus$1", f = "ObricEnrollInteropServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricEnrollInteropServiceImpl$setSvaSdkEnrollingStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ boolean $enrolling;
    int label;
    final /* synthetic */ ObricEnrollInteropServiceImpl this$0;

    public ObricEnrollInteropServiceImpl$setSvaSdkEnrollingStatus$1(boolean r1, Context r2, Bundle r3, ObricEnrollInteropServiceImpl r4, Continuation<? super ObricEnrollInteropServiceImpl$setSvaSdkEnrollingStatus$1> r5) {
        this.$enrolling = r1;
        this.$appContext = r2;
        this.$bundle = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricEnrollInteropServiceImpl$setSvaSdkEnrollingStatus$1(this.$enrolling, this.$appContext, this.$bundle, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r8);
        FLogger r9 = FLogger.a;
        r9.i("ObricEnrollInteropServiceImpl", "setSvaSdkEnrollingStatus start enrolling=" + this.$enrolling);
        ContentProviderClient r2 = null;
        ContentProviderClient r4 = a(this.$appContext.getContentResolver(), k.a);     // Catch: Throwable -> L15 RemoteException -> L17
        if (r4 != null) goto L32;
    L8:
        r9.i("ObricEnrollInteropServiceImpl", "setSvaSdkEnrollingStatus end enrolling=" + this.$enrolling);     // Catch: Throwable -> L11 RemoteException -> L13
        if (r4 == null) goto L22;
        ObricEnrollInteropServiceImpl r10 = this.this$0;
        int r0 = ObricEnrollInteropServiceImpl.b;
        r10.getClass();
        ObricEnrollInteropServiceImpl.B(r4);
    L22:
        return Unit.INSTANCE;
    L13:
        e = e;
        r2 = r4;
    L18:
        FLogger.a.e("ObricEnrollInteropServiceImpl", "setSvaSdkEnrollingStatus failed: " + e.getMessage());     // Catch: Throwable -> L15
        if (r2 == null) goto L22;
        ObricEnrollInteropServiceImpl r11 = this.this$0;
        int r1 = ObricEnrollInteropServiceImpl.b;
        r11.getClass();
        ObricEnrollInteropServiceImpl.B(r2);
    L11:
        th = th;
    L24:
        if (r4 == null) goto L26;
        ObricEnrollInteropServiceImpl r3 = this.this$0;
        int r5 = ObricEnrollInteropServiceImpl.b;
        r3.getClass();
        ObricEnrollInteropServiceImpl.B(r4);
    L26:
        throw th;
    L32:
        r4.call("set-enrolling-status", null, this.$bundle);     // Catch: Throwable -> L11 RemoteException -> L13
    L17:
        e = e;
    L15:
        th = th;
        r4 = r2;
        goto L24
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static ContentProviderClient a(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
