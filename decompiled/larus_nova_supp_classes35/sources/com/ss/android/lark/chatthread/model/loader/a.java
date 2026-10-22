package com.ss.android.lark.chatthread.model.loader;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.message.lynxcard.message.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;
import m6b.m;
import q3b.e;
import w4b.d0;
import x4b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<PageData extends x4b.a<MessageInfo>> {
    public final BasePageStore<MessageInfo, PageData> a;
    public final g b;
    public final m c;
    public final String d;
    public final int e;
    public final c f;
    public final b<PageData> g;
    public final ChatThreadDataLoader$localDataHandler$1 h;
    public final ChatThreadDataLoader$remoteDataHandler$1 i;

    /* JADX INFO: renamed from: com.ss.android.lark.chatthread.model.loader.a$a, reason: collision with other inner class name */
    public static final class C0117a {
    }

    public interface b<PageData extends x4b.a<MessageInfo>> {
        e a(List r1);
    }

    public interface c {
        void a();

        void b();
    }

    static {
    }

    public static final List a(a r5, List r6) {
        r5.getClass();
        Collections.sort(r6);
        ArrayList r0 = new ArrayList(r6.size());
        Iterator r7 = r6.iterator();
        boolean r1 = false;
    L4:
        if (r7.hasNext() == false) goto L26;
        MessageInfo r2 = (MessageInfo) r7.next();
        if (r2.getMessage().getPosition() > r5.e) goto L8;
    L9:
        r1 = true;
    L10:
        Message r3 = r2.getMessage();
        d0 r4 = b7b.b.a;
        if (ImSdkMessageUtils.c(r3) == true) goto L4;
        if (r2.getMessage().isVisible() == false) goto L4;
        if (r2.getMessage().getPosition() <= r5.e) goto L4;
        boolean r8 = o2b.a.a;
        if (o2b.a.a(r5.b) == false) goto L25;
        if (r2.getMessage().isRecalled() == false) goto L25;
        if (r.a(r2.getMessage().getRootId()) == true) goto L4;
    L25:
        r0.add(r2);
        goto L4
    L8:
        if (r2.getMessage().isVisible() == true) goto L10;
    L26:
        if (r1 == false) goto L28;
        r5.f.a();
    L28:
        return r0;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.ss.android.lark.chatthread.model.loader.ChatThreadDataLoader$localDataHandler$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.ss.android.lark.chatthread.model.loader.ChatThreadDataLoader$remoteDataHandler$1] */
    public a(BasePageStore r2, g r3, m r4, String r5, int r6, zgb.a.a r7, zgb.a.b r8) {
        Intrinsics.checkNotNullParameter(r2, "dataStore");
        Intrinsics.checkNotNullParameter(r3, "fgService");
        Intrinsics.checkNotNullParameter(r4, "postService");
        Intrinsics.checkNotNullParameter(r5, "rootMsgId");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "pageDataFactory");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = new ChatThreadDataLoader$localDataHandler$1(this);
        this.i = new ChatThreadDataLoader$remoteDataHandler$1(this);
    }
}
