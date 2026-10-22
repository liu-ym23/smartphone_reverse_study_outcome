package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.utils.v0;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.chatwindow.view.photopreview.OperateListenerImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.i0;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.widget.photo.preview.EnterSource;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements mcc.g {
    public final c a;
    public final RichText b;
    public final boolean c;

    public static final class a {
    }

    static {
    }

    public final c getContext() {
        return this.a;
    }

    public final void j(View r13, mcc.p r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r14, "imageClickInfo");
        Message r0 = this.a.d;
        Image r1 = com.ss.android.lark.widget.richtext.d.a(this.b, r14.c, r14.b);
        if (r1 != null) goto L6;
        Log.e("ImageSpanClickListener", "Can't find select image, token:" + r14.c + ", url:" + r14.b);
        return;
    L6:
        com.ss.android.lark.image.entity.Image r2 = i0.a(r1);
        if (r2 != null) goto L9;
        return;
    L9:
        PhotoItem r3 = v0.d(this.b, r2, r0.getId(), r0.isFromMe(), r0.getFromChatterTenantId());
        if (r3 != null) goto L12;
        return;
    L12:
        MessageIdentity r4 = r3.getMessageIdentity();
        if (r4 != null) goto L15;
    L17:
        r3.getTranslateProperty().setTranslated(this.c);
        r3.setThumbnail(r14.h);
        ActivityTransitionLauncher.LocationInfo r5 = new ActivityTransitionLauncher.LocationInfo();
        r5.width = r14.d;
        r5.height = r14.e;
        r5.left = r14.f;
        r5.top = r14.g;
        List<ImageSet> r15 = v0.e(this.b, this.a.d.isFromMe(), this.a.d.getFromChatterTenantId());
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = ((ArrayList) r15).iterator();
    L19:
        if (r16.hasNext() == false) goto L21;
        ImageSet r7 = (ImageSet) r16.next();
        Intrinsics.checkNotNull(r7);
        c r8 = this.a;
        g4b.a.a(r7, r8.d, r8.c, this.c);
        r6.add(r7);
        goto L19
    L21:
        int r17 = com.ss.android.lark.widget.photo.preview.utils.d.a;
        List r18 = com.ss.android.lark.widget.photo.preview.utils.d.b(r6, this.a.d.getId());
        if (CollectionUtils.isEmpty(r18) == true) goto L30;
        PhotoUtilsNew r9 = PhotoUtilsNew.a;
        int r10 = PhotoUtilsNew.g(r18, r3);
        if (r10 <= (-1)) goto L27;
        ((PhotoItem) ListProtector.get(r18, r10)).setThumbnail(r3.getThumbnail());
    L27:
        boolean r11 = ChatCoreModule.a().getFeatureGatingDependency().isEnable("translate.message.image.viewer.enable");
        Chat r12 = this.a.c;
        boolean r19 = y0.a(r12);
        boolean r20 = y0.b(r12);
        boolean r21 = y0.c(r12);
        boolean r22 = y0.d(r12);
        boolean r23 = y0.a(r12);
        boolean r110 = y0.e(r12);
        int r111 = com.ss.android.lark.widget.photo.preview.k.a;
        com.ss.android.lark.widget.photo.preview.k.c r112 = com.ss.android.lark.widget.photo.preview.k.a.a(r18, r10, r13);
        r112.c(7414);
        r112.d(false);
        r112.i(r23);
        r112.o(r11);
        r112.f(new OperateListenerImpl(r12));
        r112.c = r5;
        r112.m(r22);
        r112.l(r20);
        r112.n(r20);
        r112.h(r21);
        r112.e(!r110);
        r112.j(true);
        r112.p(true);
        r112.g(r19);
        r112.b(EnterSource.Message);
        r112.u(ContextsKt.requireActivity(this.a.getContext()));
        int r113 = w5c.a.a;
        w5c.a.a(r12.getId(), r3.getImageKey());
        return;
    L30:
        return;
    L15:
        if (r0.getType() != Message.Type.POST) goto L17;
        r4.setRiskObjectKeys(((PostContent) r0.getContent()).getRiskObjectKeys());
        goto L17
    }

    public m(c r2, RichText r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "richText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
