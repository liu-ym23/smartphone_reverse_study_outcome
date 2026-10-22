package com.lynx.debugrouter;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.debugrouter.app.MessageHandleResult;
import com.lynx.debugrouter.app.MessageHandler;
import com.lynx.debugrouter.base.usb.TemplateData;
import com.lynx.debugrouter.base.usb.TemplateFileSize;
import com.lynx.debugrouter.base.usb.USBTransTemplateUtil;
import com.lynx.debugrouter.log.LLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/lynx/debugrouter/ReceiveTemplateByUsbHandler;", "Lcom/lynx/debugrouter/app/MessageHandler;", "()V", "getName", NameKeys.UnloadStrategy_No_Strategy, "handle", "Lcom/lynx/debugrouter/app/MessageHandleResult;", LynxResourceModule.PARAMS_KEY, NameKeys.UnloadStrategy_No_Strategy, "Companion", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReceiveTemplateByUsbHandler implements MessageHandler {
    public static final Companion Companion = null;
    public static final String TAG = "USBTransTemplateReceive";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/lynx/debugrouter/ReceiveTemplateByUsbHandler$Companion;", NameKeys.UnloadStrategy_No_Strategy, "()V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ReceiveTemplateByUsbHandler() {
    }

    @Override // com.lynx.debugrouter.app.MessageHandler
    public String getName() {
        return "App.ReceiveTemplateByUsb";
    }

    @Override // com.lynx.debugrouter.app.MessageHandler
    public MessageHandleResult handle(Map<String, String> r9) {
        LLog.i(TAG, "ReceiveTemplateByUsbHandler handle");
        if (r9 == null) goto L7;
        String r0 = r9.get("requestId");
        if (r0 == null) goto L7;
        long r4 = CastLongProtector.parseLong(r0);
    L9:
        if (r4 != (-1)) goto L12;
        LLog.e(TAG, "reqId == " + r4);
        return new MessageHandleResult(-1, "illegal message: reqId == " + r4);
    L12:
        LLog.i(TAG, "Receive data reqId: " + r4);
        String r2 = null;
        if (r9 == null) goto L15;
        String r3 = r9.get("error");
    L16:
        if (r3 == null) goto L19;
        LLog.i(TAG, "Receive error: ".concat(r3));
        USBTransTemplateUtil.INSTANCE.receiveResponseSize(r4, new TemplateFileSize(-2, -2));
        return new MessageHandleResult();
    L19:
        if (r9 == null) goto L21;
        r2 = r9.get(LynxResourceModule.DATA_KEY);
    L21:
        if (r9 == null) goto L25;
        String r5 = r9.get("seqId");
        if (r5 == null) goto L25;
        int r6 = CastIntegerProtector.parseInt(r5);
    L26:
        if (r6 == (-1)) goto L44;
        if (r2 == null) goto L44;
        USBTransTemplateUtil r7 = USBTransTemplateUtil.INSTANCE;
        r7.receiveData(r4, new TemplateData(r6, r2));
        String r8 = r9.get("seq_count");
        if (r8 == null) goto L32;
        int r10 = CastIntegerProtector.parseInt(r8);
    L33:
        String r11 = r9.get("tem_file_len");
        if (r11 == null) goto L36;
        int r12 = CastIntegerProtector.parseInt(r11);
    L38:
        if (r10 == (-1)) goto L42;
        if (r12 == (-1)) goto L42;
        LLog.i(TAG, "Receive ResponseSize: seqCount = " + r10 + ", tem_file_len = " + r12);
        r7.receiveResponseSize(r4, new TemplateFileSize(r10, r12));
        return new MessageHandleResult();
    L42:
        LLog.e(TAG, "seqCount = " + r10 + ", tem_file_len = " + r12);
        return new MessageHandleResult(-1, "illegal seqCount or temLen");
    L36:
        r12 = -1;
        goto L38
    L32:
        r10 = -1;
    L44:
        LLog.e(TAG, "seqId = " + r6 + ", data == " + r2);
        return new MessageHandleResult(-1, "illegal message: seqId = " + r6 + ", data == " + r2);
    L25:
        r6 = -1;
        goto L26
    L15:
        r3 = null;
    L7:
        r4 = -1;
        goto L9
    }
}
