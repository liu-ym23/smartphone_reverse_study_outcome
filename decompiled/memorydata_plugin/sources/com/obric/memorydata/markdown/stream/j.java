package com.obric.memorydata.markdown.stream;

import android.widget.TextView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\rH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0003H\u0016\u0082\u0001\u0001\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/markdown/stream/RenderStrategy;", "", "render", "", "textView", "Landroid/widget/TextView;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "finished", "", "externalStruct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "keyInfoMap", "", "", "renderToSpanned", "", "release", "Lcom/obric/memorydata/markdown/stream/MarkdownTextViewUpdater$MarkdownTextViewStrategy;", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface j {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(j r8, TextView r9, String r10, boolean r11, com.larus.business.markdown.api.model.e r12, Map r13, int r14, Object r15) {
            j r2 = (j) ZeusTransformUtils.wrapperContextForParams(r8, j.class, "com.obric.memorydata.plugin");
            com.larus.business.markdown.api.model.e r16 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r12, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
            Map<String, ? extends List<String>> r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
            if (r15 != null) goto L14;
            if ((r14 & 8) == 0) goto L7;
            r16 = null;
        L7:
            com.larus.business.markdown.api.model.e r6 = r16;
            if ((r14 & 16) == 0) goto L10;
            Map<String, ? extends List<String>> r7 = MapsKt.emptyMap();
        L11:
            r2.a(r9, r10, r11, r6, r7);
            return;
        L10:
            r7 = r17;
            goto L11
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: render");
        }
    }

    void a();

    void a(TextView r1, String r2, boolean r3, com.larus.business.markdown.api.model.e r4, Map<String, ? extends List<String>> r5);
}
