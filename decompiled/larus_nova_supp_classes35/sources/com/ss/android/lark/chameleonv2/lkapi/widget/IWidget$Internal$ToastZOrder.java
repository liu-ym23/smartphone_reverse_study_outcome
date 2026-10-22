package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastZOrder;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "FLOAT_UI", "FLOAT_WINDOW", "NORMAL", "Companion", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IWidget$Internal$ToastZOrder extends Enum<IWidget$Internal$ToastZOrder> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IWidget$Internal$ToastZOrder[] $VALUES = null;
    public static final a Companion = null;
    public static final IWidget$Internal$ToastZOrder DEFAULT = null;
    public static final IWidget$Internal$ToastZOrder FLOAT_UI = null;
    public static final IWidget$Internal$ToastZOrder FLOAT_WINDOW = null;
    public static final IWidget$Internal$ToastZOrder NORMAL = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ IWidget$Internal$ToastZOrder[] $values() {
        return new IWidget$Internal$ToastZOrder[]{DEFAULT, FLOAT_UI, FLOAT_WINDOW, NORMAL};
    }

    public static EnumEntries<IWidget$Internal$ToastZOrder> getEntries() {
        return $ENTRIES;
    }

    static {
        DEFAULT = new IWidget$Internal$ToastZOrder("DEFAULT", 0, "default");
        FLOAT_UI = new IWidget$Internal$ToastZOrder("FLOAT_UI", 1, "float-ui");
        FLOAT_WINDOW = new IWidget$Internal$ToastZOrder("FLOAT_WINDOW", 2, "float-window");
        NORMAL = new IWidget$Internal$ToastZOrder("NORMAL", 3, "normal");
        IWidget$Internal$ToastZOrder[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new a();
    }

    public static IWidget$Internal$ToastZOrder[] values() {
        return (IWidget$Internal$ToastZOrder[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static IWidget$Internal$ToastZOrder valueOf(String r1) {
        return (IWidget$Internal$ToastZOrder) r27.a.a(IWidget$Internal$ToastZOrder.class, r1);
    }

    private IWidget$Internal$ToastZOrder(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
