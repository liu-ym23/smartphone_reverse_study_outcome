package com.ss.android.lark.chameleonv2.lkapi.storage;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$SpaceType;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Public", "User", "Companion", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IStorage$Internal$SpaceType extends Enum<IStorage$Internal$SpaceType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IStorage$Internal$SpaceType[] $VALUES = null;
    public static final a Companion = null;
    public static final IStorage$Internal$SpaceType Public = null;
    public static final IStorage$Internal$SpaceType User = null;
    private final String value;

    private static final /* synthetic */ IStorage$Internal$SpaceType[] $values() {
        return new IStorage$Internal$SpaceType[]{Public, User};
    }

    public static EnumEntries<IStorage$Internal$SpaceType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.lark.chameleonv2.lkapi.storage.IStorage$Internal$SpaceType$a] */
    static {
        Public = new IStorage$Internal$SpaceType("Public", 0, "public");
        User = new IStorage$Internal$SpaceType("User", 1, "user");
        IStorage$Internal$SpaceType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new a();
    }

    public static IStorage$Internal$SpaceType[] values() {
        return (IStorage$Internal$SpaceType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static IStorage$Internal$SpaceType valueOf(String r1) {
        return (IStorage$Internal$SpaceType) r27.a.a(IStorage$Internal$SpaceType.class, r1);
    }

    private IStorage$Internal$SpaceType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
