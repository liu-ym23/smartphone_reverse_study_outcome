package com.larus.bmhome.chat.standarduikit.videogroup.binder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.larus.bmhome.chat.standarduikit.videogroup.view.RelatedVideoView;
import com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.RelatedVideoViewModel;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.Message;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import usc.f;
import zn8.l;
import zn8.p;
import zn8.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RelatedVideoBinder implements f {
    public Job a;
    public final Lazy b;
    public Integer c;

    public final void a() {
    }

    public final Integer b(Size r1, TextView r2, Canvas r3, Paint r4) {
        return null;
    }

    public final Size c(TextView r1, usc.e r2, Map<String, ? extends Object> r3) {
        return null;
    }

    public final void e() {
    }

    public final View asView() {
        return ((wn8.c) this.b.getValue()).b();
    }

    public final void f() {
        Job r0 = this.a;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        wn8.c r1 = (wn8.c) this.b.getValue();
        ((RelatedVideoViewModel) r1.b.getValue()).c = null;
        ExposeXTrackerExtKt.e(r1.b().getCoverView());
    }

    public RelatedVideoBinder(final Context r2, final boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = LazyKt.lazy(new a(r2, r3));
    }

    public final Size d(TextView r17, Spanned r18, usc.e r19, int r20, Map<String, ? extends Object> r21) {
        Intrinsics.checkNotNullParameter(r17, "textView");
        Intrinsics.checkNotNullParameter(r18, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r19, "span");
        int r9 = 0;
        if (r18.getSpanStart(r19) != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r18.getSpanEnd(r19) != r18.length()) goto L9;
        boolean r2 = true;
    L27:
        String r7 = r19.l();     // Catch: Exception -> L15
        if (r7 != null) goto L13;
        r7 = "{}";
    L13:
        JSONObject r5 = new JSONObject(r7);     // Catch: Exception -> L15
    L16:
        l r11 = new l(r0, r2, r5.optBoolean("video_title_show"), r20);
        Job r1 = this.a;
        if (r1 == null) goto L19;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L19:
        this.a = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new RelatedVideoBinder$bindData$1(r21, this, r18, r19, r11, r17, null), 3, null);
        wn8.c r3 = (wn8.c) this.b.getValue();
        com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a r4 = new com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a(r11, CollectionsKt.emptyList(), null, null, false);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "vmData");
        RelatedVideoView r6 = r3.b();
        l r8 = r4.a;
        q r10 = new q(0);
        p r12 = new p(null);
        Intrinsics.checkNotNullParameter(r8, "sizeData");
        Intrinsics.checkNotNullParameter(r10, "videoData");
        Intrinsics.checkNotNullParameter(r12, "trackData");
        r6.getClass();
        if (r8 != null) goto L23;
        return new Size(0, 0);
    L23:
        if (r8.c == false) goto L25;
        r9 = r6.b;
    L25:
        Pair r13 = RelatedVideoView.a(r8);
        int r14 = (((Number) r13.component1()).intValue() + ((Number) r13.component2()).intValue()) + r9;
        return new Size(r8.d, r6.getWidgetHeight() + r14);
    L15:
        r5 = new JSONObject();
        goto L16
    L9:
        r2 = false;
        goto L27
    L5:
        r0 = false;
        goto L7
    }

    public static final Object g(RelatedVideoBinder r9, Spanned r10, usc.e r11, fh8.f r12, l r13, Continuation r14) {
        r9.getClass();
        if ((r14 instanceof RelatedVideoBinder$generateVMData$1) == false) goto L7;
        RelatedVideoBinder$generateVMData$1 r4 = (RelatedVideoBinder$generateVMData$1) r14;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        Message r2 = (Message) r4.L$3;
        l r8 = (l) r4.L$2;
        usc.e r15 = (usc.e) r4.L$1;
        Spanned r16 = (Spanned) r4.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L14
        Object r0 = r3;
        Message r17 = r2;
        usc.e r18 = r15;
    L51:
        Object r1 = Result.constructor-impl((List) r0);     // Catch: Throwable -> L28
    L33:
        Throwable r19 = Result.exceptionOrNull-impl(r1);
        if (r19 == null) goto L37;
        r19.printStackTrace();
    L37:
        if (Result.isFailure-impl(r1) == false) goto L39;
        r1 = null;
    L39:
        List r20 = (List) r1;
        if (r20 == null) goto L57;
        Integer r21 = r9.c;
        if (r21 == null) goto L45;
        Integer r22 = r21;
    L46:
        if (r17 == null) goto L48;
        boolean r23 = com.larus.bmhome.chat.bean.d.x(r17).getEnableVideoRecommend();
    L50:
        return new com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a(r8, r20, r17, r22, r23);
    L48:
        r23 = false;
        goto L50
    L45:
        ri8.c r24 = ri8.c.a;
        r22 = ri8.c.k(r16, r18);
        r9.c = r22;
        goto L46
    L57:
        return null;
    L28:
        th = th;
    L32:
        Result.Companion r25 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = th;
        r17 = r2;
        r18 = r15;
        goto L32
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        if (r12 == null) goto L21;
        r17 = r12.b;
    L53:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L30
        r4.L$0 = r10;     // Catch: Throwable -> L30
        r4.L$1 = r11;     // Catch: Throwable -> L30
        r4.L$2 = r13;     // Catch: Throwable -> L30
        r4.L$3 = r17;     // Catch: Throwable -> L30
        r4.label = 1;     // Catch: Throwable -> L30
        r0 = BuildersKt.withContext(Dispatchers.getIO(), new RelatedVideoBinder$parseGetVideoDataList$2(r11, r9, r17, null), r4);     // Catch: Throwable -> L30
        if (r0 == r6) goto L58;
        r16 = r10;
        r18 = r11;
        r8 = r13;
        goto L51
    L58:
        return r6;
    L30:
        th = th;
        r16 = r10;
        r18 = r11;
        r8 = r13;
        goto L32
    L21:
        r17 = null;
    L7:
        r4 = new RelatedVideoBinder$generateVMData$1(r9, r14);
        goto L8
    }
}
