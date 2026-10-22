package com.larus.bmhome.bigimg;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AwemeImageFilter {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public AwemeImageFilter() {
    }

    public final void a(String r13, String r14, String r15, Function1<? super String, Unit> r16, Function1<? super Throwable, Unit> r17) {
        Intrinsics.checkNotNullParameter(r16, "onGranted");
        Intrinsics.checkNotNullParameter(r17, "onDeny");
        if (r13 == null) goto L21;
        boolean r0 = true;
        if (r14 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L21;
        if (r15 != null) goto L14;
    L17:
        if (r0 == true) goto L21;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AwemeImageFilter$checkImageAuthWithWatermark$1(this, r17, r13, r16, r14, r15, null), 3, null);
        return;
    L14:
        if (r15.length() == 0) goto L17;
        r0 = false;
        goto L17
    L7:
        if (r14.length() == 0) goto L10;
        r7 = false;
    L21:
        FLogger.a.e("AwemeImageFilter", "checkImageAuthWithWatermark called, request invalid, itemId = " + r13 + ", uri = " + r14 + ", sortId = " + r15);
        ImageAuthException.Companion.getClass();
        r17.invoke(new ImageAuthException(-2));
    }
}
