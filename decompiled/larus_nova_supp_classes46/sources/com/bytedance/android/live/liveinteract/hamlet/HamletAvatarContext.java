package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0001|B\u0007¢\u0006\u0004\by\u0010zJ\u0006\u0010\u0004\u001a\u00020\u0003R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0016R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\u0016R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\u0016R!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\b\u001a\u0004\b!\u0010\nR#\u0010&\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R!\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\b\u001a\u0004\b+\u0010\u0016R!\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\b\u001a\u0004\b.\u0010\u0016R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b0\u0010\u0016R=\u00106\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u000203\u0018\u000102\u0012\f\u0012\n\u0012\u0004\u0012\u000203\u0018\u000102010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\b\u001a\u0004\b5\u0010\nR!\u00108\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\b\u001a\u0004\b8\u0010\u0016R!\u0010;\u001a\b\u0012\u0004\u0012\u00020$0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\b\u001a\u0004\b:\u0010\nR!\u0010>\u001a\b\u0012\u0004\u0012\u00020$0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\b\u001a\u0004\b=\u0010\nR!\u0010B\u001a\b\u0012\u0004\u0012\u00020?0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\b\u001a\u0004\bA\u0010\nR!\u0010E\u001a\b\u0012\u0004\u0012\u00020$0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\b\u001a\u0004\bD\u0010\u0016R!\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\b\u001a\u0004\bG\u0010\nR!\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\b\u001a\u0004\bJ\u0010\nR\"\u0010L\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010R\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010M\u001a\u0004\bS\u0010O\"\u0004\bT\u0010QR\"\u0010U\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bU\u0010W\"\u0004\bX\u0010YR!\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\b\u001a\u0004\b[\u0010\u0016R\"\u0010\\\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010V\u001a\u0004\b\\\u0010W\"\u0004\b]\u0010YR\"\u0010^\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010V\u001a\u0004\b^\u0010W\"\u0004\b_\u0010YR'\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0`0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\b\u001a\u0004\bc\u0010\nR$\u0010e\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010k\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010V\u001a\u0004\bl\u0010W\"\u0004\bm\u0010YR\"\u0010n\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010V\u001a\u0004\bo\u0010W\"\u0004\bp\u0010YR\"\u0010q\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010V\u001a\u0004\bq\u0010W\"\u0004\br\u0010YR\"\u0010s\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010x¨\u0006}"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/HamletAvatarContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/hamlet/i0;", "", "resetXplayState", "Lcom/bytedance/live/datacontext/n;", "", "currentState$delegate", "Lcom/bytedance/live/datacontext/p;", "getCurrentState", "()Lcom/bytedance/live/datacontext/n;", "currentState", "Lcom/bytedance/live/datacontext/j;", "Lgd0/g;", "hamletAvatarService$delegate", "getHamletAvatarService", "()Lcom/bytedance/live/datacontext/j;", "hamletAvatarService", "Lcom/bytedance/live/datacontext/m;", "", "isStreamRending$delegate", "isStreamRending", "()Lcom/bytedance/live/datacontext/m;", "isAvatarRending$delegate", "isAvatarRending", "directing$delegate", "getDirecting", "directing", "seiSubUILayout$delegate", "getSeiSubUILayout", "seiSubUILayout", "Lcom/bytedance/android/live/liveinteract/hamlet/model/l;", "chestPosition$delegate", "getChestPosition", "chestPosition", "", "", "", "downloadAvatarProgressRecord", "Ljava/util/Map;", "getDownloadAvatarProgressRecord", "()Ljava/util/Map;", "xplyStartMessageRecived$delegate", "getXplyStartMessageRecived", "xplyStartMessageRecived", "isSelfCPosition$delegate", "isSelfCPosition", "isRtcClientInitialized$delegate", "isRtcClientInitialized", "Lkotlin/Pair;", "", "", "cPositionList$delegate", "getCPositionList", "cPositionList", "isLipSyncModelDownloaded$delegate", "isLipSyncModelDownloaded", "currentSelectAvatarID$delegate", "getCurrentSelectAvatarID", "currentSelectAvatarID", "currentSelectAnimationIndex$delegate", "getCurrentSelectAnimationIndex", "currentSelectAnimationIndex", "Lorg/json/JSONArray;", "videoSimulcastJSONArray$delegate", "getVideoSimulcastJSONArray", "videoSimulcastJSONArray", "videoSimulcastIndex$delegate", "getVideoSimulcastIndex", "videoSimulcastIndex", "VADState$delegate", "getVADState", "VADState", "AEDState$delegate", "getAEDState", "AEDState", "xplayRetryCount", "I", "getXplayRetryCount", "()I", "setXplayRetryCount", "(I)V", "avatarLoadRetryCount", "getAvatarLoadRetryCount", "setAvatarLoadRetryCount", "isMultiAvatarModeForReport", "Z", "()Z", "setMultiAvatarModeForReport", "(Z)V", "isMultiAvatarMode$delegate", "isMultiAvatarMode", "isMainStreamPublicStreamReady", "setMainStreamPublicStreamReady", "isMainStreamServerMixedStart", "setMainStreamServerMixedStart", "", "Lcom/bytedance/android/live/liveinteract/hamlet/model/k;", "hamletAvatarUserInfos$delegate", "getHamletAvatarUserInfos", "hamletAvatarUserInfos", "hamletSeiAvatarList", "Ljava/lang/String;", "getHamletSeiAvatarList", "()Ljava/lang/String;", "setHamletSeiAvatarList", "(Ljava/lang/String;)V", "audienceMultiCamera", "getAudienceMultiCamera", "setAudienceMultiCamera", "playerHasMultiCamera", "getPlayerHasMultiCamera", "setPlayerHasMultiCamera", "isXplayAudioEnable", "setXplayAudioEnable", "playModeStartTs", "J", "getPlayModeStartTs", "()J", "setPlayModeStartTs", "(J)V", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class HamletAvatarContext extends DataContext implements i0 {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int STATE_INIT = 0;
    public static final int STATE_LOADED = 2;
    public static final int STATE_LOADING = 1;
    public static final int STATE_RUNNING = 3;
    public static final int STATE_STOPPED = 4;
    private final com.bytedance.live.datacontext.p AEDState$delegate;
    private final com.bytedance.live.datacontext.p VADState$delegate;
    private boolean audienceMultiCamera;
    private int avatarLoadRetryCount;
    private final com.bytedance.live.datacontext.p cPositionList$delegate;
    private final com.bytedance.live.datacontext.p chestPosition$delegate;
    private final com.bytedance.live.datacontext.p currentSelectAnimationIndex$delegate;
    private final com.bytedance.live.datacontext.p currentSelectAvatarID$delegate;
    private final com.bytedance.live.datacontext.p currentState$delegate;
    private final com.bytedance.live.datacontext.p directing$delegate;
    private final Map<Long, Float> downloadAvatarProgressRecord;
    private final com.bytedance.live.datacontext.p hamletAvatarService$delegate;
    private final com.bytedance.live.datacontext.p hamletAvatarUserInfos$delegate;
    private String hamletSeiAvatarList;
    private final com.bytedance.live.datacontext.p isAvatarRending$delegate;
    private final com.bytedance.live.datacontext.p isLipSyncModelDownloaded$delegate;
    private boolean isMainStreamPublicStreamReady;
    private boolean isMainStreamServerMixedStart;
    private final com.bytedance.live.datacontext.p isMultiAvatarMode$delegate;
    private boolean isMultiAvatarModeForReport;
    private final com.bytedance.live.datacontext.p isRtcClientInitialized$delegate;
    private final com.bytedance.live.datacontext.p isSelfCPosition$delegate;
    private final com.bytedance.live.datacontext.p isStreamRending$delegate;
    private boolean isXplayAudioEnable;
    private long playModeStartTs;
    private boolean playerHasMultiCamera;
    private final com.bytedance.live.datacontext.p seiSubUILayout$delegate;
    private final com.bytedance.live.datacontext.p videoSimulcastIndex$delegate;
    private final com.bytedance.live.datacontext.p videoSimulcastJSONArray$delegate;
    private int xplayRetryCount;
    private final com.bytedance.live.datacontext.p xplyStartMessageRecived$delegate;

    public static final class a {
        @JvmStatic
        public final HamletAvatarContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(i0.class);
            if ((r0 instanceof HamletAvatarContext) == true) goto L6;
            r0 = null;
        L6:
            return (HamletAvatarContext) r0;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "currentState", "getCurrentState()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "hamletAvatarService", "getHamletAvatarService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "isStreamRending", "isStreamRending()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "isAvatarRending", "isAvatarRending()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "directing", "getDirecting()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "seiSubUILayout", "getSeiSubUILayout()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "chestPosition", "getChestPosition()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "xplyStartMessageRecived", "getXplyStartMessageRecived()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "isSelfCPosition", "isSelfCPosition()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "isRtcClientInitialized", "isRtcClientInitialized()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "cPositionList", "getCPositionList()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "isLipSyncModelDownloaded", "isLipSyncModelDownloaded()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "currentSelectAvatarID", "getCurrentSelectAvatarID()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "currentSelectAnimationIndex", "getCurrentSelectAnimationIndex()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "videoSimulcastJSONArray", "getVideoSimulcastJSONArray()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "videoSimulcastIndex", "getVideoSimulcastIndex()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "VADState", "getVADState()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "AEDState", "getAEDState()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "isMultiAvatarMode", "isMultiAvatarMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HamletAvatarContext.class, "hamletAvatarUserInfos", "getHamletAvatarUserInfos()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final HamletAvatarContext getContext() {
        return Companion.getContext();
    }

    public final com.bytedance.live.datacontext.n<Integer> getAEDState() {
        return (com.bytedance.live.datacontext.n) this.AEDState$delegate.a(this, $$delegatedProperties[17]);
    }

    public final com.bytedance.live.datacontext.n<Pair<Set<String>, Set<String>>> getCPositionList() {
        return (com.bytedance.live.datacontext.n) this.cPositionList$delegate.a(this, $$delegatedProperties[10]);
    }

    public final com.bytedance.live.datacontext.n<com.bytedance.android.live.liveinteract.hamlet.model.l> getChestPosition() {
        return (com.bytedance.live.datacontext.n) this.chestPosition$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.n<Long> getCurrentSelectAnimationIndex() {
        return (com.bytedance.live.datacontext.n) this.currentSelectAnimationIndex$delegate.a(this, $$delegatedProperties[13]);
    }

    public final com.bytedance.live.datacontext.n<Long> getCurrentSelectAvatarID() {
        return (com.bytedance.live.datacontext.n) this.currentSelectAvatarID$delegate.a(this, $$delegatedProperties[12]);
    }

    public final com.bytedance.live.datacontext.n<Integer> getCurrentState() {
        return (com.bytedance.live.datacontext.n) this.currentState$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getDirecting() {
        return (com.bytedance.live.datacontext.m) this.directing$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.j<gd0.g> getHamletAvatarService() {
        return (com.bytedance.live.datacontext.j) this.hamletAvatarService$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.n<List<com.bytedance.android.live.liveinteract.hamlet.model.k>> getHamletAvatarUserInfos() {
        return (com.bytedance.live.datacontext.n) this.hamletAvatarUserInfos$delegate.a(this, $$delegatedProperties[19]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getSeiSubUILayout() {
        return (com.bytedance.live.datacontext.m) this.seiSubUILayout$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.n<Integer> getVADState() {
        return (com.bytedance.live.datacontext.n) this.VADState$delegate.a(this, $$delegatedProperties[16]);
    }

    public final com.bytedance.live.datacontext.m<Long> getVideoSimulcastIndex() {
        return (com.bytedance.live.datacontext.m) this.videoSimulcastIndex$delegate.a(this, $$delegatedProperties[15]);
    }

    public final com.bytedance.live.datacontext.n<JSONArray> getVideoSimulcastJSONArray() {
        return (com.bytedance.live.datacontext.n) this.videoSimulcastJSONArray$delegate.a(this, $$delegatedProperties[14]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getXplyStartMessageRecived() {
        return (com.bytedance.live.datacontext.m) this.xplyStartMessageRecived$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isAvatarRending() {
        return (com.bytedance.live.datacontext.m) this.isAvatarRending$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isLipSyncModelDownloaded() {
        return (com.bytedance.live.datacontext.m) this.isLipSyncModelDownloaded$delegate.a(this, $$delegatedProperties[11]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isMultiAvatarMode() {
        return (com.bytedance.live.datacontext.m) this.isMultiAvatarMode$delegate.a(this, $$delegatedProperties[18]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isRtcClientInitialized() {
        return (com.bytedance.live.datacontext.m) this.isRtcClientInitialized$delegate.a(this, $$delegatedProperties[9]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isSelfCPosition() {
        return (com.bytedance.live.datacontext.m) this.isSelfCPosition$delegate.a(this, $$delegatedProperties[8]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isStreamRending() {
        return (com.bytedance.live.datacontext.m) this.isStreamRending$delegate.a(this, $$delegatedProperties[2]);
    }

    public HamletAvatarContext() {
        this.currentState$delegate = com.bytedance.live.datacontext.q.c(this);
        this.hamletAvatarService$delegate = ConstantKt.c(this);
        Boolean r0 = Boolean.FALSE;
        this.isStreamRending$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.isAvatarRending$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.TRUE);
        this.directing$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.seiSubUILayout$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.chestPosition$delegate = com.bytedance.live.datacontext.q.c(this);
        this.downloadAvatarProgressRecord = new LinkedHashMap();
        this.xplyStartMessageRecived$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.isSelfCPosition$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.isRtcClientInitialized$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.cPositionList$delegate = com.bytedance.live.datacontext.q.c(this);
        this.isLipSyncModelDownloaded$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.currentSelectAvatarID$delegate = com.bytedance.live.datacontext.q.c(this);
        this.currentSelectAnimationIndex$delegate = com.bytedance.live.datacontext.q.c(this);
        this.videoSimulcastJSONArray$delegate = com.bytedance.live.datacontext.q.c(this);
        this.videoSimulcastIndex$delegate = com.bytedance.live.datacontext.q.d(this, -1L);
        this.VADState$delegate = com.bytedance.live.datacontext.q.c(this);
        this.AEDState$delegate = com.bytedance.live.datacontext.q.c(this);
        this.isMultiAvatarMode$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.hamletAvatarUserInfos$delegate = com.bytedance.live.datacontext.q.c(this);
    }

    public final void resetXplayState() {
        getCurrentState().setValue(0);
        com.bytedance.live.datacontext.m<Boolean> r0 = isStreamRending();
        Boolean r2 = Boolean.FALSE;
        r0.setValue(r2);
        this.isMainStreamPublicStreamReady = false;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.liveinteract.hamlet.model.l> r1 = getChestPosition();
        Double r4 = Double.valueOf(0.5d);
        r1.setValue(new com.bytedance.android.live.liveinteract.hamlet.model.l(r4, r4));
        getXplyStartMessageRecived().setValue(r2);
        this.isXplayAudioEnable = false;
        this.downloadAvatarProgressRecord.clear();
        if (gh0.a.d() == false) goto L5;
        isMultiAvatarMode().setValue(r2);
    L5:
        this.playerHasMultiCamera = false;
    }

    public final boolean getAudienceMultiCamera() {
        return this.audienceMultiCamera;
    }

    public final int getAvatarLoadRetryCount() {
        return this.avatarLoadRetryCount;
    }

    public final Map<Long, Float> getDownloadAvatarProgressRecord() {
        return this.downloadAvatarProgressRecord;
    }

    public final String getHamletSeiAvatarList() {
        return this.hamletSeiAvatarList;
    }

    public final long getPlayModeStartTs() {
        return this.playModeStartTs;
    }

    public final boolean getPlayerHasMultiCamera() {
        return this.playerHasMultiCamera;
    }

    public final int getXplayRetryCount() {
        return this.xplayRetryCount;
    }

    public final boolean isMainStreamPublicStreamReady() {
        return this.isMainStreamPublicStreamReady;
    }

    public final boolean isMainStreamServerMixedStart() {
        return this.isMainStreamServerMixedStart;
    }

    public final boolean isMultiAvatarModeForReport() {
        return this.isMultiAvatarModeForReport;
    }

    public final boolean isXplayAudioEnable() {
        return this.isXplayAudioEnable;
    }

    public final void setAudienceMultiCamera(boolean r1) {
        this.audienceMultiCamera = r1;
    }

    public final void setAvatarLoadRetryCount(int r1) {
        this.avatarLoadRetryCount = r1;
    }

    public final void setHamletSeiAvatarList(String r1) {
        this.hamletSeiAvatarList = r1;
    }

    public final void setMainStreamPublicStreamReady(boolean r1) {
        this.isMainStreamPublicStreamReady = r1;
    }

    public final void setMainStreamServerMixedStart(boolean r1) {
        this.isMainStreamServerMixedStart = r1;
    }

    public final void setMultiAvatarModeForReport(boolean r1) {
        this.isMultiAvatarModeForReport = r1;
    }

    public final void setPlayModeStartTs(long r1) {
        this.playModeStartTs = r1;
    }

    public final void setPlayerHasMultiCamera(boolean r1) {
        this.playerHasMultiCamera = r1;
    }

    public final void setXplayAudioEnable(boolean r1) {
        this.isXplayAudioEnable = r1;
    }

    public final void setXplayRetryCount(int r1) {
        this.xplayRetryCount = r1;
    }
}
