package com.obric.oui.popover.v2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/OPopoverModal;", "invoke", "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OPopoverModal$Companion$registerShowingPopover$1 extends Lambda implements Function1<WeakReference<g>, Boolean> {
    final /* synthetic */ g $popover;

    OPopoverModal$Companion$registerShowingPopover$1(g r1) {
        this.$popover = r1;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(WeakReference<g> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (r2.get() != this.$popover) goto L5;
        boolean r1 = true;
    L7:
        return Boolean.valueOf(r1);
    L5:
        r1 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(WeakReference<g> r3) {
        return invoke2((WeakReference) ZeusTransformUtils.preCheckCast(r3, WeakReference.class, "com.obric.memorydata.plugin"));
    }
}
