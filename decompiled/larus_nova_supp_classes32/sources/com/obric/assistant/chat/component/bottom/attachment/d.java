package com.obric.assistant.chat.component.bottom.attachment;

import com.larus.platform.model.action.SuggestedActionScene;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ ConfigAttachmentPanelComponent a;

    public /* synthetic */ d(ConfigAttachmentPanelComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ConfigAttachmentPanelComponent r0 = this.a;
        int r1 = ConfigAttachmentPanelComponent.A;
        Intrinsics.checkNotNullParameter((SuggestedActionScene) r3, "it");
        return Boolean.valueOf(!r0.L2());
    }
}
