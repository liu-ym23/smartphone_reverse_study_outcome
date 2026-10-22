package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.im.v1.GenerateUrlPreviewEntityRequest;
import com.bytedance.lark.pb.im.v1.GenerateUrlPreviewEntityResponse;
import com.bytedance.lark.pb.im.v1.GetMessagePreviewsRequest;
import com.bytedance.lark.pb.im.v1.GetMessagePreviewsResponse;
import com.bytedance.lark.pb.im.v1.HideMessageUrlPreviewRequest;
import com.bytedance.lark.pb.im.v1.HideMessageUrlPreviewResponse;
import com.bytedance.lark.pb.url.v1.MGetUrlPreviewRequest;
import com.bytedance.lark.pb.url.v1.MGetUrlPreviewResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class PreviewRepositoryV2 implements a2b.e {
    public final com.bytedance.lark.rustclient.api.l a;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ Function1<GenerateUrlPreviewEntityResponse, UrlInlinePreviewEntity> a;

        public a(Function1<? super GenerateUrlPreviewEntityResponse, UrlInlinePreviewEntity> r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (UrlInlinePreviewEntity) this.a.invoke(r3.c);
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ Function1<HideMessageUrlPreviewResponse, a2b.b> a;

        public b(Function1<? super HideMessageUrlPreviewResponse, ? extends a2b.b> r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (a2b.b) this.a.invoke(r3.c);
        }
    }

    @Inject
    public PreviewRepositoryV2(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    @Override // a2b.e
    public final Pair<Map<String, Map<String, UrlCardPreviewEntity>>, LinkedHashMap<String, MessageLink>> a(GetMessagePreviewsRequest.Builder r11, final Function1<? super GetMessagePreviewsResponse, ? extends Pair<? extends Map<String, ? extends Map<String, UrlCardPreviewEntity>>, ? extends LinkedHashMap<String, MessageLink>>> r12, final Function1<? super ErrorResult, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, GetMessagePreviewsResponse.ADAPTER, Command.GET_MESSAGE_PREVIEWS, null, null, null, null, 248);
        return (Pair) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.a.h(r0).execute(), new PreviewRepositoryV2$getMessagePreviews$1(r12)), new PreviewRepositoryV2$getMessagePreviews$2(r13));
    }

    @Override // a2b.e
    public final void b(GenerateUrlPreviewEntityRequest.Builder r11, Function1<? super GenerateUrlPreviewEntityResponse, UrlInlinePreviewEntity> r12, IGetDataCallback<UrlInlinePreviewEntity> r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, GenerateUrlPreviewEntityResponse.ADAPTER, Command.GENERATE_URL_PREVIEW_ENTITY, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a()).map(new a(r12)), r13);
    }

    @Override // a2b.e
    public final void c(HideMessageUrlPreviewRequest.Builder r11, Function1<? super HideMessageUrlPreviewResponse, ? extends a2b.b> r12, IGetDataCallback<a2b.b> r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, HideMessageUrlPreviewResponse.ADAPTER, Command.HIDE_MESSAGE_URL_PREVIEW, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a()).map(new b(r12)), r13);
    }

    @Override // a2b.e
    public final void d(MGetUrlPreviewRequest.Builder r11, com.ss.android.lark.sdk.h r12, PreviewService$getUrlPreViewEntityList$2 r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, MGetUrlPreviewResponse.ADAPTER, Command.MGET_URL_PREVIEW, null, r12, null, null, 216);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a()).map(a1.a), r13);
    }
}
