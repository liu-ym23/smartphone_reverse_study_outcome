package com.ss.android.lark.im.sdk.message.resend;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.ResourceFile;
import com.bytedance.lark.pb.im.v1.PreResendMessageRequest;
import com.bytedance.lark.pb.im.v1.ResendMessageRequest;
import com.bytedance.lark.pb.im.v1.UploadResourceRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.capacity_insufficient.CapacityCallback;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a implements jkb.d<h> {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.message.resend.a$a, reason: collision with other inner class name */
    public static final class C0083a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final ResourceFile.FileType d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "UploadInfo(uploadId=" + this.a + ", localPath=" + this.b + ", fileName=" + this.c + ", fileType=" + this.d + ')';
        }

        public b(String r2, String r3, String r4, ResourceFile.FileType r5) {
            Intrinsics.checkNotNullParameter(r2, "uploadId");
            Intrinsics.checkNotNullParameter(r3, "localPath");
            Intrinsics.checkNotNullParameter(r4, "fileName");
            Intrinsics.checkNotNullParameter(r5, "fileType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[Message.Type.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[Message.Type.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[Message.Type.TEXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[Message.Type.POST.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class d<T> implements SdkSender.IParser {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ Object parse(byte[] r1) {
            return "";
        }
    }

    static {
    }

    public a() {
    }

    @Override // jkb.d
    public String getName() {
        return "FinalResendMessageStep";
    }

    public static List f(Message r7) {
        if (g(r7.getType()) == false) goto L5;
        BaseTextContent r8 = r7.getContent();
        if (r8 == null) goto L9;
        List r9 = r8.getAttachments();
    L10:
        if (r9 != null) goto L12;
        r9 = CollectionsKt.emptyList();
    L12:
        ArrayList r1 = new ArrayList();
        Iterator r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L35;
        File r2 = (File) r10.next();
        String r3 = r2.key;
        String r4 = "";
        if (r3 != null) goto L18;
        r3 = "";
    L18:
        boolean r6 = false;
        if (h(r3) == false) goto L30;
        String r5 = r2.path;
        if (r5 == null) goto L25;
        r4 = r5;
    L25:
        if (r4.length() <= 0) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == false) goto L30;
        r6 = true;
        goto L30
    L27:
        r11 = false;
    L30:
        if (r6 == true) goto L33;
        r3 = null;
    L33:
        if (r3 == null) goto L14;
        r1.add(r3);
        goto L14
    L35:
        return r1;
    L9:
        r9 = null;
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }

    public static boolean g(Message.Type r1) {
        if (r1 != Message.Type.TEXT) goto L5;
    L8:
        return true;
    L5:
        if (r1 == Message.Type.POST) goto L8;
        return false;
    }

    public static boolean h(String r2) {
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        return false;
    L14:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        Object r3 = Result.constructor-impl(UUID.fromString(r2));     // Catch: Throwable -> L10
    L13:
        return Result.isSuccess-impl(r3);
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static boolean i(String r3) {
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r3);
        if (r1.exists() == true) goto L11;
    L15:
        return false;
    L11:
        if (r1.isFile() == false) goto L15;
        if (r1.canRead() == false) goto L15;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public static String j(String r1, String r2) {
        if (r1 == null) goto L9;
        if ((!StringsKt.isBlank(r1)) == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L9;
        return r1;
    L9:
        return new PolarisFileWrapper(r2).getName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.ss.android.lark.im.sdk.message.resend.FinalResendMessageStep$process$1] */
    @Override // jkb.d
    public final void a(jkb.b r10, jkb.c r11) {
        h r12 = (h) r10;
        Intrinsics.checkNotNullParameter(r12, "pipelineContext");
        Intrinsics.checkNotNullParameter(r11, "pipelineControl");
        final Context r2 = ImSdk.a.getContext();
        final Message r3 = r12.a;
        final IGetDataCallback<String> r5 = r12.b;
        final Message.b r13 = ImSdkMessageUtils.b(r2, r3);
        LinkedHashSet r14 = new LinkedHashSet();
        Message.Type r0 = r3.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        boolean r4 = false;
        String r6 = null;
        if (r1 != 1) goto L9;
        String r7 = r3.getContent().getFileUploadId();
        if (r7 != null) goto L53;
    L59:
        List r15 = CollectionsKt.toList(r14);
        if (r15.isEmpty() == false) goto L62;
        Log.d("FinalResendMessageStep", "No uploadIds found for message, cId is " + r3.getcId());
        d(r13, r5);
        int r16 = com.ss.android.lark.im.sdk.a.a;
        com.ss.android.lark.im.sdk.a.b(getName(), "Message resend finished for message, cId is " + r3.getcId());
        return;
    L62:
        c(r13, r15, new FinalResendMessageStep$process$1(this, r2, r3, r13, r5));
        return;
    L53:
        if (r7.length() <= 0) goto L55;
        r4 = true;
    L55:
        if (r4 == false) goto L57;
        r6 = r7;
    L57:
        if (r6 == null) goto L59;
        r14.add(r6);
        goto L59
    L9:
        if (r1 != 2) goto L11;
        MediaContent r8 = r3.getContent();
        String r9 = r8.getMediaUploadId();
        if (r9 != null) goto L33;
    L41:
        String r17 = r8.getFirstScreenImageUploadId();
        if (r17 == null) goto L59;
        if (r17.length() <= 0) goto L46;
        r4 = true;
    L46:
        if (r4 == false) goto L48;
        r6 = r17;
    L48:
        if (r6 == null) goto L59;
        r14.add(r6);
        goto L59
    L33:
        if (r9.length() <= 0) goto L35;
        boolean r18 = true;
    L36:
        if (r18 == true) goto L39;
        r9 = null;
    L39:
        if (r9 == null) goto L41;
        r14.add(r9);
        goto L41
    L35:
        r18 = false;
        goto L36
    L11:
        if (r1 != 3) goto L13;
        String r19 = r3.getContent().getImageUploadId();
        if (r19 == null) goto L59;
        if (r19.length() <= 0) goto L26;
        r4 = true;
    L26:
        if (r4 == false) goto L28;
        r6 = r19;
    L28:
        if (r6 == null) goto L59;
        r14.add(r6);
        goto L59
    L13:
        if (r1 != 4) goto L15;
    L17:
        Iterator r20 = f(r3).iterator();
    L19:
        if (r20.hasNext() == false) goto L59;
        r14.add((String) r20.next());
        goto L19
    L15:
        if (r1 == 5) goto L17;
    L5:
        r1 = c.a[r0.ordinal()];
        goto L6
    }

    public void d(Message.b r3, IGetDataCallback<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Log.i("FinalResendMessageStep", "callSdkResendMessage");
        ResendMessageRequest.Builder r5 = new ResendMessageRequest.Builder().cid(r3.a).file_handle(r3.b);
        SdkSender.asynSendRequestNonWrap(Command.RESEND_MESSAGE, r5, new CapacityCallback(r4), d.a);
    }

    public void e(UploadResourceRequest.Builder r3, FinalResendMessageStep$uploadResources$1 r4) {
        Intrinsics.checkNotNullParameter(r3, "requestBuilder");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Log.i("FinalResendMessageStep", "callSdkUploadResource");
        SdkSender.asynSendRequestNonWrap(Command.UPLOAD_RESOURCE, r3, new CapacityCallback(r4), com.ss.android.lark.im.sdk.message.resend.d.a);
    }

    public void c(Message.b r2, List r3, FinalResendMessageStep$process$1 r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "uploadIds");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Log.i("FinalResendMessageStep", "callSdkPreResendMessage");
        PreResendMessageRequest.Builder r5 = new PreResendMessageRequest.Builder().upload_ids(r3);
        SdkSender.asynSendRequestNonWrap(Command.PRE_RESEND_MESSAGE, r5, new CapacityCallback(r4), com.ss.android.lark.im.sdk.message.resend.c.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.ss.android.lark.im.sdk.message.resend.FinalResendMessageStep$uploadResources$1] */
    public static final void b(final a r8, final String r9, final List r10, final int r11, final IGetDataCallback r12) {
        r8.getClass();
        if (r11 < r10.size()) goto L5;
        r12.onSuccess(Boolean.TRUE);
        return;
    L5:
        b r0 = (b) ListProtector.get(r10, r11);
        ResourceFile r1 = new ResourceFile.Builder().file_path(r0.b).file_type(r0.d).file_name(r0.c).build();
        UploadResourceRequest.Builder r2 = new UploadResourceRequest.Builder().chat_id(r9).upload_id(r0.a).file(r1);
        Intrinsics.checkNotNull(r2);
        r8.e(r2, new FinalResendMessageStep$uploadResources$1(r8, r9, r10, r11, r12));
    }
}
