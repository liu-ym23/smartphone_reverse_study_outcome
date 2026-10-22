package com.larus.uaigc.chat.markdown.image.component;

import android.view.ViewStub;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.creative.loading.MessageLoadingUIState;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.creative.messagecard.bean.LoadingInfo;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImagePlaceHolder;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements ly9.a {
    public final CoroutineScope a;
    public final Lazy<i1<MessageLoadingUIState>> b;
    public final Lazy c;
    public Job d;
    public String e;

    public static final class a {
    }

    static {
    }

    @Override // ly9.a
    public final void a(String r10, Message r11) {
        boolean r0 = true;
        String r1 = null;
        if (r10 != null) goto L10;
        if (r11 != null) goto L10;
        FLogger.a.d("ImageLoadingProgressComponent", "refreshLoadingStatus, taskId and message is null");
        ((ISketchLoadingController) this.c.getValue()).hide();
        Job r12 = this.d;
        if (r12 == null) goto L8;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L8:
        this.d = null;
        return;
    L10:
        if (r11 == null) goto L12;
        String r2 = r11.getLocalMessageId();
    L13:
        String r3 = DataConverterKt.a(r2, r10);
        if (o0.d(r10) == true) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(this.e, r3) == true) goto L69;
        this.e = r3;
        Job r4 = this.d;
        if (r4 == null) goto L20;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L20:
        this.d = BuildersKt.launch$default(this.a, null, null, new ImageLoadingProgressComponent$observeProgress$1(this, null), 3, null);
        ISketchLoadingController.a.b((ISketchLoadingController) this.c.getValue(), false, null, 0, 7);
        ISketchLoadingController r5 = (ISketchLoadingController) this.c.getValue();
        String r6 = "";
        if (r10 != null) goto L23;
        r10 = "";
    L23:
        if (r11 != null) goto L25;
    L27:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L43;
        Iterator r13 = ((ArrayList) com.larus.im.bean.message.a.l(r11)).iterator();
    L31:
        if (r13.hasNext() == false) goto L35;
        Object r8 = r13.next();
        if (Intrinsics.areEqual(((CreationItem) r8).id, r10) == false) goto L31;
    L36:
        CreationItem r9 = (CreationItem) r8;
        if (r9 == null) goto L60;
        ImageData r14 = r9.image;
        if (r14 == null) goto L60;
        ImagePlaceHolder r15 = r14.placeholder;
        if (r15 == null) goto L60;
        r1 = r15.description;
    L60:
        if (r1 == null) goto L63;
        r6 = r1;
    L63:
        ISketchLoadingController.a.a(r5, r6, 0, 6);
        return;
    L35:
        r8 = null;
        goto L36
    L43:
        if (r11 != null) goto L45;
    L47:
        r0 = false;
    L48:
        if (r0 == false) goto L60;
        CreationMsgContentData r16 = dp8.e.c(r11);
        if (r16 == null) goto L60;
        CreationInfo r17 = r16.creationInfo;
        if (r17 == null) goto L60;
        Map r18 = r17.taskInfo;
        if (r18 == null) goto L60;
        CreationTask r19 = (CreationTask) r18.get(r10);
        if (r19 == null) goto L60;
        LoadingInfo r110 = r19.loadingInfo;
        if (r110 == null) goto L60;
        r1 = r110.loadingText;
        goto L60
    L45:
        if (com.larus.bmhome.chat.bean.d.a0(r11) != true) goto L47;
    L25:
        if (com.larus.bmhome.chat.bean.d.k(r11) != true) goto L27;
        r7 = true;
        goto L28
    L69:
        return;
    L12:
        r2 = null;
        goto L13
    }

    public c(final ViewStub r2, CoroutineScope r3, Lazy<? extends i1<MessageLoadingUIState>> r4) {
        Intrinsics.checkNotNullParameter(r2, "sketchProgressLoadingViewStub");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "loadingProgressState");
        this.a = r3;
        this.b = r4;
        this.c = LazyKt.lazy(new b(r2));
    }
}
