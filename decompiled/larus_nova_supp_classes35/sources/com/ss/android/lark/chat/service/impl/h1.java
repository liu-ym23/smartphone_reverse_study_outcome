package com.ss.android.lark.chat.service.impl;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.DoubaoResource;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.LingoOption;
import com.bytedance.lark.pb.basic.v1.Location;
import com.bytedance.lark.pb.basic.v1.LocationContent;
import com.bytedance.lark.pb.basic.v1.MediaContent;
import com.bytedance.lark.pb.basic.v1.QuasiContent;
import com.bytedance.lark.pb.im.v1.CreateQuasiMessageRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h1 {
    public static j1<Message.Type, k5b.f, QuasiContent.Builder> a;

    public static class a extends b<k5b.a> {
        public a() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r4) {
            k5b.a r5 = (k5b.a) r4;
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.AUDIO);
            this.a.upload_id(r5.x);
            if (TextUtils.isEmpty(r5.v) == true) goto L5;
            byte[] r0 = FileUtils.j(r5.v);
        L6:
            QuasiContent.Builder r1 = this.b;
            if (r0 == null) goto L9;
            byte[] r2 = r0;
        L10:
            r1.audio(ByteString.of(r2)).duration(Integer.valueOf(r5.w)).key(r5.y).text(r5.z);
            RichText r3 = r5.A;
            if (r3 == null) goto L13;
            this.b.rich_text(com.ss.android.lark.parser.internal.g0.d(r3));
        L13:
            if (r0 != null) goto L16;
            Log.e("audio message is empty, path:" + r5.v);
        L16:
            return this.b;
        L9:
            r2 = new byte[0];
            goto L10
        L5:
            r0 = null;
            goto L6
        }
    }

    public static abstract class b<T extends k5b.f> implements m6b.k<T, QuasiContent.Builder> {
        public CreateQuasiMessageRequest.Builder a;
        public QuasiContent.Builder b;

        public b() {
        }
    }

    public static class c extends b<o6b.a> {
        public c() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r3) {
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.CARD);
            this.b.card_content(((okb.e) ImSdkProxy.f.getValue()).c(((o6b.a) r3).v));
            return this.b;
        }
    }

    public static class d extends b<k5b.b> {
        public d() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r8) {
            k5b.b r9 = (k5b.b) r8;
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.FILE).cid(r9.d);
            com.ss.android.lark.biz.im.api.k r1 = r9.E;
            if (r1 == null) goto L5;
            String r0 = r1.b.replaceAll("\n", "-");
            Log.i("FileRequestTransformer", "[DoubaoFile] transform quasi content, storageType=" + r9.E.c);
            this.b.key(r9.E.a()).name(r0).doubao_resource(new DoubaoResource.Builder().name(r0).storage_type(Integer.valueOf(r9.E.c)).build());
            return this.b;
        L5:
            this.b.preprocess_key(r9.C);
            if (r9.x == 2) goto L31;
            String r2 = r9.w;
            if (TextUtils.isEmpty(r2) == true) goto L11;
            this.b.name(r2.replaceAll("\n", "-"));
        L11:
            if (TextUtils.isEmpty(r9.v) == true) goto L13;
            this.b.path(r9.v);
            return this.b;
        L13:
            Uri r3 = r9.B;
            if (r3 != null) goto L16;
            Log.e("FileRequestTransformer", "uri is null");
            return this.b;
        L16:
            this.b.file_uri(r3.toString());
            Application r4 = LarkContext.getApplication();
            if (r4 != null) goto L19;
            Log.e("FileRequestTransformer", "context is null");
            return this.b;
        L19:
            this.b.file_handle(Long.valueOf(com.ss.android.lark.utils.c1.b(r4, r3)));
            if (this.b.file_handle != null) goto L33;
            PolarisFileWrapper r5 = com.larksuite.framework.utils.m0.b(r4, r3, false);     // Catch: Exception -> L29
            if (r5 != null) goto L25;
        L27:
            Log.e("FileRequestTransformer", "failed to get file path for uri: " + r3);     // Catch: Exception -> L29
        L37:
            goto L33
        L25:
            if (r5.exists() == false) goto L27;
            this.b.path(r5.getAbsolutePath());     // Catch: Exception -> L29
        L29:
            e = move-exception;
            Log.e("FileRequestTransformer", "failed to get file path: " + e.getMessage());
        L33:
            if (TextUtils.isEmpty(r9.D) == true) goto L36;
            this.b.file_upload_id(r9.D);
        L36:
            return this.b;
        L31:
            this.b.key(r9.y).name(r9.w).mime(r9.A).size_bytes(Long.valueOf(r9.z)).file_source(File.Source.NUT_STORE);
            goto L33
        }
    }

    public static class e extends b<k5b.c> {
        public e() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r4) {
            k5b.c r5 = (k5b.c) r4;
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.IMAGE).cid(r5.d);
            byte[] r0 = FileUtils.j(r5.v);
            QuasiContent.Builder r1 = this.b;
            if (r0 == null) goto L5;
            byte[] r2 = r0;
        L6:
            r1.image(ByteString.of(r2)).width(Integer.valueOf(r5.w)).height(Integer.valueOf(r5.x)).is_origin_source(Boolean.valueOf(r5.z)).preprocess_key(r5.A);
            if (TextUtils.isEmpty(r5.B) == true) goto L9;
            this.b.image_upload_id(r5.B);
        L9:
            this.b.build();
            if (r0 != null) goto L13;
            Log.e("audio message is empty, path:" + r5.v);
        L13:
            return this.b;
        L5:
            r2 = new byte[0];
            goto L6
        }
    }

    public static class f extends b<k5b.d> {
        public f() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r4) {
            k5b.d r5 = (k5b.d) r4;
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.LOCATION);
            Location r0 = new Location.Builder().name(r5.v.getLocationDescription().getName()).description(r5.v.getLocationDescription().getDescription()).build();
            LocationContent r1 = new LocationContent.Builder().longitude(r5.v.getLongitude()).latitude(r5.v.getLatitude()).zoom_level(Integer.valueOf(r5.v.getZoomLevel())).vendor(r5.v.getVendor()).is_internal(Boolean.valueOf(r5.v.isInternal())).location(r0).build();
            byte[] r2 = FileUtils.j(r5.w);
            QuasiContent.Builder r3 = this.b;
            if (r2 != null) goto L6;
            r2 = new byte[0];
        L6:
            r3.image(ByteString.of(r2)).width(Integer.valueOf(r5.x)).height(Integer.valueOf(r5.y)).location_content(r1).build();
            return this.b;
        }
    }

    public static class g extends b<k5b.e> {
        public g() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r4) {
            k5b.e r5 = (k5b.e) r4;
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.MEDIA);
            byte[] r0 = FileUtils.j(r5.v);
            if (r0 != null) goto L5;
            r0 = new byte[0];
        L5:
            this.b.image(ByteString.of(r0)).width(Integer.valueOf(r5.w)).height(Integer.valueOf(r5.x)).path(r5.B).compress_path(r5.C).media_source(MediaContent.Source.fromValue(r5.y.getNumber())).mime(r5.z).name(r5.A).duration(Integer.valueOf((int) r5.D)).size_bytes(Long.valueOf(r5.E)).preprocess_key(r5.F);
            if (TextUtils.isEmpty(r5.H) == true) goto L9;
            this.b.media_upload_id(r5.H);
        L9:
            if (TextUtils.isEmpty(r5.G) == true) goto L12;
            this.b.first_screen_image_upload_id(r5.G);
        L12:
            return this.b;
        }
    }

    public static class h<T extends k5b.f> implements j1.a<Message.Type, T> {
        public h() {
        }

        @Override // com.ss.android.lark.chat.service.impl.j1.a
        public final Message.Type a(Object r1) {
            return ((k5b.f) r1).e;
        }
    }

    public static class i extends b<k5b.g> {
        public i() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r3) {
            k5b.g r4 = (k5b.g) r3;
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.POST).cid(r4.d);
            this.b.title(r4.v).is_group_announcement(Boolean.valueOf(r4.x)).rich_text(com.ss.android.lark.parser.internal.g0.d(r4.w));
            LingoOption r0 = com.ss.android.lark.parser.internal.g0.c(r4.w);
            if (r0 == null) goto L6;
            this.b.lingo_option(r0);
        L6:
            if (CollectionUtils.isEmpty(r4.y) == true) goto L9;
            this.b.file_attachments(h1.a(r4.y));
        L9:
            return this.b;
        }
    }

    public static class j extends b<k5b.h> {
        public j() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r3) {
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.SHARE_USER_CARD);
            this.b.share_chatter_id(((k5b.h) r3).v).build();
            return this.b;
        }
    }

    public static class k extends b<k5b.i> {
        public k() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r3) {
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.SHARE_GROUP_CHAT);
            QuasiContent.Builder r0 = this.b;
            ((k5b.i) r3).getClass();
            r0.share_chat_id(null);
            return this.b;
        }
    }

    public static class l extends b<k5b.j> {
        public l() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r3) {
            k5b.j r4 = (k5b.j) r3;
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.STICKER);
            this.b.key(r4.v).width(Integer.valueOf(r4.w)).height(Integer.valueOf(r4.x)).sticker_set_id(r4.y).sticker_id(r4.z).build();
            return this.b;
        }
    }

    public static class m extends b<k5b.k> {
        public m() {
        }

        @Override // m6b.k
        public final QuasiContent.Builder transform(Object r3) {
            k5b.k r4 = (k5b.k) r3;
            this.a.type(com.bytedance.lark.pb.basic.v1.Message.Type.TEXT).cid(r4.d);
            this.b.rich_text(com.ss.android.lark.parser.internal.g0.d(r4.v));
            LingoOption r0 = com.ss.android.lark.parser.internal.g0.c(r4.v);
            if (r0 == null) goto L6;
            this.b.lingo_option(r0);
        L6:
            if (CollectionUtils.isEmpty(r4.w) == true) goto L9;
            this.b.file_attachments(h1.a(r4.w));
        L9:
            return this.b;
        }
    }

    public static List a(List r10) {
        if (CollectionUtils.isEmpty(r10) == true) goto L49;
        ArrayList r1 = null;
        int r2 = 0;
    L7:
        if (r2 >= r10.size()) goto L38;
        File r3 = (File) ListProtector.get(r10, r2);
        String r4 = r3.key;
        if (r4 != null) goto L11;
        r4 = BuildConfig.FLAVOR;
    L11:
        String r6 = r3.path;
        if (r6 != null) goto L14;
        r6 = BuildConfig.FLAVOR;
    L14:
        boolean r8 = true;
        if (r4.startsWith("file_") == false) goto L17;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L27;
        if (TextUtils.isEmpty(r6) == true) goto L27;
        Log.w("MessageRequestTransformers", "normalize attachment path for ready resource, key=" + r4 + ", pathLen=" + r6.length());
        if (r1 != null) goto L25;
        r1 = new ArrayList(r10);
    L25:
        ListProtector.set(r1, r2, r3.newBuilder().path(BuildConfig.FLAVOR).build());
    L37:
        r2 = r2 + 1;
    L27:
        if (TextUtils.isEmpty(r4) == false) goto L42;
    L32:
        r8 = false;
    L33:
        if (r8 == false) goto L37;
        if (TextUtils.isEmpty(r6) == false) goto L37;
        Log.e("MessageRequestTransformers", "attachment upload path empty, uploadId=".concat(r4));
        goto L37
    L42:
        UUID.fromString(r4);     // Catch: IllegalArgumentException -> L31
    L17:
        r7 = false;
        goto L19
    L38:
        if (r1 != null) goto L41;
        return r10;
    L41:
        return r1;
    L49:
        return r10;
    }
}
