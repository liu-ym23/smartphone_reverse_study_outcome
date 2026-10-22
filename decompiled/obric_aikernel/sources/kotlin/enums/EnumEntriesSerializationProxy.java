package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {
    private static final Companion Companion = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<E> f10199c;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public EnumEntriesSerializationProxy(E[] r10) {
        Intrinsics.checkNotNullParameter(r10, "entries");
        Class<E> r11 = (Class<E>) r10.getClass().getComponentType();
        Intrinsics.checkNotNull(r11);
        this.f10199c = r11;
    }

    private final Object readResolve() {
        E[] r10 = this.f10199c.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(r10, "c.enumConstants");
        return EnumEntriesKt.enumEntries(r10);
    }
}
