package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f1296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Typeface f1297b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f1298m;

    public x(TextView r8, Typeface r10, int r11) {
        this.f1296a = r8;
        this.f1297b = r10;
        this.f1298m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Typeface r8 = this.f1297b;
        int r10 = this.f1298m;
        this.f1296a.setTypeface(r8, r10);
    }
}
