package com.ss.android.lark.chat.base.view.vo.message;

import android.text.Layout;
import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BaseTextContentVO<T extends BaseTextContent<T>> extends f<T> {
    public transient boolean A;
    public final Map<String, xcb.b> B;
    public Map<String, PreviewHangPoint> C;
    public Boolean D;
    public MessageUrlPreview h;
    public DocResult i;
    public PreviewHangPoint j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public List<String> n;
    public List<String> o;
    public int p;
    public boolean q;
    public boolean r;
    public EllipsizeFrameLayout.a s;
    public transient CharSequence t;
    public transient CharSequence u;
    public transient PartialReplyInfo.PartialContentRelativePosition v;
    public transient String w;
    public transient String x;
    public transient boolean y;
    public transient Layout z;

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/base/view/vo/message/BaseTextContentVO$PreviewType;", BuildConfig.FLAVOR, "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.TYPE, AnnotationTarget.FUNCTION})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PreviewType {
        public static final a Companion = null;
        public static final int DOC = 2;
        public static final int NET = 4;
        public static final int NORMAL = 1;
        public static final int UNKNOWN = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public final ArrayList<File> f() {
        return (ArrayList) this.l.getValue();
    }

    public final RichText g() {
        return (RichText) this.k.getValue();
    }

    public BaseTextContentVO(final T r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.k = LazyKt.lazy(new BaseTextContentVO$richText$2(r2));
        this.l = LazyKt.lazy(new BaseTextContentVO$attachments$2(r2));
        this.m = LazyKt.lazy(new BaseTextContentVO$textInMemory$2(r2));
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.r = true;
        this.s = new EllipsizeFrameLayout.a();
        this.B = new LinkedHashMap();
        this.C = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public boolean d(v5b.a<?> r4) {
        if (super.d(r4) == true) goto L6;
        return false;
    L6:
        if ((r4 instanceof BaseTextContentVO) == false) goto L27;
        BaseTextContentVO r5 = (BaseTextContentVO) r4;
        if (y28.a.a(g(), r5.g()) == true) goto L10;
        return false;
    L10:
        if (y28.a.a((String) this.m.getValue(), (String) r5.m.getValue()) == true) goto L12;
        return false;
    L12:
        if (this.p == r5.p) goto L14;
        return false;
    L14:
        if (this.q == r5.q) goto L16;
        return false;
    L16:
        if (this.r == r5.r) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.s, r5.s) == true) goto L20;
        return false;
    L20:
        if (y28.a.a(this.n, r5.n) == true) goto L22;
        return false;
    L22:
        if (y28.a.a(this.o, r5.o) == true) goto L24;
        return false;
    L24:
        if (y28.a.a(f(), r5.f()) == false) goto L36;
        return true;
    L36:
        return false;
    L27:
        return false;
    }
}
