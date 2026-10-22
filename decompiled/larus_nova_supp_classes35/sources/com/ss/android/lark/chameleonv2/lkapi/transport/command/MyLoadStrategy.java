package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyLoadStrategy;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Local", "Net", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MyLoadStrategy extends Enum<MyLoadStrategy> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MyLoadStrategy[] $VALUES = null;
    public static final MyLoadStrategy Local = null;
    public static final MyLoadStrategy Net = null;
    private final int value;

    private static final /* synthetic */ MyLoadStrategy[] $values() {
        return new MyLoadStrategy[]{Local, Net};
    }

    public static EnumEntries<MyLoadStrategy> getEntries() {
        return $ENTRIES;
    }

    static {
        Local = new MyLoadStrategy("Local", 0, 1);
        Net = new MyLoadStrategy("Net", 1, 2);
        MyLoadStrategy[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static MyLoadStrategy[] values() {
        return (MyLoadStrategy[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MyLoadStrategy valueOf(String r1) {
        return (MyLoadStrategy) a.a(MyLoadStrategy.class, r1);
    }

    private MyLoadStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
