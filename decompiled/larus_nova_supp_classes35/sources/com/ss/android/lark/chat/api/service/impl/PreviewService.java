package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.RequestPacket;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.GenerateUrlPreviewEntityRequest;
import com.bytedance.lark.pb.im.v1.HideMessageUrlPreviewRequest;
import com.bytedance.lark.pb.url.v1.GetURLPreviewTemplatesByIdsRequest;
import com.bytedance.lark.pb.url.v1.GetURLPreviewTemplatesByIdsResponse;
import com.bytedance.lark.pb.url.v1.GetUrlPreviewRequest;
import com.bytedance.lark.pb.url.v1.MGetUrlPreviewRequest;
import com.bytedance.lark.pb.url.v1.UrlPreviewSourceType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.preview.entity.UrlPreviewResponse;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class PreviewService implements a2b.f {
    public static final Lazy<PreviewService> c = null;
    public final a2b.e a;
    public final AndroidThrottle<u0> b;

    public static final class a {
    }

    public static final class b<T> implements SdkSender.IParser {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object parse(byte[] r2) {
            return (GetURLPreviewTemplatesByIdsResponse) GetURLPreviewTemplatesByIdsResponse.ADAPTER.decode(r2);
        }
    }

    public static final class c<T> implements AndroidThrottle.e {
        public final /* synthetic */ PreviewService a;

        public c(PreviewService r1) {
            this.a = r1;
        }

        public final void a(Collection<u0> r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            PreviewService r0 = this.a;
            r0.getClass();
            if (r4.isEmpty() == true) goto L7;
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new b1(r0, r4));
            return;
        }
    }

    static {
        c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PreviewService$Companion$instance$2.INSTANCE);
    }

    @Inject
    public PreviewService(a2b.e r3) {
        Intrinsics.checkNotNullParameter(r3, "repo");
        this.a = r3;
        AndroidThrottle.a r4 = new AndroidThrottle.a();
        r4.b = 600;
        r4.c = 2;
        r4.a = CoreThreadPool.getNonblockingHandler();
        r4.d = new s0();
        r4.e = new c(this);
        this.b = r4.a();
    }

    @Override // a2b.f
    public final void Fa(PullUrlPreviewRequest r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Log.d("[URLPreview] PreviewService", "lazy load request " + ((String) r3.b.getValue()));
        if ((!r3.a.isEmpty()) == false) goto L6;
        this.b.d(new u0(r3));
        return;
    }

    @Override // a2b.f
    public final void ba(final a2b.b r4, IGetDataCallback<a2b.b> r5) {
        Intrinsics.checkNotNullParameter(r4, "urlPreview");
        Intrinsics.checkNotNullParameter(r5, "uiCallback");
        String r0 = r4.a;
        HideMessageUrlPreviewRequest.Builder r1 = new HideMessageUrlPreviewRequest.Builder().message_id(r0);
        a2b.e r2 = this.a;
        Intrinsics.checkNotNull(r1);
        r2.c(r1, new PreviewService$deleteMessageUrlPreview$1(r4), r5);
    }

    @Override // a2b.f
    public final void getUrlInlineFromContent(String r3, IGetDataCallback<UrlInlinePreviewEntity> r4) {
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Log.i("[URLPreview] GenerateUrlPreviewEntityRequest", "start, content.length:" + r3.length());
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        GenerateUrlPreviewEntityRequest.Builder r5 = new GenerateUrlPreviewEntityRequest.Builder().url(r3);
        a2b.e r1 = this.a;
        Intrinsics.checkNotNull(r5);
        r1.b(r5, AnonymousClass1.INSTANCE, r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // a2b.f
    public final void lc(List<String> r3, final Map<String, ? extends Map<String, UrlCardPreviewEntity>> r4) {
        Intrinsics.checkNotNullParameter(r3, "templateIdList");
        Intrinsics.checkNotNullParameter(r4, "messagePreviewMap");
        if (CollectionUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder("start, templateIds:");
        k6b.a r1 = k6b.a.a;
        r0.append(k6b.a.d(r3));
        Log.i("[URLPreview] GetURLPreviewTemplatesByIdsRequest", r0.toString());
        GetURLPreviewTemplatesByIdsRequest.Builder r5 = new GetURLPreviewTemplatesByIdsRequest.Builder().template_ids(r3);
        SdkSender.asynSendRequestNonWrap(Command.GET_URL_PREVIEW_TEMPLATES_BY_IDS, r5, new PreviewService$getUrlTemplateList$1(this, r4), b.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.ss.android.lark.chat.api.service.impl.PreviewService$getUrlPreViewEntityList$2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // a2b.f
    public final void r4(final List<String> r7, final List<String> r8, SyncDataStrategy r9, final UrlPreViewEntries.UrlPreViewSourceType r10, List<Long> r11, final UIGetDataCallback<UrlPreviewResponse> r12) {
        Intrinsics.checkNotNullParameter(r7, "sourceIdList");
        Intrinsics.checkNotNullParameter(r8, "sourceTextMD5List");
        Intrinsics.checkNotNullParameter(r9, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r10, "sourceType");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        if (r8.isEmpty() == true) goto L22;
        ArrayList r0 = new ArrayList();
        int r1 = Math.min(r8.size(), r7.size());
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L15;
        GetUrlPreviewRequest.Builder r3 = new GetUrlPreviewRequest.Builder().source_id((String) ListProtector.get(r7, r2)).source_type(UrlPreviewSourceType.fromValue(r10.getValue())).source_text_md5((String) ListProtector.get(r8, r2));
        if (r11 == null) goto L14;
        Long r4 = (Long) CollectionsKt.getOrNull(r11, r2);
        if (r4 == null) goto L14;
        r3.private_description_id(Long.valueOf(r4.longValue()));
    L14:
        r0.add(r3.build());
        Log.i("[URLPreview] MGetUrlPreviewRequest", "start ,sourceID:" + ((String) ListProtector.get(r7, r2)) + ", sourceTextMD5:" + ((String) ListProtector.get(r8, r2)) + ", sourceType:" + r10.getValue());
        r2 = r2 + 1;
        goto L8
    L15:
        MGetUrlPreviewRequest.Builder r13 = new MGetUrlPreviewRequest.Builder().sync_data_strategy(r9).reqs(r0);
        com.ss.android.lark.sdk.h r14 = new com.ss.android.lark.sdk.h();
        r14.d = RequestPacket.TrafficType.HIGH_PRIORITY;
        a2b.e r5 = this.a;
        Intrinsics.checkNotNull(r13);
        r5.d(r13, r14, new PreviewService$getUrlPreViewEntityList$2(r12, r7, r8, r10));
        return;
    }
}
