package com.larksuite.component.card.plugin.video;

import com.larksuite.component.card.plugin.OPPlugin;
import com.larksuite.component.card.plugin.h;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.card.protocol.data.media.VideoInfo;
import com.larksuite.component.card.service.c;
import com.larksuite.component.card.service.d;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.widget.richtext.RichTextElement;
import j18.f;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0003\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/plugin/video/CardPreviewVideoPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "previewVideo", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/video/CardPreviewVideoPlugin$CardApiPreviewVideoRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/video/CardPreviewVideoPlugin$CardApiPreviewVideoResponse;", "CardApiPreviewVideoRequest", "CardApiPreviewVideoResponse", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardPreviewVideoPlugin extends OPPlugin {
    private static final String API_NAME = "universalCardPreviewVideo";
    public static final a Companion = null;
    private static final String TAG = "CardPreviewVideoPlugin";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/larksuite/component/card/plugin/video/CardPreviewVideoPlugin$CardApiPreviewVideoRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "fileID", "", "getFileID", "()Ljava/lang/String;", "setFileID", "(Ljava/lang/String;)V", "imgID", "getImgID", "setImgID", "enableDownload", "", "getEnableDownload", "()Ljava/lang/Boolean;", "setEnableDownload", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isTranslateElement", "setTranslateElement", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardApiPreviewVideoRequest extends LKBaseRequestModel {
        private Boolean enableDownload;
        private String fileID;
        private String imgID;
        private Boolean isTranslateElement;

        public CardApiPreviewVideoRequest() {
        }

        public final Boolean getEnableDownload() {
            return this.enableDownload;
        }

        public final String getFileID() {
            return this.fileID;
        }

        public final String getImgID() {
            return this.imgID;
        }

        public final Boolean isTranslateElement() {
            return this.isTranslateElement;
        }

        public final void setEnableDownload(Boolean r1) {
            this.enableDownload = r1;
        }

        public final void setFileID(String r1) {
            this.fileID = r1;
        }

        public final void setImgID(String r1) {
            this.imgID = r1;
        }

        public final void setTranslateElement(Boolean r1) {
            this.isTranslateElement = r1;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larksuite/component/card/plugin/video/CardPreviewVideoPlugin$CardApiPreviewVideoResponse;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardApiPreviewVideoResponse extends LKBaseResponseModel {
        public CardApiPreviewVideoResponse() {
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LKEvent a;
        public final /* synthetic */ CardContext b;
        public final /* synthetic */ VideoInfo c;
        public final /* synthetic */ RichTextElement.ImageProperty d;
        public final /* synthetic */ CardApiPreviewVideoRequest e;

        public b(LKEvent r1, CardPreviewVideoPlugin r2, CardContext r3, VideoInfo r4, RichTextElement.ImageProperty r5, CardApiPreviewVideoRequest r6) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void a() {
            Object r0 = this.a.h;
            c r2 = null;
            if ((r0 instanceof ILynxBridgeContext) == false) goto L5;
            ILynxBridgeContext r1 = (ILynxBridgeContext) r0;
        L6:
            if (r1 == null) goto L12;
            ILynxContainerContext r3 = r1.getContainerContext();
            if (r3 == null) goto L12;
            Map r4 = r3.getBizExtra();
            if (r4 == null) goto L12;
            Object r5 = r4.get("card_service");
        L14:
            if ((r5 instanceof d) == true) goto L16;
            r5 = null;
        L16:
            d r6 = (d) r5;
            if (r6 == null) goto L20;
            r2 = r6.getService(com.larksuite.component.card.component.video.service.c.class);
        L20:
            com.larksuite.component.card.component.video.service.c r7 = (com.larksuite.component.card.component.video.service.c) r2;
            if (r7 != null) goto L24;
            Log.e(CardPreviewVideoPlugin.TAG, "previewVideo videoService is null");
            return;
        L24:
            CardContext r8 = this.b;
            VideoInfo r9 = this.c;
            RichTextElement.ImageProperty r10 = this.d;
            CardApiPreviewVideoRequest r11 = this.e;
            if (r11 == null) goto L29;
            Boolean r12 = r11.getEnableDownload();
            if (r12 == null) goto L29;
            boolean r13 = r12.booleanValue();
        L30:
            r7.d(r8, r9, r10, r13);
            return;
        L29:
            r13 = true;
        L12:
            r5 = null;
            goto L14
        L5:
            r1 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public CardPreviewVideoPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {API_NAME})
    public final void previewVideo(LKEvent r10, CardApiPreviewVideoRequest r11, f<CardApiPreviewVideoResponse> r12) {
        Intrinsics.checkNotNullParameter(r12, "invokeCallback");
        if (r10 == null) goto L50;
        com.larksuite.component.card.cardcontainer.c r1 = h.a(r10);
        if (r1 == null) goto L50;
        CardContext r5 = r1.c;
        if (r5 == null) goto L50;
        if (r11 == null) goto L11;
        boolean r2 = Intrinsics.areEqual(r11.isTranslateElement(), Boolean.TRUE);
    L12:
        String r3 = null;
        if (r2 == false) goto L21;
        com.larksuite.component.card.cardcontainer.c r4 = h.a(r10);
        if (r4 == null) goto L28;
        CardData r6 = r4.b;
        if (r6 == null) goto L28;
        CardContent r7 = r6.getTranslateContent();
        if (r7 == null) goto L28;
        CardAttachment r8 = r7.getAttachment();
    L29:
        if (r8 != null) goto L32;
        Log.e(TAG, "previewVideo attachment is null");
        return;
    L32:
        HashMap<String, VideoInfo> r9 = r8.getVideos();
        if (r9 == null) goto L48;
        if (r11 == null) goto L36;
        String r13 = r11.getFileID();
    L37:
        VideoInfo r14 = r9.get(r13);
        if (r14 == null) goto L48;
        HashMap<String, RichTextElement.ImageProperty> r0 = r8.getImages();
        if (r0 == null) goto L45;
        if (r11 == null) goto L44;
        r3 = r11.getImgID();
    L44:
        RichTextElement.ImageProperty r15 = r0.get(r3);
    L46:
        mz7.b.a(new b(r10, this, r5, r14, r15, r11));
        r12.callback(new CardApiPreviewVideoResponse());
        return;
    L45:
        r15 = null;
        goto L46
    L36:
        r13 = null;
    L48:
        Log.e(TAG, "previewVideo videoInfo is null");
        return;
    L28:
        r8 = null;
        goto L29
    L21:
        com.larksuite.component.card.cardcontainer.c r16 = h.a(r10);
        if (r16 == null) goto L28;
        CardData r17 = r16.b;
        if (r17 == null) goto L28;
        CardContent r19 = r17.getCardContent();
        if (r19 == null) goto L28;
        r8 = r19.getAttachment();
        goto L29
    L11:
        r2 = false;
    L50:
        Log.e(TAG, "previewVideo cardContext is null");
    }
}
