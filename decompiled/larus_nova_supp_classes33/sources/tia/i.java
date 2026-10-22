package tia;

import com.larus.audio.call.record.CaptureBackTraceReadScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class i {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[CaptureBackTraceReadScene.values().length];
        r0[CaptureBackTraceReadScene.REALTIME_CALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[CaptureBackTraceReadScene.CONTINUOUS_TALK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
