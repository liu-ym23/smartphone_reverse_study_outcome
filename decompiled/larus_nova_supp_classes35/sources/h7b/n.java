package h7b;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class n extends ClickableSpan {
    public int a;
    public final Context b;

    public n(Context r2) {
        this.a = 2131106616;
        this.b = r2;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        r3.setColor(UIUtils.getColor(this.b, this.a));
    }

    public n(Context r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
