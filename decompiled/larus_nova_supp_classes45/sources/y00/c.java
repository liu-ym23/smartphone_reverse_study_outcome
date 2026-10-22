package y00;

import android.content.DialogInterface;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.verify.VerifyErrorExtra;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import v80.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ g a;

    public c(g r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        r3.dismiss();
        Object r5 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        VerifyErrorExtra.a r7 = VerifyErrorExtra.Companion;     // Catch: Throwable -> L8
        this.a.getClass();     // Catch: Throwable -> L8
        r7.getClass();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter("", "jsonString");     // Catch: Throwable -> L8
        VerifyErrorExtra r8 = (VerifyErrorExtra) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), "", VerifyErrorExtra.class);     // Catch: Throwable -> L8
        Boolean r0 = Boolean.TRUE;     // Catch: Throwable -> L8
        r8.setLiveAgreement(r0);     // Catch: Throwable -> L8
        r8.setLiveAnswer(r0);     // Catch: Throwable -> L8
        Map r9 = r8.toMap();     // Catch: Throwable -> L8
        if ((r9 instanceof HashMap) == true) goto L6;
        r9 = null;
    L6:
        Object r11 = Result.constructor-impl((HashMap) r9);     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r11) == true) goto L15;
        r5 = r11;
    L15:
        if (((HashMap) r5) != null) goto L17;
        new HashMap();
    L17:
        this.a.getClass();
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
