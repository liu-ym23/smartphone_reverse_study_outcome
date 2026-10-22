package x52;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.d;
import com.bytedance.bdlocation.BuildConfig;
import gm2.q;
import kotlin.jvm.internal.Intrinsics;
import q72.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static CharSequence b(d r5, float r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "message");
        CharSequence r0 = r5.getChatContent();
        if ((r5 instanceof p0) == false) goto L6;
        r0 = new SpannableStringBuilder(((p0) r5).getRenderSpan());
    L6:
        if ((r5 instanceof b) == false) goto L25;
        b r8 = (b) r5;
        if ((r8.d instanceof p0) == false) goto L25;
        r0 = new SpannableStringBuilder(r8.d.getRenderSpan());
    L25:
    L16:
        e = move-exception;
        ALogger.e("DanmakuSpanStringHelper", e.toString());
    L18:
        if (r7 == false) goto L20;
        r0 = r0.toString();
    L20:
        SpannableString r9 = ab2.a.f(r0, r6);
        if (r9 != null) goto L28;
        return BuildConfig.FLAVOR;
    L28:
        return r9;
    L11:
        if ((r0 instanceof SpannableStringBuilder) == false) goto L18;
        SpannableStringBuilder r10 = (SpannableStringBuilder) r0;     // Catch: Exception -> L16
        int r3 = 0;
        ForegroundColorSpan[] r1 = (ForegroundColorSpan[]) r10.getSpans(0, r0.length(), ForegroundColorSpan.class);     // Catch: Exception -> L16
        int r2 = r1.length;     // Catch: Exception -> L16
    L13:
        if (r3 >= r2) goto L18;
        r10.removeSpan(r1[r3]);     // Catch: Exception -> L16
        r3 = r3 + 1;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r14v7, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r14v8 */
    public static CharSequence a(t r13, boolean r14, boolean r15, float r16) {
        Intrinsics.checkNotNullParameter(r13, "data");
        boolean r0 = r13 instanceof s3;
        String r2 = BuildConfig.FLAVOR;
        if (r0 == false) goto L36;
        s3 r17 = (s3) r13;
        SpannableStringBuilder r18 = new SpannableStringBuilder();
        if (r17.getRenderSpan() == null) goto L25;
        Spannable r1 = r17.getRenderSpan();
    L13:
        e = move-exception;
        ALogger.e("DanmakuSpanStringHelper", e.toString());
    L15:
        String r3 = r2;
        if (r17.getUser2() == null) goto L19;
        r3 = q.a(r17.getUser2(), r15);
    L19:
        if (r3.length() <= 0) goto L21;
        boolean r19 = true;
    L22:
        if (r19 == false) goto L24;
        r18.append(r3.concat("："));
        r18.setSpan(new StyleSpan(1), 0, r18.length(), 33);
    L24:
        r18.append(ab2.a.f(r1, r16));
        return r18;
    L21:
        r19 = false;
        goto L22
    L8:
        if ((r1 instanceof SpannableString) == false) goto L15;
        SpannableString r7 = (SpannableString) r1;     // Catch: Exception -> L13
        ForegroundColorSpan[] r8 = (ForegroundColorSpan[]) r7.getSpans(0, r1.length(), ForegroundColorSpan.class);     // Catch: Exception -> L13
        int r9 = r8.length;     // Catch: Exception -> L13
        int r10 = 0;
    L10:
        if (r10 >= r9) goto L15;
        r7.removeSpan(r8[r10]);     // Catch: Exception -> L13
        r10 = r10 + 1;
        goto L10
    L25:
        String r4 = r2;
        if (r17.getUser2() == null) goto L28;
        r4 = q.a(r17.getUser2(), r15);
    L28:
        String r110 = r17.getContent();
        if (r4.length() <= 0) goto L31;
        boolean r111 = true;
    L32:
        if (r111 == false) goto L34;
        r18.append(r4.concat("："));
        r18.setSpan(new StyleSpan(1), 0, r18.length(), 33);
    L34:
        r18.append(ab2.a.f(r110, r16));
        return r18;
    L31:
        r111 = false;
        goto L32
    L36:
        if ((r13 instanceof h4) == false) goto L59;
        h4 r112 = (h4) r13;
        String r113 = r112.getContent();
        ?? r114 = r113;
        if (r113 != null) goto L42;
        r114 = BuildConfig.FLAVOR;
    L42:
        if (r112.getRenderSpan() == null) goto L52;
        r114 = new SpannableStringBuilder(r112.getRenderSpan());
        ForegroundColorSpan[] r115 = (ForegroundColorSpan[]) r114.getSpans(0, r114.length(), ForegroundColorSpan.class);     // Catch: Exception -> L48
        int r5 = r115.length;     // Catch: Exception -> L48
        int r6 = 0;
    L45:
        if (r6 >= r5) goto L50;
        r114.removeSpan(r115[r6]);     // Catch: Exception -> L48
        r6 = r6 + 1;
    L50:
        if (r14 == false) goto L54;
        r114.append(" ");
        r114.insert(0, "管理：", 0, 3);
        r114.insert(0, " ", 0, 1);
    L54:
        SpannableString r116 = ab2.a.f(r114, r16);
        CharSequence r11 = r2;
        if (r116 == null) goto L58;
        r11 = r116;
    L58:
        return r11;
    L48:
        e = move-exception;
        ALogger.e("DanmakuSpanStringHelper", e.toString());
        goto L50
    L52:
        if (r14 == false) goto L54;
        r114 = " 管理：" + r112.getContent() + ' ';
        goto L54
    L59:
        return " ";
    }
}
