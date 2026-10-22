package androidx.lifecycle;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/lifecycle/DefaultLifecycleObserverAdapter;", "Landroidx/lifecycle/LifecycleEventObserver;", "defaultLifecycleObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "lifecycleEventObserver", "<init>", "(Landroidx/lifecycle/DefaultLifecycleObserver;Landroidx/lifecycle/LifecycleEventObserver;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", EventVerify.TYPE_EVENT_V1, "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class DefaultLifecycleObserverAdapter implements LifecycleEventObserver {
    private final DefaultLifecycleObserver defaultLifecycleObserver;
    private final LifecycleEventObserver lifecycleEventObserver;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[Lifecycle.Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DefaultLifecycleObserverAdapter(DefaultLifecycleObserver r2, LifecycleEventObserver r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultLifecycleObserver");
        this.defaultLifecycleObserver = r2;
        this.lifecycleEventObserver = r3;
    }

    public void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, EventVerify.TYPE_EVENT_V1);
        switch(WhenMappings.$EnumSwitchMapping$0[r4.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L5;
        };
    L8:
        this.defaultLifecycleObserver.onDestroy(r3);
    L14:
        LifecycleEventObserver r0 = this.lifecycleEventObserver;
        if (r0 == null) goto L18;
        r0.onStateChanged(r3, r4);
        return;
    L18:
        return;
    L9:
        this.defaultLifecycleObserver.onStop(r3);
        goto L14
    L10:
        this.defaultLifecycleObserver.onPause(r3);
        goto L14
    L11:
        this.defaultLifecycleObserver.onResume(r3);
        goto L14
    L12:
        this.defaultLifecycleObserver.onStart(r3);
        goto L14
    L13:
        this.defaultLifecycleObserver.onCreate(r3);
        goto L14
    L5:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    }
}
