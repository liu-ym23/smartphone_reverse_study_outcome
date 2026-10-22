package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileContentVO extends BaseFileContentVO<FileContent> {
    public final Lazy A;
    public final HashMap<String, xcb.b> B;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    static {
    }

    public final Map<String, PreviewHangPoint> j() {
        return (Map) this.x.getValue();
    }

    public FileContentVO(final FileContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.r = LazyKt.lazy(new FileContentVO$mime$2(r2));
        this.s = LazyKt.lazy(new FileContentVO$filePath$2(r2));
        this.t = LazyKt.lazy(new FileContentVO$fileState$2(r2));
        this.u = LazyKt.lazy(new FileContentVO$progress$2(r2));
        this.v = LazyKt.lazy(new FileContentVO$speed$2(r2));
        this.w = LazyKt.lazy(new FileContentVO$isEncrypted$2(r2));
        this.x = LazyKt.lazy(new FileContentVO$previewHangPoints$2(r2));
        this.y = LazyKt.lazy(new FileContentVO$fileAbility$2(r2));
        this.z = LazyKt.lazy(new FileContentVO$lastUpdateTime$2(r2));
        this.A = LazyKt.lazy(new FileContentVO$lastUpdateChatterName$2(r2));
        this.B = new HashMap();
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.BaseFileContentVO, v5b.a
    public final boolean d(v5b.a<?> r7) {
        if (super.d(r7) == true) goto L5;
        return false;
    L5:
        if (r7 != null) goto L7;
        return false;
    L7:
        if ((r7 instanceof FileContentVO) == false) goto L25;
        FileContentVO r8 = (FileContentVO) r7;
        if (((FileState) this.t.getValue()) == ((FileState) r8.t.getValue())) goto L11;
        return false;
    L11:
        if (((Number) this.u.getValue()).intValue() == ((Number) r8.u.getValue()).intValue()) goto L13;
        return false;
    L13:
        if (((Boolean) this.w.getValue()).booleanValue() == ((Boolean) r8.w.getValue()).booleanValue()) goto L15;
        return false;
    L15:
        if (y28.a.a(j(), r8.j()) == true) goto L17;
        return false;
    L17:
        if (((FileContent.FileAbility) this.y.getValue()) == ((FileContent.FileAbility) r8.y.getValue())) goto L19;
        return false;
    L19:
        if (((Number) this.z.getValue()).longValue() == ((Number) r8.z.getValue()).longValue()) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual((String) this.A.getValue(), (String) r8.A.getValue()) == false) goto L32;
        return true;
    L32:
        return false;
    L25:
        return false;
    }
}
