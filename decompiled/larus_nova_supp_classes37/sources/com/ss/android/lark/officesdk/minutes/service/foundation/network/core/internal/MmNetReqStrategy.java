package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.internal;

import com.bytedance.lark.sdk.StreamDataSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u0004\u0018\u00010\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/internal/MmNetReqStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "PREFER_NETWORK", "PREFER_CACHE", "FORCE_LOCAL", "toSource", "Lcom/bytedance/lark/sdk/StreamDataSource;", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmNetReqStrategy extends Enum<MmNetReqStrategy> {
    public static final MmNetReqStrategy FORCE_LOCAL = null;
    public static final MmNetReqStrategy NONE = null;
    public static final MmNetReqStrategy PREFER_CACHE = null;
    public static final MmNetReqStrategy PREFER_NETWORK = null;
    public static final /* synthetic */ MmNetReqStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmNetReqStrategy.values().length];
            r0[MmNetReqStrategy.PREFER_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MmNetReqStrategy.FORCE_LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MmNetReqStrategy.PREFER_NETWORK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static EnumEntries<MmNetReqStrategy> getEntries() {
        return b;
    }

    static {
        MmNetReqStrategy r0 = new MmNetReqStrategy("NONE", 0);
        NONE = r0;
        MmNetReqStrategy r1 = new MmNetReqStrategy("PREFER_NETWORK", 1);
        PREFER_NETWORK = r1;
        MmNetReqStrategy r3 = new MmNetReqStrategy("PREFER_CACHE", 2);
        PREFER_CACHE = r3;
        MmNetReqStrategy r5 = new MmNetReqStrategy("FORCE_LOCAL", 3);
        FORCE_LOCAL = r5;
        MmNetReqStrategy[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmNetReqStrategy[] values() {
        return (MmNetReqStrategy[]) a.clone();
    }

    public final StreamDataSource toSource() {
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L14;
        return null;
    L14:
        return StreamDataSource.ONCE_NET;
    L15:
        return StreamDataSource.ONCE_LOCAL;
    L12:
        return StreamDataSource.DEFAULT_SMART;
    }

    public static MmNetReqStrategy valueOf(String r1) {
        return (MmNetReqStrategy) r27.a.a(MmNetReqStrategy.class, r1);
    }

    public MmNetReqStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
