package com.obric.flow.cardlistpage.ui.settings;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import c.d0;
import c.f0;
import com.lynx.tasm.utils.j;
import com.obric.flow.cardlistpage.R$dimen;
import com.obric.flow.cardlistpage.R$drawable;
import com.obric.flow.cardlistpage.R$id;
import com.obric.flow.cardlistpage.R$layout;
import com.obric.flow.cardlistpage.R$string;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.s;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/obric/flow/cardlistpage/ui/settings/CardFeedSettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "com/obric/flow/cardlistpage/ui/settings/a", "com/obric/flow/cardlistpage/ui/settings/b", "com/obric/flow/cardlistpage/ui/settings/c", "com/obric/flow/cardlistpage/ui/settings/f", "c/f0", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CardFeedSettingsActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f11819t = 0;
    public final b s;

    public CardFeedSettingsActivity() {
        this.s = new b();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setNavigationBarContrastEnforced(false);
        getWindow().setNavigationBarDividerColor(0);
        setContentView(R$layout.activity_card_feed_settings);
        boolean r11 = ym.a.h(this);
        WindowInsetsControllerCompat r5 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        boolean r12 = !r11;
        r5.setAppearanceLightStatusBars(r12);
        r5.setAppearanceLightNavigationBars(r12);
        OFloatingTitleBar r13 = (OFloatingTitleBar) findViewById(R$id.title_bar);
        Intrinsics.checkNotNull(r13);
        int r14 = R$drawable.icon_back_settings;
        ar.a r15 = new ar.a(this, 12);
        int r16 = OFloatingTitleBar.C;
        r13.d(r14, -1, r15);
        RecyclerView r17 = (RecyclerView) findViewById(R$id.recycler_view);
        r17.setNestedScrollingEnabled(false);
        r17.setLayoutManager(new s());
        r17.h(this.s);
        int r18 = getResources().getDimensionPixelSize(R$dimen.title_bar_size) + j.q(this);
        r17.setPadding(0, r18, 0, 0);
        ViewCompat.setOnApplyWindowInsetsListener(r17, new d0(this, r18, r17, 1));
        r17.setAdapter(new f0(CollectionsKt.listOf(new f[]{new e(R$drawable.ic_travel_service, R$string.travel_service_title, R$string.travel_service_subtitle, new AnonymousClass3(this)), new d(R$string.privacy_policy_link, new AnonymousClass4(this))})));
    }
}
