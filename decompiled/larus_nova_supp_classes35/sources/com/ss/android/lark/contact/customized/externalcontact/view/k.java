package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ OfficeExternalContactFragment a;

    public k(OfficeExternalContactFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        mtb.k r5 = (mtb.k) r4;
        OfficeExternalContactFragment r0 = this.a;
        int r1 = r5.a;
        r0.n = r1;
        if (r1 > 0) goto L5;
    L8:
        String r6 = BuildConfig.FLAVOR;
    L9:
        r0.o = r6;
        OfficeExternalContactFragment r7 = this.a;
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r2 = r7.k;
        if (r2 == null) goto L18;
        l9b.a r8 = r7.V90();
        Intrinsics.checkNotNullParameter(r8, "config");
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r3 = r2.a;
        if ((r3 instanceof SubPageEntryAdapter) == false) goto L14;
        SubPageEntryAdapter r9 = (SubPageEntryAdapter) r3;
    L15:
        if (r9 == null) goto L19;
        Intrinsics.checkNotNullParameter(r8, "config");
        r9.a = r8;
        r9.notifyItemChanged(0);
        return;
    L19:
        return;
    L14:
        r9 = null;
        goto L15
    L18:
        return;
    L5:
        if (StringsKt.isBlank(r5.b) == true) goto L8;
        ICUUtils.FormatArgsBuilder r10 = new ICUUtils.FormatArgsBuilder();
        r10.b(IPortraitService.NAME, r5.b);
        List r11 = r10.a;
        r6 = ICUUtils.icuFormat(UIHelper.getString(2131890045), r11);
        Intrinsics.checkNotNull(r6);
        goto L9
    }
}
