package mwb;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSummaryLoadingTextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.textselection.MmSelectableSummaryTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l {
    public static final /* synthetic */ int p = 0;
    public final View a;
    public final FrameLayout b;
    public final NestedScrollView c;
    public final MmSelectableSummaryTextView d;
    public final MmSummaryLoadingTextView e;
    public final UDShadowLayout f;
    public final AppCompatImageView g;
    public final ConstraintLayout h;
    public final View i;
    public final FrameLayout j;
    public final FrameLayout k;
    public final UDShadowLayout l;
    public final LinearLayout m;
    public final AppCompatImageView n;
    public final AppCompatImageView o;

    public static final class a {
    }

    static {
    }

    public l(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131379574);
        if (r0 == null) goto L63;
        this.b = (FrameLayout) r0;
        NestedScrollView r1 = r3.findViewById(2131379581);
        if (r1 == null) goto L61;
        this.c = r1;
        View r2 = r3.findViewById(2131379578);
        if (r2 == null) goto L59;
        LinearLayout r4 = (LinearLayout) r2;
        Object r5 = r3.findViewById(2131379536);
        if (r5 == null) goto L57;
        this.d = (MmSelectableSummaryTextView) r5;
        Object r6 = r3.findViewById(2131379579);
        if (r6 == null) goto L55;
        this.e = (MmSummaryLoadingTextView) r6;
        UDShadowLayout r7 = r3.findViewById(2131363767);
        if (r7 == null) goto L53;
        this.f = r7;
        AppCompatImageView r8 = r3.findViewById(2131363768);
        if (r8 == null) goto L51;
        this.g = r8;
        ConstraintLayout r9 = r3.findViewById(2131379575);
        if (r9 == null) goto L49;
        this.h = r9;
        this.i = r3.findViewById(2131387717);
        View r10 = r3.findViewById(2131371561);
        if (r10 == null) goto L47;
        TextView r11 = (TextView) r10;
        View r12 = r3.findViewById(2131372618);
        if (r12 == null) goto L45;
        this.j = (FrameLayout) r12;
        View r13 = r3.findViewById(2131372619);
        if (r13 == null) goto L43;
        this.k = (FrameLayout) r13;
        UDShadowLayout r14 = r3.findViewById(2131387721);
        if (r14 == null) goto L41;
        this.l = r14;
        View r15 = r3.findViewById(2131387722);
        if (r15 == null) goto L39;
        this.m = (LinearLayout) r15;
        AppCompatImageView r16 = r3.findViewById(2131387835);
        if (r16 == null) goto L37;
        this.n = r16;
        AppCompatImageView r17 = r3.findViewById(2131387836);
        if (r17 == null) goto L35;
        this.o = r17;
        return;
    L35:
        throw new IllegalStateException("Required view not found, id=2131387836, type=AppCompatImageView");
    L37:
        throw new IllegalStateException("Required view not found, id=2131387835, type=AppCompatImageView");
    L39:
        throw new IllegalStateException("Required view not found, id=2131387722, type=".concat(LinearLayout.class.getSimpleName()));
    L41:
        throw new IllegalStateException("Required view not found, id=2131387721, type=UDShadowLayout");
    L43:
        throw new IllegalStateException("Required view not found, id=2131372619, type=".concat(FrameLayout.class.getSimpleName()));
    L45:
        throw new IllegalStateException("Required view not found, id=2131372618, type=".concat(FrameLayout.class.getSimpleName()));
    L47:
        throw new IllegalStateException("Required view not found, id=2131371561, type=".concat(TextView.class.getSimpleName()));
    L49:
        throw new IllegalStateException("Required view not found, id=2131379575, type=ConstraintLayout");
    L51:
        throw new IllegalStateException("Required view not found, id=2131363768, type=AppCompatImageView");
    L53:
        throw new IllegalStateException("Required view not found, id=2131363767, type=UDShadowLayout");
    L55:
        throw new IllegalStateException("Required view not found, id=2131379579, type=MmSummaryLoadingTextView");
    L57:
        throw new IllegalStateException("Required view not found, id=2131379536, type=MmSelectableSummaryTextView");
    L59:
        throw new IllegalStateException("Required view not found, id=2131379578, type=".concat(LinearLayout.class.getSimpleName()));
    L61:
        throw new IllegalStateException("Required view not found, id=2131379581, type=NestedScrollView");
    L63:
        throw new IllegalStateException("Required view not found, id=2131379574, type=".concat(FrameLayout.class.getSimpleName()));
    }
}
