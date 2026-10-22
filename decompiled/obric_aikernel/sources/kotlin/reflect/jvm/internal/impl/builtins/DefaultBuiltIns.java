package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final Companion Companion = null;
    private static final DefaultBuiltIns Instance = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final DefaultBuiltIns getInstance() {
            return DefaultBuiltIns.access$getInstance$cp();
        }
    }

    static {
        DefaultConstructorMarker r10 = null;
        Companion = new Companion(r10);
        Instance = new DefaultBuiltIns(false, 1, r10);
    }

    public DefaultBuiltIns() {
        this(false, 1, null);
    }

    public DefaultBuiltIns(boolean r10) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (r10 == false) goto L6;
        createBuiltInsModule(false);
        return;
    }

    public /* synthetic */ DefaultBuiltIns(boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = true;
    L5:
        this(r10);
    }

    public static final /* synthetic */ DefaultBuiltIns access$getInstance$cp() {
        return Instance;
    }
}
