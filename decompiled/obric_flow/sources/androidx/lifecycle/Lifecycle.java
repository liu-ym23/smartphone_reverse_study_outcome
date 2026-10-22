package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'R\u0014\u0010\u0003\u001a\u00020\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "", "()V", "currentState", "Landroidx/lifecycle/Lifecycle$State;", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "internalScopeRef", "Ljava/util/concurrent/atomic/AtomicReference;", "getInternalScopeRef", "()Ljava/util/concurrent/atomic/AtomicReference;", "setInternalScopeRef", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "Event", "State", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Lifecycle {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private AtomicReference<Object> internalScopeRef;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/Lifecycle$Event;", "", "(Ljava/lang/String;I)V", "targetState", "Landroidx/lifecycle/Lifecycle$State;", "getTargetState", "()Landroidx/lifecycle/Lifecycle$State;", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "Companion", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Companion Companion = null;
        public static final Event ON_ANY = null;
        public static final Event ON_CREATE = null;
        public static final Event ON_DESTROY = null;
        public static final Event ON_PAUSE = null;
        public static final Event ON_RESUME = null;
        public static final Event ON_START = null;
        public static final Event ON_STOP = null;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Landroidx/lifecycle/Lifecycle$Event$Companion;", "", "()V", "downFrom", "Landroidx/lifecycle/Lifecycle$Event;", "state", "Landroidx/lifecycle/Lifecycle$State;", "downTo", "upFrom", "upTo", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                static {
                    int[] r5 = new int[State.values().length];
                    r5[State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
                L15:
                    r5[State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
                L23:
                    r5[State.RESUMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
                L17:
                    r5[State.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
                L19:
                    r5[State.INITIALIZED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
                L8:
                    $EnumSwitchMapping$0 = r5;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            @JvmStatic
            public final Event downFrom(State r5) {
                Intrinsics.checkNotNullParameter(r5, "state");
                int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L15;
                if (r10 == 3) goto L14;
                return null;
            L14:
                return Event.ON_PAUSE;
            L15:
                return Event.ON_STOP;
            L12:
                return Event.ON_DESTROY;
            }

            @JvmStatic
            public final Event downTo(State r5) {
                Intrinsics.checkNotNullParameter(r5, "state");
                int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L15;
                if (r10 == 4) goto L14;
                return null;
            L14:
                return Event.ON_DESTROY;
            L15:
                return Event.ON_PAUSE;
            L12:
                return Event.ON_STOP;
            }

            @JvmStatic
            public final Event upFrom(State r5) {
                Intrinsics.checkNotNullParameter(r5, "state");
                int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L15;
                if (r10 == 5) goto L14;
                return null;
            L14:
                return Event.ON_CREATE;
            L15:
                return Event.ON_RESUME;
            L12:
                return Event.ON_START;
            }

            @JvmStatic
            public final Event upTo(State r5) {
                Intrinsics.checkNotNullParameter(r5, "state");
                int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L15;
                if (r10 == 3) goto L14;
                return null;
            L14:
                return Event.ON_RESUME;
            L15:
                return Event.ON_START;
            L12:
                return Event.ON_CREATE;
            }

            private Companion() {
            }
        }

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[Event.values().length];
                r5[Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r5[Event.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r5[Event.ON_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r5[Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r5[Event.ON_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r5[Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r5[Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                $EnumSwitchMapping$0 = r5;
            }
        }

        private static final /* synthetic */ Event[] $values() {
            return new Event[]{ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY};
        }

        static {
            ON_CREATE = new Event("ON_CREATE", 0);
            ON_START = new Event("ON_START", 1);
            ON_RESUME = new Event("ON_RESUME", 2);
            ON_PAUSE = new Event("ON_PAUSE", 3);
            ON_STOP = new Event("ON_STOP", 4);
            ON_DESTROY = new Event("ON_DESTROY", 5);
            ON_ANY = new Event("ON_ANY", 6);
            $VALUES = $values();
            Companion = new Companion(null);
        }

        private Event(String r5, int r10) {
            super(r5, r10);
        }

        @JvmStatic
        public static final Event downFrom(State r5) {
            return Companion.downFrom(r5);
        }

        @JvmStatic
        public static final Event downTo(State r5) {
            return Companion.downTo(r5);
        }

        @JvmStatic
        public static final Event upFrom(State r5) {
            return Companion.upFrom(r5);
        }

        @JvmStatic
        public static final Event upTo(State r5) {
            return Companion.upTo(r5);
        }

        public static Event valueOf(String r5) {
            return (Event) Enum.valueOf(Event.class, r5);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        public final State getTargetState() {
            switch(WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1: goto L13;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L5;
            };
        L5:
            throw new IllegalArgumentException(this + " has no target state");
        L7:
            return State.DESTROYED;
        L9:
            return State.RESUMED;
        L11:
            return State.STARTED;
        L13:
            return State.CREATED;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/Lifecycle$State;", "", "(Ljava/lang/String;I)V", "isAtLeast", "", "state", "DESTROYED", "INITIALIZED", "CREATED", "STARTED", "RESUMED", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State INITIALIZED = null;
        public static final State RESUMED = null;
        public static final State STARTED = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{DESTROYED, INITIALIZED, CREATED, STARTED, RESUMED};
        }

        static {
            DESTROYED = new State("DESTROYED", 0);
            INITIALIZED = new State("INITIALIZED", 1);
            CREATED = new State("CREATED", 2);
            STARTED = new State("STARTED", 3);
            RESUMED = new State("RESUMED", 4);
            $VALUES = $values();
        }

        private State(String r5, int r10) {
            super(r5, r10);
        }

        public static State valueOf(String r5) {
            return (State) Enum.valueOf(State.class, r5);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public final boolean isAtLeast(State r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            if (compareTo(r5) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public Lifecycle() {
        this.internalScopeRef = new AtomicReference();
    }

    @MainThread
    public abstract void addObserver(LifecycleObserver r5);

    @MainThread
    public abstract State getCurrentState();

    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    @MainThread
    public abstract void removeObserver(LifecycleObserver r5);

    public final void setInternalScopeRef(AtomicReference<Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.internalScopeRef = r5;
    }
}
