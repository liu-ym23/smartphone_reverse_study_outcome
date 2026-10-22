package com.larus.avlink.gallery.view;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LiveData;
import com.larus.avlink.gallery.AlbumUtils;
import com.larus.avlink.gallery.viewmodel.GalleryViewModel;
import com.larus.avlink.impl.databinding.LarusFragmentMineAlbumListBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment$updateCalendarIndicator$1", f = "MineAlbumFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MineAlbumFragment$updateCalendarIndicator$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.bigimg.t1 $data;
    int label;
    final /* synthetic */ MineAlbumFragment this$0;

    public MineAlbumFragment$updateCalendarIndicator$1(MineAlbumFragment r1, com.larus.bmhome.bigimg.t1 r2, Continuation<? super MineAlbumFragment$updateCalendarIndicator$1> r3) {
        this.this$0 = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MineAlbumFragment$updateCalendarIndicator$1(this.this$0, this.$data, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L43;
        ResultKt.throwOnFailure(r12);
        LarusFragmentMineAlbumListBinding r13 = this.this$0.k;
        boolean r0 = false;
        List r1 = null;
        if (r13 == null) goto L22;
        AppCompatTextView r14 = r13.h;
        if (r14 == null) goto L22;
        int r2 = AlbumUtils.a;
        com.larus.bmhome.bigimg.t1 r3 = this.$data;
        if (r3 == null) goto L11;
        Long r4 = Boxing.boxLong(r3.e());
    L12:
        if (r4 == null) goto L20;
        r4.longValue();
        Calendar r5 = Calendar.getInstance();
        r5.set(11, 0);
        r5.set(12, 0);
        r5.set(13, 0);
        r5.set(14, 0);
        Calendar r8 = Calendar.getInstance();
        r8.setTimeInMillis(r4.longValue());
        r8.set(11, 0);
        r8.set(12, 0);
        r8.set(13, 0);
        r8.set(14, 0);
        long r6 = (r5.getTimeInMillis() - r8.getTimeInMillis()) / ((long) 86400000);
        if (r6 != 0) goto L17;
        String r7 = AppHost.a.getApplication().getString(2131910491);
    L21:
        r14.setText(r7);
        goto L22
    L17:
        if (r6 != 1) goto L19;
        r7 = AppHost.a.getApplication().getString(2131911531);
        goto L21
    L19:
        r7 = new SimpleDateFormat(AppHost.a.getApplication().getString(2131900834), Locale.CHINA).format(new Date(r4.longValue()));
        Intrinsics.checkNotNull(r7);
        goto L21
    L20:
        r7 = "";
        goto L21
    L11:
        r4 = null;
    L22:
        MineAlbumFragment r15 = this.this$0;
        if (r15.x == false) goto L41;
        GalleryViewModel r16 = r15.t;
        if (r16 == null) goto L29;
        LiveData<List<com.larus.bmhome.bigimg.t1>> r17 = r16.getLocalMediaList();
        if (r17 == null) goto L29;
        r1 = (List) r17.getValue();
    L29:
        List r9 = r1;
        if (r9 != null) goto L32;
    L33:
        r0 = true;
    L34:
        if (r0 == true) goto L41;
        LarusFragmentMineAlbumListBinding r18 = this.this$0.k;
        if (r18 == null) goto L41;
        AppCompatTextView r19 = r18.h;
        if (r19 == null) goto L41;
        com.larus.utils.e1.x(r19);
        goto L41
    L32:
        if (r9.isEmpty() == false) goto L34;
    L41:
        return Unit.INSTANCE;
    L43:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
