package com.obric.assistant.wakeup.statistics.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/wakeup/statistics/api/IBluetoothScoEstablishStatisticsAPI;", "", "markEstablishStart", "", "markEstablishResult", "result", "Lcom/obric/assistant/wakeup/statistics/api/IBluetoothScoEstablishStatisticsAPI$Result;", "rawScoState", "", "cancelInFlight", "Result", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBluetoothScoEstablishStatisticsAPI {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/wakeup/statistics/api/IBluetoothScoEstablishStatisticsAPI$Result;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTED", "DISCONNECTED", "ERROR", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Result extends Enum<Result> {
        public static final Result CONNECTED = null;
        public static final Result DISCONNECTED = null;
        public static final Result ERROR = null;
        public static final /* synthetic */ Result[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Result> getEntries() {
            return b;
        }

        static {
            Result r0 = new Result("CONNECTED", 0);
            CONNECTED = r0;
            Result r1 = new Result("DISCONNECTED", 1);
            DISCONNECTED = r1;
            Result r3 = new Result("ERROR", 2);
            ERROR = r3;
            Result[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Result[] values() {
            return (Result[]) a.clone();
        }

        public static Result valueOf(String r1) {
            return (Result) a.a(Result.class, r1);
        }

        public Result(String r1, int r2) {
            super(r1, r2);
        }
    }

    void a(Result r1, int r2);

    void b();
}
