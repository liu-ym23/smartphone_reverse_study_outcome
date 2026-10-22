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
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.sdk.SdkSender;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y0 implements a2b.e {

    public static final class a<T> implements SdkSender.IParser {
        public final /* synthetic */ Function1<GenerateUrlPreviewEntityResponse, UrlInlinePreviewEntity> a;

        public a(Function1<? super GenerateUrlPreviewEntityResponse, UrlInlinePreviewEntity> r1) {
            this.a = r1;
        }

        public final Object parse(byte[] r3) {
            return (UrlInlinePreviewEntity) this.a.invoke(GenerateUrlPreviewEntityResponse.ADAPTER.decode(r3));
        }
    }

    public static final class b<T> implements SdkSender.IParser {
        public final /* synthetic */ Function1<GetMessagePreviewsResponse, Pair<Map<String, Map<String, UrlCardPreviewEntity>>, LinkedHashMap<String, MessageLink>>> a;

        public b(Function1<? super GetMessagePreviewsResponse, ? extends Pair<? extends Map<String, ? extends Map<String, UrlCardPreviewEntity>>, ? extends LinkedHashMap<String, MessageLink>>> r1) {
            this.a = r1;
        }

        public final Object parse(byte[] r3) {
            ProtoAdapter r0 = GetMessagePreviewsResponse.ADAPTER;
            r0.decode(r3);
            return (Pair) this.a.invoke(r0.decode(r3));
        }
    }

    public static final class c<T> implements SdkSender.IParser {
        public final /* synthetic */ Function1<HideMessageUrlPreviewResponse, a2b.b> a;

        public c(Function1<? super HideMessageUrlPreviewResponse, ? extends a2b.b> r1) {
            this.a = r1;
        }

        public final Object parse(byte[] r3) {
            return (a2b.b) this.a.invoke(HideMessageUrlPreviewResponse.ADAPTER.decode(r3));
        }
    }

    public y0() {
    }

    @Override // a2b.e
    public final Pair<Map<String, Map<String, UrlCardPreviewEntity>>, LinkedHashMap<String, MessageLink>> a(GetMessagePreviewsRequest.Builder r3, Function1<? super GetMessagePreviewsResponse, ? extends Pair<? extends Map<String, ? extends Map<String, UrlCardPreviewEntity>>, ? extends LinkedHashMap<String, MessageLink>>> r4, Function1<? super ErrorResult, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        SdkSender.d r6 = SdkSender.syncSendMayError(Command.GET_MESSAGE_PREVIEWS, r3, new b(r4));
        ErrorResult r7 = r6.b;
        if (r7 == null) goto L9;
        if (r5 == null) goto L10;
        r5.invoke(r7);
        return null;
    L10:
        return null;
    L9:
        return (Pair) r6.a;
    }

    @Override // a2b.e
    public final void b(GenerateUrlPreviewEntityRequest.Builder r3, Function1<? super GenerateUrlPreviewEntityResponse, UrlInlinePreviewEntity> r4, IGetDataCallback<UrlInlinePreviewEntity> r5) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        SdkSender.asynSendRequestNonWrap(Command.GENERATE_URL_PREVIEW_ENTITY, r3, r5, new a(r4));
    }

    @Override // a2b.e
    public final void c(HideMessageUrlPreviewRequest.Builder r3, Function1<? super HideMessageUrlPreviewResponse, ? extends a2b.b> r4, IGetDataCallback<a2b.b> r5) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        SdkSender.asynSendRequestNonWrap(Command.HIDE_MESSAGE_URL_PREVIEW, r3, r5, new c(r4));
    }

    @Override // a2b.e
    public final void d(MGetUrlPreviewRequest.Builder r3, com.ss.android.lark.sdk.h r4, PreviewService$getUrlPreViewEntityList$2 r5) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        SdkSender.asynSendRequestNonWrap(Command.MGET_URL_PREVIEW, r3, r5, z0.a, r4);
    }
}
