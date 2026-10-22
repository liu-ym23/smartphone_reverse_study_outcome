package o8;

import com.bytedance.env.api.AccessKeyType;
import com.bytedance.env.api.EnvManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static volatile Boolean c;
    public boolean a;
    public boolean b;

    public static final class a {
        public static Pair b() {
            if (c.c == null) goto L5;
        L20:
            Boolean r0 = c.c;
            Boolean r1 = Boolean.FALSE;
            if (Intrinsics.areEqual(r0, r1) == true) goto L23;
            EnvManager.Companion.getClass();
            AccessKeyType r10 = EnvManager.a.a().getGeckoConfig().a();
            boolean r11 = false;
            if (r10 != AccessKeyType.INHOUSE) goto L37;
            boolean r12 = true;
        L38:
            Boolean r13 = Boolean.valueOf(r12);
            if (r10 != AccessKeyType.BOE) goto L42;
            r11 = true;
        L42:
            return new Pair(r13, Boolean.valueOf(r11));
        L37:
            r12 = false;
            goto L38
        L23:
            if (com.bytedance.android.annie.ng.g.g == false) goto L28;
            if (com.bytedance.android.annie.ng.g.b().a.b == false) goto L28;
            return new Pair(r1, Boolean.TRUE);
        L28:
            if (com.bytedance.android.annie.ng.g.g == false) goto L33;
            if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L33;
            return new Pair(Boolean.TRUE, r1);
        L33:
            return new Pair(r1, r1);
        L5:
            monitor-enter(c.class);
        L17:
            th = move-exception;
            throw th;
        L7:
            if (c.c != null) goto L14;
            Boolean r14 = c.c;     // Catch: Throwable -> L17
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L11
            a("com.bytedance.env.api.GeckoConfig");     // Catch: Throwable -> L11
            Object r16 = Result.constructor-impl(a("com.bytedance.env.core.impl.EnvManagerApiImpl"));     // Catch: Throwable -> L11
        L13:
            c.c = Boolean.valueOf(Result.isSuccess-impl(r16));     // Catch: Throwable -> L17
            goto L14
        L11:
            th = move-exception;
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L17
            r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
        L14:
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L17
            monitor-exit(c.class);
            goto L20
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r10) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r11 = Class.forName(r10);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
        L7:
            return r11;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r10);
        L12:
            throw th;
        L34:
            Class<?> r12 = Class.forName(r10);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
        L16:
            return r12;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r10);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r10);
        }
    }

    static {
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        if (this.b == true) goto L11;
        r1 = 1237;
    L11:
        return r10 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "EnvInfo(isDebug=" + this.a + ", isBoe=" + this.b + ')';
    }

    public c(int r1) {
        this.a = true;
        this.b = false;
    }
}
