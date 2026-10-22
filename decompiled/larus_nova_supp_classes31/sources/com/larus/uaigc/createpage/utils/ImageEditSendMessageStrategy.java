package com.larus.uaigc.createpage.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.uaigc.service.p0;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ImageEditSendMessageStrategy {
    public final hy9.f a;
    public final ConcurrentHashMap<String, String> b;
    public final ConcurrentHashMap<String, Integer> c;
    public final ConcurrentHashMap<String, String> d;

    public final ChatPageContext h() {
        return s1a.a.g(this.a.a).a(ChatPageContext.class);
    }

    public ImageEditSendMessageStrategy(hy9.f r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public static boolean i(String r1) {
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

    public static String j(String r4) {
        if (StringsKt.startsWith$default(r4, "file://", false, 2, null) == false) goto L9;
        String r0 = UriProtector.parse(r4).getPath();
        if (r0 != null) goto L8;
        return StringsKt.removePrefix(r4, "file://");
    L8:
        return r0;
    L9:
        return r4;
    }

    public final void m(ImageEditDataWithMask r18) {
        Intrinsics.checkNotNullParameter(r18, "imageEditDataWithMask");
        hy9.f r6 = this.a;
        FLogger.a.i("ImageEditSendMessageStrategy", "sendImageRemoveMessage");
        if (r18.getSendMsgImgStoragePath() == null) goto L54;
        Map r1 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L27
        FragmentActivity r2 = r6.a.getActivity();     // Catch: Throwable -> L27
        if (r2 == null) goto L12;
        FragmentManager r3 = r2.getSupportFragmentManager();     // Catch: Throwable -> L27
        if (r3 == null) goto L12;
        Fragment r4 = r3.findFragmentByTag("ChatCreationPagerFragment");     // Catch: Throwable -> L27
        if (r4 == null) goto L12;
    L18:
        if (r4 == null) goto L24;
        FragmentActivity r5 = r4.getActivity();     // Catch: Throwable -> L27
        if (r5 == null) goto L24;
        FragmentManager r7 = r5.getSupportFragmentManager();     // Catch: Throwable -> L27
        if (r7 == null) goto L24;
        FragmentTransaction r8 = r7.beginTransaction();     // Catch: Throwable -> L27
        r8.remove(r4);     // Catch: Throwable -> L27
        r8.commitAllowingStateLoss();     // Catch: Throwable -> L27
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        Result.constructor-impl(r9);     // Catch: Throwable -> L27
    L29:
        ci8.d r10 = ci8.e.a(r6.a);
        if (r10 == null) goto L32;
        r10.f0(PageType.Chat.getType());
    L32:
        IChatDoubleTabAbility r11 = r6.j;
        if (r11 == null) goto L35;
        r11.f0(0);
    L35:
        ICoreInputAbility r12 = r6.k;
        if (r12 == null) goto L38;
        r12.V40();
    L38:
        String r13 = r18.getSendMsgImgStoragePath();
        String r14 = "";
        if (r13 != null) goto L41;
        r13 = "";
    L41:
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        Map r16 = com.larus.bmhome.instruction.j.a.c(IAIChatUgcAIGCService.a.e0(), r6.l, "4", r6.e, false, r6.g, null, 40);
        if (r16 == null) goto L50;
        Map r17 = MapsKt.toMutableMap(r16);
        if (r17 == null) goto L50;
        zd9.h.a.getClass();
        String r19 = zd9.h.c(r18);
        if (r19 == null) goto L49;
        r14 = r19;
    L49:
        r17.put("image_edit_media_data", r14);
        r1 = r17;
    L50:
        r15.element = r1;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2(r18, r13, r15, this, r6, null), 2, null);
        return;
    L24:
        r9 = null;
    L12:
        FragmentActivity r20 = r6.a.getActivity();     // Catch: Throwable -> L27
        if (r20 == null) goto L17;
        FragmentManager r21 = r20.getSupportFragmentManager();     // Catch: Throwable -> L27
        if (r21 == null) goto L17;
        r4 = r21.findFragmentByTag("ChatGalleryDialog");     // Catch: Throwable -> L27
    L17:
        r4 = null;
    L27:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    public final void k(com.larus.bmhome.resource.access.b0 r8, Message r9) {
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new ImageEditSendMessageStrategy$observePipelineState$1(r8, this, r9, null), 2, null);
    }

    public static final void a(ImageEditSendMessageStrategy r48, Message r49, boolean r50) {
        if (r50 == true) goto L7;
        u7 r15 = r48.a.i;
        if (r15 == null) goto L28;
        r15.E4(Message.copy$default(r49, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, r48.g(r49, "0", 100), null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194305, 31, null));
        return;
    L28:
        return;
    L7:
        r48.getClass();
        String r4 = r49.getLocalMessageId();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        if (r4.length() != 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L17;
        FLogger.a.e("ImageEditSendMessageStrategy", "finishUploadingMessage localMessageId is empty");
        return;
    L17:
        if (Intrinsics.areEqual(r48.d.get(r4), "0") == false) goto L24;
        Integer r6 = r48.c.get(r4);
        if (r6 == null) goto L24;
        if (r6.intValue() != 100) goto L24;
        return;
    L24:
        r48.c.put(r4, 100);
        r48.d.put(r4, "0");
        RepoDispatcherDelegate.b.e().r1(r4, new e());
        u7 r16 = r48.a.i;
        if (r16 == null) goto L31;
        r16.E4(Message.copy$default(r49, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, r48.g(r49, "0", 100), null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194305, 31, null));
        return;
    L31:
        return;
    L13:
        r5 = false;
        goto L14
    }

    public static final void b(ImageEditSendMessageStrategy r1, ResourceUploadError r2, List r3) {
        r1.getClass();
        if (ICreationResourceAccessServiceKt.f(r2) == false) goto L5;
        int r4 = 14;
    L6:
        Iterator r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L16;
        Message r6 = (Message) r5.next();
        IChatRepoService r0 = RepoDispatcherDelegate.b.e();
        if (r6 == null) goto L12;
        String r7 = r6.getLocalMessageId();
    L13:
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        r0.t1(r7, r4);
        goto L8
    L12:
        r7 = null;
        goto L13
    L16:
        return;
    L5:
        r4 = 3;
        goto L6
    }

    public static final Object d(ImageEditSendMessageStrategy r22, String r23, Continuation r24) {
        r22.getClass();
        kotlinx.coroutines.j r1 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r24), 1);
        r1.C();
        StringBuilder r2 = new StringBuilder();
        r2.append(UUID.randomUUID());
        r2.append('_');
        r2.append(System.currentTimeMillis());
        String r3 = r2.toString();
        AtomicBoolean r4 = new AtomicBoolean(false);
        FLogger.a.i("ImageEditSendMessageStrategy", "start submitLocalImageResourceAccess, curUploaderIdentifier:" + r3);
        ICreationResourceAccessService.Companion r5 = ICreationResourceAccessService.a;
        int r6 = p0.x;
        r5.b(p0.a.c(r23, r3, null, null, true, new CountDownLatch(1), null, null, null, null, new m(r3, r4, r1, r22), new n(r3, r4, r1, r22), null, com.larus.uaigc.service.g.a, null, 1822520));
        r1.i(new o(r4, r3));
        Object r0 = r1.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r24);
    L5:
        return r0;
    }

    public static final void f(ImageEditSendMessageStrategy r54, Message r55, String r56) {
        r54.getClass();
        if (r56 == null) goto L81;
        int r3 = 0;
        if (r56.length() <= 0) goto L7;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        final String r2 = r56;
    L12:
        if (r2 == null) goto L85;
        String r5 = r55.getLocalMessageId();
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        if (r5.length() != 0) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        FLogger.a.e("ImageEditSendMessageStrategy", "updateLocalImageMessagePathIfNeeded localMessageId is empty");
        return;
    L23:
        List r7 = com.larus.bmhome.chat.bean.d.g(r55).imageList;
        if (r7 == null) goto L26;
        Image r8 = (Image) CollectionsKt.firstOrNull(r7);
    L27:
        if (r8 == null) goto L42;
        String r9 = r8.localResPath;
        if (r9 == null) goto L42;
        if (r9.length() <= 0) goto L33;
        boolean r10 = true;
    L34:
        if (r10 == true) goto L37;
        r9 = null;
    L37:
        if (r9 == null) goto L42;
        if (new PolarisFileWrapper(j(r9)).exists() == false) goto L42;
        r54.b.putIfAbsent(r5, r9);
        return;
    L33:
        r10 = false;
    L42:
        if (Intrinsics.areEqual(r54.b.put(r5, r2), r2) == true) goto L86;
        if (r8 == null) goto L46;
        String r11 = r8.localResPath;
    L48:
        if (Intrinsics.areEqual(r11, r2) == false) goto L56;
        Map r12 = r55.getBusinessExt();
        if (r12 == null) goto L52;
        String r13 = (String) r12.get("send_image_local_path");
    L54:
        if (Intrinsics.areEqual(r13, r2) == false) goto L56;
        return;
    L52:
        r13 = null;
    L56:
        Map r14 = r55.getBusinessExt();
        if (r14 != null) goto L59;
        r14 = new LinkedHashMap();
    L59:
        Map r34 = com.larus.utils.h.c(r14, new Pair[]{TuplesKt.to("send_image_local_path", r2)});
        if (r8 == null) goto L64;
        ImageObj r4 = r8.imageOri;
        if (r4 == null) goto L64;
        int r15 = r4.height;
    L65:
        if (r8 == null) goto L69;
        ImageObj r16 = r8.imageOri;
        if (r16 == null) goto L69;
        r3 = r16.width;
    L69:
        if (r8 == null) goto L71;
        Boolean r17 = r8.aiCreationImage;
    L72:
        if (r8 == null) goto L76;
        ImageObj r18 = r8.previewImage;
        if (r18 == null) goto L76;
        String r19 = r18.url;
    L77:
        final String r20 = com.larus.bmhome.chat.sendimage.e.b(r2, r15, r3, r17, r19);
        com.larus.im.d.e().x(r5, new c(r20), null);
        RepoDispatcherDelegate.b.e().r1(r5, new d(r2));
        u7 r0 = r54.a.i;
        if (r0 == null) goto L84;
        r0.E4(Message.copy$default(r55, null, null, null, 0, 0, null, 0, false, null, r20, null, null, null, null, null, null, 0, 0, false, null, null, null, r34, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194817, 31, null));
        return;
    L84:
        return;
    L76:
        r19 = null;
        goto L77
    L71:
        r17 = null;
    L64:
        r15 = 0;
        goto L65
    L46:
        r11 = null;
        goto L48
    L86:
        return;
    L26:
        r8 = null;
        goto L27
    L20:
        r6 = false;
        goto L21
    L85:
        return;
    L11:
        r2 = null;
        goto L12
    L7:
        r1 = false;
        goto L9
    }

    public final Map<String, String> g(Message r6, String r7, int r8) {
        String r0 = r6.getLocalMessageId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r1 = this.b.get(r0);
        String r2 = null;
        if (r1 != null) goto L18;
        Map r3 = r6.getBusinessExt();
        if (r3 == null) goto L10;
        r1 = (String) r3.get("send_image_local_path");
    L11:
        if (r1 != null) goto L18;
        List r4 = com.larus.bmhome.chat.bean.d.g(r6).imageList;
        if (r4 == null) goto L17;
        Image r5 = (Image) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L17;
        r1 = r5.localResPath;
    L17:
        r1 = null;
        goto L18
    L10:
        r1 = null;
    L18:
        Pair r9 = TuplesKt.to("progress", String.valueOf(r8));
        boolean r10 = true;
        List r11 = CollectionsKt.mutableListOf(new Pair[]{TuplesKt.to("loading", r7), r9});
        if (r1 != null) goto L21;
    L28:
        Map r12 = r6.getBusinessExt();
        if (r12 != null) goto L31;
        r12 = new LinkedHashMap();
    L31:
        Pair[] r13 = (Pair[]) r11.toArray(new Pair[0]);
        return com.larus.utils.h.c(r12, (Pair[]) Arrays.copyOf(r13, r13.length));
    L21:
        if (r1.length() > 0) goto L24;
        r10 = false;
    L24:
        if (r10 == false) goto L26;
        r2 = r1;
    L26:
        if (r2 == null) goto L28;
        r11.add(TuplesKt.to("send_image_local_path", r2));
        goto L28
    }

    public final void l(Message r49, int r50, boolean r51) {
        if (r51 == true) goto L8;
        u7 r15 = this.a.i;
        if (r15 == null) goto L36;
        r15.E4(Message.copy$default(r49, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, g(r49, "1", r50), null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194305, 31, null));
        return;
    L36:
        return;
    L8:
        String r4 = r49.getLocalMessageId();
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        if (r4.length() != 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L19;
        FLogger.a.e("ImageEditSendMessageStrategy", "refreshUploadingMessage localMessageId is empty");
        return;
    L19:
        if (Intrinsics.areEqual(this.d.get(r4), "0") == false) goto L26;
        Integer r6 = this.c.get(r4);
        if (r6 == null) goto L26;
        if (r6.intValue() != 100) goto L26;
        return;
    L26:
        final int r2 = RangesKt.coerceIn(r50, 5, 99);
        Integer r7 = this.c.get(r4);
        if (Intrinsics.areEqual(this.d.get(r4), "1") == false) goto L32;
        if (r7 == null) goto L32;
        if (r7.intValue() < r2) goto L32;
        return;
    L32:
        Integer r8 = Integer.valueOf(r2);
        this.c.put(r4, r8);
        this.d.put(r4, "1");
        RepoDispatcherDelegate.b.e().r1(r4, new g(r2));
        u7 r16 = this.a.i;
        if (r16 == null) goto L37;
        r16.E4(Message.copy$default(r49, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, g(r49, "1", r2), null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194305, 31, null));
        return;
    L37:
        return;
    L14:
        r5 = false;
        goto L15
    }

    public static final void e(AtomicBoolean r2, String r3, kotlinx.coroutines.i r4, mr9.l r5) {
        if (r2.compareAndSet(false, true) == true) goto L6;
        FLogger.a.w("ImageEditSendMessageStrategy", "submitLocalImageResourceAccess ignore duplicate callback, curUploaderIdentifier:" + r3);
        return;
    L6:
        if (r4.isActive() == true) goto L16;
        FLogger.a.w("ImageEditSendMessageStrategy", "submitLocalImageResourceAccess continuation inactive, curUploaderIdentifier:" + r3);
        return;
    L16:
        r4.resumeWith(Result.constructor-impl(r5));     // Catch: Throwable -> L10
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L20;
        FLogger.a.e("ImageEditSendMessageStrategy", "submitLocalImageResourceAccess resume failed, curUploaderIdentifier:" + r3, r7);
        return;
    L20:
        return;
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static final Object c(ImageEditSendMessageStrategy r8, String r9, Message r10, Function1 r11, final Function1 r12, Function1 r13, Continuation r14) {
        r8.getClass();
        if ((r14 instanceof ImageEditSendMessageStrategy$reuseSelectionPipelineTask$1) == false) goto L7;
        ImageEditSendMessageStrategy$reuseSelectionPipelineTask$1 r0 = (ImageEditSendMessageStrategy$reuseSelectionPipelineTask$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Function1 r16 = (Function1) r0.L$1;
        Function1 r17 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L33:
        ICreationResourceAccessServiceKt.c((com.larus.bmhome.resource.access.a0) r15, r17, r16);
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (Function1) r0.L$4;
        r12 = (Function1) r0.L$3;
        r11 = (Function1) r0.L$2;
        r10 = (Message) r0.L$1;
        r9 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L26:
        com.larus.bmhome.resource.access.b0 r18 = (com.larus.bmhome.resource.access.b0) r15;
        if (r18 == null) goto L36;
    L29:
        FLogger.a.i("ImageEditSendMessageStrategy", "reuse resource access taskId=" + r18.getTaskId() + ", identifier=" + r9);
        r8.k(r18, r10);
        Function1 r19 = new b(r12);
        r0.L$0 = r11;
        r0.L$1 = r13;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.label = 2;
        r15 = ICreationResourceAccessServiceKt.b(r18, r19, r0, 1);
        if (r15 == r2) goto L38;
        r17 = r11;
        r16 = r13;
        goto L33
    L38:
        return r2;
    L36:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r15);
        ICreationResourceAccessService.Companion r110 = ICreationResourceAccessService.a;
        com.larus.bmhome.resource.access.f0 r4 = r110.c(r9);
        if (r4 == null) goto L21;
        mr9.l r5 = com.larus.bmhome.resource.access.s.c(r4);
        if (r5 == null) goto L21;
        FLogger.a.i("ImageEditSendMessageStrategy", "reuse ready resource access artifact, identifier=" + r9);
        r11.invoke(r5);
        return Boxing.boxBoolean(true);
    L21:
        com.larus.bmhome.resource.access.x r6 = com.larus.uaigc.service.f.a;
        ResourceMediaType r7 = ResourceMediaType.IMAGE;
        r18 = ICreationResourceAccessService.a.b(r110, r9, r6, r7, 8);
        if (r18 != null) goto L29;
        CreationResourceAccessUploader r111 = CreationResourceAccessUploader.a;
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.L$2 = r11;
        r0.L$3 = r12;
        r0.L$4 = r13;
        r0.label = 1;
        r15 = CreationResourceAccessUploader.d(r9, r6, r7, r0);
        if (r15 != r2) goto L26;
        return r2;
    L7:
        r0 = new ImageEditSendMessageStrategy$reuseSelectionPipelineTask$1(r8, r14);
        goto L8
    }
}
