package u6b;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.core.graphics.ColorUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends CharacterStyle {
    public static final /* synthetic */ int b = 0;
    public final int a;

    /* JADX INFO: renamed from: u6b.a$a, reason: collision with other inner class name */
    public static final class C0307a {
        @JvmStatic
        public static Spannable a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            SpannableString r0 = new SpannableString(r4);
            r0.setSpan(new a(), 0, r4.length(), 17);
            return r0;
        }
    }

    static {
    }

    public a() {
        this.a = ColorUtils.setAlphaComponent(UIHelper.getColor(2131106622), 128);
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        if (r2 == null) goto L5;
        r2.setColor(this.a);
        return;
    }
}
