package com.obric.oui.popover.v2;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/a;", ST.IMPLICIT_ARG_NAME, "", "invoke", "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class OPopoverBase$StackController$onShow$1 extends Lambda implements Function1<WeakReference<a>, Boolean> {
    final /* synthetic */ a $current;

    public OPopoverBase$StackController$onShow$1(a r5) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(WeakReference<a> r5) {
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
    public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<a> r5) {
        return invoke2(r5);
    }
}
