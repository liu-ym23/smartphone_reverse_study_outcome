package com.bytedance.bmf;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class API {
    private static final String LIBBMFMODULESDK = "_jbmf";

    public API() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static native void bmf_af_copy_props(long r0, long r10);

    public static native boolean bmf_af_defined(long r0);

    public static native int bmf_af_dtype(long r0);

    public static native void bmf_af_free(long r0);

    public static native long bmf_af_make(int r0, int r1, boolean r10, int r11);

    public static native long bmf_af_make_from_data(long[] r0, int r1, int r10, boolean r11);

    public static native int bmf_af_nchannels(long r0);

    public static native int bmf_af_nplanes(long r0);

    public static native int bmf_af_nsamples(long r0);

    public static native long bmf_af_plane(long r0, int r10);

    public static native boolean bmf_af_planer(long r0);

    public static native long[] bmf_af_planes(long r0);

    public static native void bmf_af_private_attach_json_param(long r0, long r10);

    public static native long bmf_af_private_get_json_param(long r0);

    public static native void bmf_af_private_merge(long r0, long r10);

    public static native long bmf_af_pts(long r0);

    public static native float bmf_af_sample_rate(long r0);

    public static native void bmf_af_set_pts(long r0, long r10);

    public static native void bmf_af_set_sample_rate(long r0, float r10);

    public static native void bmf_af_set_time_base(long r0, int r10, int r11);

    public static native int[] bmf_af_time_base(long r0);

    public static native String bmf_json_dump(long r0);

    public static native boolean bmf_json_erase(long r0, String r10);

    public static native void bmf_json_free(long r0);

    public static native double bmf_json_get_double(long r0, String r10);

    public static native double[] bmf_json_get_double_list(long r0, String r10);

    public static native float bmf_json_get_float(long r0, String r10);

    public static native float[] bmf_json_get_float_list(long r0, String r10);

    public static native int bmf_json_get_int(long r0, String r10);

    public static native int[] bmf_json_get_int_list(long r0, String r10);

    public static native long bmf_json_get_long(long r0, String r10);

    public static native String bmf_json_get_string(long r0, String r10);

    public static native String[] bmf_json_get_string_list(long r0, String r10);

    public static native boolean bmf_json_has_key(long r0, String r10);

    public static native long bmf_json_make();

    public static native String bmf_json_param_dump(long r0);

    public static native long bmf_json_param_parse(String r0);

    public static native void bmf_json_set_double(long r0, String r10, double r11);

    public static native void bmf_json_set_double_list(long r0, String r10, double[] r11);

    public static native void bmf_json_set_float(long r0, String r10, float r11);

    public static native void bmf_json_set_float_list(long r0, String r10, float[] r11);

    public static native void bmf_json_set_int(long r0, String r10, int r11);

    public static native void bmf_json_set_int_list(long r0, String r10, int[] r11);

    public static native void bmf_json_set_long(long r0, String r10, long r11);

    public static native void bmf_json_set_string(long r0, String r10, String r11);

    public static native void bmf_json_set_string_list(long r0, String r10, String[] r11);

    public static native long[] bmf_module_functor_call(long r0, long[] r10);

    public static native void bmf_module_functor_execute(long r0, long[] r10, boolean r11);

    public static native long[] bmf_module_functor_fetch(long r0, int r10);

    public static native void bmf_module_functor_free(long r0);

    public static native long bmf_module_functor_make(String r0, String r1, String r10, String r11, String r12, int r13, int r14, int r15);

    public static native int bmf_packet_defined(long r0);

    public static native void bmf_packet_free(long r0);

    public static native long bmf_packet_from_json_param(long r0);

    public static native long bmf_packet_from_json_str(String r0);

    public static native long bmf_packet_from_videoframe(long r0);

    public static native long bmf_packet_generate_eof_packet();

    public static native long bmf_packet_generate_eos_packet();

    public static native long bmf_packet_get_json_param(long r0);

    public static native long bmf_packet_get_videoframe(long r0);

    public static native boolean bmf_packet_is_json_param(long r0);

    public static native boolean bmf_packet_is_videoframe(long r0);

    public static native void bmf_packet_set_timestamp(long r0, long r10);

    public static native long bmf_packet_timestamp(long r0);

    public static native String bmf_packet_to_json_str(long r0);

    public static native void bmf_task_fill_input_packet(long r0, int r10, long r11);

    public static native void bmf_task_fill_output_packet(long r0, int r10, long r11);

    public static native void bmf_task_free(long r0);

    public static native int[] bmf_task_get_input_stream_ids(long r0);

    public static native int[] bmf_task_get_output_stream_ids(long r0);

    public static native long bmf_task_make(int r0, int[] r1, int[] r10);

    public static native long bmf_task_pop_packet_from_input_queue(long r0, int r10);

    public static native long bmf_task_pop_packet_from_out_queue(long r0, int r10);

    public static native void bmf_task_set_timestamp(long r0, long r10);

    public static native long bmf_task_timestamp(long r0);

    public static native void bmf_vf_copy_from(long r0, long r10);

    public static native void bmf_vf_copy_props(long r0, long r10);

    public static native boolean bmf_vf_defined(long r0);

    public static native int bmf_vf_device_index(long r0);

    public static native int bmf_vf_device_type(long r0);

    public static native int bmf_vf_dtype(long r0);

    public static native long bmf_vf_frame(long r0);

    public static native void bmf_vf_free(long r0);

    public static native long bmf_vf_from_frame(long r0);

    public static native long bmf_vf_from_image(long r0);

    public static native int bmf_vf_height(long r0);

    public static native long bmf_vf_image(long r0);

    public static native boolean bmf_vf_is_image(long r0);

    public static native long bmf_vf_make_frame(int r0, int r1, long r10, String r11);

    public static native long bmf_vf_make_image(int r0, int r1, int r10, int r11, int r12, String r13, boolean r14);

    public static native void bmf_vf_private_attach_json_param(long r0, long r10);

    public static native long bmf_vf_private_get_json_param(long r0);

    public static native void bmf_vf_private_merge(long r0, long r10);

    public static native long bmf_vf_pts(long r0);

    public static native boolean bmf_vf_ready(long r0);

    public static native void bmf_vf_record(long r0, boolean r10);

    public static native void bmf_vf_set_pts(long r0, long r10);

    public static native void bmf_vf_set_time_base(long r0, int r10, int r11);

    public static native void bmf_vf_synchronize(long r0);

    public static native int[] bmf_vf_time_base(long r0);

    public static native long bmf_vf_to_device(long r0, String r10, boolean r11);

    public static native long bmf_vf_to_dtype(long r0, int r10);

    public static native long bmf_vf_to_frame(long r0, long r10);

    public static native long bmf_vf_to_image(long r0, int r10, boolean r11);

    public static native int bmf_vf_width(long r0);

    static {
        INVOKESTATIC_com_bytedance_bmf_API_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(LIBBMFMODULESDK);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_bmf_API_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r10) {
        Intrinsics.checkNotNullParameter(r10, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r10);
        a.c(r10);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r10);
    }
}
