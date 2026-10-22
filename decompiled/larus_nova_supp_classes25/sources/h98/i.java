package h98;

import android.R;
import android.app.Application;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.font.FontLevel;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.bmhome.web.IAiChatHostWebService;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.PhoneNumberConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.larus.business.markdown.api.model.TitleStyle;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.m0;
import io.noties.markwon.core.spans.ListMarginInfo;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public static final Lazy a = null;
    public static final Regex b = null;

    public static final class a extends lsc.a {
        public a() {
        }

        public final String b(String r3) {
            Intrinsics.checkNotNullParameter(r3, "markdown");
            return i.b.replace(r3, " - ");
        }
    }

    static {
        a = LazyKt.lazy(new g());
        b = new Regex("(-\\s+){4,}-");
    }

    public static final lw8.d a(Function1<? super uvc.b, Integer> r72) {
        AppHost.Companion r0 = AppHost.a;
        Application r1 = r0.getApplication();
        int r2 = m0.b(r1) - i5.Z();
        int r5 = c7.b(8);
        int r6 = ve8.d.a(2131105532, r1);
        int r15 = c7.b(80);
        ThematicBreakConfig r14 = new ThematicBreakConfig(Integer.valueOf(c7.b(Double.valueOf(0.5d))), null, 2, null);
        int r16 = c7.b(1);
        int r3 = c7.b(8);
        int r10 = b(r1, 2130970529, 2131102529);
        int r11 = i5.r0();
        TitleStyle r28 = TitleStyle.LARGE;
        int r21 = b(r1, 2130972086, 2131103159);
        if (r0.isOversea() == true) goto L10;
        AiChatHostWebService.a.getClass();
        if (((IAiChatHostWebService) AiChatHostWebService.b.getValue()) == null) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        boolean r26 = true;
    L11:
        CodeBlockConfig r7 = new CodeBlockConfig(Integer.valueOf(r11), Integer.valueOf(r10), false, Integer.valueOf(r21), 14, null, true, "", r26, true, r28, true, Integer.valueOf(r10), Integer.valueOf(r10), null, null, false, false, null, false, null, null, null, false, Boolean.FALSE, false, false, 16760864, null);
        int r49 = b(r1, 2130972086, 2131103159);
        float r12 = we8.a.a(i5.q(), false);
        int r13 = i5.b();
        int r17 = b(r1, 2130972089, 2131103169);
        int r18 = i5.r0();
        TableConfig r22 = new TableConfig(true, r49, Float.valueOf(r12), Integer.valueOf(r13), Integer.valueOf(r17), null, Integer.valueOf(r18), 0, Integer.valueOf(r2), null, null, null, r1.getString(2131900788), 14, true, true, false, true, false, null, Integer.valueOf(ContextCompat.getColor(r1, R.color.transparent)), null, 2952736, null);
        z2 r9 = z2.a;
        if (r9.M1().getEnableNewQuoteStyle() == true) goto L14;
        lw8.a r8 = null;
    L15:
        PhoneNumberConfig r19 = new PhoneNumberConfig(r9.M1().getEnablePhoneHighlight(), r9.M1().getPhoneNumberRegex(), new h());
        Lazy r20 = we8.e.a;
        int r23 = we8.e.d;
        if (r23 != FontLevel.SMALL.getValue()) goto L20;
        ListMarginInfo r24 = new ListMarginInfo(c7.b(5), c7.b(Double.valueOf(-2.5d)), c7.b(14));
    L18:
        ListMarginInfo r25 = r24;
    L30:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L32;
        List r27 = CollectionsKt.listOf(new a());
    L33:
        mw8.b r29 = new mw8.b(we8.a.a(i5.q(), false), ContextCompat.getColor(r1, 2131103681));
        LinkedHashMap r30 = new LinkedHashMap();
        r30.put(1, Float.valueOf(i5.m()));
        r30.put(2, Float.valueOf(i5.m()));
        r30.put(3, Float.valueOf(i5.m()));
        r30.put(4, Float.valueOf(i5.m()));
        return new lw8.d(r5, Integer.valueOf(r6), null, false, null, 0, null, 0.0f, Float.valueOf(1.0f), 0, r15, Integer.valueOf(r16), Integer.valueOf(r3), r72, r8, r14, r7, r22, r19, r25, r27, null, r29, r30, -66959396, 26);
    L32:
        r27 = null;
        goto L33
    L20:
        if (r23 != FontLevel.STANDARD.getValue()) goto L23;
        r24 = new ListMarginInfo(c7.b(5), c7.b(Double.valueOf(-3.5d)), c7.b(16));
        goto L18
    L23:
        if (r23 != FontLevel.LARGE.getValue()) goto L26;
        r24 = new ListMarginInfo(c7.b(6), c7.b(-5), c7.b(20));
        goto L18
    L26:
        if (r23 != FontLevel.EXTRA_LARGE.getValue()) goto L28;
        r24 = new ListMarginInfo(c7.b(6), c7.b(-6), c7.b(22));
        goto L18
    L28:
        r25 = null;
        goto L30
    L14:
        int r110 = b(r1, 2130972082, 2131103146);
        int r111 = c7.b(2);
        int r112 = c7.b(2);
        int r113 = c7.b(15);
        r8 = new lw8.a(true, Integer.valueOf(r111), Integer.valueOf(b(r1, 2130972080, 2131103140)), Integer.valueOf(r112), Integer.valueOf(r113), Integer.valueOf(r110), Integer.valueOf(r110), Integer.valueOf(r110));
        goto L15
    L7:
        r4 = false;
    L10:
        r26 = false;
        goto L11
    }

    public static final int b(Context r0, int r1, int r2) {
        return ContextCompat.getColor(r0, v19.c.b(r1, r0, r2));
    }
}
