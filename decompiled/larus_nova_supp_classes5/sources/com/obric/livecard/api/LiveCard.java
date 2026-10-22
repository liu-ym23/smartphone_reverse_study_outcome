package com.obric.livecard.api;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.impl.IslandImpl;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.island.IslandHideApi;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0080T¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/obric/livecard/api/LiveCard;", "Lcom/obric/livecard/api/ILiveCard;", "()V", "context", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "islandImpl", "Lcom/obric/livecard/api/impl/IslandImpl;", "islandVersion", "", "getIslandVersion$LiveCard_sdk_release", "()Ljava/lang/Integer;", "setIslandVersion$LiveCard_sdk_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "keyIslandVersion", "", DBDefinition.PACKAGE_NAME, "getPackageName", "()Ljava/lang/String;", "clearSession", "", "session", "Lcom/obric/livecard/api/entity/IslandSession;", "getIslandHideApi", "Lcom/obric/livecard/api/island/IslandHideApi;", "getIslandService", "Lcom/obric/livecard/api/island/IslandApi;", "getVersion", "Landroid/content/Context;", "getVersionReal", "init", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LiveCard implements ILiveCard {
    public static final LiveCard INSTANCE = null;
    private static Application context = null;
    private static final IslandImpl islandImpl = null;
    private static volatile Integer islandVersion = null;
    public static final String keyIslandVersion = "island_version";

    /* JADX INFO: renamed from: com.obric.livecard.api.LiveCard$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.livecard.api.LiveCard$init$1", f = "LiveCard.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            IslandImpl r5 = LiveCard.access$getIslandImpl$p();
            this.label = 1;
            if (r5.getService(this) != r0) goto L12;
            return r0;
        }
    }

    private LiveCard() {
    }

    public static /* synthetic */ boolean a(Function1 r0, Object r1) {
        return clearSession$lambda$4(r0, r1);
    }

    static {
        INSTANCE = new LiveCard();
        islandImpl = new IslandImpl();
    }

    @Override // com.obric.livecard.api.ILiveCard
    public String getPackageName() {
        Application r0 = getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPackageName();
    }

    public static final /* synthetic */ IslandImpl access$getIslandImpl$p() {
        return islandImpl;
    }

    @Override // com.obric.livecard.api.ILiveCard
    public Application getContext() {
        return context;
    }

    @Override // com.obric.livecard.api.ILiveCard
    public IslandApi getIslandService() {
        return islandImpl;
    }

    public final Integer getIslandVersion$LiveCard_sdk_release() {
        return islandVersion;
    }

    private final int getVersionReal(Context r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        ApplicationInfo r2 = r5.getPackageManager().getPackageInfo(IslandImpl.LIVE_CARD_PLUGIN, 128).applicationInfo;     // Catch: Throwable -> L17
        if (r2 == null) goto L9;
        Bundle r3 = r2.metaData;     // Catch: Throwable -> L17
        if (r3 == null) goto L9;
        int r6 = r3.getInt(keyIslandVersion, 0);     // Catch: Throwable -> L17
        islandVersion = Integer.valueOf(r6);     // Catch: Throwable -> L17
    L15:
        Object r7 = Result.constructor-impl(Integer.valueOf(r6));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r7) == false) goto L22;
        r7 = null;
    L22:
        Integer r8 = (Integer) r7;
        if (r8 != null) goto L25;
        return 0;
    L25:
        return r8.intValue();
    L9:
        ApplicationInfo r9 = r5.getPackageManager().getPackageInfo(IslandImpl.LIVE_CARD_HOST, 128).applicationInfo;     // Catch: Throwable -> L17
        if (r9 == null) goto L14;
        Bundle r10 = r9.metaData;     // Catch: Throwable -> L17
        if (r10 == null) goto L14;
        r6 = r10.getInt(keyIslandVersion, 0);     // Catch: Throwable -> L17
        islandVersion = Integer.valueOf(r6);     // Catch: Throwable -> L17
    L14:
        r6 = 0;
    L17:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public final void clearSession(IslandSession r3) {
        Intrinsics.checkNotNullParameter(r3, "session");
        islandImpl.getMSessionMap().keySet().removeIf(new a(new clearSession.1(r3)));
    }

    @Override // com.obric.livecard.api.ILiveCard
    public IslandHideApi getIslandHideApi(Application r3) {
        if (getContext() != null) goto L5;
        setContext(r3);
    L5:
        Application r4 = getContext();
        if (r4 == null) goto L8;
        String r5 = r4.getPackageName();
    L10:
        if (Intrinsics.areEqual(r5, "com.obric.appletapp") == true) goto L30;
        Application r6 = getContext();
        if (r6 == null) goto L14;
        String r7 = r6.getPackageName();
    L16:
        if (Intrinsics.areEqual(r7, IslandImpl.LIVE_CARD_HOST) == true) goto L30;
        Application r8 = getContext();
        if (r8 == null) goto L20;
        String r9 = r8.getPackageName();
    L22:
        if (Intrinsics.areEqual(r9, "com.android.launcher3") == true) goto L30;
        Application r10 = getContext();
        if (r10 == null) goto L26;
        String r11 = r10.getPackageName();
    L28:
        if (Intrinsics.areEqual(r11, IslandImpl.LIVE_CARD_HOST_DEPRECATED) == true) goto L30;
        return null;
    L26:
        r11 = null;
        goto L28
    L20:
        r9 = null;
        goto L22
    L14:
        r7 = null;
    L30:
        return islandImpl;
    L8:
        r5 = null;
        goto L10
    }

    @Override // com.obric.livecard.api.ILiveCard
    public int getVersion(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Integer r0 = islandVersion;
        if (r0 == null) goto L6;
        return r0.intValue();
    L6:
        return getVersionReal(r2);
    }

    @Override // com.obric.livecard.api.ILiveCard
    public void init(Application r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        setContext(r7);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(null), 3, null);
    }

    public void setContext(Application r1) {
        context = r1;
    }

    public final void setIslandVersion$LiveCard_sdk_release(Integer r1) {
        islandVersion = r1;
    }

    private static final boolean clearSession$lambda$4(Function1 r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        return ((Boolean) r1.invoke(r2)).booleanValue();
    }
}
