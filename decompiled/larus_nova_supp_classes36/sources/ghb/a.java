package ghb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.shared.page.binder2.ConstraintLayoutInfoKt;
import com.ss.android.lark.feed.shared.page.binder2.n;
import com.ss.android.lark.image.impl.preload.ImagePreloadConfig;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements n {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;

    /* JADX INFO: renamed from: ghb.a$a, reason: collision with other inner class name */
    public static final class C0268a {
    }

    public a() {
    }

    public final void a() {
    }

    public final void c() {
    }

    static {
        a = UIHelper.dp2px(12.0f);
        b = UIHelper.dp2px(3.0f);
        c = UIHelper.dp2px(16.0f);
        d = UIHelper.dp2px(5.5f);
        e = UIHelper.dp2px(8.0f);
        f = UIHelper.dp2px(16.0f);
        g = UIHelper.dp2px(1.0f);
    }

    public final void b(Context r28, ConstraintLayout r29, com.ss.android.lark.feed.export.feedcard.a r30) {
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "contentView");
        Intrinsics.checkNotNullParameter(r30, "componentInfo");
        b.g(r28, 60);
        ViewGroup.LayoutParams r3 = r29.getLayoutParams();
        if (r3 != null) goto L5;
        r3 = new ViewGroup.LayoutParams(-1, UIHelper.dp2px(80.0f));
    L5:
        r3.height = UIHelper.dp2px(80.0f);
        r29.setLayoutParams(r3);
        r29.setPadding(0, UIHelper.dp2px(8.0f), 0, 0);
        int r4 = UIHelper.dp2px(48.0f) / 2;
        int r6 = e;
        int r5 = r4 + r6;
        View r7 = new Guideline(r28);
        if (r7.getId() != (-1)) goto L8;
        r7.setId(2131372231);
    L8:
        ViewGroup.LayoutParams r0 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ConstraintLayout.LayoutParams) r0).orientation = 0;
        ((ConstraintLayout.LayoutParams) r0).guideBegin = r5;
        r29.addView(r7, r0);
        FeedCardComponent r1 = r30.b;
        if (r1 == null) goto L60;
        View r8 = r1.c();
        if (r8.getId() != (-1)) goto L13;
        r8.setId(View.generateViewId());
    L13:
        ViewGroup.MarginLayoutParams r2 = r1.b();
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(r2.width, r2.height);
        ((ViewGroup.MarginLayoutParams) r9).leftMargin = r2.leftMargin;
        ((ViewGroup.MarginLayoutParams) r9).topMargin = r2.topMargin;
        ((ViewGroup.MarginLayoutParams) r9).rightMargin = r2.rightMargin;
        ((ViewGroup.MarginLayoutParams) r9).bottomMargin = r2.bottomMargin;
        r9.topToTop = r7.getId();
        r9.bottomToBottom = r7.getId();
        r9.startToStart = 0;
        Unit r10 = Unit.INSTANCE;
        r29.addView(r8, r9);
        FeedCardComponent r11 = r30.c;
        if (r11 == null) goto L16;
        ViewGroup.MarginLayoutParams r12 = r11.b();
        View r13 = r11.c();
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(r12.width, r12.height);
        r14.startToEnd = r8.getId();
        r14.endToStart = 2131388894;
        r14.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r14).leftMargin = c;
        ((ViewGroup.MarginLayoutParams) r14).topMargin = r6 / 2;
        r29.addView(r13, r14);
    L16:
        View r15 = ConstraintLayoutInfoKt.a(r29, r30.e, new com.ss.android.lark.feed.shared.page.binder2.a(0, 0, 2131388894, r7.getId(), 0, 0, 0, d, 115));
        if (r15 != null) goto L19;
        r15 = null;
    L22:
        FeedCardComponent[] r16 = r30.d;
        int r17 = r8.getId();
        if (r15 == null) goto L25;
        int r18 = r15.getId();
    L26:
        int r19 = r7.getId();
        int r110 = a;
        int r111 = b;
        int r20 = f;
        View r21 = ConstraintLayoutInfoKt.a(r29, r16, new com.ss.android.lark.feed.shared.page.binder2.a(r17, 0, r18, r19, r20, 0, r110, r111, 34));
        if (r21 != null) goto L29;
    L31:
        FeedCardComponent[] r22 = r30.f;
        int r112 = r8.getId();
        int r113 = r7.getId();
        int r23 = g;
        View r24 = ConstraintLayoutInfoKt.a(r29, r22, new com.ss.android.lark.feed.shared.page.binder2.a(r112, r113, 2131388894, 0, r20, r23, 0, 0, ImagePreloadConfig.DEFAULT_PRELOAD_CACHE_COUNT));
        if (r24 != null) goto L34;
        r24 = null;
    L37:
        FeedCardComponent[] r25 = r30.g;
        if (r24 == null) goto L40;
        int r26 = r24.getId();
    L41:
        int r114 = r8.getId();
        View r27 = ConstraintLayoutInfoKt.a(r29, r25, new com.ss.android.lark.feed.shared.page.binder2.a(r114, r26, 2131388894, 0, r20, r23, 0, 0, ImagePreloadConfig.DEFAULT_PRELOAD_CACHE_COUNT));
        if (r27 != null) goto L44;
        r27 = null;
    L47:
        FeedCardComponent[] r31 = r30.h;
        if (r27 == null) goto L51;
        int r32 = r27.getId();
    L50:
        int r33 = r32;
        View r34 = ConstraintLayoutInfoKt.a(r29, r31, new com.ss.android.lark.feed.shared.page.binder2.a(r8.getId(), r33, 2131388894, 0, c, 0, 0, 0, 232));
        if (r34 != null) goto L57;
        return;
    L57:
        if (r34.getId() != (-1)) goto L62;
        r34.setId(View.generateViewId());
        return;
    L62:
        return;
    L51:
        if (r24 == null) goto L53;
        r32 = r24.getId();
        goto L50
    L53:
        r32 = r7.getId();
        goto L50
    L44:
        if (r27.getId() != (-1)) goto L47;
        r27.setId(View.generateViewId());
        goto L47
    L40:
        r26 = r7.getId();
        goto L41
    L34:
        if (r24.getId() != (-1)) goto L37;
        r24.setId(View.generateViewId());
        goto L37
    L29:
        if (r21.getId() != (-1)) goto L31;
        r21.setId(View.generateViewId());
        goto L31
    L25:
        r18 = -1;
        goto L26
    L19:
        if (r15.getId() != (-1)) goto L22;
        r15.setId(View.generateViewId());
        goto L22
    }
}
