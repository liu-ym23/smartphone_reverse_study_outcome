package io.noties.markwon.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.ListMarginInfo;
import io.noties.markwon.core.spans.o;
import io.noties.markwon.t;
import io.noties.markwon.w;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
public class j implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ListMarginInfo f16420a;

    public j() {
        this.f16420a = null;
    }

    private int a(t r4) {
        t r3 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(r3.a(CoreProps.c, -1), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r5 == 0) goto L7;
        if (r5 == (-1)) goto L7;
        return r5;
    L7:
        return ((Integer) ZeusTransformUtils.preCheckCast(CoreProps.f16409b.b(r3), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public int a(io.noties.markwon.i r6, t r7, ListMarginInfo r8) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin");
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r5.a(CoreProps.f16409b, -1), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Exception -> L14
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(r5.a(CoreProps.c, -1), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Exception -> L14
        if (r1 == (-1)) goto L16;
        if (r9 == (-1)) goto L17;
        if (r8 == null) goto L9;
        int r10 = r8.getListMargin();     // Catch: Exception -> L14
    L10:
        if (r1 != 0) goto L18;
        if (r9 != 0) goto L13;
        return 0;
    L13:
        return r9 * r10;
    L18:
        return 0;
    L9:
        r10 = r6.a().a();     // Catch: Exception -> L14
        goto L10
    L17:
        return 0;
    L16:
        return 0;
    L20:
        return 0;
    }

    @Override // io.noties.markwon.w
    public Object a(io.noties.markwon.i r9, t r10) {
        t r11 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        int r6 = a(r9, r11, this.f16420a);
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(CoreProps.e.b(r11), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (CoreProps.ListItemType.BULLET != CoreProps.f16408a.b(r11)) goto L6;
        return new io.noties.markwon.core.spans.c(r9.a(), this.f16420a, a(r11), r6, r7);
    L6:
        return new o(r9.a(), this.f16420a, CoreProps.d.b(r11) + "." + Typography.nbsp, r6, r7);
    }
}
