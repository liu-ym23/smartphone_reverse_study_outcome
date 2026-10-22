package androidx.room.jarjarred.org.antlr.v4.gui;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasicFontMetrics {
    public static final int MAX_CHAR = 255;
    protected int maxCharHeight;
    protected int[] widths;

    public BasicFontMetrics() {
        this.widths = new int[256];
    }

    public double getLineHeight(int r5) {
        return (((double) this.maxCharHeight) / 1000.0d) * ((double) r5);
    }

    public double getWidth(String r10, int r11) {
        char[] r12 = r10.toCharArray();
        int r5 = r12.length;
        double r13 = 0.0d;
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L5;
        r13 = r13 + getWidth(r12[r14], r11);
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    public double getWidth(char r5, int r10) {
        if (r5 > 255) goto L10;
        int r11 = this.widths[r5];
        if (r11 == 0) goto L10;
        return (((double) r11) / 1000.0d) * ((double) r10);
    L10:
        return ((double) this.widths[109(0x6d, float:1.53E-43)]) / 1000.0d;
    }
}
