package com.obric.oui.window.permission;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import cn.nubia.neopush.commons.Constant;
import com.obric.common.oui.R$string;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "com/obric/oui/window/permission/b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PrivacyStatementActivity extends AppCompatActivity {
    public static final LinkedHashMap A = null;
    public static final LinkedHashMap B = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final LinkedHashMap f14908x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final LinkedHashMap f14909y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final LinkedHashMap f14910z = null;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f14911t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f14912u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f14913v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.obric.oui.privacy.b f14914w;

    static {
        f14908x = new LinkedHashMap();
        f14909y = new LinkedHashMap();
        f14910z = new LinkedHashMap();
        A = new LinkedHashMap();
        B = new LinkedHashMap();
    }

    public PrivacyStatementActivity() {
        this.f14911t = true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (f14908x.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId")) != null) goto L6;
        return;
    L6:
        throw new ClassCastException();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
        super.onContentChanged();
        this.f14913v = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (getWindow().getDecorView().getFitsSystemWindows() == true) goto L9;
        View r5 = this.f14913v;
        if (r5 == null) goto L10;
        ViewCompat.setOnApplyWindowInsetsListener(r5, new a());
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r22) {
        if (getDelegate().getLocalNightMode() != 2) goto L5;
        boolean r5 = true;
    L7:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L9;
        boolean r10 = true;
    L10:
        ps.a.a("PrivacyStatementActivity", Intrinsics.stringPlus("onCreate savedInstanceState: ", r22));
        ps.a.a("PrivacyStatementActivity", Intrinsics.stringPlus("onCreate delegate.localNightMode: ", Integer.valueOf(getDelegate().getLocalNightMode())));
        ps.a.a("PrivacyStatementActivity", Intrinsics.stringPlus("onCreate isLocalInNightMode: ", Boolean.valueOf(r5)));
        ps.a.a("PrivacyStatementActivity", Intrinsics.stringPlus("onCreate isConfigNightMode: ", Boolean.valueOf(r10)));
        boolean r11 = getIntent().getBooleanExtra("forceNightMode", false);
        ps.a.a("PrivacyStatementActivity", Intrinsics.stringPlus("onCreate forceNightMode: ", Boolean.valueOf(r11)));
        if (r10 == true) goto L14;
        if (r11 == false) goto L14;
        boolean r12 = true;
    L15:
        if (r22 != null) goto L18;
        if (r11 == false) goto L18;
        getIntent().putExtra("forceNightMode", false);
        getDelegate().setLocalNightMode(2);
    L18:
        super.onCreate(r22);
        if (r22 != null) goto L21;
    L24:
        getWindow().setWindowAnimations(0);
        overridePendingTransition(0, 0);
        String r13 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r13 != null) goto L28;
    L29:
        LinkedHashMap r14 = f14908x;
        if (r22 == null) goto L37;
        ps.a.g("PrivacyStatementActivity", "onCreate, savedInstanceState is not null");
        if (r14.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId")) != null) goto L36;
        ps.a.g("PrivacyStatementActivity", "privacyConsentCallbacks is null, finish");
        finish();
        return;
    L36:
        throw new ClassCastException();
    L37:
        Window r15 = getWindow();
        r15.clearFlags(1024);
        r15.setBackgroundDrawableResource(R.color.transparent);
        r15.getAttributes().format = -2;
        this.f14911t = getIntent().getBooleanExtra("showNetworkConfirm", true);
        getIntent().getBooleanExtra("useLinkTextAsTitle", false);
        this.f14912u = r15.getDecorView().getRootView();
        if (r12 == true) goto L72;
        Intent r16 = getIntent();
        Intrinsics.checkNotNullParameter(r16, "intent");
        String r17 = r16.getStringExtra(Constant.TITLE);
        if (r17 != null) goto L42;
        r17 = getString(R$string.default_title);
    L42:
        String r18 = r16.getStringExtra(Constant.DESCRIPTION);
        String r19 = r16.getStringExtra("cancelText");
        String r110 = r16.getStringExtra("agreeText");
        CharSequence r20 = r16.getCharSequenceExtra("privacyText");
        String[] r111 = r16.getStringArrayExtra("urls");
        if (r111 != null) goto L45;
        r111 = new String[0];
    L45:
        String[] r112 = r111;
        boolean r113 = r16.getBooleanExtra("enableDim", true);
        boolean r114 = r16.getBooleanExtra("cancelable", true);
        boolean r21 = r16.getBooleanExtra("enableEnterAnim", false);
        if (r14.get(r16.getStringExtra("PrivacyStatementActivityInstanceId")) != null) goto L71;
        List r23 = (List) B.get(r16.getStringExtra("PrivacyStatementActivityInstanceId"));
        List r24 = (List) A.get(r16.getStringExtra("PrivacyStatementActivityInstanceId"));
        if (f14909y.get(r16.getStringExtra("PrivacyStatementActivityInstanceId")) != null) goto L69;
        String r25 = getIntent().getStringExtra("customPackageName");
        if (r25 != null) goto L52;
    L56:
        r25 = getPackageName();
    L55:
        String r115 = r25;
        if (r23 != null) goto L59;
        r23 = CollectionsKt.emptyList();
    L59:
        List r116 = r23;
        if (r20 != null) goto L63;
        String r26 = null;
    L62:
        String r117 = r26;
        if (r24 != null) goto L66;
        List r27 = CollectionsKt.emptyList();
    L67:
        com.obric.oui.privacy.b r28 = new com.obric.oui.privacy.b(this, new com.obric.oui.privacy.c(r115, r17, r18, r116, r117, r27, r110, r19, r113, r114, r21));
        c r29 = new c(this, r24, r112, r17);
        Intrinsics.checkNotNullParameter(r29, "listener");
        r28.e = r29;
        r28.b();
        this.f14914w = r28;
        getIntent().putExtra("finishShowSheet", true);
        return;
    L66:
        r27 = r24;
        goto L67
    L63:
        r26 = r20.toString();
        goto L62
    L52:
        if (r25.length() == 0) goto L56;
        ps.a.g("PrivacyStatementActivity", Intrinsics.stringPlus("using custom packageName: ", r25));
        goto L55
    L69:
        throw new ClassCastException();
    L71:
        throw new ClassCastException();
    L72:
        return;
    L28:
        if (f14910z.get(r13) == null) goto L29;
        throw new ClassCastException();
    L21:
        if (getIntent().getBooleanExtra("finishShowSheet", false) == false) goto L24;
        ps.a.a("PrivacyStatementActivity", "onCreate -> finish when savedInstanceState is not null and finishShowSheet is true");
        finish();
        return;
    L14:
        r12 = false;
        goto L15
    L9:
        r10 = false;
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        ps.a.a("PrivacyStatementActivity", "onDestroy");
        View r5 = this.f14912u;
        if (r5 != null) goto L38;
    L8:
        View r10 = this.f14913v;
        if (r10 != null) goto L34;
    L14:
        com.obric.oui.privacy.b r11 = this.f14914w;
        if (r11 != null) goto L36;
    L21:
        this.f14912u = null;
        this.f14913v = null;
        this.f14914w = null;
        super.onDestroy();
        String r12 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r12 == null) goto L40;
        LinkedHashMap r13 = f14910z;
        if (r13.get(r12) != null) goto L32;
        if (r13.remove(r12) != null) goto L30;
        return;
    L30:
        throw new ClassCastException();
    L32:
        throw new ClassCastException();
    L40:
        return;
    L36:
        com.obric.oui.sheet.v2.b r14 = r11.f14183c;     // Catch: Exception -> L33
        if (r14 == null) goto L21;
        r14.l();     // Catch: Exception -> L33
        goto L21
    L34:
        ViewCompat.setOnApplyWindowInsetsListener(r10, null);     // Catch: Exception -> L13
    L13:
        ps.a.c("PrivacyStatementActivity", "removing contentChild WindowInsets listener failed");
        goto L14
    L38:
        r5.setOnApplyWindowInsetsListener(null);     // Catch: Exception -> L7
    L7:
        ps.a.c("PrivacyStatementActivity", "removing root WindowInsets listener failed");
        goto L8
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        String r5 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r5 != null) goto L6;
        return;
    L6:
        if (f14910z.get(r5) != null) goto L9;
        return;
    L9:
        throw new ClassCastException();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        String r5 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r5 != null) goto L6;
        return;
    L6:
        if (f14910z.get(r5) != null) goto L9;
        return;
    L9:
        throw new ClassCastException();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        String r5 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r5 != null) goto L6;
        return;
    L6:
        if (f14910z.get(r5) != null) goto L9;
        return;
    L9:
        throw new ClassCastException();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        String r5 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r5 != null) goto L6;
        return;
    L6:
        if (f14910z.get(r5) != null) goto L9;
        return;
    L9:
        throw new ClassCastException();
    }
}
