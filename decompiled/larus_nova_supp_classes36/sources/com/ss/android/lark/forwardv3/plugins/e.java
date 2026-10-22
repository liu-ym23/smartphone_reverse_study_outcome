package com.ss.android.lark.forwardv3.plugins;

import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends BasePicker.IOnPickNotify {
    public final /* synthetic */ ForwardCreateGroupChatFragment a;

    public final void onSelected(String r2, SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "info");
    }

    public e(ForwardCreateGroupChatFragment r1) {
        this.a = r1;
    }

    public final void onChanged(List<String> r3, List<SearchBaseInfo> r4) {
        Intrinsics.checkNotNullParameter(r3, "ids");
        Intrinsics.checkNotNullParameter(r4, "infoList");
        this.a.l.clear();
        ForwardCreateGroupChatFragment r5 = this.a;
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        SearchBaseInfo r0 = (SearchBaseInfo) r6.next();
        r5.l.add(r0);
        goto L4
    }
}
