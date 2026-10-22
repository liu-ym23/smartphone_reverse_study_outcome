package y5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements x5.a {
    public static final /* synthetic */ int d = 0;
    public final AppletPopupSchemaParam a;
    public final View b;
    public final Integer[] c;

    public static final class a {
        public static void b(View r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            ViewGroup.LayoutParams r1 = null;
            if ((r10 instanceof ViewGroup) == false) goto L5;
            ViewGroup r0 = (ViewGroup) r10;
        L6:
            if (r0 == null) goto L9;
            r1 = r0.getLayoutParams();
        L9:
            if ((r1 instanceof FrameLayout.LayoutParams) == false) goto L12;
            ((FrameLayout.LayoutParams) r1).gravity = r11;
        L17:
            r10.requestLayout();
            return;
        L12:
            if ((r1 instanceof CoordinatorLayout.LayoutParams) == false) goto L15;
            ((CoordinatorLayout.LayoutParams) r1).gravity = r11;
            goto L17
        L15:
            if ((r1 instanceof LinearLayout.LayoutParams) == false) goto L17;
            ((LinearLayout.LayoutParams) r1).gravity = r11;
            goto L17
        L5:
            r0 = null;
            goto L6
        }

        public static int a(AppletPopupSchemaParam r11, View r12, Integer[] r13) {
            Intrinsics.checkNotNullParameter(r11, "params");
            Intrinsics.checkNotNullParameter(r12, "view");
            Intrinsics.checkNotNullParameter(r13, "margin");
            String r14 = r11.getRealGravity(r12.getContext());
            switch(r14.hashCode()) {
                case -1383228885: goto L25;
                case -1364013995: goto L22;
                case 100571: goto L18;
                case 3317767: goto L14;
                case 108511772: goto L10;
                case 109757538: goto L6;
                default: goto L96;
            };
        L6:
            if (r14.equals("start") == false) goto L96;
            return 8388611;
        L10:
            if (r14.equals("right") == false) goto L96;
            return 5;
        L14:
            if (r14.equals("left") == false) goto L96;
            return 3;
        L18:
            if (r14.equals("end") == false) goto L96;
            return 8388613;
        L22:
            if (r14.equals("center") == false) goto L96;
            return 17;
        L25:
            if (r14.equals("bottom") == false) goto L96;
            return 81;
        L96:
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L31
            Object r1 = Result.constructor-impl(Integer.valueOf(r13[0].intValue()));     // Catch: Throwable -> L31
        L34:
            if (Result.isFailure-impl(r1) == false) goto L36;
            r1 = 0;
        L36:
            int r10 = ((Number) r1).intValue();
            Object r15 = Result.constructor-impl(Integer.valueOf(r13[1].intValue()));     // Catch: Throwable -> L39
        L42:
            if (Result.isFailure-impl(r15) == false) goto L44;
            r15 = 0;
        L44:
            int r16 = ((Number) r15).intValue();
            Object r17 = Result.constructor-impl(Integer.valueOf(r13[2].intValue()));     // Catch: Throwable -> L47
        L50:
            if (Result.isFailure-impl(r17) == false) goto L52;
            r17 = 0;
        L52:
            int r18 = ((Number) r17).intValue();
            Object r19 = Result.constructor-impl(Integer.valueOf(r13[3].intValue()));     // Catch: Throwable -> L55
        L58:
            if (Result.isFailure-impl(r19) == false) goto L60;
            r19 = 0;
        L60:
            ((Number) r19).intValue();
            Object r20 = Result.constructor-impl(Integer.valueOf(r13[4].intValue()));     // Catch: Throwable -> L63
        L66:
            if (Result.isFailure-impl(r20) == false) goto L68;
            r20 = 0;
        L68:
            int r21 = ((Number) r20).intValue();
            Object r110 = Result.constructor-impl(Integer.valueOf(r13[5].intValue()));     // Catch: Throwable -> L71
        L74:
            if (Result.isFailure-impl(r110) == false) goto L76;
            r110 = 0;
        L76:
            int r111 = ((Number) r110).intValue();
            if (r16 <= 0) goto L79;
            int r112 = 48;
        L80:
            int r22 = z5.a.a;
            z5.a.a(r12.getContext());
            if (r21 <= 0) goto L84;
            int r113 = r112 | 8388611;
        L109:
            return r113;
        L84:
            if (r111 <= 0) goto L86;
            r113 = r112 | 8388613;
            goto L109
        L86:
            if (r10 <= 0) goto L88;
            r113 = r112 | 3;
            goto L109
        L88:
            if (r18 <= 0) goto L90;
            r113 = r112 | 5;
            goto L109
        L90:
            r113 = r112 | 17;
            goto L109
        L79:
            r112 = 80;
        L71:
            th = move-exception;
            Result.Companion r23 = Result.Companion;
            r110 = Result.constructor-impl(ResultKt.createFailure(th));
        L63:
            th = move-exception;
            Result.Companion r24 = Result.Companion;
            r20 = Result.constructor-impl(ResultKt.createFailure(th));
        L55:
            th = move-exception;
            Result.Companion r25 = Result.Companion;
            r19 = Result.constructor-impl(ResultKt.createFailure(th));
        L47:
            th = move-exception;
            Result.Companion r26 = Result.Companion;
            r17 = Result.constructor-impl(ResultKt.createFailure(th));
        L39:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
        L31:
            th = move-exception;
            Result.Companion r28 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L34
        }
    }

    static {
    }

    @Override // x5.a
    public final void invoke() {
        int r0 = a.a(this.a, this.b, this.c);
        a.b(this.b, r0);
    }

    public e(AppletPopupSchemaParam r10, View r11, Integer[] r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "margin");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
