package com.bytedance.android.livesdk.interactivity.api.degrade.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface DegradeSceneLevel {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$AudienceExpLevel;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "Normal", "Degrade", "Enhance", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AudienceExpLevel extends Enum<AudienceExpLevel> implements DegradeSceneLevel {
        public static final AudienceExpLevel Degrade = null;
        public static final AudienceExpLevel Enhance = null;
        public static final AudienceExpLevel Normal = null;
        public static final /* synthetic */ AudienceExpLevel[] a = null;

        static {
            AudienceExpLevel r1 = new AudienceExpLevel("Normal", 0);
            Normal = r1;
            AudienceExpLevel r2 = new AudienceExpLevel("Degrade", 1);
            Degrade = r2;
            AudienceExpLevel r3 = new AudienceExpLevel("Enhance", 2);
            Enhance = r3;
            a = new AudienceExpLevel[]{r1, r2, r3};
        }

        public static AudienceExpLevel valueOf(String r1) {
            return (AudienceExpLevel) r27.a.a(AudienceExpLevel.class, r1);
        }

        public static AudienceExpLevel[] values() {
            return (AudienceExpLevel[]) a.clone();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }

        public AudienceExpLevel(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$Default;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "NONE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Default extends Enum<Default> implements DegradeSceneLevel {
        public static final Default NONE = null;
        public static final /* synthetic */ Default[] a = null;

        static {
            Default r1 = new Default();
            NONE = r1;
            a = new Default[]{r1};
        }

        public static Default valueOf(String r1) {
            return (Default) r27.a.a(Default.class, r1);
        }

        public static Default[] values() {
            return (Default[]) a.clone();
        }

        public Default() {
            super("NONE", 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$Ecom;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "HAPPEN", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Ecom extends Enum<Ecom> implements DegradeSceneLevel {
        public static final Ecom HAPPEN = null;
        public static final /* synthetic */ Ecom[] a = null;

        static {
            Ecom r1 = new Ecom();
            HAPPEN = r1;
            a = new Ecom[]{r1};
        }

        public static Ecom valueOf(String r1) {
            return (Ecom) r27.a.a(Ecom.class, r1);
        }

        public static Ecom[] values() {
            return (Ecom[]) a.clone();
        }

        public Ecom() {
            super("HAPPEN", 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$EnterRoomDuration;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "InEnterRoomDuration", "OutEnterRoomDuration", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EnterRoomDuration extends Enum<EnterRoomDuration> implements DegradeSceneLevel {
        public static final EnterRoomDuration InEnterRoomDuration = null;
        public static final EnterRoomDuration OutEnterRoomDuration = null;
        public static final /* synthetic */ EnterRoomDuration[] a = null;

        static {
            EnterRoomDuration r1 = new EnterRoomDuration("InEnterRoomDuration", 0);
            InEnterRoomDuration = r1;
            EnterRoomDuration r2 = new EnterRoomDuration("OutEnterRoomDuration", 1);
            OutEnterRoomDuration = r2;
            a = new EnterRoomDuration[]{r1, r2};
        }

        public static EnterRoomDuration valueOf(String r1) {
            return (EnterRoomDuration) r27.a.a(EnterRoomDuration.class, r1);
        }

        public static EnterRoomDuration[] values() {
            return (EnterRoomDuration[]) a.clone();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }

        public EnterRoomDuration(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$Game;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "HAPPEN", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Game extends Enum<Game> implements DegradeSceneLevel {
        public static final Game HAPPEN = null;
        public static final /* synthetic */ Game[] a = null;

        static {
            Game r1 = new Game();
            HAPPEN = r1;
            a = new Game[]{r1};
        }

        public static Game valueOf(String r1) {
            return (Game) r27.a.a(Game.class, r1);
        }

        public static Game[] values() {
            return (Game[]) a.clone();
        }

        public Game() {
            super("HAPPEN", 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$LowPerformancePhone;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "HAPPEN", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LowPerformancePhone extends Enum<LowPerformancePhone> implements DegradeSceneLevel {
        public static final LowPerformancePhone HAPPEN = null;
        public static final /* synthetic */ LowPerformancePhone[] a = null;

        static {
            LowPerformancePhone r1 = new LowPerformancePhone();
            HAPPEN = r1;
            a = new LowPerformancePhone[]{r1};
        }

        public static LowPerformancePhone valueOf(String r1) {
            return (LowPerformancePhone) r27.a.a(LowPerformancePhone.class, r1);
        }

        public static LowPerformancePhone[] values() {
            return (LowPerformancePhone[]) a.clone();
        }

        public LowPerformancePhone() {
            super("HAPPEN", 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$PerformanceFrame;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "LEVEL_ONE", "LEVEL_TWO", "LOW_BATTERY", "ANCHOR_OVERHEAT", "CLOSE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PerformanceFrame extends Enum<PerformanceFrame> implements DegradeSceneLevel {
        public static final PerformanceFrame ANCHOR_OVERHEAT = null;
        public static final PerformanceFrame CLOSE = null;
        public static final PerformanceFrame LEVEL_ONE = null;
        public static final PerformanceFrame LEVEL_TWO = null;
        public static final PerformanceFrame LOW_BATTERY = null;
        public static final /* synthetic */ PerformanceFrame[] a = null;

        static {
            PerformanceFrame r1 = new PerformanceFrame("LEVEL_ONE", 0);
            LEVEL_ONE = r1;
            PerformanceFrame r2 = new PerformanceFrame("LEVEL_TWO", 1);
            LEVEL_TWO = r2;
            PerformanceFrame r3 = new PerformanceFrame("LOW_BATTERY", 2);
            LOW_BATTERY = r3;
            PerformanceFrame r4 = new PerformanceFrame("ANCHOR_OVERHEAT", 3);
            ANCHOR_OVERHEAT = r4;
            PerformanceFrame r5 = new PerformanceFrame("CLOSE", 4);
            CLOSE = r5;
            a = new PerformanceFrame[]{r1, r2, r3, r4, r5};
        }

        public static PerformanceFrame valueOf(String r1) {
            return (PerformanceFrame) r27.a.a(PerformanceFrame.class, r1);
        }

        public static PerformanceFrame[] values() {
            return (PerformanceFrame[]) a.clone();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }

        public PerformanceFrame(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$PlatformFlowLikeDegradeLevel;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", BuildConfig.FLAVOR, "level", "I", "getLevel", "()I", "Companion", "a", "LEVEL_ONE", "LEVEL_TWO", "LEVEL_THREE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PlatformFlowLikeDegradeLevel extends Enum<PlatformFlowLikeDegradeLevel> implements DegradeSceneLevel {
        public static final a Companion = null;
        public static final PlatformFlowLikeDegradeLevel LEVEL_ONE = null;
        public static final PlatformFlowLikeDegradeLevel LEVEL_THREE = null;
        public static final PlatformFlowLikeDegradeLevel LEVEL_TWO = null;
        public static final /* synthetic */ PlatformFlowLikeDegradeLevel[] a = null;
        private final int level;

        public static final class a {
            public a() {
            }
        }

        static {
            PlatformFlowLikeDegradeLevel r2 = new PlatformFlowLikeDegradeLevel("LEVEL_ONE", 0, 1);
            LEVEL_ONE = r2;
            PlatformFlowLikeDegradeLevel r3 = new PlatformFlowLikeDegradeLevel("LEVEL_TWO", 1, 2);
            LEVEL_TWO = r3;
            PlatformFlowLikeDegradeLevel r4 = new PlatformFlowLikeDegradeLevel("LEVEL_THREE", 2, 3);
            LEVEL_THREE = r4;
            a = new PlatformFlowLikeDegradeLevel[]{r2, r3, r4};
            Companion = new a();
        }

        public static PlatformFlowLikeDegradeLevel valueOf(String r1) {
            return (PlatformFlowLikeDegradeLevel) r27.a.a(PlatformFlowLikeDegradeLevel.class, r1);
        }

        public static PlatformFlowLikeDegradeLevel[] values() {
            return (PlatformFlowLikeDegradeLevel[]) a.clone();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }

        public final int getLevel() {
            return this.level;
        }

        public PlatformFlowLikeDegradeLevel(String r1, int r2, int r3) {
            super(r1, r2);
            this.level = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$PlatformTapLikeDegradeLevel;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", BuildConfig.FLAVOR, "level", "I", "getLevel", "()I", "Companion", "a", "LEVEL_ONE", "LEVEL_TWO", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PlatformTapLikeDegradeLevel extends Enum<PlatformTapLikeDegradeLevel> implements DegradeSceneLevel {
        public static final a Companion = null;
        public static final PlatformTapLikeDegradeLevel LEVEL_ONE = null;
        public static final PlatformTapLikeDegradeLevel LEVEL_TWO = null;
        public static final /* synthetic */ PlatformTapLikeDegradeLevel[] a = null;
        private final int level;

        public static final class a {
            public a() {
            }
        }

        static {
            PlatformTapLikeDegradeLevel r2 = new PlatformTapLikeDegradeLevel("LEVEL_ONE", 0, 1);
            LEVEL_ONE = r2;
            PlatformTapLikeDegradeLevel r3 = new PlatformTapLikeDegradeLevel("LEVEL_TWO", 1, 2);
            LEVEL_TWO = r3;
            a = new PlatformTapLikeDegradeLevel[]{r2, r3};
            Companion = new a();
        }

        public static PlatformTapLikeDegradeLevel valueOf(String r1) {
            return (PlatformTapLikeDegradeLevel) r27.a.a(PlatformTapLikeDegradeLevel.class, r1);
        }

        public static PlatformTapLikeDegradeLevel[] values() {
            return (PlatformTapLikeDegradeLevel[]) a.clone();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }

        public final int getLevel() {
            return this.level;
        }

        public PlatformTapLikeDegradeLevel(String r1, int r2, int r3) {
            super(r1, r2);
            this.level = r3;
        }
    }

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static String a(DegradeSceneLevel r1) {
            if ((r1 instanceof Enum) == false) goto L6;
            return ((Enum) r1).name();
        L6:
            return r1.getClass().getSimpleName();
        }
    }

    String logName();
}
