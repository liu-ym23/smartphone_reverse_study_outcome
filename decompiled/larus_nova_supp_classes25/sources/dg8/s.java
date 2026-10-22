package dg8;

import android.R;
import android.content.Context;
import android.content.res.Resources;
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
import com.larus.im.bean.message.Message;
import com.larus.platform.api.f3;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.noties.markwon.core.spans.ListMarginInfo;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s {
    public static final Lazy a = null;
    public static final Regex b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final boolean e = false;

    public s() {
    }

    static {
        a = LazyKt.lazy(new n());
        b = new Regex("(-\\s+){4,}-");
        c = LazyKt.lazy(new o());
        d = LazyKt.lazy(new p());
        e = e2.a.isPad();
    }

    public static lw8.d a(Context r68, boolean r69, boolean r70, Message r71, Integer r72, Integer r73, boolean r74, boolean r75, boolean r76, boolean r77, int r78) {
        if ((r78 & 8) == 0) goto L5;
        final Message r3 = null;
    L7:
        if ((r78 & 16) == 0) goto L9;
        Integer r5 = null;
    L11:
        if ((r78 & 32) == 0) goto L13;
        Integer r6 = null;
    L15:
        if ((r78 & 64) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r78 & 128) == 0) goto L21;
        boolean r12 = true;
    L23:
        if ((r78 & 256) == 0) goto L25;
        boolean r25 = true;
    L27:
        if ((r78 & 512) == 0) goto L29;
        boolean r39 = false;
    L31:
        if ((r78 & 1024) == 0) goto L33;
        boolean r40 = false;
    L34:
        Intrinsics.checkNotNullParameter(r68, "context");
        float r9 = we8.a.a(i5.q(), r70);
        int r51 = we8.e.a(r70);
        if (r7 == false) goto L37;
        int r11 = ContextCompat.getColor(r68, v19.c.b(2130972087, r68, 2131103162));
    L38:
        int r13 = ContextCompat.getColor(r68, v19.c.b(2130972082, r68, 2131103146));
        z2 r43 = z2.a;
        if (r43.M1().getEnableNewQuoteStyle() == false) goto L41;
        lw8.a r56 = new lw8.a(true, Integer.valueOf(c7.b(2)), Integer.valueOf(ContextCompat.getColor(r68, v19.c.b(2130972080, r68, 2131103140))), Integer.valueOf(c7.b(2)), Integer.valueOf(c7.b(15)), Integer.valueOf(r13), Integer.valueOf(r13), Integer.valueOf(r13));
    L42:
        r43.w3();
        int r10 = c7.b(8);
        Intrinsics.checkNotNullParameter(r68, "context");
        int r2 = ContextCompat.getColor(r68, 2131105532);
        int r52 = c7.b(80);
        ThematicBreakConfig r14 = new ThematicBreakConfig(Integer.valueOf(c7.b(Double.valueOf(0.5d))), null, 2, null);
        if (r5 == null) goto L45;
        int r8 = r5.intValue();
    L46:
        int r15 = c7.b(8);
        int r16 = i5.r0();
        TitleStyle r24 = TitleStyle.LARGE;
        boolean r17 = !r7;
        if (r7 == true) goto L49;
        Integer r22 = Integer.valueOf(ContextCompat.getColor(r68, v19.c.b(2130972086, r68, 2131103159)));
    L51:
        if (AppHost.a.isOversea() == true) goto L58;
        AiChatHostWebService.a.getClass();
        if (((IAiChatHostWebService) AiChatHostWebService.b.getValue()) == null) goto L55;
        boolean r18 = true;
    L56:
        if (r18 == false) goto L58;
        boolean r26 = true;
    L59:
        if (r7 == true) goto L61;
        Integer r27 = Integer.valueOf(r11);
    L62:
        if (r7 == true) goto L64;
        Integer r46 = Integer.valueOf(r11);
    L65:
        CodeBlockConfig r58 = new CodeBlockConfig(Integer.valueOf(r16), Integer.valueOf(r11), r17, r22, 14, null, true, "", r26, true, r24, r25, r27, r46, Integer.valueOf(ContextCompat.getColor(r68, v19.c.b(2130972079, r68, 2131103136))), null, false, false, null, false, null, null, null, false, Boolean.valueOf(r7), r39, r40, 16744480, null);
        int r19 = ContextCompat.getColor(r68, v19.c.b(2130972086, r68, 2131103159));
        int r4 = i5.b();
        int r20 = ContextCompat.getColor(r68, v19.c.b(2130972089, null, 2131103169));
        if (r12 == false) goto L68;
        int r110 = 0;
    L69:
        int r111 = i5.r0();
        String r28 = r68.getString(2131900788);
        boolean r29 = ((Boolean) a.getValue()).booleanValue();
        int r210 = ContextCompat.getColor(r68, R.color.transparent);
        if (r6 == null) goto L73;
        int r21 = r6.intValue();
        r8 = r8;
        r15 = r15;
    L94:
        Float r112 = Float.valueOf(r9);
        Integer r113 = Integer.valueOf(r4);
        Boolean r23 = null;
        TableConfig r59 = new TableConfig(r12, r19, r112, r113, Integer.valueOf(r20), null, Integer.valueOf(r111), Integer.valueOf(r110), Integer.valueOf(r21), null, null, null, r28, 14, true, r29, true, true, false, null, Integer.valueOf(r210), null, 2887200, null);
        PhoneNumberConfig r30 = new PhoneNumberConfig(r43.M1().getEnablePhoneHighlight(), r43.M1().getPhoneNumberRegex(), new q(r3));
        int r31 = we8.e.d;
        if (r31 != FontLevel.EXTRA_SMALL.getValue()) goto L98;
        ListMarginInfo r32 = new ListMarginInfo(c7.b(4), c7.b(-2), c7.b(12));
    L112:
        ListMarginInfo r61 = r32;
    L115:
        if (r43.enableSwDpOffline() == true) goto L117;
        Map r65 = null;
    L119:
        if (((Boolean) d.getValue()).booleanValue() == false) goto L121;
        List r62 = CollectionsKt.listOf(new r());
    L122:
        if (r70 == false) goto L125;
        r23 = Boolean.TRUE;
    L125:
        return com.larus.bmhome.chat.markdown.richtext.c.a(new lw8.d(r10, Integer.valueOf(r2), null, r69, null, 0, null, 0.0f, null, r51, r52, Integer.valueOf(r8), Integer.valueOf(r15), null, r56, r14, r58, r59, r30, r61, r62, r23, new mw8.b(r9, ContextCompat.getColor(r68, 2131103681)), r65, -603566116, 26), r68.getResources());
    L121:
        r62 = null;
        goto L122
    L117:
        float r33 = r68.getResources().getDimension(v19.c.b(2130971255, r68, 2131166901));
        float r34 = r68.getResources().getDimension(v19.c.b(2130971241, r68, 2131166875));
        float r35 = r68.getResources().getDimension(v19.c.b(2130971219, r68, 2131166829));
        r65 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1, Float.valueOf(r33)), TuplesKt.to(2, Float.valueOf(r34)), TuplesKt.to(3, Float.valueOf(r35)), TuplesKt.to(4, Float.valueOf(r35)), TuplesKt.to(5, Float.valueOf(r35)), TuplesKt.to(6, Float.valueOf(r35))});
        goto L119
    L98:
        if (r31 != FontLevel.SMALL.getValue()) goto L101;
        r32 = new ListMarginInfo(c7.b(5), c7.b(Double.valueOf(-2.5d)), c7.b(14));
        goto L112
    L101:
        if (r31 != FontLevel.STANDARD.getValue()) goto L104;
        r32 = new ListMarginInfo(c7.b(5), c7.b(Double.valueOf(-3.5d)), c7.b(16));
        goto L112
    L104:
        if (r31 != FontLevel.LARGE.getValue()) goto L107;
        r32 = new ListMarginInfo(c7.b(6), c7.b(-5), c7.b(20));
        goto L112
    L107:
        if (r31 != FontLevel.EXTRA_LARGE.getValue()) goto L110;
        r32 = new ListMarginInfo(c7.b(6), c7.b(-6), c7.b(22));
        goto L112
    L110:
        if (r31 != FontLevel.SUPER_EXTRA_LARGE.getValue()) goto L113;
        r32 = new ListMarginInfo(c7.b(7), c7.b(-7), c7.b(24));
        goto L112
    L113:
        r61 = null;
        goto L115
    L73:
        if (e == false) goto L75;
        e2 r36 = e2.a;
        int r37 = f3.a.a();
    L76:
        Resources r114 = r68.getResources();
        if (((Boolean) c.getValue()).booleanValue() == false) goto L81;
        if (r70 == true) goto L81;
    L87:
        int r115 = (r114.getDimensionPixelSize(2131167561) + r114.getDimensionPixelSize(2131167568)) * 2;
        r8 = r8;
        r15 = r15;
    L93:
        r21 = Math.max(r37 - r115, 0);
    L81:
        if (r3 == null) goto L83;
        String r116 = r3.getBizContentType();
    L85:
        if (Intrinsics.areEqual(r116, "deep_search_card") == true) goto L87;
        int r117 = r114.getDimensionPixelSize(2131167568) + r114.getDimensionPixelSize(2131167563);
        int r118 = r114.getDimensionPixelSize(2131167561) * 2;
        if (r70 == false) goto L91;
        int r38 = r114.getDimensionPixelSize(2131167565) - r114.getDimensionPixelSize(2131167563);
    L92:
        r37 = (r37 - r117) - r118;
        r115 = r38;
        goto L93
    L91:
        r38 = 0;
        goto L92
    L83:
        r116 = null;
        goto L85
    L75:
        Resources r41 = r68.getResources();
        r37 = WindowDisplayMetricsOverride.apply(r41, r41.getDisplayMetrics()).widthPixels;
        goto L76
    L68:
        r110 = i5.r0();
        goto L69
    L64:
        r46 = null;
        goto L65
    L61:
        r27 = null;
        goto L62
    L55:
        r18 = false;
    L58:
        r26 = false;
        goto L59
    L49:
        r22 = null;
        goto L51
    L45:
        r8 = c7.b(16);
        goto L46
    L41:
        r56 = null;
        goto L42
    L37:
        r11 = ContextCompat.getColor(r68, v19.c.b(2130970529, r68, 2131102529));
        goto L38
    L33:
        r40 = r77;
        goto L34
    L29:
        r39 = r76;
        goto L31
    L25:
        r25 = false;
        goto L27
    L21:
        r12 = r75;
        goto L23
    L17:
        r7 = r74;
        goto L19
    L13:
        r6 = r73;
        goto L15
    L9:
        r5 = r72;
        goto L11
    L5:
        r3 = r71;
        goto L7
    }
}
