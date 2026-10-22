package klb;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends klb.a {
    public final Context b;
    public final String c;
    public final boolean d;

    public static final class a {
    }

    public interface b {
        void b(View r1, String r2);
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        if ((r3 instanceof b) == true) goto L5;
        return;
    L5:
        if (a(r3) == true) goto L10;
        Log.i("OCRUrlSpan", "onClick " + this.c);
        ((b) r3).b(r3, this.c);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        r3.setColor(UIUtils.getColor(this.b, 2131106616));
        r3.setUnderlineText(this.d);
    }

    public e(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        this.b = r2;
        this.c = r3;
        this.d = false;
    }
}
