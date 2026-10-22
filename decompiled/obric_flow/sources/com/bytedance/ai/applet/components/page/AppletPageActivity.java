package com.bytedance.ai.applet.components.page;

import android.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.model.p;
import com.bytedance.ai.utils.c;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.obric.launcher.widget.R$color;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import t0.b;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/applet/components/page/AppletPageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppletPageActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f1709t = 0;
    public RenderUrlData s;

    public AppletPageActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        ActionBar r11 = getSupportActionBar();     // Catch: Exception -> L7
        if (r11 == null) goto L11;
        r11.hide();     // Catch: Exception -> L7
    L11:
        b r12 = p.f2294c;
        if (r12 != null) goto L14;
    L16:
        boolean r13 = false;
    L17:
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        WindowInsetsControllerCompat r5 = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        if (r5 == null) goto L20;
        r5.setAppearanceLightStatusBars(!r13);
    L20:
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setNavigationBarColor(0);
        WindowInsetsControllerCompat r14 = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        if (r14 == null) goto L23;
        r14.setAppearanceLightNavigationBars(true);
    L23:
        String r15 = getIntent().getStringExtra("ARG_URL");
        if (r15 != null) goto L26;
    L75:
        Intrinsics.checkNotNullParameter("AppletPageActivity", "tag");
        d r16 = c.f2846a;
        if (r16 == null) goto L78;
        r16.e("AppletPageActivity", "onCreate: url arguments null");
    L78:
        finish();
        return;
    L26:
        if (r15.length() == 0) goto L75;
        String r17 = "onCreate: url = ".concat(r15);
        Intrinsics.checkNotNullParameter("AppletPageActivity", "tag");
        d r18 = c.f2846a;
        if (r18 == null) goto L31;
        r18.d("AppletPageActivity", r17);
    L31:
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Uri r19 = Uri.parse(r15);
        String r20 = r19.getHost();
        if (r20 == null) goto L53;
        int r21 = r20.hashCode();
        if (r21 == (-1772600516)) goto L50;
        if (r21 == (-3574475)) goto L46;
        if (r21 != 1224424441) goto L53;
        if (r20.equals("webview") == false) goto L53;
        RenderType r22 = RenderType.f1752c;
    L44:
        RenderType r23 = r22;
        String r24 = r19.getQueryParameter("url");
        if (r24 != null) goto L57;
        r24 = "";
    L57:
        String r25 = r24;
        if (r25.length() == 0) goto L74;
        boolean r26 = Intrinsics.areEqual(r19.getQueryParameter("trans_status_bar"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        boolean r27 = Intrinsics.areEqual(r19.getQueryParameter("hide_nav_bar"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        Uri r28 = Uri.parse(r25);
        LinkedHashMap r29 = new LinkedHashMap();
        Iterator<String> r30 = r19.getQueryParameterNames().iterator();
    L61:
        if (r30.hasNext() == false) goto L65;
        String r31 = r30.next();
        String r32 = r19.getQueryParameter(r31);
        if (r32 == null) goto L61;
        r29.put(r31, r32);
        goto L61
    L65:
        Iterator<String> r110 = r28.getQueryParameterNames().iterator();
    L67:
        if (r110.hasNext() == false) goto L71;
        String r33 = r110.next();
        String r34 = r28.getQueryParameter(r33);
        if (r34 == null) goto L67;
        r29.put(r33, r34);
        goto L67
    L71:
        RenderUrlData r111 = new RenderUrlData(r23, r26, r27, r25, r29);
        this.s = r111;
        FrameLayout r35 = new FrameLayout(this);
        r35.setId(View.generateViewId());
        r35.setBackgroundResource(R$color.base_1);
        r35.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setContentView(r35);
        FragmentTransaction r36 = getSupportFragmentManager().beginTransaction();
        int r37 = r35.getId();
        Intrinsics.checkNotNullParameter(r111, "data");
        RenderFragment r38 = new RenderFragment();
        Bundle r39 = new Bundle();
        r39.putParcelable(Reflection.getOrCreateKotlinClass(RenderUrlData.class).getSimpleName(), r111);
        r38.setArguments(r39);
        r36.add(r37, r38).commit();
        return;
    L74:
        throw new IllegalArgumentException("url is empty");
    L46:
        if (r20.equals("relaxview") == false) goto L53;
        r22 = RenderType.e;
        goto L44
    L50:
        if (r20.equals("lynxview") == false) goto L53;
        r22 = RenderType.d;
    L53:
        r22 = RenderType.f1752c;
        goto L44
    L14:
        if (r12.isDarkMode() != true) goto L16;
        r13 = true;
    L7:
        e = move-exception;
        Intrinsics.checkNotNullParameter("AppletPageActivity", "tag");
        d r40 = c.f2846a;
        if (r40 == null) goto L11;
        r40.e("AppletPageActivity", "onCreate: hide action bar error", e);
        goto L11
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        View r5 = findViewById(R.id.content);
        if (r5 == null) goto L6;
        r5.post(new a2.b(8, r5, this));
        return;
    }
}
