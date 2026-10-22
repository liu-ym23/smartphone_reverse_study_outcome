package com.ss.android.lark.chat.api.service;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/api/service/Strategy;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "LOCAL", "TRY_LOCAL", "FORCE_SERVER", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Strategy extends Enum<Strategy> {
    public static final Strategy FORCE_SERVER = null;
    public static final Strategy LOCAL = null;
    public static final Strategy TRY_LOCAL = null;
    public static final /* synthetic */ Strategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Strategy> getEntries() {
        return b;
    }

    static {
        Strategy r0 = new Strategy("LOCAL", 0);
        LOCAL = r0;
        Strategy r1 = new Strategy("TRY_LOCAL", 1);
        TRY_LOCAL = r1;
        Strategy r3 = new Strategy("FORCE_SERVER", 2);
        FORCE_SERVER = r3;
        Strategy[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static Strategy[] values() {
        return (Strategy[]) a.clone();
    }

    public static Strategy valueOf(String r1) {
        return (Strategy) a.a(Strategy.class, r1);
    }

    public Strategy(String r1, int r2) {
        super(r1, r2);
    }
}
