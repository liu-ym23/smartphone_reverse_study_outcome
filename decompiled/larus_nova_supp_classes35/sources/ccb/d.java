package ccb;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public final List<ChatChatter> a;
    public final List<ChatChatter> b;
    public final List<ChatChatter> c;
    public final Map<String, String> d;
    public final boolean e;
    public final String f;
    public final List<UserGroupEntity> g;

    public d() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new HashMap(), false, BuildConfig.FLAVOR);
    }

    public d(List<ChatChatter> r6, List<ChatChatter> r7, List<ChatChatter> r8, List<UserGroupEntity> r9, Map<String, String> r10, boolean r11, String r12) {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        ArrayList r1 = new ArrayList();
        this.b = r1;
        ArrayList r2 = new ArrayList();
        this.c = r2;
        HashMap r3 = new HashMap();
        this.d = r3;
        ArrayList r4 = new ArrayList();
        this.g = r4;
        CollectionUtils.resetToList(r0, r6);
        CollectionUtils.resetToList(r1, r7);
        CollectionUtils.resetToList(r2, r8);
        CollectionUtils.resetToList(r4, r9);
        if (CollectionUtils.isNotEmpty(r10) == false) goto L5;
        r3.putAll(r10);
    L5:
        this.e = r11;
        this.f = r12;
    }
}
