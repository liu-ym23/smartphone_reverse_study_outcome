package n8;

import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public final WsChannelMsg a(byte[] r11) {
        Frame r10 = Frame.ADAPTER.decode(r11);
        long r5 = ((Long) Wire.get(r10.seqid, Frame.DEFAULT_SEQID)).longValue();
        long r12 = ((Long) Wire.get(r10.logid, Frame.DEFAULT_LOGID)).longValue();
        int r13 = ((Integer) Wire.get(r10.service, Frame.DEFAULT_SERVICE)).intValue();
        int r14 = ((Integer) Wire.get(r10.method, Frame.DEFAULT_METHOD)).intValue();
        List r15 = (List) Wire.get(r10.headers, Collections.EMPTY_LIST);
        String r16 = (String) Wire.get(r10.payload_encoding, "");
        String r17 = (String) Wire.get(r10.payload_type, "");
        byte[] r18 = ((ByteString) Wire.get(r10.payload, Frame.DEFAULT_PAYLOAD)).toByteArray();
        WsChannelMsg r19 = new WsChannelMsg();
        r19.f4007b = r12;
        r19.f4006a = r5;
        r19.f4008c = r13;
        r19.d = r14;
        if (r15 != null) goto L5;
    L11:
        r19.f = r16;
        r19.g = r17;
        r19.f4009h = r18;
        return r19;
    L5:
        if (r15.size() < 0) goto L11;
        ArrayList r110 = new ArrayList();
        Iterator r20 = r15.iterator();
    L8:
        if (r20.hasNext() == false) goto L10;
        Frame.ExtendedEntry r21 = (Frame.ExtendedEntry) r20.next();
        WsChannelMsg.MsgHeader r22 = new WsChannelMsg.MsgHeader();
        r22.f4012a = (String) Wire.get(r21.key, "");
        r22.f4013b = (String) Wire.get(r21.value, "");
        r110.add(r22);
        goto L8
    L10:
        r19.e = r110;
        goto L11
    }

    public final byte[] b(WsChannelMsg r5) {
        if (r5.f4009h != null) goto L5;
        r5.f4009h = new byte[1];
    L5:
        byte[] r10 = r5.f4009h;
        if (r10 == null) goto L8;
        ByteString r11 = ByteString.of(r10);
    L9:
        Frame.Builder r12 = new Frame.Builder();
        r12.f3989b = Long.valueOf(r5.f4007b);
        r12.f3988a = Long.valueOf(r5.f4006a);
        r12.f3990c = Integer.valueOf(r5.f4008c);
        r12.f = r5.f;
        r12.g = r5.g;
        r12.f3991h = r11;
        r12.d = Integer.valueOf(r5.d);
        ArrayList r13 = r5.e;
        ArrayList r14 = new ArrayList();
        if (r13 == null) goto L16;
        Iterator r15 = r13.iterator();
    L13:
        if (r15.hasNext() == false) goto L16;
        WsChannelMsg.MsgHeader r16 = (WsChannelMsg.MsgHeader) r15.next();
        Frame.ExtendedEntry.Builder r17 = new Frame.ExtendedEntry.Builder();
        r17.f3993a = r16.f4012a;
        r17.f3994b = r16.f4013b;
        r14.add(r17.a());
    L16:
        if (r14.isEmpty() == true) goto L19;
        r12.a(r14);
    L19:
        return Frame.ADAPTER.encode(r12.a());
    L8:
        r11 = ByteString.EMPTY;
        goto L9
    }
}
