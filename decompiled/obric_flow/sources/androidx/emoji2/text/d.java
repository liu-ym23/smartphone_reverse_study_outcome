package androidx.emoji2.text;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader f513b;

    public /* synthetic */ d(FontRequestEmojiCompatConfig.FontRequestMetadataLoader r5, int r10) {
        this.f512a = r10;
        this.f513b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f512a;
        FontRequestEmojiCompatConfig.FontRequestMetadataLoader r10 = this.f513b;
        switch(r5) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        r10.loadInternal();
        return;
    L6:
        r10.createMetadata();
    }
}
