package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.n0;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m implements com.larus.bmhome.chat.component.bottom.multimodal.upload.m {
    public final /* synthetic */ UplinkFileEntity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref.ObjectRef<String> c;
    public final /* synthetic */ NestedFileContent d;
    public final /* synthetic */ AttachmentInfo e;
    public final /* synthetic */ f f;
    public final /* synthetic */ Function3<AttachmentInfo, List<String>, String, Unit> g;
    public final /* synthetic */ Ref.ObjectRef<String> h;

    public static final class a implements IIMCallback<Message> {
        public a() {
        }

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            Message r2 = (Message) r1;
        }
    }

    public static final class b implements IIMCallback<Message> {
        public b() {
        }

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            Message r2 = (Message) r1;
        }
    }

    public static final class c implements IIMCallback<Message> {
        public final /* synthetic */ AttachmentInfo a;
        public final /* synthetic */ mr9.l b;
        public final /* synthetic */ String c;
        public final /* synthetic */ f d;
        public final /* synthetic */ Function3<AttachmentInfo, List<String>, String, Unit> e;
        public final /* synthetic */ Ref.ObjectRef<String> f;
        public final /* synthetic */ Ref.ObjectRef<String> g;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r24) {
            Intrinsics.checkNotNullParameter((Message) r24, "result");
            boolean r4 = this.a.isImage();
            mr9.l r2 = this.b;
            String r3 = r2.a;
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            String r5 = r3;
            mr9.d r6 = r2.d;
            if (r6 == null) goto L8;
            Integer r7 = Integer.valueOf(r6.a);
        L9:
            mr9.d r8 = this.b.d;
            if (r8 == null) goto L12;
            Integer r9 = Integer.valueOf(r8.b);
        L13:
            AttachmentInfo r1 = new AttachmentInfo(r4, r5, r7, r9, this.a.getFilePath(), this.a.getFileName(), this.a.getFromScene(), this.b.c, this.c, this.a.getActionBarKey(), null, null, null, this.b.g, null, null, null, 120832, null);
            f r10 = this.d;
            int r11 = f.d;
            if (r10.d() == false) goto L16;
            FLogger.a.i("CoreInputSender", "[sendSingleAttachmentV2] consumeInterruptCommand, skip send");
            return;
        L16:
            this.e.invoke(r1, CollectionsKt.listOf(this.f.element), this.g.element);
            return;
        L12:
            r9 = null;
            goto L13
        L8:
            r7 = null;
            goto L9
        }

        public c(AttachmentInfo r1, mr9.l r2, String r3, f r4, Function3<? super AttachmentInfo, ? super List<String>, ? super String, Unit> r5, Ref.ObjectRef<String> r6, Ref.ObjectRef<String> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
    public final void c(boolean r1) {
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
    public final void d(n0 r2) {
        Intrinsics.checkNotNullParameter(r2, "processResult");
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
    public final void a(long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
        this.a.setUpLinkProcess(Integer.valueOf((int) r3));
        if (r3 < 0) goto L5;
        this.a.setUpLinkStatus(Integer.valueOf(UpLinkState.PROCESSING.getValue()));
    L5:
        u1$a.g(zh8.a.a.getSender(), this.b, (String) this.c.element, this.d, new b());
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
    public final void b(mr9.l r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "uploadResult");
        Intrinsics.checkNotNullParameter(r21, "fileIdentifier");
        UplinkEntityContent r1 = this.a.getUplinkEntityContent();
        String r2 = null;
        if (r1 == null) goto L18;
        Image r3 = r1.getUplinkImageInfo();
        if (r3 == null) goto L18;
        UplinkFileEntity r4 = this.a;
        r3.key = r20.a;
        r3.md5 = l1.e(r4);
        mr9.d r5 = r20.d;
        if (r5 == null) goto L9;
        int r13 = r5.b;
    L10:
        if (r5 == null) goto L12;
        int r14 = r5.a;
    L13:
        ImageObj r6 = r3.imageOri;
        if (r6 == null) goto L16;
        String r16 = r6.format;
    L17:
        r3.imageOri = new ImageObj(null, r13, r14, null, r16, 9, null);
        r3.resourceId = r20.c;
        goto L18
    L16:
        r16 = null;
        goto L17
    L12:
        r14 = 0;
        goto L13
    L9:
        r13 = 0;
    L18:
        UplinkEntityContent r7 = this.a.getUplinkEntityContent();
        if (r7 == null) goto L23;
        UplinkFileInfo r8 = r7.getUplinkFileInfo();
        if (r8 == null) goto L23;
        r8.setMd5(l1.e(this.a));
        r8.setTosKey(r20.a);
        r8.setResourceId(r20.c);
    L23:
        UplinkFileEntity r9 = this.a;
        ResourceUploadInstantInfo r10 = r20.g;
        if (r10 == null) goto L26;
        r2 = GsonProtectorUtils.toJson(new Gson(), r10);
    L26:
        r9.setInstantUploadInfoJson(r2);
        this.a.setUpLinkProcess(100);
        this.a.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
        u1 r11 = zh8.a.a.getSender();
        String r12 = this.b;
        Ref.ObjectRef<String> r15 = this.c;
        u1$a.g(r11, r12, (String) r15.element, this.d, new c(this.e, r20, r21, this.f, this.g, r15, this.h));
        n r17 = n.a;
        Intrinsics.checkNotNullParameter(r21, "fileIdentifier");
        n.b.remove(r21);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
    public final void e(String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "fileIdentifier");
        this.a.setUpLinkStatus(Integer.valueOf(UpLinkState.FAIL.getValue()));
        Map r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("send_loading", "0")});
        IChatRepoService r0 = zh8.a.a;
        r0.getSender().v(this.b, (String) this.c.element, this.d, r12, new a());
        if (o0.d((String) this.h.element) == false) goto L5;
        f r1 = this.f;
        String r2 = (String) this.h.element;
        r1.getClass();
        r0.r1(r2, new com.larus.bmhome.chat.component.bottom.multimodal.sender.a(r12));
    L5:
        n r13 = n.a;
        Intrinsics.checkNotNullParameter(r10, "fileIdentifier");
        n.b.remove(r10);
    }

    public m(UplinkFileEntity r1, String r2, Ref.ObjectRef<String> r3, NestedFileContent r4, AttachmentInfo r5, f r6, Function3<? super AttachmentInfo, ? super List<String>, ? super String, Unit> r7, Ref.ObjectRef<String> r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
