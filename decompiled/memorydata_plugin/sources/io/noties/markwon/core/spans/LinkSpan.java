package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class LinkSpan extends URLSpan {
    private final Map<String, String> extra;
    private final String link;
    protected final io.noties.markwon.d resolver;
    private final io.noties.markwon.core.c theme;

    public LinkSpan(io.noties.markwon.core.c r3, String r4, io.noties.markwon.d r5) {
        this(r3, r4, null, (io.noties.markwon.d) ZeusTransformUtils.wrapperContextForParams(r5, io.noties.markwon.d.class, "com.obric.memorydata.plugin"));
    }

    public LinkSpan(io.noties.markwon.core.c r3, String r4, Map<String, String> r5, io.noties.markwon.d r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        io.noties.markwon.d r8 = (io.noties.markwon.d) ZeusTransformUtils.wrapperContextForParams(r6, io.noties.markwon.d.class, "com.obric.memorydata.plugin");
        super(r4);
        this.theme = r3;
        this.link = r4;
        if (r7 != null) goto L6;
        r7 = Collections.emptyMap();
    L6:
        this.extra = r7;
        this.resolver = r8;
    }

    public String getLink() {
        return this.link;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View r4) {
        if (ZeusTransformUtils.instanceOf(this.resolver, io.noties.markwon.e.class) == false) goto L5;
        ((io.noties.markwon.e) ZeusTransformUtils.preCheckCast(this.resolver, io.noties.markwon.e.class, "com.obric.memorydata.plugin")).a(r4, this.link, this.extra);
        return;
    L5:
        this.resolver.resolve(r4, this.link);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r1) {
        this.theme.a(r1);
    }
}
