package xga;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ViewTreeObserver c;
        public final /* synthetic */ Function1<View, Boolean> d;
        public final /* synthetic */ View e;
        public final /* synthetic */ Ref.BooleanRef f;
        public final /* synthetic */ Ref.IntRef g;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            AssistantStartupTelemetry r1 = AssistantStartupTelemetry.a;     // Catch: Exception -> L23
            if (Intrinsics.areEqual(r1.i(this.a), this.b) == true) goto L10;
            int r2 = b.a;     // Catch: Exception -> L23
            ViewTreeObserver r3 = this.c;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r3);     // Catch: Exception -> L23
            if (r3.isAlive() == false) goto L8;
            r3.removeOnPreDrawListener(this);     // Catch: Exception -> L23
        L8:
            return true;
        L10:
            if (((Boolean) this.d.invoke(this.e)).booleanValue() == true) goto L12;
            return true;
        L12:
            Ref.BooleanRef r4 = this.f;     // Catch: Exception -> L23
            if (r4.element == true) goto L15;
            r4.element = true;     // Catch: Exception -> L23
            IAssistantStartupTelemetry.a.b(r1, this.b);     // Catch: Exception -> L23
        L15:
            this.g.element++;     // Catch: Exception -> L23
            if (IAssistantStartupTelemetry.a.c(r1, this.b, this.a) == false) goto L18;
        L19:
            int r5 = b.a;     // Catch: Exception -> L23
            ViewTreeObserver r6 = this.c;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r6);     // Catch: Exception -> L23
            if (r6.isAlive() == false) goto L22;
            r6.removeOnPreDrawListener(this);     // Catch: Exception -> L23
        L22:
            return true;
        L18:
            if (this.g.element < 3) goto L22;
        L23:
            e = move-exception;
            int r7 = b.a;
            ViewTreeObserver r8 = this.c;
            Intrinsics.checkNotNull(r8);
            if (r8.isAlive() == false) goto L27;
            r8.removeOnPreDrawListener(this);
        L27:
            FLogger.a.w("AssistantStartupReadyView", "startup ready pre-draw callback failed, milestone=" + this.a, e);
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r1, String r2, ViewTreeObserver r3, Function1<? super View, Boolean> r4, View r5, Ref.BooleanRef r6, Ref.IntRef r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    static {
    }

    public static boolean a(View r11, String r12, String r13, Function1 r14) {
        Intrinsics.checkNotNullParameter(r13, "milestone");
        Intrinsics.checkNotNullParameter(r14, "isReady");
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r12 != null) goto L7;
    L18:
        return false;
    L7:
        if ((!StringsKt.isBlank(r12)) == true) goto L10;
        r12 = null;
    L10:
        String r5 = r12;
        if (r5 == null) goto L18;
        final ViewTreeObserver r15 = r11.getViewTreeObserver();
        if (r15.isAlive() == true) goto L16;
        return false;
    L16:
        final a r0 = new a(r13, r5, r15, r14, r11, new Ref.BooleanRef(), new Ref.IntRef());
        r15.addOnPreDrawListener(r0);
        r11.postInvalidateOnAnimation();
        r11.postDelayed(new xga.a(r15, r0), 15000);
        return true;
    }
}
