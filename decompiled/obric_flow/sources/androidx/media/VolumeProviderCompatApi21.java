package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int r5);

        void onSetVolumeTo(int r5);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(final int r5, final int r10, final int r11, final Delegate r12) {
        return new AnonymousClass1(r5, r10, r11, r12);
    }

    public static void setCurrentVolume(Object r5, int r10) {
        ((VolumeProvider) r5).setCurrentVolume(r10);
    }
}
