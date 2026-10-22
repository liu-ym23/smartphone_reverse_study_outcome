package com.suite.lark.platform.component.widgetrenderinterceptor;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.widget.span.nopreview.UnAuthorizationDrawableWrapper;
import com.suite.lark.platform.component.widgetrenderinterceptor.entity.BizInterceptorType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IMBizImageRenderInterceptor {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/suite/lark/platform/component/widgetrenderinterceptor/IMBizImageRenderInterceptor$Scene;", "", "<init>", "(Ljava/lang/String;I)V", "BeforeRender", "AfterRender", "widget-biz-renderinterceptor_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Scene extends Enum<Scene> {
        public static final Scene AfterRender = null;
        public static final Scene BeforeRender = null;
        public static final /* synthetic */ Scene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Scene> getEntries() {
            return b;
        }

        static {
            Scene r0 = new Scene("BeforeRender", 0);
            BeforeRender = r0;
            Scene r1 = new Scene("AfterRender", 1);
            AfterRender = r1;
            Scene[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Scene[] values() {
            return (Scene[]) a.clone();
        }

        public static Scene valueOf(String r1) {
            return (Scene) r27.a.a(Scene.class, r1);
        }

        public Scene(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        ImageView a();
    }

    public static final class b {
        public final int a;
        public final int b;
        public final UnAuthorizationDrawableWrapper.Style c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "SizeConfig(width=" + this.a + ", height=" + this.b + ", style=" + this.c + ", hasBorder=" + this.d + ')';
        }

        public b(int r2, int r3, UnAuthorizationDrawableWrapper.Style r4) {
            Intrinsics.checkNotNullParameter(r4, "style");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = false;
        }
    }

    Function0<Boolean> a(Context r1, a r2, kpc.a r3);

    Function0<Boolean> b(Context r1, a r2, kpc.a r3, b r4);

    Scene c();

    BizInterceptorType getType();
}
