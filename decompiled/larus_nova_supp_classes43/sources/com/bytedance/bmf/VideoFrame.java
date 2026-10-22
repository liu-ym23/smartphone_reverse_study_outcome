package com.bytedance.bmf;

import com.bytedance.hmp.ChannelFormat;
import com.bytedance.hmp.DeviceType;
import com.bytedance.hmp.EnumUtil;
import com.bytedance.hmp.Frame;
import com.bytedance.hmp.Image;
import com.bytedance.hmp.PixelInfo;
import com.bytedance.hmp.Ptr;
import com.bytedance.hmp.ScalarType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class VideoFrame extends Ptr {

    /* JADX INFO: renamed from: com.bytedance.bmf.VideoFrame$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmf$OpaqueDataKey = null;

        static {
            int[] r0 = new int[OpaqueDataKey.values().length];
            $SwitchMap$com$bytedance$bmf$OpaqueDataKey = r0;
            r0[OpaqueDataKey.kJsonParam.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public boolean defined() {
        return API.bmf_vf_defined(((Ptr) this).ptr);
    }

    public int deviceIndex() {
        return API.bmf_vf_device_index(((Ptr) this).ptr);
    }

    public DeviceType deviceType() {
        int r0 = API.bmf_vf_device_type(((Ptr) this).ptr);
        DeviceType r1 = DeviceType.kCPU;
        if (r0 != 0) goto L6;
        return r1;
    L6:
        if (r0 == 1) goto L8;
        return r1;
    L8:
        return DeviceType.kCUDA;
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(API.bmf_vf_dtype(((Ptr) this).ptr)));
    }

    public Frame frame() {
        return Frame.wrap(API.bmf_vf_frame(((Ptr) this).ptr), false);
    }

    public void free() {
        if (((Ptr) this).own == false) goto L6;
        API.bmf_vf_free(((Ptr) this).ptr);
        return;
    }

    public int height() {
        return API.bmf_vf_height(((Ptr) this).ptr);
    }

    public Image image() {
        return Image.wrap(API.bmf_vf_image(((Ptr) this).ptr), false);
    }

    public boolean isImage() {
        return API.bmf_vf_is_image(((Ptr) this).ptr);
    }

    public long pts() {
        return API.bmf_vf_pts(((Ptr) this).ptr);
    }

    public boolean ready() {
        return API.bmf_vf_ready(((Ptr) this).ptr);
    }

    public void synchronize() {
        API.bmf_vf_synchronize(((Ptr) this).ptr);
    }

    public Rational timeBase() {
        int[] r0 = API.bmf_vf_time_base(((Ptr) this).ptr);
        return new Rational(r0[0], r0[1]);
    }

    public int width() {
        return API.bmf_vf_width(((Ptr) this).ptr);
    }

    public VideoFrame(Frame r10) {
        ((Ptr) this).ptr = API.bmf_vf_from_frame(r10.getPtr());
        ((Ptr) this).own = true;
    }

    public void copyFrom(VideoFrame r10) {
        API.bmf_vf_copy_from(((Ptr) this).ptr, r10.getPtr());
    }

    public void copyProps(VideoFrame r10) {
        API.bmf_vf_copy_props(((Ptr) this).ptr, ((Ptr) r10).ptr);
    }

    public Object privateGet(OpaqueDataKey r10) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[r10.ordinal()] != 1) goto L7;
        String r11 = API.bmf_json_param_dump(API.bmf_vf_private_get_json_param(((Ptr) this).ptr));
        return GsonProtectorUtils.fromJson(new Gson(), r11, JsonObject.class);
    L7:
        throw new IllegalArgumentException("Unknown opaque data key in PrivateGet");
    }

    public void privateMerge(VideoFrame r10) {
        API.bmf_vf_private_merge(((Ptr) this).ptr, ((Ptr) r10).ptr);
    }

    public void record(boolean r10) {
        API.bmf_vf_record(((Ptr) this).ptr, r10);
    }

    public void setPts(long r10) {
        API.bmf_vf_set_pts(((Ptr) this).ptr, r10);
    }

    public void setTimeBase(Rational r10) {
        API.bmf_vf_set_time_base(((Ptr) this).ptr, r10.num, r10.den);
    }

    public VideoFrame to(ScalarType r10) {
        return wrap(API.bmf_vf_to_dtype(((Ptr) this).ptr, r10.getValue()), true);
    }

    public VideoFrame toFrame(PixelInfo r10) {
        return wrap(API.bmf_vf_to_frame(((Ptr) this).ptr, r10.getPtr()), true);
    }

    public VideoFrame(Image r10) {
        ((Ptr) this).ptr = API.bmf_vf_from_image(r10.getPtr());
        ((Ptr) this).own = true;
    }

    public VideoFrame(long r1, boolean r10) {
        ((Ptr) this).ptr = r1;
        ((Ptr) this).own = r10;
    }

    public static VideoFrame wrap(long r1, boolean r10) {
        return new VideoFrame(r1, r10);
    }

    public void privateAttach(OpaqueDataKey r10, Object r11) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[r10.ordinal()] != 1) goto L7;
        long r12 = API.bmf_json_param_parse(((JsonObject) r11).toString());
        API.bmf_vf_private_attach_json_param(((Ptr) this).ptr, r12);
        return;
    L7:
        throw new IllegalArgumentException("Unknown opaque data key in PrivateAttach");
    }

    public VideoFrame to(String r10, boolean r11) {
        return wrap(API.bmf_vf_to_device(((Ptr) this).ptr, r10, r11), true);
    }

    public VideoFrame toImage(ChannelFormat r10, boolean r11) {
        return wrap(API.bmf_vf_to_image(((Ptr) this).ptr, r10.getValue(), r11), true);
    }

    public VideoFrame(int r10, int r11, PixelInfo r12, String r13) {
        ((Ptr) this).ptr = API.bmf_vf_make_frame(r10, r11, r12.getPtr(), r13);
        ((Ptr) this).own = true;
    }

    public VideoFrame(int r10, int r11, int r12, ChannelFormat r13, ScalarType r14, String r15, boolean r16) {
        ((Ptr) this).ptr = API.bmf_vf_make_image(r10, r11, r12, r13.getValue(), r14.getValue(), r15, r16);
        ((Ptr) this).own = true;
    }
}
