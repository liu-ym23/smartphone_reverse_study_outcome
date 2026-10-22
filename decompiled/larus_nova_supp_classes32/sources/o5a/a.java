package o5a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallbackResult;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.relax.k;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a extends com.lynx.clay.embedding.engine.plugins.platformview.a {
    public o5a.d h;
    public boolean i;
    public boolean j;
    public int k;
    public String l;
    public boolean m;
    public String n;
    public int o;
    public int p;
    public boolean q;
    public float r;
    public String s;
    public float t;

    /* JADX INFO: renamed from: o5a.a$a, reason: collision with other inner class name */
    public class C0103a implements InputFilter {
        public final /* synthetic */ a a;

        public C0103a(a r1) {
            this.a = r1;
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r2, int r3, int r4, Spanned r5, int r6, int r7) {
            Pattern r8 = PatternProtector.compile(this.a.l);
            StringBuilder r9 = new StringBuilder();
        L3:
            if (r3 >= r4) goto L9;
            char r10 = r2.charAt(r3);
            if (r8.matcher(Character.toString(r10)).matches() == false) goto L7;
            r9.append(r10);
        L7:
            r3 = r3 + 1;
            goto L3
        L9:
            return r9.toString();
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            this.a.getClass();
            a.s(r2);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
            this.a.t();
        }
    }

    public class c implements TextWatcher {
        public final /* synthetic */ a a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            if (this.a.c("input") == false) goto L7;
            if (r4 == null) goto L8;
            HashMap r0 = new HashMap();
            r0.put("value", r4.toString());
            r0.put("cursor", Integer.valueOf(this.a.h.getSelectionEnd()));
            this.a.q("input", r0);
            return;
        L8:
            return;
        }
    }

    public class d implements View.OnFocusChangeListener {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r3, boolean r4) {
            if (r4 == false) goto L8;
            this.a.c.markAsEditing();
            if (this.a.c("focus") == false) goto L11;
            HashMap r5 = new HashMap();
            r5.put("value", this.a.h.getText().toString());
            this.a.q("focus", r5);
            return;
        L11:
            return;
        L8:
            if (this.a.c("blur") == false) goto L13;
            HashMap r6 = new HashMap();
            r6.put("value", this.a.h.getText().toString());
            this.a.q("blur", r6);
            return;
        }
    }

    public class e implements o5a.d.b {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }
    }

    public class f implements InputFilter {
        public final /* synthetic */ a a;

        public f(a r1) {
            this.a = r1;
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r2, int r3, int r4, Spanned r5, int r6, int r7) {
            int r0 = this.a.k - (r5.length() - (r7 - r6));
            if (r0 > 0) goto L6;
            return NameKeys.UnloadStrategy_No_Strategy;
        L6:
            if (r0 < (r4 - r3)) goto L9;
            return null;
        L9:
            int r1 = r0 + r3;
            if (Character.isHighSurrogate(r2.charAt(r1 - 1)) == false) goto L15;
            r1 = r1 - 1;
            if (r1 != r3) goto L15;
            return NameKeys.UnloadStrategy_No_Strategy;
        L15:
            return r2.subSequence(r3, r1);
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ a a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.w(true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(a r1) {
            this.a = r1;
        }
    }

    public class h implements InputFilter {
        public final /* synthetic */ a a;

        public h(a r1) {
            this.a = r1;
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r2, int r3, int r4, Spanned r5, int r6, int r7) {
            int r0 = this.a.k - (r5.length() - (r7 - r6));
            if (r0 > 0) goto L6;
            return NameKeys.UnloadStrategy_No_Strategy;
        L6:
            if (r0 < (r4 - r3)) goto L9;
            return null;
        L9:
            int r1 = r0 + r3;
            if (Character.isHighSurrogate(r2.charAt(r1 - 1)) == false) goto L15;
            r1 = r1 - 1;
            if (r1 != r3) goto L15;
            return NameKeys.UnloadStrategy_No_Strategy;
        L15:
            return r2.subSequence(r3, r1);
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void j() {
        this.i = true;
        if (this.j == false) goto L6;
        this.j = false;
        this.h.post(new g(this));
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void m() {
        w(false);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public void g() {
        if (this.q == false) goto L26;
        boolean r1 = true;
        if (this.n != null) goto L24;
        Typeface r0 = Typeface.DEFAULT;
        int r4 = this.p;
        if (this.o == 2) goto L21;
        r1 = false;
    L21:
        this.h.setTypeface(Typeface.create(r0, r4, r1));
    L22:
        this.q = false;
        return;
    L24:
        Typeface r2 = Typeface.createFromAsset(this.e.getAssets(), this.n);     // Catch: Exception -> L12
        int r5 = this.p;     // Catch: Exception -> L12
        if (this.o != 2) goto L9;
        boolean r6 = true;
    L10:
        this.h.setTypeface(Typeface.create(r2, r5, r6));     // Catch: Exception -> L12
        goto L22
    L9:
        r6 = false;
    L12:
        c5a.c.d(5, "BaseInputView", "Font family not found: " + this.n);
        Typeface r3 = Typeface.DEFAULT;
        int r7 = this.p;
        if (this.o == 2) goto L16;
        r1 = false;
    L16:
        this.h.setTypeface(Typeface.create(r3, r7, r1));
        goto L22
    }

    public final void t() {
        o5a.d r0 = this.h;
        if (r0 != null) goto L19;
        return;
    L19:
        r0.clearFocus();     // Catch: RuntimeException -> L18
        InputMethodManager r1 = (InputMethodManager) this.e.getSystemService("input_method");     // Catch: RuntimeException -> L18
        if (r1 != null) goto L8;
        return;
    L8:
        IBinder r2 = this.h.getWindowToken();     // Catch: RuntimeException -> L18
        if (r2 != null) goto L11;
        r2 = this.h.getApplicationWindowToken();     // Catch: RuntimeException -> L18
    L11:
        if (r2 == null) goto L13;
    L15:
        if (r2 == null) goto L21;
        r1.hideSoftInputFromWindow(r2, 0);     // Catch: RuntimeException -> L18
        return;
    L21:
        return;
    L13:
        if (this.h.getRootView() == null) goto L15;
        r2 = this.h.getRootView().getWindowToken();     // Catch: RuntimeException -> L18
    }

    public final void v() {
        h r0 = new h(this);
        C0103a r1 = new C0103a(this);
        String r2 = this.l;
        if (r2 != null) goto L5;
    L9:
        this.h.setFilters(new InputFilter[]{r0});
        return;
    L5:
        if (r2.isEmpty() == true) goto L9;
        this.h.setFilters(new InputFilter[]{r0, r1});
    }

    public final void x() {
        if (this.s.isEmpty() == false) goto L5;
        return;
    L5:
        if (this.t > 0.0f) goto L10;
        float r0 = this.r;
        if (r0 <= 0.0f) goto L9;
        this.t = r0;
        goto L10
    L9:
        this.t = 14.0f;
    L10:
        SpannableString r1 = new SpannableString(this.s);
        r1.setSpan(new AbsoluteSizeSpan((int) this.t, true), 0, this.s.length(), 18);
        this.h.setHint(r1);
        this.h.requestLayout();
        this.h.invalidate();
        e();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void h() {
        t();
    }

    public void u() {
        e();
    }

    public static void s(View r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if ((r1 instanceof FlutterView) == false) goto L12;
        lpa.d r2 = ((FlutterView) r1).getKeyboardEventStartCallback();
        if (r2 == null) goto L16;
        k r3 = r2.a.c;
        if (r3 == null) goto L17;
        r3.onStart();
        return;
    L17:
        return;
    L16:
        return;
    L12:
        Object r4 = r1.getParent();
        if ((r4 instanceof View) == false) goto L18;
        s((View) r4);
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public View a(Context r5) {
        c5a.c.c("BaseInputView", "createView");
        o5a.d r0 = new o5a.d(r5);
        r0.setBackground(null);
        r0.setImeOptions(1);
        r0.setPadding(0, 0, 0, 0);
        this.h = r0;
        r0.addOnAttachStateChangeListener(new b(this));
        this.h.addTextChangedListener(new c(this));
        this.h.setOnFocusChangeListener(new d(this));
        this.h.setOnSelectionChangeListener(new e(this));
        f r2 = new f(this);
        this.h.setFilters(new InputFilter[]{r2});
        return r0;
    }

    public final void w(boolean r2) {
        if (r2 == false) goto L7;
        this.h.requestFocus();
        if (this.m == false) goto L12;
        this.h.post(new o5a.b(this));
        return;
    L12:
        return;
    L7:
        if (this.h.isFocused() == false) goto L14;
        this.h.clearFocus();
        if (this.m == false) goto L15;
        this.h.post(new o5a.c(this));
        return;
    L15:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public void n(String r11, Object r12) {
        byte r2 = 6;
        byte r4 = -1;
        int r6 = 0;
        if ("confirm-type".equals(r11) == false) goto L38;
        if ((r12 instanceof String) == false) goto L432;
        String r13 = (String) r12;
        r13.getClass();
        switch(r13.hashCode()) {
            case -906336856: goto L27;
            case 3304: goto L23;
            case 3089282: goto L19;
            case 3377907: goto L15;
            case 3526536: goto L11;
            default: goto L30;
        };
    L30:
        switch(r4) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            default: goto L31;
        };
    L31:
        c5a.c.d(5, "BaseInputView", "Unsupported confirm type: ".concat(r13));
        return;
    L32:
        this.h.setImeOptions(4);
        return;
    L33:
        this.h.setImeOptions(5);
        return;
    L34:
        this.h.setImeOptions(6);
        return;
    L35:
        this.h.setImeOptions(2);
        return;
    L36:
        this.h.setImeOptions(3);
        return;
    L11:
        if (r13.equals("send") == false) goto L30;
        r4 = 4;
        goto L30
    L15:
        if (r13.equals("next") == false) goto L30;
        r4 = 3;
        goto L30
    L19:
        if (r13.equals("done") == false) goto L30;
        r4 = 2;
        goto L30
    L23:
        if (r13.equals("go") == false) goto L30;
        r4 = 1;
        goto L30
    L27:
        if (r13.equals("search") == false) goto L30;
        r4 = 0;
        goto L30
    L432:
        return;
    L38:
        if ("keyboard-type".equals(r11) == false) goto L78;
        if ((r12 instanceof String) == false) goto L433;
        String r14 = (String) r12;
        r14.getClass();
        switch(r14.hashCode()) {
            case -1034364087: goto L66;
            case 114715: goto L62;
            case 3556653: goto L58;
            case 95582509: goto L54;
            case 96619420: goto L50;
            case 1216985755: goto L46;
            default: goto L69;
        };
    L69:
        switch(r4) {
            case 0: goto L76;
            case 1: goto L75;
            case 2: goto L74;
            case 3: goto L73;
            case 4: goto L72;
            case 5: goto L71;
            default: goto L70;
        };
    L70:
        c5a.c.d(5, "BaseInputView", "Unsupported keyboard type: ".concat(r14));
        return;
    L71:
        this.h.setInputType(LynxTouchEvent.kPseudoStateFocusTransition);
        return;
    L72:
        this.h.setInputType(32);
        return;
    L73:
        this.h.setInputType(8194);
        return;
    L74:
        this.h.setInputType(1);
        return;
    L75:
        this.h.setInputType(3);
        return;
    L76:
        this.h.setInputType(12290);
        return;
    L46:
        if (r14.equals("password") == false) goto L69;
        r4 = 5;
        goto L69
    L50:
        if (r14.equals("email") == false) goto L69;
        r4 = 4;
        goto L69
    L54:
        if (r14.equals("digit") == false) goto L69;
        r4 = 3;
        goto L69
    L58:
        if (r14.equals("text") == false) goto L69;
        r4 = 2;
        goto L69
    L62:
        if (r14.equals("tel") == false) goto L69;
        r4 = 1;
        goto L69
    L66:
        if (r14.equals("number") == false) goto L69;
        r4 = 0;
        goto L69
    L433:
        return;
    L78:
        if ("maxlength".equals(r11) == false) goto L84;
        if ((r12 instanceof Number) == false) goto L434;
        this.k = ((Number) r12).intValue();
        v();
        return;
    L434:
        return;
    L84:
        if ("show-soft-input-on-focus".equals(r11) == false) goto L90;
        if ((r12 instanceof Boolean) == false) goto L435;
        this.m = ((Boolean) r12).booleanValue();
        return;
    L435:
        return;
    L90:
        if ("readonly".equals(r11) == true) goto L92;
        Float r1 = null;
        Field r3 = null;
        Integer r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        if ("caret-color".equals(r11) == false) goto L122;
        if ((r12 instanceof Number) == false) goto L437;
        int r15 = (int) ((Number) r12).longValue();
        o5a.d r16 = this.h;
        Field r0 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L103
        r0.setAccessible(true);     // Catch: Throwable -> L103
        r3 = r0;
    L104:
        if (r3 != null) goto L388;
        Object r7 = r16;
    L109:
        if (r3 != null) goto L111;
        Class<?> r8 = TextView.class;
    L112:
        Field r9 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L106
        r9.setAccessible(true);     // Catch: Throwable -> L106
        Drawable r17 = r16.getContext().getDrawable(r9.getInt(r16));     // Catch: Throwable -> L106
        if (r17 == null) goto L405;
        r17.setTint(r15);     // Catch: Throwable -> L106
        if (Build.VERSION.SDK_INT < 28) goto L118;
        Field r18 = r8.getDeclaredField("mDrawableForCursor");     // Catch: Throwable -> L106
        r18.setAccessible(true);     // Catch: Throwable -> L106
        r18.set(r7, r17);     // Catch: Throwable -> L106
        return;
    L118:
        Field r19 = r8.getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L106
        r19.setAccessible(true);     // Catch: Throwable -> L106
        r19.set(r7, new Drawable[]{r17, r17});     // Catch: Throwable -> L106
        return;
    L405:
        return;
    L111:
        r8 = r7.getClass();     // Catch: Throwable -> L106
        goto L112
    L388:
        r7 = r3.get(r16);     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        th.printStackTrace();
        return;
    L437:
        return;
    L122:
        if ("input-filter".equals(r11) == false) goto L128;
        if ((r12 instanceof String) == false) goto L439;
        this.l = (String) r12;
        v();
        return;
    L439:
        return;
    L128:
        if ("focus".equals(r11) == false) goto L140;
        if ((r12 instanceof Boolean) == true) goto L133;
        return;
    L133:
        if (((Boolean) r12).booleanValue() == true) goto L135;
        this.j = false;
        w(false);
        return;
    L135:
        if (this.i == false) goto L137;
        w(true);
        return;
    L137:
        this.j = true;
        return;
    L140:
        if ("direction".equals(r11) == false) goto L165;
        if ((r12 instanceof String) == false) goto L441;
        String r110 = (String) r12;
        r110.getClass();
        switch(r110.hashCode()) {
            case -1039745817: goto L156;
            case 107498: goto L152;
            case 113258: goto L148;
            default: goto L159;
        };
    L159:
        switch(r4) {
            case 0: goto L163;
            case 1: goto L162;
            case 2: goto L161;
            default: goto L442;
        };
    L161:
        this.h.setTextDirection(4);
        return;
    L162:
        this.h.setTextDirection(3);
        return;
    L163:
        this.h.setTextDirection(5);
        return;
    L442:
        return;
    L148:
        if (r110.equals("rtl") == false) goto L159;
        r4 = 2;
        goto L159
    L152:
        if (r110.equals("ltr") == false) goto L159;
        r4 = 1;
        goto L159
    L156:
        if (r110.equals("normal") == false) goto L159;
        r4 = 0;
        goto L159
    L441:
        return;
    L165:
        if ("font-size".equals(r11) == false) goto L173;
        if ((r12 instanceof Number) == false) goto L443;
        float r111 = ((Number) r12).floatValue();
        this.r = r111;
        this.h.setTextSize(0, r111);
        if (this.s.isEmpty() == true) goto L415;
        x();
        return;
    L415:
        return;
    L443:
        return;
    L173:
        if ("font-weight".equals(r11) == false) goto L187;
        if ((r12 instanceof Number) == false) goto L444;
        int r112 = ((Number) r12).intValue();
        int r113 = this.p;
        if (r112 == 0) goto L182;
        if (r112 == 1) goto L181;
        this.p = (r112 - 1) * 100;
    L184:
        if (this.p == r113) goto L417;
        this.q = true;
        return;
    L417:
        return;
    L181:
        this.p = 700;
        goto L184
    L182:
        this.p = 400;
        goto L184
    L444:
        return;
    L187:
        if ("font-style".equals(r11) == false) goto L203;
        if ((r12 instanceof Number) == false) goto L445;
        int r114 = ((Number) r12).intValue();
        int r115 = this.o;
        if (r114 == 0) goto L198;
        if (r114 == 1) goto L197;
        if (r114 != 2) goto L200;
        this.o = 2;
    L200:
        if (r115 == this.o) goto L419;
        this.q = true;
        return;
    L419:
        return;
    L197:
        this.o = 2;
        goto L200
    L198:
        this.o = 0;
        goto L200
    L445:
        return;
    L203:
        if ("font-family".equals(r11) == false) goto L213;
        if ((r12 instanceof String) == false) goto L446;
        String r116 = this.n;
        if (r116 != null) goto L210;
    L211:
        this.n = (String) r12;
        this.q = true;
        return;
    L210:
        if (r116 != ((String) r12)) goto L211;
        return;
    L446:
        return;
    L213:
        if ("letter-spacing".equals(r11) == false) goto L219;
        if ((r12 instanceof Number) == false) goto L447;
        this.h.setLetterSpacing(((float) ((Number) r12).doubleValue()) / this.h.getTextSize());
        return;
    L447:
        return;
    L219:
        if ("text-align".equals(r11) == false) goto L232;
        if ((r12 instanceof Number) == false) goto L448;
        int r117 = ((Number) r12).intValue();
        if (r117 == 0) goto L230;
        if (r117 == 1) goto L229;
        if (r117 != 2) goto L449;
        this.h.setTextAlignment(3);
        return;
    L449:
        return;
    L229:
        this.h.setTextAlignment(4);
        return;
    L230:
        this.h.setTextAlignment(2);
        return;
    L448:
        return;
    L232:
        if ("color".equals(r11) == false) goto L238;
        if ((r12 instanceof Number) == false) goto L450;
        this.h.setTextColor(((Number) r12).intValue());
        return;
    L450:
        return;
    L238:
        if ("placeholder".equals(r11) == false) goto L247;
        if ((r12 instanceof String) == false) goto L243;
        this.s = (String) r12;
    L245:
        x();
        u();
        return;
    L243:
        if ((r12 instanceof Number) == false) goto L428;
        this.s = String.valueOf(r12);
        goto L245
    L428:
        return;
    L247:
        if ("placeholder-color".equals(r11) == false) goto L356;
        if ((r12 instanceof Number) == false) goto L252;
        r5 = Integer.valueOf((int) ((Number) r12).longValue());
    L352:
        if (r5 == null) goto L451;
        this.h.setHintTextColor(r5.intValue());
        x();
        u();
        return;
    L451:
        return;
    L252:
        if ((r12 instanceof String) == false) goto L352;
        String r118 = (String) r12;
        Pattern r119 = o5a.g.a;
        if (r118 == null) goto L352;
        String r120 = r118.trim().toLowerCase();
        if (r120.isEmpty() == true) goto L352;
        switch(r120.hashCode()) {
            case -1726194350: goto L302;
            case -734239628: goto L298;
            case 112785: goto L294;
            case 3027034: goto L290;
            case 3068707: goto L286;
            case 3181155: goto L282;
            case 3181279: goto L279;
            case 93818879: goto L275;
            case 98619139: goto L271;
            case 113101865: goto L267;
            case 828922025: goto L263;
            default: goto L305;
        };
    L305:
        r2 = -1;
    L306:
        switch(r2) {
            case 0: goto L318;
            case 1: goto L317;
            case 2: goto L316;
            case 3: goto L315;
            case 4: goto L314;
            case 5: goto L313;
            case 6: goto L313;
            case 7: goto L312;
            case 8: goto L311;
            case 9: goto L310;
            case 10: goto L309;
            default: goto L382;
        };
    L309:
        r5 = -65281;
        goto L352
    L310:
        r5 = -1;
        goto L352
    L311:
        r5 = -16711936;
        goto L352
    L312:
        r5 = -16777216;
        goto L352
    L313:
        r5 = -7829368;
        goto L352
    L314:
        r5 = -16711681;
        goto L352
    L315:
        r5 = -16776961;
        goto L352
    L316:
        r5 = -65536;
        goto L352
    L317:
        r5 = -256;
        goto L352
    L318:
        r5 = 0;
        goto L352
    L382:
        Matcher r121 = o5a.g.a.matcher(r120);     // Catch: RuntimeException -> L351
        if (r121.matches() == false) goto L347;
        int r122 = CastIntegerProtector.parseInt(r121.group(1));     // Catch: RuntimeException -> L351
        if (r122 >= 0) goto L324;
        r122 = 0;
    L326:
        int r10 = CastIntegerProtector.parseInt(r121.group(2));     // Catch: RuntimeException -> L351
        if (r10 >= 0) goto L329;
        r10 = 0;
    L331:
        int r20 = CastIntegerProtector.parseInt(r121.group(3));     // Catch: RuntimeException -> L351
        if (r20 >= 0) goto L334;
        r20 = 0;
    L336:
        float r123 = CastFloatProtector.parseFloat(r121.group(4));     // Catch: RuntimeException -> L351
        if (r123 > 1.0f) goto L339;
        int r124 = Math.round(r123 * 255.0f);     // Catch: RuntimeException -> L351
    L340:
        if (r124 < 0) goto L345;
        if (r124 <= 255) goto L344;
        r6 = 255;
        goto L345
    L344:
        r6 = r124;
    L345:
        r5 = Integer.valueOf(Color.argb(r6, r122, r10, r20));     // Catch: RuntimeException -> L351
        goto L352
    L339:
        r124 = Math.round(r123);     // Catch: RuntimeException -> L351
        goto L340
    L334:
        if (r20 <= 255) goto L336;
        r20 = 255;
        goto L336
    L329:
        if (r10 <= 255) goto L331;
        r10 = 255;
        goto L331
    L324:
        if (r122 <= 255) goto L326;
        r122 = 255;
        goto L326
    L347:
        if (r120.startsWith("#") == false) goto L349;
        r5 = Integer.valueOf(Color.parseColor(r120));     // Catch: RuntimeException -> L351
        goto L352
    L349:
        r5 = Integer.valueOf((int) CastLongProtector.parseLong(r120));     // Catch: RuntimeException -> L351
        goto L352
    L263:
        if (r120.equals("magenta") == false) goto L305;
        r2 = 10;
        goto L306
    L267:
        if (r120.equals("white") == false) goto L305;
        r2 = 9;
        goto L306
    L271:
        if (r120.equals("green") == false) goto L305;
        r2 = 8;
        goto L306
    L275:
        if (r120.equals("black") == false) goto L305;
        r2 = 7;
        goto L306
    L279:
        if (r120.equals("grey") == true) goto L306;
    L282:
        if (r120.equals("gray") == false) goto L305;
        r2 = 5;
        goto L306
    L286:
        if (r120.equals("cyan") == false) goto L305;
        r2 = 4;
        goto L306
    L290:
        if (r120.equals("blue") == false) goto L305;
        r2 = 3;
        goto L306
    L294:
        if (r120.equals("red") == false) goto L305;
        r2 = 2;
        goto L306
    L298:
        if (r120.equals("yellow") == false) goto L305;
        r2 = 1;
        goto L306
    L302:
        if (r120.equals("transparent") == false) goto L305;
        r2 = 0;
        goto L306
    L356:
        if ("placeholder-font-size".equals(r11) == true) goto L358;
        return;
    L358:
        if ((r12 instanceof Number) == false) goto L361;
        float r125 = ((Number) r12).floatValue();
        Resources r126 = this.e.getResources();
        r1 = Float.valueOf(r125 / WindowDisplayMetricsOverride.apply(r126, r126.getDisplayMetrics()).density);
    L378:
        if (r1 == null) goto L452;
        this.t = r1.floatValue();
        x();
        u();
        return;
    L452:
        return;
    L361:
        if ((r12 instanceof String) == false) goto L378;
        Context r127 = this.e;
        String r128 = (String) r12;
        Pattern r21 = o5a.g.a;
        if (r127 == null) goto L378;
        if (r128 == null) goto L378;
        String r129 = r128.trim().toLowerCase();
        if (r129.isEmpty() == true) goto L378;
        if (r129.endsWith("px") == false) goto L373;
        r1 = Float.valueOf(CastFloatProtector.parseFloat(r129.substring(0, r129.length() - 2).trim()));     // Catch: RuntimeException -> L377
    L385:
        goto L378
    L373:
        if (r129.endsWith("rpx") == false) goto L375;
        float r130 = CastFloatProtector.parseFloat(r129.substring(0, r129.length() - 3).trim());     // Catch: RuntimeException -> L377
        Resources r131 = r127.getResources();     // Catch: RuntimeException -> L377
        r1 = Float.valueOf((r130 * WindowDisplayMetricsOverride.apply(r131, r131.getDisplayMetrics()).widthPixels) / 750.0f);     // Catch: RuntimeException -> L377
        goto L385
    L375:
        r1 = Float.valueOf(CastFloatProtector.parseFloat(r129));     // Catch: RuntimeException -> L377
        goto L385
    L92:
        if ((r12 instanceof Boolean) == false) goto L436;
        boolean r132 = !((Boolean) r12).booleanValue();
        this.h.setFocusable(r132);
        this.h.setFocusableInTouchMode(r132);
        return;
    }

    public a(Context r1, int r2, String r3) {
        super(r1, r2, r3);
        this.i = false;
        this.j = false;
        this.k = 140;
        this.l = NameKeys.UnloadStrategy_No_Strategy;
        this.m = true;
        this.o = 0;
        this.p = 400;
        this.q = false;
        this.r = 0.0f;
        this.s = NameKeys.UnloadStrategy_No_Strategy;
        this.t = 0.0f;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final boolean d(String r7, JSONObject r8, n5a.a r9) {
        if ("focus".equals(r7) == false) goto L9;
        w(true);
        if (this.h.isFocused() == false) goto L7;
        r9.a(PlatformMethodCallbackResult.SUCCESS);
    L71:
        return true;
    L7:
        r9.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L9:
        if ("blur".equals(r7) == false) goto L18;
        if (this.h.isFocused() == false) goto L16;
        w(false);
        if (this.h.isFocused() == true) goto L15;
        r9.a(PlatformMethodCallbackResult.SUCCESS);
        goto L71
    L15:
        r9.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L16:
        r9.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L18:
        if ("setValue".equals(r7) == false) goto L27;
        String r10 = r8.optString("value", NameKeys.UnloadStrategy_No_Strategy);
        int r11 = r8.optInt("index", -1);
        if (this.h.getText() == null) goto L25;
        this.h.setText(r10);
        if (r11 < 0) goto L24;
        this.h.setSelection(Math.min(r11, r10.length()));
    L24:
        r9.a(PlatformMethodCallbackResult.SUCCESS);
        goto L71
    L25:
        r9.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L27:
        if ("getValue".equals(r7) == false) goto L33;
        if (this.h.getText() == null) goto L31;
        HashMap r12 = new HashMap();
        r12.put("value", this.h.getText().toString());
        r9.b(PlatformMethodCallbackResult.SUCCESS, r12);
        goto L71
    L31:
        r9.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L33:
        if ("setSelectionRange".equals(r7) == false) goto L47;
        int r13 = r8.optInt("selectionStart", -1);
        int r14 = r8.optInt("selectionEnd", -1);
        if (this.h.getText() == null) goto L37;
        int r0 = this.h.getText().length();
    L38:
        if (r0 == (-1)) goto L45;
        if (r13 > r0) goto L45;
        if (r14 > r0) goto L45;
        if (r13 < 0) goto L45;
        if (r14 < 0) goto L45;
        this.h.setSelection(r13, r14);
        r9.a(PlatformMethodCallbackResult.SUCCESS);
    L45:
        r9.a(PlatformMethodCallbackResult.PARAM_INVALID);
        goto L71
    L37:
        r0 = -1;
        goto L38
    L47:
        if ("sendDelEvent".equals(r7) == false) goto L66;
        int r15 = r8.optInt("action", 1);
        if (r15 != 0) goto L58;
        int r16 = r8.optInt("length", 0);
        if (r16 <= 0) goto L64;
        int r17 = this.h.getSelectionStart();
        int r1 = this.h.getSelectionEnd();
        if (r17 == r1) goto L55;
        this.h.getText().delete(r17, r1);
        goto L64
    L55:
        int r18 = Math.min(r16 + r17, this.h.getText().length());
        if (r18 <= r17) goto L64;
        this.h.getText().delete(r17, r18);
    L64:
        r9.a(PlatformMethodCallbackResult.SUCCESS);
        goto L71
    L58:
        if (r15 != 1) goto L64;
        int r19 = this.h.getSelectionStart();
        int r20 = this.h.getSelectionEnd();
        if (r19 == r20) goto L62;
        this.h.getText().delete(r19, r20);
        goto L64
    L62:
        if (r19 <= 0) goto L64;
        this.h.getText().delete(r19 - 1, r19);
        goto L64
    L66:
        if ("addText".equals(r7) == false) goto L72;
        String r21 = r8.optString("text", NameKeys.UnloadStrategy_No_Strategy);
        if (this.h.getText() == null) goto L70;
        int r22 = this.h.getSelectionStart();
        this.h.getText().insert(r22, r21);
        this.h.setSelection(r22 + r21.length());
        r9.a(PlatformMethodCallbackResult.SUCCESS);
        goto L71
    L70:
        r9.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L72:
        return false;
    }
}
