package com.bytedance.byted_bach_sdk.buffer;

import java.util.Vector;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SingleExpressionDetectResult {
    public int ID;
    public float age;
    public float attractive;
    public float boy_prob;
    public Vector<Float> exp_probs;
    public FaceExpression exp_type;
    public FaceGender gender;
    public float happy_score;
    public float quality;
    public float real_face_prob;

    public static final enum FaceExpression extends Enum<FaceExpression> {
        private static final /* synthetic */ FaceExpression[] $VALUES = null;
        public static final FaceExpression ANGRY = null;
        public static final FaceExpression DISGUST = null;
        public static final FaceExpression FEAR = null;
        public static final FaceExpression HAPPY = null;
        public static final FaceExpression NEUTRAL = null;
        public static final FaceExpression NUM_EXPRESSION = null;
        public static final FaceExpression SAD = null;
        public static final FaceExpression SURPRISE = null;
        public static final FaceExpression UNKNOWN = null;

        static {
            FaceExpression r0 = new FaceExpression("ANGRY", 0);
            ANGRY = r0;
            FaceExpression r1 = new FaceExpression("DISGUST", 1);
            DISGUST = r1;
            FaceExpression r3 = new FaceExpression("FEAR", 2);
            FEAR = r3;
            FaceExpression r5 = new FaceExpression("HAPPY", 3);
            HAPPY = r5;
            FaceExpression r7 = new FaceExpression("SAD", 4);
            SAD = r7;
            FaceExpression r9 = new FaceExpression("SURPRISE", 5);
            SURPRISE = r9;
            FaceExpression r11 = new FaceExpression("NEUTRAL", 6);
            NEUTRAL = r11;
            FaceExpression r13 = new FaceExpression("NUM_EXPRESSION", 7);
            NUM_EXPRESSION = r13;
            FaceExpression r15 = new FaceExpression("UNKNOWN", 8);
            UNKNOWN = r15;
            $VALUES = new FaceExpression[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        public static FaceExpression[] values() {
            return (FaceExpression[]) $VALUES.clone();
        }

        public static FaceExpression valueOf(String r1) {
            return (FaceExpression) a.a(FaceExpression.class, r1);
        }

        private FaceExpression(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum FaceGender extends Enum<FaceGender> {
        private static final /* synthetic */ FaceGender[] $VALUES = null;
        public static final FaceGender FEMALE = null;
        public static final FaceGender MALE = null;
        public static final FaceGender UNKNOWN = null;

        static {
            FaceGender r0 = new FaceGender("MALE", 0);
            MALE = r0;
            FaceGender r1 = new FaceGender("FEMALE", 1);
            FEMALE = r1;
            FaceGender r3 = new FaceGender("UNKNOWN", 2);
            UNKNOWN = r3;
            $VALUES = new FaceGender[]{r0, r1, r3};
        }

        public static FaceGender[] values() {
            return (FaceGender[]) $VALUES.clone();
        }

        public static FaceGender valueOf(String r1) {
            return (FaceGender) a.a(FaceGender.class, r1);
        }

        private FaceGender(String r1, int r2) {
            super(r1, r2);
        }
    }

    public SingleExpressionDetectResult() {
        this.ID = -1;
        this.gender = FaceGender.UNKNOWN;
        this.exp_type = FaceExpression.UNKNOWN;
        this.real_face_prob = 0.0f;
        this.quality = 0.0f;
    }
}
