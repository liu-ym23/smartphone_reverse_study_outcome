package com.larus.business.markdown.api.extplugin.a;

import android.content.Context;
import android.graphics.Rect;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JH\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u0018"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeWidget;", "", "asView", "Landroid/view/View;", "context", "Landroid/content/Context;", "bindData", "Landroid/util/Size;", "textView", "Landroid/widget/TextView;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Landroid/text/Spanned;", "span", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeSpan;", "rect", "Landroid/graphics/Rect;", "payload", "", "", "maxContentWidth", "", "onRecycle", "", "onReuse", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface c {
    Size a(TextView r1, Spanned r2, b r3, Rect r4, Map<String, ? extends Object> r5, int r6);

    View a(Context r1);
}
