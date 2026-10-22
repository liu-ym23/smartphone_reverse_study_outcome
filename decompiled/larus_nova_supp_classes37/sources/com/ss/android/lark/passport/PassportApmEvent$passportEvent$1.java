package com.ss.android.lark.passport;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class PassportApmEvent$passportEvent$1 extends Lambda implements Function1<JSONObject, Unit> {
    public static final PassportApmEvent$passportEvent$1 INSTANCE = null;

    static {
        INSTANCE = new PassportApmEvent$passportEvent$1();
    }

    public PassportApmEvent$passportEvent$1() {
        super(1);
    }

    public final void invoke(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
