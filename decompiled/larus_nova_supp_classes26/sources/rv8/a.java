package rv8;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import com.larus.business.debug.base.DebugBaseServiceImpl;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a implements DialogInterface.OnClickListener {
    public final /* synthetic */ DebugBaseServiceImpl a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(DebugBaseServiceImpl r1, Context r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        DebugBaseServiceImpl r6 = this.a;
        Context r0 = this.b;
        String r1 = this.c;
        r6.getClass();
        ClipData r7 = ClipData.newPlainText("chat_message", r1);
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L5;
        r2.d0();
        i1 r3 = i1.a;
        Intrinsics.checkNotNull(r7);
        r3.i(r0, r7, "bpea-debug-tool");
    L5:
        s.a.getClass();
        s.o(r0, 2131907398, false);
        r4.dismiss();
    }
}
