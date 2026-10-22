package androidx.constraintlayout.solver.widgets;

/* JADX INFO: loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f438x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f439y;

    public Rectangle() {
    }

    public boolean contains(int r5, int r10) {
        int r11 = this.f438x;
        if (r5 >= r11) goto L5;
    L11:
        return false;
    L5:
        if (r5 >= (r11 + this.width)) goto L11;
        int r12 = this.f439y;
        if (r10 < r12) goto L11;
        if (r10 >= (r12 + this.height)) goto L11;
        return true;
    }

    public int getCenterX() {
        return (this.f438x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f439y + this.height) / 2;
    }

    public void grow(int r5, int r10) {
        this.f438x -= r5;
        this.f439y -= r10;
        this.width = (r5 * 2) + this.width;
        this.height = (r10 * 2) + this.height;
    }

    public boolean intersects(Rectangle r5) {
        int r10 = this.f438x;
        int r11 = r5.f438x;
        if (r10 >= r11) goto L5;
    L11:
        return false;
    L5:
        if (r10 >= (r11 + r5.width)) goto L11;
        int r12 = this.f439y;
        int r13 = r5.f439y;
        if (r12 < r13) goto L11;
        if (r12 >= (r13 + r5.height)) goto L11;
        return true;
    }

    public void setBounds(int r5, int r10, int r11, int r12) {
        this.f438x = r5;
        this.f439y = r10;
        this.width = r11;
        this.height = r12;
    }
}
