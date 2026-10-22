package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 4, 3})
final class MessageDisplayAppLogger$sendEvent$1 extends Lambda implements Function1<HashMap<String, String>, Unit> {
    public static final MessageDisplayAppLogger$sendEvent$1 INSTANCE = null;

    static {
        INSTANCE = new MessageDisplayAppLogger$sendEvent$1();
    }

    public MessageDisplayAppLogger$sendEvent$1() {
        super(1);
    }

    public final void invoke(HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((HashMap) r1);
        return Unit.INSTANCE;
    }
}
