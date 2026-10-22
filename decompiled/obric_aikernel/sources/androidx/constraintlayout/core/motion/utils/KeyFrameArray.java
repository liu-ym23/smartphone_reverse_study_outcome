package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class KeyFrameArray {

    public static class CustomArray {
        private static final int EMPTY = 999;
        int count;
        int[] keys;
        CustomAttribute[] values;

        public CustomArray() {
            this.keys = new int[101];
            this.values = new CustomAttribute[101];
            clear();
        }

        public void append(int r10, CustomAttribute r11) {
            if (this.values[r10] == null) goto L5;
            remove(r10);
        L5:
            this.values[r10] = r11;
            int[] r12 = this.keys;
            int r13 = this.count;
            this.count = r13 + 1;
            r12[r13] = r10;
            Arrays.sort(r12);
        }

        public void clear() {
            Arrays.fill(this.keys, 999);
            Arrays.fill(this.values, null);
            this.count = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.keys, this.count)));
            System.out.print("K: [");
            int r10 = 0;
        L4:
            if (r10 >= this.count) goto L10;
            PrintStream r11 = System.out;
            StringBuilder r12 = new StringBuilder();
            if (r10 != 0) goto L8;
            String r13 = "";
        L9:
            r12.append(r13);
            r12.append(valueAt(r10));
            r11.print(r12.toString());
            r10 = r10 + 1;
            goto L4
        L8:
            r13 = ", ";
            goto L9
        L10:
            System.out.println("]");
        }

        public int keyAt(int r10) {
            return this.keys[r10];
        }

        public void remove(int r10) {
            this.values[r10] = null;
            int r11 = 0;
            int r12 = 0;
        L3:
            int r13 = this.count;
            if (r11 >= r13) goto L11;
            int[] r14 = this.keys;
            if (r10 != r14[r11]) goto L8;
            r14[r11] = 999;
            r12 = r12 + 1;
        L8:
            if (r11 == r12) goto L10;
            r14[r11] = r14[r12];
        L10:
            r12 = r12 + 1;
            r11 = r11 + 1;
            goto L3
        L11:
            this.count = r13 - 1;
        }

        public int size() {
            return this.count;
        }

        public CustomAttribute valueAt(int r10) {
            return this.values[this.keys[r10]];
        }
    }

    public static class CustomVar {
        private static final int EMPTY = 999;
        int count;
        int[] keys;
        CustomVariable[] values;

        public CustomVar() {
            this.keys = new int[101];
            this.values = new CustomVariable[101];
            clear();
        }

        public void append(int r10, CustomVariable r11) {
            if (this.values[r10] == null) goto L5;
            remove(r10);
        L5:
            this.values[r10] = r11;
            int[] r12 = this.keys;
            int r13 = this.count;
            this.count = r13 + 1;
            r12[r13] = r10;
            Arrays.sort(r12);
        }

        public void clear() {
            Arrays.fill(this.keys, 999);
            Arrays.fill(this.values, null);
            this.count = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.keys, this.count)));
            System.out.print("K: [");
            int r10 = 0;
        L4:
            if (r10 >= this.count) goto L10;
            PrintStream r11 = System.out;
            StringBuilder r12 = new StringBuilder();
            if (r10 != 0) goto L8;
            String r13 = "";
        L9:
            r12.append(r13);
            r12.append(valueAt(r10));
            r11.print(r12.toString());
            r10 = r10 + 1;
            goto L4
        L8:
            r13 = ", ";
            goto L9
        L10:
            System.out.println("]");
        }

        public int keyAt(int r10) {
            return this.keys[r10];
        }

        public void remove(int r10) {
            this.values[r10] = null;
            int r11 = 0;
            int r12 = 0;
        L3:
            int r13 = this.count;
            if (r11 >= r13) goto L11;
            int[] r14 = this.keys;
            if (r10 != r14[r11]) goto L8;
            r14[r11] = 999;
            r12 = r12 + 1;
        L8:
            if (r11 == r12) goto L10;
            r14[r11] = r14[r12];
        L10:
            r12 = r12 + 1;
            r11 = r11 + 1;
            goto L3
        L11:
            this.count = r13 - 1;
        }

        public int size() {
            return this.count;
        }

        public CustomVariable valueAt(int r10) {
            return this.values[this.keys[r10]];
        }
    }

    static class FloatArray {
        private static final int EMPTY = 999;
        int count;
        int[] keys;
        float[][] values;

        public FloatArray() {
            this.keys = new int[101];
            this.values = new float[101][];
            clear();
        }

        public void append(int r10, float[] r11) {
            if (this.values[r10] == null) goto L5;
            remove(r10);
        L5:
            this.values[r10] = r11;
            int[] r12 = this.keys;
            int r13 = this.count;
            this.count = r13 + 1;
            r12[r13] = r10;
            Arrays.sort(r12);
        }

        public void clear() {
            Arrays.fill(this.keys, 999);
            Arrays.fill(this.values, null);
            this.count = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.keys, this.count)));
            System.out.print("K: [");
            int r10 = 0;
        L4:
            if (r10 >= this.count) goto L10;
            PrintStream r11 = System.out;
            StringBuilder r12 = new StringBuilder();
            if (r10 != 0) goto L8;
            String r13 = "";
        L9:
            r12.append(r13);
            r12.append(Arrays.toString(valueAt(r10)));
            r11.print(r12.toString());
            r10 = r10 + 1;
            goto L4
        L8:
            r13 = ", ";
            goto L9
        L10:
            System.out.println("]");
        }

        public int keyAt(int r10) {
            return this.keys[r10];
        }

        public void remove(int r10) {
            this.values[r10] = null;
            int r11 = 0;
            int r12 = 0;
        L3:
            int r13 = this.count;
            if (r11 >= r13) goto L11;
            int[] r14 = this.keys;
            if (r10 != r14[r11]) goto L8;
            r14[r11] = 999;
            r12 = r12 + 1;
        L8:
            if (r11 == r12) goto L10;
            r14[r11] = r14[r12];
        L10:
            r12 = r12 + 1;
            r11 = r11 + 1;
            goto L3
        L11:
            this.count = r13 - 1;
        }

        public int size() {
            return this.count;
        }

        public float[] valueAt(int r10) {
            return this.values[this.keys[r10]];
        }
    }

    public KeyFrameArray() {
    }
}
