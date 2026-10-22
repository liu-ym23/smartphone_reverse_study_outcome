package com.ss.android.lark.chat.chatwindow.chat.message.actionimpl;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chatwindow.view.photopreview.OperateListenerImpl;
import com.ss.android.lark.parser.internal.i0;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.Image;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements mya.a {
    public final Activity a;
    public final Scene b;
    public final Chat c;

    public final Activity getActivity() {
        return this.a;
    }

    public a(FragmentActivity r2, Scene r3, Chat r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void a(View r2, List<? extends Image> r3, Image r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "cardImages");
        Intrinsics.checkNotNullParameter(r4, "clickedImageItem");
        Intrinsics.checkNotNullParameter(r5, "msgId");
        List r6 = com.ss.android.lark.widget.photo.preview.utils.d.c(i0.b(r3), r5);
        int r7 = PhotoUtilsNew.g(r6, (PhotoItem) ListProtector.get(com.ss.android.lark.widget.photo.preview.utils.d.c(CollectionsKt.listOf(i0.a(r4)), r5), 0));
        int r8 = k.a;
        k.c r9 = k.a.a(new ArrayList(r6), r7, r2);
        r9.c(194);
        r9.i(true);
        r9.f(new OperateListenerImpl(this.c));
        r9.q(Biz.Messenger, this.b, 7);
        r9.r(this.a);
    }
}
