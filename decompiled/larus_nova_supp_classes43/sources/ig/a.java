package ig;

import android.text.TextUtils;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.model.ECMActionConditionData;
import java.util.Iterator;
import java.util.List;
import jj4.b;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static ECMActionConditionData.a a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        Lazy r0 = ECSettingKeys.a;
        int r1 = ECSettingKeys.f.a;
        int r11 = w0.a;
        Object r12 = (ECMActionConditionData) w0.b("{}", ECMActionConditionData.class);
        if (r12 == null) goto L17;
        int r13 = p.a;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L9
        b r15 = b.b;     // Catch: Throwable -> L9
        Object r16 = jj4.a.a("ec_commerce_action_condition_config", ECMActionConditionData.class, r12, false);     // Catch: Throwable -> L9
        if (r16 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L15:
        ECMActionConditionData r17 = (ECMActionConditionData) r16;
        if (r17 == null) goto L17;
    L25:
        if (r17 == null) goto L49;
        List r18 = r17.getRuleDataList();
        if (r18 == null) goto L50;
        Iterator r19 = r18.iterator();
        ECMActionConditionData.a r20 = null;
    L30:
        if (r19.hasNext() == false) goto L39;
        ECMActionConditionData.a r21 = (ECMActionConditionData.a) r19.next();
        if (r21 == null) goto L34;
        String r22 = r21.a();
    L36:
        if (TextUtils.equals(r22, r10) == false) goto L30;
        r20 = r21;
        goto L30
    L34:
        r22 = null;
        goto L36
    L39:
        return r20;
    L50:
        return null;
    L49:
        return null;
    L9:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Object r24 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r24) == true) goto L14;
        r12 = r24;
    L14:
        r16 = r12;
    L17:
        int r25 = p.a;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L20
        b r27 = b.b;     // Catch: Throwable -> L20
        Object r28 = jj4.a.a(" ec_commerce_action_condition_config", ECMActionConditionData.class, null, false);     // Catch: Throwable -> L20
    L24:
        r17 = (ECMActionConditionData) r28;
    L20:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r28) == false) goto L24;
        r28 = null;
        goto L24
    }
}
