package com.bytedance.android.livesdk.interactivity.imagerecognition;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements ImageRecognitionTask.b {
    public final /* synthetic */ ImageRecognitionServiceWidget a;

    @Override // com.bytedance.android.livesdk.interactivity.imagerecognition.ImageRecognitionTask.b
    public final void onCancel() {
        this.a.a = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.imagerecognition.ImageRecognitionTask.b
    public final void onFailed() {
        this.a.a = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.imagerecognition.ImageRecognitionTask.b
    public final void onSuccess() {
        this.a.a = null;
    }

    public b(ImageRecognitionServiceWidget r1) {
        this.a = r1;
    }
}
