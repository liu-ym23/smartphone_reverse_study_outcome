package brb;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.GroupMemAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.WantAtMemBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final List<BaseAtBean> a(List<? extends BaseAtBean> r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        ArrayList r0 = new ArrayList();
        Iterator<? extends BaseAtBean> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L19;
        BaseAtBean r1 = r7.next();
        if ((r1 instanceof GroupMemAtBean) == false) goto L9;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r2 = ((GroupMemAtBean) r1).getChatterInfo();
    L15:
        if (r2 == null) goto L18;
        if (r2.g == Chatter.ChatterType.AI) goto L4;
    L18:
        r0.add(r1);
        goto L4
    L9:
        if ((r1 instanceof SearchBean) == false) goto L12;
        r2 = ((SearchBean) r1).getChatterInfo();
        goto L15
    L12:
        if ((r1 instanceof WantAtMemBean) == false) goto L14;
        r2 = ((WantAtMemBean) r1).getChatterInfo();
        goto L15
    L14:
        r2 = null;
        goto L15
    L19:
        HashSet r8 = new HashSet();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r0.iterator();
    L21:
        if (r4.hasNext() == false) goto L30;
        Object r5 = r4.next();
        BaseAtBean r9 = (BaseAtBean) r5;
        if ((r9 instanceof SearchBean) == false) goto L25;
        String r10 = ((SearchBean) r9).getChatterInfo().a;
    L27:
        if (r8.add(r10) == false) goto L21;
        r3.add(r5);
        goto L21
    L25:
        r10 = UUID.randomUUID().toString();
        goto L27
    L30:
        if (r3.size() == r0.size()) goto L32;
        Log.w("MentionList", "duplicate search items");
    L32:
        return r3;
    }
}
