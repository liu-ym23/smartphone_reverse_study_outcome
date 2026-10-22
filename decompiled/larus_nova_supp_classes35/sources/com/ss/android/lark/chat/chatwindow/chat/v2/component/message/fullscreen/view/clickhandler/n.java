package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.View;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.v0;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.chatwindow.view.photopreview.OperateListenerImpl;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.widget.photo.preview.EnterSource;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.span.MediaInfo;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements mcc.h {
    public final c a;
    public final RichText b;
    public final boolean c;

    public final c getContext() {
        return this.a;
    }

    public final void m(View r12, MediaInfo r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r13, Keys.API_PARAM_KEY_MEDIA_INFO);
        RichTextElement.MediaProperty r0 = com.ss.android.lark.widget.richtext.d.b(this.b, r13);
        if (r0 != null) goto L5;
        return;
    L5:
        PhotoItem r4 = null;
        MediaImageSet r1 = com.ss.android.lark.parser.internal.d.c(this.a.d.getId(), this.a.c.getId(), this.a.d.getFromId(), null, r0);
        r1.getMessageIdentity().setSourceType(Message.SourceType.TYPE_FROM_MESSAGE);
        PhotoItem r2 = (PhotoItem) CollectionsKt.firstOrNull(com.ss.android.lark.widget.photopicker.utils.l.b(CollectionsKt.listOf(r1)));
        if (r2 == null) goto L8;
        r2.setThumbnail(r13.mediaThumbnail);
        r4 = r2;
    L8:
        if (r4 == null) goto L12;
        PhotoItem.TranslateProperty r3 = r4.getTranslateProperty();
        if (r3 == null) goto L12;
        r3.setTranslated(this.c);
    L12:
        ActivityTransitionLauncher.LocationInfo r5 = new ActivityTransitionLauncher.LocationInfo();
        r5.width = r13.width;
        r5.height = r13.height;
        r5.left = r13.left;
        r5.top = r13.top;
        if (r4 == null) goto L37;
        List<ImageSet> r14 = v0.e(this.b, this.a.d.isFromMe(), this.a.d.getFromChatterTenantId());
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = ((ArrayList) r14).iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        ImageSet r7 = (ImageSet) r15.next();
        Intrinsics.checkNotNull(r7);
        c r8 = this.a;
        g4b.a.a(r7, r8.d, r8.c, this.c);
        r6.add(r7);
        goto L17
    L19:
        int r16 = com.ss.android.lark.widget.photo.preview.utils.d.a;
        List r17 = com.ss.android.lark.widget.photo.preview.utils.d.b(r6, this.a.d.getId());
        if (CollectionUtils.isEmpty(r17) == true) goto L38;
        PhotoUtilsNew r9 = PhotoUtilsNew.a;
        int r10 = PhotoUtilsNew.g(r17, r4);
        if (this.a.c.isSecret() == true) goto L27;
        int r11 = y0.a;
        if (y0.a(this.a.c) == false) goto L27;
        boolean r18 = true;
    L28:
        int r19 = y0.a;
        boolean r20 = y0.d(this.a.c);
        boolean r21 = y0.b(this.a.c);
        boolean r22 = y0.e(this.a.c);
        if (y0.c(this.a.c) == true) goto L31;
    L33:
        boolean r23 = false;
    L34:
        OperateListenerImpl r24 = new OperateListenerImpl(this.a.c);
        int r110 = com.ss.android.lark.widget.photo.preview.k.a;
        com.ss.android.lark.widget.photo.preview.k.c r111 = com.ss.android.lark.widget.photo.preview.k.a.a(new ArrayList(r17), r10, r12);
        r111.d(false);
        r111.c = r5;
        r111.j(true);
        r111.g(true);
        r111.l(r21);
        r111.n(r21);
        r111.g(r18);
        r111.m(r20);
        r111.f(r24);
        r111.h(r23);
        r111.e(!r22);
        r111.b(EnterSource.Message);
        r111.u(Contexts.requireActivity(this.a.getContext()));
        return;
    L31:
        if (this.a.d.isPreMessage() == true) goto L33;
        r23 = true;
    L27:
        r18 = false;
        goto L28
    L38:
        return;
    }

    public n(c r2, RichText r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "richText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
