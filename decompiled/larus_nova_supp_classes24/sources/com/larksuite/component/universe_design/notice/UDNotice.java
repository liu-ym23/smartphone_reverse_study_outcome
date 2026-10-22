package com.larksuite.component.universe_design.notice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.notice.databinding.UdLayoutNoticeBinding;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0004qrstB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010/\u001a\u0002002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0002J\b\u00102\u001a\u000200H\u0002J\"\u00103\u001a\u0002002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0002J\u0010\u00104\u001a\u0002002\b\b\u0001\u00105\u001a\u00020\nJ\u0010\u00106\u001a\u0002002\b\b\u0001\u00107\u001a\u00020\nJ\u000e\u00106\u001a\u0002002\u0006\u00108\u001a\u00020\u000fJ\u0006\u00109\u001a\u00020\u000fJ\u0010\u0010:\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\b\u0010<\u001a\u00020\nH\u0007J\u001e\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u001eJ\u0006\u0010A\u001a\u000200J\u0010\u0010B\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\b\u0010C\u001a\u00020\nH\u0007J\u000e\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010F\u001a\u00020\u0019J\u0010\u0010G\u001a\u0002002\b\b\u0001\u00107\u001a\u00020\nJ\b\u0010H\u001a\u0004\u0018\u00010\u0016J\u0010\u0010I\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\u000e\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020\u0019J\u0006\u0010L\u001a\u00020\u0019J\b\u0010M\u001a\u00020\nH\u0007J\u000e\u0010N\u001a\u0002002\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010O\u001a\u00020\u0019J\u0010\u0010P\u001a\u0002002\b\b\u0001\u00107\u001a\u00020\nJ\b\u0010Q\u001a\u0004\u0018\u00010\u0016J\u0010\u0010R\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\b\u0010S\u001a\u00020\nH\u0007J\u000e\u0010T\u001a\u0002002\u0006\u0010U\u001a\u00020\u001eJ\u000e\u0010V\u001a\u0002002\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010W\u001a\u00020\u0019J\u000e\u0010X\u001a\u0002002\u0006\u00108\u001a\u00020\u001bJ\b\u0010Y\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010Z\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\b\u0010[\u001a\u00020\nH\u0007J\u000e\u0010\\\u001a\u0002002\u0006\u0010U\u001a\u00020\u001eJ\u000e\u0010]\u001a\u0002002\u0006\u0010^\u001a\u00020 J\u0006\u0010_\u001a\u00020 J\u000e\u0010`\u001a\u0002002\u0006\u0010a\u001a\u00020bJ\u000e\u0010c\u001a\u0002002\u0006\u0010d\u001a\u00020,J\u0006\u0010e\u001a\u00020,J\u0010\u0010f\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\nJ\u000e\u0010g\u001a\u0002002\u0006\u0010h\u001a\u00020iJ\u000e\u0010j\u001a\u0002002\u0006\u0010.\u001a\u00020\u0019J\u0006\u0010.\u001a\u00020\u0019J\u0018\u0010k\u001a\u0002002\u0006\u0010l\u001a\u00020m2\u0006\u0010E\u001a\u00020\u0019H\u0002J\b\u0010n\u001a\u000200H\u0002J\b\u0010o\u001a\u000200H\u0002J\b\u0010p\u001a\u000200H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/larksuite/component/universe_design/notice/UDNotice;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewBinding", "Lcom/larksuite/component/universe_design/notice/databinding/UdLayoutNoticeBinding;", "mText", "", "mTextColor", "mTextActions", "", "Lcom/larksuite/component/universe_design/notice/UDNotice$TextAction;", "mTextActionColor", "mIcon", "Landroid/graphics/drawable/Drawable;", "mIconColor", "mIconColorful", "", "mButtonText", "", "mButtonTextColor", "mTextButtonListener", "Landroid/view/View$OnClickListener;", "mTextButtonPosition", "Lcom/larksuite/component/universe_design/notice/UDNotice$TextButtonPosition;", "mButtonIcon", "mButtonIconColor", "mIconButtonListener", "mBackgroundColor", "mShowIcon", "mShowTextButton", "mShowIconButton", "mRadius", "mBackgroundDrawable", "Lcom/larksuite/component/universe_design/drawable/UDRoundDrawable;", "mGravity", "Lcom/larksuite/component/universe_design/notice/UDNotice$Gravity;", "isGlobalLayoutListenerAdded", "isMarquee", "init", "", "defStyleRes", "setupViews", "applyAttrs", "applyStyle", "styleRes", "setText", "resId", "text", "getText", "setTextColor", "color", "getTextColor", "addTextAction", "start", "end", "listener", "clearTextActions", "setTextActionColor", "getTextActionColor", "showIcon", "isShow", "isIconShow", "setIcon", "getIcon", "setIconColor", "setIconColorful", "isColorful", "isIconColorful", "getIconColor", "showIconButton", "isIconButtonShow", "setIconButton", "getButtonIcon", "setIconButtonColor", "getButtonIconColor", "setIconButtonListener", "onClickListener", "showTextButton", "isTextButtonShow", "setTextButton", "getButtonText", "setTextButtonColor", "getButtonTextColor", "setTextButtonListener", "setTextButtonPosition", "position", "getTextButtonPosition", "setType", "type", "Lcom/larksuite/component/universe_design/notice/UDNotice$Type;", "setGravity", "gravity", "getGravity", "setBackground", "setRadius", "radius", "Lcom/larksuite/component/universe_design/radius/UDRadius;", "setMarquee", "showView", "view", "Landroid/view/View;", "buildSpans", "applyBackground", "addGlobalLayoutListenerIfNeed", "Type", "TextButtonPosition", "Gravity", "TextAction", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDNotice extends ConstraintLayout {
    public final UdLayoutNoticeBinding a;
    public CharSequence b;
    public int c;
    public final List<a> d;
    public int e;
    public Drawable f;
    public int g;
    public boolean h;
    public String i;
    public int j;
    public View.OnClickListener k;
    public TextButtonPosition l;
    public Drawable m;
    public int n;
    public View.OnClickListener o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public final t08.a u;
    public Gravity v;
    public boolean w;
    public boolean x;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Lcom/larksuite/component/universe_design/notice/UDNotice$Gravity;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "value", "", "Companion", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Gravity extends Enum<Gravity> {
        public static final Gravity CENTER = null;
        public static final a Companion = null;
        public static final Gravity LEFT = null;
        public static final /* synthetic */ Gravity[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Gravity.values().length];
                r0[Gravity.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[Gravity.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public static EnumEntries<Gravity> getEntries() {
            return b;
        }

        static {
            Gravity r0 = new Gravity("LEFT", 0);
            LEFT = r0;
            Gravity r1 = new Gravity("CENTER", 1);
            CENTER = r1;
            Gravity[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static Gravity[] values() {
            return (Gravity[]) a.clone();
        }

        public final int value() {
            int r0 = b.a[ordinal()];
            if (r0 != 1) goto L5;
            return 0;
        L5:
            if (r0 != 2) goto L8;
            return 1;
        L8:
            throw new NoWhenBranchMatchedException();
        }

        public static Gravity valueOf(String r1) {
            return (Gravity) r27.a.a(Gravity.class, r1);
        }

        public Gravity(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"}, d2 = {"Lcom/larksuite/component/universe_design/notice/UDNotice$TextButtonPosition;", "", "<init>", "(Ljava/lang/String;I)V", "RIGHT", "BOTTOM", "AUTO", "value", "", "Companion", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum TextButtonPosition extends Enum<TextButtonPosition> {
        public static final TextButtonPosition AUTO = null;
        public static final TextButtonPosition BOTTOM = null;
        public static final a Companion = null;
        public static final TextButtonPosition RIGHT = null;
        public static final /* synthetic */ TextButtonPosition[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TextButtonPosition.values().length];
                r0[TextButtonPosition.RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[TextButtonPosition.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[TextButtonPosition.AUTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public static EnumEntries<TextButtonPosition> getEntries() {
            return b;
        }

        static {
            TextButtonPosition r0 = new TextButtonPosition("RIGHT", 0);
            RIGHT = r0;
            TextButtonPosition r1 = new TextButtonPosition("BOTTOM", 1);
            BOTTOM = r1;
            TextButtonPosition r3 = new TextButtonPosition("AUTO", 2);
            AUTO = r3;
            TextButtonPosition[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static TextButtonPosition[] values() {
            return (TextButtonPosition[]) a.clone();
        }

        public final int value() {
            int r0 = b.a[ordinal()];
            if (r0 != 1) goto L5;
            return 0;
        L5:
            if (r0 != 2) goto L7;
            return 1;
        L7:
            if (r0 != 3) goto L10;
            return 2;
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public static TextButtonPosition valueOf(String r1) {
            return (TextButtonPosition) r27.a.a(TextButtonPosition.class, r1);
        }

        public TextButtonPosition(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/universe_design/notice/UDNotice$Type;", "", "styleRes", "", "<init>", "(Ljava/lang/String;II)V", "getStyleRes$universe_ui_notice_release", "()I", "INFO", "SUCCESS", "WARNING", "ERROR", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> {
        public static final Type ERROR = null;
        public static final Type INFO = null;
        public static final Type SUCCESS = null;
        public static final Type WARNING = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int styleRes;

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("INFO", 0, 2131953853);
            INFO = r0;
            Type r1 = new Type("SUCCESS", 1, 2131953854);
            SUCCESS = r1;
            Type r2 = new Type("WARNING", 2, 2131953855);
            WARNING = r2;
            Type r4 = new Type("ERROR", 3, 2131953852);
            ERROR = r4;
            Type[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public final int getStyleRes$universe_ui_notice_release() {
            return this.styleRes;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.styleRes = r3;
        }
    }

    public static final class a {
        public final int a;
        public final int b;
        public final View.OnClickListener c;

        public a(int r2, int r3, View.OnClickListener r4) {
            Intrinsics.checkNotNullParameter(r4, "listener");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Gravity.values().length];
            r0[Gravity.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[Gravity.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[TextButtonPosition.values().length];
            r1[TextButtonPosition.RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[TextButtonPosition.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[TextButtonPosition.AUTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ UDNotice a;

        public c(UDNotice r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.o;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ UDNotice a;

        public d(UDNotice r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.k;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ UDNotice a;

        public e(UDNotice r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.k;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ UDNotice a;

        public f(UDNotice r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.k;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ UDNotice a;

        public g(UDNotice r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.k;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U5() {
        t08.a r0 = this.u;
        r0.setColor(this.p);
        if (this.t >= 0) goto L5;
        this.t = 0;
    L5:
        r0.setCornerRadius(this.t);
        setBackground(r0);
    }

    private final void Y5() {
        SpannableStringBuilder r0 = new SpannableStringBuilder(this.b);
        Iterator<a> r1 = this.d.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a r2 = r1.next();
        r0.setSpan(new b18.a(this.e, r2.c), r2.a, r2.b, 34);
        goto L4
    L6:
        this.a.d.setText(r0, TextView.BufferType.SPANNABLE);
        this.a.d.setMovementMethod(LinkMovementMethod.getInstance());
        this.a.d.setHighlightColor(0);
    }

    private final void c6() {
        TextView r0 = this.a.d;
        if (((ArrayList) this.d).isEmpty() == false) goto L5;
        r0.setText(this.b);
    L6:
        r0.setTextColor(this.c);
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
    L10:
        if (r2 == null) goto L20;
        int r3 = b.a[this.v.ordinal()];
        if (r3 != 1) goto L14;
        r2.matchConstraintDefaultWidth = 1;
    L19:
        r0.setLayoutParams(r2);
        goto L20
    L14:
        if (r3 != 2) goto L17;
        ((ViewGroup.MarginLayoutParams) r2).width = 0;
        r2.matchConstraintDefaultWidth = 0;
        goto L19
    L17:
        throw new NoWhenBranchMatchedException();
    L20:
        ImageView r4 = this.a.b;
        Drawable r5 = this.f;
        if (r5 != null) goto L23;
    L26:
        r4.setImageDrawable(this.f);
        ImageView r6 = this.a.c;
        Drawable r7 = this.m;
        if (r7 == null) goto L29;
        r7.mutate();
        r7.setTint(this.n);
    L29:
        r6.setImageDrawable(this.m);
        TextView r8 = this.a.f;
        r8.setText(this.i);
        r8.setTextColor(this.j);
        r8.setOnClickListener(new f(this));
        TextView r9 = this.a.e;
        r9.setText(this.i);
        r9.setTextColor(this.j);
        r9.setOnClickListener(new g(this));
        k6(this.r);
        i6(this.s);
        boolean r10 = this.q;
        this.q = r10;
        n6(this.a.b, r10);
        setMarquee(this.x);
        U5();
        return;
    L23:
        if (this.h == false) goto L25;
        r5.setTintList(null);
        goto L26
    L25:
        r5.mutate();
        r5.setTint(this.g);
        goto L26
    L9:
        r2 = null;
        goto L10
    L5:
        Y5();
        goto L6
    }

    public final void Z5() {
        this.a.d.setText(this.b);
        ((ArrayList) this.d).clear();
    }

    public final Drawable getButtonIcon() {
        return this.m;
    }

    public final int getButtonIconColor() {
        return this.n;
    }

    public final String getButtonText() {
        return this.i;
    }

    public final int getButtonTextColor() {
        return this.j;
    }

    public final Gravity getGravity() {
        return this.v;
    }

    public final Drawable getIcon() {
        return this.f;
    }

    public final int getIconColor() {
        return this.g;
    }

    public final CharSequence getText() {
        return this.b;
    }

    public final int getTextActionColor() {
        return this.e;
    }

    public final TextButtonPosition getTextButtonPosition() {
        return this.l;
    }

    public final int getTextColor() {
        return this.c;
    }

    public UDNotice(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void V5(int r3) {
        T5(null, 0, 2131953855);
        c6();
    }

    public final void i6(boolean r2) {
        this.s = r2;
        n6(this.a.c, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k6(boolean r4) {
        this.r = r4;
        TextButtonPosition r5 = this.l;
        int r6 = b.b[r5.ordinal()];
        if (r6 != 1) goto L5;
        n6(this.a.f, this.r);
        n6(this.a.e, false);
        return;
    L5:
        if (r6 != 2) goto L7;
        n6(this.a.f, false);
        n6(this.a.e, this.r);
        return;
    L7:
        if (r6 != 3) goto L13;
        n6(this.a.f, this.r);
        n6(this.a.e, false);
        if (this.w == true) goto L19;
        this.w = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new y08.a(this));
        return;
    L19:
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void setBackground(int r1) {
        this.p = r1;
        U5();
    }

    public final void setGravity(Gravity r2) {
        Intrinsics.checkNotNullParameter(r2, "gravity");
        if (r2 == this.v) goto L6;
        this.v = r2;
        c6();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setIcon(int r3) {
        this.q = true;
        n6(this.a.b, true);
        Drawable r4 = UDIconUtils.getIconDrawable(getContext(), r3);
        if (this.h == true) goto L5;
        r4.mutate();
        r4.setTint(this.g);
    L5:
        this.f = r4;
        this.a.b.setImageDrawable(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setIconButton(int r2) {
        i6(true);
        Drawable r3 = UDIconUtils.getIconDrawable(getContext(), r2);
        r3.mutate();
        r3.setTint(this.n);
        this.m = r3;
        this.a.c.setImageDrawable(r3);
    }

    public final void setIconButtonColor(int r2) {
        this.n = r2;
        Drawable r3 = this.m;
        if (r3 == null) goto L6;
        r3.mutate();
        r3.setTint(this.n);
        return;
    }

    public final void setIconButtonListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        this.o = r2;
        this.a.c.setOnClickListener(new c(this));
    }

    public final void setIconColor(int r2) {
        this.g = r2;
        Drawable r3 = this.f;
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.h == true) goto L9;
        r3.mutate();
        r3.setTint(this.g);
        return;
    }

    public final void setIconColorful(boolean r2) {
        this.h = r2;
        Drawable r0 = this.f;
        if (r0 == null) goto L8;
        if (r2 == false) goto L6;
        r0.setTintList(null);
        return;
    L6:
        r0.mutate();
        r0.setTint(this.g);
        return;
    }

    public final void setMarquee(boolean r3) {
        if (((ArrayList) this.d).isEmpty() == false) goto L5;
        this.x = r3;
    L7:
        if (this.x == false) goto L9;
        TextView r4 = this.a.d;
        r4.setSingleLine(true);
        r4.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r4.setMarqueeRepeatLimit(-1);
        r4.setSelected(true);
        return;
    L9:
        TextView r5 = this.a.d;
        r5.setSingleLine(false);
        r5.setEllipsize(null);
        r5.setSelected(false);
        return;
    L5:
        this.x = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setRadius(UDRadius r2) {
        Intrinsics.checkNotNullParameter(r2, "radius");
        this.t = r2.getRadiusSize(getContext());
        U5();
    }

    public final void setText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.b = r2;
        this.a.d.setText(r2);
    }

    public final void setTextActionColor(int r1) {
        this.e = r1;
        Y5();
    }

    public final void setTextButton(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        k6(true);
        this.i = r2;
        this.a.f.setText(r2);
        this.a.e.setText(this.i);
    }

    public final void setTextButtonColor(int r2) {
        this.j = r2;
        this.a.f.setTextColor(r2);
        this.a.e.setTextColor(this.j);
    }

    public final void setTextButtonListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        this.k = r2;
        this.a.f.setOnClickListener(new d(this));
        this.a.e.setOnClickListener(new e(this));
    }

    public final void setTextButtonPosition(TextButtonPosition r2) {
        Intrinsics.checkNotNullParameter(r2, "position");
        this.l = r2;
        k6(this.r);
    }

    public final void setTextColor(int r2) {
        this.c = r2;
        this.a.d.setTextColor(r2);
    }

    public final void setType(Type r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        T5(null, 0, r3.getStyleRes$universe_ui_notice_release());
        c6();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(int r2) {
        setText(getContext().getText(r2));
    }

    public UDNotice(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    private final void b6(AttributeSet r2, int r3) {
        T5(r2, r3, 2131953853);
        c6();
    }

    private static void n6(View r0, boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        r0.setVisibility(r2);
        return;
    L4:
        r2 = 8;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UDNotice(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        ConstraintLayout r13 = LayoutInflater.from(getContext()).inflate(2131568096, this, false);
        addView(r13);
        int r0 = 2131391811;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r13, 2131391811);
        if (r4 == null) goto L15;
        r0 = 2131391812;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r13, 2131391812);
        if (r5 == null) goto L15;
        r0 = 2131391813;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r13, 2131391813);
        if (r6 == null) goto L15;
        r0 = 2131391814;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r13, 2131391814);
        if (r7 == null) goto L15;
        r0 = 2131391815;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, 2131391815);
        if (r8 == null) goto L15;
        this.a = new UdLayoutNoticeBinding(r13, r4, r5, r6, r7, r8);
        this.b = "";
        this.d = new ArrayList(2);
        this.l = TextButtonPosition.RIGHT;
        this.u = new t08.a();
        this.v = Gravity.LEFT;
        b6(r11, r12);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }

    public static final /* synthetic */ void R5(UDNotice r0, View r1, boolean r2) {
        r0.getClass();
        n6(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T5(AttributeSet r5, int r6, int r7) {
        TypedArray r8 = getContext().obtainStyledAttributes(r5, new int[]{2130974916, 2130974917, 2130974918, 2130974919, 2130974920, 2130974921, 2130974922, 2130974923, 2130974924, 2130974925, 2130974926, 2130974927, 2130974928, 2130974929, 2130974935}, r6, r7);
        CharSequence r9 = r8.getString(8);
        if (r9 != null) goto L6;
        r9 = this.b;
    L6:
        this.b = r9;
        this.c = r8.getColor(13, this.c);
        Drawable r10 = r8.getDrawable(2);
        if (r10 != null) goto L9;
        r10 = this.f;
    L9:
        this.f = r10;
        this.g = r8.getColor(5, this.g);
        this.h = r8.getBoolean(6, this.h);
        if (this.f == null) goto L12;
        boolean r11 = true;
    L13:
        this.q = r11;
        Drawable r12 = r8.getDrawable(3);
        if (r12 != null) goto L16;
        r12 = this.m;
    L16:
        this.m = r12;
        this.n = r8.getColor(4, this.n);
        if (this.m == null) goto L19;
        boolean r13 = true;
    L20:
        this.s = r13;
        String r14 = r8.getString(10);
        if (r14 != null) goto L23;
        r14 = this.i;
    L23:
        this.i = r14;
        this.j = r8.getColor(11, this.j);
        if (this.i == null) goto L26;
        boolean r15 = true;
    L27:
        this.r = r15;
        TextButtonPosition.a r16 = TextButtonPosition.Companion;
        int r2 = r8.getInt(12, this.l.value());
        r16.getClass();
        if (r2 == 0) goto L34;
        if (r2 == 1) goto L33;
        if (r2 == 2) goto L32;
        TextButtonPosition r17 = TextButtonPosition.RIGHT;
    L35:
        this.l = r17;
        this.e = r8.getColor(9, this.e);
        this.p = r8.getColor(0, this.p);
        int r19 = r8.getInt(14, -1);
        if (r19 < 0) goto L38;
        UDRadius.Companion.getClass();
        this.t = UDRadius.a.a(r19).getRadiusSize(getContext());
    L38:
        Gravity.a r20 = Gravity.Companion;
        int r21 = r8.getInt(1, this.v.value());
        r20.getClass();
        if (r21 == 0) goto L43;
        if (r21 == 1) goto L42;
        Gravity r22 = Gravity.LEFT;
    L44:
        this.v = r22;
        this.x = r8.getBoolean(7, this.x);
        r8.recycle();
        return;
    L42:
        r22 = Gravity.CENTER;
        goto L44
    L43:
        r22 = Gravity.LEFT;
        goto L44
    L32:
        r17 = TextButtonPosition.AUTO;
        goto L35
    L33:
        r17 = TextButtonPosition.BOTTOM;
        goto L35
    L34:
        r17 = TextButtonPosition.RIGHT;
        goto L35
    L26:
        r15 = false;
        goto L27
    L19:
        r13 = false;
        goto L20
    L12:
        r11 = false;
        goto L13
    }

    public final void S5(int r3, int r4, View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        List<a> r0 = this.d;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new a(r3, r4, r5));
        Y5();
        if (this.x == false) goto L6;
        setMarquee(false);
        return;
    }
}
