package com.obric.livecard.api;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.impl.IslandImpl;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.island.IslandHideApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0080T¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/obric/livecard/api/LiveCard;", "Lcom/obric/livecard/api/ILiveCard;", "()V", "context", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "islandImpl", "Lcom/obric/livecard/api/impl/IslandImpl;", "islandVersion", "", "getIslandVersion$LiveCard_sdk_release", "()Ljava/lang/Integer;", "setIslandVersion$LiveCard_sdk_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "keyIslandVersion", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "getPackageName", "()Ljava/lang/String;", "clearSession", "", "session", "Lcom/obric/livecard/api/entity/IslandSession;", "getIslandHideApi", "Lcom/obric/livecard/api/island/IslandHideApi;", "getIslandService", "Lcom/obric/livecard/api/island/IslandApi;", "getVersion", "Landroid/content/Context;", "getVersionReal", CommonConsts.APM_INNER_EVENT_COST_INIT, "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LiveCard implements ILiveCard {
    public static final LiveCard INSTANCE = null;
    private static Application context = null;
    private static final IslandImpl islandImpl = null;
    private static volatile Integer islandVersion = null;
    public static final String keyIslandVersion = "island_version";

    /* JADX INFO: renamed from: com.obric.livecard.api.LiveCard$init$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.livecard.api.LiveCard$init$1", f = "LiveCard.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    static final class C10701 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        C10701(Continuation<? super C10701> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10701((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10701) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10701.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IslandImpl r6 = LiveCard.access$getIslandImpl$p();
            Continuation<? super IIslandService> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.getService(r2) != r0) goto L12;
            return r0;
        }
    }

    static {
        INSTANCE = new LiveCard();
        islandImpl = new IslandImpl();
    }

    private LiveCard() {
    }

    public static final /* synthetic */ IslandImpl access$getIslandImpl$p() {
        return islandImpl;
    }

    private static final boolean clearSession$lambda$4(Function1 r2, Object r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$tmp0");
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final int getVersionReal(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        ApplicationInfo r2 = r4.getPackageManager().getPackageInfo(IslandImpl.LIVE_CARD_PLUGIN, 128).applicationInfo;     // Catch: Throwable -> L18
        if (r2 == null) goto L10;
        Bundle r3 = r2.metaData;     // Catch: Throwable -> L18
        if (r3 == null) goto L10;
        int r6 = r3.getInt(keyIslandVersion, 0);     // Catch: Throwable -> L18
        Integer r7 = Integer.valueOf(r6);     // Catch: Throwable -> L18
    L9:
        islandVersion = r7;     // Catch: Throwable -> L18
    L16:
        Object r8 = Result.m1421constructorimpl(Integer.valueOf(r6));     // Catch: Throwable -> L18
    L21:
        if (Result.m1427isFailureimpl(r8) == false) goto L23;
        r8 = null;
    L23:
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L26;
        return 0;
    L26:
        return r9.intValue();
    L10:
        ApplicationInfo r10 = r4.getPackageManager().getPackageInfo(IslandImpl.LIVE_CARD_HOST, 128).applicationInfo;     // Catch: Throwable -> L18
        if (r10 == null) goto L15;
        Bundle r11 = r10.metaData;     // Catch: Throwable -> L18
        if (r11 == null) goto L15;
        r6 = r11.getInt(keyIslandVersion, 0);     // Catch: Throwable -> L18
        r7 = Integer.valueOf(r6);     // Catch: Throwable -> L18
    L15:
        r6 = 0;
    L18:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    /* JADX INFO: renamed from: lambda$xO4466mONn0C-P16pwwNzYBEgs4, reason: not valid java name */
    public static /* synthetic */ boolean m420lambda$xO4466mONn0CP16pwwNzYBEgs4(Function1 r0, Object r1) {
        return clearSession$lambda$4(r0, r1);
    }

    public final void clearSession(final IslandSession r3) {
        Intrinsics.checkNotNullParameter(r3, "session");
        Set<IslandSession> r2 = islandImpl.getMSessionMap().keySet();
        final Function1 r4 = (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), Function1.class, "com.obric.memorydata.plugin");
        r2.removeIf(new $$Lambda$LiveCard$xO4466mONn0CP16pwwNzYBEgs4(r4));
    }

    @Override // com.obric.livecard.api.ILiveCard
    public Application getContext() {
        return context;
    }

    @Override // com.obric.livecard.api.ILiveCard
    public IslandHideApi getIslandHideApi(Application r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.memorydata.plugin");
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")) != null) goto L5;
        setContext(r5);
    L5:
        Application r6 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L8;
        String r7 = r6.getPackageName();
    L10:
        if (Intrinsics.areEqual(r7, "com.obric.appletapp") == true) goto L31;
        Application r8 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L14;
        String r9 = r8.getPackageName();
    L16:
        if (Intrinsics.areEqual(r9, IslandImpl.LIVE_CARD_HOST) == true) goto L31;
        Application r10 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L20;
        String r11 = r10.getPackageName();
    L22:
        if (Intrinsics.areEqual(r11, "com.android.launcher3") == true) goto L31;
        Application r3 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L26;
        String r12 = r3.getPackageName();
    L28:
        if (Intrinsics.areEqual(r12, IslandImpl.LIVE_CARD_HOST_DEPRECATED) == true) goto L31;
        Object r13 = ZeusTransformUtils.preCheckCast(null, IslandHideApi.class, "com.obric.memorydata.plugin");
    L33:
        return (IslandHideApi) r13;
    L26:
        r12 = null;
        goto L28
    L20:
        r11 = null;
        goto L22
    L14:
        r9 = null;
    L31:
        r13 = ZeusTransformUtils.preCheckCast(islandImpl, IslandHideApi.class, "com.obric.memorydata.plugin");
        goto L33
    L8:
        r7 = null;
        goto L10
    }

    @Override // com.obric.livecard.api.ILiveCard
    public IslandApi getIslandService() {
        return (IslandApi) ZeusTransformUtils.preCheckCast(islandImpl, IslandApi.class, "com.obric.memorydata.plugin");
    }

    public final Integer getIslandVersion$LiveCard_sdk_release() {
        return islandVersion;
    }

    @Override // com.obric.livecard.api.ILiveCard
    public String getPackageName() {
        Application r2 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getPackageName();
    }

    @Override // com.obric.livecard.api.ILiveCard
    public int getVersion(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Integer r0 = islandVersion;
        if (r0 == null) goto L6;
        return r0.intValue();
    L6:
        return getVersionReal(r4);
    }

    @Override // com.obric.livecard.api.ILiveCard
    public void init(Application r9) {
        Application r10 = (Application) ZeusTransformUtils.wrapperContextForParams(r9, Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        setContext(r10);
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10701(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public void setContext(Application r2) {
        context = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
    }

    public final void setIslandVersion$LiveCard_sdk_release(Integer r1) {
        islandVersion = r1;
    }
}
