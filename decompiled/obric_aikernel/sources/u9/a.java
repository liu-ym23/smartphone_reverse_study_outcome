package u9;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.obric.oui.lisitem.OCardListItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GradientDrawable f13140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FrameLayout f13144e;

    /* JADX INFO: renamed from: u9.a$a, reason: collision with other inner class name */
    public static final class C0301a {
        private C0301a() {
        }

        public /* synthetic */ C0301a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new C0301a(null);
    }

    public a(FrameLayout r10, boolean r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "cardContainer");
        this.f13144e = r10;
        this.f13140a = new GradientDrawable();
        this.f13141b = true;
        this.f13143d = -1;
        this.f13142c = r12;
        a(r11, r13);
    }

    private final void a(boolean r14, int r15) {
        if (this.f13141b == r14) goto L5;
    L7:
        this.f13141b = r14;
        this.f13143d = r15;
        int r16 = 0;
        if (r14 == false) goto L22;
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        float r17 = MathKt.roundToInt(TypedValue.applyDimension(1, 20, r10.getDisplayMetrics()));
        this.f13140a.setColor(this.f13142c);
        int r11 = this.f13143d;
        OCardListItem.c r12 = OCardListItem.V;
        if (r11 != r12.c()) goto L13;
        this.f13140a.setCornerRadii(new float[]{r17, r17, r17, r17, r17, r17, r17, r17});
    L21:
        FrameLayout r18 = this.f13144e;
        GradientDrawable r13 = this.f13140a;
    L23:
        r18.setBackground(r13);
        if (this.f13141b == false) goto L26;
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        int r110 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r19.getDisplayMetrics()));
    L27:
        int r20 = this.f13143d;
        OCardListItem.c r21 = OCardListItem.V;
        if (r20 != r21.c()) goto L37;
        FrameLayout r22 = this.f13144e;
        if (this.f13141b == false) goto L33;
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        r16 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r23.getDisplayMetrics()));
    L33:
        if (this.f13141b == false) goto L35;
        float r24 = 8;
    L42:
        Resources r25 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r25, "Resources.getSystem()");
        r22.setPadding(r110, r16, r110, MathKt.roundToInt(TypedValue.applyDimension(1, r24, r25.getDisplayMetrics())));
    L52:
        this.f13144e.requestLayout();
        return;
    L35:
        r24 = 2;
        goto L42
    L37:
        if (r20 != r21.d()) goto L44;
        r22 = this.f13144e;
        if (this.f13141b == false) goto L41;
        Resources r26 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r26, "Resources.getSystem()");
        r16 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r26.getDisplayMetrics()));
    L41:
        r24 = 2;
        goto L42
    L44:
        if (r20 != r21.b()) goto L47;
        FrameLayout r111 = this.f13144e;
        float r27 = 2;
        Resources r28 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r28, "Resources.getSystem()");
        int r29 = MathKt.roundToInt(TypedValue.applyDimension(1, r27, r28.getDisplayMetrics()));
        Resources r30 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r30, "Resources.getSystem()");
        r111.setPadding(r110, r29, r110, MathKt.roundToInt(TypedValue.applyDimension(1, r27, r30.getDisplayMetrics())));
        goto L52
    L47:
        if (r20 != r21.a()) goto L52;
        FrameLayout r112 = this.f13144e;
        float r31 = 2;
        Resources r32 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r32, "Resources.getSystem()");
        int r33 = MathKt.roundToInt(TypedValue.applyDimension(1, r31, r32.getDisplayMetrics()));
        if (this.f13141b == false) goto L51;
        r31 = 8;
    L51:
        Resources r34 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r34, "Resources.getSystem()");
        r112.setPadding(r110, r33, r110, MathKt.roundToInt(TypedValue.applyDimension(1, r31, r34.getDisplayMetrics())));
        goto L52
    L26:
        r110 = 0;
        goto L27
    L13:
        if (r11 != r12.d()) goto L16;
        this.f13140a.setCornerRadii(new float[]{r17, r17, r17, r17, 0.0f, 0.0f, 0.0f, 0.0f});
        goto L21
    L16:
        if (r11 != r12.b()) goto L19;
        this.f13140a.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        goto L21
    L19:
        if (r11 != r12.a()) goto L21;
        this.f13140a.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r17, r17, r17, r17});
        goto L21
    L22:
        r18 = this.f13144e;
        r13 = null;
        goto L23
    L5:
        if (this.f13143d != r15) goto L7;
    }

    public final void b(int r10) {
        this.f13142c = r10;
        a(this.f13141b, this.f13143d);
    }

    public final void c(int r10) {
        a(this.f13141b, r10);
    }

    public final void d(boolean r10) {
        a(r10, this.f13143d);
    }
}
