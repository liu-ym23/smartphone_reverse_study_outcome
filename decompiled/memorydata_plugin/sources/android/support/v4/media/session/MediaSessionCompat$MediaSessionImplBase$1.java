package android.support.v4.media.session;

import androidx.media.VolumeProviderCompat;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionCompat$MediaSessionImplBase$1 extends VolumeProviderCompat.Callback {
    final /* synthetic */ MediaSessionCompat.a this$0;

    MediaSessionCompat$MediaSessionImplBase$1(MediaSessionCompat.a r1) {
        this.this$0 = r1;
    }

    @Override // androidx.media.VolumeProviderCompat.Callback
    public void onVolumeChanged(VolumeProviderCompat r8) {
        if (this.this$0.h == r8) goto L5;
        return;
    L5:
        ParcelableVolumeInfo r0 = new ParcelableVolumeInfo(this.this$0.f, this.this$0.g, r8.getVolumeControl(), r8.getMaxVolume(), r8.getCurrentVolume());
        this.this$0.a(r0);
    }
}
