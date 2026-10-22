package androidx.media;

import android.media.VolumeProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int r1);

        void onSetVolumeTo(int r1);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(final int r2, final int r3, final int r4, Delegate r5) {
        final Delegate r6 = (Delegate) ZeusTransformUtils.wrapperContextForParams(r5, Delegate.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r2, r3, r4, r6);
    }

    public static void setCurrentVolume(Object r2, int r3) {
        ((VolumeProvider) ZeusTransformUtils.preCheckCast(r2, VolumeProvider.class, "com.obric.memorydata.plugin")).setCurrentVolume(r3);
    }
}
