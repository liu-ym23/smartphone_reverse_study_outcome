package com.larus.platform.model.video.sdkwrapper.feed;

import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00142\u00020\u0001:\t\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001cB/\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u0082\u0001\b\u001d\u001e\u001f !\"#$¨\u0006%"}, d2 = {"Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent;", "", "awemeId", "", "awemeType", "", "extra", "", "<init>", "(Ljava/lang/String;ILjava/util/Map;)V", "getAwemeId", "()Ljava/lang/String;", "setAwemeId", "(Ljava/lang/String;)V", "getAwemeType", "()I", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "Companion", "FirstFrame", "StartPlay", "StopPlay", "PausePlay", "ResumePlay", "CompletePlay", "RestartPlay", "PlayError", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$CompletePlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$FirstFrame;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$PausePlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$PlayError;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$RestartPlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$ResumePlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$StartPlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$StopPlay;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public abstract class CustomFeedPlayerEvent {
    public static final a Companion = null;
    public static final String EXTRA_KEY_REASON = "reason";
    public static final int REASON_ACTIVITY_LIFECYCLE = 3;
    public static final int REASON_METHOD_INVOCATION = 4;
    public static final int REASON_PERSONAL_PROFILE_PAGE = 2;
    public static final int REASON_UNKNOWN = 0;
    public static final int REASON_USER_INTERACTION = 1;
    private String awemeId;
    private final int awemeType;
    private Map<String, ? extends Object> extra;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$CompletePlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent;", "awemeId", "", "awemeType", "", "<init>", "(Ljava/lang/String;I)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class CompletePlay extends CustomFeedPlayerEvent {
        public CompletePlay(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "awemeId");
            Map r0 = null;
            super(r2, r3, r0, r0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$FirstFrame;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent;", "awemeId", "", "awemeType", "", "<init>", "(Ljava/lang/String;I)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class FirstFrame extends CustomFeedPlayerEvent {
        public FirstFrame(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "awemeId");
            Map r0 = null;
            super(r2, r3, r0, r0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$PausePlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent;", "awemeId", "", "awemeType", "", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "<init>", "(Ljava/lang/String;II)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class PausePlay extends CustomFeedPlayerEvent {
        public PausePlay(String r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "awemeId");
            super(r2, r3, MapsKt.mapOf(TuplesKt.to(CustomFeedPlayerEvent.EXTRA_KEY_REASON, Integer.valueOf(r4))), null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$PlayError;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent;", "awemeId", "", "awemeType", "", "<init>", "(Ljava/lang/String;I)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class PlayError extends CustomFeedPlayerEvent {
        public PlayError(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "awemeId");
            Map r0 = null;
            super(r2, r3, r0, r0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$RestartPlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent;", "awemeId", "", "awemeType", "", "<init>", "(Ljava/lang/String;I)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class RestartPlay extends CustomFeedPlayerEvent {
        public RestartPlay(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "awemeId");
            Map r0 = null;
            super(r2, r3, r0, r0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$ResumePlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent;", "awemeId", "", "awemeType", "", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "<init>", "(Ljava/lang/String;II)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class ResumePlay extends CustomFeedPlayerEvent {
        public ResumePlay(String r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "awemeId");
            super(r2, r3, MapsKt.mapOf(TuplesKt.to(CustomFeedPlayerEvent.EXTRA_KEY_REASON, Integer.valueOf(r4))), null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$StartPlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent;", "awemeId", "", "awemeType", "", "<init>", "(Ljava/lang/String;I)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class StartPlay extends CustomFeedPlayerEvent {
        public StartPlay(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "awemeId");
            Map r0 = null;
            super(r2, r3, r0, r0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent$StopPlay;", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomFeedPlayerEvent;", "awemeId", "", "awemeType", "", "<init>", "(Ljava/lang/String;I)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class StopPlay extends CustomFeedPlayerEvent {
        public StopPlay(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "awemeId");
            Map r0 = null;
            super(r2, r3, r0, r0);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public /* synthetic */ CustomFeedPlayerEvent(String r1, int r2, Map r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final int getAwemeType() {
        return this.awemeType;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final void setAwemeId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.awemeId = r2;
    }

    public final void setExtra(Map<String, ? extends Object> r1) {
        this.extra = r1;
    }

    private CustomFeedPlayerEvent(String r1, int r2, Map<String, ? extends Object> r3) {
        this.awemeId = r1;
        this.awemeType = r2;
        this.extra = r3;
    }
}
