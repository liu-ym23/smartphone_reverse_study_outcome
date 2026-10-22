package lda;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskStatus;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import com.obric.assistant.cocreationreview.w4;
import com.obric.assistant.cocreationreview.y4;
import com.obric.assistant.cocreationreview.z4;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t extends w4<b0> {
    public static final t b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OmniTaskStatus.values().length];
            r0[OmniTaskStatus.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[OmniTaskStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[OmniTaskStatus.USER_STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[OmniTaskTriggerType.values().length];
            r1[OmniTaskTriggerType.PROACTIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[OmniTaskTriggerType.MY_TASK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[OmniTaskTriggerType.AUTOMATIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    static {
        b = new t();
    }

    public t() {
        super(e.a);
    }

    public static List m(b0 r15) {
        String r5 = "步骤数： " + r15.i.size();
        CardTemplateTagTone r3 = CardTemplateTagTone.METRIC;
        List r1 = CollectionsKt.mutableListOf(new com.obric.assistant.cocreationreview.c[]{new com.obric.assistant.cocreationreview.c(r5, r3, null, null, null, null, null, 252)});
        if ((true ^ StringsKt.isBlank(r15.j)) == true) goto L5;
    L9:
        return r1;
    L5:
        if (StringsKt.contains$default(r15.j, "秒", false, 2, null) == false) goto L7;
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r1.add(new com.obric.assistant.cocreationreview.c("耗时： " + r15.j + r0, r3, null, null, null, null, null, 252));
        goto L9
    L7:
        r0 = " 秒";
        goto L8
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final boolean a(com.obric.assistant.cocreationreview.a r2) {
        Intrinsics.checkNotNullParameter((b0) r2, "record");
        return true;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        b0 r3 = (b0) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.k;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r2) {
        b0 r3 = (b0) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return m(r3);
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r5) {
        b0 r6 = (b0) r5;
        Intrinsics.checkNotNullParameter(r6, "record");
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r6.d));
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r2) {
        b0 r3 = (b0) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.e;
    }

    @Override // com.obric.assistant.cocreationreview.w4, com.obric.assistant.cocreationreview.n5
    public final List i(com.obric.assistant.cocreationreview.a r19) {
        b0 r0 = (b0) r19;
        Intrinsics.checkNotNullParameter(r0, "record");
        com.obric.assistant.cocreationreview.d[] r2 = new com.obric.assistant.cocreationreview.d[3];
        l5 r3 = e.a;
        r2[0] = new com.obric.assistant.cocreationreview.d(r3.c, CardTemplateTagTone.NEUTRAL, Integer.valueOf(r3.e), Integer.valueOf(r3.d), 16);
        OmniTaskTriggerType r4 = r0.h;
        int r5 = a.b[r4.ordinal()];
        if (r5 == 1) goto L9;
        if (r5 == 2) goto L9;
        if (r5 != 3) goto L8;
        com.obric.assistant.cocreationreview.d r6 = new com.obric.assistant.cocreationreview.d(r4.getLabel(), CardTemplateTagTone.WARNING, null, null, 28);
    L10:
        r2[1] = r6;
        OmniTaskStatus r1 = r0.g;
        int r7 = a.a[r1.ordinal()];
        if (r7 == 1) goto L18;
        if (r7 == 2) goto L17;
        if (r7 != 3) goto L16;
        com.obric.assistant.cocreationreview.d r8 = new com.obric.assistant.cocreationreview.d("主动停止", CardTemplateTagTone.WARNING, null, null, 28);
    L19:
        r2[2] = r8;
        return CollectionsKt.listOf(r2);
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r8 = new com.obric.assistant.cocreationreview.d("失败", CardTemplateTagTone.DANGER, null, null, 28);
        goto L19
    L18:
        r8 = new com.obric.assistant.cocreationreview.d("成功", CardTemplateTagTone.SUCCESS, null, null, 28);
        goto L19
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        r6 = new com.obric.assistant.cocreationreview.d(r4.getLabel(), CardTemplateTagTone.ACCENT, null, null, 28);
        goto L10
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r12, a5 r13) {
        b0 r14 = (b0) r12;
        Intrinsics.checkNotNullParameter(r14, "record");
        Intrinsics.checkNotNullParameter(r13, "feedback");
        String r3 = r14.a;
        String r4 = e.a.c + "详情";
        String r1 = r14.e;
        Intrinsics.checkNotNullParameter(r14, "record");
        com.obric.assistant.cocreationreview.e r5 = new com.obric.assistant.cocreationreview.e(r1, null, new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r14.d)));
        y4[] r0 = new y4[2];
        r0[0] = new y4.c("豆包回复", r14.f);
        List r2 = m(r14);
        List<c> r15 = r14.i;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        r6.add(((c) r16.next()).a);
        goto L4
    L6:
        r0[1] = new y4.b(r2, r6);
        return new z4.a(r3, r4, r5, r13, CollectionsKt.listOf(r0), null, "用户问询", 96);
    }
}
