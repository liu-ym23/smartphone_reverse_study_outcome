package com.ss.android.lark.qrcode.utils;

import android.app.ActivityManager;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class QRScanUtils {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/qrcode/utils/QRScanUtils$ProcessSuffix;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SUFFIX_P0", "SUFFIX_MINI_APP", "value", "getValue", "qrcode_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum ProcessSuffix extends Enum<ProcessSuffix> {
        public static final ProcessSuffix SUFFIX_MINI_APP = null;
        public static final ProcessSuffix SUFFIX_P0 = null;
        public static final /* synthetic */ ProcessSuffix[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<ProcessSuffix> getEntries() {
            return b;
        }

        static {
            ProcessSuffix r0 = new ProcessSuffix("SUFFIX_P0", 0, ":p0");
            SUFFIX_P0 = r0;
            ProcessSuffix r1 = new ProcessSuffix("SUFFIX_MINI_APP", 1, ":miniapp");
            SUFFIX_MINI_APP = r1;
            ProcessSuffix[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static ProcessSuffix[] values() {
            return (ProcessSuffix[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ProcessSuffix valueOf(String r1) {
            return (ProcessSuffix) a.a(ProcessSuffix.class, r1);
        }

        public ProcessSuffix(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
    }

    public static boolean a(ProcessSuffix r7) {
        ActivityManager r0 = (ActivityManager) LarkContext.getApplication().getSystemService("activity");
        if (r0 == null) goto L14;
        List<ActivityManager.RunningAppProcessInfo> r1 = r0.getRunningAppProcesses();
        if (r1 == null) goto L14;
        if ((!r1.isEmpty()) == false) goto L14;
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        if (StringsKt.contains$default(r2.next().processName, r7.getValue(), false, 2, null) == false) goto L10;
        return true;
    L14:
        return false;
    }
}
