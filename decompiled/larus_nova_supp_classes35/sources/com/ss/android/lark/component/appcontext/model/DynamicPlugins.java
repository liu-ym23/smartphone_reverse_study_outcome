package com.ss.android.lark.component.appcontext.model;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "FCM", "UPDATE", "BYTED_CERT", "LYNX_DEVTOOL", "HW", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DynamicPlugins extends Enum<DynamicPlugins> {
    public static final DynamicPlugins BYTED_CERT = null;
    public static final DynamicPlugins FCM = null;
    public static final DynamicPlugins HW = null;
    public static final DynamicPlugins LYNX_DEVTOOL = null;
    public static final DynamicPlugins UPDATE = null;
    public static final /* synthetic */ DynamicPlugins[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DynamicPlugins> getEntries() {
        return b;
    }

    static {
        DynamicPlugins r0 = new DynamicPlugins("FCM", 0);
        FCM = r0;
        DynamicPlugins r1 = new DynamicPlugins("UPDATE", 1);
        UPDATE = r1;
        DynamicPlugins r3 = new DynamicPlugins("BYTED_CERT", 2);
        BYTED_CERT = r3;
        DynamicPlugins r5 = new DynamicPlugins("LYNX_DEVTOOL", 3);
        LYNX_DEVTOOL = r5;
        DynamicPlugins r7 = new DynamicPlugins("HW", 4);
        HW = r7;
        DynamicPlugins[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DynamicPlugins[] values() {
        return (DynamicPlugins[]) a.clone();
    }

    public static DynamicPlugins valueOf(String r1) {
        return (DynamicPlugins) a.a(DynamicPlugins.class, r1);
    }

    public DynamicPlugins(String r1, int r2) {
        super(r1, r2);
    }
}
