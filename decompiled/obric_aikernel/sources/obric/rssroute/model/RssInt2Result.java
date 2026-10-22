package obric.rssroute.model;

/* JADX INFO: loaded from: classes3.dex */
public final class RssInt2Result {
    public final int status;
    public final int value1;
    public final int value2;

    public RssInt2Result(int r10, int r11, int r12) {
        this.status = r10;
        this.value1 = r11;
        this.value2 = r12;
    }

    public boolean isSuccess() {
        if (this.status != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
