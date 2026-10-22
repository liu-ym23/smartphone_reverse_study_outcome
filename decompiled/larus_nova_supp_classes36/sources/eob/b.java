package eob;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends ClickableSpan {
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.a = r2;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        KeyboardBaseModule.a().openUrl(r4.getContext(), this.a, IOfflineExtraParser.ParserType.TODO);
    }
}
