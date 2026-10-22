package com.larus.dora.impl.device.ailab.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/device/ailab/config/AutoStopTimeConfig;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FIVE_SECONDS", "EIGHT_SECONDS", "TWELVE_SECONDS", "TWENTY_SECONDS", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AutoStopTimeConfig extends Enum<AutoStopTimeConfig> {
    public static final a Companion = null;
    public static final AutoStopTimeConfig EIGHT_SECONDS = null;
    public static final AutoStopTimeConfig FIVE_SECONDS = null;
    public static final AutoStopTimeConfig TWELVE_SECONDS = null;
    public static final AutoStopTimeConfig TWENTY_SECONDS = null;
    public static final /* synthetic */ AutoStopTimeConfig[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static List a(boolean r5) {
            EnumEntries<AutoStopTimeConfig> r0 = AutoStopTimeConfig.getEntries();
            ArrayList r1 = new ArrayList();
            Iterator r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L14;
            Object r3 = r2.next();
            AutoStopTimeConfig r4 = (AutoStopTimeConfig) r3;
            if (r5 == true) goto L8;
        L11:
            boolean r6 = true;
        L12:
            if (r6 == false) goto L4;
            r1.add(r3);
            goto L4
        L8:
            if (r4 != AutoStopTimeConfig.FIVE_SECONDS) goto L11;
            r6 = false;
            goto L12
        L14:
            return r1;
        }
    }

    public static EnumEntries<AutoStopTimeConfig> getEntries() {
        return b;
    }

    static {
        AutoStopTimeConfig r0 = new AutoStopTimeConfig("FIVE_SECONDS", 0, 5);
        FIVE_SECONDS = r0;
        AutoStopTimeConfig r1 = new AutoStopTimeConfig("EIGHT_SECONDS", 1, 8);
        EIGHT_SECONDS = r1;
        AutoStopTimeConfig r3 = new AutoStopTimeConfig("TWELVE_SECONDS", 2, 12);
        TWELVE_SECONDS = r3;
        AutoStopTimeConfig r5 = new AutoStopTimeConfig("TWENTY_SECONDS", 3, 20);
        TWENTY_SECONDS = r5;
        AutoStopTimeConfig[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static AutoStopTimeConfig[] values() {
        return (AutoStopTimeConfig[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AutoStopTimeConfig valueOf(String r1) {
        return (AutoStopTimeConfig) r27.a.a(AutoStopTimeConfig.class, r1);
    }

    public AutoStopTimeConfig(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
