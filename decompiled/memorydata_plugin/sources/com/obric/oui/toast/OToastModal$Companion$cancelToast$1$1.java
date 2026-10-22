package com.obric.oui.toast;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/oui/toast/OToastModal$ToastRecord;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/obric/oui/toast/OToastModal$ToastRecord;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OToastModal$Companion$cancelToast$1$1 extends Lambda implements Function1<b.C0789b, Boolean> {
    final /* synthetic */ b $toast;

    OToastModal$Companion$cancelToast$1$1(b r1) {
        this.$toast = r1;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(b.C0789b r1) {
        if (r1.a() != this.$toast) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(b.C0789b r3) {
        return invoke2((b.C0789b) ZeusTransformUtils.preCheckCast(r3, b.C0789b.class, "com.obric.memorydata.plugin"));
    }
}
