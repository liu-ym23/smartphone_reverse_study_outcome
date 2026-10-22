package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogActionType;", "Lcom/bytedance/ee/util/io/NonProguard;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Secondary", "Primary", "Danger", "Companion", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IWidget$Internal$ConfirmDialogActionType extends Enum<IWidget$Internal$ConfirmDialogActionType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IWidget$Internal$ConfirmDialogActionType[] $VALUES = null;
    public static final a Companion = null;
    public static final IWidget$Internal$ConfirmDialogActionType Danger = null;
    public static final IWidget$Internal$ConfirmDialogActionType Primary = null;
    public static final IWidget$Internal$ConfirmDialogActionType Secondary = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ IWidget$Internal$ConfirmDialogActionType[] $values() {
        return new IWidget$Internal$ConfirmDialogActionType[]{Secondary, Primary, Danger};
    }

    public static EnumEntries<IWidget$Internal$ConfirmDialogActionType> getEntries() {
        return $ENTRIES;
    }

    static {
        Secondary = new IWidget$Internal$ConfirmDialogActionType("Secondary", 0, "secondary");
        Primary = new IWidget$Internal$ConfirmDialogActionType("Primary", 1, "primary");
        Danger = new IWidget$Internal$ConfirmDialogActionType("Danger", 2, "danger");
        IWidget$Internal$ConfirmDialogActionType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new a();
    }

    public static IWidget$Internal$ConfirmDialogActionType[] values() {
        return (IWidget$Internal$ConfirmDialogActionType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static IWidget$Internal$ConfirmDialogActionType valueOf(String r1) {
        return (IWidget$Internal$ConfirmDialogActionType) r27.a.a(IWidget$Internal$ConfirmDialogActionType.class, r1);
    }

    private IWidget$Internal$ConfirmDialogActionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
