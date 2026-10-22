package obric.rssroute.model;

/* JADX INFO: loaded from: classes3.dex */
public final class RssUIntResult {
    public final int status;
    public final int value;

    public RssUIntResult(int r10, int r11) {
        this.status = r10;
        this.value = r11;
    }

    public boolean isSuccess() {
        if (this.status != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
