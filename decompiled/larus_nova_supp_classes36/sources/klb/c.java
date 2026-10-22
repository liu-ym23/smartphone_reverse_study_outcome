package klb;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends klb.a {
    public final Context b;
    public final String c;

    public interface a {
        void a(View r1, String r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        if ((r3 instanceof a) == true) goto L5;
        return;
    L5:
        if (a(r3) == true) goto L10;
        ((a) r3).a(r3, this.c);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        r3.setColor(UIUtils.getColor(this.b, 2131106616));
        r3.setUnderlineText(false);
    }

    public c(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "phone");
        this.b = r2;
        this.c = r3;
    }
}
