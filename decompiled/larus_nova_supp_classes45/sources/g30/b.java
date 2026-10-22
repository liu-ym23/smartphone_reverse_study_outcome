package g30;

import com.bytedance.android.live.browser.jsbridge.base.CreateChatGroupResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.h0;
import w20.n8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "createChatGroup")
public final class b extends h0<n8, CreateChatGroupResultModel> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final void invoke(Object r5, CallContext r6) {
        n8 r7 = (n8) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        ALogger.i("LiveCreateChatGroupMethod", "invoke");
        Integer r1 = r7.a();
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.intValue() != 1) goto L40;
        ALogger.i("LiveCreateChatGroupMethod", "invoke ktv group,type=" + r7.getType());
        Integer r0 = r7.getType();
        if (r0 != null) goto L11;
    L13:
        Integer r8 = r7.getType();
        if (r8 != null) goto L17;
        return;
    L17:
        if (r8.intValue() != 2) goto L42;
        List r9 = (List) IInteractService.linkMicSettings.getValue();
        Integer r11 = null;
        if (r9 == null) goto L33;
        Iterator r12 = r9.iterator();
    L22:
        if (r12.hasNext() == false) goto L29;
        Object r2 = r12.next();
        if (((y) r2).getKey() != 56) goto L26;
        boolean r3 = true;
    L27:
        if (r3 == false) goto L22;
    L30:
        y r4 = (y) r2;
        if (r4 == null) goto L33;
        r11 = Integer.valueOf(r4.getValue());
        goto L33
    L26:
        r3 = false;
        goto L27
    L29:
        r2 = null;
    L33:
        CreateChatGroupResultModel r13 = new CreateChatGroupResultModel();
        r13.a(String.valueOf(r11));
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r13);
        return;
    L42:
        return;
    L11:
        if (r0.intValue() != 1) goto L13;
        k.n(IKtvService.class).createKtvGroup(r6.getContext());
        return;
    }
}
