package wh8;

import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.c2;
import com.larus.bmhome.actionbar.model.d1;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.o1;
import com.larus.bmhome.actionbar.model.z1;
import com.larus.bmhome.chat.model.api.DefaultReplyExposedConfig;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuItemIcon;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuItemTag;
import com.larus.bmhome.chat.model.api.DefaultReplyModelItemIndex;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuConfig;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final g1 a(DefaultReplyMenuItemIcon r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        return new g1(r7.getUri(), r7.getUrl(), null, null, 28);
    }

    public static final d1 b(DefaultReplyExposedConfig r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        return new d1(r4.getMaxExposedNum(), a(r4.getIcon()), a(r4.getDarkModeIcon()), r4.getText());
    }

    public static final o1 c(DefaultReplyModelItemIndex r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new o1(r2.getItemId(), r2.getModelItemKey());
    }

    public static final a2 d(DefaultReplySwitchMenuConfig r26) {
        if (r26 == null) goto L47;
        List<DefaultReplySwitchMenuItem> r1 = r26.getItemList();
        if (r1 != null) goto L7;
        r1 = CollectionsKt.emptyList();
    L7:
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L36;
        DefaultReplySwitchMenuItem r4 = (DefaultReplySwitchMenuItem) r3.next();
        if (r4 == null) goto L32;
        String r19 = r4.getModelItemKey();
        if (r19 == null) goto L32;
        Integer r5 = Integer.valueOf(r4.getDeprecatedItemId());
        String r6 = r4.getName();
        g1 r7 = a(r4.getIcon());
        g1 r8 = a(r4.getDarkModeIcon());
        g1 r9 = a(r4.getActiveIcon());
        g1 r10 = a(r4.getActiveDarkModeIcon());
        String r11 = r4.getSubTitleName();
        Integer r12 = r4.getShowTaskTools();
        Long r13 = r4.getRedDotVersion();
        List<DefaultReplyMenuItemTag> r14 = r4.getTagList();
        if (r14 == null) goto L26;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L19:
        if (r16.hasNext() == false) goto L27;
        DefaultReplyMenuItemTag r17 = (DefaultReplyMenuItemTag) r16.next();
        if (r17 == null) goto L23;
        c2 r18 = e(r17);
    L24:
        if (r18 == null) goto L19;
        r15.add(r18);
        goto L19
    L23:
        r18 = null;
    L27:
        String r110 = r4.getSelectedName();
        Integer r111 = r4.getAgentMode();
        Boolean r112 = r4.getNeedLogin();
        z1 r113 = r4.getSubscribeConfig();
        Map<String, String> r20 = r4.getModelExtraParams();
        List<String> r21 = r4.getConversationModeList();
        if (r21 == null) goto L30;
        List r22 = CollectionsKt.filterNotNull(r21);
    L31:
        b2 r23 = new b2(r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r110, r111, r112, r113, r19, r20, r22, r4.getDefaultConversationMode(), r4.getDefaultMode(), r4.getReasoningEffortConfig(), 1048576);
    L33:
        if (r23 == null) goto L9;
        r2.add(r23);
        goto L9
    L30:
        r22 = null;
        goto L31
    L26:
        r15 = null;
    L32:
        r23 = null;
        goto L33
    L36:
        return new a2(new ArrayList(r2), b(r26.getExposeConfig()));
    L47:
        return null;
    }

    public static final c2 e(DefaultReplyMenuItemTag r8) {
        return new c2(r8.getType(), r8.getText(), r8.getIcon(), r8.getDarkModeIcon(), r8.getTagExpireTime(), 48);
    }
}
