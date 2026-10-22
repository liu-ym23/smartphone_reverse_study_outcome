package com.obric.assistant.card.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class DownloadAppOpener {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/card/utils/DownloadAppOpener$Result;", NameKeys.UnloadStrategy_No_Strategy, "failureType", NameKeys.UnloadStrategy_No_Strategy, "messageRes", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)V", "getFailureType", "()Ljava/lang/String;", "getMessageRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "OPENED", "NOT_INSTALLED", "NO_LAUNCHER", "FAILED", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Result extends Enum<Result> {
        public static final Result FAILED = null;
        public static final Result NOT_INSTALLED = null;
        public static final Result NO_LAUNCHER = null;
        public static final Result OPENED = null;
        public static final /* synthetic */ Result[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String failureType;
        private final Integer messageRes;

        public static EnumEntries<Result> getEntries() {
            return b;
        }

        static {
            Result r0 = new Result("OPENED", 0, null, null);
            OPENED = r0;
            Result r1 = new Result("NOT_INSTALLED", 1, "app_not_exist", 2131911994);
            NOT_INSTALLED = r1;
            Result r2 = new Result("NO_LAUNCHER", 2, "app_not_launchable", 2131911995);
            NO_LAUNCHER = r2;
            Result r4 = new Result("FAILED", 3, "app_open_failed", 2131911996);
            FAILED = r4;
            Result[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static Result[] values() {
            return (Result[]) a.clone();
        }

        public final String getFailureType() {
            return this.failureType;
        }

        public final Integer getMessageRes() {
            return this.messageRes;
        }

        public static Result valueOf(String r1) {
            return (Result) r27.a.a(Result.class, r1);
        }

        public Result(String r1, int r2, String r3, Integer r4) {
            super(r1, r2);
            this.failureType = r3;
            this.messageRes = r4;
        }
    }

    static {
    }

    public static Result a(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8 != null) goto L27;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        Result r9 = Result.NOT_INSTALLED;     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
    L23:
        Integer r0 = r9.getMessageRes();
        if (r0 == null) goto L26;
        s.j(s.a, r7, r7.getString(r0.intValue()), null, false, 28);
    L26:
        return r9;
    L13:
        PackageManager r2 = r7.getPackageManager();     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        if (r2.getApplicationInfo(r8, 0).enabled == true) goto L16;
        r9 = Result.FAILED;     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        goto L23
    L16:
        Intent r3 = r2.getLaunchIntentForPackage(r8);     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        if (r3 != null) goto L19;
        r9 = Result.NO_LAUNCHER;     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        goto L23
    L19:
        r3.addFlags(268435456);     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        r7.startActivity(r3);     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        r9 = Result.OPENED;     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        goto L23
    L27:
    L22:
        r9 = Result.NOT_INSTALLED;
    L8:
        e = move-exception;
        FLogger.a.e("DownloadAppOpener", "Failed to open " + r8, e);
        r9 = Result.FAILED;
        goto L23
    L5:
        if (StringsKt.isBlank(r8) == true) goto L10;
        r1 = false;
        goto L11
    }
}
