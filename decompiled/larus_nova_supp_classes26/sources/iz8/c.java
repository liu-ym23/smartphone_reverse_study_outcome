package iz8;

import android.app.Application;
import com.google.gson.Gson;
import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.block.AppletBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.ResearchBlock;
import com.larus.utils.o0;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import vd9.r;
import yc9.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    static {
    }

    public static String c(Message r12) {
        Intrinsics.checkNotNullParameter(r12, "message");
        AppHost.Companion r0 = AppHost.a;
        Application r1 = r0.getApplication();
        String r2 = d.H(r12);
        String r4 = null;
        boolean r6 = true;
        if (r0.isOversea() == false) goto L5;
    L26:
        String r3 = r12.getBrief();
        if (r3 != null) goto L29;
    L31:
        boolean r5 = false;
    L32:
        if (r5 == false) goto L61;
        if (com.larus.im.bean.message.a.b0(r12) == false) goto L57;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Iterator r7 = r.a(r12).iterator();
    L37:
        if (r7.hasNext() == false) goto L44;
        Object r8 = r7.next();
        if (((Block) r8).getBlockType() != BlockType.BLOCK_TYPE_BLOCK_RESEARCH.getValue()) goto L41;
        boolean r9 = true;
    L42:
        if (r9 == false) goto L37;
    L45:
        Block r10 = (Block) r8;
        if (r10 == null) goto L53;
        StringBuilder r11 = new StringBuilder();
        r11.append(r12.getBrief());
        r11.append(' ');
        BlockContent r13 = r10.getContent();
        if (r13 == null) goto L52;
        ResearchBlock r14 = r13.getResearchBlock();
        if (r14 == null) goto L52;
        r4 = r14.getBrief();
    L52:
        r11.append(r4);
        String r15 = r11.toString();
    L152:
        return r15;
    L53:
        r15 = r12.getBrief();
        if (r15 != null) goto L152;
    L167:
        return "";
    L41:
        r9 = false;
        goto L42
    L44:
        r8 = null;
        goto L45
    L57:
        String r16 = r12.getBrief();
        if (r16 == null) goto L167;
        return r16;
    L61:
        if (r12.getContentType() == 6) goto L143;
        if (dp8.a.a(r12) == true) goto L143;
        if (CollectionsKt.listOf(new Integer[]{3, 70, 72}).contains(Integer.valueOf(r12.getContentType())) == false) goto L69;
        return r1.getString(2131900786);
    L69:
        if (r12.getContentType() != 5) goto L72;
        return r1.getString(2131900789);
    L72:
        if (r12.getContentType() != 50) goto L75;
        return r1.getString(2131900785);
    L75:
        if (lr8.c.a(r12) == false) goto L81;
        NestedFileContent r17 = d.f(r12);
        if (v0.h(r17) <= v0.c(r17)) goto L79;
        String r18 = r1.getString(2131905683);
        Intrinsics.checkNotNull(r18);
        return r18;
    L79:
        String r19 = r1.getString(2131900783);
        Intrinsics.checkNotNull(r19);
        return r19;
    L81:
        if (r12.getContentType() != 800) goto L86;
        if (Intrinsics.areEqual(r12.getBizContentType(), "dora_record") == false) goto L86;
        String r20 = r1.getString(2131907355);
        Intrinsics.checkNotNull(r20);
        return r20;
    L86:
        if (r12.getContentType() != 7) goto L89;
        return r1.getString(2131905683);
    L89:
        if (r12.getContentType() != 8) goto L92;
        return r1.getString(2131900779);
    L92:
        if (r12.getContentType() == 9) goto L162;
        String r21 = r12.getContent();
        if (r21 != null) goto L97;
    L99:
        boolean r22 = false;
    L100:
        if (r22 == true) goto L163;
        String r23 = r12.getContent();
        if (r23 != null) goto L105;
    L107:
        boolean r24 = false;
    L108:
        if (r24 == false) goto L111;
        return r1.getString(2131900780);
    L111:
        if (r12.getContentType() != 1) goto L116;
        String r25 = d.H(r12);
        if (r25 == null) goto L167;
        return r25;
    L116:
        if (dp8.a.b(r12) == false) goto L131;
        String r110 = r12.getContent();
        Type r26 = new b().getType();
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L120
        Object r111 = Result.constructor-impl((TextContent) new Gson().fromJson(r110, r26));     // Catch: Throwable -> L120
    L123:
        if (Result.isFailure-impl(r111) == false) goto L125;
        r111 = null;
    L125:
        TextContent r112 = (TextContent) r111;
        if (r112 == null) goto L128;
        String r28 = r112.text;
    L129:
        if (r28 == null) goto L167;
        return r28;
    L128:
        r28 = null;
    L120:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L123
    L131:
        if (r2 != null) goto L133;
    L138:
        r6 = false;
    L139:
        if (r6 == false) goto L167;
        return r2;
    L133:
        if (r2.length() <= 0) goto L135;
        boolean r113 = true;
    L136:
        if (r113 != true) goto L138;
    L135:
        r113 = false;
        goto L136
    L105:
        if (StringsKt.contains$default(r23, "```", false, 2, null) != true) goto L107;
        r24 = true;
        goto L108
    L163:
        return r1.getString(2131900783);
    L97:
        if (StringsKt.contains$default(r21, "<img", false, 2, null) != true) goto L99;
        r22 = true;
        goto L100
    L162:
        return r1.getString(2131900789);
    L143:
        return r1.getString(2131900783);
    L29:
        if (o0.d(r3) != true) goto L31;
        r5 = true;
        goto L32
    L5:
        if (r12.getContentType() != 100) goto L26;
        if (com.larus.im.bean.message.a.b0(r12) == false) goto L20;
        Block r30 = com.larus.im.bean.message.a.p(r12, BlockType.BLOCK_TYPE_DEEP_THINK);
        if (r30 == null) goto L19;
        BlockContent r31 = r30.getContent();
        if (r31 == null) goto L19;
        AppletBlock r32 = r31.getAppletBlock();
        if (r32 == null) goto L19;
        String r33 = r32.renderData;
        if (r33 == null) goto L19;
        if (StringsKt.contains$default(r33, "widget__hot-news", false, 2, null) != true) goto L19;
        boolean r34 = true;
    L24:
        if (r34 == false) goto L26;
        StringCompanionObject r35 = StringCompanionObject.INSTANCE;
        String r36 = r1.getString(2131901368);
        Calendar r37 = a.a;
        return String.format(r36, Arrays.copyOf(new Object[]{new SimpleDateFormat("yyyy/MM/dd").format(new Date(r12.getCreateTime() * ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY)))}, 1));
    L19:
        r34 = false;
        goto L24
    L20:
        WidgetRenderDelegate r38 = WidgetRenderDelegate.a;
        String r39 = r12.getMessageId();
        if (r39 != null) goto L23;
        r39 = "";
    L23:
        r34 = StringsKt.contains$default(r38.b(r39, r12.getContent()), "widget__hot-news", false, 2, null);
        goto L24
    }

    public static String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "query");
        BigInteger r0 = new BigInteger(1, MessageDigest.getInstance("SHA-512").digest(r2.getBytes(Charsets.UTF_8)));     // Catch: Exception -> L5
        BigInteger r3 = BigInteger.ONE;     // Catch: Exception -> L5
        return String.valueOf(r0.and(r3.shiftLeft(63).subtract(r3)).longValue());
    L5:
        return TriggerSendLoading.NO_LOADING;
    }

    public static String b(String r7, String r8) {
        String r0 = "";
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        int r1 = StringsKt.indexOf$default(r7, "<h>", 0, true, 2, null);
        boolean r2 = true;
        if (r1 < 0) goto L10;
        int r3 = r1 + 3;
        int r4 = StringsKt.indexOf(r7, "</h>", r3, true);
        if (r4 <= r3) goto L10;
        String r9 = StringsKt.trim(StringsKt.replace(StringsKt.replace(r7.substring(r3, r4), "<h>", "", true), "</h>", "", true)).toString();
    L12:
        if (r9.length() == 0) goto L15;
        r2 = false;
    L15:
        if (r2 == false) goto L24;
        if (r8 == null) goto L18;
        String r10 = StringsKt.trim(r8).toString();
    L19:
        if (r10 == null) goto L23;
        r0 = r10;
    L23:
        return r0;
    L18:
        r10 = null;
        goto L19
    L24:
        return r9;
    L10:
        r9 = "";
        goto L12
    }

    public static boolean a(String r2, String r3, Message r4) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        Intrinsics.checkNotNullParameter(r3, "brief");
        Intrinsics.checkNotNullParameter(r4, "message");
        if (r4.getContentType() != 1) goto L8;
        if (StringsKt.contains(r3, r2, true) == false) goto L8;
        return true;
    L8:
        if (com.larus.im.bean.message.a.b0(r4) == true) goto L17;
        String r5 = r4.getContent();
        if (r5 != null) goto L13;
    L15:
        return false;
    L13:
        if (StringsKt.contains(r5, r2, true) != true) goto L15;
        return true;
    L17:
        return StringsKt.contains(com.larus.im.bean.message.a.e(r4), r2, true);
    }
}
