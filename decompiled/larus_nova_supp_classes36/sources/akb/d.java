package akb;

import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.maintab.export.TabAppInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class d {

    public static final class a {
        public final Event a;
        public final d b;
        public String c;

        public final void a() {
            String r0 = this.c;
            if (r0 != null) goto L5;
            return;
        L5:
            this.b.getClass();
            Intrinsics.checkNotNullParameter(r0, TabAppInfo.IMAGE_JSON_KEY);
            AppreciableKit.Companion.getInstance().end(r0);
        }

        public final void c() {
            d r0 = this.b;
            Event r4 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "event");
            Intrinsics.checkNotNullParameter(r4, "event");
            this.c = AppreciableKit.Companion.getInstance().start(r0.a(), r0.b(), r4, null, true, null, null, null, null);
        }

        public a(Event r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Intrinsics.checkNotNullParameter(r3, "ugAppreciable");
            this.a = r2;
            this.b = r3;
        }

        public final void b(int r17, String r18) {
            d r1 = this.b;
            Event r5 = this.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r5, "event");
            ErrorType r6 = ErrorType.Network;
            ErrorLevel r7 = ErrorLevel.Exception;
            Boolean r12 = Boolean.TRUE;
            Intrinsics.checkNotNullParameter(r6, "errorType");
            Intrinsics.checkNotNullParameter(r7, "errorLevel");
            ErrorParams r2 = new ErrorParams(r1.a(), r1.b(), r5, r6, r7, r17, null, null, r18, r12, null, null, null);
            AppreciableKit.Companion.getInstance().error(r2);
        }
    }

    public d() {
    }

    public abstract Biz a();

    public abstract Scene b();
}
