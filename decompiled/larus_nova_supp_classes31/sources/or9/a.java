package or9;

import com.larus.platform.model.video.business.EnterVideoMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final EnterVideoMethod a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        EnterVideoMethod r0 = EnterVideoMethod.MAIN_DOUBLE_TAG;
        if (Intrinsics.areEqual(r2, r0.getValue()) == true) goto L37;
        EnterVideoMethod r1 = EnterVideoMethod.INDEPENDENT_DOU_YIN_BOT;
        if (Intrinsics.areEqual(r2, r1.getValue()) == true) goto L38;
        EnterVideoMethod r3 = EnterVideoMethod.BOTTOM_TAB;
        if (Intrinsics.areEqual(r2, r3.getValue()) == true) goto L39;
        EnterVideoMethod r4 = EnterVideoMethod.OUTER_PUSH;
        if (Intrinsics.areEqual(r2, r4.getValue()) == true) goto L40;
        EnterVideoMethod r5 = EnterVideoMethod.SEARCH_VIDEO_PAGE;
        if (Intrinsics.areEqual(r2, r5.getValue()) == true) goto L41;
        EnterVideoMethod r6 = EnterVideoMethod.WELCOME_BACK_AWEME_VIDEO_CARD_LIST;
        if (Intrinsics.areEqual(r2, r6.getValue()) == true) goto L42;
        EnterVideoMethod r7 = EnterVideoMethod.CLICK_NOTIFY_BANNER;
        if (Intrinsics.areEqual(r2, r7.getValue()) == true) goto L43;
        EnterVideoMethod r8 = EnterVideoMethod.COLLECTION_VIDEO_PAGE;
        if (Intrinsics.areEqual(r2, r8.getValue()) == true) goto L44;
        EnterVideoMethod r9 = EnterVideoMethod.CLICK_MUSIC_FLOAT_WINDOW;
        if (Intrinsics.areEqual(r2, r9.getValue()) == true) goto L45;
        EnterVideoMethod r10 = EnterVideoMethod.FLOW_CLICK_RECOMMEND_VIDEO_CARD;
        if (Intrinsics.areEqual(r2, r10.getValue()) == true) goto L46;
        EnterVideoMethod r11 = EnterVideoMethod.POI_VIDEO_PAGE;
        if (Intrinsics.areEqual(r2, r11.getValue()) == false) goto L36;
        return r11;
    L36:
        return EnterVideoMethod.NONE;
    L46:
        return r10;
    L45:
        return r9;
    L44:
        return r8;
    L43:
        return r7;
    L42:
        return r6;
    L41:
        return r5;
    L40:
        return r4;
    L39:
        return r3;
    L38:
        return r1;
    L37:
        return r0;
    }
}
