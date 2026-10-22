package im.quar.autolayout.config;

import android.content.Context;
import im.quar.autolayout.ScaleAdapter;
import im.quar.autolayout.utils.ScreenUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultScaleAdapter implements ScaleAdapter {
    private Context mContext;

    public DefaultScaleAdapter(Context r8) {
        this.mContext = r8;
    }

    @Override // im.quar.autolayout.ScaleAdapter
    public float adapt(float r8, int r10, int r11) {
        if (r10 < 720) goto L6;
        if (r11 < 720) goto L6;
        return r8;
    L6:
        if (r10 <= 480) goto L13;
        if (r11 <= 480) goto L13;
        if (ScreenUtils.getDevicePhysicalSize(this.mContext) >= 4.0d) goto L12;
        float r12 = 1.3f;
    L15:
        return r8 * r12;
    L12:
        r12 = 1.05f;
    L13:
        r12 = 1.2f;
        goto L15
    }
}
