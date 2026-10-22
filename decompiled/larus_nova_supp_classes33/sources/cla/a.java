package cla;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.common.oui.R;
import com.obric.miniapp.utils.e1;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static Float b(Object r1) {
        if ((r1 instanceof Number) == false) goto L6;
        return Float.valueOf(((Number) r1).floatValue());
    L6:
        if ((r1 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toFloatOrNull(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.trim((String) r1).toString(), "dp"), "sp"), "px"));
    }

    public static String c(String r13) {
        Intrinsics.checkNotNullParameter(r13, "rawName");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim(r13).toString(), "builtin:"), "popover:"), "oui:"), "@drawable/"), "drawable/").toLowerCase(Locale.ROOT), "-", "_", false, 4, null), " ", "_", false, 4, null);
    }

    public static Integer d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "rawName");
        String r2 = c(r1);
        switch(r2.hashCode()) {
            case -2079216026: goto L69;
            case -1867169789: goto L65;
            case -1573253640: goto L61;
            case -1419699188: goto L58;
            case -1367724422: goto L54;
            case -697920873: goto L51;
            case 3089282: goto L48;
            case 3322014: goto L45;
            case 93090825: goto L42;
            case 94627080: goto L39;
            case 94756344: goto L36;
            case 94935104: goto L33;
            case 445606381: goto L30;
            case 499742456: goto L27;
            case 696834840: goto L24;
            case 718796017: goto L21;
            case 742886971: goto L18;
            case 951117504: goto L15;
            case 1671672458: goto L12;
            case 1677581638: goto L9;
            case 1962919167: goto L6;
            default: goto L72;
        };
    L72:
        return null;
    L6:
        if (r2.equals("calendar_list") == false) goto L72;
    L75:
        return 2131244153;
    L9:
        if (r2.equals("schedule_list") == true) goto L75;
    L12:
        if (r2.equals("dismiss") == false) goto L72;
    L74:
        return 2131244202;
    L15:
        if (r2.equals("confirm") == false) goto L72;
    L76:
        return 2131235883;
    L18:
        if (r2.equals("chevron") == false) goto L72;
    L77:
        return 2131244160;
    L21:
        if (r2.equals("agenda_list") == true) goto L75;
    L24:
        if (r2.equals("chevron_right") == true) goto L77;
    L27:
        if (r2.equals("close_black") == true) goto L74;
    L30:
        if (r2.equals("disclosure") == true) goto L77;
    L33:
        if (r2.equals("cross") == true) goto L74;
    L36:
        if (r2.equals("close") == false) goto L72;
    L39:
        if (r2.equals("check") == true) goto L76;
    L42:
        if (r2.equals("arrow") == true) goto L77;
    L45:
        if (r2.equals("list") == true) goto L75;
    L48:
        if (r2.equals("done") == true) goto L76;
    L51:
        if (r2.equals("schedule") == true) goto L75;
    L54:
        if (r2.equals(WindowEvent.WindowOpenPerfResult.CANCEL) == true) goto L74;
    L58:
        if (r2.equals("agenda") == true) goto L75;
    L61:
        if (r2.equals("view_list") == true) goto L75;
    L65:
        if (r2.equals(WindowEvent.WindowOpenPerfResult.SUCCESS) == true) goto L76;
    L69:
        if (r2.equals("arrow_right") == true) goto L77;
        goto L72
    }

    public static String e(String r1) {
        Intrinsics.checkNotNullParameter(r1, "rawName");
        String r2 = c(r1);
        switch(r2.hashCode()) {
            case -2024140158: goto L318;
            case -2017212418: goto L314;
            case -1824445809: goto L310;
            case -1573253640: goto L306;
            case -1558685317: goto L302;
            case -1503154213: goto L298;
            case -1502921481: goto L294;
            case -1437264628: goto L290;
            case -1419699188: goto L287;
            case -1354792126: goto L283;
            case -1352294148: goto L279;
            case -1335458389: goto L275;
            case -1314689291: goto L271;
            case -1291065759: goto L267;
            case -1217487446: goto L264;
            case -1206631530: goto L261;
            case -1068795718: goto L257;
            case -1028322118: goto L254;
            case -991851251: goto L251;
            case -934610812: goto L248;
            case -906336856: goto L245;
            case -838832707: goto L241;
            case -804429082: goto L238;
            case -732377866: goto L235;
            case -697920873: goto L232;
            case -624136624: goto L229;
            case -352329957: goto L225;
            case -338497235: goto L222;
            case -321005126: goto L219;
            case -238962746: goto L216;
            case -178324674: goto L213;
            case -88014641: goto L210;
            case 96417: goto L207;
            case 99228: goto L204;
            case 108835: goto L200;
            case 108960: goto L197;
            case 110873: goto L194;
            case 114009: goto L191;
            case 1618569: goto L188;
            case 3045982: goto L185;
            case 3059573: goto L181;
            case 3076014: goto L178;
            case 3108362: goto L175;
            case 3168655: goto L172;
            case 3202370: goto L169;
            case 3237038: goto L165;
            case 3322014: goto L162;
            case 3357525: goto L158;
            case 3444122: goto L155;
            case 3704893: goto L151;
            case 41204738: goto L148;
            case 50359046: goto L145;
            case 69208186: goto L142;
            case 92611469: goto L139;
            case 104080000: goto L135;
            case 106642798: goto L132;
            case 108704329: goto L129;
            case 110621496: goto L126;
            case 184994700: goto L123;
            case 185934015: goto L120;
            case 188702929: goto L117;
            case 485975746: goto L114;
            case 535225839: goto L111;
            case 566447392: goto L108;
            case 678990007: goto L105;
            case 718796017: goto L102;
            case 722049599: goto L99;
            case 728504064: goto L96;
            case 842074177: goto L93;
            case 912514171: goto L90;
            case 931310141: goto L87;
            case 954891333: goto L84;
            case 988711087: goto L81;
            case 1201687819: goto L78;
            case 1247787042: goto L75;
            case 1250407999: goto L72;
            case 1265807887: goto L69;
            case 1277802073: goto L66;
            case 1285169560: goto L63;
            case 1301496073: goto L60;
            case 1434631203: goto L57;
            case 1505434244: goto L54;
            case 1505669047: goto L51;
            case 1557721666: goto L48;
            case 1645600483: goto L45;
            case 1677581638: goto L42;
            case 1798276132: goto L39;
            case 1802489424: goto L36;
            case 1862666772: goto L33;
            case 1888598416: goto L30;
            case 1961215722: goto L27;
            case 1962919167: goto L24;
            case 1963302046: goto L21;
            case 1968600364: goto L18;
            case 1985941072: goto L15;
            case 1989861112: goto L12;
            case 2006930817: goto L9;
            case 2102494577: goto L6;
            default: goto L321;
        };
    L321:
        return null;
    L6:
        if (r2.equals("navigate") == false) goto L321;
    L202:
        return "popover/navigation.svg";
    L9:
        if (r2.equals("info_circle") == false) goto L321;
    L167:
        return "popover/about.svg";
    L12:
        if (r2.equals("preferences") == false) goto L321;
    L285:
        return "popover/settings.svg";
    L15:
        if (r2.equals("setting") == true) goto L285;
    L18:
        if (r2.equals("information") == true) goto L167;
    L21:
        if (r2.equals("calendar_year") == false) goto L321;
    L153:
        return "popover/calendar_year.svg";
    L24:
        if (r2.equals("calendar_list") == false) goto L321;
    L308:
        return "popover/agenda_list.svg";
    L27:
        if (r2.equals("calendar_3day") == false) goto L321;
    L304:
        return "popover/calendar_3day.svg";
    L30:
        if (r2.equals("arrow_up_down") == false) goto L321;
    L243:
        return "popover/chevrons_vertical.svg";
    L33:
        if (r2.equals("navigation") == true) goto L202;
    L36:
        if (r2.equals("oic_plus") == false) goto L321;
    L281:
        return "popover/plus.svg";
    L39:
        if (r2.equals("all_todo") == false) goto L321;
    L296:
        return "popover/all_todos.svg";
    L42:
        if (r2.equals("schedule_list") == true) goto L308;
    L45:
        if (r2.equals("done_todo") == false) goto L321;
    L300:
        return "popover/complete_todo.svg";
    L48:
        if (r2.equals("details") == true) goto L167;
    L51:
        if (r2.equals("copy_text") == false) goto L321;
    L183:
        return "popover/copy.svg";
    L54:
        if (r2.equals("copy_link") == true) goto L183;
    L57:
        if (r2.equals("settings") == true) goto L285;
    L60:
        if (r2.equals("magnifier_search") == false) goto L321;
    L316:
        return "popover/search.svg";
    L63:
        if (r2.equals("trashcan") == false) goto L321;
    L277:
        return "popover/delete.svg";
    L66:
        if (r2.equals("contact_plus") == false) goto L321;
    L320:
        return "popover/add_contact.svg";
    L69:
        if (r2.equals("make_call") == false) goto L321;
    L312:
        return "popover/call.svg";
    L72:
        if (r2.equals("date_picker") == false) goto L321;
    L292:
        return "popover/pick_date.svg";
    L75:
        if (r2.equals("send_sms") == false) goto L321;
    L273:
        return "popover/send_sms.svg";
    L78:
        if (r2.equals("duplicate") == true) goto L183;
    L81:
        if (r2.equals("calendar_picker") == true) goto L292;
    L84:
        if (r2.equals("ellipsis_3") == false) goto L321;
    L160:
        return "popover/ellipsis_3.svg";
    L87:
        if (r2.equals("chevrons_vertical") == true) goto L243;
    L90:
        if (r2.equals("oic_ellipsis_3") == true) goto L160;
    L93:
        if (r2.equals("vertical_chevrons") == true) goto L243;
    L96:
        if (r2.equals("calendar_today") == false) goto L321;
    L227:
        return "popover/calendar_day.svg";
    L99:
        if (r2.equals("calendar_month") == false) goto L321;
    L137:
        return "popover/calendar_month.svg";
    L102:
        if (r2.equals("agenda_list") == true) goto L308;
    L105:
        if (r2.equals("person_add") == true) goto L320;
    L108:
        if (r2.equals("more_vertical") == true) goto L160;
    L111:
        if (r2.equals("eye_slash") == false) goto L321;
    L269:
        return "popover/visibility_off.svg";
    L114:
        if (r2.equals("visibility_off") == true) goto L269;
    L117:
        if (r2.equals("ellipsis") == true) goto L160;
    L120:
        if (r2.equals("oic_magnifier_search") == true) goto L316;
    L123:
        if (r2.equals("complete_todo") == true) goto L300;
    L126:
        if (r2.equals("trash") == true) goto L277;
    L129:
        if (r2.equals("route") == true) goto L202;
    L132:
        if (r2.equals("phone") == true) goto L312;
    L135:
        if (r2.equals("month") == true) goto L137;
    L139:
        if (r2.equals("about") == true) goto L167;
    L142:
        if (r2.equals("checkmark_circle") == true) goto L300;
    L145:
        if (r2.equals("leading") == true) goto L160;
    L148:
        if (r2.equals("contact_add") == true) goto L320;
    L151:
        if (r2.equals("year") == true) goto L153;
    L155:
        if (r2.equals("plus") == true) goto L281;
    L158:
        if (r2.equals("more") == true) goto L160;
    L162:
        if (r2.equals("list") == true) goto L308;
    L165:
        if (r2.equals("info") == true) goto L167;
    L169:
        if (r2.equals("hide") == true) goto L269;
    L172:
        if (r2.equals("gear") == true) goto L285;
    L175:
        if (r2.equals("edit") == false) goto L321;
    L259:
        return "popover/edit.svg";
    L178:
        if (r2.equals("date") == true) goto L292;
    L181:
        if (r2.equals("copy") == true) goto L183;
    L185:
        if (r2.equals("call") == true) goto L312;
    L188:
        if (r2.equals("3day") == true) goto L304;
    L191:
        if (r2.equals("sms") == true) goto L273;
    L194:
        if (r2.equals("pen") == true) goto L259;
    L197:
        if (r2.equals("new") == true) goto L281;
    L200:
        if (r2.equals("nav") == true) goto L202;
    L204:
        if (r2.equals("day") == true) goto L227;
    L207:
        if (r2.equals("add") == true) goto L281;
    L210:
        if (r2.equals("all_todos") == true) goto L296;
    L213:
        if (r2.equals("calendar") == true) goto L292;
    L216:
        if (r2.equals("up_down") == true) goto L243;
    L219:
        if (r2.equals("calendar_three_day") == true) goto L304;
    L222:
        if (r2.equals("show_off") == true) goto L269;
    L225:
        if (r2.equals("calendar_day") == true) goto L227;
    L229:
        if (r2.equals("send_message") == true) goto L273;
    L232:
        if (r2.equals("schedule") == true) goto L308;
    L235:
        if (r2.equals("article") == true) goto L296;
    L238:
        if (r2.equals("configure") == true) goto L285;
    L241:
        if (r2.equals("updown") == true) goto L243;
    L245:
        if (r2.equals("search") == true) goto L316;
    L248:
        if (r2.equals("remove") == true) goto L277;
    L251:
        if (r2.equals("pencil") == true) goto L259;
    L254:
        if (r2.equals("add_to_contact") == true) goto L320;
    L257:
        if (r2.equals("modify") == true) goto L259;
    L261:
        if (r2.equals("multi_day") == true) goto L304;
    L264:
        if (r2.equals("hidden") == true) goto L269;
    L267:
        if (r2.equals("eye_off") == true) goto L269;
    L271:
        if (r2.equals("text_message") == true) goto L273;
    L275:
        if (r2.equals("delete") == true) goto L277;
    L279:
        if (r2.equals("create") == true) goto L281;
    L283:
        if (r2.equals("config") == true) goto L285;
    L287:
        if (r2.equals("agenda") == true) goto L308;
    L290:
        if (r2.equals("pick_date") == true) goto L292;
    L294:
        if (r2.equals("todo_list") == true) goto L296;
    L298:
        if (r2.equals("todo_done") == true) goto L300;
    L302:
        if (r2.equals("three_day") == true) goto L304;
    L306:
        if (r2.equals("view_list") == true) goto L308;
    L310:
        if (r2.equals("phone_call") == true) goto L312;
    L314:
        if (r2.equals("magnifier") == true) goto L316;
    L318:
        if (r2.equals("add_contact") == true) goto L320;
        goto L320
    }

    public static int a(Context r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Resources r3 = r1.getResources();
        return (int) (r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density);
    }

    public static Drawable f(Context r6, String r7) {
        boolean r0 = true;
        String r8 = StringsKt.trimStart(StringsKt.trim(r7).toString(), new char[]{65279});
        Object r3 = null;
        if (StringsKt.isBlank(r8) == false) goto L5;
        return null;
    L5:
        e1.a.getClass();
        Drawable r1 = e1.b(r6, r8);
        if (r1 == null) goto L9;
        return r1;
    L9:
        if (StringsKt.endsWith(r8, ".svg", true) == false) goto L13;
        Drawable r2 = e1.a(r6, r8);
        if (r2 == null) goto L13;
        return r2;
    L13:
        String r4 = e(r8);
        if (r4 == null) goto L18;
        Drawable r5 = e1.a(r6, r4);
        if (r5 == null) goto L18;
        return r5;
    L18:
        Integer r9 = d(r8);
        if (r9 == null) goto L31;
        int r10 = r9.intValue();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L23
        Object r12 = Result.constructor-impl(ContextCompat.getDrawable(r6, r10));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r12) == true) goto L30;
        r3 = r12;
    L30:
        return (Drawable) r3;
    L23:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L31:
        String r14 = StringsKt.removePrefix(StringsKt.removePrefix(r8, "@drawable/"), "drawable/");
        Integer r15 = Integer.valueOf(r6.getResources().getIdentifier(r14, "drawable", r6.getPackageName()));
        if (r15.intValue() == 0) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == true) goto L38;
        r15 = null;
    L38:
        if (r15 == null) goto L67;
    L55:
        if (r15 == null) goto L73;
        int r17 = r15.intValue();
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L59
        Object r19 = Result.constructor-impl(ContextCompat.getDrawable(r6, r17));     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r19) == true) goto L66;
        r3 = r19;
    L66:
        return (Drawable) r3;
    L59:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L73:
        return null;
    L67:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L41
        Object r22 = Result.constructor-impl(Integer.valueOf(R.drawable.class.getField(r14).getInt(null)));     // Catch: Throwable -> L41
    L44:
        if (Result.isFailure-impl(r22) == false) goto L46;
        r22 = null;
    L46:
        r15 = (Integer) r22;
        if (r15 != null) goto L49;
    L54:
        r15 = null;
        goto L55
    L49:
        if (r15.intValue() != 0) goto L52;
        r0 = false;
    L52:
        if (r0 == false) goto L54;
    L41:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L34:
        r16 = false;
        goto L35
    }
}
