package ya2;

import android.text.InputFilter;
import android.text.Spanned;
import com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements InputFilter {
    public final Pattern a;
    public final c b;

    public a(RoomNoticeBaseDialog.b r2) {
        this.b = r2;
        this.a = PatternProtector.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66);
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
        Object r7 = null;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L12
        if (this.a.matcher(r1).find() == false) goto L9;
        c r9 = this.b;     // Catch: Throwable -> L12
        if (r9 == null) goto L8;
        r9.a();     // Catch: Throwable -> L12
    L8:
        String r10 = BuildConfig.FLAVOR;
    L10:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r11) != null) goto L18;
        r7 = r11;
    L18:
        return (CharSequence) r7;
    L9:
        r10 = null;
    L12:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
