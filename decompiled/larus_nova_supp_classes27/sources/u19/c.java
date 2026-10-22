package u19;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.common_ui.toast.ToastLayout;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends e {
    public final boolean d;
    public CharSequence e;
    public Function0<Unit> f;

    @Override // u19.a
    public final void clear() {
        super.clear();
        this.e = "";
        this.f = null;
    }

    @Override // u19.e
    public final boolean b() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.larus.common_ui.toast.ToastLayout] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, u19.b] */
    @Override // u19.a
    public final ToastLayout buildLayout(Context r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        ?? r0 = new ToastLayout(v19.f.g(r11, r12));
        setToastLayout(r0);
        int r13 = getIconDrawableRes();
        CharSequence r1 = getText();
        CharSequence r2 = this.e;
        ?? r3 = new b(this);
        Intrinsics.checkNotNullParameter(r1, "text");
        Intrinsics.checkNotNullParameter(r2, "actionText");
        Intrinsics.checkNotNullParameter(r3, "onActionClick");
        ViewGroup.inflate(r0.getContext(), 2131562898, r0);
        r0.R5(r12);
        r0.findViewById(2131379210).setImageResource(r13);
        TextView r14 = (TextView) r0.findViewById(2131388386);
        SpannableStringBuilder r15 = new SpannableStringBuilder(r1);
        int r4 = StringsKt.indexOf$default(r15, r2.toString(), 0, false, 6, null);
        if (r4 >= 0) goto L13;
        FLogger.a.w("ToastLogger", "action text missing from toast content, append as fallback");
        if (r15.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L10;
    L12:
        r4 = r15.length();
        r15.append(r2);
        goto L13
    L10:
        if (CharsKt.isWhitespace(StringsKt.last(r15)) == true) goto L12;
        r15.append(' ');
        goto L12
    L7:
        r5 = false;
    L13:
        r15.setSpan(new t19.a(r3, r0), r4, r2.length() + r4, 33);
        r14.setHighlightColor(0);
        r14.setMovementMethod(LinkMovementMethod.getInstance());
        r14.setText(r15);
        r0.setYOffsetPx(getToastYOffsetPx());
        return r0;
    }

    public c(int r2, CharSequence r3, CharSequence r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "actionText");
        Intrinsics.checkNotNullParameter(r5, "onActionClick");
        this.d = true;
        this.e = r4;
        this.f = r5;
        icon(r2);
        text(r3);
    }
}
