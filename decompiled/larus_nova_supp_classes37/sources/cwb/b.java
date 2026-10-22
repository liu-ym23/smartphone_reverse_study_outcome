package cwb;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAutoSaveDecisionScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingAutoSaveDialogReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MmRecordingAutoSaveDialogReason.values().length];
            r0[MmRecordingAutoSaveDialogReason.NoQuota.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[MmRecordingAutoSaveDialogReason.WindowLimited5H.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[MmRecordingAutoSaveDialogReason.WindowLimited7D.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[MmRecordingAutoSaveDecisionScene.values().length];
            r1[MmRecordingAutoSaveDecisionScene.TOKEN_READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[MmRecordingAutoSaveDecisionScene.RECORD_FINISH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    static {
    }
}
