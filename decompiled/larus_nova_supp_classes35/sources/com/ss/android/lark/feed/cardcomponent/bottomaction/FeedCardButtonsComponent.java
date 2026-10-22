package com.ss.android.lark.feed.cardcomponent.bottomaction;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.button.e;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.shared.openfeed.FeedCardButtonsParamsFactory$createFeedCardButtonsParams$clickListener$1;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedCardButtonsComponent extends FeedCardComponent<c, View> {

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/bottomaction/FeedCardButtonsComponent$BottomActionButtonView;", "Lcom/larksuite/component/universe_design/button/UDButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "style", "Lcom/ss/android/lark/feed/cardcomponent/bottomaction/FeedCardButtonsComponent$ButtonStyle;", "setStyle", BuildConfig.FLAVOR, "setState", "state", "Lcom/ss/android/lark/feed/cardcomponent/bottomaction/FeedCardButtonsComponent$ButtonState;", "loadingText", BuildConfig.FLAVOR, "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BottomActionButtonView extends UDButton {
        public ButtonStyle a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ButtonState.values().length];
                r0[ButtonState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[ButtonState.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public BottomActionButtonView(Context r3, AttributeSet r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this(r3, r4, 4, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(ButtonStyle r8) {
            Intrinsics.checkNotNullParameter(r8, "style");
            this.a = r8;
            setTextColor(UIUtils.getColorStateList(getContext(), r8.getTextColor()));
            int r0 = UIUtils.getColor(getContext(), r8.getBackgroundColor());
            int r9 = UIUtils.getColor(getContext(), r8.getPressedColor());
            setBackgroundColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{r9, r0}));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BottomActionButtonView(Context r2, AttributeSet r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2, r3, r4);
            setEllipsize(TextUtils.TruncateAt.END);
            setSingleLine(true);
            setGravity(17);
            setBackgroundColor(2131103352);
            setTextSize(0, zz7.b.h(r2, 14));
            int r5 = UIUtils.dp2px(r2, 16.0f);
            setPadding(r5, 0, r5, 0);
            setCornerRadius(UIUtils.dp2px(r2, 6.0f));
            a(ButtonStyle.DEFAULT);
        }

        public /* synthetic */ BottomActionButtonView(Context r1, AttributeSet r2, int r3, int r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2, 0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/bottomaction/FeedCardButtonsComponent$ButtonState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LOADING", "DISABLED", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ButtonState extends Enum<ButtonState> {
        public static final ButtonState DEFAULT = null;
        public static final ButtonState DISABLED = null;
        public static final ButtonState LOADING = null;
        public static final /* synthetic */ ButtonState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ButtonState> getEntries() {
            return b;
        }

        static {
            ButtonState r0 = new ButtonState("DEFAULT", 0);
            DEFAULT = r0;
            ButtonState r1 = new ButtonState("LOADING", 1);
            LOADING = r1;
            ButtonState r3 = new ButtonState("DISABLED", 2);
            DISABLED = r3;
            ButtonState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ButtonState[] values() {
            return (ButtonState[]) a.clone();
        }

        public static ButtonState valueOf(String r1) {
            return (ButtonState) r27.a.a(ButtonState.class, r1);
        }

        public ButtonState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B;\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/bottomaction/FeedCardButtonsComponent$ButtonStyle;", BuildConfig.FLAVOR, "backgroundColor", BuildConfig.FLAVOR, "textColor", "borderColor", "pressedColor", "progressColor", "<init>", "(Ljava/lang/String;IIIIII)V", "getBackgroundColor", "()I", "getTextColor", "getBorderColor", "getPressedColor", "getProgressColor", "DEFAULT", "PRIMARY", "SUCCESS", "TOPPING", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ButtonStyle extends Enum<ButtonStyle> {
        public static final ButtonStyle DEFAULT = null;
        public static final ButtonStyle PRIMARY = null;
        public static final ButtonStyle SUCCESS = null;
        public static final ButtonStyle TOPPING = null;
        public static final /* synthetic */ ButtonStyle[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int backgroundColor;
        private final int borderColor;
        private final int pressedColor;
        private final int progressColor;
        private final int textColor;

        public static EnumEntries<ButtonStyle> getEntries() {
            return b;
        }

        static {
            ButtonStyle r8 = new ButtonStyle("DEFAULT", 0, 2131102430, 2131108884, 2131103352, 2131102432, 2131105542);
            DEFAULT = r8;
            ButtonStyle r0 = new ButtonStyle("PRIMARY", 1, 2131103352, 2131102121, 2131105542, 2131109022, 2131105542);
            PRIMARY = r0;
            ButtonStyle r1 = new ButtonStyle("SUCCESS", 2, 2131103352, 2131102153, 2131102153, 2131102162, 2131102153);
            SUCCESS = r1;
            ButtonStyle r2 = new ButtonStyle("TOPPING", 3, 2131102436, 2131108884, 2131103352, 2131102428, 2131105542);
            TOPPING = r2;
            ButtonStyle[] r3 = {r8, r0, r1, r2};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ButtonStyle[] values() {
            return (ButtonStyle[]) a.clone();
        }

        public final int getBackgroundColor() {
            return this.backgroundColor;
        }

        public final int getBorderColor() {
            return this.borderColor;
        }

        public final int getPressedColor() {
            return this.pressedColor;
        }

        public final int getProgressColor() {
            return this.progressColor;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public static ButtonStyle valueOf(String r1) {
            return (ButtonStyle) r27.a.a(ButtonStyle.class, r1);
        }

        public ButtonStyle(String r1, int r2, int r3, int r4, int r5, int r6, int r7) {
            super(r1, r2);
            this.backgroundColor = r3;
            this.textColor = r4;
            this.borderColor = r5;
            this.pressedColor = r6;
            this.progressColor = r7;
        }
    }

    public static final class a {
        public final String a;
        public final ButtonStyle b;
        public final ButtonState c;
        public final View.OnClickListener d;

        public a(String r2, ButtonStyle r3, ButtonState r4, FeedCardButtonsParamsFactory$createFeedCardButtonsParams$clickListener$1 r5) {
            Intrinsics.checkNotNullParameter(r2, "text");
            Intrinsics.checkNotNullParameter(r3, "style");
            Intrinsics.checkNotNullParameter(r5, "clickListener");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b {
    }

    public static final class c {
        public final List<a> a;

        public c(List<a> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
            this.a = r2;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(0);
        return r0;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        ViewGroup.MarginLayoutParams r0 = super.b();
        r0.width = 0;
        r0.height = -2;
        return r0;
    }

    public FeedCardButtonsComponent(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.view.View, android.widget.Button, com.larksuite.component.universe_design.button.UDButton, com.ss.android.lark.feed.cardcomponent.bottomaction.FeedCardButtonsComponent$BottomActionButtonView] */
    public final void d(c r13) {
        Intrinsics.checkNotNullParameter(r13, Keys.API_RETURN_KEY_DATA);
        View r0 = c();
        AttributeSet r2 = null;
        if ((r0 instanceof LinearLayout) == false) goto L5;
        LinearLayout r1 = (LinearLayout) r0;
    L6:
        if (r1 != 0) goto L8;
        return;
    L8:
        if (r1.getChildCount() <= 0) goto L10;
        r1.removeAllViews();
    L10:
        int r4 = 0;
        if ((!r13.a.isEmpty()) == false) goto L13;
        int r3 = UIUtils.dp2px(r1.getContext(), 8.0f);
    L14:
        r1.setPadding(0, r3, 0, 0);
        Iterator<T> r14 = r13.a.iterator();
        int r5 = 0;
    L16:
        if (r14.hasNext() == false) goto L35;
        int r6 = r5 + 1;
        a r7 = (a) r14.next();
        final ?? r8 = new BottomActionButtonView(r1.getContext(), r2, 6, r4);
        r8.setText(r7.a);
        r8.a(r7.b);
        ButtonState r9 = r7.c;
        if (r9 != null) goto L20;
        r9 = ButtonState.DEFAULT;
    L20:
        final String r10 = r7.a;
        Intrinsics.checkNotNullParameter(r9, "state");
        Intrinsics.checkNotNullParameter(r10, "loadingText");
        int r11 = BottomActionButtonView.a.a[r9.ordinal()];
        if (r11 != 1) goto L23;
        r8.setEnabled(false);
        r8.setAlpha(1.0f);
        e.h(r8, new FeedCardButtonsComponent$BottomActionButtonView$setState$1(r10, r8));
    L27:
        r8.setOnClickListener(r7.d);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(0, zz7.b.g(r1.getContext(), 36));
        r12.weight = 1.0f;
        r12.bottomMargin = UIUtils.dp2px(r1.getContext(), 4.0f);
        if (r5 <= 0) goto L30;
        r12.leftMargin = UIUtils.dp2px(r1.getContext(), 8.0f);
    L30:
        r1.addView(r8, r12);
        r5 = r6;
        goto L16
    L23:
        if (r11 == 2) goto L25;
        r8.setEnabled(true);
        r8.setAlpha(1.0f);
        goto L27
    L25:
        r8.setEnabled(false);
        r8.setAlpha(1.0f);
        goto L27
    L35:
        return;
    L13:
        r3 = 0;
        goto L14
    L5:
        r1 = 0;
        goto L6
    }
}
