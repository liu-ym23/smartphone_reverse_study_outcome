package uzb;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h extends ClickableSpan {
    public final Context a;
    public final a b;
    public long c;

    public interface a extends View.OnClickListener {
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r8) {
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - this.c) <= 500) goto L8;
        this.c = r0;
        a r1 = this.b;
        if (r1 == null) goto L9;
        ((i) r1).onClick(r8);
        return;
    L9:
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        super.updateDrawState(r3);
        this.b.getClass();
        r3.setUnderlineText(false);
        r3.setColor(this.a.getResources().getColor(2131105548));
    }

    public h(FragmentActivity r3, i r4) {
        this.c = 0;
        this.a = r3;
        this.b = r4;
    }
}
