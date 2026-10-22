package ho8;

import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.im.bean.message.Message;
import go8.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public ho8.a a;
    public eo8.a b;
    public final Lazy c;

    public static final class a {
    }

    public static final class b implements g {
        public final /* synthetic */ c a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[AppletWidget.WidgetEvent.values().length];
                r0[AppletWidget.WidgetEvent.SCROLL_TO_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[AppletWidget.WidgetEvent.LAYOUT_FINISH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[AppletWidget.WidgetEvent.PAGE_UPDATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        @Override // go8.g
        public final void a() {
            c r0 = this.a;
            eo8.a r1 = r0.b;
            if (r1 == null) goto L11;
            ho8.a r2 = r0.a;
            if (r2 == null) goto L12;
            Message r3 = r2.c;
            if (r3 == null) goto L13;
            r1.r2(r3);
            return;
        L13:
            return;
        L12:
            return;
        }

        public b(c r1) {
            this.a = r1;
        }

        @Override // go8.g
        public final void b(AppletWidget.WidgetEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            int r3 = a.a[r2.ordinal()];
            if (r3 != 1) goto L5;
            eo8.a r4 = this.a.b;
            if (r4 == null) goto L20;
            r4.a();
            return;
        L20:
            return;
        L5:
            if (r3 != 2) goto L7;
        L11:
            eo8.a r5 = this.a.b;
            if (r5 == null) goto L18;
            r5.n2();
            return;
        L18:
            return;
        L7:
            if (r3 == 3) goto L11;
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public c() {
        this.c = LazyKt.lazy(new ho8.b(this));
    }
}
