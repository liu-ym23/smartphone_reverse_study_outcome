package com.larus.uaigc.helper;

import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/helper/CreationImagePreprocessHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationImagePreprocessHandler implements ResourceNodeHandler {
    public final String a;
    public final String b;

    public final void getPriority() {
    }

    public CreationImagePreprocessHandler() {
        this.a = "creation_image_preprocess";
        this.b = "preprocess";
    }

    public final String a() {
        return this.b;
    }

    public final String getKey() {
        return this.a;
    }

    public final boolean b(com.larus.bmhome.resource.access.h0 r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (a0.b(r4) == true) goto L6;
        return false;
    L6:
        if (r4.a.c == ResourceMediaType.IMAGE) goto L8;
        return false;
    L8:
        com.larus.bmhome.resource.access.j0 r0 = r4.c;
        if ((r0 instanceof com.larus.bmhome.resource.access.j0.a) == false) goto L12;
        return true;
    L12:
        if ((r0 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L15;
        return a0.a(r4, "enable_preprocess", new j());
    L15:
        if ((r0 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L17;
        return false;
    L17:
        if ((r0 instanceof com.larus.bmhome.resource.access.j0.d) == false) goto L20;
        return false;
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public final Object c(com.larus.bmhome.resource.access.h0 r49, Continuation<? super com.larus.bmhome.resource.access.g> r50) {
        com.larus.bmhome.resource.access.h0 r1 = r49;
        if ((r50 instanceof CreationImagePreprocessHandler$execute$1) == false) goto L7;
        CreationImagePreprocessHandler$execute$1 r3 = (CreationImagePreprocessHandler$execute$1) r50;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        com.larus.bmhome.resource.access.j0 r7 = (com.larus.bmhome.resource.access.j0) r3.L$1;
        com.larus.bmhome.resource.access.h0 r8 = (com.larus.bmhome.resource.access.h0) r3.L$0;
        ResultKt.throwOnFailure(r2);
        com.larus.bmhome.resource.access.j0 r9 = r7;
        r1 = r8;
        Object r10 = r2;
    L26:
        ic8.n0 r11 = (ic8.n0) r10;
        ic8.m0 r12 = r11.a;
        ProcessFileResultCode r13 = r11.b;
        if (r13 != null) goto L29;
    L31:
        boolean r14 = false;
    L32:
        if (r14 == false) goto L156;
        if (r12 == null) goto L35;
        String r15 = r12.e;
    L36:
        if (r15 != null) goto L38;
    L41:
        boolean r16 = true;
    L42:
        if (r16 == true) goto L156;
        if (r12 == null) goto L45;
        String r17 = r12.e;
    L46:
        String r18 = "";
        if (r17 != null) goto L49;
        r17 = "";
    L49:
        if (r12 == null) goto L54;
        String r19 = r12.a;
        if (r19 == null) goto L54;
        String r110 = r19;
    L55:
        int r20 = g.a;
        if (r12 == null) goto L58;
        String r21 = r12.a;
    L59:
        Boolean r111 = Boxing.boxBoolean(g.b(r21));
        if (r12 == null) goto L67;
        Long r22 = Boxing.boxLong(r12.c);
        if (r22.longValue() < 0) goto L64;
        boolean r112 = true;
    L65:
        if (r112 == false) goto L67;
        Long r113 = r22;
    L68:
        if (r12 == null) goto L70;
        mr9.c r114 = r12.l;
    L71:
        com.larus.bmhome.resource.access.j0.b r23 = new com.larus.bmhome.resource.access.j0.b(r17, r110, r111, r113, r114);
        if (r12 == null) goto L74;
        mr9.c r27 = r12.l;
    L75:
        if (r12 == null) goto L82;
        Long r115 = Boxing.boxLong(r12.c);
        if (r115.longValue() < 0) goto L79;
        boolean r116 = true;
    L80:
        if (r116 == false) goto L82;
        Long r28 = r115;
    L83:
        mr9.h r117 = r1.f;
        String r118 = r1.a.d.a;
        Set<String> r119 = i.a;
        UplinkFileEntity r120 = r117.c;
        if (r120 == null) goto L91;
        UplinkEntityContent r121 = r120.getUplinkEntityContent();
        if (r121 == null) goto L91;
        Image r122 = r121.getUplinkImageInfo();
        if (r122 == null) goto L91;
        File r123 = new PolarisFileWrapper(r17);
        BitmapFactory.Options r24 = new BitmapFactory.Options();
        r24.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r17, r24);
        int r25 = r24.outWidth;
        if (r25 > 0) goto L95;
    L97:
        Pair r26 = null;
    L98:
        if (r26 == null) goto L104;
        int r124 = ((Number) r26.component1()).intValue();
        int r125 = ((Number) r26.component2()).intValue();
        ImageObj r29 = r122.imageOri;
        if (r29 != null) goto L102;
        r29 = new ImageObj(null, 0, 0, null, null, 31, null);
    L102:
        ImageObj r30 = ImageObj.copy$default(r29, null, r124, r125, null, null, 25, null);
        if (r30 == null) goto L104;
    L105:
        if (r12 == null) goto L108;
        String r31 = r12.f;
        if (r31 == null) goto L108;
    L109:
        String r32 = r122.identifier;
        if (r32 != null) goto L112;
        String r126 = r118;
    L113:
        Map r33 = r122.ext;
        if (r33 != null) goto L116;
        r33 = MapsKt.emptyMap();
    L116:
        if (r12 == null) goto L120;
        File r127 = r123;
        if (r12.i != true) goto L121;
        boolean r128 = true;
    L122:
        if (r128 == false) goto L124;
        String r129 = "1";
    L125:
        Map r130 = MapsKt.plus(r33, MapsKt.mapOf(TuplesKt.to("is_marked", r129)));
        File r34 = r127;
        Image r35 = Image.copy$default(r122, null, r31, null, r30, null, r17, r126, r130, null, null, null, null, null, null, 16149, null);
        Uri r40 = Uri.fromFile(r34);
        mr9.h r210 = mr9.h.a(r117, UplinkFileEntity.copy$default(r120, null, UplinkEntityContent.copy$default(r121, null, r35, 1, null), null, null, null, null, null, null, null, false, r40, null, null, null, 15357, null));
    L126:
        String r131 = StringsKt.substringAfterLast(r17, '.', "");
        if (r131.length() <= 0) goto L129;
        boolean r36 = true;
    L130:
        if (r36 == true) goto L133;
        r131 = null;
    L133:
        if (r131 != null) goto L135;
        String r211 = r1.g;
    L136:
        Pair[] r37 = new Pair[3];
        ProcessFileResultCode r38 = r11.b;
        if (r38 == null) goto L139;
        String r132 = r38.getValue();
    L140:
        if (r132 != null) goto L142;
        r132 = "";
    L142:
        r37[0] = TuplesKt.to("preprocess_result", r132);
        if (r12 == null) goto L145;
        String r133 = Boxing.boxLong(r12.c).toString();
    L146:
        if (r133 != null) goto L148;
        r133 = "";
    L148:
        r37[1] = TuplesKt.to("preprocess_file_size", r133);
        if (r12 == null) goto L151;
        String r39 = r12.d;
    L152:
        if (r39 == null) goto L155;
        r18 = r39;
    L155:
        r37[2] = TuplesKt.to("preprocess_file_type", r18);
        mr9.c r212 = r27;
        Long r213 = r28;
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(r23, r212, r213, r210, r211, null, MapsKt.mapOf(r37), 32));
    L151:
        r39 = null;
        goto L152
    L145:
        r133 = null;
        goto L146
    L139:
        r132 = null;
        goto L140
    L135:
        r211 = r131;
        goto L136
    L129:
        r36 = false;
        goto L130
    L124:
        r129 = "0";
    L121:
        r128 = false;
        goto L122
    L120:
        r127 = r123;
        goto L121
    L112:
        r126 = r32;
    L108:
        ImFileUtil.a.getClass();
        r31 = ImFileUtil.g(r123);
    L104:
        r30 = r122.imageOri;
        goto L105
    L95:
        if (r24.outHeight <= 0) goto L97;
        r26 = TuplesKt.to(Integer.valueOf(r25), Integer.valueOf(r24.outHeight));
    L91:
        r210 = r117;
        goto L126
    L79:
        r116 = false;
    L82:
        r28 = null;
        goto L83
    L74:
        r27 = null;
        goto L75
    L70:
        r114 = null;
        goto L71
    L64:
        r112 = false;
    L67:
        r113 = null;
        goto L68
    L58:
        r21 = null;
    L54:
        r110 = r9.a();
        goto L55
    L45:
        r17 = null;
        goto L46
    L38:
        if (r15.length() == 0) goto L41;
        r16 = false;
        goto L42
    L35:
        r15 = null;
    L156:
        String r41 = this.b;
        ProcessFileResultCode r42 = r11.b;
        if (r42 == null) goto L160;
        String r43 = r42.getValue();
        if (r43 == null) goto L160;
    L162:
        return new com.larus.bmhome.resource.access.g.b(new com.larus.bmhome.resource.access.r(r41, r43, "creation image preprocess failed", null));
    L160:
        r43 = ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR.getValue();
        goto L162
    L29:
        if (r13.isSuccess() != true) goto L31;
        r14 = true;
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r9 = r1.c;
        if ((r9 instanceof com.larus.bmhome.resource.access.j0.a) == false) goto L18;
        Uri r44 = UriProtector.parse(((com.larus.bmhome.resource.access.j0.a) r9).b);
    L20:
        String r45 = r1.a.d.d;
        if (r45 != null) goto L23;
        r45 = "ai_creation";
    L23:
        CreationImageUploadPolicy r46 = CreationImageUploadPolicy.a;
        Intrinsics.checkNotNull(r44);
        String r47 = (String) r49.b().get("preprocess_sub_scene");
        r3.L$0 = r1;
        r3.L$1 = r9;
        r3.label = 1;
        r10 = r46.a(r44, r45, r47, r3);
        if (r10 != r5) goto L26;
        return r5;
    L18:
        if ((r9 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L164;
        r44 = Uri.fromFile(new PolarisFileWrapper(((com.larus.bmhome.resource.access.j0.b) r9).b));
        goto L20
    L164:
        if ((r9 instanceof com.larus.bmhome.resource.access.j0.c) == true) goto L171;
        if ((r9 instanceof com.larus.bmhome.resource.access.j0.d) == true) goto L171;
        throw new NoWhenBranchMatchedException();
    L171:
        return com.larus.bmhome.resource.access.g.e.a;
    L7:
        r3 = new CreationImagePreprocessHandler$execute$1(this, r50);
        goto L8
    }
}
