package com.larus.bmhome.chat.stop;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PendingAppletActionCancellation$cancel$messageIds$2 extends FunctionReferenceImpl implements Function1<String, String> {
    public PendingAppletActionCancellation$cancel$messageIds$2(Object r8) {
        super(1, r8, PendingAppletActionCancellation.class, "normalizeIdentifier", "normalizeIdentifier(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    public final String invoke(String r3) {
        PendingAppletActionCancellation r0 = (PendingAppletActionCancellation) ((CallableReference) this).receiver;
        PendingAppletActionCancellation r1 = PendingAppletActionCancellation.a;
        r0.getClass();
        return PendingAppletActionCancellation.e(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
