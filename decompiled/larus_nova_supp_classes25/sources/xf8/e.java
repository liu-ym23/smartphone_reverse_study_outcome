package xf8;

import com.larus.bmhome.chat.list.cell.lynx.LynxCell;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements Function0 {
    public /* synthetic */ e() {
    }

    public final Object invoke() {
        int r0 = LynxCell.l;
        return Boolean.valueOf(!AppHost.a.isOversea());
    }
}
