package com.larksuite.rucket.impl.base.request;

import com.bytedance.lark.sdk.StreamDataSource;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u0004\u0018\u00010\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/larksuite/rucket/impl/base/request/RequestStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "PREFER_NETWORK", "PREFER_CACHE", "FORCE_LOCAL", "toSource", "Lcom/bytedance/lark/sdk/StreamDataSource;", "rucket_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum RequestStrategy extends Enum<RequestStrategy> {
    public static final RequestStrategy FORCE_LOCAL = null;
    public static final RequestStrategy NONE = null;
    public static final RequestStrategy PREFER_CACHE = null;
    public static final RequestStrategy PREFER_NETWORK = null;
    public static final /* synthetic */ RequestStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RequestStrategy.values().length];
            r0[RequestStrategy.PREFER_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[RequestStrategy.FORCE_LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[RequestStrategy.PREFER_NETWORK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static EnumEntries<RequestStrategy> getEntries() {
        return b;
    }

    static {
        RequestStrategy r0 = new RequestStrategy("NONE", 0);
        NONE = r0;
        RequestStrategy r1 = new RequestStrategy("PREFER_NETWORK", 1);
        PREFER_NETWORK = r1;
        RequestStrategy r3 = new RequestStrategy("PREFER_CACHE", 2);
        PREFER_CACHE = r3;
        RequestStrategy r5 = new RequestStrategy("FORCE_LOCAL", 3);
        FORCE_LOCAL = r5;
        RequestStrategy[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static RequestStrategy[] values() {
        return (RequestStrategy[]) a.clone();
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

    public static RequestStrategy valueOf(String r1) {
        return (RequestStrategy) r27.a.a(RequestStrategy.class, r1);
    }

    public RequestStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
