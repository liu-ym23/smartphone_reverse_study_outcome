package com.obric.assistant.interaction.impl.activityresult;

import android.app.Activity;
import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import com.obric.assistant.interaction.api.service.ActivityResultCallback;
import com.obric.assistant.interaction.api.service.IActivityResultHelperApi;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import gd9.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0017J\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityResultHelperImpl;", "Lcom/obric/assistant/interaction/api/service/IActivityResultHelperApi;", "<init>", "()V", "startActivityForResult", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "callback", "Lcom/obric/assistant/interaction/api/service/ActivityResultCallback;", "listener", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "finishActivitiesExceptChatWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityResultHelperImpl implements IActivityResultHelperApi {
    public static final Companion Companion = null;
    public static final String TAG = "ActivityResultHelperImpl";
    private static final ConcurrentHashMap<String, ActivityResultCallback> callbackMap = null;
    private static final Function1<Intent, Unit> defaultProxyActivityStarter = null;
    private static Function1<? super Intent, Unit> proxyActivityStarter;
    private static final ActivityProxyRequestStore proxyRequestStore = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\b\u0017J\u0017\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u000eH\u0000¢\u0006\u0002\b&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityResultHelperImpl$Companion;", "", "<init>", "()V", "TAG", "", "callbackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/interaction/api/service/ActivityResultCallback;", "proxyRequestStore", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyRequestStore;", "defaultProxyActivityStarter", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "proxyActivityStarter", "getProxyActivityStarter$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setProxyActivityStarter$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "dispatchSuccess", "requestId", "data", "dispatchSuccess$impl_mainlandRelease", "dispatchCancel", "dispatchCancel$impl_mainlandRelease", "consumeListener", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "token", "", "consumeListener$impl_mainlandRelease", "installProxyRequestForTest", "Lcom/obric/assistant/interaction/impl/activityresult/ProxyRequest;", "listener", "installProxyRequestForTest$impl_mainlandRelease", "resetProxyActivityStarterForTest", "resetProxyActivityStarterForTest$impl_mainlandRelease", "resetProxyRequestStoreForTest", "resetProxyRequestStoreForTest$impl_mainlandRelease", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Function1<Intent, Unit> getProxyActivityStarter$impl_mainlandRelease() {
            return ActivityResultHelperImpl.access$getProxyActivityStarter$cp();
        }

        public final void resetProxyActivityStarterForTest$impl_mainlandRelease() {
            setProxyActivityStarter$impl_mainlandRelease(ActivityResultHelperImpl.access$getDefaultProxyActivityStarter$cp());
        }

        public final void resetProxyRequestStoreForTest$impl_mainlandRelease() {
            ActivityResultHelperImpl.access$getProxyRequestStore$cp().resetForTest();
        }

        public final ActivityProxyListener consumeListener$impl_mainlandRelease(long r2) {
            return ActivityResultHelperImpl.access$getProxyRequestStore$cp().consume(r2);
        }

        public final void dispatchCancel$impl_mainlandRelease(String r2) {
            if (r2 == null) goto L7;
            ActivityResultCallback r3 = (ActivityResultCallback) ActivityResultHelperImpl.access$getCallbackMap$cp().remove(r2);
            if (r3 == null) goto L8;
            r3.onCancel();
            return;
        L8:
            return;
        }

        public final ProxyRequest installProxyRequestForTest$impl_mainlandRelease(ActivityProxyListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            return ActivityResultHelperImpl.access$getProxyRequestStore$cp().install(r2);
        }

        public final void setProxyActivityStarter$impl_mainlandRelease(Function1<? super Intent, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            ActivityResultHelperImpl.access$setProxyActivityStarter$cp(r2);
        }

        public final void dispatchSuccess$impl_mainlandRelease(String r2, Intent r3) {
            if (r2 == null) goto L7;
            ActivityResultCallback r4 = (ActivityResultCallback) ActivityResultHelperImpl.access$getCallbackMap$cp().remove(r2);
            if (r4 == null) goto L8;
            r4.onSuccess(r3);
            return;
        L8:
            return;
        }
    }

    public ActivityResultHelperImpl() {
    }

    public static /* synthetic */ Unit a(Intent r0) {
        return defaultProxyActivityStarter$lambda$4(r0);
    }

    static {
        Companion = new Companion(null);
        callbackMap = new ConcurrentHashMap();
        proxyRequestStore = new ActivityProxyRequestStore(new MainActivityProxyRequestScheduler());
        Function1<Intent, Unit> r0 = new d();
        defaultProxyActivityStarter = r0;
        proxyActivityStarter = r0;
    }

    @Override // com.obric.assistant.interaction.api.service.IActivityResultHelperApi
    public void finishActivitiesExceptChatWindow() {
        i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        List r1 = r0.a().d();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((!(((Activity) r4) instanceof ChatWindowActivity)) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Iterator r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        Activity r6 = (Activity) r5.next();
        FLogger.a.i(TAG, "finish activity: " + r6);
        r6.finish();
        goto L10
    }

    public static final /* synthetic */ ConcurrentHashMap access$getCallbackMap$cp() {
        return callbackMap;
    }

    public static final /* synthetic */ Function1 access$getDefaultProxyActivityStarter$cp() {
        return defaultProxyActivityStarter;
    }

    public static final /* synthetic */ Function1 access$getProxyActivityStarter$cp() {
        return proxyActivityStarter;
    }

    public static final /* synthetic */ ActivityProxyRequestStore access$getProxyRequestStore$cp() {
        return proxyRequestStore;
    }

    public static final /* synthetic */ void access$setProxyActivityStarter$cp(Function1 r0) {
        proxyActivityStarter = r0;
    }

    private static final Unit defaultProxyActivityStarter$lambda$4(Intent r1) {
        Intrinsics.checkNotNullParameter(r1, MemorySourceLinkType.INTENT);
        i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        r0.getApplication().startActivity(r1);
        return Unit.INSTANCE;
    }

    @Override // com.obric.assistant.interaction.api.service.IActivityResultHelperApi
    public void startActivityForResult(ActivityProxyListener r8) {
        Intrinsics.checkNotNullParameter(r8, "listener");
        finishActivitiesExceptChatWindow();
        ProxyRequest r4 = proxyRequestStore.install(r8);
        i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        Intent r9 = new Intent(r0.getApplication(), ActivityResultProxyActivity.class);
        r9.addFlags(268435456);
        r9.addFlags(134217728);
        r9.addFlags(32768);
        r9.putExtra(ActivityProxyRequestStoreKt.EXTRA_PROXY_REQUEST_TOKEN, r4.getToken());
        r9.putExtra("is_pop_window_when_finish", true);
        r9.putExtra("obric_allow_show_when_locked", true);
        proxyActivityStarter.invoke(r9);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        proxyRequestStore.clearIfCurrent(r4.getToken(), r4, "start_activity_throw", null);
        FLogger.a.e(TAG, "start ActivityResultProxyActivity failed", th);
        throw th;
    }

    @Override // com.obric.assistant.interaction.api.service.IActivityResultHelperApi
    public void startActivityForResult(Intent r4, ActivityResultCallback r5) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r5, "callback");
        finishActivitiesExceptChatWindow();
        String r0 = UUID.randomUUID().toString();
        callbackMap.put(r0, r5);
        i r1 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r1);
        Intent r6 = new Intent(r1.getApplication(), ActivityResultHelperActivity.class);
        r6.putExtra(ActivityResultHelperActivity.KEY_INTENT, r4);
        r6.putExtra(ActivityResultHelperActivity.KEY_REQUEST_ID, r0);
        r6.putExtra("is_pop_window_when_finish", true);
        r6.putExtra("obric_allow_show_when_locked", true);
        r6.addFlags(268435456);
        r6.addFlags(134217728);
        r6.addFlags(32768);
        i r7 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r7);
        r7.getApplication().startActivity(r6);
    }
}
