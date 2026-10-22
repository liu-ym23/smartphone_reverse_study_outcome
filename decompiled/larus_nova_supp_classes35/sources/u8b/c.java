package u8b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.conditional.access.utils.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends ClickableSpan {
    public final Context a;
    public final a b;
    public long c;

    public interface a extends View.OnClickListener {
        void Vg(TextPaint r1);
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r8) {
        Intrinsics.checkNotNullParameter(r8, "widget");
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - this.c) <= 500) goto L6;
        this.c = r0;
        this.b.onClick(r8);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        this.b.Vg(r3);
        r3.setUnderlineText(false);
        r3.setColor(this.a.getResources().getColor(2131105548));
    }

    public c(Context r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mCallback");
        this.a = r2;
        this.b = r3;
    }
}
