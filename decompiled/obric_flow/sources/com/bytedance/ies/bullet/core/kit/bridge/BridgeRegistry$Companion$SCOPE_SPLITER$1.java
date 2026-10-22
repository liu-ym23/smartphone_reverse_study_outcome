package com.bytedance.ies.bullet.core.kit.bridge;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", ST.IMPLICIT_ARG_NAME, "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class BridgeRegistry$Companion$SCOPE_SPLITER$1 extends Lambda implements Function1<String, List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BridgeRegistry$Companion$SCOPE_SPLITER$1 f5330a = null;

    static {
        f5330a = new BridgeRegistry$Companion$SCOPE_SPLITER$1();
    }

    public BridgeRegistry$Companion$SCOPE_SPLITER$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final List<? extends String> invoke(String r5) {
        String r10 = r5;
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        return StringsKt.K(r10, new String[]{"/"}, 0, 6);
    }
}
