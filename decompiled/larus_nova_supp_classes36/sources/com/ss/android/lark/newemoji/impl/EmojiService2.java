package com.ss.android.lark.newemoji.impl;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.Emoji;
import com.bytedance.lark.pb.im.v1.GetEmojisRequest;
import com.bytedance.lark.pb.im.v1.GetEmojisResponse;
import com.bytedance.lark.pb.im.v1.PushEmojis;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class EmojiService2 extends c0c.c implements rsb.b, rsb.a.InterfaceC0324a {
    public final l b;
    public final rsb.a c;
    public final AtomicBoolean d;
    public final b e;
    public Disposable f;

    public static final class a {
    }

    public static final class b implements zob.b {
        public final /* synthetic */ EmojiService2 a;

        public b(EmojiService2 r1) {
            this.a = r1;
        }

        @Override // zob.b
        public final void a(Locale r3, Locale r4) {
            Log.i("EmojiService2", "onLanguageChange, from " + wsb.c.a(r3) + " to " + wsb.c.a(r4));
            this.a.c.f3();
            this.a.P4();
        }
    }

    static {
    }

    @Override // rsb.b
    public final void P4() {
        k0(this.c.U9(), null);
    }

    public final void c() {
        Log.i("EmojiService2", "destroy");
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        com.ss.android.lark.language.service.impl.a.b.a.k(this.e);
        this.c.c9(null);
        Disposable r1 = this.f;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.f = null;
    }

    public final void e() {
        Log.i("EmojiService2", "onPrepared");
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        com.ss.android.lark.language.service.impl.a.b.a.c(this.e);
        this.c.c9(this);
        Disposable r1 = this.f;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.f = this.b.i(Command.PUSH_EMOJIS, PushEmojis.ADAPTER).subscribe(new d(this), e.a);
        P4();
    }

    @Override // rsb.b, rsb.a.InterfaceC0324a
    public final void k0(int r18, final List<String> r19) {
        if (this.d.get() == false) goto L5;
        return;
    L5:
        this.d.set(true);
        Log.i("EmojiService2", "fetchEmojis start");
        if (r18 != Integer.MIN_VALUE) goto L8;
        final boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        Integer r0 = null;
    L12:
        GetEmojisRequest.Builder r8 = new GetEmojisRequest.Builder().version(r0);
        if (CollectionUtils.isEmpty(r19) == true) goto L15;
        r8.trigger_keys(r19);
    L15:
        final long r2 = SystemClock.elapsedRealtime();
        final Function1<ErrorResult, Unit> r1 = new EmojiService2$fetchEmojis$errorHandler$1(r2, r4, r19);
        l r3 = this.b;
        Intrinsics.checkNotNull(r8);
        t.a(r3.h(new com.bytedance.lark.rustclient.api.d(r8, GetEmojisResponse.ADAPTER, Command.GET_EMOJIS, null, null, null, null, 248)).a(), new EmojiService2$fetchEmojis$1(this, r2, r4, r19), new EmojiService2$fetchEmojis$2(this, r1), new EmojiService2$fetchEmojis$3(this, r1));
        return;
    L11:
        r0 = Integer.valueOf(r18);
        goto L12
    L8:
        r4 = false;
        goto L9
    }

    public final Set<qsb.a> m(int r12, Map<String, Emoji> r13) {
        if (this.c.U9() < r12) goto L5;
    L41:
        return null;
    L5:
        if (CollectionUtils.isEmpty(r13) == true) goto L41;
        HashSet r14 = new HashSet();
        Iterator<Map.Entry<String, Emoji>> r15 = r13.entrySet().iterator();
    L9:
        if (r15.hasNext() == false) goto L40;
        Map.Entry<String, Emoji> r0 = r15.next();
        Emoji r2 = r0.getValue();
        String r5 = r0.getKey();
        if (this.c.b0(r5) != null) goto L18;
        if (this.c.Yd(r5) != null) goto L18;
        if (TextUtils.isEmpty(r5) == true) goto L9;
        qsb.a r1 = new qsb.a(r5, r5, r2.text, r2.image_key, null, r2.is_deleted);
        r1.i = r2.width.intValue();
        r1.j = r2.height.intValue();
        List r3 = r2.skin_keys;
        r1.f.clear();
        r1.f.addAll(r3);
        r14.add(r1);
    L18:
        qsb.a r4 = this.c.b0(r5);
        if (r4 != null) goto L24;
        r4 = this.c.Yd(r5);
        if (r4 == null) goto L9;
    L24:
        if (Intrinsics.areEqual(Boolean.valueOf(r4.h), r2.is_deleted) == true) goto L26;
    L30:
        boolean r6 = false;
    L31:
        if (r6 == true) goto L9;
        if (TextUtils.equals(r4.c, r2.text) == true) goto L36;
        Log.i("EmojiService2", "parseEmojisFromPb, emoji text update, key: " + r5 + ", origin text: " + r4.c + ", pb text: " + r2.text);
    L36:
        if (TextUtils.equals(r4.d, r2.image_key) == false) goto L38;
        Bitmap r9 = r4.b();
    L39:
        qsb.a r7 = new qsb.a(r4.a, r4.b, r2.text, r2.image_key, r9, r2.is_deleted);
        r7.i = r2.width.intValue();
        r7.j = r2.height.intValue();
        List r8 = r2.skin_keys;
        r7.f.clear();
        r7.f.addAll(r8);
        r14.add(r7);
        goto L9
    L38:
        r9 = null;
        goto L39
    L26:
        if (TextUtils.equals(r4.c, r2.text) == false) goto L30;
        if (TextUtils.equals(r4.d, r2.image_key) == false) goto L30;
        r6 = true;
        goto L31
    L40:
        return r14;
    }

    @Inject
    public EmojiService2(m r2, l r3, rsb.a r4) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        Intrinsics.checkNotNullParameter(r4, "emojiMapManager");
        super(r2);
        this.b = r3;
        this.c = r4;
        this.d = new AtomicBoolean(false);
        this.e = new b(this);
        s.a(this);
        r4.c9(this);
    }
}
