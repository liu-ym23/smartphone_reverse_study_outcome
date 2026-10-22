package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class PreviewPush implements a2b.c {
    public final a2b.d a;
    public final a2b.f b;
    public final ExecutorService c;
    public final CopyOnWriteArrayList<tya.a> d;
    public final Function1<Throwable, Unit> e;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.sdk.f.a {
        public final /* synthetic */ PreviewPush a;

        public b(PreviewPush r1) {
            this.a = r1;
        }

        public final void a() {
            this.a.a.a();
        }
    }

    static {
    }

    @Override // a2b.c
    public final void N4(tya.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.b(this.d, r3, new b(this));
        this.c.execute(x0.a);
    }

    @Override // a2b.c
    public final void v9(tya.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.a(this.d, r3, new PreviewPush$startPush$1(this));
    }

    @Inject
    public PreviewPush(a2b.d r2, a2b.f r3) {
        Intrinsics.checkNotNullParameter(r2, "pushRepo");
        Intrinsics.checkNotNullParameter(r3, "previewService");
        this.a = r2;
        this.b = r3;
        this.c = CoreThreadPool.getDefault().getSingleScheduledThreadPool("thread-pool-message-preview-push");
        this.d = new CopyOnWriteArrayList();
        this.e = PreviewPush$onError$1.INSTANCE;
    }

    public final List<UrlPreviewHangPoint> a(String r5, List<String> r6) {
        Message r7 = ImSdkService.f().za(r5);
        if (r7 != null) goto L5;
        return null;
    L5:
        uxb.b r8 = r7.getMessageContent();
        if ((r8 instanceof BaseTextContent) == false) goto L8;
        BaseTextContent r9 = (BaseTextContent) r8;
    L9:
        if (r9 != null) goto L11;
        return null;
    L11:
        Collection<PreviewHangPoint> r10 = r9.getPreviewHangPoints().values();
        ArrayList r0 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L13:
        if (r11.hasNext() == false) goto L18;
        PreviewHangPoint r1 = (PreviewHangPoint) r11.next();
        if (CollectionsKt.contains(r6, r1.getPreviewId()) == false) goto L13;
        r0.add(new UrlPreviewHangPoint.Builder().url(r1.getUrl()).preview_id(r1.getPreviewId()).need_local_preview(Boolean.valueOf(r1.getNeedLocalPreview())).is_lazy_load(Boolean.valueOf(r1.isLazyLoad())).build());
        goto L13
    L18:
        return CollectionsKt.toList(r0);
    L8:
        r9 = null;
        goto L9
    }
}
