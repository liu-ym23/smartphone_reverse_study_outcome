package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

/* JADX INFO: loaded from: classes.dex */
public class IntegerStack extends IntegerList {
    public IntegerStack() {
    }

    public final int peek() {
        return get(size() - 1);
    }

    public final int pop() {
        return removeAt(size() - 1);
    }

    public final void push(int r5) {
        add(r5);
    }

    public IntegerStack(int r5) {
        super(r5);
    }

    public IntegerStack(IntegerStack r5) {
        super(r5);
    }
}
