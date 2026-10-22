package androidx.room.jarjarred.org.stringtemplate.v4.debug;

/* JADX INFO: loaded from: classes.dex */
public class ConstructionEvent {
    public Throwable stack;

    public ConstructionEvent() {
        this.stack = new Throwable();
    }

    public String getFileName() {
        return getSTEntryPoint().getFileName();
    }

    public int getLine() {
        return getSTEntryPoint().getLineNumber();
    }

    public StackTraceElement getSTEntryPoint() {
        StackTraceElement[] r10 = this.stack.getStackTrace();
        int r5 = r10.length;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L9;
        StackTraceElement r12 = r10[r11];
        if (r12.toString().startsWith("androidx.room.jarjarred.org.stringtemplate.v4") == false) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r12;
    L9:
        return r10[0];
    }
}
