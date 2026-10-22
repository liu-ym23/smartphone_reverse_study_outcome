package m39;

import com.larus.doc.impl.DocFragment;
import com.larus.doc.impl.offline.CreateDocByMessageActionType;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tx9.t0;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CreateDocByMessageActionType.values().length];
            r0[CreateDocByMessageActionType.FORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CreateDocByMessageActionType.COMPENSATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public b() {
    }

    public static void a(String r3) {
        FLogger r0 = FLogger.a;
        if (r0.isDebug() == false) goto L6;
        r0.i("OfflineDocReport", "mobDocOfflineCompensateCreate, " + r3);
        return;
    }

    public static String f(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L14;
        if (r2 != null) goto L11;
        return "null";
    L11:
        return "empty";
    L14:
        return "len=" + r2.length() + ",hash=" + r2.hashCode();
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        StringBuilder r0 = new StringBuilder("等待创建离线文档结束, 当前阶段:");
        r0.append(r2);
        r0.append(", 原因:");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.append(r3);
        a(r0.toString());
    }

    public static void e(com.larus.doc.impl.offline.b r10, DocFragment r11, int r12) {
        boolean r1 = false;
        if ((r12 & 2) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r12 & 4) == 0) goto L9;
        r11 = null;
    L9:
        DocFragment r9 = r11;
        Intrinsics.checkNotNullParameter(r10, "createDocByMessageState");
        CreateDocByMessageActionType r13 = r10.a;
        CreateDocByMessageActionType r14 = CreateDocByMessageActionType.COMPENSATE;
        if (r13 != r14) goto L12;
        boolean r0 = true;
    L13:
        int r3 = t0.a;
        if (r13 != r14) goto L16;
        r1 = true;
    L16:
        u0.a(t0.a(r1, r10.b, r10.c, r10.d), r4, Boolean.valueOf(r0), Boolean.valueOf(r10.b), Boolean.valueOf(r10.c), Boolean.valueOf(r10.d), r9);
        return;
    L12:
        r0 = false;
        goto L13
    L5:
        r4 = false;
        goto L7
    }

    public static void c(String r2, String r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "source");
        StringBuilder r0 = new StringBuilder("刷新远端绑定, 来源:");
        r0.append(r2);
        r0.append(", realToken:");
        r0.append(f(r3));
        r0.append(", 是否已刷新:");
        r0.append(r4);
        r0.append(", 原因:");
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.append(r5);
        a(r0.toString());
    }

    public static void b(String r6, String r7, Boolean r8, String r9, com.larus.doc.impl.offline.b r10) {
        Intrinsics.checkNotNullParameter(r6, "trigger");
        Intrinsics.checkNotNullParameter(r10, "createDocByMessageState");
        CreateDocByMessageActionType r0 = r10.a;
        CreateDocByMessageActionType r1 = CreateDocByMessageActionType.COMPENSATE;
        boolean r2 = false;
        if (r0 != r1) goto L5;
        boolean r4 = true;
    L6:
        int r3 = a.a[r0.ordinal()];
        if (r3 != 1) goto L9;
        String r5 = "正常创建卡片";
    L14:
        int r11 = t0.a;
        if (r10.a != r1) goto L17;
        r2 = true;
    L17:
        a("卡片补偿决策, 是否补偿:" + r4 + ", 动作:" + r5 + ", 当前阶段:" + r6 + ", 是否有realToken:" + r10.b + ", 是否已收到USER_CHANGES:" + r10.c + ", 是否已前端绑定:" + r10.d + ", realToken:" + f(r7) + ", 是否使用消息内容:" + r8 + ", 创建状态原因:" + t0.a(r2, r10.b, r10.c, r10.d) + ", 旧失败原因:" + r9);
        return;
    L9:
        if (r3 != 2) goto L12;
        r5 = "补偿创建卡片";
        goto L14
    L12:
        throw new NoWhenBranchMatchedException();
    L5:
        r4 = false;
        goto L6
    }
}
