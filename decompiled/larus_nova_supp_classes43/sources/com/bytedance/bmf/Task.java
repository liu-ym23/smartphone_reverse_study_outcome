package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class Task extends Ptr {
    public void free() {
        if (((Ptr) this).own == false) goto L6;
        API.bmf_task_free(((Ptr) this).ptr);
        return;
    }

    public int[] getInputStreamIds() {
        return API.bmf_task_get_input_stream_ids(((Ptr) this).ptr);
    }

    public int[] getOutputStreamIds() {
        return API.bmf_task_get_output_stream_ids(((Ptr) this).ptr);
    }

    public long timestamp() {
        return API.bmf_task_timestamp(((Ptr) this).ptr);
    }

    public Packet popPacketFromInputQueue(int r10) {
        return Packet.wrap(API.bmf_task_pop_packet_from_input_queue(((Ptr) this).ptr, r10), true);
    }

    public Packet popPacketFromOutputQueue(int r10) {
        return Packet.wrap(API.bmf_task_pop_packet_from_out_queue(((Ptr) this).ptr, r10), true);
    }

    public void setTimestamp(long r10) {
        API.bmf_task_set_timestamp(((Ptr) this).ptr, r10);
    }

    public Task(long r1, boolean r10) {
        ((Ptr) this).ptr = r1;
        ((Ptr) this).own = r10;
    }

    public static Task wrap(long r1, boolean r10) {
        return new Task(r1, r10);
    }

    public void fillInputPacket(int r10, Packet r11) {
        API.bmf_task_fill_input_packet(((Ptr) this).ptr, r10, r11.getPtr());
    }

    public void fillOutputPacket(int r10, Packet r11) {
        API.bmf_task_fill_output_packet(((Ptr) this).ptr, r10, r11.getPtr());
    }

    public Task(int r1, int[] r10, int[] r11) {
        ((Ptr) this).ptr = API.bmf_task_make(r1, r10, r11);
        ((Ptr) this).own = true;
    }
}
