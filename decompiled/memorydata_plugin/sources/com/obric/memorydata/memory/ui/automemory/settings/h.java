package com.obric.memorydata.memory.ui.automemory.settings;

import android.text.TextUtils;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\u0005"}, d2 = {"setSubTitleAndShow", "", "Lcom/obric/oui/lisitem/OCardListItem;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class h {
    public static final /* synthetic */ void a(OCardListItem r2, CharSequence r3) {
        b(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    private static final void b(OCardListItem r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        r2.setSubTitle(r4);
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        r2.d(!r5);
        OTextView r6 = r2.getSubTitleView();
        r6.setSingleLine(true);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r5 = false;
        goto L9
    }
}
