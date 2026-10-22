package tv8;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public /* synthetic */ e(Context r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        Context r6 = this.a;
        ClipData r0 = ClipData.newPlainText("chat_message", this.b);
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L5;
        r1.d0();
        i1 r2 = i1.a;
        Intrinsics.checkNotNull(r0);
        r2.i(r6, r0, "bpea-debug-tool");
    L5:
        s.a.getClass();
        s.o(r6, 2131907398, false);
        r4.dismiss();
    }
}
