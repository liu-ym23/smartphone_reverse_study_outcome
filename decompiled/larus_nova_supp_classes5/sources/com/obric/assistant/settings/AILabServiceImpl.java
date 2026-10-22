package com.obric.assistant.settings;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0013\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0017J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0097@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\rH\u0097@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0006H\u0083@¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0003J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/settings/AILabServiceImpl;", "Lcom/obric/assistant/settings/IAILabService;", "<init>", "()V", "cachedSettings", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/settings/AILabSettingItem;", "", "workScope", "Lkotlinx/coroutines/CoroutineScope;", "init", "", "isSettingEnabled", "", "item", "(Lcom/obric/assistant/settings/AILabSettingItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAILabEnabled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contentObserver", "com/obric/assistant/settings/AILabServiceImpl$contentObserver$1", "Lcom/obric/assistant/settings/AILabServiceImpl$contentObserver$1;", "queryFromCP", "unstableQueryFromCP", "uri", "Landroid/net/Uri;", "fallbackToCachedOrDefault", "reason", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AILabServiceImpl implements IAILabService {
    public static final /* synthetic */ int d = 0;
    public final ConcurrentHashMap<AILabSettingItem, Integer> a;
    public final CoroutineScope b;
    public final contentObserver.1 c;

    /* JADX INFO: renamed from: com.obric.assistant.settings.AILabServiceImpl$init$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.AILabServiceImpl$init$3", f = "AILabServiceImpl.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AILabServiceImpl this$0;

        public AnonymousClass3(AILabServiceImpl r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Iterator r2 = (Iterator) this.L$1;
            AILabServiceImpl r3 = (AILabServiceImpl) this.L$0;
            ResultKt.throwOnFailure(r7);
        L17:
            if (r2.hasNext() == false) goto L22;
            AILabSettingItem r4 = (AILabSettingItem) r2.next();
            this.L$0 = r3;
            this.L$1 = r2;
            this.label = 1;
            int r5 = AILabServiceImpl.d;
            if (r3.e(r4, this) != r0) goto L17;
            return r0;
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            EnumEntries r8 = AILabSettingItem.getEntries();
            ArrayList r6 = new ArrayList();
            Iterator r9 = r8.iterator();
        L10:
            if (r9.hasNext() == false) goto L14;
            Object r10 = r9.next();
            if (((AILabSettingItem) r10).getAutoUpdate() == false) goto L10;
            r6.add(r10);
            goto L10
        L14:
            AILabServiceImpl r11 = this.this$0;
            r2 = r6.iterator();
            r3 = r11;
            goto L17
        }
    }

    static {
    }

    public final void init() {
        FLogger r0 = FLogger.a;
        r0.i("AILabServiceImpl", "init");
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        r0.w("AILabServiceImpl", "init: sdk < N, skip CP observer/query");
        return;
    L6:
        EnumEntries r1 = AILabSettingItem.getEntries();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (((AILabSettingItem) r4).getAutoUpdate() == false) goto L8;
        r2.add(r4);
        goto L8
    L12:
        Iterator r5 = r2.iterator();
    L14:
        if (r5.hasNext() == false) goto L23;
        Uri r6 = UriProtector.parse("content://com.obric.memorydata.memory.ailabprovider/" + ((AILabSettingItem) r5.next()).getUriKey());
        FLogger.a.i("AILabServiceImpl", "observe " + r6);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L18
        AppHost.a.getApplication().getContentResolver().registerContentObserver(r6, false, this.c);     // Catch: Throwable -> L18
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L14;
        FLogger.a.w("AILabServiceImpl", "observe failed, uri = " + r6 + ", error = " + r9.getMessage(), r9);
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L23:
        BuildersKt.launch$default(this.b, null, null, new AnonymousClass3(this, null), 3, null);
    }

    public AILabServiceImpl() {
        this.a = new ConcurrentHashMap();
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.c = new contentObserver.1(this, t0.a);
    }

    public final Object a(Continuation<? super Boolean> r9) {
        if ((r9 instanceof isAILabEnabled.1) == false) goto L7;
        isAILabEnabled.1 r0 = (isAILabEnabled.1) r9;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r6 = false;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L35:
        if (((Number) r10).intValue() == 4) goto L37;
    L36:
        r6 = true;
    L37:
        FLogger.a.i("AILabServiceImpl", "isAILabEnabled(): aiLabStatusEnable is " + r6);
        return Boxing.boxBoolean(r6);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
    L20:
        if (((Number) r10).intValue() != 1) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == true) goto L26;
        FLogger.a.i("AILabServiceImpl", "isAILabEnabled(): hasMemoryPermission is false, return false");
        return Boxing.boxBoolean(false);
    L26:
        ConcurrentHashMap<AILabSettingItem, Integer> r12 = this.a;
        AILabSettingItem r4 = AILabSettingItem.AILabStatus;
        Integer r13 = r12.get(r4);
        if (r13 != null) goto L29;
        r0.label = 2;
        r10 = e(r4, r0);
        if (r10 != r2) goto L35;
        return r2;
    L29:
        if (r13.intValue() == 4) goto L37;
    L22:
        r11 = false;
        goto L23
    L16:
        ResultKt.throwOnFailure(r10);
        AILabSettingItem r14 = AILabSettingItem.MemoryPermissonStatus;
        r0.label = 1;
        r10 = e(r14, r0);
        if (r10 != r2) goto L20;
        return r2;
    L7:
        r0 = new isAILabEnabled.1(this, r9);
        goto L8
    }

    public static ContentProviderClient c(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(240008);
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
        d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
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
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final Object b(AILabSettingItem r6, Continuation<? super Boolean> r7) {
        if ((r7 instanceof isSettingEnabled.1) == false) goto L7;
        isSettingEnabled.1 r0 = (isSettingEnabled.1) r7;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L25:
        if (((Number) r8).intValue() != 1) goto L28;
        r4 = true;
    L28:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        Integer r9 = this.a.get(r6);
        if (r9 == null) goto L21;
        FLogger.a.i("AILabServiceImpl", "isSettingEnabled: use cached " + r9);
        if (r9.intValue() != 1) goto L20;
        r4 = true;
    L20:
        return Boxing.boxBoolean(r4);
    L21:
        r0.label = 1;
        r8 = e(r6, r0);
        if (r8 != r2) goto L25;
        return r2;
    L7:
        r0 = new isSettingEnabled.1(this, r7);
        goto L8
    }

    public final int d(AILabSettingItem r7, String r8) {
        Integer r0 = this.a.get(r7);
        if (r0 == null) goto L6;
        FLogger.a.i("AILabServiceImpl", "queryFromCP: use cached fallback. " + r7.getUriKey() + ", reason = " + r8 + ", cachedValue = " + r0);
        return r0.intValue();
    L6:
        FLogger.a.i("AILabServiceImpl", "queryFromCP: use default fallback. " + r7.getUriKey() + ", reason = " + r8);
        return -100;
    }

    public final Object e(AILabSettingItem r7, Continuation<? super Integer> r8) {
        return BuildersKt.async$default(this.b, null, null, new AILabServiceImpl$queryFromCP$2(r7, this, null), 3, null).await(r8);
    }
}
