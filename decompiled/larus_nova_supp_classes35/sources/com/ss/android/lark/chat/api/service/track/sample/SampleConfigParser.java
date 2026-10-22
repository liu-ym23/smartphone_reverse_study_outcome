package com.ss.android.lark.chat.api.service.track.sample;

import com.ss.android.lark.chat.api.service.track.sample.handler.ReactionSampleSettingHandler;
import com.ss.android.lark.chat.api.service.track.sample.handler.ReadSampleSettingHandler;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.z;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/api/service/track/sample/SampleConfigParser;", BuildConfig.FLAVOR, "<init>", "()V", "initConfig", BuildConfig.FLAVOR, "parseReactionConfig", "Lcom/ss/android/lark/chat/api/service/track/sample/ReactionSampleReportConfig;", Keys.API_RETURN_KEY_DATA, BuildConfig.FLAVOR, "parseReadConfig", "Lcom/ss/android/lark/chat/api/service/track/sample/ReadSampleReportConfig;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SampleConfigParser {
    public static final a Companion = null;
    public static final String TAG = "SampleConfigParser";
    private static ReactionSampleReportConfig reactionConfig;
    private static ReadSampleReportConfig readConfig;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SampleConfigParser() {
    }

    public final void initConfig() {
        if (reactionConfig != null) goto L6;
        ReactionSampleSettingHandler r0 = ReactionSampleSettingHandler.i;
        reactionConfig = parseReactionConfig(AbstractBaseSettingHandler.e(r0, r0.d()));
    L6:
        if (readConfig != null) goto L9;
        ReadSampleSettingHandler r1 = ReadSampleSettingHandler.i;
        readConfig = parseReadConfig(AbstractBaseSettingHandler.e(r1, r1.d()));
        return;
    }

    public static final /* synthetic */ ReactionSampleReportConfig access$getReactionConfig$cp() {
        return reactionConfig;
    }

    public static final /* synthetic */ ReadSampleReportConfig access$getReadConfig$cp() {
        return readConfig;
    }

    public static final /* synthetic */ void access$setReactionConfig$cp(ReactionSampleReportConfig r0) {
        reactionConfig = r0;
    }

    public static final /* synthetic */ void access$setReadConfig$cp(ReadSampleReportConfig r0) {
        readConfig = r0;
    }

    public final ReactionSampleReportConfig parseReactionConfig(String r4) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        Log.i(TAG, "SampleConfigParser: " + r4);     // Catch: Exception -> L5
        return (ReactionSampleReportConfig) z.a(r4, ReactionSampleReportConfig.class);
    L5:
        e = move-exception;
        Log.e(TAG, "error: +" + e.getMessage() + ')');
        return null;
    }

    public final ReadSampleReportConfig parseReadConfig(String r4) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        Log.i(TAG, "SampleConfigParser: " + r4);     // Catch: Exception -> L5
        return (ReadSampleReportConfig) z.a(r4, ReadSampleReportConfig.class);
    L5:
        e = move-exception;
        Log.e(TAG, "error: +" + e.getMessage() + ')');
        return null;
    }
}
