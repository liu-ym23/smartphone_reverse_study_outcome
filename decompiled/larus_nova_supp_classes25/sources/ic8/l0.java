package ic8;

import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l0 {
    public static final boolean a(List<Integer> r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (AppHost.a.isPlugin() == false) goto L8;
        return false;
    L8:
        PageType r1 = PageType.Chat;
        if (r4.contains(Integer.valueOf(r1.getType())) == false) goto L15;
        if (r4.contains(Integer.valueOf(PageType.AI_GENERATE.getType())) == false) goto L15;
        return !com.larus.platform.service.e0.a.j();
    L15:
        if (r4.contains(Integer.valueOf(r1.getType())) == false) goto L21;
        if (r4.contains(Integer.valueOf(PageType.VIDEO.getType())) == false) goto L21;
        return SettingRepoDelegate.b.q0();
    L21:
        if (r4.contains(Integer.valueOf(r1.getType())) == true) goto L23;
        return false;
    L23:
        if (r4.contains(Integer.valueOf(PageType.AWEME_FEED.getType())) == true) goto L25;
        return false;
    L25:
        if (AccountService.a.isLogin().booleanValue() == true) goto L27;
        return false;
    L27:
        if (SettingRepoDelegate.b.q0() == false) goto L33;
        return true;
    L33:
        return false;
    }

    public static final boolean b(List<Integer> r4) {
        if (a(r4) == false) goto L6;
        return true;
    L6:
        if (r4 == null) goto L13;
        Integer r2 = (Integer) CollectionsKt.getOrNull(r4, 0);
        int r3 = PageType.Chat.getType();
        if (r2 == null) goto L13;
        if (r2.intValue() != r3) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L26;
        Integer r6 = (Integer) CollectionsKt.getOrNull(r4, 1);
        int r7 = PageType.IMAGE_TEMPLATE.getType();
        if (r6 != null) goto L19;
    L20:
        Integer r8 = (Integer) CollectionsKt.getOrNull(r4, 1);
        int r9 = PageType.MUSIC_TEMPLATE.getType();
        if (r8 == null) goto L26;
        if (r8.intValue() != r9) goto L26;
        return true;
    L19:
        if (r6.intValue() != r7) goto L20;
        return true;
    L26:
        return false;
    L13:
        r5 = false;
        goto L14
    }
}
