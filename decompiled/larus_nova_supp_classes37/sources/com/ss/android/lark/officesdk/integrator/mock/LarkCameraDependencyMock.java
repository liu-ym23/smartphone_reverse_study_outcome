package com.ss.android.lark.officesdk.integrator.mock;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.camera_export.ICameraIntentCallback;
import com.ss.android.lark.camera_export.ILarkCameraDependency;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(ILarkCameraDependency.class)
public class LarkCameraDependencyMock implements ILarkCameraDependency {
    private static final String TAG = "OfficeSdkMock";

    public LarkCameraDependencyMock() {
    }

    public void getCKCamera(Activity r1, CameraParam r2, ICameraIntentCallback r3) {
    }

    public void onCreate(Activity r1) {
    }

    public void onDestroy(Activity r1) {
    }

    public void onEditPhotoResult(Activity r1, Bundle r2, String r3) {
    }

    public void onTakeMedia(Activity r1, String r2, String r3) {
    }

    public void openPhotoEditor(Activity r1, String r2, int r3) {
    }

    public void saveCameraResultToGallery(String r1) {
    }
}
