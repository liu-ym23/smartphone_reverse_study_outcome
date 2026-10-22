package com.zte.miboard.cards.express.login;

import ai.j0;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.m;
import c.n;
import c.n0;
import c.o0;
import c.r0;
import c.s;
import c.s0;
import c.u;
import c.v;
import com.google.gson.Gson;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.ExpressCard;
import com.zte.miboard.cards.express.data.SimpleResultBean;
import com.zte.miboard.cards.express.more.ExpressMoreActivty;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class LoginActivity extends n implements View.OnClickListener {
    private RelativeLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private OInputLayout f16294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private OEditText f16295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private OInputLayout f16296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private OEditText f16297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Button f16298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Button f16299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private r0 f16300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f16301o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private u f16302p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f16303q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private n0 f16304r;

    public class a implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f16305a;

        public a(LoginActivity r5) {
            this.f16305a = r5;
        }

        @Override // c.n0
        public void a(ArrayList<o0> r5) {
            Pattern r10 = Pattern.compile("\\d{6}");
            Iterator<o0> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L12;
            o0 r12 = r11.next();
            if (r12 == null) goto L4;
            String r13 = r12.f1071a;
            if (TextUtils.isEmpty(r13) == true) goto L4;
            Matcher r14 = r10.matcher(r13);
            if (r14.find() == false) goto L4;
            String r15 = r14.group();
        L14:
            if (TextUtils.isEmpty(r15) == true) goto L25;
            LoginActivity.a(this.f16305a).setText(r15);
            return;
        L25:
            return;
        L12:
            r15 = null;
            goto L14
        }
    }

    public class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f16306a;

        public b(LoginActivity r5) {
            this.f16306a = r5;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r5) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r5, int r10, int r11, int r12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r5, int r10, int r11, int r12) {
            if (r5 == null) goto L14;
            String r13 = r5.toString();
            ArrayList r14 = s.f1081a;
            String r15 = "";
            if (r13 == null) goto L7;
            r15 = r13.replaceAll("\\s", "");
        L7:
            if (r15.length() != 11) goto L14;
            if (LoginActivity.b(this.f16306a) != null) goto L11;
        L12:
            Button r16 = LoginActivity.c(this.f16306a);
            boolean r17 = true;
        L13:
            r16.setEnabled(r17);
            return;
        L11:
            if (LoginActivity.b(this.f16306a).f1080b == true) goto L12;
            return;
        L14:
            r16 = LoginActivity.c(this.f16306a);
            r17 = false;
            goto L13
        }
    }

    public class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f16307a;

        public c(LoginActivity r5) {
            this.f16307a = r5;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r5) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r5, int r10, int r11, int r12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r5, int r10, int r11, int r12) {
            if (r5 != null) goto L4;
        L14:
            Button r13 = LoginActivity.e(this.f16307a);
            boolean r14 = false;
        L13:
            r13.setEnabled(r14);
            return;
        L4:
            if (r5.toString().length() != 6) goto L14;
            if (LoginActivity.d(this.f16307a).getText() == null) goto L14;
            String r15 = LoginActivity.d(this.f16307a).getText().toString();
            ArrayList r16 = s.f1081a;
            String r17 = "";
            if (r15 == null) goto L11;
            r17 = r15.replaceAll("\\s", "");
        L11:
            if (r17.length() != 11) goto L14;
            r13 = LoginActivity.e(this.f16307a);
            r14 = true;
            goto L13
        }
    }

    public class d implements mt.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoginActivity f16309b;

        public d(LoginActivity r5, String r10) {
            this.f16309b = r5;
            this.f16308a = r10;
        }

        public void a(SimpleResultBean r5) {
            m.i("LoginActivity", "verifyExpressCode res: " + r5.getResult());
            if (r5.getResult() == 0) goto L5;
            Toast.makeText(this.f16309b.getApplicationContext(), this.f16309b.getResources().getString(R.string.express_verify_code_error), 1).show();
            return;
        L5:
            if (r5.isSFSubscribeResultOk() == false) goto L7;
            m.i("LoginActivity", "verifyExpressCode isSFSubscribeResultOk");
            ExpressCard.f(this.f16309b.getApplicationContext());
        L7:
            LoginActivity.a(this.f16309b, this.f16308a);
            ExpressCard.q();
            ExpressCard.a(this.f16309b);
            Intent r10 = new Intent(this.f16309b.getApplicationContext(), ExpressMoreActivty.class);
            r10.addFlags(268435456);
            s0.g(this.f16309b, r10);
            this.f16309b.finish();
        }

        @Override // mt.u
        public void onComplete() {
            m.i("LoginActivity", "verifyExpressCode onCompleted: ");
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            m.i("LoginActivity", "verifyExpressCode onError: " + r5);
            Toast.makeText(this.f16309b.getApplicationContext(), this.f16309b.getResources().getString(R.string.express_bind_phone_failed), 1).show();
            LoginActivity.e(this.f16309b).setEnabled(true);
        }

        @Override // mt.u
        public /* bridge */ /* synthetic */ void onNext(Object r5) {
            a((SimpleResultBean) r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
        }
    }

    public LoginActivity() {
        this.f16301o = false;
        this.f16303q = false;
        this.f16304r = new a(this);
    }

    public static /* synthetic */ OInputLayout a(LoginActivity r5) {
        return r5.f16296j;
    }

    public static /* synthetic */ r0 b(LoginActivity r5) {
        return r5.f16300n;
    }

    public static /* synthetic */ Button c(LoginActivity r5) {
        return r5.f16298l;
    }

    public static /* synthetic */ OInputLayout d(LoginActivity r5) {
        return r5.f16294h;
    }

    public static /* synthetic */ Button e(LoginActivity r5) {
        return r5.f16299m;
    }

    private void g() {
        RelativeLayout r5 = (RelativeLayout) findViewById(R.id.express_login_content);
        this.g = r5;
        r5.setVisibility(0);
        h();
    }

    private void h() {
        OInputLayout r5 = (OInputLayout) findViewById(R.id.login_input_phone);
        this.f16294h = r5;
        this.f16295i = r5.getVInput();
        OInputLayout r10 = (OInputLayout) findViewById(R.id.login_input_code);
        this.f16296j = r10;
        OEditText r11 = r10.getVInput();
        this.f16297k = r11;
        r11.setEllipsize(TextUtils.TruncateAt.END);
        this.f16298l = (Button) findViewById(R.id.login_request_code_btn);
        this.f16299m = (Button) findViewById(R.id.login_commit_btn);
        this.f16298l.setOnClickListener(this);
        this.f16295i.setFilters(new InputFilter[]{new InputFilter.LengthFilter(getResources().getInteger(R.integer.express_login_phone_edit_max_length))});
        this.f16297k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(getResources().getInteger(R.integer.express_login_code_edit_max_length))});
        boolean r12 = s0.f1083a;
        int r13 = (int) ((8.0f * getResources().getDisplayMetrics().density) + 0.5f);
        View r14 = this.f16296j.findViewById(R.id.input_container);
        r14.setPadding(r14.getPaddingLeft(), r13, r14.getPaddingRight(), r13);
        this.f16298l.setEnabled(false);
        this.f16299m.setOnClickListener(this);
        this.f16295i.addTextChangedListener(new b(this));
        this.f16297k.addTextChangedListener(new c(this));
        Button r15 = this.f16298l;
        r0 r16 = new r0(60000, 1000);
        r16.f1080b = true;
        r16.f1079a = r15;
        this.f16300n = r16;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r5, int r10, @Nullable Intent r11) {
        super.onActivityResult(r5, r10, r11);
        m.i("LoginActivity", "onActivityResult requestCode=" + r5 + " resultCode=" + r10);
        if (1100 == r5) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        finish();
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (this.f16294h.getText() != null) goto L5;
        return;
    L5:
        if (this.f16296j.getText() == null) goto L52;
        String r5 = this.f16294h.getText().toString();
        ArrayList r11 = s.f1081a;
        String r12 = "";
        if (r5 == null) goto L10;
        r12 = r5.replaceAll("\\s", "");
    L10:
        String r13 = this.f16296j.getText().toString().trim();
        if (r10.getId() != R.id.login_request_code_btn) goto L35;
        if (a(r12) == true) goto L16;
        return;
    L16:
        if (v.b(getApplicationContext()) == true) goto L20;
        Resources r14 = getResources();
        int r15 = R.string.net_connected_error;
    L18:
        Toast.makeText(this, r14.getString(r15), 1).show();
        return;
    L20:
        Iterator r16 = s.b(getApplicationContext()).iterator();
    L22:
        if (r16.hasNext() == false) goto L33;
        String r17 = (String) r16.next();
        if (r17.length() != 11) goto L29;
        if (r17.equals(r12) == false) goto L29;
    L32:
        r14 = getResources();
        r15 = R.string.express_phone_has_bind_tips;
    L29:
        if (r17.length() != 10) goto L22;
        if (r17.equals(r12.substring(1)) == false) goto L22;
    L33:
        m.m(getApplicationContext(), r12);
        this.f16296j.requestFocus();
        String r18 = getApplicationContext().getResources().getString(R.string.express_verify_code_tips, new Object[]{r12});
        Toast.makeText(getApplicationContext(), r18, 0).show();
        this.f16300n.start();
        return;
    L35:
        if (r10.getId() == R.id.login_commit_btn) goto L37;
        return;
    L37:
        if (v.b(getApplicationContext()) == true) goto L39;
        Toast.makeText(this, getResources().getString(R.string.net_connected_error), 1).show();
        return;
    L39:
        this.f16300n.cancel();
        this.f16300n.onFinish();
        a(r12, r13);
        this.f16299m.setEnabled(false);
        return;
    }

    @Override // c.n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.express_login);
        m.i("LoginActivity", "LoginActivity onCreate: mNeedCheckStatement=" + this.f16301o);
        g();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m.i("LoginActivity", "onDestroy");
        r0 r5 = this.f16300n;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.f1080b == true) goto L9;
        r5.cancel();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        m.i("LoginActivity", "LoginActivity onPause: ");
        u r5 = this.f16302p;
        if (r5 == null) goto L9;
        String[] r10 = u.f1085a;
        unregisterReceiver(r5);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        m.j("SmsBroadcastReceiver", "unregisterReceiver error", e);
    L9:
        n0 r11 = this.f16304r;
        ArrayList r12 = u.f1086b;
        if (r12.contains(r11) == false) goto L15;
        r12.remove(r11);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r5, @NonNull String[] r10, @NonNull int[] r11) {
        super.onRequestPermissionsResult(r5, r10, r11);
        StringBuilder r12 = j0.s(r5, "onRequestPermissionsResult requestCode=", " permissions=");
        r12.append(Arrays.asList(r10));
        r12.append(" grantResults=");
        r12.append(new Gson().toJson(r11));
        m.i("LoginActivity", r12.toString());
        if (r5 != 1000) goto L6;
        a(true);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f16301o == true) goto L6;
        a(false);
        return;
    }

    public static /* synthetic */ void a(LoginActivity r5, String r10) {
        r5.b(r10);
    }

    private void b(String r5) {
        Context r10 = getApplicationContext();
        List r11 = s.b(r10);
        r11.add(r5.substring(1));
        if (r11.size() <= 0) goto L6;
        String r12 = new Gson().toJson(r11);
        SharedPreferences.Editor r13 = r10.getSharedPreferences("express_info", 0).edit();
        r13.putString("express_data", r12);
        r13.commit();
    L6:
        ExpressCard.b(getApplicationContext());
    }

    @Override // c.n
    public String d() {
        return "";
    }

    private void a(String r5, String r10) {
        m.d(getApplicationContext(), r5, r10, new d(this, r5));
    }

    private void a(boolean r10) {
        String[] r5 = u.f1085a;
        HashMap r11 = new HashMap();
        boolean r12 = false;
        String r13 = r5[0];
        if (checkSelfPermission(r13) != 0) goto L5;
        boolean r14 = true;
    L6:
        r11.put(r13, Boolean.valueOf(r14));
        boolean r15 = r11.containsValue(Boolean.FALSE);
        boolean r16 = !r15;
        if (r15 == false) goto L9;
        m.l("SmsBroadcastReceiver", "registerReceiver checkHasAllPermissions not grant, return null");
        u r17 = null;
    L14:
        this.f16302p = r17;
        StringBuilder r18 = new StringBuilder("initSmsIfNeed mRequest=");
        r18.append(this.f16303q);
        r18.append(" mSmsBroadcastReceiver=");
        if (this.f16302p == null) goto L17;
        r12 = true;
    L17:
        r18.append(r12);
        r18.append(" fromPermissionsResult=");
        r18.append(r10);
        m.i("LoginActivity", r18.toString());
        n0 r19 = this.f16304r;
        if (r19 == null) goto L23;
        ArrayList r20 = u.f1086b;
        if (r20.contains(r19) == true) goto L23;
        r20.add(r19);
    L23:
        if (this.f16302p == null) goto L25;
    L28:
        this.f16303q = true;
        return;
    L25:
        if (this.f16303q == true) goto L28;
        if (r10 == true) goto L28;
        requestPermissions(u.f1085a, 1000);
        goto L28
    L9:
        m.i("SmsBroadcastReceiver", "registerReceiver grant=" + r16);
        r17 = new u();
        IntentFilter r21 = new IntentFilter();     // Catch: Exception -> L12
        r21.addAction("android.provider.Telephony.SMS_RECEIVED");     // Catch: Exception -> L12
        r21.addAction("com.android.internal.telephony.VERIFY_CODE_SMS_RECEIVED");     // Catch: Exception -> L12
        registerReceiver(r17, r21, 2);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        m.j("SmsBroadcastReceiver", "registerReceiver error", e);
        goto L14
    L5:
        r14 = false;
        goto L6
    }

    private boolean a(String r5) {
        ArrayList r10 = s.f1081a;
        if (r5.isEmpty() == false) goto L6;
    L14:
        Toast.makeText(this, getResources().getString(R.string.express_phone_number_error), 0).show();
        return false;
    L6:
        if (r5.length() != 11) goto L14;
        if (TextUtils.isEmpty(r5) == false) goto L10;
        boolean r11 = false;
    L11:
        if (r11 == false) goto L14;
        return true;
    L10:
        r11 = r5.matches("[1][3456789]\\d{9}");
        goto L11
    }
}
