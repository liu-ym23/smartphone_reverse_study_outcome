package com.ss.android.lark.filedetail.impl.open;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/open/OpenFileActionType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "VIEW", "SHARE", "toIntentAction", BuildConfig.FLAVOR, "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenFileActionType extends Enum<OpenFileActionType> {
    public static final OpenFileActionType SHARE = null;
    public static final OpenFileActionType VIEW = null;
    public static final /* synthetic */ OpenFileActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OpenFileActionType.values().length];
            r0[OpenFileActionType.VIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OpenFileActionType.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static EnumEntries<OpenFileActionType> getEntries() {
        return b;
    }

    static {
        OpenFileActionType r0 = new OpenFileActionType("VIEW", 0);
        VIEW = r0;
        OpenFileActionType r1 = new OpenFileActionType("SHARE", 1);
        SHARE = r1;
        OpenFileActionType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OpenFileActionType[] values() {
        return (OpenFileActionType[]) a.clone();
    }

    public final String toIntentAction() {
        int r0 = a.a[ordinal()];
        if (r0 != 1) goto L5;
        return "android.intent.action.VIEW";
    L5:
        if (r0 != 2) goto L8;
        return "android.intent.action.SEND";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static OpenFileActionType valueOf(String r1) {
        return (OpenFileActionType) r27.a.a(OpenFileActionType.class, r1);
    }

    public OpenFileActionType(String r1, int r2) {
        super(r1, r2);
    }
}
