package t19;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.common_ui.toast.ToastLayout;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends ClickableSpan {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ ToastLayout b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        FLogger.a.i("ToastLogger", "action toast span clicked");
        this.a.invoke();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        Intrinsics.checkNotNullParameter(r5, "ds");
        r5.setColor(ContextCompat.getColor(this.b.getContext(), v19.c.b(2130972123, this.b.getContext(), 2131103203)));
        r5.setUnderlineText(false);
    }

    public a(u19.b r1, ToastLayout r2) {
        this.a = r1;
        this.b = r2;
    }
}
