package n9;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* JADX INFO: loaded from: classes.dex */
public final class b extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Chip f9472a;

    public b(Chip r8) {
        this.f9472a = r8;
    }

    @Override // android.view.ViewOutlineProvider
    @TargetApi(21)
    public final void getOutline(View r8, Outline r10) {
        com.google.android.material.chip.a r11 = this.f9472a.f4560o;
        if (r11 == null) goto L5;
        r11.getOutline(r10);
        return;
    L5:
        r10.setAlpha(0.0f);
    }
}
