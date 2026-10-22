package com.ss.android.lark.chat.service.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.videosend.tools.VideoCoverManager;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b1 {
    public static j1<Message.Type, MessageParams, k5b.f> a;

    public static class a extends b<h5b.a, k5b.a> {
        public a() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r9) {
            h5b.a r10 = (h5b.a) r9;
            return new k5b.a(r10.A, r10.B, r10.D, r10.E, r10.F, r10.G);
        }
    }

    public static abstract class b<P extends MessageParams, R extends k5b.f> implements m6b.k<P, R> {
        public abstract R a(P r1);

        public b() {
        }

        @Override // m6b.k
        public final Object transform(Object r3) {
            MessageParams r4 = (MessageParams) r3;
            k5b.f r0 = a(r4);
            r0.e = r4.e;
            r0.g = r4.g;
            r0.f = r4.f;
            r0.c = r4.c;
            r0.d = r4.d;
            r0.b = r4.b;
            r0.a = r4.a;
            r0.h = r4.h;
            r0.i = r4.k;
            r0.j = r4.m;
            r0.l = r4.p;
            r0.n = r4.r;
            r0.o = r4.s;
            r0.p = r4.u;
            r0.m = r4.q;
            r0.q = r4.v;
            r0.r = r4.w;
            r0.s = r4.x;
            r0.t = r4.y;
            r0.u = r4.z;
            return r0;
        }
    }

    public static class c extends b<ecb.a, o6b.a> {
        public c() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r2) {
            ((ecb.a) r2).getClass();
            return new o6b.a();
        }
    }

    public static class d extends b<com.ss.android.lark.biz.im.api.l, k5b.b> {
        public d() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r13) {
            com.ss.android.lark.biz.im.api.l r14 = (com.ss.android.lark.biz.im.api.l) r13;
            String r0 = r14.B;
            if (r0 != null) goto L5;
            r0 = r14.A;
        L5:
            Uri r8 = r14.I;
            return new k5b.b(r0, r14.C, r14.D, r14.E, r14.F, r8, r14.H, r14.J, r14.K);
        }
    }

    public static class e extends b<com.ss.android.lark.biz.im.api.p0, k5b.c> {
        public e() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r10) {
            com.ss.android.lark.biz.im.api.p0 r11 = (com.ss.android.lark.biz.im.api.p0) r10;
            return new k5b.c(r11.A, r11.B, r11.C, r11.D, r11.E, r11.F, r11.G);
        }
    }

    public static class f extends b<b2b.a, k5b.d> {
        public f() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r5) {
            b2b.a r6 = (b2b.a) r5;
            return new k5b.d(r6.A, r6.B, r6.C, r6.D);
        }
    }

    public static class g extends b<com.ss.android.lark.biz.im.api.t0, k5b.e> {
        public g() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r21) {
            com.ss.android.lark.biz.im.api.t0 r0 = (com.ss.android.lark.biz.im.api.t0) r21;
            if (TextUtils.isEmpty(r0.C) == true) goto L10;
            if (r0.B <= 0) goto L10;
            if (r0.A <= 0) goto L10;
        L18:
            PerfLog.start("get_first_frame", r0.l, BuildConfig.FLAVOR);
            File r1 = r0.E;
            if (r1 == null) goto L21;
            boolean r4 = true;
        L23:
            if ((r1.exists() & r4) == false) goto L25;
            File r2 = r0.E;
        L26:
            String r11 = r2.getAbsolutePath();
            VideoCoverManager.a r5 = VideoCoverManager.getVideoCover(ImSdk.a.getContext(), r11);
            PerfLog.end("get_first_frame", r0.l, BuildConfig.FLAVOR);
            return new k5b.e(r5.a, r5.b, r5.c, r0.H, r0.C, r2.getName(), r11, r0.F, r0.A, r0.B, r0.I, r0.J, r0.K);
        L25:
            r2 = r0.D;
            goto L26
        L21:
            r4 = false;
        L10:
            if (TextUtils.isEmpty(r0.C) == false) goto L13;
            r0.C = "video/mp4";
        L13:
            if (r0.B != 0) goto L16;
            r0.B = r0.D.length();
        L16:
            if (r0.A != 0) goto L18;
            r0.A = VideoTools.getVideoInfo(r0.D.getAbsolutePath()).duration;
            goto L18
        }
    }

    public static class h<T extends MessageParams> implements j1.a<Message.Type, T> {
        public h() {
        }

        @Override // com.ss.android.lark.chat.service.impl.j1.a
        public final Message.Type a(Object r1) {
            return ((MessageParams) r1).e;
        }
    }

    public static class i extends b<kya.a, k5b.g> {
        public i() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r5) {
            kya.a r6 = (kya.a) r5;
            return new k5b.g(r6.A, r6.B, r6.D, r6.E);
        }
    }

    public static class j extends b<com.ss.android.lark.biz.im.api.e1, k5b.h> {
        public j() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r2) {
            return new k5b.h(((com.ss.android.lark.biz.im.api.e1) r2).A);
        }
    }

    public static class k extends b<com.ss.android.lark.biz.im.api.i1, k5b.i> {
        public k() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r1) {
            ((com.ss.android.lark.biz.im.api.i1) r1).getClass();
            throw null;
        }
    }

    public static class l extends b<h5b.b, k5b.j> {
        public l() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r7) {
            StickerFileInfo r8 = ((h5b.b) r7).A;
            return new k5b.j(r8.key, r8.width, r8.height, r8.stickerSetId, r8.stickerId);
        }
    }

    public static class m extends b<com.ss.android.lark.biz.im.api.j1, k5b.k> {
        public m() {
        }

        @Override // com.ss.android.lark.chat.service.impl.b1.b
        public final k5b.f a(MessageParams r3) {
            com.ss.android.lark.biz.im.api.j1 r4 = (com.ss.android.lark.biz.im.api.j1) r3;
            return new k5b.k(r4.A, r4.C);
        }
    }
}
