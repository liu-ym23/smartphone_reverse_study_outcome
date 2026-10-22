package com.ss.android.lark.keyboard.biz.send.inject;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.lark.pb.basic.v1.ResourceFile;
import com.bytedance.lark.pb.im.v1.UploadResourceRequest;
import com.bytedance.lark.pb.im.v1.UploadResourceResponse;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.Image;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UpLinkState;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkEntityContent;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileInfo;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.keyboard.base.ResourceUploadInfo;
import com.ss.android.lark.keyboard.base.e;
import com.ss.android.lark.keyboard.base.f;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.base.l;
import com.ss.android.lark.keyboard.base.q;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.utils.FlowSendMessageUtils;
import com.ss.android.lark.keyboard.utils.PluginUtils;
import com.ss.android.lark.keyboard.utils.g;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.b1;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import cya.h;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SendInnerEndPlugin implements wnb.b<SendInnerEndPlugin>, l {
    public static final a q = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public com.ss.android.lark.keyboard.b b;
    public wnb.c c;
    public View d;
    public ImageView e;
    public final Lazy f;
    public final LinkedHashSet<String> g;
    public final LinkedHashSet<String> h;
    public final LinkedHashSet<String> i;
    public Job j;
    public Job k;
    public Job l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final d p;

    public static final class a implements wnb.b.a<SendInnerEndPlugin> {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ SendInnerEndPlugin b;

        public b(View r1, SendInnerEndPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            if (this.a.isEnabled() == true) goto L5;
            return;
        L5:
            SendInnerEndPlugin.f(this.b);
        }
    }

    public static final class c implements View.OnLongClickListener {
        public final /* synthetic */ SendInnerEndPlugin a;

        public c(SendInnerEndPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            com.ss.android.lark.keyboard.keyboard2.b r6 = this.a.k().L();
            l r1 = null;
            if ((r6 instanceof f) == false) goto L5;
            f r7 = (f) r6;
        L7:
            if (r7 != null) goto L9;
            return false;
        L9:
            q r8 = r7.N(true);
            com.ss.android.lark.keyboard.keyboard2.b r2 = this.a.k().L();
            if ((r2 instanceof l) == false) goto L12;
            r1 = (l) r2;
        L12:
            if (r1 != null) goto L14;
            return false;
        L14:
            return r1.g(r8);
        L5:
            r7 = null;
            goto L7
        }
    }

    public static final class d extends OnSingleClickListener {
        public final /* synthetic */ SendInnerEndPlugin a;

        public d(SendInnerEndPlugin r1) {
            this.a = r1;
        }

        public final void onSingleClick(View r1) {
            SendInnerEndPlugin.f(this.a);
        }
    }

    static {
        q = new a();
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final boolean g(q r1) {
        return false;
    }

    @Override // wnb.b
    public final boolean i() {
        return false;
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final void y(boolean r1) {
    }

    @Override // wnb.b
    public final View a() {
        View r0 = LayoutInflater.from(this.a.a.requireContext()).inflate(2131561610, null);
        ImageView r1 = (ImageView) r0.findViewById(2131375941);
        r1.setImageResource(PluginUtils.b());
        this.e = r1;
        r0.setOnClickListener(new b(r0, this));
        r0.setOnLongClickListener(new c(this));
        this.d = r0;
        com.ss.android.lark.keyboard.keyboard2.b r2 = k().L();
        if ((r2 instanceof f) == false) goto L5;
        f r3 = (f) r2;
    L6:
        if (r3 == null) goto L8;
        r3.p(this);
    L8:
        com.ss.android.lark.keyboard.keyboard2.b r4 = k().L();
        if ((r4 instanceof f) == false) goto L11;
        f r5 = (f) r4;
    L12:
        if (r5 == null) goto L14;
        int r6 = e.a;
        r5.N(false);
    L14:
        k().e().of(this).d(h.class, new SendInnerEndPlugin$refreshSendUI$1$1(this));
        Job r7 = this.j;
        if (r7 == null) goto L17;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L17:
        this.j = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a.a), null, null, new SendInnerEndPlugin$initAttachmentStateFlow$1(this, null), 3, null);
        Job r8 = this.k;
        if (r8 == null) goto L20;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L20:
        this.k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a.a), null, null, new SendInnerEndPlugin$initUploadPush$1(this, null), 3, null);
        Intrinsics.checkNotNull(r0);
        return r0;
    L11:
        r5 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    @Override // wnb.b
    public final wnb.e b() {
        return new wnb.e(0, 0, UIHelper.dp2px(12.0f), 0);
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    public final com.ss.android.lark.keyboard.b k() {
        com.ss.android.lark.keyboard.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        View r0 = this.d;
        if (r0 == null) goto L5;
        r0.setOnClickListener(null);
    L5:
        View r1 = this.d;
        if (r1 == null) goto L30;
        r1.setOnLongClickListener(null);
    L30:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        com.ss.android.lark.keyboard.keyboard2.b r3 = k().L();     // Catch: Throwable -> L17
        if ((r3 instanceof f) == false) goto L11;
        f r4 = (f) r3;     // Catch: Throwable -> L17
    L12:
        if (r4 == null) goto L14;
        r4.E(this);     // Catch: Throwable -> L17
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Result.constructor-impl(r5);     // Catch: Throwable -> L17
    L19:
        Job r6 = this.j;
        if (r6 == null) goto L22;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L22:
        this.j = null;
        Job r7 = this.k;
        if (r7 == null) goto L25;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L25:
        this.k = null;
        Job r8 = this.l;
        if (r8 == null) goto L28;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L28:
        this.l = null;
        this.g.clear();
        this.h.clear();
        this.i.clear();
        this.d = null;
        this.e = null;
        return;
    L14:
        r5 = null;
        goto L15
    L11:
        r4 = null;
    L17:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.BOTTOM;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerEndVertical;
    }

    @Override // wnb.b
    public final wnb.b.a<SendInnerEndPlugin> getKey() {
        return q;
    }

    public SendInnerEndPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
        this.f = LazyKt.lazy(SendInnerEndPlugin$model$2.INSTANCE);
        this.g = new LinkedHashSet();
        this.h = new LinkedHashSet();
        this.i = new LinkedHashSet();
        this.m = LazyKt.lazy(new SendInnerEndPlugin$attachmentExtension$2(this));
        this.n = LazyKt.lazy(new SendInnerEndPlugin$attachmentEntityListStateFlow$2(this));
        this.o = LazyKt.lazy(SendInnerEndPlugin$resourceUploadInfoMap$2.INSTANCE);
        this.p = new d(this);
    }

    public static final void f(SendInnerEndPlugin r8) {
        Job r0 = r8.l;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        r8.l = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8.a.a), null, null, new SendInnerEndPlugin$clickWrapper$1(r8, null), 3, null);
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final String l(UplinkFileEntity r5) {
        String r2 = null;
        if (wxa.f.d(r5) == false) goto L11;
        int r0 = b1.a;
        Context r1 = this.a.a.requireContext();
        Uri r3 = r5.getUri();
        UplinkEntityContent r6 = r5.getUplinkEntityContent();
        if (r6 == null) goto L9;
        Image r7 = r6.getUplinkImageInfo();
        if (r7 == null) goto L9;
        r2 = r7.localResPath;
    L9:
        Intrinsics.checkNotNullParameter(r1, "context");
        return b1.c(r1, r3, r2);
    L11:
        if (wxa.f.c(r5) == false) goto L19;
        int r4 = b1.a;
        Context r8 = this.a.a.requireContext();
        Uri r9 = r5.getUri();
        UplinkEntityContent r10 = r5.getUplinkEntityContent();
        if (r10 == null) goto L28;
        UplinkFileInfo r11 = r10.getUplinkFileInfo();
        if (r11 == null) goto L28;
        r11.getLocalResPath();
    L28:
        return b1.b(r8, r9);
    L19:
        if (wxa.f.e(r5) == false) goto L29;
        int r12 = b1.a;
        Context r13 = this.a.a.requireContext();
        Uri r14 = r5.getUri();
        UplinkEntityContent r15 = r5.getUplinkEntityContent();
        if (r15 == null) goto L25;
        UplinkFileInfo r16 = r15.getUplinkFileInfo();
        if (r16 == null) goto L25;
        r2 = r16.getLocalResPath();
    L25:
        Intrinsics.checkNotNullParameter(r13, "context");
        return b1.c(r13, r14, r2);
    L29:
        return null;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public static final Object j(SendInnerEndPlugin r16, String r17, String r18, String r19, UplinkFileEntity r20, Continuation r21) {
        r16.getClass();
        if ((r21 instanceof SendInnerEndPlugin$uploadResource$1) == false) goto L7;
        SendInnerEndPlugin$uploadResource$1 r2 = (SendInnerEndPlugin$uploadResource$1) r21;
        int r3 = r2.label;
        if ((r3 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r2.label = r3 - Target.SIZE_ORIGINAL;
    L8:
        SendInnerEndPlugin$uploadResource$1 r10 = r2;
        Object r1 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r10.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L41:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        UplinkFileEntity r5 = (UplinkFileEntity) r10.L$2;
        String r6 = (String) r10.L$1;
        String r7 = (String) r10.L$0;
        ResultKt.throwOnFailure(r1);
        UplinkFileEntity r15 = r5;
        String r14 = r6;
        String r8 = r7;
    L22:
        g r9 = (g) r1;
        UplinkFileEntity r12 = r15;
    L23:
        Log.i("SendInnerEndPlugin", "handleResourceBeforeUpload, handleResult: " + r9);
        if (r9 == null) goto L27;
        String r13 = r9.b;
        if (r13 == null) goto L27;
    L28:
        if (r9 == null) goto L30;
        ResourceFile.FileType r22 = r9.a;
    L32:
        if (TextUtils.isEmpty(r13) == true) goto L39;
        if (r22 == null) goto L39;
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.label = 2;
        if (r16.m(r8, r14, r13, r22, r12, r10) != r11) goto L41;
        return r11;
    L39:
        Log.e("SendInnerEndPlugin", "uploadResource failed, uploadId=" + r14 + ", finalPath=" + r13 + ", fileType=" + r22);
        r16.g.remove(r14);
        r16.h.add(r14);
        r16.i.remove(r14);
        r12.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        r12.setUpLinkProcess(Boxing.boxInt(0));
        return Unit.INSTANCE;
    L30:
        r22 = null;
    L27:
        r13 = "";
        goto L28
    L16:
        ResultKt.throwOnFailure(r1);
        Context r23 = r16.a.a.getContext();
        if (r23 != null) goto L19;
        r8 = r17;
        r14 = r18;
        r12 = r20;
        r9 = null;
        goto L23
    L19:
        FlowSendMessageUtils r24 = FlowSendMessageUtils.a;
        ConcurrentHashMap<String, ResourceUploadInfo> r25 = (ConcurrentHashMap) r16.o.getValue();
        r8 = r17;
        r10.L$0 = r8;
        r14 = r18;
        r10.L$1 = r14;
        r15 = r20;
        r10.L$2 = r15;
        r10.label = 1;
        r1 = r24.b(r23, r18, r19, r20, r25, r10);
        if (r1 != r11) goto L22;
        return r11;
    L7:
        r2 = new SendInnerEndPlugin$uploadResource$1(r16, r21);
        goto L8
    }

    public final Object m(String r5, String r6, String r7, ResourceFile.FileType r8, UplinkFileEntity r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof SendInnerEndPlugin$uploadResourceInner$1) == false) goto L7;
        SendInnerEndPlugin$uploadResourceInner$1 r0 = (SendInnerEndPlugin$uploadResourceInner$1) r10;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (UplinkFileEntity) r0.L$1;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L17:
        com.larksuite.rucket.job.base.b r12 = (com.larksuite.rucket.job.base.b) r11;
        r12.getClass();
        if ((r12 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L21;
        Log.e("SendInnerEndPlugin", "uploadResource failed, uploadId=" + r6 + ", err=" + r12.a());
        this.g.remove(r6);
        this.h.add(r6);
        this.i.remove(r6);
        r9.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        r9.setUpLinkProcess(Boxing.boxInt(0));
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        UploadResourceRequest r13 = new UploadResourceRequest.Builder().chat_id(r5).upload_id(r6).file(new ResourceFile.Builder().file_path(r7).file_type(r8).build()).build();
        KeyboardModel r14 = (KeyboardModel) this.f.getValue();
        com.ss.android.lark.keyboard.viewmodel.a r15 = (com.ss.android.lark.keyboard.viewmodel.a) b38.b.a.create(com.ss.android.lark.keyboard.viewmodel.a.class);
        Intrinsics.checkNotNull(r13);
        RucketJob<UploadResourceResponse> r16 = r15.uploadResource(r13);
        r0.L$0 = r6;
        r0.L$1 = r9;
        r0.label = 1;
        r11 = r16.awaitGet(r0);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new SendInnerEndPlugin$uploadResourceInner$1(this, r10);
        goto L8
    }
}
