package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.url.v1.PushUrlPreviews;
import com.ss.android.lark.chat.api.service.impl.PreviewCache;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntry;
import com.ss.android.lark.chat.utils.o1;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements c0.a {
    public final a2b.c a;
    public final WeakReference<b> b;
    public final c c;

    public static final class a {
    }

    public interface b {
        void onPushPreview(Map<String, ? extends Map<String, UrlCardPreviewEntity>> r1, Map<String, ? extends Map<String, MessageLink>> r2);

        void onPushSignUrlPreview(List<UrlPreViewEntries> r1);
    }

    public static final class c implements tya.a {
        public final /* synthetic */ i a;

        public c(i r1) {
            this.a = r1;
        }

        public final void a(Map<String, ? extends ArrayList<String>> r3) {
            Intrinsics.checkNotNullParameter(r3, "updateMaps");
            Lazy<PreviewCache> r0 = PreviewCache.f;
            Map<String, Map<String, UrlCardPreviewEntity>> r1 = PreviewCache.a.a().d(r3);
            Map<String, Map<String, MessageLink>> r4 = PreviewCache.a.a().a(r3);
            b r2 = this.a.b.get();
            if (r2 == null) goto L6;
            r2.onPushPreview(r1, r4);
            return;
        }
    }

    public static final class d implements com.ss.android.lark.sdk.g.b {
        public final /* synthetic */ i a;

        public d(i r1) {
            this.a = r1;
        }

        public final void a(byte[] r18) {
            List<UrlPreViewEntries> r1 = j6b.d.e((PushUrlPreviews) PushUrlPreviews.ADAPTER.decode(r18));
            i r2 = this.a;
            Iterator r3 = ((ArrayList) r1).iterator();
        L4:
            if (r3.hasNext() == false) goto L36;
            UrlPreViewEntries r4 = (UrlPreViewEntries) r3.next();
            Iterator<T> r5 = r4.getEntryList().iterator();
        L7:
            if (r5.hasNext() == false) goto L35;
            UrlPreViewEntry r6 = (UrlPreViewEntry) r5.next();
            ConcurrentHashMap<Integer, Long> r8 = o1.a;
            Long r9 = o1.a(r4.getSourceId());
            r2.getClass();
            UrlInlinePreviewEntity r10 = r6.getPreviewEntity();
            String r11 = null;
            if (r10 == null) goto L13;
            Url r12 = r10.getUrl();
            if (r12 == null) goto L13;
            String r13 = r12.getAndroidUrl();
        L14:
            if (r13 != null) goto L16;
        L19:
            boolean r14 = true;
        L20:
            if (r14 == false) goto L25;
            if (r10 == null) goto L29;
            Url r15 = r10.getUrl();
            if (r15 == null) goto L29;
            r11 = r15.getUrl();
        L29:
            String r16 = r11;
            if (r9 == null) goto L7;
            StringBuilder r17 = new StringBuilder();
            r17.append(r6.getPreviewId());
            ChatHitPointExtraParams.UrlAnalysisScene r19 = ChatHitPointExtraParams.UrlAnalysisScene.CHAT_STATUS;
            r17.append(r19.getValue());
            if (o1.a(r17.toString()) != null) goto L7;
            if (r16 == null) goto L7;
            Log.i("[URLPreview] pushURLPreviews", "sign push userId:" + r4.getSourceId() + ",previewId:" + r6.getPreviewId());
            com.ss.android.lark.chatwindow.view.preview.i.e(r19, r6.getPreviewId(), r16, ChatHitPointExtraParams.DataSource.FROM_SDK_PUSH, r9.longValue());
            goto L7
        L25:
            if (r10 == null) goto L29;
            Url r20 = r10.getUrl();
            if (r20 == null) goto L29;
            r11 = r20.getAndroidUrl();
            goto L29
        L16:
            if (r13.length() == 0) goto L19;
            r14 = false;
        L13:
            r13 = null;
            goto L14
        L35:
            h6b.g r7 = h6b.g.b;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r4, "urlPreViewEntries");
            Intrinsics.checkNotNullParameter("[URLPreview] pushURLPreviews", "tag");
            r7.a.getClass();
            k6b.a.c(r4, "[URLPreview] pushURLPreviews");
            goto L4
        L36:
            b r21 = this.a.b.get();
            if (r21 == null) goto L50;
            r21.onPushSignUrlPreview(r1);
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        Lazy<PreviewCache> r0 = PreviewCache.f;
        PreviewCache r1 = PreviewCache.a.a();
        c r2 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "observer");
        if (r1.e.contains(r2) == true) goto L5;
        r1.e.put(r2, new Object());
    L5:
        this.a.v9(this.c);
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_URL_PREVIEWS, new d(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        Lazy<PreviewCache> r0 = PreviewCache.f;
        PreviewCache r1 = PreviewCache.a.a();
        c r2 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "observer");
        r1.e.remove(r2);
        this.a.N4(this.c);
        com.ss.android.lark.sdk.g.e.a.c(Command.PUSH_URL_PREVIEWS);
    }

    public i(a2b.c r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "previewPush");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = r2;
        this.b = new WeakReference(r3);
        this.c = new c(this);
    }
}
