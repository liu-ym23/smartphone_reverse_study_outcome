package com.obric.oui.popover.v2;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/b;", ST.IMPLICIT_ARG_NAME, "", "invoke", "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class OPopoverModal$Companion$unregisterShowingPopover$1 extends Lambda implements Function1<WeakReference<b>, Boolean> {
    final /* synthetic */ b $popover;

    public OPopoverModal$Companion$unregisterShowingPopover$1(b r5) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(WeakReference<b> r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        if (r5.get() != null) goto L5;
        boolean r10 = true;
    L7:
        return Boolean.valueOf(r10);
    L5:
        r10 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<b> r5) {
        return invoke2(r5);
    }
}
