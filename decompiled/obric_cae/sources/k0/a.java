package k0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f8887b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f8888m;

    public a(int r8, f r10, int r11) {
        this.f8886a = r8;
        this.f8887b = r10;
        this.f8888m = r11;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r8) {
        Bundle r10 = new Bundle();
        r10.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f8886a);
        this.f8887b.f8890a.performAction(this.f8888m, r10);
    }
}
