package com.larus.dora.o.impl.album;

import android.view.View;
import android.widget.TextView;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import w88.g;
import w88.h;
import w88.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.album.ODoraAlbumCardView$refresh$1", f = "ODoraAlbumCardView.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
public final class ODoraAlbumCardView$refresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ODoraAlbumCardView this$0;

    public ODoraAlbumCardView$refresh$1(ODoraAlbumCardView r1, Continuation<? super ODoraAlbumCardView$refresh$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ODoraAlbumCardView$refresh$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r21);     // Catch: Exception -> L56
        Object r3 = r21;
    L16:
        g r4 = (g) r3;     // Catch: Exception -> L56
        final ODoraAlbumCardView r1 = this.this$0;
        List r5 = r4.a;
        int r6 = r4.b;
        int r7 = r4.c + r4.d;
        r1.f = r7;
        List r8 = r5;
        if ((r8 instanceof Collection) == true) goto L20;
    L22:
        Iterator r9 = r8.iterator();
    L24:
        if (r9.hasNext() == false) goto L28;
        if (((h) r9.next()).h == false) goto L24;
        boolean r10 = true;
    L29:
        r1.h = r10;
        i r11 = r1.b(r1.g);
        FLogger.a.i("ODoraAlbumCardView", "bindData total=" + r6 + ", items=" + r5.size() + ", unsynced=" + r7 + ", hasInProgressPreview=" + r1.h + ", latest=" + ODoraAlbumCardView.c(r1.g) + ", display=" + ODoraAlbumCardView.c(r11));
        r1.f(r11);
        int r12 = 4;
        if (r5.isEmpty() == false) goto L32;
        r1.d.c.setVisibility(4);
        r1.d.b.setVisibility(0);
    L55:
        return Unit.INSTANCE;
    L32:
        r1.d.c.setVisibility(0);
        r1.d.b.setVisibility(8);
        Iterator r13 = ((ArrayList) r1.e).iterator();
        int r14 = 0;
    L34:
        if (r13.hasNext() == false) goto L55;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        ODoraAlbumCardView.b r17 = (ODoraAlbumCardView.b) r15;
        final h r18 = (h) CollectionsKt.getOrNull(r5, r14);
        if (r18 != null) goto L41;
        r17.a.setVisibility(r12);
        r5 = r5;
    L53:
        r14 = r16;
        r5 = r5;
        r12 = 4;
        goto L34
    L41:
        r17.a.setVisibility(0);
        ImageLoaderKt.u(r17.b, "file://" + r18.b, "dora_o_device_management_album");
        r17.a.setOnClickListener(new e(r1, r18));
        if (r18.c == false) goto L47;
        r17.c.setVisibility(0);
        TextView r110 = r17.c;
        long r111 = (long) (r18.d / ((double) 1000));
        if (r111 >= 0) goto L46;
        r111 = 0;
    L46:
        StringCompanionObject r112 = StringCompanionObject.INSTANCE;
        long r20 = 60;
        r110.setText(String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r111 / r20), Long.valueOf(r111 % r20)}, 2)));
    L48:
        View r22 = r17.d;
        if (r18.h == false) goto L51;
        int r23 = 0;
    L52:
        r22.setVisibility(r23);
        goto L53
    L51:
        r23 = 8;
        goto L52
    L47:
        r17.c.setVisibility(8);
    L28:
        r10 = false;
        goto L29
    L20:
        if (r8.isEmpty() == false) goto L22;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r21);
        IDoraAVLinkService r24 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r24 == null) goto L12;
        this.label = 1;     // Catch: Exception -> L56
        r3 = r24.j1(this);     // Catch: Exception -> L56
        if (r3 != r0) goto L16;
        return r0;
    L12:
        return Unit.INSTANCE;
    L56:
        e = move-exception;
        FLogger.a.e("ODoraAlbumCardView", "getAlbumPreviewData failed: " + e.getMessage());
        return Unit.INSTANCE;
    }
}
