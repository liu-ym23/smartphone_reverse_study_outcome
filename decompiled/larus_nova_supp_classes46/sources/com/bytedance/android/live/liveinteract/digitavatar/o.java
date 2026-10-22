package com.bytedance.android.live.liveinteract.digitavatar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class o {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[DigitAvatarMsgController.AvatarStickerType.values().length];
        r0[DigitAvatarMsgController.AvatarStickerType.Recognition.ordinal()] = 1;
        r0[DigitAvatarMsgController.AvatarStickerType.DigitAvatar.ordinal()] = 2;
        int[] r1 = new int[DigitAvatarRecognitionDialog.RecognitionType.values().length];
        a = r1;
        r1[DigitAvatarRecognitionDialog.RecognitionType.CAMERA.ordinal()] = 1;
        r1[DigitAvatarRecognitionDialog.RecognitionType.PHOTO.ordinal()] = 2;
        r1[DigitAvatarRecognitionDialog.RecognitionType.DEFAULT.ordinal()] = 3;
        r1[DigitAvatarRecognitionDialog.RecognitionType.RESULT.ordinal()] = 4;
    }
}
