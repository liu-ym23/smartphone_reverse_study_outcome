package com.larus.slides.operation.download.view;

import android.app.Application;
import android.os.Build;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.FileExportType;
import com.larus.common_ui.view.FileExportTypeItemView;
import com.larus.platform.api.IFlowOfficeWikiTokenResolver;
import com.larus.platform.service.i2;
import com.larus.slides.biz.impl.databinding.LarusPageSlidesExportChooseDialogBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kw9.h;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.operation.download.view.SlidesExportChooseDialog$onViewCreated$3$2", f = "SlidesExportChooseDialog.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
public final class SlidesExportChooseDialog$onViewCreated$3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LinearLayout $it;
    int label;
    final /* synthetic */ SlidesExportChooseDialog this$0;

    public SlidesExportChooseDialog$onViewCreated$3$2(SlidesExportChooseDialog r1, LinearLayout r2, Continuation<? super SlidesExportChooseDialog$onViewCreated$3$2> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SlidesExportChooseDialog$onViewCreated$3$2(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.slides.operation.download.view.f, java.lang.Object, kotlin.jvm.functions.Function3] */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L47:
        final String r8 = (String) r12;
        if (r8 != null) goto L51;
        s r13 = s.a;
        Application r2 = AppHost.a.getApplication();
        r13.getClass();
        s.s(r2, 2131909776);
        int r14 = SlidesExportChooseDialog.k;
        SlidesExportChooseDialog.a.a(this.this$0);
        return Unit.INSTANCE;
    L51:
        SlidesExportChooseDialog r15 = this.this$0;
        if (r15.i == true) goto L78;
        if (r15.isDetached() == true) goto L78;
        SlidesExportChooseDialog r16 = this.this$0;
        r16.g = r8;
        boolean r3 = com.larus.slides.operation.download.c.a;
        final FragmentActivity r6 = r16.getContext();
        if (r6 == null) goto L59;
        final SlidesExportChooseDialog r17 = this.this$0;
        final FileExportType r7 = r17.e;
        final String r9 = r17.h;
        final ?? r10 = new f(r17);
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "downloadType");
        Intrinsics.checkNotNullParameter(r8, "token");
        Intrinsics.checkNotNullParameter(r9, "fileName");
        Intrinsics.checkNotNullParameter(r10, "callback");
        FLogger.a.i("SlidesDownloader", "[startDownload] isDownloading:" + com.larus.slides.operation.download.c.a + ", token:" + r8 + ' ');
        if (com.larus.slides.operation.download.c.a == false) goto L63;
        r10.invoke(Boolean.FALSE, null, "current is downloading");
    L76:
        return Unit.INSTANCE;
    L63:
        com.larus.slides.operation.download.c.a = true;
        if (Build.VERSION.SDK_INT <= 28) goto L66;
    L74:
        com.larus.slides.operation.download.c.b(r6, r7, r8, r9, r10);
        goto L76
    L66:
        if (ContextCompat.checkSelfPermission(r6, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L74;
        if ((r6 instanceof FragmentActivity) == false) goto L70;
        FragmentActivity r4 = r6;
    L71:
        if (r4 != null) goto L73;
        com.larus.slides.operation.download.c.a = false;
        r10.invoke(Boolean.FALSE, null, "context is not activity");
        goto L76
    L73:
        i2.b.a(r4, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), new com.larus.slides.operation.download.b(r6, r7, r8, r9, r10));
        goto L76
    L70:
        r4 = null;
        goto L71
    L59:
        return Unit.INSTANCE;
    L78:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        LarusPageSlidesExportChooseDialogBinding r18 = this.this$0.d;
        if (r18 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L11:
        e1.x(r18.c);
        LarusPageSlidesExportChooseDialogBinding r19 = this.this$0.d;
        if (r19 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L14:
        r19.d.setText(this.this$0.getResources().getString(2131909777));
        this.$it.setClickable(false);
        FileExportTypeItemView[] r110 = new FileExportTypeItemView[2];
        LarusPageSlidesExportChooseDialogBinding r5 = this.this$0.d;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L17:
        r110[0] = r5.e;
        LarusPageSlidesExportChooseDialogBinding r11 = this.this$0.d;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L20:
        r110[1] = r11.f;
        List r111 = CollectionsKt.listOf(r110);
        ArrayList r20 = new ArrayList();
        Iterator r112 = r111.iterator();
    L22:
        if (r112.hasNext() == false) goto L26;
        Object r21 = r112.next();
        if (((FileExportTypeItemView) r21).isSelected() == true) goto L22;
        r20.add(r21);
        goto L22
    L26:
        Iterator r113 = r20.iterator();
    L28:
        if (r113.hasNext() == false) goto L30;
        FileExportTypeItemView r22 = (FileExportTypeItemView) r113.next();
        r22.setClickable(false);
        r22.setAlpha(0.5f);
        goto L28
    L30:
        SlidesExportChooseDialog r114 = this.this$0;
        System.currentTimeMillis();
        r114.getClass();
        SlidesExportChooseDialog r115 = this.this$0;
        this.label = 1;
        h r23 = r115.j;
        if (r23 == null) goto L38;
        Integer r24 = r23.j;
        if (r24 == null) goto L38;
        if (r24.intValue() != 14) goto L38;
        boolean r25 = true;
    L39:
        if (r25 == true) goto L41;
        r12 = r115.f;
    L45:
        if (r12 != r0) goto L47;
        return r0;
    L41:
        IFlowOfficeWikiTokenResolver r26 = (IFlowOfficeWikiTokenResolver) ServiceManager.get().getService(IFlowOfficeWikiTokenResolver.class);
        if (r26 == null) goto L44;
        r12 = r26.a(r115.f, this);
        goto L45
    L44:
        r12 = null;
    L38:
        r25 = false;
        goto L39
    }
}
