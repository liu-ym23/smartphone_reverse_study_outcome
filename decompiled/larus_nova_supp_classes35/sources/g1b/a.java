package g1b;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.log.ILog$Internal$LogRequest;
import com.ss.android.lark.chameleonv2.lkapi.log.LogLevel;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {

    /* JADX INFO: renamed from: g1b.a$a, reason: collision with other inner class name */
    public static final class C0221a {
    }

    public final class b extends AbsChameleonHandler<ILog$Internal$LogRequest> {
        public final String a;

        /* JADX INFO: renamed from: g1b.a$b$a, reason: collision with other inner class name */
        public /* synthetic */ class C0222a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[LogLevel.values().length];
                r0[LogLevel.INFO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[LogLevel.WARN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[LogLevel.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public b() {
            this.a = LKAPIModules.Internal.Log.LogNoReturn.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(ILog$Internal$LogRequest r4, Callback r5) {
            ILog$Internal$LogRequest r6 = r4;
            Intrinsics.checkNotNullParameter(r6, "req");
            Intrinsics.checkNotNullParameter(r5, "callback");
            String r7 = "[" + r6.getLogModule() + "] " + r6.getMessage();
            int r8 = r6.getLevel();
            if (r8 != 3) goto L5;
            LogLevel r9 = LogLevel.INFO;
        L12:
            int r10 = C0222a.a[r9.ordinal()];
            if (r10 != 1) goto L15;
            j.e("LK_API_TAG_Log", r7);
            return;
        L15:
            if (r10 == 2) goto L20;
            if (r10 != 3) goto L19;
            j.b("LK_API_TAG_Log", r7);
            return;
        L19:
            throw new NoWhenBranchMatchedException();
        L20:
            j.f("LK_API_TAG_Log", r7);
            return;
        L5:
            if (r8 != 4) goto L7;
            r9 = LogLevel.WARN;
            goto L12
        L7:
            if (r8 == 5) goto L9;
            r9 = LogLevel.INFO;
            goto L12
        L9:
            r9 = LogLevel.ERROR;
            goto L12
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    public a() {
    }
}
