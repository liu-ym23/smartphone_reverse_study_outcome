package c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.nubia.neopush.commons.Constant;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.zte.miboard.cards.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f extends n implements View.OnClickListener {
    public String A;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RecyclerView f1042t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public d f1043u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f1044v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f1045w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LinearLayout f1046x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LinearLayout f1047y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f1048z;

    public f() {
        this.f1044v = new ArrayList();
    }

    public final void h() {
        if (v.b(getApplicationContext()) == true) goto L5;
        this.f1046x.setVisibility(0);
        this.f1047y.setVisibility(8);
        return;
    L5:
        Intent r5 = getIntent();
        this.f1048z = r5.getStringExtra("mailNo");
        this.A = r5.getStringExtra("orderNo");
        String r10 = this.f1048z;
        if (v.b(getApplicationContext()) == false) goto L8;
        j r11 = new j(this, r10);
        m.i("ExpressNetwork", "deleteExpressDatas enter: ");
        l r12 = m.a(this);
        JsonObject r13 = new JsonObject();
        m.c(this, r13);
        r13.addProperty("version", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        r13.addProperty(Constant.IMEI, "");
        r13.addProperty("androidId", k0.a(this));
        r13.addProperty("mailNo", r10);
        r13.addProperty("newSF", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        j0.b(r12.a(r13), r11);
    L8:
        this.f1046x.setVisibility(8);
        this.f1047y.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5.getId() != R.id.express_look_goods_button) goto L16;
        Context r10 = getApplicationContext();
        String r11 = this.f1048z;
        String r12 = this.A;
        if (s0.h(r10, "com.jingdong.app.mall") == true) goto L7;
        Intent r13 = new Intent(this, e.class);
        r13.addFlags(268435456);
        s0.g(this, r13);
        return;
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r11 = r12;
    L9:
        String r14 = ai.j0.k("openApp.jdMobile://virtual?params={\"category\":\"jump\",\"sourceValue\":\"win_Wuliu\",\"sourceType\":\"win_Search\",\"des\":\"orderDetail\",\"orderId\":\"", r11, "\",\"msf_type\":\"click\",\"M_sourceFrom\":\"zhongxing\"}");
        ArrayList r15 = s.f1081a;
        Intent r16 = new Intent("android.intent.action.VIEW", Uri.parse(r14));     // Catch: Exception -> L12
        r16.addFlags(268435456);     // Catch: Exception -> L12
        s0.g(r10, r16);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        m.i("ExpressUtils", "startOtherActivity error: " + r14);
        return;
    L16:
        if (r5.getId() != R.id.express_detail_no_internet) goto L23;
        h();
        return;
    }

    @Override // c.n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.express_detail_main_view);
        LinearLayout r10 = (LinearLayout) findViewById(R.id.express_detail_no_internet);
        this.f1046x = r10;
        r10.setOnClickListener(new ar.a(this, 2));
        this.f1047y = (LinearLayout) findViewById(R.id.express_detail_content);
        RecyclerView r11 = (RecyclerView) findViewById(R.id.expres_detail_recycler_view);
        this.f1042t = r11;
        r11.setLayoutManager(new LinearLayoutManager(this));
        ArrayList r12 = this.f1044v;
        d r13 = new d();
        r13.f1032a = this;
        r13.f1033b = r12;
        this.f1043u = r13;
        this.f1042t.setAdapter(r13);
        this.f1043u.notifyDataSetChanged();
        this.f1045w = (TextView) findViewById(R.id.express_detail_mailno);
        ((Button) findViewById(R.id.express_look_goods_button)).setOnClickListener(new ar.a(this, 2));
        m.i("ExpressDetailActivity", "ExpressDetailActivity onCreate: ");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        m.i("ExpressDetailActivity", "ExpressDetailActivity onDestroy: ");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        h();
        m.i("ExpressDetailActivity", "ExpressDetailActivity getJDDetailDatas onResume: " + this.f1048z);
    }
}
