package com.obric.oui.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.util.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import u8.f;
import u8.h;
import u8.j;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 U2\u00020\u0001:\u0002VWB1\b\u0007\u0012\u0006\u0010O\u001a\u00020N\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\b\u0002\u0010R\u001a\u000208\u0012\b\b\u0002\u0010C\u001a\u000208¢\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u0004J\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010&\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010*R\u0019\u0010,\u001a\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u00101\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b9\u0010:R\u0019\u0010;\u001a\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010-\u001a\u0004\b<\u0010/R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010:R\u0019\u0010A\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\bA\u00102\u001a\u0004\bB\u00104R\"\u0010C\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010:\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0019\u0010H\u001a\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010-\u001a\u0004\bI\u0010/R\"\u0010J\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u00102\u001a\u0004\bK\u00104\"\u0004\bL\u0010M¨\u0006X"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView;", "Lcom/obric/oui/forms/AbsOForm;", "Landroid/view/View;", "view", "", "setPrefixView", "adjustHeight", "showSoftInput", "hideSoftInput", "clear", "showPrefixView", "hidePrefixView", "Lcom/obric/oui/forms/OBoxInputView$c;", "config", "updateConfig", "", "getText", "text", "setText", "showTitleIcon", "hideTitleIcon", "showTitle", "hideTitle", "getConfig", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "tips", "showErrorTips", "hideErrorTips", "Landroid/widget/EditText;", "getInterEditText", "Landroidx/appcompat/widget/AppCompatEditText;", "editText", "Landroidx/appcompat/widget/AppCompatEditText;", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/widget/ImageView;", "ivTitleIcon", "Landroid/widget/ImageView;", "getIvTitleIcon", "()Landroid/widget/ImageView;", "Ljava/lang/String;", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "Landroid/view/ViewGroup;", "prefixContainer", "Landroid/view/ViewGroup;", "getPrefixContainer", "()Landroid/view/ViewGroup;", "", "showTitleDefaultIcon", "Z", "", "DEFAULT_MAX_LINES", "I", "tvCounter", "getTvCounter", "Lcom/obric/oui/forms/OBoxInputView$c;", "counterTextWatcher", "Landroid/text/TextWatcher;", "textGravity", "inputContainer", "getInputContainer", "arrangeDirection", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "tvErrorTips", "getTvErrorTips", "titleContainer", "getTitleContainer", "setTitleContainer", "(Landroid/view/ViewGroup;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBoxInputView extends AbsOForm {
    public static final int ARRANGE_DIRECTION_HORIZONTAL = 1;
    public static final int ARRANGE_DIRECTION_VERTICAL = 0;
    public static final b Companion = null;
    private static final int DEFAULT_INPUT_BOX_HEIGHT = 0;
    private static final int DEFAULT_LINES = 6;
    private final int DEFAULT_MAX_LINES;
    private int arrangeDirection;
    private c config;
    private TextWatcher counterTextWatcher;
    private final AppCompatEditText editText;
    private final ViewGroup inputContainer;
    private final ImageView ivTitleIcon;
    private final ViewGroup prefixContainer;
    private boolean showTitleDefaultIcon;
    private String text;
    private int textGravity;
    private ViewGroup titleContainer;
    private final TextView tvCounter;
    private final TextView tvErrorTips;
    private final TextView tvTitle;

    static final class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OBoxInputView f6546c;

        a(OBoxInputView r10) {
            this.f6546c = r10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r10, boolean r11) {
            OBoxInputView r12 = this.f6546c;
            if (r11 == false) goto L5;
            OBoxInputView.access$showSoftInput(r12);
            return;
        L5:
            OBoxInputView.access$hideSoftInput(r12);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f6548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f6549c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f6550d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f6551e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f6552f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private TextWatcher f6553g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f6554h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f6555i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f6556j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Drawable f6557k;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f6558a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f6559b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f6560c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private Integer f6561d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private String f6562e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private View f6563f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private TextWatcher f6564g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private int f6565h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private int f6566i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private boolean f6567j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private Drawable f6568k;

            public a() {
                this(false, null, false, null, null, null, null, 0, 0, false, null, 2047, null);
            }

            public a(boolean r10, String r11, boolean r12, Integer r13, String r14, View r15, TextWatcher r16, int r17, int r18, boolean r19, Drawable r110) {
                this.f6558a = r10;
                this.f6559b = r11;
                this.f6560c = r12;
                this.f6561d = r13;
                this.f6562e = r14;
                this.f6563f = r15;
                this.f6564g = r16;
                this.f6565h = r17;
                this.f6566i = r18;
                this.f6567j = r19;
                this.f6568k = r110;
            }

            public /* synthetic */ a(boolean r10, String r11, boolean r12, Integer r13, String r14, View r15, TextWatcher r16, int r17, int r18, boolean r19, Drawable r110, int r111, DefaultConstructorMarker r112) {
                if ((r111 & 1) == 0) goto L6;
                r10 = false;
            L6:
                if ((r111 & 2) == 0) goto L9;
                r11 = null;
            L9:
                if ((r111 & 4) == 0) goto L12;
                r12 = false;
            L12:
                if ((r111 & 8) == 0) goto L15;
                r13 = null;
            L15:
                if ((r111 & 16) == 0) goto L18;
                r14 = null;
            L18:
                if ((r111 & 32) == 0) goto L21;
                r15 = null;
            L21:
                if ((r111 & 64) == 0) goto L24;
                r16 = null;
            L24:
                if ((r111 & 128) == 0) goto L27;
                r17 = OBoxInputView.access$getDEFAULT_INPUT_BOX_HEIGHT$cp();
            L27:
                if ((r111 & 256) == 0) goto L30;
                r18 = Integer.MAX_VALUE;
            L30:
                if ((r111 & 512) == 0) goto L33;
                r19 = false;
            L33:
                if ((r111 & 1024) == 0) goto L35;
                r110 = null;
            L35:
                this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
            }

            public final c a() {
                boolean r10 = this.f6558a;
                String r11 = this.f6559b;
                boolean r12 = this.f6560c;
                String r13 = this.f6562e;
                Integer r14 = this.f6561d;
                TextWatcher r15 = this.f6564g;
                return new c(r10, r11, r12, r14, r13, this.f6563f, r15, this.f6565h, this.f6566i, this.f6567j, this.f6568k, null);
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L4;
                return true;
            L4:
                if ((r10 instanceof a) == false) goto L28;
                a r11 = (a) r10;
                if (this.f6558a == r11.f6558a) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f6559b, r11.f6559b) == true) goto L10;
                return false;
            L10:
                if (this.f6560c == r11.f6560c) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f6561d, r11.f6561d) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.f6562e, r11.f6562e) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.f6563f, r11.f6563f) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f6564g, r11.f6564g) == true) goto L20;
                return false;
            L20:
                if (this.f6565h == r11.f6565h) goto L22;
                return false;
            L22:
                if (this.f6566i == r11.f6566i) goto L24;
                return false;
            L24:
                if (this.f6567j == r11.f6567j) goto L26;
                return false;
            L26:
                if (Intrinsics.areEqual(this.f6568k, r11.f6568k) == true) goto L43;
                return false;
            L43:
                return true;
            L28:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v22 */
            /* JADX WARN: Type inference failed for: r0v23 */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r2v26 */
            /* JADX WARN: Type inference failed for: r2v28 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            public int hashCode() {
                boolean r10 = this.f6558a;
                ?? r11 = 1;
                ?? r12 = r10;
                if (r10 == false) goto L5;
                r12 = 1;
            L5:
                int r13 = r12 * 31;
                String r14 = this.f6559b;
                int r15 = 0;
                if (r14 == null) goto L8;
                int r16 = r14.hashCode();
            L9:
                int r17 = (r13 + r16) * 31;
                boolean r18 = this.f6560c;
                ?? r19 = r18;
                if (r18 == false) goto L12;
                r19 = 1;
            L12:
                int r20 = (r17 + r19) * 31;
                Integer r21 = this.f6561d;
                if (r21 == null) goto L15;
                int r22 = r21.hashCode();
            L16:
                int r23 = (r20 + r22) * 31;
                String r24 = this.f6562e;
                if (r24 == null) goto L19;
                int r25 = r24.hashCode();
            L20:
                int r26 = (r23 + r25) * 31;
                View r27 = this.f6563f;
                if (r27 == null) goto L23;
                int r28 = r27.hashCode();
            L24:
                int r29 = (r26 + r28) * 31;
                TextWatcher r30 = this.f6564g;
                if (r30 == null) goto L27;
                int r31 = r30.hashCode();
            L28:
                int r32 = (((((r29 + r31) * 31) + Integer.hashCode(this.f6565h)) * 31) + Integer.hashCode(this.f6566i)) * 31;
                boolean r33 = this.f6567j;
                if (r33 == true) goto L32;
                r11 = r33;
            L32:
                int r34 = (r32 + r11) * 31;
                Drawable r35 = this.f6568k;
                if (r35 == null) goto L36;
                r15 = r35.hashCode();
            L36:
                return r34 + r15;
            L27:
                r31 = 0;
                goto L28
            L23:
                r28 = 0;
                goto L24
            L19:
                r25 = 0;
                goto L20
            L15:
                r22 = 0;
                goto L16
            L8:
                r16 = 0;
                goto L9
            }

            public String toString() {
                return "Builder(showTitle=" + this.f6558a + ", title=" + this.f6559b + ", showCounter=" + this.f6560c + ", lengthLimit=" + this.f6561d + ", hintText=" + this.f6562e + ", prefixView=" + this.f6563f + ", textWatcher=" + this.f6564g + ", inputBoxHeight=" + this.f6565h + ", inputBoxMaxHeight=" + this.f6566i + ", autoAdjustHeight=" + this.f6567j + ", ivTitleIcon=" + this.f6568k + ")";
            }
        }

        private c(boolean r10, String r11, boolean r12, Integer r13, String r14, View r15, TextWatcher r16, int r17, int r18, boolean r19, Drawable r110) {
            this.f6547a = r10;
            this.f6548b = r11;
            this.f6549c = r12;
            this.f6550d = r13;
            this.f6551e = r14;
            this.f6552f = r15;
            this.f6553g = r16;
            this.f6554h = r17;
            this.f6555i = r18;
            this.f6556j = r19;
            this.f6557k = r110;
        }

        public /* synthetic */ c(boolean r10, String r11, boolean r12, Integer r13, String r14, View r15, TextWatcher r16, int r17, int r18, boolean r19, Drawable r110, DefaultConstructorMarker r111) {
            this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
        }

        public final boolean a() {
            return this.f6556j;
        }

        public final String b() {
            return this.f6551e;
        }

        public final int c() {
            return this.f6554h;
        }

        public final int d() {
            return this.f6555i;
        }

        public final Drawable e() {
            return this.f6557k;
        }

        public final Integer f() {
            return this.f6550d;
        }

        public final View g() {
            return this.f6552f;
        }

        public final boolean h() {
            return this.f6549c;
        }

        public final boolean i() {
            return this.f6547a;
        }

        public final TextWatcher j() {
            return this.f6553g;
        }

        public final String k() {
            return this.f6548b;
        }

        public final void l(boolean r10) {
            this.f6556j = r10;
        }

        public final void m(String r10) {
            this.f6551e = r10;
        }

        public final void n(int r10) {
            this.f6554h = r10;
        }

        public final void o(int r10) {
            this.f6555i = r10;
        }

        public final void p(Integer r10) {
            this.f6550d = r10;
        }

        public final void q(boolean r10) {
            this.f6549c = r10;
        }

        public final void r(boolean r10) {
            this.f6547a = r10;
        }

        public final void s(String r10) {
            this.f6548b = r10;
        }
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OBoxInputView f6569c;

        static final class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f6570c;

            a(d r10) {
                this.f6570c = r10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OBoxInputView.access$adjustHeight(this.f6570c.f6569c);
            }
        }

        d(OBoxInputView r10) {
            this.f6569c = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            Intrinsics.checkNotNullParameter(r10, "s");
            this.f6569c.getEditText().post(new a(this));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "s");
        }
    }

    public static final class e implements TextWatcher {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OBoxInputView f6571c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f6572g;

        static final class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f6573c;

            a(e r10) {
                this.f6573c = r10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OBoxInputView.access$adjustHeight(this.f6573c.f6571c);
            }
        }

        e(OBoxInputView r10, c r11) {
            this.f6571c = r10;
            this.f6572g = r11;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (this.f6572g.a() == false) goto L6;
            this.f6571c.getEditText().post(new a(this));
            return;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            if (this.f6572g.f() == null) goto L23;
            Resources r14 = this.f6571c.getResources();
            int r15 = j.oui_form_counter;
            Object[] r16 = new Object[2];
            if (r10 == null) goto L7;
            String r17 = String.valueOf(r10.length());
        L8:
            r16[0] = r17;
            r16[1] = String.valueOf(this.f6572g.f());
            String r18 = r14.getString(r15, r16);
            Intrinsics.checkNotNullExpressionValue(r18, "resources.getString(\n   …                        )");
            SpannableString r19 = new SpannableString(r18);
            if (r10 == null) goto L11;
            int r20 = r10.length();
        L12:
            Integer r21 = this.f6572g.f();
            Intrinsics.checkNotNull(r21);
            if (r20 <= r21.intValue()) goto L21;
            ForegroundColorSpan r22 = new ForegroundColorSpan(ContextCompat.getColor(this.f6571c.getContext(), u8.c.Primary));
            if (r10 == null) goto L19;
            String r23 = String.valueOf(r10.length());
            if (r23 == null) goto L19;
            int r24 = r23.length();
        L20:
            r19.setSpan(r22, 0, r24, 18);
        L19:
            r24 = 0;
        L21:
            this.f6571c.getTvCounter().setText(r19, TextView.BufferType.SPANNABLE);
            return;
        L11:
            r20 = 0;
            goto L12
        L7:
            r17 = null;
            goto L8
        }
    }

    static {
        Companion = new b(null);
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        DEFAULT_INPUT_BOX_HEIGHT = MathKt.roundToInt(TypedValue.applyDimension(1, 144, r10.getDisplayMetrics()));
    }

    @JvmOverloads
    public OBoxInputView(Context r10) {
        this(r10, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public OBoxInputView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, 12, null);
    }

    @JvmOverloads
    public OBoxInputView(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, 8, null);
    }

    @JvmOverloads
    public OBoxInputView(Context r18, AttributeSet r19, int r20, int r21) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20);
        this.arrangeDirection = r21;
        this.config = new c.a(false, null, false, null, null, null, null, 0, 0, false, null, 2047, null).a();
        this.textGravity = 48;
        this.DEFAULT_MAX_LINES = 20;
        TypedArray r10 = r18.getTheme().obtainStyledAttributes(r19, l.OBoxInputView, 0, 0);
        this.arrangeDirection = r10.getInt(l.OBoxInputView_oui_formArrangeDirection, 1);     // Catch: Throwable -> L23
        this.config.m(r10.getString(l.OBoxInputView_android_hint));     // Catch: Throwable -> L23
        this.config.q(r10.getBoolean(l.OBoxInputView_oui_formShowCounter, false));     // Catch: Throwable -> L23
        int r11 = r10.getInt(l.OBoxInputView_oui_formLengthLimit, 0);     // Catch: Throwable -> L23
        if (r11 <= 0) goto L6;
        this.config.p(Integer.valueOf(r11));     // Catch: Throwable -> L23
    L6:
        String r12 = r10.getString(l.OBoxInputView_oui_formTitle);     // Catch: Throwable -> L23
        if (r12 != null) goto L9;
    L12:
        boolean r13 = true;
    L13:
        if (r13 == true) goto L15;
        this.config.s(r12);     // Catch: Throwable -> L23
        this.config.r(true);     // Catch: Throwable -> L23
    L16:
        this.config.n(r10.getDimensionPixelSize(l.OBoxInputView_oui_formInputHeight, DEFAULT_INPUT_BOX_HEIGHT));     // Catch: Throwable -> L23
        this.config.o(r10.getDimensionPixelSize(l.OBoxInputView_oui_formInputMaxHeight, Integer.MAX_VALUE));     // Catch: Throwable -> L23
        this.text = r10.getString(l.OBoxInputView_android_text);     // Catch: Throwable -> L23
        this.showTitleDefaultIcon = r10.getBoolean(l.OBoxInputView_oui_formShowTitleDefaultIcon, false);     // Catch: Throwable -> L23
        this.config.l(r10.getBoolean(l.OBoxInputView_oui_formAutoAdjustHeight, false));     // Catch: Throwable -> L23
        this.textGravity = r10.getInt(l.OBoxInputView_android_gravity, 48);     // Catch: Throwable -> L23
        r10.recycle();
        if (this.arrangeDirection == 1) goto L20;
        int r14 = h.o_form_box_vertical;
    L21:
        LayoutInflater.from(r18).inflate(r14, this);
        View r15 = findViewById(f.tv_title);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r15;
        View r16 = findViewById(f.iv_title_icon);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.iv_title_icon)");
        this.ivTitleIcon = (ImageView) r16;
        View r17 = findViewById(f.prefix_container);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.prefix_container)");
        this.prefixContainer = (ViewGroup) r17;
        View r22 = findViewById(f.edittext);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.edittext)");
        AppCompatEditText r23 = (AppCompatEditText) r22;
        this.editText = r23;
        View r24 = findViewById(f.tv_counter);
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.tv_counter)");
        this.tvCounter = (TextView) r24;
        View r25 = findViewById(f.tv_error_tips);
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.tv_error_tips)");
        this.tvErrorTips = (TextView) r25;
        r23.setOnFocusChangeListener(new a(this));
        View r26 = findViewById(f.input_container);
        Intrinsics.checkNotNullExpressionValue(r26, "findViewById(R.id.input_container)");
        this.inputContainer = (ViewGroup) r26;
        View r27 = findViewById(f.title_container);
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.title_container)");
        this.titleContainer = (ViewGroup) r27;
        updateConfig(this.config);
        r23.setLines(20);
        r23.setSingleLine(false);
        return;
    L20:
        r14 = h.o_form_box_horizontal;
        goto L21
    L15:
        this.config.s("标题");     // Catch: Throwable -> L23
        goto L16
    L9:
        if (r12.length() == 0) goto L12;
        r13 = false;
    L23:
        th = move-exception;
        r10.recycle();
        throw th;
    }

    public /* synthetic */ OBoxInputView(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 1;
    L11:
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ void access$adjustHeight(OBoxInputView r10) {
        r10.adjustHeight();
    }

    public static final /* synthetic */ int access$getDEFAULT_INPUT_BOX_HEIGHT$cp() {
        return DEFAULT_INPUT_BOX_HEIGHT;
    }

    public static final /* synthetic */ void access$hideSoftInput(OBoxInputView r10) {
        r10.hideSoftInput();
    }

    public static final /* synthetic */ void access$showSoftInput(OBoxInputView r10) {
        r10.showSoftInput();
    }

    private final void adjustHeight() {
        int r10 = this.editText.getLineCount();
        int r11 = this.editText.getLineHeight();
        int r12 = this.editText.getHeight();
        int r13 = this.inputContainer.getHeight();
        int r14 = ((r10 * r11) + r13) - r12;
        if (r14 >= this.config.c()) goto L5;
    L8:
        ViewGroup.LayoutParams r15 = this.inputContainer.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(r15, "inputContainer.getLayoutParams()");
        r15.height = r13;
        this.inputContainer.setLayoutParams(r15);
        return;
    L5:
        if (r14 >= this.config.d()) goto L8;
        r13 = r14;
        goto L8
    }

    private final void clear() {
        Iterator<WeakReference<TextWatcher>> r10 = getTextWatchers().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        WeakReference<TextWatcher> r11 = r10.next();
        this.editText.removeTextChangedListener(r11.get());
        goto L4
    }

    private final void hideSoftInput() {
        Object r10 = getContext().getSystemService("input_method");
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r10).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private final void setPrefixView(View r10) {
        if (r10 == null) goto L5;
        this.prefixContainer.removeAllViews();
        this.prefixContainer.addView(r10, new ConstraintLayout.LayoutParams(-2, -2));
        return;
    }

    private final void showSoftInput() {
        Object r10 = getContext().getSystemService("input_method");
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r10).showSoftInput(this, 0);
    }

    public final int getArrangeDirection() {
        return this.arrangeDirection;
    }

    public final c getConfig() {
        return this.config;
    }

    public final AppCompatEditText getEditText() {
        return this.editText;
    }

    public final ViewGroup getInputContainer() {
        return this.inputContainer;
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return this.editText;
    }

    public final ImageView getIvTitleIcon() {
        return this.ivTitleIcon;
    }

    public final ViewGroup getPrefixContainer() {
        return this.prefixContainer;
    }

    public final String getText() {
        return String.valueOf(this.editText.getText());
    }

    public final ViewGroup getTitleContainer() {
        return this.titleContainer;
    }

    public final TextView getTvCounter() {
        return this.tvCounter;
    }

    public final TextView getTvErrorTips() {
        return this.tvErrorTips;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public final void hideErrorTips() {
        this.tvErrorTips.setText("");
        k.f(this.tvErrorTips);
    }

    public final void hidePrefixView() {
        k.f(this.prefixContainer);
    }

    public final void hideTitle() {
        k.f(this.tvTitle);
        if (this.ivTitleIcon.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        k.f(this.titleContainer);
    L8:
        this.config.r(false);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void hideTitleIcon() {
        k.f(this.ivTitleIcon);
        if (this.tvTitle.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
    L9:
        k.f(this.titleContainer);
        return;
    L8:
        if (TextUtils.isEmpty(this.tvTitle.getText()) == true) goto L9;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void setArrangeDirection(int r10) {
        this.arrangeDirection = r10;
    }

    public final void setText(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == true) goto L14;
        this.editText.setText(r10);
        TextWatcher r12 = this.counterTextWatcher;
        if (r12 == null) goto L15;
        Intrinsics.checkNotNull(r10);
        r12.onTextChanged(r10, 0, 0, r10.length());
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    public final void setTextWatcher(TextWatcher r10) {
        Intrinsics.checkNotNullParameter(r10, "textWatcher");
        clear();
        getTextWatchers().add(new WeakReference(r10));
        this.editText.addTextChangedListener(r10);
    }

    public final void setTitleContainer(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.titleContainer = r10;
    }

    public final void showErrorTips(String r10) {
        Intrinsics.checkNotNullParameter(r10, "tips");
        k.h(this.tvErrorTips);
        this.tvErrorTips.setText(r10);
    }

    public final void showPrefixView() {
        k.h(this.prefixContainer);
    }

    public final void showTitle() {
        k.h(this.tvTitle);
        if (this.titleContainer.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        k.h(this.titleContainer);
    L8:
        this.config.r(true);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void showTitleIcon() {
        if (this.titleContainer.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        k.h(this.titleContainer);
    L8:
        k.h(this.ivTitleIcon);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void updateConfig(c r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.config = r10;
        String r11 = r10.k();
        boolean r12 = true;
        if (r11 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L12;
        this.tvTitle.setText(r10.k());
    L12:
        if (r10.i() == false) goto L14;
        showTitle();
    L16:
        if (r10.g() == null) goto L19;
        View r14 = r10.g();
        Intrinsics.checkNotNull(r14);
        setPrefixView(r14);
    L19:
        if (TextUtils.isEmpty(r10.b()) == true) goto L22;
        this.editText.setHint(r10.b());
    L22:
        if (r10.a() == false) goto L25;
        this.editText.addTextChangedListener(new d(this));
    L25:
        if (r10.h() == true) goto L27;
    L32:
        r10.c();
        if (r10.c() <= 0) goto L36;
        ViewGroup r15 = this.inputContainer;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        Objects.requireNonNull(r16, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) r16;
        ((ViewGroup.MarginLayoutParams) r17).height = r10.c();
        r15.setLayoutParams(r17);
    L36:
        if (r10.j() == null) goto L39;
        TextWatcher r18 = r10.j();
        Intrinsics.checkNotNull(r18);
        setTextWatcher(r18);
    L39:
        if (r10.e() == null) goto L42;
        this.ivTitleIcon.setImageDrawable(r10.e());
    L42:
        if (this.showTitleDefaultIcon == true) goto L44;
    L46:
        String r19 = this.text;
        if (r19 != null) goto L49;
    L52:
        if (r12 == true) goto L54;
        setText(this.text);
    L54:
        this.editText.setGravity(this.textGravity);
        return;
    L49:
        if (r19.length() == 0) goto L52;
        r12 = false;
        goto L52
    L44:
        if (r10.e() != null) goto L46;
        showTitleIcon();
        goto L46
    L27:
        if (r10.f() == null) goto L32;
        this.counterTextWatcher = new e(this, r10);
        ArrayList<WeakReference<TextWatcher>> r20 = getTextWatchers();
        TextWatcher r21 = this.counterTextWatcher;
        Intrinsics.checkNotNull(r21);
        r20.add(new WeakReference(r21));
        this.editText.addTextChangedListener(this.counterTextWatcher);
        TextWatcher r22 = this.counterTextWatcher;
        if (r22 == null) goto L31;
        r22.onTextChanged(this.editText.getText(), 0, 0, 0);
    L31:
        k.h(this.tvCounter);
        goto L32
    L14:
        hideTitle();
        goto L16
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r13 = false;
        goto L9
    }
}
