package com.larus.bmhome.rc;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import mr9.l;
import mr9.n;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResourceCenterPostUploadSupport {
    public static final ResourceCenterPostUploadSupport a = null;

    static {
        a = new ResourceCenterPostUploadSupport();
    }

    public ResourceCenterPostUploadSupport() {
    }

    public static Map c(ResourceCenterPostUploadSupport r2, String r3, String r4, Long r5, Integer r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = null;
    L8:
        r2.getClass();
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("api_name", "resource_register"), TuplesKt.to("api_path", "/alice/resource/register"), TuplesKt.to("error_type", r3), TuplesKt.to("fail_reason", r4), TuplesKt.to("server_error_code", r5), TuplesKt.to("network_error_code", r6)});
    }

    public final Object a(l r37, UplinkFileEntity r38, ResourceAttachmentExtra r39, String r40, String r41, FlowResourceType r42, ResourceInstantUploadInfo r43, Long r44, Continuation<? super ResourceRegisterData> r45) {
        String r1 = r40;
        if ((r45 instanceof ResourceCenterPostUploadSupport$register$1) == false) goto L7;
        ResourceCenterPostUploadSupport$register$1 r4 = (ResourceCenterPostUploadSupport$register$1) r45;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        String r11 = null;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        String r0 = (String) r4.L$2;
        String r2 = (String) r4.L$1;
        String r8 = (String) r4.L$0;
        ResultKt.throwOnFailure(r3);
        boolean r9 = true;
        String r10 = r2;
        r1 = r8;
        Object r12 = r3;
    L151:
        dm9.a.b r13 = (dm9.a) r12;
        if ((r13 instanceof dm9.a.a) == false) goto L154;
        FLogger.a.e("ResourceCenterPostUpload", "[register] failed, sceneId=" + r1 + ", resp=" + r13);
        StringBuilder r14 = new StringBuilder();
        dm9.a.a r15 = (dm9.a.a) r13;
        r14.append(r15.a);
        r14.append(':');
        r14.append(r15.b);
        throw new ResourceRegisterTraceError(new ResourceUploadError("upload_resource_register_error", r14.toString()), c(this, "network", "network_error", null, Boxing.boxInt(r15.a), 4));
    L154:
        if ((r13 instanceof dm9.a.b) == false) goto L181;
        dm9.a.b r16 = r13;
        if (r16.a.isSuccess() == true) goto L162;
        FLogger.a.e("ResourceCenterPostUpload", "[register] biz failed, sceneId=" + r1 + ", resp=" + r13);
        StringBuilder r17 = new StringBuilder("register biz failed, code=");
        r17.append(r16.a.getCode());
        r17.append(", msg=");
        String r18 = r16.a.getMsg();
        if (r18 != null) goto L160;
        r18 = "";
    L160:
        r17.append(r18);
        throw new ResourceRegisterTraceError(new ResourceUploadError("upload_resource_register_error", r17.toString()), c(this, "biz", "biz_fail", Boxing.boxLong(r16.a.getCode()), null, 8));
    L162:
        Map r19 = (Map) r16.a.getData();
        if (r19 == null) goto L165;
        ResourceRegisterData r20 = (ResourceRegisterData) r19.get(r0);
    L166:
        if (r20 == null) goto L169;
        r11 = r20.getResourceId();
    L169:
        if (r20 == null) goto L178;
        if (r11 != null) goto L172;
    L175:
        if (r9 == true) goto L178;
        FLogger.a.i("ResourceCenterPostUpload", "[register] success, registerUri=" + r0 + ", resourceId=" + r11 + ", aliasName=" + r20.getAliasName() + ", sceneId=" + r1);
        return r20;
    L172:
        if (r11.length() == 0) goto L175;
        r9 = false;
    L178:
        FLogger.a.e("ResourceCenterPostUpload", "[register] resourceId empty, registerUri=" + r0 + ", tosKey=" + r10 + ", sceneId=" + r1 + ", response=" + r19);
        throw new ResourceRegisterTraceError(new ResourceUploadError("upload_resource_register_error", "register resourceId is empty"), c(this, "response", "empty_resource_id", null, null, 12));
    L165:
        r20 = null;
        goto L166
    L181:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        if (r43 != null) goto L36;
        ConcurrentHashMap<String, ResourceInstantUploadInfo> r21 = com.larus.bmhome.upload.instant.f.a;
        if (r41 != null) goto L21;
        if (r38 == null) goto L20;
        String r22 = r38.getFileIdentifier();
    L22:
        if (r22 != null) goto L24;
    L35:
        ResourceInstantUploadInfo r23 = null;
    L37:
        r10 = r37.a;
        if (r10 == null) goto L185;
        String r110 = f.a(r23, r10);
        Integer r111 = Boxing.boxInt(r42.getValue());
        String r112 = r39.getBotId();
        String r24 = r39.getLocalMessageId();
        if (l1.j(r38) == false) goto L69;
        if (r38 == null) goto L48;
        UplinkEntityContent r25 = r38.getUplinkEntityContent();
        if (r25 == null) goto L48;
        UplinkFileInfo r26 = r25.getUplinkFileInfo();
        if (r26 == null) goto L48;
        String r113 = r26.getFileName();
    L49:
        if (r38 == null) goto L55;
        UplinkEntityContent r27 = r38.getUplinkEntityContent();
        if (r27 == null) goto L55;
        UplinkFileInfo r28 = r27.getUplinkFileInfo();
        if (r28 == null) goto L55;
        String r114 = r28.getMd5();
    L56:
        if (r38 == null) goto L58;
        String r115 = r38.getFileIdentifier();
    L60:
        if (r38 == null) goto L66;
        UplinkEntityContent r29 = r38.getUplinkEntityContent();
        if (r29 == null) goto L66;
        UplinkFileInfo r30 = r29.getUplinkFileInfo();
        if (r30 == null) goto L66;
        Long r210 = r30.getSize();
    L67:
        FlowResourceMeta r31 = new FlowResourceMeta(new FileResourceMeta(r113, r114, r115, null, r210, null, 40, null), null, null, null, null, null, 62, null);
    L142:
        FlowResourceMeta r32 = f.b(r31, r23, r44);
        if (r38 == null) goto L146;
        String r33 = r38.getFileIdentifier();
        if (r33 == null) goto L146;
    L147:
        FlowResource r116 = new FlowResource(r110, r111, r32, r33);
        ResourceCenter r34 = ResourceCenter.a;
        List<FlowResource> r35 = CollectionsKt.listOf(r116);
        r4.L$0 = r1;
        r4.L$1 = r10;
        r4.L$2 = r110;
        r9 = true;
        r4.label = 1;
        Object r36 = r34.l(r35, r39, r1, r4);
        if (r36 != r6) goto L150;
        return r6;
    L150:
        r12 = r36;
        r0 = r110;
    L146:
        r33 = r41;
    L66:
        r210 = null;
        goto L67
    L58:
        r115 = null;
    L55:
        r114 = null;
    L48:
        r113 = null;
        goto L49
    L69:
        if (l1.i(r38) == true) goto L71;
        if (r38 == null) goto L105;
        Integer r46 = r38.getEntityType();
        int r47 = UplinkEntityType.EntityTypeImage.getValue();
        if (r46 == null) goto L105;
        if (r46.intValue() != r47) goto L105;
        boolean r48 = true;
    L106:
        if (r48 == false) goto L108;
    L128:
        if (r38 == null) goto L131;
        String r49 = r38.getFileIdentifier();
        if (r49 == null) goto L131;
    L133:
        if (r38 == null) goto L139;
        UplinkEntityContent r50 = r38.getUplinkEntityContent();
        if (r50 == null) goto L139;
        Image r51 = r50.getUplinkImageInfo();
        if (r51 == null) goto L139;
        r51.identifier = r49;
    L140:
        FlowResourceMeta r52 = new FlowResourceMeta(null, new ImageResourceMeta(r51, null, 2, null), null, null, null, null, 61, null);
    L141:
        r31 = r52;
    L139:
        r51 = null;
    L131:
        r49 = r41;
        goto L133
    L108:
        if (r42 == FlowResourceType.Image) goto L128;
        if (l1.n(r38) == false) goto L113;
    L117:
        n r53 = r37.e;
        if (r53 == null) goto L120;
        String r54 = r53.a;
    L121:
        if (r53 == null) goto L123;
        String r117 = r53.b;
    L124:
        if (r53 == null) goto L126;
        mr9.e r55 = r53.c;
    L127:
        r52 = new FlowResourceMeta(null, null, null, new VideoResourceMeta(r54, r117, r55), null, null, 55, null);
        goto L141
    L126:
        r55 = null;
        goto L127
    L123:
        r117 = null;
        goto L124
    L120:
        r54 = null;
        goto L121
    L113:
        if (r42 == FlowResourceType.Video) goto L117;
        r31 = new FlowResourceMeta(null, null, null, null, null, null, 63, null);
    L105:
        r48 = false;
        goto L106
    L71:
        if (r38 == null) goto L77;
        UplinkEntityContent r118 = r38.getUplinkEntityContent();
        if (r118 == null) goto L77;
        UplinkFileInfo r119 = r118.getUplinkFileInfo();
        if (r119 == null) goto L77;
        String r211 = r119.getFileName();
    L78:
        if (r38 == null) goto L84;
        UplinkEntityContent r120 = r38.getUplinkEntityContent();
        if (r120 == null) goto L84;
        UplinkFileInfo r121 = r120.getUplinkFileInfo();
        if (r121 == null) goto L84;
        String r212 = r121.getMd5();
    L85:
        if (r38 == null) goto L87;
        String r213 = r38.getFileIdentifier();
    L89:
        if (r38 == null) goto L95;
        UplinkEntityContent r122 = r38.getUplinkEntityContent();
        if (r122 == null) goto L95;
        UplinkFileInfo r123 = r122.getUplinkFileInfo();
        if (r123 == null) goto L95;
        Long r214 = r123.getSize();
    L96:
        r31 = new FlowResourceMeta(null, null, new AudioResourceMeta(r211, r212, r213, null, r214, new AudioResourceParseExtra(r112, r24), 8, null), null, null, null, 59, null);
    L95:
        r214 = null;
        goto L96
    L87:
        r213 = null;
    L84:
        r212 = null;
    L77:
        r211 = null;
        goto L78
    L185:
        throw new ResourceUploadError("upload_resource_register_error", "register skipped because tosKey is null");
    L24:
        if (r22.length() <= 0) goto L26;
        boolean r56 = true;
    L27:
        if (r56 == true) goto L30;
        r22 = null;
    L30:
        if (r22 == null) goto L35;
        r23 = com.larus.bmhome.upload.instant.f.a.remove(r22);
        if (r23 == null) goto L35;
        FLogger.a.d("ImageInstantUpload", "consume register info, key=" + r22 + ", info=" + com.larus.bmhome.upload.instant.f.d(r23));
        goto L37
    L26:
        r56 = false;
        goto L27
    L20:
        r22 = null;
        goto L22
    L21:
        r22 = r41;
        goto L22
    L36:
        r23 = r43;
    L7:
        r4 = new ResourceCenterPostUploadSupport$register$1(this, r45);
        goto L8
    }

    public static /* synthetic */ Object b(l r10, UplinkFileEntity r11, ResourceAttachmentExtra r12, String r13, String r14, FlowResourceType r15, ResourceInstantUploadInfo r16, Long r17, Continuation r18, int r19) {
        ResourceCenterPostUploadSupport r1 = a;
        if ((r19 & 16) == 0) goto L8;
        if (r11 == null) goto L6;
        String r2 = r11.getFileIdentifier();
    L7:
        String r5 = r2;
    L10:
        if ((r19 & 32) == 0) goto L12;
        FlowResourceType r6 = mr9.a.a(r11);
    L14:
        if ((r19 & 64) == 0) goto L16;
        ResourceInstantUploadInfo r7 = null;
    L18:
        if ((r19 & 128) == 0) goto L20;
        Long r8 = null;
    L22:
        return r1.a(r10, r11, r12, r13, r5, r6, r7, r8, r18);
    L20:
        r8 = r17;
        goto L22
    L16:
        r7 = r16;
        goto L18
    L12:
        r6 = r15;
        goto L14
    L6:
        r2 = null;
        goto L7
    L8:
        r5 = r14;
        goto L10
    }
}
