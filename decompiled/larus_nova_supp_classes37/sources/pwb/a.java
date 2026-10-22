package pwb;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.qrcode.api.IQRCodeResultHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKUserScope
public final class a implements owb.a {
    public static final List<IQRCodeResultHandler> a = null;

    /* JADX INFO: renamed from: pwb.a$a, reason: collision with other inner class name */
    public static final class C0177a {
    }

    @Inject
    public a() {
    }

    static {
        ArrayList r0 = new ArrayList();
        r0.add(new qwb.a());
        a = r0;
    }

    @Override // owb.a
    public final boolean L(String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "result");
        Intrinsics.checkNotNullParameter(r4, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Iterator r1 = ((ArrayList) a).iterator();     // Catch: Throwable -> L12
    L5:
        if (r1.hasNext() == false) goto L10;
        if (((IQRCodeResultHandler) r1.next()).a(r3, r4) == false) goto L5;
        return true;
    L10:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L24;
        Log.e("OpenFeishuQRCodeHandlerImpl", "handleFeishuQrCode throw exception", r6);
        return false;
    L24:
        return false;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
