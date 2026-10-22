package androidx.emoji2.text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader a;

    public /* synthetic */ d(FontRequestEmojiCompatConfig.FontRequestMetadataLoader r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.createMetadata();
    }
}
