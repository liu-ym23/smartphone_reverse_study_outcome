package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class CreationExtras {
    private final Map<Key<?>, Object> map;

    public static final class Empty extends CreationExtras {
        public static final Empty INSTANCE = null;

        static {
            INSTANCE = new Empty();
        }

        private Empty() {
        }

        @Override // androidx.lifecycle.viewmodel.CreationExtras
        public <T> T get(Key<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "key");
            return null;
        }
    }

    public interface Key<T> {
    }

    public CreationExtras() {
        this.map = new LinkedHashMap();
    }

    public abstract <T> T get(Key<T> r10);

    public final Map<Key<?>, Object> getMap$lifecycle_viewmodel_release() {
        return this.map;
    }
}
