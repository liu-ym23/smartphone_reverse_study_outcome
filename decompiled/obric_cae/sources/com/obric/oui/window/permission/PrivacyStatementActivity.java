package com.obric.oui.window.permission;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.cae.R;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalVertical;
import com.obric.oui.button.OButton;
import com.obric.oui.divider.ODivider;
import ge.l;
import ge.q;
import he.i;
import he.j;
import j0.h0;
import j0.m0;
import j0.w;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;
import ne.g;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacyStatementActivity extends androidx.appcompat.app.e {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final LinkedHashMap f6690p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final LinkedHashMap f6691q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final LinkedHashMap f6692r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6694b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f6696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f6697o;

    public interface a {
        void a();
    }

    public interface b {
        void a();

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean m13a();

        void onCancel();

        /* JADX INFO: renamed from: onCancel, reason: collision with other method in class */
        boolean m14onCancel();
    }

    public static final class c extends j implements q<Context, Integer, Integer, OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f6699b;

        public c(String r8, l r10) {
            this.f6698a = r8;
            this.f6699b = r10;
            super(3);
        }

        @Override // ge.q
        public final OButton invoke(Context r8, Integer r10, Integer r11) {
            Context r12 = r8;
            r10.intValue();
            int r13 = r11.intValue();
            i.f(r12, "styledContext");
            OButton r14 = new OButton(r12, null, 0);
            r14.setText(this.f6698a);
            r14.setLayoutParams(new ViewGroup.LayoutParams(-1, r13));
            l r15 = this.f6699b;
            Object r16 = r15;
            if (r15 == null) goto L5;
            r16 = new cd.c(r15);
        L5:
            r14.setOnClickListener((View.OnClickListener) r16);
            return r14;
        }
    }

    public static final class d implements j0.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6700a = null;

        static {
            f6700a = new d();
        }

        @Override // j0.q
        public final m0 a(View r8, m0 r10) {
            int r11 = r10.e();
            r10.b();
            i.e(r8, "v");
            r8.setPadding(r8.getPaddingLeft(), r11, r8.getPaddingRight(), 0);
            return r10;
        }
    }

    public static final class e extends j implements l<View, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrivacyStatementActivity f6701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f6702b;

        public e(PrivacyStatementActivity r8, b r10) {
            this.f6701a = r8;
            this.f6702b = r10;
            super(1);
        }

        @Override // ge.l
        public final xd.j invoke(View r8) {
            i.f(r8, "it");
            b r10 = this.f6702b;
            if (r10 != null) goto L5;
        L6:
            if (r10 == null) goto L8;
            r10.a();
        L8:
            PrivacyStatementActivity r11 = this.f6701a;
            r11.getClass();
            PrivacyStatementActivity.d(r11);
        L10:
            return xd.j.f13877a;
        L5:
            if (r10.m13a() == true) goto L10;
            goto L6
        }
    }

    public static final class f extends j implements l<View, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrivacyStatementActivity f6703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f6704b;

        public f(PrivacyStatementActivity r8, b r10) {
            this.f6703a = r8;
            this.f6704b = r10;
            super(1);
        }

        @Override // ge.l
        public final xd.j invoke(View r8) {
            i.f(r8, "it");
            b r10 = this.f6704b;
            if (r10 != null) goto L5;
        L6:
            if (r10 == null) goto L8;
            r10.onCancel();
        L8:
            PrivacyStatementActivity r11 = this.f6703a;
            r11.getClass();
            r11.finish();
        L10:
            return xd.j.f13877a;
        L5:
            if (r10.m14onCancel() == true) goto L10;
            goto L6
        }
    }

    static {
        f6690p = new LinkedHashMap();
        f6691q = new LinkedHashMap();
        f6692r = new LinkedHashMap();
    }

    public PrivacyStatementActivity() {
        this.f6694b = true;
    }

    public static final void d(PrivacyStatementActivity r8) {
        super.finish();
        r8.overridePendingTransition(R.anim.oui_transition_settings_out_a, R.anim.oui_transition_settings_out_b);
    }

    public static View e(Context r8, String r10, int r11, l r12) {
        c r13 = new c(r10, r12);
        i.f(r8, "context");
        ContextThemeWrapper r14 = new ContextThemeWrapper(r8, r11);
        TypedArray r15 = r14.obtainStyledAttributes(null, new int[]{android.R.attr.layout_width, android.R.attr.layout_height}, 0, r11);
        i.e(r15, "contextThemeWrapper.obta…ll, attrs, 0, styleResId)");
        int r16 = r15.getLayoutDimension(0, -2);     // Catch: Throwable -> L6
        int r17 = r15.getLayoutDimension(1, -2);     // Catch: Throwable -> L6
        View r18 = (View) r13.invoke(r14, Integer.valueOf(r16), Integer.valueOf(r17));     // Catch: Throwable -> L6
        r15.recycle();
        return r18;
    L6:
        th = move-exception;
        r15.recycle();
        throw th;
    }

    public static Drawable f(Context r8, String r10) {
        Drawable r11 = r8.getPackageManager().getApplicationIcon(r10);
        i.e(r11, "context.packageManager.g…licationIcon(packageName)");
        if ((r11 instanceof AdaptiveIconDrawable) == false) goto L5;
        zc.b.d("PrivacyStatementActivity", "loadApplicationIcon: " + r10 + " is adaptive icon");
        Object r12 = androidx.core.content.a.f1674a;
        int r13 = androidx.core.content.a.c.a(r8, R.color.oui_basic_line_1);
        Resources r14 = Resources.getSystem();
        i.e(r14, "Resources.getSystem()");
        return new cd.d((AdaptiveIconDrawable) r11, r13, TypedValue.applyDimension(1, (float) 1.33d, r14.getDisplayMetrics()));
    L5:
        zc.b.a("PrivacyStatementActivity", "loadApplicationIcon: " + r10 + " is not adaptive icon");
        return r11;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        b r8 = (b) f6690p.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId"));
        if (r8 != null) goto L5;
    L6:
        if (r8 == null) goto L8;
        r8.onCancel();
    L8:
        finish();
        return;
    L5:
        if (r8.m14onCancel() != true) goto L6;
    }

    @Override // androidx.appcompat.app.e, android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
        super.onContentChanged();
        this.f6697o = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        Window r8 = getWindow();
        i.e(r8, "window");
        View r10 = r8.getDecorView();
        i.e(r10, "window.decorView");
        if ((!r10.getFitsSystemWindows()) == false) goto L8;
        View r11 = this.f6697o;
        if (r11 == null) goto L9;
        d r12 = d.f6700a;
        WeakHashMap<View, h0> r13 = w.f8437a;
        w.i.u(r11, r12);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public final void onCreate(Bundle r15) {
        zc.b.a("PrivacyStatementActivity", "onCreate");
        super.onCreate(r15);
        String r8 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r8 == null) goto L5;
        cd.a r10 = (cd.a) f6692r.get(r8);
    L5:
        LinkedHashMap r11 = f6690p;
        if (r15 == null) goto L12;
        zc.b.h("PrivacyStatementActivity", "onCreate, savedInstanceState is not null");
        if (((b) r11.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId"))) != null) goto L11;
        zc.b.h("PrivacyStatementActivity", "privacyConsentCallbacks is null, finish");
        finish();
        overridePendingTransition(0, 0);
        return;
    L11:
        zc.b.d("PrivacyStatementActivity", "privacyConsentCallbacks is not null");
    L12:
        setContentView(R.layout.activity_privacy_statement);
        Window r16 = getWindow();
        i.e(r16, "window");
        r16.setStatusBarColor(getColor(R.color.oui_bg_base_1));
        t2.b.f(this);
        this.f6694b = getIntent().getBooleanExtra("showNetworkConfirm", true);
        this.f6695m = getIntent().getBooleanExtra("useLinkTextAsTitle", false);
        String r12 = getIntent().getStringExtra("title");
        if (r12 != null) goto L16;
        r12 = getString(R.string.default_title);
    L16:
        i.e(r12, "intent.getStringExtra(\"t…g(R.string.default_title)");
        i.e(getString(R.string.default_description), "getString(R.string.default_description)");
        String r13 = getIntent().getStringExtra("customizedCancelText");
        if (r13 != null) goto L20;
        r13 = getString(R.string.oui_cancel_and_quit);
    L20:
        i.e(r13, "intent.getStringExtra(\"c…ring.oui_cancel_and_quit)");
        String r14 = getString(R.string.oui_agree);
        i.e(r14, "getString(R.string.oui_agree)");
        String r17 = getIntent().getStringExtra("privacyText");
        if (r17 != null) goto L24;
        r17 = getString(R.string.privacy_policy_text);
    L24:
        i.e(r17, "intent.getStringExtra(\"p…ring.privacy_policy_text)");
        getIntent().getIntExtra("iconResId", R.drawable.white_circle);
        String[] r18 = getIntent().getStringArrayExtra("urls");
        if (r18 != null) goto L28;
        r18 = new String[0];
    L28:
        TextView r19 = (TextView) findViewById(R.id.title);
        ImageView r110 = (ImageView) findViewById(R.id.icon);
        View r111 = r16.getDecorView();
        i.e(r111, "window.decorView");
        this.f6696n = r111.getRootView();
        OBottomActionBarNormalVertical r112 = (OBottomActionBarNormalVertical) findViewById(R.id.privacy_bottom_action_bar);
        b r20 = (b) r11.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId"));
        ArrayList r21 = new ArrayList();
        r21.add(e(this, r14, R.style.OStyleV2_OButton_L_Standard_Primary, new e(this, r20)));
        r21.add(e(this, r13, R.style.OStyleV2_OButton_L_Trans_Neutral, new f(this, r20)));
        r112.setButtons(r21);
        ODivider r22 = r112.f6158a;
        if (r22 == null) goto L31;
        r22.setVisibility(8);
    L31:
        i.e(r19, "titleTextView");
        r19.setText(r12);
        String r23 = getIntent().getStringExtra("customPackageName");     // Catch: Exception -> L44
        if (r23 != null) goto L35;
    L38:
        boolean r24 = true;
    L39:
        if (r24 == false) goto L41;
        r23 = getPackageName();     // Catch: Exception -> L44
        i.e(r23, "packageName");     // Catch: Exception -> L44
    L42:
        r110.setImageDrawable(f(this, r23));     // Catch: Exception -> L44
    L46:
        View r25 = LayoutInflater.from(this).inflate(R.layout.layout_privacy_statement_header, null);
        i.e(r25, "headerView");
        r112.setHeaderView(r25);
        TextView r113 = (TextView) r25.findViewById(R.id.privacy_policy_text);
        i.e(r113, "privacyPolicyTextView");
        int r26 = ne.j.A0(r17, "{", 0, false, 6);
        int r27 = ne.j.A0(r17, "}", 0, false, 6);
        int r28 = ne.j.B0(r17, "{", 6);
        int r29 = ne.j.B0(r17, "}", 6);
        String r114 = "this as java.lang.String…ing(startIndex, endIndex)";
        if (this.f6695m == false) goto L52;
        if (r26 == (-1)) goto L52;
        if (r27 == (-1)) goto L52;
        if (r26 >= r27) goto L52;
        String r115 = r17.substring(r26 + 1, r27);
        i.e(r115, "this as java.lang.String…ing(startIndex, endIndex)");
    L54:
        if (this.f6695m == false) goto L59;
        if (r28 == (-1)) goto L59;
        if (r29 == (-1)) goto L59;
        if (r28 >= r29) goto L59;
        String r116 = r17.substring(r28 + 1, r29);
    L60:
        i.e(r116, r114);
        cd.b r117 = new cd.b(this, (String) yd.e.t0(r18, 0), r115, this);
        cd.b r30 = new cd.b(this, (String) yd.e.t0(r18, 1), r116, this);
        if (r26 == (-1)) goto L70;
        if (r27 == (-1)) goto L70;
        if (r28 == (-1)) goto L70;
        if (r29 == (-1)) goto L70;
        String r31 = g.u0(g.u0(r17, "{", ""), "}", "");
        if (r26 != r28) goto L69;
        if (r27 != r29) goto L69;
        SpannableString r32 = new SpannableString(r31);
        r32.setSpan(r117, r26, r27 - 1, 33);
    L71:
        r113.setText(r32);
        r113.setMovementMethod(LinkMovementMethod.getInstance());
        Window r33 = getWindow();     // Catch: Exception -> L74
        i.e(r33, "activity.window");     // Catch: Exception -> L74
        int r34 = r33.getDecorView().getSystemUiVisibility();     // Catch: Exception -> L74
        Window r118 = getWindow();     // Catch: Exception -> L74
        i.e(r118, "activity.window");     // Catch: Exception -> L74
        r118.getDecorView().setSystemUiVisibility(r34 | 512);     // Catch: Exception -> L74
        return;
    L74:
        e = move-exception;
        zc.b.c("ActivityUtils", "hideNavBar error", e);
        return;
    L69:
        SpannableString r35 = new SpannableString(r31);
        r35.setSpan(r117, r26, r27 - 1, 33);
        r35.setSpan(r30, r28 - 2, r29 - 3, 33);
        r32 = r35;
    L70:
        r32 = new SpannableString(r17);
    L59:
        r116 = getString(R.string.title_user_agreement);
        r114 = "getString(R.string.title_user_agreement)";
    L52:
        r115 = getString(R.string.title_privacy_policy);
        i.e(r115, "getString(R.string.title_privacy_policy)");
        goto L54
    L41:
        zc.b.h("PrivacyStatementActivity", "using custom packageName: " + r23);     // Catch: Exception -> L44
        goto L42
    L35:
        if (r23.length() == 0) goto L38;
        r24 = false;
    L44:
        e = move-exception;
        zc.b.c("PrivacyStatementActivity", "createCircularDrawableWithBorder error", e);
        goto L46
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public final void onDestroy() {
        zc.b.a("PrivacyStatementActivity", "onDestroy");
        View r8 = this.f6696n;
        if (r8 != null) goto L16;
    L7:
        View r10 = this.f6697o;
        if (r10 != null) goto L18;
    L12:
        this.f6696n = null;
        this.f6697o = null;
        super.onDestroy();
        String r11 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r11 == null) goto L20;
        f6690p.remove(r11);
        f6691q.remove(r11);
        LinkedHashMap r12 = f6692r;
        cd.a r13 = (cd.a) r12.get(r11);
        cd.a r14 = (cd.a) r12.remove(r11);
        return;
    L20:
        return;
    L18:
        WeakHashMap<View, h0> r15 = w.f8437a;     // Catch: Exception -> L11
        w.i.u(r10, null);     // Catch: Exception -> L11
    L11:
        zc.b.b("PrivacyStatementActivity", "removing contentChild WindowInsets listener failed");
        goto L12
    L16:
        r8.setOnApplyWindowInsetsListener(null);     // Catch: Exception -> L6
    L6:
        zc.b.b("PrivacyStatementActivity", "removing root WindowInsets listener failed");
        goto L7
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public final void onPause() {
        super.onPause();
        String r8 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r8 == null) goto L6;
        cd.a r10 = (cd.a) f6692r.get(r8);
        return;
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public final void onResume() {
        super.onResume();
        String r8 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r8 == null) goto L6;
        cd.a r10 = (cd.a) f6692r.get(r8);
        return;
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public final void onStart() {
        super.onStart();
        String r8 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r8 == null) goto L6;
        cd.a r10 = (cd.a) f6692r.get(r8);
        return;
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public final void onStop() {
        super.onStop();
        String r8 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r8 == null) goto L6;
        cd.a r10 = (cd.a) f6692r.get(r8);
        return;
    }
}
