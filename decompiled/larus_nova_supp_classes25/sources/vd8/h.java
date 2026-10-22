package vd8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerTransitionType;
import com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final h a = null;

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
            pc8.e r3 = com.larus.bmhome.chat.bubble.floating.runtime.k.b(r2);
            if (r3 == null) goto L6;
            h.a.getClass();
            h.a(r3);
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
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[BubbleBannerState.values().length];
            r0[BubbleBannerState.RESOLVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[BubbleBannerState.ENTERING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L29:
            r0[BubbleBannerState.VISIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L23:
            r0[BubbleBannerState.EXITING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[BubbleBannerTransitionType.values().length];
            r1[BubbleBannerTransitionType.ENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[BubbleBannerTransitionType.EXIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L11:
            b = r1;
        }
    }

    static {
        a = new h();
    }

    public h() {
    }

    public static void a(pc8.e r3) {
        pc8.i r0 = r3.j;
        if (r0 != null) goto L5;
    L10:
        r0 = null;
    L12:
        if (r0 != null) goto L17;
        int r1 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        String r4 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "promptId");
        IBubbleBannerRuntimeService r2 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r2 == null) goto L21;
        r2.b(r4);
        return;
    L21:
        return;
    L17:
        int r5 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        String r6 = r3.a;
        String r7 = r0.a;
        BubbleBannerRenderPart r8 = BubbleBannerRenderPart.SPACER;
        Intrinsics.checkNotNullParameter(r6, "promptId");
        Intrinsics.checkNotNullParameter(r7, "transitionId");
        Intrinsics.checkNotNullParameter(r8, "part");
        IBubbleBannerRuntimeService r9 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r9 == null) goto L22;
        r9.k(r6, r7, r8);
        return;
    L22:
        return;
    L5:
        if (r0.getType() != BubbleBannerTransitionType.EXIT) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L10;
    L7:
        r10 = false;
        goto L8
    }
}
