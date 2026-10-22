package com.ss.android.lark.chat.service.impl;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.ResourceFile;
import com.bytedance.lark.pb.im.v1.CancelAsyncUploadRequest;
import com.bytedance.lark.pb.im.v1.UploadResourceRequest;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class EditMessageService extends c38.a<m6b.h> {
    public static final CoroutineScope d = null;
    public static final ExecutorCoroutineDispatcher e = null;
    public final m6b.j b;
    public final com.ss.android.lark.im.sdk.service.p c;

    public static final class a {
    }

    static {
        d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        e = ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool());
    }

    @Inject
    public EditMessageService(b38.b r2, m6b.j r3, com.ss.android.lark.im.sdk.service.p r4) {
        Intrinsics.checkNotNullParameter(r2, "rucket");
        Intrinsics.checkNotNullParameter(r3, "configService");
        Intrinsics.checkNotNullParameter(r4, "msgService");
        super(r2);
        this.b = r3;
        this.c = r4;
    }

    public static final Object a(EditMessageService r10, String r11, Map r12, Continuation r13) {
        r10.getClass();
        if ((r13 instanceof EditMessageService$uploadRichTextMediaIfNeed$1) == false) goto L7;
        EditMessageService$uploadRichTextMediaIfNeed$1 r0 = (EditMessageService$uploadRichTextMediaIfNeed$1) r13;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        RichTextElement.MediaProperty r15 = (RichTextElement.MediaProperty) r0.L$2;
        String r16 = (String) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L29:
        String r17 = (String) r14;
        if (r17.length() != 0) goto L32;
        boolean r5 = true;
    L34:
        if (r5 == false) goto L36;
        Log.i("EditMessageService", "uploadRichTextMediaIfNeed: compress failed, cancel current upload task");
        CancelAsyncUploadRequest r18 = new CancelAsyncUploadRequest.Builder().upload_ids(CollectionsKt.listOf(r16)).build();
        m6b.h r19 = (m6b.h) ((c38.a) r10).a.create(m6b.h.class);
        Intrinsics.checkNotNull(r18);
        r19.cancelAsyncUpload(r18);
        return Unit.INSTANCE;
    L36:
        Log.i("EditMessageService", "compress video success, start upload media");
        String r110 = r15.getName();
        if (r110 != null) goto L39;
    L43:
        r110 = new PolarisFileWrapper(r17).getName();
    L44:
        Intrinsics.checkNotNull(r110);
        UploadResourceRequest r111 = new UploadResourceRequest.Builder().chat_id(r4).upload_id(r16).file(new ResourceFile.Builder().file_path(r17).file_type(ResourceFile.FileType.MEDIA).file_name(r110).build()).build();
        m6b.h r112 = (m6b.h) ((c38.a) r10).a.create(m6b.h.class);
        Intrinsics.checkNotNull(r111);
        RucketJob.error$default(r112.uploadResource(r111), null, new EditMessageService$uploadResourceByUploadId$1(null), 1, null);
        return Unit.INSTANCE;
    L39:
        if ((!StringsKt.isBlank(r110)) == true) goto L42;
        r110 = null;
    L42:
        if (r110 != null) goto L44;
    L32:
        r5 = false;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r12.isEmpty() == true) goto L46;
        String r113 = (String) CollectionsKt.firstOrNull(r12.keySet());
        if (r113 == null) goto L47;
        RichTextElement.MediaProperty r114 = (RichTextElement.MediaProperty) r12.get(r113);
        if (r114 == null) goto L48;
        r0.L$0 = r11;
        r0.L$1 = r113;
        r0.L$2 = r114;
        r0.label = 1;
        kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r6.C();
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        com.ss.android.lark.videosend.compress.a r8 = new com.ss.android.lark.videosend.compress.a(UUID.randomUUID().hashCode(), r114.getOriginPath(), new t(r6, r7));
        r7.element = r8;
        int r9 = com.ss.android.lark.videosend.compress.d.d;
        com.ss.android.lark.videosend.compress.d.b.a.c(r8);
        Object r20 = r6.B();
        if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L26:
        if (r20 == r2) goto L50;
        r4 = r11;
        r15 = r114;
        r16 = r113;
        r14 = r20;
        goto L29
    L50:
        return r2;
    L48:
        return Unit.INSTANCE;
    L47:
        return Unit.INSTANCE;
    L46:
        return Unit.INSTANCE;
    L7:
        r0 = new EditMessageService$uploadRichTextMediaIfNeed$1(r10, r13);
        goto L8
    }

    public final void b(String r17, RichText r18, String r19, Chat r20, Context r21, s5c.d r22, List<File> r23) {
        Intrinsics.checkNotNullParameter(r17, "title");
        Intrinsics.checkNotNullParameter(r18, "richText");
        Intrinsics.checkNotNullParameter(r19, "msgId");
        Intrinsics.checkNotNullParameter(r21, "context");
        if (r20 != null) goto L5;
        return;
    L5:
        String r9 = r20.getId();
        if (r9 != null) goto L8;
        return;
    L8:
        WeakReference r2 = new WeakReference(r21);
        BuildersKt.launch$default(d, null, null, new EditMessageService$editMessage$1(r22, r2, r21, r17, r18, r23, this, r19, r9, r20, null), 3, null);
    }
}
