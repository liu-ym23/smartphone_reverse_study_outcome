package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseFileContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BaseFileContentVO<T extends BaseFileContent<T>> extends v5b.a<T> {
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
    public boolean n;
    public String o;
    public Message.SourceType p;
    public Message.FileDeletedStatus q;

    public final String e() {
        return (String) this.b.getValue();
    }

    public final String f() {
        return (String) this.c.getValue();
    }

    public final boolean g() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) this.j.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) this.k.getValue()).booleanValue();
    }

    public BaseFileContentVO(final T r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.b = LazyKt.lazy(new BaseFileContentVO$key$2(r2));
        this.c = LazyKt.lazy(new BaseFileContentVO$name$2(r2));
        this.d = LazyKt.lazy(new BaseFileContentVO$size$2(r2));
        this.e = LazyKt.lazy(new BaseFileContentVO$nameSpace$2(r2));
        this.f = LazyKt.lazy(new BaseFileContentVO$source$2(r2));
        this.g = LazyKt.lazy(new BaseFileContentVO$saveToDrive$2(r2));
        this.h = LazyKt.lazy(new BaseFileContentVO$isFromDrive$2(r2));
        this.i = LazyKt.lazy(new BaseFileContentVO$isInMyNutStore$2(r2));
        this.j = LazyKt.lazy(new BaseFileContentVO$isLanTrans$2(r2));
        this.k = LazyKt.lazy(new BaseFileContentVO$isSender$2(r2));
        this.l = LazyKt.lazy(new BaseFileContentVO$isLanTransferring$2(r2));
        this.m = LazyKt.lazy(new BaseFileContentVO$lanTransStatus$2(r2));
        this.o = BuildConfig.FLAVOR;
        this.p = Message.SourceType.TYPE_FROM_UNKONWN;
        this.q = Message.FileDeletedStatus.NORMAL;
    }

    @Override // v5b.a
    public boolean d(v5b.a<?> r4) {
        if (super.d(r4) == true) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
        return false;
    L7:
        if ((r4 instanceof BaseFileContentVO) == false) goto L27;
        BaseFileContentVO r5 = (BaseFileContentVO) r4;
        if (((Number) this.g.getValue()).intValue() == ((Number) r5.g.getValue()).intValue()) goto L11;
        return false;
    L11:
        if (g() == r5.g()) goto L13;
        return false;
    L13:
        if (this.n == r5.n) goto L15;
        return false;
    L15:
        if (((Boolean) this.i.getValue()).booleanValue() == ((Boolean) r5.i.getValue()).booleanValue()) goto L17;
        return false;
    L17:
        if (this.q == r5.q) goto L19;
        return false;
    L19:
        if (h() == r5.h()) goto L21;
        return false;
    L21:
        if (i() == r5.i()) goto L23;
        return false;
    L23:
        if (((Number) this.m.getValue()).intValue() != ((Number) r5.m.getValue()).intValue()) goto L35;
        return true;
    L35:
        return false;
    L27:
        return false;
    }
}
