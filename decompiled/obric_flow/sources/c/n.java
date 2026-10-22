package c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.zte.miboard.cards.R;

/* JADX INFO: loaded from: classes.dex */
public class n extends AppCompatActivity {
    public static final /* synthetic */ int s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OFloatingTitleBar f1067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RecyclerView f1068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f1069c;
    private com.obric.oui.orecyclerview.widget.a0 d;
    private View e;
    private h0 f;

    public n() {
    }

    public static /* synthetic */ View a(n r5) {
        return r5.e;
    }

    public static void h(n r5, int r10, RecyclerView r11, View r12, WindowInsetsCompat r13) {
        r5.getClass();
        r5.f.f1055a = r13.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        r12.setPadding(r12.getPaddingLeft(), r10, r12.getPaddingRight(), 0);
        if (r11.f13747o.size() == 0) goto L10;
        com.obric.oui.orecyclerview.widget.k0 r14 = r11.f13743m;
        if (r14 == null) goto L8;
        r14.b("Cannot invalidate item decorations during a scroll or layout");
    L8:
        r11.I();
        r11.requestLayout();
        return;
    }

    public int b() {
        return 0;
    }

    @NonNull
    public OFloatingTitleBar c() {
        return this.f1067a;
    }

    public String d() {
        return getTitle() + "";
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public <T extends View> T findViewById(int r5) {
        T r10 = (T) super.findViewById(r5);
        if (f() == false) goto L9;
        if (r10 != null) goto L10;
        View r11 = this.e;
        if (r11 != null) goto L8;
        return r10;
    L8:
        return (T) r11.findViewById(r5);
    L10:
        return r10;
    L9:
        return r10;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        int r5 = 0;
        super.onCreate(r10);
        m.i(getClass().getSimpleName(), "onCreate ".concat(getClass().getSimpleName()));
        getWindow().setDecorFitsSystemWindows(false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setNavigationBarContrastEnforced(false);
        getWindow().setNavigationBarDividerColor(0);
        super.setContentView(R.layout.base_miboard_aty);
        boolean r11 = s0.f1083a;
        if (32 != (getResources().getConfiguration().uiMode & 48)) goto L5;
        boolean r12 = true;
    L6:
        WindowInsetsControllerCompat r13 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        boolean r14 = !r12;
        r13.setAppearanceLightStatusBars(r14);
        r13.setAppearanceLightNavigationBars(r14);
        OFloatingTitleBar r15 = (OFloatingTitleBar) findViewById(R.id.miboard_aty_title_bar);
        this.f1067a = r15;
        r15.d(R.drawable.oui_icon_oic_arrow_left, 0, new ar.a(this, 3));
        this.f1067a.setCenterTitle(d());
        LinearLayout r16 = (LinearLayout) findViewById(R.id.miboard_aty_container_linear_layout);
        RecyclerView r17 = (RecyclerView) findViewById(R.id.miboard_aty_container_recycler_view);
        r17.setNestedScrollingEnabled(false);
        r17.setLayoutManager(new com.obric.oui.orecyclerview.widget.s());
        h0 r18 = new h0();
        r18.f1055a = 0;
        this.f = r18;
        r17.h(r18);
        int r19 = (com.lynx.tasm.utils.j.q(this) + getResources().getDimensionPixelSize(R.dimen.title_bar_size)) + b();
        ViewCompat.setOnApplyWindowInsetsListener(r17, new d0(this, r19, r17, r5));
        ViewCompat.setOnApplyWindowInsetsListener(r16, new e0(r19, 0));
        this.f1068b = r17;
        this.f1069c = r16;
        if (f() == false) goto L9;
        int r20 = 0;
    L10:
        r17.setVisibility(r20);
        LinearLayout r21 = this.f1069c;
        if (f() == false) goto L14;
        r5 = 8;
    L14:
        r21.setVisibility(r5);
        a(new f0(this));
        return;
    L9:
        r20 = 8;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r5) {
        this.e = LayoutInflater.from(this).inflate(r5, this.f1069c, false);
        if (f() == true) goto L6;
        this.f1069c.addView(this.e);
        return;
    }

    @NonNull
    public OCardListItem a(@NonNull String r5, @Nullable View.OnClickListener r10, @NonNull LayoutInflater r11, @NonNull ViewGroup r12) {
        OCardListItem r13 = (OCardListItem) r11.inflate(R.layout.base_card_list_item, r12, false);
        r13.setShowCardBg(true);
        r13.setCardType(0);
        r13.setTitle(r5);
        r13.setDefaultTailIcon(0);
        r13.l(true);
        r13.setOnContentClickListener(r10);
        return r13;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r5) {
        m.j(getClass().getSimpleName(), "setContentView(view) error:", new Exception());
    }

    public RecyclerView a() {
        return this.f1068b;
    }

    public void a(@NonNull com.obric.oui.orecyclerview.widget.a0 r5) {
        this.d = r5;
        this.f1068b.setAdapter(r5);
    }
}
