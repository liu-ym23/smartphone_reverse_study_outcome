package vd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.social.userchat.model.z;
import com.larus.extension.summary_card.api.SummaryCardConfigDelegate;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements td8.c {
    public final td8.d a;
    public Message b;
    public int c;

    public static final class a {
    }

    static {
    }

    public e(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContextTask");
        this.a = r2;
        this.c = -1;
    }

    @Override // td8.c
    public final boolean a(int r7, xc8.b r8, xc8.b r9, List<? extends xc8.b> r10) {
        Intrinsics.checkNotNullParameter(r9, "current");
        Intrinsics.checkNotNullParameter(r10, "input");
        if ((this.a.l() instanceof z) == false) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L58;
        this.b = null;
        this.c = -1;
        Iterator<T> r1 = r10.iterator();
        int r2 = 0;
    L11:
        if (r1.hasNext() == false) goto L20;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        xc8.b r5 = (xc8.b) r3;
        if (m99.a.e(r5.getMessage()) == false) goto L18;
        this.b = r5.getMessage();
        this.c = r2;
    L18:
        r2 = r4;
        goto L11
    L20:
        if (SummaryCardConfigDelegate.b.enabled() == false) goto L46;
        int r6 = this.c;
        int r12 = r6 + 1;
        if (r6 < 0) goto L46;
        if (r12 >= r10.size()) goto L46;
        Message r13 = ((xc8.b) ListProtector.get(r10, r12)).getMessage();
        Message r14 = this.b;
        if (r14 == null) goto L30;
        Map r15 = r14.getBusinessExt();
        if (r15 == null) goto L30;
        String r16 = (String) r15.get("feed_video_summary_id");
    L32:
        if (Intrinsics.areEqual(r16, r13.getLocalMessageId()) == false) goto L35;
        FLogger.a.i("Pipeline_List_AwemeClearContextTask", "hide: isAmnestyVideoSummary");
        this.b = null;
        this.c = -1;
    L50:
        boolean r17 = true;
    L52:
        if (r17 == false) goto L59;
        return true;
    L59:
        return false;
    L35:
        if (m99.a.f(r13) == false) goto L46;
        if (m99.a.d(r13) == true) goto L39;
        FLogger.a.i("Pipeline_List_AwemeClearContextTask", "hide: !isRealOrExpandVideoSummary");
        this.b = null;
        this.c = -1;
        goto L50
    L39:
        String r18 = m99.a.b(r13);
        Message r19 = this.b;
        if (r19 == null) goto L42;
        String r20 = m99.a.b(r19);
    L44:
        if (Intrinsics.areEqual(r18, r20) == false) goto L46;
        FLogger.a.i("Pipeline_List_AwemeClearContextTask", "hide: video summary & video suggest from same feed");
        this.b = null;
        this.c = -1;
        goto L50
    L42:
        r20 = null;
    L30:
        r16 = null;
    L46:
        int r21 = this.c + 1;
        this.c = r21;
        if (this.b != null) goto L49;
    L51:
        r17 = false;
        goto L52
    L49:
        if (r21 > r10.size()) goto L51;
    L58:
        return false;
    L5:
        if ((this.a.l() instanceof com.larus.bmhome.social.userchat.model.b) == true) goto L7;
        r11 = true;
        goto L8
    }

    @Override // td8.c
    public final List<xc8.b> b(int r3, xc8.b r4, xc8.b r5, List<xc8.b> r6) {
        Intrinsics.checkNotNullParameter(r5, "current");
        Intrinsics.checkNotNullParameter(r6, "input");
        Message r7 = this.b;
        if (r7 != null) goto L5;
    L13:
        return r6;
    L5:
        if (this.c > r6.size()) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L13;
        int r9 = this.c;
        int r10 = j.c;
        ListProtector.add(r6, r9, j.a.a(r7, this.a.p(), "aweme_video_suggest", false));
        FLogger.a.i("Pipeline_List_AwemeClearContextTask", "insertFakeClearContextDividerByAwemeVideoSuggest at " + this.c);
        goto L13
    L7:
        r8 = false;
        goto L8
    }
}
