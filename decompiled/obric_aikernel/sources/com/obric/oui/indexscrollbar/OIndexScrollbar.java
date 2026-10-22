package com.obric.oui.indexscrollbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.NpthBus;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004=>'?B\u001b\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\bJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019R\u001c\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u001c\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u001c\u0010+\u001a\u00020&8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b,\u0010\u001c\u001a\u0004\b-\u0010\u001eR\u001c\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b/\u0010\u001c\u001a\u0004\b0\u0010\u001eR\u0019\u00106\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u0006@"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar;", "Landroid/widget/LinearLayout;", "", "hostWidth", "", "setHostWidth", "state", "setState", "", "showBg", "setLettersBarBg", "visible", "setShadowVisible", "getScreenWidth", "getParentxPos", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$b;", "listener", "setQBListener", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$d;", "setSurnameListener", "setPoundVisibility", "position", "setPoundPosition", "enabled", "setLongPressEnabled", "Lcom/obric/oui/indexscrollbar/LettersBar;", "getLetterBar", "j0", "I", "getLETTER_CHANGED_CLICK", "()I", "LETTER_CHANGED_CLICK", "H", "getPOUND_POSITION_BOTTOM", "POUND_POSITION_BOTTOM", NpthBus.UUID_SUFIX_3_1_3, "getPOUND_POSITION_TOP", "POUND_POSITION_TOP", "", "c", "Ljava/lang/String;", "getOIndexScrollbar_TAG", "()Ljava/lang/String;", "OIndexScrollbar_TAG", "h0", "getVISIBILITY_LIMIT", "VISIBILITY_LIMIT", "i0", "getLETTER_CHANGED_SLIDE", "LETTER_CHANGED_SLIDE", "g", "Z", "getOIndexScrollbar_DEBUG", "()Z", "OIndexScrollbar_DEBUG", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "d", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OIndexScrollbar extends LinearLayout {
    private boolean A;
    private boolean B;
    private final List<s9.b> C;
    private int[] D;
    private Bitmap[][] E;
    private boolean F;
    private final int G;
    private final int H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private PopupWindow f6710J;
    private SurnameGridView K;
    private SurnameFlowLayout L;
    private final int M;
    private final int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final int f6711a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private PopupWindow f6712b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6713c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private TextView f6714c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final int f6715d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f6716e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f6717f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f6718g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private String f6719g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f6720h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final int f6721h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LettersBar f6722i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final int f6723i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private GridView f6724j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final int f6725j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f6726k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f6727k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f6728l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private int f6729l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f6730m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private boolean f6731m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6732n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private ViewGroup f6733n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f6734o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private View f6735o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6736p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f6737q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f6738r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f6739s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f6740t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f6741u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f6742v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f6743w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f6744x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private b f6745y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private d f6746z;

    public final class a extends BaseAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String[] f6747c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f6748g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f6749h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f6750i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Context f6751j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6752k;

        public a(OIndexScrollbar r10, Context r11) {
            this.f6752k = r10;
            this.f6751j = r11;
            Locale r12 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(r12, "Locale.getDefault()");
            String r13 = r12.getLanguage();
            Intrinsics.checkNotNullExpressionValue(r13, "Locale.getDefault().language");
            this.f6748g = r13;
            float r14 = s9.a.f12765f.j(r13);
            this.f6749h = r14;
            int r15 = ((int) Math.ceil(r14)) - 1;
            GridView r16 = OIndexScrollbar.c(r10);
            Intrinsics.checkNotNull(r16);
            this.f6750i = r15 * r16.getVerticalSpacing();
        }

        private final int b() {
            return (int) ((OIndexScrollbar.f(this.f6752k) - this.f6750i) / this.f6749h);
        }

        private final boolean c() {
            if (((int) ((OIndexScrollbar.f(this.f6752k) - this.f6750i) % this.f6749h)) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private final boolean d(int r10) {
            if (r10 != (getCount() - 1)) goto L5;
            return true;
        L5:
            if (r10 != (getCount() - 2)) goto L7;
            return true;
        L7:
            if (r10 == (getCount() - 3)) goto L13;
            return false;
        L13:
            return true;
        }

        public String a(int r10) {
            String[] r11 = this.f6747c;
            if (r11 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L6:
            return r11[r10];
        }

        public final void e(String[] r10) {
            if (r10 == null) goto L5;
            this.f6747c = r10;
            return;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] r10 = this.f6747c;
            if (r10 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L5:
            if (r10 == null) goto L10;
            String[] r11 = this.f6747c;
            if (r11 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L12:
            return r11.length;
        L10:
            return 0;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r10) {
            return a(r10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r10v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v6, types: [android.widget.ImageView] */
        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            Intrinsics.checkNotNullParameter(r12, "parent");
            String[] r13 = this.f6747c;
            if (r13 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L5:
            String r14 = r13[r10];
            int r15 = b();
            float r16 = OIndexScrollbar.f(this.f6752k) - this.f6750i;
            float r17 = this.f6749h;
            int r18 = (int) (r16 - (r15 * r17));
            if (r17 == 9.0f) goto L8;
        L12:
            if (r11 != 0) goto L26;
            s9.a r19 = s9.a.f12765f;
            if (r19.i(r14) == false) goto L16;
            r11 = new ImageView(this.f6751j);
            r11.setImageResource(u8.e.letter_bar_unfold_button);
            r11.setScaleType(ImageView.ScaleType.CENTER);
            r11.setMinimumHeight(r15);
            goto L26
        L16:
            AlphabetView r20 = new AlphabetView(this.f6751j, null, 0, 6, null);
            r20.setHeight(r15);
            if (r19.c(r14) == false) goto L20;
            r20.setTextColor(Color.parseColor("#80000000"));
            r14 = r14.substring(1);
            Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
        L20:
            if (r19.f(r14) == true) goto L23;
            r20.setText(r14);
        L23:
            if (r19.g(r14) == false) goto L25;
            r20.setTypeface(null, 0);
        L25:
            r11 = r20;
        L26:
            int r21 = (r10 / 3) % 2;
            Context r22 = this.f6751j;
            Intrinsics.checkNotNull(r22);
            Resources r23 = r22.getResources();
            if (r21 != 0) goto L29;
            int r24 = u8.e.quickbar_ex_alphabet_text_light_colorlist;
        L30:
            r11.setBackground(r23.getDrawable(r24));
            return r11;
        L29:
            r24 = u8.e.quickbar_ex_alphabet_text_dark_colorlist;
            goto L30
        L8:
            if (c() == false) goto L12;
            if (d(r10) == false) goto L12;
            r15 = r15 + r18;
            goto L12
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r10) {
            s9.a r11 = s9.a.f12765f;
            String[] r12 = this.f6747c;
            if (r12 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L6:
            if (r11.f(r12[r10]) == true) goto L13;
            String[] r13 = this.f6747c;
            if (r13 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L11:
            if (r11.c(r13[r10]) == true) goto L13;
            return true;
        L13:
            return false;
        }
    }

    public interface b {
        boolean a(String r10, int r11);

        void b();

        void c();
    }

    private final class c extends BaseAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f6753c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final List<String> f6754g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6755h;

        public c(OIndexScrollbar r10, Context r11, List<String> r12) {
            this.f6755h = r10;
            this.f6753c = r11;
            this.f6754g = r12;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> r10 = this.f6754g;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r10) {
            List<String> r11 = this.f6754g;
            if (r11 == null) goto L5;
            String r12 = r11.get(r10);
        L6:
            Intrinsics.checkNotNull(r12);
            return r12;
        L5:
            r12 = null;
            goto L6
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            Intrinsics.checkNotNullParameter(r12, "parent");
            if (r11 != null) goto L5;
            r11 = LayoutInflater.from(this.f6753c).inflate(u8.h.o_surname_popup_item_ex, null);
            r11.setLayoutParams(new AbsListView.LayoutParams(OIndexScrollbar.o(this.f6755h), OIndexScrollbar.n(this.f6755h)));
        L5:
            int r13 = r10 % OIndexScrollbar.m(this.f6755h);
            if (r13 == 0) goto L8;
        L10:
            if (r13 != 0) goto L14;
            int r14 = u8.e.surname_popup_item_right;
        L12:
            r11.setBackgroundResource(r14);
            List<String> r15 = this.f6754g;
            Intrinsics.checkNotNull(r15);
            ((TextView) r11).setText(r15.get(r10).toString());
            return r11;
        L14:
            if (r13 != (OIndexScrollbar.m(this.f6755h) - 1)) goto L16;
        L19:
            r14 = u8.e.surname_popup_item_left;
            goto L12
        L16:
            if (r10 == (getCount() - 1)) goto L19;
            r14 = u8.e.surname_popup_item_middle;
            goto L12
        L8:
            if (r10 != (getCount() - 1)) goto L10;
            r14 = u8.e.surname_popup_item_special;
            goto L12
        }
    }

    public interface d {
        void a(String r10);

        List<String> b(String r10);
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6756c;

        e(OIndexScrollbar r10) {
            this.f6756c = r10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "arg0");
            OIndexScrollbar.x(this.f6756c, false);
            OIndexScrollbar.s(this.f6756c);
            if (OIndexScrollbar.i(this.f6756c) == null) goto L6;
            b r11 = OIndexScrollbar.i(this.f6756c);
            Intrinsics.checkNotNull(r11);
            r11.b();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "arg0");
            OIndexScrollbar.x(this.f6756c, true);
        }
    }

    static final class f implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6757c;

        f(OIndexScrollbar r10) {
            this.f6757c = r10;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> r10, View r11, int r12, long r13) {
            s9.a r14 = s9.a.f12765f;
            a r15 = OIndexScrollbar.b(this.f6757c);
            Intrinsics.checkNotNull(r15);
            if (r14.i(r15.a(r12)) == true) goto L7;
            b r16 = OIndexScrollbar.i(this.f6757c);
            Intrinsics.checkNotNull(r16);
            a r17 = OIndexScrollbar.b(this.f6757c);
            Intrinsics.checkNotNull(r17);
            if (r16.a(r17.a(r12), this.f6757c.getLETTER_CHANGED_CLICK()) == false) goto L7;
            this.f6757c.invalidate();
        L7:
            OIndexScrollbar.r(this.f6757c);
        }
    }

    static final class g implements View.OnTouchListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6758c;

        g(OIndexScrollbar r10) {
            this.f6758c = r10;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r10, MotionEvent r11) {
            if (OIndexScrollbar.l(this.f6758c) != OIndexScrollbar.q(this.f6758c)) goto L12;
            Intrinsics.checkNotNullExpressionValue(r11, NotificationCompat.CATEGORY_EVENT);
            if (r11.getAction() == 0) goto L7;
            return false;
        L7:
            if (OIndexScrollbar.h(this.f6758c) == null) goto L15;
            PopupWindow r12 = OIndexScrollbar.h(this.f6758c);
            Intrinsics.checkNotNull(r12);
            if (r12.isShowing() == false) goto L16;
            PopupWindow r13 = OIndexScrollbar.h(this.f6758c);
            Intrinsics.checkNotNull(r13);
            r13.dismiss();
            return true;
        L16:
            return false;
        L15:
            return false;
        L12:
            return false;
        }
    }

    static final class h implements AdapterView.OnItemLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6759a;

        h(OIndexScrollbar r10) {
            this.f6759a = r10;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> r10, View r11, int r12, long r13) {
            if (OIndexScrollbar.e(this.f6759a) == true) goto L5;
            return false;
        L5:
            s9.a r14 = s9.a.f12765f;
            a r15 = OIndexScrollbar.b(this.f6759a);
            Intrinsics.checkNotNull(r15);
            if (r14.i(r15.a(r12)) == true) goto L13;
            Locale r16 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(r16, "Locale.getDefault()");
            String r17 = r16.getLanguage();
            Intrinsics.checkNotNullExpressionValue(r17, "Locale.getDefault().language");
            if (r14.k(r17) != 1) goto L10;
            OIndexScrollbar r18 = this.f6759a;
            Intrinsics.checkNotNullExpressionValue(r11, "view");
            OIndexScrollbar.A(r18, r11, r12);
        L11:
            OIndexScrollbar.w(this.f6759a, true);
            return true;
        L10:
            OIndexScrollbar r19 = this.f6759a;
            Intrinsics.checkNotNullExpressionValue(r11, "view");
            OIndexScrollbar.B(r19, r11, r12);
            goto L11
        L13:
            return false;
        }
    }

    public static final class i implements LettersBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6760a;

        i(OIndexScrollbar r10) {
            this.f6760a = r10;
        }

        @Override // com.obric.oui.indexscrollbar.LettersBar.b
        public boolean a(String r10) {
            if ((!Intrinsics.areEqual(r10, OIndexScrollbar.a(this.f6760a))) == false) goto L5;
            q9.a.f12489c.a(OIndexScrollbar.d(this.f6760a), 26);
        L5:
            OIndexScrollbar.u(this.f6760a, r10);
            if (OIndexScrollbar.i(this.f6760a) == null) goto L10;
            b r11 = OIndexScrollbar.i(this.f6760a);
            Intrinsics.checkNotNull(r11);
            if (r11.a(r10, this.f6760a.getLETTER_CHANGED_SLIDE()) == false) goto L10;
            return true;
        L10:
            return false;
        }
    }

    public static final class j implements LettersBar.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6761a;

        j(OIndexScrollbar r10) {
            this.f6761a = r10;
        }

        @Override // com.obric.oui.indexscrollbar.LettersBar.c
        public void a(boolean r10) {
            OIndexScrollbar.z(this.f6761a, r10);
        }
    }

    static final class k implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6762c;

        k(OIndexScrollbar r10) {
            this.f6762c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            Objects.requireNonNull(r10, "null cannot be cast to non-null type android.widget.TextView");
            String r11 = ((TextView) r10).getText().toString();
            d r12 = OIndexScrollbar.p(this.f6762c);
            Intrinsics.checkNotNull(r12);
            r12.a(r11);
            this.f6762c.F();
        }
    }

    static final class l implements View.OnTouchListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6763c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ TextView f6764g;

        l(OIndexScrollbar r10, TextView r11) {
            this.f6763c = r10;
            this.f6764g = r11;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r10, MotionEvent r11) {
            Intrinsics.checkNotNullExpressionValue(r11, "motionEvent");
            if (r11.getAction() == 0) goto L9;
            if (r11.getAction() == 2) goto L9;
            OIndexScrollbar r12 = this.f6763c;
            r10 = null;
        L16:
            OIndexScrollbar.C(r12, r10);
            return false;
        L9:
            if (OIndexScrollbar.j(this.f6763c) != null) goto L11;
        L15:
            Intrinsics.checkNotNullExpressionValue(r10, "view");
            r10.setTag(this.f6764g.getText());
            r12 = this.f6763c;
            goto L16
        L11:
            if (OIndexScrollbar.k(this.f6763c) == null) goto L15;
            CharSequence r13 = this.f6764g.getText();
            TextView r14 = OIndexScrollbar.k(this.f6763c);
            Intrinsics.checkNotNull(r14);
            if ((!Intrinsics.areEqual(r13, r14.getText())) == false) goto L15;
            PopupWindow r15 = OIndexScrollbar.j(this.f6763c);
            Intrinsics.checkNotNull(r15);
            r15.dismiss();
            goto L15
        }
    }

    public static final class m implements SurnameGridView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6765a;

        static final class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ m f6766c;

            a(m r10) {
                this.f6766c = r10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OIndexScrollbar.C(this.f6766c.f6765a, null);
            }
        }

        m(OIndexScrollbar r10) {
            this.f6765a = r10;
        }

        @Override // com.obric.oui.indexscrollbar.SurnameGridView.a
        public void a(int r10) {
            if (r10 != (-1)) goto L5;
            new Handler(Looper.getMainLooper()).postDelayed(new a(this), 100);
            return;
        L5:
            SurnameGridView r11 = OIndexScrollbar.g(this.f6765a);
            Intrinsics.checkNotNull(r11);
            SurnameGridView r12 = OIndexScrollbar.g(this.f6765a);
            Intrinsics.checkNotNull(r12);
            View r13 = r11.getChildAt(r10 - r12.getFirstVisiblePosition());
            Intrinsics.checkNotNullExpressionValue(r13, "mPopupGridView!!.getChil…etFirstVisiblePosition())");
            if (r13 == null) goto L10;
            SurnameGridView r14 = OIndexScrollbar.g(this.f6765a);
            Intrinsics.checkNotNull(r14);
            Object r15 = r14.getAdapter().getItem(r10);
            Objects.requireNonNull(r15, "null cannot be cast to non-null type kotlin.String");
            r13.setTag((String) r15);
            OIndexScrollbar.C(this.f6765a, r13);
            return;
        }
    }

    static final class n implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6767c;

        n(OIndexScrollbar r10) {
            this.f6767c = r10;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> r10, View r11, int r12, long r13) {
            Object r14 = r10.getItemAtPosition(r12);
            Objects.requireNonNull(r14, "null cannot be cast to non-null type kotlin.String");
            d r15 = OIndexScrollbar.p(this.f6767c);
            Intrinsics.checkNotNull(r15);
            r15.a((String) r14);
            this.f6767c.F();
        }
    }

    public static final class o implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OIndexScrollbar f6768c;

        o(OIndexScrollbar r10) {
            this.f6768c = r10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "arg0");
            OIndexScrollbar.y(this.f6768c, false);
            OIndexScrollbar.t(this.f6768c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "arg0");
            OIndexScrollbar.y(this.f6768c, true);
            OIndexScrollbar.v(this.f6768c, true);
        }
    }

    public OIndexScrollbar(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.f6713c = "OIndexScrollbar";
        this.f6718g = Log.isLoggable("OIndexScrollbar", 3);
        this.f6739s = 1;
        this.f6740t = 2;
        this.f6741u = 3;
        this.f6742v = 1;
        this.C = new ArrayList();
        this.F = true;
        this.G = 1;
        this.H = 2;
        this.I = 2;
        this.M = 8;
        this.N = 8;
        this.f6711a0 = 3;
        this.f6715d0 = -99999;
        this.f6716e0 = -99999;
        I(r10);
        this.f6721h0 = 30;
        this.f6725j0 = 1;
        this.f6729l0 = -1;
        this.f6731m0 = true;
    }

    public static final /* synthetic */ void A(OIndexScrollbar r10, View r11, int r12) {
        r10.R(r11, r12);
    }

    public static final /* synthetic */ void B(OIndexScrollbar r10, View r11, int r12) {
        r10.S(r11, r12);
    }

    public static final /* synthetic */ void C(OIndexScrollbar r10, View r11) {
        r10.U(r11);
    }

    private final int D(double r10) {
        Context r11 = this.f6720h;
        Intrinsics.checkNotNull(r11);
        Resources r12 = r11.getResources();
        Intrinsics.checkNotNullExpressionValue(r12, "mContext!!.resources");
        return (int) ((r10 * ((double) r12.getDisplayMetrics().density)) + ((double) 0.5f));
    }

    private final void E() {
        PopupWindow r10 = this.f6710J;
        if (r10 == null) goto L5;
        Intrinsics.checkNotNull(r10);
        r10.dismiss();
        this.f6710J = null;
        this.K = null;
        this.L = null;
    L5:
        PopupWindow r11 = this.f6712b0;
        if (r11 == null) goto L9;
        Intrinsics.checkNotNull(r11);
        r11.dismiss();
        this.f6712b0 = null;
        this.f6714c0 = null;
        return;
    }

    private final void H() {
        E();
        AnimatorSet r10 = new AnimatorSet();
        ObjectAnimator r11 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.f6730m})});
        Intrinsics.checkNotNullExpressionValue(r11, "ObjectAnimator.ofPropertyValuesHolder(this, pvhX)");
        r10.play(r11);
        r10.setDuration(200);
        r10.addListener(new e(this));
        r10.start();
    }

    private final void J() {
        View r10 = findViewById(u8.f.quickbar_right_grid_view);
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.widget.GridView");
        this.f6724j = (GridView) r10;
        a r11 = new a(this, this.f6720h);
        this.f6728l = r11;
        Intrinsics.checkNotNull(r11);
        s9.a r12 = s9.a.f12765f;
        Locale r13 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r13, "Locale.getDefault()");
        String r14 = r13.getLanguage();
        Intrinsics.checkNotNullExpressionValue(r14, "Locale.getDefault().language");
        r11.e(r12.a(r14));
        GridView r15 = this.f6724j;
        Intrinsics.checkNotNull(r15);
        r15.setAdapter(this.f6728l);
        GridView r16 = this.f6724j;
        Intrinsics.checkNotNull(r16);
        r16.setOnItemClickListener(new f(this));
        GridView r17 = this.f6724j;
        Intrinsics.checkNotNull(r17);
        r17.setOnTouchListener(new g(this));
        GridView r18 = this.f6724j;
        Intrinsics.checkNotNull(r18);
        r18.setOnItemLongClickListener(new h(this));
    }

    private final void L() {
        View r10 = findViewById(u8.f.quickbar_left_letters_bar);
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.indexscrollbar.LettersBar");
        LettersBar r11 = (LettersBar) r10;
        this.f6722i = r11;
        Intrinsics.checkNotNull(r11);
        r11.setLetters(this.C);
        LettersBar r12 = this.f6722i;
        Intrinsics.checkNotNull(r12);
        r12.setListener(new i(this));
        LettersBar r13 = this.f6722i;
        Intrinsics.checkNotNull(r13);
        r13.setOnBackgroundVisibleChangedListener(new j(this));
        K();
    }

    private final int N(int r10) {
        return View.MeasureSpec.getSize(r10);
    }

    private final void O() {
        setState(this.f6739s);
        setX(this.f6730m);
        setLettersBarBg(false);
    }

    private final void P(MotionEvent r13) {
        PopupWindow r10 = this.f6710J;
        if (r10 == null) goto L50;
        Intrinsics.checkNotNull(r10);
        if (r10.isShowing() == false) goto L54;
        int r11 = (int) r13.getRawX();
        int r14 = (int) r13.getRawY();
        s9.a r12 = s9.a.f12765f;
        Locale r15 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r15, "Locale.getDefault()");
        String r16 = r15.getLanguage();
        Intrinsics.checkNotNullExpressionValue(r16, "Locale.getDefault().language");
        if (r12.k(r16) != 1) goto L31;
        SurnameFlowLayout r17 = this.L;
        if (r17 == null) goto L51;
        int[] r18 = new int[2];
        Intrinsics.checkNotNull(r17);
        r17.getLocationOnScreen(r18);
        int r19 = -1;
        SurnameFlowLayout r20 = this.L;
        Intrinsics.checkNotNull(r20);
        int r21 = r20.getChildCount();
        int r22 = 0;
    L12:
        if (r22 >= r21) goto L18;
        SurnameFlowLayout r23 = this.L;
        Intrinsics.checkNotNull(r23);
        View r24 = r23.getChildAt(r22);
        Intrinsics.checkNotNullExpressionValue(r24, "mPopupFlowLayout!!.getChildAt(i)");
        Rect r110 = new Rect();
        r24.getHitRect(r110);
        if (r110.contains(r11 - r18[0], r14 - r18[1]) == true) goto L15;
        r22 = r22 + 1;
        goto L12
    L15:
        r19 = r22;
    L18:
        if (r19 >= 0) goto L20;
        SurnameFlowLayout r25 = this.L;
        Intrinsics.checkNotNull(r25);
        View r26 = r25.getChildAt(this.f6729l0);
        Intrinsics.checkNotNullExpressionValue(r26, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        if (r26 == null) goto L30;
        r26.setPressed(false);
        U(null);
    L30:
        this.f6729l0 = r19;
        return;
    L20:
        if (this.f6729l0 == r19) goto L30;
        SurnameFlowLayout r27 = this.L;
        Intrinsics.checkNotNull(r27);
        View r28 = r27.getChildAt(this.f6729l0);
        Intrinsics.checkNotNullExpressionValue(r28, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        if (r28 == null) goto L24;
        r28.setPressed(false);
        U(null);
    L24:
        SurnameFlowLayout r111 = this.L;
        Intrinsics.checkNotNull(r111);
        View r112 = r111.getChildAt(r19);
        Intrinsics.checkNotNullExpressionValue(r112, "mPopupFlowLayout!!.getChildAt(position)");
        if (r112 == null) goto L30;
        r112.setPressed(true);
        CharSequence r29 = ((TextView) r112).getText();
        Objects.requireNonNull(r29, "null cannot be cast to non-null type kotlin.String");
        r112.setTag((String) r29);
        U(r112);
        goto L30
    L51:
        return;
    L31:
        SurnameGridView r30 = this.K;
        if (r30 == null) goto L53;
        int[] r31 = new int[2];
        Intrinsics.checkNotNull(r30);
        r30.getLocationOnScreen(r31);
        int r32 = r11 - r31[0];
        int r113 = r14 - r31[1];
        SurnameGridView r33 = this.K;
        Intrinsics.checkNotNull(r33);
        int r114 = r33.pointToPosition(r32, r113);
        if (r114 >= 0) goto L36;
        SurnameGridView r34 = this.K;
        Intrinsics.checkNotNull(r34);
        View r35 = r34.getChildAt(this.f6729l0);
        Intrinsics.checkNotNullExpressionValue(r35, "mPopupGridView!!.getChildAt(mPrePosition)");
        if (r35 == null) goto L46;
        r35.setPressed(false);
        U(null);
    L46:
        this.f6729l0 = r114;
        return;
    L36:
        if (this.f6729l0 == r114) goto L46;
        SurnameGridView r36 = this.K;
        Intrinsics.checkNotNull(r36);
        View r37 = r36.getChildAt(this.f6729l0);
        Intrinsics.checkNotNullExpressionValue(r37, "mPopupGridView!!.getChildAt(mPrePosition)");
        if (r37 == null) goto L40;
        r37.setPressed(false);
        U(null);
    L40:
        SurnameGridView r38 = this.K;
        Intrinsics.checkNotNull(r38);
        View r39 = r38.getChildAt(r114);
        Intrinsics.checkNotNullExpressionValue(r39, "mPopupGridView!!.getChildAt(position)");
        if (r39 == null) goto L46;
        r39.setPressed(true);
        SurnameGridView r40 = this.K;
        Intrinsics.checkNotNull(r40);
        Object r41 = r40.getAdapter().getItem(r114);
        Objects.requireNonNull(r41, "null cannot be cast to non-null type kotlin.String");
        r39.setTag((String) r41);
        U(r39);
        goto L46
    L53:
        return;
    L54:
        return;
    }

    private final void Q() {
        setX(this.f6732n);
        setState(this.f6741u);
        setLettersBarBg(true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void R(View r19, int r20) {
        if (this.f6746z == null) goto L97;
        s9.a r10 = s9.a.f12765f;
        Locale r11 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r11, "Locale.getDefault()");
        String r12 = r11.getLanguage();
        Intrinsics.checkNotNullExpressionValue(r12, "Locale.getDefault().language");
        a r13 = this.f6728l;
        Intrinsics.checkNotNull(r13);
        if (r10.h(r12, r13.a(r20)) == true) goto L7;
        return;
    L7:
        d r14 = this.f6746z;
        Intrinsics.checkNotNull(r14);
        a r15 = this.f6728l;
        Intrinsics.checkNotNull(r15);
        List<String> r16 = r14.b(r15.a(r20));
        if (r16 != null) goto L10;
        return;
    L10:
        if (r16.size() == 0) goto L102;
        ViewGroup r17 = null;
        View r18 = LayoutInflater.from(this.f6720h).inflate(u8.h.o_surname_flow_popup, null);
        Intrinsics.checkNotNullExpressionValue(r18, "LayoutInflater.from(mCon…surname_flow_popup, null)");
        View r21 = r18.findViewById(u8.f.surname_content);
        Objects.requireNonNull(r21, "null cannot be cast to non-null type com.obric.oui.indexscrollbar.SurnameFlowLayout");
        this.L = (SurnameFlowLayout) r21;
        this.Q = D(7.0d);
        this.R = D((this.N * 33) + 19);
        this.O = D(40.0d);
        this.P = D(33.0d);
        this.W = this.M;
        int r22 = D(98.0d);
        Drawable r23 = getResources().getDrawable(u8.e.surname_popup_item_left);
        int r24 = this.W * this.O;
        Iterator<String> r25 = r16.iterator();
        int r110 = 1;
        int r111 = 0;
        int r112 = 0;
    L14:
        if (r25.hasNext() == false) goto L38;
        String r113 = r25.next();
        View r26 = LayoutInflater.from(this.f6720h).inflate(u8.h.o_surname_popup_item_ex, r17);
        Objects.requireNonNull(r26, "null cannot be cast to non-null type android.widget.TextView");
        TextView r27 = (TextView) r26;
        r27.setText(r113);
        ViewGroup.MarginLayoutParams r114 = new ViewGroup.MarginLayoutParams(-2, -2);
        r114.height = this.P;
        r27.setLayoutParams(r114);
        Drawable r115 = r23;
        r27.setPadding(D(10.0d), 0, D(10.0d), 0);
        if (r16.size() != 1) goto L18;
        int r28 = u8.e.surname_popup_item_special;
    L19:
        r27.setBackgroundResource(r28);
        int r29 = (int) Math.ceil(r27.getPaint().measureText(r113));
        if (r115 == null) goto L26;
        int r116 = r115.getIntrinsicWidth();
        if (r116 <= 0) goto L26;
        int r117 = r110;
        double r118 = 20.0d;
        if (r116 <= (D(20.0d) + r29)) goto L27;
        r29 = r116 - D(20.0d);
    L27:
        if (r29 <= r22) goto L29;
        r29 = r22;
    L29:
        int r30 = r29 + D(r118);
        if ((r112 + r30) <= r24) goto L32;
        r110 = r117 + 1;
        r112 = 0;
    L33:
        r112 = r112 + r30;
        if (r111 > r112) goto L37;
        r111 = r112;
    L37:
        r27.setOnClickListener(new k(this));
        r27.setOnTouchListener(new l(this, r27));
        SurnameFlowLayout r31 = this.L;
        Intrinsics.checkNotNull(r31);
        r31.addView(r27);
        r23 = r115;
        r17 = null;
        goto L14
    L32:
        r110 = r117;
    L26:
        r117 = r110;
        r118 = 20.0d;
        goto L27
    L18:
        r28 = u8.e.surname_popup_item_left;
        goto L19
    L38:
        this.V = r110;
        SurnameFlowLayout r32 = this.L;
        Intrinsics.checkNotNull(r32);
        r32.measure(0, 0);
        if (this.f6718g == false) goto L41;
        Log.d(this.f6713c, "surname FlowLayout, width = " + r111);
        String r33 = this.f6713c;
        StringBuilder r34 = new StringBuilder();
        r34.append("surname FlowLayout, measuredHeight = ");
        SurnameFlowLayout r35 = this.L;
        Intrinsics.checkNotNull(r35);
        r34.append(r35.getMeasuredHeight());
        Log.d(r33, r34.toString());
    L41:
        SurnameFlowLayout r36 = this.L;
        Intrinsics.checkNotNull(r36);
        ViewGroup.LayoutParams r37 = r36.getLayoutParams();
        Objects.requireNonNull(r37, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r38 = (FrameLayout.LayoutParams) r37;
        r38.width = r111;
        SurnameFlowLayout r39 = this.L;
        Intrinsics.checkNotNull(r39);
        r39.setLayoutParams(r38);
        if (this.f6710J != null) goto L44;
        PopupWindow r40 = new PopupWindow();
        this.f6710J = r40;
        Intrinsics.checkNotNull(r40);
        r40.setWindowLayoutMode(-2, -2);
        PopupWindow r41 = this.f6710J;
        Intrinsics.checkNotNull(r41);
        r41.setBackgroundDrawable(getResources().getDrawable(u8.c.Transparent));
        PopupWindow r42 = this.f6710J;
        Intrinsics.checkNotNull(r42);
        r42.setClippingEnabled(true);
    L44:
        PopupWindow r43 = this.f6710J;
        Intrinsics.checkNotNull(r43);
        r43.setContentView(r18);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r44 = new int[2];
        r19.getLocationOnScreen(r44);
        int r45 = r44[0] + (r19.getWidth() / 2);
        int r46 = r44[1] + (r19.getHeight() / 2);
        if (this.f6718g == false) goto L47;
        String r47 = this.f6713c;
        StringBuilder r48 = new StringBuilder();
        r48.append("alphabet anchorX = ");
        int r119 = 0;
        r48.append(r44[0]);
        r48.append(", anchorY = ");
        r48.append(r44[1]);
        Log.d(r47, r48.toString());
    L48:
        r18.measure(r119, r119);
        int r49 = r18.getMeasuredWidth();
        int r50 = r18.getMeasuredHeight();
        if (this.f6718g == false) goto L51;
        Log.d(this.f6713c, "popMeasureWidth = " + r49 + ", popMeasureHeight = " + r50);
    L51:
        int r51 = this.f6711a0;
        if (r20 >= r51) goto L56;
        boolean r120 = true;
        if (this.V > 1) goto L77;
    L57:
        if (r20 < r51) goto L63;
        if (r20 >= (r51 * 2)) goto L63;
        if (this.V > 3) goto L77;
    L63:
        if (r20 < (r51 * 2)) goto L69;
        if (r20 >= (r51 * 3)) goto L69;
        if (this.V > 5) goto L77;
    L69:
        if (r20 >= (r51 * 3)) goto L71;
    L75:
        r120 = false;
        goto L77
    L71:
        if (r20 >= (r51 * 4)) goto L75;
        if (this.V <= 7) goto L75;
    L77:
        if (r120 == false) goto L79;
        View r52 = r18.findViewById(u8.f.surname_popup_top_arrow);
        Objects.requireNonNull(r52, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r53 = (ImageView) r52;
        int r54 = r46 + this.Q;
    L80:
        r53.setVisibility(0);
        r53.measure(0, 0);
        int r55 = r53.getMeasuredWidth();
        if (this.f6718g == false) goto L83;
        Log.d(this.f6713c, "arrowWidth = " + r55);
    L83:
        int r121 = r49 / 2;
        int r122 = (int) Math.min(getScreenWidth() - r45, r121);
        int r56 = r45 - r121;
        int r57 = (r49 - r122) - (r55 / 2);
        View r58 = r18.findViewById(u8.f.surname_top_mask);
        Objects.requireNonNull(r58, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r59 = (ImageView) r58;
        ViewGroup.LayoutParams r60 = r59.getLayoutParams();
        Objects.requireNonNull(r60, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r61 = (FrameLayout.LayoutParams) r60;
        r61.width = r111;
        View r123 = r18.findViewById(u8.f.surname_bottom_mask);
        Objects.requireNonNull(r123, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r124 = (ImageView) r123;
        ViewGroup.LayoutParams r62 = r124.getLayoutParams();
        Objects.requireNonNull(r62, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r63 = (FrameLayout.LayoutParams) r62;
        r63.width = r111;
        View r64 = r18.findViewById(u8.f.surname_container);
        Objects.requireNonNull(r64, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r65 = (LinearLayout) r64;
        ViewGroup.LayoutParams r125 = r65.getLayoutParams();
        Objects.requireNonNull(r125, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r126 = (FrameLayout.LayoutParams) r125;
        SurnameFlowLayout r66 = this.L;
        Intrinsics.checkNotNull(r66);
        int r67 = r66.getMeasuredHeight();
        int r127 = this.R;
        if (r67 <= r127) goto L86;
        r126.height = r127;
    L86:
        r65.setLayoutParams(r126);
        if (r111 != (this.W * this.O)) goto L89;
        r65.setPadding(D(14.0d), D(1.5d), D(17.0d), D(4.0d));
        r57 = r57 + getResources().getDimensionPixelSize(u8.d.surname_arrow_offset_x);
        r61.leftMargin = D(20.0d);
        r63.leftMargin = D(20.0d);
        r61.width -= D(10.0d);
        r63.width -= D(10.0d);
    L90:
        r59.setLayoutParams(r61);
        r124.setLayoutParams(r63);
        r53.setTranslationX(r57);
        if (Math.abs(getX() - this.f6732n) <= D(1.0d)) goto L94;
        Log.d(this.f6713c, "GridView is hiding now...");
        return;
    L94:
        PopupWindow r68 = this.f6710J;
        Intrinsics.checkNotNull(r68);
        r68.showAtLocation(this, 0, r56, r54);
        return;
    L89:
        r56 = r56 - 1;
        goto L90
    L79:
        View r69 = r18.findViewById(u8.f.surname_popup_bottom_arrow);
        Objects.requireNonNull(r69, "null cannot be cast to non-null type android.widget.ImageView");
        r54 = (r46 - r50) - this.Q;
        r53 = (ImageView) r69;
        goto L80
    L56:
        r120 = true;
        goto L57
    L47:
        r119 = 0;
        goto L48
    L102:
        return;
    L97:
        throw new IllegalArgumentException("You must implements SurnameListener".toString());
    }

    private final void S(View r18, int r19) {
        if (this.f6746z == null) goto L82;
        s9.a r10 = s9.a.f12765f;
        Locale r11 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r11, "Locale.getDefault()");
        String r12 = r11.getLanguage();
        Intrinsics.checkNotNullExpressionValue(r12, "Locale.getDefault().language");
        a r13 = this.f6728l;
        Intrinsics.checkNotNull(r13);
        if (r10.h(r12, r13.a(r19)) == true) goto L7;
        return;
    L7:
        d r14 = this.f6746z;
        Intrinsics.checkNotNull(r14);
        a r15 = this.f6728l;
        Intrinsics.checkNotNull(r15);
        List<String> r16 = r14.b(r15.a(r19));
        if (r16 != null) goto L10;
        return;
    L10:
        if (r16.size() == 0) goto L84;
        c r17 = new c(this, this.f6720h, r16);
        View r20 = LayoutInflater.from(this.f6720h).inflate(u8.h.o_surname_popup, null);
        Intrinsics.checkNotNullExpressionValue(r20, "LayoutInflater.from(mCon…ut.o_surname_popup, null)");
        View r21 = r20.findViewById(u8.f.surname_content);
        Objects.requireNonNull(r21, "null cannot be cast to non-null type com.obric.oui.indexscrollbar.SurnameGridView");
        this.K = (SurnameGridView) r21;
        this.Q = D(7.0d);
        this.P = D(33.0d);
        this.R = D((this.N * 33) + 19);
        this.S = D(16.0d);
        this.T = D(6.0d);
        this.W = this.M;
        this.O = D(40.0d);
        int r22 = r16.size();
        int r23 = this.W;
        if (r22 >= r23) goto L16;
        r23 = r16.size();
    L16:
        this.U = r23;
        int r24 = (int) Math.ceil((((double) r16.size()) * 1.0d) / ((double) this.U));
        this.V = r24;
        int r25 = (this.U * this.O) + (this.T * 2);
        if (r24 <= this.N) goto L19;
        int r26 = this.R;
    L20:
        int r27 = r26 + (this.S * 2);
        if (this.f6718g == false) goto L23;
        Log.d(this.f6713c, "surname GridView, width = " + r25 + ", height = " + r27);
    L23:
        SurnameGridView r28 = this.K;
        Intrinsics.checkNotNull(r28);
        r28.setNumColumns(this.U);
        SurnameGridView r29 = this.K;
        Intrinsics.checkNotNull(r29);
        r29.setLayoutParams(new LinearLayout.LayoutParams(r25, r27));
        SurnameGridView r30 = this.K;
        Intrinsics.checkNotNull(r30);
        r30.setGravity(17);
        SurnameGridView r31 = this.K;
        Intrinsics.checkNotNull(r31);
        r31.setAdapter(r17);
        SurnameGridView r32 = this.K;
        Intrinsics.checkNotNull(r32);
        r32.setOnPressChangeListener(new m(this));
        SurnameGridView r33 = this.K;
        Intrinsics.checkNotNull(r33);
        r33.setOnItemClickListener(new n(this));
        boolean r34 = true;
        if (this.f6710J != null) goto L26;
        PopupWindow r35 = new PopupWindow();
        this.f6710J = r35;
        Intrinsics.checkNotNull(r35);
        r35.setWindowLayoutMode(-2, -2);
        PopupWindow r36 = this.f6710J;
        Intrinsics.checkNotNull(r36);
        r36.setBackgroundDrawable(getResources().getDrawable(u8.c.Transparent));
        PopupWindow r37 = this.f6710J;
        Intrinsics.checkNotNull(r37);
        r37.setClippingEnabled(true);
    L26:
        PopupWindow r38 = this.f6710J;
        Intrinsics.checkNotNull(r38);
        r38.setContentView(r20);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r39 = new int[2];
        r18.getLocationOnScreen(r39);
        if (this.f6718g == false) goto L29;
        Log.d(this.f6713c, "alphabetView.getWidth = " + r18.getWidth() + ", alphabetView.getHeight = " + r18.getHeight());
    L29:
        int r110 = r39[0] + (r18.getWidth() / 2);
        int r111 = r39[1] + (r18.getHeight() / 2);
        if (this.f6718g == false) goto L32;
        Log.d(this.f6713c, "alphabet anchorX = " + r39[0] + ", anchorY = " + r39[1]);
    L32:
        r20.measure(0, 0);
        int r40 = r20.getMeasuredWidth();
        int r41 = r20.getMeasuredHeight();
        if (this.f6718g == false) goto L35;
        Log.d(this.f6713c, "popMeasureWidth = " + r40 + ", popMeasureHeight = " + r41);
    L35:
        int r42 = this.f6711a0;
        if (r19 < r42) goto L38;
    L39:
        if (r19 < r42) goto L45;
        if (r19 >= (r42 * 2)) goto L45;
        if (this.V <= 3) goto L45;
    L59:
        if (r34 == false) goto L61;
        View r43 = r20.findViewById(u8.f.surname_popup_top_arrow);
        Objects.requireNonNull(r43, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r44 = (ImageView) r43;
        int r112 = r111 + this.Q;
    L62:
        r44.setVisibility(0);
        r44.measure(0, 0);
        int r45 = r44.getMeasuredWidth();
        if (this.f6718g == false) goto L65;
        Log.d(this.f6713c, "arrowWidth = " + r45);
    L65:
        int r113 = r40 / 2;
        int r46 = r110 - r113;
        int r47 = r45 / 2;
        int r48 = (r40 - ((int) Math.min(getScreenWidth() - r110, r113))) - r47;
        View r49 = r20.findViewById(u8.f.surname_top_mask);
        Objects.requireNonNull(r49, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r50 = (ImageView) r49;
        ViewGroup.LayoutParams r51 = r50.getLayoutParams();
        Objects.requireNonNull(r51, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r52 = (FrameLayout.LayoutParams) r51;
        r52.width = this.U * this.O;
        View r114 = r20.findViewById(u8.f.surname_bottom_mask);
        Objects.requireNonNull(r114, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r115 = (ImageView) r114;
        ViewGroup.LayoutParams r53 = r115.getLayoutParams();
        Objects.requireNonNull(r53, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r54 = (FrameLayout.LayoutParams) r53;
        r54.width = this.U * this.O;
        View r55 = r20.findViewById(u8.f.surname_container);
        Objects.requireNonNull(r55, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r56 = (LinearLayout) r55;
        int r116 = this.U;
        int r117 = this.W;
        if (r116 != r117) goto L71;
        int r118 = this.M;
        if (r117 != r118) goto L70;
        r56.setPadding(D(14.0d), D(1.5d), D(17.0d), D(4.0d));
        r48 = r48 + getResources().getDimensionPixelSize(u8.d.surname_arrow_offset_x);
        FrameLayout.LayoutParams r119 = r52;
        r119.leftMargin = D(20.0d);
        r54.leftMargin = D(20.0d);
    L73:
        if (this.f6718g == false) goto L75;
        Log.d(this.f6713c, "arrowTranslationX = " + r48);
    L75:
        r44.setTranslationX(r48);
        r50.setLayoutParams(r119);
        r115.setLayoutParams(r54);
        if (Math.abs(getX() - this.f6732n) <= D(1.0d)) goto L79;
        Log.d(this.f6713c, "GridView is hiding now...");
        return;
    L79:
        PopupWindow r57 = this.f6710J;
        Intrinsics.checkNotNull(r57);
        r57.showAtLocation(this, 0, r46, r112);
        return;
    L70:
        r119 = r52;
        int r120 = ((r118 * D(40.0d)) - (this.U * this.O)) / 2;
        r56.setPadding(D(14.0d) + r120, D(1.5d), D(17.0d) + r120, D(4.0d));
        r48 = r110 - r47;
        r119.leftMargin = D(20.0d) + r120;
        r54.leftMargin = D(20.0d) + r120;
        goto L73
    L71:
        r119 = r52;
        r46 = r46 - 1;
        goto L73
    L61:
        View r58 = r20.findViewById(u8.f.surname_popup_bottom_arrow);
        Objects.requireNonNull(r58, "null cannot be cast to non-null type android.widget.ImageView");
        r44 = (ImageView) r58;
        r112 = (r111 - r41) - this.Q;
    L45:
        if (r19 < (r42 * 2)) goto L51;
        if (r19 >= (r42 * 3)) goto L51;
        if (this.V > 5) goto L59;
    L51:
        if (r19 >= (r42 * 3)) goto L53;
    L57:
        r34 = false;
        goto L59
    L53:
        if (r19 >= (r42 * 4)) goto L57;
        if (this.V <= 7) goto L57;
    L38:
        if (this.V > 1) goto L59;
    L19:
        r26 = r24 * this.P;
        goto L20
    L84:
        return;
    L82:
        throw new IllegalArgumentException("You must implements SurnameListener".toString());
    }

    private final void T() {
        b r10 = this.f6745y;
        if (r10 == null) goto L5;
        Intrinsics.checkNotNull(r10);
        r10.c();
    L5:
        AnimatorSet r11 = new AnimatorSet();
        ObjectAnimator r12 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.f6732n})});
        Intrinsics.checkNotNullExpressionValue(r12, "ObjectAnimator.ofPropertyValuesHolder(this, pvhX)");
        r11.play(r12);
        r11.setDuration(200);
        r11.addListener(new o(this));
        r11.start();
    }

    private final void U(View r11) {
        if (r11 != null) goto L8;
        PopupWindow r10 = this.f6712b0;
        if (r10 == null) goto L25;
        Intrinsics.checkNotNull(r10);
        r10.dismiss();
        return;
    L25:
        return;
    L8:
        if (this.f6712b0 != null) goto L10;
        PopupWindow r12 = new PopupWindow();
        this.f6712b0 = r12;
        Intrinsics.checkNotNull(r12);
        r12.setWindowLayoutMode(-2, -2);
        PopupWindow r13 = this.f6712b0;
        Intrinsics.checkNotNull(r13);
        r13.setBackgroundDrawable(getResources().getDrawable(u8.c.Transparent));
        PopupWindow r14 = this.f6712b0;
        Intrinsics.checkNotNull(r14);
        r14.setClippingEnabled(true);
        ViewGroup r15 = (ViewGroup) LayoutInflater.from(getContext()).inflate(u8.h.o_surname_second_popup_ex, null);
        this.f6733n0 = r15;
        Intrinsics.checkNotNull(r15);
        this.f6735o0 = r15.getChildAt(1);
        ViewGroup r16 = this.f6733n0;
        Intrinsics.checkNotNull(r16);
        View r17 = r16.getChildAt(0);
        Objects.requireNonNull(r17, "null cannot be cast to non-null type android.widget.TextView");
        this.f6714c0 = (TextView) r17;
    L10:
        PopupWindow r18 = this.f6712b0;
        Intrinsics.checkNotNull(r18);
        r18.setContentView(this.f6733n0);
        int[] r19 = new int[2];
        r11.getLocationOnScreen(r19);
        Log.d(this.f6713c, "original anchorViewLocation[0] = " + r19[0] + ", anchorViewLocation[1] = " + r19[1]);
        int[] r20 = new int[2];
        getRootView().getLocationOnScreen(r20);
        Log.d(this.f6713c, "rootViewLocation[0] = " + r20[0] + ", rootViewLocation[1] = " + r20[1]);
        String r21 = r11.getTag().toString();
        TextView r22 = this.f6714c0;
        Intrinsics.checkNotNull(r22);
        r22.setText(r21);
        TextView r23 = this.f6714c0;
        Intrinsics.checkNotNull(r23);
        r23.measure(0, 0);
        TextView r24 = this.f6714c0;
        Intrinsics.checkNotNull(r24);
        int r25 = ((int) r24.getPaint().measureText(r21)) + D(40.0d);
        int r26 = D(320.0d);
        if (r25 <= r26) goto L13;
        r25 = r26;
    L13:
        TextView r27 = this.f6714c0;
        Intrinsics.checkNotNull(r27);
        int r28 = r27.getMeasuredHeight();
        int r29 = r11.getWidth();
        int r30 = r11.getHeight();
        int r31 = (r19[0] - r20[0]) + (r29 / 2);
        int r32 = (r19[1] - r20[1]) + (r30 / 2);
        int r33 = r25 / 2;
        int r34 = r31 - r33;
        int r35 = (r32 - r28) - 20;
        View r36 = this.f6735o0;
        Intrinsics.checkNotNull(r36);
        r36.getLocationOnScreen(new int[2]);
        View r37 = this.f6735o0;
        Intrinsics.checkNotNull(r37);
        r37.setTranslationX(0.0f);
        if (r34 >= 0) goto L17;
        View r38 = this.f6735o0;
        Intrinsics.checkNotNull(r38);
        float r39 = r34;
    L16:
        r38.setTranslationX(r39);
    L21:
        if (this.f6718g == false) goto L23;
        Log.d(this.f6713c, "x = " + r34 + ", width = " + r25 + ", anchorView.getWidth() = " + r11.getWidth());
        Log.d(this.f6713c, "y = " + r35 + ", height = " + r28 + ", anchorView.getHeight() = " + r11.getHeight());
    L23:
        PopupWindow r110 = this.f6712b0;
        Intrinsics.checkNotNull(r110);
        r110.showAtLocation(this, 51, r34, r35);
        return;
    L17:
        int r40 = r31 + r33;
        if (r40 <= getScreenWidth()) goto L21;
        r38 = this.f6735o0;
        Intrinsics.checkNotNull(r38);
        r39 = r40 - getScreenWidth();
        goto L16
    }

    public static final /* synthetic */ String a(OIndexScrollbar r10) {
        return r10.f6719g0;
    }

    public static final /* synthetic */ a b(OIndexScrollbar r10) {
        return r10.f6728l;
    }

    public static final /* synthetic */ GridView c(OIndexScrollbar r10) {
        return r10.f6724j;
    }

    public static final /* synthetic */ LettersBar d(OIndexScrollbar r10) {
        return r10.f6722i;
    }

    public static final /* synthetic */ boolean e(OIndexScrollbar r10) {
        return r10.f6731m0;
    }

    public static final /* synthetic */ int f(OIndexScrollbar r10) {
        return r10.f6738r;
    }

    public static final /* synthetic */ SurnameGridView g(OIndexScrollbar r10) {
        return r10.K;
    }

    private final void getParentxPos() {
        if (this.f6716e0 == this.f6715d0) goto L5;
        return;
    L5:
        Object r10 = getParent();
        Intrinsics.checkNotNullExpressionValue(r10, "this@OIndexScrollbar.getParent()");
        if ((r10 instanceof View) == false) goto L9;
        int[] r11 = new int[2];
        ((View) r10).getLocationInWindow(r11);
        this.f6716e0 = r11[0];
        return;
    }

    private final int getScreenWidth() {
        Point r10 = new Point();
        Context r11 = this.f6720h;
        Intrinsics.checkNotNull(r11);
        Object r12 = r11.getSystemService("window");
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) r12).getDefaultDisplay().getSize(r10);
        return r10.x;
    }

    public static final /* synthetic */ PopupWindow h(OIndexScrollbar r10) {
        return r10.f6710J;
    }

    public static final /* synthetic */ b i(OIndexScrollbar r10) {
        return r10.f6745y;
    }

    public static final /* synthetic */ PopupWindow j(OIndexScrollbar r10) {
        return r10.f6712b0;
    }

    public static final /* synthetic */ TextView k(OIndexScrollbar r10) {
        return r10.f6714c0;
    }

    public static final /* synthetic */ int l(OIndexScrollbar r10) {
        return r10.f6742v;
    }

    public static final /* synthetic */ int m(OIndexScrollbar r10) {
        return r10.W;
    }

    public static final /* synthetic */ int n(OIndexScrollbar r10) {
        return r10.P;
    }

    public static final /* synthetic */ int o(OIndexScrollbar r10) {
        return r10.O;
    }

    public static final /* synthetic */ d p(OIndexScrollbar r10) {
        return r10.f6746z;
    }

    public static final /* synthetic */ int q(OIndexScrollbar r10) {
        return r10.f6741u;
    }

    public static final /* synthetic */ void r(OIndexScrollbar r10) {
        r10.H();
    }

    public static final /* synthetic */ void s(OIndexScrollbar r10) {
        r10.O();
    }

    private final void setHostWidth(int r10) {
        int r11 = (r10 - this.f6736p) - this.f6737q;
        this.f6730m = r11;
        int r12 = r10 - this.f6734o;
        this.f6732n = r12;
        int r13 = this.f6742v;
        if (r13 != this.f6739s) goto L6;
        float r14 = r11;
    L9:
        setX(r14);
        if (this.f6718g == false) goto L12;
        Log.d(this.f6713c, "mStartX = " + this.f6730m);
    L12:
        invalidate();
        return;
    L6:
        if (r13 != this.f6741u) goto L8;
        r14 = r12;
        goto L9
    L8:
        r14 = getX();
        goto L9
    }

    private final void setLettersBarBg(boolean r10) {
        LettersBar r11 = this.f6722i;
        Intrinsics.checkNotNull(r11);
        r11.setShowBg(r10);
        setShadowVisible(r10);
    }

    private final void setShadowVisible(boolean r10) {
        View r11 = this.f6726k;
        Intrinsics.checkNotNull(r11);
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 4;
        goto L6
    }

    private final void setState(int r10) {
        this.f6742v = r10;
        LettersBar r11 = this.f6722i;
        Intrinsics.checkNotNull(r11);
        if (r10 != this.f6739s) goto L5;
        boolean r12 = true;
    L6:
        r11.setSettled(r12);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public static final /* synthetic */ void t(OIndexScrollbar r10) {
        r10.Q();
    }

    public static final /* synthetic */ void u(OIndexScrollbar r10, String r11) {
        r10.f6719g0 = r11;
    }

    public static final /* synthetic */ void v(OIndexScrollbar r10, boolean r11) {
        r10.setLettersBarBg(r11);
    }

    public static final /* synthetic */ void w(OIndexScrollbar r10, boolean r11) {
        r10.f6727k0 = r11;
    }

    public static final /* synthetic */ void x(OIndexScrollbar r10, boolean r11) {
        r10.A = r11;
    }

    public static final /* synthetic */ void y(OIndexScrollbar r10, boolean r11) {
        r10.B = r11;
    }

    public static final /* synthetic */ void z(OIndexScrollbar r10, boolean r11) {
        r10.setShadowVisible(r11);
    }

    public final void F() {
        G(true);
    }

    public final void G(boolean r10) {
        E();
        if (M() == true) goto L8;
        if (r10 == false) goto L6;
        H();
        return;
    L6:
        O();
        return;
    }

    public final void I(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f6720h = r10;
        Intrinsics.checkNotNull(r10);
        Resources r11 = r10.getResources();
        LayoutInflater.from(this.f6720h).inflate(u8.h.o_index_scrollbar, this, true);
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        this.f6736p = MathKt.roundToInt(TypedValue.applyDimension(1, 20, r12.getDisplayMetrics()));
        int r13 = r11.getDimensionPixelOffset(u8.d.bytedance_quickbar_grid_item_space);
        int r14 = r11.getDimensionPixelOffset(u8.d.quickbar_ex_grid_column_width);
        this.f6717f0 = r11.getDimensionPixelOffset(u8.d.bytedance_quickbar_min_distance);
        Context r15 = this.f6720h;
        Intrinsics.checkNotNull(r15);
        Drawable r16 = r15.getResources().getDrawable(u8.e.letters_bar_background_shadow);
        Intrinsics.checkNotNullExpressionValue(r16, "mContext!!.resources.get…rs_bar_background_shadow)");
        this.f6737q = r16.getIntrinsicWidth();
        int r17 = (r13 * 2) + this.f6736p;
        Context r18 = this.f6720h;
        Intrinsics.checkNotNull(r18);
        this.f6734o = (r17 + (r14 * r18.getResources().getInteger(u8.g.bytedance_letterbar_gridview_column_num))) + this.f6737q;
        L();
        J();
        this.f6726k = findViewById(u8.f.iv_letter_bar_shadow);
        setLettersBarBg(false);
    }

    public final void K() {
        this.C.clear();
        int[] r10 = this.D;
        int r11 = 0;
        if (r10 == null) goto L11;
        Intrinsics.checkNotNull(r10);
        int r12 = r10.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        List<s9.b> r14 = this.C;
        s9.b.a r15 = s9.b.f12767e;
        int[] r16 = this.D;
        Intrinsics.checkNotNull(r16);
        String r17 = String.valueOf(r16[r13]);
        Bitmap[][] r18 = this.E;
        if (r18 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mIconsForSymbols");
    L9:
        r14.add(r15.c(r17, r18[r13]));
        r13 = r13 + 1;
        goto L5
    L10:
        int[] r19 = this.D;
        Intrinsics.checkNotNull(r19);
        int r20 = r19.length;
    L12:
        s9.c r21 = s9.c.f12775e;
        Locale r22 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r22, "Locale.getDefault()");
        String r23 = r22.getLanguage();
        Intrinsics.checkNotNullExpressionValue(r23, "Locale.getDefault().language");
        String[] r24 = r21.b(r23);
        int r25 = r24.length - 1;
    L13:
        if (r11 >= r25) goto L20;
        s9.c r26 = s9.c.f12775e;
        Locale r27 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r27, "Locale.getDefault()");
        String r28 = r27.getLanguage();
        Intrinsics.checkNotNullExpressionValue(r28, "Locale.getDefault().language");
        if (r26.a(r28, r11) == false) goto L17;
        List<s9.b> r29 = this.C;
        s9.b r30 = s9.b.f12767e.b(r24[r11]);
    L18:
        r29.add(r30);
        r11 = r11 + 1;
        goto L13
    L17:
        r29 = this.C;
        r30 = s9.b.f12767e.a(r24[r11]);
        goto L18
    L20:
        if (this.F == true) goto L22;
    L25:
        invalidate();
        return;
    L22:
        if (this.I != this.G) goto L24;
        this.C.add(r20, s9.b.f12767e.d());
        goto L25
    L24:
        this.C.add(s9.b.f12767e.d());
        goto L25
    L11:
        r20 = 0;
        goto L12
    }

    public final boolean M() {
        if (this.A == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f6742v == this.f6739s) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        s9.a r11 = s9.a.f12765f;
        Locale r12 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r12, "Locale.getDefault()");
        String r13 = r12.getLanguage();
        Intrinsics.checkNotNullExpressionValue(r13, "Locale.getDefault().language");
        if (r11.b(r13) == false) goto L5;
        getParentxPos();
        int r14 = r10.getAction();
        r10.getX();
        r10.getY();
        float r15 = r10.getRawX() - this.f6716e0;
        if (r14 == 0) goto L61;
        if (r14 == 1) goto L31;
        if (r14 == 2) goto L15;
        if (r14 == 3) goto L31;
    L68:
        boolean r16 = false;
    L69:
        if (r16 == false) goto L71;
        return true;
    L71:
        if (super.dispatchTouchEvent(r10) == false) goto L74;
        return true;
    L74:
        return false;
    L15:
        if (this.f6727k0 == false) goto L17;
        P(r10);
        goto L68
    L17:
        float r17 = this.f6744x;
        this.f6743w = r17;
        this.f6744x = r15;
        int r18 = this.f6742v;
        if (r18 != this.f6739s) goto L21;
        int r19 = (r15 > this.f6730m ? 1 : (r15 == this.f6730m ? 0 : -1));
        goto L68
    L21:
        if (r18 == this.f6740t) goto L68;
        if (r18 != this.f6741u) goto L68;
        if ((r15 - r17) <= this.f6717f0) goto L68;
        if (r17 <= this.f6732n) goto L68;
    L60:
        r16 = true;
    L31:
        if (this.f6727k0 == false) goto L50;
        Locale r20 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r20, "Locale.getDefault()");
        String r21 = r20.getLanguage();
        Intrinsics.checkNotNullExpressionValue(r21, "Locale.getDefault().language");
        if (r11.k(r21) != 1) goto L42;
        if (this.f6729l0 < 0) goto L48;
        SurnameFlowLayout r22 = this.L;
        if (r22 == null) goto L48;
        Intrinsics.checkNotNull(r22);
        View r23 = r22.getChildAt(this.f6729l0);
        Intrinsics.checkNotNullExpressionValue(r23, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        if (r23 == null) goto L48;
        r23.setPressed(false);
        r23.performClick();
    L48:
        this.f6729l0 = -1;
        goto L68
    L42:
        if (this.f6729l0 < 0) goto L48;
        SurnameGridView r24 = this.K;
        if (r24 == null) goto L48;
        Intrinsics.checkNotNull(r24);
        View r25 = r24.getChildAt(this.f6729l0);
        Intrinsics.checkNotNullExpressionValue(r25, "mPopupGridView!!.getChildAt(mPrePosition)");
        if (r25 == null) goto L48;
        r25.setPressed(false);
        SurnameGridView r26 = this.K;
        Intrinsics.checkNotNull(r26);
        r26.performItemClick(r25, this.f6729l0, -1);
        goto L48
    L50:
        if (getX() != this.f6730m) goto L53;
        setLettersBarBg(false);
        goto L68
    L53:
        if (this.f6742v != this.f6740t) goto L68;
        if ((this.f6744x - this.f6743w) <= 0) goto L57;
    L59:
        H();
        goto L60
    L57:
        if (getX() >= (getScreenWidth() + NetError.ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN)) goto L59;
        T();
        goto L60
    L61:
        this.f6727k0 = false;
        this.f6744x = r15;
        this.f6743w = r15;
        if (this.f6742v != this.f6741u) goto L68;
        PopupWindow r27 = this.f6710J;
        if (r27 == null) goto L68;
        Intrinsics.checkNotNull(r27);
        if (r27.isShowing() == false) goto L68;
        PopupWindow r28 = this.f6710J;
        Intrinsics.checkNotNull(r28);
        r28.dismiss();
        goto L68
    L5:
        return super.dispatchTouchEvent(r10);
    }

    public final int getLETTER_CHANGED_CLICK() {
        return this.f6725j0;
    }

    public final int getLETTER_CHANGED_SLIDE() {
        return this.f6723i0;
    }

    public final LettersBar getLetterBar() {
        return this.f6722i;
    }

    public final boolean getOIndexScrollbar_DEBUG() {
        return this.f6718g;
    }

    public final String getOIndexScrollbar_TAG() {
        return this.f6713c;
    }

    public final int getPOUND_POSITION_BOTTOM() {
        return this.H;
    }

    public final int getPOUND_POSITION_TOP() {
        return this.G;
    }

    public final int getVISIBILITY_LIMIT() {
        return this.f6721h0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        this.f6738r = N(r11);
        int r12 = View.MeasureSpec.getSize(r10);
        Object r13 = getParent();
        if (r13 == null) goto L7;
        int r14 = ((View) r13).getMeasuredWidth();
        if (r14 <= 0) goto L9;
        setHostWidth(r14);
    L9:
        if (this.f6718g == false) goto L12;
        Log.d(this.f6713c, "measure width:" + r12 + "  parentWidth:" + r14);
        return;
    L12:
        return;
    L7:
        r14 = 0;
        goto L9
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "changedView");
        super.onVisibilityChanged(r10, r11);
        if (r11 != 8) goto L11;
        if (r10 != this) goto L12;
        PopupWindow r12 = this.f6710J;
        if (r12 == null) goto L13;
        Intrinsics.checkNotNull(r12);
        if (r12.isShowing() == false) goto L14;
        PopupWindow r13 = this.f6710J;
        Intrinsics.checkNotNull(r13);
        r13.dismiss();
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void setLongPressEnabled(boolean r10) {
        this.f6731m0 = r10;
    }

    public final void setPoundPosition(int r10) {
        this.I = r10;
    }

    public final void setPoundVisibility(boolean r10) {
        this.F = r10;
    }

    public final void setQBListener(b r10) {
        this.f6745y = r10;
    }

    public final void setSurnameListener(d r10) {
        this.f6746z = r10;
    }
}
