package com.ss.android.lark.flow.chat.message.image;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.base.frame.FrameFragment;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.i0;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.Image;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements mya.a {
    public final Fragment a;
    public final v b;
    public final Function0<m2b.a> c;
    public final Lazy d;
    public final Lazy e;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.image.a$a, reason: collision with other inner class name */
    public static final class C0026a {
    }

    static {
    }

    public a(FrameFragment r2, v r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "chatAppContainer");
        Intrinsics.checkNotNullParameter(r4, "chatContextProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(FlowCardImageClickActionHandler$openFeishuGalleryPreviewDependency$2.INSTANCE);
        this.e = LazyKt.lazy(new FlowCardImageClickActionHandler$mediaPreviewObserverManager$2(this));
    }

    public final void a(View r9, List<? extends Image> r10, Image r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "cardImages");
        Intrinsics.checkNotNullParameter(r11, "clickedImageItem");
        Intrinsics.checkNotNullParameter(r12, "msgId");
        m2b.a r3 = (m2b.a) this.c.invoke();
        if (r3 != null) goto L6;
        Log.e("FlowCardImageClick", "onCardImageClick failed, chatContext is null");
        return;
    L6:
        com.ss.android.lark.image.entity.Image r13 = i0.a(r11);
        Pair r1 = null;
        if (r13 == null) goto L13;
        List r14 = CollectionsKt.listOf(r13);
        if (r12 != null) goto L11;
        String r2 = "";
    L12:
        PhotoItem r15 = (PhotoItem) CollectionsKt.firstOrNull(com.ss.android.lark.widget.photo.preview.utils.d.c(r14, r2));
    L14:
        if (r15 != null) goto L16;
        Log.e("FlowCardImageClick", "getCardPhotoItems failed, selectPhotoItem is null");
    L26:
        if (r1 != null) goto L28;
        return;
    L28:
        List r4 = (List) r1.component1();
        int r5 = ((Number) r1.component2()).intValue();
        int r16 = FlowMediaPreviewUtils.a;
        FlowMediaPreviewUtils.c(r3.getContext(), this.a, r4, r3, r5, null, (kza.d) this.d.getValue(), (pgb.a) this.e.getValue());
        return;
    L16:
        List r17 = i0.b(r10);
        if (r12 != null) goto L19;
        r12 = "";
    L19:
        List r18 = CollectionsKt.toMutableList(com.ss.android.lark.widget.photo.preview.utils.d.c(r17, r12));
        int r19 = FlowMediaPreviewUtils.a(r18, r15);
        if (r19 > (-1)) goto L23;
        Log.i("FlowCardImageClick", "getCardPhotoItems, currentPosition is -1, use selected item only");
        r18.clear();
        r18.add(r15);
        r19 = 0;
    L23:
        if (r18.isEmpty() == false) goto L25;
        Log.e("FlowCardImageClick", "getCardPhotoItems failed, photoItems is empty");
        goto L26
    L25:
        r1 = TuplesKt.to(r18, Integer.valueOf(r19));
        goto L26
    L11:
        r2 = r12;
        goto L12
    L13:
        r15 = null;
        goto L14
    }
}
