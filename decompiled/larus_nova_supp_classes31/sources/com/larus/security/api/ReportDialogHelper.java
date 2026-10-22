package com.larus.security.api;

import android.content.ClipData;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.share.network.MessageShareApi;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.home.impl.sdk.i1;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.d;
import com.larus.network.bean.BizResponse;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ReportDialogHelper {
    public static final ReportDialogHelper a = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
        }
    }

    public static final class b implements IIMCallback<Message> {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function0<Unit> c;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r9) {
            Message r10 = (Message) r9;
            Intrinsics.checkNotNullParameter(r10, "result");
            ReportDialogHelper.d(ReportDialogHelper.a, this.a, CollectionsKt.listOf(r10), this.b, null, this.c, 8);
        }

        public b(FragmentActivity r1, String r2, Function0<Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        a = new ReportDialogHelper();
    }

    public ReportDialogHelper() {
    }

    public final Object b(List<Message> r23, Continuation<? super BizResponse<SaveMessageShareInfo>> r24) {
        if ((r24 instanceof ReportDialogHelper$doRequestMessageShareApi$1) == false) goto L7;
        ReportDialogHelper$doRequestMessageShareApi$1 r1 = (ReportDialogHelper$doRequestMessageShareApi$1) r24;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L28:
        dm9.a.b r5 = (dm9.a) r0;
        if ((r5 instanceof dm9.a.b) == false) goto L32;
        return r5.a;
    L32:
        if ((r5 instanceof dm9.a.a) == false) goto L36;
        FLogger.a.i("ReportDialogHelper", String.valueOf(((dm9.a.a) r5).c));
        return new BizResponse(-1, null, null, null, 14, null);
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        List r6 = CollectionsKt.sortedWith(r23, new a());
        List r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L16:
        if (r9.hasNext() == false) goto L22;
        String r10 = ((Message) r9.next()).getMessageId();
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        r8.add(r10);
        goto L16
    L22:
        if (r6.isEmpty() == true) goto L24;
        String r11 = ((Message) CollectionsKt.last(r6)).getConversationId();
        MessageShareApi.Companion r12 = MessageShareApi.a;
        com.larus.bmhome.share.network.f r13 = new com.larus.bmhome.share.network.f(r11, r8, Boxing.boxBoolean(z2.a.getShareConfig().g()), Boxing.boxBoolean(false), null, 16);
        r1.label = 1;
        r12.getClass();
        r0 = MessageShareApi.Companion.a(r13, r1);
        if (r0 != r3) goto L28;
        return r3;
    L24:
        return new BizResponse(-1, null, null, new SaveMessageShareInfo(null, null, null, null, null, 31, null), 6, null);
    L7:
        r1 = new ReportDialogHelper$doRequestMessageShareApi$1(this, r24);
        goto L8
    }

    public static void a(Context r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        StringBuilder r0 = new StringBuilder("");
        if (o0.d(r4) == false) goto L6;
        r0.append(r3.getString(2131905663));
        r0.append("：" + r4 + '\n');
    L6:
        if (o0.d(r5) == false) goto L8;
        r0.append(r3.getString(2131905662));
        r0.append("：" + r5);
    L8:
        String r6 = r0.toString();
        if (StringsKt.isBlank(r6) == false) goto L12;
        s r7 = s.a;
        String r8 = r3.getString(2131899529);
        r7.getClass();
        s.t(r3, r8);
        return;
    L12:
        ClipData r9 = ClipData.newPlainText("text", r6);
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L15;
        r10.d0();
        i1 r11 = i1.a;
        Intrinsics.checkNotNull(r9);
        r11.i(r3, r9, "bpea-user-report-message");
    L15:
        s r12 = s.a;
        String r13 = r3.getString(2131905670);
        r12.getClass();
        s.p(r3, r13);
    }

    public static void c(FragmentActivity r2, String r3, String r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "confirmUnit");
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        d.e().m(r3, new b(r2, r4, r5));
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static void d(ReportDialogHelper r3, final FragmentActivity r4, final List r5, final String r6, final List r7, final Function0 r8, int r9) {
        if ((r9 & 4) == 0) goto L6;
        r6 = null;
    L6:
        if ((r9 & 8) == 0) goto L8;
        r7 = r5;
    L8:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "msgList");
        Intrinsics.checkNotNullParameter(r7, "shareMsgList");
        Intrinsics.checkNotNullParameter(r8, "confirmUnit");
        if (r4 == null) goto L24;
        CommonDialog.a r10 = new CommonDialog.a();
        int r11 = j0.a;
        r10.i(j0.d(2131905665));
        r10.g(j0.d(2131905664));
        CommonDialog.a.f(r10, new ReportDialogHelper$showReportDialogByMessage$1$dialog$1(r8, r5), j0.d(2131905660), false, 12);
        r10.m = true;
        f0 r12 = new f0(null, Integer.valueOf(ContextCompat.getColor(r4, v19.c.b(2130972079, null, 2131103136))), null, 5);
        Intrinsics.checkNotNullParameter(r12, "commonDialogTextStyleConfig");
        r10.D = r12;
        CommonDialog.a.e(r10, new ReportDialogHelper$showReportDialogByMessage$1$dialog$2(r7, r5, r6, r4), j0.d(2131905661), 4);
        r10.t = true;
        CommonDialog r13 = r10.a();
        if (r4.isFinishing() == false) goto L13;
        return;
    L13:
        if (r4.isDestroyed() == true) goto L26;
        FragmentManager r14 = r4.getSupportFragmentManager();
        LandscapeRestrictionOperation r15 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, null, r15);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r13, r15) == true) goto L27;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L19:
        r13.show(r14, null);
        return;
    L27:
        return;
    L26:
        return;
    }
}
