package com.bytedance.bmf;

import com.bytedance.hmp.EnumUtil;
import com.bytedance.hmp.Ptr;
import com.bytedance.hmp.ScalarType;
import com.bytedance.hmp.Tensor;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AudioFrame extends Ptr {

    /* JADX INFO: renamed from: com.bytedance.bmf.AudioFrame$1, reason: invalid class name */
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
        return API.bmf_af_defined(((Ptr) this).ptr);
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(API.bmf_af_dtype(((Ptr) this).ptr)));
    }

    public void free() {
        if (((Ptr) this).own == false) goto L6;
        API.bmf_af_free(((Ptr) this).ptr);
        return;
    }

    public int nchannels() {
        return API.bmf_af_nchannels(((Ptr) this).ptr);
    }

    public int nplanes() {
        return API.bmf_af_nplanes(((Ptr) this).ptr);
    }

    public int nsamples() {
        return API.bmf_af_nsamples(((Ptr) this).ptr);
    }

    public boolean planer() {
        return API.bmf_af_planer(((Ptr) this).ptr);
    }

    public Tensor[] planes() {
        long[] r0 = API.bmf_af_planes(((Ptr) this).ptr);
        int r1 = r0.length;
        Tensor[] r10 = new Tensor[r1];
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L5;
        r10[r11] = Tensor.wrap(r0[r11], true);
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    public long pts() {
        return API.bmf_af_pts(((Ptr) this).ptr);
    }

    public float sampleRate() {
        return API.bmf_af_sample_rate(((Ptr) this).ptr);
    }

    public Rational timeBase() {
        int[] r0 = API.bmf_af_time_base(((Ptr) this).ptr);
        return new Rational(r0[0], r0[1]);
    }

    public void copyProps(AudioFrame r10) {
        API.bmf_af_copy_props(((Ptr) this).ptr, ((Ptr) r10).ptr);
    }

    public Tensor plane(int r10) {
        return Tensor.wrap(API.bmf_af_plane(((Ptr) this).ptr, r10), true);
    }

    public Object privateGet(OpaqueDataKey r10) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[r10.ordinal()] != 1) goto L7;
        String r11 = API.bmf_json_param_dump(API.bmf_af_private_get_json_param(((Ptr) this).ptr));
        return GsonProtectorUtils.fromJson(new Gson(), r11, JsonObject.class);
    L7:
        throw new IllegalArgumentException("Unknown opaque data key in PrivateGet");
    }

    public void privateMerge(AudioFrame r10) {
        API.bmf_af_private_merge(((Ptr) this).ptr, ((Ptr) r10).ptr);
    }

    public void setPts(long r10) {
        API.bmf_af_set_pts(((Ptr) this).ptr, r10);
    }

    public void setSampleRate(float r10) {
        API.bmf_af_set_sample_rate(((Ptr) this).ptr, r10);
    }

    public void setTimeBase(Rational r10) {
        API.bmf_af_set_time_base(((Ptr) this).ptr, r10.num, r10.den);
    }

    public AudioFrame(long r1, boolean r10) {
        ((Ptr) this).ptr = r1;
        ((Ptr) this).own = r10;
    }

    public static AudioFrame wrap(long r1, boolean r10) {
        return new AudioFrame(r1, r10);
    }

    public void privateAttach(OpaqueDataKey r10, Object r11) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[r10.ordinal()] != 1) goto L7;
        long r12 = API.bmf_json_param_parse(((JsonObject) r11).toString());
        API.bmf_af_private_attach_json_param(((Ptr) this).ptr, r12);
        return;
    L7:
        throw new IllegalArgumentException("Unknown opaque data key in PrivateAttach");
    }

    public AudioFrame(Tensor[] r10, int r11, int r12, boolean r13) {
        int r0 = r10.length;
        long[] r1 = new long[r0];
        int r14 = 0;
    L3:
        if (r14 >= r0) goto L5;
        r1[r14] = r10[r14].getPtr();
        r14 = r14 + 1;
        goto L3
    L5:
        ((Ptr) this).ptr = API.bmf_af_make_from_data(r1, r11, r12, r13);
        ((Ptr) this).own = true;
    }

    public AudioFrame(int r1, int r10, boolean r11, ScalarType r12) {
        ((Ptr) this).ptr = API.bmf_af_make(r1, r10, r11, r12.getValue());
        ((Ptr) this).own = true;
    }
}
