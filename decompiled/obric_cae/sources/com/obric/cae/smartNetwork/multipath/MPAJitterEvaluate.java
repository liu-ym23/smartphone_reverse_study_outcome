package com.obric.cae.smartNetwork.multipath;

import ha.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MPAJitterEvaluate {
    private static final boolean DEBUG = false;
    private static final float INVALID_SCORE = -1.0f;
    private static final String JSON_TPUT_JITTER_SCORE_TABLE = "[\n  {\n    \"tput\": 70,\n    \"jitter\": [0, 10, 20, 30, 40, 50, 60, 70, 80, 90],\n    \"score\": [140, 130, 120, 110, 100, 90, 80, 70, 60, 50]\n  },\n  {\n    \"tput\": 80,\n    \"jitter\": [0, 10, 20, 30, 40, 50, 60, 70, 80, 90],\n    \"score\": [160, 150, 140, 130, 120, 110, 100, 90, 80, 70]\n  }\n,  {\n    \"tput\": 90,\n    \"jitter\": [0, 10, 20, 30, 40, 50, 60, 70, 80, 90],\n    \"score\": [180, 170, 160, 150, 140, 130, 120, 110, 100, 90]\n  },\n  {\n    \"tput\": 100,\n    \"jitter\": [0, 10, 20, 30, 40, 50, 60, 70, 80, 90],\n    \"score\": [200, 190, 180, 170, 160, 150, 140, 130, 120, 110]\n  },\n  {\n    \"tput\": 110,\n    \"jitter\": [0, 10, 20, 30, 40, 50, 60, 70, 80, 90],\n    \"score\": [220, 210, 200, 190, 180, 170, 160, 150, 140, 130]\n  },\n  {\n    \"tput\": 120,\n    \"jitter\": [0, 10, 20, 30, 40, 50, 60, 70, 80, 90],\n    \"score\": [240, 230, 220, 210, 200, 190, 180, 170, 160, 150]\n  }\n]";
    private static final String TAG = "MPAJitterEvaluate";
    private final List<DataRow> mDataRows;

    public class DataRow {
        private int[] jitter;
        private int[] score;
        final /* synthetic */ MPAJitterEvaluate this$0;
        private int tput;

        public DataRow(MPAJitterEvaluate r8, int r10, int[] r11, int[] r12) {
            this.this$0 = r8;
            this.tput = r10;
            this.jitter = r11;
            this.score = r12;
        }

        public static /* synthetic */ int access$300(DataRow r8) {
            return r8.tput;
        }

        public static /* synthetic */ int[] access$400(DataRow r8) {
            return r8.jitter;
        }

        public static /* synthetic */ int[] access$500(DataRow r8) {
            return r8.score;
        }

        public int[] getJitterArray() {
            return this.jitter;
        }

        public int[] getScoreArray() {
            return this.score;
        }

        public int getTput() {
            return this.tput;
        }
    }

    public class Result {
        private int jitter;
        private int score;
        final /* synthetic */ MPAJitterEvaluate this$0;
        private int tput;

        public Result(MPAJitterEvaluate r8, int r10, int r11, int r12) {
            this.this$0 = r8;
            this.tput = r10;
            this.jitter = r11;
            this.score = r12;
        }

        public static /* synthetic */ int access$000(Result r8) {
            return r8.score;
        }

        public static /* synthetic */ int access$100(Result r8) {
            return r8.tput;
        }

        public static /* synthetic */ int access$200(Result r8) {
            return r8.jitter;
        }

        public int getJitter() {
            return this.jitter;
        }

        public int getScore() {
            return this.score;
        }

        public int getTput() {
            return this.tput;
        }
    }

    public MPAJitterEvaluate() {
        ArrayList r8 = new ArrayList();
        this.mDataRows = r8;
        Collections.addAll(r8, (DataRow[]) new j().c(DataRow[].class, JSON_TPUT_JITTER_SCORE_TABLE));
    }

    public static /* synthetic */ int a(int r8, Integer r10) {
        return lambda$findClosestTputs$1(r8, r10);
    }

    public static /* synthetic */ int b(int r8, Integer r10) {
        return lambda$findClosestJitters$2(r8, r10);
    }

    public static /* synthetic */ int c(Result r8, Result r10) {
        return lambda$sortResults$0(r8, r10);
    }

    private float calculateScoreForFourResult(int r8, int r10, List<Result> r11) {
        if (r11.size() == 4) goto L6;
        return -1.0f;
    L6:
        float r12 = (((r8 - Result.access$100(r11.get(0))) / (Result.access$100(r11.get(2)) - Result.access$100(r11.get(0)))) * Result.access$000(r11.get(2))) + (((Result.access$100(r11.get(2)) - r8) / (Result.access$100(r11.get(2)) - Result.access$100(r11.get(0)))) * Result.access$000(r11.get(0)));
        float r13 = (((r8 - Result.access$100(r11.get(0))) / (Result.access$100(r11.get(2)) - Result.access$100(r11.get(0)))) * Result.access$000(r11.get(3))) + (((Result.access$100(r11.get(2)) - r8) / (Result.access$100(r11.get(2)) - Result.access$100(r11.get(0)))) * Result.access$000(r11.get(1)));
        float r14 = (r10 - Result.access$200(r11.get(1))) / (Result.access$200(r11.get(0)) - Result.access$200(r11.get(1)));
        return (((Result.access$200(r11.get(0)) - r10) / (Result.access$200(r11.get(0)) - Result.access$200(r11.get(1)))) * r12) + (r14 * r13);
    }

    private float calculateScoreForTwoResult(int r8, int r10, List<Result> r11) {
        if (r11.size() == 2) goto L7;
        return -1.0f;
    L7:
        if (Result.access$100(r11.get(0)) != Result.access$100(r11.get(1))) goto L10;
        return (((r10 - Result.access$200(r11.get(1))) / (Result.access$200(r11.get(0)) - Result.access$200(r11.get(1)))) * Result.access$000(r11.get(0))) + (((Result.access$200(r11.get(0)) - r10) / (Result.access$200(r11.get(0)) - Result.access$200(r11.get(1)))) * Result.access$000(r11.get(1)));
    L10:
        if (Result.access$200(r11.get(0)) == Result.access$200(r11.get(1))) goto L15;
        return 0.0f;
    L15:
        return (((Result.access$100(r11.get(1)) - r8) / (Result.access$100(r11.get(1)) - Result.access$100(r11.get(0)))) * Result.access$000(r11.get(0))) + (((r8 - Result.access$100(r11.get(0))) / (Result.access$100(r11.get(1)) - Result.access$100(r11.get(0)))) * Result.access$000(r11.get(1)));
    }

    private int[] findClosestJitters(int[] r8, int r10, int r11) {
        ArrayList r12 = new ArrayList();
        int r13 = r8.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(Integer.valueOf(r8[r14]));
        r14 = r14 + 1;
        goto L3
    L5:
        r12.sort(Comparator.comparingInt(new a(r10, 1)));
        return r12.stream().limit(r11).mapToInt(new com.google.protobuf.a(2)).toArray();
    }

    private int[] findClosestTputs(List<DataRow> r8, int r10, int r11) {
        ArrayList r12 = new ArrayList();
        Iterator<DataRow> r13 = r8.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(Integer.valueOf(DataRow.access$300(r13.next())));
        goto L4
    L6:
        r12.sort(Comparator.comparingInt(new a(r10, 0)));
        return r12.stream().distinct().limit(r11).mapToInt(new com.google.protobuf.a(1)).toArray();
    }

    private int findExactJitterIndex(int[] r8, int r10) {
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L9;
        if (r8[r11] == r10) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return -1;
    }

    private List<Result> getResult(List<DataRow> r19, int r20, int r21) {
        ArrayList r8 = new ArrayList();
        ArrayList r10 = new ArrayList();
        Iterator<DataRow> r11 = r19.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        DataRow r12 = r11.next();
        if (DataRow.access$300(r12) != r20) goto L4;
        r10.add(r12);
    L8:
        int r13 = -1;
        int r14 = 2;
        if (r10.isEmpty() == true) goto L19;
        Iterator r15 = r10.iterator();
    L12:
        if (r15.hasNext() == false) goto L34;
        DataRow r16 = (DataRow) r15.next();
        int r17 = findExactJitterIndex(DataRow.access$400(r16), r21);
        if (r17 != (-1)) goto L15;
        int[] r18 = findClosestJitters(DataRow.access$400(r16), r21, 2);
        int r22 = r18.length;
        int r110 = 0;
    L17:
        if (r110 >= r22) goto L12;
        int r111 = r18[r110];
        int r112 = findExactJitterIndex(DataRow.access$400(r16), r111);
        r8.add(new Result(this, DataRow.access$300(r16), DataRow.access$400(r16)[r112], DataRow.access$500(r16)[r112]));
        r110 = r110 + 1;
        goto L17
    L15:
        r8.add(new Result(this, DataRow.access$300(r16), DataRow.access$400(r16)[r17], DataRow.access$500(r16)[r17]));
    L34:
        return r8;
    L19:
        int[] r23 = findClosestTputs(r19, r20, 2);
        int r24 = r23.length;
        int r25 = 0;
    L20:
        if (r25 >= r24) goto L34;
        int r113 = r23[r25];
        Iterator<DataRow> r114 = r19.iterator();
    L23:
        if (r114.hasNext() == false) goto L33;
        DataRow r115 = r114.next();
        if (DataRow.access$300(r115) != r113) goto L32;
        int r116 = findExactJitterIndex(DataRow.access$400(r115), r21);
        if (r116 == r13) goto L29;
        r8.add(new Result(this, DataRow.access$300(r115), DataRow.access$400(r115)[r116], DataRow.access$500(r115)[r116]));
        goto L32
    L29:
        int[] r26 = findClosestJitters(DataRow.access$400(r115), r21, r14);
        int r117 = r26.length;
        int r118 = 0;
    L30:
        if (r118 >= r117) goto L32;
        int r119 = r26[r118];
        int r27 = findExactJitterIndex(DataRow.access$400(r115), r119);
        int[] r28 = r23;
        r8.add(new Result(this, DataRow.access$300(r115), DataRow.access$400(r115)[r27], DataRow.access$500(r115)[r27]));
        r118 = r118 + 1;
        r23 = r28;
    L32:
        r23 = r23;
        r13 = -1;
        r14 = 2;
        goto L23
    L33:
        r25 = r25 + 1;
        r13 = -1;
        r14 = 2;
        goto L20
    }

    private static /* synthetic */ int lambda$findClosestJitters$2(int r8, Integer r10) {
        return Math.abs(r10.intValue() - r8);
    }

    private static /* synthetic */ int lambda$findClosestTputs$1(int r8, Integer r10) {
        return Math.abs(r10.intValue() - r8);
    }

    private static /* synthetic */ int lambda$sortResults$0(Result r8, Result r10) {
        if (Result.access$100(r8) == Result.access$100(r10)) goto L7;
        return Integer.compare(Result.access$100(r8), Result.access$100(r10));
    L7:
        return Integer.compare(Result.access$200(r10), Result.access$200(r8));
    }

    private void sortResults(List<Result> r8) {
        r8.sort(new b());
    }

    public float calculateScore(int r8, int r10) {
        List<Result> r11 = getResult(this.mDataRows, r8, r10);
        if (r11.isEmpty() == false) goto L6;
        return -1.0f;
    L6:
        if (r11.size() != 1) goto L10;
        return Result.access$000(r11.get(0));
    L10:
        if (r11.size() != 2) goto L14;
        sortResults(r11);
        return calculateScoreForTwoResult(r8, r10, r11);
    L14:
        if (r11.size() != 4) goto L17;
        sortResults(r11);
        return calculateScoreForFourResult(r8, r10, r11);
    L17:
        return -1.0f;
    }
}
