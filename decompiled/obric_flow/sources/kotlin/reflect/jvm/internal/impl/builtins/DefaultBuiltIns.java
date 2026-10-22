package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final Companion Companion = null;
    private static final DefaultBuiltIns Instance = null;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final DefaultBuiltIns getInstance() {
            return DefaultBuiltIns.access$getInstance$cp();
        }

        private Companion() {
        }
    }

    static {
        DefaultConstructorMarker r5 = null;
        Companion = new Companion(r5);
        Instance = new DefaultBuiltIns(false, 1, r5);
    }

    public DefaultBuiltIns() {
        boolean r5 = false;
        this(r5, 1, null);
    }

    public static final /* synthetic */ DefaultBuiltIns access$getInstance$cp() {
        return Instance;
    }

    public DefaultBuiltIns(boolean r5) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (r5 == false) goto L6;
        createBuiltInsModule(false);
        return;
    }

    public /* synthetic */ DefaultBuiltIns(boolean r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = true;
    L5:
        this(r5);
    }
}
