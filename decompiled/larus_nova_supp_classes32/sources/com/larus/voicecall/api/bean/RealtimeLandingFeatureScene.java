package com.larus.voicecall.api.bean;

import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voicecall/api/bean/RealtimeLandingFeatureScene;", NameKeys.UnloadStrategy_No_Strategy, "scene", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "VIDEO", "CALL", "SCREEN_SHARE", "SCENE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealtimeLandingFeatureScene extends Enum<RealtimeLandingFeatureScene> {
    public static final RealtimeLandingFeatureScene CALL = null;
    public static final RealtimeLandingFeatureScene SCENE = null;
    public static final RealtimeLandingFeatureScene SCREEN_SHARE = null;
    public static final RealtimeLandingFeatureScene VIDEO = null;
    public static final /* synthetic */ RealtimeLandingFeatureScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String scene;

    public static EnumEntries<RealtimeLandingFeatureScene> getEntries() {
        return b;
    }

    static {
        RealtimeLandingFeatureScene r0 = new RealtimeLandingFeatureScene("VIDEO", 0, LynxResourceModule.VIDEO_TYPE);
        VIDEO = r0;
        RealtimeLandingFeatureScene r1 = new RealtimeLandingFeatureScene("CALL", 1, "call");
        CALL = r1;
        RealtimeLandingFeatureScene r2 = new RealtimeLandingFeatureScene("SCREEN_SHARE", 2, "screen_share");
        SCREEN_SHARE = r2;
        RealtimeLandingFeatureScene r4 = new RealtimeLandingFeatureScene("SCENE", 3, "scene");
        SCENE = r4;
        RealtimeLandingFeatureScene[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static RealtimeLandingFeatureScene[] values() {
        return (RealtimeLandingFeatureScene[]) a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static RealtimeLandingFeatureScene valueOf(String r1) {
        return (RealtimeLandingFeatureScene) a.a(RealtimeLandingFeatureScene.class, r1);
    }

    public RealtimeLandingFeatureScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.scene = r3;
    }
}
