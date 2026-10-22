package com.obric.assistant.feedback.impl;

import androidx.core.content.ContextCompat;
import com.ivy.ivykit.api.bridge.core.model.IvyReadableType;
import com.larus.bmhome.auth.ReportReason;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.feedback.IObricFeedbackService;
import com.obric.assistant.feedback.IObricFeedbackService$c;
import com.obric.assistant.spi.feedback.IFeedbackService;
import dx7.b;
import dx7.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016Jq\u0010\u000f\u001a\u00020\t2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/feedback/impl/FeedbackServiceImpl;", "Lcom/obric/assistant/spi/feedback/IFeedbackService;", "<init>", "()V", "reasonMetaList", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/auth/ReportReason;", "Lkotlin/collections/ArrayList;", "cacheReasonList", "", "metaList", "", "feedbackReadableMap", "params", "", "feedback", "reasonIds", "", "tagList", "", "content", "urlList", "messageIdList", "filePathList", "reportType", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "getSubmitFeedbackText", "getSubmitFeedbackSuccessText", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackServiceImpl implements IFeedbackService {
    public static final Set<Integer> b = null;
    public static final Set<Integer> c = null;
    public final ArrayList<ReportReason> a;

    public static final class a {
    }

    static {
        b = SetsKt.setOf(new Integer[]{6, 7, 8, 9, 14, 19, 17, 24, 25});
        c = SetsKt.setOf(1);
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final String a() {
        return ContextCompat.getString(AppHost.a.getApplication(), 2131912614);
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final String d() {
        return ContextCompat.getString(AppHost.a.getApplication(), 2131912613);
    }

    public FeedbackServiceImpl() {
        this.a = new ArrayList();
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void c(List<ReportReason> r2) {
        Intrinsics.checkNotNullParameter(r2, "metaList");
        this.a.clear();
        this.a.addAll(r2);
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void e(b r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter("data", "name");
        String r2 = null;
        if (r11.hasKey("data") == false) goto L8;
        dx7.a r12 = r11.get("data");
        if (r12.getType() != IvyReadableType.Map) goto L8;
        b r13 = r12.e();
    L10:
        if (r13 == null) goto L12;
        r2 = cx7.a.d(r13, "content", "");
    L12:
        String r5 = r2;
        int r1 = 0;
        if (r5 != null) goto L15;
    L18:
        boolean r3 = true;
    L20:
        if (r3 == false) goto L23;
        FLogger.a.d("FeedbackServiceImpl", "feedback called, content isNullOrEmpty, no need to feedback!");
        return;
    L23:
        e r14 = cx7.a.a(r13, "imageList");
        ArrayList r6 = new ArrayList();
        ArrayList r4 = new ArrayList();
        if (r14 == null) goto L36;
        e r15 = r14;
        int r7 = r15.b();
    L26:
        if (r1 >= r7) goto L36;
        dx7.a r8 = r15.a(r1);
        if (r8.getType() != IvyReadableType.Map) goto L35;
        b r9 = r8.e();
        String r10 = cx7.a.d(r9, "uri", "");
        if (o0.d(r10) == false) goto L32;
        r6.add(r10);
    L32:
        String r16 = cx7.a.d(r9, "tempFilePath", "");
        if (o0.d(r16) == false) goto L35;
        r4.add(r16);
    L35:
        r1 = r1 + 1;
    L36:
        FLogger.a.d("FeedbackServiceImpl", "feedback called, content=" + r5 + ", urlList=" + r6 + ", pathList=" + r4);
        IFeedbackService.a.a(this, null, r5, r6, null, null, 97);
        return;
    L15:
        if (r5.length() == 0) goto L18;
        r3 = false;
    L8:
        r13 = null;
        goto L10
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void b(List<Integer> r29, List<String> r30, String r31, List<String> r32, List<String> r33, List<String> r34, Integer r35) {
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("feedback: reasonIds = ");
        r4.append(r29);
        r4.append(", tagList = ");
        r4.append(r30);
        r4.append(", content.len = ");
        if (r31 != null) goto L5;
        String r6 = "";
    L6:
        r4.append(r6.length());
        r4.append(", messageIdList = ");
        r4.append(r33);
        r4.append(", urlList = ");
        r4.append(r32);
        r4.append(", filePathList = ");
        r4.append(r34);
        r4.append(", reportType = ");
        r4.append(r35);
        r3.i("FeedbackServiceImpl", r4.toString());
        if (r35 != null) goto L10;
    L13:
        boolean r11 = true;
    L15:
        if (r11 == true) goto L18;
        r3.i("FeedbackServiceImpl", "obric feedback skipped by reportType: " + r35);
        return;
    L18:
        List<String> r2 = r30;
        if (r2 != null) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == false) goto L47;
        IObricFeedbackService.a.getClass();
        IObricFeedbackService r1 = IObricFeedbackService.a.a();
        if (r1 == null) goto L59;
        ArrayList<ReportReason> r7 = this.a;
        ArrayList r8 = new ArrayList();
        Iterator<ReportReason> r9 = r7.iterator();
    L30:
        if (r9.hasNext() == false) goto L39;
        ReportReason r12 = r9.next();
        ReportReason r13 = r12;
        if (r29 != null) goto L34;
    L36:
        boolean r14 = false;
    L37:
        if (r14 == false) goto L30;
        r8.add(r12);
        goto L30
    L34:
        if (r29.contains(Integer.valueOf(r13.b())) != true) goto L36;
        r14 = true;
        goto L37
    L39:
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r0 = r8.iterator();
    L41:
        if (r0.hasNext() == false) goto L46;
        String r15 = ((ReportReason) r0.next()).a();
        if (r15 != null) goto L45;
        r15 = "";
    L45:
        r10.add(r15);
        goto L41
    L46:
        r1.a(new IObricFeedbackService$c(r10, r31, r32, r33, null, null, null, null, null, null, false, r34, false, false, false, null, false, null, 522224));
        return;
    L59:
        return;
    L47:
        IObricFeedbackService.a.getClass();
        IObricFeedbackService r16 = IObricFeedbackService.a.a();
        if (r16 == null) goto L61;
        r16.a(new IObricFeedbackService$c(r30, r31, r32, r33, null, null, null, null, null, null, false, r34, false, false, false, null, false, null, 522224));
        return;
    L61:
        return;
    L21:
        if (r2.isEmpty() == true) goto L24;
        r5 = false;
        goto L25
    L10:
        if (b.contains(r35) == false) goto L12;
    L14:
        r11 = false;
        goto L15
    L12:
        if (c.contains(r35) == true) goto L14;
    L5:
        r6 = r31;
        goto L6
    }
}
