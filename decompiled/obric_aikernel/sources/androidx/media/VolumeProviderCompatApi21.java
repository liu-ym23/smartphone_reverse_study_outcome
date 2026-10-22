package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int r10);

        void onSetVolumeTo(int r10);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(final int r10, final int r11, final int r12, final Delegate r13) {
        return new AnonymousClass1(r10, r11, r12, r13);
    }

    public static void setCurrentVolume(Object r10, int r11) {
        ((VolumeProvider) r10).setCurrentVolume(r11);
    }
}
