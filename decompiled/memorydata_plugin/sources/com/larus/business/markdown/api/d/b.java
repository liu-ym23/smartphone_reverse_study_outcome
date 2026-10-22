package com.larus.business.markdown.api.d;

import android.content.Context;
import android.view.ViewGroup;
import com.larus.business.markdown.api.model.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JI\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000bH&JO\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/business/markdown/api/widget/IMarkdownWidgetHandler;", "", "canHandle", "", "node", "Lorg/commonmark/node/Node;", "generateMarkdownWidget", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "context", "Landroid/content/Context;", "maxContentWidth", "", "prevNode", "isLastNode", "markwonStructCache", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "(Landroid/content/Context;ILorg/commonmark/node/Node;Lorg/commonmark/node/Node;Ljava/lang/Boolean;Lcom/larus/business/markdown/api/model/IMarkwonStruct;)Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "priority", "updateMarkdownWidget", "index", "currentViewGroup", "Landroid/view/ViewGroup;", "(Landroid/content/Context;IILandroid/view/ViewGroup;Lorg/commonmark/node/Node;Ljava/lang/Boolean;Lcom/larus/business/markdown/api/model/IMarkwonStruct;)Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface b {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static /* synthetic */ com.larus.business.markdown.api.d.a a(b r10, Context r11, int r12, int r13, ViewGroup r14, Node r15, Boolean r16, e r17, int r18, Object r19) {
            b r2 = (b) ZeusTransformUtils.wrapperContextForParams(r10, b.class, "com.obric.memorydata.plugin");
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
            e r0 = (e) ZeusTransformUtils.wrapperContextForParams(r17, e.class, "com.obric.memorydata.plugin");
            if (r19 != null) goto L14;
            if ((r18 & 32) == 0) goto L7;
            Boolean r8 = false;
        L9:
            if ((r18 & 64) == 0) goto L12;
            r0 = null;
        L12:
            return r2.a(r3, r12, r13, r14, r15, r8, r0);
        L7:
            r8 = r16;
            goto L9
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMarkdownWidget");
        }

        public static /* synthetic */ com.larus.business.markdown.api.d.a a(b r9, Context r10, int r11, Node r12, Node r13, Boolean r14, e r15, int r16, Object r17) {
            b r2 = (b) ZeusTransformUtils.wrapperContextForParams(r9, b.class, "com.obric.memorydata.plugin");
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            e r0 = (e) ZeusTransformUtils.wrapperContextForParams(r15, e.class, "com.obric.memorydata.plugin");
            if (r17 != null) goto L14;
            if ((r16 & 16) == 0) goto L7;
            Boolean r7 = false;
        L9:
            if ((r16 & 32) == 0) goto L12;
            r0 = null;
        L12:
            return r2.a(r3, r11, r12, r13, r7, r0);
        L7:
            r7 = r14;
            goto L9
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateMarkdownWidget");
        }
    }

    int a();

    com.larus.business.markdown.api.d.a a(Context r1, int r2, int r3, ViewGroup r4, Node r5, Boolean r6, e r7);

    com.larus.business.markdown.api.d.a a(Context r1, int r2, Node r3, Node r4, Boolean r5, e r6);

    boolean a(Node r1);
}
