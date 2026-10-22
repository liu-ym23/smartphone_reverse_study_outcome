package ivb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.MmMinutesCreateSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {

    /* JADX INFO: renamed from: ivb.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0146a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingSource.values().length];
            r0[MmRecordingSource.DOUBAO_GLASSES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[MmRecordingSource.DOUBAO_EARBUDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[MmRecordingSource.FEISHU_HARDWARE_RECORDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204_CASE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[MmRecordingSource.OBRIC_RECORDER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static final MmMinutesCreateSource a(MmRecordingSource r1) {
        if (r1 != null) goto L4;
        int r2 = -1;
    L5:
        switch(r2) {
            case 1: goto L12;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L14;
            default: goto L6;
        };
    L6:
        return null;
    L14:
        return MmMinutesCreateSource.DoubaoRecorder;
    L15:
        return MmMinutesCreateSource.LibertyHeadset;
    L16:
        return MmMinutesCreateSource.SoundCoreHardware;
    L17:
        return MmMinutesCreateSource.DoubaoWearableHear;
    L12:
        return MmMinutesCreateSource.DoubaoWearableGlass;
    L4:
        r2 = C0146a.a[r1.ordinal()];
        goto L5
    }
}
