package androidx.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f254x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f255y;

    public Rectangle() {
    }

    public boolean contains(int r10, int r11) {
        int r12 = this.f254x;
        if (r10 >= r12) goto L5;
    L11:
        return false;
    L5:
        if (r10 >= (r12 + this.width)) goto L11;
        int r13 = this.f255y;
        if (r11 < r13) goto L11;
        if (r11 >= (r13 + this.height)) goto L11;
        return true;
    }

    public int getCenterX() {
        return (this.f254x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f255y + this.height) / 2;
    }

    void grow(int r10, int r11) {
        this.f254x -= r10;
        this.f255y -= r11;
        this.width += r10 * 2;
        this.height += r11 * 2;
    }

    boolean intersects(Rectangle r10) {
        int r11 = this.f254x;
        int r12 = r10.f254x;
        if (r11 >= r12) goto L5;
    L11:
        return false;
    L5:
        if (r11 >= (r12 + r10.width)) goto L11;
        int r13 = this.f255y;
        int r14 = r10.f255y;
        if (r13 < r14) goto L11;
        if (r13 >= (r14 + r10.height)) goto L11;
        return true;
    }

    public void setBounds(int r10, int r11, int r12, int r13) {
        this.f254x = r10;
        this.f255y = r11;
        this.width = r12;
        this.height = r13;
    }
}
