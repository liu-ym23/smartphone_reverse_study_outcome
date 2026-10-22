package com.obric.matrix.sdk.push;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.push.PushSupporter;
import com.matrix.MatrixPushAdapter;
import java.util.List;
import jka.a;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e implements a {
    public final /* synthetic */ d a;
    public final /* synthetic */ b b;

    @Override // jka.a
    public final void onCallback(List<Object> r5) {
        kka.b.a(this.a.a, "on  register_channel method callback , params is " + r5);
        if (r5 == null) goto L20;
        MatrixPushAdapter.a r0 = this.b;
        Object r1 = ListProtector.get(r5, 0);
        if (r1 == null) goto L19;
        String r2 = (String) r1;
        Object r6 = ListProtector.get(r5, 1);
        if (r6 == null) goto L17;
        String r7 = (String) r6;
        if (TextUtils.equals(r2, "success") == false) goto L14;
        MatrixPushAdapter.a r3 = r0;
        r3.getClass();
        PushSupporter.logger().i("MatrixPushAdapter", "onSuccess,deviceToken:".concat(r7));
        if (TextUtils.isEmpty(r7) == true) goto L13;
        PushSupporter.thirdService().registerSenderSuccessAndUploadToken(r3.a, MatrixPushAdapter.getMatrixPushType(), r7);
    L15:
        Unit r8 = Unit.INSTANCE;
    L21:
        if (r8 != null) goto L24;
        this.b.a("102", "error when call push_service!");
        return;
    L24:
        return;
    L13:
        PushSupporter.monitor().monitorRegisterSenderFailed(r3.b, 102, "0", "token is null");
        goto L15
    L14:
        r0.a("103", r7);
        goto L15
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L20:
        r8 = null;
        goto L21
    }

    public e(d r1, MatrixPushAdapter.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
