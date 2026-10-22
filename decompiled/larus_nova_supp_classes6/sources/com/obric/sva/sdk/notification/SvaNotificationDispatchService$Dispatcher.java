package com.obric.sva.sdk.notification;

import android.content.Context;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.service.notification.StatusBarNotification;
import com.obric.assistant.NotificationSignatureWhiteItem;
import com.obric.assistant.OUseMemorySettingsConfig;
import com.obric.assistant.ObricPackageSignatureCache;
import com.obric.assistant.ObricSecuritySettingsPackageWhitelistConfig;
import com.obric.assistant.l;
import com.obric.assistant.spi.notification.IObricInteractorNotificationCallback;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\nJ\u001c\u0010\u0016\u001a\u00020\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0018H\u0002J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u001a\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/sva/sdk/notification/SvaNotificationDispatchService$Dispatcher;", "", "<init>", "()V", "callbacks", "Landroid/os/RemoteCallbackList;", "Lcom/obric/assistant/spi/notification/IObricInteractorNotificationCallback;", "listenerConnected", "", "registerCallback", "", "callback", "unregisterCallback", "dispatchNotificationPosted", "context", "Landroid/content/Context;", "notification", "Landroid/service/notification/StatusBarNotification;", "dispatchNotificationRemoved", "dispatchListenerConnected", "dispatchListenerDisconnected", "kill", "dispatch", "block", "Lkotlin/Function1;", "receiveNotificationData", "getAppName", "", "pkg", "isNotificationDataSafe", "pkgName", "config", "Lcom/obric/assistant/ObricSecuritySettingsPackageWhitelistConfig;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SvaNotificationDispatchService$Dispatcher {
    public static final SvaNotificationDispatchService$Dispatcher INSTANCE = null;
    private static final RemoteCallbackList<IObricInteractorNotificationCallback> callbacks = null;
    private static boolean listenerConnected;

    private SvaNotificationDispatchService$Dispatcher() {
    }

    public static /* synthetic */ Unit a(StatusBarNotification r0, IObricInteractorNotificationCallback r1) {
        return dispatchNotificationRemoved$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit b(IObricInteractorNotificationCallback r0) {
        return dispatchListenerDisconnected$lambda$3(r0);
    }

    public static /* synthetic */ Unit c(IObricInteractorNotificationCallback r0) {
        return dispatchListenerConnected$lambda$2(r0);
    }

    public static /* synthetic */ boolean d(String r0) {
        return isNotificationDataSafe$lambda$8(r0);
    }

    public static /* synthetic */ String e(String r0) {
        return isNotificationDataSafe$lambda$7(r0);
    }

    public static /* synthetic */ boolean f(String r0, NotificationSignatureWhiteItem r1) {
        return isNotificationDataSafe$lambda$5(r0, r1);
    }

    public static /* synthetic */ Sequence g(NotificationSignatureWhiteItem r0) {
        return isNotificationDataSafe$lambda$6(r0);
    }

    public static /* synthetic */ Unit h(StatusBarNotification r0, IObricInteractorNotificationCallback r1) {
        return dispatchNotificationPosted$lambda$0(r0, r1);
    }

    public final void dispatchListenerConnected() {
        listenerConnected = true;
        LogUtils.i("SvaNotificationDispatch", "dispatchListenerConnected", new Object[0]);
        dispatch(new d());
    }

    public final void dispatchListenerDisconnected() {
        listenerConnected = false;
        LogUtils.i("SvaNotificationDispatch", "dispatchListenerDisconnected", new Object[0]);
        dispatch(new i());
    }

    public final void kill() {
        listenerConnected = false;
        callbacks.kill();
    }

    static {
        INSTANCE = new SvaNotificationDispatchService$Dispatcher();
        callbacks = new RemoteCallbackList();
    }

    private final void dispatch(Function1<? super IObricInteractorNotificationCallback, Unit> r8) {
        int r0 = callbacks.beginBroadcast();
        LogUtils.i("SvaNotificationDispatch", "dispatch callback count: " + r0, new Object[0]);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        r8.invoke(callbacks.getBroadcastItem(r1));     // Catch: Throwable -> L7 RemoteException -> L9
    L11:
        r1 = r1 + 1;
    L7:
        th = move-exception;
        LogUtils.w("SvaNotificationDispatch", "dispatch callback failed", new Object[]{th});     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        callbacks.finishBroadcast();
        throw th;
    L9:
        e = move-exception;
        LogUtils.w("SvaNotificationDispatch", "dispatch remote callback failed", new Object[]{e});     // Catch: Throwable -> L12
        goto L11
    L15:
        callbacks.finishBroadcast();
    }

    private static final Unit dispatchListenerConnected$lambda$2(IObricInteractorNotificationCallback r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        r1.onListenerConnected();
        return Unit.INSTANCE;
    }

    private static final Unit dispatchListenerDisconnected$lambda$3(IObricInteractorNotificationCallback r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        r1.onListenerDisconnected();
        return Unit.INSTANCE;
    }

    private static final Sequence isNotificationDataSafe$lambda$6(NotificationSignatureWhiteItem r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        List r2 = r1.getSignatures();
        if (r2 != null) goto L6;
        r2 = CollectionsKt.emptyList();
    L6:
        return CollectionsKt.asSequence(r2);
    }

    private static final String isNotificationDataSafe$lambda$7(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return StringsKt.trim(r1).toString().toLowerCase(Locale.ROOT);
    }

    private static final boolean isNotificationDataSafe$lambda$8(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return !StringsKt.isBlank(r1);
    }

    public final void dispatchNotificationRemoved(StatusBarNotification r3) {
        if (r3 != null) goto L5;
        LogUtils.w("SvaNotificationDispatch", "dispatchNotificationRemoved failed, notification is null", new Object[0]);
        return;
    L5:
        dispatch(new j(r3));
    }

    public final void registerCallback(IObricInteractorNotificationCallback r6) {
        if (r6 != null) goto L6;
        LogUtils.w("SvaNotificationDispatch", "registerCallback failed, callback is null", new Object[0]);
        return;
    L6:
        callbacks.register(r6);
        LogUtils.i("SvaNotificationDispatch", "registerCallback: " + r6 + ", listenerConnected: " + listenerConnected, new Object[0]);
        if (listenerConnected == true) goto L16;
        return;
    L16:
        r6.onListenerConnected();     // Catch: Throwable -> L11 RemoteException -> L13
        LogUtils.i("SvaNotificationDispatch", "notify current listener connected to new callback", new Object[0]);     // Catch: Throwable -> L11 RemoteException -> L13
    L20:
        return;
    L13:
        e = move-exception;
        LogUtils.w("SvaNotificationDispatch", "notify current listener connected failed", new Object[]{e});
        return;
    L11:
        th = move-exception;
        LogUtils.w("SvaNotificationDispatch", "notify current listener connected failed", new Object[]{th});
    }

    public final void unregisterCallback(IObricInteractorNotificationCallback r5) {
        if (r5 != null) goto L6;
        LogUtils.w("SvaNotificationDispatch", "unregisterCallback failed, callback is null", new Object[0]);
        return;
    L6:
        callbacks.unregister(r5);
        LogUtils.i("SvaNotificationDispatch", "unregisterCallback: " + r5, new Object[0]);
    }

    private static final Unit dispatchNotificationPosted$lambda$0(StatusBarNotification r1, IObricInteractorNotificationCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.onNotificationPosted(r1);
        return Unit.INSTANCE;
    }

    private static final Unit dispatchNotificationRemoved$lambda$1(StatusBarNotification r1, IObricInteractorNotificationCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.onNotificationRemoved(r1);
        return Unit.INSTANCE;
    }

    private final String getAppName(Context r5, String r6) {
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L18;
        if (r6 != null) goto L20;
        return "";
    L20:
        return r6;
    L18:
        return r5.getPackageManager().getApplicationLabel(r5.getPackageManager().getApplicationInfo(r6, 0)).toString();
    L15:
        th = move-exception;
        LogUtils.w("SvaNotificationDispatch", "getAppName failed, pkg=" + r6, new Object[]{th});
        return r6;
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final boolean isNotificationDataSafe(String r5, ObricSecuritySettingsPackageWhitelistConfig r6) {
        OUseMemorySettingsConfig r0 = l.a;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        boolean r1 = true;
        if (Intrinsics.areEqual(r6.getGlobalWhiteListSignatureCheckEnabled(), Boolean.TRUE) == true) goto L6;
        return true;
    L6:
        if (r5 == null) goto L33;
        String r3 = null;
        if ((!StringsKt.isBlank(r5)) == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L33;
        List r7 = r6.getAppListSignatures();
        if (r7 != null) goto L16;
        r7 = CollectionsKt.emptyList();
    L16:
        Set r8 = SequencesKt.toSet(SequencesKt.filter(SequencesKt.map(SequencesKt.filterNotNull(SequencesKt.flatMap(SequencesKt.filter(CollectionsKt.asSequence(CollectionsKt.filterNotNull(r7)), new e(r5)), new f())), new g()), new h()));
        if (r8.isEmpty() == false) goto L19;
        return false;
    L19:
        String r9 = ObricPackageSignatureCache.a.getOrCompute(r5);
        if (r9 == null) goto L24;
        String r10 = StringsKt.trim(r9).toString();
        if (r10 == null) goto L24;
        r3 = r10.toLowerCase(Locale.ROOT);
    L24:
        if (r3 != null) goto L26;
    L29:
        if (r1 == false) goto L32;
        return false;
    L32:
        return r8.contains(r3);
    L26:
        if (StringsKt.isBlank(r3) == true) goto L29;
        r1 = false;
    L33:
        return false;
    }

    private static final boolean isNotificationDataSafe$lambda$5(String r1, NotificationSignatureWhiteItem r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Intrinsics.areEqual(r2.getPkgName(), r1);
    }

    private final void receiveNotificationData(Context r10, StatusBarNotification r11) {
        LogUtils.w("SvaNotificationDispatch", "receiveNotificationData", new Object[0]);
        if (r10 != null) goto L6;
        LogUtils.w("SvaNotificationDispatch", "receiveNotificationData failed, context is null", new Object[0]);
        return;
    L6:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new receiveNotificationData.1(r11, r10, null), 2, null);
    }

    public final void dispatchNotificationPosted(Context r6, StatusBarNotification r7) {
        if (r7 != null) goto L6;
        LogUtils.w("SvaNotificationDispatch", "dispatchNotificationPosted failed, notification is null", new Object[0]);
        return;
    L6:
        LogUtils.w("SvaNotificationDispatch", "dispatchNotificationPosted: " + r7.getPackageName() + ", when: " + r7.getPostTime(), new Object[0]);
        receiveNotificationData(r6, r7);
        dispatch(new c(r7));
    }

    public static final /* synthetic */ String access$getAppName(SvaNotificationDispatchService$Dispatcher r0, Context r1, String r2) {
        return r0.getAppName(r1, r2);
    }

    public static final /* synthetic */ boolean access$isNotificationDataSafe(SvaNotificationDispatchService$Dispatcher r0, String r1, ObricSecuritySettingsPackageWhitelistConfig r2) {
        return r0.isNotificationDataSafe(r1, r2);
    }
}
