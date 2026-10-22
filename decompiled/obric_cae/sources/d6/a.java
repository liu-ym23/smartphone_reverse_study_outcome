package d6;

import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.squareup.wire.Wire;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jf.g;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final WsChannelMsg a(byte[] r11) {
        Frame r10 = Frame.ADAPTER.decode(r11);
        long r8 = ((Long) Wire.get(r10.seqid, Frame.DEFAULT_SEQID)).longValue();
        long r12 = ((Long) Wire.get(r10.logid, Frame.DEFAULT_LOGID)).longValue();
        int r13 = ((Integer) Wire.get(r10.service, Frame.DEFAULT_SERVICE)).intValue();
        int r14 = ((Integer) Wire.get(r10.method, Frame.DEFAULT_METHOD)).intValue();
        List r15 = (List) Wire.get(r10.headers, Collections.emptyList());
        String r16 = (String) Wire.get(r10.payload_encoding, "");
        String r17 = (String) Wire.get(r10.payload_type, "");
        byte[] r18 = ((g) Wire.get(r10.payload, Frame.DEFAULT_PAYLOAD)).o();
        WsChannelMsg r19 = new WsChannelMsg();
        r19.f3905b = r12;
        r19.f3904a = r8;
        r19.f3906m = r13;
        r19.f3907n = r14;
        if (r15 != null) goto L5;
    L11:
        r19.f3909p = r16;
        r19.f3910q = r17;
        r19.f3911r = r18;
        return r19;
    L5:
        if (r15.size() < 0) goto L11;
        ArrayList r110 = new ArrayList();
        Iterator r20 = r15.iterator();
    L8:
        if (r20.hasNext() == false) goto L10;
        Frame.b r21 = (Frame.b) r20.next();
        WsChannelMsg.MsgHeader r22 = new WsChannelMsg.MsgHeader();
        r22.f3914a = (String) Wire.get(r21.f3879a, "");
        r22.f3915b = (String) Wire.get(r21.f3880b, "");
        r110.add(r22);
        goto L8
    L10:
        r19.f3908o = r110;
        goto L11
    }

    public final byte[] b(WsChannelMsg r8) {
        if (r8.f3911r != null) goto L5;
        r8.f3911r = new byte[1];
    L5:
        byte[] r10 = r8.f3911r;
        if (r10 == null) goto L10;
        if (r10 != null) goto L9;
        r8.f3911r = new byte[1];
    L9:
        g r11 = g.g(r8.f3911r);
    L11:
        Frame.a r12 = new Frame.a();
        r12.f3871b = Long.valueOf(r8.f3905b);
        r12.f3870a = Long.valueOf(r8.f3904a);
        r12.f3872c = Integer.valueOf(r8.f3906m);
        r12.f3875f = r8.f3909p;
        r12.f3876g = r8.f3910q;
        r12.f3877h = r11;
        r12.f3873d = Integer.valueOf(r8.f3907n);
        List<WsChannelMsg.MsgHeader> r13 = r8.f3908o;
        ArrayList r14 = new ArrayList();
        if (r13 == null) goto L18;
        Iterator<WsChannelMsg.MsgHeader> r15 = r13.iterator();
    L15:
        if (r15.hasNext() == false) goto L18;
        WsChannelMsg.MsgHeader r16 = r15.next();
        Frame.b.a r17 = new Frame.b.a();
        r17.f3881a = r16.f3914a;
        r17.f3882b = r16.f3915b;
        r14.add(r17.a());
    L18:
        if (r14.isEmpty() == true) goto L21;
        Internal.checkElementsNotNull(r14);
        r12.f3874e = r14;
    L21:
        return Frame.ADAPTER.encode(r12.a());
    L10:
        r11 = g.f8841o;
        goto L11
    }
}
