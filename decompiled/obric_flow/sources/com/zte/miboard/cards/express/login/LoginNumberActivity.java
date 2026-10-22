package com.zte.miboard.cards.express.login;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import ar.a;
import c.c0;
import c.m;
import c.n;
import c.s;
import c.s0;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.zte.miboard.cards.R;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LoginNumberActivity extends n implements View.OnClickListener {
    private RecyclerView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c0 f16310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f16311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Button f16312j;

    public LoginNumberActivity() {
    }

    private void h() {
        List<String> r5 = this.f16311i;
        c0 r10 = new c0();
        r10.f1030b = this;
        r10.f1031c = r5;
        this.f16310h = r10;
        this.g.setAdapter(r10);
    }

    private void i() {
        this.f16311i = s.c(getApplicationContext());
    }

    private void j() {
        i();
        h();
    }

    @Override // c.n
    public int b() {
        return getResources().getDimensionPixelSize(R.dimen.aty_first_item_padding_top_8dp);
    }

    public void g() {
        if (s.b(getApplicationContext()).size() < 5) goto L6;
        Toast.makeText(getApplicationContext(), R.string.express_bind_number, 1).show();
        return;
    L6:
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5.getId() != R.id.login_commit_btn) goto L6;
        g();
        return;
    }

    @Override // c.n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.express_login_number);
        RecyclerView r10 = (RecyclerView) findViewById(R.id.bind_phone_info_contents);
        this.g = r10;
        r10.setLayoutManager(new com.obric.oui.orecyclerview.widget.s());
        Button r11 = (Button) findViewById(R.id.login_commit_btn);
        this.f16312j = r11;
        r11.setOnClickListener(new a(this, 20));
        m.i("LoginNumberActivityTest", "onCreate: ");
        boolean r12 = s0.f1083a;
        if (Resources.getSystem().getConfiguration().fontScale <= 1.0f) goto L10;
        View r13 = findViewById(R.id.bind_phone_nubmer);
        if (r13 != null) goto L7;
        return;
    L7:
        if ((r13.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13.getLayoutParams();
        r14.topMargin = 0;
        r13.setLayoutParams(r14);
        return;
    L12:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m.i("LoginNumberActivityTest", "onDestroy: ");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        m.i("LoginNumberActivityTest", "onPause: ");
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        m.i("LoginNumberActivityTest", "onRestart: ");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        j();
        m.i("LoginNumberActivityTest", "onResume: ");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        m.i("LoginNumberActivityTest", "onStart: ");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        m.i("LoginNumberActivityTest", "onStop: ");
    }
}
