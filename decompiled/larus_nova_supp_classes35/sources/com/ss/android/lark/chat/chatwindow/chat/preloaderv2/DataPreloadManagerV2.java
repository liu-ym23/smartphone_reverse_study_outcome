package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class DataPreloadManagerV2 implements d, r {
    public final c a;
    public final Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> b;
    public final Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>> c;
    public final m d;
    public CoroutineScope e;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final m getPassport() {
        return this.d;
    }

    public final void onUserOffline(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        CoroutineScope r4 = this.e;
        if (r4 == null) goto L5;
        CoroutineScopeKt.cancel$default(r4, null, 1, null);
    L5:
        this.e = null;
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r2, "state");
        this.e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d
    public final <S> Object B6(w3b.d<S> r6, Continuation<? super Result<? extends S>> r7) {
        if ((r7 instanceof DataPreloadManagerV2$fetchData$1) == false) goto L7;
        DataPreloadManagerV2$fetchData$1 r0 = (DataPreloadManagerV2$fetchData$1) r7;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        w3b.d r9 = (w3b.d) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L30:
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r6;
        r0.label = 1;
        final j r10 = new j(IntrinsicsKt.intercepted(r0), 1);
        r10.C();
        Provider<v3b.d<? extends w3b.d<?>, ?>> r4 = this.c.get(r6.type());
        v3b.d r5 = null;
        if (r4 == null) goto L17;
        v3b.d r11 = (v3b.d) r4.get();
    L19:
        if ((r11 instanceof v3b.d) == false) goto L21;
        r5 = r11;
    L21:
        if (r5 != null) goto L23;
        Log.e("DataPreloaderV2", "Could not find a keyProvider for target task");
        Result.Companion r12 = Result.Companion;
        r10.resumeWith(Result.constructor-impl(ResultKt.createFailure(new Exception("Could not find a keyProvider for target task"))));
    L24:
        r8 = r10.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L27:
        if (r8 != r2) goto L30;
        return r2;
    L23:
        this.a.a(r5.a(r6), r6, new DataPreloadManagerV2$fetchData$2$1(r10));
        goto L24
    L17:
        r11 = null;
    L7:
        r0 = new DataPreloadManagerV2$fetchData$1(this, r7);
        goto L8
    }

    @Inject
    public DataPreloadManagerV2(c r2, Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> r3, Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>> r4, m r5) {
        Intrinsics.checkNotNullParameter(r2, "engine");
        Intrinsics.checkNotNullParameter(r3, "loaders");
        Intrinsics.checkNotNullParameter(r4, "keyProviders");
        Intrinsics.checkNotNullParameter(r5, "passport");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        r5.d(this);
    }
}
