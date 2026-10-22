package com.larus.uaigc.chat.markdown.image.component;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageShareClickMethod;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.share.ShareScene;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.b1;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.message.CreationTaskType;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.uaigc.chat.markdown.helper.j0;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.service.ICreationShareService;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.v1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ImageOperatorComponent implements d {
    public final /* synthetic */ d a;
    public boolean b;

    @Override // com.larus.uaigc.chat.markdown.image.component.d
    public final View a() {
        return this.a.a();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.d
    public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> b() {
        return this.a.b();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.d
    public final Function1<Continuation<? super Message>, Object> c() {
        return this.a.c();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.d
    public final String getLogTag() {
        return this.a.getLogTag();
    }

    public ImageOperatorComponent(d r2) {
        Intrinsics.checkNotNullParameter(r2, "depend");
        this.a = r2;
    }

    public final Object d(Message r7, ImageInfo r8, JSONObject r9, Continuation<? super df8.a> r10) {
        if ((r10 instanceof ImageOperatorComponent$generateImageItemInfo$1) == false) goto L7;
        ImageOperatorComponent$generateImageItemInfo$1 r0 = (ImageOperatorComponent$generateImageItemInfo$1) r10;
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
        int r12 = r0.I$0;
        ImageItem r13 = (ImageItem) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L63:
        return new df8.a(r12, r13, null, (Map) r11);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r14 = r0.I$0;
        ImageItem r15 = (ImageItem) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L31:
        return new df8.a(r14, r15, null, (Map) r11);
    L16:
        ResultKt.throwOnFailure(r11);
        if (r7 != null) goto L19;
        return null;
    L19:
        if (r8 != null) goto L22;
        return null;
    L22:
        if (com.larus.bmhome.chat.bean.d.k(r7) == false) goto L32;
        if (r9 == null) goto L25;
        int r16 = r9.optInt("position");
    L26:
        int r17 = r16 - 1;
        r15 = j0.g(r8);
        Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> r18 = b();
        r0.L$0 = r15;
        r0.I$0 = r17;
        r0.label = 1;
        r11 = r18.invoke(r7, r0);
        if (r11 != r2) goto L29;
        return r2;
    L29:
        r14 = r17;
        goto L31
    L25:
        r16 = 1;
        goto L26
    L32:
        Map<String, CreationTask> r19 = j0.c(dp8.e.c(r7));
        if (r19 == null) goto L37;
        Collection<CreationTask> r20 = r19.values();
        if (r20 == null) goto L37;
        List r21 = CollectionsKt.toList(r20);
    L38:
        if (r21 != null) goto L40;
        r21 = CollectionsKt.emptyList();
    L40:
        Iterator r22 = r21.iterator();
        int r110 = 0;
    L42:
        if (r22.hasNext() == false) goto L57;
        CreationTask r4 = (CreationTask) r22.next();
        if (r4 == null) goto L52;
        CreationAsset r5 = r4.asset;
        if (r5 == null) goto L52;
        UserCreationImage r6 = r5.imageContent;
        if (r6 == null) goto L52;
        ImageInfo r23 = r6.a;
        if (r23 == null) goto L52;
        String r24 = r23.e;
    L54:
        if (Intrinsics.areEqual(r24, r8.e) == true) goto L55;
        r110 = r110 + 1;
        goto L42
    L55:
        int r25 = r110;
    L58:
        r13 = j0.g(r8);
        Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> r111 = b();
        r0.L$0 = r13;
        r0.I$0 = r25;
        r0.label = 2;
        r11 = r111.invoke(r7, r0);
        if (r11 != r2) goto L61;
        return r2;
    L61:
        r12 = r25;
    L52:
        r24 = null;
        goto L54
    L57:
        r25 = -1;
    L37:
        r21 = null;
    L7:
        r0 = new ImageOperatorComponent$generateImageItemInfo$1(this, r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(ImageInfo r24, JSONObject r25, String r26, @CreationTaskType Integer r27, Continuation<? super Unit> r28) {
        if ((r28 instanceof ImageOperatorComponent$saveImage$1) == false) goto L7;
        ImageOperatorComponent$saveImage$1 r2 = (ImageOperatorComponent$saveImage$1) r28;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        ImageOperatorComponent$saveImage$1 r7 = r2;
        Object r0 = r7.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r7.label;
        if (r4 == 0) goto L22;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L20;
        if (r4 == 3) goto L19;
        if (r4 == 4) goto L18;
        if (r4 != 5) goto L17;
        Message r1 = (Message) r7.L$2;
        Integer r5 = (Integer) r7.L$1;
        JSONObject r6 = (JSONObject) r7.L$0;
        ResultKt.throwOnFailure(r0);
        String r10 = null;
    L140:
        df8.a r15 = (df8.a) r0;
        if (r15 == null) goto L163;
        com.larus.uaigc.chat.image.event.b r8 = com.larus.uaigc.chat.image.event.b.a;
        ImageShareClickMethod r14 = ImageShareClickMethod.OverviewClick;
        if (r5 == null) goto L145;
        String r16 = DataConverterKt.h(r5.intValue());
    L146:
        if (r6 == null) goto L148;
        Integer r17 = Boxing.boxInt(r6.optInt("position"));
    L149:
        if (r6 == null) goto L151;
        String r18 = r6.optString("creation_task_id");
    L152:
        if (r6 == null) goto L154;
        String r19 = r6.optString("creation_id");
    L155:
        if (r1 == null) goto L157;
        String r20 = com.larus.im.bean.message.a.r(r1);
    L158:
        if (r1 == null) goto L160;
        String r21 = com.larus.im.bean.message.a.s(r1);
    L161:
        r8.getClass();
        com.larus.uaigc.chat.image.event.b.f(r14, r15, r16, r17, r18, r19, r20, r21, r6);
        goto L163
    L160:
        r21 = r10;
        goto L161
    L157:
        r20 = r10;
        goto L158
    L154:
        r19 = r10;
        goto L155
    L151:
        r18 = r10;
        goto L152
    L148:
        r17 = r10;
        goto L149
    L145:
        r16 = r10;
    L163:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        Integer r11 = (Integer) r7.L$2;
        JSONObject r12 = (JSONObject) r7.L$1;
        ImageInfo r13 = (ImageInfo) r7.L$0;
        ResultKt.throwOnFailure(r0);
        r6 = r12;
        r10 = null;
        r5 = r11;
    L137:
        r1 = (Message) r0;
        r7.L$0 = r6;
        r7.L$1 = r5;
        r7.L$2 = r1;
        r7.label = 5;
        r0 = d(r1, r13, r6, r7);
        if (r0 != r9) goto L140;
        return r9;
    L19:
        String r22 = (String) r7.L$4;
        Integer r23 = (Integer) r7.L$3;
        final String r29 = (String) r7.L$2;
        JSONObject r30 = (JSONObject) r7.L$1;
        ImageInfo r110 = (ImageInfo) r7.L$0;
        ResultKt.throwOnFailure(r0);
        Integer r111 = r23;
        ImageInfo r112 = r110;
        JSONObject r113 = r30;
    L99:
        Message r31 = (Message) r0;
        if (r113 == null) goto L102;
        String r32 = r113.optString("creation_task_id");
    L103:
        ICreationMetadataService.Companion r33 = ICreationMetadataService.a;
        if (r113 == null) goto L106;
        String r34 = Boxing.boxInt(r113.optInt("position")).toString();
    L107:
        final UserCreationFromIM r35 = r33.I(r31, r32, r34);
        Map<String, String> r36 = r33.L(r35, r32);
        if (r111 == null) goto L115;
        String r37 = DataConverterKt.h(r111.intValue());
        if ((!StringsKt.isBlank(r37)) == true) goto L113;
        r37 = null;
    L113:
        if (r37 == null) goto L115;
    L125:
        IFlowSdkDepend r38 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r38 == null) goto L132;
        r38.D0();
        b1 r39 = b1.a;
        r39.c("chat_thumbnail_download");
        if (r22 != null) goto L130;
        String r114 = "";
    L131:
        r39.d(r114);
        goto L132
    L130:
        r114 = r22;
    L132:
        ImageDownloadLoadingMgr r40 = ImageDownloadLoadingMgr.a;
        ImageDownloadLoadingMgr.b(r22, r36, new ImageOperatorComponent$saveImage$3(r35, r32, r29, null), new e(r35, r29), true, new ImageOperatorComponent$saveImage$5(r22, r37, r112, null));
        r5 = r111;
    L133:
        r13 = r112;
        Function1<Continuation<? super Message>, Object> r41 = c();
        r7.L$0 = r13;
        r7.L$1 = r113;
        r7.L$2 = r5;
        r10 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.label = 4;
        r0 = r41.invoke(r7);
        if (r0 != r9) goto L136;
        return r9;
    L136:
        r6 = r113;
    L115:
        if (r31 == null) goto L121;
        String r42 = ap8.a.b(r31);
        if (r42 == null) goto L121;
        if ((!StringsKt.isBlank(r42)) == false) goto L121;
    L122:
        if (r42 != null) goto L124;
        r37 = "image";
        goto L125
    L124:
        r37 = r42;
    L121:
        r42 = null;
        goto L122
    L106:
        r34 = null;
        goto L107
    L102:
        r32 = null;
        goto L103
    L20:
        r22 = (String) r7.L$4;
        r5 = (Integer) r7.L$3;
        String r43 = (String) r7.L$2;
        r113 = (JSONObject) r7.L$1;
        r112 = (ImageInfo) r7.L$0;
        ResultKt.throwOnFailure(r0);
        String r44 = r43;
    L94:
        if (((Boolean) r0).booleanValue() == false) goto L133;
        Function1<Continuation<? super Message>, Object> r45 = c();
        r7.L$0 = r112;
        r7.L$1 = r113;
        r7.L$2 = r44;
        r7.L$3 = r5;
        r7.L$4 = r22;
        r7.label = 3;
        r0 = r45.invoke(r7);
        if (r0 != r9) goto L98;
        return r9;
    L98:
        r111 = r5;
        r29 = r44;
        goto L99
    L21:
        ResultKt.throwOnFailure(r0);
    L56:
        return Unit.INSTANCE;
    L22:
        ResultKt.throwOnFailure(r0);
        z2 r46 = z2.a;
        v1 r47 = r46.getCreationShareSettings().a();
        boolean r115 = false;
        if (r47 != null) goto L25;
    L27:
        boolean r48 = false;
    L28:
        if (r48 == false) goto L57;
        v1 r49 = r46.getCreationShareSettings().a();
        if (r49 != null) goto L32;
    L34:
        boolean r50 = false;
    L35:
        if (r50 == false) goto L41;
        if (r27 != null) goto L39;
    L49:
        boolean r51 = true;
    L51:
        if (r51 == false) goto L57;
        r7.label = 1;
        if (f(r24, r25, r26, true, r27, true, r7) != r9) goto L56;
        return r9;
    L39:
        if (r27.intValue() != 5) goto L49;
    L50:
        r51 = false;
        goto L51
    L41:
        if (r27 != null) goto L44;
    L45:
        if (r27 == null) goto L49;
        if (r27.intValue() == 1) goto L50;
    L44:
        if (r27.intValue() == 5) goto L50;
    L32:
        if (r49.f() != true) goto L34;
        r50 = true;
    L57:
        if (r24 == null) goto L61;
        Image r52 = r24.a;
        if (r52 == null) goto L61;
        String r53 = r52.a;
    L62:
        if (r53 != null) goto L64;
    L65:
        r115 = true;
    L66:
        if (r115 == false) goto L69;
        FLogger.a.e(getLogTag(), "doSaveImage error because imageUrl is null or empty");
        return Unit.INSTANCE;
    L69:
        FragmentActivity r54 = a().getContext();
        if ((r54 instanceof FragmentActivity) == false) goto L72;
        FragmentActivity r55 = r54;
    L73:
        if (r55 != null) goto L78;
        FragmentActivity r56 = AppHost.a.a().getCurrentActivity();
        if ((r56 instanceof FragmentActivity) == false) goto L77;
        r55 = r56;
        goto L78
    L77:
        r55 = null;
    L78:
        if (r55 != null) goto L81;
        FLogger.a.e(getLogTag(), "no activity");
        return Unit.INSTANCE;
    L81:
        r7.L$0 = r24;
        r7.L$1 = r25;
        r44 = r26;
        r7.L$2 = r44;
        r7.L$3 = r27;
        r7.L$4 = r53;
        r7.label = 2;
        SafeContinuation r116 = new SafeContinuation(IntrinsicsKt.intercepted(r7));
        if (Build.VERSION.SDK_INT <= 29) goto L84;
    L86:
        Result.Companion r57 = Result.Companion;
        r116.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
    L87:
        Object r58 = r116.getOrThrow();
        if (r58 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L90;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L90:
        if (r58 != r9) goto L92;
        return r9;
    L92:
        r113 = r25;
        r112 = r24;
        r22 = r53;
        r0 = r58;
        r5 = r27;
        goto L94
    L84:
        if (ContextCompat.checkSelfPermission(r55, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L86;
        i2.b.a(r55, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new f(r116));
        goto L87
    L72:
        r55 = null;
        goto L73
    L64:
        if (r53.length() != 0) goto L66;
    L61:
        r53 = null;
        goto L62
    L25:
        if (r47.b() != true) goto L27;
        r48 = true;
    L7:
        r2 = new ImageOperatorComponent$saveImage$1(this, r28);
        goto L8
    }

    public final Object f(ImageInfo r42, JSONObject r43, String r44, boolean r45, @CreationTaskType Integer r46, boolean r47, Continuation<? super Unit> r48) {
        JSONObject r2 = r43;
        if ((r48 instanceof ImageOperatorComponent$shareImage$1) == false) goto L7;
        ImageOperatorComponent$shareImage$1 r5 = (ImageOperatorComponent$shareImage$1) r48;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r9 = true;
        String r14 = "";
        switch(r5.label) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r4);
        ImageOperatorComponent r11 = this;
    L270:
        r11.b = false;
        return Unit.INSTANCE;
    L13:
        Integer r1 = (Integer) r5.L$1;
        JSONObject r3 = (JSONObject) r5.L$0;
        ResultKt.throwOnFailure(r4);
        r11 = this;
        Object r0 = r7;
    L260:
        df8.a r8 = (df8.a) r4;
        if (r8 == null) goto L267;
        com.larus.uaigc.chat.image.event.b r10 = com.larus.uaigc.chat.image.event.b.a;
        ImageShareClickMethod r12 = ImageShareClickMethod.OverviewClick;
        if (r1 == null) goto L265;
        String r13 = DataConverterKt.h(r1.intValue());
    L266:
        r10.a(r12, r8, r13, r3);
        Unit r15 = Unit.INSTANCE;
        goto L267
    L265:
        r13 = null;
    L267:
        r5.L$0 = null;
        r5.L$1 = null;
        r5.label = 10;
        if (DelayKt.delay(500, r5) != r0) goto L270;
        return r0;
    L14:
        ImageOperatorComponent r16 = (ImageOperatorComponent) r5.L$3;
        Integer r17 = (Integer) r5.L$2;
        JSONObject r18 = (JSONObject) r5.L$1;
        ImageInfo r19 = (ImageInfo) r5.L$0;
        ResultKt.throwOnFailure(r4);
        r11 = this;
        JSONObject r110 = r18;
        r0 = r7;
        ImageOperatorComponent r20 = r16;
        Object r21 = null;
    L256:
        r5.L$0 = r110;
        r5.L$1 = r17;
        r5.L$2 = r21;
        r5.L$3 = r21;
        r5.label = 9;
        r4 = r20.d((Message) r4, r19, r110, r5);
        if (r4 != r0) goto L259;
        return r0;
    L259:
        r1 = r17;
        r3 = r110;
        goto L260
    L15:
        ICreationMetadataService.Companion r22 = (ICreationMetadataService.Companion) r5.L$8;
        com.larus.bmhome.share.panel.h r23 = (com.larus.bmhome.share.panel.h) r5.L$7;
        Context r24 = (Context) r5.L$6;
        ICreationShareService.Companion r25 = (ICreationShareService.Companion) r5.L$5;
        String r26 = (String) r5.L$4;
        String r27 = (String) r5.L$3;
        Integer r111 = (Integer) r5.L$2;
        r110 = (JSONObject) r5.L$1;
        ImageInfo r112 = (ImageInfo) r5.L$0;
        ResultKt.throwOnFailure(r4);
    L16:
        com.larus.bmhome.share.panel.h r28 = r23;
        Context r113 = r24;
        ICreationShareService.Companion r114 = r25;
        String r29 = r26;
        String r115 = r27;
        Message r30 = (Message) r4;
        if (r110 == null) goto L127;
        String r31 = Boxing.boxInt(r110.optInt("position")).toString();
    L128:
        if (r110 == null) goto L130;
        String r32 = r110.optString("creation_task_id");
    L131:
        ICreationShareService.a.a(r114, r113, r115, null, null, r28, null, r22.I(r30, r32, r31), r111, r29, 140);
        Unit r33 = Unit.INSTANCE;
        r11 = this;
        r5 = r5;
        r19 = r112;
        Integer r34 = r111;
        r7 = r7;
    L252:
        Function1<Continuation<? super Message>, Object> r35 = c();
        r5 = r5;
        r5.L$0 = r19;
        r5.L$1 = r110;
        r5.L$2 = r34;
        r5.L$3 = r11;
        r21 = null;
        r5.L$4 = null;
        r5.L$5 = null;
        r5.L$6 = null;
        r5.L$7 = null;
        r5.L$8 = null;
        r5.label = 8;
        r4 = r35.invoke(r5);
        r0 = r7;
        if (r4 != r0) goto L255;
        return r0;
    L255:
        r17 = r34;
        r20 = r11;
        goto L256
    L130:
        r32 = null;
        goto L131
    L127:
        r31 = null;
        goto L128
    L17:
        com.larus.uaigc.chat.image.event.b r36 = (com.larus.uaigc.chat.image.event.b) r5.L$11;
        ImageShareClickMethod r37 = (ImageShareClickMethod) r5.L$10;
        df8.a r38 = (df8.a) r5.L$9;
        Integer r39 = (Integer) r5.L$8;
        JSONObject r40 = (JSONObject) r5.L$7;
        Context r41 = (Context) r5.L$6;
        ICreationShareService.Companion r116 = (ICreationShareService.Companion) r5.L$5;
        String r117 = (String) r5.L$4;
        String r118 = (String) r5.L$3;
        Integer r119 = (Integer) r5.L$2;
        JSONObject r49 = (JSONObject) r5.L$1;
        ImageInfo r50 = (ImageInfo) r5.L$0;
        ResultKt.throwOnFailure(r4);
        ImageInfo r120 = r50;
        Object r51 = r4;
        com.larus.uaigc.chat.image.event.b r52 = r36;
        JSONObject r53 = r49;
        String r310 = r117;
        Integer r121 = r39;
    L18:
        String r54 = r310;
        r23 = r52.c(r37, r38, r121, r40, (Message) r51);
        r26 = r54;
        r24 = r41;
        r25 = r116;
        r111 = r119;
        r27 = r118;
        r112 = r120;
        r110 = r53;
    L121:
        r22 = ICreationMetadataService.a;
        Function1<Continuation<? super Message>, Object> r55 = c();
        r5.L$0 = r112;
        r5.L$1 = r110;
        r5.L$2 = r111;
        r5.L$3 = r27;
        r5.L$4 = r26;
        r5.L$5 = r25;
        r5.L$6 = r24;
        r5.L$7 = r23;
        r5.L$8 = r22;
        r5.L$9 = null;
        r5.L$10 = null;
        r5.L$11 = null;
        r5.label = 7;
        r4 = r55.invoke(r5);
        if (r4 != r7) goto L16;
        return r7;
    L19:
        Context r56 = (Context) r5.L$6;
        ICreationShareService.Companion r57 = (ICreationShareService.Companion) r5.L$5;
        String r58 = (String) r5.L$4;
        String r59 = (String) r5.L$3;
        Integer r60 = (Integer) r5.L$2;
        JSONObject r61 = (JSONObject) r5.L$1;
        ImageInfo r122 = (ImageInfo) r5.L$0;
        ResultKt.throwOnFailure(r4);
        r118 = r59;
        r119 = r60;
        r40 = r61;
        r41 = r56;
        ImageInfo r62 = r122;
        r116 = r57;
    L106:
        df8.a r63 = (df8.a) r4;
        if (r63 == null) goto L120;
        r52 = com.larus.uaigc.chat.image.event.b.a;
        ImageShareClickMethod r64 = ImageShareClickMethod.OverviewClick;
        if (r119 == null) goto L111;
        String r123 = DataConverterKt.h(r119.intValue());
    L112:
        if (r123 == null) goto L115;
        r14 = r123;
    L115:
        r121 = Boxing.boxInt(ap8.a.d(r14));
        Function1<Continuation<? super Message>, Object> r65 = c();
        r5.L$0 = r62;
        r5.L$1 = r40;
        r5.L$2 = r119;
        r5.L$3 = r118;
        r5.L$4 = r58;
        r5.L$5 = r116;
        r5.L$6 = r41;
        r5.L$7 = r40;
        r5.L$8 = r121;
        r5.L$9 = r63;
        r5.L$10 = r64;
        r5.L$11 = r52;
        r120 = r62;
        r5.label = 6;
        r51 = r65.invoke(r5);
        if (r51 != r7) goto L118;
        return r7;
    L118:
        r53 = r40;
        r310 = r58;
        r38 = r63;
        r37 = r64;
        goto L18
    L111:
        r123 = null;
        goto L112
    L120:
        r25 = r116;
        r111 = r119;
        r112 = r62;
        r23 = null;
        JSONObject r311 = r40;
        r26 = r58;
        r24 = r41;
        r27 = r118;
        r110 = r311;
        goto L121
    L20:
        ImageOperatorComponent r66 = (ImageOperatorComponent) r5.L$7;
        Context r67 = (Context) r5.L$6;
        ICreationShareService.Companion r68 = (ICreationShareService.Companion) r5.L$5;
        String r69 = (String) r5.L$4;
        String r70 = (String) r5.L$3;
        Integer r71 = (Integer) r5.L$2;
        JSONObject r124 = (JSONObject) r5.L$1;
        ImageInfo r125 = (ImageInfo) r5.L$0;
        ResultKt.throwOnFailure(r4);
    L102:
        r5.L$0 = r125;
        r5.L$1 = r124;
        r5.L$2 = r71;
        r5.L$3 = r70;
        r5.L$4 = r69;
        r5.L$5 = r68;
        r5.L$6 = r67;
        Context r410 = r67;
        r5.L$7 = null;
        r5.label = 5;
        r4 = r66.d((Message) r4, r125, null, r5);
        if (r4 != r7) goto L105;
        return r7;
    L105:
        r118 = r70;
        r40 = r124;
        r62 = r125;
        r116 = r68;
        r58 = r69;
        r119 = r71;
        r41 = r410;
        goto L106
    L21:
        boolean r72 = r5.Z$0;
        Message r73 = (Message) r5.L$4;
        r34 = (Integer) r5.L$3;
        String r74 = (String) r5.L$2;
        JSONObject r126 = (JSONObject) r5.L$1;
        ImageInfo r127 = (ImageInfo) r5.L$0;
        ResultKt.throwOnFailure(r4);
        ImageInfo r128 = r127;
        r11 = this;
    L143:
        df8.a r75 = (df8.a) r4;
        if (r75 == null) goto L152;
        com.larus.uaigc.chat.image.event.b r76 = com.larus.uaigc.chat.image.event.b.a;
        ImageShareClickMethod r77 = ImageShareClickMethod.OverviewClick;
        if (r34 == null) goto L148;
        String r129 = DataConverterKt.h(r34.intValue());
    L149:
        if (r129 != null) goto L151;
        r129 = "";
    L151:
        com.larus.bmhome.share.panel.h r210 = r76.c(r77, r75, Boxing.boxInt(ap8.a.d(r129)), r126, r73);
    L153:
        FragmentActivity r78 = a().getContext();
        if ((r78 instanceof FragmentActivity) == false) goto L156;
        FragmentActivity r79 = r78;
    L157:
        if (r79 != null) goto L162;
        Activity r80 = AppHost.a.a().getCurrentActivity();
        if ((r80 instanceof FragmentActivity) == false) goto L161;
        r79 = (FragmentActivity) r80;
        goto L162
    L161:
        r79 = null;
    L162:
        if (r79 == null) goto L250;
        FragmentManager r81 = r79.getSupportFragmentManager();
        if (r81 == null) goto L250;
        if (r73 != null) goto L167;
    L169:
        boolean r82 = false;
    L170:
        if (r82 == false) goto L174;
        Image r83 = r128.c;
        if (r83 == null) goto L177;
        String r84 = r83.a;
    L178:
        if (r84 == null) goto L182;
        r14 = r84;
    L182:
        if (r14.length() != 0) goto L184;
        boolean r85 = true;
    L185:
        if (r85 == false) goto L191;
        Image r86 = r128.b;
        if (r86 == null) goto L189;
        String r87 = bz9.a.b(r86);
    L190:
        r14 = r87;
        goto L191
    L189:
        r87 = null;
    L191:
        String r130 = String.valueOf(r14);
        IFlowSdkDepend r88 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r88 == null) goto L250;
        r88.r0();
        e2 r89 = e2.a;
        Image r90 = r128.a;
        if (r90 == null) goto L196;
        String r91 = r90.a;
    L197:
        String r211 = String.valueOf(r91);
        Image r92 = r128.i;
        if (r92 == null) goto L200;
        String r212 = r92.a;
    L201:
        if (r73 != null) goto L203;
    L205:
        r9 = false;
    L206:
        if (r9 == true) goto L211;
        Image r93 = r128.d;
        if (r93 == null) goto L211;
        String r213 = r93.a;
    L212:
        ShareScene r214 = ShareScene.IMAGE_VIEWER_REPORT;
        Image r94 = r128.c;
        if (r94 == null) goto L215;
        long r215 = r94.d;
    L216:
        if (r94 == null) goto L218;
        long r216 = r94.c;
    L220:
        if (r72 == false) goto L222;
        String r95 = "download";
    L223:
        sq9.i r96 = new sq9.i(r95, r74, null, 4);
        ICreationMetadataService.Companion r97 = ICreationMetadataService.a;
        if (r126 == null) goto L226;
        String r98 = Boxing.boxInt(r126.optInt("position")).toString();
    L227:
        if (r126 == null) goto L229;
        String r99 = r126.optString("creation_task_id");
    L230:
        Map<String, String> r312 = r97.L(r97.I(r73, r99, r98), null);
        Image r100 = r128.a;
        if (r100 == null) goto L234;
        String r101 = r100.e;
        if (r101 == null) goto L234;
    L248:
        String r313 = r101;
    L249:
        r89.Z0(r81, new sq9.j(null, r130, r211, r212, r213, null, r210, r214, r216, r215, r96, r312, 0, null, r34, null, r313, 45089));
        Unit r102 = Unit.INSTANCE;
    L251:
        r19 = r128;
        r110 = r126;
    L234:
        Image r103 = r128.c;
        if (r103 == null) goto L237;
        r101 = r103.e;
    L238:
        if (r101 != null) goto L248;
        Image r104 = r128.b;
        if (r104 == null) goto L242;
        r101 = r104.e;
    L243:
        if (r101 != null) goto L248;
        Image r105 = r128.i;
        if (r105 == null) goto L247;
        r101 = r105.e;
        goto L248
    L247:
        r313 = null;
        goto L249
    L242:
        r101 = null;
        goto L243
    L237:
        r101 = null;
        goto L238
    L229:
        r99 = null;
        goto L230
    L226:
        r98 = null;
        goto L227
    L222:
        r95 = "share";
        goto L223
    L218:
        r216 = -1;
        goto L220
    L215:
        r215 = -1;
    L211:
        r213 = null;
        goto L212
    L203:
        if (ap8.a.c(r73) != true) goto L205;
    L200:
        r212 = null;
        goto L201
    L196:
        r91 = null;
        goto L197
    L184:
        r85 = false;
    L177:
        r84 = null;
        goto L178
    L174:
        Image r106 = r128.c;
        if (r106 == null) goto L177;
        r84 = bz9.a.b(r106);
        goto L178
    L167:
        if (com.larus.bmhome.chat.bean.d.a0(r73) != true) goto L169;
        r82 = true;
    L250:
        r5 = r5;
        r7 = r7;
        goto L251
    L156:
        r79 = null;
        goto L157
    L148:
        r129 = null;
        goto L149
    L152:
        r210 = null;
        goto L153
    L22:
        r72 = r5.Z$0;
        ImageOperatorComponent r107 = (ImageOperatorComponent) r5.L$5;
        Message r108 = (Message) r5.L$4;
        Integer r109 = (Integer) r5.L$3;
        String r131 = (String) r5.L$2;
        JSONObject r132 = (JSONObject) r5.L$1;
        r128 = (ImageInfo) r5.L$0;
        ResultKt.throwOnFailure(r4);
        r11 = this;
        ImageOperatorComponent r133 = r107;
        r73 = r108;
        r34 = r109;
        r74 = r131;
        r126 = r132;
    L140:
        r5.L$0 = r128;
        r5.L$1 = r126;
        r5.L$2 = r74;
        r5.L$3 = r34;
        r5.L$4 = r73;
        r5.L$5 = null;
        r5.Z$0 = r72;
        r5.label = 3;
        r4 = r133.d((Message) r4, r128, r126, r5);
        if (r4 != r7) goto L143;
        return r7;
    L23:
        r72 = r5.Z$0;
        Integer r134 = (Integer) r5.L$3;
        String r135 = (String) r5.L$2;
        JSONObject r136 = (JSONObject) r5.L$1;
        ImageInfo r137 = (ImageInfo) r5.L$0;
        ResultKt.throwOnFailure(r4);
        Integer r138 = r134;
        r2 = r136;
    L136:
        Message r139 = (Message) r4;
        Function1<Continuation<? super Message>, Object> r140 = c();
        r5.L$0 = r137;
        r5.L$1 = r2;
        r5.L$2 = r135;
        r5.L$3 = r138;
        r5.L$4 = r139;
        r11 = this;
        r5.L$5 = r11;
        r5.Z$0 = r72;
        r5.label = 2;
        Object r141 = r140.invoke(r5);
        if (r141 != r7) goto L139;
        return r7;
    L139:
        r128 = r137;
        r126 = r2;
        r73 = r139;
        r4 = r141;
        r74 = r135;
        r34 = r138;
        r133 = r11;
        goto L140
    L24:
        ResultKt.throwOnFailure(r4);
        if (r42 == null) goto L29;
        Image r142 = r42.a;
        if (r142 == null) goto L29;
        String r143 = r142.a;
    L30:
        if (r143 != null) goto L32;
    L35:
        boolean r144 = true;
    L36:
        if (r144 == false) goto L40;
        FLogger.a.e(getLogTag(), "doShareImage error because imageUrl is null or empty");
        return Unit.INSTANCE;
    L40:
        if (this.b == false) goto L43;
        FLogger.a.i(getLogTag(), "doShareImage return because isSharing is true");
        return Unit.INSTANCE;
    L43:
        this.b = true;
        if (r47 == true) goto L132;
        z2 r145 = z2.a;
        v1 r146 = r145.getCreationShareSettings().a();
        if (r146 != null) goto L48;
    L50:
        boolean r147 = false;
    L51:
        if (r147 == false) goto L76;
        v1 r148 = r145.getCreationShareSettings().a();
        if (r148 != null) goto L55;
    L57:
        boolean r149 = false;
    L58:
        if (r149 == false) goto L64;
        if (r46 != null) goto L62;
    L72:
        boolean r150 = true;
    L74:
        if (r150 == false) goto L76;
    L62:
        if (r46.intValue() != 5) goto L72;
    L73:
        r150 = false;
        goto L74
    L64:
        if (r46 != null) goto L67;
    L68:
        if (r46 == null) goto L72;
        if (r46.intValue() == 1) goto L73;
    L67:
        if (r46.intValue() == 5) goto L73;
    L55:
        if (r148.f() != true) goto L57;
        r149 = true;
    L76:
        if (r42 == null) goto L81;
        Image r151 = r42.a;
        if (r151 == null) goto L81;
        r69 = r151.e;
        if (r69 == null) goto L81;
    L98:
        ICreationShareService.Companion r152 = ICreationShareService.a;
        Context r153 = a().getContext();
        Function1<Continuation<? super Message>, Object> r154 = c();
        r5.L$0 = r42;
        r5.L$1 = r2;
        r5.L$2 = r46;
        r5.L$3 = r143;
        r5.L$4 = r69;
        r5.L$5 = r152;
        r5.L$6 = r153;
        r5.L$7 = this;
        r5.label = 4;
        Object r155 = r154.invoke(r5);
        if (r155 != r7) goto L101;
        return r7;
    L101:
        r125 = r42;
        r66 = this;
        r124 = r2;
        r67 = r153;
        r71 = r46;
        r68 = r152;
        r70 = r143;
        r4 = r155;
    L81:
        if (r42 == null) goto L85;
        Image r156 = r42.c;
        if (r156 == null) goto L85;
        r69 = r156.e;
    L86:
        if (r69 != null) goto L98;
        if (r42 == null) goto L91;
        Image r157 = r42.b;
        if (r157 == null) goto L91;
        r69 = r157.e;
    L92:
        if (r69 != null) goto L98;
        if (r42 == null) goto L97;
        Image r158 = r42.i;
        if (r158 == null) goto L97;
        r69 = r158.e;
    L97:
        r69 = null;
    L91:
        r69 = null;
    L85:
        r69 = null;
        goto L86
    L48:
        if (r146.e() != true) goto L50;
        r147 = true;
    L132:
        Function1<Continuation<? super Message>, Object> r159 = c();
        r5.L$0 = r42;
        r5.L$1 = r2;
        r5.L$2 = r44;
        r5.L$3 = r46;
        r5.Z$0 = r45;
        r5.label = 1;
        Object r160 = r159.invoke(r5);
        if (r160 != r7) goto L135;
        return r7;
    L135:
        r137 = r42;
        r72 = r45;
        r4 = r160;
        r138 = r46;
        r135 = r44;
        goto L136
    L32:
        if (r143.length() == 0) goto L35;
        r144 = false;
    L29:
        r143 = null;
        goto L30
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r5 = new ImageOperatorComponent$shareImage$1(this, r48);
        goto L8
    }
}
