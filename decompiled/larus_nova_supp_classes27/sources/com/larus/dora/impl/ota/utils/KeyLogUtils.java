package com.larus.dora.impl.ota.utils;

import android.text.TextUtils;
import com.larus.dora.api.model.FlowDoraWifiScene;
import g49.d;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class KeyLogUtils {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/ota/utils/KeyLogUtils$DataFlowDirection;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UPLINK", "DOWNLINK", "INTERNAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DataFlowDirection extends Enum<DataFlowDirection> {
        public static final DataFlowDirection DOWNLINK = null;
        public static final DataFlowDirection INTERNAL = null;
        public static final DataFlowDirection UPLINK = null;
        public static final /* synthetic */ DataFlowDirection[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<DataFlowDirection> getEntries() {
            return b;
        }

        static {
            DataFlowDirection r0 = new DataFlowDirection("UPLINK", 0, "UPLINK");
            UPLINK = r0;
            DataFlowDirection r1 = new DataFlowDirection("DOWNLINK", 1, "DOWNLINK");
            DOWNLINK = r1;
            DataFlowDirection r3 = new DataFlowDirection("INTERNAL", 2, "INTERNAL");
            INTERNAL = r3;
            DataFlowDirection[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DataFlowDirection[] values() {
            return (DataFlowDirection[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static DataFlowDirection valueOf(String r1) {
            return (DataFlowDirection) r27.a.a(DataFlowDirection.class, r1);
        }

        public DataFlowDirection(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/ota/utils/KeyLogUtils$DataLink;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IMAGE", "AUDIO", FlowDoraWifiScene.OTA, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DataLink extends Enum<DataLink> {
        public static final DataLink AUDIO = null;
        public static final DataLink IMAGE = null;
        public static final DataLink OTA = null;
        public static final /* synthetic */ DataLink[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<DataLink> getEntries() {
            return b;
        }

        static {
            DataLink r0 = new DataLink("IMAGE", 0, "IMAGE");
            IMAGE = r0;
            DataLink r1 = new DataLink("AUDIO", 1, "AUDIO");
            AUDIO = r1;
            DataLink r3 = new DataLink(FlowDoraWifiScene.OTA, 2, FlowDoraWifiScene.OTA);
            OTA = r3;
            DataLink[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DataLink[] values() {
            return (DataLink[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static DataLink valueOf(String r1) {
            return (DataLink) r27.a.a(DataLink.class, r1);
        }

        public DataLink(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/ota/utils/KeyLogUtils$LogType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "KEY", "INFO", "WARN", "ERROR", "FATAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LogType extends Enum<LogType> {
        public static final LogType ERROR = null;
        public static final LogType FATAL = null;
        public static final LogType INFO = null;
        public static final LogType KEY = null;
        public static final LogType WARN = null;
        public static final /* synthetic */ LogType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<LogType> getEntries() {
            return b;
        }

        static {
            LogType r0 = new LogType("KEY", 0, "KEY");
            KEY = r0;
            LogType r1 = new LogType("INFO", 1, "INFO");
            INFO = r1;
            LogType r3 = new LogType("WARN", 2, "WARN");
            WARN = r3;
            LogType r5 = new LogType("ERROR", 3, "ERROR");
            ERROR = r5;
            LogType r7 = new LogType("FATAL", 4, "FATAL");
            FATAL = r7;
            LogType[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static LogType[] values() {
            return (LogType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static LogType valueOf(String r1) {
            return (LogType) r27.a.a(LogType.class, r1);
        }

        public LogType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public final JSONObject a;

        public a() {
            this.a = new JSONObject();
        }

        public static void b(String r2, JSONException r3) {
            d.b("KeyLogUtils", "JSONBuilder add field error, key: " + r2 + ", exception: " + r3);
        }

        public final void a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            JSONObject r0 = this.a;     // Catch: JSONException -> L8
            if (r3 != null) goto L6;
            r3 = "none";
        L6:
            r0.put(r2, r3);     // Catch: JSONException -> L8
            return;
        L8:
            e = move-exception;
            b(r2, e);
        }
    }

    static {
    }

    public static void a(LogType r4, DataLink r5, DataFlowDirection r6, String r7, a r8, String r9) {
        Intrinsics.checkNotNullParameter(r4, "logType");
        Intrinsics.checkNotNullParameter(r5, "dataLink");
        Intrinsics.checkNotNullParameter(r6, "dataFlowDirection");
        String r0 = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        if (r8 == null) goto L8;
        JSONObject r10 = r8.a;
        if (r10 == null) goto L8;
        String r11 = r10.toString();
        if (r11 == null) goto L8;
    L9:
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        Object[] r2 = new Object[9];
        r2[0] = r0;
        r2[1] = r4.getValue();
        TextUtils.isEmpty("-");
        r2[2] = "-";
        r2[3] = r5.getValue();
        TextUtils.isEmpty("-");
        r2[4] = "-";
        r2[5] = r6.getValue();
        r2[6] = r7;
        r2[7] = r11;
        if (TextUtils.isEmpty(r9) == false) goto L12;
        r9 = "-";
    L12:
        r2[8] = r9;
        d.d("KeyLogUtils", String.format("[%s]|DS|%s|%s|%s|%s|%s|%s|%s|%s|", Arrays.copyOf(r2, 9)));
        return;
    L8:
        r11 = "{}";
        goto L9
    }
}
