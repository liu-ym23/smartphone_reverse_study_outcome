package com.larus.bmhome.chat.layout.holder.helper;

import android.content.ClipData;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.bmhome.chat.list.cell.nested_file.NestedFileDownloader;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.save_share.VideoGenerateSaver;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OClickActionBlock;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyBlockStatus;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.bean.message.block.QuickReplyScene;
import com.larus.im.bean.message.block.ResearchBlock;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.audit.BehaviorAuditApi;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MessageCopyHelper implements s0 {
    public static final MessageCopyHelper a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TargetDataSource.values().length];
            r0[TargetDataSource.Thinking.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[TargetDataSource.Content.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[TargetDataSource.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements Function4<Integer, String, Long, Boolean, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<Uri> a;
        public final /* synthetic */ CoroutineScope b;
        public final /* synthetic */ Context c;

        public b(kotlinx.coroutines.j r1, CoroutineScope r2, Context r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object invoke(Object r3, Object r4, Object r5, Object r6) {
            int r7 = ((Number) r3).intValue();
            String r8 = (String) r4;
            ((Number) r5).longValue();
            Boolean r9 = (Boolean) r6;
            Intrinsics.checkNotNullParameter(r8, "path");
            if (r7 == 0) goto L5;
        L25:
            Uri r10 = null;
        L27:
            if (this.a.isActive() == false) goto L29;
            this.a.resumeWith(Result.constructor-impl(r10));
        L29:
            CoroutineScopeKt.cancel$default(this.b, null, 1, null);
            return Unit.INSTANCE;
        L5:
            if ((!StringsKt.isBlank(r8)) == false) goto L25;
            if (StringsKt.startsWith$default(r8, "content://", false, 2, null) == false) goto L9;
            String r11 = r8;
        L10:
            if (r11 == null) goto L14;
            r10 = UriProtector.parse(r11);
            if (r10 != null) goto L27;
        L14:
            MessageCopyHelper.a.getClass();
            String r12 = MessageCopyHelper.k(r8);
            if (r12 == null) goto L25;
            Context r13 = this.c;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
            Object r14 = Result.constructor-impl(com.larus.bmhome.bigimg.i1.c(r13, new PolarisFileWrapper(r12)));     // Catch: Throwable -> L19
        L22:
            if (Result.isFailure-impl(r14) == false) goto L24;
            r14 = null;
        L24:
            r10 = (Uri) r14;
        L19:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L22
        L9:
            r11 = null;
            goto L10
        }
    }

    public static final class c implements Function1<Throwable, Unit> {
        public final /* synthetic */ CoroutineScope a;

        public c(CoroutineScope r1) {
            this.a = r1;
        }

        public final Object invoke(Object r3) {
            Throwable r4 = (Throwable) r3;
            CoroutineScopeKt.cancel$default(this.a, null, 1, null);
            return Unit.INSTANCE;
        }
    }

    static {
        a = new MessageCopyHelper();
    }

    public MessageCopyHelper() {
    }

    public static String k(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return null;
    L13:
        if (StringsKt.startsWith$default(r4, "file://", false, 2, null) == true) goto L15;
        return r4;
    L15:
        return UriProtector.parse(r4).getPath();
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r1 = false;
        goto L10
    }

    public static String j(UplinkFileEntity r6, String r7) {
        String r8 = k(r7);
        String r1 = null;
        if (r8 != null) goto L5;
    L10:
        PolarisFileWrapper r2 = null;
    L11:
        UplinkEntityContent r9 = r6.getUplinkEntityContent();
        if (r9 == null) goto L23;
        UplinkFileInfo r10 = r9.getUplinkFileInfo();
        if (r10 == null) goto L23;
        String r11 = r10.getFileName();
        if (r11 == null) goto L23;
        if ((!StringsKt.isBlank(r11)) == true) goto L21;
        r11 = null;
    L21:
        if (r11 == null) goto L23;
    L40:
        if ((!StringsKt.isBlank(StringsKt.substringAfterLast(r11, '.', ""))) == false) goto L43;
        return r11;
    L43:
        if (yc9.n1.d(r6) == false) goto L60;
        if (r2 == null) goto L68;
        String r12 = URLConnection.guessContentTypeFromName(r2.getName());
        if (r12 != null) goto L48;
        BitmapFactory.Options r13 = new BitmapFactory.Options();
        r13.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r2.getAbsolutePath(), r13);
        r12 = r13.outMimeType;
    L48:
        if (r12 == null) goto L68;
        String r14 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r12);
        if (r14 == null) goto L68;
        if ((!StringsKt.isBlank(r14)) == true) goto L55;
        r14 = null;
    L55:
        if (r14 == null) goto L68;
        if (Intrinsics.areEqual(r14, "jpeg") == false) goto L69;
        r14 = "jpg";
    L69:
        if (r14 == null) goto L79;
        String r15 = StringsKt.trim(r14).toString();
        if (r15 == null) goto L79;
        String r16 = StringsKt.trimStart(r15, new char[]{'.'});
        if (r16 == null) goto L79;
        String r17 = r16.toLowerCase(Locale.ROOT);
        if (r17 == null) goto L79;
        if ((true ^ StringsKt.isBlank(r17)) == false) goto L79;
        r1 = r17;
    L79:
        if (r1 == null) goto L85;
        String r18 = r11 + '.' + r1;
        if (r18 != null) goto L84;
        return r11;
    L84:
        return r18;
    L85:
        return r11;
    L68:
        r14 = null;
        goto L69
    L60:
        if (yc9.n1.e(r6) == false) goto L68;
        UplinkEntityContent r19 = r6.getUplinkEntityContent();
        if (r19 == null) goto L68;
        UplinkFileInfo r20 = r19.getUplinkFileInfo();
        if (r20 == null) goto L68;
        VideoExtension r21 = r20.getVideo();
        if (r21 == null) goto L68;
        r14 = r21.getFormat();
    L23:
        if (r2 == null) goto L29;
        r11 = r2.getName();
        if (r11 == null) goto L29;
        if ((!StringsKt.isBlank(r11)) == false) goto L29;
    L30:
        if (r11 != null) goto L40;
        if (yc9.n1.d(r6) == false) goto L35;
        String r22 = "image";
    L38:
        r11 = r22 + '_' + System.currentTimeMillis();
        goto L40
    L35:
        if (yc9.n1.e(r6) == false) goto L37;
        r22 = "video";
        goto L38
    L37:
        r22 = "attachment";
    L29:
        r11 = null;
        goto L30
    L5:
        if ((!StringsKt.isBlank(r8)) == true) goto L8;
        r8 = null;
    L8:
        if (r8 == null) goto L10;
        r2 = new PolarisFileWrapper(r8);
        goto L11
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.s0
    public final Object b(List<? extends lw8.l> r4, Continuation<? super String> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MessageCopyHelper$generateCopyText$2(r4, null), r5);
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.s0
    public final boolean f(Context r4, CharSequence r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter("bpea-thread-detail-text", "copyKey");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return false;
    L9:
        return n(r4, r5, null, "bpea-thread-detail-text");
    L5:
        r0 = false;
        goto L6
    }

    public static Object m(Context r36, UplinkFileEntity r37, Continuation r38) {
        UplinkEntityContent r0 = r37.getUplinkEntityContent();
        if (r0 == null) goto L43;
        UplinkFileInfo r1 = r0.getUplinkFileInfo();
        if (r1 == null) goto L43;
        VideoExtension r3 = r1.getVideo();
        if (r3 == null) goto L43;
        String r4 = k(r1.getLocalResPath());
        if (r4 != null) goto L13;
    L18:
        r4 = k(r3.getPath());
        if (r4 != null) goto L21;
    L23:
        String r13 = null;
    L24:
        String r8 = r3.getDownloadUrl();
        boolean r5 = false;
        if (r13 != null) goto L27;
    L30:
        boolean r6 = true;
    L31:
        if (r6 == false) goto L38;
        if (r8 != null) goto L34;
    L35:
        r5 = true;
    L36:
        if (r5 == false) goto L38;
    L34:
        if (StringsKt.isBlank(r8) == false) goto L36;
    L38:
        String r7 = r3.getVid();
        Float r9 = r3.getDuration();
        if (r9 == null) goto L41;
        Double r10 = Double.valueOf(r9.floatValue());
    L42:
        nr9.g r19 = new nr9.g(r7, null, r8, null, r10, r3.getFormat(), null, r13, r1.getResourceId(), null, 586);
    L44:
        if (r19 != null) goto L46;
        return null;
    L46:
        CoroutineScope r2 = CoroutineScopeKt.MainScope();
        kotlinx.coroutines.j r11 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r38), 1);
        r11.C();
        com.larus.bmhome.video.save_share.a.a.a(VideoGenerateSaver.a, r36, r19, new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383), "", r2, false, false, null, null, null, false, new b(r11, r2, r36), 1984);
        r11.i(new c(r2));
        Object r12 = r11.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L49;
        DebugProbesKt.probeCoroutineSuspended(r38);
    L49:
        return r12;
    L41:
        r10 = null;
        goto L42
    L27:
        if (StringsKt.isBlank(r13) == true) goto L30;
        r6 = false;
        goto L31
    L21:
        if (new PolarisFileWrapper(r4).exists() == false) goto L23;
    L22:
        r13 = r4;
        goto L24
    L13:
        if (new PolarisFileWrapper(r4).exists() == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L18;
    L43:
        r19 = null;
        goto L44
    }

    public final Object i(Context r21, UplinkFileEntity r22, Continuation r23) {
        Context r0 = r21;
        UplinkFileEntity r2 = r22;
        if ((r23 instanceof MessageCopyHelper$copySingleAttachment$1) == false) goto L7;
        MessageCopyHelper$copySingleAttachment$1 r4 = (MessageCopyHelper$copySingleAttachment$1) r23;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        String r8 = null;
        String r10 = "video";
        if (r7 == 0) goto L28;
        if (r7 == 1) goto L25;
        if (r7 == 2) goto L22;
        if (r7 == 3) goto L19;
        if (r7 != 4) goto L18;
        String r1 = (String) r4.L$3;
        String r9 = (String) r4.L$2;
        UplinkFileEntity r11 = (UplinkFileEntity) r4.L$1;
        Context r12 = (Context) r4.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L87
    L117:
        Uri r13 = (Uri) r3;     // Catch: Throwable -> L87
        if (r13 != null) goto L120;
        r13 = com.larus.bmhome.bigimg.i1.c(r12, new PolarisFileWrapper(r9));     // Catch: Throwable -> L87
    L120:
        String r15 = r1;
        r2 = r11;
    L121:
        if (r13 != null) goto L125;
        return Boxing.boxBoolean(false);
    L125:
        if (yc9.n1.d(r2) == false) goto L128;
        r10 = "image";
    L131:
        ClipData r14 = ClipData.newUri(r12.getContentResolver(), r10, r13);     // Catch: Throwable -> L87
        IFlowSdkDepend r16 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L87
        if (r16 == null) goto L137;
        r16.d0();     // Catch: Throwable -> L87
        com.larus.home.impl.sdk.i1 r17 = com.larus.home.impl.sdk.i1.a;
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L87
        r17.i(r12, r14, "bpea-message-copy-with-attachment");     // Catch: Throwable -> L87
    L137:
        UplinkEntityContent r18 = r2.getUplinkEntityContent();     // Catch: Throwable -> L87
        if (r18 == null) goto L140;
        UplinkFileInfo r19 = r18.getUplinkFileInfo();     // Catch: Throwable -> L87
    L142:
        if (r19 == null) goto L147;
        String r20 = r19.getResourceId();     // Catch: Throwable -> L87
        if (r20 == null) goto L147;
        String r110 = r20;
    L148:
        if (r19 == null) goto L150;
        Long r111 = r19.getSize();     // Catch: Throwable -> L87
    L151:
        if (r19 == null) goto L153;
        r8 = r19.getMd5();     // Catch: Throwable -> L87
    L153:
        String r112 = r8;
        if (r19 == null) goto L159;
        String r24 = r19.getMimeType();     // Catch: Throwable -> L87
        if (r24 == null) goto L159;
        String r113 = r24;
    L160:
        BehaviorAuditApi.b(new com.larus.platform.audit.b(r110, r15, r111, r112, r113), MapsKt.mapOf(TuplesKt.to("token", "bpea-message-copy-with-attachment")));     // Catch: Throwable -> L87
        t19.s.a.getClass();     // Catch: Throwable -> L87
        t19.s.o(r12, 2131910467, false);     // Catch: Throwable -> L87
        Object r25 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L87
    L163:
        Boolean r26 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r25) == true) goto L166;
        return r25;
    L166:
        return r26;
    L159:
        r113 = r10;
        goto L160
    L150:
        r111 = null;
    L147:
        r110 = r2.getFileIdentifier();     // Catch: Throwable -> L87
        goto L148
    L140:
        r19 = null;
        goto L142
    L128:
        if (yc9.n1.e(r2) == true) goto L131;
        r10 = "file";
        goto L131
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        String r27 = (String) r4.L$2;
        r2 = (UplinkFileEntity) r4.L$1;
        r12 = (Context) r4.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L87
    L109:
        r13 = (Uri) r3;     // Catch: Throwable -> L87
    L86:
        r15 = r27;
        goto L121
    L22:
        r27 = (String) r4.L$2;
        r2 = (UplinkFileEntity) r4.L$1;
        r12 = (Context) r4.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L87
    L85:
        r13 = (Uri) r3;     // Catch: Throwable -> L87
        goto L86
    L25:
        MessageCopyHelper r28 = (MessageCopyHelper) r4.L$2;
        r2 = (UplinkFileEntity) r4.L$1;
        Context r29 = (Context) r4.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L87
        MessageCopyHelper r30 = r28;
        r0 = r29;
        Object r31 = r3;
    L61:
        String r32 = (String) r31;     // Catch: Throwable -> L87
    L63:
        if (r32 != null) goto L78;
        UplinkEntityContent r114 = r2.getUplinkEntityContent();     // Catch: Throwable -> L87
        if (r114 == null) goto L69;
        UplinkFileInfo r115 = r114.getUplinkFileInfo();     // Catch: Throwable -> L87
        if (r115 == null) goto L69;
        String r116 = r115.getLocalResPath();     // Catch: Throwable -> L87
    L70:
        if (r116 != null) goto L77;
        UplinkEntityContent r117 = r2.getUplinkEntityContent();     // Catch: Throwable -> L87
        if (r117 == null) goto L76;
        Image r118 = r117.getUplinkImageInfo();     // Catch: Throwable -> L87
        if (r118 == null) goto L76;
        String r119 = r118.localResPath;     // Catch: Throwable -> L87
    L79:
        r30.getClass();     // Catch: Throwable -> L87
        String r33 = j(r2, r119);     // Catch: Throwable -> L87
        if (yc9.n1.e(r2) == false) goto L90;
        r4.L$0 = r0;     // Catch: Throwable -> L87
        r4.L$1 = r2;     // Catch: Throwable -> L87
        r4.L$2 = r33;     // Catch: Throwable -> L87
        r4.label = 2;     // Catch: Throwable -> L87
        Object r34 = m(r0, r2, r4);     // Catch: Throwable -> L87
        if (r34 != r6) goto L84;
        return r6;
    L84:
        r12 = r0;
        r27 = r33;
        r3 = r34;
        goto L85
    L90:
        if (yc9.n1.d(r2) == false) goto L110;
        r4.L$0 = r0;     // Catch: Throwable -> L87
        r4.L$1 = r2;     // Catch: Throwable -> L87
        r4.L$2 = r33;     // Catch: Throwable -> L87
        r4.label = 3;     // Catch: Throwable -> L87
        UplinkEntityContent r35 = r2.getUplinkEntityContent();     // Catch: Throwable -> L87
        if (r35 == null) goto L105;
        Image r36 = r35.getUplinkImageInfo();     // Catch: Throwable -> L87
        if (r36 == null) goto L105;
        ImageObj r37 = r36.imageOri;     // Catch: Throwable -> L87
        if (r37 == null) goto L105;
        String r38 = r37.url;     // Catch: Throwable -> L87
        if (r38 == null) goto L105;
        if ((!StringsKt.isBlank(r38)) == true) goto L103;
        r38 = null;
    L103:
        if (r38 == null) goto L105;
        Object r39 = ImageSave.a.y(r0, r38, null, r4);     // Catch: Throwable -> L87
    L106:
        if (r39 != r6) goto L108;
        return r6;
    L108:
        Object r120 = r39;
        r12 = r0;
        r27 = r33;
        r3 = r120;
    L105:
        r39 = null;
        goto L106
    L110:
        if (r32 == null) goto L112;
        ImageSave r121 = ImageSave.a;     // Catch: Throwable -> L87
        r4.L$0 = r0;     // Catch: Throwable -> L87
        r4.L$1 = r2;     // Catch: Throwable -> L87
        r4.L$2 = r32;     // Catch: Throwable -> L87
        r4.L$3 = r33;     // Catch: Throwable -> L87
        r4.label = 4;     // Catch: Throwable -> L87
        Object r40 = ImageSave.l(r121, r0, r32, r33, r4);     // Catch: Throwable -> L87
        if (r40 != r6) goto L116;
        return r6;
    L116:
        r11 = r2;
        r9 = r32;
        r12 = r0;
        r1 = r33;
        r3 = r40;
        goto L117
    L112:
        return Boxing.boxBoolean(false);
    L76:
        r119 = null;
        goto L79
    L77:
        r119 = r116;
    L69:
        r116 = null;
        goto L70
    L78:
        r119 = r32;
        goto L79
    L28:
        ResultKt.throwOnFailure(r3);
        FlowFileProtectionService r41 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r41 != null) goto L31;
    L33:
        boolean r42 = false;
    L34:
        if (r42 == false) goto L52;
        com.larus.platform.service.o r43 = com.larus.platform.service.o.a;
        JSONObject r44 = new JSONObject();
        r44.put("action", "copy_file");
        r44.put("entry", "message_copy");
        if (yc9.n1.d(r22) == false) goto L39;
        r10 = "image";
    L42:
        r44.put("content_type", r10);
        Unit r45 = Unit.INSTANCE;
        r43.reportEvent("flow_enterprise_file_egress_block", r44);
        String r46 = r41.H0();
        if (r46 == null) goto L51;
        if ((!StringsKt.isBlank(r46)) == false) goto L47;
        String r47 = r46;
    L48:
        if (r47 == null) goto L51;
        t19.s.j(t19.s.a, r21, r47, null, false, 28);
        goto L51
    L47:
        r47 = null;
    L51:
        return Boxing.boxBoolean(false);
    L39:
        if (yc9.n1.e(r22) == true) goto L42;
        r10 = "file";
        goto L42
    L52:
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L87
        if (yc9.n1.e(r22) == false) goto L55;
    L62:
        r30 = this;
        r32 = null;
        goto L63
    L55:
        if (yc9.n1.d(r22) == true) goto L62;
        r4.L$0 = r0;     // Catch: Throwable -> L87
        r4.L$1 = r2;     // Catch: Throwable -> L87
        r4.L$2 = this;     // Catch: Throwable -> L87
        r4.label = 1;     // Catch: Throwable -> L87
        Object r49 = l(r0, r2, r4);     // Catch: Throwable -> L87
        if (r49 != r6) goto L60;
        return r6;
    L60:
        r31 = r49;
        r30 = this;
        goto L61
    L31:
        if (r41.I0() != true) goto L33;
        r42 = true;
    L87:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r4 = new MessageCopyHelper$copySingleAttachment$1(this, r23);
        goto L8
    }

    public final Object l(Context r8, UplinkFileEntity r9, Continuation<? super String> r10) {
        if ((r10 instanceof MessageCopyHelper$resolveFileAttachmentCachePath$1) == false) goto L7;
        MessageCopyHelper$resolveFileAttachmentCachePath$1 r0 = (MessageCopyHelper$resolveFileAttachmentCachePath$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MessageCopyHelper$resolveFileAttachmentCachePath$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L33:
        NestedFileDownloader.a r12 = (NestedFileDownloader.a) r11;
        if (r12.a == 0) goto L38;
    L36:
        return null;
    L38:
        return r12.d;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        UplinkEntityContent r13 = r9.getUplinkEntityContent();
        if (r13 == null) goto L36;
        UplinkFileInfo r4 = r13.getUplinkFileInfo();
        if (r4 == null) goto L36;
        String r14 = k(r4.getLocalResPath());
        if (r14 != null) goto L22;
    L25:
        boolean r15 = true;
    L26:
        if (r15 == false) goto L28;
    L30:
        NestedFileDownloader r5 = NestedFileDownloader.a;
        r6.label = 1;
        r11 = r5.c(r8, r4, null, null, r6);
        if (r11 != r2) goto L33;
        return r2;
    L28:
        if (new PolarisFileWrapper(r14).exists() == false) goto L30;
        return r14;
    L22:
        if (StringsKt.isBlank(r14) == true) goto L25;
        r15 = false;
    L7:
        r0 = new MessageCopyHelper$resolveFileAttachmentCachePath$1(this, r10);
        goto L8
    }

    public static boolean n(Context r3, CharSequence r4, CharSequence r5, String r6) {
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Exception -> L15
        if (r1 == null) goto L7;
        r1.d0();     // Catch: Exception -> L15
        com.larus.home.impl.sdk.i1 r2 = com.larus.home.impl.sdk.i1.a;
    L8:
        ClipData r7 = com.larus.bmhome.utils.p.b(r4, r5);     // Catch: Exception -> L15
        if (r2 == null) goto L11;
        r2.i(r3, r7, r6);     // Catch: Exception -> L15
    L11:
        BehaviorAuditApi.b(null, MapsKt.mapOf(TuplesKt.to("token", r6)));     // Catch: Exception -> L15
        if (r2 == null) goto L20;
        return true;
    L20:
        return false;
    L7:
        r2 = null;
    L15:
        e = move-exception;
        FLogger.a.e("MessageCopyHelper", "do copy failed", e);
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.s0
    public final Object a(Message r9, String r10, TargetDataSource r11, Continuation<? super List<String>> r12) {
        int r0 = r9.getContentType();
        if (r0 == 1) goto L10;
        if (r0 == 11) goto L10;
        if (r0 == 9999) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (com.larus.im.bean.message.a.b0(r9) == false) goto L22;
        int r13 = a.a[r11.ordinal()];
        if (r13 == 1) goto L19;
        if (r13 == 2) goto L18;
        if (r13 != 3) goto L17;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        List r14 = vd9.r.a(r9);
    L21:
        return s0.a.a(this, r14, false, r10, false, null, r12, 24);
    L17:
        throw new NoWhenBranchMatchedException();
    L18:
        r14 = com.larus.im.bean.message.a.A(r9);
        goto L21
    L19:
        r14 = com.larus.im.bean.message.a.R(r9);
        goto L21
    L22:
        int r15 = a.a[r11.ordinal()];
        String r16 = "";
        String r17 = null;
        if (r15 == 1) goto L50;
        if (r15 == 2) goto L43;
        if (r15 != 3) goto L42;
        List r18 = com.larus.im.bean.message.a.S(r9);
        if (r18 == null) goto L31;
        com.larus.im.bean.message.c r19 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L31;
        String r110 = r19.a;
    L32:
        if (r110 != null) goto L34;
        r110 = "";
    L34:
        Regex r1 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        TextContent r20 = vd9.r.b(r9);
        if (r20 == null) goto L37;
        r17 = r20.text;
    L37:
        if (r17 == null) goto L61;
        r16 = r17;
    L61:
        return CollectionsKt.listOf(r110.concat(r16));
    L31:
        r110 = null;
        goto L32
    L42:
        throw new NoWhenBranchMatchedException();
    L43:
        Regex r111 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        TextContent r21 = vd9.r.b(r9);
        if (r21 == null) goto L46;
        r17 = r21.text;
    L46:
        if (r17 == null) goto L62;
        r16 = r17;
    L62:
        return CollectionsKt.listOf(r16);
    L50:
        List r22 = com.larus.im.bean.message.a.S(r9);
        if (r22 == null) goto L55;
        com.larus.im.bean.message.c r23 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r22);
        if (r23 == null) goto L55;
        r17 = r23.a;
    L55:
        if (r17 == null) goto L59;
        r16 = r17;
    L59:
        return CollectionsKt.listOf(r16);
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.s0
    public final Object e(Context r7, List<? extends lw8.l> r8, String r9, Continuation<? super Unit> r10) {
        Object r11 = h(r7, r8, null, r9, r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.s0
    public final Object g(Context r68, Message r69, BotModel r70, TargetDataSource r71, Continuation<? super List<? extends lw8.l>> r72) {
        if ((r72 instanceof MessageCopyHelper$getMarkdownContentList$1) == false) goto L7;
        MessageCopyHelper$getMarkdownContentList$1 r3 = (MessageCopyHelper$getMarkdownContentList$1) r72;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        MessageCopyHelper$getMarkdownContentList$1 r10 = r3;
        Object r2 = r10.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r10.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        int r0 = r10.I$1;
        int r1 = r10.I$0;
        MarkwonStruct r7 = (MarkwonStruct) r10.L$2;
        lw8.d r8 = (lw8.d) r10.L$1;
        Context r9 = (Context) r10.L$0;
        ResultKt.throwOnFailure(r2);
    L50:
        ArrayList r11 = new ArrayList();
        Iterator r12 = ((Iterable) r2).iterator();
    L52:
        if (r12.hasNext() == false) goto L95;
        String r22 = (String) r12.next();
        gw8.c.a.getClass();
        gw8.c r19 = gw8.c.a.b();
        if (r19 == null) goto L59;
        if (r0 == 0) goto L57;
        boolean r23 = true;
    L58:
        lw8.l r13 = gw8.c.b.a(r19, r9, r1, r22, r23, r8, r7, null, 192);
    L60:
        if (r13 == null) goto L52;
        r11.add(r13);
        goto L52
    L57:
        r23 = false;
        goto L58
    L59:
        r13 = null;
        goto L60
    L95:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        lw8.d r14 = new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, new CodeBlockConfig(null, null, false, null, 0, null, false, null, false, false, null, false, null, null, null, null, false, false, null, false, null, null, null, false, Boxing.boxBoolean(true), false, false, 117440511, null), null, null, null, null, null, null, null, -2097153, 31);
        int r15 = com.larus.utils.m0.b(r68);
        if (com.larus.bmhome.chat.bean.d.j0(r69) == true) goto L17;
    L19:
        boolean r16 = false;
    L20:
        gw8.c.a.getClass();
        gw8.c r17 = gw8.c.a.b();
        if (r17 == null) goto L23;
        boolean r73 = r16;
        MarkwonStruct r18 = r17.createCacheMarkwonStruct(r68, Boxing.boxInt(r15), r14, null, r73);
    L25:
        if ((r18 instanceof MarkwonStruct) == false) goto L27;
        MarkwonStruct r20 = r18;
    L28:
        int r21 = r69.getContentType();
        if (r21 == 1) goto L36;
        if (r21 == 66) goto L36;
        if (r21 == 9999) goto L36;
        return CollectionsKt.emptyList();
    L36:
        if (com.larus.im.bean.message.a.b0(r69) == false) goto L63;
        int r24 = a.a[r71.ordinal()];
        if (r24 == 1) goto L45;
        if (r24 == 2) goto L44;
        if (r24 != 3) goto L43;
        Intrinsics.checkNotNullParameter(r69, "<this>");
        List r25 = vd9.r.a(r69);
    L46:
        r10.L$0 = r68;
        r10.L$1 = r14;
        r10.L$2 = r20;
        r10.I$0 = r15;
        boolean r110 = r73;
        r10.I$1 = r110 ? 1 : 0;
        r10.label = 1;
        MarkwonStruct r111 = r20;
        Object r26 = s0.a.a(this, r25, true, null, false, null, r10, 28);
        if (r26 != r5) goto L49;
        return r5;
    L49:
        r9 = r68;
        r8 = r14;
        r7 = r111;
        r1 = r15;
        r2 = r26;
        r0 = r110 ? 1 : 0;
        goto L50
    L43:
        throw new NoWhenBranchMatchedException();
    L44:
        r25 = com.larus.im.bean.message.a.A(r69);
        goto L46
    L45:
        r25 = com.larus.im.bean.message.a.R(r69);
        goto L46
    L63:
        boolean r112 = r73;
        MarkwonStruct r113 = r20;
        int r27 = a.a[r71.ordinal()];
        String r28 = "";
        if (r27 != 1) goto L66;
        String r29 = com.larus.bmhome.chat.bean.d.n(r69);
        if (r29 != null) goto L79;
        String r30 = "";
    L80:
        gw8.c r31 = gw8.c.a.b();
        if (r31 == null) goto L88;
        lw8.l r32 = gw8.c.b.a(r31, r68, r15, r30, r112, r14, r113, null, 192);
        if (r32 == null) goto L88;
        List r33 = CollectionsKt.listOf(r32);
        if (r33 == null) goto L88;
        return r33;
    L88:
        return CollectionsKt.emptyList();
    L79:
        r30 = r29;
        goto L80
    L66:
        if (r27 == 2) goto L75;
        if (r27 != 3) goto L74;
        String r34 = com.larus.bmhome.chat.bean.d.n(r69);
        if (r34 == null) goto L72;
        r28 = r34;
    L72:
        r29 = r28 + hc8.b.a.a(PluginManagerDelegate.a, r69, r70, true, 8);
        goto L79
    L74:
        throw new NoWhenBranchMatchedException();
    L75:
        r29 = hc8.b.a.a(PluginManagerDelegate.a, r69, r70, true, 8);
        goto L79
    L27:
        r20 = null;
        goto L28
    L23:
        r73 = r16;
        r18 = null;
        goto L25
    L17:
        if (com.larus.bmhome.chat.bean.d.Q0(r69) == true) goto L19;
        r16 = true;
    L7:
        r3 = new MessageCopyHelper$getMarkdownContentList$1(this, r72);
        goto L8
    }

    public final Object h(Context r5, List<? extends lw8.l> r6, CharSequence r7, String r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof MessageCopyHelper$copyAllMarkdownContent$2) == false) goto L7;
        MessageCopyHelper$copyAllMarkdownContent$2 r0 = (MessageCopyHelper$copyAllMarkdownContent$2) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (String) r0.L$2;
        r7 = (CharSequence) r0.L$1;
        r5 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L36:
        ClipData r11 = com.larus.bmhome.utils.p.b((String) r10, r7);     // Catch: Exception -> L32
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Exception -> L32
        if (r12 == null) goto L28;
        r12.d0();     // Catch: Exception -> L32
        com.larus.home.impl.sdk.i1 r13 = com.larus.home.impl.sdk.i1.a;
        if (r8 != null) goto L25;
        String r4 = "bpea-markdown-text-copy";
    L26:
        r13.i(r5, r11, r4);     // Catch: Exception -> L32
        goto L28
    L25:
        r4 = r8;
    L28:
        if (r8 != null) goto L30;
        r8 = "bpea-markdown-text-copy";
    L30:
        BehaviorAuditApi.b(null, MapsKt.mapOf(TuplesKt.to("token", r8)));     // Catch: Exception -> L32
    L35:
        return Unit.INSTANCE;
    L32:
        e = move-exception;
        FLogger.a.e("MessageCopyHelper", "do copy failed", e);
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r0.L$0 = r5;
        r0.L$1 = r7;
        r0.L$2 = r8;
        r0.label = 1;
        r10 = b(r6, r0);
        if (r10 != r2) goto L36;
        return r2;
    L7:
        r0 = new MessageCopyHelper$copyAllMarkdownContent$2(this, r9);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x023e -> B:121:0x0247). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:124:0x0277 -> B:126:0x027f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:125:0x027e -> B:126:0x027f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00ab -> B:126:0x027f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00af -> B:126:0x027f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c5 -> B:126:0x027f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d4 -> B:126:0x027f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x019a -> B:126:0x027f). Please report as a decompilation issue!!! */
    @Override // com.larus.bmhome.chat.layout.holder.helper.s0
    public final Object c(List<Block> r25, boolean r26, String r27, boolean r28, Function1<? super Block, String> r29, Continuation<? super List<String>> r30) {
        if ((r30 instanceof MessageCopyHelper$getBlockListFlattenText$1) == false) goto L7;
        MessageCopyHelper$getBlockListFlattenText$1 r1 = (MessageCopyHelper$getBlockListFlattenText$1) r30;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        Message r5 = null;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        boolean r6 = r1.Z$1;
        boolean r8 = r1.Z$0;
        Iterator r9 = (Iterator) r1.L$3;
        Collection r10 = (Collection) r1.L$2;
        Function1<? super Block, String> r11 = (Function1) r1.L$1;
        String r12 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        String r7 = r12;
    L121:
        String r13 = CollectionsKt.joinToString$default((Iterable) r0, r7, null, null, 0, null, null, 62, null);
        Collection r14 = r10;
        MessageCopyHelper$getBlockListFlattenText$1 r15 = r1;
        boolean r16 = r8;
        Function1<? super Block, String> r17 = r11;
        Object r18 = r3;
        String r19 = r7;
    L126:
        if (r13 == null) goto L128;
        r14.add(r13);
    L128:
        r5 = null;
    L22:
        if (r9.hasNext() == false) goto L130;
        Block r20 = (Block) r9.next();
        int r110 = r20.getBlockType();
        if (r110 != com.larus.bmhome.chat.deepresearch.view.j.e) goto L33;
        if (r16 == true) goto L31;
        BlockContent r21 = r20.getContent();
        if (r21 == null) goto L125;
        TextBlock r22 = r21.getTextBlock();
        if (r22 == null) goto L125;
        r13 = r22.text;
    L125:
        r13 = null;
        goto L126
    L31:
        r13 = qf8.a.c(r20, r5, 3);
        goto L126
    L33:
        if (r110 != com.larus.bmhome.chat.deepresearch.view.j.S) goto L45;
        if (r17 == null) goto L39;
        String r111 = (String) r17.invoke(r20);
        if (r111 == null) goto L39;
        r13 = r111;
    L39:
        BlockContent r23 = r20.getContent();
        if (r23 == null) goto L125;
        OClickActionBlock r24 = r23.getOClickActionBlock();
        if (r24 == null) goto L125;
        r13 = r24.content;
        goto L126
    L45:
        if (r110 != com.larus.bmhome.chat.deepresearch.view.j.G) goto L87;
        a.getClass();
        BlockContent r31 = r20.getContent();
        if (r31 == null) goto L125;
        QuickReplyBlock r32 = r31.getQuickReplyBlock();
        if (r32 == null) goto L125;
        Integer r112 = r32.getScene();
        int r113 = QuickReplyScene.SCENE_ASWEER_INNER_OPTION.getValue();
        if (r112 == null) goto L125;
        if (r112.intValue() != r113) goto L125;
        Integer r114 = r32.getStatus();
        int r115 = QuickReplyBlockStatus.STATUS_HIDDEN.getValue();
        if (r114 != null) goto L61;
    L63:
        List r33 = r32.getItems();
        if (r33 != null) goto L66;
        r33 = CollectionsKt.emptyList();
    L66:
        ArrayList r116 = new ArrayList();
        Iterator r34 = r33.iterator();
    L67:
        boolean r210 = false;
        if (r34.hasNext() == false) goto L81;
        String r117 = ((QuickReplyItem) r34.next()).getText();
        if (r117 == null) goto L78;
        Message r118 = StringsKt.trim(r117).toString();
        if (r118 == null) goto L78;
        if (r118.length() <= 0) goto L76;
        r210 = true;
    L76:
        if (r210 == false) goto L78;
    L79:
        if (r118 == null) goto L67;
        r116.add(r118);
    L78:
        r118 = r5;
        goto L79
    L81:
        r13 = CollectionsKt.joinToString$default(r116, "\n", null, null, 0, null, null, 62, null);
        if (r13.length() <= 0) goto L84;
        if (0 == 0) goto L125;
        goto L126
    L84:
        if (1 == 0) goto L125;
    L61:
        if (r114.intValue() != r115) goto L63;
    L87:
        if (r110 != com.larus.bmhome.chat.deepresearch.view.j.r) goto L123;
        BlockContent r35 = r20.getContent();
        if (r35 == null) goto L125;
        ResearchBlock r36 = r35.getResearchBlock();
        if (r36 == null) goto L125;
        String r119 = r36.getResourceId();
        if (r119 == null) goto L125;
        if (r6 == false) goto L131;
        r13 = r36.getBrief();
        goto L126
    L131:
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L105
        CoroutineDispatcher r38 = Dispatchers.getIO();     // Catch: Throwable -> L105
        MessageCopyHelper$getBlockListFlattenText$2$content$1$1 r120 = new MessageCopyHelper$getBlockListFlattenText$2$content$1$1(r119, r5);     // Catch: Throwable -> L105
        r15.L$0 = r19;     // Catch: Throwable -> L105
        r15.L$1 = r17;     // Catch: Throwable -> L105
        r15.L$2 = r14;     // Catch: Throwable -> L105
        r15.L$3 = r9;     // Catch: Throwable -> L105
        r15.Z$0 = r16;     // Catch: Throwable -> L105
        r15.Z$1 = r6;     // Catch: Throwable -> L105
        r15.label = 1;     // Catch: Throwable -> L105
        r0 = BuildersKt.withContext(r38, r120, r15);     // Catch: Throwable -> L105
        if (r0 != r18) goto L101;
        return r18;
    L101:
        Function1<? super Block, String> r211 = r17;
        boolean r39 = r16;
        r1 = r15;
        Collection r121 = r14;
        String r122 = r19;
        r3 = r18;
        Function1<? super Block, String> r123 = r211;
    L102:
        Object r40 = Result.constructor-impl((mf9.c) r0);     // Catch: Throwable -> L18
        boolean r124 = r39;
        Iterator r125 = r9;
        Collection r126 = r121;
        String r212 = r122;
        Function1<? super Block, String> r127 = r123;
        String r128 = r212;
    L107:
        Throwable r41 = Result.exceptionOrNull-impl(r40);
        if (r41 == null) goto L111;
        FLogger.a.e("MessageCopyHelper", "getDeepResearchResource failed", r41);
    L111:
        if (Result.isFailure-impl(r40) == false) goto L113;
        r40 = null;
    L113:
        mf9.c r42 = (mf9.c) r40;
        if (r42 == null) goto L122;
        List r43 = r42.a;
        if (r43 == null) goto L122;
        MessageCopyHelper r44 = a;
        r1.L$0 = r128;
        r1.L$1 = r127;
        r1.L$2 = r126;
        r1.L$3 = r125;
        r1.Z$0 = r124;
        r1.Z$1 = r6;
        r1.label = 2;
        String r129 = r128;
        Function1<? super Block, String> r130 = r127;
        Collection r45 = r126;
        Iterator r46 = r125;
        boolean r131 = r124;
        Object r47 = s0.a.a(r44, r43, r124, r128, false, null, r1, 24);
        if (r47 != r3) goto L120;
        return r3;
    L120:
        r10 = r45;
        r9 = r46;
        r0 = r47;
        r7 = r129;
        r11 = r130;
        r8 = r131;
    L122:
        String r132 = r128;
        Function1<? super Block, String> r133 = r127;
        r14 = r126;
        r15 = r1;
        r18 = r3;
        r9 = r125;
        r19 = r132;
        r17 = r133;
        r16 = r124;
    L18:
        Throwable th = th;
        Collection r213 = r121;
        r15 = r1;
        r16 = r39;
        r17 = r123;
        r18 = r3;
        r19 = r122;
        r14 = r213;
    L106:
        Result.Companion r134 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        r124 = r16;
        r125 = r9;
        r1 = r15;
        r126 = r14;
        r127 = r17;
        Object r214 = r18;
        r128 = r19;
        r3 = r214;
    L105:
        th = th;
        goto L106
    L123:
        if (r17 == null) goto L125;
        r13 = (String) r17.invoke(r20);
        goto L126
    L130:
        return (List) r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = r1.Z$1;
        r39 = r1.Z$0;
        r9 = (Iterator) r1.L$3;
        r121 = (Collection) r1.L$2;
        r123 = (Function1) r1.L$1;
        r122 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L18
        goto L102
    L20:
        ResultKt.throwOnFailure(r0);
        ArrayList r48 = new ArrayList();
        r17 = r29;
        r9 = r25.iterator();
        r15 = r1;
        r18 = r3;
        r14 = r48;
        r16 = r26;
        r19 = r27;
        r6 = r28;
    L7:
        r1 = new MessageCopyHelper$getBlockListFlattenText$1(this, r30);
        goto L8
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.s0
    public final Object d(Context r19, List<Block> r20, boolean r21, int r22, lw8.d r23, lw8.h r24, boolean r25, boolean r26, Function1<? super Block, String> r27, Continuation<? super List<? extends lw8.l>> r28) {
        if ((r28 instanceof MessageCopyHelper$getMarkdownContentList$4) == false) goto L7;
        MessageCopyHelper$getMarkdownContentList$4 r1 = (MessageCopyHelper$getMarkdownContentList$4) r28;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MessageCopyHelper$getMarkdownContentList$4 r8 = r1;
        Object r0 = r8.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r8.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        int r5 = r8.I$0;
        boolean r6 = r8.Z$0;
        lw8.h r7 = (lw8.h) r8.L$2;
        lw8.d r9 = (lw8.d) r8.L$1;
        Context r10 = (Context) r8.L$0;
        ResultKt.throwOnFailure(r0);
        int r15 = r5;
        boolean r14 = r6;
        lw8.d r13 = r9;
    L29:
        ArrayList r11 = new ArrayList();
        Iterator r12 = ((Iterable) r0).iterator();
    L31:
        if (r12.hasNext() == false) goto L38;
        String r16 = (String) r12.next();
        gw8.c.a.getClass();
        gw8.c r17 = gw8.c.a.b();
        if (r17 == null) goto L35;
        lw8.l r18 = gw8.c.b.a(r17, r10, r15, r16, r14, r13, r7, null, 192);
    L36:
        if (r18 == null) goto L31;
        r11.add(r18);
        goto L31
    L35:
        r18 = null;
        goto L36
    L38:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (r24 != null) goto L24;
        gw8.c.a.getClass();
        gw8.c r110 = gw8.c.a.b();
        if (r110 == null) goto L19;
        lw8.h r29 = r110.createCacheMarkwonStruct(r19, Boxing.boxInt(r22), r23, null, r21);
    L21:
        if ((r29 instanceof MarkwonStruct) == false) goto L23;
        lw8.h r30 = (MarkwonStruct) r29;
    L25:
        r8.L$0 = r19;
        r13 = r23;
        r8.L$1 = r13;
        r8.L$2 = r30;
        r14 = r21;
        r8.Z$0 = r14;
        r15 = r22;
        r8.I$0 = r15;
        r8.label = 1;
        Object r31 = s0.a.a(this, r20, r26, null, r25, r27, r8, 4);
        if (r31 != r3) goto L28;
        return r3;
    L28:
        r7 = r30;
        r0 = r31;
        r10 = r19;
        goto L29
    L23:
        r30 = null;
        goto L25
    L19:
        r29 = null;
        goto L21
    L24:
        r30 = r24;
    L7:
        r1 = new MessageCopyHelper$getMarkdownContentList$4(this, r28);
        goto L8
    }
}
