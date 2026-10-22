package q69;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.larus.dora.impl.view.DoraMovieView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e extends ViewOutlineProvider {
    public final /* synthetic */ DoraMovieView a;

    public e(DoraMovieView r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r17, Outline r18) {
        DoraMovieView r1 = this.a;
        int r2 = r1.n;
        if (r2 > 0) goto L5;
    L7:
        if (r2 <= 0) goto L9;
        int r13 = r17.getWidth();
        int r3 = r17.getHeight();
        int r4 = this.a.n;
        r18.setRoundRect(0, 0, r13, r3 + r4, r4);
        return;
    L9:
        int r5 = r1.o;
        if (r5 <= 0) goto L12;
        r18.setRoundRect(0, -r5, r17.getWidth(), r17.getHeight(), this.a.o);
        return;
    L12:
        r18.setRect(0, 0, r17.getWidth(), r17.getHeight());
        return;
    L5:
        if (r1.o <= 0) goto L7;
        r18.setRoundRect(0, 0, r17.getWidth(), r17.getHeight(), this.a.n);
    }
}
