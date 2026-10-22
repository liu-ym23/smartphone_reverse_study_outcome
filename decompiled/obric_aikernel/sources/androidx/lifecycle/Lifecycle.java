package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycle {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private AtomicReference<Object> internalScopeRef;

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

        public static final class Companion {

            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                static {
                    int[] r10 = new int[State.values().length];
                    r10[State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
                L15:
                    r10[State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
                L23:
                    r10[State.RESUMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
                L17:
                    r10[State.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
                L19:
                    r10[State.INITIALIZED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
                L8:
                    $EnumSwitchMapping$0 = r10;
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            @JvmStatic
            public final Event downFrom(State r10) {
                Intrinsics.checkNotNullParameter(r10, "state");
                int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
                if (r11 == 1) goto L12;
                if (r11 == 2) goto L15;
                if (r11 == 3) goto L14;
                return null;
            L14:
                return Event.ON_PAUSE;
            L15:
                return Event.ON_STOP;
            L12:
                return Event.ON_DESTROY;
            }

            @JvmStatic
            public final Event downTo(State r10) {
                Intrinsics.checkNotNullParameter(r10, "state");
                int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
                if (r11 == 1) goto L12;
                if (r11 == 2) goto L15;
                if (r11 == 4) goto L14;
                return null;
            L14:
                return Event.ON_DESTROY;
            L15:
                return Event.ON_PAUSE;
            L12:
                return Event.ON_STOP;
            }

            @JvmStatic
            public final Event upFrom(State r10) {
                Intrinsics.checkNotNullParameter(r10, "state");
                int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
                if (r11 == 1) goto L12;
                if (r11 == 2) goto L15;
                if (r11 == 5) goto L14;
                return null;
            L14:
                return Event.ON_CREATE;
            L15:
                return Event.ON_RESUME;
            L12:
                return Event.ON_START;
            }

            @JvmStatic
            public final Event upTo(State r10) {
                Intrinsics.checkNotNullParameter(r10, "state");
                int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
                if (r11 == 1) goto L12;
                if (r11 == 2) goto L15;
                if (r11 == 3) goto L14;
                return null;
            L14:
                return Event.ON_RESUME;
            L15:
                return Event.ON_START;
            L12:
                return Event.ON_CREATE;
            }
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r10 = new int[Event.values().length];
                r10[Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r10[Event.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r10[Event.ON_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r10[Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r10[Event.ON_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r10[Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r10[Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                $EnumSwitchMapping$0 = r10;
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

        private Event(String r10, int r11) {
            super(r10, r11);
        }

        @JvmStatic
        public static final Event downFrom(State r10) {
            return Companion.downFrom(r10);
        }

        @JvmStatic
        public static final Event downTo(State r10) {
            return Companion.downTo(r10);
        }

        @JvmStatic
        public static final Event upFrom(State r10) {
            return Companion.upFrom(r10);
        }

        @JvmStatic
        public static final Event upTo(State r10) {
            return Companion.upTo(r10);
        }

        public static Event valueOf(String r10) {
            return (Event) Enum.valueOf(Event.class, r10);
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

        private State(String r10, int r11) {
            super(r10, r11);
        }

        public static State valueOf(String r10) {
            return (State) Enum.valueOf(State.class, r10);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public final boolean isAtLeast(State r10) {
            Intrinsics.checkNotNullParameter(r10, "state");
            if (compareTo(r10) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public Lifecycle() {
        this.internalScopeRef = new AtomicReference();
    }

    @MainThread
    public abstract void addObserver(LifecycleObserver r10);

    @MainThread
    public abstract State getCurrentState();

    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    @MainThread
    public abstract void removeObserver(LifecycleObserver r10);

    public final void setInternalScopeRef(AtomicReference<Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.internalScopeRef = r10;
    }
}
