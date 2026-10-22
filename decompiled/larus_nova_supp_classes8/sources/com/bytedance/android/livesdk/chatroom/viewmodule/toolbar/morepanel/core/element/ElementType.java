package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/morepanel/core/element/ElementType;", "", "", "id", "I", "getId", "()I", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "a", DSLType.Unknown, "Basic", "Extend", "ShareIM", "Toolbar", "SimpleDivider", "BottomSpace", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ElementType extends Enum<ElementType> {
    public static final ElementType Basic = null;
    public static final ElementType BottomSpace = null;
    public static final ElementType Extend = null;
    public static final ElementType ShareIM = null;
    public static final ElementType SimpleDivider = null;
    public static final ElementType Toolbar = null;
    public static final ElementType Unknown = null;
    public static final /* synthetic */ ElementType[] a = null;
    private final String desc;
    private final int id;

    public static final class a {
        public static int a;
        public static final a b = null;

        public a() {
        }

        public final synchronized int a() {
            monitor-enter(this);
            int r0 = a;     // Catch: Throwable -> L6
            int r1 = r0 + BubbleId.PadCast;     // Catch: Throwable -> L6
            a = r0 + 1;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r1;
        L6:
            th = move-exception;
            throw th;
        }

        static {
            b = new a();
        }
    }

    static {
        ElementType[] r0 = new ElementType[7];
        ElementType r1 = new ElementType(DSLType.Unknown, 0, -1998, "未知类型");
        Unknown = r1;
        r0[0] = r1;
        ElementType r2 = new ElementType("Basic", 1, 1, "基础功能块， 横向可滑动");
        Basic = r2;
        r0[1] = r2;
        ElementType r3 = new ElementType("Extend", 2, 2, "扩展块，横向可滑动");
        Extend = r3;
        r0[2] = r3;
        ElementType r4 = new ElementType("ShareIM", 3, 3, "分享行");
        ShareIM = r4;
        r0[3] = r4;
        a r5 = a.b;
        monitor-enter(r5);
        int r6 = a.a;     // Catch: Throwable -> L8
        int r7 = r6 + BubbleId.PadCast;     // Catch: Throwable -> L8
        a.a = r6 + 1;     // Catch: Throwable -> L8
        monitor-exit(r5);
        ElementType r8 = new ElementType("Toolbar", 4, r7, "toolbar区");
        Toolbar = r8;
        r0[4] = r8;
        ElementType r9 = new ElementType("SimpleDivider", 5, r5.a(), "简单的————————————分割线");
        SimpleDivider = r9;
        r0[5] = r9;
        ElementType r10 = new ElementType("BottomSpace", 6, r5.a(), "底部的间距");
        BottomSpace = r10;
        r0[6] = r10;
        a = r0;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static ElementType valueOf(String r1) {
        return (ElementType) r27.a.a(ElementType.class, r1);
    }

    public static ElementType[] values() {
        return (ElementType[]) a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getId() {
        return this.id;
    }

    public ElementType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.id = r3;
        this.desc = r4;
    }
}
