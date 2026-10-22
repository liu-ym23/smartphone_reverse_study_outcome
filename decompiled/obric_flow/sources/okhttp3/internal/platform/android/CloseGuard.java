package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/platform/android/CloseGuard;", "", "getMethod", "Ljava/lang/reflect/Method;", "openMethod", "warnIfOpenMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "createAndOpen", "closer", "", "warnIfOpen", "", "closeGuardInstance", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CloseGuard {
    public static final Companion Companion = null;
    private final Method getMethod;
    private final Method openMethod;
    private final Method warnIfOpenMethod;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/platform/android/CloseGuard$Companion;", "", "()V", "get", "Lokhttp3/internal/platform/android/CloseGuard;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final CloseGuard get() {
            Method r5 = null;
            Class<?> r10 = Class.forName("dalvik.system.CloseGuard");     // Catch: Exception -> L5
            Method r11 = r10.getMethod("get", null);     // Catch: Exception -> L5
            Method r12 = r10.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L5
            Method r13 = r10.getMethod("warnIfOpen", null);     // Catch: Exception -> L5
            r5 = r11;
        L7:
            return new CloseGuard(r5, r12, r13);
        L5:
            r13 = null;
            r12 = null;
            goto L7
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CloseGuard(Method r5, Method r10, Method r11) {
        this.getMethod = r5;
        this.openMethod = r10;
        this.warnIfOpenMethod = r11;
    }

    public final Object createAndOpen(String r5) {
        Intrinsics.checkNotNullParameter(r5, "closer");
        Method r10 = this.getMethod;
        if (r10 != null) goto L8;
    L6:
        return null;
    L8:
        Object r11 = r10.invoke(null, null);     // Catch: Exception -> L7
        Method r12 = this.openMethod;     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L7
        r12.invoke(r11, new Object[]{r5});     // Catch: Exception -> L7
        return r11;
    }

    public final boolean warnIfOpen(Object r5) {
        if (r5 != null) goto L8;
    L5:
        return false;
    L8:
        Method r10 = this.warnIfOpenMethod;     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L7
        r10.invoke(r5, null);     // Catch: Exception -> L7
        return true;
    }
}
