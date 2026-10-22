package a2;

import android.text.TextUtils;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
class c implements a {
    c() {
    }

    private static String c(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        StringBuilder r11 = new StringBuilder(r10);
        int r12 = r11.indexOf("ttnet;");
        if (r12 >= 0) goto L8;
        return null;
    L8:
        r11.insert(r12 + 6, "recv_time=" + System.currentTimeMillis() + ";");
        return r11.toString();
    }

    @Override // a2.a
    public WsChannelMsg a(byte[] r13) {
        Frame r12 = Frame.ADAPTER.decode(r13);
        long r10 = ((Long) Wire.get(r12.seqid, Frame.DEFAULT_SEQID)).longValue();
        long r11 = ((Long) Wire.get(r12.logid, Frame.DEFAULT_LOGID)).longValue();
        int r14 = ((Integer) Wire.get(r12.service, Frame.DEFAULT_SERVICE)).intValue();
        int r15 = ((Integer) Wire.get(r12.method, Frame.DEFAULT_METHOD)).intValue();
        List r16 = (List) Wire.get(r12.headers, Collections.emptyList());
        String r17 = (String) Wire.get(r12.payload_encoding, "");
        String r18 = (String) Wire.get(r12.payload_type, "");
        byte[] r19 = ((ByteString) Wire.get(r12.payload, Frame.DEFAULT_PAYLOAD)).toByteArray();
        String r110 = (String) Wire.get(r12.serverTiming, "");
        String r111 = (String) Wire.get(r12.msgId, "");
        WsChannelMsg r112 = new WsChannelMsg();
        r112.setLogId(r11);
        r112.setSeqId(r10);
        r112.setService(r14);
        r112.setMethod(r15);
        if (r16 != null) goto L5;
    L11:
        r112.setPayloadEncoding(r17);
        r112.setPayloadType(r18);
        r112.setPayload(r19);
        String r113 = c(r110);
        if (TextUtils.isEmpty(r113) == true) goto L14;
        r110 = r113;
    L14:
        r112.setServerTiming(r110);
        r112.setMsgId(r111);
        return r112;
    L5:
        if (r16.size() < 0) goto L11;
        ArrayList r114 = new ArrayList();
        Iterator r20 = r16.iterator();
    L8:
        if (r20.hasNext() == false) goto L10;
        Frame.ExtendedEntry r21 = (Frame.ExtendedEntry) r20.next();
        WsChannelMsg.MsgHeader r22 = new WsChannelMsg.MsgHeader();
        r22.setKey((String) Wire.get(r21.key, ""));
        r22.setValue((String) Wire.get(r21.value, ""));
        r114.add(r22);
        goto L8
    L10:
        r112.setMsgHeaders(r114);
        goto L11
    }

    @Override // a2.a
    public byte[] b(WsChannelMsg r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.getPayload() == null) goto L8;
        ByteString r11 = ByteString.of(r10.getPayload());
    L9:
        Frame.a r12 = new Frame.a().c(Long.valueOf(r10.getLogId())).j(Long.valueOf(r10.getSeqId())).l(Integer.valueOf(r10.getService())).h(r10.getPayloadEncoding()).i(r10.getPayloadType()).g(r11).e(Integer.valueOf(r10.getMethod()));
        List<WsChannelMsg.MsgHeader> r13 = r10.getMsgHeaders();
        ArrayList r14 = new ArrayList();
        if (r13 == null) goto L16;
        Iterator<WsChannelMsg.MsgHeader> r15 = r13.iterator();
    L13:
        if (r15.hasNext() == false) goto L16;
        WsChannelMsg.MsgHeader r16 = r15.next();
        r14.add(new Frame.ExtendedEntry.a().b(r16.getKey()).c(r16.getValue()).a());
    L16:
        if (r14.isEmpty() == true) goto L19;
        r12.b(r14);
    L19:
        return Frame.ADAPTER.encode(r12.a());
    L8:
        r11 = ByteString.EMPTY;
        goto L9
    }
}
