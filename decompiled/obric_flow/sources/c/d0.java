package c;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.obric.flow.cardlistpage.ui.settings.CardFeedSettingsActivity;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d0 implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1039c;
    public final /* synthetic */ AppCompatActivity d;

    public /* synthetic */ d0(AppCompatActivity r5, int r10, RecyclerView r11, int r12) {
        this.f1037a = r12;
        this.d = r5;
        this.f1038b = r10;
        this.f1039c = r11;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r10) {
        RecyclerView r11 = this.f1039c;
        int r12 = this.f1038b;
        AppCompatActivity r13 = this.d;
        switch(this.f1037a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        int r14 = CardFeedSettingsActivity.f11819t;
        CardFeedSettingsActivity r15 = (CardFeedSettingsActivity) r13;
        Intrinsics.checkNotNullParameter(r15, "this$0");
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r10, "insets");
        r15.s.f11821a = r10.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        r5.setPadding(r5.getPaddingLeft(), r12, r5.getPaddingRight(), 0);
        if (r11.f13747o.size() == 0) goto L11;
        com.obric.oui.orecyclerview.widget.k0 r16 = r11.f13743m;
        if (r16 == null) goto L10;
        r16.b("Cannot invalidate item decorations during a scroll or layout");
    L10:
        r11.I();
        r11.requestLayout();
    L11:
        return r10;
    L12:
        n.h((n) r13, r12, r11, r5, r10);
        return r10;
    }
}
