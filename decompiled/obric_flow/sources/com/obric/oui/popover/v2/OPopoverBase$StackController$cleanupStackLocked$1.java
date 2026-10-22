package com.obric.oui.popover.v2;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/a;", "ref", "", "invoke", "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class OPopoverBase$StackController$cleanupStackLocked$1 extends Lambda implements Function1<WeakReference<a>, Boolean> {
    public static final OPopoverBase$StackController$cleanupStackLocked$1 INSTANCE = null;

    static {
        INSTANCE = new OPopoverBase$StackController$cleanupStackLocked$1();
    }

    public OPopoverBase$StackController$cleanupStackLocked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<a> r5) {
        return invoke2(r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(WeakReference<a> r5) {
        Intrinsics.checkNotNullParameter(r5, "ref");
        j0.A(r5.get());
        return true;
    }
}
