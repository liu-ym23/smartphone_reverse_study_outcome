package com.obric.oui.window.permission;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.oui.actionbar.OBottomActionBar;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import u8.f;
import u8.h;
import u8.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 12\u00020\u0001:\u0003234B\u0007¢\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J(\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0014J\b\u0010 \u001a\u00020\u0017H\u0014J\b\u0010!\u001a\u00020\u0017H\u0014J\b\u0010\"\u001a\u00020\u0017H\u0014J\b\u0010#\u001a\u00020\u0017H\u0014J\b\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0002H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010)R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010+¨\u00065"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "", "isEdgeToEdge", "", "message", "", "urls", "Landroid/content/Context;", "context", "Landroid/text/SpannableString;", "processMessage", "(Ljava/lang/String;[Ljava/lang/String;Landroid/content/Context;)Landroid/text/SpannableString;", "url", "title", "Landroid/text/style/ClickableSpan;", "createClickableSpan", "text", "span", "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "applyClickableSpan", "", "openBrowser", "finishWithAnim", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onContentChanged", "onBackPressed", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onAgree", "onDisagree", "canFinishSelfInOnCreateIfCallbackNotSet", "Landroid/view/View;", "root", "Landroid/view/View;", "useLinkTextAsTitle", "Z", "hasAgreed", "contentChild", "showNetworkConfirm", "<init>", "()V", "Companion", "a", "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class PrivacyStatementActivity extends AppCompatActivity {
    public static final a Companion = null;
    private static final String EXTRA__KEY_ACTIVITY_INSTANCE_ID = "PrivacyStatementActivityInstanceId";
    private static final String TAG = "PrivacyStatementActivity";
    private static final Map<String, a.AbstractC0136a> activityCustomizers = null;
    private static int counter;
    private static final Map<String, b> linkClickListeners = null;
    private static final Map<String, c> privacyConsentCallbacks = null;
    private View contentChild;
    private boolean hasAgreed;
    private View root;
    private boolean showNetworkConfirm;
    private boolean useLinkTextAsTitle;

    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.window.permission.PrivacyStatementActivity$a$a, reason: collision with other inner class name */
        public static abstract class AbstractC0136a {
            public AbstractC0136a() {
            }

            public void a(Activity r10) {
                Intrinsics.checkNotNullParameter(r10, "activity");
            }

            public void b(Activity r10) {
                Intrinsics.checkNotNullParameter(r10, "activity");
            }

            public void c(Activity r10) {
                Intrinsics.checkNotNullParameter(r10, "activity");
            }

            public void d(Activity r10) {
                Intrinsics.checkNotNullParameter(r10, "activity");
            }

            public void e(Activity r10) {
                Intrinsics.checkNotNullParameter(r10, "activity");
            }

            public void f(Activity r10) {
                Intrinsics.checkNotNullParameter(r10, "activity");
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface b {
        void a(String r10, Context r11);
    }

    public interface c {
        @Deprecated(message = "use onAgree(activity: Activity) instead")
        void a();

        boolean b(Activity r10);

        boolean c(Activity r10);

        @Deprecated(message = "use onCancel(activity: Activity) instead")
        void onCancel();
    }

    /* JADX INFO: renamed from: com.obric.oui.window.permission.PrivacyStatementActivity$createClickableSpan$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ClickableSpan {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PrivacyStatementActivity f7767c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f7768g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f7769h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f7770i;

        AnonymousClass1(PrivacyStatementActivity r10, String r11, String r12, Context r13) {
            this.f7767c = r10;
            this.f7768g = r11;
            this.f7769h = r12;
            this.f7770i = r13;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r10) {
            Intrinsics.checkNotNullParameter(r10, "widget");
            final b r11 = (b) PrivacyStatementActivity.access$getLinkClickListeners$cp().get(this.f7767c.getIntent().getStringExtra(PrivacyStatementActivity.EXTRA__KEY_ACTIVITY_INSTANCE_ID));
            boolean r12 = true;
            if (PrivacyStatementActivity.access$getShowNetworkConfirm$p(this.f7767c) == true) goto L15;
            String r13 = this.f7768g;
            if (r13 != null) goto L7;
        L10:
            if (r12 == true) goto L28;
            if (r11 == null) goto L29;
            r11.a(this.f7768g, this.f7767c);
            return;
        L29:
            return;
        L28:
            return;
        L7:
            if (r13.length() == 0) goto L10;
            r12 = false;
            goto L10
        L15:
            if (PrivacyStatementActivity.access$getHasAgreed$p(this.f7767c) == false) goto L26;
            String r14 = this.f7768g;
            if (r14 != null) goto L19;
        L22:
            if (r12 == true) goto L30;
            if (r11 == null) goto L25;
            r11.a(this.f7768g, this.f7767c);
            return;
        L25:
            PrivacyStatementActivity.access$openBrowser(this.f7767c, this.f7768g, this.f7769h);
            return;
        L30:
            return;
        L19:
            if (r14.length() == 0) goto L22;
            r12 = false;
            goto L22
        L26:
            OAlertDialogBuilder r15 = OAlertDialogBuilder.s(new OAlertDialogBuilder(this.f7767c).l(false), this.f7767c.getString(j.privacy_permisssion_dialog_title), false, 2, null).n(this.f7767c.getString(j.privacy_permisssion_dialog_message));
            String r16 = this.f7767c.getString(j.oui_agree);
            Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.oui_agree)");
            OAlertDialogBuilder r17 = r15.q(r16, new PrivacyStatementActivity$createClickableSpan$1$onClick$1(this, r11));
            String r18 = this.f7767c.getString(j.oui_cancel_only);
            Intrinsics.checkNotNullExpressionValue(r18, "getString(R.string.oui_cancel_only)");
            r17.o(r18, PrivacyStatementActivity$createClickableSpan$1$onClick$2.INSTANCE).a().show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r10) {
            Intrinsics.checkNotNullParameter(r10, "ds");
            super.updateDrawState(r10);
            r10.setColor(ContextCompat.getColor(this.f7770i, u8.c.oui_fill_highlighted));
            r10.setUnderlineText(false);
        }
    }

    static final class d implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f7772b;

        d(int r10, ImageView r11) {
            this.f7771a = r10;
            this.f7772b = r11;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View r10, WindowInsets r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, "insets");
            int r12 = r11.getSystemWindowInsetTop();
            int r13 = (int) ((((double) this.f7771a) * 0.235d) - ((double) r12));
            ImageView r14 = this.f7772b;
            Intrinsics.checkNotNullExpressionValue(r14, "iconImageView");
            ViewGroup.LayoutParams r15 = r14.getLayoutParams();
            Objects.requireNonNull(r15, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
            r16.topMargin = r13;
            ImageView r17 = this.f7772b;
            Intrinsics.checkNotNullExpressionValue(r17, "iconImageView");
            r17.setLayoutParams(r16);
            return r10.onApplyWindowInsets(r11);
        }
    }

    static final class e implements OBottomActionBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrivacyStatementActivity f7773a;

        e(PrivacyStatementActivity r10) {
            this.f7773a = r10;
        }

        @Override // com.obric.oui.actionbar.OBottomActionBar.b
        public final void a(View r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "<anonymous parameter 0>");
            c r12 = (c) PrivacyStatementActivity.access$getPrivacyConsentCallbacks$cp().get(this.f7773a.getIntent().getStringExtra(PrivacyStatementActivity.EXTRA__KEY_ACTIVITY_INSTANCE_ID));
            if (r11 != 1) goto L10;
            if (r12 != null) goto L6;
        L7:
            if (r12 == null) goto L9;
            r12.a();
        L9:
            this.f7773a.onAgree();
            PrivacyStatementActivity.access$finishWithAnim(this.f7773a);
            return;
        L6:
            if (r12.b(this.f7773a) != true) goto L7;
            return;
        L10:
            if (r12 != null) goto L12;
        L13:
            if (r12 == null) goto L15;
            r12.onCancel();
        L15:
            this.f7773a.onDisagree();
            this.f7773a.finish();
            return;
        L12:
            if (r12.c(this.f7773a) != true) goto L13;
        }
    }

    static {
        Companion = new a(null);
        privacyConsentCallbacks = new LinkedHashMap();
        linkClickListeners = new LinkedHashMap();
        activityCustomizers = new LinkedHashMap();
    }

    public PrivacyStatementActivity() {
        this.showNetworkConfirm = true;
    }

    public static final /* synthetic */ void access$finishWithAnim(PrivacyStatementActivity r10) {
        r10.finishWithAnim();
    }

    public static final /* synthetic */ Map access$getActivityCustomizers$cp() {
        return activityCustomizers;
    }

    public static final /* synthetic */ int access$getCounter$cp() {
        return counter;
    }

    public static final /* synthetic */ boolean access$getHasAgreed$p(PrivacyStatementActivity r10) {
        return r10.hasAgreed;
    }

    public static final /* synthetic */ Map access$getLinkClickListeners$cp() {
        return linkClickListeners;
    }

    public static final /* synthetic */ Map access$getPrivacyConsentCallbacks$cp() {
        return privacyConsentCallbacks;
    }

    public static final /* synthetic */ boolean access$getShowNetworkConfirm$p(PrivacyStatementActivity r10) {
        return r10.showNetworkConfirm;
    }

    public static final /* synthetic */ void access$openBrowser(PrivacyStatementActivity r10, String r11, String r12) {
        r10.openBrowser(r11, r12);
    }

    public static final /* synthetic */ void access$setCounter$cp(int r10) {
        counter = r10;
    }

    public static final /* synthetic */ void access$setHasAgreed$p(PrivacyStatementActivity r10, boolean r11) {
        r10.hasAgreed = r11;
    }

    public static final /* synthetic */ void access$setShowNetworkConfirm$p(PrivacyStatementActivity r10, boolean r11) {
        r10.showNetworkConfirm = r11;
    }

    private final SpannableString applyClickableSpan(String r10, ClickableSpan r11, int r12, int r13) {
        SpannableString r14 = new SpannableString(r10);
        r14.setSpan(r11, r12, r13, 33);
        return r14;
    }

    private final ClickableSpan createClickableSpan(Context r10, String r11, String r12) {
        return new AnonymousClass1(this, r11, r12, r10);
    }

    private final void finishWithAnim() {
        super.finish();
        overridePendingTransition(u8.a.oui_transition_settings_out_a, u8.a.oui_transition_settings_out_b);
    }

    private final boolean isEdgeToEdge() {
        Window r10 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r10, "window");
        View r11 = r10.getDecorView();
        Intrinsics.checkNotNullExpressionValue(r11, "window.decorView");
        return !r11.getFitsSystemWindows();
    }

    private final void openBrowser(String r10, String r11) {
        WebViewActivity.open(this, r10, r11);
    }

    private final SpannableString processMessage(String r23, String[] r24, Context r25) {
        int r10 = StringsKt.indexOf$default(r23, "{", 0, false, 6, null);
        int r11 = StringsKt.indexOf$default(r23, "}", 0, false, 6, null);
        int r12 = StringsKt.lastIndexOf$default(r23, "{", 0, false, 6, null);
        int r13 = StringsKt.lastIndexOf$default(r23, "}", 0, false, 6, null);
        String r14 = "this as java.lang.String…ing(startIndex, endIndex)";
        if (this.useLinkTextAsTitle == false) goto L8;
        if (r10 == (-1)) goto L8;
        if (r11 == (-1)) goto L8;
        if (r10 >= r11) goto L8;
        String r15 = r23.substring(r10 + 1, r11);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String…ing(startIndex, endIndex)");
    L10:
        if (this.useLinkTextAsTitle == false) goto L15;
        if (r12 == (-1)) goto L15;
        if (r13 == (-1)) goto L15;
        if (r12 >= r13) goto L15;
        String r16 = r23.substring(r12 + 1, r13);
    L16:
        Intrinsics.checkNotNullExpressionValue(r16, r14);
        ClickableSpan r17 = createClickableSpan(r25, (String) ArraysKt.getOrNull(r24, 0), r15);
        ClickableSpan r18 = createClickableSpan(r25, (String) ArraysKt.getOrNull(r24, 1), r16);
        if (r10 == (-1)) goto L27;
        if (r11 == (-1)) goto L27;
        if (r12 == (-1)) goto L27;
        if (r13 == (-1)) goto L27;
        String r19 = StringsKt.replace$default(StringsKt.replace$default(r23, "{", "", false, 4, null), "}", "", false, 4, null);
        if (r10 != r12) goto L25;
        if (r11 != r13) goto L25;
        return applyClickableSpan(r19, r17, r10, r11 - 1);
    L25:
        SpannableString r20 = new SpannableString(r19);
        r20.setSpan(r17, r10, r11 - 1, 33);
        r20.setSpan(r18, r12 - 2, r13 - 3, 33);
        return r20;
    L27:
        return new SpannableString(r23);
    L15:
        r16 = getString(j.title_user_agreement);
        r14 = "getString(R.string.title_user_agreement)";
    L8:
        r15 = getString(j.title_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(r15, "getString(R.string.title_privacy_policy)");
        goto L10
    }

    public boolean canFinishSelfInOnCreateIfCallbackNotSet() {
        return true;
    }

    public void onAgree() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        c r10 = privacyConsentCallbacks.get(getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID));
        if (r10 != null) goto L5;
    L6:
        if (r10 == null) goto L8;
        r10.onCancel();
    L8:
        onDisagree();
        finish();
        return;
    L5:
        if (r10.c(this) != true) goto L6;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        this.contentChild = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (isEdgeToEdge() == false) goto L8;
        View r10 = this.contentChild;
        if (r10 == null) goto L9;
        ViewCompat.setOnApplyWindowInsetsListener(r10, PrivacyStatementActivity$onContentChanged$1$1.INSTANCE);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r21) {
        ea.b.a(TAG, "onCreate");
        super.onCreate(r21);
        String r10 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r10 == null) goto L8;
        a.AbstractC0136a r11 = activityCustomizers.get(r10);
        if (r11 == null) goto L8;
        r11.a(this);
    L8:
        if (canFinishSelfInOnCreateIfCallbackNotSet() == false) goto L15;
        if (r21 == null) goto L15;
        ea.b.j(TAG, "onCreate, savedInstanceState is not null");
        if (privacyConsentCallbacks.get(getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)) != null) goto L14;
        ea.b.j(TAG, "privacyConsentCallbacks is null, finish");
        finish();
        overridePendingTransition(0, 0);
        return;
    L14:
        ea.b.e(TAG, "privacyConsentCallbacks is not null");
    L15:
        setContentView(h.activity_privacy_statement);
        Window r12 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r12, "window");
        int r13 = u8.c.oui_bg_base_1;
        r12.setStatusBarColor(getColor(r13));
        r12.setNavigationBarColor(getColor(r13));
        if (Build.VERSION.SDK_INT < 30) goto L18;
        da.a.a(this);
    L18:
        this.showNetworkConfirm = getIntent().getBooleanExtra("showNetworkConfirm", true);
        this.useLinkTextAsTitle = getIntent().getBooleanExtra("useLinkTextAsTitle", false);
        String r14 = getIntent().getStringExtra("title");
        if (r14 != null) goto L22;
        r14 = getString(j.default_title);
    L22:
        Intrinsics.checkNotNullExpressionValue(r14, "intent.getStringExtra(\"t…g(R.string.default_title)");
        Intrinsics.checkNotNullExpressionValue(getString(j.default_description), "getString(R.string.default_description)");
        String r15 = getIntent().getStringExtra("customizedCancelText");
        if (r15 != null) goto L26;
        r15 = getString(j.oui_cancel_and_quit);
    L26:
        Intrinsics.checkNotNullExpressionValue(r15, "intent.getStringExtra(\"c…ring.oui_cancel_and_quit)");
        String r16 = getString(j.oui_agree);
        Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.oui_agree)");
        String r17 = getIntent().getStringExtra("privacyText");
        if (r17 != null) goto L30;
        r17 = getString(j.privacy_policy_text);
    L30:
        String r18 = r17;
        Intrinsics.checkNotNullExpressionValue(r18, "intent.getStringExtra(\"p…ring.privacy_policy_text)");
        int r19 = getIntent().getIntExtra("iconResId", u8.e.white_circle);
        String[] r20 = getIntent().getStringArrayExtra("urls");
        if (r20 != null) goto L34;
        r20 = new String[0];
    L34:
        String[] r110 = r20;
        TextView r22 = (TextView) findViewById(f.title);
        TextView r111 = (TextView) findViewById(f.privacy_policy_text);
        ImageView r112 = (ImageView) findViewById(f.icon);
        Resources r113 = getResources();
        Intrinsics.checkNotNullExpressionValue(r113, "resources");
        int r114 = r113.getDisplayMetrics().heightPixels;
        View r23 = r12.getDecorView();
        Intrinsics.checkNotNullExpressionValue(r23, "window.decorView");
        View r24 = r23.getRootView();
        this.root = r24;
        if (r24 == null) goto L37;
        r24.setOnApplyWindowInsetsListener(new d(r114, r112));
    L37:
        OBottomActionBar r25 = (OBottomActionBar) findViewById(f.bottom_action_bar);
        r25.g(false, "l1", true, new String[]{r15, r16}, null);
        r25.setBottomButtonClickListener(new e(this));
        Intrinsics.checkNotNullExpressionValue(r22, "titleTextView");
        r22.setText(r14);
        Drawable r26 = ContextCompat.getDrawable(this, r19);     // Catch: Exception -> L40
        Intrinsics.checkNotNull(r26);     // Catch: Exception -> L40
        Intrinsics.checkNotNullExpressionValue(r26, "ContextCompat.getDrawable(this, iconResId)!!");     // Catch: Exception -> L40
        r112.setImageDrawable(r9.a.f12702a.a(this, r26, -1.0f, -1.0f, 1.33f, ContextCompat.getColor(this, u8.c.oui_basic_line_1)));     // Catch: Exception -> L40
    L42:
        Intrinsics.checkNotNullExpressionValue(r111, "privacyPolicyTextView");
        r111.setText(processMessage(r18, r110, this));
        r111.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L40:
        e = move-exception;
        ea.b.c(TAG, "createCircularDrawableWithBorder error", e);
        goto L42
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        ea.b.a(TAG, "onDestroy");
        View r10 = this.root;
        if (r10 != null) goto L19;
    L7:
        View r11 = this.contentChild;
        if (r11 != null) goto L21;
    L12:
        this.root = null;
        this.contentChild = null;
        super.onDestroy();
        String r12 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r12 == null) goto L23;
        privacyConsentCallbacks.remove(r12);
        linkClickListeners.remove(r12);
        Map<String, a.AbstractC0136a> r13 = activityCustomizers;
        a.AbstractC0136a r14 = r13.get(r12);
        if (r14 == null) goto L17;
        r14.b(this);
    L17:
        a.AbstractC0136a r15 = r13.remove(r12);
        return;
    L23:
        return;
    L21:
        ViewCompat.setOnApplyWindowInsetsListener(r11, null);     // Catch: Exception -> L11
    L11:
        ea.b.b(TAG, "removing contentChild WindowInsets listener failed");
        goto L12
    L19:
        r10.setOnApplyWindowInsetsListener(null);     // Catch: Exception -> L6
    L6:
        ea.b.b(TAG, "removing root WindowInsets listener failed");
        goto L7
    }

    public void onDisagree() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        String r10 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r10 == null) goto L8;
        a.AbstractC0136a r11 = activityCustomizers.get(r10);
        if (r11 == null) goto L9;
        r11.c(this);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        String r10 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r10 == null) goto L8;
        a.AbstractC0136a r11 = activityCustomizers.get(r10);
        if (r11 == null) goto L9;
        r11.d(this);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        String r10 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r10 == null) goto L8;
        a.AbstractC0136a r11 = activityCustomizers.get(r10);
        if (r11 == null) goto L9;
        r11.e(this);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        String r10 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r10 == null) goto L8;
        a.AbstractC0136a r11 = activityCustomizers.get(r10);
        if (r11 == null) goto L9;
        r11.f(this);
        return;
    L9:
        return;
    }
}
