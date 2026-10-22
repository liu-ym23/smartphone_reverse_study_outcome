package com.bytedance.android.livesdk.interactivity;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "bgDrawable", "Landroid/graphics/drawable/Drawable;", "isSetDefaultBg", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class LeftAvatarWidget$showBubble$onBackgroundReady$1 extends Lambda implements Function2<Drawable, Boolean, Unit> {
    final /* synthetic */ View $anchorView;
    final /* synthetic */ ImageView $bubbleArrow;
    final /* synthetic */ TextView $bubbleTv;
    final /* synthetic */ pp1.c $command;
    final /* synthetic */ View $contentView;
    final /* synthetic */ long $displayTime;
    final /* synthetic */ View $giftIconClickView;
    final /* synthetic */ Ref.IntRef $horizontalPadding;
    final /* synthetic */ Ref.IntRef $verticalPadding;
    final /* synthetic */ LeftAvatarWidget this$0;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LeftAvatarWidget$showBubble$onBackgroundReady$1 a;

        public a(LeftAvatarWidget$showBubble$onBackgroundReady$1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LeftAvatarWidget$showBubble$onBackgroundReady$1 r5 = this.a;
            LeftAvatarWidget r0 = r5.this$0;
            pp1.c r6 = r5.$command;
            LeftAvatarWidget.wq(r0, r6.j, r6.i, "click");
            IUser r7 = this.a.this$0.j;
            if (r7 == null) goto L17;
            com.bytedance.android.live.base.model.user.e r8 = r7.getBottomEntry();
            if (r8 == null) goto L17;
            boolean r1 = true;
            if (r8.getStatus() == 1) goto L9;
        L11:
            r1 = false;
        L12:
            if (r1 == true) goto L15;
            r8 = null;
        L15:
            if (r8 == null) goto L17;
            LeftAvatarWidget.xq(this.a.this$0, r8);
            goto L17
        L9:
            if (this.a.this$0.k <= 0) goto L11;
        L17:
            this.a.this$0.Aq();
        }
    }

    public static final class b implements PopupWindow.OnDismissListener {
        public final /* synthetic */ LeftAvatarWidget$showBubble$onBackgroundReady$1 a;

        public b(LeftAvatarWidget$showBubble$onBackgroundReady$1 r1) {
            this.a = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            LeftAvatarWidget r0 = this.a.this$0;
            r0.i = false;
            r0.Aq();
            this.a.this$0.zq();
        }
    }

    public static final class c implements yo2.e.a {
        public final /* synthetic */ LeftAvatarWidget$showBubble$onBackgroundReady$1 a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ c a;
            public final /* synthetic */ View b;

            public a(c r1, View r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r4) {
                LeftAvatarWidget$showBubble$onBackgroundReady$1 r5 = this.a.a;
                LeftAvatarWidget r0 = r5.this$0;
                pp1.c r6 = r5.$command;
                LeftAvatarWidget.wq(r0, r6.j, r6.i, "click");
                if (this.a.c.length() <= 0) goto L5;
                boolean r7 = true;
            L6:
                if (r7 == false) goto L13;
                if (this.a.b == true) goto L13;
                IBaseLiveActionHandler r8 = jc1.k.f(IBaseLiveActionHandler.class);
                if (r8 == null) goto L13;
                c r1 = this.a;
                r8.handle(((Widget) r1.a.this$0).context, r1.c);
            L13:
                if ((!Intrinsics.areEqual(this.b, this.a.a.$bubbleTv)) == true) goto L15;
                return;
            L15:
                if ((!Intrinsics.areEqual(this.b, this.a.a.$giftIconClickView)) == false) goto L19;
                this.a.a.this$0.Aq();
                return;
            L19:
                return;
            L5:
                r7 = false;
                goto L6
            }
        }

        public c(LeftAvatarWidget$showBubble$onBackgroundReady$1 r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(View r1, yo2.e r2) {
            r1.setOnClickListener(new a(this, r1));
        }
    }

    public LeftAvatarWidget$showBubble$onBackgroundReady$1(LeftAvatarWidget r1, View r2, TextView r3, Ref.IntRef r4, Ref.IntRef r5, pp1.c r6, ImageView r7, View r8, View r9, long r10) {
        this.this$0 = r1;
        this.$anchorView = r2;
        this.$bubbleTv = r3;
        this.$verticalPadding = r4;
        this.$horizontalPadding = r5;
        this.$command = r6;
        this.$bubbleArrow = r7;
        this.$giftIconClickView = r8;
        this.$contentView = r9;
        this.$displayTime = r10;
        super(2);
    }

    public final void invoke(Drawable r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "bgDrawable");
        int r0 = LeftAvatarWidget.n;
        View r1 = this.$anchorView;
        Intrinsics.checkNotNullParameter(r1, "view");
        boolean r2 = true;
        int r3 = 0;
        if (r1.getParent() != null) goto L5;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == true) goto L13;
        LeftAvatarWidget r15 = this.this$0;
        r15.i = false;
        r15.Aq();
        this.this$0.zq();
        return;
    L13:
        if (r14 == false) goto L15;
        TextView r16 = this.$bubbleTv;
        int r5 = this.$verticalPadding.element;
        int r6 = this.$horizontalPadding.element;
        r16.setPadding(r5, r6, r5, r6);
        s1.H(this.$bubbleTv, r13);
    L15:
        pp1.c r17 = this.$command;
        Spannable r18 = r17.a;
        ViewGroup.LayoutParams r7 = null;
        if (r18 == null) goto L18;
        this.$bubbleTv.setText(r18);
    L22:
        py.k r19 = this.$command.g;
        if (r19 != null) goto L25;
    L27:
        this.$bubbleArrow.setImageDrawable(((Widget) this.this$0).context.getResources().getDrawable(2131251350));
    L28:
        int r110 = this.$command.h;
        if (r110 != 2) goto L31;
        boolean r8 = true;
    L33:
        if (r110 != 3) goto L35;
        boolean r111 = true;
    L36:
        if (r8 == true) goto L38;
        if (r111 == true) goto L38;
    L39:
        pp1.c r9 = this.$command;
        String r10 = r9.d;
        if (r10 != null) goto L42;
        r10 = BuildConfig.FLAVOR;
    L42:
        LeftAvatarWidget r11 = this.this$0;
        yo2.e r20 = new yo2.e(((Widget) r11).context);
        ((yo2.d) r20).d = this.$contentView;
        ((yo2.d) r20).e = 0;
        ((yo2.d) r20).l = true;
        ((yo2.d) r20).m = this.$displayTime;
        ((yo2.d) r20).n = true;
        ((yo2.d) r20).o = r9.k;
        ((yo2.d) r20).k = new b(this);
        r20.x = new c(this, r111, r10);
        r20.a();
        r11.g = r20;
        LeftAvatarWidget r112 = this.this$0;
        yo2.e r21 = r112.g;
        if (r21 == null) goto L96;
        this.$contentView.measure(View.MeasureSpec.makeMeasureSpec(UIUtils.getScreenWidth(((Widget) r112).context), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(UIUtils.getScreenHeight(((Widget) this.this$0).context), Integer.MIN_VALUE));
        int r113 = this.$contentView.getMeasuredWidth();
        int r23 = this.$bubbleArrow.getMeasuredWidth();
        float r24 = UIUtils.dip2Px(((Widget) this.this$0).context, 8.0f);
        int[] r25 = new int[2];
        this.$anchorView.getLocationOnScreen(r25);
        int r26 = r25[0] + (this.$anchorView.getMeasuredWidth() / 2);
        float r114 = r26 - (r113 / 2);
        if (r114 >= r24) goto L61;
        int r115 = (int) (r24 - r114);
        float r27 = r26 - r24;
        ViewGroup.LayoutParams r28 = this.$bubbleArrow.getLayoutParams();
        if ((r28 instanceof LinearLayout.LayoutParams) == true) goto L49;
        r28 = null;
    L49:
        LinearLayout.LayoutParams r29 = (LinearLayout.LayoutParams) r28;
        if (r29 == null) goto L53;
        r29.gravity = 3;
        r29.leftMargin = (int) (r27 - (r23 / 2));
        this.$bubbleArrow.setLayoutParams(r29);
    L53:
        if (this.$giftIconClickView.getVisibility() != 0) goto L77;
        ViewGroup.LayoutParams r30 = this.$giftIconClickView.getLayoutParams();
        if ((r30 instanceof LinearLayout.LayoutParams) == false) goto L58;
        r7 = r30;
    L58:
        LinearLayout.LayoutParams r31 = (LinearLayout.LayoutParams) r7;
        if (r31 == null) goto L77;
        r31.gravity = 3;
        r31.leftMargin = (int) (r27 - (this.$giftIconClickView.getMeasuredWidth() / 2));
        this.$giftIconClickView.setLayoutParams(r31);
    L77:
        int r33 = this.$command.h;
        if (r33 != 2) goto L80;
        boolean r116 = true;
    L81:
        if (r33 == 3) goto L85;
        r2 = false;
    L85:
        if (r116 == true) goto L87;
        if (r2 == true) goto L87;
    L88:
        int r34 = r115 + r3;
        if (r116 == true) goto L93;
        if (r2 == true) goto L93;
        r21.i(this.$anchorView, 1, 0, r34, s1.f(-2.0f));
    L94:
        LeftAvatarWidget r117 = this.this$0;
        pp1.c r118 = this.$command;
        LeftAvatarWidget.wq(r117, r118.j, r118.i, "show");
        return;
    L93:
        r21.i(this.$anchorView, 1, 0, r34, s1.f(38.0f));
    L87:
        r3 = s1.f(-2.0f);
        goto L88
    L80:
        r116 = false;
        goto L81
    L61:
        ViewGroup.LayoutParams r119 = this.$bubbleArrow.getLayoutParams();
        if ((r119 instanceof LinearLayout.LayoutParams) == true) goto L64;
        r119 = null;
    L64:
        LinearLayout.LayoutParams r120 = (LinearLayout.LayoutParams) r119;
        if (r120 == null) goto L68;
        r120.gravity = 1;
        r120.leftMargin = 0;
        this.$bubbleArrow.setLayoutParams(r120);
    L68:
        if (this.$giftIconClickView.getVisibility() != 0) goto L76;
        ViewGroup.LayoutParams r121 = this.$giftIconClickView.getLayoutParams();
        if ((r121 instanceof LinearLayout.LayoutParams) == false) goto L73;
        r7 = r121;
    L73:
        LinearLayout.LayoutParams r35 = (LinearLayout.LayoutParams) r7;
        if (r35 == null) goto L76;
        r35.gravity = 1;
        r35.leftMargin = 0;
        this.$giftIconClickView.setLayoutParams(r35);
    L76:
        r115 = 0;
        goto L77
    L96:
        return;
    L38:
        UIUtils.setViewVisibility(this.$giftIconClickView, 0);
        this.$giftIconClickView.setOnClickListener(new a(this));
        goto L39
    L35:
        r111 = false;
        goto L36
    L31:
        r8 = false;
        goto L33
    L25:
        if (r19.isValid() != true) goto L27;
        ImageUtil.loadImage(this.$bubbleArrow, this.$command.g, 0);
        goto L28
    L18:
        Text r122 = r17.c;
        if (r122 != null) goto L21;
        r122 = new Text();
        r122.setDefaultPattern(this.$command.b);
    L21:
        this.$bubbleTv.setText(sb2.a.f((a5) com.bytedance.android.live.base.model.m.b(r122, Text.class), null).a);
        goto L22
    L5:
        if (r1.getApplicationWindowToken() == null) goto L9;
        if (r1.getVisibility() != 0) goto L9;
        r4 = true;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Drawable) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }
}
