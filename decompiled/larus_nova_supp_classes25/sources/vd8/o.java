package vd8;

import com.larus.bmhome.chat.bubble.floating.ReachSpacerState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    public static final class a implements com.larus.bmhome.chat.list.cell.spacer.i {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // com.larus.bmhome.chat.list.cell.spacer.i
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "spacerId");
            pc8.l r0 = pc8.k.a;
            pc8.l r1 = pc8.k.a;
            if (r1 == null) goto L6;
            r1.e(r2);
            return;
        }

        @Override // com.larus.bmhome.chat.list.cell.spacer.i
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "spacerId");
        }

        @Override // com.larus.bmhome.chat.list.cell.spacer.i
        public final void c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "spacerId");
        }

        @Override // com.larus.bmhome.chat.list.cell.spacer.i
        public final void d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "spacerId");
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReachSpacerState.values().length];
            r0[ReachSpacerState.WAITING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ReachSpacerState.ENTERING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ReachSpacerState.VISIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ReachSpacerState.EXITING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }
}
