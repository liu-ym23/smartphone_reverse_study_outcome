package q78;

import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends AudioManager.AudioRecordingCallback {
    public final /* synthetic */ f a;

    public e(f r1) {
        this.a = r1;
    }

    @Override // android.media.AudioManager.AudioRecordingCallback
    public final void onRecordingConfigChanged(List<AudioRecordingConfiguration> r13) {
        Intrinsics.checkNotNullParameter(r13, "configs");
        super.onRecordingConfigChanged(r13);
        List<AudioRecordingConfiguration> r14 = r13;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L10;
        AudioRecordingConfiguration r1 = (AudioRecordingConfiguration) r15.next();
        AudioDeviceInfo r2 = r1.getAudioDevice();
        if (r2 == null) goto L8;
        a r3 = new a(r2.getId(), r2.getProductName().toString(), r2.getType(), r2.isSource());
    L9:
        int r5 = r1.getClientAudioSource();
        int r6 = r1.getClientAudioSessionId();
        AudioFormat r7 = r1.getClientFormat();
        boolean r8 = r1.isClientSilenced();
        r0.add(new c(r5, r6, r7, r8, r3, r1.getAudioSource(), r1.getFormat()));
        goto L4
    L8:
        r3 = null;
        goto L9
    L10:
        this.a.a(r0);
    }
}
