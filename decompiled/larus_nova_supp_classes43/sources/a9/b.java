package a9;

import android.content.Context;
import com.bytedance.android.annie.bridge.method.LoadingMethods$HideLoadingMethod;
import com.bytedance.android.annie.bridge.method.LoadingMethods$ShowLoadingMethod;
import com.bytedance.android.annie.bridge.method.b1;
import e7.x0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements h {
    public b() {
    }

    @Override // a9.h
    public final void B0(b1 r10) {
        Intrinsics.checkNotNullParameter(r10, "modalBuilder");
    }

    @Override // a9.h
    public final void C(Context r10, v7.b r11, x0 r12, LoadingMethods$ShowLoadingMethod.a r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "showLoadingMethodParams");
        Intrinsics.checkNotNullParameter(r13, "callback");
        String r14 = r12.a();
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        if (r11 == null) goto L7;
        r11.e(r14);
    L7:
        if (r11 == null) goto L9;
        r11.d();
    L9:
        r13.a();
    }

    @Override // a9.h
    public final void E1(Context r10, v7.b r11, JSONObject r12, LoadingMethods$HideLoadingMethod.a r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "showLoadingMethodParams");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (r11 == null) goto L5;
        r11.c();
    L5:
        r13.a();
    }
}
