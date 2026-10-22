package com.obric.cae.smartNetwork.networkHandoverRL;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;
import com.obric.cae.log.CaeLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ModelSettingObserver {
    private static final int CONTINUOUS_COUNT_AGGRESSIVE = 2;
    private static final int CONTINUOUS_COUNT_DEFAULT = 3;
    private static final float CONTINUOUS_HANDOVER_THRESHOLD = 0.9f;
    private static final float EMA_ALPHA_AGGRESSIVE = 0.8f;
    private static final float EMA_ALPHA_DEFAULT = 0.5f;
    public static final String GLOBAL_SETTINGS_CLUSTER_NETWORK_HANDOVER_ENABLED = "global_cluster_network_handover_enabled";
    private static final String GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_AGGRESSIVE = "global_rl_continuous_count_aggressive";
    private static final String GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_DEFAULT = "global_rl_continuous_count_default";
    private static final String GLOBAL_SETTINGS_RL_CONTINUOUS_HANDOVER_THRESHOLD = "global_rl_continuous_handover_threshold";
    private static final String GLOBAL_SETTINGS_RL_EMA_ALPHA_AGGRESSIVE = "global_rl_ema_alpha_aggressive";
    private static final String GLOBAL_SETTINGS_RL_EMA_ALPHA_DEFAULT = "global_rl_ema_alpha_default";
    public static final String GLOBAL_SETTINGS_RL_NETWORK_HANDOVER_ENABLED = "global_rl_network_handover_enabled";
    private static final String GLOBAL_SETTINGS_RL_PREDICT_HANDOVER_NUM = "global_rl_predict_handover_num";
    private static final String GLOBAL_SETTINGS_RL_PREDICT_SWITCH_THRESHOLD = "global_rl_predict_switch_threshold";
    private static final String GLOBAL_SETTINGS_RL_PREDICT_UNSWITCH_THRESHOLD = "global_rl_predict_unswitch_threshold";
    private static final String GLOBAL_SETTINGS_RL_SATISFIED_HANDOVER_TIMEOUT_MS = "global_rl_satisfied_handover_timeout_ms";
    private static final String GLOBAL_SETTINGS_RL_SMOOTH_HANDOVER_THRESHOLD = "global_rl_smooth_handover_threshold";
    public static final int PREDICT_FAST_HANDOVER_NUM = 3;
    public static final int PREDICT_HANDOVER_NUM = 5;
    private static final float PREDICT_SWITCH_THRESHOLD = 0.8f;
    private static final float PREDICT_UNSWITCH_NUM_LOW = 0.5f;
    private static final int SATISFIED_HANDOVER_TIMEOUT_MS = 30000;
    private static final float SMOOTH_HANDOVER_THRESHOLD = 0.8f;
    private static final String TAG = "ModelSettingObserver";
    private static volatile ModelSettingObserver sInstance;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final SettingObserver mSettingObserver;
    private final List<Uri> mSettingUris;

    public class SettingObserver extends ContentObserver {
        final /* synthetic */ ModelSettingObserver this$0;

        public SettingObserver(ModelSettingObserver r8) {
            this.this$0 = r8;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8) {
            CaeLog.e(ModelSettingObserver.TAG, "Should never be reached.");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            if (ModelSettingObserver.access$000(this.this$0).contains(r10) == true) goto L5;
            CaeLog.e(ModelSettingObserver.TAG, "Unexpected settings observation: " + r10);
        L5:
            CaeLog.d(ModelSettingObserver.TAG, "onChange: " + r10);
        }
    }

    private ModelSettingObserver(Context r13) {
        this.mContext = r13;
        this.mContentResolver = r13.getContentResolver();
        this.mSettingObserver = new SettingObserver(this);
        List<Uri> r14 = Arrays.asList(new Uri[]{Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_NETWORK_HANDOVER_ENABLED), Settings.Global.getUriFor(GLOBAL_SETTINGS_CLUSTER_NETWORK_HANDOVER_ENABLED), Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_PREDICT_HANDOVER_NUM), Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_PREDICT_SWITCH_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_PREDICT_UNSWITCH_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_SATISFIED_HANDOVER_TIMEOUT_MS), Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_SMOOTH_HANDOVER_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_CONTINUOUS_HANDOVER_THRESHOLD), Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_EMA_ALPHA_DEFAULT), Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_EMA_ALPHA_AGGRESSIVE), Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_DEFAULT), Settings.Global.getUriFor(GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_AGGRESSIVE)});
        this.mSettingUris = r14;
        Iterator<Uri> r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        Uri r8 = r15.next();
        this.mContentResolver.registerContentObserver(r8, false, this.mSettingObserver);
        goto L4
    }

    public static /* synthetic */ List access$000(ModelSettingObserver r8) {
        return r8.mSettingUris;
    }

    public static ModelSettingObserver getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(ModelSettingObserver.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ModelSettingObserver(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ModelSettingObserver.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void setClusterHandoverEnabled(boolean r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_CLUSTER_NETWORK_HANDOVER_ENABLED, r8 ? 1 : 0);
    }

    private void setContinuousCountAggressive(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_AGGRESSIVE, r8);
    }

    private void setContinuousCountDefault(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_DEFAULT, r8);
    }

    private void setContinuousHandoverThreshold(float r8) {
        Settings.Global.putFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_CONTINUOUS_HANDOVER_THRESHOLD, r8);
    }

    private void setEmaAlphaAggressive(float r8) {
        Settings.Global.putFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_EMA_ALPHA_AGGRESSIVE, r8);
    }

    private void setEmaAlphaDefault(float r8) {
        Settings.Global.putFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_EMA_ALPHA_DEFAULT, r8);
    }

    private void setPredictHandoverNum(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RL_PREDICT_HANDOVER_NUM, r8);
    }

    private void setPredictSwitchThreshold(float r8) {
        Settings.Global.putFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_PREDICT_SWITCH_THRESHOLD, r8);
    }

    private void setPredictUnswitchThreshold(float r8) {
        Settings.Global.putFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_PREDICT_UNSWITCH_THRESHOLD, r8);
    }

    private void setRlHandoverEnabled(boolean r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RL_NETWORK_HANDOVER_ENABLED, r8 ? 1 : 0);
    }

    private void setSatisfiedHandoverTimeoutMs(int r8) {
        Settings.Global.putInt(this.mContentResolver, GLOBAL_SETTINGS_RL_SATISFIED_HANDOVER_TIMEOUT_MS, r8);
    }

    private void setSmoothHandoverThreshold(float r8) {
        Settings.Global.putFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_SMOOTH_HANDOVER_THRESHOLD, r8);
    }

    public boolean getClusterHandoverEnabled() {
        if (Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_CLUSTER_NETWORK_HANDOVER_ENABLED, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public int getContinuousCountAggressive() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_AGGRESSIVE, 2);
    }

    public int getContinuousCountDefault() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_DEFAULT, 3);
    }

    public float getContinuousHandoverThreshold() {
        return Settings.Global.getFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_CONTINUOUS_HANDOVER_THRESHOLD, CONTINUOUS_HANDOVER_THRESHOLD);
    }

    public float getEmaAlphaAggressive() {
        return Settings.Global.getFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_EMA_ALPHA_AGGRESSIVE, 0.8f);
    }

    public float getEmaAlphaDefault() {
        return Settings.Global.getFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_EMA_ALPHA_DEFAULT, 0.5f);
    }

    public int getPredictHandoverNum() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RL_PREDICT_HANDOVER_NUM, 5);
    }

    public float getPredictSwitchThreshold() {
        return Settings.Global.getFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_PREDICT_SWITCH_THRESHOLD, 0.8f);
    }

    public float getPredictUnswitchThreshold() {
        return Settings.Global.getFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_PREDICT_UNSWITCH_THRESHOLD, 0.5f);
    }

    public boolean getRlHandoverEnabled() {
        if (Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RL_NETWORK_HANDOVER_ENABLED, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public int getSatisfiedHandoverTimeoutMs() {
        return Settings.Global.getInt(this.mContentResolver, GLOBAL_SETTINGS_RL_SATISFIED_HANDOVER_TIMEOUT_MS, 30000);
    }

    public float getSmoothHandoverThreshold() {
        return Settings.Global.getFloat(this.mContentResolver, GLOBAL_SETTINGS_RL_SMOOTH_HANDOVER_THRESHOLD, 0.8f);
    }

    public void setPredictFastHandoverNum(int r8) {
        setPredictHandoverNum(r8);
    }

    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: TypeSearchVarInfo not found in map for var: r13v0 ??
    	at jadx.core.dex.visitors.typeinference.TypeSearchState.getVarInfo(TypeSearchState.java:34)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.lambda$resolveIndependentVariables$1(TypeSearch.java:173)
    	at java.base/java.util.stream.MatchOps$1MatchSink.accept(MatchOps.java:90)
    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.test(ReferencePipeline.java:306)
    	at java.base/java.util.stream.MatchOps$1MatchSink.accept(MatchOps.java:90)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1701)
    	at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:147)
    	at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:588)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:574)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:230)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:196)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
    	at java.base/java.util.stream.ReferencePipeline.allMatch(ReferencePipeline.java:673)
    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.accept(ReferencePipeline.java:291)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1701)
    	at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:147)
    	at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:588)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:574)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:230)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:196)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
    	at java.base/java.util.stream.ReferencePipeline.allMatch(ReferencePipeline.java:673)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.resolveIndependentVariables(TypeSearch.java:173)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:63)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v25, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r16v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v2 */
    public void updateHandoverModelToggle(JSONObject r19) {
        boolean r17 = false;
        boolean r8 = true;
        if (r19.has(GLOBAL_SETTINGS_RL_NETWORK_HANDOVER_ENABLED) == true) goto L6;
        boolean r14 = getRlHandoverEnabled();     // Catch: Exception -> L66
    L10:
        ?? r13 = r19.has(GLOBAL_SETTINGS_CLUSTER_NETWORK_HANDOVER_ENABLED);     // Catch: Exception -> L66
        if (r13 != 0) goto L13;
        r17 = getClusterHandoverEnabled();     // Catch: Exception -> L66
    L16:
        r8 = r17;
    L18:
        if (r19.has(GLOBAL_SETTINGS_RL_PREDICT_HANDOVER_NUM) == false) goto L20;
        int r11 = r19.getInt(GLOBAL_SETTINGS_RL_PREDICT_HANDOVER_NUM);     // Catch: Exception -> L66
    L21:
        if (r19.has(GLOBAL_SETTINGS_RL_PREDICT_SWITCH_THRESHOLD) == true) goto L24;
        float r10 = getPredictSwitchThreshold();     // Catch: Exception -> L64
    L27:
        if (r19.has(GLOBAL_SETTINGS_RL_PREDICT_UNSWITCH_THRESHOLD) == false) goto L29;
        float r12 = (float) r19.getDouble(GLOBAL_SETTINGS_RL_PREDICT_UNSWITCH_THRESHOLD);     // Catch: Exception -> L64
    L31:
        if (r19.has(GLOBAL_SETTINGS_RL_SATISFIED_HANDOVER_TIMEOUT_MS) == false) goto L33;
        int r15 = r19.getInt(GLOBAL_SETTINGS_RL_SATISFIED_HANDOVER_TIMEOUT_MS);     // Catch: Exception -> L64
    L35:
        if (r19.has(GLOBAL_SETTINGS_RL_SMOOTH_HANDOVER_THRESHOLD) == false) goto L37;
        float r16 = (float) r19.getDouble(GLOBAL_SETTINGS_RL_SMOOTH_HANDOVER_THRESHOLD);     // Catch: Exception -> L64
    L39:
        if (r19.has(GLOBAL_SETTINGS_RL_CONTINUOUS_HANDOVER_THRESHOLD) == false) goto L41;
        float r18 = (float) r19.getDouble(GLOBAL_SETTINGS_RL_CONTINUOUS_HANDOVER_THRESHOLD);     // Catch: Exception -> L64
    L43:
        if (r19.has(GLOBAL_SETTINGS_RL_EMA_ALPHA_DEFAULT) == false) goto L45;
        float r20 = (float) r19.getDouble(GLOBAL_SETTINGS_RL_EMA_ALPHA_DEFAULT);     // Catch: Exception -> L64
    L47:
        if (r19.has(GLOBAL_SETTINGS_RL_EMA_ALPHA_AGGRESSIVE) == false) goto L49;
        float r21 = (float) r19.getDouble(GLOBAL_SETTINGS_RL_EMA_ALPHA_AGGRESSIVE);     // Catch: Exception -> L64
    L51:
        if (r19.has(GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_DEFAULT) == false) goto L53;
        int r22 = r19.getInt(GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_DEFAULT);     // Catch: Exception -> L64
    L55:
        if (r19.has(GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_AGGRESSIVE) == false) goto L57;
        int r23 = r19.getInt(GLOBAL_SETTINGS_RL_CONTINUOUS_COUNT_AGGRESSIVE);     // Catch: Exception -> L64
    L58:
        String r24 = "update handover model toggle, RlHandoverEnabled:" + r14 + ", ClusterHandoverEnabled:" + r8 + ", PredictHandoverNum:" + r11 + ", PredictSwitchThreshold:" + r10 + ", PredictUnswitchThreshold:" + r12 + ", SatisfiedHandoverTimeoutMs:" + r15 + ", SmoothHandoverThreshold:" + r16 + ", ContinuousHandoverThreshold:" + r18 + ", EmaAlphaDefault:" + r20 + ", EmaAlphaAggressive:" + r21 + ", ContinuousCountDefault:" + r22 + ", ContinuousCountAggressive:" + r23;     // Catch: Exception -> L64
        ?? r110 = TAG;
        CaeLog.i(r110, r24);     // Catch: Exception -> L62
        setRlHandoverEnabled(r14);     // Catch: Exception -> L62
        setClusterHandoverEnabled(r8);     // Catch: Exception -> L62
        setPredictHandoverNum(r11);     // Catch: Exception -> L62
        setPredictSwitchThreshold(r10);     // Catch: Exception -> L62
        setPredictUnswitchThreshold(r12);     // Catch: Exception -> L62
        setSatisfiedHandoverTimeoutMs(r15);     // Catch: Exception -> L62
        setSmoothHandoverThreshold(r16);     // Catch: Exception -> L62
        setContinuousHandoverThreshold(r18);     // Catch: Exception -> L62
        setEmaAlphaDefault(r20);     // Catch: Exception -> L62
        setEmaAlphaAggressive(r21);     // Catch: Exception -> L62
        setContinuousCountDefault(r22);     // Catch: Exception -> L62
        setContinuousCountAggressive(r23);     // Catch: Exception -> L62
        return;
    L62:
        e = e;
    L68:
        android.aimedia.a.q("updateHandoverModelSwitch: ", e, r110);
        return;
    L57:
        r23 = getContinuousCountAggressive();     // Catch: Exception -> L64
        goto L58
    L53:
        r22 = getContinuousCountDefault();     // Catch: Exception -> L64
        goto L55
    L49:
        r21 = getEmaAlphaAggressive();     // Catch: Exception -> L64
        goto L51
    L45:
        r20 = getEmaAlphaDefault();     // Catch: Exception -> L64
        goto L47
    L41:
        r18 = getContinuousHandoverThreshold();     // Catch: Exception -> L64
        goto L43
    L37:
        r16 = getSmoothHandoverThreshold();     // Catch: Exception -> L64
        goto L39
    L33:
        r15 = getSatisfiedHandoverTimeoutMs();     // Catch: Exception -> L64
        goto L35
    L29:
        r12 = getPredictUnswitchThreshold();     // Catch: Exception -> L64
        goto L31
    L24:
        r10 = (float) r19.getDouble(GLOBAL_SETTINGS_RL_PREDICT_SWITCH_THRESHOLD);     // Catch: Exception -> L64
    L64:
        e = e;
        r110 = r13;
        goto L68
    L20:
        r11 = getPredictHandoverNum();     // Catch: Exception -> L66
        goto L21
    L13:
        if (r19.getInt(GLOBAL_SETTINGS_CLUSTER_NETWORK_HANDOVER_ENABLED) != 1) goto L16;
    L6:
        if (r19.getInt(GLOBAL_SETTINGS_RL_NETWORK_HANDOVER_ENABLED) != 1) goto L8;
        r14 = true;
        goto L10
    L8:
        r14 = false;
    L66:
        e = e;
        r110 = TAG;
        goto L68
    }
}
