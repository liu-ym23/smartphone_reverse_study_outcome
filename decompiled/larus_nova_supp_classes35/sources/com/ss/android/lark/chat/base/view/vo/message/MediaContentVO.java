package com.ss.android.lark.chat.base.view.vo.message;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MediaContentVO extends v5b.a<MediaContent> {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public String n;
    public Message.SourceType o;
    public boolean p;
    public Message.FileDeletedStatus q;

    public final long e() {
        return ((Number) this.g.getValue()).longValue();
    }

    public final String f() {
        if (TextUtils.isEmpty((String) this.i.getValue()) == true) goto L6;
        return (String) this.i.getValue();
    L6:
        return (String) this.j.getValue();
    }

    public MediaContentVO(final MediaContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.b = LazyKt.lazy(new MediaContentVO$key$2(r2));
        this.c = LazyKt.lazy(new MediaContentVO$name$2(r2));
        this.d = LazyKt.lazy(new MediaContentVO$mime$2(r2));
        this.e = LazyKt.lazy(new MediaContentVO$source$2(r2));
        this.f = LazyKt.lazy(new MediaContentVO$imageSet$2(r2));
        this.g = LazyKt.lazy(new MediaContentVO$duration$2(r2));
        this.h = LazyKt.lazy(new MediaContentVO$progress$2(r2));
        this.i = LazyKt.lazy(new MediaContentVO$originPath$2(r2));
        this.j = LazyKt.lazy(new MediaContentVO$filePath$2(r2));
        this.k = LazyKt.lazy(new MediaContentVO$compressPath$2(r2));
        this.l = LazyKt.lazy(new MediaContentVO$fileState$2(r2));
        this.m = LazyKt.lazy(new MediaContentVO$url$2(r2));
        this.n = BuildConfig.FLAVOR;
        this.o = Message.SourceType.TYPE_FROM_UNKONWN;
        this.q = Message.FileDeletedStatus.NORMAL;
    }

    @Override // v5b.a
    public final boolean d(v5b.a<?> r7) {
        if (super.d(r7) == true) goto L5;
        return false;
    L5:
        if (r7 != null) goto L7;
        return false;
    L7:
        if ((r7 instanceof MediaContentVO) == false) goto L21;
        MediaContentVO r8 = (MediaContentVO) r7;
        if (e() == r8.e()) goto L11;
        return false;
    L11:
        if (((Number) this.h.getValue()).intValue() == ((Number) r8.h.getValue()).intValue()) goto L13;
        return false;
    L13:
        if (((FileState) this.l.getValue()) == ((FileState) r8.l.getValue())) goto L15;
        return false;
    L15:
        if (this.p == r8.p) goto L17;
        return false;
    L17:
        if (y28.a.a(f(), r8.f()) == false) goto L26;
        return true;
    L26:
        return false;
    L21:
        return false;
    }
}
