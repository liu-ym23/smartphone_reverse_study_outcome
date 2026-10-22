package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class TypedBundle {
    private static final int INITIAL_BOOLEAN = 4;
    private static final int INITIAL_FLOAT = 10;
    private static final int INITIAL_INT = 10;
    private static final int INITIAL_STRING = 5;
    int mCountBoolean;
    int mCountFloat;
    int mCountInt;
    int mCountString;
    int[] mTypeBoolean;
    int[] mTypeFloat;
    int[] mTypeInt;
    int[] mTypeString;
    boolean[] mValueBoolean;
    float[] mValueFloat;
    int[] mValueInt;
    String[] mValueString;

    public TypedBundle() {
        this.mTypeInt = new int[10];
        this.mValueInt = new int[10];
        this.mCountInt = 0;
        this.mTypeFloat = new int[10];
        this.mValueFloat = new float[10];
        this.mCountFloat = 0;
        this.mTypeString = new int[5];
        this.mValueString = new String[5];
        this.mCountString = 0;
        this.mTypeBoolean = new int[4];
        this.mValueBoolean = new boolean[4];
        this.mCountBoolean = 0;
    }

    public void add(int r10, float r11) {
        int r12 = this.mCountFloat;
        int[] r13 = this.mTypeFloat;
        if (r12 < r13.length) goto L5;
        this.mTypeFloat = Arrays.copyOf(r13, r13.length * 2);
        float[] r14 = this.mValueFloat;
        this.mValueFloat = Arrays.copyOf(r14, r14.length * 2);
    L5:
        int[] r15 = this.mTypeFloat;
        int r16 = this.mCountFloat;
        r15[r16] = r10;
        float[] r17 = this.mValueFloat;
        this.mCountFloat = r16 + 1;
        r17[r16] = r11;
    }

    public void add(int r10, int r11) {
        int r12 = this.mCountInt;
        int[] r13 = this.mTypeInt;
        if (r12 < r13.length) goto L5;
        this.mTypeInt = Arrays.copyOf(r13, r13.length * 2);
        int[] r14 = this.mValueInt;
        this.mValueInt = Arrays.copyOf(r14, r14.length * 2);
    L5:
        int[] r15 = this.mTypeInt;
        int r16 = this.mCountInt;
        r15[r16] = r10;
        int[] r17 = this.mValueInt;
        this.mCountInt = r16 + 1;
        r17[r16] = r11;
    }

    public void add(int r10, String r11) {
        int r12 = this.mCountString;
        int[] r13 = this.mTypeString;
        if (r12 < r13.length) goto L5;
        this.mTypeString = Arrays.copyOf(r13, r13.length * 2);
        String[] r14 = this.mValueString;
        this.mValueString = (String[]) Arrays.copyOf(r14, r14.length * 2);
    L5:
        int[] r15 = this.mTypeString;
        int r16 = this.mCountString;
        r15[r16] = r10;
        String[] r17 = this.mValueString;
        this.mCountString = r16 + 1;
        r17[r16] = r11;
    }

    public void add(int r10, boolean r11) {
        int r12 = this.mCountBoolean;
        int[] r13 = this.mTypeBoolean;
        if (r12 < r13.length) goto L5;
        this.mTypeBoolean = Arrays.copyOf(r13, r13.length * 2);
        boolean[] r14 = this.mValueBoolean;
        this.mValueBoolean = Arrays.copyOf(r14, r14.length * 2);
    L5:
        int[] r15 = this.mTypeBoolean;
        int r16 = this.mCountBoolean;
        r15[r16] = r10;
        boolean[] r17 = this.mValueBoolean;
        this.mCountBoolean = r16 + 1;
        r17[r16] = r11;
    }

    public void addIfNotNull(int r10, String r11) {
        if (r11 == null) goto L5;
        add(r10, r11);
        return;
    }

    public void applyDelta(TypedBundle r10) {
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= this.mCountInt) goto L6;
        r10.add(this.mTypeInt[r12], this.mValueInt[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        int r13 = 0;
    L8:
        if (r13 >= this.mCountFloat) goto L10;
        r10.add(this.mTypeFloat[r13], this.mValueFloat[r13]);
        r13 = r13 + 1;
        goto L8
    L10:
        int r14 = 0;
    L12:
        if (r14 >= this.mCountString) goto L15;
        r10.add(this.mTypeString[r14], this.mValueString[r14]);
        r14 = r14 + 1;
    L15:
        if (r11 >= this.mCountBoolean) goto L17;
        r10.add(this.mTypeBoolean[r11], this.mValueBoolean[r11]);
        r11 = r11 + 1;
        goto L15
    }

    public void applyDelta(TypedValues r10) {
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= this.mCountInt) goto L6;
        r10.setValue(this.mTypeInt[r12], this.mValueInt[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        int r13 = 0;
    L8:
        if (r13 >= this.mCountFloat) goto L10;
        r10.setValue(this.mTypeFloat[r13], this.mValueFloat[r13]);
        r13 = r13 + 1;
        goto L8
    L10:
        int r14 = 0;
    L12:
        if (r14 >= this.mCountString) goto L15;
        r10.setValue(this.mTypeString[r14], this.mValueString[r14]);
        r14 = r14 + 1;
    L15:
        if (r11 >= this.mCountBoolean) goto L17;
        r10.setValue(this.mTypeBoolean[r11], this.mValueBoolean[r11]);
        r11 = r11 + 1;
        goto L15
    }

    public void clear() {
        this.mCountBoolean = 0;
        this.mCountString = 0;
        this.mCountFloat = 0;
        this.mCountInt = 0;
    }

    public int getInteger(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mCountInt) goto L10;
        if (this.mTypeInt[r11] == r10) goto L8;
        r11 = r11 + 1;
        goto L4
    L8:
        return this.mValueInt[r11];
    L10:
        return -1;
    }
}
