package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements LifecycleEventObserver {
    private final DefaultLifecycleObserver defaultLifecycleObserver;
    private final LifecycleEventObserver lifecycleEventObserver;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[Lifecycle.Event.values().length];
            r10[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r10[Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r10[Lifecycle.Event.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r10[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r10[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r10[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r10[Lifecycle.Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public DefaultLifecycleObserverAdapter(DefaultLifecycleObserver r10, LifecycleEventObserver r11) {
        Intrinsics.checkNotNullParameter(r10, "defaultLifecycleObserver");
        this.defaultLifecycleObserver = r10;
        this.lifecycleEventObserver = r11;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_EVENT);
        switch(WhenMappings.$EnumSwitchMapping$0[r11.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L13;
        };
    L7:
        this.defaultLifecycleObserver.onDestroy(r10);
        goto L13
    L8:
        this.defaultLifecycleObserver.onStop(r10);
        goto L13
    L9:
        this.defaultLifecycleObserver.onPause(r10);
        goto L13
    L10:
        this.defaultLifecycleObserver.onResume(r10);
        goto L13
    L11:
        this.defaultLifecycleObserver.onStart(r10);
        goto L13
    L12:
        this.defaultLifecycleObserver.onCreate(r10);
    L13:
        LifecycleEventObserver r12 = this.lifecycleEventObserver;
        if (r12 == null) goto L17;
        r12.onStateChanged(r10, r11);
        return;
    L17:
        return;
    L6:
        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    }
}
