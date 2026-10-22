package dv8;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.AccountService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final String b(SpeakerVoice r19) {
        if (r19 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r19.getId(), TriggerSendLoading.NO_LOADING) == false) goto L7;
        return null;
    L7:
        if (Intrinsics.areEqual(r19.getId(), "none") == true) goto L73;
        List r1 = r19.getMixVoiceList();
        boolean r4 = false;
        if (r1 == null) goto L15;
        if ((!r1.isEmpty()) != true) goto L15;
        r4 = true;
    L15:
        if (r4 == false) goto L50;
        LinkedHashSet r5 = new LinkedHashSet();
        List r8 = r19.getMixVoiceList();
        if (r8 == null) goto L40;
        Iterator r9 = r8.iterator();
    L20:
        if (r9.hasNext() == false) goto L40;
        SpeakerVoice r10 = ((MixVoice) r9.next()).getVoiceItem();
        if (r10 == null) goto L20;
        if (Intrinsics.areEqual(r10.getId(), TriggerSendLoading.NO_LOADING) == false) goto L26;
    L35:
        Object r11 = null;
    L36:
        if (r11 != null) goto L38;
        r11 = "";
    L38:
        r5.add(r11);
        goto L20
    L26:
        if (Intrinsics.areEqual(r10.getId(), "none") == true) goto L35;
        if (Intrinsics.areEqual(r10.getCreatorId(), AccountService.a.getUserId()) == false) goto L32;
        r11 = "self_created";
        goto L36
    L32:
        if (r10.isUgcVoice() == false) goto L34;
        r11 = "others_created";
        goto L36
    L34:
        r11 = "other_default";
    L40:
        if ((!r5.isEmpty()) == false) goto L70;
        ArrayList r12 = new ArrayList();
        Iterator r0 = r5.iterator();
    L43:
        if (r0.hasNext() == false) goto L69;
        Object r2 = r0.next();
        if (StringsKt.isBlank((String) r2) == true) goto L43;
        r12.add(r2);
        goto L43
    L69:
        return CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, null, 62, null);
    L70:
        return "";
    L50:
        if (Intrinsics.areEqual(r19.getCreatorId(), AccountService.a.getUserId()) == false) goto L53;
        return "self_created";
    L53:
        if (r19.isUgcVoice() == false) goto L56;
        return "others_created";
    L56:
        return "other_default";
    L73:
        return null;
    }

    public static final String a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        switch(r4.hashCode()) {
            case -1336235738: goto L84;
            case -1336145668: goto L80;
            case -1075478955: goto L76;
            case -777013775: goto L70;
            case -777005199: goto L66;
            case -589638217: goto L62;
            case 202894787: goto L58;
            case 221550025: goto L19;
            case 267651712: goto L15;
            case 1045863740: goto L9;
            case 2005260732: goto L6;
            default: goto L87;
        };
    L87:
        return null;
    L6:
        if (r4.equals("5tab_create_pannel") == false) goto L87;
    L17:
        return "direct_create";
    L9:
        if (r4.equals("click_placeholder") == false) goto L87;
        if (Intrinsics.areEqual(r3, "bot_list_profile") == false) goto L87;
        return "bot_list_profile_placeholder";
    L15:
        if (r4.equals("click_direct") == true) goto L17;
    L19:
        if (r4.equals("click_button") == false) goto L87;
        switch(r3.hashCode()) {
            case -1462439438: goto L54;
            case -1039689911: goto L50;
            case -503960960: goto L46;
            case -474703450: goto L42;
            case 305232804: goto L39;
            case 439401621: goto L35;
            case 857331732: goto L32;
            case 1613755702: goto L29;
            case 1619864869: goto L25;
            default: goto L87;
        };
    L25:
        if (r3.equals("chat_list") == false) goto L87;
        return "chat_list_float_button";
    L29:
        if (r3.equals("chat_list_discover_search_sec") == false) goto L87;
    L44:
        return "chat_list_icon_search_button";
    L32:
        if (r3.equals("chat_list_icon_search") == true) goto L44;
    L35:
        if (r3.equals("bot_list_discover_search") == false) goto L87;
        return "bot_list_discover_search_button";
    L39:
        if (r3.equals("chat_list_discover_search") == true) goto L44;
    L42:
        if (r3.equals("chat_list_icon_search_sec") == true) goto L44;
    L46:
        if (r3.equals("bot_list_profile") == false) goto L87;
        return "bot_list_profile_float_button";
    L50:
        if (r3.equals("notify") == false) goto L87;
        return "notify_float_button";
    L54:
        if (r3.equals("bot_list_discover") == false) goto L87;
        return "bot_list_discover_float_button";
    L58:
        if (r4.equals("click_banner") == false) goto L87;
        return "notify_banner";
    L62:
        if (r4.equals("5tab_pannel") == false) goto L87;
        return "direct_click";
    L66:
        if (r4.equals("click_push") == false) goto L87;
        return "outer_push";
    L70:
        if (r4.equals("click_plus") == false) goto L87;
        if (Intrinsics.areEqual(r3, "chat_list") == false) goto L87;
        return "chat_list_plus";
    L76:
        if (r4.equals("bot_maker_card_complete") == false) goto L87;
        return "bot_maker_complete";
    L80:
        if (r4.equals("bot_maker_card_head") == false) goto L87;
        return "bot_maker_head";
    L84:
        if (r4.equals("bot_maker_card_edit") == false) goto L87;
        return "bot_maker_edit";
    }
}
