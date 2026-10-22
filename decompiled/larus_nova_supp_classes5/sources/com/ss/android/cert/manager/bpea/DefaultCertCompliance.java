package com.ss.android.cert.manager.bpea;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioRecord;
import androidx.core.app.ActivityCompat;
import com.bytedance.permissions.annotation.PermissionsRequest;
import com.ss.android.cert.manager.ablity.ICertCompliance;
import f06.b;
import f06.c;
import f06.d;
import fna.g;
import hna.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DefaultCertCompliance implements ICertCompliance {
    public DefaultCertCompliance() {
    }

    private static Camera com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_open() {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        d r11 = r8.b(100100, "android/hardware/Camera", "open", Camera.class, r9, "android.hardware.Camera", r10);
        if (r11.a == false) goto L6;
        r8.a(100100, "android/hardware/Camera", "open", Camera.class, r9, null, r10, false);
        return (Camera) r11.b;
    L6:
        Camera r12 = Camera.open();
        r8.a(100100, "android/hardware/Camera", "open", Camera.class, r9, r12, r10, true);
        return r12;
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public Camera openCamera() {
        return com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_open();
    }

    public static void INVOKEVIRTUAL_com_ss_android_cert_manager_bpea_DefaultCertCompliance_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(AudioRecord r1) {
        if (g.d() == true) goto L6;
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_startRecording(r1);
        return;
    L6:
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_startRecording(r1);
        if ((r1 instanceof AudioRecord) == false) goto L10;
        a.b(r1.hashCode());
        return;
    }

    public static void INVOKEVIRTUAL_com_ss_android_cert_manager_bpea_DefaultCertCompliance_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(AudioRecord r1) {
        if (g.d() == true) goto L6;
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_stop(r1);
        return;
    L6:
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_stop(r1);
        if ((r1 instanceof AudioRecord) == false) goto L10;
        a.c(r1.hashCode());
        return;
    }

    private static Camera com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_open(int r12) {
        c r8 = new c();
        Object[] r9 = {Integer.valueOf(r12)};
        b r10 = new b();
        d r11 = r8.b(100100, "android/hardware/Camera", "open", Camera.class, r9, "android.hardware.Camera", r10);
        if (r11.a == false) goto L6;
        r8.a(100100, "android/hardware/Camera", "open", Camera.class, r9, null, r10, false);
        return (Camera) r11.b;
    L6:
        Camera r13 = Camera.open(r12);
        r8.a(100100, "android/hardware/Camera", "open", Camera.class, r9, r13, r10, true);
        return r13;
    }

    private static void com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_release(Camera r12) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        if (r8.b(100101, "android/hardware/Camera", "release", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100101, "android/hardware/Camera", "release", r12, r9, null, r10, false);
        return;
    L6:
        r12.release();
        r8.a(100101, "android/hardware/Camera", "release", r12, r9, null, r10, true);
    }

    private static void com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_release(AudioRecord r12) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        if (r8.b(100403, "android/media/AudioRecord", "release", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, false);
        return;
    L6:
        r12.release();
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, true);
    }

    private static void com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_startRecording(AudioRecord r12) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        if (r8.b(100400, "android/media/AudioRecord", "startRecording", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r10, false);
        return;
    L6:
        r12.startRecording();
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r10, true);
    }

    private static void com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_stop(AudioRecord r12) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        if (r8.b(100401, "android/media/AudioRecord", "stop", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, false);
        return;
    L6:
        r12.stop();
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, true);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public Camera openCamera(int r1) {
        return com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_open(r1);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void releaseCamera(Camera r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_hardware_Camera_release(r1);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void releaseRecord(AudioRecord r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        com_ss_android_cert_manager_bpea_DefaultCertCompliance_android_media_AudioRecord_release(r1);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void startRecord(AudioRecord r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        INVOKEVIRTUAL_com_ss_android_cert_manager_bpea_DefaultCertCompliance_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(r1);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public void stopRecord(AudioRecord r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        INVOKEVIRTUAL_com_ss_android_cert_manager_bpea_DefaultCertCompliance_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(r1);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    public Sensor getDefaultSensor(SensorManager r1, int r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getDefaultSensor(r2);
    }

    @Override // com.ss.android.cert.manager.ablity.ICertCompliance
    @PermissionsRequest(forceAllPermissionsRequest = true, scene = "certification")
    public void requestPermissions(Activity r1, String[] r2, int r3) {
        ActivityCompat.requestPermissions(r1, r2, r3);
    }
}
