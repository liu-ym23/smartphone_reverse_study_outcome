package com.larus.setting.impl.iconchanger;

import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.larus.bmhome.auth.CocoSetting;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.e0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconManager$preload$1", f = "ChangeAppIconManager.kt", i = {0}, l = {460}, m = "invokeSuspend", n = {"id"}, s = {"L$1"})
public final class ChangeAppIconManager$preload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;

    public static final class a extends BaseDataSubscriber<Void> {
        public final /* synthetic */ Integer a;

        public final void onFailureImpl(DataSource<Void> r2) {
            Intrinsics.checkNotNullParameter(r2, "dataSource");
        }

        public a(Integer r1) {
            this.a = r1;
        }

        public final void onNewResultImpl(DataSource<Void> r2) {
            Intrinsics.checkNotNullParameter(r2, "dataSource");
            ChangeAppIconManager.c.add(this.a);
        }
    }

    public ChangeAppIconManager$preload$1(Continuation<? super ChangeAppIconManager$preload$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ChangeAppIconManager$preload$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0075 -> B:37:0x007b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0095 -> B:19:0x004d). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        Integer r2 = (Integer) this.L$1;
        Iterator r3 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L8
        Iterator r4 = r3;
        Integer r5 = r2;
        Object r6 = r0;
        ChangeAppIconManager$preload$1 r7 = this;
    L37:
        ((DataSource) r12).subscribe(new a(r5), UiThreadImmediateExecutorService.getInstance());     // Catch: Exception -> L28
        ChangeAppIconManager$preload$1 r13 = r7;
        r0 = r6;
        r3 = r4;
    L20:
        if (r3.hasNext() == false) goto L34;
        CocoSetting r8 = (CocoSetting) r3.next();
        String r9 = r8.c();
        Integer r10 = r8.a();
        r13.L$0 = r3;     // Catch: Exception -> L30
        r13.L$1 = r10;     // Catch: Exception -> L30
        r13.label = 1;     // Catch: Exception -> L30
        Object r11 = ImageLoaderKt.C(r9, "change_app_icon", null, null, r13, 60);     // Catch: Exception -> L30
        if (r11 != r0) goto L25;
        return r0;
    L25:
        Object r14 = r0;
        r7 = r13;
        r12 = r11;
        r4 = r3;
        r5 = r10;
        r6 = r14;
    L30:
        e = move-exception;
        Object r15 = r0;
        r7 = r13;
        Exception e = e;
        r6 = r15;
    L32:
        FLogger.a.i("ChangeAppIconDynamicImgLoader", "preload error=" + e.getMessage());
        r13 = r7;
        r0 = r6;
    L34:
        return Unit.INSTANCE;
    L28:
        e = e;
        r3 = r4;
    L8:
        e = e;
        r6 = r0;
        r7 = this;
        goto L32
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r12);
        c1 r16 = (c1) AuthModelDelegate.b.c().getValue();
        if (r16 == null) goto L34;
        e0 r17 = (e0) r16.d;
        if (r17 == null) goto L34;
        List r18 = r17.p();
        if (r18 == null) goto L34;
        r3 = r18.iterator();
        r13 = this;
        goto L20
    }
}
