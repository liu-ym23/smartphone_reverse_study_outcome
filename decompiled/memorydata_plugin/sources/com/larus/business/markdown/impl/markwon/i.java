package com.larus.business.markdown.impl.markwon;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.t;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/TableForegroundProvider;", "Lio/noties/markwon/ext/tables/ForegroundProvider;", "()V", "getDrawable", "Landroid/graphics/drawable/Drawable;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class i implements io.noties.markwon.ext.tables.d {
    public i() {
    }

    @Override // io.noties.markwon.ext.tables.d
    public Drawable a(CharSequence r3, int r4, int r5) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        return null;
    L12:
        TextView r7 = t.a(r2);
        if (ZeusTransformUtils.instanceOf(r7, com.larus.business.markdown.api.c.a.a.class) == false) goto L15;
        com.larus.business.markdown.api.c.a.a r8 = (com.larus.business.markdown.api.c.a.a) ZeusTransformUtils.preCheckCast(r7, com.larus.business.markdown.api.c.a.a.class, "com.obric.memorydata.plugin");
    L16:
        if (r8 != null) goto L19;
        return null;
    L19:
        if (r8.isSelected(r4, r5) == true) goto L21;
        return null;
    L21:
        return (Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(r8.getSelectedColor()), Drawable.class, "com.obric.memorydata.plugin");
    L15:
        r8 = null;
        goto L16
    L5:
        if (r2.length() == 0) goto L8;
        r6 = false;
        goto L10
    }
}
