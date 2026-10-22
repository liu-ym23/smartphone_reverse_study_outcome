package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppFeatureType;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MiniApp", "H5", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MyOpenAppFeatureType extends Enum<MyOpenAppFeatureType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MyOpenAppFeatureType[] $VALUES = null;
    public static final MyOpenAppFeatureType H5 = null;
    public static final MyOpenAppFeatureType MiniApp = null;
    private final int value;

    private static final /* synthetic */ MyOpenAppFeatureType[] $values() {
        return new MyOpenAppFeatureType[]{MiniApp, H5};
    }

    public static EnumEntries<MyOpenAppFeatureType> getEntries() {
        return $ENTRIES;
    }

    static {
        MiniApp = new MyOpenAppFeatureType("MiniApp", 0, 1);
        H5 = new MyOpenAppFeatureType("H5", 1, 2);
        MyOpenAppFeatureType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static MyOpenAppFeatureType[] values() {
        return (MyOpenAppFeatureType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MyOpenAppFeatureType valueOf(String r1) {
        return (MyOpenAppFeatureType) a.a(MyOpenAppFeatureType.class, r1);
    }

    private MyOpenAppFeatureType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
