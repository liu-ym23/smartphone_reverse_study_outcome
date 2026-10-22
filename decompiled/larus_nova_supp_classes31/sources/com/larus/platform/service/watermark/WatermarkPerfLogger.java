package com.larus.platform.service.watermark;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class WatermarkPerfLogger {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/larus/platform/service/watermark/WatermarkPerfLogger$Path;", "", "<init>", "(Ljava/lang/String;I)V", "A", "B_LOCAL", "B_FILE", "NONE", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum Path extends Enum<Path> {
        public static final Path A = null;
        public static final Path B_FILE = null;
        public static final Path B_LOCAL = null;
        public static final a Companion = null;
        public static final Path NONE = null;
        public static final /* synthetic */ Path[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }

            public static Path a(String r4) {
                Intrinsics.checkNotNullParameter(r4, "input");
                if (r4.length() != 0) goto L5;
                boolean r0 = true;
            L6:
                if (r0 == true) goto L27;
                DownloadWatermarkService.a.getClass();
                if (DownloadWatermarkService.d() == true) goto L12;
                return Path.NONE;
            L12:
                if (StringsKt.startsWith(r4, "http://", true) == true) goto L26;
                if (StringsKt.startsWith(r4, "https://", true) == true) goto L26;
                if (StringsKt.startsWith$default(r4, "data:", false, 2, null) == false) goto L22;
                if (StringsKt.contains$default(r4, "base64", false, 2, null) == false) goto L22;
                return Path.NONE;
            L22:
                if (StringsKt.startsWith$default(r4, "file", false, 2, null) == false) goto L31;
                return Path.B_LOCAL;
            L31:
                return Path.B_LOCAL;
            L26:
                return Path.A;
            L27:
                return Path.NONE;
            L5:
                r0 = false;
                goto L6
            }
        }

        public static EnumEntries<Path> getEntries() {
            return b;
        }

        static {
            Path r0 = new Path("A", 0);
            A = r0;
            Path r1 = new Path("B_LOCAL", 1);
            B_LOCAL = r1;
            Path r3 = new Path("B_FILE", 2);
            B_FILE = r3;
            Path r5 = new Path("NONE", 3);
            NONE = r5;
            Path[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
        }

        public static Path[] values() {
            return (Path[]) a.clone();
        }

        public static Path valueOf(String r1) {
            return (Path) r27.a.a(Path.class, r1);
        }

        public Path(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/service/watermark/WatermarkPerfLogger$Result;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAIL", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum Result extends Enum<Result> {
        public static final Result FAIL = null;
        public static final Result SUCCESS = null;
        public static final /* synthetic */ Result[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Result> getEntries() {
            return b;
        }

        static {
            Result r0 = new Result("SUCCESS", 0);
            SUCCESS = r0;
            Result r1 = new Result("FAIL", 1);
            FAIL = r1;
            Result[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Result[] values() {
            return (Result[]) a.clone();
        }

        public static Result valueOf(String r1) {
            return (Result) r27.a.a(Result.class, r1);
        }

        public Result(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/service/watermark/WatermarkPerfLogger$Version;", "", "<init>", "(Ljava/lang/String;I)V", "ENTERPRISE", "PERSONAL", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum Version extends Enum<Version> {
        public static final Version ENTERPRISE = null;
        public static final Version PERSONAL = null;
        public static final /* synthetic */ Version[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Version> getEntries() {
            return b;
        }

        static {
            Version r0 = new Version("ENTERPRISE", 0);
            ENTERPRISE = r0;
            Version r1 = new Version("PERSONAL", 1);
            PERSONAL = r1;
            Version[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Version[] values() {
            return (Version[]) a.clone();
        }

        public static Version valueOf(String r1) {
            return (Version) r27.a.a(Version.class, r1);
        }

        public Version(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final Version b;
        public final DownloadWatermarkScene c;
        public final long d;
        public long e;
        public Path f;
        public final List<Pair<String, Long>> g;
        public volatile boolean h;

        public final void a(String r6) {
            Intrinsics.checkNotNullParameter(r6, "name");
            long r0 = System.currentTimeMillis();
            List<Pair<String, Long>> r2 = this.g;
            ArrayList r3 = (ArrayList) r2;
            r3.add(TuplesKt.to(r6, Long.valueOf(r0 - this.e)));
            this.e = r0;
        }

        public final void c(Path r2) {
            Intrinsics.checkNotNullParameter(r2, "path");
            this.f = r2;
        }

        public final void b(Result r13, String r14) {
            Intrinsics.checkNotNullParameter(r13, "result");
            if (this.h == false) goto L5;
            return;
        L5:
            this.h = true;
            long r1 = System.currentTimeMillis() - this.d;
            String r3 = CollectionsKt.joinToString$default(this.g, ",", null, null, 0, null, new e(), 30, null);
            DownloadWatermarkScene r4 = this.c;
            String r5 = "-";
            if (r4 == null) goto L9;
            String r6 = r4.getScene() + '/' + r4.getSubScene();
            if (r6 == null) goto L9;
        L10:
            FLogger.a.i("WatermarkPerf", "watermark_perf entry=" + this.a + " version=" + this.b + " scene=" + r6 + " path=" + this.f + " result=" + r13 + " reason=" + r14 + " total_ms=" + r1 + " stages=[" + r3 + ']');
            kotlin.Result.Companion r7 = kotlin.Result.Companion;     // Catch: Throwable -> L24
            TrackParams r8 = new TrackParams();     // Catch: Throwable -> L24
            r8.put("entry", this.a);     // Catch: Throwable -> L24
            r8.put("version", this.b.name());     // Catch: Throwable -> L24
            DownloadWatermarkScene r9 = this.c;     // Catch: Throwable -> L24
            if (r9 == null) goto L15;
            String r10 = r9.getScene();     // Catch: Throwable -> L24
            if (r10 == null) goto L15;
        L16:
            r8.put("scene", r10);     // Catch: Throwable -> L24
            DownloadWatermarkScene r11 = this.c;     // Catch: Throwable -> L24
            if (r11 == null) goto L22;
            String r12 = r11.getSubScene();     // Catch: Throwable -> L24
            if (r12 == null) goto L22;
            r5 = r12;
        L22:
            r8.put("sub_scene", r5);     // Catch: Throwable -> L24
            r8.put("path", this.f.name());     // Catch: Throwable -> L24
            r8.put("result", r13.name());     // Catch: Throwable -> L24
            r8.put(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r14);     // Catch: Throwable -> L24
            r8.put("total_ms", Long.valueOf(r1));     // Catch: Throwable -> L24
            r8.put("stages", r3);     // Catch: Throwable -> L24
            by7.a r15 = new by7.a("watermark_perf");     // Catch: Throwable -> L24
            r15.a.merge(r8);     // Catch: Throwable -> L24
            r15.b();     // Catch: Throwable -> L24
            Object r16 = kotlin.Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
        L26:
            Throwable r17 = kotlin.Result.exceptionOrNull-impl(r16);
            if (r17 == null) goto L32;
            FLogger.a.e("WatermarkPerf", "emit watermark_perf fail: " + r17.getMessage());
            return;
        L32:
            return;
        L15:
            r10 = "-";
        L24:
            th = move-exception;
            kotlin.Result.Companion r18 = kotlin.Result.Companion;
            r16 = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
        L9:
            r6 = "-";
            goto L10
        }

        public a(String r2, Version r3, DownloadWatermarkScene r4, long r5) {
            Intrinsics.checkNotNullParameter(r2, "entry");
            Intrinsics.checkNotNullParameter(r3, "version");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r5;
            this.f = Path.NONE;
            this.g = new ArrayList();
        }
    }

    static {
    }

    public static a a(String r7, Version r8, DownloadWatermarkScene r9) {
        Intrinsics.checkNotNullParameter(r7, "entry");
        Intrinsics.checkNotNullParameter(r8, "version");
        return new a(r7, r8, r9, System.currentTimeMillis());
    }
}
