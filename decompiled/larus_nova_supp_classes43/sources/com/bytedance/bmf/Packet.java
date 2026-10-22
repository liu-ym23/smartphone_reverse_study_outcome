package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class Packet extends Ptr {
    public boolean defined() {
        if (API.bmf_packet_defined(((Ptr) this).ptr) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void free() {
        if (((Ptr) this).own == false) goto L6;
        API.bmf_packet_free(((Ptr) this).ptr);
        return;
    }

    public long timestamp() {
        return API.bmf_packet_timestamp(((Ptr) this).ptr);
    }

    public static Packet generateEofPacket() {
        return wrap(API.bmf_packet_generate_eof_packet(), true);
    }

    public static Packet generateEosPacket() {
        return wrap(API.bmf_packet_generate_eos_packet(), true);
    }

    public Packet(Object r10) {
        if (r10 != null) goto L5;
        ((Ptr) this).ptr = 0;
        ((Ptr) this).own = false;
        return;
    L5:
        Class<?> r1 = r10.getClass();
        if (r1 != VideoFrame.class) goto L9;
        ((Ptr) this).ptr = API.bmf_packet_from_videoframe(((VideoFrame) r10).getPtr());
        ((Ptr) this).own = true;
        return;
    L9:
        if (r1 != Packet.class) goto L12;
        ((Ptr) this).ptr = ((Packet) r10).getPtr();
        ((Ptr) this).own = false;
        return;
    L12:
        if (r1 != JsonParam.class) goto L14;
        ((Ptr) this).ptr = API.bmf_packet_from_json_param(((JsonParam) r10).getPtr());
        ((Ptr) this).own = true;
        return;
    L14:
        ((Ptr) this).ptr = API.bmf_packet_from_json_str(GsonProtectorUtils.toJson(new Gson(), r10));
        ((Ptr) this).own = true;
    }

    public Object get(Class r10) throws ClassCastException {
        if (r10 != VideoFrame.class) goto L7;
        return VideoFrame.wrap(API.bmf_packet_get_videoframe(((Ptr) this).ptr), true);
    L7:
        if (r10 != JsonParam.class) goto L11;
        return JsonParam.wrap(API.bmf_packet_get_json_param(((Ptr) this).ptr), true);
    L11:
        if (API.bmf_packet_is_json_param(((Ptr) this).ptr) == false) goto L15;
        String r0 = API.bmf_packet_to_json_str(((Ptr) this).ptr);
        return GsonProtectorUtils.fromJson(new Gson(), r0, r10);
    L15:
        throw new ClassCastException(r10.getName());
    }

    public boolean is(Class r10) {
        if (r10 != VideoFrame.class) goto L7;
        return API.bmf_packet_is_videoframe(((Ptr) this).ptr);
    L7:
        return API.bmf_packet_is_json_param(((Ptr) this).ptr);
    }

    public void setTimestamp(long r10) {
        API.bmf_packet_set_timestamp(((Ptr) this).ptr, r10);
    }

    public Packet(long r1, boolean r10) {
        ((Ptr) this).ptr = r1;
        ((Ptr) this).own = r10;
    }

    public static Packet wrap(long r1, boolean r10) {
        return new Packet(r1, r10);
    }
}
