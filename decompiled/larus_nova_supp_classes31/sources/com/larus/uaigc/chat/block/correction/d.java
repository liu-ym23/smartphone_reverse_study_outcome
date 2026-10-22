package com.larus.uaigc.chat.block.correction;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import java.util.List;
import kc8.y;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements f {
    public final /* synthetic */ e a;
    public final /* synthetic */ a b;

    public d(e r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.uaigc.chat.block.correction.f
    public final void a(SimpleDraweeView r19, CreationItem r20) {
        Intrinsics.checkNotNullParameter(r19, "bindView");
        Intrinsics.checkNotNullParameter(r20, "creationItem");
        e r11 = this.a;
        Message r4 = this.b.j();
        View r2 = r11.i;
        if (r2 == null) goto L5;
        r2.setOnLongClickListener(null);
        r2.setLongClickable(false);
    L5:
        r11.i = null;
        r19.setOnLongClickListener(null);
        r19.setLongClickable(false);
        ImageData r1 = r20.image;
        if (r1 == null) goto L29;
        ImageItem r6 = bz9.a.k(r1, null);
        String r3 = ((jc8.b) r11).b;
        String r8 = r4.getMessageId();
        ChatParam r9 = r11.j();
        kc8.b r5 = r11.d;
        if (r5 == null) goto L14;
        y r7 = r5.a;
        if (r7 == null) goto L14;
        q0 r10 = r7.x;
        if (r10 == null) goto L14;
        q0.a r12 = r10.getProvider();
    L15:
        kc8.b r13 = r11.d;
        if (r13 == null) goto L30;
        y r14 = r13.a;
        if (r14 == null) goto L31;
        Fragment r15 = r14.a;
        if (r15 == null) goto L32;
        LifecycleCoroutineScope r16 = LifecycleOwnerKt.getLifecycleScope(r15);
        if (r16 == null) goto L33;
        r11.i = r19;
        Job r17 = r11.h;
        if (r17 == null) goto L27;
        Job.DefaultImpls.cancel$default(r17, null, 1, null);
    L27:
        r11.h = BuildersKt.launch$default(r16, Dispatchers.getMain(), null, new CorrectionImageBlockHolder$bindLongClickListener$1(r11, r3, r4, r8, r6, r19, r12, r9, null), 2, null);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L14:
        r12 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.uaigc.chat.block.correction.f
    public final void b(CorrectionImageView r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        if (r12 != null) goto L5;
        return;
    L5:
        Context r1 = r11.getContext();
        List r2 = CollectionsKt.listOf(r12);
        Pair[] r13 = new Pair[7];
        boolean r0 = false;
        r13[0] = TuplesKt.to("user_type", "bot");
        String r5 = "chat";
        r13[1] = TuplesKt.to("enter_picture_method", "chat");
        kc8.b r14 = this.a.d;
        if (r14 == null) goto L10;
        y r15 = r14.a;
        if (r15 == null) goto L10;
        r0 = Intrinsics.areEqual(r15.g, Boolean.TRUE);
    L10:
        if (r0 == false) goto L12;
        r5 = "temporary_chat";
    L12:
        r13[2] = TuplesKt.to("enter_from", r5);
        ChatParam r16 = this.a.j();
        if (r16 == null) goto L15;
        String r17 = r16.b;
    L16:
        String r6 = "";
        if (r17 != null) goto L19;
        r17 = "";
    L19:
        r13[3] = TuplesKt.to("bot_id", r17);
        ChatParam r18 = this.a.j();
        if (r18 == null) goto L22;
        String r19 = r18.e;
    L23:
        if (r19 != null) goto L25;
        r19 = "";
    L25:
        r13[4] = TuplesKt.to("chat_type", r19);
        ChatParam r110 = this.a.j();
        if (r110 == null) goto L28;
        String r111 = r110.d;
    L29:
        if (r111 != null) goto L31;
        r111 = "";
    L31:
        r13[5] = TuplesKt.to("current_page", r111);
        ChatParam r112 = this.a.j();
        if (r112 == null) goto L34;
        String r113 = r112.c;
    L35:
        if (r113 == null) goto L38;
        r6 = r113;
    L38:
        r13[6] = TuplesKt.to("previous_page", r6);
        com.larus.bmhome.bigimg.k.b(r1, r2, 0, new uo8.k(MapsKt.mapOf(r13), null), false, null, null, null, 4064);
        return;
    L34:
        r113 = null;
        goto L35
    L28:
        r111 = null;
        goto L29
    L22:
        r19 = null;
        goto L23
    L15:
        r17 = null;
        goto L16
    }
}
