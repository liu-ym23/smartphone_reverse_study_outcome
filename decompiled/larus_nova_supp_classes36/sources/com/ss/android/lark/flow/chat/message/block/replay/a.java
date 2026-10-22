package com.ss.android.lark.flow.chat.message.block.replay;

import acc.d;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.larkfeed.impl.gallery.SocialGalleryRecallProvider;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.v0;
import com.ss.android.lark.flow.chat.message.image.f;
import com.ss.android.lark.flow.chat.message.image.model.FlowMediaMessageType;
import com.ss.android.lark.flow.chat.message.image.model.FlowPhotoItem;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kza.m;
import kza.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ y6b.c<?> a;
    public final /* synthetic */ c b;
    public final /* synthetic */ MessagePermissionUtil.ReceiveAuthorizationState c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ ValidateResult e;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.block.replay.a$a, reason: collision with other inner class name */
    public static final class C0025a implements kza.c {
        public C0025a() {
        }

        public final void a(SocialGalleryRecallProvider.observer.1 r2) {
            Intrinsics.checkNotNullParameter(r2, "observer");
        }

        public final void d(SocialGalleryRecallProvider.observer.1 r2) {
            Intrinsics.checkNotNullParameter(r2, "observer");
        }

        public final void b(FragmentActivity r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "localPath");
            Intrinsics.checkNotNullParameter(r4, "messageId");
        }

        public final void c(GallerySource r2, FragmentActivity r3, boolean r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "activity");
            com.ss.android.lark.flow.chat.message.image.b.a(r3, r4, r5);
        }
    }

    public a(y6b.c<?> r1, c r2, MessagePermissionUtil.ReceiveAuthorizationState r3, boolean r4, ValidateResult r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        ImageContentVO r9 = this.a.o;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
        ImageContentVO r10 = r9;
        String r1 = null;
        if (((v5b.a) r10).a.resourceIsCleaned() == false) goto L10;
        FragmentActivity r11 = this.b.e.getContext();
        ResourceType r2 = ResourceType.IMAGE;
        ResourceCleanScene r3 = lpc.a.b(this.a);
        y6b.b r4 = this.a.t;
        if (r4 == null) goto L7;
        r1 = r4.w;
    L7:
        acc.a.f(r11, new d(r2, r3, acc.a.d(r1)));
        return;
    L10:
        if (MessagePermissionUtil.g(this.c) == false) goto L22;
        MessagePermissionUtil.ReceiveAuthorizationState r12 = this.c;
        if (r12 != MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L15;
        MessagePermissionUtil.m(this.b.e.getContext());
        return;
    L15:
        if (r12 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L54;
        AuthorizationServiceV2 r13 = owa.a.c();
        ValidateIMFileResult r0 = this.a.F;
        if (r0 == null) goto L19;
        r1 = r0.getValidateResult();
    L19:
        r13.d(r1, MessagePermissionUtil.a());
        return;
    L54:
        return;
    L22:
        if (this.d == true) goto L25;
        MessagePermissionUtil.n(this.b.e.getContext(), 2131891410, this.e);
        return;
    L25:
        PhotoItem r14 = v0.g(r10, this.a.c);
        if (r14 == null) goto L55;
        FragmentActivity r5 = this.b.e.getContext();
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        r7.add(r14);
        Iterator r15 = r7.iterator();
    L29:
        if (r15.hasNext() == false) goto L40;
        PhotoItem r16 = (PhotoItem) r15.next();
        if ((r16 instanceof FlowPhotoItem) == true) goto L32;
        r6.add(f.e(r5, r16));
        goto L29
    L32:
        FlowPhotoItem r17 = (FlowPhotoItem) r16;
        if (r17.getMediaMessageType() == FlowMediaMessageType.Doubao) goto L36;
        if (r17.getMediaMessageType() != FlowMediaMessageType.Lark) goto L29;
    L36:
        m r18 = r17.getPreviewItem();
        if (r18 == null) goto L29;
        r6.add(r18);
        goto L29
    L40:
        int r19 = com.ss.android.lark.flow.chat.message.image.b.a;
        n r20 = new n(com.ss.android.lark.flow.chat.message.image.b.b(this.b.e), r6, true, new C0025a(), 8);
        ((kza.d) this.b.g.getValue()).T1(r20, r5);
        return;
    }
}
