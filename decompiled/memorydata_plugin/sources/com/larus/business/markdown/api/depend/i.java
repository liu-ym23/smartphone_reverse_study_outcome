package com.larus.business.markdown.api.depend;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "Lio/noties/markwon/LinkResolver;", "enableLinkStyle", "", "link", "", "needUnderline", "resolve", "", "view", "Landroid/view/View;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface i extends io.noties.markwon.d {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static void a(i r2, View r3, String r4, boolean r5) {
            i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "link");
            if (r5 == false) goto L6;
            r6.resolve(r3, r4);
            return;
        }
    }

    void a(View r1, String r2, boolean r3);

    boolean a(String r1);

    boolean b(String r1);

    @Override // io.noties.markwon.d
    void resolve(View r1, String r2);
}
