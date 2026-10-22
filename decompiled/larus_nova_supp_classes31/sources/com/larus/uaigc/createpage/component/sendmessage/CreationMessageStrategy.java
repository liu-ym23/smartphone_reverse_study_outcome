package com.larus.uaigc.createpage.component.sendmessage;

import android.content.Context;
import android.net.Uri;
import androidx.collection.LruCache;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.m1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.utils.RegisterHelper;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.im.service.IMessageService;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.api.m3;
import com.larus.platform.creation.CreationMultiReferenceLogEvent;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.helper.CreationImageUploadPolicy;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import tx9.e2;
import tx9.y3;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationMessageStrategy {
    public static final /* synthetic */ int e = 0;
    public final Lazy a;
    public final Lazy b;
    public final ConcurrentHashMap<String, Integer> c;
    public final ConcurrentHashMap<String, String> d;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final ic8.n0 b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            ic8.n0 r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "PreparedUploadPath(uploadPath=" + this.a + ", preprocessResult=" + this.b + ')';
        }

        public b(String r1, ic8.n0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProcessFileResultCode.values().length];
            r0[ProcessFileResultCode.PREPARE_OVER_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements Function1<List<? extends Message>, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<List<Message>> a;

        public d(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r3));
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class e extends TypeToken<com.larus.bmhome.actionbar.model.r> {
        public e() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class f extends TypeToken<m1> {
        public f() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class g extends TypeToken<com.larus.bmhome.actionbar.model.v> {
        public g() {
        }
    }

    static {
    }

    public static Map i() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("loading", "1"), TuplesKt.to("progress", String.valueOf(5))});
    }

    public CreationMessageStrategy() {
        this.a = LazyKt.lazy(new com.larus.uaigc.createpage.component.sendmessage.f());
        this.b = LazyKt.lazy(new com.larus.uaigc.createpage.component.sendmessage.g());
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public static Map g(CreationSendMessageConfig r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = r8.getEnterMethod();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("enter_method_trace", r1);
        String r3 = r8.getPreviousPage();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put("previous_page_trace", r3);
        Map<String, String> r4 = r8.getMessageExtMap();
        if (r4 == null) goto L11;
        r0.putAll(r4);
    L11:
        ILegacyChatUiServiceDelegate r5 = ILegacyChatUiServiceDelegate.b;
        boolean r6 = false;
        r0.putAll(r5.S8(new Pair[0]));
        if (r8.isReEdit() == false) goto L14;
        r0.put("sec_scene", "reedit");
    L14:
        int r7 = od8.h0.a;
        if (od8.h0.e(r8.getActionInstruction()) == false) goto L19;
        Map r9 = r5.B8();
        if (r9 == null) goto L19;
        r0.putAll(r9);
    L19:
        Map<String, String> r10 = r8.getActionBarInstructionMap();
        if (r10 == null) goto L22;
        r0.putAll(r10);
    L22:
        AttachmentInfo r11 = r8.getAttachmentInfo();
        String r12 = null;
        if (r11 == null) goto L25;
        String r13 = r11.getActionBarKey();
    L27:
        if (r13 != null) goto L29;
    L32:
        boolean r14 = true;
    L33:
        if (r14 == true) goto L40;
        AttachmentInfo r15 = r8.getAttachmentInfo();
        if (r15 == null) goto L38;
        String r16 = r15.getActionBarKey();
        if (r16 == null) goto L38;
    L39:
        r0.put("action_bar_key", r16);
    L38:
        r16 = "";
    L40:
        String r17 = r8.getLyricCreateType();
        if (r17 == null) goto L52;
        if (r17.length() <= 0) goto L45;
        boolean r18 = true;
    L46:
        if (r18 == true) goto L49;
        r17 = null;
    L49:
        if (r17 == null) goto L52;
        r0.put("gen_music_create_type", r17);
        goto L52
    L45:
        r18 = false;
    L52:
        if (r8.getAttachmentInfo() == null) goto L67;
        CharSequence r19 = (CharSequence) r0.get("enter_method_trace");
        if (r19 != null) goto L56;
    L57:
        r6 = true;
    L58:
        if (r6 == false) goto L81;
        AttachmentInfo r20 = r8.getAttachmentInfo();
        if (r20 == null) goto L62;
        r12 = r20.getEnterMethod();
    L62:
        if (r12 == null) goto L65;
        r2 = r12;
    L65:
        r0.put("enter_method_trace", r2);
    L81:
        return r0;
    L56:
        if (r19.length() != 0) goto L58;
    L67:
        if (r8.getCustomMultiAttachmentInfo() == null) goto L81;
        CharSequence r21 = (CharSequence) r0.get("enter_method_trace");
        if (r21 != null) goto L71;
    L72:
        r6 = true;
    L73:
        if (r6 == false) goto L81;
        CustomMultiAttachmentInfo r22 = r8.getCustomMultiAttachmentInfo();
        if (r22 == null) goto L77;
        r12 = r22.getEnterMethod();
    L77:
        if (r12 == null) goto L80;
        r2 = r12;
    L80:
        r0.put("enter_method_trace", r2);
        goto L81
    L71:
        if (r21.length() != 0) goto L73;
    L29:
        if (r13.length() == 0) goto L32;
        r14 = false;
        goto L33
    L25:
        r13 = null;
        goto L27
    }

    public static boolean m(String r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(UriProtector.parse(r1).getScheme());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        return Intrinsics.areEqual(r2, "content");
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void n(Message... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Message r2 = r5[r1];
        IChatRepoService r3 = RepoDispatcherDelegate.b.e();
        String r4 = r2.getLocalMessageId();
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r3.t1(r4, 14);
        r1 = r1 + 1;
        goto L3
    }

    public static void o(Message... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Message r2 = r5[r1];
        IChatRepoService r3 = RepoDispatcherDelegate.b.e();
        String r4 = r2.getLocalMessageId();
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r3.t1(r4, 3);
        r1 = r1 + 1;
        goto L3
    }

    public static void p(List r3) {
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        String r0 = (String) r4.next();
        RepoDispatcherDelegate.b.e().t1(r0, 12);
        goto L4
    }

    public static String r(String r4) {
        if (StringsKt.startsWith$default(r4, "file://", false, 2, null) == false) goto L9;
        String r0 = UriProtector.parse(r4).getPath();
        if (r0 != null) goto L8;
        return StringsKt.removePrefix(r4, "file://");
    L8:
        return r0;
    L9:
        return r4;
    }

    public static String v(String r4) {
        String r0 = r(r4);
        boolean r2 = false;
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L11;
        if (new PolarisFileWrapper(r0).exists() == false) goto L11;
        return r0;
    L11:
        if (m(r4) == true) goto L29;
    L28:
        return null;
    L29:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r5 = Result.constructor-impl(vqc.d.d(AppHost.a.getApplication().getApplicationContext(), UriProtector.parse(r4)));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r5) == false) goto L19;
        r5 = null;
    L19:
        String r6 = (String) r5;
        if (r6 != null) goto L22;
    L23:
        r2 = true;
    L24:
        if (r2 == true) goto L28;
        if (new PolarisFileWrapper(r6).exists() == false) goto L28;
        return r6;
    L22:
        if (r6.length() != 0) goto L24;
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L5:
        r1 = false;
        goto L6
    }

    public static String w(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L47;
        ICreationResourceAccessService.Companion r2 = ICreationResourceAccessService.a;
        com.larus.bmhome.resource.access.f0 r3 = r2.c(r5);
        if (r3 == null) goto L16;
        com.larus.bmhome.resource.access.j0 r4 = r3.b;
    L18:
        if ((r4 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L20;
        com.larus.bmhome.resource.access.j0.b r6 = (com.larus.bmhome.resource.access.j0.b) r4;
    L21:
        if (r6 == null) goto L26;
        String r7 = r6.b;
        if (r7 == null) goto L26;
        return r7;
    L26:
        com.larus.bmhome.resource.access.z r8 = ICreationResourceAccessService.a.c(r2, r5, com.larus.uaigc.service.f.a, ResourceMediaType.IMAGE, 8);
        if (r8 == null) goto L29;
        com.larus.bmhome.resource.access.a0 r9 = r8.c;
    L31:
        if ((r9 instanceof com.larus.bmhome.resource.access.a0.e) == false) goto L33;
        com.larus.bmhome.resource.access.a0.e r10 = (com.larus.bmhome.resource.access.a0.e) r9;
    L34:
        if (r10 == null) goto L36;
        com.larus.bmhome.resource.access.j0 r11 = r10.c;
    L38:
        if ((r11 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L40;
        com.larus.bmhome.resource.access.j0.b r12 = (com.larus.bmhome.resource.access.j0.b) r11;
    L41:
        if (r12 != null) goto L43;
        return null;
    L43:
        return r12.b;
    L40:
        r12 = null;
        goto L41
    L36:
        r11 = null;
        goto L38
    L33:
        r10 = null;
        goto L34
    L29:
        r9 = null;
        goto L31
    L20:
        r6 = null;
        goto L21
    L16:
        r4 = null;
        goto L18
    L47:
        return null;
    L7:
        r1 = false;
        goto L8
    }

    public static String x(AttachmentInfo r5) {
        String r0 = r5.getPreviewUrl();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L13:
        Image r2 = r5.getImage();
        if (r2 == null) goto L26;
        ImageObj r3 = r2.previewImage;
        if (r3 == null) goto L26;
        r0 = r3.url;
        if (r0 == null) goto L26;
        if (r0.length() != 0) goto L22;
        boolean r4 = true;
    L24:
        if ((!r4) == false) goto L26;
    L27:
        if (r0 != null) goto L40;
        r0 = r5.getServerUrl();
        if (r0 != null) goto L31;
        return null;
    L31:
        if (Intrinsics.areEqual(r5.getAiCreationImage(), Boolean.TRUE) == true) goto L33;
    L38:
        if (r1 == true) goto L40;
        return null;
    L33:
        if (r0.length() != 0) goto L35;
        boolean r6 = true;
    L36:
        if (r6 == true) goto L38;
        r1 = true;
        goto L38
    L35:
        r6 = false;
    L40:
        return r0;
    L22:
        r4 = false;
    L26:
        r0 = null;
        goto L27
    L5:
        if (r0.length() != 0) goto L7;
        boolean r7 = true;
    L9:
        if ((!r7) == true) goto L12;
        r0 = null;
    L12:
        if (r0 != null) goto L40;
    L7:
        r7 = false;
        goto L9
    }

    public final void j(Message r4) {
        String r5 = r4.getLocalMessageId();
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        if (r5.length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        FLogger.a.e("CreationMessageStrategy", "finishUploadingMessage localMessageId is empty");
        return;
    L13:
        if (Intrinsics.areEqual(this.d.get(r5), "0") == false) goto L20;
        Integer r1 = this.c.get(r5);
        if (r1 == null) goto L20;
        if (r1.intValue() != 100) goto L20;
        return;
    L20:
        this.c.put(r5, 100);
        this.d.put(r5, "0");
        RepoDispatcherDelegate.b.e().r1(r5, new com.larus.uaigc.createpage.component.sendmessage.d());
        return;
    L8:
        r0 = false;
        goto L9
    }

    public static void C(Message r7, final String r8) {
        if (r8 == null) goto L71;
        boolean r1 = true;
        int r2 = 0;
        if (r8.length() <= 0) goto L6;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r8 = null;
    L11:
        if (r8 == null) goto L72;
        String r3 = r7.getLocalMessageId();
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        if (r3.length() != 0) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L22;
        return;
    L22:
        List r5 = com.larus.bmhome.chat.bean.d.g(r7).imageList;
        if (r5 == null) goto L25;
        Image r6 = (Image) CollectionsKt.firstOrNull(r5);
    L26:
        if (r6 == null) goto L40;
        String r9 = r6.localResPath;
        if (r9 == null) goto L40;
        if (r9.length() > 0) goto L33;
        r1 = false;
    L33:
        if (r1 == true) goto L36;
        r9 = null;
    L36:
        if (r9 == null) goto L40;
        if (new PolarisFileWrapper(r(r9)).exists() == false) goto L40;
        return;
    L40:
        if (r6 == null) goto L42;
        String r10 = r6.localResPath;
    L44:
        if (Intrinsics.areEqual(r10, r8) == false) goto L52;
        Map r11 = r7.getBusinessExt();
        if (r11 == null) goto L48;
        String r12 = (String) r11.get("send_image_local_path");
    L50:
        if (Intrinsics.areEqual(r12, r8) == false) goto L52;
        return;
    L48:
        r12 = null;
    L52:
        if (r6 == null) goto L56;
        ImageObj r13 = r6.imageOri;
        if (r13 == null) goto L56;
        int r14 = r13.height;
    L57:
        if (r6 == null) goto L61;
        ImageObj r15 = r6.imageOri;
        if (r15 == null) goto L61;
        r2 = r15.width;
    L61:
        if (r6 == null) goto L63;
        Boolean r16 = r6.aiCreationImage;
    L64:
        if (r6 == null) goto L68;
        ImageObj r17 = r6.previewImage;
        if (r17 == null) goto L68;
        String r18 = r17.url;
    L69:
        final String r19 = com.larus.bmhome.chat.sendimage.e.b(r8, r14, r2, r16, r18);
        com.larus.im.d.e().x(r3, new i(r19), null);
        RepoDispatcherDelegate.b.e().r1(r3, new j(r8));
        return;
    L68:
        r18 = null;
        goto L69
    L63:
        r16 = null;
    L56:
        r14 = 0;
        goto L57
    L42:
        r10 = null;
        goto L44
    L25:
        r6 = null;
        goto L26
    L19:
        r4 = false;
        goto L20
    L72:
        return;
    L6:
        r0 = false;
        goto L8
    }

    public static Map h(CreationSendMessageConfig r5, AttachmentInfo r6) {
        Map<String, String> r0 = r5.getActionBarInstructionMap();
        if (r0 != null) goto L5;
        r0 = MapsKt.emptyMap();
    L5:
        Map r1 = MapsKt.toMutableMap(r0);
        String r2 = r6.getFromScene();
        String r3 = "shoot";
        Boolean r4 = null;
        switch(r2.hashCode()) {
            case -2113586946: goto L19;
            case 92896879: goto L15;
            case 109413407: goto L12;
            case 249793358: goto L9;
            default: goto L53;
        };
    L53:
        r3 = null;
    L21:
        if (r3 == null) goto L23;
        String r7 = (String) r1.put("content_source", r3);
    L23:
        r1.putAll(g(r5));
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L45
        IBachDetectCenterAbility.Companion r9 = IBachDetectCenterAbility.a;     // Catch: Throwable -> L45
        if (r9.b() == true) goto L27;
    L50:
        return r1;
    L27:
        if (r6.isImage() == false) goto L50;
        if (com.larus.utils.o0.d(r6.getServerUrl()) == false) goto L33;
        r4 = r9.c(UriProtector.parse(r6.getServerUrl()), true);     // Catch: Throwable -> L45
    L41:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L43;
        r1.put(IAIChatUgcAIGCService.a.F0(), "1");     // Catch: Throwable -> L45
    L43:
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L50;
        FLogger.a.e("CreationMessageStrategy", "appendBachDetectExt failed", r11);
        goto L50
    L33:
        if (com.larus.utils.o0.d(r6.getFilePath()) == false) goto L41;
        String r12 = r6.getFilePath();     // Catch: Throwable -> L45
        if (r12 != null) goto L37;
        r12 = "";
    L37:
        PolarisFileWrapper r13 = new PolarisFileWrapper(r(r12));     // Catch: Throwable -> L45
        if (r13.exists() == false) goto L41;
        r4 = r9.c(Uri.fromFile(r13), true);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L9:
        if (r2.equals("album_ocr") == false) goto L54;
    L17:
        r3 = "upload";
        goto L21
    L54:
        r3 = null;
        goto L21
    L12:
        if (r2.equals("shoot") == true) goto L21;
        r3 = null;
        goto L21
    L15:
        if (r2.equals("album") == true) goto L17;
        r3 = null;
        goto L21
    L19:
        if (r2.equals("shoot_ocr") == true) goto L21;
        r3 = null;
        goto L21
    }

    public final Object E(String r9, Continuation<? super String> r10) {
        if ((r10 instanceof CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$1) == false) goto L7;
        CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$1 r0 = (CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Ref.ObjectRef r12 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L47:
        return r12.element;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
    L40:
        com.larus.bmhome.resource.access.b0 r13 = (com.larus.bmhome.resource.access.b0) r11;
        if (r13 != null) goto L43;
        return null;
    L43:
        r12 = new Ref.ObjectRef();
        StateFlowImpl r14 = r13.a();
        CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$3 r4 = new CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$3(r12, this, null);
        r0.L$0 = r12;
        r0.label = 2;
        if (kotlinx.coroutines.flow.e.t(r14, r4, r0) != r2) goto L47;
        return r2;
    L16:
        ResultKt.throwOnFailure(r11);
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L19;
        return null;
    L19:
        if (r9 != null) goto L21;
    L48:
        return null;
    L21:
        if (r9.length() <= 0) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == true) goto L27;
        r9 = null;
    L27:
        if (r9 == null) goto L48;
        String r16 = w(r9);
        if (r16 != null) goto L32;
        r16 = "";
    L32:
        String r17 = v(r16);
        if (r17 == null) goto L35;
        return r17;
    L35:
        ICreationResourceAccessService.Companion r18 = ICreationResourceAccessService.a;
        com.larus.bmhome.resource.access.x r5 = com.larus.uaigc.service.f.a;
        ResourceMediaType r6 = ResourceMediaType.IMAGE;
        r13 = ICreationResourceAccessService.a.b(r18, r9, r5, r6, 8);
        if (r13 != null) goto L43;
        CreationResourceAccessUploader r19 = CreationResourceAccessUploader.a;
        r0.label = 1;
        r11 = CreationResourceAccessUploader.d(r9, r5, r6, r0);
        if (r11 != r2) goto L40;
        return r2;
    L23:
        r15 = false;
    L7:
        r0 = new CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$1(this, r10);
        goto L8
    }

    public final Object k(CreationSendMessageConfig r28, Continuation<? super Boolean> r29) {
        if ((r29 instanceof CreationMessageStrategy$handleImageEditWithMask$1) == false) goto L7;
        CreationMessageStrategy$handleImageEditWithMask$1 r1 = (CreationMessageStrategy$handleImageEditWithMask$1) r29;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        String r5 = "";
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ai8.h r6 = (ai8.h) r1.L$5;
        ai8.e r7 = (ai8.e) r1.L$4;
        String r8 = (String) r1.L$3;
        String r9 = (String) r1.L$2;
        ImageEditDataWithMask r10 = (ImageEditDataWithMask) r1.L$1;
        CreationSendMessageConfig r11 = (CreationSendMessageConfig) r1.L$0;
        ResultKt.throwOnFailure(r0);
        CreationSendMessageConfig r12 = r11;
        ImageEditDataWithMask r13 = r10;
    L45:
        List r14 = (List) r0;
        FLogger r15 = FLogger.a;
        r15.i("CreationMessageStrategy", "sendLocalSingleAttachment add image and text message success");
        if (r14.size() == 2) goto L49;
        r15.e("CreationMessageStrategy", "sendLocalSingleAttachment localMessageList size invalid");
        return Boxing.boxBoolean(false);
    L49:
        Message r16 = (Message) CollectionsKt.firstOrNull(r14);
        Message r17 = (Message) CollectionsKt.lastOrNull(r14);
        if (r16 == null) goto L70;
        if (r17 == null) goto L70;
        ConcurrentHashMap r18 = ko8.b.a;
        ko8.b.b(r12.getCreationSendTraceId(), CollectionsKt.listOf(new String[]{r16.getLocalMessageId(), r17.getLocalMessageId()}));
        IConversationRepoService r19 = RepoDispatcherDelegate.b.f();
        String r20 = r16.getConversationId();
        if (r20 != null) goto L56;
        String r110 = "";
    L57:
        IConversationRepoService.a.f(r19, r110, false, false, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG, 4);
        u(r16, 5);
        String r21 = r16.getLocalMessageId();
        if (r21 == null) goto L62;
        r5 = r21;
    L62:
        if (r5.length() != 0) goto L64;
        boolean r22 = true;
    L65:
        if (r22 == false) goto L67;
        String r23 = UUID.randomUUID().toString();
    L68:
        tx9.l0.d(r23);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new CreationMessageStrategy$handleImageEditWithMask$2(r13, r8, r23, this, r16, r12, r17, null), 2, null);
        return Boxing.boxBoolean(true);
    L67:
        r23 = r5;
        goto L68
    L64:
        r22 = false;
        goto L65
    L56:
        r110 = r20;
    L70:
        r15.e("CreationMessageStrategy", "sendLocalSingleAttachment imageMsg or textMsg is null");
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        FLogger r24 = FLogger.a;
        r24.i("CreationMessageStrategy", "handleImageEditWithMask");
        ImageEditDataWithMask r25 = r28.getImageEditDataWithMask();
        if (r25 == null) goto L73;
        if (r25.getSendMsgImgStoragePath() == null) goto L73;
        String r26 = r28.getCvsId();
        if (r26 != null) goto L22;
    L25:
        boolean r27 = true;
    L26:
        if (r27 == false) goto L29;
        r24.e("CreationMessageStrategy", "sendLocalSingleAttachment cvsId is empty");
        return Boxing.boxBoolean(false);
    L29:
        String r30 = r25.getSendMsgImgStoragePath();
        if (r30 != null) goto L32;
        r30 = "";
    L32:
        Map<String, String> r31 = r28.getActionBarInstructionMap();
        if (r31 != null) goto L35;
        r31 = MapsKt.emptyMap();
    L35:
        ai8.e r111 = new ai8.e(r30, null, null, null, null, null, null, null, r31, i(), false, r28.getChatPageContext(), null, null, 27134);
        String r112 = r28.getContent();
        if (r112 != null) goto L38;
        String r113 = "";
    L39:
        ai8.h r114 = new ai8.h(r113, null, null, null, r31, MapsKt.mapOf(TuplesKt.to("is_mock_text", "1")), false, false, r28.getChatPageContext(), null, 718);
        r12 = r28;
        r1.L$0 = r12;
        r1.L$1 = r25;
        r1.L$2 = r26;
        r1.L$3 = r30;
        r1.L$4 = r111;
        r1.L$5 = r114;
        r1.label = 1;
        kotlinx.coroutines.j r115 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r1), 1);
        r115.C();
        RepoDispatcherDelegate.b.e().u1().j(r26, r111, r114, new d(r115));
        Object r32 = r115.B();
        if (r32 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L42;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L42:
        if (r32 != r3) goto L44;
        return r3;
    L44:
        r8 = r30;
        r13 = r25;
        r0 = r32;
        goto L45
    L38:
        r113 = r112;
        goto L39
    L22:
        if (r26.length() == 0) goto L25;
        r27 = false;
    L73:
        return Boxing.boxBoolean(false);
    L7:
        r1 = new CreationMessageStrategy$handleImageEditWithMask$1(this, r29);
        goto L8
    }

    public final void u(Message r4, int r5) {
        String r6 = r4.getLocalMessageId();
        if (r6 != null) goto L6;
        r6 = "";
    L6:
        if (r6.length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        FLogger.a.e("CreationMessageStrategy", "refreshUploadingMessage localMessageId is empty");
        return;
    L13:
        if (Intrinsics.areEqual(this.d.get(r6), "0") == false) goto L20;
        Integer r1 = this.c.get(r6);
        if (r1 == null) goto L20;
        if (r1.intValue() != 100) goto L20;
        return;
    L20:
        final int r7 = RangesKt.coerceIn(r5, 5, 99);
        Integer r2 = this.c.get(r6);
        if (Intrinsics.areEqual(this.d.get(r6), "1") == false) goto L26;
        if (r2 == null) goto L26;
        if (r2.intValue() < r7) goto L26;
        return;
    L26:
        Integer r3 = Integer.valueOf(r7);
        this.c.put(r6, r3);
        this.d.put(r6, "1");
        RepoDispatcherDelegate.b.e().r1(r6, new h(r7));
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final Object y(CreationSendMessageConfig r51, Continuation<? super Boolean> r52) {
        if ((r52 instanceof CreationMessageStrategy$send$1) == false) goto L7;
        CreationMessageStrategy$send$1 r2 = (CreationMessageStrategy$send$1) r52;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        ResultKt.throwOnFailure(r1);
    L327:
        boolean r6 = ((Boolean) r1).booleanValue();
    L365:
        if (r6 == false) goto L368;
        IAIChatControlTraceService.a.fb();
    L368:
        return Boxing.boxBoolean(r6);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r1);
    L321:
        r6 = ((Boolean) r1).booleanValue();
        goto L365
    L17:
        ResultKt.throwOnFailure(r1);
    L300:
        r6 = ((Boolean) r1).booleanValue();
        goto L365
    L18:
        ResultKt.throwOnFailure(r1);
        String r7 = r51.getScene();
        if (r7 != null) goto L21;
    L24:
        boolean r8 = true;
    L25:
        if (r8 == false) goto L27;
        CreationSendMessageConfig r9 = CreationSendMessageConfig.copy$default(r51, null, null, null, null, "keyboard", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217711, null);
    L28:
        Map<String, String> r10 = r9.getSendTrackExtMap();
        if (r10 != null) goto L31;
        r10 = MapsKt.emptyMap();
    L31:
        Map<String, String> r11 = MapsKt.toMutableMap(r10);
        String r12 = r11.get("current_page");
        if (r12 != null) goto L34;
    L37:
        boolean r13 = true;
    L38:
        if (r13 == false) goto L40;
        r11.put("current_page", "chat");
    L40:
        IAIChatUgcAIGCService.Companion r14 = IAIChatUgcAIGCService.a;
        String r15 = r9.getCvsId();
        String r38 = "";
        if (r15 != null) goto L43;
        r15 = "";
    L43:
        r14.c(r15, r11);
        if (com.larus.utils.o0.d(r9.getActionBarCreationId()) == true) goto L46;
    L57:
        Integer r16 = r9.getActionInstruction();
        if (r16 == null) goto L90;
        if (r16.intValue() != 1) goto L90;
        boolean r17 = !r9.getLocalIntercepted();
        String r18 = r9.getLocalInterceptInfo();
        String r19 = r9.getPreviousPage();
        if (r19 != null) goto L65;
        String r110 = "";
    L66:
        String r111 = r9.getBotId();
        if (r111 != null) goto L69;
        String r21 = "";
    L70:
        wc9.e r112 = r9.getConversation();
        if (r112 == null) goto L73;
        String r113 = ic8.n.f(r112);
    L74:
        if (r113 != null) goto L76;
        String r22 = "";
    L77:
        String r114 = r9.getLyricCreateType();
        if (r114 != null) goto L80;
        String r23 = "";
    L81:
        if (r17 == false) goto L83;
        String r115 = "1";
    L84:
        String r25 = r115;
        if (r17 == false) goto L87;
        String r26 = "";
    L88:
        String r116 = r9.getEnterMethod();
        LruCache r20 = ko8.a.a;
        e2.a.b(new kr8.e("chat", r110, r116, IAIChatControlTraceService.a.nb(), r21, r22, r23, "1", r25, r26, null, 4225), null, 3);
        goto L90
    L87:
        r26 = r18;
        goto L88
    L83:
        r115 = "0";
        goto L84
    L80:
        r23 = r114;
        goto L81
    L76:
        r22 = r113;
        goto L77
    L73:
        r113 = null;
        goto L74
    L69:
        r21 = r111;
        goto L70
    L65:
        r110 = r19;
    L90:
        if (r9.getLocalIntercepted() == false) goto L94;
        IAIChatControlTraceService.a.fb();
        return Boxing.boxBoolean(true);
    L94:
        if (r9.getCustomMultiAttachmentInfo() == null) goto L301;
        r2.label = 1;
        FLogger r24 = FLogger.a;
        r24.i("CreationMessageStrategy", "handleMultiAttachment");
        CustomMultiAttachmentInfo r27 = r9.getCustomMultiAttachmentInfo();
        if (r27 == null) goto L98;
        NestedFileContent r28 = r27.getNestedFileContent();
    L99:
        if (r28 != null) goto L101;
        r24.e("CreationMessageStrategy", "handleMultiAttachment nestedFileContent is null");
        r1 = Boxing.boxBoolean(false);
    L298:
        if (r1 != r4) goto L300;
        return r4;
    L101:
        final CreationMultiAttachmentProcessor r29 = (CreationMultiAttachmentProcessor) this.a.getValue();
        final CreationSendMessageConfig r30 = CreationSendMessageConfig.copy$default(r9, null, null, null, null, null, null, null, null, null, g(r9), null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217215, null);
        r29.getClass();
        Intrinsics.checkNotNullParameter(r30, "config");
        CustomMultiAttachmentInfo r31 = r30.getCustomMultiAttachmentInfo();
        if (r31 == null) goto L104;
        NestedFileContent r117 = r31.getNestedFileContent();
    L106:
        if (r31 == null) goto L296;
        if (r117 == null) goto L296;
        Integer r32 = r30.getActionInstruction();
        if (r32 != null) goto L113;
    L114:
        CustomMultiAttachmentInfo r53 = r31;
    L201:
        if (r53.isSkipUpload() == false) goto L203;
    L295:
        r29.l(r30, null, null);
    L297:
        r1 = Boxing.boxBoolean(true);
        goto L298
    L203:
        if (CreationMultiAttachmentProcessor.i(r117) == true) goto L295;
        final CustomMultiAttachmentInfo r210 = r30.getCustomMultiAttachmentInfo();
        if (r210 == null) goto L208;
        NestedFileContent r41 = r210.getNestedFileContent();
    L209:
        if (r210 == null) goto L294;
        if (r41 == null) goto L294;
        if (CreationMultiAttachmentProcessor.i(r41) == false) goto L215;
        r29.l(r30, null, null);
        goto L297
    L215:
        final long r118 = System.currentTimeMillis();
        com.larus.uaigc.helper.f.a.getClass();
        boolean r33 = com.larus.uaigc.helper.f.a();
        List r34 = r41.getEntities();
        if (r34 == null) goto L253;
        Iterator r35 = r34.iterator();
    L219:
        if (r35.hasNext() == false) goto L253;
        UplinkFileEntity r36 = (UplinkFileEntity) r35.next();
        if (r33 == false) goto L230;
        String r119 = r36.getFileIdentifier();
        if (r119 == null) goto L230;
        if (r119.length() <= 0) goto L227;
        boolean r37 = true;
    L228:
        if (r37 == false) goto L230;
    L231:
        if (r119 != null) goto L233;
        r119 = UUID.randomUUID().toString();
    L233:
        r36.setFileIdentifier(r119);
        if (r33 == false) goto L248;
        UplinkEntityContent r39 = r36.getUplinkEntityContent();
        if (r39 == null) goto L240;
        Image r40 = r39.getUplinkImageInfo();
        if (r40 == null) goto L240;
        String r42 = r40.identifier;
    L241:
        if (r42 != null) goto L243;
    L246:
        boolean r43 = true;
    L247:
        if (r43 == false) goto L219;
    L243:
        if (r42.length() == 0) goto L246;
        r43 = false;
    L240:
        r42 = null;
    L248:
        UplinkEntityContent r44 = r36.getUplinkEntityContent();
        if (r44 == null) goto L219;
        Image r45 = r44.getUplinkImageInfo();
        if (r45 == null) goto L219;
        r45.identifier = r119;
        goto L219
    L227:
        r37 = false;
    L230:
        r119 = null;
    L253:
        wc9.e r46 = r30.getConversation();
        if (r46 != null) goto L256;
        FLogger.a.e("CreationMultiAttachmentProcessor", "uploadBeforeSendNestedFiles conversation is null");
        goto L297
    L256:
        List r47 = r41.getEntities();
        if (r47 != null) goto L259;
        r47 = CollectionsKt.emptyList();
    L259:
        ArrayList r48 = new ArrayList();
        Iterator r49 = r47.iterator();
    L261:
        if (r49.hasNext() == false) goto L271;
        Object r50 = r49.next();
        Integer r54 = ((UplinkFileEntity) r50).getUpLinkStatus();
        int r55 = UpLinkState.PROCESSING.getValue();
        if (r54 != null) goto L266;
    L268:
        boolean r56 = false;
    L269:
        if (r56 == false) goto L261;
        r48.add(r50);
        goto L261
    L266:
        if (r54.intValue() != r55) goto L268;
        r56 = true;
        goto L269
    L271:
        final ArrayList r57 = new ArrayList();
        Iterator r58 = r48.iterator();
    L273:
        if (r58.hasNext() == false) goto L285;
        String r120 = ((UplinkFileEntity) r58.next()).getFileIdentifier();
        if (r120 != null) goto L277;
    L282:
        r120 = null;
    L283:
        if (r120 == null) goto L273;
        r57.add(r120);
        goto L273
    L277:
        if (r120.length() <= 0) goto L279;
        boolean r59 = true;
    L280:
        if (r59 == false) goto L282;
    L279:
        r59 = false;
        goto L280
    L285:
        Iterator r60 = r57.iterator();
    L287:
        if (r60.hasNext() == false) goto L289;
        String r61 = (String) r60.next();
        Set<String> r62 = CreationMultiAttachmentProcessor.b;
        CreationMultiAttachmentProcessor.a.a(r61);
        goto L287
    L289:
        String r63 = r46.a;
        ((com.larus.uaigc.createpage.component.sendmessage.a) r29.a.getValue()).getClass();
        com.larus.uaigc.createpage.component.sendmessage.a.a(r63, "prepare_creation_multi_attachment");
        int r64 = wf9.b.a;
        String r410 = com.flow.kmp.common.util.i.a();
        final Map r411 = CreationMultiAttachmentProcessor.h(r30);
        u1 r310 = RepoDispatcherDelegate.b.e().getSender();
        String r65 = r30.getContent();
        if (r65 != null) goto L292;
        String r412 = "";
    L293:
        final NestedFileContent r121 = r41;
        u1.a.b(r310, r412, r41, r410, r46, r63, r411, null, r30.getChatPageContext(), new r(r57, r121, r118, r29, r30, r210, r411), 192);
        goto L297
    L292:
        r412 = r65;
    L294:
        FLogger.a.e("CreationMultiAttachmentProcessor", "uploadBeforeSendNestedFiles missing multi attachment");
        goto L297
    L208:
        r41 = null;
        goto L209
    L113:
        if (r32.intValue() != 28) goto L114;
        List r66 = r117.getEntities();
        if (r66 != null) goto L118;
        r66 = CollectionsKt.emptyList();
    L118:
        List r122 = r66;
        boolean r123 = r122 instanceof Collection;
        if (r123 == true) goto L121;
    L123:
        Iterator r124 = r122.iterator();
        int r125 = 0;
    L125:
        if (r124.hasNext() == false) goto L131;
        if (n1.d((UplinkFileEntity) r124.next()) == false) goto L125;
        r125 = r125 + 1;
        if (r125 >= 0) goto L125;
        CollectionsKt.throwCountOverflow();
        goto L125
    L131:
        int r126 = r125;
    L132:
        if (r123 == true) goto L134;
    L136:
        Iterator r127 = r122.iterator();
        int r128 = 0;
    L138:
        if (r127.hasNext() == false) goto L144;
        if (n1.e((UplinkFileEntity) r127.next()) == false) goto L138;
        r128 = r128 + 1;
        if (r128 >= 0) goto L138;
        CollectionsKt.throwCountOverflow();
        goto L138
    L144:
        int r129 = r128;
    L145:
        if (r123 == true) goto L147;
    L149:
        Iterator r130 = r122.iterator();
        int r131 = 0;
    L151:
        if (r130.hasNext() == false) goto L157;
        if (n1.a((UplinkFileEntity) r130.next()) == false) goto L151;
        r131 = r131 + 1;
        if (r131 >= 0) goto L151;
        CollectionsKt.throwCountOverflow();
        goto L151
    L157:
        int r132 = r131;
    L158:
        Set<String> r133 = cq9.b.a;
        CreationMultiReferenceLogEvent r134 = CreationMultiReferenceLogEvent.UPLINK_BUILT;
        Boolean r135 = Boolean.TRUE;
        int r211 = RangesKt.coerceAtLeast(((r66.size() - r126) - r129) - r132, 0);
        List r136 = r66;
        ArrayList r67 = new ArrayList();
        Iterator r137 = r136.iterator();
    L160:
        if (r137.hasNext() == false) goto L165;
        Object r68 = r137.next();
        if (n1.e((UplinkFileEntity) r68) == false) goto L160;
        r67.add(r68);
        goto L160
    L165:
        Iterator r69 = r67.iterator();
        double r212 = 0.0d;
    L167:
        if (r69.hasNext() == false) goto L179;
        UplinkEntityContent r70 = ((UplinkFileEntity) r69.next()).getUplinkEntityContent();
        if (r70 == null) goto L177;
        UplinkFileInfo r71 = r70.getUplinkFileInfo();
        if (r71 == null) goto L177;
        VideoExtension r72 = r71.getVideo();
        if (r72 == null) goto L177;
        Float r73 = r72.getDuration();
        if (r73 == null) goto L177;
        double r74 = r73.floatValue();
    L178:
        r212 = r212 + r74;
        r31 = r31;
    L177:
        r74 = 0.0d;
        goto L178
    L179:
        r53 = r31;
        ArrayList r75 = new ArrayList();
        Iterator r76 = r136.iterator();
    L181:
        if (r76.hasNext() == false) goto L185;
        Object r77 = r76.next();
        if (n1.a((UplinkFileEntity) r77) == false) goto L181;
        r75.add(r77);
        goto L181
    L185:
        Iterator r78 = r75.iterator();
        double r79 = 0.0d;
    L187:
        if (r78.hasNext() == false) goto L199;
        UplinkEntityContent r80 = ((UplinkFileEntity) r78.next()).getUplinkEntityContent();
        if (r80 == null) goto L197;
        UplinkFileInfo r81 = r80.getUplinkFileInfo();
        if (r81 == null) goto L197;
        VideoExtension r82 = r81.getVideo();
        if (r82 == null) goto L197;
        Float r83 = r82.getDuration();
        if (r83 == null) goto L197;
        double r84 = r83.floatValue();
    L198:
        r79 = r79 + r84;
        r78 = r78;
    L197:
        r84 = 0.0d;
        goto L198
    L199:
        cq9.a r85 = new cq9.a(r126, r129, r132, r211, r212, r79, Integer.valueOf(r66.size()));
        r30.getCreationSendTraceId();
        cq9.b.a(r134, r135, "video_creation", "nested_file", r85, null, null, null, 464);
        goto L201
    L147:
        if (r122.isEmpty() == false) goto L149;
        r132 = 0;
        goto L158
    L134:
        if (r122.isEmpty() == false) goto L136;
        r129 = 0;
        goto L145
    L121:
        if (r122.isEmpty() == false) goto L123;
        r126 = 0;
    L296:
        r24.e("CreationMultiAttachmentProcessor", "send customMultiAttachment or nestedFileContent is null");
        goto L297
    L104:
        r117 = null;
        goto L106
    L98:
        r28 = null;
        goto L99
    L301:
        boolean r86 = true;
        if (r9.getAttachmentInfo() == null) goto L323;
        r2.label = 2;
        AttachmentInfo r87 = r9.getAttachmentInfo();
        if (r87 != null) goto L307;
        r1 = Boxing.boxBoolean(false);
    L319:
        if (r1 != r4) goto L321;
        return r4;
    L307:
        if (com.larus.utils.o0.d(r87.getTosKey()) == false) goto L310;
        boolean r88 = B(r9, r87, null, null);
    L318:
        r1 = Boxing.boxBoolean(r88);
        goto L319
    L310:
        if (com.larus.utils.o0.d(r87.getFilePath()) == true) goto L312;
    L317:
        FLogger.a.e("CreationMessageStrategy", "handleSingleAttachment missing attachment source");
        r88 = false;
        goto L318
    L312:
        if (r87.getTosKey().length() == 0) goto L315;
        r86 = false;
    L315:
        if (r86 == false) goto L317;
        r1 = z(r9, r87, r2);
        goto L319
    L323:
        if (r9.getImageEditDataWithMask() == null) goto L328;
        r2.label = 3;
        r1 = k(r9, r2);
        if (r1 != r4) goto L327;
        return r4;
    L328:
        FLogger r89 = FLogger.a;
        r89.i("CreationMessageStrategy", "handleText");
        String r90 = r9.getContent();
        if (r90 != null) goto L331;
        r90 = "";
    L331:
        String r91 = r9.getTxtScene();
        if (r91 != null) goto L336;
        r91 = r9.getScene();
        if (r91 != null) goto L336;
    L337:
        String r138 = r38;
        Map r139 = g(r9);
        String r140 = r9.getCvsId();
        if (r140 != null) goto L340;
    L343:
        boolean r92 = true;
    L344:
        if (r92 == false) goto L346;
        r89.e("CreationMessageStrategy", "handleText conversationId is empty");
        boolean r93 = false;
    L364:
        r6 = r93;
        goto L365
    L346:
        com.larus.uaigc.createpage.component.sendmessage.a r94 = (com.larus.uaigc.createpage.component.sendmessage.a) this.b.getValue();
        String r213 = r9.getCreationSendTraceId();
        ChatPageContext r214 = r9.getChatPageContext();
        int r95 = com.larus.uaigc.createpage.component.sendmessage.a.a;
        r94.getClass();
        Intrinsics.checkNotNullParameter(r90, "content");
        Intrinsics.checkNotNullParameter(r138, "scene");
        if (r140 != null) goto L349;
    L352:
        boolean r96 = true;
    L354:
        if (r96 == false) goto L356;
        r89.e("CreationMessageSender", "[sendText] conversationId is empty");
    L363:
        r93 = true;
        goto L364
    L356:
        z2 r97 = z2.a;
        m3 r98 = z2.d4();
        if (r98 == null) goto L359;
        boolean r99 = r98.messageVoicePlay();
    L360:
        if (r99 == true) goto L362;
        t19.s.j(t19.s.a, AppHost.a.getApplication(), "WIP", null, false, 28);
        goto L363
    L362:
        r89.i("CreationMessageSender", "[sendText] scene:" + r138 + ", isAutoInterrupt:true");
        String r100 = UUID.randomUUID().toString();
        r14.d(r100);
        com.larus.uaigc.createpage.component.sendmessage.a.b(r140, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
        u1.a.f(RepoDispatcherDelegate.b.e().u1(), StringsKt.trim(r90).toString(), r140, r138, r139, null, null, r100, false, null, "CreationMessageSender#sendText", r213, r214, null, false, 24872);
        goto L363
    L359:
        r99 = true;
        goto L360
    L349:
        if (StringsKt.isBlank(r140) == true) goto L352;
        r96 = false;
        goto L354
    L340:
        if (r140.length() == 0) goto L343;
        r92 = false;
    L336:
        r38 = r91;
        goto L337
    L46:
        if (com.larus.utils.o0.d(r9.getActionBarCreationType()) == false) goto L57;
        String r101 = r9.getCvsId();
        if (r101 != null) goto L50;
        r101 = "";
    L50:
        String r141 = r9.getActionBarCreationId();
        if (r141 != null) goto L53;
        r141 = "";
    L53:
        String r142 = r9.getActionBarCreationType();
        if (r142 != null) goto L56;
        r142 = "";
    L56:
        r14.S(r101, r141, r142);
        goto L57
    L34:
        if (r12.length() == 0) goto L37;
        r13 = false;
        goto L38
    L27:
        r9 = r51;
        goto L28
    L21:
        if (r7.length() == 0) goto L24;
        r8 = false;
    L7:
        r2 = new CreationMessageStrategy$send$1(this, r52);
        goto L8
    }

    public static final Object b(CreationMessageStrategy r22, String r23, Continuation r24) {
        r22.getClass();
        kotlinx.coroutines.j r1 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r24), 1);
        r1.C();
        StringBuilder r2 = new StringBuilder();
        r2.append(UUID.randomUUID());
        r2.append('_');
        r2.append(System.currentTimeMillis());
        String r7 = r2.toString();
        AtomicBoolean r3 = new AtomicBoolean(false);
        r1.i(new n(r3, r7));
        FLogger.a.i("CreationMessageStrategy", "start submitLocalImageResourceAccess, curUploaderIdentifier:" + r7);
        ICreationResourceAccessService.Companion r4 = ICreationResourceAccessService.a;
        int r5 = com.larus.uaigc.service.p0.x;
        r4.b(com.larus.uaigc.service.p0.a.c(r23, r7, null, null, true, new CountDownLatch(1), null, null, null, null, new o(r7, r3, r1, r22), new p(r7, r3, r1, r22), null, com.larus.uaigc.service.g.a, null, 1822520));
        Object r0 = r1.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r24);
    L5:
        return r0;
    }

    public final Object t(CreationSendMessageConfig r7, String r8, Continuation<? super b> r9) {
        if ((r9 instanceof CreationMessageStrategy$prepareUploadPath$1) == false) goto L7;
        CreationMessageStrategy$prepareUploadPath$1 r0 = (CreationMessageStrategy$prepareUploadPath$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L22:
        ic8.n0 r11 = (ic8.n0) r10;
        ProcessFileResultCode r12 = r11.b;
        boolean r5 = false;
        if (r12 != null) goto L25;
    L27:
        boolean r13 = false;
    L28:
        if (r13 == false) goto L55;
        ic8.m0 r14 = r11.a;
        if (r14 == null) goto L32;
        String r15 = r14.e;
    L33:
        IBachDetectCenterAbility.Companion r6 = IBachDetectCenterAbility.a;
        if (r6.b() == false) goto L50;
        if (r15 != null) goto L37;
    L38:
        r5 = true;
    L39:
        if (r5 == true) goto L50;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L48
        PolarisFileWrapper r17 = new PolarisFileWrapper(r8);     // Catch: Throwable -> L48
        PolarisFileWrapper r18 = new PolarisFileWrapper(r15);     // Catch: Throwable -> L48
        if (r17.exists() == true) goto L44;
    L46:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L48
        goto L50
    L44:
        if (r18.exists() == false) goto L46;
        r6.e(Uri.fromFile(r17), Uri.fromFile(r18), true);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L37:
        if (r15.length() != 0) goto L39;
    L50:
        ic8.m0 r20 = r11.a;
        if (r20 == null) goto L53;
        r4 = r20.e;
    L53:
        if (r4 != null) goto L57;
        r4 = "";
    L57:
        return new b(r4, r11);
    L32:
        r15 = null;
        goto L33
    L55:
        FLogger.a.i("CreationMessageStrategy", "prepareUploadPath: compress failed");
        goto L57
    L25:
        if (r12.isSuccess() != true) goto L27;
        r13 = true;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (Intrinsics.areEqual(r7.getHasImagePreprocessed(), Boxing.boxBoolean(true)) == true) goto L58;
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L58;
        CreationImageUploadPolicy r21 = CreationImageUploadPolicy.a;
        Uri r22 = Uri.fromFile(new PolarisFileWrapper(r8));
        r0.L$0 = r8;
        r0.label = 1;
        r10 = r21.a(r22, "ai_beautify", null, r0);
        if (r10 != r2) goto L22;
        return r2;
    L58:
        FLogger.a.i("CreationMessageStrategy", "skip prepareUploadPath, uploadPath = " + r8);
        return new b(r8, null);
    L7:
        r0 = new CreationMessageStrategy$prepareUploadPath$1(this, r9);
        goto L8
    }

    public final Object z(CreationSendMessageConfig r34, AttachmentInfo r35, Continuation<? super Boolean> r36) {
        if ((r36 instanceof CreationMessageStrategy$sendLocalSingleAttachment$1) == false) goto L7;
        CreationMessageStrategy$sendLocalSingleAttachment$1 r2 = (CreationMessageStrategy$sendLocalSingleAttachment$1) r36;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        int r6 = 0;
        Boolean r10 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        String r0 = (String) r2.L$5;
        Map<String, String> r7 = (Map) r2.L$4;
        String r8 = (String) r2.L$3;
        String r11 = (String) r2.L$2;
        AttachmentInfo r12 = (AttachmentInfo) r2.L$1;
        final CreationSendMessageConfig r9 = (CreationSendMessageConfig) r2.L$0;
        ResultKt.throwOnFailure(r1);
        String r29 = r0;
        String r31 = r11;
        AttachmentInfo r32 = r12;
    L72:
        String r13 = (String) r1;
        if (r13 != null) goto L75;
    L78:
        boolean r14 = true;
    L79:
        if (r14 == false) goto L90;
        if (r29 != null) goto L82;
    L85:
        boolean r15 = true;
    L86:
        if (r15 == false) goto L90;
        FLogger.a.e("CreationMessageStrategy", "sendLocalSingleAttachment displayable local path is empty");
        return Boxing.boxBoolean(false);
    L82:
        if (r29.length() == 0) goto L85;
        r15 = false;
    L90:
        if (r13 != null) goto L92;
        String r16 = "";
    L94:
        if (r32 == null) goto L98;
        Integer r17 = r32.getHeight();
        if (r17 == null) goto L98;
        int r18 = r17.intValue();
    L99:
        Integer r19 = Boxing.boxInt(r18);
        if (r32 == null) goto L104;
        Integer r20 = r32.getWidth();
        if (r20 == null) goto L104;
        r6 = r20.intValue();
    L104:
        Integer r110 = Boxing.boxInt(r6);
        if (r32 == null) goto L107;
        String r22 = r32.getLocalMessageId();
    L108:
        Map r25 = i();
        ChatPageContext r27 = r9.getChatPageContext();
        if (r32 == null) goto L111;
        r10 = r32.getAiCreationImage();
    L111:
        ai8.e r21 = new ai8.e(r16, null, r19, r110, null, null, r22, null, r7, r25, false, r27, r10, r29, 2418);
        String r23 = r9.getContent();
        if (r23 != null) goto L114;
        String r111 = "";
    L115:
        ai8.h r112 = new ai8.h(r111, null, null, null, r7, MapsKt.mapOf(TuplesKt.to("is_mock_text", "1")), false, false, r9.getChatPageContext(), null, 718);
        final String r24 = r8;
        String r113 = r8;
        final String r26 = r31;
        final AttachmentInfo r28 = r32;
        RepoDispatcherDelegate.b.e().u1().j(r113, r21, r112, new com.larus.uaigc.createpage.component.sendmessage.e(this, r9, r24, r26, r28));
        return Boxing.boxBoolean(true);
    L114:
        r111 = r23;
        goto L115
    L107:
        r22 = null;
    L98:
        r18 = 0;
        goto L99
    L92:
        r16 = r13;
        goto L94
    L75:
        if (r13.length() == 0) goto L78;
        r14 = false;
        goto L79
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (r35 == null) goto L24;
        String r30 = r35.getFilePath();
        if (r30 == null) goto L24;
        if (r30.length() <= 0) goto L21;
        boolean r33 = true;
    L22:
        if (r33 == false) goto L24;
    L25:
        if (r30 != null) goto L27;
    L30:
        boolean r37 = true;
    L31:
        if (r37 == false) goto L34;
        FLogger.a.e("CreationMessageStrategy", "sendLocalSingleAttachment localPath is empty");
        return Boxing.boxBoolean(false);
    L34:
        r8 = r34.getCvsId();
        if (r8 != null) goto L37;
    L40:
        boolean r114 = true;
    L41:
        if (r114 == false) goto L44;
        FLogger.a.e("CreationMessageStrategy", "sendLocalSingleAttachment cvsId is empty");
        return Boxing.boxBoolean(false);
    L44:
        Map<String, String> r115 = r34.getActionBarInstructionMap();
        if (r115 != null) goto L47;
        r115 = MapsKt.emptyMap();
    L47:
        if (r35 == null) goto L49;
        String r116 = x(r35);
    L50:
        r2.L$0 = r34;
        r2.L$1 = r35;
        r2.L$2 = r30;
        r2.L$3 = r8;
        r2.L$4 = r115;
        r2.L$5 = r116;
        r2.label = 1;
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L53;
        Object r117 = r30;
    L63:
        if (r117 != null) goto L69;
        if (r35 == null) goto L67;
        String r118 = r35.getFileIdentifier();
    L68:
        r117 = E(r118, r2);
        goto L69
    L67:
        r118 = null;
    L69:
        if (r117 != r4) goto L71;
        return r4;
    L71:
        r32 = r35;
        r31 = r30;
        r7 = r115;
        r29 = r116;
        r9 = r34;
        r1 = r117;
        goto L72
    L53:
        if (r35 == null) goto L55;
        String r119 = r35.getFileIdentifier();
    L56:
        String r120 = w(r119);
        if (r120 != null) goto L59;
        r120 = "";
    L59:
        r117 = v(r120);
        if (r117 != null) goto L63;
        r117 = v(r30);
        goto L63
    L55:
        r119 = null;
        goto L56
    L49:
        r116 = null;
        goto L50
    L37:
        if (r8.length() == 0) goto L40;
        r114 = false;
        goto L41
    L27:
        if (r30.length() == 0) goto L30;
        r37 = false;
        goto L31
    L21:
        r33 = false;
    L24:
        r30 = null;
    L7:
        r2 = new CreationMessageStrategy$sendLocalSingleAttachment$1(this, r36);
        goto L8
    }

    public static final void c(AtomicBoolean r2, String r3, kotlinx.coroutines.i r4, mr9.l r5) {
        if (r2.compareAndSet(false, true) == true) goto L6;
        FLogger.a.w("CreationMessageStrategy", "submitLocalImageResourceAccess ignore duplicate callback, curUploaderIdentifier:" + r3);
        return;
    L6:
        if (r4.isActive() == true) goto L16;
        FLogger.a.w("CreationMessageStrategy", "submitLocalImageResourceAccess continuation inactive, curUploaderIdentifier:" + r3);
        return;
    L16:
        r4.resumeWith(Result.constructor-impl(r5));     // Catch: Throwable -> L10
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L20;
        FLogger.a.e("CreationMessageStrategy", "submitLocalImageResourceAccess resume failed, curUploaderIdentifier:" + r3, r7);
        return;
    L20:
        return;
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static final void e(boolean r3, CreationMessageStrategy r4, Message r5, mr9.k r6) {
        FLogger.a.i("CreationMessageStrategy", "uploading, process=" + r6.a + ", pending=" + r6.b);
        if (r3 == false) goto L5;
        int r7 = com.larus.uaigc.createpage.utils.a.a;
        int r8 = com.larus.uaigc.createpage.utils.a.b(r6.a);
    L10:
        r4.u(r5, r8);
        return;
    L5:
        Long r9 = r6.a;
        if (r9 == null) goto L8;
        long r0 = r9.longValue();
    L9:
        r8 = Math.max(5, (int) r0);
        goto L10
    L8:
        r0 = 5;
        goto L9
    }

    public static void q(CreationSendMessageConfig r54, AttachmentInfo r55, String r56, com.larus.bmhome.resource.access.f0 r57) {
        String r6 = null;
        if (r55 == null) goto L5;
        String r2 = r55.getFileIdentifier();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        Integer r4 = mr9.i.a(r56);
        if (r57 == null) goto L15;
        Map r5 = r57.f;
        if (r5 == null) goto L15;
        String r7 = (String) r5.get("preprocess_file_size");
        if (r7 == null) goto L15;
        Long r8 = StringsKt.toLongOrNull(r7);
    L16:
        if (r57 == null) goto L20;
        Map r0 = r57.f;
        if (r0 == null) goto L20;
        String r9 = (String) r0.get("preprocess_file_type");
    L21:
        tx9.l0.a("creation_page_album_image_to_message", r2, false, r4, r8, r9);
        ny9.u r1 = r54.getHitPointData();
        if (r1 == null) goto L24;
        String r16 = r1.getClickFrom();
    L25:
        if (r1 == null) goto L27;
        String r18 = r1.m();
    L28:
        if (r1 == null) goto L30;
        String r19 = r1.i();
    L31:
        if (r1 == null) goto L33;
        String r3 = r1.getEnterMethod();
    L34:
        String r22 = r3;
        String r10 = r54.getBotId();
        if (r10 != null) goto L39;
        if (r1 == null) goto L38;
        r6 = r1.getBotId();
    L38:
        String r11 = r6;
    L40:
        IAIChatControlTraceService.Companion r12 = IAIChatControlTraceService.a;
        y3.a(r11, "chat", null, "upload", "pic", null, "0", null, null, r16, null, r18, r19, null, null, r22, null, r12.h(r12.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        return;
    L39:
        r11 = r10;
        goto L40
    L33:
        r3 = r54.getEnterMethod();
        goto L34
    L30:
        r19 = null;
        goto L31
    L27:
        r18 = null;
        goto L28
    L24:
        r16 = null;
    L20:
        r9 = null;
    L15:
        r8 = null;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    public final boolean B(CreationSendMessageConfig r25, AttachmentInfo r26, String r27, String r28) {
        ArrayList r7 = new ArrayList();
        if (r27 != null) goto L7;
        String r0 = r26.getLocalMessageId();
        if (r0 != null) goto L8;
        int r1 = wf9.b.a;
        r0 = com.flow.kmp.common.util.i.a();
    L8:
        ConcurrentHashMap r2 = ko8.b.a;
        ko8.b.a(r25.getCreationSendTraceId(), r0);
        int r3 = RegisterHelper.a;
        String r9 = r25.getBotId();
        String r10 = r25.getCvsId();
        String r11 = r26.getTosKey();
        String r12 = r26.getFileIdentifier();
        ResourceUploadInstantInfo r13 = r26.getInstantUploadInfo();
        Image r14 = r26.getImage();
        wc9.e r4 = r25.getConversation();
        if (r4 == null) goto L11;
        String r5 = r4.B;
    L12:
        String r8 = r0;
        RegisterHelper.c(r8, r9, r10, r11, r12, r13, r14, r5, 16);
        String r15 = r26.getFilePath();
        String r16 = r26.getTosKey();
        Integer r6 = r26.getHeight();
        if (r6 == null) goto L15;
        int r17 = r6.intValue();
    L16:
        Integer r18 = Integer.valueOf(r17);
        Integer r19 = r26.getWidth();
        if (r19 == null) goto L19;
        int r20 = r19.intValue();
    L20:
        String r110 = r0;
        r7.add(new ai8.e(r15, r16, r18, Integer.valueOf(r20), r26.getResourceId(), r26.getServerUrl(), r110, null, h(r25, r26), null, false, r25.getChatPageContext(), r26.getAiCreationImage(), x(r26), 3392));
        String r21 = r25.getContent();
        if (r21 != null) goto L23;
        String r22 = "";
    L25:
        if (r22.length() <= 0) goto L27;
        boolean r23 = true;
    L28:
        if (r23 == false) goto L34;
        if (r28 != null) goto L31;
        int r24 = wf9.b.a;
        String r111 = com.flow.kmp.common.util.i.a();
    L32:
        ko8.b.a(r25.getCreationSendTraceId(), r111);
        r7.add(new ai8.h(r22, r111, null, null, h(r25, r26), null, false, false, r25.getChatPageContext(), null, 748));
        goto L34
    L31:
        r111 = r28;
    L34:
        if (r7.isEmpty() == false) goto L37;
        FLogger.a.e("CreationMessageStrategy", "sendUploadedSingleAttachment strategyList is empty");
        return false;
    L37:
        wc9.e r29 = r25.getConversation();
        if (r29 != null) goto L47;
        FLogger.a.e("CreationMessageStrategy", "sendUploadedSingleAttachment conversation is null");
        ArrayList r30 = new ArrayList();
        Iterator r31 = r7.iterator();
    L41:
        if (r31.hasNext() == false) goto L45;
        String r32 = ((ic8.w) r31.next()).b();
        if (r32 == null) goto L41;
        r30.add(r32);
        goto L41
    L45:
        p(r30);
        return false;
    L47:
        FLogger r33 = FLogger.a;
        r33.i("CreationMessageStrategy", "sendUploadedSingleAttachment start send message");
        com.larus.uaigc.createpage.component.sendmessage.a r34 = (com.larus.uaigc.createpage.component.sendmessage.a) this.b.getValue();
        String r35 = r25.getTxtScene();
        if (r35 != null) goto L52;
        r35 = r25.getScene();
        if (r35 != null) goto L52;
        r35 = "";
    L52:
        String r36 = r35;
        boolean r37 = com.larus.uaigc.createpage.component.sendmessage.a.c(r34, r29, r36, r7, r26.getFromScene(), "creation_send_single_attachment", 32);
        if (r37 == true) goto L61;
        r33.e("CreationMessageStrategy", "sendUploadedSingleAttachment send failed");
        ArrayList r38 = new ArrayList();
        Iterator r39 = r7.iterator();
    L56:
        if (r39.hasNext() == false) goto L60;
        String r40 = ((ic8.w) r39.next()).b();
        if (r40 == null) goto L56;
        r38.add(r40);
        goto L56
    L60:
        p(r38);
    L61:
        return r37;
    L27:
        r23 = false;
        goto L28
    L23:
        r22 = r21;
        goto L25
    L19:
        r20 = 0;
        goto L20
    L15:
        r17 = 0;
        goto L16
    L11:
        r5 = null;
        goto L12
    L7:
        r0 = r27;
        goto L8
    }

    public final void A(CreationSendMessageConfig r73, String r74, AttachmentInfo r75, Message r76, Message r77, mr9.l r78) {
        FLogger.a.i("CreationMessageStrategy", "sendUploadedLocalImage, toskey: " + r78.a);
        String r2 = r78.a;
        if (r2 != null) goto L5;
        return;
    L5:
        mr9.d r0 = r78.d;
        String r24 = null;
        if (r0 == null) goto L8;
        Integer r7 = Integer.valueOf(r0.a);
    L9:
        mr9.d r1 = r78.d;
        if (r1 == null) goto L12;
        Integer r8 = Integer.valueOf(r1.b);
    L14:
        if (r75 == null) goto L17;
        String r3 = r75.getFromScene();
        if (r3 == null) goto L17;
    L20:
        String r11 = r3;
    L21:
        String r4 = r78.c;
        if (r4 != null) goto L26;
        if (r75 == null) goto L25;
        r4 = r75.getResourceId();
        goto L26
    L25:
        String r12 = null;
    L27:
        if (r75 == null) goto L29;
        String r13 = r75.getFileIdentifier();
    L31:
        if (r75 == null) goto L33;
        String r16 = r75.getServerUrl();
    L34:
        if (r75 == null) goto L36;
        String r17 = r75.getPreviewUrl();
    L37:
        ResourceUploadInstantInfo r5 = r78.g;
        if (r5 != null) goto L42;
        if (r75 == null) goto L41;
        r5 = r75.getInstantUploadInfo();
        goto L42
    L41:
        ResourceUploadInstantInfo r18 = null;
    L43:
        if (r75 == null) goto L45;
        Image r19 = r75.getImage();
    L46:
        if (r75 == null) goto L48;
        String r20 = r75.getLocalMessageId();
    L49:
        if (r75 == null) goto L51;
        Boolean r21 = r75.getAiCreationImage();
    L52:
        AttachmentInfo r6 = new AttachmentInfo(true, r2, r7, r8, r74, null, r11, r12, r13, null, null, r16, r17, r18, r19, r20, r21, 1536, null);
        zd9.h r9 = zd9.h.a;
        Map<String, String> r10 = r73.getActionBarInstructionMap();
        String r15 = "action_bar_instruction";
        if (r10 == null) goto L55;
        String r14 = r10.get("action_bar_instruction");
    L56:
        boolean r110 = false;
        if (r14 != null) goto L59;
    L62:
        boolean r22 = true;
    L64:
        if (r22 == false) goto L286;
    L75:
        Object r23 = null;
    L76:
        com.larus.bmhome.actionbar.model.r r111 = (com.larus.bmhome.actionbar.model.r) r23;
        if (r111 == null) goto L84;
        Integer r25 = r111.a;
        if (r25 == null) goto L84;
        if (r25.intValue() != 28) goto L84;
        boolean r26 = true;
    L85:
        long r27 = 0;
        if (r26 == false) goto L177;
        com.larus.bmhome.actionbar.model.y r28 = r111.i;
        if (r28 == null) goto L175;
        ArrayList r29 = r28.a;
        if (r29 == null) goto L175;
        z0 r30 = (z0) CollectionsKt.firstOrNull(r29);
        if (r30 == null) goto L175;
        com.larus.bmhome.actionbar.model.r r31 = r30.q;
        if (r31 == null) goto L101;
        Integer r32 = r31.a;
        if (r32 == null) goto L101;
        if (r32.intValue() != 4) goto L101;
        boolean r33 = true;
    L102:
        if (r33 == false) goto L173;
        com.larus.bmhome.actionbar.model.r r34 = r30.q;
        if (r34 == null) goto L173;
        List r35 = r34.b;
        if (r35 == null) goto L173;
        Iterator r36 = r35.iterator();
    L109:
        if (r36.hasNext() == false) goto L119;
        Object r112 = r36.next();
        Integer r113 = ((com.larus.bmhome.actionbar.model.u) r112).b;
        if (r113 != null) goto L114;
    L116:
        boolean r114 = false;
    L117:
        if (r114 == false) goto L109;
    L120:
        com.larus.bmhome.actionbar.model.u r115 = (com.larus.bmhome.actionbar.model.u) r112;
        if (r115 == null) goto L173;
        zd9.h r210 = zd9.h.a;
        com.larus.bmhome.actionbar.model.r r37 = r30.q;
        if (r37 == null) goto L142;
        List r38 = r37.b;
        if (r38 == null) goto L142;
        Iterator r39 = r38.iterator();
    L128:
        if (r39.hasNext() == false) goto L138;
        Object r40 = r39.next();
        Integer r116 = ((com.larus.bmhome.actionbar.model.u) r40).b;
        if (r116 != null) goto L133;
    L135:
        boolean r117 = false;
    L136:
        if (r117 == false) goto L128;
    L139:
        com.larus.bmhome.actionbar.model.u r41 = (com.larus.bmhome.actionbar.model.u) r40;
        if (r41 == null) goto L142;
        String r42 = r41.d;
    L143:
        if (r42 != null) goto L145;
    L148:
        boolean r43 = true;
    L149:
        if (r43 == false) goto L288;
    L160:
        Object r44 = null;
    L161:
        com.larus.bmhome.actionbar.model.v r45 = (com.larus.bmhome.actionbar.model.v) r44;
        if (r45 == null) goto L171;
        mr9.d r46 = r78.d;
        if (r46 == null) goto L166;
        long r47 = r46.b;
    L167:
        Long r48 = Long.valueOf(r47);
        mr9.d r49 = r78.d;
        if (r49 == null) goto L170;
        r27 = r49.a;
    L170:
        r45.c = CollectionsKt.mutableListOf(new MediaAttachment[]{new MediaAttachment(null, r2, new ImageUploadInfo(r48, Long.valueOf(r27)), null, null, null, null, null, null, null, null, r6.getAiCreationImage(), 2041, null)});
    L172:
        r210.getClass();
        r115.d = zd9.h.c(r45);
        Unit r50 = Unit.INSTANCE;
    L174:
        Unit r51 = Unit.INSTANCE;
    L176:
        com.larus.bmhome.actionbar.model.r r118 = r111;
    L244:
        if (r118 == null) goto L253;
        Map<String, String> r52 = r73.getActionBarInstructionMap();
        if (r52 != null) goto L248;
        r52 = MapsKt.emptyMap();
    L248:
        Map r53 = MapsKt.toMutableMap(r52);
        zd9.h.a.getClass();
        String r54 = zd9.h.c(r118);
        if (r54 != null) goto L251;
        r54 = "";
    L251:
        r53.put(r15, r54);
        Unit r55 = Unit.INSTANCE;
        CreationSendMessageConfig r56 = CreationSendMessageConfig.copy$default(r73, null, null, null, null, null, null, null, null, null, r53, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217215, null);
        if (r56 == null) goto L253;
    L254:
        B(r56, r6, r76.getLocalMessageId(), r77.getLocalMessageId());
        ny9.u r57 = r73.getHitPointData();
        if (r57 == null) goto L257;
        String r310 = r57.getClickFrom();
    L258:
        ny9.u r58 = r73.getHitPointData();
        if (r58 == null) goto L261;
        String r311 = r58.m();
    L262:
        ny9.u r59 = r73.getHitPointData();
        if (r59 == null) goto L265;
        String r312 = r59.i();
    L266:
        ny9.u r60 = r73.getHitPointData();
        if (r60 == null) goto L269;
        String r410 = r60.getEnterMethod();
    L270:
        String r61 = r73.getBotId();
        if (r61 != null) goto L276;
        ny9.u r62 = r73.getHitPointData();
        if (r62 == null) goto L275;
        r61 = r62.getBotId();
        goto L276
    L275:
        String r211 = null;
    L278:
        if (StringsKt.isBlank(r2) == false) goto L280;
        String r63 = "0";
    L281:
        String r313 = r63;
        if (StringsKt.isBlank(r2) == false) goto L284;
        r24 = "upload";
    L284:
        IAIChatControlTraceService.Companion r64 = IAIChatControlTraceService.a;
        y3.a(r211, "chat", null, r24, "pic", null, r313, null, null, r310, null, r311, r312, null, null, r410, null, r64.h(r64.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        return;
    L280:
        r63 = "1";
    L276:
        r211 = r61;
        goto L278
    L269:
        r410 = null;
        goto L270
    L265:
        r312 = null;
        goto L266
    L261:
        r311 = null;
        goto L262
    L257:
        r310 = null;
    L253:
        r56 = r73;
        goto L254
    L166:
        r47 = 0;
        goto L167
    L171:
        r45 = null;
        goto L172
    L288:
        Result.Companion r65 = Result.Companion;     // Catch: Throwable -> L153
        r210.getClass();     // Catch: Throwable -> L153
        r44 = Result.constructor-impl(zd9.h.b.fromJson(r42, new g().getType()));     // Catch: Throwable -> L153
    L155:
        Throwable r66 = Result.exceptionOrNull-impl(r44);
        if (r66 == null) goto L159;
        com.larus.im.internal.delegate.c0 r119 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r120 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r66, "<this>");
        r120.append(ExceptionsKt.stackTraceToString(r66));
        r119.e("GsonHolder", r120.toString());
    L159:
        if (Result.isFailure-impl(r44) == false) goto L161;
    L153:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L155
    L145:
        if (StringsKt.isBlank(r42) == true) goto L148;
        r43 = false;
        goto L149
    L133:
        if (r116.intValue() != 15) goto L135;
        r117 = true;
        goto L136
    L138:
        r40 = null;
    L142:
        r42 = null;
        goto L143
    L114:
        if (r113.intValue() != 15) goto L116;
        r114 = true;
        goto L117
    L119:
        r112 = null;
    L173:
        r111 = r111;
        r15 = "action_bar_instruction";
    L101:
        r33 = false;
    L175:
        r111 = r111;
        r15 = "action_bar_instruction";
        goto L176
    L177:
        r15 = "action_bar_instruction";
        r118 = r111;
        if (r118 == null) goto L243;
        List r68 = r118.b;
        if (r68 == null) goto L243;
        Iterator r69 = r68.iterator();
    L183:
        if (r69.hasNext() == false) goto L193;
        Object r121 = r69.next();
        Integer r122 = ((com.larus.bmhome.actionbar.model.u) r121).b;
        if (r122 != null) goto L188;
    L190:
        boolean r123 = false;
    L191:
        if (r123 == false) goto L183;
    L194:
        com.larus.bmhome.actionbar.model.u r124 = (com.larus.bmhome.actionbar.model.u) r121;
        if (r124 == null) goto L243;
        zd9.h r212 = zd9.h.a;
        List r70 = r118.b;
        if (r70 == null) goto L214;
        Iterator r71 = r70.iterator();
    L200:
        if (r71.hasNext() == false) goto L210;
        Object r125 = r71.next();
        Integer r126 = ((com.larus.bmhome.actionbar.model.u) r125).b;
        if (r126 != null) goto L205;
    L207:
        boolean r127 = false;
    L208:
        if (r127 == false) goto L200;
    L211:
        com.larus.bmhome.actionbar.model.u r128 = (com.larus.bmhome.actionbar.model.u) r125;
        if (r128 == null) goto L214;
        String r72 = r128.d;
    L215:
        if (r72 != null) goto L217;
    L218:
        r110 = true;
    L219:
        if (r110 == false) goto L290;
    L230:
        Object r79 = null;
    L231:
        m1 r80 = (m1) r79;
        if (r80 == null) goto L241;
        mr9.d r81 = r78.d;
        if (r81 == null) goto L236;
        long r82 = r81.b;
    L237:
        Long r83 = Long.valueOf(r82);
        mr9.d r84 = r78.d;
        if (r84 == null) goto L240;
        r27 = r84.a;
    L240:
        r80.d = new MediaAttachment(null, r2, new ImageUploadInfo(r83, Long.valueOf(r27)), null, null, null, null, null, null, null, null, r6.getAiCreationImage(), 2041, null);
    L242:
        r212.getClass();
        r124.d = zd9.h.c(r80);
        Unit r85 = Unit.INSTANCE;
        goto L244
    L236:
        r82 = 0;
        goto L237
    L241:
        r80 = null;
        goto L242
    L290:
        Result.Companion r86 = Result.Companion;     // Catch: Throwable -> L223
        r212.getClass();     // Catch: Throwable -> L223
        r79 = Result.constructor-impl(zd9.h.b.fromJson(r72, new f().getType()));     // Catch: Throwable -> L223
    L225:
        Throwable r87 = Result.exceptionOrNull-impl(r79);
        if (r87 == null) goto L229;
        com.larus.im.internal.delegate.c0 r129 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r130 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r87, "<this>");
        r130.append(ExceptionsKt.stackTraceToString(r87));
        r129.e("GsonHolder", r130.toString());
    L229:
        if (Result.isFailure-impl(r79) == false) goto L231;
    L223:
        th = move-exception;
        Result.Companion r88 = Result.Companion;
        r79 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L225
    L217:
        if (StringsKt.isBlank(r72) == false) goto L219;
    L205:
        if (r126.intValue() != 14) goto L207;
        r127 = true;
        goto L208
    L210:
        r125 = null;
    L214:
        r72 = null;
        goto L215
    L188:
        if (r122.intValue() != 14) goto L190;
        r123 = true;
        goto L191
    L193:
        r121 = null;
    L243:
        r118 = r118;
    L84:
        r26 = false;
        goto L85
    L286:
        Result.Companion r89 = Result.Companion;     // Catch: Throwable -> L68
        r9.getClass();     // Catch: Throwable -> L68
        r23 = Result.constructor-impl(zd9.h.b.fromJson(r14, new e().getType()));     // Catch: Throwable -> L68
    L70:
        Throwable r90 = Result.exceptionOrNull-impl(r23);
        if (r90 == null) goto L74;
        com.larus.im.internal.delegate.c0 r91 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r92 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r90, "<this>");
        r92.append(ExceptionsKt.stackTraceToString(r90));
        r91.e("GsonHolder", r92.toString());
    L74:
        if (Result.isFailure-impl(r23) == false) goto L76;
    L68:
        th = move-exception;
        Result.Companion r93 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L70
    L59:
        if (StringsKt.isBlank(r14) == true) goto L62;
        r22 = false;
        goto L64
    L55:
        r14 = null;
        goto L56
    L51:
        r21 = null;
        goto L52
    L48:
        r20 = null;
        goto L49
    L45:
        r19 = null;
    L42:
        r18 = r5;
        goto L43
    L36:
        r17 = null;
        goto L37
    L33:
        r16 = null;
        goto L34
    L29:
        r13 = null;
    L26:
        r12 = r4;
    L17:
        r3 = r73.getScene();
        if (r3 != null) goto L20;
        r11 = "";
        goto L21
    L12:
        r8 = null;
        goto L14
    L8:
        r7 = null;
        goto L9
    }

    public final void l(CreationSendMessageConfig r20, String r21, AttachmentInfo r22, Message r23, Message r24, com.larus.bmhome.resource.access.f0 r25) {
        mr9.l r0 = r25.e;
        if (r0 != null) goto L5;
        r0 = new mr9.l(r25.c, null, r25.d, null, null, false, null, 122);
    L5:
        mr9.l r6 = r0;
        String r1 = r6.a;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        Long r10 = null;
        String r11 = null;
        if (r2 == false) goto L19;
        FLogger.a.e("CreationMessageStrategy", "handleReadyResourceAccessArtifact tosKey is empty");
        j(r23);
        o(new Message[]{r23, r24});
        CreationResourceAccessUploader r3 = CreationResourceAccessUploader.a;
        if (r22 == null) goto L17;
        r11 = r22.getFileIdentifier();
    L17:
        CreationResourceAccessUploader.g(r11);
        q(r20, r22, "empty_upload_result", r25);
        return;
    L19:
        com.larus.bmhome.resource.access.j0.b r4 = r25.b;
        if ((r4 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L22;
        com.larus.bmhome.resource.access.j0.b r5 = r4;
    L23:
        if (r5 == null) goto L26;
        String r7 = r5.b;
        if (r7 == null) goto L26;
    L27:
        String r8 = r7;
        C(r23, r8);
        CreationResourceAccessUploader r9 = CreationResourceAccessUploader.a;
        if (r22 == null) goto L30;
        String r12 = r22.getFileIdentifier();
    L31:
        CreationResourceAccessUploader.g(r12);
        j(r23);
        A(r20, r8, r22, r23, r24, r6);
        if (r22 == null) goto L34;
        String r13 = r22.getFileIdentifier();
    L35:
        if (r13 != null) goto L37;
        r13 = "";
    L37:
        String r14 = r13;
        String r15 = (String) r25.f.get("preprocess_file_size");
        if (r15 == null) goto L40;
        r10 = StringsKt.toLongOrNull(r15);
    L40:
        tx9.l0.b("creation_page_album_image_to_message", r14, true, null, r10, (String) r25.f.get("preprocess_file_type"), 8);
        return;
    L34:
        r13 = null;
        goto L35
    L30:
        r12 = null;
    L26:
        r7 = r(r21);
        goto L27
    L22:
        r5 = null;
        goto L23
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public static final Object a(CreationMessageStrategy r23, CreationSendMessageConfig r24, String r25, String r26, AttachmentInfo r27, List r28, Continuation r29) {
        r23.getClass();
        if ((r29 instanceof CreationMessageStrategy$handleLocalSingleAttachmentPrepared$1) == false) goto L7;
        CreationMessageStrategy$handleLocalSingleAttachmentPrepared$1 r1 = (CreationMessageStrategy$handleLocalSingleAttachmentPrepared$1) r29;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CreationMessageStrategy$handleLocalSingleAttachmentPrepared$1 r9 = r1;
        Object r0 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r9.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L41:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Message r4 = (Message) r9.L$5;
        Message r5 = (Message) r9.L$4;
        AttachmentInfo r6 = (AttachmentInfo) r9.L$3;
        String r7 = (String) r9.L$2;
        String r8 = (String) r9.L$1;
        CreationSendMessageConfig r11 = (CreationSendMessageConfig) r9.L$0;
        ResultKt.throwOnFailure(r0);
        Message r12 = r4;
        CreationSendMessageConfig r13 = r11;
        Message r14 = r5;
        String r15 = r8;
        AttachmentInfo r16 = r6;
        String r17 = r7;
    L31:
        if (((Boolean) r0).booleanValue() == true) goto L40;
        r9.L$0 = null;
        r9.L$1 = null;
        r9.L$2 = null;
        r9.L$3 = null;
        r9.L$4 = null;
        r9.L$5 = null;
        r9.label = 2;
        if (r23.D(r13, r15, r17, r16, r14, r12, r9) != r10) goto L41;
        return r10;
    L40:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r0);
        FLogger r18 = FLogger.a;
        r18.i("CreationMessageStrategy", "sendLocalSingleAttachment add image and text message success");
        if (r28.size() == 2) goto L19;
        r18.e("CreationMessageStrategy", "sendLocalSingleAttachment localMessageList size invalid");
        return Unit.INSTANCE;
    L19:
        Message r19 = (Message) CollectionsKt.firstOrNull(r28);
        Message r110 = (Message) CollectionsKt.lastOrNull(r28);
        if (r19 == null) goto L37;
        if (r110 == null) goto L37;
        ConcurrentHashMap r20 = ko8.b.a;
        ko8.b.b(r24.getCreationSendTraceId(), CollectionsKt.listOf(new String[]{r19.getLocalMessageId(), r110.getLocalMessageId()}));
        IConversationRepoService r111 = RepoDispatcherDelegate.b.f();
        String r21 = r19.getConversationId();
        if (r21 != null) goto L26;
        r21 = "";
    L26:
        IConversationRepoService.a.f(r111, r21, false, false, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG, 4);
        r23.u(r19, 5);
        r9.L$0 = r24;
        r9.L$1 = r25;
        r9.L$2 = r26;
        r9.L$3 = r27;
        r9.L$4 = r19;
        r9.L$5 = r110;
        r9.label = 1;
        r0 = r23.s(r24, r25, r26, r27, r19, r110, r9);
        if (r0 == r10) goto L42;
        r17 = r26;
        r16 = r27;
        r14 = r19;
        r12 = r110;
        r13 = r24;
        r15 = r25;
        goto L31
    L42:
        return r10;
    L37:
        r18.e("CreationMessageStrategy", "sendLocalSingleAttachment imageMsg or textMsg is null");
        return Unit.INSTANCE;
    L7:
        r1 = new CreationMessageStrategy$handleLocalSingleAttachmentPrepared$1(r23, r29);
        goto L8
    }

    public final Object D(CreationSendMessageConfig r68, String r69, String r70, AttachmentInfo r71, Message r72, Message r73, Continuation<? super Unit> r74) {
        String r1 = r70;
        if ((r74 instanceof CreationMessageStrategy$uploadLocalImageAfterAddMsg$1) == false) goto L7;
        CreationMessageStrategy$uploadLocalImageAfterAddMsg$1 r3 = (CreationMessageStrategy$uploadLocalImageAfterAddMsg$1) r74;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        Message r0 = (Message) r3.L$5;
        Message r7 = (Message) r3.L$4;
        AttachmentInfo r8 = (AttachmentInfo) r3.L$3;
        String r9 = (String) r3.L$2;
        String r10 = (String) r3.L$1;
        CreationSendMessageConfig r11 = (CreationSendMessageConfig) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Message r13 = r0;
        Message r12 = r7;
        CreationSendMessageConfig r19 = r11;
        r1 = r9;
        String r14 = r10;
        AttachmentInfo r15 = r8;
    L18:
        b r16 = (b) r2;
        String r17 = r16.a;
        boolean r18 = false;
        if (r17 != null) goto L21;
    L24:
        boolean r20 = true;
    L25:
        String r21 = null;
        if (r20 == false) goto L68;
        ic8.n0 r22 = r16.b;
        FLogger r23 = FLogger.a;
        StringBuilder r24 = new StringBuilder("uploadLocalImageAfterAddMsg uploadPath is empty, preprocessResultCode: ");
        if (r22 == null) goto L30;
        ProcessFileResultCode r25 = r22.b;
    L31:
        r24.append(r25);
        r23.e("CreationMessageStrategy", r24.toString());
        IMessageService.a.a(com.larus.im.d.e(), r14, CollectionsKt.listOf(new Message[]{r12, r13}), false, false, false, null, 48);
        if (r22 == null) goto L34;
        ProcessFileResultCode r26 = r22.b;
    L35:
        if (r26 != null) goto L37;
        int r27 = -1;
    L38:
        if (r27 == 1) goto L42;
        if (r27 == 2) goto L41;
        t19.s r28 = t19.s.a;
        Context r29 = AppHost.a.getApplication().getApplicationContext();
        r28.getClass();
        t19.s.s(r29, 2131908214);
    L43:
        r23.e("CreationMessageStrategy", "sendLocalSingleAttachment, unsupported_format");
        com.larus.platform.service.g r30 = com.larus.platform.service.g.a;
        StringBuilder r31 = new StringBuilder("sendLocalSingleAttachment, resultCode: ");
        if (r22 == null) goto L46;
        ProcessFileResultCode r32 = r22.b;
    L47:
        r31.append(r32);
        r31.append(", inputFilePath: ");
        r31.append(r1);
        r30.ensureNotReachHere(new Throwable(r31.toString()));
        ny9.u r33 = r19.getHitPointData();
        if (r33 == null) goto L50;
        String r210 = r33.getClickFrom();
    L51:
        if (r33 == null) goto L53;
        String r34 = r33.m();
    L54:
        if (r33 == null) goto L56;
        String r35 = r33.i();
    L57:
        if (r33 == null) goto L59;
        String r36 = r33.getEnterMethod();
    L60:
        String r37 = r36;
        String r38 = r19.getBotId();
        if (r38 != null) goto L65;
        if (r33 == null) goto L64;
        r21 = r33.getBotId();
    L64:
        String r211 = r21;
    L66:
        IAIChatControlTraceService.Companion r39 = IAIChatControlTraceService.a;
        y3.a(r211, "chat", null, "upload", "pic", null, "0", null, null, r210, null, r34, r35, null, null, r37, null, r39.h(r39.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        return Unit.INSTANCE;
    L65:
        r211 = r38;
        goto L66
    L59:
        r36 = r19.getEnterMethod();
        goto L60
    L56:
        r35 = null;
        goto L57
    L53:
        r34 = null;
        goto L54
    L50:
        r210 = null;
        goto L51
    L46:
        r32 = null;
        goto L47
    L41:
        r23.e("CreationMessageStrategy", "tryAttachmentUpload ProcessResult for PREPARE_TYPE_NO_MATCH");
        t19.s r40 = t19.s.a;
        Context r41 = AppHost.a.getApplication().getApplicationContext();
        r40.getClass();
        t19.s.s(r41, 2131906526);
        goto L43
    L42:
        r23.e("CreationMessageStrategy", "tryAttachmentUpload ProcessResult for OverSize");
        t19.s r42 = t19.s.a;
        Context r43 = AppHost.a.getApplication().getApplicationContext();
        r42.getClass();
        t19.s.s(r43, 2131906513);
        goto L43
    L37:
        r27 = c.a[r26.ordinal()];
        goto L38
    L34:
        r26 = null;
        goto L35
    L30:
        r25 = null;
        goto L31
    L68:
        com.larus.uaigc.helper.f.a.getClass();
        boolean r110 = com.larus.uaigc.helper.f.a();
        String r44 = UUID.randomUUID().toString();
        if (r110 == false) goto L83;
        if (r15 == null) goto L83;
        String r45 = r15.getFileIdentifier();
        if (r45 == null) goto L83;
        if (r45.length() <= 0) goto L76;
        boolean r46 = true;
    L77:
        if (r46 == true) goto L80;
        r45 = null;
    L80:
        if (r45 == null) goto L83;
        String r212 = r45;
    L84:
        tx9.l0.d(r212);
        ic8.n0 r47 = r16.b;
        if (r47 == null) goto L87;
        ic8.m0 r48 = r47.a;
    L89:
        if (r110 == true) goto L91;
        int r49 = com.larus.uaigc.service.p0.x;
        String r50 = r212;
        Message r51 = r12;
        com.larus.uaigc.service.p0 r52 = com.larus.uaigc.service.p0.a.c(r17, r212, r48, null, true, new CountDownLatch(1), StringsKt.substringAfterLast$default(r17, '.', null, 2, null), "ai_beautify", "send_after_add_msg", new CreationMessageStrategy$uploadLocalImageAfterAddMsg$submitRequest$4(r110, this, r12), new CreationMessageStrategy$uploadLocalImageAfterAddMsg$submitRequest$5(r110, this, r50, r17, r51, r19, r15, r13, r16), new CreationMessageStrategy$uploadLocalImageAfterAddMsg$submitRequest$6(r16, r110, r50, this, r51, r13, r19), Boxing.boxBoolean(false), com.larus.uaigc.service.g.a, null, 1802280);
    L114:
        com.larus.bmhome.resource.access.b0 r53 = ICreationResourceAccessService.a.b(r52);
        if (r110 == false) goto L118;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new CreationMessageStrategy$observePipelineProgress$1(r53, this, r12, null), 2, null);
    L118:
        return Unit.INSTANCE;
    L91:
        if (m(r17) == false) goto L93;
        com.larus.bmhome.resource.access.j0 r213 = new com.larus.bmhome.resource.access.j0.a(r17);
    L112:
        int r54 = com.larus.uaigc.service.p0.x;
        String r55 = r212;
        Message r56 = r12;
        r52 = com.larus.uaigc.service.p0.a.b(r213, r212, null, null, true, new CountDownLatch(1), StringsKt.substringAfterLast$default(r17, '.', null, 2, null), "ai_beautify", "send_after_add_msg", new CreationMessageStrategy$uploadLocalImageAfterAddMsg$submitRequest$1(r110, this, r12), new CreationMessageStrategy$uploadLocalImageAfterAddMsg$submitRequest$2(r110, this, r55, r17, r56, r19, r15, r13, r16), new CreationMessageStrategy$uploadLocalImageAfterAddMsg$submitRequest$3(r16, r110, r55, this, r56, r13, r19), Boxing.boxBoolean(!Intrinsics.areEqual(r19.getHasImagePreprocessed(), Boxing.boxBoolean(true))), null, null, null, null, com.larus.uaigc.service.g.a, false, null, 1818648);
        goto L114
    L93:
        if (r48 == null) goto L95;
        String r57 = r48.a;
    L96:
        int r58 = com.larus.uaigc.helper.g.a;
        if (r48 == null) goto L99;
        String r59 = r48.a;
    L100:
        Boolean r60 = Boxing.boxBoolean(com.larus.uaigc.helper.g.b(r59));
        if (r48 == null) goto L107;
        Long r61 = Boxing.boxLong(r48.c);
        if (r61.longValue() < 0) goto L105;
        r18 = true;
    L105:
        if (r18 == false) goto L107;
    L108:
        if (r48 == null) goto L110;
        mr9.c r62 = r48.l;
    L111:
        r213 = new com.larus.bmhome.resource.access.j0.b(r17, r57, r60, r61, r62);
        goto L112
    L110:
        r62 = null;
    L107:
        r61 = null;
        goto L108
    L99:
        r59 = null;
        goto L100
    L95:
        r57 = null;
        goto L96
    L87:
        r48 = null;
        goto L89
    L76:
        r46 = false;
    L83:
        r212 = r44;
        goto L84
    L21:
        if (r17.length() == 0) goto L24;
        r20 = false;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r3.L$0 = r68;
        r3.L$1 = r69;
        r3.L$2 = r1;
        r3.L$3 = r71;
        r3.L$4 = r72;
        r3.L$5 = r73;
        r3.label = 1;
        Object r63 = t(r68, r1, r3);
        if (r63 != r5) goto L17;
        return r5;
    L17:
        r19 = r68;
        r14 = r69;
        r2 = r63;
        r12 = r72;
        r13 = r73;
        r15 = r71;
    L7:
        r3 = new CreationMessageStrategy$uploadLocalImageAfterAddMsg$1(this, r74);
        goto L8
    }

    public final Object s(CreationSendMessageConfig r18, String r19, String r20, AttachmentInfo r21, Message r22, Message r23, Continuation<? super Boolean> r24) {
        AttachmentInfo r3 = r21;
        if ((r24 instanceof CreationMessageStrategy$observePendingResourceAccessAfterAddMsg$1) == false) goto L7;
        CreationMessageStrategy$observePendingResourceAccessAfterAddMsg$1 r1 = (CreationMessageStrategy$observePendingResourceAccessAfterAddMsg$1) r24;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CreationMessageStrategy$observePendingResourceAccessAfterAddMsg$1 r7 = r1;
        Object r0 = r7.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r7.label;
        if (r4 == 0) goto L19;
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L17;
        if (r4 != 3) goto L16;
        ResultKt.throwOnFailure(r0);
    L87:
        return Boxing.boxBoolean(true);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Message r5 = (Message) r7.L$5;
        Message r6 = (Message) r7.L$4;
        AttachmentInfo r12 = (AttachmentInfo) r7.L$3;
        String r13 = (String) r7.L$2;
        String r14 = (String) r7.L$1;
        CreationSendMessageConfig r15 = (CreationSendMessageConfig) r7.L$0;
        ResultKt.throwOnFailure(r0);
        Message r8 = r5;
        AttachmentInfo r10 = r12;
        String r11 = r14;
        CreationSendMessageConfig r16 = r15;
        final Message r17 = r6;
        String r25 = r13;
    L54:
        com.larus.bmhome.resource.access.a0.d r26 = (com.larus.bmhome.resource.access.a0) r0;
        if ((r26 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L58;
        l(r16, r25, r10, r17, r8, r26.a);
        goto L87
    L58:
        if ((r26 instanceof com.larus.bmhome.resource.access.a0.c) == false) goto L69;
        com.larus.bmhome.resource.access.a0.c r27 = (com.larus.bmhome.resource.access.a0.c) r26;
        FLogger.a.e("CreationMessageStrategy", "observePendingResourceAccessAfterAddMsg failed: " + r27.a.b);
        j(r17);
        if (ICreationResourceAccessServiceKt.e(r27) == false) goto L62;
        n(new Message[]{r17, r8});
    L63:
        CreationResourceAccessUploader r28 = CreationResourceAccessUploader.a;
        if (r10 == null) goto L66;
        String r29 = r10.getFileIdentifier();
    L67:
        CreationResourceAccessUploader.g(r29);
        q(r16, r10, r27.a.b, null);
        goto L87
    L66:
        r29 = null;
        goto L67
    L62:
        o(new Message[]{r17, r8});
        goto L63
    L69:
        if ((r26 instanceof com.larus.bmhome.resource.access.a0.a) == false) goto L78;
        FLogger.a.e("CreationMessageStrategy", "observePendingResourceAccessAfterAddMsg cancelled: " + ((com.larus.bmhome.resource.access.a0.a) r26).a);
        CreationResourceAccessUploader r30 = CreationResourceAccessUploader.a;
        if (r10 == null) goto L73;
        String r31 = r10.getFileIdentifier();
    L74:
        CreationResourceAccessUploader.g(r31);
        r7.L$0 = null;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.L$5 = null;
        r7.label = 3;
        if (D(r16, r11, r25, r10, r17, r8, r7) != r9) goto L87;
        return r9;
    L73:
        r31 = null;
        goto L74
    L78:
        if (Intrinsics.areEqual(r26, com.larus.bmhome.resource.access.a0.b.a) == true) goto L87;
        if ((r26 instanceof com.larus.bmhome.resource.access.a0.e) == true) goto L87;
        if ((r26 instanceof com.larus.bmhome.resource.access.a0.f) == true) goto L87;
        throw new NoWhenBranchMatchedException();
    L18:
        String r32 = (String) r7.L$6;
        Message r33 = (Message) r7.L$5;
        r17 = (Message) r7.L$4;
        AttachmentInfo r110 = (AttachmentInfo) r7.L$3;
        String r111 = (String) r7.L$2;
        String r112 = (String) r7.L$1;
        CreationSendMessageConfig r34 = (CreationSendMessageConfig) r7.L$0;
        ResultKt.throwOnFailure(r0);
        r8 = r33;
        r3 = r110;
        CreationSendMessageConfig r113 = r34;
        String r114 = r111;
        String r115 = r112;
    L45:
        com.larus.bmhome.resource.access.b0 r35 = (com.larus.bmhome.resource.access.b0) r0;
        if (r35 == null) goto L48;
    L50:
        FLogger.a.i("CreationMessageStrategy", "observePendingResourceAccessAfterAddMsg observe taskId=" + r35.getTaskId() + ", identifier=" + r32);
        Function1 r36 = new com.larus.uaigc.createpage.component.sendmessage.b(this, r17);
        Function1 r37 = new com.larus.uaigc.createpage.component.sendmessage.c(this, r17);
        r7.L$0 = r113;
        r7.L$1 = r115;
        r7.L$2 = r114;
        r7.L$3 = r3;
        r7.L$4 = r17;
        r7.L$5 = r8;
        r7.L$6 = null;
        r7.label = 2;
        r0 = ICreationResourceAccessServiceKt.a(r35, r36, r37, r7);
        if (r0 != r9) goto L53;
        return r9;
    L53:
        r10 = r3;
        r16 = r113;
        r11 = r115;
        r25 = r114;
        goto L54
    L48:
        return Boxing.boxBoolean(false);
    L19:
        ResultKt.throwOnFailure(r0);
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L22;
        if (r3 == null) goto L89;
        String r38 = r21.getFileIdentifier();
        if (r38 == null) goto L89;
        if (r38.length() <= 0) goto L29;
        boolean r39 = true;
    L30:
        if (r39 == false) goto L32;
        r32 = r38;
    L33:
        if (r32 == null) goto L89;
        ICreationResourceAccessService.Companion r40 = ICreationResourceAccessService.a;
        com.larus.bmhome.resource.access.f0 r116 = r40.c(r32);
        if (r116 == null) goto L39;
        FLogger.a.i("CreationMessageStrategy", "observePendingResourceAccessAfterAddMsg hit ready artifact, identifier=".concat(r32));
        l(r18, r20, r21, r22, r23, r116);
        return Boxing.boxBoolean(true);
    L39:
        com.larus.bmhome.resource.access.x r41 = com.larus.uaigc.service.f.a;
        ResourceMediaType r117 = ResourceMediaType.IMAGE;
        r35 = ICreationResourceAccessService.a.b(r40, r32, r41, r117, 8);
        if (r35 != null) goto L49;
        CreationResourceAccessUploader r42 = CreationResourceAccessUploader.a;
        r113 = r18;
        r7.L$0 = r113;
        r115 = r19;
        r7.L$1 = r115;
        r114 = r20;
        r7.L$2 = r114;
        r7.L$3 = r3;
        r7.L$4 = r22;
        r8 = r23;
        r7.L$5 = r8;
        r7.L$6 = r32;
        r7.label = 1;
        Object r43 = CreationResourceAccessUploader.d(r32, r41, r117, r7);
        if (r43 != r9) goto L44;
        return r9;
    L44:
        r17 = r22;
        r0 = r43;
        goto L45
    L49:
        r113 = r18;
        r115 = r19;
        r114 = r20;
        r8 = r23;
        r17 = r22;
        goto L50
    L32:
        r32 = null;
        goto L33
    L29:
        r39 = false;
    L89:
        return Boxing.boxBoolean(false);
    L22:
        return Boxing.boxBoolean(false);
    L7:
        r1 = new CreationMessageStrategy$observePendingResourceAccessAfterAddMsg$1(this, r24);
        goto L8
    }

    public static final void d(b r52, boolean r53, String r54, CreationMessageStrategy r55, Message r56, Message r57, CreationSendMessageConfig r58, ResourceUploadError r59) {
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("uploadLocalImageAfterAddMsg failed: ");
        r2.append(r59.getCode());
        r2.append(", preprocessResultCode: ");
        ic8.n0 r3 = r52.b;
        String r4 = null;
        if (r3 == null) goto L5;
        ProcessFileResultCode r5 = r3.b;
    L6:
        r2.append(r5);
        r1.e("CreationMessageStrategy", r2.toString());
        if (r53 == false) goto L9;
        CreationResourceAccessUploader r6 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.g(r54);
    L9:
        r55.j(r56);
        Message[] r7 = {r56, r57};
        if (ICreationResourceAccessServiceKt.f(r59) == false) goto L12;
        n((Message[]) Arrays.copyOf(r7, 2));
    L13:
        Integer r8 = mr9.i.a(r59.getCode());
        ic8.n0 r9 = r52.b;
        if (r9 == null) goto L18;
        ic8.m0 r10 = r9.a;
        if (r10 == null) goto L18;
        Long r11 = Long.valueOf(r10.c);
    L19:
        ic8.n0 r0 = r52.b;
        if (r0 == null) goto L24;
        ic8.m0 r12 = r0.a;
        if (r12 == null) goto L24;
        String r13 = r12.d;
    L25:
        tx9.l0.a("creation_page_album_image_to_message", r54, false, r8, r11, r13);
        ny9.u r14 = r58.getHitPointData();
        if (r14 == null) goto L28;
        String r15 = r14.getClickFrom();
    L29:
        if (r14 == null) goto L31;
        String r16 = r14.m();
    L32:
        if (r14 == null) goto L34;
        String r17 = r14.i();
    L35:
        if (r14 == null) goto L37;
        String r18 = r14.getEnterMethod();
    L38:
        String r20 = r18;
        String r19 = r58.getBotId();
        if (r19 != null) goto L43;
        if (r14 == null) goto L42;
        r4 = r14.getBotId();
    L42:
        String r21 = r4;
    L44:
        IAIChatControlTraceService.Companion r22 = IAIChatControlTraceService.a;
        y3.a(r21, "chat", null, "upload", "pic", null, "0", null, null, r15, null, r16, r17, null, null, r20, null, r22.h(r22.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        return;
    L43:
        r21 = r19;
        goto L44
    L37:
        r18 = r58.getEnterMethod();
        goto L38
    L34:
        r17 = null;
        goto L35
    L31:
        r16 = null;
        goto L32
    L28:
        r15 = null;
    L24:
        r13 = null;
    L18:
        r11 = null;
        goto L19
    L12:
        o((Message[]) Arrays.copyOf(r7, 2));
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    public static final void f(boolean r51, CreationMessageStrategy r52, String r53, String r54, Message r55, CreationSendMessageConfig r56, AttachmentInfo r57, Message r58, b r59, mr9.l r60) {
        FLogger.a.i("CreationMessageStrategy", "uploadLocalImageAfterAddMsg upload success");
        if (r51 == false) goto L8;
        r52.getClass();
        String r0 = w(r53);
        if (r0 != null) goto L7;
        r0 = r(r54);
    L7:
        String r2 = r0;
    L9:
        if (r51 == false) goto L11;
        r52.getClass();
        C(r55, r2);
        CreationResourceAccessUploader r1 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.g(r53);
    L11:
        r52.j(r55);
        r52.A(r56, r2, r57, r55, r58, r60);
        ic8.n0 r3 = r59.b;
        String r4 = null;
        if (r3 == null) goto L16;
        ic8.m0 r5 = r3.a;
        if (r5 == null) goto L16;
        Long r6 = Long.valueOf(r5.c);
    L17:
        ic8.n0 r7 = r59.b;
        if (r7 == null) goto L22;
        ic8.m0 r8 = r7.a;
        if (r8 == null) goto L22;
        String r9 = r8.d;
    L23:
        tx9.l0.b("creation_page_album_image_to_message", r53, true, null, r6, r9, 8);
        String r10 = r60.a;
        if (r10 != null) goto L26;
        r10 = "";
    L26:
        ny9.u r11 = r56.getHitPointData();
        if (r11 == null) goto L29;
        String r13 = r11.getClickFrom();
    L30:
        if (r11 == null) goto L32;
        String r15 = r11.m();
    L33:
        if (r11 == null) goto L35;
        String r16 = r11.i();
    L36:
        if (r11 == null) goto L38;
        String r12 = r11.getEnterMethod();
    L39:
        String r19 = r12;
        String r14 = r56.getBotId();
        if (r14 != null) goto L44;
        if (r11 == null) goto L43;
        String r17 = r11.getBotId();
    L46:
        if (StringsKt.isBlank(r10) == false) goto L48;
        String r18 = "0";
    L49:
        String r110 = r18;
        if (StringsKt.isBlank(r10) == false) goto L52;
        r4 = "upload";
    L52:
        IAIChatControlTraceService.Companion r20 = IAIChatControlTraceService.a;
        y3.a(r17, "chat", null, r4, "pic", null, r110, null, null, r13, null, r15, r16, null, null, r19, null, r20.h(r20.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        return;
    L48:
        r18 = "1";
        goto L49
    L43:
        r17 = null;
        goto L46
    L44:
        r17 = r14;
        goto L46
    L38:
        r12 = r56.getEnterMethod();
        goto L39
    L35:
        r16 = null;
        goto L36
    L32:
        r15 = null;
        goto L33
    L29:
        r13 = null;
    L22:
        r9 = null;
    L16:
        r6 = null;
        goto L17
    L8:
        r2 = r54;
        goto L9
    }
}
