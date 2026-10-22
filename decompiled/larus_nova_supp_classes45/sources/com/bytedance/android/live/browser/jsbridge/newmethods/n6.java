package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.browser.jsbridge.base.LiveHighlightTranscodingResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.highlightTranscoding")
public final class n6 extends w20.z2<w20.ua, LiveHighlightTranscodingResultModel> {
    public String a;

    public n6() {
    }

    public static final void j(n6 r2, List r3) {
        r2.getClass();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        String r5 = (String) r4.next();
        if (new PolarisFileWrapper(r5).delete() == true) goto L4;
        ALogger.e("LiveHighlightTranscodingMethod", "delete failed, file path is " + r5);
        goto L4
    }

    public final void invoke(Object r22, CallContext r23) {
        n6 r11 = this;
        final w20.ua r12 = (w20.ua) r22;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r23, "context");
        ICommentService r0 = jc1.k.f(ICommentService.class);
        Object r13 = null;
        if (r0 == null) goto L5;
        String r1 = r0.getCacheFilePath(getCallContext().getContext());
    L6:
        r11.a = r1;
        final ICommentService r14 = jc1.k.f(ICommentService.class);
        if (r14 == null) goto L62;
        LiveHighlightTranscodingResultModel r15 = new LiveHighlightTranscodingResultModel();
        final ArrayList r16 = new ArrayList();
        ArrayList r9 = new ArrayList();
        ArrayList r8 = new ArrayList();
        List<w20.ua.a> r2 = r12.b();
        if (r2 == null) goto L60;
        Iterator<T> r17 = r2.iterator();
    L12:
        if (r17.hasNext() == false) goto L60;
        final w20.ua.a r3 = (w20.ua.a) r17.next();
        String r4 = r3.a();
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        String r5 = r11.a;
        if (r5 == null) goto L32;
        File[] r6 = new PolarisFileWrapper(r5).listFiles();
        if (r6 == null) goto L32;
        int r7 = r6.length;
        int r18 = 0;
    L21:
        if (r18 >= r7) goto L32;
        File r19 = r6[r18];
        if (r4.length() <= 0) goto L25;
        boolean r110 = true;
    L26:
        if (r110 == false) goto L31;
        if (StringsKt.contains$default(r19.getName(), r4, false, 2, r13) == false) goto L31;
        String r21 = r19.getAbsolutePath();
    L34:
        if (r21.length() <= 0) goto L36;
        boolean r24 = true;
    L37:
        if (r24 == false) goto L39;
        LiveHighlightTranscodingResultModel.b r25 = new LiveHighlightTranscodingResultModel.b();
        r25.a(r3.a());
        r25.b(r21);
        Unit r26 = Unit.INSTANCE;
        r8.add(r25);
        final ArrayList r27 = r8;
        ArrayList r28 = r9;
    L59:
        r11 = this;
        r15 = r15;
        r8 = r27;
        r9 = r28;
        r13 = null;
        goto L12
    L39:
        final ArrayList r29 = new ArrayList();
        List<String> r31 = r3.b();
        if (r31 != null) goto L42;
        r31 = CollectionsKt.emptyList();
    L42:
        int r32 = r31.size();
        String[] r33 = new String[r32];
        int r34 = 0;
    L43:
        if (r34 >= r32) goto L45;
        r33[r34] = "";
        r34 = r34 + 1;
        goto L43
    L45:
        int r35 = r31.size();
        int r36 = 0;
    L46:
        if (r36 >= r35) goto L58;
        String r37 = (String) ListProtector.get(r31, r36);
        if (r37 != null) goto L50;
    L53:
        boolean r111 = true;
    L54:
        if (r111 == true) goto L57;
        String r38 = r11.a + File.separator + r36 + Item.MIX_ID_SEPERATOR + r3.a();
        r16.add(new Pair(r37, r38));
        r33[r36] = r38;
        ListProtector.add(r29, r36, r38);
    L57:
        r36 = r36 + 1;
        goto L46
    L50:
        if (r37.length() == 0) goto L53;
        r111 = false;
        goto L54
    L58:
        final String r112 = r11.a + File.separator + System.currentTimeMillis() + '_' + r3.a() + "_highlight.mp4";
        final ArrayList r39 = r8;
        final ArrayList r41 = r9;
        r27 = r8;
        final ArrayList r210 = r9;
        r28 = r210;
        r28.add(Observable.concat(r14.createDownloadTask(r16), Observable.create(new m6(r33, r112, new LiveHighlightTranscodingMethod$concatVideo$$inlined$let$lambda$1(r29, r3, r112, r39, r16, r41, r14, this, r12), new LiveHighlightTranscodingMethod$concatVideo$$inlined$let$lambda$2(r29, r112, r27, r16, r210, r14, this, r12))).subscribeOn(Schedulers.io())));
        goto L59
    L36:
        r24 = false;
    L31:
        r18 = r18 + 1;
        r6 = r6;
        goto L21
    L25:
        r110 = false;
    L32:
        r21 = "";
    L60:
        Observable.zip(r9, k6.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(l6.a, new i6(this, r12), new j6(r15, r8, this, r12));
        return;
    L62:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
