package od8;

import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Integer r3) {
        return CollectionsKt.contains(CollectionsKt.arrayListOf(new Integer[]{14, 7, 29, 12, 13}), r3);
    }

    public static boolean b(Integer r1) {
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() != 29) goto L7;
        return true;
    }

    public static boolean c(Integer r3) {
        return CollectionsKt.contains(CollectionsKt.arrayListOf(new Integer[]{7, 12, 13, 23, 29}), r3);
    }

    public static boolean d(Integer r1) {
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() != 7) goto L7;
        return true;
    }

    public static boolean e(Integer r3) {
        return CollectionsKt.contains(CollectionsKt.arrayListOf(new Integer[]{12, 14}), r3);
    }

    public static boolean f(Integer r1) {
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() != 30) goto L7;
        return true;
    }

    public static boolean g(Integer r1) {
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() != 27) goto L7;
        return true;
    }

    public static boolean h(Integer r3) {
        return CollectionsKt.contains(CollectionsKt.arrayListOf(new Integer[]{7, 29}), r3);
    }

    public static boolean i(Integer r1) {
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() != 34) goto L7;
        return true;
    }

    public static String j(String r2) {
        if (r2 != null) goto L4;
    L52:
        return null;
    L4:
        switch(r2.hashCode()) {
            case -1775152378: goto L49;
            case -1519652696: goto L45;
            case -1104494850: goto L42;
            case -751697127: goto L39;
            case -701204130: goto L36;
            case -325190508: goto L33;
            case -106106972: goto L30;
            case 120426756: goto L26;
            case 451709046: goto L23;
            case 1086767678: goto L19;
            case 1504163779: goto L16;
            case 1515662834: goto L13;
            case 1840109215: goto L10;
            case 1970358852: goto L7;
            default: goto L52;
        };
    L7:
        if (r2.equals("send_photo_preview") == false) goto L52;
    L51:
        return "input_left";
    L10:
        if (r2.equals("common_bottom_menu") == false) goto L52;
    L47:
        return "general";
    L13:
        if (r2.equals("ecom_page") == false) goto L52;
        return "ecom_page";
    L16:
        if (r2.equals("prompt_direct_send") == true) goto L47;
    L19:
        if (r2.equals("edu_photo_search") == false) goto L52;
        return "image_answer_action_bar";
    L23:
        if (r2.equals("common_input") == false) goto L52;
    L26:
        if (r2.equals("edu_homework_correct") == false) goto L52;
        return "homework_correction_action_bar";
    L30:
        if (r2.equals("welcome_back") == true) goto L47;
    L33:
        if (r2.equals("travel_page") == false) goto L52;
        return "ecom_page";
    L36:
        if (r2.equals("common_action_bar") == true) goto L47;
    L39:
        if (r2.equals("attach_menu") == true) goto L47;
    L42:
        if (r2.equals("inject_input_photo_picker") == true) goto L47;
    L45:
        if (r2.equals("message_sug_action") == true) goto L47;
    L49:
        if (r2.equals("outer_input") == true) goto L51;
        goto L51
    }

    public static String k(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        switch(r2.hashCode()) {
            case -958719347: goto L25;
            case 229271330: goto L21;
            case 537420380: goto L17;
            case 1214385683: goto L13;
            case 1528556640: goto L9;
            default: goto L33;
        };
    L33:
        return null;
    L9:
        if (r2.equals("essay_correction") == false) goto L34;
        return "CAPTURE_MODE_EDU_ARTICLE_PHOTO";
    L34:
        return null;
    L13:
        if (r2.equals("arithmetic_correction") == false) goto L35;
        return "CAPTURE_MODE_EDU_CALCULATION_PHOTO";
    L35:
        return null;
    L17:
        if (r2.equals("general_camera") == false) goto L36;
        return "CAPTURE_MODE_PHOTO";
    L36:
        return null;
    L21:
        if (r2.equals("image_answer") == false) goto L37;
        return "CAPTURE_MODE_EDU_GENERAL_PHOTO";
    L37:
        return null;
    L25:
        if (r2.equals("homework_correction") == false) goto L38;
        return "CAPTURE_MODE_EDU_HOMEWORK_PHOTO";
    L38:
        return null;
    }

    public static Integer l(String r1) {
        if (r1 != null) goto L4;
    L30:
        return null;
    L4:
        switch(r1.hashCode()) {
            case -1332250801: goto L27;
            case -1094802766: goto L23;
            case -861871587: goto L19;
            case -737941017: goto L15;
            case 358782896: goto L11;
            case 1556930703: goto L7;
            default: goto L30;
        };
    L7:
        if (r1.equals("CAPTURE_MODE_EDU_GENERAL_PHOTO") == false) goto L30;
        return 7;
    L11:
        if (r1.equals("CAPTURE_MODE_EDU_CALCULATION_PHOTO") == false) goto L30;
        return 13;
    L15:
        if (r1.equals("CAPTURE_MODE_HEALTH_SECOND_PHOTO") == false) goto L30;
        return 20;
    L19:
        if (r1.equals("CAPTURE_MODE_EDU_ARTICLE_PHOTO") == false) goto L30;
        return 12;
    L23:
        if (r1.equals("CAPTURE_MODE_HEALTH_PHOTO") == false) goto L30;
        return 14;
    L27:
        if (r1.equals("CAPTURE_MODE_EDU_HOMEWORK_PHOTO") == false) goto L30;
        return 29;
    }
}
