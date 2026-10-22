package e82;

import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ImageRecognitionEntry.values().length];
        a = r0;
        ImageRecognitionEntry r1 = ImageRecognitionEntry.LongPressPanel;
        r0[r1.ordinal()] = 1;
        ImageRecognitionEntry r2 = ImageRecognitionEntry.ClearScreen;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[ImageRecognitionEntry.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
