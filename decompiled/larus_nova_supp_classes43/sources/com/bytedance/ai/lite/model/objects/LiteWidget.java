package com.bytedance.ai.lite.model.objects;

import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AppletResourceTool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/lite/model/objects/LiteWidget;", "Lcom/bytedance/ai/model/objects/Widget;", "packageName", "", "widgetId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "markInUse", "", "markOutOfUse", "ai-sdk-render-lite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiteWidget extends Widget {
    public LiteWidget() {
        this("", "");
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final void e() {
        this.H.incrementAndGet();
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final void g() {
        if (this.H.decrementAndGet() > 0) goto L8;
        String r0 = this.x;
        if (r0 == null) goto L9;
        AppletResourceTool.a.getClass();
        AppletResourceTool.a(r0);
        return;
    L9:
        return;
    }

    public LiteWidget(String r24, String r25) {
        Intrinsics.checkNotNullParameter(r24, "packageName");
        Intrinsics.checkNotNullParameter(r25, "widgetId");
        super(null, r24, 0, null, null, null, null, null, null, null, null, null, r25, null, null, null, false, 0, null, null, 1044477);
        this.x = AppletResourceTool.s(AppletResourceTool.a);
    }
}
