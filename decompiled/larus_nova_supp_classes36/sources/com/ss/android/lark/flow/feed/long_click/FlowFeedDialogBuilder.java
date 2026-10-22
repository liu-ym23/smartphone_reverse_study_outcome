package com.ss.android.lark.flow.feed.long_click;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.framework.utils.UIUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.page.utils.CanvasUtil;
import com.ss.android.lark.flow.feed.component.title.FlowTitleView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowFeedDialogBuilder extends UDBaseDialogBuilder<FlowFeedDialogBuilder> {
    public final View a;
    public final int b;
    public final int c;
    public final int d;
    public final Rect e;
    public Function0<Unit> f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnShowListener {
        public final /* synthetic */ FlowFeedDialogBuilder a;
        public final /* synthetic */ UDDialog b;

        public b(FlowFeedDialogBuilder r1, UDDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r4) {
            FlowFeedDialogBuilder r5 = this.a;
            UDDialog r0 = this.b;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r0, "dialog");
            Window r1 = r0.getWindow();
            if (r1 == null) goto L9;
            View r2 = FlowFeedDialogBuilder.a(r1);
            if (r2 == null) goto L10;
            com.ss.android.lark.flow.feed.long_click.b r3 = new com.ss.android.lark.flow.feed.long_click.b(r0);
            r5.a.addOnLayoutChangeListener(r3);
            r2.addOnAttachStateChangeListener(new com.ss.android.lark.flow.feed.long_click.a(r5, r3));
            return;
        L10:
            return;
        }
    }

    static {
    }

    public final UDDialog c() {
        final UDDialog r0 = super.build();
        this.f = new FlowFeedDialogBuilder$buildDialog$1(r0);
        Ref.BooleanRef r1 = new Ref.BooleanRef();
        Window r2 = r0.getWindow();
        if (r2 == null) goto L8;
        View r3 = a(r2);
        if (r3 == null) goto L8;
        r3.setOnTouchListener(new c(r1, this, r0));
    L8:
        if (((Boolean) this.j.getValue()).booleanValue() == true) goto L10;
        r0.setOnShowListener(new b(this, r0));
    L10:
        return r0;
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static FlowTitleView d(View r4) {
        if ((r4 instanceof FlowTitleView) == false) goto L7;
        return (FlowTitleView) r4;
    L7:
        if ((r4 instanceof ViewGroup) == true) goto L9;
        return null;
    L9:
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L15;
        FlowTitleView r3 = d(r5.getChildAt(r2));
        if (r3 != null) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return r3;
    L15:
        return null;
    }

    public static void e(View r7, Canvas r8) {
        if (com.ss.android.lark.feed.shared.fg.c.a.isEnable("lark.feed.dialog_redraw_avatar_view_opt") == false) goto L19;
        View r0 = r7.findViewById(2131381508);
        if (r0 != null) goto L7;
        return;
    L7:
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L10;
        ViewGroup r2 = (ViewGroup) r1;
    L11:
        if (r2 != null) goto L13;
        return;
    L13:
        int r3 = CanvasUtil.a;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r7, "rootView");
        Intrinsics.checkNotNullParameter(r2, "avatarContainer");
        Intrinsics.checkNotNullParameter(r7, "rootView");
        Intrinsics.checkNotNullParameter(r2, "targetView");
        int[] r4 = new int[2];
        r7.getLocationOnScreen(r4);
        int[] r9 = new int[2];
        r2.getLocationOnScreen(r9);
        float r5 = r9[0] - r4[0];
        float r10 = r9[1] - r4[1];
        RectF r6 = new RectF(r5, r10, r2.getWidth() + r5, r2.getHeight() + r10);
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r6, "rect");
        Paint r11 = new Paint(1);
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        r8.drawRect(r6, r11);
        float r12 = r6.left;
        float r13 = r6.top;
        int r14 = r8.save();
        r8.translate(r12, r13);
        CanvasUtil.a(r8, r2);     // Catch: Throwable -> L16
        r8.restoreToCount(r14);
        return;
    L16:
        th = move-exception;
        r8.restoreToCount(r14);
        throw th;
    L10:
        r2 = null;
        goto L11
    L19:
        CanvasUtil.e(r8, r7);
    }

    public static final boolean b(FlowFeedDialogBuilder r5, float r6, float r7) {
        int[] r0 = new int[2];
        ((View) r5.i.getValue()).getLocationOnScreen(r0);
        int r2 = r0[0];
        int r1 = r0[1];
        int r4 = ((View) r5.i.getValue()).getWidth() + r2;
        int r8 = ((View) r5.i.getValue()).getHeight() + r1;
        float r3 = r2;
        if (r6 <= r4) goto L5;
    L7:
        boolean r9 = false;
    L8:
        if (r9 == false) goto L16;
        float r10 = r1;
        if (r7 <= r8) goto L12;
    L14:
        boolean r11 = false;
    L15:
        if (r11 == false) goto L16;
        return false;
    L12:
        if (r10 > r7) goto L14;
        r11 = true;
    L16:
        return true;
    L5:
        if (r3 > r6) goto L7;
        r9 = true;
        goto L8
    }

    public FlowFeedDialogBuilder(View r14, final UIFeedCard r15, final ueb.a r16, final LinkedHashMap<FeedActionType, aeb.c> r17, final aeb.a r18, int r19) {
        Intrinsics.checkNotNullParameter(r14, "itemView");
        Intrinsics.checkNotNullParameter(r15, "data");
        Intrinsics.checkNotNullParameter(r16, "itemContainer");
        Intrinsics.checkNotNullParameter(r17, "feedActionMap");
        Intrinsics.checkNotNullParameter(r18, "actionStatusListener");
        super(r14.getContext());
        this.a = r14;
        this.b = r19;
        this.c = UIHelper.dp2px(30.0f);
        this.d = UIHelper.dp2px(7.0f);
        Rect r8 = new Rect();
        this.e = r8;
        LazyThreadSafetyMode r9 = LazyThreadSafetyMode.NONE;
        Lazy r10 = LazyKt.lazy(r9, new FlowFeedDialogBuilder$menuListHeight$2(this, r17));
        this.g = r10;
        Lazy r11 = LazyKt.lazy(r9, new FlowFeedDialogBuilder$isMenuOnBottom$2(this));
        this.h = r11;
        Lazy r0 = LazyKt.lazy(r9, new FlowFeedDialogBuilder$contentView$2(this, r15, r16, r17, r18));
        this.i = r0;
        this.j = LazyKt.lazy(r9, FlowFeedDialogBuilder$disableDialogNoDismiss$2.INSTANCE);
        r14.getGlobalVisibleRect(r8);
        float r1 = r14.getMeasuredWidth() + r8.left;
        gravity(51);
        contentLayout((View) r0.getValue());
        View r2 = new View(getContext());
        r2.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        footerLayout(r2);
        int r3 = UIHelper.px2dp(UIUtils.calcViewScreenLocation(r14).top);
        Rect r4 = new Rect();
        r14.getWindowVisibleDisplayFrame(r4);
        int r5 = UIHelper.px2dp(r4.top);
        if (((Boolean) r11.getValue()).booleanValue() == true) goto L6;
        r3 = (r3 - 4) - UIHelper.px2dp(((Number) r10.getValue()).intValue());
    L6:
        translationOnY(r3 - r5);
        width(UIHelper.px2dp(r1));
        backgroundColor(2131106784);
        if (Build.VERSION.SDK_INT >= 31) goto L9;
        float r6 = 0.3f;
    L10:
        maskAlpha(r6);
        return;
    L9:
        r6 = 0.0f;
        goto L10
    }
}
