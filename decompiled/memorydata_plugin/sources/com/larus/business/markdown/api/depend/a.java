package com.larus.business.markdown.api.depend;

import android.text.Spanned;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J>\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "", "accept", "", "dataType", "", "getWidget", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "container", "Landroid/widget/FrameLayout;", "textView", "Landroid/widget/TextView;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "payload", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface a {
    io.noties.markwon.html.a.g a(FrameLayout r1, TextView r2, Spanned r3, io.noties.markwon.html.a.f r4, Map<String, ? extends Object> r5);

    boolean a(String r1);
}
