package xe;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationContextStore;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    public static final WeakHashMap<Activity, Bundle> a = null;
    public static final a b = null;

    public a() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    static {
        b = new a();
        a = new WeakHashMap();
    }

    public static Bundle a(FragmentActivity r1) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        WeakHashMap<Activity, Bundle> r0 = a;
        monitor-enter(r0);
        Bundle r10 = r0.get(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        ConversationContextStore.b.g(r10);
        WeakHashMap<Activity, Bundle> r0 = a;
        monitor-enter(r0);
        Bundle r11 = r0.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        WeakHashMap<Activity, Bundle> r0 = a;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.containsKey(r10) == true) goto L7;
        r0.put(r10, r11);     // Catch: Throwable -> L10
    L7:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        WeakHashMap<Activity, Bundle> r0 = a;
        monitor-enter(r0);
        r0.put(r10, r11);     // Catch: Throwable -> L7
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "outState");
        ConversationContextStore r0 = ConversationContextStore.b;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L21
        ConversationContextStore.a r1 = ConversationContextStore.b(r10);     // Catch: Throwable -> L21
        if (r1 == null) goto L8;
        String r12 = r1.b.a;     // Catch: Throwable -> L21
    L9:
        monitor-exit(r0);
        if (r12 == null) goto L26;
        r11.putString(ConversationConstants.KEY_CONVERSATION_CID, r12);
        String r13 = r0.e(r10);
        if (r13 == null) goto L14;
        r11.putString(ConversationConstants.KEY_CONVERSATION_ORIGIN_MSG_ID, r13);
    L14:
        String r14 = r0.d(r10);
        if (r14 == null) goto L17;
        r11.putString(ConversationConstants.KEY_CONVERSATION_ORIGIN_BCM_ID, r14);
    L17:
        Boolean r15 = r0.c(r10);
        if (r15 == null) goto L27;
        r11.putBoolean(ConversationConstants.KEY_FIRST_MSG, r15.booleanValue());
        return;
    L27:
        return;
    L26:
        return;
    L8:
        r12 = null;
    L21:
        th = move-exception;
        throw th;
    }
}
