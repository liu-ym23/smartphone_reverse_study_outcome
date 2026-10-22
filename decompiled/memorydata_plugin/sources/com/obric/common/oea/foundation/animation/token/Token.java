package com.obric.common.oea.foundation.animation.token;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.apm6.fd.config.FdConfig;
import com.bytedance.crash.entity.EventBody;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.bduploader.UploadKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/Token;", "", "()V", "Bounce", "Delay", "Duration", "Easing", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class Token {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;", "", "bounce", "", "dampingRatio", "(Ljava/lang/String;IFF)V", "getBounce", "()F", "getDampingRatio", "OUI_ANIMATION_BOUNCE_SMOOTH", "OUI_ANIMATION_BOUNCE_SNAPPY_1", "OUI_ANIMATION_BOUNCE_SNAPPY_2", "OUI_ANIMATION_BOUNCE_SNAPPY_3", "OUI_ANIMATION_BOUNCE_SNAPPY_4", "OUI_ANIMATION_BOUNCE_BOUNCY_1", "OUI_ANIMATION_BOUNCE_BOUNCY_2", "OUI_ANIMATION_BOUNCE_BOUNCY_3", "OUI_ANIMATION_BOUNCE_BOUNCY_4", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Bounce extends Enum<Bounce> {
        private static final /* synthetic */ Bounce[] $VALUES = null;
        public static final Bounce OUI_ANIMATION_BOUNCE_BOUNCY_1 = null;
        public static final Bounce OUI_ANIMATION_BOUNCE_BOUNCY_2 = null;
        public static final Bounce OUI_ANIMATION_BOUNCE_BOUNCY_3 = null;
        public static final Bounce OUI_ANIMATION_BOUNCE_BOUNCY_4 = null;
        public static final Bounce OUI_ANIMATION_BOUNCE_SMOOTH = null;
        public static final Bounce OUI_ANIMATION_BOUNCE_SNAPPY_1 = null;
        public static final Bounce OUI_ANIMATION_BOUNCE_SNAPPY_2 = null;
        public static final Bounce OUI_ANIMATION_BOUNCE_SNAPPY_3 = null;
        public static final Bounce OUI_ANIMATION_BOUNCE_SNAPPY_4 = null;
        private final float bounce;
        private final float dampingRatio;

        static {
            Bounce r1 = new Bounce("OUI_ANIMATION_BOUNCE_SMOOTH", 0, 0.0f, 1.0f);
            OUI_ANIMATION_BOUNCE_SMOOTH = r1;
            Bounce r2 = new Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_1", 1, 0.05f, 0.95f);
            OUI_ANIMATION_BOUNCE_SNAPPY_1 = r2;
            Bounce r3 = new Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_2", 2, 0.1f, 0.9f);
            OUI_ANIMATION_BOUNCE_SNAPPY_2 = r3;
            Bounce r4 = new Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_3", 3, 0.15f, 0.85f);
            OUI_ANIMATION_BOUNCE_SNAPPY_3 = r4;
            Bounce r5 = new Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_4", 4, 0.2f, 0.8f);
            OUI_ANIMATION_BOUNCE_SNAPPY_4 = r5;
            Bounce r6 = new Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_1", 5, 0.25f, 0.75f);
            OUI_ANIMATION_BOUNCE_BOUNCY_1 = r6;
            Bounce r7 = new Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_2", 6, 0.3f, 0.7f);
            OUI_ANIMATION_BOUNCE_BOUNCY_2 = r7;
            Bounce r8 = new Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_3", 7, 0.35f, 0.65f);
            OUI_ANIMATION_BOUNCE_BOUNCY_3 = r8;
            Bounce r9 = new Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_4", 8, 0.4f, 0.6f);
            OUI_ANIMATION_BOUNCE_BOUNCY_4 = r9;
            $VALUES = new Bounce[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        }

        private Bounce(String r1, int r2, float r3, float r4) {
            super(r1, r2);
            this.bounce = r3;
            this.dampingRatio = r4;
        }

        public static Bounce valueOf(String r2) {
            return (Bounce) ZeusTransformUtils.preCheckCast(Enum.valueOf(Bounce.class, r2), Bounce.class, "com.obric.memorydata.plugin");
        }

        public static Bounce[] values() {
            return (Bounce[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Bounce[].class, "com.obric.memorydata.plugin");
        }

        public final float getBounce() {
            return this.bounce;
        }

        public final float getDampingRatio() {
            return this.dampingRatio;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/Token$Delay;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "OUI_ANIMATION_DELAY_NONE", "OUI_ANIMATION_DELAY_SHORT_1", "OUI_ANIMATION_DELAY_SHORT_2", "OUI_ANIMATION_DELAY_SHORT_3", "OUI_ANIMATION_DELAY_SHORT_4", "OUI_ANIMATION_DELAY_MEDIUM_1", "OUI_ANIMATION_DELAY_MEDIUM_2", "OUI_ANIMATION_DELAY_MEDIUM_3", "OUI_ANIMATION_DELAY_MEDIUM_4", "OUI_ANIMATION_DELAY_LONG_1", "OUI_ANIMATION_DELAY_LONG_2", "OUI_ANIMATION_DELAY_LONG_3", "OUI_ANIMATION_DELAY_LONG_4", "OUI_ANIMATION_DELAY_VERY_LONG_1", "OUI_ANIMATION_DELAY_VERY_LONG_2", "OUI_ANIMATION_DELAY_VERY_LONG_3", "OUI_ANIMATION_DELAY_VERY_LONG_4", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Delay extends Enum<Delay> {
        private static final /* synthetic */ Delay[] $VALUES = null;
        public static final Delay OUI_ANIMATION_DELAY_LONG_1 = null;
        public static final Delay OUI_ANIMATION_DELAY_LONG_2 = null;
        public static final Delay OUI_ANIMATION_DELAY_LONG_3 = null;
        public static final Delay OUI_ANIMATION_DELAY_LONG_4 = null;
        public static final Delay OUI_ANIMATION_DELAY_MEDIUM_1 = null;
        public static final Delay OUI_ANIMATION_DELAY_MEDIUM_2 = null;
        public static final Delay OUI_ANIMATION_DELAY_MEDIUM_3 = null;
        public static final Delay OUI_ANIMATION_DELAY_MEDIUM_4 = null;
        public static final Delay OUI_ANIMATION_DELAY_NONE = null;
        public static final Delay OUI_ANIMATION_DELAY_SHORT_1 = null;
        public static final Delay OUI_ANIMATION_DELAY_SHORT_2 = null;
        public static final Delay OUI_ANIMATION_DELAY_SHORT_3 = null;
        public static final Delay OUI_ANIMATION_DELAY_SHORT_4 = null;
        public static final Delay OUI_ANIMATION_DELAY_VERY_LONG_1 = null;
        public static final Delay OUI_ANIMATION_DELAY_VERY_LONG_2 = null;
        public static final Delay OUI_ANIMATION_DELAY_VERY_LONG_3 = null;
        public static final Delay OUI_ANIMATION_DELAY_VERY_LONG_4 = null;
        private final int value;

        static {
            Delay r1 = new Delay("OUI_ANIMATION_DELAY_NONE", 0, 0);
            OUI_ANIMATION_DELAY_NONE = r1;
            Delay r2 = new Delay("OUI_ANIMATION_DELAY_SHORT_1", 1, 50);
            OUI_ANIMATION_DELAY_SHORT_1 = r2;
            Delay r3 = new Delay("OUI_ANIMATION_DELAY_SHORT_2", 2, 100);
            OUI_ANIMATION_DELAY_SHORT_2 = r3;
            Delay r4 = new Delay("OUI_ANIMATION_DELAY_SHORT_3", 3, AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD);
            OUI_ANIMATION_DELAY_SHORT_3 = r4;
            Delay r5 = new Delay("OUI_ANIMATION_DELAY_SHORT_4", 4, 200);
            OUI_ANIMATION_DELAY_SHORT_4 = r5;
            Delay r6 = new Delay("OUI_ANIMATION_DELAY_MEDIUM_1", 5, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            OUI_ANIMATION_DELAY_MEDIUM_1 = r6;
            Delay r7 = new Delay("OUI_ANIMATION_DELAY_MEDIUM_2", 6, 300);
            OUI_ANIMATION_DELAY_MEDIUM_2 = r7;
            Delay r8 = new Delay("OUI_ANIMATION_DELAY_MEDIUM_3", 7, 350);
            OUI_ANIMATION_DELAY_MEDIUM_3 = r8;
            Delay r9 = new Delay("OUI_ANIMATION_DELAY_MEDIUM_4", 8, 400);
            OUI_ANIMATION_DELAY_MEDIUM_4 = r9;
            Delay r10 = new Delay("OUI_ANIMATION_DELAY_LONG_1", 9, BDVideoUploaderBase.KeyIsDynamicSliceHighSize);
            OUI_ANIMATION_DELAY_LONG_1 = r10;
            Delay r11 = new Delay("OUI_ANIMATION_DELAY_LONG_2", 10, 500);
            OUI_ANIMATION_DELAY_LONG_2 = r11;
            Delay r12 = new Delay("OUI_ANIMATION_DELAY_LONG_3", 11, 550);
            OUI_ANIMATION_DELAY_LONG_3 = r12;
            Delay r13 = new Delay("OUI_ANIMATION_DELAY_LONG_4", 12, 600);
            OUI_ANIMATION_DELAY_LONG_4 = r13;
            Delay r14 = new Delay("OUI_ANIMATION_DELAY_VERY_LONG_1", 13, TypedValues.TransitionType.TYPE_DURATION);
            OUI_ANIMATION_DELAY_VERY_LONG_1 = r14;
            Delay r15 = new Delay("OUI_ANIMATION_DELAY_VERY_LONG_2", 14, FdConfig.DEFAULT_FD_COUNT_THRESHOLD);
            OUI_ANIMATION_DELAY_VERY_LONG_2 = r15;
            Delay r16 = new Delay("OUI_ANIMATION_DELAY_VERY_LONG_3", 15, 900);
            OUI_ANIMATION_DELAY_VERY_LONG_3 = r16;
            Delay r17 = new Delay("OUI_ANIMATION_DELAY_VERY_LONG_4", 16, 1000);
            OUI_ANIMATION_DELAY_VERY_LONG_4 = r17;
            $VALUES = new Delay[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17};
        }

        private Delay(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static Delay valueOf(String r2) {
            return (Delay) ZeusTransformUtils.preCheckCast(Enum.valueOf(Delay.class, r2), Delay.class, "com.obric.memorydata.plugin");
        }

        public static Delay[] values() {
            return (Delay[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Delay[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "", "duration", "", "stiffness", "(Ljava/lang/String;III)V", "getDuration", "()I", "getStiffness", "OUI_ANIMATION_DURATION_SHORT_1", "OUI_ANIMATION_DURATION_SHORT_2", "OUI_ANIMATION_DURATION_SHORT_3", "OUI_ANIMATION_DURATION_SHORT_4", "OUI_ANIMATION_DURATION_MEDIUM_1", "OUI_ANIMATION_DURATION_MEDIUM_2", "OUI_ANIMATION_DURATION_MEDIUM_3", "OUI_ANIMATION_DURATION_MEDIUM_4", "OUI_ANIMATION_DURATION_LONG_1", "OUI_ANIMATION_DURATION_LONG_2", "OUI_ANIMATION_DURATION_LONG_3", "OUI_ANIMATION_DURATION_LONG_4", "OUI_ANIMATION_DURATION_VERY_LONG_1", "OUI_ANIMATION_DURATION_VERY_LONG_2", "OUI_ANIMATION_DURATION_VERY_LONG_3", "OUI_ANIMATION_DURATION_VERY_LONG_4", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Duration extends Enum<Duration> {
        private static final /* synthetic */ Duration[] $VALUES = null;
        public static final Duration OUI_ANIMATION_DURATION_LONG_1 = null;
        public static final Duration OUI_ANIMATION_DURATION_LONG_2 = null;
        public static final Duration OUI_ANIMATION_DURATION_LONG_3 = null;
        public static final Duration OUI_ANIMATION_DURATION_LONG_4 = null;
        public static final Duration OUI_ANIMATION_DURATION_MEDIUM_1 = null;
        public static final Duration OUI_ANIMATION_DURATION_MEDIUM_2 = null;
        public static final Duration OUI_ANIMATION_DURATION_MEDIUM_3 = null;
        public static final Duration OUI_ANIMATION_DURATION_MEDIUM_4 = null;
        public static final Duration OUI_ANIMATION_DURATION_SHORT_1 = null;
        public static final Duration OUI_ANIMATION_DURATION_SHORT_2 = null;
        public static final Duration OUI_ANIMATION_DURATION_SHORT_3 = null;
        public static final Duration OUI_ANIMATION_DURATION_SHORT_4 = null;
        public static final Duration OUI_ANIMATION_DURATION_VERY_LONG_1 = null;
        public static final Duration OUI_ANIMATION_DURATION_VERY_LONG_2 = null;
        public static final Duration OUI_ANIMATION_DURATION_VERY_LONG_3 = null;
        public static final Duration OUI_ANIMATION_DURATION_VERY_LONG_4 = null;
        private final int duration;
        private final int stiffness;

        static {
            Duration r1 = new Duration("OUI_ANIMATION_DURATION_SHORT_1", 0, 50, 15791);
            OUI_ANIMATION_DURATION_SHORT_1 = r1;
            Duration r2 = new Duration("OUI_ANIMATION_DURATION_SHORT_2", 1, 100, 3948);
            OUI_ANIMATION_DURATION_SHORT_2 = r2;
            Duration r3 = new Duration("OUI_ANIMATION_DURATION_SHORT_3", 2, AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD, 1755);
            OUI_ANIMATION_DURATION_SHORT_3 = r3;
            Duration r4 = new Duration("OUI_ANIMATION_DURATION_SHORT_4", 3, 200, 987);
            OUI_ANIMATION_DURATION_SHORT_4 = r4;
            Duration r5 = new Duration("OUI_ANIMATION_DURATION_MEDIUM_1", 4, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 632);
            OUI_ANIMATION_DURATION_MEDIUM_1 = r5;
            Duration r6 = new Duration("OUI_ANIMATION_DURATION_MEDIUM_2", 5, 300, UploadKeys.KeyIsEnd2EndEncryptionOption);
            OUI_ANIMATION_DURATION_MEDIUM_2 = r6;
            Duration r7 = new Duration("OUI_ANIMATION_DURATION_MEDIUM_3", 6, 350, 322);
            OUI_ANIMATION_DURATION_MEDIUM_3 = r7;
            Duration r8 = new Duration("OUI_ANIMATION_DURATION_MEDIUM_4", 7, 400, 247);
            OUI_ANIMATION_DURATION_MEDIUM_4 = r8;
            Duration r9 = new Duration("OUI_ANIMATION_DURATION_LONG_1", 8, BDVideoUploaderBase.KeyIsDynamicSliceHighSize, 195);
            OUI_ANIMATION_DURATION_LONG_1 = r9;
            Duration r10 = new Duration("OUI_ANIMATION_DURATION_LONG_2", 9, 500, 158);
            OUI_ANIMATION_DURATION_LONG_2 = r10;
            Duration r11 = new Duration("OUI_ANIMATION_DURATION_LONG_3", 10, 550, 131);
            OUI_ANIMATION_DURATION_LONG_3 = r11;
            Duration r12 = new Duration("OUI_ANIMATION_DURATION_LONG_4", 11, 600, 110);
            OUI_ANIMATION_DURATION_LONG_4 = r12;
            Duration r13 = new Duration("OUI_ANIMATION_DURATION_VERY_LONG_1", 12, TypedValues.TransitionType.TYPE_DURATION, 81);
            OUI_ANIMATION_DURATION_VERY_LONG_1 = r13;
            Duration r14 = new Duration("OUI_ANIMATION_DURATION_VERY_LONG_2", 13, FdConfig.DEFAULT_FD_COUNT_THRESHOLD, 62);
            OUI_ANIMATION_DURATION_VERY_LONG_2 = r14;
            Duration r15 = new Duration("OUI_ANIMATION_DURATION_VERY_LONG_3", 14, 900, 49);
            OUI_ANIMATION_DURATION_VERY_LONG_3 = r15;
            Duration r16 = new Duration("OUI_ANIMATION_DURATION_VERY_LONG_4", 15, 1000, 39);
            OUI_ANIMATION_DURATION_VERY_LONG_4 = r16;
            $VALUES = new Duration[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16};
        }

        private Duration(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.duration = r3;
            this.stiffness = r4;
        }

        public static Duration valueOf(String r2) {
            return (Duration) ZeusTransformUtils.preCheckCast(Enum.valueOf(Duration.class, r2), Duration.class, "com.obric.memorydata.plugin");
        }

        public static Duration[] values() {
            return (Duration[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Duration[].class, "com.obric.memorydata.plugin");
        }

        public final int getDuration() {
            return this.duration;
        }

        public final int getStiffness() {
            return this.stiffness;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0002\b\u001c\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\n\u0010\u0002\u001a\u00020\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "", "values", "", "", "(Ljava/lang/String;I[F)V", "getValues", "()[F", "OUI_ANIMATION_EASING_LINEAR", "OUI_ANIMATION_EASING_STANDARD", "OUI_ANIMATION_EASING_EASE", "OUI_ANIMATION_EASING_EASE_IN", "OUI_ANIMATION_EASING_EASE_OUT", "OUI_ANIMATION_EASING_EASE_IN_OUT", "OUI_ANIMATION_EASING_EASE_IN_SINE", "OUI_ANIMATION_EASING_EASE_OUT_SINE", "OUI_ANIMATION_EASING_EASE_IN_OUT_SINE", "OUI_ANIMATION_EASING_EASE_IN_QUAD", "OUI_ANIMATION_EASING_EASE_OUT_QUAD", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD", "OUI_ANIMATION_EASING_EASE_IN_CUBIC", "OUI_ANIMATION_EASING_EASE_OUT_CUBIC", "OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC", "OUI_ANIMATION_EASING_EASE_IN_QUART", "OUI_ANIMATION_EASING_EASE_OUT_QUART", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUART", "OUI_ANIMATION_EASING_EASE_IN_QUINT", "OUI_ANIMATION_EASING_EASE_OUT_QUINT", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT", "OUI_ANIMATION_EASING_EASE_IN_EXPO", "OUI_ANIMATION_EASING_EASE_OUT_EXPO", "OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Easing extends Enum<Easing> {
        private static final /* synthetic */ Easing[] $VALUES = null;
        public static final Easing OUI_ANIMATION_EASING_EASE = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_CUBIC = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_EXPO = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_OUT = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUART = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_OUT_SINE = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_QUAD = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_QUART = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_QUINT = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_IN_SINE = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_OUT = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_OUT_CUBIC = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_OUT_EXPO = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_OUT_QUAD = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_OUT_QUART = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_OUT_QUINT = null;
        public static final Easing OUI_ANIMATION_EASING_EASE_OUT_SINE = null;
        public static final Easing OUI_ANIMATION_EASING_LINEAR = null;
        public static final Easing OUI_ANIMATION_EASING_STANDARD = null;
        private final float[] values;

        static {
            Easing r1 = new Easing("OUI_ANIMATION_EASING_LINEAR", 0, new float[]{0.0f, 0.0f, 1.0f, 1.0f});
            OUI_ANIMATION_EASING_LINEAR = r1;
            Easing r2 = new Easing("OUI_ANIMATION_EASING_STANDARD", 1, new float[]{0.34f, 0.69f, 0.1f, 1.0f});
            OUI_ANIMATION_EASING_STANDARD = r2;
            Easing r3 = new Easing("OUI_ANIMATION_EASING_EASE", 2, new float[]{0.25f, 0.1f, 0.25f, 1.0f});
            OUI_ANIMATION_EASING_EASE = r3;
            Easing r4 = new Easing("OUI_ANIMATION_EASING_EASE_IN", 3, new float[]{0.42f, 0.0f, 1.0f, 1.0f});
            OUI_ANIMATION_EASING_EASE_IN = r4;
            Easing r5 = new Easing("OUI_ANIMATION_EASING_EASE_OUT", 4, new float[]{0.0f, 0.0f, 0.58f, 1.0f});
            OUI_ANIMATION_EASING_EASE_OUT = r5;
            Easing r6 = new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT", 5, new float[]{0.42f, 0.0f, 0.58f, 1.0f});
            OUI_ANIMATION_EASING_EASE_IN_OUT = r6;
            Easing r7 = new Easing("OUI_ANIMATION_EASING_EASE_IN_SINE", 6, new float[]{0.47f, 0.0f, 0.745f, 0.715f});
            OUI_ANIMATION_EASING_EASE_IN_SINE = r7;
            Easing r8 = new Easing("OUI_ANIMATION_EASING_EASE_OUT_SINE", 7, new float[]{0.39f, 0.575f, 0.565f, 1.0f});
            OUI_ANIMATION_EASING_EASE_OUT_SINE = r8;
            Easing r9 = new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_SINE", 8, new float[]{0.445f, 0.05f, 0.55f, 0.95f});
            OUI_ANIMATION_EASING_EASE_IN_OUT_SINE = r9;
            Easing r10 = new Easing("OUI_ANIMATION_EASING_EASE_IN_QUAD", 9, new float[]{0.26f, 0.0f, 0.6f, 0.2f});
            OUI_ANIMATION_EASING_EASE_IN_QUAD = r10;
            Easing r11 = new Easing("OUI_ANIMATION_EASING_EASE_OUT_QUAD", 10, new float[]{0.4f, 0.8f, 0.74f, 1.0f});
            OUI_ANIMATION_EASING_EASE_OUT_QUAD = r11;
            Easing r12 = new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD", 11, new float[]{0.48f, 0.04f, 0.52f, 0.96f});
            OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD = r12;
            Easing r13 = new Easing("OUI_ANIMATION_EASING_EASE_IN_CUBIC", 12, new float[]{0.4f, 0.0f, 0.68f, 0.06f});
            OUI_ANIMATION_EASING_EASE_IN_CUBIC = r13;
            Easing r14 = new Easing("OUI_ANIMATION_EASING_EASE_OUT_CUBIC", 13, new float[]{0.32f, 0.94f, 0.6f, 1.0f});
            OUI_ANIMATION_EASING_EASE_OUT_CUBIC = r14;
            Easing r15 = new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC", 14, new float[]{0.66f, 0.0f, 0.34f, 1.0f});
            OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC = r15;
            Easing r16 = new Easing("OUI_ANIMATION_EASING_EASE_IN_QUART", 15, new float[]{0.52f, 0.0f, 0.74f, 0.0f});
            OUI_ANIMATION_EASING_EASE_IN_QUART = r16;
            Easing r17 = new Easing("OUI_ANIMATION_EASING_EASE_OUT_QUART", 16, new float[]{0.26f, 1.0f, 0.48f, 1.0f});
            OUI_ANIMATION_EASING_EASE_OUT_QUART = r17;
            Easing r18 = new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUART", 17, new float[]{0.76f, 0.0f, 0.24f, 1.0f});
            OUI_ANIMATION_EASING_EASE_IN_OUT_QUART = r18;
            Easing r19 = new Easing("OUI_ANIMATION_EASING_EASE_IN_QUINT", 18, new float[]{0.64f, 0.0f, 0.78f, 0.0f});
            OUI_ANIMATION_EASING_EASE_IN_QUINT = r19;
            Easing r20 = new Easing("OUI_ANIMATION_EASING_EASE_OUT_QUINT", 19, new float[]{0.22f, 1.0f, 0.36f, 1.0f});
            OUI_ANIMATION_EASING_EASE_OUT_QUINT = r20;
            Easing r21 = new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT", 20, new float[]{0.84f, 0.0f, 0.16f, 1.0f});
            OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT = r21;
            Easing r22 = new Easing("OUI_ANIMATION_EASING_EASE_IN_EXPO", 21, new float[]{0.66f, 0.0f, 0.86f, 0.0f});
            OUI_ANIMATION_EASING_EASE_IN_EXPO = r22;
            Easing r23 = new Easing("OUI_ANIMATION_EASING_EASE_OUT_EXPO", 22, new float[]{0.14f, 1.0f, 0.34f, 1.0f});
            OUI_ANIMATION_EASING_EASE_OUT_EXPO = r23;
            Easing r24 = new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO", 23, new float[]{0.9f, 0.0f, 0.1f, 1.0f});
            OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO = r24;
            $VALUES = new Easing[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24};
        }

        private Easing(String r1, int r2, float... r3) {
            super(r1, r2);
            this.values = r3;
        }

        public static Easing valueOf(String r2) {
            return (Easing) ZeusTransformUtils.preCheckCast(Enum.valueOf(Easing.class, r2), Easing.class, "com.obric.memorydata.plugin");
        }

        public static Easing[] values() {
            return (Easing[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Easing[].class, "com.obric.memorydata.plugin");
        }

        public final float[] getValues() {
            return this.values;
        }
    }
}
