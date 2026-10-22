package com.obric.sva.sdk.logger;

import com.bytedance.crash.dumper.Scraps;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J,\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016¨\u0006\u001b"}, d2 = {"Lcom/obric/sva/sdk/logger/LoggerImpl;", "Lcom/obric/sva/sdk/logger/ILogger;", "<init>", "()V", "isDebug", "", "getDirPath", "", "v", "", "tag", "msg", "d", "i", "tr", "", "w", "e", "s", "category", "Lcom/obric/sva/sdk/logger/SpecialCategory;", "uploadAllLog", "scene", Scraps.INNER_UNIT, "Lkotlin/Function1;", "flush", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class LoggerImpl implements ILogger {
    public static final Companion Companion = null;
    private static final String LOG_TAG_PREFIX = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/sva/sdk/logger/LoggerImpl$Companion;", "", "<init>", "()V", "LOG_TAG_PREFIX", "", "getLOG_TAG_PREFIX", "()Ljava/lang/String;", "withLogTagPrefix", "tag", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String getLOG_TAG_PREFIX() {
            return LoggerImpl.access$getLOG_TAG_PREFIX$cp();
        }

        private final String withLogTagPrefix(String r5) {
            if (StringsKt.startsWith$default(r5, getLOG_TAG_PREFIX(), false, 2, null) == false) goto L6;
            return r5;
        L6:
            return getLOG_TAG_PREFIX() + r5;
        }

        public static final /* synthetic */ String access$withLogTagPrefix(Companion r0, String r1) {
            return r0.withLogTagPrefix(r1);
        }
    }

    public LoggerImpl() {
    }

    static {
        Companion = new Companion(null);
        LOG_TAG_PREFIX = "SVA-";
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void flush() {
        Logger.INSTANCE.flush();
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public String getDirPath() {
        return Logger.INSTANCE.getDirPath();
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public boolean isDebug() {
        return Logger.INSTANCE.isDebug();
    }

    public static final /* synthetic */ String access$getLOG_TAG_PREFIX$cp() {
        return LOG_TAG_PREFIX;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Logger.INSTANCE.d(Companion.access$withLogTagPrefix(Companion, r3), r4);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Logger.INSTANCE.e(Companion.access$withLogTagPrefix(Companion, r3), r4);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void i(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Logger.INSTANCE.i(Companion.access$withLogTagPrefix(Companion, r3), r4);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void special(String r1, SpecialCategory r2) {
        ILogger.DefaultImpls.special(this, r1, r2);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void uploadAllLog(String r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Logger.INSTANCE.uploadAllLog(r2, r3);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void v(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Logger.INSTANCE.v(Companion.access$withLogTagPrefix(Companion, r3), r4);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void w(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Logger.INSTANCE.w(Companion.access$withLogTagPrefix(Companion, r3), r4);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void w(String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Logger.INSTANCE.w(Companion.access$withLogTagPrefix(Companion, r3), r4);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void e(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Logger.INSTANCE.e(Companion.access$withLogTagPrefix(Companion, r3), r4, r5);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void i(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Logger.INSTANCE.i(Companion.access$withLogTagPrefix(Companion, r2), r3);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void s(String r3, String r4, SpecialCategory r5) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r5, "category");
        Logger.INSTANCE.i(Companion.access$withLogTagPrefix(Companion, r3), r4);
        special(r4, r5);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void w(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Logger.INSTANCE.w(Companion.access$withLogTagPrefix(Companion, r3), r4, r5);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void s(String r2, String r3, Throwable r4, SpecialCategory r5) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r5, "category");
        Logger.INSTANCE.i(Companion.access$withLogTagPrefix(Companion, r2), r3);
        special(r3, r5);
    }
}
