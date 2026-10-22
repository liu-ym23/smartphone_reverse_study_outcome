package com.ss.android.lark.docs.url;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/docs/url/MiaodaUrlRoute;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "PAGE", "App", "docs-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MiaodaUrlRoute extends Enum<MiaodaUrlRoute> {
    public static final MiaodaUrlRoute App = null;
    public static final MiaodaUrlRoute PAGE = null;
    public static final /* synthetic */ MiaodaUrlRoute[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MiaodaUrlRoute> getEntries() {
        return b;
    }

    static {
        MiaodaUrlRoute r0 = new MiaodaUrlRoute("PAGE", 0);
        PAGE = r0;
        MiaodaUrlRoute r1 = new MiaodaUrlRoute("App", 1);
        App = r1;
        MiaodaUrlRoute[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MiaodaUrlRoute[] values() {
        return (MiaodaUrlRoute[]) a.clone();
    }

    public static MiaodaUrlRoute valueOf(String r1) {
        return (MiaodaUrlRoute) a.a(MiaodaUrlRoute.class, r1);
    }

    public MiaodaUrlRoute(String r1, int r2) {
        super(r1, r2);
    }
}
