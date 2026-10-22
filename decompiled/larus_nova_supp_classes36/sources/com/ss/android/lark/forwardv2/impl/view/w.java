package com.ss.android.lark.forwardv2.impl.view;

import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w extends BasePicker.IOnPickNotify {
    public final /* synthetic */ d0 a;

    public final void onChanged(List<String> r1, List<SearchBaseInfo> r2) {
    }

    public w(d0 r1) {
        this.a = r1;
    }

    public final void onDeSelected(String r1, final SearchBaseInfo r2) {
        qqb.c.c(new v(this, r2));
    }

    public final void onSelected(String r1, final SearchBaseInfo r2) {
        qqb.c.d("Forward: on item selected", new u(this, r2));
    }
}
